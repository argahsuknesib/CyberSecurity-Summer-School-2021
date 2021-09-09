package com.amap.api.services.a;

import android.content.Context;

abstract class ax<T, V> extends k<T, V> {
    public ax(Context context, T t) {
        super(context, t);
    }

    public T j() {
        return this.f3422a;
    }

    public String i() {
        return r.a() + "/weather/weatherInfo?";
    }
}
