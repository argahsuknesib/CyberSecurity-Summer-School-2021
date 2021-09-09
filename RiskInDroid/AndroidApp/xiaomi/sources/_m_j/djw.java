package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class djw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f14732O000000o = "";

    public static void O000000o(String str) {
        f14732O000000o = str;
    }

    public static final int O000000o(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "start");
            jSONObject.put("action", 0);
            jSONObject.put("packageName", str);
            String format = String.format("qqmusicactive://qq.com/aidl?p=%s", URLEncoder.encode(jSONObject.toString(), "utf-8"));
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(format));
            context.startActivity(intent);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static final int O000000o(Context context, String str, String str2, String str3, String str4) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("cmd", "start");
                    jSONObject.put("action", 1);
                    jSONObject.put("appId", str);
                    jSONObject.put("packageName", str2);
                    jSONObject.put("callbackurl", str4);
                    jSONObject.put("encryptString", str3);
                    O00000o0(context, URLEncoder.encode(jSONObject.toString(), "utf-8"));
                    return 0;
                }
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static final Bundle O00000Oo(Context context, String str) {
        Bundle bundle = new Bundle();
        if (context == null) {
            try {
                bundle.putInt("code", 4);
                bundle.putString("error", "context is null");
                return bundle;
            } catch (Exception e) {
                bundle.putInt("code", 1);
                bundle.putString("error", "UnKnow Exception " + e.getMessage());
            }
        } else {
            O00000o0(context, URLEncoder.encode("{\"cmd\":\"login\",\"callbackurl\":\"" + str + "\"}", "utf-8"));
            bundle.putInt("code", 0);
            return bundle;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064  */
    private static void O00000o0(Context context, String str) {
        char c;
        String str2;
        String str3 = f14732O000000o;
        int hashCode = str3.hashCode();
        if (hashCode != 3714) {
            if (hashCode != 98260) {
                if (hashCode != 110739) {
                    if (hashCode == 106642798 && str3.equals("phone")) {
                        c = 0;
                        str2 = c != 0 ? c != 1 ? c != 2 ? c != 3 ? "" : "qqmusicpad" : "qqmusiccar" : "qqmusictv" : "qqmusic";
                        if (!TextUtils.isEmpty(str2)) {
                            String format = String.format("%s://qq.com/other/aidl?p=%s", str2, str);
                            Intent intent = new Intent();
                            intent.addFlags(268435456);
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(Uri.parse(format));
                            context.startActivity(intent);
                            return;
                        }
                        return;
                    }
                } else if (str3.equals("pad")) {
                    c = 3;
                    if (c != 0) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
            } else if (str3.equals(car.f13556O000000o)) {
                c = 2;
                if (c != 0) {
                }
                if (!TextUtils.isEmpty(str2)) {
                }
            }
        } else if (str3.equals("tv")) {
            c = 1;
            if (c != 0) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
    }
}
