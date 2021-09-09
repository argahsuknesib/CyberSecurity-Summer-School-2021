package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.mi.mistatistic.sdk.model.Stat;
import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public abstract class cdd {

    public interface O00000Oo {
        void O000000o(String str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static boolean O000000o(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static String O00000Oo(Context context) {
        NetworkInfo activeNetworkInfo;
        if (O000000o(context)) {
            return "WIFI";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "";
            }
            return (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:3:0x0007 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:28:0x008c */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c A[SYNTHETIC, Splitter:B:36:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a1 A[Catch:{ IOException -> 0x00a4 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static void O000000o(String str, Stat stat, O00000Oo o00000Oo) throws IOException {
        ? r5;
        ? bufferedReader;
        if (!TextUtils.isEmpty(str)) {
            OutputStream outputStream = null;
            try {
                HttpURLConnection O000000o2 = O000000o(ccx.O000000o(), new URL(str));
                O000000o2.setConnectTimeout(C.MSG_CUSTOM_BASE);
                O000000o2.setReadTimeout(15000);
                O000000o2.setRequestMethod("POST");
                O000000o2.setDoOutput(true);
                byte[] encode = stat.encode();
                OutputStream outputStream2 = O000000o2.getOutputStream();
                try {
                    outputStream2.write(encode, 0, encode.length);
                    outputStream2.flush();
                    outputStream2.close();
                    O000000o2.getResponseCode();
                    bufferedReader = new BufferedReader(new InputStreamReader(new O000000o(O000000o2.getInputStream())));
                } catch (IOException e) {
                    e = e;
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    r5 = 0;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                    }
                    if (r5 != 0) {
                    }
                    throw th;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    String property = System.getProperty("line.separator");
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        stringBuffer.append(readLine);
                        stringBuffer.append(property);
                    }
                    o00000Oo.O000000o(stringBuffer.toString());
                    bufferedReader.close();
                } catch (IOException e2) {
                    e = e2;
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    stat = bufferedReader;
                    throw new IOException(th.getMessage());
                }
            } catch (IOException e3) {
                e = e3;
                throw e;
            } catch (Throwable th3) {
                th = th3;
                r5 = stat;
                if (outputStream != null) {
                }
                if (r5 != 0) {
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("url");
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:3:0x0007 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:30:0x0098 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a8 A[SYNTHETIC, Splitter:B:38:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad A[Catch:{ IOException -> 0x00b0 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static void O000000o(Context context, String str, Map<String, String> map, O00000Oo o00000Oo) throws IOException {
        ? r5;
        ? bufferedReader;
        if (!TextUtils.isEmpty(str)) {
            OutputStream outputStream = null;
            try {
                HttpURLConnection O000000o2 = O000000o(context, new URL(str));
                O000000o2.setConnectTimeout(C.MSG_CUSTOM_BASE);
                O000000o2.setReadTimeout(15000);
                O000000o2.setRequestMethod("POST");
                O000000o(map);
                OutputStream outputStream2 = O000000o2.getOutputStream();
                try {
                    String O00000Oo2 = O00000Oo(map);
                    if (!TextUtils.isEmpty(O00000Oo2)) {
                        O000000o2.setDoOutput(true);
                        byte[] bytes = O00000Oo2.getBytes();
                        outputStream2.write(bytes, 0, bytes.length);
                    }
                    outputStream2.flush();
                    outputStream2.close();
                    O000000o2.getResponseCode();
                    bufferedReader = new BufferedReader(new InputStreamReader(new O000000o(O000000o2.getInputStream())));
                } catch (IOException e) {
                    e = e;
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    r5 = 0;
                    if (outputStream != null) {
                    }
                    if (r5 != 0) {
                    }
                    throw th;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    String property = System.getProperty("line.separator");
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        stringBuffer.append(readLine);
                        stringBuffer.append(property);
                    }
                    o00000Oo.O000000o(stringBuffer.toString());
                    bufferedReader.close();
                } catch (IOException e2) {
                    e = e2;
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    str = bufferedReader;
                    throw new IOException(th.getMessage());
                }
            } catch (IOException e3) {
                e = e3;
                throw e;
            } catch (Throwable th3) {
                th = th3;
                r5 = str;
                if (outputStream != null) {
                }
                if (r5 != 0) {
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("url");
        }
    }

    private static void O000000o(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        new HashMap();
        if (map != null) {
            ArrayList<String> arrayList = new ArrayList<>(map.keySet());
            cdc.O00000Oo("mistats_NetworkUtils_keys:" + arrayList.toString());
            Collections.sort(arrayList);
            for (String str : arrayList) {
                sb.append(str + map.get(str));
            }
        }
        sb.append("mistats_sdkconfig_jafej!@#)(*e@!#");
    }

    private static String O00000Oo(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : map.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException unused) {
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static final class O000000o extends FilterInputStream {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f13652O000000o;

        public O000000o(InputStream inputStream) {
            super(inputStream);
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read;
            if (!this.f13652O000000o && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.f13652O000000o = true;
            return -1;
        }
    }

    private static HttpURLConnection O000000o(Context context, URL url) throws IOException {
        if (!"http".equals(url.getProtocol())) {
            return (HttpURLConnection) url.openConnection();
        }
        if (O00000oO(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        if (!O00000o(context)) {
            return (HttpURLConnection) url.openConnection();
        }
        String host = url.getHost();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(O000000o(url)).openConnection();
        httpURLConnection.addRequestProperty("X-Online-Host", host);
        return httpURLConnection;
    }

    private static String O000000o(URL url) {
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

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static boolean O00000o(Context context) {
        NetworkInfo activeNetworkInfo;
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || extraInfo.contains("ctwap")) {
                return false;
            }
            return extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3);
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static boolean O00000oO(Context context) {
        NetworkInfo activeNetworkInfo;
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || !extraInfo.contains("ctwap")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    private static String O000000o() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                byte[] hardwareAddress = nextElement.getHardwareAddress();
                if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    String sb2 = sb.toString();
                    if ("wlan0".equals(nextElement.getName())) {
                        return sb2;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String O00000o0(Context context) {
        String O000000o2 = Build.VERSION.SDK_INT >= 23 ? O000000o() : "";
        if (TextUtils.isEmpty(O000000o2)) {
            try {
                O000000o2 = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return !TextUtils.isEmpty(O000000o2) ? O000000o(O000000o2) : O000000o2;
    }

    private static byte[] O00000Oo(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(O00000Oo(str));
                return String.format("%1$032X", new BigInteger(1, instance.digest()));
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
