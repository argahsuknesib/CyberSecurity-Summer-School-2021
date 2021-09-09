package com.tencent.a.a.a.a;

import _m_j.dgg;
import _m_j.dgi;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;

public final class e extends dgg {
    public e(Context context) {
        super(context);
    }

    public final void O000000o(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to Settings.System");
            Settings.System.putString(this.f14601O000000o.getContentResolver(), dgi.O00000o0("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    public final boolean O000000o() {
        return dgi.O000000o(this.f14601O000000o, "android.permission.WRITE_SETTINGS");
    }

    public final String O00000Oo() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from Settings.System");
            string = Settings.System.getString(this.f14601O000000o.getContentResolver(), dgi.O00000o0("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }
}
