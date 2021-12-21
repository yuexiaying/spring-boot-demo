package com.study.service;

import com.study.domain.User;
import com.study.event.InsertEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author fjding
 * @date 2021/12/20
 */
//@Transactional // 对所有public方法启作用，不推荐，继承该类的类也会添加事务
@Service
public class UserServiceImpl implements UserService {

    /**
     * 是否抛出异常
     */
    private boolean error;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 事务操作模板
     */
    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 事务管理接口
     */
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Resource(name = "myTransactionTemplate")
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 只读，意义在于保持读的一致性，比如，多条语句查询，可能会出现前后查询不一致的情况
     *
     * @param id
     * @return
     */
    @Transactional(
            // 传播行为
            propagation = Propagation.REQUIRED
            // 隔离级别
            , isolation = Isolation.DEFAULT
            // 只读
            , readOnly = true
            // 触发事务回滚的异常类型
            , rollbackFor = Exception.class
            // 事务最大执行时间
            , timeout = 50)
    @Override
    public User getById(Integer id) {
        /* queryForObject，直接指定类型仅支持基本类型，不支持自定义类，
        自定义类的转换可以使用BeanPropertyRowMapper(target.class)的方式，
        其支持类型之间的转换，驼峰形式的转换，对于无法推断映射的列，可以通过指定别名的方式映射。
         */
        String name = jdbcTemplate.queryForObject("select name from user where id = ?", String.class, id);
        System.out.println("name:" + name);
        Integer count = jdbcTemplate.queryForObject("select count(*) from user where id = ?", Integer.class, id);
        System.out.println("数量：" + count);
        User user = jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<>(User.class), id);
        System.out.println(user);
        if (error) {
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 就算在该条语句查询之前数据库修改了，这里查询结果和上一条还是会一致的
        User user2 = jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<>(User.class), id);
        System.out.println(user2);
        return user;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public boolean insert(User user) {
        final int[] result = new int[1];
        // 使用模板操作事务
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    result[0] = jdbcTemplate.update("insert into user(id,name) values(?,?) ", user.getId(), user.getName());
                    // 发布事件
                    eventPublisher.publishEvent(new InsertEvent("插入" + user.getId()));
                    if (error) {
                        throw new RuntimeException();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    result[0] = 0;
                    status.setRollbackOnly();
                }
            }
        });
        return result[0] == 1;
    }

    @Override
    public boolean update(User user) {
        int result = 0;
        // 使用事务管理器直接操作事务
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            result = jdbcTemplate.update("update user set name = ? where id = ?", user.getName(), user.getId());
            stringRedisTemplate.opsForValue().set(user.getName(),user.getName());
            if (error) {
                throw new RuntimeException();
            }
            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            result = 0;
            transactionManager.rollback(transactionStatus);

        }
        return result == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(Integer id) {
        jdbcTemplate.update("delete from user where id = ?", id);
        if (error) {
            throw new RuntimeException();
        }
        return true;
    }

    @Override
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * 内部调用事务不起作用
     *
     * @param id
     */
    @Override
    public void inner(Integer id) {
        delete(id);
    }
}
