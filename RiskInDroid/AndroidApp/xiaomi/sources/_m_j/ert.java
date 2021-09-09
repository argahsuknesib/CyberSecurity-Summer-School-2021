package _m_j;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ert {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f15756O000000o = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    private static Cipher O000000o(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f15756O000000o);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, ivParameterSpec);
        return instance;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        return O000000o(bArr, 2).doFinal(bArr2);
    }

    public static byte[] O00000Oo(byte[] bArr, byte[] bArr2) {
        return O000000o(bArr, 1).doFinal(bArr2);
    }
}
