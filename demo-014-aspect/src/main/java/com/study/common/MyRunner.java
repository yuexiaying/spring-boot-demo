package com.study.common;

import com.study.domain.Order;
import com.study.service.OrderService;
import com.study.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author fjding
 * @date 2021/11/28
 */
@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Order order = new Order();
        order.setId("a-1");
        orderService.add(order);
        orderService.setId("a-2");
        commonService.print();

        Order order1 = orderService.getOrder("a-1");
        System.out.println("==订单信息：" +order1);
        orderService.getOrder("a-3");

    }
}
