package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.emg;
import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.push.g;
import java.util.Arrays;
import java.util.Map;

public class as {

    /* renamed from: a  reason: collision with root package name */
    public static final Pair<String, String> f6506a = new Pair<>("canShowBadge", "canShowBadge");

    /* renamed from: a  reason: collision with other field name */
    private static String f259a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f260a = {"com.mi.globalbrowser", "com.android.browser"};
    public static final Pair<String, String> b = new Pair<>("canFloat", "canShowFloat");
    public static final Pair<String, String> c = new Pair<>("canShowOnKeyguard", "canShowOnKeyguard");
    public static final Pair<String, String> d = new Pair<>("canSound", "canSound");
    public static final Pair<String, String> e = new Pair<>("canVibrate", "canVibrate");
    public static final Pair<String, String> f = new Pair<>("canLights", "canLights");

    public static int a(ContentResolver contentResolver) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
            } catch (Exception e2) {
                duv.O000000o("get user aggregate failed, ".concat(String.valueOf(e2)));
            }
        }
        return 0;
    }

    static int a(Context context, String str) {
        return g.O00000oo(context, str);
    }

    public static <T> T a(Notification notification, String str) {
        if (Build.VERSION.SDK_INT < 19 || notification.extras == null) {
            return null;
        }
        try {
            return notification.extras.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):T
     arg types: [android.app.Notification, java.lang.String]
     candidates:
      com.xiaomi.push.service.as.a(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.as.a(android.app.Notification, int):void
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):void
      com.xiaomi.push.service.as.a(android.app.Notification, boolean):void
      com.xiaomi.push.service.as.a(android.content.Context, android.content.Intent):void
      com.xiaomi.push.service.as.a(android.app.Notification$Builder, boolean):boolean
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):T */
    public static <T> T a(Object obj, String str, Object obj2) {
        T t;
        try {
            if (obj instanceof Notification) {
                t = a((Notification) obj, str);
            } else if (obj instanceof Map) {
                t = ((Map) obj).get(str);
            } else if (obj instanceof Bundle) {
                t = ((Bundle) obj).get(str);
            } else {
                duv.O000000o("not support get value from classType:".concat(String.valueOf(obj)));
                t = null;
            }
        } catch (Exception e2) {
            duv.O000000o("get value error ".concat(String.valueOf(e2)));
        }
        return t == null ? obj2 : t;
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT < 19 || notification.extras == null) {
            charSequence = null;
        } else {
            charSequence = notification.extras.getCharSequence("android.title");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.title.big");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    static void a(Notification notification, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putInt("miui.messageCount", i);
            }
            Object O000000o2 = emg.O000000o(notification, "extraNotification");
            if (O000000o2 != null) {
                emg.O000000o(O000000o2, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    static void a(Notification notification, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 19 && notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m172a(Notification notification, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putString("target_package", str);
            }
            Object O000000o2 = emg.O000000o(notification, "extraNotification");
            if (O000000o2 != null) {
                emg.O000000o(O000000o2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    static void a(Notification notification, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putBoolean("miui.enableFloat", z);
            }
            Object O000000o2 = emg.O000000o(notification, "extraNotification");
            if (O000000o2 != null) {
                emg.O000000o(O000000o2, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    static void a(Context context, Intent intent) {
        String str;
        int i = -1;
        while (true) {
            str = i < 0 ? f259a : f260a[i];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        break;
                    }
                } catch (Exception e2) {
                    duv.O000000o("not found xm browser:".concat(String.valueOf(e2)));
                }
            }
            i++;
            if (i >= f260a.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        f259a = str;
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            duv.O000000o("cp map to b fail:".concat(String.valueOf(str)));
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        duv.O00000Oo("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m173a(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a(map, "not_suppress", "true"));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Notification.Action[] m174a(Notification notification) {
        Parcelable[] parcelableArray;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        if (notification.actions != null) {
            return notification.actions;
        }
        if (notification.extras == null || (parcelableArray = notification.extras.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT < 19 || notification.extras == null) {
            charSequence = null;
        } else {
            charSequence = notification.extras.getCharSequence("android.text");
            if (TextUtils.isEmpty(charSequence) && Build.VERSION.SDK_INT >= 21) {
                charSequence = notification.extras.getCharSequence("android.bigText");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static void b(Notification notification, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putBoolean("miui.enableKeyguard", z);
            }
            Object O000000o2 = emg.O000000o(notification, "extraNotification");
            if (O000000o2 != null) {
                emg.O000000o(O000000o2, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static String c(Notification notification) {
        Object O000000o2;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                str = notification.extras.getString("target_package");
            }
            if (TextUtils.isEmpty(str) && (O000000o2 = emg.O000000o(notification, "extraNotification")) != null) {
                return (String) emg.O000000o(O000000o2, "getTargetPkg", new Object[0]);
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
