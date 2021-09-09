package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class q implements Callable<u> {
    private static final HttpRequestRetryHandler e = new ad();

    /* renamed from: a  reason: collision with root package name */
    protected l f3144a;
    protected Context b;
    protected o c;
    String d;
    private HttpUriRequest f;
    private HttpContext g = new BasicHttpContext();
    private CookieStore h = new BasicCookieStore();
    private CookieManager i;
    private AbstractHttpEntity j;
    private HttpHost k;
    private URL l;
    private int m = 0;
    private boolean n = false;
    private boolean o = false;
    private String p = null;
    private String q;

    public q(l lVar, o oVar) {
        this.f3144a = lVar;
        this.b = this.f3144a.f3141a;
        this.c = oVar;
    }

    private static long a(String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if ("max-age".equalsIgnoreCase(strArr[i2])) {
                int i3 = i2 + 1;
                if (strArr[i3] != null) {
                    try {
                        return Long.parseLong(strArr[i3]);
                    } catch (Exception unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return 0;
    }

    private static HttpUrlHeader a(HttpResponse httpResponse) {
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c0 A[SYNTHETIC, Splitter:B:23:0x00c0] */
    private u a(HttpResponse httpResponse, int i2, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        new StringBuilder("开始handle，handleResponse-1,").append(Thread.currentThread().getId());
        HttpEntity entity = httpResponse.getEntity();
        String str3 = null;
        if (entity != null && httpResponse.getStatusLine().getStatusCode() == 200) {
            new StringBuilder("200，开始处理，handleResponse-2,threadid = ").append(Thread.currentThread().getId());
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    a(entity, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    this.o = false;
                    this.f3144a.c(System.currentTimeMillis() - currentTimeMillis);
                    this.f3144a.a((long) byteArray.length);
                    new StringBuilder("res:").append(byteArray.length);
                    p pVar = new p(a(httpResponse), i2, str, byteArray);
                    long b2 = b(httpResponse);
                    Header contentType = httpResponse.getEntity().getContentType();
                    if (contentType != null) {
                        HashMap<String, String> a2 = a(contentType.getValue());
                        str3 = a2.get("charset");
                        str2 = a2.get("Content-Type");
                    } else {
                        str2 = null;
                    }
                    pVar.b(str2);
                    pVar.a(str3);
                    pVar.a(System.currentTimeMillis());
                    pVar.b(b2);
                    try {
                        byteArrayOutputStream.close();
                        return pVar;
                    } catch (IOException e2) {
                        throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
                    }
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } else if (entity != null) {
            return null;
        } else {
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
    }

    private static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(";")) {
            String[] split = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split[0], split[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a2 = b.a(httpEntity);
        long contentLength = httpEntity.getContentLength();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = a2.read(bArr);
                if (read == -1 || this.c.h()) {
                    outputStream.flush();
                } else {
                    outputStream.write(bArr, 0, read);
                    if (this.c.f() != null) {
                        int i2 = (contentLength > 0 ? 1 : (contentLength == 0 ? 0 : -1));
                    }
                }
            }
            outputStream.flush();
            r.a(a2);
        } catch (Exception e2) {
            e2.getCause();
            throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
        } catch (Throwable th) {
            r.a(a2);
            throw th;
        }
    }

    private static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0;
    }

    private URI b() {
        String a2 = this.c.a();
        String str = this.d;
        if (str != null) {
            a2 = str;
        }
        if (a2 != null) {
            return new URI(a2);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] b2 = this.c.b();
            String b3 = this.c.b("gzip");
            if (b2 != null) {
                if (TextUtils.equals(b3, "true")) {
                    this.j = b.a(b2);
                } else {
                    this.j = new ByteArrayEntity(b2);
                }
                this.j.setContentType(this.c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f = httpPost;
        } else {
            this.f = new HttpGet(b());
        }
        return this.f;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.alipay.android.phone.mrpc.core.b.execute(org.apache.http.HttpHost, org.apache.http.HttpRequest, org.apache.http.protocol.HttpContext):org.apache.http.HttpResponse
     arg types: [org.apache.http.HttpHost, org.apache.http.client.methods.HttpUriRequest, org.apache.http.protocol.HttpContext]
     candidates:
      com.alipay.android.phone.mrpc.core.b.execute(org.apache.http.HttpHost, org.apache.http.HttpRequest, org.apache.http.client.ResponseHandler):T
      com.alipay.android.phone.mrpc.core.b.execute(org.apache.http.client.methods.HttpUriRequest, org.apache.http.client.ResponseHandler, org.apache.http.protocol.HttpContext):T
      com.alipay.android.phone.mrpc.core.b.execute(org.apache.http.HttpHost, org.apache.http.HttpRequest, org.apache.http.protocol.HttpContext):org.apache.http.HttpResponse */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0284, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0285, code lost:
        e();
        r2 = r14.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x028a, code lost:
        if (r2 <= 0) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x028c, code lost:
        r14.m = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0292, code lost:
        new java.lang.StringBuilder().append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02a7, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(0, java.lang.String.valueOf(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02a9, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02b2, code lost:
        if (r14.c.f() != null) goto L_0x02b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02b4, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02bc, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02d1, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(6, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02d3, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02dc, code lost:
        if (r14.c.f() != null) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02de, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02e6, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02fd, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(9, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02fe, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02ff, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0308, code lost:
        if (r14.c.f() != null) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x030a, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0321, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(8, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0322, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0323, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x032c, code lost:
        if (r14.c.f() != null) goto L_0x032e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x032e, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0336, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x034c, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(5, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x034d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x034e, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0357, code lost:
        if (r14.c.f() != null) goto L_0x0359;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0359, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0361, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0377, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(4, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0378, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0379, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0382, code lost:
        if (r14.c.f() != null) goto L_0x0384;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0384, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x038c, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x03a1, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(3, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x03a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03a3, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03ac, code lost:
        if (r14.c.f() != null) goto L_0x03ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03ae, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03b6, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03cb, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(3, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03cd, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03d6, code lost:
        if (r14.c.f() != null) goto L_0x03d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03d8, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03e0, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03f5, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(6, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03f6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03f7, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0400, code lost:
        if (r14.c.f() != null) goto L_0x0402;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0402, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x040a, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x041f, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(2, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0420, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0421, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x042a, code lost:
        if (r14.c.f() != null) goto L_0x042c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x042c, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0434, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0449, code lost:
        throw new com.alipay.android.phone.mrpc.core.HttpException(2, java.lang.String.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x044a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0456, code lost:
        throw new java.lang.RuntimeException("Url parser error!", r0.getCause());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0457, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0458, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0461, code lost:
        if (r14.c.f() != null) goto L_0x0463;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0463, code lost:
        r0.getCode();
        r0.getMsg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0469, code lost:
        new java.lang.StringBuilder().append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0472, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x022f */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0284 A[ExcHandler: NullPointerException (r1v46 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02a8 A[ExcHandler: IOException (r0v22 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02d2 A[ExcHandler: UnknownHostException (r0v20 'e' java.net.UnknownHostException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02fe A[ExcHandler: HttpHostConnectException (r0v18 'e' org.apache.http.conn.HttpHostConnectException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0322 A[ExcHandler: NoHttpResponseException (r0v16 'e' org.apache.http.NoHttpResponseException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x034d A[ExcHandler: SocketTimeoutException (r0v14 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0378 A[ExcHandler: ConnectTimeoutException (r0v12 'e' org.apache.http.conn.ConnectTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x03a2 A[ExcHandler: ConnectionPoolTimeoutException (r0v10 'e' org.apache.http.conn.ConnectionPoolTimeoutException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03cc A[ExcHandler: SSLException (r0v8 'e' javax.net.ssl.SSLException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03f6 A[ExcHandler: SSLPeerUnverifiedException (r0v6 'e' javax.net.ssl.SSLPeerUnverifiedException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0420 A[ExcHandler: SSLHandshakeException (r0v4 'e' javax.net.ssl.SSLHandshakeException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x044a A[ExcHandler: URISyntaxException (r0v2 'e' java.net.URISyntaxException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0457 A[ExcHandler: HttpException (r0v1 'e' com.alipay.android.phone.mrpc.core.HttpException A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0256 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0109 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0129 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x015c A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0169 A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01de A[Catch:{ HttpException -> 0x0457, URISyntaxException -> 0x044a, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, SocketTimeoutException -> 0x034d, NoHttpResponseException -> 0x0322, HttpHostConnectException -> 0x02fe, UnknownHostException -> 0x02d2, IOException -> 0x02a8, NullPointerException -> 0x0284, Exception -> 0x0262 }] */
    /* renamed from: d */
    public u call() {
        boolean z;
        HttpHost httpHost;
        List<Cookie> cookies;
        int statusCode;
        u a2;
        String a3;
        while (true) {
            try {
                NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getAllNetworkInfo();
                boolean z2 = true;
                if (allNetworkInfo != null) {
                    int length = allNetworkInfo.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            NetworkInfo networkInfo = allNetworkInfo[i2];
                            if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                                z = true;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        ArrayList<Header> d2 = this.c.d();
                        if (d2 != null && !d2.isEmpty()) {
                            Iterator<Header> it = d2.iterator();
                            while (it.hasNext()) {
                                c().addHeader(it.next());
                            }
                        }
                        b.a((HttpRequest) c());
                        b.b((HttpRequest) c());
                        c().addHeader("cookie", i().getCookie(this.c.a()));
                        this.g.setAttribute("http.cookie-store", this.h);
                        this.f3144a.a().a(e);
                        long currentTimeMillis = System.currentTimeMillis();
                        StringBuilder sb = new StringBuilder("By Http/Https to request. operationType=");
                        sb.append(f());
                        sb.append(" url=");
                        sb.append(this.f.getURI().toString());
                        HttpParams params = this.f3144a.a().getParams();
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
                        HttpHost httpHost2 = null;
                        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                            String defaultHost = Proxy.getDefaultHost();
                            int defaultPort = Proxy.getDefaultPort();
                            if (defaultHost != null) {
                                httpHost = new HttpHost(defaultHost, defaultPort);
                                if (httpHost != null || !TextUtils.equals(httpHost.getHostName(), "127.0.0.1") || httpHost.getPort() != 8087) {
                                    httpHost2 = httpHost;
                                }
                                params.setParameter("http.route.default-proxy", httpHost2);
                                if (this.k == null) {
                                    URL h2 = h();
                                    this.k = new HttpHost(h2.getHost(), g(), h2.getProtocol());
                                }
                                HttpHost httpHost3 = this.k;
                                if (g() == 80) {
                                    httpHost3 = new HttpHost(h().getHost());
                                }
                                HttpResponse execute = this.f3144a.a().execute(httpHost3, (HttpRequest) this.f, this.g);
                                this.f3144a.b(System.currentTimeMillis() - currentTimeMillis);
                                cookies = this.h.getCookies();
                                if (this.c.e()) {
                                    i().removeAllCookie();
                                }
                                if (!cookies.isEmpty()) {
                                    for (Cookie cookie : cookies) {
                                        if (cookie.getDomain() != null) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(cookie.getName());
                                            sb2.append("=");
                                            sb2.append(cookie.getValue());
                                            sb2.append("; domain=");
                                            sb2.append(cookie.getDomain());
                                            sb2.append(cookie.isSecure() ? "; Secure" : "");
                                            i().setCookie(this.c.a(), sb2.toString());
                                            CookieSyncManager.getInstance().sync();
                                        }
                                    }
                                }
                                statusCode = execute.getStatusLine().getStatusCode();
                                String reasonPhrase = execute.getStatusLine().getReasonPhrase();
                                if (statusCode != 200) {
                                    if (statusCode != 304) {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        throw new HttpException(Integer.valueOf(execute.getStatusLine().getStatusCode()), execute.getStatusLine().getReasonPhrase());
                                    }
                                }
                                a2 = a(execute, statusCode, reasonPhrase);
                                if (((a2 != null || a2.b() == null) ? -1 : (long) a2.b().length) == -1 && (a2 instanceof p)) {
                                    Long.parseLong(((p) a2).a().getHead("Content-Length"));
                                }
                                a3 = this.c.a();
                                if (a3 != null && !TextUtils.isEmpty(f())) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(a3);
                                    sb3.append("#");
                                    sb3.append(f());
                                }
                                return a2;
                            }
                        }
                        httpHost = null;
                        if (httpHost != null) {
                        }
                        httpHost2 = httpHost;
                        params.setParameter("http.route.default-proxy", httpHost2);
                        if (this.k == null) {
                        }
                        HttpHost httpHost32 = this.k;
                        if (g() == 80) {
                        }
                        HttpResponse execute2 = this.f3144a.a().execute(httpHost32, (HttpRequest) this.f, this.g);
                        this.f3144a.b(System.currentTimeMillis() - currentTimeMillis);
                        cookies = this.h.getCookies();
                        if (this.c.e()) {
                        }
                        if (!cookies.isEmpty()) {
                        }
                        statusCode = execute2.getStatusLine().getStatusCode();
                        String reasonPhrase2 = execute2.getStatusLine().getReasonPhrase();
                        if (statusCode != 200) {
                        }
                        a2 = a(execute2, statusCode, reasonPhrase2);
                        Long.parseLong(((p) a2).a().getHead("Content-Length"));
                        a3 = this.c.a();
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append(a3);
                        sb32.append("#");
                        sb32.append(f());
                        return a2;
                    }
                    throw new HttpException(1, "The network is not available");
                }
                z = false;
                if (!z) {
                }
            } catch (HttpException e2) {
            } catch (URISyntaxException e3) {
            } catch (SSLHandshakeException e4) {
            } catch (SSLPeerUnverifiedException e5) {
            } catch (SSLException e6) {
            } catch (ConnectionPoolTimeoutException e7) {
            } catch (ConnectTimeoutException e8) {
            } catch (SocketTimeoutException e9) {
            } catch (NoHttpResponseException e10) {
            } catch (HttpHostConnectException e11) {
            } catch (UnknownHostException e12) {
            } catch (IOException e13) {
            } catch (NullPointerException e14) {
            } catch (Exception e15) {
                e();
                if (this.c.f() != null) {
                    new StringBuilder().append(e15);
                }
                throw new HttpException(0, String.valueOf(e15));
            }
        }
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        this.q = this.c.b("operationType");
        return this.q;
    }

    private int g() {
        URL h2 = h();
        return h2.getPort() == -1 ? h2.getDefaultPort() : h2.getPort();
    }

    private URL h() {
        URL url = this.l;
        if (url != null) {
            return url;
        }
        this.l = new URL(this.c.a());
        return this.l;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.i;
        if (cookieManager != null) {
            return cookieManager;
        }
        this.i = CookieManager.getInstance();
        return this.i;
    }

    public final o a() {
        return this.c;
    }
}
