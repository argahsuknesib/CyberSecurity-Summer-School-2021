package _m_j;

import _m_j.bsw;
import _m_j.bwy;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.loc.t;
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

public final class bsy {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f13256O000000o;
    private int O00000Oo;
    private SSLContext O00000o;
    private boolean O00000o0;
    private Proxy O00000oO;
    private volatile boolean O00000oo;
    private long O0000O0o;
    private long O0000OOo;
    private O000000o O0000Oo;
    private String O0000Oo0;
    private bsw.O000000o O0000OoO;

    static class O00000Oo implements HostnameVerifier {

        /* renamed from: O000000o  reason: collision with root package name */
        String f13258O000000o;
        String O00000Oo;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.f13258O000000o) ? this.f13258O000000o.equals(str) : !TextUtils.isEmpty(this.O00000Oo) ? defaultHostnameVerifier.verify(this.O00000Oo, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    bsy(int i, int i2, Proxy proxy, boolean z) {
        this(i, i2, proxy, z, (byte) 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x010d A[SYNTHETIC, Splitter:B:75:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0117 A[SYNTHETIC, Splitter:B:80:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0121 A[SYNTHETIC, Splitter:B:85:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x012b A[SYNTHETIC, Splitter:B:90:0x012b] */
    private bta O000000o(HttpURLConnection httpURLConnection, boolean z) throws t, IOException {
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
                            bsf.O00000o0();
                            bta bta = new bta();
                            bta.f13259O000000o = byteArrayOutputStream2.toByteArray();
                            bta.O00000Oo = headerFields;
                            bta.O00000o0 = this.O0000Oo0;
                            bta.O00000o = str;
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Throwable th2) {
                                bsc.O000000o(th2, "ht", "par");
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th3) {
                                    bsc.O000000o(th3, "ht", "par");
                                }
                            }
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th4) {
                                bsc.O000000o(th4, "ht", "par");
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th5) {
                                bsc.O000000o(th5, "ht", "par");
                            }
                            return bta;
                        } catch (IOException unused) {
                            pushbackInputStream3 = null;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                throw new t("IO 操作异常 - IOException", str);
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
                        throw new t("IO 操作异常 - IOException", str);
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
                                bsc.O000000o(th10, "ht", "par");
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th11) {
                                bsc.O000000o(th11, "ht", "par");
                            }
                        }
                        if (pushbackInputStream != null) {
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th12) {
                                bsc.O000000o(th12, "ht", "par");
                            }
                        }
                        if (pushbackInputStream2 != null) {
                            try {
                                pushbackInputStream2.close();
                            } catch (Throwable th13) {
                                bsc.O000000o(th13, "ht", "par");
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                    inputStream2 = null;
                    pushbackInputStream3 = null;
                    pushbackInputStream = pushbackInputStream3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    throw new t("IO 操作异常 - IOException", str);
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
                t tVar = new t("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.O0000Oo0, str);
                tVar.a(responseCode);
                throw tVar;
            }
        } catch (IOException unused4) {
            inputStream2 = null;
            pushbackInputStream3 = null;
            pushbackInputStream = null;
            throw new t("IO 操作异常 - IOException", str);
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

    static String O000000o(Map<String, String> map) {
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

    private void O000000o(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.addRequestProperty(next, map.get(next));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.O0000Oo0);
        } catch (Throwable th) {
            bsc.O000000o(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.f13256O000000o);
        httpURLConnection.setReadTimeout(this.O00000Oo);
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        volatile O00000Oo f13257O000000o;
        private Vector<O00000Oo> O00000Oo;

        private O000000o() {
            this.O00000Oo = new Vector<>();
            this.f13257O000000o = new O00000Oo((byte) 0);
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final O00000Oo O000000o(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f13257O000000o;
            }
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                O00000Oo o00000Oo = this.O00000Oo.get(i);
                if (o00000Oo != null && o00000Oo.O00000Oo.equals(str)) {
                    return o00000Oo;
                }
            }
            O00000Oo o00000Oo2 = new O00000Oo((byte) 0);
            o00000Oo2.O00000Oo = str;
            this.O00000Oo.add(o00000Oo2);
            return o00000Oo2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
        if (r4.f13369O000000o.O000000o() != false) goto L_0x0033;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    private bsy(int i, int i2, Proxy proxy, boolean z, byte b) {
        boolean z2;
        this.O00000oo = false;
        this.O0000O0o = -1;
        this.O0000OOo = 0;
        this.f13256O000000o = i;
        this.O00000Oo = i2;
        this.O00000oO = proxy;
        bwy bwy = bwy.O000000o.f13370O000000o;
        if (!bwy.O000000o()) {
            if (!z) {
                if (bwy.f13369O000000o == null) {
                    bwy.f13369O000000o = new bwy.O00000Oo((byte) 0);
                }
            }
            z2 = true;
            this.O00000o0 = z2;
            if (bwy.O000000o()) {
                this.O00000o0 = false;
            }
            this.O0000OoO = null;
            this.O0000Oo0 = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
            if (this.O00000o0) {
                try {
                    SSLContext instance = SSLContext.getInstance("TLS");
                    instance.init(null, null, null);
                    this.O00000o = instance;
                } catch (Throwable th) {
                    bsc.O000000o(th, "ht", "ne");
                }
            }
            this.O0000Oo = new O000000o((byte) 0);
        }
        z2 = false;
        this.O00000o0 = z2;
        if (bwy.O000000o()) {
        }
        this.O0000OoO = null;
        try {
            this.O0000Oo0 = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th2) {
            bsc.O000000o(th2, "ht", "ic");
        }
        if (this.O00000o0) {
        }
        this.O0000Oo = new O000000o((byte) 0);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0175 A[SYNTHETIC, Splitter:B:108:0x0175] */
    public final bta O000000o(String str, boolean z, String str2, Map<String, String> map, byte[] bArr, boolean z2) throws t {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            bww.O00000o0();
            if (map == null) {
                map = new HashMap<>();
            }
            O00000Oo o00000Oo = this.O0000Oo.f13257O000000o;
            if (z && !TextUtils.isEmpty(str2)) {
                o00000Oo = this.O0000Oo.O000000o(str2);
            }
            String str3 = "";
            if (bsw.f13254O000000o == 1) {
                str3 = bsw.O00000Oo;
            }
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str);
                String host = parse.getHost();
                str = parse.buildUpon().encodedAuthority(str3).build().toString();
                if (map != null) {
                    map.put("targetHost", host);
                }
                if (this.O00000o0) {
                    O000000o o000000o = this.O0000Oo;
                    if (!TextUtils.isEmpty(str3)) {
                        o000000o.f13257O000000o.f13258O000000o = str3;
                    }
                }
            }
            if (this.O00000o0) {
                str = bwy.O000000o(str);
            }
            URL url = new URL(str);
            URLConnection O000000o2 = this.O0000OoO != null ? this.O0000OoO.O000000o() : null;
            if (O000000o2 == null) {
                O000000o2 = this.O00000oO != null ? url.openConnection(this.O00000oO) : url.openConnection();
            }
            if (this.O00000o0) {
                httpURLConnection = (HttpsURLConnection) O000000o2;
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.O00000o.getSocketFactory());
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(o00000Oo);
            } else {
                httpURLConnection = (HttpURLConnection) O000000o2;
            }
            if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
                httpURLConnection.setRequestProperty("Connection", "close");
            }
            O000000o(map, httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        dataOutputStream.write(bArr);
                        dataOutputStream.close();
                    }
                } catch (ConnectException e) {
                    e = e;
                    e.printStackTrace();
                    throw new t("http连接失败 - ConnectionException");
                } catch (MalformedURLException e2) {
                    e = e2;
                    e.printStackTrace();
                    throw new t("url异常 - MalformedURLException");
                } catch (UnknownHostException e3) {
                    e = e3;
                    e.printStackTrace();
                    throw new t("未知主机 - UnKnowHostException");
                } catch (SocketException e4) {
                    e = e4;
                    e.printStackTrace();
                    throw new t("socket 连接异常 - SocketException");
                } catch (SocketTimeoutException e5) {
                    e = e5;
                    e.printStackTrace();
                    throw new t("socket 连接超时 - SocketTimeoutException");
                } catch (InterruptedIOException unused) {
                    throw new t("未知的错误");
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    throw new t("IO 操作异常 - IOException");
                } catch (t e7) {
                    e = e7;
                    bsc.O000000o(e, "ht", "mPt");
                    throw e;
                } catch (Throwable th) {
                    httpURLConnection2 = httpURLConnection;
                    th = th;
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Throwable th2) {
                            bsc.O000000o(th2, "ht", "mPt");
                        }
                    }
                    throw th;
                }
            }
            bta O000000o3 = O000000o(httpURLConnection, z2);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th3) {
                    bsc.O000000o(th3, "ht", "mPt");
                }
            }
            return O000000o3;
        } catch (ConnectException e8) {
            e = e8;
            e.printStackTrace();
            throw new t("http连接失败 - ConnectionException");
        } catch (MalformedURLException e9) {
            e = e9;
            e.printStackTrace();
            throw new t("url异常 - MalformedURLException");
        } catch (UnknownHostException e10) {
            e = e10;
            e.printStackTrace();
            throw new t("未知主机 - UnKnowHostException");
        } catch (SocketException e11) {
            e = e11;
            e.printStackTrace();
            throw new t("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e12) {
            e = e12;
            e.printStackTrace();
            throw new t("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused2) {
            throw new t("未知的错误");
        } catch (IOException e13) {
            e = e13;
            e.printStackTrace();
            throw new t("IO 操作异常 - IOException");
        } catch (t e14) {
            e = e14;
            bsc.O000000o(e, "ht", "mPt");
            throw e;
        } catch (Throwable th4) {
            th = th4;
            if (httpURLConnection2 != null) {
            }
            throw th;
        }
    }
}
