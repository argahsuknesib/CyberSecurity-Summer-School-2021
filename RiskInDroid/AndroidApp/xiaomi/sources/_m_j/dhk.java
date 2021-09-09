package _m_j;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class dhk implements dhl {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f14640O000000o = null;

    public final byte[] O000000o(byte[] bArr) throws Exception {
        if (this.f14640O000000o == null || bArr == null) {
            return null;
        }
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f14640O000000o.getBytes("UTF-8"))), new IvParameterSpec(this.f14640O000000o.getBytes("UTF-8")));
        return instance.doFinal(bArr);
    }

    public final byte[] O00000Oo(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (this.f14640O000000o == null || bArr == null) {
            return null;
        }
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f14640O000000o.getBytes("UTF-8"))), new IvParameterSpec(this.f14640O000000o.getBytes("UTF-8")));
        return instance.doFinal(bArr);
    }

    public final void O000000o(String str) {
        if (str != null) {
            this.f14640O000000o = str;
        }
    }
}
