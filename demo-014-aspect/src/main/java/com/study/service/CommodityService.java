package com.study.service;

import com.study.domain.Commodity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjding
 * @date 2021/11/29
 */
@Service
public class CommodityService implements GoodService<Commodity>{

    List<Commodity> list = new ArrayList<>();

    @Override
    public void add(Commodity commodity) {
        list.add(commodity);
    }

    @Override
    public List<Commodity> addAll(List<Commodity> list) {
        this.list.addAll(list);
        return list;
    }
}
