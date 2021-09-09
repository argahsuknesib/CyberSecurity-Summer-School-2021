package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.push.hp;
import com.xiaomi.push.il;
import com.xiaomi.push.is;
import com.xiaomi.push.service.af;
import com.xiaomi.push.service.s;
import java.util.HashMap;
import java.util.Map;

public final class dzo {
    public static void O000000o(Context context, String str) {
        ebb.O000000o(context, e.b, str);
    }

    public static void O000000o(Context context, Map<String, String> map) {
        PushMessageReceiver O00000o;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (O00000o = ebb.O00000o(context)) != null) {
            O00000o.onNotificationMessageArrived(context, ebb.O000000o(str));
        }
    }

    public static boolean O000000o(Context context) {
        e eVar = e.b;
        return ebb.O00000Oo(context) && dzs.O0000oO0(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):com.xiaomi.push.service.af$c
     arg types: [android.content.Context, com.xiaomi.push.il, byte[]]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.lang.String):int
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, boolean):android.graphics.Bitmap
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):android.widget.RemoteViews
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, java.util.Map<java.lang.String, java.lang.String>):java.lang.String
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int):void
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, java.lang.String):boolean
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[]):com.xiaomi.push.service.af$c */
    public static Map<String, String> O00000Oo(Context context, Map<String, String> map) {
        byte[] decode;
        il a2;
        PushMessageReceiver O00000o;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (O00000o = ebb.O00000o(context)) != null) {
            O00000o.onReceivePassThroughMessage(context, ebb.O000000o(str));
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            decode = Base64.decode(str2, 2);
            a2 = s.a(decode);
            MiPushMessage O000000o2 = eab.O000000o((is) eai.O000000o(context, a2), a2.f122a, false);
            PushMessageReceiver O00000o2 = ebb.O00000o(context);
            if (O00000o2 != null) {
                O00000o2.onNotificationMessageArrived(context, O000000o2);
            }
        } catch (Throwable th) {
            duv.O000000o("fcm notify notification error ", th);
        }
        af.m146a(context, a2, decode);
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(hp.f.a()));
        hashMap.put("deviceStatus", String.valueOf((int) eru.O000000o(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }
}
