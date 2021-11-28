package com.study.service;

import com.study.domain.Order;

import java.util.List;

/**
 * 订单接口
 *
 * @author fjding
 * @date 2021/11/28
 */
public interface OrderService {

    /**
     * 增加订单
     *
     * @param order
     * @return
     */
    boolean add(Order order);

    /**
     * 设置id
     *
     * @param id
     */
    void setId(String id);

    /**
     * 根据id获得订单
     *
     * @param id
     * @return
     */
    Order getOrder(String id);

    /**
     * 获得所有订单
     *
     * @return
     */
    List<Order> list();
}
