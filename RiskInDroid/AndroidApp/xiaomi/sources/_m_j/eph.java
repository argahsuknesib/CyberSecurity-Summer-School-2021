package _m_j;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.h;

final class eph implements epd {
    eph() {
    }

    public final void O000000o(Context context, epa epa) {
        if (epa != null) {
            String str = epa.f15697O000000o;
            String str2 = epa.O00000o0;
            String str3 = epa.O00000o;
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str3)) {
                    eox.O000000o(context, "service", 1008, "argument error");
                } else {
                    eox.O000000o(context, str3, 1008, "argument error");
                }
            } else if (!h.a(context, str)) {
                eox.O000000o(context, str3, 1003, "B is not ready");
            } else {
                eox.O000000o(context, str3, 1002, "B is ready");
                eox.O000000o(context, str3, 1004, "A is ready");
                try {
                    Intent intent = new Intent();
                    intent.setClassName(str, str2);
                    intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                    intent.putExtra("waker_pkgname", context.getPackageName());
                    intent.putExtra("awake_info", eow.O000000o(str3));
                    if (context.startService(intent) != null) {
                        eox.O000000o(context, str3, 1005, "A is successful");
                        eox.O000000o(context, str3, 1006, "The job is finished");
                        return;
                    }
                    eox.O000000o(context, str3, 1008, "A is fail to help B's service");
                } catch (Exception e) {
                    duv.O000000o(e);
                    eox.O000000o(context, str3, 1008, "A meet a exception when help B's service");
                }
            }
        }
    }

    public final void O000000o(Context context, Intent intent, String str) {
        if (context != null && (context instanceof Service)) {
            Service service = (Service) context;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("waker_pkgname");
                String stringExtra2 = intent.getStringExtra("awake_info");
                if (TextUtils.isEmpty(stringExtra)) {
                    eox.O000000o(service.getApplicationContext(), "service", 1007, "old version message");
                } else if (!TextUtils.isEmpty(stringExtra2)) {
                    String O00000Oo = eow.O00000Oo(stringExtra2);
                    if (!TextUtils.isEmpty(O00000Oo)) {
                        eox.O000000o(service.getApplicationContext(), O00000Oo, 1007, "old version message ");
                    } else {
                        eox.O000000o(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
                    }
                } else {
                    eox.O000000o(service.getApplicationContext(), stringExtra, 1007, "play with service ");
                }
            }
        }
    }
}
