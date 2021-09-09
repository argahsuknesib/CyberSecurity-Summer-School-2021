package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.UserNotAuthenticatedException;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

@TargetApi(23)
public final class fwj {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f17310O000000o = -1;
    public static int O00000Oo = -2;
    public static int O00000o = -4;
    public static int O00000o0 = -3;
    public static int O00000oO = -5;
    private static final String O00000oo = "fwj";
    private static volatile fwj O0000O0o;
    private KeyStore O0000OOo;
    private boolean O0000Oo;
    private SharedPreferences O0000Oo0;

    private fwj(Context context, boolean z) {
        this.O0000Oo = z;
        this.O0000Oo0 = context.getSharedPreferences("xiaomi.device.pincode", 0);
        try {
            this.O0000OOo = KeyStore.getInstance("AndroidKeyStore");
        } catch (KeyStoreException e) {
            gsy.O000000o(LogType.GENERAL, "Failed to get an instance of KeyStore", e.getMessage());
        }
    }

    public static fwj O000000o(Context context, boolean z) {
        if (O0000O0o == null) {
            synchronized (fwj.class) {
                if (O0000O0o == null) {
                    O0000O0o = new fwj(context, z);
                }
            }
        }
        return O0000O0o;
    }

    private String O00000o0(String str) {
        if (this.O0000Oo) {
            return "pin_key_global".concat(String.valueOf(str));
        }
        return "xiaomi.sm.pin_key".concat(String.valueOf(str));
    }

    private String O00000o(String str) {
        if (this.O0000Oo) {
            return "encryted_pin_global".concat(String.valueOf(str));
        }
        return "xiaomi.sm.encryted_pin".concat(String.valueOf(str));
    }

    private String O00000oO(String str) {
        if (this.O0000Oo) {
            return "encryted_pin_iv_global".concat(String.valueOf(str));
        }
        return "xiaomi.sm.encryted_pin_iv".concat(String.valueOf(str));
    }

    private String O00000oo(String str) {
        if (this.O0000Oo) {
            return "is_open_fingerprint_verify_global".concat(String.valueOf(str));
        }
        return "xiaomi.sm.is_open_fingerprint_verify".concat(String.valueOf(str));
    }

    public final void O000000o(String str, boolean z) {
        SharedPreferences.Editor edit = this.O0000Oo0.edit();
        edit.putBoolean(O00000oo(str), z);
        edit.apply();
    }

    public final boolean O000000o(String str) {
        return this.O0000Oo0.getBoolean(O00000oo(str), false);
    }

    public final void O000000o(String str, String str2, Cipher cipher) {
        if (cipher != null) {
            try {
                byte[] doFinal = cipher.doFinal(str2.getBytes("utf-8"));
                byte[] iv = cipher.getIV();
                String encodeToString = Base64.encodeToString(doFinal, 0);
                String encodeToString2 = Base64.encodeToString(iv, 0);
                SharedPreferences.Editor edit = this.O0000Oo0.edit();
                edit.putString(O00000o(str), encodeToString);
                edit.putString(O00000oO(str), encodeToString2);
                edit.apply();
            } catch (IOException | BadPaddingException | IllegalBlockSizeException e) {
                O0000Oo0(str);
                throw new RuntimeException("Failed to encrypt pin ", e);
            }
        }
    }

    public final String O000000o(String str, Cipher cipher) {
        String string = this.O0000Oo0.getString(O00000o(str), "");
        if (TextUtils.isEmpty(string) || cipher == null) {
            return "";
        }
        try {
            return new String(cipher.doFinal(Base64.decode(string, 0)), Charset.forName("UTF8"));
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            LogType logType = LogType.GENERAL;
            String str2 = O00000oo;
            gsy.O000000o(logType, str2, "Failed to decrypt the data with the generated key." + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    private boolean O0000O0o(String str) {
        String O00000o02 = O00000o0(str);
        try {
            this.O0000OOo.load(null);
            if (this.O0000OOo.containsAlias(O00000o02) || O0000OOo(str)) {
                return true;
            }
            return false;
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            LogType logType = LogType.GENERAL;
            gsy.O000000o(logType, "", "Fail to init key store " + e.getMessage());
            return false;
        } catch (KeyStoreException e2) {
            LogType logType2 = LogType.GENERAL;
            gsy.O000000o(logType2, "", "Get a KeyStoreException when create key " + e2.getMessage());
            return false;
        }
    }

    private boolean O0000OOo(String str) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            KeyGenParameterSpec.Builder encryptionPaddings = new KeyGenParameterSpec.Builder(O00000o0(str), 3).setBlockModes("CBC").setUserAuthenticationRequired(true).setEncryptionPaddings("PKCS7Padding");
            if (Build.VERSION.SDK_INT >= 24) {
                encryptionPaddings.setInvalidatedByBiometricEnrollment(true);
            }
            try {
                instance.init(encryptionPaddings.build());
                try {
                    instance.generateKey();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (InvalidAlgorithmParameterException e2) {
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "", "Failed to init KeyGenerator " + e2.getMessage());
                return false;
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException e3) {
            LogType logType2 = LogType.GENERAL;
            gsy.O000000o(logType2, "", "Failed to get an instance of KeyGenerator" + e3.getMessage());
            return false;
        }
    }

    public final void O000000o(String str, fwe fwe) {
        if (!O0000O0o(str)) {
            fwe.onGetCipherError(f17310O000000o, "generate key error!");
            return;
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            this.O0000OOo.load(null);
            instance.init(1, (SecretKey) this.O0000OOo.getKey(O00000o0(str), null));
            fwe.onGetCipherSuccess(instance);
        } catch (KeyPermanentlyInvalidatedException e) {
            gsy.O000000o(LogType.GENERAL, "", e.getMessage());
            if (!O0000Oo0(str)) {
                fwe.onGetCipherError(O00000Oo, "generate key fail");
            } else {
                O00000o0(str, fwe);
            }
        } catch (Exception e2) {
            gsy.O000000o(6, O00000oo, Log.getStackTraceString(e2));
            if (e2 instanceof UserNotAuthenticatedException) {
                fwe.onGetCipherError(O00000o, e2.getMessage());
            } else {
                fwe.onGetCipherError(O00000oO, e2.getMessage());
            }
        }
    }

    private void O00000o0(String str, fwe fwe) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            this.O0000OOo.load(null);
            instance.init(1, (SecretKey) this.O0000OOo.getKey(O00000o0(str), null));
            fwe.onGetResetCipherSuccess(instance);
            O00000Oo(str);
        } catch (Exception e) {
            gsy.O000000o(LogType.GENERAL, "", e.getMessage());
            if (e instanceof UserNotAuthenticatedException) {
                fwe.onGetCipherError(O00000o, e.getMessage());
            } else {
                fwe.onGetCipherError(O00000oO, e.getMessage());
            }
        }
    }

    public final void O00000Oo(String str, fwe fwe) {
        if (!O0000O0o(str)) {
            fwe.onGetCipherError(f17310O000000o, "generate key error!");
            return;
        }
        try {
            byte[] decode = Base64.decode(this.O0000Oo0.getString(O00000oO(str), ""), 0);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            this.O0000OOo.load(null);
            instance.init(2, (SecretKey) this.O0000OOo.getKey(O00000o0(str), null), new IvParameterSpec(decode));
            fwe.onGetCipherSuccess(instance);
        } catch (KeyPermanentlyInvalidatedException e) {
            gsy.O000000o(LogType.GENERAL, "", e.getMessage());
            if (!O0000Oo0(str)) {
                fwe.onGetCipherError(O00000Oo, "generate key fail");
            } else {
                O00000o0(str, fwe);
            }
        } catch (Exception e2) {
            if (e2 instanceof UserNotAuthenticatedException) {
                fwe.onGetCipherError(O00000o, e2.getMessage());
            } else {
                fwe.onGetCipherError(O00000oO, e2.getMessage());
            }
        }
    }

    public final void O00000Oo(String str) {
        SharedPreferences.Editor edit = this.O0000Oo0.edit();
        edit.remove(O00000o(str));
        edit.remove(O00000oO(str));
        edit.remove(O00000oo(str));
        edit.apply();
    }

    private boolean O0000Oo0(String str) {
        try {
            this.O0000OOo.load(null);
            return O0000OOo(str);
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            LogType logType = LogType.GENERAL;
            gsy.O000000o(logType, "", "Fail to init key store " + e.getMessage());
            return false;
        }
    }
}
