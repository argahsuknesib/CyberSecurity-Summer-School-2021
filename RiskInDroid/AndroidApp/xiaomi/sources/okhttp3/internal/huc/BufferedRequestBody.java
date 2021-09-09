package okhttp3.internal.huc;

import _m_j.jax;
import _m_j.jay;
import java.io.IOException;
import okhttp3.Request;

final class BufferedRequestBody extends OutputStreamRequestBody {
    final jax buffer = new jax();
    long contentLength = -1;

    BufferedRequestBody(long j) {
        initOutputStream(this.buffer, j);
    }

    public final long contentLength() throws IOException {
        return this.contentLength;
    }

    public final Request prepareToSendRequest(Request request) throws IOException {
        if (request.header("Content-Length") != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.O00000Oo;
        return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.O00000Oo)).build();
    }

    public final void writeTo(jay jay) throws IOException {
        this.buffer.O000000o(jay.O000000o(), 0, this.buffer.O00000Oo);
    }
}
