package com.xiaomi.smarthome.cache.keystore;

import _m_j.fau;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.support.v4.app.NotificationCompat;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

public final class EncryptionManager {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f4323O000000o;
    protected final String O00000Oo;
    fau O00000o;
    protected final String O00000o0;
    private final int O00000oO = 2048;
    private final int O00000oo = 256;
    private final int O0000O0o = 256;
    private final int O0000OOo = NotificationCompat.FLAG_HIGH_PRIORITY;
    private final int O0000Oo = 12;
    private final int O0000Oo0 = 16;
    private final String O0000OoO = "AndroidKeyStore";
    private final String O0000Ooo = "AndroidOpenSSL";
    private final String O0000o = "RSA/ECB/PKCS1Padding";
    private final byte[] O0000o0;
    private final String O0000o00 = "BC";
    private final String O0000o0O;
    private final String O0000o0o = "]";
    private final String O0000oO = "AES/CBC/PKCS7Padding";
    private final String O0000oO0 = "AES/GCM/NoPadding";
    private final String O0000oOO = "HmacSHA256";
    private KeyStore O0000oOo;
    private SecretKey O0000oo;
    private SecretKey O0000oo0;
    private RSAPublicKey O0000ooO;
    private RSAPrivateKey O0000ooo;
    private Context O000O00o;
    private String O00oOooO;
    private boolean O00oOooo = false;

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0261 A[Catch:{ Exception -> 0x030c }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0286 A[Catch:{ Exception -> 0x030c }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x028e A[Catch:{ Exception -> 0x030c }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x029d A[Catch:{ Exception -> 0x030c }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02cb A[Catch:{ Exception -> 0x030c }] */
    public EncryptionManager(Context context, fau fau, String str, byte[] bArr) throws IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException, NoSuchPaddingException, CertificateException, KeyStoreException, UnrecoverableEntryException, InvalidKeyException, IllegalStateException {
        boolean z;
        boolean z2;
        boolean z3;
        String O000000o2;
        boolean z4;
        SecureRandom secureRandom;
        KeyPairGeneratorSpec keyPairGeneratorSpec;
        Context context2 = context;
        fau fau2 = fau;
        byte[] bArr2 = bArr;
        this.O0000o0 = bArr2;
        String O000000o3 = fau2.O000000o(O000000o("OverridingAlias"), str);
        this.O00oOooO = O000000o3 == null ? "sps" : O000000o3;
        boolean z5 = true;
        this.O00000o0 = String.format("%s_%s", this.O00oOooO, "data_in_compat");
        this.O0000o0O = String.format("%s_%s", this.O00oOooO, "rsa_key");
        this.f4323O000000o = String.format("%s_%s", this.O00oOooO, "aes_key");
        this.O00000Oo = String.format("%s_%s", this.O00oOooO, "mac_key");
        this.O00oOooo = fau2.O000000o(O000000o(this.O00000o0), Build.VERSION.SDK_INT < 23);
        this.O000O00o = context2;
        this.O00000o = fau2;
        this.O0000oOo = KeyStore.getInstance("AndroidKeyStore");
        SecretKeySpec secretKeySpec = null;
        this.O0000oOo.load(null);
        try {
            if (this.O00oOooo) {
                if (!this.O0000oOo.containsAlias(this.O0000o0O)) {
                    KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    Calendar instance2 = Calendar.getInstance();
                    instance2.add(11, -26);
                    Calendar instance3 = Calendar.getInstance();
                    instance3.add(1, 100);
                    if (Build.VERSION.SDK_INT >= 19) {
                        keyPairGeneratorSpec = new KeyPairGeneratorSpec.Builder(context2).setAlias(this.O0000o0O).setKeySize(2048).setKeyType("RSA").setSerialNumber(BigInteger.ONE).setSubject(new X500Principal("CN = Secured Preference Store, O = Devliving Online")).setStartDate(instance2.getTime()).setEndDate(instance3.getTime()).build();
                    } else {
                        keyPairGeneratorSpec = new KeyPairGeneratorSpec.Builder(context2).setAlias(this.O0000o0O).setSerialNumber(BigInteger.ONE).setSubject(new X500Principal("CN = Secured Preference Store, O = Devliving Online")).setStartDate(instance2.getTime()).setEndDate(instance3.getTime()).build();
                    }
                    if (bArr2 == null || bArr2.length <= 0) {
                        instance.initialize(keyPairGeneratorSpec);
                    } else {
                        instance.initialize(keyPairGeneratorSpec, new SecureRandom(bArr2));
                    }
                    instance.generateKeyPair();
                    z = true;
                } else {
                    z = false;
                }
                if (this.O0000oOo.containsAlias(this.O0000o0O) && this.O0000oOo.entryInstanceOf(this.O0000o0O, KeyStore.PrivateKeyEntry.class)) {
                    KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) this.O0000oOo.getEntry(this.O0000o0O, null);
                    this.O0000ooO = (RSAPublicKey) privateKeyEntry.getCertificate().getPublicKey();
                    this.O0000ooo = (RSAPrivateKey) privateKeyEntry.getPrivateKey();
                }
                String O000000o4 = O000000o(this.f4323O000000o);
                if (!fau2.O00000Oo(O000000o4)) {
                    KeyGenerator instance4 = KeyGenerator.getInstance("AES");
                    if (bArr2 == null || bArr2.length <= 0) {
                        instance4.init(256);
                    } else {
                        instance4.init(256, new SecureRandom(bArr2));
                    }
                    z2 = fau2.O00000Oo(O000000o4, Base64.encodeToString(O00000o(O000000o(instance4.generateKey().getEncoded(), this.O0000o0)), 2));
                    fau2.O000000o(O000000o(this.O00000o0));
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (!z) {
                        z3 = false;
                        O000000o2 = O000000o(this.O00000Oo);
                        if (fau2.O00000Oo(O000000o2)) {
                            byte[] bArr3 = new byte[32];
                            if (bArr2 == null || bArr2.length <= 0) {
                                secureRandom = new SecureRandom();
                            } else {
                                secureRandom = new SecureRandom(bArr2);
                            }
                            secureRandom.nextBytes(bArr3);
                            z4 = fau2.O00000Oo(O000000o2, Base64.encodeToString(O00000o(bArr3), 2));
                        } else {
                            z4 = false;
                        }
                        if (z4 || z3) {
                            z5 = true;
                            if (z5) {
                            }
                            if (!this.O00oOooo) {
                            }
                        }
                    }
                }
                z3 = true;
                O000000o2 = O000000o(this.O00000Oo);
                if (fau2.O00000Oo(O000000o2)) {
                }
                z5 = true;
                if (z5) {
                }
                if (!this.O00oOooo) {
                }
            } else if (!this.O0000oOo.containsAlias(this.f4323O000000o)) {
                KeyGenerator instance5 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(this.f4323O000000o, 3).setCertificateSubject(new X500Principal("CN = Secured Preference Store, O = Devliving Online")).setCertificateSerialNumber(BigInteger.ONE).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setRandomizedEncryptionRequired(false).build();
                if (bArr2 == null || bArr2.length <= 0) {
                    instance5.init(build);
                } else {
                    instance5.init(build, new SecureRandom(bArr2));
                }
                instance5.generateKey();
                if (z5) {
                    this.O00000o.O00000Oo(O000000o("OverridingAlias"), this.O00oOooO);
                }
                if (!this.O00oOooo) {
                    String O000000o5 = fau2.O000000o(O000000o(this.f4323O000000o), (String) null);
                    this.O0000oo0 = O000000o5 != null ? new SecretKeySpec(O000000o(O00000oO(Base64.decode(O000000o5, 2)), this.O0000o0), "AES") : null;
                    String O000000o6 = fau2.O000000o(O000000o(this.O00000Oo), (String) null);
                    this.O0000oo = O000000o6 != null ? new SecretKeySpec(O00000oO(Base64.decode(O000000o6, 2)), "HmacSHA256") : secretKeySpec;
                    return;
                } else if (!this.O0000oOo.containsAlias(this.f4323O000000o)) {
                    return;
                } else {
                    if (Build.VERSION.SDK_INT >= 28) {
                        this.O0000oo0 = (SecretKey) this.O0000oOo.getKey(this.f4323O000000o, null);
                        return;
                    } else {
                        this.O0000oo0 = ((KeyStore.SecretKeyEntry) this.O0000oOo.getEntry(this.f4323O000000o, null)).getSecretKey();
                        return;
                    }
                }
            }
            z5 = false;
            if (z5) {
            }
            if (!this.O00oOooo) {
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String O000000o(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return O00000Oo(MessageDigest.getInstance("SHA-256").digest(str.getBytes("UTF-8")));
    }

    private static String O00000Oo(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        return sb.toString();
    }

    @TargetApi(19)
    private Cipher O000000o(byte[] bArr, boolean z) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(z ? 1 : 2, this.O0000oo0, new GCMParameterSpec(NotificationCompat.FLAG_HIGH_PRIORITY, bArr));
        return instance;
    }

    private Cipher O00000Oo(byte[] bArr, boolean z) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
        instance.init(z ? 1 : 2, this.O0000oo0, new IvParameterSpec(bArr));
        return instance;
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length == 0) {
            return bArr;
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    private byte[] O00000o0(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(this.O0000oo);
        return instance.doFinal(bArr);
    }

    private byte[] O00000o(byte[] bArr) throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IOException {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
        instance.init(1, this.O0000ooO);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] O00000oO(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IOException {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
        instance.init(2, this.O0000ooo);
        CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(bArr), instance);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int read = cipherInputStream.read();
            if (read == -1) {
                break;
            }
            arrayList.add(Byte.valueOf((byte) read));
        }
        byte[] bArr2 = new byte[arrayList.size()];
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        cipherInputStream.close();
        return bArr2;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public byte[] f4324O000000o = null;
        public byte[] O00000Oo = null;
        public byte[] O00000o0 = null;

        /* access modifiers changed from: package-private */
        public final byte[] O000000o() {
            byte[] bArr = this.f4324O000000o;
            byte[] bArr2 = new byte[(bArr.length + this.O00000Oo.length)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            byte[] bArr3 = this.O00000Oo;
            System.arraycopy(bArr3, 0, bArr2, this.f4324O000000o.length, bArr3.length);
            return bArr2;
        }
    }

    public class InvalidMacException extends GeneralSecurityException {
        public InvalidMacException() {
            super("Invalid Mac, failed to verify integrity.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.cache.keystore.EncryptionManager.O000000o(byte[], boolean):javax.crypto.Cipher
     arg types: [byte[], int]
     candidates:
      com.xiaomi.smarthome.cache.keystore.EncryptionManager.O000000o(byte[], byte[]):byte[]
      com.xiaomi.smarthome.cache.keystore.EncryptionManager.O000000o(byte[], boolean):javax.crypto.Cipher */
    public final O000000o O000000o(byte[] bArr) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException, InvalidKeyException, KeyStoreException, UnrecoverableEntryException {
        byte[] bArr2;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    if (!this.O00oOooo) {
                        bArr2 = new byte[12];
                    } else {
                        bArr2 = new byte[16];
                    }
                    new SecureRandom().nextBytes(bArr2);
                    if (this.O00oOooo) {
                        Cipher O00000Oo2 = O00000Oo(bArr2, true);
                        O000000o o000000o = new O000000o();
                        o000000o.f4324O000000o = O00000Oo2.getIV();
                        o000000o.O00000Oo = O00000Oo2.doFinal(bArr);
                        o000000o.O00000o0 = O00000o0(o000000o.O000000o());
                        return o000000o;
                    }
                    Cipher O000000o2 = O000000o(bArr2, true);
                    O000000o o000000o2 = new O000000o();
                    o000000o2.f4324O000000o = O000000o2.getIV();
                    o000000o2.O00000Oo = O000000o2.doFinal(bArr);
                    return o000000o2;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.cache.keystore.EncryptionManager.O000000o(byte[], boolean):javax.crypto.Cipher
     arg types: [byte[], int]
     candidates:
      com.xiaomi.smarthome.cache.keystore.EncryptionManager.O000000o(byte[], byte[]):byte[]
      com.xiaomi.smarthome.cache.keystore.EncryptionManager.O000000o(byte[], boolean):javax.crypto.Cipher */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b A[Catch:{ Exception -> 0x0050 }] */
    public final byte[] O000000o(O000000o o000000o) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException, NoSuchProviderException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidMacException {
        boolean z;
        try {
            if (o000000o.O00000Oo == null) {
                return null;
            }
            if (!this.O00oOooo) {
                return O000000o(o000000o.f4324O000000o, false).doFinal(o000000o.O00000Oo);
            }
            byte[] bArr = o000000o.O00000o0;
            byte[] O000000o2 = o000000o.O000000o();
            if (bArr != null) {
                byte[] O00000o02 = O00000o0(O000000o2);
                if (O00000o02.length == bArr.length) {
                    byte b = 0;
                    for (int i = 0; i < O00000o02.length; i++) {
                        b |= O00000o02[i] ^ bArr[i];
                    }
                    if (b == 0) {
                        z = true;
                        if (!z) {
                            return O00000Oo(o000000o.f4324O000000o, false).doFinal(o000000o.O00000Oo);
                        }
                        throw new InvalidMacException();
                    }
                }
            }
            z = false;
            if (!z) {
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
