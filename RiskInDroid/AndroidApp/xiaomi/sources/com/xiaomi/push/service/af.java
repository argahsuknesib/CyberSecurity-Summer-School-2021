package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.elo;
import _m_j.emg;
import _m_j.epj;
import _m_j.epk;
import _m_j.epl;
import _m_j.esl;
import _m_j.esv;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.push.ex;
import com.xiaomi.push.g;
import com.xiaomi.push.hp;
import com.xiaomi.push.ic;
import com.xiaomi.push.il;
import com.xiaomi.push.service.aq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class af {

    /* renamed from: a  reason: collision with root package name */
    public static long f6489a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile am f233a;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, il>> f234a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f235a = Executors.newCachedThreadPool();

    static class a implements Callable<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private Context f6490a;

        /* renamed from: a  reason: collision with other field name */
        private String f236a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f237a;

        public a(String str, Context context, boolean z) {
            this.f6490a = context;
            this.f236a = str;
            this.f237a = z;
        }

        /* renamed from: a */
        public Bitmap call() {
            if (TextUtils.isEmpty(this.f236a)) {
                duv.O000000o("Failed get online picture/icon resource cause picUrl is empty");
            } else if (this.f236a.startsWith("http")) {
                aq.b a2 = aq.a(this.f6490a, this.f236a, this.f237a);
                if (a2 != null) {
                    return a2.f254a;
                }
                duv.O000000o("Failed get online picture/icon resource");
            } else {
                Bitmap a3 = aq.a(this.f6490a, this.f236a);
                if (a3 != null) {
                    return a3;
                }
                duv.O000000o("Failed get online picture/icon resource");
                return a3;
            }
            return null;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        long f6491a = 0;

        /* renamed from: a  reason: collision with other field name */
        Notification f238a;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f6492a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f239a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f240a = false;
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static int a(Context context, String str, Map<String, String> map, int i) {
        ComponentName a2;
        Intent b2 = b(context, str, map, i);
        if (b2 == null || (a2 = h.a(context, b2)) == null) {
            return 0;
        }
        return a2.hashCode();
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static elo.O000000o a(Context context, String str, int i, String str2, Notification notification) {
        return new ah(i, str2, context, str, notification);
    }

    private static Notification a(Notification notification) {
        Object O000000o2 = emg.O000000o(notification, "extraNotification");
        if (O000000o2 != null) {
            emg.O000000o(O000000o2, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    private static PendingIntent a(Context context, il ilVar, String str, byte[] bArr, int i) {
        return a(context, ilVar, str, bArr, i, 0, a(context, ilVar, str));
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Intent m145a(Context context, String str, Map<String, String> map, int i) {
        if (m154b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        } else if (i == 1) {
            return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        } else {
            if (i == 2) {
                return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
            }
            if (i == 3) {
                return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            if (i != 4) {
                return null;
            }
            return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fa  */
    private static Intent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent intent;
        StringBuilder sb;
        String str6;
        String str7 = map.get(str2);
        if (TextUtils.isEmpty(str7)) {
            return null;
        }
        if (bd.f6521a.equals(str7)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e) {
                duv.O00000o("Cause: " + e.getMessage());
            }
        } else if (!bd.b.equals(str7)) {
            if (bd.c.equals(str7)) {
                String str8 = map.get(str5);
                if (!TextUtils.isEmpty(str8)) {
                    String trim = str8.trim();
                    if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                        trim = "http://".concat(String.valueOf(trim));
                    }
                    try {
                        String protocol = new URL(trim).getProtocol();
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            intent = new Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(Uri.parse(trim));
                                as.a(context, intent);
                            } catch (MalformedURLException e2) {
                                e = e2;
                            }
                        }
                    } catch (MalformedURLException e3) {
                        e = e3;
                        intent = null;
                        sb = new StringBuilder("Cause: ");
                        str6 = e.getMessage();
                        sb.append(str6);
                        duv.O00000o(sb.toString());
                        if (intent != null) {
                        }
                        return null;
                    }
                }
            }
            intent = null;
        } else if (map.containsKey(str3)) {
            String str9 = map.get(str3);
            if (str9 != null) {
                try {
                    intent = Intent.parseUri(str9, 1);
                    try {
                        intent.setPackage(str);
                    } catch (URISyntaxException e4) {
                        e = e4;
                    }
                } catch (URISyntaxException e5) {
                    e = e5;
                    intent = null;
                    sb = new StringBuilder("Cause: ");
                    str6 = e.getMessage();
                    sb.append(str6);
                    duv.O00000o(sb.toString());
                    if (intent != null) {
                    }
                    return null;
                }
            }
            intent = null;
        } else {
            if (map.containsKey(str4)) {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName(str, map.get(str4)));
                intent = intent2;
            }
            intent = null;
        }
        if (intent != null) {
            intent.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    return intent;
                }
            } catch (Exception e6) {
                duv.O00000o("Cause: " + e6.getMessage());
            }
        }
        return null;
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    /* JADX INFO: finally extract failed */
    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = f235a.submit(new a(str, context, z));
        try {
            Bitmap bitmap = (Bitmap) submit.get(180, TimeUnit.SECONDS);
            if (bitmap != null) {
                return bitmap;
            }
            submit.cancel(true);
            return bitmap;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            duv.O000000o(e);
            submit.cancel(true);
            return null;
        } catch (Throwable th) {
            submit.cancel(true);
            throw th;
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? g.O00000oO(context, str) : map.get("channel_name");
    }

    public static String a(Map<String, String> map, int i) {
        String format = i == 0 ? "notify_effect" : m154b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m147a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int i3;
        if (context != null && !TextUtils.isEmpty(str) && i >= -1) {
            ar a2 = ar.a(context, str);
            List<StatusBarNotification> b2 = a2.m171b();
            if (!esv.O000000o(b2)) {
                LinkedList linkedList = new LinkedList();
                boolean z = false;
                if (i == -1) {
                    i3 = 0;
                    z = true;
                } else {
                    i3 = ((str.hashCode() / 10) * 10) + i;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    Iterator<StatusBarNotification> it = b2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        StatusBarNotification next = it.next();
                        if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                            int id = next.getId();
                            if (z) {
                                linkedList.add(next);
                                a2.a(id);
                            } else if (i3 == id) {
                                d.a(context, next, i2);
                                linkedList.add(next);
                                a2.a(id);
                                break;
                            }
                        }
                    }
                }
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            ar a2 = ar.a(context, str);
            List<StatusBarNotification> b2 = a2.m171b();
            if (!esv.O000000o(b2)) {
                LinkedList linkedList = new LinkedList();
                if (Build.VERSION.SDK_INT >= 18) {
                    for (StatusBarNotification next : b2) {
                        Notification notification = next.getNotification();
                        if (notification != null && !TextUtils.isEmpty(String.valueOf(next.getId()))) {
                            int id = next.getId();
                            String a3 = as.a(notification);
                            String b3 = as.b(notification);
                            if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b3) && a(a3, str2) && a(b3, str3)) {
                                linkedList.add(next);
                                a2.a(id);
                            }
                        }
                    }
                }
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            bs.a(context, "category_clear_notification", "clear_notification", (long) linkedList.size(), "");
        }
    }

    private static void a(Intent intent) {
        try {
            Method declaredMethod = intent.getClass().getDeclaredMethod("addMiuiFlags", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(intent, 2);
        } catch (Exception e) {
            duv.O00000Oo("insert flags error ".concat(String.valueOf(e)));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m148a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.importance == 100 && Arrays.asList(next.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m150a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }

    private static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            duv.O00000o0("importance=".concat(String.valueOf(str)));
            return Integer.parseInt(str);
        } catch (Exception e) {
            duv.O00000o("parsing channel importance error: ".concat(String.valueOf(e)));
            return 3;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):android.content.Intent
     arg types: [android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):int
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, int):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):android.content.Intent */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012f  */
    public static Intent b(Context context, String str, Map<String, String> map, int i) {
        Intent intent;
        StringBuilder sb;
        String str2;
        String str3;
        if (map == null) {
            return null;
        }
        if (i != 0) {
            return m145a(context, str, map, i);
        }
        if (!map.containsKey("notify_effect")) {
            return null;
        }
        String str4 = map.get("notify_effect");
        int i2 = -1;
        String str5 = map.get("intent_flag");
        try {
            if (!TextUtils.isEmpty(str5)) {
                i2 = Integer.parseInt(str5);
            }
        } catch (NumberFormatException e) {
            duv.O00000o("Cause by intent_flag: " + e.getMessage());
        }
        if (bd.f6521a.equals(str4)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                duv.O00000o("Cause: " + e2.getMessage());
            }
        } else if (!bd.b.equals(str4)) {
            if (bd.c.equals(str4) && (str3 = map.get("web_uri")) != null) {
                String trim = str3.trim();
                if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                    trim = "http://".concat(String.valueOf(trim));
                }
                try {
                    String protocol = new URL(trim).getProtocol();
                    if ("http".equals(protocol) || "https".equals(protocol)) {
                        intent = new Intent("android.intent.action.VIEW");
                        try {
                            intent.setData(Uri.parse(trim));
                        } catch (MalformedURLException e3) {
                            e = e3;
                        }
                    }
                } catch (MalformedURLException e4) {
                    e = e4;
                    intent = null;
                    sb = new StringBuilder("Cause: ");
                    str2 = e.getMessage();
                    sb.append(str2);
                    duv.O00000o(sb.toString());
                    if (intent != null) {
                    }
                    return null;
                }
            }
            intent = null;
        } else if (map.containsKey("intent_uri")) {
            String str6 = map.get("intent_uri");
            if (str6 != null) {
                try {
                    intent = Intent.parseUri(str6, 1);
                    try {
                        intent.setPackage(str);
                    } catch (URISyntaxException e5) {
                        e = e5;
                    }
                } catch (URISyntaxException e6) {
                    e = e6;
                    intent = null;
                    sb = new StringBuilder("Cause: ");
                    str2 = e.getMessage();
                    sb.append(str2);
                    duv.O00000o(sb.toString());
                    if (intent != null) {
                    }
                    return null;
                }
            }
            intent = null;
        } else {
            if (map.containsKey("class_name")) {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName(str, map.get("class_name")));
                intent = intent2;
            }
            intent = null;
        }
        if (intent != null) {
            if (i2 >= 0) {
                intent.setFlags(i2);
            }
            intent.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    return intent;
                }
                duv.O000000o("not resolve activity:".concat(String.valueOf(intent)));
            } catch (Exception e7) {
                duv.O00000o("Cause: " + e7.getMessage());
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static String b(int i, String str) {
        return "n_top_update_" + i + "_" + str;
    }

    public static String b(il ilVar) {
        return m149a(ilVar) ? "E100002" : c(ilVar) ? "E100000" : m153b(ilVar) ? "E100001" : d(ilVar) ? "E100003" : "";
    }

    /* renamed from: b  reason: collision with other method in class */
    static void m151b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
     arg types: [android.app.Notification, java.lang.String, int]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, java.lang.String, android.app.Notification):_m_j.elo$O000000o
     arg types: [android.content.Context, java.lang.String, int, java.lang.String, ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, java.lang.String, byte[], int):android.app.PendingIntent
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[], java.lang.String, int):com.xiaomi.push.ex
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, java.lang.String, android.app.Notification):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, java.lang.String, android.app.Notification):_m_j.elo$O000000o */
    @TargetApi(19)
    private static void b(Context context, String str, int i, String str2, Notification notification) {
        boolean z;
        Context context2 = context;
        int i2 = i;
        String str3 = str2;
        Notification notification2 = notification;
        if (context2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ar.a(context, str) != null && Build.VERSION.SDK_INT >= 26) {
            ar a2 = ar.a(context, str);
            if (notification2 == null) {
                List<StatusBarNotification> b2 = a2.m171b();
                if (b2 != null) {
                    Iterator<StatusBarNotification> it = b2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            notification2 = null;
                            break;
                        }
                        StatusBarNotification next = it.next();
                        Notification notification3 = next.getNotification();
                        String string = notification3.extras.getString("message_id");
                        if (i2 == next.getId() && str3.equals(string)) {
                            notification2 = notification3;
                            break;
                        }
                    }
                    z = false;
                } else {
                    return;
                }
            } else if (str3.equals(notification2.extras.getString("message_id"))) {
                z = true;
            } else {
                return;
            }
            if (notification2 != null) {
                if (notification2.getGroupAlertBehavior() != 1) {
                    emg.O000000o((Object) notification2, "mGroupAlertBehavior", (Object) 1);
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j = notification2.extras.getLong("mipush_org_when", 0);
                int i3 = notification2.extras.getInt("mipush_n_top_fre", 0);
                int i4 = notification2.extras.getInt("mipush_n_top_prd", 0);
                if (i4 > 0 && i4 >= i3) {
                    long j2 = ((long) (i4 * 1000)) + j;
                    if (j >= currentTimeMillis || currentTimeMillis >= j2) {
                        i4 = 0;
                    } else if (i3 > 0) {
                        int min = (int) Math.min((j2 - currentTimeMillis) / 1000, (long) i3);
                        if (min > 0 && !z) {
                            notification2.when = currentTimeMillis;
                            duv.O000000o("update top notification: ".concat(String.valueOf(str2)));
                            a2.a(i2, notification2);
                        }
                        i4 = min;
                    }
                    if (i4 > 0) {
                        duv.O000000o("schedule top notification next update delay: ".concat(String.valueOf(i4)));
                        elo.O000000o(context).O000000o(b(i, str2));
                        elo.O000000o(context).O000000o(a(context2, str, i2, str3, (Notification) null), i4);
                        return;
                    }
                    String a3 = an.a(a2);
                    Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context2, notification2);
                    recoverBuilder.setChannelId(a3);
                    recoverBuilder.setPriority(0);
                    duv.O000000o("update top notification to common: ".concat(String.valueOf(str2)));
                    a2.a(i2, recoverBuilder.build());
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    static boolean m152b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m154b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        duv.O000000o("meta extra is null");
        return false;
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            duv.O00000o0("priority=".concat(String.valueOf(str)));
            return Integer.parseInt(str);
        } catch (Exception e) {
            duv.O00000o("parsing notification priority error: ".concat(String.valueOf(e)));
            return 0;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private static boolean m155c(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_top_repeat");
            if (!TextUtils.isEmpty(str)) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                duv.O00000o0("top notification' repeat is ".concat(String.valueOf(parseBoolean)));
                return parseBoolean;
            }
        }
        return true;
    }

    private static int d(Map<String, String> map) {
        int i;
        if (map != null) {
            String str = map.get("notification_top_frequency");
            if (!TextUtils.isEmpty(str)) {
                try {
                    duv.O00000o0("fre of top notification is ".concat(String.valueOf(str)));
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    duv.O00000o("parsing top notification frequency error: ".concat(String.valueOf(e)));
                }
                return Math.max(0, i);
            }
        }
        i = 0;
        return Math.max(0, i);
    }

    private static int e(Map<String, String> map) {
        int i;
        if (map != null) {
            String str = map.get("notification_top_period");
            if (!TextUtils.isEmpty(str)) {
                try {
                    duv.O00000o0("prd of top notification is ".concat(String.valueOf(str)));
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    duv.O00000o("parsing top notification period error: ".concat(String.valueOf(e)));
                }
                return Math.max(0, i);
            }
        }
        i = 0;
        return Math.max(0, i);
    }

    public static boolean e(il ilVar) {
        return m149a(ilVar) || c(ilVar) || m153b(ilVar);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.am.a(android.content.Context, int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):boolean
     arg types: [android.content.Context, int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>]
     candidates:
      com.xiaomi.push.service.am.a(android.content.Context, int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):com.xiaomi.push.ex
      com.xiaomi.push.service.am.a(com.xiaomi.push.il, java.util.Map<java.lang.String, java.lang.String>, int, android.app.Notification):void
      com.xiaomi.push.service.am.a(android.content.Context, int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):android.widget.RemoteViews
     arg types: [android.content.Context, com.xiaomi.push.il, byte[]]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.lang.String):int
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, boolean):android.graphics.Bitmap
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):com.xiaomi.push.service.af$c
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int):void
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):android.widget.RemoteViews */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):int
     arg types: [android.content.Context, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.b(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean
     arg types: [android.content.Context, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.af.b(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):int
     arg types: [android.content.Context, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, int):android.graphics.Bitmap
      com.xiaomi.push.service.af.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.a(java.util.Map<java.lang.String, java.lang.String>, int):java.lang.String
      com.xiaomi.push.service.af.a(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.af.a(android.content.Context, java.util.LinkedList<? extends java.lang.Object>):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):boolean
      com.xiaomi.push.service.af.a(java.lang.String, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.ic):java.lang.String[]
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):void
     arg types: [android.app.Notification, java.lang.String]
     candidates:
      com.xiaomi.push.service.as.a(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):T
      com.xiaomi.push.service.as.a(android.app.Notification, int):void
      com.xiaomi.push.service.as.a(android.app.Notification, boolean):void
      com.xiaomi.push.service.as.a(android.content.Context, android.content.Intent):void
      com.xiaomi.push.service.as.a(android.app.Notification$Builder, boolean):boolean
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.elo.O000000o(_m_j.elo$O000000o, int):boolean
     arg types: [com.xiaomi.push.service.ag, int]
     candidates:
      _m_j.elo.O000000o(java.lang.Runnable, int):void
      _m_j.elo.O000000o(_m_j.elo$O000000o, int):boolean */
    /* renamed from: a  reason: collision with other method in class */
    public static c m146a(Context context, il ilVar, byte[] bArr) {
        Map<String, String> map;
        int i;
        Notification notification;
        String str;
        String str2;
        String str3;
        Context context2 = context;
        il ilVar2 = ilVar;
        c cVar = new c();
        g.a O000000o2 = g.O000000o(context2, a(ilVar), true);
        ic icVar = ilVar2.f122a;
        if (icVar != null) {
            i = icVar.c;
            map = icVar.f86a;
        } else {
            map = null;
            i = 0;
        }
        String a2 = a(ilVar);
        int hashCode = !TextUtils.isEmpty(a2) ? ((a2.hashCode() / 10) * 10) + i : i;
        if (esl.O000000o(context) && O000000o2 == g.a.c) {
            if (icVar != null) {
                epj.O000000o(context.getApplicationContext()).O000000o(ilVar2.b, b(ilVar), icVar.f84a, "10:" + a(ilVar));
            }
            duv.O000000o("Do not notify because user block " + a(ilVar) + "‘s notification");
            return cVar;
        } else if (!esl.O000000o(context) || f233a == null || !f233a.m156a(context2, hashCode, a(ilVar), map)) {
            RemoteViews a3 = a(context, ilVar, bArr);
            PendingIntent a4 = a(context2, ilVar2, ilVar2.b, bArr, hashCode);
            if (a4 == null) {
                if (icVar != null) {
                    epj.O000000o(context.getApplicationContext()).O000000o(ilVar2.b, b(ilVar), icVar.f84a, "11");
                }
                duv.O000000o("The click PendingIntent is null. ");
                return cVar;
            }
            if (Build.VERSION.SDK_INT >= 11) {
                b a5 = a(context, ilVar, bArr, a3, a4, hashCode);
                cVar.f6492a = a5.f6491a;
                cVar.f239a = a(ilVar);
                notification = a5.f238a;
            } else {
                notification = new Notification(b(context2, a(ilVar)), null, System.currentTimeMillis());
                String[] a6 = a(context2, icVar);
                try {
                    notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context2, a6[0], a6[1], a4);
                } catch (NoSuchMethodException e) {
                    if (icVar != null) {
                        epj.O000000o(context.getApplicationContext()).O00000Oo(ilVar2.b, b(ilVar), icVar.f84a, "4");
                    }
                    duv.O00000o("meet no such method error. ".concat(String.valueOf(e)));
                } catch (IllegalAccessException e2) {
                    if (icVar != null) {
                        epj.O000000o(context.getApplicationContext()).O00000Oo(ilVar2.b, b(ilVar), icVar.f84a, "5");
                    }
                    duv.O00000o("meet illegal access error. ".concat(String.valueOf(e2)));
                } catch (IllegalArgumentException e3) {
                    if (icVar != null) {
                        epj.O000000o(context.getApplicationContext()).O00000Oo(ilVar2.b, b(ilVar), icVar.f84a, "6");
                    }
                    duv.O00000o("meet illegal argument error. ".concat(String.valueOf(e3)));
                } catch (InvocationTargetException e4) {
                    if (icVar != null) {
                        epj.O000000o(context.getApplicationContext()).O00000Oo(ilVar2.b, b(ilVar), icVar.f84a, "7");
                    }
                    duv.O00000o("meet invocation target error. ".concat(String.valueOf(e4)));
                }
                Map<String, String> map2 = icVar.f86a;
                if (map2 != null && map2.containsKey("ticker")) {
                    notification.tickerText = map2.get("ticker");
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f6489a > 10000) {
                    f6489a = currentTimeMillis;
                    int i2 = icVar.f6409a;
                    if (m152b(context2, a(ilVar))) {
                        i2 = a(context2, a(ilVar));
                    }
                    notification.defaults = i2;
                    if (!(map2 == null || (i2 & 1) == 0)) {
                        String str4 = map2.get("sound_uri");
                        if (!TextUtils.isEmpty(str4)) {
                            if (str4.startsWith("android.resource://" + a(ilVar))) {
                                notification.defaults = i2 ^ 1;
                                notification.sound = Uri.parse(str4);
                            }
                        }
                    }
                }
                notification.flags |= 16;
                if (a3 != null) {
                    notification.contentView = a3;
                }
            }
            if (esl.O000000o() && Build.VERSION.SDK_INT >= 19) {
                if (!TextUtils.isEmpty(icVar.f84a)) {
                    notification.extras.putString("message_id", icVar.f84a);
                }
                notification.extras.putString("local_paid", ilVar2.f124a);
                as.a(map, notification.extras, "msg_busi_type");
                as.a(map, notification.extras, "disable_notification_flags");
                if (icVar.f89b == null) {
                    str3 = null;
                } else {
                    str3 = icVar.f89b.get("score_info");
                }
                if (!TextUtils.isEmpty(str3)) {
                    notification.extras.putString("score_info", str3);
                }
                notification.extras.putString("pushUid", a(icVar.f86a, "n_stats_expose"));
                int i3 = -1;
                if (c(ilVar)) {
                    i3 = 1000;
                } else if (m149a(ilVar)) {
                    i3 = 3000;
                }
                notification.extras.putString("eventMessageType", String.valueOf(i3));
                notification.extras.putString("target_package", a(ilVar));
            }
            if (icVar.f86a == null) {
                str = null;
            } else {
                str = icVar.f86a.get("message_count");
            }
            if (esl.O000000o() && str != null) {
                try {
                    as.a(notification, Integer.parseInt(str));
                } catch (NumberFormatException e5) {
                    if (icVar != null) {
                        epj.O000000o(context.getApplicationContext()).O00000Oo(ilVar2.b, b(ilVar), icVar.f84a, "8");
                    }
                    duv.O00000o("fail to set message count. ".concat(String.valueOf(e5)));
                }
            }
            String a7 = a(ilVar);
            if (!esl.O00000o() && esl.O000000o(context)) {
                as.m172a(notification, a7);
            }
            ar a8 = ar.a(context2, a7);
            if (esl.O000000o(context) && f233a != null) {
                f233a.a(ilVar2, icVar.f86a, hashCode, notification);
            }
            if (!esl.O000000o(context) || f233a == null || !f233a.a(icVar.f86a, hashCode, notification)) {
                a8.a(hashCode, notification);
                cVar.f240a = true;
            } else {
                duv.O00000Oo("consume this notificaiton by agent");
            }
            if (esl.O000000o() && esl.O000000o(context)) {
                ao.a().a(context2, hashCode, notification);
                if (Build.VERSION.SDK_INT >= 26 && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
                    b(context2, a7, hashCode, icVar.f84a, notification);
                }
            }
            if (m149a(ilVar)) {
                epj.O000000o(context.getApplicationContext()).O000000o(ilVar2.b, b(ilVar), icVar.f84a, 3002, null);
            }
            if (c(ilVar)) {
                epj.O000000o(context.getApplicationContext()).O000000o(ilVar2.b, b(ilVar), icVar.f84a, 1002, null);
            }
            if (Build.VERSION.SDK_INT < 26) {
                if (icVar != null) {
                    str2 = icVar.f84a;
                } else {
                    str2 = null;
                }
                elo O000000o3 = elo.O000000o(context);
                int a9 = a(icVar.f86a);
                if (a9 > 0 && !TextUtils.isEmpty(str2)) {
                    String concat = "n_timeout_".concat(String.valueOf(str2));
                    O000000o3.O000000o(concat);
                    O000000o3.O000000o((elo.O000000o) new ag(concat, a8, hashCode), a9);
                }
            }
            Pair pair = new Pair(Integer.valueOf(hashCode), ilVar2);
            synchronized (f234a) {
                f234a.add(pair);
                if (f234a.size() > 100) {
                    f234a.remove();
                }
            }
            return cVar;
        } else {
            if (icVar != null) {
                epj.O000000o(context.getApplicationContext()).O000000o(ilVar2.b, b(ilVar), icVar.f84a, "14:" + a(ilVar));
            }
            duv.O000000o("Do not notify because card notification is canceled or sequence incorrect");
            return cVar;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    private static PendingIntent a(Context context, il ilVar, String str, byte[] bArr, int i, int i2, boolean z) {
        Intent intent;
        Context context2 = context;
        byte[] bArr2 = bArr;
        int i3 = c(ilVar) ? 1000 : m149a(ilVar) ? 3000 : -1;
        ic icVar = ilVar.f122a;
        String str2 = icVar != null ? icVar.f84a : "";
        boolean a2 = m149a(ilVar);
        if (icVar == null || TextUtils.isEmpty(icVar.e)) {
            if (a2) {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent2.putExtra("mipush_payload", bArr2);
                intent2.putExtra("mipush_notified", true);
                intent2.addCategory(String.valueOf(i));
                intent2.addCategory(String.valueOf(str2));
                intent = intent2;
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent.putExtra("mipush_payload", bArr2);
                intent.putExtra("mipush_notified", true);
                intent.addCategory(String.valueOf(i));
                intent.addCategory(String.valueOf(str2));
            }
            intent.putExtra("notification_click_button", i2);
            intent.putExtra("messageId", str2);
            intent.putExtra("eventMessageType", i3);
            if (a2 || !z) {
                a(context, intent, ilVar, icVar, str2, i2);
                return PendingIntent.getService(context2, 0, intent, 134217728);
            }
            Intent intent3 = new Intent();
            intent3.setComponent(a(str));
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.addCategory(String.valueOf(i));
            intent3.addCategory(String.valueOf(str2));
            intent3.addCategory(String.valueOf(i2));
            a(context, intent3, ilVar, icVar, str2, i2);
            a(intent3);
            return PendingIntent.getActivity(context2, 0, intent3, 134217728);
        }
        Intent intent4 = new Intent("android.intent.action.VIEW");
        intent4.setData(Uri.parse(icVar.e));
        intent4.addFlags(268435456);
        intent4.putExtra("messageId", str2);
        intent4.putExtra("eventMessageType", i3);
        return PendingIntent.getActivity(context2, 0, intent4, 134217728);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):int
     arg types: [android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):android.content.Intent
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, int):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):int */
    private static void a(Context context, Intent intent, il ilVar, ic icVar, String str, int i) {
        if (ilVar != null && icVar != null && !TextUtils.isEmpty(str)) {
            String a2 = a(icVar.f86a, i);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if (bd.f6521a.equals(a2) || bd.b.equals(a2) || bd.c.equals(a2)) {
                intent.putExtra("messageId", str);
                intent.putExtra("local_paid", ilVar.f124a);
                if (!TextUtils.isEmpty(ilVar.b)) {
                    intent.putExtra("target_package", ilVar.b);
                }
                intent.putExtra("job_key", a(icVar.f86a, "jobkey"));
                intent.putExtra(i + "_target_component", a(context, ilVar.b, icVar.f86a, i));
            }
        }
    }

    private static boolean a(Context context, il ilVar, String str) {
        if (ilVar == null || ilVar.f122a == null || ilVar.f122a.f86a == null || TextUtils.isEmpty(str)) {
            duv.O000000o("should clicked activity params are null.");
            return false;
        } else if (!Boolean.parseBoolean(ilVar.f122a.f86a.get("use_clicked_activity")) || !h.a(context, a(str))) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0048, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x006c;
     */
    private static String[] a(Context context, ic icVar) {
        String str;
        String str2 = icVar.f90c;
        String str3 = icVar.d;
        Map<String, String> map = icVar.f86a;
        if (map != null) {
            int intValue = Float.valueOf((((float) context.getResources().getDisplayMetrics().widthPixels) / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str4 = map.get("title_short");
                if (!TextUtils.isEmpty(str4)) {
                    str2 = str4;
                }
                str = map.get("description_short");
            } else if (intValue > 360) {
                String str5 = map.get("title_long");
                if (!TextUtils.isEmpty(str5)) {
                    str2 = str5;
                }
                str = map.get("description_long");
            }
            str3 = str;
        }
        return new String[]{str2, str3};
    }

    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):int
     arg types: [android.content.Context, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.b(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, boolean):android.graphics.Bitmap
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.lang.String):int
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):android.widget.RemoteViews
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):com.xiaomi.push.service.af$c
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int):void
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, boolean):android.graphics.Bitmap */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [com.xiaomi.push.ex, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.aq.a(android.content.Context, java.lang.String, boolean):com.xiaomi.push.service.aq$b
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      com.xiaomi.push.service.aq.a(android.content.Context, byte[], java.lang.String):void
      com.xiaomi.push.service.aq.a(android.content.Context, java.lang.String, boolean):com.xiaomi.push.service.aq$b */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean
     arg types: [android.content.Context, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.af.b(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.af.b(android.content.Context, java.lang.String):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):int
     arg types: [android.content.Context, java.lang.String]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, int):android.graphics.Bitmap
      com.xiaomi.push.service.af.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.a(java.util.Map<java.lang.String, java.lang.String>, int):java.lang.String
      com.xiaomi.push.service.af.a(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.af.a(android.content.Context, java.util.LinkedList<? extends java.lang.Object>):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):boolean
      com.xiaomi.push.service.af.a(java.lang.String, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.ic):java.lang.String[]
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.as.a(android.app.Notification, boolean):void
     arg types: [android.app.Notification, int]
     candidates:
      com.xiaomi.push.service.as.a(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):T
      com.xiaomi.push.service.as.a(android.app.Notification, int):void
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):void
      com.xiaomi.push.service.as.a(android.content.Context, android.content.Intent):void
      com.xiaomi.push.service.as.a(android.app.Notification$Builder, boolean):boolean
      com.xiaomi.push.service.as.a(android.app.Notification, boolean):void */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r13v22, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x026e  */
    @SuppressLint({"NewApi"})
    private static b a(Context context, il ilVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i) {
        ex exVar;
        boolean z;
        Bitmap a2;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        long currentTimeMillis;
        boolean z5;
        int i2;
        String str2;
        boolean z6;
        Notification notification;
        String str3;
        Bitmap bitmap;
        ? r13;
        Bitmap bitmap2;
        StringBuilder sb;
        String str4;
        boolean z7;
        int a3;
        Context context2 = context;
        il ilVar2 = ilVar;
        RemoteViews remoteViews2 = remoteViews;
        b bVar = new b();
        ic icVar = ilVar2.f122a;
        String a4 = a(ilVar);
        Map<String, String> map = icVar.f86a;
        String[] a5 = a(context2, icVar);
        if (remoteViews2 != null) {
            ex exVar2 = new ex(context2);
            exVar2.setCustomContentView(remoteViews2);
            exVar = exVar2;
        } else {
            exVar = (map == null || !map.containsKey("notification_style_type")) ? new ex(context2) : a(context2, ilVar2, bArr, a5[1], i);
        }
        ex exVar3 = exVar;
        a(exVar, context, ilVar2.b, ilVar, bArr, i);
        exVar3.setContentTitle(a5[0]);
        exVar3.setContentText(a5[1]);
        long currentTimeMillis2 = System.currentTimeMillis();
        exVar3.setWhen(currentTimeMillis2);
        String a6 = a(map, "notification_show_when");
        if (!TextUtils.isEmpty(a6)) {
            exVar3.setShowWhen(Boolean.parseBoolean(a6));
        } else if (Build.VERSION.SDK_INT >= 24) {
            exVar3.setShowWhen(true);
        }
        exVar3.setContentIntent(pendingIntent);
        int a7 = a(context2, a4, "mipush_notification");
        int a8 = a(context2, a4, "mipush_small_notification");
        if (a7 <= 0 || a8 <= 0) {
            if (!esl.O000000o(context)) {
                String a9 = a(map, "fcm_icon_uri");
                String a10 = a(map, "fcm_icon_color");
                if (!TextUtils.isEmpty(a9) && !TextUtils.isEmpty(a10) && (a3 = a(context2, a4, a9)) > 0) {
                    exVar3.setSmallIcon(a3);
                    exVar3.O000000o(a10);
                    z7 = true;
                    if (!z7) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            exVar3.setSmallIcon(Icon.createWithResource(a4, as.a(context2, a4)));
                        } else {
                            exVar3.setSmallIcon(b(context2, a4));
                        }
                    }
                }
            }
            z7 = false;
            if (!z7) {
            }
        } else {
            exVar3.setLargeIcon(a(context2, a7));
            exVar3.setSmallIcon(a8);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (map == null) {
                bitmap2 = null;
                r13 = 1;
            } else {
                r13 = 1;
                bitmap2 = a(context2, map.get("notification_small_icon_uri"), true);
            }
            if (bitmap2 != null) {
                Object[] objArr = new Object[r13];
                objArr[0] = bitmap2;
                Object O000000o2 = emg.O000000o("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                if (O000000o2 != null) {
                    Object[] objArr2 = new Object[r13];
                    objArr2[0] = O000000o2;
                    emg.O000000o((Object) exVar3, "setSmallIcon", objArr2);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", r13);
                    exVar3.addExtras(bundle);
                    exVar3.O000000o(a(map, "notification_small_icon_color"));
                } else {
                    sb = new StringBuilder("failed te get small icon with url:");
                    str4 = map.get("notification_small_icon_uri");
                }
            } else {
                sb = new StringBuilder("failed to get small icon url:");
                str4 = a(map, "notification_small_icon_uri");
            }
            sb.append(str4);
            duv.O000000o(sb.toString());
            exVar3.O000000o(a(map, "notification_small_icon_color"));
        }
        String a11 = a(map, "__dynamic_icon_uri");
        boolean z8 = Boolean.parseBoolean(a(map, "__adiom")) || !esl.O000000o();
        if (!TextUtils.isEmpty(a11) && z8) {
            if (a11.startsWith("http")) {
                aq.b a12 = aq.a(context2, a11, true);
                if (a12 != null) {
                    bitmap = a12.f254a;
                    bVar.f6491a = a12.f6504a;
                } else {
                    bitmap = null;
                }
            } else {
                bitmap = aq.a(context2, a11);
            }
            if (bitmap != null) {
                exVar3.setLargeIcon(bitmap);
                z = true;
                a2 = map != null ? null : a(context2, map.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    exVar3.setLargeIcon(a2);
                }
                if (map != null || Build.VERSION.SDK_INT < 24) {
                    z4 = true;
                    z3 = false;
                    z2 = false;
                    str = null;
                } else {
                    String str5 = map.get("notification_group");
                    z3 = Boolean.parseBoolean(map.get("notification_is_summary"));
                    boolean parseBoolean = Boolean.parseBoolean(map.get("notification_group_disable_default"));
                    if (TextUtils.isEmpty(str5) && (esl.O000000o() || !parseBoolean)) {
                        str5 = a(ilVar);
                    }
                    String str6 = str5;
                    emg.O000000o((Object) exVar3, "setGroupSummary", Boolean.valueOf(z3));
                    String str7 = map.get("notification_style_type");
                    if (!"com.xiaomi.xmsf".equals(context.getPackageName()) || (!"4".equals(str7) && !"3".equals(str7))) {
                        str = str6;
                        z4 = true;
                        z2 = false;
                    } else {
                        str = a(ilVar) + "_custom_" + currentTimeMillis2;
                        z4 = true;
                        z2 = true;
                    }
                }
                exVar3.setAutoCancel(z4);
                currentTimeMillis = System.currentTimeMillis();
                if (map != null && map.containsKey("ticker")) {
                    exVar3.setTicker(map.get("ticker"));
                }
                b bVar2 = bVar;
                if (currentTimeMillis - f6489a <= 10000) {
                    f6489a = currentTimeMillis;
                    i2 = icVar.f6409a;
                    if (m152b(context2, a4)) {
                        i2 = a(context2, a4);
                    }
                    exVar3.setDefaults(i2);
                    if (!(map == null || (i2 & 1) == 0)) {
                        String str8 = map.get("sound_uri");
                        if (!TextUtils.isEmpty(str8)) {
                            z5 = z;
                            if (str8.startsWith("android.resource://".concat(String.valueOf(a4)))) {
                                exVar3.setDefaults(i2 ^ 1);
                                exVar3.setSound(Uri.parse(str8));
                            }
                        }
                    }
                    z5 = z;
                } else {
                    z5 = z;
                    i2 = -100;
                }
                if (map != null || Build.VERSION.SDK_INT < 26) {
                    z6 = z2;
                    str2 = str;
                    if (map != null && Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 26) {
                        emg.O000000o((Object) exVar3, "setPriority", Integer.valueOf(c(map)));
                    }
                } else {
                    ar a13 = ar.a(context2, a4);
                    int a14 = a(map);
                    if (a14 > 0) {
                        z6 = z2;
                        str2 = str;
                        emg.O000000o((Object) exVar3, "setTimeoutAfter", Long.valueOf((long) (a14 * 1000)));
                    } else {
                        z6 = z2;
                        str2 = str;
                    }
                    String str9 = map.get("channel_id");
                    if (!TextUtils.isEmpty(str9) || context.getApplicationInfo().targetSdkVersion >= 26) {
                        String a15 = a(context2, a4, map);
                        int b2 = b(map);
                        int i3 = icVar.f6409a;
                        String str10 = map.get("channel_description");
                        String str11 = map.get("sound_uri");
                        if (b2 >= 4 && esl.O000000o(context) && m155c(map)) {
                            int e = e(map);
                            if (e == 0) {
                                duv.O00000o("meet prd of top notification is zero.");
                                str3 = an.a(a13);
                                if (str3 == null) {
                                    str3 = an.a(a13, str9, a15, str10, i3, b2, str11);
                                }
                                emg.O000000o((Object) exVar3, "setChannelId", str3);
                                if (i2 == -100 && as.a(map)) {
                                    as.a(exVar3, z3);
                                }
                                if ("pulldown".equals(as.a((Object) map)) && as.a(map) && Objects.equals(map.get("pull_down_pop_type"), "0")) {
                                    as.a(exVar3, z3);
                                }
                                if ("tts".equals(as.a((Object) map)) && as.a(map)) {
                                    as.a(exVar3, z3);
                                }
                            } else {
                                exVar3.setPriority(2);
                                int d = d(map);
                                Bundle bundle2 = new Bundle();
                                bundle2.putLong("mipush_org_when", currentTimeMillis2);
                                bundle2.putBoolean("mipush_n_top_flag", true);
                                if (d > 0 && d <= e) {
                                    bundle2.putInt("mipush_n_top_fre", d);
                                }
                                if (e > 0 && d <= e) {
                                    bundle2.putInt("mipush_n_top_prd", e);
                                }
                                exVar3.addExtras(bundle2);
                            }
                        }
                        str3 = null;
                        if (str3 == null) {
                        }
                        emg.O000000o((Object) exVar3, "setChannelId", str3);
                        as.a(exVar3, z3);
                        as.a(exVar3, z3);
                        as.a(exVar3, z3);
                    }
                    String str12 = map.get("background_color");
                    if (!TextUtils.isEmpty(str12)) {
                        try {
                            int parseInt = Integer.parseInt(str12);
                            exVar3.setOngoing(true);
                            exVar3.setColor(parseInt);
                            emg.O000000o((Object) exVar3, "setColorized", Boolean.TRUE);
                        } catch (Exception e2) {
                            duv.O000000o(e2);
                        }
                    }
                }
                if (str2 != null) {
                    emg.O000000o((Object) exVar3, "setGroup", !z6 ? ao.a().a(context2, exVar3, str2) : str2);
                }
                if (esl.O00000o() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    emg.O000000o("miui.util.NotificationHelper", "setTargetPkg", context2, exVar3, a(ilVar));
                }
                notification = exVar3.getNotification();
                if (z5 && esl.O000000o()) {
                    a(notification);
                }
                if (map != null) {
                    if (notification.extras == null) {
                        notification.extras = new Bundle();
                    }
                    if (!TextUtils.isEmpty(map.get("enable_keyguard"))) {
                        as.b(notification, Boolean.parseBoolean(map.get("enable_keyguard")));
                    }
                    if (!TextUtils.isEmpty(map.get("enable_float"))) {
                        as.a(notification, Boolean.parseBoolean(map.get("enable_float")));
                    }
                    if (!TextUtils.isEmpty(map.get("float_small_win")) && "0".equals(map.get("float_small_win")) && g.O0000OOo(context2, a4)) {
                        as.a(notification, false);
                    }
                    int O000000o3 = esv.O000000o(map.get("section_is_prr"));
                    int O000000o4 = esv.O000000o(map.get("section_prr_cl"));
                    if (O000000o3 >= 0 && O000000o4 >= 0) {
                        as.a(notification, O000000o3, O000000o4);
                    }
                }
                b bVar3 = bVar2;
                bVar3.f238a = notification;
                return bVar3;
            }
        }
        z = false;
        if (map != null) {
        }
        if (a2 != null) {
        }
        if (map != null) {
        }
        z4 = true;
        z3 = false;
        z2 = false;
        str = null;
        exVar3.setAutoCancel(z4);
        currentTimeMillis = System.currentTimeMillis();
        exVar3.setTicker(map.get("ticker"));
        b bVar22 = bVar;
        if (currentTimeMillis - f6489a <= 10000) {
        }
        if (map != null) {
        }
        z6 = z2;
        str2 = str;
        emg.O000000o((Object) exVar3, "setPriority", Integer.valueOf(c(map)));
        if (str2 != null) {
        }
        emg.O000000o("miui.util.NotificationHelper", "setTargetPkg", context2, exVar3, a(ilVar));
        notification = exVar3.getNotification();
        a(notification);
        if (map != null) {
        }
        b bVar32 = bVar22;
        bVar32.f238a = notification;
        return bVar32;
    }

    @TargetApi(16)
    private static void a(ex exVar, Context context, String str, il ilVar, byte[] bArr, int i) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Map<String, String> map = ilVar.f122a.f86a;
        if (!TextUtils.equals("3", map.get("notification_style_type")) && !TextUtils.equals("4", map.get("notification_style_type"))) {
            if (m154b(map)) {
                for (int i2 = 1; i2 <= 3; i2++) {
                    String str2 = map.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                    if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, ilVar, bArr, i, i2)) != null) {
                        exVar.addAction(0, str2, a5);
                    }
                }
                return;
            }
            if (!TextUtils.isEmpty(map.get("notification_style_button_left_name")) && (a4 = a(context, str, ilVar, bArr, i, 1)) != null) {
                exVar.addAction(0, map.get("notification_style_button_left_name"), a4);
            }
            if (!TextUtils.isEmpty(map.get("notification_style_button_mid_name")) && (a3 = a(context, str, ilVar, bArr, i, 2)) != null) {
                exVar.addAction(0, map.get("notification_style_button_mid_name"), a3);
            }
            if (!TextUtils.isEmpty(map.get("notification_style_button_right_name")) && (a2 = a(context, str, ilVar, bArr, i, 3)) != null) {
                exVar.addAction(0, map.get("notification_style_button_right_name"), a2);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):android.content.Intent
     arg types: [android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):int
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, int):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, int):android.content.Intent */
    private static PendingIntent a(Context context, String str, il ilVar, byte[] bArr, int i, int i2) {
        Map<String, String> map = ilVar.f122a.f86a;
        if (map == null) {
            return null;
        }
        boolean a2 = a(context, ilVar, str);
        if (a2) {
            return a(context, ilVar, str, bArr, i, i2, a2);
        }
        Intent a3 = m145a(context, str, map, i2);
        if (a3 != null) {
            return PendingIntent.getActivity(context, 0, a3, 134217728);
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.am.a(android.content.Context, int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):com.xiaomi.push.ex
     arg types: [android.content.Context, int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>]
     candidates:
      com.xiaomi.push.service.am.a(com.xiaomi.push.il, java.util.Map<java.lang.String, java.lang.String>, int, android.app.Notification):void
      com.xiaomi.push.service.am.a(android.content.Context, int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):boolean
      com.xiaomi.push.service.am.a(android.content.Context, int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):com.xiaomi.push.ex */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, boolean):android.graphics.Bitmap
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.lang.String):int
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):android.widget.RemoteViews
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):com.xiaomi.push.service.af$c
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int):void
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, boolean):android.graphics.Bitmap */
    @TargetApi(16)
    private static ex a(Context context, il ilVar, byte[] bArr, String str, int i) {
        PendingIntent a2;
        String a3 = a(ilVar);
        Map<String, String> map = ilVar.f122a.f86a;
        String str2 = map.get("notification_style_type");
        ex a4 = (!esl.O000000o(context) || f233a == null) ? null : f233a.a(context, i, a3, map);
        if (a4 != null) {
            a4.O000000o(map);
            return a4;
        } else if (Build.VERSION.SDK_INT >= 16 && "2".equals(str2)) {
            ex exVar = new ex(context);
            Bitmap a5 = TextUtils.isEmpty(map.get("notification_bigPic_uri")) ? null : a(context, map.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                duv.O000000o("can not get big picture.");
                return exVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(exVar);
            bigPictureStyle.bigPicture(a5);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            exVar.setStyle(bigPictureStyle);
            return exVar;
        } else if (Build.VERSION.SDK_INT >= 16 && "1".equals(str2)) {
            ex exVar2 = new ex(context);
            exVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return exVar2;
        } else if ("4".equals(str2) && esl.O000000o()) {
            epk epk = new epk(context, a3);
            if (!TextUtils.isEmpty(map.get("notification_banner_image_uri"))) {
                Bitmap a6 = a(context, map.get("notification_banner_image_uri"), false);
                if (epk.O00000oO && a6 != null) {
                    if (a6.getWidth() != 984 || 184 > a6.getHeight() || a6.getHeight() > 1678) {
                        duv.O000000o("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
                    } else {
                        epk.f15702O000000o = a6;
                    }
                }
            }
            if (!TextUtils.isEmpty(map.get("notification_banner_icon_uri"))) {
                Bitmap a7 = a(context, map.get("notification_banner_icon_uri"), false);
                if (epk.O00000oO && a7 != null) {
                    epk.O00000Oo = a7;
                }
            }
            epk.O000000o(map);
            return epk;
        } else if (!"3".equals(str2) || !esl.O000000o()) {
            return new ex(context);
        } else {
            epl epl = new epl(context, i, a3);
            if (!TextUtils.isEmpty(map.get("notification_colorful_button_text")) && (a2 = a(context, a3, ilVar, bArr, i, 4)) != null) {
                epl.O000000o(map.get("notification_colorful_button_text"), a2).O00000Oo(map.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(map.get("notification_colorful_bg_color"))) {
                epl.O00000o0(map.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(map.get("notification_colorful_bg_image_uri"))) {
                Bitmap a8 = a(context, map.get("notification_colorful_bg_image_uri"), false);
                if (epl.O00000oO && a8 != null) {
                    if (a8.getWidth() != 984 || a8.getHeight() < 177 || a8.getHeight() > 207) {
                        duv.O000000o("colorful notification bg image resolution error, must [984*177, 984*207]");
                    } else {
                        epl.f15703O000000o = a8;
                    }
                }
            }
            epl.O000000o(map);
            return epl;
        }
    }

    private static RemoteViews a(Context context, il ilVar, byte[] bArr) {
        ic icVar = ilVar.f122a;
        String a2 = a(ilVar);
        if (!(icVar == null || icVar.f86a == null)) {
            Map<String, String> map = icVar.f86a;
            String str = map.get("layout_name");
            String str2 = map.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a2, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a2);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e) {
                        duv.O000000o(e);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    duv.O000000o(e2);
                }
            }
        }
        return null;
    }

    public static String a(il ilVar) {
        ic icVar;
        if (!(!"com.xiaomi.xmsf".equals(ilVar.b) || (icVar = ilVar.f122a) == null || icVar.f86a == null)) {
            String str = icVar.f86a.get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return ilVar.b;
    }

    private static boolean a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        String str = icVar.f84a;
        return !TextUtils.isEmpty(str) && str.length() == 22 && "satuigmo".indexOf(str.charAt(0)) >= 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m149a(il ilVar) {
        ic icVar = ilVar.f122a;
        return a(icVar) && icVar.f87a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m153b(il ilVar) {
        ic icVar = ilVar.f122a;
        return a(icVar) && icVar.b == 1 && !m149a(ilVar);
    }

    public static boolean c(il ilVar) {
        ic icVar = ilVar.f122a;
        return a(icVar) && icVar.b == 0 && !m149a(ilVar);
    }

    public static boolean d(il ilVar) {
        return ilVar.f6426a == hp.f6389a;
    }
}
