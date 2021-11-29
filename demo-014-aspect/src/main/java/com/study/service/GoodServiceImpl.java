package com.study.service;

import com.study.domain.Good;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjding
 * @date 2021/11/29
 */
@Service
public class GoodServiceImpl implements GoodService<Good> {

    List<Good> list = new ArrayList<>();

    @Override
    public void add(Good good) {
        list.add(good);
    }

    @Override
    public List<Good> addAll(List<Good> list) {
        this.list.addAll(list);
        return list;
    }
}
