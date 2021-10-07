package com.study.common;

import com.study.domain.Person;

/**
 * 原型工厂，通过该接口，可以不断的获得原型Bean
 * 注意：Bean本身必须是原型的
 *
 * @author fjding
 * @date 2021/10/7
 */

public interface PrototypeFactory {

    /**
     * 获得原型的Command
     *
     * @param name
     * @return
     */
    Command getCommand(String name);

    /**
     * 因为Person是单例的，这里其实不会获得原型Bean
     *
     * @param name
     * @return
     */
    Person getPerson(String name);
}
