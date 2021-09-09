package com.alibaba.android.arouter.facade.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeWrapper<T> {
    protected final Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    protected TypeWrapper() {
    }

    public Type getType() {
        return this.type;
    }
}
