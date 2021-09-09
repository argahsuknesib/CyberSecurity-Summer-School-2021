package _m_j;

import android.util.Base64;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class gwb {
    private static volatile gwb O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public IvParameterSpec f18400O000000o;
    public Cipher O00000Oo;

    private gwb() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        this.f18400O000000o = new IvParameterSpec(bArr);
        try {
            this.O00000Oo = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            this.O00000Oo = null;
        }
    }

    public static gwb O000000o() {
        if (O00000o0 == null) {
            synchronized (gwb.class) {
                if (O00000o0 == null) {
                    O00000o0 = new gwb();
                }
            }
        }
        return O00000o0;
    }

    public final byte[] O000000o(byte[] bArr) {
        try {
            this.O00000Oo.init(1, new SecretKeySpec(Base64.decode(CameraRouterFactory.getCameraCloudApi().getSsecurity(), 2), "AES"), this.f18400O000000o);
            return this.O00000Oo.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            gsy.O000000o(6, "CameraCryptoUtils", "encrypt e:" + e.toString());
            return null;
        }
    }

    public static byte[] O00000Oo(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(bArr);
        return instance.digest();
    }
}
