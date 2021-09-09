package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ikk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f1400O000000o = null;
    public static String O00000Oo = null;
    private static String O00000o = "1tyt1zuKMloXu/prwDTm5Q==";
    private static String O00000o0 = "";
    private static Cipher O00000oO = null;
    private static String O00000oo = "";

    public static String O000000o(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(f1400O000000o)) {
            return f1400O000000o;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            f1400O000000o = string;
            return string;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O00000Oo(Context context) {
        try {
            return O00000o0(context);
        } catch (Exception unused) {
            return "undefined";
        }
    }

    public static String O00000o0(final Context context) throws Exception {
        AnonymousClass1 r0 = new Runnable() {
            /* class _m_j.ikk.AnonymousClass1 */

            public final void run() {
                try {
                    ikk.O00000Oo = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                } catch (Exception unused) {
                    ikk.O00000Oo = null;
                }
            }
        };
        if (!TextUtils.isEmpty(O00000Oo)) {
            iln.O00000Oo(r0);
            return O00000Oo;
        }
        r0.run();
        if (!TextUtils.isEmpty(O00000Oo)) {
            return O00000Oo;
        }
        throw new Exception("未获取到imei");
    }

    @SuppressLint({"WifiManagerLeak"})
    public static String O00000o(Context context) throws XimalayaException {
        if (TextUtils.isEmpty(O00000o0)) {
            O00000o0 = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (!TextUtils.isEmpty(O00000o0)) {
            return O00000o0;
        }
        throw new XimalayaException(1006, "get mac address error");
    }

    public static int O00000oO(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null) {
            return 3;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 49679470:
                if (str.equals("46000")) {
                    c = 0;
                    break;
                }
                break;
            case 49679471:
                if (str.equals("46001")) {
                    c = 3;
                    break;
                }
                break;
            case 49679472:
                if (str.equals("46002")) {
                    c = 1;
                    break;
                }
                break;
            case 49679473:
                if (str.equals("46003")) {
                    c = 4;
                    break;
                }
                break;
            case 49679475:
                if (str.equals("46005")) {
                    c = 5;
                    break;
                }
                break;
            case 49679477:
                if (str.equals("46007")) {
                    c = 2;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1 || c == 2) {
            return 0;
        }
        if (c == 3) {
            return 1;
        }
        if (c == 4 || c == 5) {
            return 2;
        }
        return 3;
    }

    public static String O000000o(String str) throws Exception {
        byte[] decode = Base64.decode(str, 0);
        byte[] decode2 = Base64.decode(O00000o, 0);
        if (O00000oO == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decode2, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            O00000oO = instance;
            instance.init(2, secretKeySpec);
        }
        return new String(O00000oO.doFinal(decode));
    }
}
