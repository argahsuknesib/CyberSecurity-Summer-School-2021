package okhttp3.internal.huc;

import _m_j.jay;
import _m_j.jbo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

abstract class OutputStreamRequestBody extends RequestBody {
    boolean closed;
    private long expectedContentLength;
    private OutputStream outputStream;
    private jbo timeout;

    public final MediaType contentType() {
        return null;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        return request;
    }

    OutputStreamRequestBody() {
    }

    /* access modifiers changed from: protected */
    public void initOutputStream(final jay jay, final long j) {
        this.timeout = jay.timeout();
        this.expectedContentLength = j;
        this.outputStream = new OutputStream() {
            /* class okhttp3.internal.huc.OutputStreamRequestBody.AnonymousClass1 */
            private long bytesReceived;

            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (!OutputStreamRequestBody.this.closed) {
                    long j = j;
                    if (j == -1 || this.bytesReceived + ((long) i2) <= j) {
                        this.bytesReceived += (long) i2;
                        try {
                            jay.O00000o0(bArr, i, i2);
                        } catch (InterruptedIOException e) {
                            throw new SocketTimeoutException(e.getMessage());
                        }
                    } else {
                        throw new ProtocolException("expected " + j + " bytes but received " + this.bytesReceived + i2);
                    }
                } else {
                    throw new IOException("closed");
                }
            }

            public void flush() throws IOException {
                if (!OutputStreamRequestBody.this.closed) {
                    jay.flush();
                }
            }

            public void close() throws IOException {
                OutputStreamRequestBody.this.closed = true;
                long j = j;
                if (j == -1 || this.bytesReceived >= j) {
                    jay.close();
                    return;
                }
                throw new ProtocolException("expected " + j + " bytes but received " + this.bytesReceived);
            }
        };
    }

    public final OutputStream outputStream() {
        return this.outputStream;
    }

    public final jbo timeout() {
        return this.timeout;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public long contentLength() throws IOException {
        return this.expectedContentLength;
    }
}
