package com.yanzhenjie.yp_permission.source;

import _m_j.ipz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;

public class ContextSource extends ipz {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f12248O000000o;

    public ContextSource(Context context) {
        this.f12248O000000o = context;
    }

    public final Context O000000o() {
        return this.f12248O000000o;
    }

    public final void O000000o(Intent intent, int i) {
        Context context = this.f12248O000000o;
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.setFlags(268435456);
        this.f12248O000000o.startActivity(intent);
    }

    public final boolean O000000o(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        Context context = this.f12248O000000o;
        if (context instanceof Activity) {
            return ((Activity) context).shouldShowRequestPermissionRationale(str);
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            Method method = packageManager.getClass().getMethod("shouldShowRequestPermissionRationale", String.class);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return ((Boolean) method.invoke(packageManager, str)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
