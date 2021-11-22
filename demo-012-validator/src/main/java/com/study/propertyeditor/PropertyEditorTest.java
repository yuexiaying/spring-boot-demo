package com.study.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * PropertyEditor是Java提供的属性设置接口，主要是用于在界面上，将字面量转换为对象的属性
 */
public class PropertyEditorTest {

    public static void main(String[] args) {
        MyPropertyEditor propertyEditor = new MyPropertyEditor();
        propertyEditor.setAsText("1");
        System.out.println(propertyEditor.getValue());
    }

    public static class MyPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if ("1".equals(text)) {
                setValue(new Date());
            }
        }

    }
}
