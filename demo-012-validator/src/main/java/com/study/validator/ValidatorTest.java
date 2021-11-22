package com.study.validator;

import com.study.domain.Person;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * 验证测试
 * @author fjding
 * @date 2021/10/28
 */
public class ValidatorTest {
    public static void main(String[] args) {
        Person person = new Person();
        DataBinder binder = new DataBinder(person);
        // 设置校验器
        binder.setValidator(new PersonValidator(new AddressValidator()));
        // 验证
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();
        System.out.println(bindingResult);
    }
}
