package _m_j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.g;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.bl;
import com.xiaomi.push.service.n;
import com.xiaomi.push.service.o;
import org.json.JSONObject;

public final class eoc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15667O000000o;
    private static Boolean O00000Oo;

    public static String O000000o() {
        return Build.MANUFACTURER + "|" + Build.VERSION.INCREMENTAL;
    }

    public static String O000000o(Context context) {
        if (f15667O000000o == null) {
            String packageName = context.getPackageName();
            String O000000o2 = g.O000000o(context, packageName);
            f15667O000000o = packageName + "|" + O000000o2;
        }
        return f15667O000000o;
    }

    public static String O000000o(String str) {
        try {
            String str2 = str.split("#n")[0];
            return str2.contains("android.os.DeadSystemException") ? "android.os.DeadSystemException" : str2.contains(":") ? str2.substring(0, str2.indexOf(":")) : str2;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int O00000Oo() {
        return Build.VERSION.SDK_INT;
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
    public static boolean O00000Oo(Context context) {
        return at.a(context).a(hu.bq.a(), true);
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String contains : enx.O0000o00) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.erv.O000000o(android.content.Context, boolean):java.lang.String
     arg types: [android.content.Context, int]
     candidates:
      _m_j.erv.O000000o(android.content.Context, java.lang.String):void
      _m_j.erv.O000000o(android.content.Context, java.util.Map<java.lang.String, java.lang.String>):void
      _m_j.erv.O000000o(android.content.Context, boolean):java.lang.String */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[RETURN] */
    public static String O00000o0(Context context) {
        String str;
        JSONObject jSONObject;
        n a2 = o.m222a(context);
        if (a2 != null && !TextUtils.isEmpty(a2.f341a)) {
            String[] split = a2.f341a.split("@");
            if (split.length > 0) {
                str = "@-" + split[0];
                if (TextUtils.isEmpty(str)) {
                    str = erv.O000000o(context, true);
                }
                jSONObject = new JSONObject();
                jSONObject.put("uniqueId", str);
                if (jSONObject.length() <= 0) {
                    return bl.a(jSONObject.toString());
                }
                return null;
            }
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
        } catch (Exception unused) {
        }
        if (jSONObject.length() <= 0) {
        }
    }

    public static String O00000o0(String str) {
        try {
            String[] split = str.replaceAll("\\t", "").split("\\n");
            StringBuilder sb = new StringBuilder();
            int length = split.length;
            for (int i = 0; i < length; i++) {
                split[i] = split[i].replaceAll("((java:)|(length=)|(index=)|(Index:)|(Size:))\\d+", "$1XX").replaceAll("\\$[0-9a-fA-F]{1,10}@[0-9a-fA-F]{1,10}|@[0-9a-fA-F]{1,10}|0x[0-9a-fA-F]{1,10}", "XX");
                sb.append(split[i]);
                sb.append("#n");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean O00000o0() {
        if (O00000Oo == null) {
            O00000Oo = Boolean.valueOf(!esl.O00000oo());
        }
        return O00000Oo.booleanValue();
    }
}
