package com.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * 自定义自己的Loader
 *
 * @author fjding
 * @date 2021/10/24
 */
@Component
public class MyResourceLoader implements ResourceLoader {

    @Autowired
    private ApplicationContext context;

    @Override
    public Resource getResource(String location) {
        return context.getResource(location);
    }

    @Override
    public ClassLoader getClassLoader() {
        return this.getClassLoader();
    }
}
