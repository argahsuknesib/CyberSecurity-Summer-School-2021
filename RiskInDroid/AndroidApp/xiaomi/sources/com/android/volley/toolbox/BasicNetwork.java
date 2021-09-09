package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mPool = byteArrayPool;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008f, code lost:
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0092, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0093, code lost:
        r2 = r4;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0095, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009f, code lost:
        r2 = null;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a3, code lost:
        r0 = r14.getStatusLine().getStatusCode();
        com.android.volley.VolleyLog.e("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r19.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bf, code lost:
        if (r2 != null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c1, code lost:
        r3 = new com.android.volley.NetworkResponse(r0, r2, r1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c8, code lost:
        if (r0 == 401) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d4, code lost:
        throw new com.android.volley.ServerError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d5, code lost:
        attemptRetryOnException("auth", r8, new com.android.volley.AuthFailureError(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e7, code lost:
        throw new com.android.volley.NetworkError((com.android.volley.NetworkResponse) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ed, code lost:
        throw new com.android.volley.NoConnectionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ee, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0106, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r19.getUrl(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0107, code lost:
        attemptRetryOnException("connection", r8, new com.android.volley.TimeoutError());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0113, code lost:
        attemptRetryOnException("socket", r8, new com.android.volley.TimeoutError());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ee A[ExcHandler: MalformedURLException (r0v2 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), SYNTHETIC, Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e8 A[SYNTHETIC] */
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        HttpResponse httpResponse;
        byte[] bArr;
        Map convertHeaders;
        byte[] bArr2;
        byte[] bArr3;
        Request<?> request2 = request;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Map hashMap = new HashMap();
            try {
                HashMap hashMap2 = new HashMap();
                addCacheHeaders(hashMap2, request.getCacheEntry());
                httpResponse = this.mHttpStack.performRequest(request2, hashMap2);
                StatusLine statusLine = httpResponse.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                Header[] allHeaders = httpResponse.getAllHeaders();
                convertHeaders = convertHeaders(allHeaders);
                if (statusCode == 304) {
                    return new NetworkResponse(304, request.getCacheEntry() == null ? null : request.getCacheEntry().data, convertHeaders, true);
                }
                if (httpResponse.getEntity() != null) {
                    bArr2 = entityToBytes(httpResponse.getEntity());
                } else {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = bArr2;
                bArr3 = bArr4;
                Map map = convertHeaders;
                logSlowRequests(SystemClock.elapsedRealtime() - elapsedRealtime, request, bArr3, statusLine);
                if (statusCode < 200 || statusCode > 299) {
                    byte[] bArr5 = bArr3;
                } else {
                    bArr = bArr3;
                    NetworkResponse networkResponse = new NetworkResponse(statusCode, bArr, map, false);
                    networkResponse.allHeaders = allHeaders;
                    return networkResponse;
                }
            } catch (SocketTimeoutException unused) {
            } catch (ConnectTimeoutException unused2) {
            } catch (MalformedURLException e) {
            } catch (IOException e2) {
                e = e2;
                hashMap = convertHeaders;
                bArr = null;
                if (httpResponse != null) {
                }
            }
        }
        byte[] bArr52 = bArr3;
        throw new IOException();
    }

    private void logSlowRequests(long j, Request<?> request, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > ((long) SLOW_REQUEST_THRESHOLD_MS)) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private void addCacheHeaders(Map<String, String> map, Cache.Entry entry) {
        if (entry != null) {
            if (entry.etag != null) {
                map.put("If-None-Match", entry.etag);
            }
            if (entry.serverDate > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(entry.serverDate)));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void logError(String str, String str2, long j) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    private byte[] entityToBytes(HttpEntity httpEntity) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                bArr = this.mPool.getBuf(1024);
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    poolingByteArrayOutputStream.write(bArr, 0, read);
                }
                return poolingByteArrayOutputStream.toByteArray();
            }
            throw new ServerError();
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(bArr);
            poolingByteArrayOutputStream.close();
        }
    }

    private static Map<String, String> convertHeaders(Header[] headerArr) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }
}
