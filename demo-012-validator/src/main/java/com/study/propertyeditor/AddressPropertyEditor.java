package com.study.propertyeditor;

import com.study.domain.Address;

import java.beans.PropertyEditorSupport;


public class AddressPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Address address = new Address();
        address.setLocation("address:" + text);
        setValue(address);
    }
}
