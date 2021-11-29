package com.study.service;

import java.util.List;

/**
 * 商品业务类
 * @author fjding
 * @date 2021/11/29
 */
public interface GoodService<T> {

    /**
     * 添加
     * @param t
     */
    void add(T t);

    /**
     * 集合
     * @return
     */
    List<T> addAll(List<T> list);
}
