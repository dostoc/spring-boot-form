package com.ripsa.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculaEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) throws IllegalArgumentException {
        setValue(value.toUpperCase().trim());
    }

    
    
}
