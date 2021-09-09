package com.xiaomi.verificationsdk.internal;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.utils.AESCoder;
import com.xiaomi.accountsdk.utils.CloudCoder;
import com.xiaomi.passport.utils.PassportEnvEncryptUtils;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public final class EnvEncryptUtils {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f12044O000000o = "-----BEGIN CERTIFICATE-----\nMIIDXTCCAkWgAwIBAgIJAOMjETkYAg3lMA0GCSqGSIb3DQEBCwUAMEUxCzAJBgNV\nBAYTAkFVMRMwEQYDVQQIDApTb21lLVN0YXRlMSEwHwYDVQQKDBhJbnRlcm5ldCBX\naWRnaXRzIFB0eSBMdGQwHhcNMTgwMTExMDk0ODQ3WhcNMTgwMjEwMDk0ODQ3WjBF\nMQswCQYDVQQGEwJBVTETMBEGA1UECAwKU29tZS1TdGF0ZTEhMB8GA1UECgwYSW50\nZXJuZXQgV2lkZ2l0cyBQdHkgTHRkMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIB\nCgKCAQEArxfNLkuAQ/BYHzkzVwtug+0abmYRBVCEScSzGxJIOsfxVzcuqaKO87H2\no2wBcacD3bRHhMjTkhSEqxPjQ/FEXuJ1cdbmr3+b3EQR6wf/cYcMx2468/QyVoQ7\nBADLSPecQhtgGOllkC+cLYN6Md34Uii6U+VJf0p0q/saxUTZvhR2ka9fqJ4+6C6c\nOghIecjMYQNHIaNW+eSKunfFsXVU+QfMD0q2EM9wo20aLnos24yDzRjh9HJc6xfr\n37jRlv1/boG/EABMG9FnTm35xWrVR0nw3cpYF7GZg13QicS/ZwEsSd4HyboAruMx\nJBPvK3Jdr4ZS23bpN0cavWOJsBqZVwIDAQABo1AwTjAdBgNVHQ4EFgQU0AWcCdJQ\nruwyc3Hjt2dEmYXmUCUwHwYDVR0jBBgwFoAU0AWcCdJQruwyc3Hjt2dEmYXmUCUw\nDAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQsFAAOCAQEASssjoOG4RbRjy6ivCDkZ\nteOLur7jQ6/AZru8n8Fow8WGd9zM1uFZs9+c6okvlmUeCPuOiYDxps6xfL23hkQc\nKghkMofjBn2eLoqTiQ+woAoZHAqLuiFUHae85KH7185EV8NTm2LpJJoqh2x5KU4Q\nlCWm+5uadtqPEbO9wmI1er5Kob/njPI0QtQn2/5H9u7t71MCjHIGuQ5OSrZmmyzV\nTFUVbdkf0mwoL44JO7ErbdOQ/nq+dElYiGnq7tI9gdt78k3Pgi7ykU5W7pnDbxLN\no66M6umwCy2ies0zzsxS9pKzurddXd+Zt4NBh74MV0RCf2PbDCtUODTBowLeDluq\nXw==\n-----END CERTIFICATE-----\n";
    private static volatile PublicKey O00000Oo;
    private static volatile String O00000o;
    private static volatile SecretKey O00000o0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f12045O000000o;
        public String O00000Oo;
    }

    public static O000000o O000000o(String str) throws EncryptException {
        O000000o o000000o = new O000000o();
        synchronized (PassportEnvEncryptUtils.class) {
            if (O00000o0 == null || O00000o == null) {
                SecretKey O00000o02 = O00000o0();
                O00000o0 = O00000o02;
                O00000o = O000000o(Base64.encodeToString(O00000o02.getEncoded(), 10), O00000Oo(), "RSA/ECB/PKCS1Padding");
            }
        }
        o000000o.f12045O000000o = O000000o(str, O00000o0);
        o000000o.O00000Oo = O00000o;
        return o000000o;
    }

    private static PublicKey O00000Oo() throws EncryptException {
        if (O00000Oo != null) {
            return O00000Oo;
        }
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(f12044O000000o.getBytes("UTF-8")))).getPublicKey();
            O00000Oo = publicKey;
            return publicKey;
        } catch (CertificateException e) {
            throw new EncryptException(e);
        } catch (UnsupportedEncodingException e2) {
            throw new EncryptException(e2);
        }
    }

    private static SecretKey O00000o0() throws EncryptException {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init((int) NotificationCompat.FLAG_HIGH_PRIORITY, new SecureRandom());
            return instance.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptException(e);
        }
    }

    private static String O000000o(String str, SecretKey secretKey) throws EncryptException {
        try {
            return new AESCoder(secretKey.getEncoded()).encrypt(str);
        } catch (CipherException e) {
            throw new EncryptException(e);
        }
    }

    private static String O000000o(String str, Key key, String str2) throws EncryptException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.encode(O000000o(str.getBytes("UTF-8"), key, str2), 10), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new EncryptException(e);
        }
    }

    private static byte[] O000000o(byte[] bArr, Key key, String str) throws EncryptException {
        try {
            Cipher instance = Cipher.getInstance(str);
            instance.init(1, key);
            return instance.doFinal(bArr);
        } catch (IllegalBlockSizeException e) {
            throw new EncryptException(e);
        } catch (BadPaddingException e2) {
            throw new EncryptException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new EncryptException(e3);
        } catch (NoSuchPaddingException e4) {
            throw new EncryptException(e4);
        } catch (InvalidKeyException e5) {
            throw new EncryptException(e5);
        }
    }

    public static class EncryptException extends Exception {
        public EncryptException(Throwable th) {
            super(th);
        }
    }

    public static String O000000o() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }

    public static String O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String hash4SHA1 = CloudCoder.hash4SHA1(str);
        if (6 > hash4SHA1.length()) {
            return hash4SHA1;
        }
        return hash4SHA1.substring(0, 6);
    }
}
