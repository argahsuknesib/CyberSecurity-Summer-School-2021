package com.facebook.react.modules.network;

import _m_j.jay;
import _m_j.jbg;
import _m_j.jbm;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ProgressRequestBody extends RequestBody {
    private long mContentLength = 0;
    public final ProgressListener mProgressListener;
    private final RequestBody mRequestBody;

    public ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        this.mRequestBody = requestBody;
        this.mProgressListener = progressListener;
    }

    public MediaType contentType() {
        return this.mRequestBody.contentType();
    }

    public long contentLength() throws IOException {
        if (this.mContentLength == 0) {
            this.mContentLength = this.mRequestBody.contentLength();
        }
        return this.mContentLength;
    }

    public void writeTo(jay jay) throws IOException {
        jay O000000o2 = jbg.O000000o(outputStreamSink(jay));
        contentLength();
        this.mRequestBody.writeTo(O000000o2);
        O000000o2.flush();
    }

    private jbm outputStreamSink(jay jay) {
        return jbg.O000000o(new CountingOutputStream(jay.O00000Oo()) {
            /* class com.facebook.react.modules.network.ProgressRequestBody.AnonymousClass1 */

            public void write(byte[] bArr, int i, int i2) throws IOException {
                super.write(bArr, i, i2);
                sendProgressUpdate();
            }

            public void write(int i) throws IOException {
                super.write(i);
                sendProgressUpdate();
            }

            private void sendProgressUpdate() throws IOException {
                long count = getCount();
                long contentLength = ProgressRequestBody.this.contentLength();
                ProgressRequestBody.this.mProgressListener.onProgress(count, contentLength, count == contentLength);
            }
        });
    }
}
