package com.xiaomi.smarthome.framework.store;

import _m_j.get;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceCredentialStore implements get {

    /* renamed from: O000000o  reason: collision with root package name */
    private final SharedPreferences f8641O000000o;

    public PreferenceCredentialStore(Context context) {
        this.f8641O000000o = context.getApplicationContext().getSharedPreferences("com.xiaomi.sh.account", 0);
    }

    public final String O000000o() {
        return this.f8641O000000o.getString("wifi", null);
    }

    public final void O000000o(String str) {
        SharedPreferences.Editor edit = this.f8641O000000o.edit();
        edit.putString("wifi", str);
        edit.commit();
    }
}
