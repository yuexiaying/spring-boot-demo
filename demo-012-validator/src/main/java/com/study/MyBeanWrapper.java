package com.study;

import com.study.domain.Company;
import com.study.domain.Employee;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * BeanWrapper 对Bean的封装，可以获得、设置属性
 *
 * @author fjding
 */
public class MyBeanWrapper {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        BeanWrapper companyWrapper = new BeanWrapperImpl(new Company());
        companyWrapper.setPropertyValue("name", "阿里");
        BeanWrapper employeeWrapper = new BeanWrapperImpl(new Employee());
        employeeWrapper.setPropertyValue("name", "zs");
        companyWrapper.setPropertyValue("managingDirector", employeeWrapper.getWrappedInstance());
        Object propertyValue = companyWrapper.getPropertyValue("managingDirector.name");
        System.out.println(propertyValue);
    }
}
