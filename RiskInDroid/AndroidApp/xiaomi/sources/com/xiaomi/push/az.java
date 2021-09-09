package com.xiaomi.push;

import _m_j.duv;
import _m_j.elv;
import _m_j.esu;
import android.content.Context;
import java.lang.reflect.Method;

public class az implements elv {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f6365O000000o;
    private Class<?> O00000Oo;
    private Method O00000o = null;
    private Object O00000o0;
    private Method O00000oO = null;
    private Method O00000oo = null;
    private Method O0000O0o = null;

    private String O000000o(Context context, Method method) {
        Object obj = this.O00000o0;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            duv.O000000o("miui invoke error", e);
            return null;
        }
    }

    public static boolean O000000o(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    public final boolean O000000o() {
        return (this.O00000Oo == null || this.O00000o0 == null) ? false : true;
    }

    public final String O00000Oo() {
        return null;
    }

    public final String O00000o() {
        return O000000o(this.f6365O000000o, this.O00000oo);
    }

    public final String O00000o0() {
        return O000000o(this.f6365O000000o, this.O00000oO);
    }

    public final String O00000oO() {
        return O000000o(this.f6365O000000o, this.O0000O0o);
    }

    public az(Context context) {
        this.f6365O000000o = context;
        try {
            this.O00000Oo = esu.O000000o(context, "com.android.id.impl.IdProviderImpl");
            this.O00000o0 = this.O00000Oo.newInstance();
            this.O00000o = this.O00000Oo.getMethod("getUDID", Context.class);
            this.O00000oO = this.O00000Oo.getMethod("getOAID", Context.class);
            this.O00000oo = this.O00000Oo.getMethod("getVAID", Context.class);
            this.O0000O0o = this.O00000Oo.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            duv.O000000o("miui load class error", e);
        }
    }
}
