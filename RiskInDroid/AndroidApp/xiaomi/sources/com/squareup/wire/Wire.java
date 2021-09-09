package com.squareup.wire;

public final class Wire {
    public static <T> T get(T t, T t2) {
        return t != null ? t : t2;
    }

    private Wire() {
    }
}
