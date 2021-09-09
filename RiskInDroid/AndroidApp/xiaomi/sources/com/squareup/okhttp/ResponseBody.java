package com.squareup.okhttp;

import _m_j.jax;
import _m_j.jaz;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    public abstract long contentLength() throws IOException;

    public abstract MediaType contentType();

    public abstract jaz source() throws IOException;

    public final InputStream byteStream() throws IOException {
        return source().O00000oO();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            jaz source = source();
            try {
                byte[] O0000oOO = source.O0000oOO();
                Util.closeQuietly(source);
                if (contentLength == -1 || contentLength == ((long) O0000oOO.length)) {
                    return O0000oOO;
                }
                throw new IOException("Content-Length and stream length disagree");
            } catch (Throwable th) {
                Util.closeQuietly(source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(contentLength)));
        }
    }

    public final Reader charStream() throws IOException {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(byteStream(), charset());
        this.reader = inputStreamReader;
        return inputStreamReader;
    }

    public final String string() throws IOException {
        return new String(bytes(), charset().name());
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public void close() throws IOException {
        source().close();
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        jax O000000o2 = new jax().O00000Oo(str, charset);
        return create(mediaType, O000000o2.O00000Oo, O000000o2);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new jax().O00000o0(bArr));
    }

    public static ResponseBody create(final MediaType mediaType, final long j, final jaz jaz) {
        if (jaz != null) {
            return new ResponseBody() {
                /* class com.squareup.okhttp.ResponseBody.AnonymousClass1 */

                public final MediaType contentType() {
                    return mediaType;
                }

                public final long contentLength() {
                    return j;
                }

                public final jaz source() {
                    return jaz;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
