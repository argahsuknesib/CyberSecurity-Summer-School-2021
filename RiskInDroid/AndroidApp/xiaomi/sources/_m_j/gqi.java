package _m_j;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class gqi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f18150O000000o = {65, 105, 20, 56, 72, 38, 72, 97, 22, 97, 21, 121, 54, 37, 36, 3};
    private static final byte[] O00000Oo = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    public static String O000000o(String str, String str2) {
        int i;
        int i2;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2 != null ? gqb.O0000OOo(str2) : f18150O000000o, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(O00000Oo));
            str.getBytes("UTF-8");
            byte[] O000000o2 = grs.O000000o(str);
            byte[] update = instance.update(O000000o2, 0, O000000o2.length);
            byte[] doFinal = instance.doFinal();
            if (update == null) {
                i = 0;
            } else {
                i = update.length;
            }
            int length = i + (doFinal == null ? 0 : doFinal.length);
            if (length <= 0) {
                return null;
            }
            byte[] bArr = new byte[length];
            if (update != null) {
                System.arraycopy(update, 0, bArr, 0, update.length);
                i2 = update.length;
            } else {
                i2 = 0;
            }
            if (doFinal != null) {
                System.arraycopy(doFinal, 0, bArr, i2, doFinal.length);
            }
            return new String(bArr, "UTF-8");
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public static String O00000Oo(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec;
        if (str2 != null) {
            byte[] bArr = new byte[16];
            System.arraycopy(gqb.O0000OOo(str2), 0, bArr, 0, 16);
            secretKeySpec = new SecretKeySpec(bArr, "AES");
        } else {
            secretKeySpec = new SecretKeySpec(f18150O000000o, "AES");
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(O00000Oo));
        return String.valueOf(grs.O000000o(instance.doFinal(str.getBytes("UTF-8"))));
    }
}
