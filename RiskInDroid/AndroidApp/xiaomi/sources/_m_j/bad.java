package _m_j;

import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public final class bad {
    private static byte[] O00000Oo(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static String O000000o(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] O00000Oo = O00000Oo("com.nearme.mcs");
            int length = O00000Oo.length % 2 == 0 ? O00000Oo.length : O00000Oo.length - 1;
            for (int i = 0; i < length; i += 2) {
                byte b = O00000Oo[i];
                int i2 = i + 1;
                O00000Oo[i] = O00000Oo[i2];
                O00000Oo[i2] = b;
            }
            if (O00000Oo != null) {
                str2 = new String(O00000Oo, Charset.forName("UTF-8"));
            } else {
                str2 = "";
            }
            Cipher instance = Cipher.getInstance("DES");
            instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(Base64.decode(str2, 0))));
            return new String(instance.doFinal(Base64.decode(str, 0)), Charset.defaultCharset()).trim();
        } catch (Exception e) {
            bae.O00000Oo("desDecrypt-" + e.getMessage());
            return "";
        }
    }
}
