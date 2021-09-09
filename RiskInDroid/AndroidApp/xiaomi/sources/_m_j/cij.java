package _m_j;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class cij {
    public static String O000000o(Context context) {
        String str = Settings.Secure.getString(context.getContentResolver(), "android_id") + Build.SERIAL + XmPluginHostApi.instance().getAccountId();
        try {
            return O000000o(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String O000000o(String str) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
