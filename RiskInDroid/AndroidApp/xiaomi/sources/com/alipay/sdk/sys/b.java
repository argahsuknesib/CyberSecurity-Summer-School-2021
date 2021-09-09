package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.util.c;
import com.ta.utdid2.device.UTDevice;
import java.io.File;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f3201a;
    private Context b;

    private b() {
    }

    public static b a() {
        if (f3201a == null) {
            f3201a = new b();
        }
        return f3201a;
    }

    public Context b() {
        return this.b;
    }

    public void a(Context context) {
        com.alipay.sdk.data.b.b();
        this.b = context.getApplicationContext();
    }

    public com.alipay.sdk.data.b c() {
        return com.alipay.sdk.data.b.b();
    }

    public static boolean d() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public String e() {
        try {
            return UTDevice.getUtdid(this.b);
        } catch (Throwable th) {
            c.a(th);
            return "getUtdidEx";
        }
    }
}
