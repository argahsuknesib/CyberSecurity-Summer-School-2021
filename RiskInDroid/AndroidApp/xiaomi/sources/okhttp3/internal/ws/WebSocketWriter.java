package okhttp3.internal.ws;

import _m_j.jax;
import _m_j.jay;
import _m_j.jbm;
import _m_j.jbo;
import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.util.Random;
import okio.ByteString;

final class WebSocketWriter {
    boolean activeWriter;
    final jax buffer = new jax();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final jax.O000000o maskCursor;
    private final byte[] maskKey;
    final Random random;
    final jay sink;
    final jax sinkBuffer;
    boolean writerClosed;

    WebSocketWriter(boolean z, jay jay, Random random2) {
        if (jay == null) {
            throw new NullPointerException("sink == null");
        } else if (random2 != null) {
            this.isClient = z;
            this.sink = jay;
            this.sinkBuffer = jay.O000000o();
            this.random = random2;
            jax.O000000o o000000o = null;
            this.maskKey = z ? new byte[4] : null;
            this.maskCursor = z ? new jax.O000000o() : o000000o;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void writePing(ByteString byteString) throws IOException {
        writeControlFrame(9, byteString);
    }

    /* access modifiers changed from: package-private */
    public final void writePong(ByteString byteString) throws IOException {
        writeControlFrame(10, byteString);
    }

    /* access modifiers changed from: package-private */
    public final void writeClose(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.O00000Oo;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            jax jax = new jax();
            jax.O0000Oo0(i);
            if (byteString != null) {
                jax.O00000o0(byteString);
            }
            byteString2 = jax.O0000o0o();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    private void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            int O0000OOo = byteString.O0000OOo();
            if (((long) O0000OOo) <= 125) {
                this.sinkBuffer.O0000Oo(i | NotificationCompat.FLAG_HIGH_PRIORITY);
                if (this.isClient) {
                    this.sinkBuffer.O0000Oo(O0000OOo | NotificationCompat.FLAG_HIGH_PRIORITY);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.O00000o0(this.maskKey);
                    if (O0000OOo > 0) {
                        long j = this.sinkBuffer.O00000Oo;
                        this.sinkBuffer.O00000o0(byteString);
                        this.sinkBuffer.O000000o(this.maskCursor);
                        this.maskCursor.O000000o(j);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.O0000Oo(O0000OOo);
                    this.sinkBuffer.O00000o0(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public final jbm newMessageSink(int i, long j) {
        if (!this.activeWriter) {
            this.activeWriter = true;
            FrameSink frameSink2 = this.frameSink;
            frameSink2.formatOpcode = i;
            frameSink2.contentLength = j;
            frameSink2.isFirstFrame = true;
            frameSink2.closed = false;
            return frameSink2;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    public final void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        if (!this.writerClosed) {
            int i2 = 0;
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= NotificationCompat.FLAG_HIGH_PRIORITY;
            }
            this.sinkBuffer.O0000Oo(i);
            if (this.isClient) {
                i2 = NotificationCompat.FLAG_HIGH_PRIORITY;
            }
            if (j <= 125) {
                this.sinkBuffer.O0000Oo(((int) j) | i2);
            } else if (j <= 65535) {
                this.sinkBuffer.O0000Oo(i2 | 126);
                this.sinkBuffer.O0000Oo0((int) j);
            } else {
                this.sinkBuffer.O0000Oo(i2 | 127);
                this.sinkBuffer.O0000Oo(j);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.O00000o0(this.maskKey);
                if (j > 0) {
                    long j2 = this.sinkBuffer.O00000Oo;
                    this.sinkBuffer.write(this.buffer, j);
                    this.sinkBuffer.O000000o(this.maskCursor);
                    this.maskCursor.O000000o(j2);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.write(this.buffer, j);
            }
            this.sink.O00000o0();
            return;
        }
        throw new IOException("closed");
    }

    final class FrameSink implements jbm {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public final void write(jax jax, long j) throws IOException {
            if (!this.closed) {
                WebSocketWriter.this.buffer.write(jax, j);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.O00000Oo > this.contentLength - 8192;
                long O00000oo = WebSocketWriter.this.buffer.O00000oo();
                if (O00000oo > 0 && !z) {
                    WebSocketWriter.this.writeMessageFrame(this.formatOpcode, O00000oo, this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public final void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.O00000Oo, this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public final jbo timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public final void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.O00000Oo, this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.activeWriter = false;
                return;
            }
            throw new IOException("closed");
        }
    }
}
