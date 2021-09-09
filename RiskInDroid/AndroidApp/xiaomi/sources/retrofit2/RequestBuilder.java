package retrofit2;

import _m_j.jax;
import _m_j.jay;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final HttpUrl baseUrl;
    private RequestBody body;
    private MediaType contentType;
    private FormBody.Builder formBuilder;
    private final boolean hasBody;
    private final String method;
    private MultipartBody.Builder multipartBuilder;
    private String relativeUrl;
    private final Request.Builder requestBuilder = new Request.Builder();
    private HttpUrl.Builder urlBuilder;

    RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        this.contentType = mediaType;
        this.hasBody = z;
        if (headers != null) {
            this.requestBuilder.headers(headers);
        }
        if (z2) {
            this.formBuilder = new FormBody.Builder();
        } else if (z3) {
            this.multipartBuilder = new MultipartBody.Builder();
            this.multipartBuilder.setType(MultipartBody.FORM);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setRelativeUrl(Object obj) {
        if (obj != null) {
            this.relativeUrl = obj.toString();
            return;
        }
        throw new NullPointerException("@Url parameter is null.");
    }

    /* access modifiers changed from: package-private */
    public final void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            MediaType parse = MediaType.parse(str2);
            if (parse != null) {
                this.contentType = parse;
                return;
            }
            throw new IllegalArgumentException("Malformed content type: ".concat(String.valueOf(str2)));
        }
        this.requestBuilder.addHeader(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final void addPathParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            this.relativeUrl = str3.replace("{" + str + "}", canonicalizeForPath(str2, z));
            return;
        }
        throw new AssertionError();
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                jax jax = new jax();
                jax.O000000o(str, 0, i);
                canonicalizeForPath(jax, str, i, length, z);
                return jax.O0000o();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void canonicalizeForPath(jax jax, String str, int i, int i2, boolean z) {
        jax jax2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (jax2 == null) {
                        jax2 = new jax();
                    }
                    jax2.O000000o(codePointAt);
                    while (!jax2.O00000o()) {
                        byte O0000O0o = jax2.O0000O0o() & 255;
                        jax.O0000Oo(37);
                        jax.O0000Oo((int) HEX_DIGITS[(O0000O0o >> 4) & 15]);
                        jax.O0000Oo((int) HEX_DIGITS[O0000O0o & 15]);
                    }
                } else {
                    jax.O000000o(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: package-private */
    public final void addQueryParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            this.urlBuilder = this.baseUrl.newBuilder(str3);
            if (this.urlBuilder != null) {
                this.relativeUrl = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        if (z) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.addEncoded(str, str2);
        } else {
            this.formBuilder.add(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    /* access modifiers changed from: package-private */
    public final void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    /* access modifiers changed from: package-private */
    public final void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    /* access modifiers changed from: package-private */
    public final Request build() {
        HttpUrl httpUrl;
        HttpUrl.Builder builder = this.urlBuilder;
        if (builder != null) {
            httpUrl = builder.build();
        } else {
            httpUrl = this.baseUrl.resolve(this.relativeUrl);
            if (httpUrl == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            FormBody.Builder builder2 = this.formBuilder;
            if (builder2 != null) {
                contentTypeOverridingRequestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.multipartBuilder;
                if (builder3 != null) {
                    contentTypeOverridingRequestBody = builder3.build();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.contentType;
        if (mediaType != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, mediaType);
            } else {
                this.requestBuilder.addHeader("Content-Type", mediaType.toString());
            }
        }
        return this.requestBuilder.url(httpUrl).method(this.method, contentTypeOverridingRequestBody).build();
    }

    static class ContentTypeOverridingRequestBody extends RequestBody {
        private final MediaType contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public void writeTo(jay jay) throws IOException {
            this.delegate.writeTo(jay);
        }
    }
}
