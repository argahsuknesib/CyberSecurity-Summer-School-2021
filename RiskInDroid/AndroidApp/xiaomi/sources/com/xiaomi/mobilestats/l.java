package com.xiaomi.mobilestats;

import _m_j.ebp;
import android.content.Context;
import java.lang.ref.SoftReference;

class l implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private SoftReference f6075O000000o;

    public l(Context context) {
        this.f6075O000000o = new SoftReference(context == null ? null : context.getApplicationContext());
    }

    public void run() {
        Context context = (Context) this.f6075O000000o.get();
        if (context != null) {
            ebp.O000000o(context);
        }
    }
}
