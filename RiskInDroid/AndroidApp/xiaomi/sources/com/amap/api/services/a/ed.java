package com.amap.api.services.a;

import android.content.Context;

public class ed extends ec {
    private Context b;
    private boolean c = false;

    public ed(Context context, boolean z) {
        this.b = context;
        this.c = z;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return bt.q(this.b) == 1 || this.c;
    }
}
