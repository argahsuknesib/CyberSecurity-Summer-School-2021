package com.squareup.okhttp;

import _m_j.jay;
import _m_j.jbg;
import _m_j.jbn;
import com.squareup.okhttp.internal.Util;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.ByteString;

public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(jay jay) throws IOException;

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() {
            /* class com.squareup.okhttp.RequestBody.AnonymousClass1 */

            public final MediaType contentType() {
                return mediaType;
            }

            public final long contentLength() throws IOException {
                return (long) byteString.O0000OOo();
            }

            public final void writeTo(jay jay) throws IOException {
                jay.O00000o0(byteString);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                /* class com.squareup.okhttp.RequestBody.AnonymousClass2 */

                public final MediaType contentType() {
                    return mediaType;
                }

                public final long contentLength() {
                    return (long) i2;
                }

                public final void writeTo(jay jay) throws IOException {
                    jay.O00000o0(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                /* class com.squareup.okhttp.RequestBody.AnonymousClass3 */

                public final MediaType contentType() {
                    return mediaType;
                }

                public final long contentLength() {
                    return file.length();
                }

                public final void writeTo(jay jay) throws IOException {
                    jbn jbn = null;
                    try {
                        jbn = jbg.O000000o(file);
                        jay.O000000o(jbn);
                    } finally {
                        Util.closeQuietly(jbn);
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
