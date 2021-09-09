package _m_j;

import android.text.TextUtils;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import javax.crypto.Cipher;

public final class ti {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f2494O000000o = {48, 92, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, 75, 0, 48, 72, 2, 65, 0, -18, 74, 99, -65, 73, -9, -121, 104, -44, 122, 126, -72, -9, 4, -10, -30, 102, -73, 101, 13, -119, -83, -90, -101, 87, -8, -70, 57, 80, 65, 125, -117, -49, -118, 45, -73, 75, 39, -45, -16, -116, 34, -36, -118, -121, -78, -72, Byte.MIN_VALUE, 67, -15, -31, 23, -7, -21, -72, -127, -89, -95, -23, 121, -60, 24, 5, -75, 2, 3, 1, 0, 1};

    public static boolean O000000o(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("$")) <= 0) {
            return false;
        }
        try {
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1, str.length());
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            byte[] O000000o2 = O000000o(pa.O000000o(substring, "", ""));
            byte[] O00000Oo = O00000Oo(substring2);
            if (O000000o2 != null) {
                if (O00000Oo != null) {
                    return Arrays.equals(O000000o2, O00000Oo);
                }
            }
            return false;
        } catch (Exception unused) {
        }
    }

    private static byte[] O000000o(byte[] bArr) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(f2494O000000o));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePublic);
            return instance.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] O00000Oo(String str) {
        try {
            return MessageDigest.getInstance("SHA1").digest(str.getBytes());
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] O000000o(String str, byte[] bArr, sm smVar) {
        try {
            if (smVar.O0000O0o != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("et", "111");
                hashMap.put("Accept-Encoding", "gzip");
                ov ovVar = new ov();
                ovVar.O00000Oo = hashMap;
                ovVar.O00000o0 = bArr;
                ovVar.f2376O000000o = str;
                ow O000000o2 = smVar.O0000O0o.O000000o(ovVar);
                if (O000000o2 == null || O000000o2.f2377O000000o != 200) {
                    return null;
                }
                return O000000o2.O00000o0;
            }
            om.O00000Oo("CloudUtils", "网络库为空");
            return null;
        } catch (Throwable unused) {
        }
    }
}
