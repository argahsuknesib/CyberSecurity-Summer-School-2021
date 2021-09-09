package com.xiaomi.accounts;

import android.accounts.AuthenticatorDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Log;

public class AccountAuthenticatorCache {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f5953O000000o;
    private final String O00000Oo = "com.xiaomi.accounts.AccountAuthenticator";
    private O000000o<AuthenticatorDescription> O00000o0;

    public AccountAuthenticatorCache(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        String str2;
        this.f5953O000000o = context;
        Intent intent = new Intent(this.O00000Oo);
        intent.setPackage(this.f5953O000000o.getPackageName());
        ResolveInfo resolveService = this.f5953O000000o.getPackageManager().resolveService(intent, 0);
        if (resolveService != null) {
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            str2 = serviceInfo.packageName;
            str = serviceInfo.name;
            applicationInfo = serviceInfo.applicationInfo;
        } else {
            str2 = this.f5953O000000o.getPackageName();
            applicationInfo = this.f5953O000000o.getApplicationInfo();
            str = "com.xiaomi.passport.accountmanager.MiAuthenticatorService";
        }
        String str3 = str2;
        this.O00000o0 = new O000000o<>(new AuthenticatorDescription("com.xiaomi", str3, applicationInfo.labelRes, applicationInfo.icon, applicationInfo.icon, -1), new ComponentName(str3, str), applicationInfo.uid);
    }

    public final O000000o<AuthenticatorDescription> O000000o(AuthenticatorDescription authenticatorDescription) {
        if (authenticatorDescription != null && TextUtils.equals("com.xiaomi", authenticatorDescription.type)) {
            return this.O00000o0;
        }
        Log.i("Account", "no xiaomi account type");
        return null;
    }

    public static class O000000o<V> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final V f5954O000000o;
        public final ComponentName O00000Oo;
        public final int O00000o0;

        public O000000o(V v, ComponentName componentName, int i) {
            this.f5954O000000o = v;
            this.O00000Oo = componentName;
            this.O00000o0 = i;
        }

        public final String toString() {
            return "ServiceInfo: " + ((Object) this.f5954O000000o) + ", " + this.O00000Oo + ", uid " + this.O00000o0;
        }
    }
}
