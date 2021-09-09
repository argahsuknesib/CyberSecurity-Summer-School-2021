package _m_j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

public final class qw {
    public static int O000000o(bwk bwk, Context context) {
        if (ok.O000000o() < 0 || TextUtils.isEmpty(ok.O00000Oo())) {
            throw new RuntimeException("必须在 HeaderBuildre 中，设置好 productId, productVerion" + ((int) ok.O000000o()) + ok.O00000Oo() + "， 以及其他的值");
        }
        try {
            int O000000o2 = bwk.O000000o(context.getPackageName());
            int O000000o3 = bwk.O000000o(ok.O00000Oo());
            int O000000o4 = TextUtils.isEmpty(ol.O000000o()) ? Integer.MIN_VALUE : bwk.O000000o(ol.O000000o());
            String O00000Oo = ol.O00000Oo(context);
            int O000000o5 = TextUtils.isEmpty(O00000Oo) ? Integer.MIN_VALUE : bwk.O000000o(O00000Oo);
            String O000000o6 = ol.O000000o(context);
            int O000000o7 = TextUtils.isEmpty(O000000o6) ? Integer.MIN_VALUE : bwk.O000000o(O000000o6);
            String O00000o0 = ol.O00000o0(context);
            int O000000o8 = TextUtils.isEmpty(O00000o0) ? Integer.MIN_VALUE : bwk.O000000o(O00000o0);
            String str = Build.BRAND;
            if (str != null && str.length() > 16) {
                str = str.substring(0, 16);
            }
            int O000000o9 = TextUtils.isEmpty(str) ? Integer.MIN_VALUE : bwk.O000000o(str);
            String str2 = Build.MODEL;
            if (str2 != null && str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            int O000000o10 = TextUtils.isEmpty(str2) ? Integer.MIN_VALUE : bwk.O000000o(str2);
            int O000000o11 = TextUtils.isEmpty(ok.O00000o0()) ? Integer.MIN_VALUE : bwk.O000000o(ok.O00000o0());
            int O000000o12 = TextUtils.isEmpty(ok.O00000o()) ? Integer.MIN_VALUE : bwk.O000000o(ok.O00000o());
            qx.O000000o(bwk);
            qx.O000000o(bwk, ok.O000000o());
            qx.O000000o(bwk, O000000o2);
            qx.O00000Oo(bwk, O000000o3);
            qx.O00000Oo(bwk, (byte) ol.O00000oO());
            qx.O000000o(bwk, ol.O00000o(context));
            if (O000000o4 != Integer.MIN_VALUE) {
                qx.O00000o0(bwk, O000000o4);
            }
            if (O000000o5 != Integer.MIN_VALUE) {
                qx.O00000o(bwk, O000000o5);
            }
            if (O000000o7 != Integer.MIN_VALUE) {
                qx.O00000oO(bwk, O000000o7);
            }
            if (O000000o8 != Integer.MIN_VALUE) {
                qx.O00000oo(bwk, O000000o8);
            }
            if (O000000o9 != Integer.MIN_VALUE) {
                qx.O0000O0o(bwk, O000000o9);
            }
            if (O000000o10 != Integer.MIN_VALUE) {
                qx.O0000OOo(bwk, O000000o10);
            }
            if (O000000o11 != Integer.MIN_VALUE) {
                qx.O0000Oo0(bwk, O000000o11);
            }
            if (O000000o12 != Integer.MIN_VALUE) {
                qx.O0000Oo(bwk, O000000o12);
            }
            return qx.O00000Oo(bwk);
        } catch (Error | Exception unused) {
            return 0;
        }
    }
}
