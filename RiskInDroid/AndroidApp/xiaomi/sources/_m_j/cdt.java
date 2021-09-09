package _m_j;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class cdt {
    private static SecretKeySpec O000000o(String str) {
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

    private static IvParameterSpec O00000Oo(String str) {
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

    private static String O000000o(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec O000000o2 = O000000o(str);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, O000000o2, O00000Oo(str2));
            return Base64.encodeToString(instance.doFinal(bArr), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O000000o(String str, String str2, String str3) {
        try {
            return O000000o(str.getBytes("UTF-8"), str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
