package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

public class ThreadLocalSelectArg extends BaseArgumentHolder {
    private ThreadLocal<ValueWrapper> threadValue = new ThreadLocal<>();

    public ThreadLocalSelectArg() {
    }

    public ThreadLocalSelectArg(String str, Object obj) {
        super(str);
        setValue(obj);
    }

    public ThreadLocalSelectArg(SqlType sqlType, Object obj) {
        super(sqlType);
        setValue(obj);
    }

    public ThreadLocalSelectArg(Object obj) {
        setValue(obj);
    }

    /* access modifiers changed from: protected */
    public Object getValue() {
        ValueWrapper valueWrapper = this.threadValue.get();
        if (valueWrapper == null) {
            return null;
        }
        return valueWrapper.value;
    }

    public void setValue(Object obj) {
        this.threadValue.set(new ValueWrapper(obj));
    }

    /* access modifiers changed from: protected */
    public boolean isValueSet() {
        return this.threadValue.get() != null;
    }

    static class ValueWrapper {
        Object value;

        public ValueWrapper(Object obj) {
            this.value = obj;
        }
    }
}
