package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.smarthome.frame.CoreContentProvider;

public final class fsl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile boolean f17060O000000o = false;
    private static volatile boolean O00000Oo = true;

    public static boolean O000000o(Context context) {
        if (context == null) {
            return true;
        }
        boolean O00000o = ftm.O00000o(context);
        if (f17060O000000o && O00000o) {
            return O00000Oo;
        }
        if (O00000o) {
            try {
                O00000Oo = CoreContentProvider.O000000o.O000000o(context);
                f17060O000000o = true;
                return O00000Oo;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        } else {
            Bundle call = context.getContentResolver().call(Uri.parse("content://com.xiaomi.smarthome.core_auth"), "isUsrExpPlanEnabled", (String) null, (Bundle) null);
            if (call == null) {
                O00000Oo = true;
                f17060O000000o = true;
                return true;
            }
            f17060O000000o = true;
            boolean z = call.getBoolean("enabled", true);
            O00000Oo = z;
            return z;
        }
    }

    public static void O000000o(Context context, boolean z) {
        boolean z2;
        if (context != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("enabled", z);
                Bundle call = context.getContentResolver().call(Uri.parse("content://com.xiaomi.smarthome.core_auth"), "setUsrExpPlanEnabled", (String) null, bundle);
                if (call == null) {
                    z2 = true;
                } else {
                    z2 = call.getBoolean("enabled", true);
                }
                if (ftm.O00000o(context)) {
                    O00000Oo = z;
                    f17060O000000o = true;
                }
                boolean z3 = false;
                if (z2) {
                    Intent intent = new Intent("com.xiaomi.smarthome.usr_exp_plan_change");
                    intent.putExtra("usr_exp_plan_value", z);
                    ft.O000000o(context).O000000o(intent);
                    if (z) {
                        dgm.f14605O000000o = false;
                    } else {
                        dgm.f14605O000000o = true;
                    }
                }
                if (!z) {
                    z3 = true;
                }
                OneTrack.setDisable(z3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean O000000o(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("device_id", str);
                Bundle call = context.getContentResolver().call(Uri.parse("content://com.xiaomi.smarthome.core_auth"), "isDeviceUsrExpPlanEnabled", (String) null, bundle);
                if (call == null) {
                    return true;
                }
                return call.getBoolean("enabled", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void O000000o(Context context, String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("device_id", str);
                bundle.putBoolean("enabled", z);
                context.getContentResolver().call(Uri.parse("content://com.xiaomi.smarthome.core_auth"), "setDeviceUsrExpPlanEnabled", (String) null, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
