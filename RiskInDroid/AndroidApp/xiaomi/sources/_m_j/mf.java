package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.URL;
import java.util.regex.Pattern;

public final class mf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Pattern f2181O000000o = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern O00000Oo = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern O00000o0 = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static boolean O000000o(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso()) || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
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
}
