package com.amap.api.services.a;

import android.content.Context;
import java.util.List;

public class cu {

    /* renamed from: a  reason: collision with root package name */
    private cp f3377a;
    private Context b;

    public cu(Context context, boolean z) {
        this.b = context;
        this.f3377a = a(this.b, z);
    }

    private cp a(Context context, boolean z) {
        try {
            return new cp(context, cp.a((Class<? extends co>) ct.class));
        } catch (Throwable th) {
            if (!z) {
                cl.c(th, "sd", "gdb");
            }
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cu.a(android.content.Context, boolean):com.amap.api.services.a.cp
     arg types: [android.content.Context, int]
     candidates:
      com.amap.api.services.a.cu.a(java.util.List<com.amap.api.services.a.by>, com.amap.api.services.a.by):boolean
      com.amap.api.services.a.cu.a(android.content.Context, boolean):com.amap.api.services.a.cp */
    public void a(by byVar) {
        if (byVar != null) {
            try {
                if (this.f3377a == null) {
                    this.f3377a = a(this.b, false);
                }
                String a2 = by.a(byVar.a());
                List a3 = this.f3377a.a(a2, by.class);
                if (a3 != null) {
                    if (a3.size() != 0) {
                        if (a(a3, byVar)) {
                            this.f3377a.a(a2, byVar);
                            return;
                        }
                        return;
                    }
                }
                this.f3377a.a(byVar);
            } catch (Throwable th) {
                cl.c(th, "sd", "it");
            }
        }
    }

    private boolean a(List<by> list, by byVar) {
        for (by equals : list) {
            if (equals.equals(byVar)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class, boolean):java.util.List<T>
     arg types: [java.lang.String, java.lang.Class, int]
     candidates:
      com.amap.api.services.a.cp.a(android.database.Cursor, java.lang.Class, com.amap.api.services.a.cq):T
      com.amap.api.services.a.cp.a(java.lang.Object, java.lang.reflect.Field, android.content.ContentValues):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Object, boolean):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class, boolean):java.util.List<T> */
    public List<by> a() {
        try {
            return this.f3377a.a(by.g(), by.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
