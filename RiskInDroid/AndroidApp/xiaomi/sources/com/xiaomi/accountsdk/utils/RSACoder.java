package com.xiaomi.accountsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.accountsdk.account.exception.CryptoException;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSACoder {
    public static KeyPair generateRsaKeyPair(int i) throws CryptoException {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(i, new SecureRandom());
            return instance.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoException("generate key", e.getCause());
        }
    }

    public static PublicKey getCertificatePublicKey(String str) throws CryptoException {
        if (!TextUtils.isEmpty(str)) {
            try {
                return getCertificatePublicKey(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new CryptoException("getPublicKey", e.getCause());
            }
        } else {
            throw new IllegalStateException("public key should not be empty");
        }
    }

    public static PublicKey getCertificatePublicKey(byte[] bArr) throws CryptoException {
        if (bArr != null) {
            try {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            } catch (CertificateException e) {
                throw new CryptoException("getPublicKey", e.getCause());
            }
        } else {
            throw new IllegalStateException("public key bytes should not be empty");
        }
    }

    public static PublicKey getPublicKey(byte[] bArr) throws CryptoException {
        if (bArr != null) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
            } catch (NoSuchAlgorithmException e) {
                throw new CryptoException("getPublicKey", e.getCause());
            } catch (InvalidKeySpecException e2) {
                throw new CryptoException("getPublicKey", e2.getCause());
            }
        } else {
            throw new IllegalStateException("public key bytes should not be empty");
        }
    }

    public static PrivateKey getPrivateKey(byte[] bArr) throws CryptoException {
        if (bArr != null) {
            try {
                return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr));
            } catch (InvalidKeySpecException e) {
                throw new CryptoException("getPrivateKey", e.getCause());
            } catch (NoSuchAlgorithmException e2) {
                throw new CryptoException("getPrivateKey", e2.getCause());
            }
        } else {
            throw new IllegalStateException("private key bytes should not be empty");
        }
    }

    public static String encrypt(String str, Key key) throws CryptoException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("plain data should not be empty");
        } else if (key != null) {
            return Base64.encodeToString(encrypt(Base64.decode(str, 10), key), 10);
        } else {
            throw new IllegalStateException("encrypt key should not be empty");
        }
    }

    public static byte[] encrypt(byte[] bArr, Key key) throws CryptoException {
        try {
            return cipher(bArr, key, 1);
        } catch (CryptoException e) {
            throw new CryptoException("encrypt", e.getCause());
        }
    }

    public static String decrypt(String str, Key key) throws CryptoException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("en data should not be empty");
        } else if (key != null) {
            return Base64.encodeToString(decrypt(Base64.decode(str, 10), key), 10);
        } else {
            throw new IllegalStateException("decrypt key should not be empty");
        }
    }

    public static byte[] decrypt(byte[] bArr, Key key) throws CryptoException {
        try {
            return cipher(bArr, key, 2);
        } catch (CryptoException e) {
            throw new CryptoException("decrypt", e.getCause());
        }
    }

    public static byte[] cipher(byte[] bArr, Key key, int i) throws CryptoException {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/OAEPPadding");
            instance.init(i, key);
            return instance.doFinal(bArr);
        } catch (IllegalBlockSizeException e) {
            throw new CryptoException(e.getCause());
        } catch (BadPaddingException e2) {
            throw new CryptoException(e2.getCause());
        } catch (NoSuchAlgorithmException e3) {
            throw new CryptoException(e3.getCause());
        } catch (NoSuchPaddingException e4) {
            throw new CryptoException(e4.getCause());
        } catch (InvalidKeyException e5) {
            throw new CryptoException(e5.getCause());
        }
    }
}
