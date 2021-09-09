package _m_j;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public final class dhy {

    /* renamed from: O000000o  reason: collision with root package name */
    static dhy f14653O000000o;
    public Map<String, String> O00000Oo = null;
    private Context O00000o0;

    dhy(Context context) {
        this.O00000o0 = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:99:0x0180 A[Catch:{ all -> 0x0174, Throwable -> 0x0194 }] */
    public final byte[] O000000o(String str, byte[] bArr, dib dib, Map<String, String> map) {
        long j;
        int i;
        Throwable th;
        Throwable th2;
        long j2;
        Object[] objArr;
        boolean z;
        byte[] bArr2 = bArr;
        dib dib2 = dib;
        byte[] bArr3 = null;
        int i2 = 0;
        if (str == null) {
            did.O00000oO("Failed for no URL.", new Object[0]);
            return null;
        }
        if (bArr2 == null) {
            j = 0;
        } else {
            j = (long) bArr2.length;
        }
        int i3 = 1;
        did.O00000o0("request: %s, send: %d (pid=%d | tid=%d)", str, Long.valueOf(j), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str2 = str;
        int i4 = 0;
        int i5 = 0;
        boolean z2 = false;
        while (i4 <= 0 && i5 <= 0) {
            if (z2) {
                i = i4;
                z2 = false;
            } else {
                int i6 = i4 + 1;
                if (i6 > i3) {
                    did.O00000o0("try time: ".concat(String.valueOf(i6)), new Object[i2]);
                    z = z2;
                    SystemClock.sleep(((long) new Random(System.currentTimeMillis()).nextInt(C.MSG_CUSTOM_BASE)) + 10000);
                } else {
                    z = z2;
                }
                z2 = z;
                i = i6;
            }
            String O00000oo = dgt.O00000oo(this.O00000o0);
            if (O00000oo == null) {
                did.O00000o("Failed to request for network not avail", new Object[i2]);
            } else {
                dib2.f14658O000000o += i3;
                dib2.O00000Oo += j;
                HttpURLConnection O000000o2 = O000000o(str2, bArr2, O00000oo, map);
                if (O000000o2 != null) {
                    try {
                        int responseCode = O000000o2.getResponseCode();
                        if (responseCode == 200) {
                            this.O00000Oo = O000000o(O000000o2);
                            byte[] O00000Oo2 = O00000Oo(O000000o2);
                            if (O00000Oo2 == null) {
                                j2 = 0;
                            } else {
                                j2 = (long) O00000Oo2.length;
                            }
                            dib2.O000000o(j2);
                            try {
                                O000000o2.disconnect();
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                if (!did.O000000o(th4)) {
                                    th4.printStackTrace();
                                }
                            }
                            return O00000Oo2;
                        }
                        if (responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                            try {
                                String headerField = O000000o2.getHeaderField("Location");
                                if (headerField == null) {
                                    try {
                                        did.O00000oO("Failed to redirect: %d".concat(String.valueOf(responseCode)), new Object[0]);
                                        try {
                                            O000000o2.disconnect();
                                            return null;
                                        } catch (Throwable th5) {
                                            Throwable th6 = th5;
                                            if (did.O000000o(th6)) {
                                                return null;
                                            }
                                            th6.printStackTrace();
                                            return null;
                                        }
                                    } catch (IOException e) {
                                        e = e;
                                        z2 = true;
                                        try {
                                            if (!did.O000000o(e)) {
                                            }
                                            i4 = i;
                                            bArr3 = null;
                                            i2 = 0;
                                            i3 = 1;
                                        } catch (Throwable th7) {
                                            Throwable th8 = th7;
                                            if (!did.O000000o(th8)) {
                                                th8.printStackTrace();
                                            }
                                        }
                                        try {
                                            O000000o2.disconnect();
                                        } catch (Throwable th9) {
                                            th = th9;
                                            if (did.O000000o(th)) {
                                            }
                                            th.printStackTrace();
                                        }
                                    }
                                } else {
                                    i5++;
                                    try {
                                        objArr = new Object[2];
                                        objArr[0] = Integer.valueOf(responseCode);
                                    } catch (IOException e2) {
                                        e = e2;
                                        str2 = headerField;
                                        i = 0;
                                        z2 = true;
                                        if (!did.O000000o(e)) {
                                        }
                                        O000000o2.disconnect();
                                        i4 = i;
                                        bArr3 = null;
                                        i2 = 0;
                                        i3 = 1;
                                    }
                                    try {
                                        objArr[1] = headerField;
                                        did.O00000o0("redirect code: %d ,to:%s", objArr);
                                        str2 = headerField;
                                        i = 0;
                                        z2 = true;
                                    } catch (IOException e3) {
                                        e = e3;
                                        str2 = headerField;
                                        i = 0;
                                        z2 = true;
                                        if (!did.O000000o(e)) {
                                        }
                                        O000000o2.disconnect();
                                        i4 = i;
                                        bArr3 = null;
                                        i2 = 0;
                                        i3 = 1;
                                    }
                                }
                            } catch (IOException e4) {
                                e = e4;
                                z2 = true;
                                if (!did.O000000o(e)) {
                                    e.printStackTrace();
                                }
                                O000000o2.disconnect();
                                i4 = i;
                                bArr3 = null;
                                i2 = 0;
                                i3 = 1;
                            }
                        }
                        try {
                            did.O00000o("response code ".concat(String.valueOf(responseCode)), new Object[0]);
                            long contentLength = (long) O000000o2.getContentLength();
                            if (contentLength < 0) {
                                contentLength = 0;
                            }
                            dib2.O000000o(contentLength);
                        } catch (IOException e5) {
                            e = e5;
                            if (!did.O000000o(e)) {
                            }
                            O000000o2.disconnect();
                            i4 = i;
                            bArr3 = null;
                            i2 = 0;
                            i3 = 1;
                        }
                        try {
                            O000000o2.disconnect();
                        } catch (Throwable th10) {
                            th = th10;
                            if (did.O000000o(th)) {
                            }
                            th.printStackTrace();
                        }
                    } catch (IOException e6) {
                        e = e6;
                        if (!did.O000000o(e)) {
                        }
                        O000000o2.disconnect();
                        i4 = i;
                        bArr3 = null;
                        i2 = 0;
                        i3 = 1;
                    }
                } else {
                    did.O00000o0("Failed to execute post.", new Object[0]);
                    dib2.O000000o(0);
                }
            }
            i4 = i;
            bArr3 = null;
            i2 = 0;
            i3 = 1;
        }
        return bArr3;
        throw th2;
    }

    private static Map<String, String> O000000o(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String next : headerFields.keySet()) {
            List list = headerFields.get(next);
            if (list.size() > 0) {
                hashMap.put(next, list.get(0));
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A[SYNTHETIC, Splitter:B:26:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004f A[SYNTHETIC, Splitter:B:33:0x004f] */
    private static byte[] O00000Oo(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!did.O000000o(th)) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static HttpURLConnection O000000o(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            did.O00000oO("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection O000000o2 = O000000o(str2, str);
        if (O000000o2 == null) {
            did.O00000oO("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            O000000o2.setRequestProperty("wup_version", "3.0");
            if (map != null) {
                if (map.size() > 0) {
                    for (Map.Entry next : map.entrySet()) {
                        O000000o2.setRequestProperty((String) next.getKey(), URLEncoder.encode((String) next.getValue(), "utf-8"));
                    }
                }
            }
            O000000o2.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            O000000o2.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = O000000o2.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return O000000o2;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            did.O00000oO("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    private static HttpURLConnection O000000o(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(C.MSG_CUSTOM_BASE);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
