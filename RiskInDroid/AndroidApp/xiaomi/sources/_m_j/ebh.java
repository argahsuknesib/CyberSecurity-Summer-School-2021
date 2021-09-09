package _m_j;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.em;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.at;

public final class ebh {
    public static void O000000o(Context context, Intent intent, Uri uri) {
        epb O000000o2;
        em emVar;
        if (context != null) {
            eao.O000000o(context).O000000o();
            if (epb.O000000o(context.getApplicationContext()).O00000oO == null) {
                epb.O000000o(context.getApplicationContext()).O000000o(b.O000000o(context.getApplicationContext()).O00000Oo.f6054O000000o, context.getPackageName(), at.a(context.getApplicationContext()).a(hu.aF.a(), 0), new eaw());
                at.a(context).a(new ebj("awake online config", context));
            }
            if ((context instanceof Activity) && intent != null) {
                O000000o2 = epb.O000000o(context.getApplicationContext());
                emVar = em.f6375a;
            } else if (!(context instanceof Service) || intent == null) {
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    epb.O000000o(context.getApplicationContext()).O000000o(em.d, context, (Intent) null, uri.toString());
                    return;
                }
                return;
            } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                O000000o2 = epb.O000000o(context.getApplicationContext());
                emVar = em.c;
            } else {
                O000000o2 = epb.O000000o(context.getApplicationContext());
                emVar = em.b;
            }
            O000000o2.O000000o(emVar, context, intent, (String) null);
        }
    }
}
