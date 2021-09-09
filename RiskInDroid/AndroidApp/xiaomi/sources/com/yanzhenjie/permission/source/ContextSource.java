package com.yanzhenjie.permission.source;

import _m_j.ioh;
import android.content.Context;
import android.content.Intent;

public class ContextSource extends ioh {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f12246O000000o;

    public ContextSource(Context context) {
        this.f12246O000000o = context;
    }

    public final Context O000000o() {
        return this.f12246O000000o;
    }

    public final void O000000o(Intent intent) {
        this.f12246O000000o.startActivity(intent);
    }

    public final void O000000o(Intent intent, int i) {
        this.f12246O000000o.startActivity(intent);
    }
}
