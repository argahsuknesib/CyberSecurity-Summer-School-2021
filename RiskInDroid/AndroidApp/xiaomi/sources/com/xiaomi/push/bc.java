package com.xiaomi.push;

import _m_j.duv;
import _m_j.elv;
import _m_j.ema;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.support.v4.app.NotificationCompat;
import java.security.MessageDigest;

public class bc implements elv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f6366O000000o;
    /* access modifiers changed from: private */
    public Context O00000Oo;
    /* access modifiers changed from: private */
    public volatile int O00000o = 0;
    private ServiceConnection O00000o0;
    /* access modifiers changed from: private */
    public volatile O000000o O00000oO = null;
    /* access modifiers changed from: private */
    public final Object O00000oo = new Object();

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6367O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;

        private O000000o() {
            this.f6367O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
        }

        public /* synthetic */ O000000o(bc bcVar, byte b) {
            this();
        }
    }

    public class O00000Oo implements ServiceConnection {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(bc bcVar, byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (bc.this.O00000oO == null) {
                new Thread(new ema(this, iBinder)).start();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class O00000o0 {
        public static String O000000o(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0032 */
    private void O000000o(String str) {
        if (this.O00000o == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.O00000oo) {
                duv.O000000o("oppo's " + str + " wait...");
                this.O00000oo.wait(3000);
            }
        }
    }

    public static boolean O000000o(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", (int) NotificationCompat.FLAG_HIGH_PRIORITY);
            if (packageInfo != null) {
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f6366O000000o = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    public String O00000oo() {
        try {
            Signature[] signatureArr = this.O00000Oo.getPackageManager().getPackageInfo(this.O00000Oo.getPackageName(), 64).signatures;
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            byte[] digest = instance.digest(signatureArr[0].toByteArray());
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean O000000o() {
        return f6366O000000o;
    }

    public final String O00000Oo() {
        O000000o("getUDID");
        if (this.O00000oO == null) {
            return null;
        }
        return this.O00000oO.f6367O000000o;
    }

    public final String O00000o() {
        O000000o("getVAID");
        if (this.O00000oO == null) {
            return null;
        }
        return this.O00000oO.O00000o0;
    }

    public final String O00000o0() {
        O000000o("getOAID");
        if (this.O00000oO == null) {
            return null;
        }
        return this.O00000oO.O00000Oo;
    }

    public final String O00000oO() {
        O000000o("getAAID");
        if (this.O00000oO == null) {
            return null;
        }
        return this.O00000oO.O00000o;
    }

    public bc(Context context) {
        boolean z = false;
        this.O00000Oo = context;
        this.O00000o0 = new O00000Oo(this, (byte) 0);
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        int i = 1;
        try {
            z = this.O00000Oo.bindService(intent, this.O00000o0, 1);
        } catch (Exception unused) {
        }
        this.O00000o = !z ? 2 : i;
    }

    public static /* synthetic */ void O00000o(bc bcVar) {
        ServiceConnection serviceConnection = bcVar.O00000o0;
        if (serviceConnection != null) {
            try {
                bcVar.O00000Oo.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }
}
