package _m_j;

import android.content.Context;
import android.util.Base64;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Calendar;
import java.util.Date;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class dua {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile String f14943O000000o;
    private dub O00000Oo = new dub("XMPassport");

    public final synchronized String O000000o(Context context) {
        String str;
        if (f14943O000000o == null) {
            try {
                AccountLog.i("SQLCipherManager", "deriveKeyOnlyOnce");
                byte[] bArr = null;
                if (!(((PrivateKey) dub.O000000o().getKey(this.O00000Oo.f14944O000000o, null)) != null)) {
                    AccountLog.w("SQLCipherManager", "generateKey() start");
                    try {
                        dub.O000000o().deleteEntry(this.O00000Oo.f14944O000000o);
                    } catch (GeneralSecurityException unused) {
                        AccountLog.w("SQLCipherManager", "Failed to discard a key");
                    }
                    Calendar instance = Calendar.getInstance();
                    instance.set(1, 2000);
                    instance.set(14, 0);
                    instance.set(13, 0);
                    instance.set(12, 0);
                    instance.set(11, 0);
                    Date time = instance.getTime();
                    instance.set(1, 2200);
                    this.O00000Oo.O000000o(context, 2048, "CN=Database/O=Xiaomi Corporation", time, instance.getTime(), 1, false);
                    AccountLog.w("SQLCipherManager", "generateKey() end");
                }
                Key key = dub.O000000o().getKey(this.O00000Oo.f14944O000000o, null);
                if (key != null) {
                    Signature instance2 = Signature.getInstance("SHA256withRSA");
                    instance2.initSign((PrivateKey) key);
                    instance2.update("db-key".getBytes());
                    byte[] sign = instance2.sign();
                    Mac instance3 = Mac.getInstance("HmacSHA256");
                    instance3.init(new SecretKeySpec(new byte[instance3.getMacLength()], "HmacSHA256"));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(instance3.doFinal(sign), "HmacSHA256");
                    for (int i = 0; i < sign.length; i++) {
                        sign[i] = 119;
                    }
                    byte[] bArr2 = new byte[0];
                    double macLength = (double) instance3.getMacLength();
                    Double.isNaN(macLength);
                    int ceil = (int) Math.ceil(32.0d / macLength);
                    if (ceil <= 255) {
                        ByteBuffer allocate = ByteBuffer.allocate(32);
                        byte[] bArr3 = bArr2;
                        int i2 = 0;
                        int i3 = 32;
                        while (i2 < ceil) {
                            Mac instance4 = Mac.getInstance("HmacSHA256");
                            instance4.init(secretKeySpec);
                            instance4.update(bArr3);
                            instance4.update("db-key".getBytes());
                            i2++;
                            instance4.update((byte) i2);
                            bArr3 = instance4.doFinal();
                            int min = Math.min(i3, bArr3.length);
                            allocate.put(bArr3, 0, min);
                            i3 -= min;
                        }
                        bArr = allocate.array();
                    } else {
                        throw new IllegalArgumentException("out length must be maximal 255 * hash-length; requested: 32" + " bytes");
                    }
                }
                if (bArr == null) {
                    AccountLog.w("SQLCipherManager", "key is null, use fail over key");
                    str = "010203040506070809";
                } else {
                    str = Base64.encodeToString(bArr, 2);
                }
                f14943O000000o = str;
            } catch (GeneralSecurityException e) {
                AccountLog.e("SQLCipherManager", "error when deriveKeyOnlyOnce(), maybe android api is lower than 18, use FAIL_OVER_KEY", e);
            }
        }
        if (f14943O000000o == null) {
            f14943O000000o = "010203040506070809";
        }
        return f14943O000000o;
    }
}
