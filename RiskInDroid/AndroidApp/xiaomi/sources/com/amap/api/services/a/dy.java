package com.amap.api.services.a;

import java.io.File;

public class dy extends ec {
    private int b;
    private String c;

    public dy(int i, String str, ec ecVar) {
        super(ecVar);
        this.b = i;
        this.c = str;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return a(this.c) >= this.b;
    }

    public int a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            cl.c(th, "fus", "gfn");
            return 0;
        }
    }
}
