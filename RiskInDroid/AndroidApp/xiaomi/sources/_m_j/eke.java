package _m_j;

import android.util.Base64;
import java.nio.charset.Charset;

public final class eke {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Charset f15569O000000o = Charset.forName("UTF-8");

    public static String O000000o(String str) {
        return Base64.encodeToString(str.getBytes(f15569O000000o), 10);
    }

    public static String O000000o(byte[] bArr) {
        return Base64.encodeToString(bArr, 10);
    }

    public static String O00000Oo(String str) {
        return new String(Base64.decode(str, 10), f15569O000000o);
    }
}
