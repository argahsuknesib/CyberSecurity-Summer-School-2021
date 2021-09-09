package _m_j;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class cdv {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13670O000000o = O000000o();
    public static final String O00000Oo = O00000Oo();

    private static SecretKeySpec O00000Oo(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    private static IvParameterSpec O00000o0(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        return new IvParameterSpec(bArr);
    }

    public static String O000000o(String str) {
        return O000000o(str, f13670O000000o, O00000Oo);
    }

    public static byte[] O000000o(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(f13670O000000o.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(O00000Oo.getBytes());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] O000000o(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec O00000Oo2 = O00000Oo(str);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, O00000Oo2, O00000o0(str2));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static String O000000o() {
        return new String(Base64.decode("MTQzMWVkMzQyNDlmMTNkZQ==", 0));
    }

    static String O00000Oo() {
        return new String(Base64.decode("NGRlZjVlY2E3MGU0MTU1MQ==", 0));
    }

    private static String O000000o(String str, String str2, String str3) {
        byte[] bArr;
        try {
            bArr = new byte[(str.length() / 2)];
            int i = 0;
            int i2 = 0;
            while (i < str.length()) {
                int i3 = i + 2;
                bArr[i2] = (byte) Integer.parseInt(str.substring(i, i3), 16);
                i2++;
                i = i3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        byte[] O000000o2 = O000000o(bArr, str2, str3);
        if (O000000o2 == null) {
            return null;
        }
        try {
            return new String(O000000o2, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
