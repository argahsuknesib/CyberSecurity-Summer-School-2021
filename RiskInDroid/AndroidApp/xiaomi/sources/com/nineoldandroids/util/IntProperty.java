package com.nineoldandroids.util;

public abstract class IntProperty<T> extends Property<T, Integer> {
    public abstract void setValue(Object obj, int i);

    public IntProperty(String str) {
        super(Integer.class, str);
    }

    public final void set(T t, Integer num) {
        while (true) {
            num = Integer.valueOf(num.intValue());
        }
    }
}
