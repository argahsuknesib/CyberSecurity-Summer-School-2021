package _m_j;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;

public final class ina {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f1490O000000o = "h5";
    public static Activity O00000Oo;
    public static O000000o O00000o0;

    public interface O000000o {
    }

    public static void O000000o(Context context, String str) {
        ArrayList<String> O00000oO = ilp.O000000o(context).O00000oO("share_pay_order_no");
        if (O00000oO.remove(str)) {
            ilp.O000000o(context).O000000o("share_pay_order_no", O00000oO);
        }
    }
}
