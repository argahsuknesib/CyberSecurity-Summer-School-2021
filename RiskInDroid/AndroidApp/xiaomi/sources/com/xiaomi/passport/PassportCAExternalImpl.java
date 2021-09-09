package com.xiaomi.passport;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.account.data.PassportCAToken;
import com.xiaomi.accountsdk.account.PassportCAExternal;

public class PassportCAExternalImpl implements PassportCAExternal {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f6188O000000o;

    public PassportCAExternalImpl(Context context) {
        if (context != null) {
            this.f6188O000000o = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public PassportCAToken loadCAToken() {
        SharedPreferences O000000o2 = O000000o();
        String string = O000000o2.getString("ca_token", null);
        String string2 = O000000o2.getString("ca_token_security", null);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        return new PassportCAToken(string, string2);
    }

    public void saveCAToken(PassportCAToken passportCAToken) {
        if (passportCAToken != null) {
            SharedPreferences.Editor edit = O000000o().edit();
            edit.putString("ca_token", passportCAToken.token);
            edit.putString("ca_token_security", passportCAToken.security);
            edit.commit();
        }
    }

    public void saveNextCAEnabledTime(long j) {
        O000000o().edit().putLong("next_enabled_time", j).commit();
    }

    public long loadNextCAEnabledTime(long j) {
        return O000000o().getLong("next_enabled_time", j);
    }

    private SharedPreferences O000000o() {
        return this.f6188O000000o.getSharedPreferences("passport_ca", 0);
    }
}
