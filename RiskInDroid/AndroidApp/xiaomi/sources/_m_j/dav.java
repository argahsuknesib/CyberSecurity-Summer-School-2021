package _m_j;

import android.content.Context;
import android.text.TextUtils;

public final class dav {

    /* renamed from: O000000o  reason: collision with root package name */
    private static dav f14423O000000o;
    private String O00000Oo;

    private dav() {
    }

    public static synchronized dav O000000o() {
        dav dav;
        synchronized (dav.class) {
            if (f14423O000000o == null) {
                f14423O000000o = new dav();
            }
            dav = f14423O000000o;
        }
        return dav;
    }

    public final synchronized String O000000o(Context context) {
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            return this.O00000Oo;
        }
        String O000000o2 = dbe.O000000o(context, "app_token", "");
        if (!TextUtils.isEmpty(O000000o2)) {
            this.O00000Oo = dat.O000000o().O00000Oo(O000000o2);
        }
        return this.O00000Oo;
    }

    public final synchronized boolean O000000o(Context context, String str) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            String O000000o2 = dat.O000000o().O000000o(str);
            if (!TextUtils.isEmpty(O000000o2)) {
                dbe.O00000Oo(context, "app_token", O000000o2);
                this.O00000Oo = str;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public final synchronized void O00000Oo(Context context) {
        this.O00000Oo = null;
        dbe.O00000Oo(context, "app_token", "");
    }

    public final synchronized boolean O00000o0(Context context) {
        return !TextUtils.isEmpty(dbe.O000000o(context, "app_token", ""));
    }
}
