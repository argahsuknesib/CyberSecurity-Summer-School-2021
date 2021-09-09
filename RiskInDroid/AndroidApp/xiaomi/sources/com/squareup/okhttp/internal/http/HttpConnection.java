package com.squareup.okhttp.internal.http;

import _m_j.jax;
import _m_j.jay;
import _m_j.jaz;
import _m_j.jbd;
import _m_j.jbg;
import _m_j.jbm;
import _m_j.jbn;
import _m_j.jbo;
import _m_j.jdn;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public final class HttpConnection {
    public final Connection connection;
    public int onIdle = 0;
    public final ConnectionPool pool;
    public final jay sink;
    private final Socket socket;
    public final jaz source;
    public int state = 0;

    public HttpConnection(ConnectionPool connectionPool, Connection connection2, Socket socket2) throws IOException {
        this.pool = connectionPool;
        this.connection = connection2;
        this.socket = socket2;
        this.source = jbg.O000000o(jbg.O00000Oo(socket2));
        this.sink = jbg.O000000o(jbg.O000000o(socket2));
    }

    public final void setTimeouts(int i, int i2) {
        if (i != 0) {
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
        }
        if (i2 != 0) {
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public final void poolOnIdle() {
        this.onIdle = 1;
        if (this.state == 0) {
            this.onIdle = 0;
            Internal.instance.recycle(this.pool, this.connection);
        }
    }

    public final void closeOnIdle() throws IOException {
        this.onIdle = 2;
        if (this.state == 0) {
            this.state = 6;
            this.connection.getSocket().close();
        }
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    public final void closeIfOwnedBy(Object obj) throws IOException {
        Internal.instance.closeIfOwnedBy(this.connection, obj);
    }

    public final void flush() throws IOException {
        this.sink.flush();
    }

    public final long bufferSize() {
        return this.source.O000000o().O00000Oo;
    }

    public final boolean isReadable() {
        int soTimeout;
        try {
            soTimeout = this.socket.getSoTimeout();
            this.socket.setSoTimeout(1);
            if (this.source.O00000o()) {
                this.socket.setSoTimeout(soTimeout);
                return false;
            }
            this.socket.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        } catch (Throwable th) {
            this.socket.setSoTimeout(soTimeout);
            throw th;
        }
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

    public final Response.Builder readResponse() throws IOException {
        StatusLine parse;
        Response.Builder message;
        int i = this.state;
        if (i == 1 || i == 3) {
            do {
                try {
                    parse = StatusLine.parse(this.source.O0000oO0());
                    message = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message);
                    Headers.Builder builder = new Headers.Builder();
                    readHeaders(builder);
                    builder.add(OkHeaders.SELECTED_PROTOCOL, parse.protocol.toString());
                    message.headers(builder.build());
                } catch (EOFException e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.connection + " (recycle count=" + Internal.instance.recycleCount(this.connection) + ")");
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (parse.code == 100);
            this.state = 4;
            return message;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final void readHeaders(Headers.Builder builder) throws IOException {
        while (true) {
            String O0000oO0 = this.source.O0000oO0();
            if (O0000oO0.length() != 0) {
                Internal.instance.addLenient(builder, O0000oO0);
            } else {
                return;
            }
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

    public final void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.state == 1) {
            this.state = 3;
            retryableSink.writeToSocket(this.sink);
            return;
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

    public final jbn newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpEngine);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final jbn newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new UnknownLengthSource();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final jay rawSink() {
        return this.sink;
    }

    public final jaz rawSource() {
        return this.source;
    }

    final class FixedLengthSink implements jbm {
        private long bytesRemaining;
        private boolean closed;
        private final jbd timeout;

        private FixedLengthSink(long j) {
            this.timeout = new jbd(HttpConnection.this.sink.timeout());
            this.bytesRemaining = j;
        }

        public final jbo timeout() {
            return this.timeout;
        }

        public final void write(jax jax, long j) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(jax.O00000Oo, 0, j);
                if (j <= this.bytesRemaining) {
                    HttpConnection.this.sink.write(jax, j);
                    this.bytesRemaining -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public final void flush() throws IOException {
            if (!this.closed) {
                HttpConnection.this.sink.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    HttpConnection.this.detachTimeout(this.timeout);
                    HttpConnection.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    final class ChunkedSink implements jbm {
        private boolean closed;
        private final jbd timeout;

        private ChunkedSink() {
            this.timeout = new jbd(HttpConnection.this.sink.timeout());
        }

        public final jbo timeout() {
            return this.timeout;
        }

        public final void write(jax jax, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                HttpConnection.this.sink.O0000o0(j);
                HttpConnection.this.sink.O00000Oo("\r\n");
                HttpConnection.this.sink.write(jax, j);
                HttpConnection.this.sink.O00000Oo("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.closed) {
                HttpConnection.this.sink.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                HttpConnection.this.sink.O00000Oo("0\r\n\r\n");
                HttpConnection.this.detachTimeout(this.timeout);
                HttpConnection.this.state = 3;
            }
        }
    }

    abstract class AbstractSource implements jbn {
        protected boolean closed;
        protected final jbd timeout;

        private AbstractSource() {
            this.timeout = new jbd(HttpConnection.this.source.timeout());
        }

        public jbo timeout() {
            return this.timeout;
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean z) throws IOException {
            if (HttpConnection.this.state == 5) {
                HttpConnection.this.detachTimeout(this.timeout);
                HttpConnection httpConnection = HttpConnection.this;
                httpConnection.state = 0;
                if (z && httpConnection.onIdle == 1) {
                    HttpConnection.this.onIdle = 0;
                    Internal.instance.recycle(HttpConnection.this.pool, HttpConnection.this.connection);
                } else if (HttpConnection.this.onIdle == 2) {
                    HttpConnection httpConnection2 = HttpConnection.this;
                    httpConnection2.state = 6;
                    httpConnection2.connection.getSocket().close();
                }
            } else {
                throw new IllegalStateException("state: " + HttpConnection.this.state);
            }
        }

        /* access modifiers changed from: protected */
        public final void unexpectedEndOfInput() {
            Util.closeQuietly(HttpConnection.this.connection.getSocket());
            HttpConnection.this.state = 6;
        }
    }

    class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (this.bytesRemaining == 0) {
                endOfInput(true);
            }
        }

        public long read(jax jax, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                long read = HttpConnection.this.source.read(jax, Math.min(this.bytesRemaining, j));
                if (read != -1) {
                    this.bytesRemaining -= read;
                    if (this.bytesRemaining == 0) {
                        endOfInput(true);
                    }
                    return read;
                }
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }

    class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpEngine httpEngine;

        ChunkedSource(HttpEngine httpEngine2) throws IOException {
            super();
            this.httpEngine = httpEngine2;
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
                long read = HttpConnection.this.source.read(jax, Math.min(j, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                HttpConnection.this.source.O0000oO0();
            }
            try {
                this.bytesRemainingInChunk = HttpConnection.this.source.O0000o0O();
                String trim = HttpConnection.this.source.O0000oO0().trim();
                if (this.bytesRemainingInChunk < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + jdn.f1779O000000o);
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Headers.Builder builder = new Headers.Builder();
                    HttpConnection.this.readHeaders(builder);
                    this.httpEngine.receiveHeaders(builder.build());
                    endOfInput(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }

    class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
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
                long read = HttpConnection.this.source.read(jax, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(false);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }

    public final void detachTimeout(jbd jbd) {
        jbo jbo = jbd.f1724O000000o;
        jbd.O000000o(jbo.NONE);
        jbo.clearDeadline();
        jbo.clearTimeout();
    }
}
