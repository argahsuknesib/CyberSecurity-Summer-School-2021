package _m_j;

import android.app.Activity;
import android.content.Intent;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.framework.page.verify.DevicePinMotifyOpenActivity;
import com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyChangeActivity;
import com.xiaomi.smarthome.framework.page.verify.FingerPrintVerifyActivity;

public final class fwb {
    public static void O000000o(Activity activity, String str, String str2, boolean z, int i) {
        Intent intent = new Intent(activity, DevicePinMotifyOpenActivity.class);
        O000000o(intent, str);
        O00000Oo(intent, str2);
        O000000o(intent, z);
        activity.startActivityForResult(intent, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwb.O000000o(android.content.Intent, boolean):void
     arg types: [android.content.Intent, int]
     candidates:
      _m_j.fwb.O000000o(android.content.Intent, java.lang.String):void
      _m_j.fwb.O000000o(android.content.Intent, boolean):void */
    public static void O000000o(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, DevicePinVerifyChangeActivity.class);
        O000000o(intent, str);
        O00000Oo(intent, str2);
        O000000o(intent, false);
        activity.startActivityForResult(intent, 7002);
    }

    public static void O000000o(Activity activity, String str, String str2, boolean z) {
        Intent intent = new Intent(activity, FingerPrintVerifyActivity.class);
        intent.putExtras(activity.getIntent());
        O000000o(intent, str);
        O00000Oo(intent, str2);
        O000000o(intent, z);
        activity.startActivityForResult(intent, C.MSG_CUSTOM_BASE);
    }

    public static void O000000o(Intent intent, String str) {
        intent.putExtra("extra_device_did", str);
    }

    public static void O000000o(Intent intent, boolean z) {
        intent.putExtra("verify_for_global_pin", z);
    }

    public static void O00000Oo(Intent intent, String str) {
        intent.putExtra("xiaomi.smarthome.desc", str);
    }

    public static void O00000o0(Intent intent, String str) {
        intent.putExtra("xiaomi.smarthome.pincode", str);
    }
}
