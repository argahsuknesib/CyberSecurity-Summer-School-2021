package okhttp3.internal.ws;

import _m_j.jax;
import _m_j.jaz;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

final class WebSocketReader {
    boolean closed;
    private final jax controlFrameBuffer = new jax();
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final jax.O000000o maskCursor;
    private final byte[] maskKey;
    private final jax messageFrameBuffer = new jax();
    int opcode;
    final jaz source;

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, jaz jaz, FrameCallback frameCallback2) {
        byte[] bArr;
        if (jaz == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback2 != null) {
            this.isClient = z;
            this.source = jaz;
            this.frameCallback = frameCallback2;
            jax.O000000o o000000o = null;
            if (z) {
                bArr = null;
            } else {
                bArr = new byte[4];
            }
            this.maskKey = bArr;
            this.maskCursor = !z ? new jax.O000000o() : o000000o;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    /* JADX INFO: finally extract failed */
    private void readHeader() throws IOException {
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                byte O0000O0o = this.source.O0000O0o() & 255;
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.opcode = O0000O0o & 15;
                boolean z = true;
                this.isFinalFrame = (O0000O0o & 128) != 0;
                this.isControlFrame = (O0000O0o & 8) != 0;
                if (!this.isControlFrame || this.isFinalFrame) {
                    boolean z2 = (O0000O0o & 64) != 0;
                    boolean z3 = (O0000O0o & 32) != 0;
                    boolean z4 = (O0000O0o & 16) != 0;
                    if (z2 || z3 || z4) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte O0000O0o2 = this.source.O0000O0o() & 255;
                    if ((O0000O0o2 & 128) == 0) {
                        z = false;
                    }
                    boolean z5 = this.isClient;
                    if (z == z5) {
                        throw new ProtocolException(z5 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    this.frameLength = (long) (O0000O0o2 & Byte.MAX_VALUE);
                    long j = this.frameLength;
                    if (j == 126) {
                        this.frameLength = ((long) this.source.O0000OOo()) & 65535;
                    } else if (j == 127) {
                        this.frameLength = this.source.O0000Oo();
                        if (this.frameLength < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.source.O000000o(this.maskKey);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void readControlFrame() throws IOException {
        String str;
        long j = this.frameLength;
        if (j > 0) {
            this.source.O000000o(this.controlFrameBuffer, j);
            if (!this.isClient) {
                this.controlFrameBuffer.O000000o(this.maskCursor);
                this.maskCursor.O000000o(0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                short s = 1005;
                long j2 = this.controlFrameBuffer.O00000Oo;
                if (j2 != 1) {
                    if (j2 != 0) {
                        s = this.controlFrameBuffer.O0000OOo();
                        str = this.controlFrameBuffer.O0000o();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.frameCallback.onReadClose(s, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.O0000o0o());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.O0000o0o());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    private void readMessageFrame() throws IOException {
        int i = this.opcode;
        if (i == 1 || i == 2) {
            readMessage();
            if (i == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.O0000o());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.O0000o0o());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.O000000o(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    this.messageFrameBuffer.O000000o(this.maskCursor);
                    this.maskCursor.O000000o(this.messageFrameBuffer.O00000Oo - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }
}
