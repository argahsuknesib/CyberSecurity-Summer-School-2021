package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class a {
    private static final CookieManager c = new CookieManager();

    /* renamed from: com.alipay.sdk.net.a$a  reason: collision with other inner class name */
    public static final class C0018a {

        /* renamed from: a  reason: collision with root package name */
        public final String f3193a;
        public final byte[] b;
        public final Map<String, String> c;

        public C0018a(String str, Map<String, String> map, byte[] bArr) {
            this.f3193a = str;
            this.b = bArr;
            this.c = map;
        }

        public final String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", this.f3193a, this.c);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<String>> f3194a;
        public final String b;
        public final byte[] c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f3194a = map;
            this.b = str;
            this.c = bArr;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0172 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b7 A[SYNTHETIC, Splitter:B:103:0x01b7] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01be A[SYNTHETIC, Splitter:B:107:0x01be] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c5 A[SYNTHETIC, Splitter:B:111:0x01c5] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ad A[Catch:{ Throwable -> 0x018e, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e6 A[Catch:{ Throwable -> 0x018e, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f3 A[Catch:{ Throwable -> 0x018e, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0105 A[Catch:{ Throwable -> 0x0187, all -> 0x0185 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0137 A[Catch:{ Throwable -> 0x017f, all -> 0x017b }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016f A[SYNTHETIC, Splitter:B:59:0x016f] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0177 A[SYNTHETIC, Splitter:B:65:0x0177] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01a0 A[SYNTHETIC, Splitter:B:88:0x01a0] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01a7 A[SYNTHETIC, Splitter:B:92:0x01a7] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01ae A[SYNTHETIC, Splitter:B:96:0x01ae] */
    public static b a(Context context, C0018a aVar) {
        HttpURLConnection httpURLConnection;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        List<String> list;
        BufferedInputStream bufferedInputStream3 = null;
        if (context == null) {
            return null;
        }
        try {
            c.b("mspl", "conn config: ".concat(String.valueOf(aVar)));
            URL url = new URL(aVar.f3193a);
            Proxy a2 = a(context);
            c.b("mspl", "conn proxy: ".concat(String.valueOf(a2)));
            if (a2 != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(a2);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                System.setProperty("http.keepAlive", "false");
                if (c.getCookieStore().getCookies().size() > 0) {
                    httpURLConnection.setRequestProperty("Cookie", TextUtils.join(";", c.getCookieStore().getCookies()));
                }
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", "msp");
                if (aVar.b != null) {
                    if (aVar.b.length > 0) {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream;binary/octet-stream");
                        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                        httpURLConnection.setRequestProperty("Keep-Alive", "timeout=180, max=100");
                        if (aVar.c != null) {
                            for (Map.Entry next : aVar.c.entrySet()) {
                                if (next.getKey() != null) {
                                    httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                                }
                            }
                        }
                        httpURLConnection.setDoInput(true);
                        if ("POST".equals(httpURLConnection.getRequestMethod())) {
                            httpURLConnection.setDoOutput(true);
                        }
                        if (!"POST".equals(httpURLConnection.getRequestMethod())) {
                            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                bufferedOutputStream.write(aVar.b);
                                bufferedOutputStream.flush();
                            } catch (Throwable th2) {
                                th = th2;
                                if (httpURLConnection != null) {
                                }
                                if (bufferedInputStream3 != null) {
                                }
                                if (bufferedOutputStream != null) {
                                }
                                throw th;
                            }
                        } else {
                            bufferedOutputStream = null;
                        }
                        bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                        byte[] a3 = a(bufferedInputStream2);
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        String join = (headerFields != null || headerFields.get(null) == null) ? null : TextUtils.join(",", headerFields.get(null));
                        list = headerFields.get("Set-Cookie");
                        if (list != null) {
                            for (String parse : list) {
                                List<HttpCookie> parse2 = HttpCookie.parse(parse);
                                if (parse2 != null && !parse2.isEmpty()) {
                                    c.getCookieStore().add(url.toURI(), parse2.get(0));
                                }
                            }
                        }
                        b bVar = new b(headerFields, join, a3);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        try {
                            bufferedInputStream2.close();
                        } catch (Throwable unused) {
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        return bVar;
                    }
                }
                httpURLConnection.setRequestMethod("GET");
                if (aVar.c != null) {
                }
                httpURLConnection.setDoInput(true);
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                }
                if (!"POST".equals(httpURLConnection.getRequestMethod())) {
                }
                bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] a32 = a(bufferedInputStream2);
                    Map<String, List<String>> headerFields2 = httpURLConnection.getHeaderFields();
                    if (headerFields2 != null) {
                    }
                    list = headerFields2.get("Set-Cookie");
                    if (list != null) {
                    }
                    b bVar2 = new b(headerFields2, join, a32);
                    if (httpURLConnection != null) {
                    }
                    bufferedInputStream2.close();
                    if (bufferedOutputStream != null) {
                    }
                    return bVar2;
                } catch (Throwable th3) {
                    bufferedInputStream3 = bufferedInputStream2;
                    th = th3;
                    if (httpURLConnection != null) {
                    }
                    if (bufferedInputStream3 != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                }
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (Throwable unused4) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedOutputStream = null;
            if (httpURLConnection != null) {
            }
            if (bufferedInputStream3 != null) {
            }
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
    }

    private static Proxy a(Context context) {
        String c2 = c(context);
        if (c2 != null && !c2.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static NetworkInfo b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String c(Context context) {
        try {
            NetworkInfo b2 = b(context);
            if (b2 != null && b2.isAvailable()) {
                if (b2.getType() == 1) {
                    return "wifi";
                }
                return b2.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
