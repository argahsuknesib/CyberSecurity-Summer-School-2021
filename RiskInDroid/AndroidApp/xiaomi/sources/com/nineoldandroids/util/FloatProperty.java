package com.nineoldandroids.util;

public abstract class FloatProperty<T> extends Property<T, Float> {
    public abstract void setValue(Object obj, float f);

    public FloatProperty(String str) {
        super(Float.class, str);
    }

    public final void set(T t, Float f) {
        setValue(t, f.floatValue());
    }
}
