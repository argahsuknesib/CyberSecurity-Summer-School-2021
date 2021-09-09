package com.mi.blockcanary;

import _m_j.bxv;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.List;

public class BlockAppContext extends bxv {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4568O000000o;

    public final boolean O00000o() {
        return true;
    }

    public BlockAppContext(Context context) {
        this.f4568O000000o = context;
    }

    public final String O000000o() {
        try {
            PackageInfo packageInfo = this.f4568O000000o.getPackageManager().getPackageInfo(this.f4568O000000o.getPackageName(), 0);
            return "" + packageInfo.versionCode + "_" + packageInfo.versionName + "_YYB";
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppContext", "provideQualifier exception", e);
            return "";
        }
    }

    public final List<String> O00000Oo() {
        List<String> O00000o0 = super.O00000o0();
        O00000o0.add(this.f4568O000000o.getPackageName());
        return O00000o0;
    }

    public final List<String> O00000o0() {
        List<String> O00000o0 = super.O00000o0();
        O00000o0.add("com.whitelist");
        return O00000o0;
    }
}
