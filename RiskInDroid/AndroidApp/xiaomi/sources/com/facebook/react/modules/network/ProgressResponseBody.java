package com.facebook.react.modules.network;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbc;
import _m_j.jbg;
import _m_j.jbn;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public class ProgressResponseBody extends ResponseBody {
    private jaz mBufferedSource;
    public final ProgressListener mProgressListener;
    public final ResponseBody mResponseBody;
    public long mTotalBytesRead = 0;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.mResponseBody = responseBody;
        this.mProgressListener = progressListener;
    }

    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public long totalBytesRead() {
        return this.mTotalBytesRead;
    }

    public jaz source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = jbg.O000000o(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    private jbn source(jbn jbn) {
        return new jbc(jbn) {
            /* class com.facebook.react.modules.network.ProgressResponseBody.AnonymousClass1 */

            public long read(jax jax, long j) throws IOException {
                long read = super.read(jax, j);
                ProgressResponseBody.this.mTotalBytesRead += read != -1 ? read : 0;
                ProgressResponseBody.this.mProgressListener.onProgress(ProgressResponseBody.this.mTotalBytesRead, ProgressResponseBody.this.mResponseBody.contentLength(), read == -1);
                return read;
            }
        };
    }
}
