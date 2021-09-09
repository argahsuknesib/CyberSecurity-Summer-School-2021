package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;

public class eb extends ec {
    private int b;
    private long c;
    private String d;
    private Context e;

    public eb(Context context, int i, String str, ec ecVar) {
        super(ecVar);
        this.b = i;
        this.d = str;
        this.e = context;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        if (this.c == 0) {
            this.c = a(this.d);
        }
        return System.currentTimeMillis() - this.c >= ((long) this.b);
    }

    public void a(boolean z) {
        super.a(z);
        if (z) {
            a(this.d, System.currentTimeMillis());
        }
    }

    private void a(String str, long j) {
        this.c = j;
        cj.a(this.e, str, String.valueOf(j));
    }

    private long a(String str) {
        String a2 = cj.a(this.e, str);
        if (TextUtils.isEmpty(a2)) {
            return 0;
        }
        return Long.parseLong(a2);
    }
}
