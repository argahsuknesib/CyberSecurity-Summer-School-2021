package okhttp3.internal.http2;

import _m_j.jax;
import _m_j.jay;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final jax hpackBuffer = new jax();
    final Hpack.Writer hpackWriter = new Hpack.Writer(this.hpackBuffer);
    private int maxFrameSize = 16384;
    private final jay sink;

    Http2Writer(jay jay, boolean z) {
        this.sink = jay;
        this.client = z;
    }

    public final synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (this.client) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.O00000oo()));
            }
            this.sink.O00000o0(Http2.CONNECTION_PREFACE.O0000Oo0());
            this.sink.flush();
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void pushPromise(int i, int i2, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long j = this.hpackBuffer.O00000Oo;
            int min = (int) Math.min((long) (this.maxFrameSize - 4), j);
            long j2 = (long) min;
            frameHeader(i, min + 4, (byte) 5, j == j2 ? (byte) 4 : 0);
            this.sink.O0000OOo(i2 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j2);
            if (j > j2) {
                writeContinuationFrames(i, j - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void synStream(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void headers(int i, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(false, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(i, 4, (byte) 3, (byte) 0);
            this.sink.O0000OOo(errorCode.httpCode);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void data(boolean z, int i, jax jax, int i2) throws IOException {
        if (!this.closed) {
            dataFrame(i, z ? (byte) 1 : 0, jax, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public final void dataFrame(int i, byte b, jax jax, int i2) throws IOException {
        frameHeader(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.sink.write(jax, (long) i2);
        }
    }

    public final synchronized void settings(Settings settings) throws IOException {
        if (!this.closed) {
            int i = 0;
            frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.isSet(i)) {
                    this.sink.O0000Oo0(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.sink.O0000OOo(settings.get(i));
                }
                i++;
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void ping(boolean z, int i, int i2) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.sink.O0000OOo(i);
            this.sink.O0000OOo(i2);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.sink.O0000OOo(i);
            this.sink.O0000OOo(errorCode.httpCode);
            if (bArr.length > 0) {
                this.sink.O00000o0(bArr);
            }
            this.sink.flush();
        } else {
            throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
        }
    }

    public final synchronized void windowUpdate(int i, long j) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            frameHeader(i, 4, (byte) 8, (byte) 0);
            this.sink.O0000OOo((int) j);
            this.sink.flush();
        }
    }

    public final void frameHeader(int i, int i2, byte b, byte b2) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, i, i2, b, b2));
        }
        int i3 = this.maxFrameSize;
        if (i2 > i3) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            writeMedium(this.sink, i2);
            this.sink.O0000Oo(b & 255);
            this.sink.O0000Oo(b2 & 255);
            this.sink.O0000OOo(i & Integer.MAX_VALUE);
        } else {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public final synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    private static void writeMedium(jay jay, int i) throws IOException {
        jay.O0000Oo((i >>> 16) & 255);
        jay.O0000Oo((i >>> 8) & 255);
        jay.O0000Oo(i & 255);
    }

    private void writeContinuationFrames(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.maxFrameSize, j);
            long j2 = (long) min;
            j -= j2;
            frameHeader(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.sink.write(this.hpackBuffer, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void headers(boolean z, int i, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long j = this.hpackBuffer.O00000Oo;
            int min = (int) Math.min((long) this.maxFrameSize, j);
            long j2 = (long) min;
            byte b = j == j2 ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            frameHeader(i, min, (byte) 1, b);
            this.sink.write(this.hpackBuffer, j2);
            if (j > j2) {
                writeContinuationFrames(i, j - j2);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
