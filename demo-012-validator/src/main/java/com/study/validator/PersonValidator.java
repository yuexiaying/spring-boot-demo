package com.study.validator;

import com.study.domain.Address;
import com.study.domain.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Person实体校验类
 *
 * @author fjding
 * @date 2021/10/24
 */

public class PersonValidator implements Validator {

    private final Validator addressValidator;

    public PersonValidator(Validator addressValidator) {
        if (addressValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is " +
                    "required and must not be null.");
        }
        if (!addressValidator.supports(Address.class)) {
            throw new IllegalArgumentException("The supplied [Validator] must " +
                    "support the validation of [Address] instances.");
        }
        this.addressValidator = addressValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name 为空");
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "negative value", "年龄不能为负值");
        } else if (p.getAge() > 110) {
            errors.rejectValue("age", "too old", "年龄不能超过110");
        }
        // 嵌套校验器
        try {
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(this.addressValidator, p.getAddress(), errors);
        } finally {
            errors.popNestedPath();
        }
    }
}
