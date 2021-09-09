package com.hzy.tvmao.model.legacy.api;

import android.os.Build;
import android.text.TextUtils;
import com.hzy.tvmao.KookongSDK;
import com.hzy.tvmao.u;
import com.hzy.tvmao.utils.LogUtil;
import com.hzy.tvmao.utils.a;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public final class c {
    private static long g = 0;
    private static String h = "";
    /* access modifiers changed from: private */
    public static List<String> i = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public String f4430a;
    private HashMap<String, String> b;
    private HttpURLConnection c;
    private boolean d;
    private boolean e;
    private boolean f;

    private static void a(HttpURLConnection httpURLConnection) {
    }

    public c() {
        this(false);
    }

    public c(boolean z) {
        SSLContext sSLContext;
        this.f4430a = "";
        this.d = true;
        this.e = false;
        this.f = false;
        if (z) {
            d();
        }
        c();
        if (Build.VERSION.SDK_INT <= 19) {
            try {
                sSLContext = SSLContext.getInstance("TLSv1");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                sSLContext = null;
            }
            try {
                sSLContext.init(null, null, null);
            } catch (KeyManagementException e3) {
                e3.printStackTrace();
            }
            HttpsURLConnection.setDefaultSSLSocketFactory(new g(sSLContext.getSocketFactory()));
            HttpsURLConnection.setDefaultHostnameVerifier(new d(this));
        }
    }

    private void c() {
        this.f4430a = System.getProperty("http.agent").replace("Dalvik", "Dalv1k");
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final void a(Map<String, String> map) {
        d();
        this.b.putAll(map);
    }

    private void d() {
        if (this.b == null) {
            this.b = new HashMap<>();
            this.b.put("s", "android-kksdk");
            HashMap<String, String> hashMap = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append(u.g);
            hashMap.put("sdk", sb.toString());
            HashMap<String, String> hashMap2 = this.b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(u.b);
            hashMap2.put("version", sb2.toString());
            this.b.put("secret", KookongSDK.APPKEY);
            this.b.put("pkg", u.e);
            this.b.put("platform", "android");
            this.b.put("cv", "2");
            this.b.put("sdhiad", u.j);
            HashMap<String, String> hashMap3 = this.b;
            hashMap3.put("model", u.i + "_" + u.h);
            HashMap<String, String> hashMap4 = this.b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(u.f4469a);
            hashMap4.put("sdk_vcode", sb3.toString());
            this.b.put("lanCode", com.hzy.tvmao.utils.c.f());
            if (!TextUtils.isEmpty(KookongSDK.DEVICEID)) {
                this.b.put("deviceId", KookongSDK.DEVICEID);
            }
        }
    }

    public final Map<String, Object> a(String str, boolean z) {
        return a(str, false, z);
    }

    private CharSequence e() throws Exception {
        HashMap<String, String> f2 = f();
        return (f2 == null || f2.size() <= 0) ? "" : b(f2);
    }

    private HashMap<String, String> f() throws Exception {
        HashMap<String, String> hashMap = this.b;
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        String a2 = a.a(a(this.b));
        String a3 = StreamHelper.a(a2);
        LogUtil.d("params is ".concat(String.valueOf(a2)));
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("d2", a3);
        return hashMap2;
    }

    private HashMap<String, String> a(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            if (hashMap.get(it.next()) == null) {
                it.remove();
            }
        }
        return hashMap;
    }

    private CharSequence b(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : hashMap.entrySet()) {
            if (next.getValue() != null) {
                sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                sb.append('&');
            }
        }
        sb.setLength(sb.length() - 1);
        return sb;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:25:0x00b4 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:178:0x042e */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:162:0x03ba */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:156:0x039f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:142:0x037f */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.BufferedInputStream, java.lang.Object, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0385 A[ExcHandler: OutOfMemoryError (r0v9 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:41:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0388 A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:41:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x038b A[ExcHandler: ConnectException (r0v7 'e' java.net.ConnectException A[CUSTOM_DECLARE]), Splitter:B:41:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0397 A[ExcHandler: all (r0v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:39:0x0147] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x039c A[ExcHandler: OutOfMemoryError (r0v4 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:15:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03b7 A[ExcHandler: Exception (r0v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:15:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03dd A[Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397, all -> 0x043a }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03de A[Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397, all -> 0x043a }, ExcHandler: ConnectException (r0v2 'e' java.net.ConnectException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:15:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0403 A[Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397, all -> 0x043a }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x042e A[EDGE_INSN: B:178:0x042e->B:179:? ?: BREAK  , SYNTHETIC, Splitter:B:178:0x042e] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x043e  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:162:0x03ba=Splitter:B:162:0x03ba, B:156:0x039f=Splitter:B:156:0x039f} */
    private java.util.Map<java.lang.String, java.lang.Object> a(java.lang.String r21, boolean r22, boolean r23) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r2 = "="
            java.lang.String r3 = "Content-Length"
            boolean r4 = com.hzy.tvmao.KookongSDK.getUseHttps()
            android.net.Uri r5 = android.net.Uri.parse(r21)
            java.lang.String r6 = r5.getScheme()
            java.lang.String r7 = "https"
            java.lang.String r8 = "http"
            if (r4 == 0) goto L_0x002f
            boolean r9 = r6.equalsIgnoreCase(r8)
            if (r9 == 0) goto L_0x002f
            android.net.Uri$Builder r9 = r5.buildUpon()
            android.net.Uri$Builder r9 = r9.scheme(r7)
            android.net.Uri r9 = r9.build()
            java.lang.String r9 = r9.toString()
            goto L_0x0031
        L_0x002f:
            r9 = r21
        L_0x0031:
            if (r4 != 0) goto L_0x0049
            boolean r4 = r6.equalsIgnoreCase(r7)
            if (r4 == 0) goto L_0x0049
            android.net.Uri$Builder r4 = r5.buildUpon()
            android.net.Uri$Builder r4 = r4.scheme(r8)
            android.net.Uri r4 = r4.build()
            java.lang.String r9 = r4.toString()
        L_0x0049:
            java.lang.String r4 = java.lang.String.valueOf(r9)
            java.lang.String r5 = "***requestUrl***> "
            java.lang.String r4 = r5.concat(r4)
            com.hzy.tvmao.utils.LogUtil.i(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r5 = 0
            r6 = 0
        L_0x005d:
            r7 = 2
            if (r6 >= r7) goto L_0x0445
            r4.clear()
            java.lang.String r10 = "Error: "
            java.lang.String r11 = "1"
            java.lang.String r12 = "errno"
            java.lang.String r13 = "content"
            if (r22 == 0) goto L_0x00b4
            java.lang.CharSequence r14 = r20.e()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            int r15 = r14.length()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            if (r15 <= 0) goto L_0x008c
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r15.<init>()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r15.append(r9)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8 = 63
            r15.append(r8)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r15.append(r14)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r8 = r15.toString()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            goto L_0x008d
        L_0x008c:
            r8 = r9
        L_0x008d:
            java.lang.String r14 = "Get URL = "
            java.lang.String r15 = java.lang.String.valueOf(r8)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r14 = r14.concat(r15)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            com.hzy.tvmao.utils.LogUtil.d(r14)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.URL r14 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r14.<init>(r8)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.URLConnection r8 = r14.openConnection()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r1.c = r8     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            goto L_0x00c1
        L_0x00a8:
            r0 = move-exception
            r16 = r2
            r17 = r3
            r19 = r6
            r8 = 0
        L_0x00b0:
            r15 = 0
        L_0x00b1:
            r2 = r0
            goto L_0x040e
        L_0x00b4:
            java.net.URL r8 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.<init>(r9)     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r1.c = r8     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
        L_0x00c1:
            java.net.HttpURLConnection r8 = r1.c     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r14 = 10000(0x2710, float:1.4013E-41)
            r8.setConnectTimeout(r14)     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r8 = r1.c     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r14 = 20000(0x4e20, float:2.8026E-41)
            r8.setReadTimeout(r14)     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r8 = r1.c     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r14 = 1
            r8.setInstanceFollowRedirects(r14)     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r8 = r1.c     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r15 = "User-Agent"
            java.lang.String r7 = r1.f4430a     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.setRequestProperty(r15, r7)     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            boolean r7 = r1.d     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            if (r7 != 0) goto L_0x00eb
            java.net.HttpURLConnection r7 = r1.c     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r8 = "Accept-Encoding"
            java.lang.String r15 = "identity"
            r7.setRequestProperty(r8, r15)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
        L_0x00eb:
            java.net.HttpURLConnection r7 = r1.c     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r8 = "model"
            java.lang.String r15 = com.hzy.tvmao.u.h     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r7.setRequestProperty(r8, r15)     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r7 = r1.c     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            a(r7)     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            if (r22 != 0) goto L_0x0147
            java.net.HttpURLConnection r7 = r1.c     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r8 = "POST"
            r7.setRequestMethod(r8)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r7 = r1.c     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r7.setUseCaches(r5)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r7 = r1.c     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r7.setDoOutput(r14)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.CharSequence r7 = r20.e()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            int r8 = r7.length()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            if (r8 <= 0) goto L_0x012e
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r15 = r1.c     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.io.OutputStream r15 = r15.getOutputStream()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.<init>(r15)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r15 = r7.toString()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.writeBytes(r15)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.flush()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.close()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
        L_0x012e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r15 = "Post URL = "
            r8.<init>(r15)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.append(r9)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r15 = "?"
            r8.append(r15)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.append(r7)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.lang.String r7 = r8.toString()     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            com.hzy.tvmao.utils.LogUtil.d(r7)     // Catch:{ SocketTimeoutException -> 0x00a8, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
        L_0x0147:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r7 = r1.c     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            r8.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x0404, ConnectException -> 0x03de, Exception -> 0x03b7, OutOfMemoryError -> 0x039c, all -> 0x0397 }
            java.net.HttpURLConnection r7 = r1.c     // Catch:{ SocketTimeoutException -> 0x038e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            int r7 = r7.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x038e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r15 = 200(0xc8, float:2.8E-43)
            if (r7 != r15) goto L_0x0368
            java.lang.String r7 = "0"
            r4.put(r12, r7)     // Catch:{ SocketTimeoutException -> 0x038e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            boolean r7 = r1.e     // Catch:{ SocketTimeoutException -> 0x038e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r7 == 0) goto L_0x0221
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r7.<init>()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.net.HttpURLConnection r15 = r1.c     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.util.Map r15 = r15.getHeaderFields()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.util.Set r15 = r15.entrySet()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x0178:
            boolean r17 = r15.hasNext()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r17 == 0) goto L_0x0210
            java.lang.Object r17 = r15.next()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.util.Map$Entry r17 = (java.util.Map.Entry) r17     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r14 = "set-cookie"
            java.lang.Object r18 = r17.getKey()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r5 = r18
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            boolean r5 = r14.equalsIgnoreCase(r5)     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r5 == 0) goto L_0x020c
            java.lang.Object r5 = r17.getValue()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x019e:
            boolean r14 = r5.hasNext()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r14 == 0) goto L_0x0210
            java.lang.Object r14 = r5.next()     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r15 = ";\\s*"
            java.lang.String[] r14 = r14.split(r15)     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            int r15 = r14.length     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r21 = r5
            r5 = 0
        L_0x01b4:
            if (r5 >= r15) goto L_0x0209
            r17 = r15
            r15 = r14[r5]     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String[] r15 = r15.split(r2)     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r18 = r14
            int r14 = r15.length     // Catch:{ SocketTimeoutException -> 0x021c, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r19 = r6
            r6 = 2
            if (r14 != r6) goto L_0x01ff
            r14 = 0
            r16 = r15[r14]     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r14 = r16.trim()     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r6 = "user_id"
            boolean r6 = r14.equals(r6)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r6 != 0) goto L_0x01e5
            java.lang.String r6 = "user_email"
            boolean r6 = r14.equals(r6)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r6 != 0) goto L_0x01e5
            java.lang.String r6 = "token"
            boolean r6 = r14.equals(r6)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r6 == 0) goto L_0x01ff
        L_0x01e5:
            r7.append(r14)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r7.append(r2)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r6 = 1
            r5 = r15[r6]     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r5 = r5.trim()     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r7.append(r5)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r5 = ";"
            r7.append(r5)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r5 = r21
            r6 = r19
            goto L_0x019e
        L_0x01ff:
            r6 = 1
            int r5 = r5 + 1
            r15 = r17
            r14 = r18
            r6 = r19
            goto L_0x01b4
        L_0x0209:
            r5 = r21
            goto L_0x019e
        L_0x020c:
            r5 = 0
            r14 = 1
            goto L_0x0178
        L_0x0210:
            r19 = r6
            java.lang.String r5 = "Cookie"
            java.lang.String r6 = r7.toString()     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r4.put(r5, r6)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            goto L_0x0223
        L_0x021c:
            r0 = move-exception
            r19 = r6
            goto L_0x0362
        L_0x0221:
            r19 = r6
        L_0x0223:
            java.net.HttpURLConnection r5 = r1.c     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r5 = r5.getHeaderField(r3)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r5 == 0) goto L_0x0234
            java.lang.String r5 = r5.trim()     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            goto L_0x0235
        L_0x0234:
            r5 = 0
        L_0x0235:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r7 = "Content-Length = "
            r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            int r7 = r5 / 1024
            r6.append(r7)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r7 = "KB"
            r6.append(r7)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r6 = r6.toString()     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            com.hzy.tvmao.utils.LogUtil.d(r6)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r4.put(r3, r5)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r23 == 0) goto L_0x025b
            r4.put(r13, r8)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            goto L_0x037f
        L_0x025b:
            java.lang.String r5 = ""
            java.net.HttpURLConnection r6 = r1.c     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r7 = "e"
            java.lang.String r6 = r6.getHeaderField(r7)     // Catch:{ SocketTimeoutException -> 0x0361, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r7 = "解码库错误"
            java.lang.String r14 = "UTF-8"
            java.lang.String r15 = "encrypt_data"
            r16 = r2
            r2 = 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x02b2
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ SocketTimeoutException -> 0x02ab, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r5.<init>()     // Catch:{ SocketTimeoutException -> 0x02ab, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            byte[] r2 = new byte[r2]     // Catch:{ SocketTimeoutException -> 0x02ab, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x0278:
            int r6 = r8.read(r2)     // Catch:{ SocketTimeoutException -> 0x02ab, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r6 <= 0) goto L_0x0287
            r17 = r3
            r3 = 0
            r5.write(r2, r3, r6)     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3 = r17
            goto L_0x0278
        L_0x0287:
            r17 = r3
            byte[] r2 = r5.toByteArray()     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            boolean r3 = r1.f     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r3 == 0) goto L_0x0294
            r4.put(r15, r2)     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x0294:
            byte[] r2 = com.hzy.tvmao.model.legacy.api.StreamHelper.dec1(r2)     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r3 = new java.lang.String     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3.<init>(r2, r14)     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r2 == 0) goto L_0x02a6
            com.hzy.tvmao.utils.LogUtil.d(r7)     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x02a6:
            r15 = 0
            goto L_0x034d
        L_0x02a9:
            r0 = move-exception
            goto L_0x02ae
        L_0x02ab:
            r0 = move-exception
            r17 = r3
        L_0x02ae:
            r2 = r0
            r15 = 0
            goto L_0x040e
        L_0x02b2:
            r17 = r3
            java.net.HttpURLConnection r3 = r1.c     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r6 = "e2"
            java.lang.String r3 = r3.getHeaderField(r6)     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r3 == 0) goto L_0x032b
            java.lang.String r3 = "decrypt with e2"
            com.hzy.tvmao.utils.LogUtil.d(r3)     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            byte[] r2 = new byte[r2]     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x02ca:
            int r5 = r8.read(r2)     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r5 <= 0) goto L_0x02d5
            r6 = 0
            r3.write(r2, r6, r5)     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            goto L_0x02ca
        L_0x02d5:
            byte[] r5 = r3.toByteArray()     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3.reset()     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            boolean r6 = r1.f     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r6 == 0) goto L_0x02e3
            r4.put(r15, r5)     // Catch:{ SocketTimeoutException -> 0x02a9, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x02e3:
            byte[] r5 = com.hzy.tvmao.model.legacy.api.StreamHelper.dec2(r5)     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.io.ByteArrayInputStream r15 = new java.io.ByteArrayInputStream     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r15.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r6.<init>(r15)     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x02f1:
            int r5 = r6.read(r2)     // Catch:{ SocketTimeoutException -> 0x035e, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r5 <= 0) goto L_0x02fc
            r15 = 0
            r3.write(r2, r15, r5)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            goto L_0x02f1
        L_0x02fc:
            r15 = 0
            r6.close()     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r2 = r3.toString(r14)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r3 == 0) goto L_0x030d
            com.hzy.tvmao.utils.LogUtil.d(r7)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x030d:
            r4.put(r13, r2)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3.append(r9)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r5 = ":CONTENT = "
            r3.append(r5)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3.append(r2)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r2 = r3.toString()     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            com.hzy.tvmao.utils.LogUtil.d(r2)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r23 != 0) goto L_0x0445
            goto L_0x03af
        L_0x032b:
            r15 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3.<init>(r8)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r2.<init>(r3)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r3 = r5
        L_0x0337:
            java.lang.String r5 = r2.readLine()     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            if (r5 == 0) goto L_0x034d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r6.<init>()     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r6.append(r3)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r6.append(r5)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r3 = r6.toString()     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            goto L_0x0337
        L_0x034d:
            r4.put(r13, r3)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r2 = "CONTENT = "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            com.hzy.tvmao.utils.LogUtil.d(r2)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            goto L_0x037f
        L_0x035e:
            r0 = move-exception
            goto L_0x00b0
        L_0x0361:
            r0 = move-exception
        L_0x0362:
            r16 = r2
            r17 = r3
            goto L_0x00b0
        L_0x0368:
            r16 = r2
            r17 = r3
            r19 = r6
            r15 = 0
            r4.put(r12, r11)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r2 = "status code = "
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
            r4.put(r13, r2)     // Catch:{ SocketTimeoutException -> 0x0382, ConnectException -> 0x038b, Exception -> 0x0388, OutOfMemoryError -> 0x0385 }
        L_0x037f:
            if (r23 != 0) goto L_0x0445
            goto L_0x03af
        L_0x0382:
            r0 = move-exception
            goto L_0x00b1
        L_0x0385:
            r0 = move-exception
            r2 = r0
            goto L_0x039f
        L_0x0388:
            r0 = move-exception
            r2 = r0
            goto L_0x03ba
        L_0x038b:
            r0 = move-exception
            r2 = r0
            goto L_0x03e1
        L_0x038e:
            r0 = move-exception
            r16 = r2
            r17 = r3
            r19 = r6
            goto L_0x00b0
        L_0x0397:
            r0 = move-exception
            r2 = r0
            r8 = 0
            goto L_0x043c
        L_0x039c:
            r0 = move-exception
            r2 = r0
            r8 = 0
        L_0x039f:
            java.lang.System.gc()     // Catch:{ all -> 0x043a }
            r4.put(r12, r11)     // Catch:{ all -> 0x043a }
            java.lang.String r3 = "OutOfMemoryError"
            r4.put(r13, r3)     // Catch:{ all -> 0x043a }
            com.hzy.tvmao.utils.LogUtil.e(r10, r2)     // Catch:{ all -> 0x043a }
            if (r23 != 0) goto L_0x0445
        L_0x03af:
            com.hzy.tvmao.model.legacy.api.u.a(r8)
            r20.a()
            goto L_0x0445
        L_0x03b7:
            r0 = move-exception
            r2 = r0
            r8 = 0
        L_0x03ba:
            r4.put(r12, r11)     // Catch:{ all -> 0x043a }
            java.lang.Class r3 = r2.getClass()     // Catch:{ all -> 0x043a }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x043a }
            r4.put(r13, r3)     // Catch:{ all -> 0x043a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x043a }
            r3.<init>(r10)     // Catch:{ all -> 0x043a }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x043a }
            r3.append(r2)     // Catch:{ all -> 0x043a }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x043a }
            com.hzy.tvmao.utils.LogUtil.e(r2)     // Catch:{ all -> 0x043a }
            if (r23 != 0) goto L_0x0445
            goto L_0x03af
        L_0x03de:
            r0 = move-exception
            r2 = r0
            r8 = 0
        L_0x03e1:
            r4.put(r12, r11)     // Catch:{ all -> 0x043a }
            java.lang.String r3 = "ConnectException"
            r4.put(r13, r3)     // Catch:{ all -> 0x043a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x043a }
            java.lang.String r5 = "ConnectException:"
            r3.<init>(r5)     // Catch:{ all -> 0x043a }
            r3.append(r9)     // Catch:{ all -> 0x043a }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x043a }
            r3.append(r2)     // Catch:{ all -> 0x043a }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x043a }
            com.hzy.tvmao.utils.LogUtil.e(r2)     // Catch:{ all -> 0x043a }
            if (r23 != 0) goto L_0x0445
            goto L_0x03af
        L_0x0404:
            r0 = move-exception
            r16 = r2
            r17 = r3
            r19 = r6
            r15 = 0
            r2 = r0
            r8 = 0
        L_0x040e:
            java.lang.String r3 = "SocketTimeoutException:"
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x043a }
            java.lang.String r3 = r3.concat(r5)     // Catch:{ all -> 0x043a }
            com.hzy.tvmao.utils.LogUtil.d(r3, r2)     // Catch:{ all -> 0x043a }
            if (r19 > 0) goto L_0x042e
            if (r23 != 0) goto L_0x0425
            com.hzy.tvmao.model.legacy.api.u.a(r8)
            r20.a()
        L_0x0425:
            int r6 = r19 + 1
            r2 = r16
            r3 = r17
            r5 = 0
            goto L_0x005d
        L_0x042e:
            r4.put(r12, r11)     // Catch:{ all -> 0x043a }
            java.lang.String r2 = "SocketTimeoutException"
            r4.put(r13, r2)     // Catch:{ all -> 0x043a }
            if (r23 != 0) goto L_0x0445
            goto L_0x03af
        L_0x043a:
            r0 = move-exception
            r2 = r0
        L_0x043c:
            if (r23 != 0) goto L_0x0444
            com.hzy.tvmao.model.legacy.api.u.a(r8)
            r20.a()
        L_0x0444:
            throw r2
        L_0x0445:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hzy.tvmao.model.legacy.api.c.a(java.lang.String, boolean, boolean):java.util.Map");
    }

    public final void a() {
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.c = null;
        }
    }
}
