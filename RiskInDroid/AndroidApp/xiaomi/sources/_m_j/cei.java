package _m_j;

import android.text.TextUtils;
import android.util.Base64;
import java.net.URLEncoder;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class cei {
    public static String O000000o(String str) {
        try {
            byte[] bytes = (str + '|' + System.currentTimeMillis()).getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(1, new SecretKeySpec(cdv.O000000o().getBytes(), "AES"), new IvParameterSpec(cdv.O00000Oo().getBytes()));
            return URLEncoder.encode(new String(Base64.encode(instance.doFinal(bytes), 0)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O00000Oo(String str) {
        String str2;
        String str3 = "";
        try {
            byte[] decode = Base64.decode("jWw5zMsiWkU29IQkmo2gYA==", 0);
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[(decode.length + bytes.length)];
            System.arraycopy(decode, 0, bArr, 0, decode.length);
            System.arraycopy(bytes, 0, bArr, decode.length, bytes.length);
            instance.update(bArr);
            String str4 = new String(Base64.encode(instance.digest(), 0));
            try {
                if (!TextUtils.isEmpty(str4)) {
                    str3 = str4.replace('+', '-');
                    str2 = str3.replace('/', '_').trim();
                    while (str2.endsWith("=")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                } else {
                    str2 = str4;
                }
                return URLEncoder.encode(str2, "UTF-8");
            } catch (Exception e) {
                e = e;
                str3 = str4;
                e.printStackTrace();
                return str3;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return str3;
        }
    }
}
