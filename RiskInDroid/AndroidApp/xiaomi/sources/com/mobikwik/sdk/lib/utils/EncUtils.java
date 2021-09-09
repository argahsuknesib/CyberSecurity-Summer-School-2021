package com.mobikwik.sdk.lib.utils;

import android.util.Log;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class EncUtils {
    public static PublicKey generatePublicKey(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (Base64DecoderException e2) {
            Log.e("EncUtils", "Could not decode from Base64.");
            throw new IllegalArgumentException(e2);
        } catch (InvalidKeySpecException e3) {
            Log.e("EncUtils", "Invalid key specification.");
            throw new IllegalArgumentException(e3);
        }
    }
}
