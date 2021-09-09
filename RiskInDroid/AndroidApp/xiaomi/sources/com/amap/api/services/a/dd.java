package com.amap.api.services.a;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.services.a.db;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.PushbackInputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

public class dd {

    /* renamed from: a  reason: collision with root package name */
    private int f3395a;
    private int b;
    private boolean c;
    private SSLContext d;
    private Proxy e;
    private volatile boolean f;
    private long g;
    private long h;
    private String i;
    private a j;
    private db.a k;

    private void a() {
        try {
            this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            ci.a(th, "ht", "ic");
        }
    }

    dd(int i2, int i3, Proxy proxy, boolean z) {
        this(i2, i3, proxy, z, null);
    }

    dd(int i2, int i3, Proxy proxy, boolean z, db.a aVar) {
        this.f = false;
        this.g = -1;
        this.h = 0;
        this.f3395a = i2;
        this.b = i3;
        this.e = proxy;
        this.c = bv.a().b(z);
        if (bv.c()) {
            this.c = false;
        }
        this.k = aVar;
        a();
        if (this.c) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.d = instance;
            } catch (Throwable th) {
                ci.a(th, "ht", "ne");
            }
        }
        this.j = new a();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0097 A[SYNTHETIC, Splitter:B:65:0x0097] */
    public dh a(String str, boolean z, String str2, Map<String, String> map, Map<String, String> map2, boolean z2) throws bo {
        HttpURLConnection httpURLConnection = null;
        try {
            String a2 = a(map2);
            StringBuffer stringBuffer = new StringBuffer();
            String str3 = str;
            stringBuffer.append(str);
            if (a2 != null) {
                stringBuffer.append("?");
                stringBuffer.append(a2);
            }
            httpURLConnection = a(stringBuffer.toString(), z, str2, map, false);
            try {
                dh a3 = a(httpURLConnection, z2);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        ci.a(th, "ht", "mgr");
                    }
                }
                return a3;
            } catch (ConnectException unused) {
                throw new bo("http连接失败 - ConnectionException");
            } catch (MalformedURLException unused2) {
                throw new bo("url异常 - MalformedURLException");
            } catch (UnknownHostException unused3) {
                throw new bo("未知主机 - UnKnowHostException");
            } catch (SocketException unused4) {
                throw new bo("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException unused5) {
                throw new bo("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused6) {
                throw new bo("未知的错误");
            } catch (IOException unused7) {
                throw new bo("IO 操作异常 - IOException");
            } catch (bo e2) {
                e = e2;
                throw e;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                throw new bo("未知的错误");
            }
        } catch (ConnectException unused8) {
            throw new bo("http连接失败 - ConnectionException");
        } catch (MalformedURLException unused9) {
            throw new bo("url异常 - MalformedURLException");
        } catch (UnknownHostException unused10) {
            throw new bo("未知主机 - UnKnowHostException");
        } catch (SocketException unused11) {
            throw new bo("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException unused12) {
            throw new bo("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused13) {
            throw new bo("未知的错误");
        } catch (IOException unused14) {
            throw new bo("IO 操作异常 - IOException");
        } catch (bo e3) {
            e = e3;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            Throwable th4 = th;
            if (httpURLConnection != null) {
            }
            throw th4;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00b8 A[SYNTHETIC, Splitter:B:67:0x00b8] */
    public dh a(String str, boolean z, String str2, Map<String, String> map, byte[] bArr, boolean z2) throws bo {
        byte[] bArr2 = bArr;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = a(str, z, str2, map, true);
            if (bArr2 != null && bArr2.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(bArr2);
                dataOutputStream.close();
            }
            try {
                dh a2 = a(httpURLConnection, z2);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        ci.a(th, "ht", "mPt");
                    }
                }
                return a2;
            } catch (ConnectException e2) {
                e = e2;
                e.printStackTrace();
                throw new bo("http连接失败 - ConnectionException");
            } catch (MalformedURLException e3) {
                e = e3;
                e.printStackTrace();
                throw new bo("url异常 - MalformedURLException");
            } catch (UnknownHostException e4) {
                e = e4;
                e.printStackTrace();
                throw new bo("未知主机 - UnKnowHostException");
            } catch (SocketException e5) {
                e = e5;
                e.printStackTrace();
                throw new bo("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException e6) {
                e = e6;
                e.printStackTrace();
                throw new bo("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused) {
                throw new bo("未知的错误");
            } catch (IOException e7) {
                e = e7;
                e.printStackTrace();
                throw new bo("IO 操作异常 - IOException");
            } catch (bo e8) {
                e = e8;
                ci.a(e, "ht", "mPt");
                throw e;
            } catch (Throwable th2) {
                th = th2;
                ci.a(th, "ht", "mPt");
                throw new bo("未知的错误");
            }
        } catch (ConnectException e9) {
            e = e9;
            e.printStackTrace();
            throw new bo("http连接失败 - ConnectionException");
        } catch (MalformedURLException e10) {
            e = e10;
            e.printStackTrace();
            throw new bo("url异常 - MalformedURLException");
        } catch (UnknownHostException e11) {
            e = e11;
            e.printStackTrace();
            throw new bo("未知主机 - UnKnowHostException");
        } catch (SocketException e12) {
            e = e12;
            e.printStackTrace();
            throw new bo("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e13) {
            e = e13;
            e.printStackTrace();
            throw new bo("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused2) {
            throw new bo("未知的错误");
        } catch (IOException e14) {
            e = e14;
            e.printStackTrace();
            throw new bo("IO 操作异常 - IOException");
        } catch (bo e15) {
            e = e15;
            ci.a(e, "ht", "mPt");
            throw e;
        } catch (Throwable th3) {
            th = th3;
            Throwable th4 = th;
            if (httpURLConnection != null) {
            }
            throw th4;
        }
    }

    private String a(int i2, String str, Map<String, String> map) {
        String str2 = i2 != 1 ? "" : db.b;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        String uri = parse.buildUpon().encodedAuthority(str2).build().toString();
        if (map != null) {
            map.put("targetHost", host);
        }
        if (this.c) {
            this.j.b(str2);
        }
        return uri;
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection a(String str, boolean z, String str2, Map<String, String> map, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection;
        bt.b();
        if (map == null) {
            map = new HashMap<>();
        }
        b a2 = this.j.a();
        if (z && !TextUtils.isEmpty(str2)) {
            a2 = this.j.a(str2);
        }
        String a3 = a(db.f3393a, str, map);
        if (this.c) {
            a3 = bv.a(a3);
        }
        URL url = new URL(a3);
        db.a aVar = this.k;
        URLConnection a4 = aVar != null ? aVar.a(this.e, url) : null;
        if (a4 == null) {
            Proxy proxy = this.e;
            if (proxy != null) {
                a4 = url.openConnection(proxy);
            } else {
                a4 = url.openConnection();
            }
        }
        if (this.c) {
            httpURLConnection = (HttpsURLConnection) a4;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.d.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(a2);
        } else {
            httpURLConnection = (HttpURLConnection) a4;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        a(map, httpURLConnection);
        if (z2) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x010d A[SYNTHETIC, Splitter:B:75:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0117 A[SYNTHETIC, Splitter:B:80:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0121 A[SYNTHETIC, Splitter:B:85:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x012b A[SYNTHETIC, Splitter:B:90:0x012b] */
    private dh a(HttpURLConnection httpURLConnection, boolean z) throws bo, IOException {
        InputStream inputStream;
        Throwable th;
        PushbackInputStream pushbackInputStream;
        PushbackInputStream pushbackInputStream2;
        PushbackInputStream pushbackInputStream3;
        InputStream inputStream2;
        List list;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            httpURLConnection.connect();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (!(headerFields == null || (list = headerFields.get("gsid")) == null || list.size() <= 0)) {
                str = (String) list.get(0);
            }
            if (responseCode == 200) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        pushbackInputStream = new PushbackInputStream(inputStream2, 2);
                        try {
                            byte[] bArr = new byte[2];
                            pushbackInputStream.read(bArr);
                            pushbackInputStream.unread(bArr);
                            FilterInputStream gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117 && !z) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = gZIPInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, read);
                            }
                            cl.b();
                            dh dhVar = new dh();
                            dhVar.f3399a = byteArrayOutputStream2.toByteArray();
                            dhVar.b = headerFields;
                            dhVar.c = this.i;
                            dhVar.d = str;
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Throwable th2) {
                                ci.a(th2, "ht", "par");
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th3) {
                                    ci.a(th3, "ht", "par");
                                }
                            }
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th4) {
                                ci.a(th4, "ht", "par");
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th5) {
                                ci.a(th5, "ht", "par");
                            }
                            return dhVar;
                        } catch (IOException unused) {
                            pushbackInputStream3 = null;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                throw new bo("IO 操作异常 - IOException", str);
                            } catch (Throwable th6) {
                                PushbackInputStream pushbackInputStream4 = pushbackInputStream3;
                                inputStream = inputStream2;
                                th = th6;
                                pushbackInputStream2 = pushbackInputStream4;
                                if (byteArrayOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (pushbackInputStream != null) {
                                }
                                if (pushbackInputStream2 != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            pushbackInputStream2 = null;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            Throwable th8 = th;
                            inputStream = inputStream2;
                            th = th8;
                            if (byteArrayOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (pushbackInputStream != null) {
                            }
                            if (pushbackInputStream2 != null) {
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        pushbackInputStream3 = null;
                        pushbackInputStream = pushbackInputStream3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        throw new bo("IO 操作异常 - IOException", str);
                    } catch (Throwable th9) {
                        th = th9;
                        pushbackInputStream2 = null;
                        pushbackInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        Throwable th82 = th;
                        inputStream = inputStream2;
                        th = th82;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th10) {
                                ci.a(th10, "ht", "par");
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th11) {
                                ci.a(th11, "ht", "par");
                            }
                        }
                        if (pushbackInputStream != null) {
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th12) {
                                ci.a(th12, "ht", "par");
                            }
                        }
                        if (pushbackInputStream2 != null) {
                            try {
                                pushbackInputStream2.close();
                            } catch (Throwable th13) {
                                ci.a(th13, "ht", "par");
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                    inputStream2 = null;
                    pushbackInputStream3 = null;
                    pushbackInputStream = pushbackInputStream3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    throw new bo("IO 操作异常 - IOException", str);
                } catch (Throwable th14) {
                    th = th14;
                    inputStream = null;
                    pushbackInputStream2 = null;
                    pushbackInputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (pushbackInputStream != null) {
                    }
                    if (pushbackInputStream2 != null) {
                    }
                    throw th;
                }
            } else {
                bo boVar = new bo("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.i, str);
                boVar.a(responseCode);
                throw boVar;
            }
        } catch (IOException unused4) {
            inputStream2 = null;
            pushbackInputStream3 = null;
            pushbackInputStream = null;
            throw new bo("IO 操作异常 - IOException", str);
        } catch (Throwable th15) {
            th = th15;
            inputStream = null;
            pushbackInputStream2 = null;
            pushbackInputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (pushbackInputStream != null) {
            }
            if (pushbackInputStream2 != null) {
            }
            throw th;
        }
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.addRequestProperty(next, map.get(next));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.i);
        } catch (Throwable th) {
            ci.a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.f3395a);
        httpURLConnection.setReadTimeout(this.b);
    }

    static class b implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        private String f3397a;
        private String b;

        private b() {
        }

        public void a(String str) {
            this.f3397a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public String a() {
            return this.b;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f3397a)) {
                return this.f3397a.equals(str);
            }
            if (!TextUtils.isEmpty(this.b)) {
                return defaultHostnameVerifier.verify(this.b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private Vector<b> f3396a;
        private volatile b b;

        private a() {
            this.f3396a = new Vector<>();
            this.b = new b();
        }

        public b a() {
            return this.b;
        }

        public b a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.f3396a.size(); i++) {
                b bVar = this.f3396a.get(i);
                if (bVar != null && bVar.a().equals(str)) {
                    return bVar;
                }
            }
            b bVar2 = new b();
            bVar2.b(str);
            this.f3396a.add(bVar2);
            return bVar2;
        }

        public void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b.a(str);
            }
        }
    }

    static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (str2 == null) {
                str2 = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str));
            sb.append("=");
            sb.append(URLEncoder.encode(str2));
        }
        return sb.toString();
    }
}
