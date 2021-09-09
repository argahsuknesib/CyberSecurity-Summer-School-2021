package com.xiaomi.smarthome.miio.camera.cloudstorage.utils;

import _m_j.gsy;
import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CloudVideoCryptoUtils {
    private static volatile CloudVideoCryptoUtils instance;
    public Cipher cipher;
    public IvParameterSpec iv;

    public byte[] encrypt() {
        return null;
    }

    private CloudVideoCryptoUtils() {
        init();
    }

    public static CloudVideoCryptoUtils getInstance() {
        if (instance == null) {
            synchronized (CloudVideoCryptoUtils.class) {
                if (instance == null) {
                    instance = new CloudVideoCryptoUtils();
                }
            }
        }
        return instance;
    }

    private void init() {
        this.iv = genIV();
        try {
            this.cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            this.cipher = null;
        }
    }

    public byte[] decrypt(byte[] bArr) {
        try {
            this.cipher.init(2, new SecretKeySpec(Base64.decode(CloudVideoNetUtils.getInstance().getTokenInfo().O00000o, 2), "AES"), this.iv);
            return this.cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            gsy.O000000o(6, "CloudVideoCryptoUtils", "e:" + e.toString());
            return null;
        }
    }

    private IvParameterSpec genIV() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return new IvParameterSpec(bArr);
    }
}
