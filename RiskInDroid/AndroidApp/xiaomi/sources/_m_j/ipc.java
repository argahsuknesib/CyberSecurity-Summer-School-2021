package _m_j;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

final class ipc implements ipb {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1533O000000o;

    ipc(Context context) {
        this.f1533O000000o = context;
    }

    public final boolean O000000o() throws Throwable {
        if (!this.f1533O000000o.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f1533O000000o.getSystemService("phone");
        if (telephonyManager.getPhoneType() == 0 || !TextUtils.isEmpty(telephonyManager.getDeviceId()) || !TextUtils.isEmpty(telephonyManager.getSubscriberId())) {
            return true;
        }
        return false;
    }
}
