package com.study.common;

import com.google.common.collect.Lists;
import com.study.domain.Commodity;
import com.study.domain.Good;
import com.study.domain.Order;
import com.study.service.CommodityService;
import com.study.service.GoodServiceImpl;
import com.study.service.OrderService;
import com.study.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author fjding
 * @date 2021/11/28
 */
//@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private GoodServiceImpl goodService;

    @Autowired
    private CommodityService commodityService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Order order = new Order();
        order.setId("a-1");
        orderService.add(order);
        orderService.setId("a-2");
        commonService.print();

        // ---泛型参数验证---
        Good good = new Good();
        goodService.add(good);
        goodService.addAll(Lists.newArrayList(good));

        Commodity commodity = new Commodity();
        commodityService.add(commodity);
        commodityService.addAll(Lists.newArrayList(commodity));
        // ---泛型参数验证---

        // --引入--
        OrderService convert = (OrderService) goodService;
        convert.list();
        // --引入--

        Order order1 = orderService.getOrder("a-1");
        System.out.println("==订单信息：" +order1);
        orderService.getOrder("a-3");

    }
}
