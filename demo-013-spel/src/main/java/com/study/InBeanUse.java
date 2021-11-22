package com.study;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 在bean中的使用
 * @author fjding
 */
@Component
public class InBeanUse implements InitializingBean {

    /**
     * 字段上使用
     */
    @Value("#{testMap['name']}")
    private String region;

    private String name;

    private String var;

    /**
     * set方法上使用
     * @param name
     */
    @Value("#{testMap.get('name')}")
    public void setRegion(String name) {
        this.name = name;
    }

    /**
     * 构造方法上使用
     * @param var
     */
    public InBeanUse(@Value("#{testMap['name']}") String var) {
        this.var = var;
    }

    /**
     * 普通方法上使用
     */
    public void context(@Value("#{webApplicationContext}") ApplicationContext context){
        System.out.println(context);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println(region);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
