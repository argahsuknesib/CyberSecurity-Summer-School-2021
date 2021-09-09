package _m_j;

import _m_j.esv;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.push.il;
import com.xiaomi.push.service.at;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class ebb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashMap<String, String> f15139O000000o = new HashMap<>();

    public static String O000000o(e eVar) {
        int i = ebd.f15141O000000o[eVar.ordinal()];
        if (i == 1) {
            return "hms_push_error";
        }
        if (i == 2) {
            return "fcm_push_error";
        }
        if (i == 3) {
            return "cos_push_error";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    public static void O000000o(Context context, e eVar) {
        String O00000Oo = O00000Oo(eVar);
        if (!TextUtils.isEmpty(O00000Oo)) {
            ess.O000000o(context.getSharedPreferences("mipush_extra", 0).edit().putString(O00000Oo, ""));
        }
    }

    private static synchronized void O000000o(e eVar, String str) {
        synchronized (ebb.class) {
            String O00000Oo = O00000Oo(eVar);
            if (TextUtils.isEmpty(O00000Oo)) {
                duv.O000000o("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                duv.O000000o("ASSEMBLE_PUSH : token is null");
            } else {
                f15139O000000o.put(O00000Oo, str);
            }
        }
    }

    private static String O00000Oo(e eVar) {
        int i = ebd.f15141O000000o[eVar.ordinal()];
        if (i == 1) {
            return "hms_push_token";
        }
        if (i == 2) {
            return "fcm_push_token_v2";
        }
        if (i == 3) {
            return "cos_push_token";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    private static synchronized String O00000Oo(String str) {
        String str2;
        synchronized (ebb.class) {
            str2 = f15139O000000o.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    public static HashMap<String, String> O00000Oo(Context context, e eVar) {
        StringBuilder sb;
        ag agVar;
        HashMap<String, String> hashMap = new HashMap<>();
        String O00000Oo = O00000Oo(eVar);
        if (TextUtils.isEmpty(O00000Oo)) {
            return hashMap;
        }
        int i = ebd.f15141O000000o[eVar.ordinal()];
        ApplicationInfo applicationInfo = null;
        if (i == 1) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            } catch (Exception e) {
                duv.O00000o(e.toString());
            }
            int i2 = -1;
            if (applicationInfo != null) {
                i2 = applicationInfo.metaData.getInt("com.huawei.hms.client.appid");
            }
            applicationInfo = "brand:" + ebg.O000000o(context).name() + "~token:" + O00000Oo(O00000Oo) + "~package_name:" + context.getPackageName() + "~app_id:" + i2;
        } else if (i != 2) {
            if (i == 3) {
                sb = new StringBuilder("brand:");
                agVar = ag.d;
            } else if (i == 4) {
                sb = new StringBuilder("brand:");
                agVar = ag.e;
            }
            sb.append(agVar.name());
            sb.append("~token:");
            sb.append(O00000Oo(O00000Oo));
            sb.append("~package_name:");
            sb.append(context.getPackageName());
            applicationInfo = sb.toString();
        } else {
            applicationInfo = new esv.O000000o(":", "~").O000000o("brand", ag.c.name()).O000000o("token", O00000Oo(O00000Oo)).O000000o("package_name", context.getPackageName()).O000000o("version", 40020).toString();
        }
        hashMap.put("RegInfo", applicationInfo);
        return hashMap;
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
        if (ebe.O000000o() != null) {
            return at.a(context).a(ebe.O000000o().a(), true);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[Catch:{ Exception -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050 A[RETURN] */
    protected static PushMessageReceiver O00000o(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    resolveInfo = it.next();
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
                if (resolveInfo == null) {
                    return (PushMessageReceiver) esu.O000000o(context, resolveInfo.activityInfo.name).newInstance();
                }
                return null;
            }
            resolveInfo = null;
            if (resolveInfo == null) {
            }
        } catch (Exception e) {
            duv.O00000o(e.toString());
            return null;
        }
    }

    public static boolean O00000o0(Context context) {
        if (context == null) {
            return false;
        }
        return emf.O000000o(context);
    }

    public static void O00000oO(Context context) {
        eay.O000000o(context).O000000o();
    }

    public static void O00000oo(Context context) {
        eay.O000000o(context).O00000Oo();
    }

    public static void O000000o(Context context, e eVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            String O00000Oo = O00000Oo(eVar);
            if (TextUtils.isEmpty(O00000Oo)) {
                duv.O000000o("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            boolean z = !TextUtils.equals(b.O000000o(context).O00000Oo.O00000o0, sharedPreferences.getString("last_check_token", ""));
            String string = sharedPreferences.getString(O00000Oo, "");
            if (TextUtils.isEmpty(string) || !str.equals(string) || z) {
                duv.O000000o("ASSEMBLE_PUSH : send token upload, check:".concat(String.valueOf(z)));
                O000000o(eVar, str);
                au O00000Oo2 = ebe.O00000Oo(eVar);
                if (O00000Oo2 != null) {
                    eao.O000000o(context).O000000o((String) null, O00000Oo2, eVar);
                    return;
                }
                return;
            }
            duv.O000000o("ASSEMBLE_PUSH : do not need to send token");
        }
    }

    public static byte[] O000000o(Context context, il ilVar, e eVar) {
        boolean z;
        String str;
        if (ilVar == null || ilVar.f122a == null || ilVar.f122a.f86a == null) {
            z = false;
        } else {
            if (eVar == e.b) {
                str = "FCM";
            } else {
                str = "";
            }
            z = str.equalsIgnoreCase(ilVar.f122a.f86a.get("assemble_push_type"));
        }
        String str2 = null;
        if (!z) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String O00000Oo = O00000Oo(eVar);
        if (!TextUtils.isEmpty(O00000Oo)) {
            str2 = sharedPreferences.getString(O00000Oo, "");
        }
        return emk.O00000o0(str2);
    }

    static void O000000o(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String O00000Oo = O00000Oo(e.f6055a);
        String O00000Oo2 = O00000Oo(e.b);
        if (!TextUtils.isEmpty(sharedPreferences.getString(O00000Oo, "")) && TextUtils.isEmpty(sharedPreferences.getString(O00000Oo2, ""))) {
            z = true;
        }
        if (z) {
            eao O000000o2 = eao.O000000o(context);
            Intent O00000Oo3 = O000000o2.O00000Oo();
            O00000Oo3.setAction("com.xiaomi.mipush.thirdparty");
            O00000Oo3.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", 2);
            O00000Oo3.putExtra("com.xiaomi.mipush.thirdparty_DESC", O00000Oo);
            O000000o2.O00000Oo(O00000Oo3);
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void O00000o(Context context, e eVar, String str) {
        synchronized (ebb.class) {
            String O00000Oo = O00000Oo(eVar);
            if (TextUtils.isEmpty(O00000Oo)) {
                duv.O000000o("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            ess.O000000o(context.getSharedPreferences("mipush_extra", 0).edit().putString(O00000Oo, str).putString("last_check_token", b.O000000o(context).O00000Oo.O00000o0));
            duv.O000000o("ASSEMBLE_PUSH : update sp file success!  ".concat(String.valueOf(str)));
        }
    }

    public static void O00000Oo(Context context, e eVar, String str) {
        elo.O000000o(context).O000000o(new ebc(str, context, eVar), 0);
    }

    public static MiPushMessage O000000o(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = "extra";
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.messageId = jSONObject.getString("messageId");
                }
                if (jSONObject.has("description")) {
                    miPushMessage.description = jSONObject.getString("description");
                }
                if (jSONObject.has("title")) {
                    miPushMessage.title = jSONObject.getString("title");
                }
                if (jSONObject.has("content")) {
                    miPushMessage.content = jSONObject.getString("content");
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.passThrough = jSONObject.getInt("passThrough");
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.notifyType = jSONObject.getInt("notifyType");
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.messageType = jSONObject.getInt("messageType");
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.alias = jSONObject.getString("alias");
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.topic = jSONObject.getString("topic");
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.userAccount = jSONObject.getString("user_account");
                }
                if (jSONObject.has("notifyId")) {
                    miPushMessage.notifyId = jSONObject.getInt("notifyId");
                }
                if (jSONObject.has("category")) {
                    miPushMessage.category = jSONObject.getString("category");
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.isNotified = jSONObject.getBoolean("isNotified");
                }
                String str3 = str2;
                if (jSONObject.has(str3)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.O000000o(hashMap);
                    }
                }
            } catch (Exception e) {
                duv.O00000o(e.toString());
            }
        }
        return miPushMessage;
    }
}
