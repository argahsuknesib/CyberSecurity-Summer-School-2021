package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.emg;
import _m_j.erv;
import _m_j.esl;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.hu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

public class ar {

    /* renamed from: a  reason: collision with root package name */
    private static Context f6505a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f255a;

    /* renamed from: a  reason: collision with other field name */
    private static WeakHashMap<Integer, ar> f256a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f257a;

    /* renamed from: a  reason: collision with other field name */
    private String f258a;
    private String b;

    private ar(String str) {
        this.f258a = str;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return f6505a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) f6505a.getSystemService("notification");
    }

    public static ar a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        ar arVar = f256a.get(Integer.valueOf(hashCode));
        if (arVar != null) {
            return arVar;
        }
        ar arVar2 = new ar(str);
        f256a.put(Integer.valueOf(hashCode), arVar2);
        return arVar2;
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a("mipush|%s|%s", str2, "");
        return str.startsWith(a2) ? a("mipush_%s_%s", str2, str.replace(a2, "")) : str;
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(str, str2, str3);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [android.app.NotificationManager, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    private static void a(Context context) {
        if (f6505a == null) {
            f6505a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) emg.O000000o((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m161a("fwk is support.init:".concat(String.valueOf(bool)));
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f257a = booleanValue;
            if (booleanValue) {
                f255a = emg.O000000o((Object) a2, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m161a(String str) {
        duv.O000000o("NMHelper:".concat(String.valueOf(str)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    /* renamed from: a  reason: collision with other method in class */
    private static boolean m162a() {
        if (esl.O000000o() && at.a(f6505a).a(hu.aZ.a(), true)) {
            return f257a;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m163a(Context context) {
        a(context);
        return m162a();
    }

    /* renamed from: a  reason: collision with other method in class */
    private StatusBarNotification[] m164a() {
        if (!esl.O000000o(m166a())) {
            return null;
        }
        try {
            String packageName = m166a().getPackageName();
            Object O000000o2 = emg.O000000o(f255a, "getActiveNotifications", packageName);
            if (O000000o2 instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) O000000o2;
            }
            return null;
        } catch (Throwable th) {
            m161a("getAllNotifications error ".concat(String.valueOf(th)));
            return null;
        }
    }

    private String b(String str) {
        return a(m162a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f258a, str);
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m165a(String str) {
        try {
            if (!m162a()) {
                return a().getNotificationChannel(str);
            }
            List<NotificationChannel> a2 = m169a();
            if (a2 != null) {
                for (NotificationChannel next : a2) {
                    if (str.equals(next.getId())) {
                        return next;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            m161a("getNotificationChannel error".concat(String.valueOf(e)));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m166a() {
        return f6505a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m167a() {
        return this.f258a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m168a(String str) {
        return TextUtils.isEmpty(str) ? b() : esl.O000000o(m166a()) ? b(str) : str;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public List<NotificationChannel> m169a() {
        String str;
        String str2 = this.f258a;
        List<NotificationChannel> list = null;
        try {
            if (m162a()) {
                int a2 = a(str2);
                if (a2 != -1) {
                    str = "mipush|%s|%s";
                    list = (List) a(emg.O000000o(f255a, "getNotificationChannelsForPackage", str2, Integer.valueOf(a2), Boolean.FALSE));
                } else {
                    str = null;
                }
            } else {
                list = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!esl.O000000o() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String a3 = a(str, str2, "");
            for (NotificationChannel next : list) {
                if (next.getId().startsWith(a3)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } catch (Exception e) {
            m161a("getNotificationChannels error ".concat(String.valueOf(e)));
            return null;
        }
    }

    public void a(int i) {
        String str = this.f258a;
        try {
            if (m162a()) {
                int O000000o2 = erv.O000000o();
                String packageName = m166a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    emg.O00000Oo(f255a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(O000000o2));
                } else {
                    emg.O00000Oo(f255a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(O000000o2));
                }
                m161a("cancel succ:".concat(String.valueOf(i)));
                return;
            }
            a().cancel(i);
        } catch (Exception e) {
            m161a("cancel error".concat(String.valueOf(e)));
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f258a;
        NotificationManager a2 = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m162a()) {
                if (i2 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i2 >= 29) {
                    a2.notifyAsPackage(str, null, i, notification);
                } else {
                    a2.notify(i, notification);
                }
            } else {
                a2.notify(i, notification);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f258a;
        try {
            if (m162a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    Object a3 = a(Arrays.asList(notificationChannel));
                    emg.O00000Oo(f255a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a3);
                    return;
                }
                return;
            }
            a().createNotificationChannel(notificationChannel);
        } catch (Exception e) {
            m161a("createNotificationChannel error".concat(String.valueOf(e)));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f258a;
        if (z) {
            try {
                int a2 = a(str);
                if (a2 != -1) {
                    emg.O00000Oo(f255a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                }
            } catch (Exception e) {
                m161a("updateNotificationChannel error ".concat(String.valueOf(e)));
            }
        } else {
            a(notificationChannel);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m170a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(b(""));
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = b("default");
        }
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public String b(String str, String str2) {
        return m162a() ? str : str2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m171b() {
        ArrayList arrayList = null;
        if (Build.VERSION.SDK_INT < 18) {
            return null;
        }
        String str = this.f258a;
        NotificationManager a2 = a();
        try {
            if (m162a()) {
                int O000000o2 = erv.O000000o();
                if (O000000o2 != -1) {
                    return (List) a(emg.O000000o(f255a, "getAppActiveNotifications", str, Integer.valueOf(O000000o2)));
                }
            } else {
                StatusBarNotification[] activeNotifications = Build.VERSION.SDK_INT >= 23 ? a2.getActiveNotifications() : m164a();
                boolean O000000o3 = esl.O000000o();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (!O000000o3 || str.equals(as.c(statusBarNotification.getNotification()))) {
                                arrayList2.add(statusBarNotification);
                            }
                        }
                        return arrayList2;
                    } catch (Throwable th) {
                        th = th;
                        arrayList = arrayList2;
                        m161a("getActiveNotifications error ".concat(String.valueOf(th)));
                        return arrayList;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            m161a("getActiveNotifications error ".concat(String.valueOf(th)));
            return arrayList;
        }
        return arrayList;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f258a + "}";
    }
}
