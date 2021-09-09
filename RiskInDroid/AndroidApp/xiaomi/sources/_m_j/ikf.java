package _m_j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Request;

public class ikf {
    public static String O00000o;
    private static volatile ikf O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    final Pattern f1385O000000o = Pattern.compile("\\{\\w*\\}");
    final Pattern O00000Oo = Pattern.compile("\\[\\w*\\]");
    final Pattern O00000o0 = Pattern.compile("__\\w*__");
    private Map<String, String> O00000oo = new ConcurrentHashMap();
    private Context O0000O0o;

    private ikf(Context context) {
        if (context != null) {
            this.O0000O0o = context.getApplicationContext();
            this.O00000oo.put("OS", "0");
            Context context2 = this.O0000O0o;
            if (context2 != null) {
                try {
                    this.O00000oo.put("IMEI", imd.O000000o(ikk.O00000o0(context2)));
                } catch (Exception e) {
                    this.O00000oo.put("IMEI", "");
                    e.printStackTrace();
                }
                String str = null;
                try {
                    str = ikk.O00000o(this.O0000O0o);
                } catch (XimalayaException e2) {
                    e2.printStackTrace();
                }
                if (!TextUtils.isEmpty(str)) {
                    this.O00000oo.put("MAC1", imd.O000000o(str));
                    this.O00000oo.put("MAC", imd.O000000o(str.replaceAll(":", "")));
                }
                this.O00000oo.put("ANDROIDID", imd.O000000o(ikk.O000000o(this.O0000O0o)));
                this.O00000oo.put("ANDROIDID1", ikk.O000000o(this.O0000O0o));
                try {
                    Map<String, String> map = this.O00000oo;
                    iit.O000000o();
                    map.put("UA", iit.O0000OOo());
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                Map<String, String> map2 = this.O00000oo;
                iit.O000000o();
                map2.put("OSVS", iit.O00000oo());
                this.O00000oo.put("TERM", Build.MODEL);
                this.O00000oo.put("APPID", "0");
                try {
                    String encode = URLEncoder.encode(O000000o(), "UTF-8");
                    this.O00000oo.put("APPNAME", encode);
                    this.O00000oo.put("APP", encode);
                    this.O00000oo.put("ANAME", encode);
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
                Map<String, String> map3 = this.O00000oo;
                ilp O000000o2 = ilp.O000000o(this.O0000O0o);
                String O00000o02 = O000000o2.O00000o0("ad_first_open_time");
                if (TextUtils.isEmpty(O00000o02)) {
                    O00000o02 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());
                    O000000o2.O000000o("ad_first_open_time", O00000o02);
                }
                map3.put("FIRSTOPENTIME", O00000o02);
            }
        }
    }

    public static ikf O000000o(Context context) {
        if (O00000oO == null) {
            synchronized (ikf.class) {
                if (O00000oO == null) {
                    O00000oO = new ikf(context);
                }
            }
        }
        return O00000oO;
    }

    private String O000000o() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = this.O0000O0o.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(this.O0000O0o.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0084  */
    public final void O000000o(String str) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            String format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date(currentTimeMillis));
            this.O00000oo.put("TS", String.valueOf(currentTimeMillis));
            this.O00000oo.put("timestamp", String.valueOf(currentTimeMillis));
            this.O00000oo.put("clicktime", String.valueOf(currentTimeMillis));
            this.O00000oo.put("CLICKTIME", format);
            Map<String, String> map = this.O00000oo;
            Context context = this.O0000O0o;
            if (TextUtils.isEmpty(O00000o)) {
                int O00000Oo2 = O00000Oo(context);
                if (O00000Oo2 == 0) {
                    O00000o = O00000Oo();
                } else if (O00000Oo2 == 1) {
                    O00000o = O00000o0(context);
                }
                if (TextUtils.isEmpty(O00000o)) {
                    str2 = "192.168.1.1";
                    map.put("IP", str2);
                    if (!TextUtils.isEmpty(str)) {
                        str3 = null;
                    } else {
                        str3 = O000000o(O000000o(O000000o(str, this.f1385O000000o, 1), this.O00000Oo, 1), this.O00000o0, 2).replace(" ", "");
                    }
                    iiz.O000000o().O000000o(new Request.Builder().url(str3).build(), null);
                }
            }
            str2 = O00000o;
            map.put("IP", str2);
            if (!TextUtils.isEmpty(str)) {
            }
            iiz.O000000o().O000000o(new Request.Builder().url(str3).build(), null);
        }
    }

    private String O000000o(String str, Pattern pattern, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null) {
                if (group.length() > i && i < group.length() - i) {
                    String upperCase = group.substring(i, group.length() - i).toUpperCase();
                    String str2 = this.O00000oo.get(upperCase);
                    if (!TextUtils.isEmpty(str2)) {
                        group = str2;
                    } else if ("IMEI".equals(upperCase)) {
                        group = "";
                    }
                }
                matcher.appendReplacement(stringBuffer, group);
            }
        }
        return matcher.appendTail(stringBuffer).toString();
    }

    private static int O00000Oo(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null) {
            return -1;
        }
        NetworkInfo networkInfo = null;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return -1;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused2) {
        }
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return -1;
        }
        return networkInfo.getType() == 1 ? 1 : 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0014 A[SYNTHETIC] */
    private static String O00000Oo() {
        boolean z;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            String hostAddress = nextElement.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress) && hostAddress.length() >= 7) {
                                if (hostAddress.length() <= 15) {
                                    z = Pattern.compile("^((\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5]))$").matcher(hostAddress).find();
                                    if (!z) {
                                        return nextElement.getHostAddress();
                                    }
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String O00000o0(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        WifiInfo wifiInfo = null;
        try {
            wifiInfo = wifiManager.getConnectionInfo();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (wifiInfo == null) {
            return "";
        }
        int ipAddress = wifiInfo.getIpAddress();
        return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
    }
}
