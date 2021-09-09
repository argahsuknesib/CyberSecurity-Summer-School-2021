package com.xiaomi.push;

import _m_j.duv;
import _m_j.elv;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.support.v4.app.NotificationCompat;

public class at implements elv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f6361O000000o;
    private Context O00000Oo;
    /* access modifiers changed from: private */
    public volatile int O00000o = 0;
    private ServiceConnection O00000o0;
    /* access modifiers changed from: private */
    public volatile String O00000oO = null;
    /* access modifiers changed from: private */
    public volatile boolean O00000oo = false;
    private volatile String O0000O0o = null;
    /* access modifiers changed from: private */
    public final Object O0000OOo = new Object();

    class O000000o implements ServiceConnection {
        private O000000o() {
        }

        /* synthetic */ O000000o(at atVar, byte b) {
            this();
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002f */
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                String unused = at.this.O00000oO = O00000Oo.O000000o(iBinder);
                boolean unused2 = at.this.O00000oo = O00000Oo.O00000Oo(iBinder);
                at.O000000o(at.this);
                int unused3 = at.this.O00000o = 2;
                synchronized (at.this.O0000OOo) {
                    at.this.O0000OOo.notifyAll();
                }
            } catch (Exception unused4) {
                at.O000000o(at.this);
                int unused5 = at.this.O00000o = 2;
                synchronized (at.this.O0000OOo) {
                    at.this.O0000OOo.notifyAll();
                }
            } catch (Throwable th) {
                at.O000000o(at.this);
                int unused6 = at.this.O00000o = 2;
                synchronized (at.this.O0000OOo) {
                    at.this.O0000OOo.notifyAll();
                    throw th;
                }
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    static class O00000Oo {
        static String O000000o(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        static boolean O00000Oo(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean z = false;
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static boolean O000000o(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", (int) NotificationCompat.FLAG_HIGH_PRIORITY);
            boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
            f6361O000000o = packageInfo.versionCode >= 20602000;
            return z;
        } catch (Exception unused) {
        }
    }

    private static String O00000Oo(Context context) {
        String str;
        String str2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                str2 = context.createDeviceProtectedStorageContext().getSharedPreferences("aaid", 0).getString("aaid", null);
                if (str2 != null) {
                    return str2;
                }
            } else {
                str2 = null;
            }
            try {
                str = context.getSharedPreferences("aaid", 0).getString("aaid", null);
            } catch (Exception unused) {
                str = str2;
            }
        } catch (Exception unused2) {
            str = null;
        }
        return str == null ? "" : str;
    }

    public final boolean O000000o() {
        return f6361O000000o;
    }

    public final String O00000Oo() {
        return null;
    }

    public final String O00000o() {
        return null;
    }

    public final String O00000oO() {
        if (this.O0000O0o == null) {
            synchronized (this) {
                if (this.O0000O0o == null) {
                    this.O0000O0o = O00000Oo(this.O00000Oo);
                }
            }
        }
        return this.O0000O0o;
    }

    public at(Context context) {
        boolean z = false;
        this.O00000Oo = context;
        this.O00000o0 = new O000000o(this, (byte) 0);
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i = 1;
        try {
            z = this.O00000Oo.bindService(intent, this.O00000o0, 1);
        } catch (Exception unused) {
        }
        this.O00000o = !z ? 2 : i;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0034 */
    public final String O00000o0() {
        if (this.O00000o == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.O0000OOo) {
                duv.O000000o("huawei's " + "getOAID" + " wait...");
                this.O0000OOo.wait(3000);
            }
        }
        return this.O00000oO;
    }

    static /* synthetic */ void O000000o(at atVar) {
        ServiceConnection serviceConnection = atVar.O00000o0;
        if (serviceConnection != null) {
            try {
                atVar.O00000Oo.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }
}
