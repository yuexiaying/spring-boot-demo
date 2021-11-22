package com.study.propertyeditor;

import com.study.domain.Address;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

//@Component
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Address.class,new AddressPropertyEditor());
    }
}
