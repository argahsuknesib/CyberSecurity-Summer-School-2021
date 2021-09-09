package _m_j;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

public final class bve {
    private static String O000000o() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] O000000o2 = bvd.O000000o(currentTimeMillis);
        byte[] O000000o3 = bvd.O000000o(nanoTime);
        byte[] O000000o4 = bvd.O000000o(nextInt);
        byte[] O000000o5 = bvd.O000000o(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(O000000o2, 0, bArr, 0, 4);
        System.arraycopy(O000000o3, 0, bArr, 4, 4);
        System.arraycopy(O000000o4, 0, bArr, 8, 4);
        System.arraycopy(O000000o5, 0, bArr, 12, 4);
        return bvc.O000000o(bArr, 2);
    }

    public static String O000000o(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Exception unused) {
            }
        }
        return bvf.O000000o(str) ? O000000o() : str;
    }

    public static String O00000Oo(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (Exception unused) {
            }
        }
        return bvf.O000000o(str) ? O000000o() : str;
    }
}
