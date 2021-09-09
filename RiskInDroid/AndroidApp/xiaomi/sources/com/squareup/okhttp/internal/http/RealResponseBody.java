package com.squareup.okhttp.internal.http;

import _m_j.jaz;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;

public final class RealResponseBody extends ResponseBody {
    private final Headers headers;
    private final jaz source;

    public RealResponseBody(Headers headers2, jaz jaz) {
        this.headers = headers2;
        this.source = jaz;
    }

    public final MediaType contentType() {
        String str = this.headers.get("Content-Type");
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public final long contentLength() {
        return OkHeaders.contentLength(this.headers);
    }

    public final jaz source() {
        return this.source;
    }
}
