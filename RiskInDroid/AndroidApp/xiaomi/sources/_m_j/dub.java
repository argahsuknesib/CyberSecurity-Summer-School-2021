package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.util.Date;
import java.util.Locale;
import javax.security.auth.x500.X500Principal;

public final class dub {

    /* renamed from: O000000o  reason: collision with root package name */
    final String f14944O000000o;

    dub(String str) {
        this.f14944O000000o = str;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(18)
    public void O000000o(Context context, int i, String str, Date date, Date date2, int i2, boolean z) throws GeneralSecurityException {
        Context applicationContext = context.getApplicationContext();
        X500Principal x500Principal = new X500Principal(str);
        KeyStore O000000o2 = O000000o();
        KeyPairGeneratorSpec.Builder builder = new KeyPairGeneratorSpec.Builder(applicationContext);
        builder.setAlias(this.f14944O000000o);
        builder.setStartDate(date);
        builder.setEndDate(date2);
        builder.setSerialNumber(BigInteger.valueOf(1));
        builder.setSubject(x500Principal);
        if (Build.VERSION.SDK_INT >= 19) {
            builder.setKeySize(2048);
        }
        Locale locale = Locale.getDefault();
        O000000o(applicationContext, Locale.ENGLISH);
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        instance.initialize(builder.build());
        try {
            instance.generateKeyPair();
            O000000o(applicationContext, locale);
            try {
                if (((PrivateKey) O000000o2.getKey(this.f14944O000000o, null)) == null) {
                    throw new GeneralSecurityException("Failed to obtain private key from a generated key pair");
                } else if (O000000o2.getCertificate(this.f14944O000000o).getPublicKey() == null) {
                    throw new GeneralSecurityException("Failed to obtain private key from a generated key pair");
                }
            } catch (RuntimeException e) {
                throw new GeneralSecurityException(e);
            }
        } catch (ProviderException e2) {
            throw new GeneralSecurityException(e2);
        } catch (IllegalStateException e3) {
            throw new GeneralSecurityException(e3);
        } catch (Throwable th) {
            O000000o(applicationContext, locale);
            throw th;
        }
    }

    static KeyStore O000000o() throws GeneralSecurityException {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        try {
            instance.load(null);
            return instance;
        } catch (IOException e) {
            throw new KeyStoreException("Key store error", e);
        }
    }

    private static void O000000o(Context context, Locale locale) {
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
