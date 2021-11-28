package com.study.domain;

import com.study.annotation.SimpleType;
import lombok.Data;

/**
 * 订单实体
 *
 * @author fjding
 * @date 2021/11/28
 */
@Data
@SimpleType
public class Order {

    private String id;
}
