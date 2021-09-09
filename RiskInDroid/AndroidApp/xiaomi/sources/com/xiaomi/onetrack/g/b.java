package com.xiaomi.onetrack.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.d.f;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.n;
import com.xiaomi.onetrack.h.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class b {
    private static String h = "HttpUtil";

    private b() {
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARNING: Multi-variable type inference failed */
    public static String a(String str, byte[] bArr) throws IOException {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        OutputStream outputStream2;
        InputStream inputStream2;
        OutputStream outputStream3;
        int responseCode;
        q.a(h, "doPost url=" + str + ", len=" + bArr.length);
        InputStream inputStream3 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                String str2 = f.a().b()[1];
                httpURLConnection.setRequestProperty("OT_SID", str2);
                httpURLConnection.setRequestProperty("OT_ts", Long.toString(System.currentTimeMillis()));
                httpURLConnection.setRequestProperty("OT_net", c.a(a.a()).toString());
                httpURLConnection.setRequestProperty("OT_sender", a.d());
                httpURLConnection.setRequestProperty("OT_protocol", "3.0");
                q.a(h, "sid:".concat(String.valueOf(str2)));
                outputStream3 = httpURLConnection.getOutputStream();
            } catch (IOException e) {
                e = e;
                inputStream2 = null;
                inputStream = inputStream2;
                outputStream2 = inputStream2;
                try {
                    q.b(h, String.format("HttpUtils POST 上传失败, url: %s, error: %s", str, e.getMessage()));
                    n.a(inputStream);
                    n.a((OutputStream) outputStream2);
                    n.a(httpURLConnection);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream3 = inputStream;
                    outputStream = outputStream2;
                    n.a(inputStream3);
                    n.a(outputStream);
                    n.a(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                n.a(inputStream3);
                n.a(outputStream);
                n.a(httpURLConnection);
                throw th;
            }
            try {
                outputStream3.write(bArr, 0, bArr.length);
                outputStream3.flush();
                responseCode = httpURLConnection.getResponseCode();
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                outputStream2 = outputStream3;
                q.b(h, String.format("HttpUtils POST 上传失败, url: %s, error: %s", str, e.getMessage()));
                n.a(inputStream);
                n.a((OutputStream) outputStream2);
                n.a(httpURLConnection);
                return null;
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream3;
                n.a(inputStream3);
                n.a(outputStream);
                n.a(httpURLConnection);
                throw th;
            }
            try {
                byte[] b = n.b(inputStream);
                q.a(h, String.format("HttpUtils POST 上传成功 url: %s, code: %s", str, Integer.valueOf(responseCode)));
                String str3 = new String(b, "UTF-8");
                n.a(inputStream);
                n.a(outputStream3);
                n.a(httpURLConnection);
                return str3;
            } catch (IOException e3) {
                e = e3;
                outputStream2 = outputStream3;
                q.b(h, String.format("HttpUtils POST 上传失败, url: %s, error: %s", str, e.getMessage()));
                n.a(inputStream);
                n.a((OutputStream) outputStream2);
                n.a(httpURLConnection);
                return null;
            }
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            inputStream2 = null;
            inputStream = inputStream2;
            outputStream2 = inputStream2;
            q.b(h, String.format("HttpUtils POST 上传失败, url: %s, error: %s", str, e.getMessage()));
            n.a(inputStream);
            n.a((OutputStream) outputStream2);
            n.a(httpURLConnection);
            return null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            outputStream = null;
            n.a(inputStream3);
            n.a(outputStream);
            n.a(httpURLConnection);
            throw th;
        }
    }

    public static String a(String str) throws IOException {
        return a(str, null, false);
    }

    public static String a(String str, Map<String, String> map) throws IOException {
        return a(str, map, true);
    }

    public static String a(String str, Map<String, String> map, boolean z) throws IOException {
        return a("GET", str, map, z);
    }

    public static String b(String str, Map<String, String> map) throws IOException {
        return b(str, map, true);
    }

    public static String b(String str, Map<String, String> map, boolean z) throws IOException {
        return a("POST", str, map, z);
    }

    private static String a(String str, String str2, Map<String, String> map, boolean z) {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream;
        String str3;
        String str4;
        InputStream inputStream2 = null;
        if (map == null) {
            str3 = null;
        } else {
            try {
                str3 = a(map, z);
            } catch (Exception e) {
                e = e;
                outputStream = null;
                httpURLConnection = null;
                inputStream = null;
                try {
                    q.b(h, "HttpUtils POST 上传异常", e);
                    n.a(inputStream);
                    n.a(outputStream);
                    n.a(httpURLConnection);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    n.a(inputStream2);
                    n.a(outputStream);
                    n.a(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                httpURLConnection = null;
                n.a(inputStream2);
                n.a(outputStream);
                n.a(httpURLConnection);
                throw th;
            }
        }
        if (!"GET".equals(str) || str3 == null) {
            str4 = str2;
        } else {
            str4 = str2 + "? " + str3;
        }
        httpURLConnection = (HttpURLConnection) new URL(str4).openConnection();
        try {
            httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
            httpURLConnection.setReadTimeout(15000);
            if ("GET".equals(str)) {
                httpURLConnection.setRequestMethod("GET");
            } else if ("POST".equals(str) && str3 != null) {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setDoOutput(true);
                byte[] bytes = str3.getBytes("UTF-8");
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bytes, 0, bytes.length);
                    outputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    inputStream = httpURLConnection.getInputStream();
                    byte[] b = n.b(inputStream);
                    q.a(h, String.format("HttpUtils POST 上传成功 url: %s, code: %s", str2, Integer.valueOf(responseCode)));
                    String str5 = new String(b, "UTF-8");
                    n.a(inputStream);
                    n.a(outputStream);
                    n.a(httpURLConnection);
                    return str5;
                } catch (Exception e2) {
                    e = e2;
                    inputStream = null;
                    q.b(h, "HttpUtils POST 上传异常", e);
                    n.a(inputStream);
                    n.a(outputStream);
                    n.a(httpURLConnection);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    n.a(inputStream2);
                    n.a(outputStream);
                    n.a(httpURLConnection);
                    throw th;
                }
            }
            outputStream = null;
            int responseCode2 = httpURLConnection.getResponseCode();
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] b2 = n.b(inputStream);
                q.a(h, String.format("HttpUtils POST 上传成功 url: %s, code: %s", str2, Integer.valueOf(responseCode2)));
                String str52 = new String(b2, "UTF-8");
                n.a(inputStream);
                n.a(outputStream);
                n.a(httpURLConnection);
                return str52;
            } catch (Exception e3) {
                e = e3;
                q.b(h, "HttpUtils POST 上传异常", e);
                n.a(inputStream);
                n.a(outputStream);
                n.a(httpURLConnection);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            outputStream = null;
            inputStream = null;
            q.b(h, "HttpUtils POST 上传异常", e);
            n.a(inputStream);
            n.a(outputStream);
            n.a(httpURLConnection);
            return null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            n.a(inputStream2);
            n.a(outputStream);
            n.a(httpURLConnection);
            throw th;
        }
    }

    private static String a(Map<String, String> map, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            try {
                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(next.getValue() == null ? "null" : (String) next.getValue(), "UTF-8"));
                }
            } catch (UnsupportedEncodingException unused) {
                q.b(h, "format params failed");
            }
        }
        if (z) {
            String a2 = a(map);
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode("sign", "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(a2, "UTF-8"));
        }
        return sb.toString();
    }

    public static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            ArrayList<String> arrayList = new ArrayList<>(map.keySet());
            Collections.sort(arrayList);
            for (String str : arrayList) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    sb.append(map.get(str));
                }
            }
        }
        sb.append("miui_sdkconfig_jafej!@#)(*e@!#");
        return d.c(sb.toString());
    }
}
