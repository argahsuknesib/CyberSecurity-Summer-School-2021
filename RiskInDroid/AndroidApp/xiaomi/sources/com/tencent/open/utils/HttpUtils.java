package com.tencent.open.utils;

import _m_j.dih;
import _m_j.dij;
import _m_j.diz;
import _m_j.djl;
import _m_j.djm;
import _m_j.djo;
import _m_j.djp;
import _m_j.djy;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public final class HttpUtils {

    public static class HttpStatusException extends Exception {
        public HttpStatusException(String str) {
            super(str);
        }
    }

    public static class NetworkUnavailableException extends Exception {
        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:580)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:486)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:206)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0110, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0111, code lost:
        r0.printStackTrace();
        _m_j.diy.O000000o().O000000o(r6, r8, 0, 0, -4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0122, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0123, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0124, code lost:
        r0.printStackTrace();
        _m_j.diy.O000000o().O000000o(r6, r8, 0, 0, O000000o(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0138, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0139, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013a, code lost:
        r0.printStackTrace();
        _m_j.diy.O000000o().O000000o(r6, r8, 0, 0, -3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x014b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x014c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x014d, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0150, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0151, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0152, code lost:
        r1 = r0;
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0166, code lost:
        r13 = java.lang.Integer.parseInt(r1.getMessage().replace("http status code error:", ""));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0168, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0169, code lost:
        r0.printStackTrace();
        r13 = -9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x017e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x017f, code lost:
        r0.printStackTrace();
        r10 = -8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0183, code lost:
        if (r5 < r4) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0185, code lost:
        r8 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x018a, code lost:
        _m_j.diy.O000000o().O000000o(r6, r8, 0, 0, -8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0198, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0199, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x019a, code lost:
        r0.printStackTrace();
        r10 = -7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x019e, code lost:
        if (r5 < r4) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a0, code lost:
        r8 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a6, code lost:
        r7 = r8;
        r13 = r10;
        r9 = 0;
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b4, code lost:
        _m_j.diy.O000000o().O000000o(r6, r8, 0, 0, -7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01c3, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a4, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        continue;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0123 A[ExcHandler: IOException (r0v13 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:26:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0139 A[ExcHandler: MalformedURLException (r0v12 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:26:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x014c A[ExcHandler: NetworkUnavailableException (r0v11 'e' com.tencent.open.utils.HttpUtils$NetworkUnavailableException A[CUSTOM_DECLARE]), Splitter:B:26:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0151 A[ExcHandler: HttpStatusException (r0v5 'e' com.tencent.open.utils.HttpUtils$HttpStatusException A[CUSTOM_DECLARE]), Splitter:B:26:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017e A[ExcHandler: SocketTimeoutException (r0v4 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), PHI: r2 10  PHI: (r2v6 org.json.JSONObject) = (r2v2 org.json.JSONObject), (r2v9 org.json.JSONObject), (r2v9 org.json.JSONObject), (r2v9 org.json.JSONObject) binds: [B:26:0x00f4, B:29:0x0100, B:33:0x0106, B:34:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:26:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0199 A[ExcHandler: ConnectTimeoutException (r0v3 'e' org.apache.http.conn.ConnectTimeoutException A[CUSTOM_DECLARE]), PHI: r2 10  PHI: (r2v5 org.json.JSONObject) = (r2v2 org.json.JSONObject), (r2v9 org.json.JSONObject), (r2v9 org.json.JSONObject), (r2v9 org.json.JSONObject) binds: [B:26:0x00f4, B:29:0x0100, B:33:0x0106, B:34:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:26:0x00f4] */
    public static org.json.JSONObject O000000o(_m_j.dij r15, android.content.Context r16, java.lang.String r17, android.os.Bundle r18, java.lang.String r19) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /*
            r0 = r15
            r1 = r16
            r2 = r17
            java.lang.String r3 = "openSDK_LOG.HttpUtils"
            java.lang.String r4 = "OpenApi request"
            _m_j.diz.O00000o0(r3, r4)
            java.lang.String r3 = r17.toLowerCase()
            java.lang.String r4 = "http"
            boolean r3 = r3.startsWith(r4)
            if (r3 != 0) goto L_0x004a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            _m_j.djm r4 = _m_j.djm.O000000o()
            java.lang.String r5 = "https://openmobile.qq.com/"
            java.lang.String r4 = r4.O000000o(r1, r5)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            _m_j.djm r6 = _m_j.djm.O000000o()
            java.lang.String r5 = r6.O000000o(r1, r5)
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r6 = r4
            goto L_0x004c
        L_0x004a:
            r3 = r2
            r6 = r3
        L_0x004c:
            java.lang.String r4 = "add_share"
            int r4 = r2.indexOf(r4)
            r5 = 0
            r7 = 1
            if (r4 >= 0) goto L_0x008e
            java.lang.String r4 = "upload_pic"
            int r4 = r2.indexOf(r4)
            if (r4 >= 0) goto L_0x008e
            java.lang.String r4 = "add_topic"
            int r4 = r2.indexOf(r4)
            if (r4 >= 0) goto L_0x008e
            java.lang.String r4 = "set_user_face"
            int r4 = r2.indexOf(r4)
            if (r4 >= 0) goto L_0x008e
            java.lang.String r4 = "add_t"
            int r4 = r2.indexOf(r4)
            if (r4 >= 0) goto L_0x008e
            java.lang.String r4 = "add_pic_t"
            int r4 = r2.indexOf(r4)
            if (r4 >= 0) goto L_0x008e
            java.lang.String r4 = "add_pic_url"
            int r4 = r2.indexOf(r4)
            if (r4 >= 0) goto L_0x008e
            java.lang.String r4 = "add_video"
            int r4 = r2.indexOf(r4)
            if (r4 < 0) goto L_0x0097
        L_0x008e:
            java.lang.String[] r4 = new java.lang.String[r7]
            r4[r5] = r2
            java.lang.String r2 = "requireApi"
            _m_j.dih.O000000o(r1, r15, r2, r4)
        L_0x0097:
            r2 = 0
            long r8 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r4 = r0.f14674O000000o
            _m_j.djl r4 = _m_j.djl.O000000o(r1, r4)
            java.lang.String r10 = "Common_HttpRetryCount"
            int r4 = r4.O000000o(r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "config 1:Common_HttpRetryCount            config_value:"
            r10.<init>(r11)
            r10.append(r4)
            java.lang.String r11 = "   appid:"
            r10.append(r11)
            java.lang.String r12 = r0.f14674O000000o
            r10.append(r12)
            java.lang.String r12 = "     url:"
            r10.append(r12)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            java.lang.String r13 = "OpenConfig_test"
            _m_j.diz.O000000o(r13, r10)
            if (r4 != 0) goto L_0x00d0
            r4 = 3
        L_0x00d0:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r14 = "config 1:Common_HttpRetryCount            result_value:"
            r10.<init>(r14)
            r10.append(r4)
            r10.append(r11)
            java.lang.String r0 = r0.f14674O000000o
            r10.append(r0)
            r10.append(r12)
            r10.append(r6)
            java.lang.String r0 = r10.toString()
            _m_j.diz.O000000o(r13, r0)
        L_0x00ef:
            int r5 = r5 + r7
            r12 = r18
            r13 = r19
            _m_j.djp$O000000o r0 = O000000o(r1, r3, r13, r12)     // Catch:{ ConnectTimeoutException -> 0x0199, SocketTimeoutException -> 0x017e, HttpStatusException -> 0x0151, NetworkUnavailableException -> 0x014c, MalformedURLException -> 0x0139, IOException -> 0x0123, JSONException -> 0x0110 }
            java.lang.String r14 = r0.f14727O000000o     // Catch:{ ConnectTimeoutException -> 0x0199, SocketTimeoutException -> 0x017e, HttpStatusException -> 0x0151, NetworkUnavailableException -> 0x014c, MalformedURLException -> 0x0139, IOException -> 0x0123, JSONException -> 0x0110 }
            org.json.JSONObject r2 = _m_j.djp.O00000o(r14)     // Catch:{ ConnectTimeoutException -> 0x0199, SocketTimeoutException -> 0x017e, HttpStatusException -> 0x0151, NetworkUnavailableException -> 0x014c, MalformedURLException -> 0x0139, IOException -> 0x0123, JSONException -> 0x0110 }
            java.lang.String r14 = "ret"
            int r14 = r2.getInt(r14)     // Catch:{ JSONException -> 0x0105, ConnectTimeoutException -> 0x0199, SocketTimeoutException -> 0x017e, HttpStatusException -> 0x0151, NetworkUnavailableException -> 0x014c, MalformedURLException -> 0x0139, IOException -> 0x0123 }
            goto L_0x0106
        L_0x0105:
            r14 = -4
        L_0x0106:
            long r10 = r0.O00000Oo     // Catch:{ ConnectTimeoutException -> 0x0199, SocketTimeoutException -> 0x017e, HttpStatusException -> 0x0151, NetworkUnavailableException -> 0x014c, MalformedURLException -> 0x0139, IOException -> 0x0123, JSONException -> 0x0110 }
            long r0 = r0.O00000o0     // Catch:{ ConnectTimeoutException -> 0x0199, SocketTimeoutException -> 0x017e, HttpStatusException -> 0x0151, NetworkUnavailableException -> 0x014c, MalformedURLException -> 0x0139, IOException -> 0x0123, JSONException -> 0x0110 }
            r7 = r8
            r9 = r10
            r13 = r14
            r11 = r0
            goto L_0x01ac
        L_0x0110:
            r0 = move-exception
            r0.printStackTrace()
            _m_j.diy r5 = _m_j.diy.O000000o()
            r1 = 0
            r11 = 0
            r13 = -4
            r7 = r8
            r9 = r1
            r5.O000000o(r6, r7, r9, r11, r13)
            throw r0
        L_0x0123:
            r0 = move-exception
            r0.printStackTrace()
            int r13 = O000000o(r0)
            _m_j.diy r5 = _m_j.diy.O000000o()
            r1 = 0
            r11 = 0
            r7 = r8
            r9 = r1
            r5.O000000o(r6, r7, r9, r11, r13)
            throw r0
        L_0x0139:
            r0 = move-exception
            r0.printStackTrace()
            _m_j.diy r5 = _m_j.diy.O000000o()
            r1 = 0
            r11 = 0
            r13 = -3
            r7 = r8
            r9 = r1
            r5.O000000o(r6, r7, r9, r11, r13)
            throw r0
        L_0x014c:
            r0 = move-exception
            r0.printStackTrace()
            throw r0
        L_0x0151:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
            java.lang.String r0 = r1.getMessage()
            java.lang.String r2 = "http status code error:"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r2, r3)     // Catch:{ Exception -> 0x0168 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0168 }
            r13 = r0
            goto L_0x0170
        L_0x0168:
            r0 = move-exception
            r0.printStackTrace()
            r0 = -9
            r13 = -9
        L_0x0170:
            _m_j.diy r5 = _m_j.diy.O000000o()
            r2 = 0
            r11 = 0
            r7 = r8
            r9 = r2
            r5.O000000o(r6, r7, r9, r11, r13)
            throw r1
        L_0x017e:
            r0 = move-exception
            r0.printStackTrace()
            r10 = -8
            if (r5 >= r4) goto L_0x018a
            long r8 = android.os.SystemClock.elapsedRealtime()
            goto L_0x01a4
        L_0x018a:
            _m_j.diy r5 = _m_j.diy.O000000o()
            r1 = 0
            r11 = 0
            r13 = -8
            r7 = r8
            r9 = r1
            r5.O000000o(r6, r7, r9, r11, r13)
            throw r0
        L_0x0199:
            r0 = move-exception
            r0.printStackTrace()
            r10 = -7
            if (r5 >= r4) goto L_0x01b4
            long r8 = android.os.SystemClock.elapsedRealtime()
        L_0x01a4:
            if (r5 < r4) goto L_0x00ef
            r7 = r8
            r13 = r10
            r9 = 0
            r11 = 0
        L_0x01ac:
            _m_j.diy r5 = _m_j.diy.O000000o()
            r5.O000000o(r6, r7, r9, r11, r13)
            return r2
        L_0x01b4:
            _m_j.diy r5 = _m_j.diy.O000000o()
            r1 = 0
            r11 = 0
            r13 = -7
            r7 = r8
            r9 = r1
            r5.O000000o(r6, r7, r9, r11, r13)
            goto L_0x01c4
        L_0x01c3:
            throw r0
        L_0x01c4:
            goto L_0x01c3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.O000000o(_m_j.dij, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static void O000000o(dij dij, Context context, String str, Bundle bundle, String str2, djy djy) {
        diz.O00000o0("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        final dij dij2 = dij;
        final Context context2 = context;
        final String str3 = str;
        final Bundle bundle2 = bundle;
        final String str4 = str2;
        final djy djy2 = djy;
        new Thread() {
            /* class com.tencent.open.utils.HttpUtils.AnonymousClass1 */

            public final void run() {
                try {
                    JSONObject O000000o2 = HttpUtils.O000000o(dij2, context2, str3, bundle2, str4);
                    if (djy2 != null) {
                        djy2.O000000o(O000000o2);
                        diz.O00000o0("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (MalformedURLException e) {
                    djy djy = djy2;
                    if (djy != null) {
                        djy.O000000o(e);
                        diz.O00000oO("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e.toString());
                    }
                } catch (ConnectTimeoutException e2) {
                    djy djy2 = djy2;
                    if (djy2 != null) {
                        djy2.O000000o(e2);
                        diz.O00000oO("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException" + e2.toString());
                    }
                } catch (SocketTimeoutException e3) {
                    djy djy3 = djy2;
                    if (djy3 != null) {
                        djy3.O000000o(e3);
                        diz.O00000oO("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e3.toString());
                    }
                } catch (NetworkUnavailableException e4) {
                    djy djy4 = djy2;
                    if (djy4 != null) {
                        djy4.O000000o(e4);
                        diz.O00000oO("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e4.toString());
                    }
                } catch (HttpStatusException e5) {
                    djy djy5 = djy2;
                    if (djy5 != null) {
                        djy5.O000000o(e5);
                        diz.O00000oO("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e5.toString());
                    }
                } catch (IOException e6) {
                    djy djy6 = djy2;
                    if (djy6 != null) {
                        djy6.O000000o(e6);
                        diz.O00000oO("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e6.toString());
                    }
                } catch (JSONException e7) {
                    djy djy7 = djy2;
                    if (djy7 != null) {
                        djy7.O000000o(e7);
                        diz.O00000oO("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e7.toString());
                    }
                } catch (Exception e8) {
                    djy djy8 = djy2;
                    if (djy8 != null) {
                        djy8.O000000o(e8);
                        diz.O00000oO("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e8.toString());
                    }
                }
            }
        }.start();
    }

    public static int O000000o(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof HttpResponseException) {
            return -23;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static djp.O000000o O000000o(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        Bundle bundle2;
        String str3;
        Bundle bundle3;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable())) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            String string = bundle2.getString("appid_for_getting_config");
            bundle2.remove("appid_for_getting_config");
            HttpClient O000000o2 = O000000o(context, string);
            HttpUriRequest httpUriRequest = null;
            int i = -1;
            boolean z = true;
            int i2 = 0;
            if (str2.equals("GET")) {
                String O000000o3 = O000000o(bundle2);
                int length = O000000o3.length() + 0;
                diz.O000000o("openSDK_LOG.HttpUtils", "-->openUrl2 before url =".concat(String.valueOf(str)));
                if (str.indexOf("?") == -1) {
                    str3 = str + "?";
                } else {
                    str3 = str + "&";
                }
                if (!bundle2.containsKey("access_token") && !bundle2.containsKey("pay_token") && !bundle2.containsKey("pfkey") && !bundle2.containsKey("expires_in") && !bundle2.containsKey("openid") && !bundle2.containsKey("proxy_code") && !bundle2.containsKey("proxy_expires_in")) {
                    z = false;
                }
                if (!z) {
                    bundle3 = bundle2;
                } else {
                    bundle3 = new Bundle(bundle2);
                    bundle3.remove("access_token");
                    bundle3.remove("pay_token");
                    bundle3.remove("pfkey");
                    bundle3.remove("expires_in");
                    bundle3.remove("openid");
                    bundle3.remove("proxy_code");
                    bundle3.remove("proxy_expires_in");
                }
                if (bundle3 != bundle2) {
                    diz.O00000o0("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + O000000o(bundle3) + " -- url = " + str3);
                } else {
                    diz.O00000o0("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + O000000o3 + " -- url = " + str3);
                }
                HttpUriRequest httpGet = new HttpGet(str3 + O000000o3);
                httpGet.addHeader("Accept-Encoding", "gzip");
                i2 = length;
                httpUriRequest = httpGet;
            } else if (str2.equals("POST")) {
                httpUriRequest = new HttpPost(str);
                httpUriRequest.addHeader("Accept-Encoding", "gzip");
                Bundle bundle4 = new Bundle();
                for (String next : bundle2.keySet()) {
                    Object obj = bundle2.get(next);
                    if (obj instanceof byte[]) {
                        bundle4.putByteArray(next, (byte[]) obj);
                    }
                }
                if (!bundle2.containsKey("method")) {
                    bundle2.putString("method", str2);
                }
                httpUriRequest.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
                httpUriRequest.setHeader("Connection", "Keep-Alive");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(djp.O00000oO("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                byteArrayOutputStream.write(djp.O00000oO(O000000o(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
                if (!bundle4.isEmpty()) {
                    int size = bundle4.size();
                    byteArrayOutputStream.write(djp.O00000oO("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    for (String next2 : bundle4.keySet()) {
                        i++;
                        byteArrayOutputStream.write(djp.O00000oO("Content-Disposition: form-data; name=\"" + next2 + "\"; filename=\"" + next2 + "\"\r\n"));
                        byteArrayOutputStream.write(djp.O00000oO("Content-Type: content/unknown\r\n\r\n"));
                        byte[] byteArray = bundle4.getByteArray(next2);
                        if (byteArray != null) {
                            byteArrayOutputStream.write(byteArray);
                        }
                        if (i < size - 1) {
                            byteArrayOutputStream.write(djp.O00000oO("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                        }
                    }
                }
                byteArrayOutputStream.write(djp.O00000oO("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                i2 = 0 + byteArray2.length;
                byteArrayOutputStream.close();
                httpUriRequest.setEntity(new ByteArrayEntity(byteArray2));
            }
            HttpResponse execute = O000000o2.execute(httpUriRequest);
            int statusCode = execute.getStatusLine().getStatusCode();
            diz.O00000o0("openSDK_LOG.HttpUtils", "-->openUrl2 response cdoe =".concat(String.valueOf(statusCode)));
            if (statusCode == 200) {
                return new djp.O000000o(O000000o(execute), i2);
            }
            throw new HttpStatusException("http status code error:".concat(String.valueOf(statusCode)));
        }
        throw new NetworkUnavailableException("network unavailable");
    }

    private static String O000000o(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        InputStream gZIPInputStream = (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf("gzip") < 0) ? content : new GZIPInputStream(content);
        byte[] bArr = new byte[512];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                gZIPInputStream.close();
                return str;
            }
        }
    }

    public static HttpClient O000000o(Context context, String str) {
        int i;
        int i2;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        String str2;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", socketFactory, 443));
            } else {
                schemeRegistry.register(new Scheme("https", new djo(), 443));
            }
        } catch (Exception unused) {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        O000000o o000000o = null;
        djl O000000o2 = context != null ? djl.O000000o(context, str) : null;
        if (O000000o2 != null) {
            i2 = O000000o2.O000000o("Common_HttpConnectionTimeout");
            i = O000000o2.O000000o("Common_SocketConnectionTimeout");
        } else {
            i = 0;
            i2 = 0;
        }
        if (i2 == 0) {
            i2 = 15000;
        }
        if (i == 0) {
            i = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i2);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        if (!(context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0)) {
            if (Build.VERSION.SDK_INT >= 11) {
                str2 = System.getProperty("http.proxyHost");
            } else if (context != null) {
                str2 = Proxy.getHost(context);
                if (TextUtils.isEmpty(str2)) {
                    str2 = Proxy.getDefaultHost();
                }
            } else {
                str2 = Proxy.getDefaultHost();
            }
            int O000000o3 = O000000o(context);
            if (!TextUtils.isEmpty(str2) && O000000o3 >= 0) {
                o000000o = new O000000o(str2, O000000o3, (byte) 0);
            }
        }
        if (o000000o != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(o000000o.f5877O000000o, o000000o.O00000Oo));
        }
        return defaultHttpClient;
    }

    public static String O000000o(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if ((obj instanceof String) || (obj instanceof String[])) {
                if (obj instanceof String[]) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(next) + "=");
                    String[] stringArray = bundle.getStringArray(next);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                sb.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                sb.append(URLEncoder.encode("," + stringArray[i]));
                            }
                        }
                    }
                } else {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(next) + "=" + URLEncoder.encode(bundle.getString(next)));
                }
            }
        }
        return sb.toString();
    }

    private static String O000000o(Bundle bundle, String str) {
        StringBuilder sb = new StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (String next : bundle.keySet()) {
            i++;
            Object obj = bundle.get(next);
            if (obj instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + next + "\"\r\n\r\n" + ((String) obj));
                if (i < size - 1) {
                    sb.append("\r\n--" + str + "\r\n");
                }
            }
        }
        return sb.toString();
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f5877O000000o;
        public final int O00000Oo;

        /* synthetic */ O000000o(String str, int i, byte b) {
            this(str, i);
        }

        private O000000o(String str, int i) {
            this.f5877O000000o = str;
            this.O00000Oo = i;
        }
    }

    private static int O000000o(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            String property = System.getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                try {
                    return Integer.parseInt(property);
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        } else if (context == null) {
            return Proxy.getDefaultPort();
        } else {
            int port = Proxy.getPort(context);
            if (port < 0) {
                return Proxy.getDefaultPort();
            }
            return port;
        }
    }
}
