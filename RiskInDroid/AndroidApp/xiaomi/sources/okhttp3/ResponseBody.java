package okhttp3;

import _m_j.jax;
import _m_j.jaz;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.ByteString;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract jaz source();

    public final InputStream byteStream() {
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
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + O0000oOO.length + ") disagree");
            } catch (Throwable th) {
                Util.closeQuietly(source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(contentLength)));
        }
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    public final String string() throws IOException {
        jaz source = source();
        try {
            return source.O000000o(Util.bomAwareCharset(source, charset()));
        } finally {
            Util.closeQuietly(source);
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public void close() {
        Util.closeQuietly(source());
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

    public static ResponseBody create(MediaType mediaType, ByteString byteString) {
        return create(mediaType, (long) byteString.O0000OOo(), new jax().O00000o0(byteString));
    }

    public static ResponseBody create(final MediaType mediaType, final long j, final jaz jaz) {
        if (jaz != null) {
            return new ResponseBody() {
                /* class okhttp3.ResponseBody.AnonymousClass1 */

                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return j;
                }

                public jaz source() {
                    return jaz;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final jaz source;

        BomAwareReader(jaz jaz, Charset charset2) {
            this.source = jaz;
            this.charset = charset2;
        }

        public final int read(char[] cArr, int i, int i2) throws IOException {
            if (!this.closed) {
                Reader reader = this.delegate;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.source.O00000oO(), Util.bomAwareCharset(this.source, this.charset));
                    this.delegate = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }

        public final void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }
    }
}
