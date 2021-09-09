package _m_j;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public final class o0O00Oo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Intent f2231O000000o;
    public final Bundle O00000Oo;

    public o0O00Oo0(Intent intent, Bundle bundle) {
        this.f2231O000000o = intent;
        this.O00000Oo = bundle;
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Intent f2232O000000o;
        public ArrayList<Bundle> O00000Oo;
        public ArrayList<Bundle> O00000o;
        public Bundle O00000o0;
        public boolean O00000oO;

        public O000000o() {
            this((byte) 0);
        }

        private O000000o(byte b) {
            this.f2232O000000o = new Intent("android.intent.action.VIEW");
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = true;
            Bundle bundle = new Bundle();
            oOOO0OO0.O000000o(bundle, "android.support.customtabs.extra.SESSION", null);
            this.f2232O000000o.putExtras(bundle);
        }
    }
}
