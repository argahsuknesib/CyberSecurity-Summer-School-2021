package com.xiaomi.mobilestats;

import _m_j.ebt;
import android.content.Context;
import java.lang.ref.SoftReference;

class j implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private SoftReference f6074O000000o;

    public j(Context context) {
        this.f6074O000000o = new SoftReference(context == null ? null : context.getApplicationContext());
    }

    public void run() {
        ebt O000000o2 = ebt.O000000o();
        Context context = (Context) this.f6074O000000o.get();
        if (context != null) {
            O000000o2.f15155O000000o = context.getApplicationContext();
            O000000o2.O00000Oo = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(O000000o2);
    }
}
