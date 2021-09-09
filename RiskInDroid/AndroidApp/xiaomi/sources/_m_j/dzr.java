package _m_j;

import android.content.Context;

public final class dzr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f15104O000000o = false;
    private static dut O00000Oo;

    protected static dut O000000o() {
        return O00000Oo;
    }

    private static boolean O000000o(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String equals : strArr) {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(equals)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void O000000o(Context context, dut dut) {
        O00000Oo = dut;
        boolean z = false;
        boolean z2 = O00000Oo != null;
        if (f15104O000000o) {
            z2 = false;
        } else if (O000000o(context)) {
            z = true;
        }
        eoi eoi = null;
        dut dut2 = z2 ? O00000Oo : null;
        if (z) {
            eoi = eoi.O000000o(context);
        }
        duv.O000000o(new eoh(dut2, eoi));
    }
}
