package okhttp3;

import _m_j.jax;
import _m_j.jay;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.ByteString;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType FORM = MediaType.get("multipart/form-data");
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");
    private final ByteString boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.boundary = byteString;
        this.originalType = mediaType;
        this.contentType = MediaType.get(mediaType + "; boundary=" + byteString.O000000o());
        this.parts = Util.immutableList(list);
    }

    public final MediaType type() {
        return this.originalType;
    }

    public final String boundary() {
        return this.boundary.O000000o();
    }

    public final int size() {
        return this.parts.size();
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final Part part(int i) {
        return this.parts.get(i);
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

    public final void writeTo(jay jay) throws IOException {
        writeOrCountBytes(jay, false);
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
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = this.parts.get(i);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            jay.O00000o0(DASHDASH);
            jay.O00000o0(this.boundary);
            jay.O00000o0(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    jay.O00000Oo(headers.name(i2)).O00000o0(COLONSPACE).O00000Oo(headers.value(i2)).O00000o0(CRLF);
                }
            }
            MediaType contentType2 = requestBody.contentType();
            if (contentType2 != null) {
                jay.O00000Oo("Content-Type: ").O00000Oo(contentType2.toString()).O00000o0(CRLF);
            }
            long contentLength2 = requestBody.contentLength();
            if (contentLength2 != -1) {
                jay.O00000Oo("Content-Length: ").O0000o0O(contentLength2).O00000o0(CRLF);
            } else if (z) {
                jax.O0000oOo();
                return -1;
            }
            jay.O00000o0(CRLF);
            if (z) {
                j += contentLength2;
            } else {
                requestBody.writeTo(jay);
            }
            jay.O00000o0(CRLF);
        }
        jay.O00000o0(DASHDASH);
        jay.O00000o0(this.boundary);
        jay.O00000o0(DASHDASH);
        jay.O00000o0(CRLF);
        if (!z) {
            return j;
        }
        long j2 = j + jax.O00000Oo;
        jax.O0000oOo();
        return j2;
    }

    static StringBuilder appendQuotedString(StringBuilder sb, String str) {
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

    public static final class Part {
        final RequestBody body;
        final Headers headers;

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part create(Headers headers2, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            } else if (headers2 != null && headers2.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers2 == null || headers2.get("Content-Length") == null) {
                return new Part(headers2, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create((MediaType) null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                MultipartBody.appendQuotedString(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.appendQuotedString(sb, str2);
                }
                return create(Headers.of("Content-Disposition", sb.toString()), requestBody);
            }
            throw new NullPointerException("name == null");
        }

        private Part(Headers headers2, RequestBody requestBody) {
            this.headers = headers2;
            this.body = requestBody;
        }

        public final Headers headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }
    }

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = ByteString.O000000o(str);
        }

        public final Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(mediaType)));
            }
        }

        public final Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public final Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public final Builder addPart(Part part) {
            if (part != null) {
                this.parts.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }
}
