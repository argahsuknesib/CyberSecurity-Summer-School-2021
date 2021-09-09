package _m_j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public final class hxw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f963O000000o = 4096;
    private static Map<String, Integer> O00000Oo = new HashMap();

    public static int O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Integer num = O00000Oo.get(str);
        if (num != null) {
            return num.intValue();
        }
        int O000000o2 = flu.O00000oO().O000000o(str);
        if (O000000o2 < 0) {
            return -3;
        }
        O00000Oo.put(str, Integer.valueOf(O000000o2));
        return O000000o2;
    }

    public static byte[] O000000o(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        O000000o(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static void O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[f963O000000o];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static boolean O000000o() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final String O000000o(long j, long j2) {
        return "plugin." + j + "." + j2;
    }
}
