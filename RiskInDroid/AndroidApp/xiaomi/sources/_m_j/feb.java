package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class feb {
    public static int O000000o(int i) {
        return O000000o(fec.O00000o0().O000000o(i));
    }

    public static int O000000o(String str) {
        return fec.O00000o0().O00000o0(str);
    }

    public static byte[] O000000o(String str, int i) {
        return BLECipher.O000000o(ffr.O0000OoO(str), i);
    }

    public static byte[] O00000Oo(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            int length = digest.length;
            if (length < 12) {
                return got.f18097O000000o;
            }
            int i = length / 2;
            return Arrays.copyOfRange(digest, i - 6, i + 6);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static int O00000o0(String str) {
        int O0000O0o = ffr.O0000O0o(str);
        if (O0000O0o <= 0) {
            String O0000Oo = ffr.O0000Oo(str);
            if (!TextUtils.isEmpty(O0000Oo)) {
                return fec.O00000o0().O000000o(O0000Oo);
            }
        }
        return O0000O0o;
    }
}
