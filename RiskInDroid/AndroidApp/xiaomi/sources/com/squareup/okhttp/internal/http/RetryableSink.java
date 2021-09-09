package com.squareup.okhttp.internal.http;

import _m_j.jax;
import _m_j.jbm;
import _m_j.jbo;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;

public final class RetryableSink implements jbm {
    private boolean closed;
    private final jax content;
    private final int limit;

    public final void flush() throws IOException {
    }

    public RetryableSink(int i) {
        this.content = new jax();
        this.limit = i;
    }

    public RetryableSink() {
        this(-1);
    }

    public final void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (this.content.O00000Oo < ((long) this.limit)) {
                throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.O00000Oo);
            }
        }
    }

    public final void write(jax jax, long j) throws IOException {
        if (!this.closed) {
            Util.checkOffsetAndCount(jax.O00000Oo, 0, j);
            if (this.limit == -1 || this.content.O00000Oo <= ((long) this.limit) - j) {
                this.content.write(jax, j);
                return;
            }
            throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
        }
        throw new IllegalStateException("closed");
    }

    public final jbo timeout() {
        return jbo.NONE;
    }

    public final long contentLength() throws IOException {
        return this.content.O00000Oo;
    }

    public final void writeToSocket(jbm jbm) throws IOException {
        jax jax = new jax();
        jax jax2 = this.content;
        jax2.O000000o(jax, 0, jax2.O00000Oo);
        jbm.write(jax, jax.O00000Oo);
    }
}
