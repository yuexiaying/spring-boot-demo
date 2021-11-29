package com.study.aspect.declareparents;

import com.study.service.OrderService;
import com.study.service.OrderServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * 引入，给指定目标添加方法
 *
 * @author fjding
 * @date 2021/11/29
 */
@Component
@Aspect
public class SimpleTest {

    /**
     * value：目标表达式
     * defaultImpl：默认实现
     * OrderService ： 接口类型
     */
    @DeclareParents(value = "com.study.service.*Impl", defaultImpl = OrderServiceImpl.class)
    private OrderService good;


}
