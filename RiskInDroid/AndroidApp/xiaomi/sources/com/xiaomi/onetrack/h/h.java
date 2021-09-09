package com.xiaomi.onetrack.h;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.onetrack.d.d;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class h {
    private static String A;
    private static String B;
    private static String C;
    private static String D;
    private static String E;
    private static String F;
    private static String G;
    private static Boolean H;
    private static String I;
    private static Method j;
    private static Method k;
    private static Method l;
    private static Object m;
    private static Method n;
    private static Method o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    private static String v;
    private static String w;
    private static String x;
    private static String y;
    private static String z;

    public static long a(long j2) {
        float f = (float) j2;
        if (((double) f) > 900.0d) {
            f /= 1000.0f;
        }
        if (((double) f) > 900.0d) {
            f /= 1000.0f;
        }
        if (((double) f) > 900.0d) {
            f /= 1000.0f;
        }
        return (long) f;
    }

    private static long c(long j2) {
        long j3 = 1;
        long j4 = 1;
        while (true) {
            long j5 = j3 * j4;
            if (j5 >= j2) {
                return j5;
            }
            j3 <<= 1;
            if (j3 > 512) {
                j4 *= 1000;
                j3 = 1;
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0055 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    static {
        try {
            j = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
        } catch (Exception unused) {
        }
        Class<?> cls = Class.forName("miui.telephony.TelephonyManagerEx");
        m = cls.getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
        k = cls.getMethod("getImeiList", new Class[0]);
        l = cls.getMethod("getMeidList", new Class[0]);
        o = cls.getMethod("getSubscriberIdForSlot", Integer.TYPE);
        try {
            if (Build.VERSION.SDK_INT < 21) {
                n = Class.forName("android.telephony.TelephonyManager").getMethod("getImei", Integer.TYPE);
            }
        } catch (Exception unused2) {
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        r(context);
        return !TextUtils.isEmpty(p) ? p : "";
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(w)) {
            return w;
        }
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        String c = d.c(a2);
        w = c;
        return c;
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(A)) {
            return A;
        }
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        String e = d.e(a2);
        A = e;
        return e;
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(C)) {
            return C;
        }
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        String d = d.d(a2);
        C = d;
        return d;
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty(q)) {
            return q;
        }
        r(context);
        return !TextUtils.isEmpty(q) ? q : "";
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(x)) {
            return x;
        }
        String e = e(context);
        if (TextUtils.isEmpty(e)) {
            return "";
        }
        String c = d.c(e);
        x = c;
        return c;
    }

    public static String g(Context context) {
        if (!TextUtils.isEmpty(B)) {
            return B;
        }
        String e = e(context);
        if (TextUtils.isEmpty(e)) {
            return "";
        }
        String e2 = d.e(e);
        B = e2;
        return e2;
    }

    public static String h(Context context) {
        if (!TextUtils.isEmpty(D)) {
            return D;
        }
        String e = e(context);
        if (TextUtils.isEmpty(e)) {
            return "";
        }
        String d = d.d(e);
        D = d;
        return d;
    }

    private static String A(Context context) {
        if (!TextUtils.isEmpty(r)) {
            return r;
        }
        D(context);
        return !TextUtils.isEmpty(r) ? r : "";
    }

    public static String i(Context context) {
        if (!TextUtils.isEmpty(y)) {
            return y;
        }
        String A2 = A(context);
        if (TextUtils.isEmpty(A2)) {
            return "";
        }
        String c = d.c(A2);
        y = c;
        return c;
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(E)) {
            return E;
        }
        String A2 = A(context);
        if (TextUtils.isEmpty(A2)) {
            return "";
        }
        String e = d.e(A2);
        E = e;
        return e;
    }

    public static String k(Context context) {
        if (!TextUtils.isEmpty(s)) {
            return s;
        }
        String b2 = b.b(context);
        if (TextUtils.isEmpty(b2)) {
            return "";
        }
        s = b2;
        return b2;
    }

    public static String l(Context context) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        String u2 = u(context);
        if (TextUtils.isEmpty(u2)) {
            return "";
        }
        t = u2;
        return u2;
    }

    public static String m(Context context) {
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        String l2 = l(context);
        if (TextUtils.isEmpty(l2)) {
            return "";
        }
        String c = d.c(l2);
        z = c;
        return c;
    }

    public static String n(Context context) {
        if (!TextUtils.isEmpty(G)) {
            return G;
        }
        String l2 = l(context);
        if (TextUtils.isEmpty(l2)) {
            return "";
        }
        String e = d.e(l2);
        G = e;
        return e;
    }

    public static String o(Context context) {
        if (!TextUtils.isEmpty(u)) {
            return u;
        }
        try {
            String type = context.getContentResolver().getType(Uri.parse("content://com.miui.analytics.server.AnalyticsProvider/aaid"));
            if (!TextUtils.isEmpty(type)) {
                u = type;
                return type;
            }
            Object invoke = Class.forName("android.provider.MiuiSettings$Ad").getDeclaredMethod("getAaid", ContentResolver.class).invoke(null, context.getContentResolver());
            if (!(invoke instanceof String) || TextUtils.isEmpty((String) invoke)) {
                return "";
            }
            String str = (String) invoke;
            u = str;
            return str;
        } catch (Exception e) {
            q.a("DeviceUtil", "getAaid failed ex: " + e.getMessage());
            return "";
        }
    }

    public static String p(Context context) {
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        if (a.b(context)) {
            return "";
        }
        String a2 = a.a(context);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        v = a2;
        return a2;
    }

    public static void a() {
        v = null;
    }

    public static List<String> q(Context context) {
        List<String> r2 = r(context);
        ArrayList arrayList = new ArrayList();
        if (r2 != null && !r2.isEmpty()) {
            for (int i = 0; i < r2.size(); i++) {
                if (!TextUtils.isEmpty(r2.get(i))) {
                    arrayList.add(i, d.c(r2.get(i)));
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"MissingPermission"})
    public static List<String> r(Context context) {
        List<String> list;
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            list = l();
            if (list == null || list.isEmpty()) {
                list = Build.VERSION.SDK_INT >= 21 ? B(context) : C(context);
            }
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            Collections.sort(list);
            p = list.get(0);
            if (list.size() >= 2) {
                q = list.get(1);
            }
        }
        return list;
    }

    private static List<String> l() {
        if (k == null || n()) {
            return null;
        }
        try {
            List<String> list = (List) k.invoke(m, new Object[0]);
            if (list == null || list.size() <= 0 || a(list)) {
                return null;
            }
            return list;
        } catch (Exception e) {
            q.a("DeviceUtil", "getImeiListFromMiui failed ex: " + e.getMessage());
            return null;
        }
    }

    private static List<String> B(Context context) {
        if (n == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str = (String) n.invoke(telephonyManager, 0);
            if (c(str)) {
                arrayList.add(str);
            }
            if (m()) {
                String str2 = (String) n.invoke(telephonyManager, 1);
                if (c(str2)) {
                    arrayList.add(str2);
                }
            }
            return arrayList;
        } catch (Exception e) {
            q.a("DeviceUtil", "getImeiListAboveLollipop failed ex: " + e.getMessage());
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static List<String> C(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            Class<?> cls = Class.forName("android.telephony.TelephonyManager");
            if (!m()) {
                String deviceId = ((TelephonyManager) cls.getMethod("getDefault", new Class[0]).invoke(null, new Object[0])).getDeviceId();
                if (c(deviceId)) {
                    arrayList.add(deviceId);
                }
                return arrayList;
            }
            String deviceId2 = ((TelephonyManager) cls.getMethod("getDefault", Integer.TYPE).invoke(null, 0)).getDeviceId();
            String deviceId3 = ((TelephonyManager) cls.getMethod("getDefault", Integer.TYPE).invoke(null, 1)).getDeviceId();
            if (c(deviceId2)) {
                arrayList.add(deviceId2);
            }
            if (c(deviceId3)) {
                arrayList.add(deviceId3);
            }
            return arrayList;
        } catch (Exception e) {
            q.a("DeviceUtil", "getImeiListBelowLollipop failed ex: " + e.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d A[Catch:{ Exception -> 0x0098 }] */
    @SuppressLint({"MissingPermission"})
    private static List<String> D(Context context) {
        String str;
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            Method method = l;
            if (method != null) {
                try {
                    List<String> list = (List) method.invoke(m, new Object[0]);
                    if (list != null && list.size() > 0 && !b(list)) {
                        Collections.sort(list);
                        r = list.get(0);
                        return list;
                    }
                } catch (Exception e) {
                    q.a("DeviceUtil", "queryMeidList failed ex: " + e.getMessage());
                }
            }
            try {
                Class<?> cls = Class.forName("android.telephony.TelephonyManager");
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (cls != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        Method method2 = cls.getMethod("getMeid", new Class[0]);
                        if (method2 != null) {
                            str = (String) method2.invoke(telephonyManager, new Object[0]);
                            if (d(str)) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(str);
                                r = str;
                                return arrayList;
                            }
                        }
                    } else {
                        Method method3 = cls.getMethod("getDeviceId", new Class[0]);
                        if (method3 != null) {
                            str = (String) method3.invoke(telephonyManager, new Object[0]);
                            if (d(str)) {
                            }
                        }
                    }
                }
                str = null;
                if (d(str)) {
                }
            } catch (Exception e2) {
                q.a("DeviceUtil", "queryMeidList->getMeid failed ex: " + e2.getMessage());
            }
        }
        return null;
    }

    public static String s(Context context) {
        try {
            List<String> D2 = D(context);
            if (D2 == null) {
                return "";
            }
            Collections.sort(D2, new i());
            for (int i = 0; i < D2.size(); i++) {
                D2.set(i, d.h(D2.get(i)));
            }
            return D2.toString();
        } catch (Throwable th) {
            q.b("DeviceUtil", "getMeidListMd5 e", th);
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static List<String> t(Context context) {
        String str;
        String str2;
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            ArrayList arrayList = new ArrayList();
            try {
                if (m()) {
                    Class<?> cls = Class.forName("android.telephony.TelephonyManager");
                    if (Build.VERSION.SDK_INT >= 22) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                        Class<?> cls2 = Class.forName("android.telephony.SubscriptionManager");
                        if (Build.VERSION.SDK_INT < 29) {
                            str2 = a(cls, cls2, telephonyManager, subscriptionManager)[0];
                            str = a(cls, cls2, telephonyManager, subscriptionManager)[1];
                        } else {
                            str2 = b(cls, cls2, telephonyManager, subscriptionManager)[0];
                            str = b(cls, cls2, telephonyManager, subscriptionManager)[1];
                        }
                    } else {
                        str2 = ((TelephonyManager) cls.getMethod("getDefault", Integer.TYPE).invoke(null, 0)).getSubscriberId();
                        str = ((TelephonyManager) cls.getMethod("getDefault", Integer.TYPE).invoke(null, 1)).getSubscriberId();
                    }
                    if (!e(str2)) {
                        str2 = "";
                    }
                    arrayList.add(str2);
                    if (!e(str)) {
                        str = "";
                    }
                    arrayList.add(str);
                    return arrayList;
                }
                String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                if (e(subscriberId)) {
                    arrayList.add(subscriberId);
                }
                return arrayList;
            } catch (SecurityException unused) {
                q.a("DeviceUtil", "getImsiList failed with on permission");
            } catch (Exception e) {
                q.b("DeviceUtil", "getImsiList failed!", e);
            }
        }
        return null;
    }

    private static boolean m() {
        if ("dsds".equals(b("persist.radio.multisim.config"))) {
            return true;
        }
        String str = Build.DEVICE;
        if ("lcsh92_wet_jb9".equals(str) || "lcsh92_wet_tdd".equals(str) || "HM2013022".equals(str) || "HM2013023".equals(str) || "armani".equals(str) || "HM2014011".equals(str) || "HM2014012".equals(str)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static String b(String str) {
        try {
            if (j != null) {
                return String.valueOf(j.invoke(null, str));
            }
        } catch (Exception e) {
            q.a("DeviceUtil", "getProp failed ex: " + e.getMessage());
        }
        return null;
    }

    private static boolean n() {
        if (Build.VERSION.SDK_INT >= 21) {
            return false;
        }
        String str = Build.DEVICE;
        String b2 = b("persist.radio.modem");
        if ("HM2014812".equals(str) || "HM2014821".equals(str)) {
            return true;
        }
        if ((!"gucci".equals(str) || !"ct".equals(b("persist.sys.modem"))) && !"CDMA".equals(b2) && !"HM1AC".equals(b2) && !"LTE-X5-ALL".equals(b2) && !"LTE-CT".equals(b2) && !"MI 3C".equals(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean a(List<String> list) {
        for (String c : list) {
            if (!c(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(List<String> list) {
        for (String d : list) {
            if (!d(d)) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(String str) {
        return str != null && str.length() == 15 && !str.matches("^0*$");
    }

    private static boolean d(String str) {
        return str != null && str.length() == 14 && !str.matches("^0*$");
    }

    @SuppressLint({"MissingPermission"})
    public static String u(Context context) {
        String str = null;
        if (Build.VERSION.SDK_INT < 26) {
            str = Build.SERIAL;
        } else if (a(context, "android.permission.READ_PHONE_STATE")) {
            try {
                Method method = Class.forName("android.os.Build").getMethod("getSerial", new Class[0]);
                if (method != null) {
                    str = (String) method.invoke(null, new Object[0]);
                }
            } catch (Exception e) {
                q.a("DeviceUtil", "querySerial failed ex: " + e.getMessage());
            }
        }
        if (TextUtils.isEmpty(str) || "unknown".equals(str)) {
            return "";
        }
        t = str;
        return str;
    }

    private static boolean a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    static class a {
        private a() {
        }

        static String a(Context context) {
            if (!c(context)) {
                q.a("GAIDClient", "Google play service is not available");
                return "";
            }
            C0059a aVar = new C0059a(null);
            try {
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, aVar, 1)) {
                    String a2 = new b(aVar.a()).a();
                    context.unbindService(aVar);
                    return a2;
                }
            } catch (Exception e) {
                q.a("GAIDClient", "Query Google ADID failed ", e);
            } catch (Throwable th) {
                context.unbindService(aVar);
                throw th;
            }
            context.unbindService(aVar);
            return "";
        }

        static boolean b(Context context) {
            if (!c(context)) {
                q.a("GAIDClient", "Google play service is not available");
                return false;
            }
            C0059a aVar = new C0059a(null);
            try {
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, aVar, 1)) {
                    boolean a2 = new b(aVar.a()).a(true);
                    context.unbindService(aVar);
                    return a2;
                }
            } catch (Exception e) {
                q.a("GAIDClient", "Query Google isLimitAdTrackingEnabled failed ", e);
            } catch (Throwable th) {
                context.unbindService(aVar);
                throw th;
            }
            context.unbindService(aVar);
            return false;
        }

        private static boolean c(Context context) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 16384);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }

        /* renamed from: com.xiaomi.onetrack.h.h$a$a  reason: collision with other inner class name */
        static final class C0059a implements ServiceConnection {
            private boolean b;
            private IBinder c;

            private C0059a() {
                this.b = false;
            }

            /* synthetic */ C0059a(i iVar) {
                this();
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this) {
                    this.c = iBinder;
                    notifyAll();
                }
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                this.b = true;
                this.c = null;
            }

            public final IBinder a() throws InterruptedException {
                IBinder iBinder = this.c;
                if (iBinder != null) {
                    return iBinder;
                }
                if (iBinder == null && !this.b) {
                    synchronized (this) {
                        wait(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                        if (this.c == null) {
                            throw new InterruptedException("Not connect or connect timeout to google play service");
                        }
                    }
                }
                return this.c;
            }
        }

        static final class b implements IInterface {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6174a;

            public b(IBinder iBinder) {
                this.f6174a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f6174a;
            }

            public final String a() throws RemoteException {
                if (this.f6174a == null) {
                    return "";
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f6174a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(boolean z) throws RemoteException {
                boolean z2 = false;
                if (this.f6174a == null) {
                    return false;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f6174a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    static class b {
        private static Signature[] f;
        private static final Signature g = new Signature("3082033b30820223a003020102020900a07a328482f70d2a300d06092a864886f70d01010505003035310b30090603550406130255533113301106035504080c0a43616c69666f726e69613111300f06035504070c084d6f756e7461696e301e170d3133303430313033303831325a170d3430303831373033303831325a3035310b30090603550406130255533113301106035504080c0a43616c69666f726e69613111300f06035504070c084d6f756e7461696e30820120300d06092a864886f70d01010105000382010d00308201080282010100ac678c9234a0226edbeb75a43e8e18f632d8c8a094c087fffbbb0b5e4429d845e36bffbe2d7098e320855258aa777368c18c538f968063d5d61663dc946ab03acbb31d00a27d452e12e6d42865e27d6d0ad2d8b12cf3b3096a7ec66a21db2a6a697857fd4d29fb4cdf294b3371d7601f2e3f190c0164efa543897026c719b334808e4f612fe3a3da589115fc30f9ca89862feefdf31a9164ecb295dcf7767e673be2192dda64f88189fd6e6ebd62e572c7997c2385a0ea9292ec799dee8f87596fc73aa123fb6f577d09ac0c123179c3bdbc978c2fe6194eb9fa4ab3658bfe8b44040bb13fe7809409e622189379fbc63966ab36521793547b01673ecb5f15cf020103a350304e301d0603551d0e0416041447203684e562385ada79108c4c94c5055037592f301f0603551d2304183016801447203684e562385ada79108c4c94c5055037592f300c0603551d13040530030101ff300d06092a864886f70d010105050003820101008d530fe05c6fe694c7559ddb5dd2c556528dd3cad4f7580f439f9a90a4681d37ce246b9a6681bdd5a5437f0b8bba903e39bac309fc0e9ee5553681612e723e9ec4f6abab6b643b33013f09246a9b5db7703b96f838fb27b00612f5fcd431bea32f68350ae51a4a1d012c520c401db7cccc15a7b19c4310b0c3bfc625ce5744744d0b9eeb02b0a4e7d51ed59849ce580b9f7c3062c84b9a0b13cc211e1c916c289820266a610801e3316c915649804571b147beadbf88d3b517ee04121d40630853f2f2a506bb788620de9648faeacff568e5033a666316bc2046526674ed3de25ceefdc4ad3628f1a230fd41bf9ca9f6a078173850dba555768fe1c191483ad9");

        private b() {
        }

        static boolean a(Context context) {
            if (f == null) {
                f = new Signature[]{c(context)};
            }
            Signature[] signatureArr = f;
            return signatureArr[0] != null && signatureArr[0].equals(g);
        }

        private static Signature a(PackageInfo packageInfo) {
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return null;
            }
            return packageInfo.signatures[0];
        }

        private static Signature c(Context context) {
            try {
                return a(context.getPackageManager().getPackageInfo("android", 64));
            } catch (Exception unused) {
                return null;
            }
        }

        public static String b(Context context) {
            String str;
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), "mi_device_mac");
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                } catch (Exception unused) {
                }
            }
            boolean z = false;
            try {
                String str2 = Build.PRODUCT;
                String a2 = h.b("ro.product.model");
                if ((TextUtils.equals("tv", a()) && !"batman".equals(str2) && !"conan".equals(str2)) || "augustrush".equals(str2) || "casablanca".equals(str2)) {
                    z = true;
                }
                if (TextUtils.equals("me2", str2)) {
                    str = h.b("persist.service.bdroid.bdaddr");
                } else if ((TextUtils.equals("transformers", str2) && TextUtils.equals("MiBOX4C", a2)) || TextUtils.equals("dolphin-zorro", str2)) {
                    str = a("/sys/class/net/wlan0/address");
                } else if (z) {
                    str = a("/sys/class/net/eth0/address");
                } else {
                    str = a("ro.boot.btmac");
                }
                if (!TextUtils.isEmpty(str)) {
                    return str.trim();
                }
                return "";
            } catch (Exception e) {
                q.a("DeviceUtil", "getMiTvMac exception", e);
                return "";
            }
        }

        private static String a(String str) {
            String str2 = "";
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 512);
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        str2 = str2 + readLine;
                    }
                    n.a(bufferedReader2);
                } catch (Exception e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        q.b("DeviceUtil", "catEntry exception", e);
                        n.a(bufferedReader);
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        n.a(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    n.a(bufferedReader);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                q.b("DeviceUtil", "catEntry exception", e);
                n.a(bufferedReader);
                return str2;
            }
            return str2;
        }

        private static String a() {
            try {
                Class<?> cls = Class.forName("mitv.common.ConfigurationManager");
                int parseInt = Integer.parseInt(String.valueOf(cls.getMethod("getProductCategory", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(cls, new Object[0]), new Object[0])));
                Class<?> cls2 = Class.forName("mitv.tv.TvContext");
                if (parseInt == Integer.parseInt(String.valueOf(a(cls2, "PRODUCT_CATEGORY_MITV")))) {
                    return "tv";
                }
                if (parseInt == Integer.parseInt(String.valueOf(a(cls2, "PRODUCT_CATEGORY_MIBOX")))) {
                    return "box";
                }
                if (parseInt == Integer.parseInt(String.valueOf(a(cls2, "PRODUCT_CATEGORY_MITVBOX")))) {
                    return "tvbox";
                }
                if (parseInt == Integer.parseInt(String.valueOf(a(cls2, "PRODUCT_CATEGORY_MIPROJECTOR")))) {
                    return "projector";
                }
                return "";
            } catch (Exception e) {
                q.a("DeviceUtil", "getMiTvProductCategory exception", e);
                return "";
            }
        }

        private static <T> T a(Class<?> cls, String str) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.get(null);
            } catch (Exception e) {
                q.b("DeviceUtil", "getStaticVariableValue exception", e);
                return null;
            }
        }
    }

    private static boolean e(String str) {
        return str != null && str.length() >= 6 && str.length() <= 15 && !str.matches("^0*$");
    }

    private static String[] a(Class<?> cls, Class<?> cls2, TelephonyManager telephonyManager, SubscriptionManager subscriptionManager) {
        String[] strArr = new String[2];
        try {
            if (Build.VERSION.SDK_INT == 21) {
                strArr[0] = (String) cls.getMethod("getSubscriberId", Long.TYPE).invoke(telephonyManager, Long.valueOf(((long[]) cls2.getMethod("getSubId", Integer.TYPE).invoke(subscriptionManager, 0))[0]));
            } else {
                strArr[0] = (String) cls.getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(((int[]) cls2.getMethod("getSubId", Integer.TYPE).invoke(subscriptionManager, 0))[0]));
            }
            if (e(strArr[0]) || n == null || m == null) {
                if (Build.VERSION.SDK_INT == 21) {
                    strArr[1] = (String) cls.getMethod("getSubscriberId", Long.TYPE).invoke(telephonyManager, Long.valueOf(((long[]) cls2.getMethod("getSubId", Integer.TYPE).invoke(subscriptionManager, 1))[0]));
                } else {
                    strArr[1] = (String) cls.getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(((int[]) cls2.getMethod("getSubId", Integer.TYPE).invoke(subscriptionManager, 1))[0]));
                }
                return strArr;
            }
            strArr[0] = (String) o.invoke(m, 0);
            strArr[1] = (String) o.invoke(m, 1);
            return strArr;
        } catch (Exception e) {
            q.a("DeviceUtil", "getImsiFromLToP: ".concat(String.valueOf(e)));
        }
    }

    private static String[] b(Class<?> cls, Class<?> cls2, TelephonyManager telephonyManager, SubscriptionManager subscriptionManager) {
        String[] strArr = new String[2];
        try {
            int[] iArr = (int[]) cls2.getMethod("getSubscriptionIds", Integer.TYPE).invoke(subscriptionManager, 0);
            if (iArr != null) {
                strArr[0] = (String) cls.getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(iArr[0]));
            }
        } catch (Exception e) {
            q.b("DeviceUtil", "get imsi1 above Android Q exception:".concat(String.valueOf(e)));
        }
        try {
            int[] iArr2 = (int[]) cls2.getMethod("getSubscriptionIds", Integer.TYPE).invoke(subscriptionManager, 1);
            if (iArr2 != null) {
                strArr[1] = (String) cls.getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(iArr2[0]));
            }
        } catch (Exception e2) {
            q.b("DeviceUtil", "get imsi2 above Android Q exception:".concat(String.valueOf(e2)));
        }
        return strArr;
    }

    public static String v(Context context) {
        try {
            List<String> t2 = t(context);
            if (t2 == null) {
                return "";
            }
            for (int i = 0; i < t2.size(); i++) {
                t2.set(i, d.h(t2.get(i)));
            }
            return t2.toString();
        } catch (Throwable th) {
            q.b(q.a("DeviceUtil"), "getImeiListMd5 failed!", th);
            return "";
        }
    }

    public static String b() {
        return b("ro.product.name");
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d() {
        return Build.MANUFACTURER;
    }

    public static String w(Context context) {
        if (!TextUtils.isEmpty(I)) {
            return I;
        }
        if (o()) {
            I = "Pad";
            return "Pad";
        } else if (!F(context)) {
            return "Phone";
        } else {
            I = "Tv";
            return "Tv";
        }
    }

    public static String e() {
        try {
            String b2 = b("ro.product.model.real");
            return TextUtils.isEmpty(b2) ? c() : b2;
        } catch (Exception e) {
            q.b("DeviceUtil", "getModelReal Exception: ", e);
            return "";
        }
    }

    public static String f() {
        try {
            String a2 = aa.a("ro.product.mod_device", "");
            return TextUtils.isEmpty(a2) ? Build.DEVICE : a2;
        } catch (Exception e) {
            q.b("DeviceUtil", "getModDevice Exception: ", e);
            return "";
        }
    }

    public static String g() {
        return aa.a("ro.build.description", "");
    }

    public static String h() {
        try {
            return aa.a("ro.product.manufacturer", "");
        } catch (Exception e) {
            q.b(q.a("DeviceUtil"), "getProductManufacturer e", e);
            return "";
        }
    }

    private static boolean o() {
        try {
            Class<?> cls = Class.forName("miui.os.Build");
            if (cls != null) {
                return ((Boolean) cls.getField("IS_TABLET").get(null)).booleanValue();
            }
        } catch (Exception unused) {
        }
        try {
            Class<?> cls2 = Class.forName("miui.util.FeatureParser");
            if (cls2 != null) {
                return ((Boolean) cls2.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, "is_pad", Boolean.FALSE)).booleanValue();
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    private static boolean E(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean x(Context context) {
        if (H == null) {
            H = Boolean.valueOf(b.a(context));
        }
        return H.booleanValue();
    }

    private static boolean F(Context context) {
        if (!b.a(context) && (context.getResources().getConfiguration().uiMode & 15) != 4) {
            return false;
        }
        return true;
    }

    public static String y(Context context) {
        return com.xiaomi.onetrack.h.a.a.a().a(context);
    }

    public static long i() {
        long j2;
        long j3;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j3 = statFs.getBlockSizeLong();
            j2 = statFs.getBlockCountLong();
        } else {
            j3 = (long) statFs.getBlockSize();
            j2 = (long) statFs.getBlockCount();
        }
        return (j3 * j2) / 1073741824;
    }

    public static String j() {
        long j2;
        long j3;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j3 = statFs.getBlockSizeLong();
            j2 = statFs.getBlockCountLong();
        } else {
            j3 = (long) statFs.getBlockSize();
            j2 = (long) statFs.getBlockCount();
        }
        return String.format("%dGB", Long.valueOf(b(j3 * j2)));
    }

    public static long k() {
        long j2;
        long j3;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j3 = statFs.getBlockSizeLong();
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j3 = (long) statFs.getBlockSize();
            j2 = (long) statFs.getAvailableBlocks();
        }
        return a(j3 * j2);
    }

    private static long b(long j2) {
        long j3;
        if (j2 >= 8000000000L) {
            j3 = (long) Math.pow(2.0d, Math.ceil(Math.log((double) (j2 / 1000000000)) / Math.log(2.0d)));
        } else {
            j3 = (j2 / 1000000000) + 1;
        }
        long j4 = j3 * 1000000000;
        if (j4 < j2) {
            j4 = c(j2);
        }
        return j4 / 1000000000;
    }

    public static String z(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return String.format("%d*%d", Integer.valueOf(point.y), Integer.valueOf(point.x));
    }
}
