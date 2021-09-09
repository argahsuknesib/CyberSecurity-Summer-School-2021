package _m_j;

import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.mijialog.LoganModel;

public final class dxh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f15027O000000o = false;
    private static dxn O00000Oo;
    private static dxj O00000o0;

    public static void O000000o(dxi dxi) {
        O00000o0 = dxj.O000000o(dxi);
    }

    public static void O000000o(String str, int i, String str2, String str3) {
        dxj dxj = O00000o0;
        if (dxj == null) {
            throw new RuntimeException("Please initialize Logan first");
        } else if (!TextUtils.isEmpty(str)) {
            LoganModel loganModel = new LoganModel();
            loganModel.f6029O000000o = LoganModel.Action.WRITE;
            dxp dxp = new dxp();
            String name = Thread.currentThread().getName();
            long id = Thread.currentThread().getId();
            boolean z = false;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z = true;
            }
            dxp.f15035O000000o = str;
            dxp.O00000oO = System.currentTimeMillis();
            dxp.O00000oo = i;
            dxp.O0000O0o = str2;
            dxp.O0000OOo = str3;
            dxp.O00000Oo = z;
            dxp.O00000o0 = id;
            dxp.O00000o = name;
            loganModel.O00000Oo = dxp;
            if (((long) dxj.f15030O000000o.size()) < dxj.O00000o0) {
                dxj.f15030O000000o.add(loganModel);
                if (dxj.O00000o != null) {
                    dxj.O00000o.O000000o();
                }
            }
        }
    }

    public static void O000000o() {
        dxj dxj = O00000o0;
        if (dxj == null) {
            throw new RuntimeException("Please initialize Logan first");
        } else if (!TextUtils.isEmpty(dxj.O00000Oo)) {
            LoganModel loganModel = new LoganModel();
            loganModel.f6029O000000o = LoganModel.Action.FLUSH;
            dxj.f15030O000000o.add(loganModel);
            if (dxj.O00000o != null) {
                dxj.O00000o.O000000o();
            }
        }
    }

    public static void O000000o(boolean z) {
        f15027O000000o = z;
    }

    static void O000000o(String str, int i) {
        dxn dxn = O00000Oo;
        if (dxn != null) {
            dxn.O000000o(str, i);
        }
    }

    public static void O000000o(dxn dxn) {
        O00000Oo = dxn;
    }
}
