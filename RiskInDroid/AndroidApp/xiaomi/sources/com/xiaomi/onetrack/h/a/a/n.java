package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.xiaomi.onetrack.h.a.b.e;
import com.xiaomi.onetrack.h.q;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class n {

    /* renamed from: a  reason: collision with root package name */
    e f6157a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    ServiceConnection c = new o(this);
    private String e;

    public String a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = "";
        if (context.bindService(intent, this.c, 1)) {
            try {
                IBinder poll = this.b.poll(1, TimeUnit.SECONDS);
                if (poll == null) {
                    try {
                        context.unbindService(this.c);
                    } catch (Exception e2) {
                        q.a("OppoDeviceIDHelper", e2.getMessage());
                    }
                    return str;
                }
                this.f6157a = e.a.a(poll);
                if (this.f6157a != null) {
                    str = a("OUID", context);
                }
                try {
                    context.unbindService(this.c);
                } catch (Exception e3) {
                    q.a("OppoDeviceIDHelper", e3.getMessage());
                }
            } catch (Exception e4) {
                q.a("OppoDeviceIDHelper", e4.getMessage());
                context.unbindService(this.c);
            } catch (Throwable th) {
                try {
                    context.unbindService(this.c);
                } catch (Exception e5) {
                    q.a("OppoDeviceIDHelper", e5.getMessage());
                }
                throw th;
            }
        }
        return str;
    }

    private String a(String str, Context context) {
        Signature[] signatureArr;
        String packageName = context.getPackageName();
        if (this.e == null) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e2) {
                e2.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA1");
                    if (instance != null) {
                        byte[] digest = instance.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            this.e = str2;
        }
        return ((e.a.C0057a) this.f6157a).a(packageName, this.e, str);
    }

    private boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo != null && ((long) packageInfo.versionCode) >= 1) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            q.a("OppoDeviceIDHelper", e2.getMessage());
            return true;
        }
    }
}
