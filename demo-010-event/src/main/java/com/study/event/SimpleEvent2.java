package com.study.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * 事件
 *
 * @author fjding
 * @date 2021/10/24
 */
public class SimpleEvent2 extends ApplicationEvent implements ResolvableTypeProvider {
    private String context;

    public SimpleEvent2(Object source, String context) {
        super(source);
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    /**
     * 指定事件实例的类型，可以更好的区分
     *
     * @return
     */
    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
    }
}
