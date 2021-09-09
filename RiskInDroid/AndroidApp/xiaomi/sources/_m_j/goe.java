package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.regex.Pattern;

public final class goe {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Pattern f18085O000000o = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern O00000Oo = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern O00000o0 = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    private static int O00000oo(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static boolean O000000o(Context context) {
        return O00000oo(context) == 1;
    }

    public static boolean O00000Oo(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType() == 13;
    }

    public static boolean O00000o0(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType() == 20;
    }

    public static boolean O00000o(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso()) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        String extraInfo = activeNetworkInfo.getExtraInfo();
        if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || extraInfo.contains("ctwap") || !extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3)) {
            return false;
        }
        return true;
    }

    public static String O000000o(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol());
        sb.append("://10.0.0.172");
        sb.append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery())) {
            sb.append("?");
            sb.append(url.getQuery());
        }
        return sb.toString();
    }

    public static boolean O00000oO(Context context) {
        return O00000oo(context) >= 0;
    }

    public static final class O000000o extends FilterInputStream {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f18086O000000o;

        public O000000o(InputStream inputStream) {
            super(inputStream);
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read;
            if (!this.f18086O000000o && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.f18086O000000o = true;
            return -1;
        }
    }
}
