package com.study.replace;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 替换bean中的方法
 *
 * @author fjding
 * @date 2021/10/23
 */
@Component
public class ReplaceBeanMethod implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("替换了" + method.getName());
        return null;
    }
}
