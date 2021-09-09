package com.squareup.okhttp;

import _m_j.jax;
import _m_j.jay;
import _m_j.jaz;
import _m_j.jbb;
import _m_j.jbc;
import _m_j.jbg;
import _m_j.jbm;
import _m_j.jbn;
import _m_j.jdn;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okio.ByteString;

public final class Cache {
    public final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    public int writeAbortCount;
    public int writeSuccessCount;

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new InternalCache() {
            /* class com.squareup.okhttp.Cache.AnonymousClass1 */

            public Response get(Request request) throws IOException {
                return Cache.this.get(request);
            }

            public CacheRequest put(Response response) throws IOException {
                return Cache.this.put(response);
            }

            public void remove(Request request) throws IOException {
                Cache.this.remove(request);
            }

            public void update(Response response, Response response2) throws IOException {
                Cache.this.update(response, response2);
            }

            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.trackResponse(cacheStrategy);
            }
        };
        this.cache = DiskLruCache.create(fileSystem, file, 201105, 2, j);
    }

    private static String urlToKey(Request request) {
        return Util.md5Hex(request.urlString());
    }

    /* access modifiers changed from: package-private */
    public final Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(urlToKey(request));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(request, snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public final CacheRequest put(Response response) throws IOException {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals("GET") || OkHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.cache.edit(urlToKey(response.request()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new CacheRequestImpl(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    public final void remove(Request request) throws IOException {
        this.cache.remove(urlToKey(request));
    }

    public final void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).snapshot.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            abortQuietly(editor);
        }
    }

    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public final Iterator<String> urls() throws IOException {
        return new Iterator<String>() {
            /* class com.squareup.okhttp.Cache.AnonymousClass2 */
            boolean canRemove;
            final Iterator<DiskLruCache.Snapshot> delegate = Cache.this.cache.snapshots();
            String nextUrl;

            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        this.nextUrl = jbg.O000000o(next.getSource(0)).O0000oO0();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            public String next() {
                if (hasNext()) {
                    String str = this.nextUrl;
                    this.nextUrl = null;
                    this.canRemove = true;
                    return str;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                if (this.canRemove) {
                    this.delegate.remove();
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }
        };
    }

    public final synchronized int getWriteAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int getWriteSuccessCount() {
        return this.writeSuccessCount;
    }

    public final long getSize() throws IOException {
        return this.cache.size();
    }

    public final long getMaxSize() {
        return this.cache.getMaxSize();
    }

    public final void flush() throws IOException {
        this.cache.flush();
    }

    public final void close() throws IOException {
        this.cache.close();
    }

    public final File getDirectory() {
        return this.cache.getDirectory();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    public final synchronized void trackResponse(CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    public final synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public final synchronized int getNetworkCount() {
        return this.networkCount;
    }

    public final synchronized int getHitCount() {
        return this.hitCount;
    }

    public final synchronized int getRequestCount() {
        return this.requestCount;
    }

    final class CacheRequestImpl implements CacheRequest {
        private jbm body;
        private jbm cacheOut;
        public boolean done;
        private final DiskLruCache.Editor editor;

        public CacheRequestImpl(final DiskLruCache.Editor editor2) throws IOException {
            this.editor = editor2;
            this.cacheOut = editor2.newSink(1);
            this.body = new jbb(this.cacheOut, Cache.this) {
                /* class com.squareup.okhttp.Cache.CacheRequestImpl.AnonymousClass1 */

                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (!CacheRequestImpl.this.done) {
                            CacheRequestImpl.this.done = true;
                            Cache.this.writeSuccessCount++;
                            super.close();
                            editor2.commit();
                        }
                    }
                }
            };
        }

        public final void abort() {
            synchronized (Cache.this) {
                if (!this.done) {
                    this.done = true;
                    Cache.this.writeAbortCount++;
                    Util.closeQuietly(this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public final jbm body() {
            return this.body;
        }
    }

    static final class Entry {
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String url;
        private final Headers varyHeaders;

        public Entry(jbn jbn) throws IOException {
            try {
                jaz O000000o2 = jbg.O000000o(jbn);
                this.url = O000000o2.O0000oO0();
                this.requestMethod = O000000o2.O0000oO0();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(O000000o2);
                for (int i = 0; i < readInt; i++) {
                    builder.addLenient(O000000o2.O0000oO0());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(O000000o2.O0000oO0());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(O000000o2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    builder2.addLenient(O000000o2.O0000oO0());
                }
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String O0000oO0 = O000000o2.O0000oO0();
                    if (O0000oO0.length() <= 0) {
                        this.handshake = Handshake.get(O000000o2.O0000oO0(), readCertificateList(O000000o2), readCertificateList(O000000o2));
                    } else {
                        throw new IOException("expected \"\" but was \"" + O0000oO0 + jdn.f1779O000000o);
                    }
                } else {
                    this.handshake = null;
                }
            } finally {
                jbn.close();
            }
        }

        public Entry(Response response) {
            this.url = response.request().urlString();
            this.varyHeaders = OkHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            jay O000000o2 = jbg.O000000o(editor.newSink(0));
            O000000o2.O00000Oo(this.url);
            O000000o2.O0000Oo(10);
            O000000o2.O00000Oo(this.requestMethod);
            O000000o2.O0000Oo(10);
            O000000o2.O0000o0O((long) this.varyHeaders.size());
            O000000o2.O0000Oo(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                O000000o2.O00000Oo(this.varyHeaders.name(i));
                O000000o2.O00000Oo(": ");
                O000000o2.O00000Oo(this.varyHeaders.value(i));
                O000000o2.O0000Oo(10);
            }
            O000000o2.O00000Oo(new StatusLine(this.protocol, this.code, this.message).toString());
            O000000o2.O0000Oo(10);
            O000000o2.O0000o0O((long) this.responseHeaders.size());
            O000000o2.O0000Oo(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                O000000o2.O00000Oo(this.responseHeaders.name(i2));
                O000000o2.O00000Oo(": ");
                O000000o2.O00000Oo(this.responseHeaders.value(i2));
                O000000o2.O0000Oo(10);
            }
            if (isHttps()) {
                O000000o2.O0000Oo(10);
                O000000o2.O00000Oo(this.handshake.cipherSuite());
                O000000o2.O0000Oo(10);
                writeCertList(O000000o2, this.handshake.peerCertificates());
                writeCertList(O000000o2, this.handshake.localCertificates());
            }
            O000000o2.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(jaz jaz) throws IOException {
            int readInt = Cache.readInt(jaz);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    String O0000oO0 = jaz.O0000oO0();
                    jax jax = new jax();
                    jax.O00000o0(ByteString.O00000Oo(O0000oO0));
                    arrayList.add(instance.generateCertificate(jax.O00000oO()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertList(jay jay, List<Certificate> list) throws IOException {
            try {
                jay.O0000o0O((long) list.size());
                jay.O0000Oo(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    jay.O00000Oo(ByteString.O000000o(list.get(i).getEncoded()).O00000Oo());
                    jay.O0000Oo(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            return this.url.equals(request.urlString()) && this.requestMethod.equals(request.method()) && OkHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(Request request, DiskLruCache.Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).build();
        }
    }

    public static int readInt(jaz jaz) throws IOException {
        try {
            long O0000o0 = jaz.O0000o0();
            String O0000oO0 = jaz.O0000oO0();
            if (O0000o0 >= 0 && O0000o0 <= 2147483647L && O0000oO0.isEmpty()) {
                return (int) O0000o0;
            }
            throw new IOException("expected an int but was \"" + O0000o0 + O0000oO0 + jdn.f1779O000000o);
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    static class CacheResponseBody extends ResponseBody {
        private final jaz bodySource;
        private final String contentLength;
        private final String contentType;
        public final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(final DiskLruCache.Snapshot snapshot2, String str, String str2) {
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = jbg.O000000o(new jbc(snapshot2.getSource(1)) {
                /* class com.squareup.okhttp.Cache.CacheResponseBody.AnonymousClass1 */

                public void close() throws IOException {
                    snapshot2.close();
                    super.close();
                }
            });
        }

        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public long contentLength() {
            try {
                if (this.contentLength != null) {
                    return Long.parseLong(this.contentLength);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public jaz source() {
            return this.bodySource;
        }
    }
}
