package com.tencent.open.utils;

import _m_j.diz;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

public class a {

    /* renamed from: O000000o  reason: collision with root package name */
    private KeyStore f5878O000000o;
    private SharedPreferences O00000Oo;

    public a(Context context) {
        try {
            this.O00000Oo = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            this.f5878O000000o = KeyStore.getInstance("AndroidKeyStore");
            this.f5878O000000o.load(null);
            if (!this.f5878O000000o.containsAlias("KEYSTORE_AES")) {
                O00000Oo("");
                diz.O00000Oo("KEYSTORE", "Build.VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
                if (Build.VERSION.SDK_INT >= 23) {
                    KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").build());
                    instance.generateKeyPair();
                } else if (Build.VERSION.SDK_INT >= 18) {
                    KeyPairGenerator instance2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    Calendar instance3 = Calendar.getInstance();
                    Calendar instance4 = Calendar.getInstance();
                    instance4.add(1, 30);
                    instance2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(instance3.getTime()).setEndDate(instance4.getTime()).build());
                    instance2.generateKeyPair();
                }
                byte[] bArr = new byte[16];
                SecureRandom secureRandom = new SecureRandom();
                secureRandom.nextBytes(bArr);
                O00000Oo(Base64.encodeToString(secureRandom.generateSeed(12), 0));
                if (Build.VERSION.SDK_INT >= 18) {
                    PublicKey publicKey = this.f5878O000000o.getCertificate("KEYSTORE_AES").getPublicKey();
                    Cipher instance5 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    instance5.init(1, publicKey);
                    O00000o0(Base64.encodeToString(instance5.doFinal(bArr), 0));
                    return;
                }
                MessageDigest instance6 = MessageDigest.getInstance("SHA-256");
                instance6.update(bArr);
                O00000o0(Base64.encodeToString(instance6.digest(), 0));
            }
        } catch (Exception e) {
            diz.O000000o("KEYSTORE", "Exception", e);
        }
    }

    public final String O000000o(String str) {
        SecretKeySpec secretKeySpec;
        try {
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            String string = this.O00000Oo.getString("PREF_KEY_AES", "");
            if (Build.VERSION.SDK_INT >= 18) {
                Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                instance2.init(2, (PrivateKey) this.f5878O000000o.getKey("KEYSTORE_AES", null));
                secretKeySpec = new SecretKeySpec(instance2.doFinal(Base64.decode(string, 0)), "AES/GCM/NoPadding");
            } else {
                secretKeySpec = new SecretKeySpec(Base64.decode(string, 0), "AES/GCM/NoPadding");
            }
            instance.init(1, secretKeySpec, new IvParameterSpec(Base64.decode(this.O00000Oo.getString("PREF_KEY_IV", ""), 0)));
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
        } catch (Exception e) {
            diz.O00000Oo("KEYSTORE", "Exception", e);
            return "";
        }
    }

    private void O00000Oo(String str) {
        this.O00000Oo.edit().putString("PREF_KEY_IV", str).apply();
    }

    private void O00000o0(String str) {
        this.O00000Oo.edit().putString("PREF_KEY_AES", str).apply();
    }
}
