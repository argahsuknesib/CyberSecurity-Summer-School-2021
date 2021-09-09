package okhttp3.internal.http1;

import _m_j.jax;
import _m_j.jay;
import _m_j.jaz;
import _m_j.jbd;
import _m_j.jbg;
import _m_j.jbm;
import _m_j.jbn;
import _m_j.jbo;
import _m_j.jdn;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

public final class Http1Codec implements HttpCodec {
    final OkHttpClient client;
    private long headerLimit = 262144;
    final jay sink;
    final jaz source;
    int state = 0;
    final StreamAllocation streamAllocation;

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation2, jaz jaz, jay jay) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation2;
        this.source = jaz;
        this.sink = jay;
    }

    public final jbm createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public final void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, jbg.O000000o(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(header, -1, jbg.O000000o(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, jbg.O000000o(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1, jbg.O000000o(newUnknownLengthSource()));
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    public final void flushRequest() throws IOException {
        this.sink.flush();
    }

    public final void finishRequest() throws IOException {
        this.sink.flush();
    }

    public final void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            this.sink.O00000Oo(str).O00000Oo("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.sink.O00000Oo(headers.name(i)).O00000Oo(": ").O00000Oo(headers.value(i)).O00000Oo("\r\n");
            }
            this.sink.O00000Oo("\r\n");
            this.state = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        int i = this.state;
        if (i == 1 || i == 3) {
            try {
                StatusLine parse = StatusLine.parse(readHeaderLine());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.state = 3;
                    return headers;
                }
                this.state = 4;
                return headers;
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.state);
        }
    }

    private String readHeaderLine() throws IOException {
        String O00000oo = this.source.O00000oo(this.headerLimit);
        this.headerLimit -= (long) O00000oo.length();
        return O00000oo;
    }

    public final Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readHeaderLine);
        }
    }

    public final jbm newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final jbm newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final jbn newFixedLengthSource(long j) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final jbn newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final jbn newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            StreamAllocation streamAllocation2 = this.streamAllocation;
            if (streamAllocation2 != null) {
                this.state = 5;
                streamAllocation2.noNewStreams();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.state);
    }

    final class FixedLengthSink implements jbm {
        private long bytesRemaining;
        private boolean closed;
        private final jbd timeout = new jbd(Http1Codec.this.sink.timeout());

        FixedLengthSink(long j) {
            this.bytesRemaining = j;
        }

        public final jbo timeout() {
            return this.timeout;
        }

        public final void write(jax jax, long j) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(jax.O00000Oo, 0, j);
                if (j <= this.bytesRemaining) {
                    Http1Codec.this.sink.write(jax, j);
                    this.bytesRemaining -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public final void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    Http1Codec.this.detachTimeout(this.timeout);
                    Http1Codec.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    final class ChunkedSink implements jbm {
        private boolean closed;
        private final jbd timeout = new jbd(Http1Codec.this.sink.timeout());

        ChunkedSink() {
        }

        public final jbo timeout() {
            return this.timeout;
        }

        public final void write(jax jax, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.sink.O0000o0(j);
                Http1Codec.this.sink.O00000Oo("\r\n");
                Http1Codec.this.sink.write(jax, j);
                Http1Codec.this.sink.O00000Oo("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                Http1Codec.this.sink.O00000Oo("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
            }
        }
    }

    abstract class AbstractSource implements jbn {
        protected long bytesRead;
        protected boolean closed;
        protected final jbd timeout;

        private AbstractSource() {
            this.timeout = new jbd(Http1Codec.this.source.timeout());
            this.bytesRead = 0;
        }

        public jbo timeout() {
            return this.timeout;
        }

        public long read(jax jax, long j) throws IOException {
            try {
                long read = Http1Codec.this.source.read(jax, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(false, e);
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.state != 6) {
                if (Http1Codec.this.state == 5) {
                    Http1Codec.this.detachTimeout(this.timeout);
                    Http1Codec http1Codec = Http1Codec.this;
                    http1Codec.state = 6;
                    if (http1Codec.streamAllocation != null) {
                        Http1Codec.this.streamAllocation.streamFinished(!z, Http1Codec.this, this.bytesRead, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + Http1Codec.this.state);
            }
        }
    }

    class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (this.bytesRemaining == 0) {
                endOfInput(true, null);
            }
        }

        public long read(jax jax, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (!this.closed) {
                long j2 = this.bytesRemaining;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(jax, Math.min(j2, j));
                if (read != -1) {
                    this.bytesRemaining -= read;
                    if (this.bytesRemaining == 0) {
                        endOfInput(true, null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                endOfInput(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpUrl url;

        ChunkedSource(HttpUrl httpUrl) {
            super();
            this.url = httpUrl;
        }

        public long read(jax jax, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                long j2 = this.bytesRemainingInChunk;
                if (j2 == 0 || j2 == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                long read = super.read(jax, Math.min(j, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                endOfInput(false, protocolException);
                throw protocolException;
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1Codec.this.source.O0000oO0();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.source.O0000o0O();
                String trim = Http1Codec.this.source.O0000oO0().trim();
                if (this.bytesRemainingInChunk < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + jdn.f1779O000000o);
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
                    endOfInput(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        UnknownLengthSource() {
            super();
        }

        public long read(jax jax, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = super.read(jax, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(true, null);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void detachTimeout(jbd jbd) {
        jbo jbo = jbd.f1724O000000o;
        jbd.O000000o(jbo.NONE);
        jbo.clearDeadline();
        jbo.clearTimeout();
    }
}
