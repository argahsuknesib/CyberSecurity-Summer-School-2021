package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

final class inw implements inv {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1508O000000o;

    inw(Context context) {
        this.f1508O000000o = context;
    }

    @SuppressLint({"HardwareIds"})
    public final boolean O000000o() throws Throwable {
        TelephonyManager telephonyManager = (TelephonyManager) this.f1508O000000o.getSystemService("phone");
        return !TextUtils.isEmpty(telephonyManager.getDeviceId()) || !TextUtils.isEmpty(telephonyManager.getSubscriberId());
    }
}
