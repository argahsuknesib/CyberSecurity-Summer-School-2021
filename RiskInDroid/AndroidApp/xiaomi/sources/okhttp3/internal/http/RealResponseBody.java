package okhttp3.internal.http;

import _m_j.jaz;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final jaz source;

    public RealResponseBody(String str, long j, jaz jaz) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = jaz;
    }

    public final MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public final long contentLength() {
        return this.contentLength;
    }

    public final jaz source() {
        return this.source;
    }
}
