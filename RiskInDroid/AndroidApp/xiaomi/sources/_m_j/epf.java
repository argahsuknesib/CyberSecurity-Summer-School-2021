package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.push.service.h;

final class epf implements epd {
    epf() {
    }

    public final void O000000o(Context context, epa epa) {
        if (epa != null) {
            String str = epa.O00000Oo;
            String str2 = epa.O00000o;
            int i = epa.O00000oO;
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str2)) {
                    eox.O000000o(context, "provider", 1008, "argument error");
                } else {
                    eox.O000000o(context, str2, 1008, "argument error");
                }
            } else if (!h.b(context, str)) {
                eox.O000000o(context, str2, 1003, "B is not ready");
            } else {
                eox.O000000o(context, str2, 1002, "B is ready");
                eox.O000000o(context, str2, 1004, "A is ready");
                String O000000o2 = eow.O000000o(str2);
                try {
                    if (TextUtils.isEmpty(O000000o2)) {
                        eox.O000000o(context, str2, 1008, "info is empty");
                    } else if (i != 1 || epb.O00000Oo(context)) {
                        String type = context.getContentResolver().getType(Uri.parse("content://".concat(String.valueOf(str))).buildUpon().appendPath(O000000o2).build());
                        if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                            eox.O000000o(context, str2, 1008, "A is fail to help B's provider");
                            return;
                        }
                        eox.O000000o(context, str2, 1005, "A is successful");
                        eox.O000000o(context, str2, 1006, "The job is finished");
                    } else {
                        eox.O000000o(context, str2, 1008, "A not in foreground");
                    }
                } catch (Exception e) {
                    duv.O000000o(e);
                    eox.O000000o(context, str2, 1008, "A meet a exception when help B's provider");
                }
            }
        } else {
            eox.O000000o(context, "provider", 1008, "A receive incorrect message");
        }
    }

    public final void O000000o(Context context, Intent intent, String str) {
        try {
            if (TextUtils.isEmpty(str) || context == null) {
                eox.O000000o(context, "provider", 1008, "B get a incorrect message");
                return;
            }
            String[] split = str.split("/");
            if (split.length <= 0 || TextUtils.isEmpty(split[split.length - 1])) {
                eox.O000000o(context, "provider", 1008, "B get a incorrect message");
                return;
            }
            String str2 = split[split.length - 1];
            if (TextUtils.isEmpty(str2)) {
                eox.O000000o(context, "provider", 1008, "B get a incorrect message");
                return;
            }
            String decode = Uri.decode(str2);
            if (TextUtils.isEmpty(decode)) {
                eox.O000000o(context, "provider", 1008, "B get a incorrect message");
                return;
            }
            String O00000Oo = eow.O00000Oo(decode);
            if (!TextUtils.isEmpty(O00000Oo)) {
                eox.O000000o(context, O00000Oo, 1007, "play with provider successfully");
            } else {
                eox.O000000o(context, "provider", 1008, "B get a incorrect message");
            }
        } catch (Exception e) {
            eox.O000000o(context, "provider", 1008, "B meet a exception" + e.getMessage());
        }
    }
}
