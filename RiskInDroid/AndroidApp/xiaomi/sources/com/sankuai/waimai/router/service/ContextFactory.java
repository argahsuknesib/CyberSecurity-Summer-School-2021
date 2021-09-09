package com.sankuai.waimai.router.service;

import _m_j.cyy;
import android.content.Context;

public class ContextFactory implements cyy {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f5510O000000o;

    public ContextFactory(Context context) {
        this.f5510O000000o = context;
    }

    public final <T> T O000000o(Class<T> cls) throws Exception {
        return cls.getConstructor(Context.class).newInstance(this.f5510O000000o);
    }
}
