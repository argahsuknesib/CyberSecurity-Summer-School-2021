package com.xiaomi.passport.utils;

import android.util.Base64;
import com.xiaomi.accountsdk.account.exception.CryptoException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.utils.AESCoder;
import com.xiaomi.accountsdk.utils.RSACoder;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class PassportEnvEncryptUtils {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6348O000000o;
        public String O00000Oo;
    }

    public static class O00000Oo extends O000000o {
        public byte[] O00000o0;
    }

    public static O00000Oo O000000o(String str) throws EncryptException {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return O000000o(str, bArr);
    }

    private static O00000Oo O000000o(String str, byte[] bArr) throws EncryptException {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.O00000o0 = (byte[]) bArr.clone();
        SecretKey O000000o2 = O000000o();
        try {
            String encodeToString = Base64.encodeToString(RSACoder.encrypt(Base64.encode(O000000o2.getEncoded(), 10), RSACoder.getCertificatePublicKey("-----BEGIN CERTIFICATE-----\nMIICDzCCAXigAwIBAgIEWBw0IzANBgkqhkiG9w0BAQUFADBMMQswCQYDVQQGEwJD\nTjEPMA0GA1UEChMGeGlhb21pMQ8wDQYDVQQLEwZ4aWFvbWkxGzAZBgNVBAMTEmFj\nY291bnQueGlhb21pLmNvbTAeFw0xNjExMDQwNzA5MjNaFw0xNzExMDQwNzA5MjNa\nMEwxCzAJBgNVBAYTAkNOMQ8wDQYDVQQKEwZ4aWFvbWkxDzANBgNVBAsTBnhpYW9t\naTEbMBkGA1UEAxMSYWNjb3VudC54aWFvbWkuY29tMIGfMA0GCSqGSIb3DQEBAQUA\nA4GNADCBiQKBgQCHcPEm9Wo8/LWHL8mohOV5YalTgZLzng+nWCEkIRP//6GohYlI\nh3dvGpueJvQ3Sany/3dLx0x6MQKA34NxRyoO37R/LgPZUfe6eWzHQeColBBHxTED\nbCqDh46Gv5vogjqHRl4+q2WGCmZOIfmPjNHQWG8sMIZyTqFCLc6gk9vSewIDAQAB\nMA0GCSqGSIb3DQEBBQUAA4GBAHaPnscaxSPh0N0Z5OgQ6PcWr5uYPLMweatYGZRH\nSFxwSqYXpqIowuRxmrBj+oE5rG5rzFCtNjCBoeMVy/7JXZr9Juaw9NCWaTaqrmIV\nP4nK/0kizCvkx3088OOCGextGeZUC9/PCbVUEcRvGLwSrvgqiC1KG4ufeIdQWBaJ\n8ZlG\n-----END CERTIFICATE-----\n")), 10);
            o00000Oo.f6348O000000o = O000000o(str, O000000o2, o00000Oo.O00000o0);
            o00000Oo.O00000Oo = encodeToString;
            return o00000Oo;
        } catch (CryptoException e) {
            throw new EncryptException(e);
        }
    }

    private static SecretKey O000000o() throws EncryptException {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(new SecureRandom());
            return instance.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptException(e);
        }
    }

    private static String O000000o(String str, SecretKey secretKey, byte[] bArr) throws EncryptException {
        try {
            return new AESCoder(secretKey.getEncoded()).encryptWithIv(str, bArr);
        } catch (CipherException e) {
            throw new EncryptException(e);
        }
    }

    public static class EncryptException extends Exception {
        public EncryptException(Throwable th) {
            super(th);
        }
    }
}
