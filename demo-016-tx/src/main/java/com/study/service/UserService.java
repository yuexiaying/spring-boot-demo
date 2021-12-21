package com.study.service;

import com.study.domain.User;

import java.util.List;

/**
 * @author fjding
 * @date 2021/12/20
 */
public interface UserService {

    /**
     * 单个
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 集合
     * @return
     */
    List<User> list();

    /**
     * 插入
     * @param user
     * @return
     */
    boolean insert(User user);

    /**
     * 更新
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 异常
     * @param error
     */
    void setError(boolean error);

    /**
     * 内部
     * @param id
     */
    void inner(Integer id);
}
