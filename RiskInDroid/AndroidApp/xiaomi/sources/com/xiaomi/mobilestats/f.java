package com.xiaomi.mobilestats;

import _m_j.ebp;
import android.content.Context;
import java.lang.ref.SoftReference;

class f implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private SoftReference f6073O000000o;

    public f(Context context) {
        this.f6073O000000o = new SoftReference(context == null ? null : context.getApplicationContext());
    }

    public void run() {
        Context context = (Context) this.f6073O000000o.get();
        if (context != null) {
            ebp.O00000Oo(context);
        }
    }
}
