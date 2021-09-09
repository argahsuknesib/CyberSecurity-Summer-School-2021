package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

public class SelectArg extends BaseArgumentHolder {
    private boolean hasBeenSet = false;
    private Object value = null;

    public SelectArg() {
    }

    public SelectArg(String str, Object obj) {
        super(str);
        setValue(obj);
    }

    public SelectArg(SqlType sqlType, Object obj) {
        super(sqlType);
        setValue(obj);
    }

    public SelectArg(SqlType sqlType) {
        super(sqlType);
    }

    public SelectArg(Object obj) {
        setValue(obj);
    }

    /* access modifiers changed from: protected */
    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.hasBeenSet = true;
        this.value = obj;
    }

    /* access modifiers changed from: protected */
    public boolean isValueSet() {
        return this.hasBeenSet;
    }
}
