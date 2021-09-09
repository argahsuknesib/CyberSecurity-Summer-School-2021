package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.h;

final class eoz implements epd {
    eoz() {
    }

    public final void O000000o(Context context, epa epa) {
        if (epa != null) {
            String str = epa.f15697O000000o;
            String str2 = epa.O00000Oo;
            String str3 = epa.O00000o;
            int i = epa.O00000oO;
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                if (TextUtils.isEmpty(str3)) {
                    eox.O000000o(context, "activity", 1008, "argument error");
                } else {
                    eox.O000000o(context, str3, 1008, "argument error");
                }
            } else if (!h.b(context, str, str2)) {
                eox.O000000o(context, str3, 1003, "B is not ready");
            } else {
                eox.O000000o(context, str3, 1002, "B is ready");
                eox.O000000o(context, str3, 1004, "A is ready");
                Intent intent = new Intent(str2);
                intent.setPackage(str);
                intent.putExtra("awake_info", eow.O000000o(str3));
                intent.addFlags(276824064);
                intent.setAction(str2);
                if (i == 1) {
                    try {
                        if (!epb.O00000Oo(context)) {
                            eox.O000000o(context, str3, 1008, "A not in foreground");
                            return;
                        }
                    } catch (Exception e) {
                        duv.O000000o(e);
                        eox.O000000o(context, str3, 1008, "A meet a exception when help B's activity");
                        return;
                    }
                }
                context.startActivity(intent);
                eox.O000000o(context, str3, 1005, "A is successful");
                eox.O000000o(context, str3, 1006, "The job is finished");
            }
        } else {
            eox.O000000o(context, "activity", 1008, "A receive incorrect message");
        }
    }

    public final void O000000o(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            eox.O000000o(context, "activity", 1008, "B receive incorrect message");
            return;
        }
        Activity activity = (Activity) context;
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String O00000Oo = eow.O00000Oo(stringExtra);
            if (!TextUtils.isEmpty(O00000Oo)) {
                eox.O000000o(activity.getApplicationContext(), O00000Oo, 1007, "play with activity successfully");
            } else {
                eox.O000000o(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
            }
        } else {
            eox.O000000o(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
        }
    }
}
