package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.weibo.ssosdk.WeiboSsoSdk;

public final class dbn {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f14455O000000o;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final dbn f14456O000000o = new dbn((byte) 0);
    }

    /* synthetic */ dbn(byte b) {
        this();
    }

    private dbn() {
    }

    public static synchronized dbn O000000o() {
        dbn dbn;
        synchronized (dbn.class) {
            dbn = O000000o.f14456O000000o;
        }
        return dbn;
    }

    public final void O000000o(Context context, String str) {
        dbt.O000000o("WeiboSsoManager", "init config");
        dtr dtr = new dtr();
        dtr.O000000o(context);
        dtr.O00000Oo = str;
        dtr.O00000o = "1478195010";
        dtr.O00000oO = "1000_0001";
        WeiboSsoSdk.O000000o(dtr);
        O00000Oo();
    }

    private void O00000Oo() {
        try {
            this.f14455O000000o = WeiboSsoSdk.O000000o().O00000o0();
            if (TextUtils.isEmpty(this.f14455O000000o)) {
                this.f14455O000000o = WeiboSsoSdk.O000000o().O00000Oo().f5936O000000o;
            }
        } catch (Exception e) {
            e.printStackTrace();
            dbt.O00000o0("WeiboSsoManager", e.getMessage());
        }
    }

    public final String O00000Oo(Context context, String str) {
        dbt.O000000o("WeiboSsoManager", "getAid()");
        if (TextUtils.isEmpty(this.f14455O000000o)) {
            O000000o(context, str);
        }
        return this.f14455O000000o;
    }
}
