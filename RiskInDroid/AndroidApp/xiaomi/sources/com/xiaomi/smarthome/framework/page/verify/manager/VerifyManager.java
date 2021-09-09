package com.xiaomi.smarthome.framework.page.verify.manager;

import _m_j.fno;
import _m_j.fqx;
import _m_j.fwc;
import _m_j.fwe;
import _m_j.fwj;
import _m_j.gsy;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.HashMap;
import javax.crypto.Cipher;

public class VerifyManager {
    public static HashMap<String, fwc> O00000o0 = new HashMap<>();

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f8025O000000o;
    public fwj O00000Oo = null;

    public VerifyManager(Context context) {
        this.f8025O000000o = context.getApplicationContext();
    }

    public static int O000000o(String str, String str2) {
        return fqx.O000000o(str, str2) ? 6 : 4;
    }

    public static boolean O00000Oo(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void O000000o(String str, fwe fwe) {
        if (this.O00000Oo == null) {
            fwe.onGetCipherError(fwj.O00000o0, "DeviceVerifyCache is null!");
        }
        this.O00000Oo.O000000o(str, fwe);
    }

    public final void O00000Oo(String str, fwe fwe) {
        if (this.O00000Oo == null) {
            fwe.onGetCipherError(fwj.O00000o0, "DeviceVerifyCache is null!");
        }
        this.O00000Oo.O00000Oo(str, fwe);
    }

    public final String O000000o(String str, Cipher cipher) {
        return this.O00000Oo.O000000o(str, cipher);
    }

    public static String O000000o(String str, long j) {
        fwc fwc;
        String O0000o0 = CoreApi.O000000o().O0000o0();
        if (TextUtils.equals(str, O0000o0)) {
            fwc = O00000o0.get(O0000o0);
        } else {
            Device O000000o2 = fno.O000000o().O000000o(str);
            if (O000000o2 == null || O000000o2.isSetPinCode == 0) {
                fwc = null;
            } else {
                fwc = O00000o0.get(str);
                if (fwc == null) {
                    fwc = O00000o0.get(O0000o0);
                }
            }
        }
        if (fwc == null || (j != 0 && System.currentTimeMillis() - fwc.O00000Oo >= j)) {
            LogType logType = LogType.GENERAL;
            gsy.O00000o0(logType, "", "getPincode", "getPincode failed, return empty text, deviceId:" + str + " uid:" + O0000o0);
            return "";
        }
        LogType logType2 = LogType.GENERAL;
        gsy.O00000o0(logType2, "", "getPincode", "getPincode success, deviceId:" + str + " uid:" + O0000o0);
        return fwc.f17300O000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwj.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fwj.O000000o(android.content.Context, boolean):_m_j.fwj
      _m_j.fwj.O000000o(java.lang.String, javax.crypto.Cipher):java.lang.String
      _m_j.fwj.O000000o(java.lang.String, _m_j.fwe):void
      _m_j.fwj.O000000o(java.lang.String, boolean):void */
    @TargetApi(23)
    public final void O000000o(String str, String str2, Cipher cipher) {
        fwj fwj = this.O00000Oo;
        if (fwj != null) {
            try {
                fwj.O000000o(str, str2, cipher);
                this.O00000Oo.O000000o(str, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwj.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fwj.O000000o(android.content.Context, boolean):_m_j.fwj
      _m_j.fwj.O000000o(java.lang.String, javax.crypto.Cipher):java.lang.String
      _m_j.fwj.O000000o(java.lang.String, _m_j.fwe):void
      _m_j.fwj.O000000o(java.lang.String, boolean):void */
    @TargetApi(23)
    public final void O000000o(String str) {
        fwj fwj = this.O00000Oo;
        if (fwj != null) {
            fwj.O000000o(str, false);
        }
    }

    public final boolean O00000Oo(String str) {
        return O000000o() && this.O00000Oo.O000000o(str);
    }

    public final boolean O000000o() {
        return O00000o0(this.f8025O000000o) && this.O00000Oo != null;
    }

    public static boolean O00000o0(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class);
            if (fingerprintManager != null && fingerprintManager.isHardwareDetected()) {
                if (fingerprintManager.hasEnrolledFingerprints()) {
                    KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);
                    if (keyguardManager == null || !keyguardManager.isKeyguardSecure()) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
