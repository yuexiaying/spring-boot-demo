package com.study.service;

import com.study.annotation.SimpleType;
import com.study.domain.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author fjding
 * @date 2021/11/28
 */
@Component
public class OrderServiceImpl implements OrderService {

    private List<Order> orderList = new ArrayList<>();

    @Override
    public boolean add(Order order) {
        orderList.add(order);
        System.out.println("添加了订单：" + order.getId());
        return true;
    }


    @Override
    public void setId(String id) {
        System.out.println("设置了订单id:" + id);
    }

    @SimpleType
    @Override
    public Order getOrder(String id) {
        Optional<Order> orderOptional = orderList.stream().filter(order -> order.getId().equals(id)).findAny();
        if (!orderOptional.isPresent()) {
            throw new RuntimeException("订单不存在！");
        }
        System.out.println("获得订单：" + orderOptional.get());
        return orderOptional.get();
    }

    @Override
    public List<Order> list() {
        System.out.println("订单列表：" + orderList);
        return orderList;
    }
}
