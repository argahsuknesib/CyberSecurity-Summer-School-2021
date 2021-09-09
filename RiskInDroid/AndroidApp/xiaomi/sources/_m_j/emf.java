package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class emf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Pattern f15624O000000o = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern O00000Oo = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern O00000o0 = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static final class O000000o extends FilterInputStream {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f15625O000000o;

        public O000000o(InputStream inputStream) {
            super(inputStream);
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read;
            if (!this.f15625O000000o && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.f15625O000000o = true;
            return -1;
        }
    }

    public static emd O000000o(Context context, String str, Map<String, String> map) {
        return O000000o(context, str, "POST", (Map<String, String>) null, O000000o(map));
    }

    public static String O000000o(Context context, URL url) {
        return O000000o(context, url, "UTF-8");
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:4:0x0010 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:40:0x011d */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static String O000000o(String str, Map<String, String> map, File file, String str2) {
        ? r9;
        File file2;
        Object obj;
        FileInputStream fileInputStream = null;
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
            for (Map.Entry next : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes("--*****\r\n");
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
            dataOutputStream.writeBytes("\r\n");
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                    dataOutputStream.flush();
                }
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.writeBytes("--");
                dataOutputStream.writeBytes("*****");
                dataOutputStream.writeBytes("--");
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.flush();
                StringBuffer stringBuffer = new StringBuffer();
                ? bufferedReader = new BufferedReader(new InputStreamReader(new O000000o(httpURLConnection.getInputStream())));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            String stringBuffer2 = stringBuffer.toString();
                            ele.O000000o(fileInputStream2);
                            ele.O000000o((Closeable) bufferedReader);
                            return stringBuffer2;
                        }
                    } catch (IOException e) {
                        e = e;
                        throw new IOException("IOException:" + e.getClass().getSimpleName());
                    } catch (Throwable th) {
                        th = th;
                        obj = bufferedReader;
                        fileInputStream = fileInputStream2;
                        r9 = obj;
                        ele.O000000o(fileInputStream);
                        ele.O000000o((Closeable) r9);
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            } catch (Throwable th2) {
                th = th2;
                obj = null;
                fileInputStream = fileInputStream2;
                r9 = obj;
                ele.O000000o(fileInputStream);
                ele.O000000o((Closeable) r9);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw new IOException("IOException:" + e.getClass().getSimpleName());
        } catch (Throwable th3) {
            th = th3;
            r9 = file;
            ele.O000000o(fileInputStream);
            ele.O000000o((Closeable) r9);
            throw th;
        }
    }

    private static String O000000o(Map<String, String> map) {
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
                } catch (UnsupportedEncodingException e) {
                    duv.O000000o("Failed to convert from params map to string: ".concat(String.valueOf(e)));
                    duv.O000000o("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static boolean O000000o(Context context) {
        return O0000Oo(context) >= 0;
    }

    public static emd O00000Oo(Context context, String str, Map<String, String> map) {
        String O000000o2 = O000000o(map);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", "gzip");
        return O000000o(context, str, "POST", hashMap, O000000o2);
    }

    private static HttpURLConnection O00000Oo(Context context, URL url) {
        return (HttpURLConnection) (("http".equals(url.getProtocol()) && O0000OoO(context)) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
    }

    public static boolean O00000Oo(Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (Exception unused) {
                }
            } else {
                z = O000000o(context);
            }
            return !z && O00000o0(context);
        }
        z = false;
        if (!z) {
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static boolean O00000o(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType()) ? false : true;
        } catch (Exception unused) {
        }
    }

    public static boolean O00000o0(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean O00000oO(Context context) {
        NetworkInfo O0000Ooo = O0000Ooo(context);
        return O0000Ooo != null && O0000Ooo.getType() == 0 && 20 == O0000Ooo.getSubtype();
    }

    public static boolean O00000oo(Context context) {
        NetworkInfo O0000Ooo = O0000Ooo(context);
        return O0000Ooo != null && O0000Ooo.getType() == 0 && 13 == O0000Ooo.getSubtype();
    }

    public static boolean O0000O0o(Context context) {
        NetworkInfo O0000Ooo = O0000Ooo(context);
        if (O0000Ooo == null || O0000Ooo.getType() != 0) {
            return false;
        }
        String subtypeName = O0000Ooo.getSubtypeName();
        if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
            switch (O0000Ooo.getSubtype()) {
                case 3:
                case 5:
                case 6:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                case 9:
                case 10:
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                case 14:
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    break;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean O0000OOo(Context context) {
        NetworkInfo O0000Ooo = O0000Ooo(context);
        if (O0000Ooo == null || O0000Ooo.getType() != 0) {
            return false;
        }
        int subtype = O0000Ooo.getSubtype();
        return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static int O0000Oo(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static String O0000Oo0(Context context) {
        NetworkInfo activeNetworkInfo;
        if (O00000o(context)) {
            return "wifi";
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

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private static boolean O0000OoO(Context context) {
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
            return !TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && extraInfo.contains("ctwap");
        } catch (Exception unused) {
        }
    }

    private static NetworkInfo O0000Ooo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    private static InputStream O000000o(Context context, URL url, boolean z, String str, String str2) {
        String str3;
        if (context == null) {
            throw new IllegalArgumentException("context");
        } else if (url != null) {
            String url2 = url.toString();
            if (!TextUtils.isEmpty(url2)) {
                new String();
                str3 = String.format("%s&key=%s", url2, emk.O000000o(String.format("%sbe988a6134bc8254465424e5a70ef037", url2)));
            } else {
                str3 = null;
            }
            URL url3 = new URL(str3);
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection O00000Oo2 = O00000Oo(context, url3);
                O00000Oo2.setConnectTimeout(C.MSG_CUSTOM_BASE);
                O00000Oo2.setReadTimeout(15000);
                if (!TextUtils.isEmpty(null)) {
                    O00000Oo2.setRequestProperty("User-Agent", null);
                }
                return new O000000o(O00000Oo2.getInputStream());
            } catch (IOException e) {
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        } else {
            throw new IllegalArgumentException("url");
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emf.O000000o(android.content.Context, java.net.URL, boolean, java.lang.String, java.lang.String):java.io.InputStream
     arg types: [android.content.Context, java.net.URL, int, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY]]
     candidates:
      _m_j.emf.O000000o(android.content.Context, java.lang.String, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, java.lang.String):_m_j.emd
      _m_j.emf.O000000o(android.content.Context, java.net.URL, boolean, java.lang.String, java.lang.String):java.io.InputStream */
    private static String O000000o(Context context, URL url, String str) {
        try {
            InputStream O000000o2 = O000000o(context, url, false, (String) null, (String) null);
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(O000000o2, str));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 != read) {
                    sb.append(cArr, 0, read);
                } else {
                    ele.O000000o(O000000o2);
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            ele.O000000o((Closeable) null);
            throw th;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:1:0x0006 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:48:0x010f */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010a, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010b, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010d, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010e, code lost:
        r8 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00be */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:23:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:1:0x0006] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static emd O000000o(Context context, String str, String str2, Map<String, String> map, String str3) {
        ? r8;
        boolean z;
        emd emd = new emd();
        OutputStream outputStream = null;
        try {
            HttpURLConnection O00000Oo2 = O00000Oo(context, new URL(str));
            O00000Oo2.setConnectTimeout(C.MSG_CUSTOM_BASE);
            O00000Oo2.setReadTimeout(15000);
            O00000Oo2.setRequestMethod(str2);
            int i = 0;
            if (map != null) {
                z = "gzip".equalsIgnoreCase(map.get("Content-Encoding"));
                for (String next : map.keySet()) {
                    O00000Oo2.setRequestProperty(next, map.get(next));
                }
            } else {
                z = false;
            }
            if (!TextUtils.isEmpty(str3)) {
                O00000Oo2.setDoOutput(true);
                byte[] bytes = str3.getBytes();
                OutputStream gZIPOutputStream = z ? new GZIPOutputStream(O00000Oo2.getOutputStream()) : O00000Oo2.getOutputStream();
                try {
                    gZIPOutputStream.write(bytes, 0, bytes.length);
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                } catch (IOException e) {
                    e = e;
                } catch (Throwable th) {
                    th = th;
                    r8 = 0;
                    outputStream = gZIPOutputStream;
                    ele.O000000o(outputStream);
                    ele.O000000o((Closeable) r8);
                    throw th;
                }
            }
            emd.f15623O000000o = O00000Oo2.getResponseCode();
            duv.O000000o("Http POST Response Code: " + emd.f15623O000000o);
            while (true) {
                String headerFieldKey = O00000Oo2.getHeaderFieldKey(i);
                String headerField = O00000Oo2.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new O000000o(O00000Oo2.getInputStream())));
                    bufferedReader = new BufferedReader(new InputStreamReader(new O000000o(O00000Oo2.getErrorStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                        }
                        emd.O00000o0 = stringBuffer.toString();
                        bufferedReader.close();
                        ele.O000000o((Closeable) null);
                        ele.O000000o((Closeable) null);
                        return emd;
                    } catch (IOException e2) {
                        e = e2;
                        throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = bufferedReader;
                        throw new IOException(th.getMessage());
                    }
                } else {
                    emd.O00000Oo.put(headerFieldKey, headerField);
                    i = i + 1 + 1;
                }
            }
        } catch (IOException e3) {
            e = e3;
            throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
        } catch (Throwable th3) {
            th = th3;
            r8 = str2;
            ele.O000000o(outputStream);
            ele.O000000o((Closeable) r8);
            throw th;
        }
    }
}
