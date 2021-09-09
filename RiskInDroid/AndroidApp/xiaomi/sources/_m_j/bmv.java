package _m_j;

import _m_j.blp;
import _m_j.blq;
import _m_j.bma;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class bmv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f13118O000000o = "POST";
    private static bmv O0000Oo;
    private int O00000Oo;
    private int O00000o;
    /* access modifiers changed from: private */
    public ArrayList<String> O00000o0 = new ArrayList<>();
    private int O00000oO = 3;
    private int O00000oo = 2;
    private int O0000O0o;
    private long O0000OOo;
    private SSLContext O0000Oo0 = null;
    private TrustManager[] O0000OoO = null;
    private KeyStore O0000Ooo = null;

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public HttpURLConnection f13122O000000o = null;
        public byte[] O00000Oo = null;
        public int O00000o = -1;
        public Map<String, String> O00000o0 = null;
        public O000000o O00000oO = null;
        public bmg<O00000Oo> O00000oo = null;
        public boolean O0000O0o = false;
        public int O0000OOo = 0;
        public String O0000Oo;
        public String O0000Oo0 = null;
        public String O0000OoO;
    }

    public static abstract class O000000o<T> extends bmg<T> {
        public O00000Oo O00000Oo = null;

        public O000000o(boolean z, int i) {
            super(z, 2);
        }

        public abstract void O000000o(String str);

        public boolean O000000o(String str, int i) {
            if (!this.O00000Oo.O0000O0o || this.O00000Oo.O00000o + 1 >= this.O00000Oo.O0000OOo) {
                if (this.O00000Oo != null && !TextUtils.isEmpty(str)) {
                    bma.O000000o.f13086O000000o.O000000o(str, this.O00000Oo.O0000Oo);
                }
                return true;
            }
            this.O00000Oo.O00000o++;
            bne.O000000o(this.O00000Oo.f13122O000000o);
            O00000Oo o00000Oo = this.O00000Oo;
            o00000Oo.f13122O000000o = null;
            o00000Oo.O00000oo.O000000o();
            return false;
        }

        public void run() {
            BufferedReader bufferedReader;
            InputStream inputStream;
            Exception e;
            if (this.O00000Oo.O0000Oo0 != null) {
                O000000o(this.O00000Oo.O0000Oo0, 1);
                this.O00000Oo.O0000Oo0 = null;
            } else if (this.O00000Oo.f13122O000000o == null) {
                O000000o("HttpUrlConnection is null", 0);
            } else {
                try {
                    int responseCode = this.O00000Oo.f13122O000000o.getResponseCode();
                    if (responseCode != 200) {
                        bmz.O000000o("HttpTransport", "HttpTransport responseCode ( %d )", Integer.valueOf(responseCode));
                        O000000o("responseCode: ".concat(String.valueOf(responseCode)), 2);
                        return;
                    }
                    try {
                        inputStream = this.O00000Oo.f13122O000000o.getInputStream();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            try {
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                }
                                if (!TextUtils.isEmpty(this.O00000Oo.O0000OoO)) {
                                    blq.O000000o.f13069O000000o.O000000o(bne.O0000OOo(this.O00000Oo.O0000Oo), this.O00000Oo.O0000OoO);
                                }
                                String sb2 = sb.toString();
                                bmz.O000000o("HttpTransport", "result: %s", sb2);
                                O000000o(sb2);
                                bne.O000000o((Closeable) inputStream);
                                bne.O000000o((Closeable) bufferedReader);
                                bne.O000000o(this.O00000Oo.f13122O000000o);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    bmz.O000000o("HttpTransport", "HttpTransport response content err: %s", Log.getStackTraceString(e));
                                    O000000o("response content err: ".concat(String.valueOf(e)), 3);
                                    bne.O000000o((Closeable) inputStream);
                                    bne.O000000o((Closeable) bufferedReader);
                                    bne.O000000o(this.O00000Oo.f13122O000000o);
                                } catch (Throwable th) {
                                    th = th;
                                    bne.O000000o((Closeable) inputStream);
                                    bne.O000000o((Closeable) bufferedReader);
                                    bne.O000000o(this.O00000Oo.f13122O000000o);
                                    throw th;
                                }
                            }
                        } catch (Exception e3) {
                            Exception exc = e3;
                            bufferedReader = null;
                            e = exc;
                            bmz.O000000o("HttpTransport", "HttpTransport response content err: %s", Log.getStackTraceString(e));
                            O000000o("response content err: ".concat(String.valueOf(e)), 3);
                            bne.O000000o((Closeable) inputStream);
                            bne.O000000o((Closeable) bufferedReader);
                            bne.O000000o(this.O00000Oo.f13122O000000o);
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = null;
                            bne.O000000o((Closeable) inputStream);
                            bne.O000000o((Closeable) bufferedReader);
                            bne.O000000o(this.O00000Oo.f13122O000000o);
                            throw th;
                        }
                    } catch (Exception e4) {
                        bufferedReader = null;
                        e = e4;
                        inputStream = null;
                        bmz.O000000o("HttpTransport", "HttpTransport response content err: %s", Log.getStackTraceString(e));
                        O000000o("response content err: ".concat(String.valueOf(e)), 3);
                        bne.O000000o((Closeable) inputStream);
                        bne.O000000o((Closeable) bufferedReader);
                        bne.O000000o(this.O00000Oo.f13122O000000o);
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        bufferedReader = null;
                        bne.O000000o((Closeable) inputStream);
                        bne.O000000o((Closeable) bufferedReader);
                        bne.O000000o(this.O00000Oo.f13122O000000o);
                        throw th;
                    }
                } catch (Exception e5) {
                    bne.O000000o(this.O00000Oo.f13122O000000o);
                    bmz.O000000o("HttpTransport", "HttpTransport getResponseCode failed: %s", Log.getStackTraceString(e5));
                    O000000o(e5.getMessage(), 2);
                }
            }
        }
    }

    public final bmv O000000o(bmu bmu) {
        if (bmu == null) {
            return null;
        }
        int length = bmu.O00000oo.length;
        this.O00000Oo = bmu.f13117O000000o;
        for (int i = 0; i < this.O00000oO; i++) {
            this.O00000o0.add(bmu.O00000oO);
        }
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < this.O00000oo; i3++) {
                this.O00000o0.add(bmu.O00000oo[i2]);
            }
        }
        this.O00000o = bmu.O00000Oo * 1000;
        this.O0000O0o = bmu.O00000o0 * 1000;
        this.O0000OOo = (long) (bmu.O00000o * 1000);
        if (1 == this.O00000Oo) {
            return this;
        }
        try {
            if (bmu.O0000OOo) {
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bmu.O0000O0o));
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null);
                instance.setCertificateEntry("smfp", generateCertificate);
                TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance2.init(instance);
                this.O0000OoO = instance2.getTrustManagers();
                this.O0000Oo0 = SSLContext.getInstance("SSL");
                this.O0000Oo0.init(null, this.O0000OoO, null);
            }
            return this;
        } catch (Exception unused) {
            this.O0000Oo0 = null;
            this.O0000OoO = null;
            return this;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.blq.O000000o(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      _m_j.blq.O000000o(java.lang.String, java.lang.String):void
      _m_j.blq.O000000o(java.lang.String, boolean):java.lang.String */
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
    /* JADX WARNING: Multi-variable type inference failed */
    public final java.lang.String O000000o(byte[] r10, java.util.Map<java.lang.String, java.lang.String> r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r11 = "HttpTransport"
            if (r10 == 0) goto L_0x0156
            int r0 = r10.length
            if (r0 == 0) goto L_0x0156
            r0 = 0
            java.lang.String r1 = _m_j.bne.O0000OOo(r12)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            _m_j.blq r2 = _m_j.blq.O000000o.f13069O000000o     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            r3 = 0
            java.lang.String r2 = r2.O000000o(r1, r3)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            java.lang.String r4 = "IP of %s : %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            r5[r3] = r12     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            r6 = 1
            r5[r6] = r2     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            _m_j.bmz.O00000Oo(r11, r4, r5)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            if (r4 == 0) goto L_0x002e
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            r4.<init>(r12)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            goto L_0x003d
        L_0x002e:
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            java.util.regex.Pattern r5 = android.util.Patterns.DOMAIN_NAME     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            java.util.regex.Matcher r5 = r5.matcher(r12)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            java.lang.String r5 = r5.replaceFirst(r2)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
        L_0x003d:
            java.lang.String r5 = "final URL: %s"
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            r7[r3] = r4     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            _m_j.bmz.O00000Oo(r11, r5, r7)     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x0141, all -> 0x013c }
            int r5 = r9.O00000Oo     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            if (r5 != 0) goto L_0x006f
            r5 = r4
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            _m_j.bmv$1 r7 = new _m_j.bmv$1     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r7.<init>(r1)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r5.setHostnameVerifier(r7)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            javax.net.ssl.TrustManager[] r5 = r9.O0000OoO     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            if (r5 == 0) goto L_0x006f
            javax.net.ssl.SSLContext r5 = r9.O0000Oo0     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            if (r5 == 0) goto L_0x006f
            r5 = r4
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            javax.net.ssl.SSLContext r7 = r9.O0000Oo0     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            javax.net.ssl.SSLSocketFactory r7 = r7.getSocketFactory()     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r5.setSSLSocketFactory(r7)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
        L_0x006f:
            r4.setDoInput(r6)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r4.setDoOutput(r6)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r4.setUseCaches(r3)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r4.setInstanceFollowRedirects(r6)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            java.lang.String r5 = _m_j.bmv.f13118O000000o     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r4.setRequestMethod(r5)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            java.lang.String r5 = "Content-Type"
            java.lang.String r7 = "application/octet-stream"
            r4.setRequestProperty(r5, r7)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            java.lang.String r5 = "Connection"
            java.lang.String r7 = "Close"
            r4.setRequestProperty(r5, r7)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            int r5 = r9.O00000o     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r4.setConnectTimeout(r5)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            int r5 = r9.O0000O0o     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r4.setReadTimeout(r5)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            int r5 = r10.length     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r4.setFixedLengthStreamingMode(r5)     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r4.connect()     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ IOException -> 0x0136, all -> 0x0132 }
            r5.write(r10)     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            r5.flush()     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            _m_j.bmz.O000000o(r11, r12, r10)     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            int r10 = r4.getResponseCode()     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            r12 = 200(0xc8, float:2.8E-43)
            if (r10 != r12) goto L_0x010d
            java.io.InputStream r10 = r4.getInputStream()     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0106, all -> 0x00fe }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0106, all -> 0x00fe }
            r7.<init>(r10)     // Catch:{ IOException -> 0x0106, all -> 0x00fe }
            r12.<init>(r7)     // Catch:{ IOException -> 0x0106, all -> 0x00fe }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            r0.<init>()     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
        L_0x00c9:
            java.lang.String r7 = r12.readLine()     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            if (r7 == 0) goto L_0x00d3
            r0.append(r7)     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            goto L_0x00c9
        L_0x00d3:
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            if (r7 != 0) goto L_0x00e0
            _m_j.blq r7 = _m_j.blq.O000000o.f13069O000000o     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            r7.O000000o(r1, r2)     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
        L_0x00e0:
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            java.lang.String r1 = "result: %s"
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            r2[r3] = r0     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            _m_j.bmz.O000000o(r11, r1, r2)     // Catch:{ IOException -> 0x00fc, all -> 0x00fa }
            _m_j.bne.O000000o(r5)
            _m_j.bne.O000000o(r10)
            _m_j.bne.O000000o(r12)
            _m_j.bne.O000000o(r4)
            return r0
        L_0x00fa:
            r11 = move-exception
            goto L_0x0100
        L_0x00fc:
            r11 = move-exception
            goto L_0x0108
        L_0x00fe:
            r11 = move-exception
            r12 = r0
        L_0x0100:
            r0 = r5
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0149
        L_0x0106:
            r11 = move-exception
            r12 = r0
        L_0x0108:
            r0 = r4
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0145
        L_0x010d:
            java.lang.String r12 = "responseCode ( %d )"
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            r1[r3] = r2     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            _m_j.bmz.O000000o(r11, r12, r1)     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            java.io.IOException r11 = new java.io.IOException     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            java.lang.String r12 = "responseCode = "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            java.lang.String r10 = r12.concat(r10)     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            r11.<init>(r10)     // Catch:{ IOException -> 0x012e, all -> 0x012a }
            throw r11     // Catch:{ IOException -> 0x012e, all -> 0x012a }
        L_0x012a:
            r10 = move-exception
            r11 = r0
            r12 = r11
            goto L_0x0148
        L_0x012e:
            r10 = move-exception
            r11 = r0
            r12 = r11
            goto L_0x013a
        L_0x0132:
            r10 = move-exception
            r11 = r0
            r12 = r11
            goto L_0x0149
        L_0x0136:
            r10 = move-exception
            r11 = r0
            r12 = r11
            r5 = r12
        L_0x013a:
            r0 = r4
            goto L_0x0145
        L_0x013c:
            r10 = move-exception
            r11 = r0
            r12 = r11
            r4 = r12
            goto L_0x0149
        L_0x0141:
            r10 = move-exception
            r11 = r0
            r12 = r11
            r5 = r12
        L_0x0145:
            throw r10     // Catch:{ all -> 0x0146 }
        L_0x0146:
            r10 = move-exception
            r4 = r0
        L_0x0148:
            r0 = r5
        L_0x0149:
            _m_j.bne.O000000o(r0)
            _m_j.bne.O000000o(r11)
            _m_j.bne.O000000o(r12)
            _m_j.bne.O000000o(r4)
            throw r10
        L_0x0156:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "data is null"
            r10.<init>(r11)
            goto L_0x015f
        L_0x015e:
            throw r10
        L_0x015f:
            goto L_0x015e
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bmv.O000000o(byte[], java.util.Map, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0110, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0112, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0113, code lost:
        r6 = null;
        r5 = r4;
        r4 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[Catch:{ Exception -> 0x0112, all -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[Catch:{ Exception -> 0x0112, all -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078 A[Catch:{ Exception -> 0x010d, all -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6 A[Catch:{ Exception -> 0x010d, all -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0110 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0128 A[Catch:{ all -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void O000000o(byte[] bArr, Map<String, String> map, String str, O000000o<?> o000000o) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        boolean z;
        String O000000o2;
        URL url;
        OutputStream outputStream2;
        bmz.O000000o("HttpTransport", "HttpTransport transport: %s", str);
        if (bArr == null || bArr.length == 0) {
            throw new IOException("data is null");
        }
        if (o000000o != null && o000000o.O00000Oo == null) {
            o000000o.O00000Oo = new O00000Oo();
        }
        ? r1 = 0;
        if (o000000o != null) {
            try {
                if (o000000o.O00000Oo.O00000o > 0) {
                    z = true;
                    final String O0000OOo2 = bne.O0000OOo(str);
                    O000000o2 = blq.O000000o.f13069O000000o.O000000o(O0000OOo2, z);
                    bmz.O00000Oo("HttpTransport", "IP of %s: %s", str, O000000o2);
                    if (!TextUtils.isEmpty(O000000o2)) {
                        url = new URL(str);
                    } else {
                        URL url2 = new URL(Patterns.DOMAIN_NAME.matcher(str).replaceFirst(O000000o2));
                        if (o000000o != null) {
                            o000000o.O00000Oo.O0000OoO = O000000o2;
                        }
                        url = url2;
                    }
                    bmz.O00000Oo("HttpTransport", "final URL: %s", url);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    if (this.O00000Oo == 0) {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
                            /* class _m_j.bmv.AnonymousClass2 */

                            public final boolean verify(String str, SSLSession sSLSession) {
                                if (TextUtils.isEmpty(O0000OOo2) || Patterns.IP_ADDRESS.matcher(O0000OOo2).matches()) {
                                    return true;
                                }
                                return HttpsURLConnection.getDefaultHostnameVerifier().verify(O0000OOo2, sSLSession);
                            }
                        });
                        if (!(this.O0000OoO == null || this.O0000Oo0 == null)) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.O0000Oo0.getSocketFactory());
                        }
                    }
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod(f13118O000000o);
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection.setRequestProperty("Connection", "Close");
                    httpURLConnection.setConnectTimeout(this.O00000o);
                    httpURLConnection.setReadTimeout(this.O0000O0o);
                    httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                    if (map != null) {
                        for (Map.Entry next : map.entrySet()) {
                            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                        }
                    }
                    httpURLConnection.connect();
                    outputStream2 = httpURLConnection.getOutputStream();
                    outputStream2.write(bArr);
                    outputStream2.flush();
                    bmz.O000000o("HttpTransport", "HttpTransport finish: %s", str);
                    bne.O000000o((Closeable) outputStream2);
                    r1 = httpURLConnection;
                    if (o000000o != null) {
                        o000000o.O00000Oo.f13122O000000o = r1;
                        o000000o.O00000Oo.O00000Oo = bArr;
                        o000000o.O00000Oo.O00000o0 = map;
                        o000000o.O00000Oo.O0000Oo = str;
                        o000000o.O000000o();
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e = e;
                outputStream = null;
                try {
                    bne.O000000o(httpURLConnection);
                    bmz.O00000o("HttpTransport", "HttpTransport request failed: %s", Log.getStackTraceString(e));
                    if (o000000o != null) {
                    }
                    bne.O000000o((Closeable) outputStream);
                    if (o000000o != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = outputStream;
                    bne.O000000o((Closeable) r1);
                    throw th;
                }
            } catch (Throwable th2) {
            }
        }
        z = false;
        final String O0000OOo22 = bne.O0000OOo(str);
        O000000o2 = blq.O000000o.f13069O000000o.O000000o(O0000OOo22, z);
        bmz.O00000Oo("HttpTransport", "IP of %s: %s", str, O000000o2);
        if (!TextUtils.isEmpty(O000000o2)) {
        }
        bmz.O00000Oo("HttpTransport", "final URL: %s", url);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        if (this.O00000Oo == 0) {
        }
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestMethod(f13118O000000o);
        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.setRequestProperty("Connection", "Close");
        httpURLConnection.setConnectTimeout(this.O00000o);
        httpURLConnection.setReadTimeout(this.O0000O0o);
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        if (map != null) {
        }
        httpURLConnection.connect();
        outputStream2 = httpURLConnection.getOutputStream();
        try {
            outputStream2.write(bArr);
            outputStream2.flush();
            bmz.O000000o("HttpTransport", "HttpTransport finish: %s", str);
            bne.O000000o((Closeable) outputStream2);
            r1 = httpURLConnection;
        } catch (Exception e2) {
            Exception exc = e2;
            outputStream = outputStream2;
            e = exc;
            bne.O000000o(httpURLConnection);
            bmz.O00000o("HttpTransport", "HttpTransport request failed: %s", Log.getStackTraceString(e));
            if (o000000o != null) {
                o000000o.O00000Oo.O0000Oo0 = e.toString();
            }
            bne.O000000o((Closeable) outputStream);
            if (o000000o != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            r1 = outputStream2;
            bne.O000000o((Closeable) r1);
            throw th;
        }
        if (o000000o != null) {
        }
    }

    public final void O000000o(byte[] bArr, O000000o o000000o) {
        if (o000000o != null) {
            try {
                blr O000000o2 = blp.O000000o.f13066O000000o.O000000o();
                int i = O000000o2 == null ? 2 : O000000o2.O0000oo0;
                if (o000000o.O00000Oo == null) {
                    o000000o.O00000Oo = new O00000Oo();
                }
                o000000o.O00000Oo.O00000o = 0;
                o000000o.O00000Oo.O00000Oo = bArr;
                o000000o.O00000Oo.O00000o0 = null;
                o000000o.O00000Oo.O0000O0o = true;
                o000000o.O00000Oo.O00000oO = o000000o;
                o000000o.O00000Oo.O0000OOo = Math.min(i + 1, this.O00000o0.size());
                o000000o.O00000Oo.O0000Oo = this.O00000o0.get(0);
                o000000o.O00000Oo.O00000oo = new bmg<O00000Oo>(bmf.O00000Oo().O000000o(), this.O0000OOo) {
                    /* class _m_j.bmv.AnonymousClass3 */

                    public final void run() {
                        O00000Oo o00000Oo = (O00000Oo) this.O0000OOo;
                        if (o00000Oo != null) {
                            try {
                                if (o00000Oo.O00000o < bmv.this.O00000o0.size()) {
                                    bmv.this.O000000o(o00000Oo.O00000Oo, o00000Oo.O00000o0, (String) bmv.this.O00000o0.get(o00000Oo.O00000o), o00000Oo.O00000oO);
                                }
                            } catch (Exception e) {
                                bmz.O00000o("HttpTransport", "transportWithRetry asyn failed: url: %s", Log.getStackTraceString(e));
                            }
                        } else {
                            throw new Exception("sessionCache is null");
                        }
                    }
                };
                o000000o.O00000Oo.O00000oo.O0000OOo = o000000o.O00000Oo;
            } catch (Exception e) {
                bmz.O00000o("HttpTransport", "transportWithRetry asyn failed: url: + %s", Log.getStackTraceString(e));
                return;
            }
        }
        O000000o(bArr, null, this.O00000o0.get(0), o000000o);
    }
}
