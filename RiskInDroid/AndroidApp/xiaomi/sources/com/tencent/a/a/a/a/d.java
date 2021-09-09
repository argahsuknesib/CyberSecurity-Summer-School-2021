package com.tencent.a.a.a.a;

import _m_j.dgg;
import _m_j.dgi;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public final class d extends dgg {
    public d(Context context) {
        super(context);
    }

    public final void O000000o(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to sharedPreferences");
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f14601O000000o).edit();
            edit.putString(dgi.O00000o0("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }

    public final boolean O000000o() {
        return true;
    }

    public final String O00000Oo() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.f14601O000000o).getString(dgi.O00000o0("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }
}
