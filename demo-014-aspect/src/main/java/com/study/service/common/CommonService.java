package com.study.service.common;

import com.study.annotation.SimpleType;
import org.springframework.stereotype.Component;

/**
 * 通用service
 *
 * @author fjding
 * @date 2021/11/28
 */
@Component
@SimpleType
public  class CommonService {

    /**
     * 打印
     */
    public void print() {
        System.out.println("我是通用类的打印方法");
    }
}
