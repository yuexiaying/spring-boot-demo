package com.study.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.stereotype.Component;

@Component
public class MyCustomEditorConfigurer extends CustomEditorConfigurer {

    @Override
    public void setPropertyEditorRegistrars(PropertyEditorRegistrar[] propertyEditorRegistrars) {
        propertyEditorRegistrars = new CustomPropertyEditorRegistrar[5];
        propertyEditorRegistrars[0] = new CustomPropertyEditorRegistrar();
        super.setPropertyEditorRegistrars(propertyEditorRegistrars);
    }
}
