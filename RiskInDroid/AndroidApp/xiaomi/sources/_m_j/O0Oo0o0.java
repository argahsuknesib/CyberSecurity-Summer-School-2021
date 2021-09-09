package _m_j;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Base64;
import com.xiaomi.smarthome.R;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class O0Oo0o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public final O0OOO0 f6678O000000o;

    public O0Oo0o0(Context context, String str) {
        InputStream openRawResource = context.getResources().openRawResource(R.raw.otex_public);
        O0OOO00 o0ooo00 = new O0OOO00(openRawResource);
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        SecretKey generateKey = instance.generateKey();
        O0OOO0 o0ooo0 = new O0OOO0();
        Cipher instance2 = Cipher.getInstance("AES");
        instance2.init(1, generateKey);
        String str2 = new String(Base64.encode(instance2.doFinal(str.getBytes("UTF8")), 0));
        String str3 = new String(Base64.encode(O0OOO00.O000000o(generateKey.getEncoded(), o0ooo00.f6671O000000o), 0));
        o0ooo0.O00000Oo = str2;
        o0ooo0.f6670O000000o = str3;
        openRawResource.close();
        this.f6678O000000o = o0ooo0;
    }
}
