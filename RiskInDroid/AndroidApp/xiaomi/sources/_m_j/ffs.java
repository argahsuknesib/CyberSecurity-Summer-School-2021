package _m_j;

import android.text.TextUtils;
import java.util.Arrays;

public final class ffs {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f16246O000000o = {"yeelink.light.ble1", "roidmi.btfm.v1", "roidmi.btfm.m1", "ninebot.balscooter.v1", "xiaomi.ble.v1", "onemore.soundbox.sm001"};
    private static final String[] O00000Oo = {"zimi.powerbank.v1", "haiii.pettag.v1", "aer.mask.smartbug"};

    public static int O000000o(String str) {
        if (Arrays.asList(f16246O000000o).contains(str)) {
            return 0;
        }
        return Arrays.asList(O00000Oo).contains(str) ? 1 : 2;
    }

    public static boolean O00000Oo(String str) {
        int O000000o2 = O000000o(str);
        return O000000o2 == 0 || O000000o2 == 1;
    }

    public static boolean O00000o0(String str) {
        if (!TextUtils.isEmpty(str) && O000000o(str) == 2) {
            return true;
        }
        return false;
    }
}
