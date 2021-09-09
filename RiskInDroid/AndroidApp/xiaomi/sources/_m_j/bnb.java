package _m_j;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public final class bnb {
    private static PublicKey O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(str, 0)))).getPublicKey();
        }
        throw new IllegalAccessException("empty publicKeyStr");
    }

    public static byte[] O000000o(String str, byte[] bArr) {
        return O000000o(O000000o(str), bArr);
    }

    private static byte[] O000000o(PublicKey publicKey, byte[] bArr) {
        if (publicKey == null) {
            throw new Exception("public key can not be null!");
        } else if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("empty data");
        } else {
            Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING");
            instance.init(1, publicKey, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            return instance.doFinal(bArr);
        }
    }
}
