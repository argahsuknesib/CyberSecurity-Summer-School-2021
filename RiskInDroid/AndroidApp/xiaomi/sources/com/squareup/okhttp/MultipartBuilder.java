package com.squareup.okhttp;

import _m_j.jax;
import _m_j.jay;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.ByteString;

public final class MultipartBuilder {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    public static final byte[] COLONSPACE = {58, 32};
    public static final byte[] CRLF = {13, 10};
    public static final byte[] DASHDASH = {45, 45};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final ByteString boundary;
    private final List<RequestBody> partBodies;
    private final List<Headers> partHeaders;
    private MediaType type;

    public MultipartBuilder() {
        this(UUID.randomUUID().toString());
    }

    public MultipartBuilder(String str) {
        this.type = MIXED;
        this.partHeaders = new ArrayList();
        this.partBodies = new ArrayList();
        this.boundary = ByteString.O000000o(str);
    }

    public final MultipartBuilder type(MediaType mediaType) {
        if (mediaType == null) {
            throw new NullPointerException("type == null");
        } else if (mediaType.type().equals("multipart")) {
            this.type = mediaType;
            return this;
        } else {
            throw new IllegalArgumentException("multipart != ".concat(String.valueOf(mediaType)));
        }
    }

    public final MultipartBuilder addPart(RequestBody requestBody) {
        return addPart(null, requestBody);
    }

    public final MultipartBuilder addPart(Headers headers, RequestBody requestBody) {
        if (requestBody == null) {
            throw new NullPointerException("body == null");
        } else if (headers != null && headers.get("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        } else if (headers == null || headers.get("Content-Length") == null) {
            this.partHeaders.add(headers);
            this.partBodies.add(requestBody);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
    }

    private static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                sb.append("%0A");
            } else if (charAt == 13) {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    public final MultipartBuilder addFormDataPart(String str, String str2) {
        return addFormDataPart(str, null, RequestBody.create((MediaType) null, str2));
    }

    public final MultipartBuilder addFormDataPart(String str, String str2, RequestBody requestBody) {
        if (str != null) {
            StringBuilder sb = new StringBuilder("form-data; name=");
            appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                appendQuotedString(sb, str2);
            }
            return addPart(Headers.of("Content-Disposition", sb.toString()), requestBody);
        }
        throw new NullPointerException("name == null");
    }

    public final RequestBody build() {
        if (!this.partHeaders.isEmpty()) {
            return new MultipartRequestBody(this.type, this.boundary, this.partHeaders, this.partBodies);
        }
        throw new IllegalStateException("Multipart body must have at least one part.");
    }

    static final class MultipartRequestBody extends RequestBody {
        private final ByteString boundary;
        private long contentLength = -1;
        private final MediaType contentType;
        private final List<RequestBody> partBodies;
        private final List<Headers> partHeaders;

        public MultipartRequestBody(MediaType mediaType, ByteString byteString, List<Headers> list, List<RequestBody> list2) {
            if (mediaType != null) {
                this.boundary = byteString;
                this.contentType = MediaType.parse(mediaType + "; boundary=" + byteString.O000000o());
                this.partHeaders = Util.immutableList(list);
                this.partBodies = Util.immutableList(list2);
                return;
            }
            throw new NullPointerException("type == null");
        }

        public final MediaType contentType() {
            return this.contentType;
        }

        public final long contentLength() throws IOException {
            long j = this.contentLength;
            if (j != -1) {
                return j;
            }
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: _m_j.jay} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: _m_j.jax} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: _m_j.jax} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: _m_j.jay} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: _m_j.jax} */
        /* JADX WARNING: Multi-variable type inference failed */
        private long writeOrCountBytes(jay jay, boolean z) throws IOException {
            jax jax;
            if (z) {
                jay = new jax();
                jax = jay;
            } else {
                jax = 0;
            }
            int size = this.partHeaders.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                Headers headers = this.partHeaders.get(i);
                RequestBody requestBody = this.partBodies.get(i);
                jay.O00000o0(MultipartBuilder.DASHDASH);
                jay.O00000o0(this.boundary);
                jay.O00000o0(MultipartBuilder.CRLF);
                if (headers != null) {
                    int size2 = headers.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        jay.O00000Oo(headers.name(i2)).O00000o0(MultipartBuilder.COLONSPACE).O00000Oo(headers.value(i2)).O00000o0(MultipartBuilder.CRLF);
                    }
                }
                MediaType contentType2 = requestBody.contentType();
                if (contentType2 != null) {
                    jay.O00000Oo("Content-Type: ").O00000Oo(contentType2.toString()).O00000o0(MultipartBuilder.CRLF);
                }
                long contentLength2 = requestBody.contentLength();
                if (contentLength2 != -1) {
                    jay.O00000Oo("Content-Length: ").O0000o0O(contentLength2).O00000o0(MultipartBuilder.CRLF);
                } else if (z) {
                    jax.O0000oOo();
                    return -1;
                }
                jay.O00000o0(MultipartBuilder.CRLF);
                if (z) {
                    j += contentLength2;
                } else {
                    this.partBodies.get(i).writeTo(jay);
                }
                jay.O00000o0(MultipartBuilder.CRLF);
            }
            jay.O00000o0(MultipartBuilder.DASHDASH);
            jay.O00000o0(this.boundary);
            jay.O00000o0(MultipartBuilder.DASHDASH);
            jay.O00000o0(MultipartBuilder.CRLF);
            if (!z) {
                return j;
            }
            long j2 = j + jax.O00000Oo;
            jax.O0000oOo();
            return j2;
        }

        public final void writeTo(jay jay) throws IOException {
            writeOrCountBytes(jay, false);
        }
    }
}
