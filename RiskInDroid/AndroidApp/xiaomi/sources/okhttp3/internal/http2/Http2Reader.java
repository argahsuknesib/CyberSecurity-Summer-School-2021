package okhttp3.internal.http2;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbn;
import _m_j.jbo;
import com.google.android.exoplayer2.C;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.ByteString;

final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation = new ContinuationSource(this.source);
    final Hpack.Reader hpackReader = new Hpack.Reader(4096, this.continuation);
    private final jaz source;

    interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, jaz jaz, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    Http2Reader(jaz jaz, boolean z) {
        this.source = jaz;
        this.client = z;
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        if (!this.client) {
            ByteString O00000o = this.source.O00000o((long) Http2.CONNECTION_PREFACE.O0000OOo());
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", O00000o.O00000oo()));
            }
            if (!Http2.CONNECTION_PREFACE.equals(O00000o)) {
                throw Http2.ioException("Expected a connection header but was %s", O00000o.O000000o());
            }
        } else if (!nextFrame(true, handler)) {
            throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
        }
    }

    public final boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.O000000o(9);
            int readMedium = readMedium(this.source);
            if (readMedium < 0 || readMedium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
            }
            byte O0000O0o = (byte) (this.source.O0000O0o() & 255);
            if (!z || O0000O0o == 4) {
                byte O0000O0o2 = (byte) (this.source.O0000O0o() & 255);
                int O0000Oo0 = this.source.O0000Oo0() & Integer.MAX_VALUE;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.frameLog(true, O0000Oo0, readMedium, O0000O0o, O0000O0o2));
                }
                switch (O0000O0o) {
                    case 0:
                        readData(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    case 1:
                        readHeaders(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    case 2:
                        readPriority(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    case 3:
                        readRstStream(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    case 4:
                        readSettings(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    case 5:
                        readPushPromise(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    case 6:
                        readPing(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    case 7:
                        readGoAway(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        readWindowUpdate(handler, readMedium, O0000O0o2, O0000Oo0);
                        break;
                    default:
                        this.source.O0000Oo0((long) readMedium);
                        break;
                }
                return true;
            }
            throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(O0000O0o));
        } catch (IOException unused) {
            return false;
        }
    }

    private void readHeaders(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.source.O0000O0o() & 255);
            }
            if ((b & 32) != 0) {
                readPriority(handler, i2);
                i -= 5;
            }
            handler.headers(z, i2, -1, readHeaderBlock(lengthWithoutPadding(i, b, s), s, b, i2));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<Header> readHeaderBlock(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        continuationSource.padding = s;
        continuationSource.flags = b;
        continuationSource.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readData(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.source.O0000O0o() & 255);
                }
                handler.data(z2, i2, this.source, lengthWithoutPadding(i, b, s));
                this.source.O0000Oo0((long) s);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void readPriority(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            readPriority(handler, i2);
        } else {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void readPriority(Handler handler, int i) throws IOException {
        int O0000Oo0 = this.source.O0000Oo0();
        handler.priority(i, O0000Oo0 & Integer.MAX_VALUE, (this.source.O0000O0o() & 255) + 1, (Integer.MIN_VALUE & O0000Oo0) != 0);
    }

    private void readRstStream(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int O0000Oo0 = this.source.O0000Oo0();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(O0000Oo0);
            if (fromHttp2 != null) {
                handler.rstStream(i2, fromHttp2);
            } else {
                throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(O0000Oo0));
            }
        } else {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void readSettings(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i == 0) {
                handler.ackSettings();
                return;
            }
            throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i % 6 == 0) {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short O0000OOo = this.source.O0000OOo() & 65535;
                int O0000Oo0 = this.source.O0000Oo0();
                if (O0000OOo != 1) {
                    if (O0000OOo != 2) {
                        if (O0000OOo == 3) {
                            O0000OOo = 4;
                        } else if (O0000OOo == 4) {
                            O0000OOo = 7;
                            if (O0000Oo0 < 0) {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        } else if (O0000OOo == 5 && (O0000Oo0 < 16384 || O0000Oo0 > 16777215)) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(O0000Oo0));
                        }
                    } else if (!(O0000Oo0 == 0 || O0000Oo0 == 1)) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                }
                settings.set(O0000OOo, O0000Oo0);
            }
            handler.settings(false, settings);
        } else {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    private void readPushPromise(Handler handler, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.source.O0000O0o() & 255);
            }
            handler.pushPromise(i2, this.source.O0000Oo0() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i - 4, b, s), s, b, i2));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void readPing(Handler handler, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int O0000Oo0 = this.source.O0000Oo0();
            int O0000Oo02 = this.source.O0000Oo0();
            if ((b & 1) != 0) {
                z = true;
            }
            handler.ping(z, O0000Oo0, O0000Oo02);
        } else {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void readGoAway(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int O0000Oo0 = this.source.O0000Oo0();
            int O0000Oo02 = this.source.O0000Oo0();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(O0000Oo02);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.O00000Oo;
                if (i3 > 0) {
                    byteString = this.source.O00000o((long) i3);
                }
                handler.goAway(O0000Oo0, fromHttp2, byteString);
                return;
            }
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(O0000Oo02));
        } else {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private void readWindowUpdate(Handler handler, int i, byte b, int i2) throws IOException {
        if (i == 4) {
            long O0000Oo0 = ((long) this.source.O0000Oo0()) & 2147483647L;
            if (O0000Oo0 != 0) {
                handler.windowUpdate(i2, O0000Oo0);
            } else {
                throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(O0000Oo0));
            }
        } else {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public final void close() throws IOException {
        this.source.close();
    }

    static final class ContinuationSource implements jbn {
        byte flags;
        int left;
        int length;
        short padding;
        private final jaz source;
        int streamId;

        public final void close() throws IOException {
        }

        ContinuationSource(jaz jaz) {
            this.source = jaz;
        }

        public final long read(jax jax, long j) throws IOException {
            while (true) {
                int i = this.left;
                if (i == 0) {
                    this.source.O0000Oo0((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(jax, Math.min(j, (long) i));
                    if (read == -1) {
                        return -1;
                    }
                    this.left = (int) (((long) this.left) - read);
                    return read;
                }
            }
        }

        public final jbo timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int readMedium = Http2Reader.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte O0000O0o = (byte) (this.source.O0000O0o() & 255);
            this.flags = (byte) (this.source.O0000O0o() & 255);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, O0000O0o, this.flags));
            }
            this.streamId = this.source.O0000Oo0() & Integer.MAX_VALUE;
            if (O0000O0o != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(O0000O0o));
            } else if (this.streamId != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int readMedium(jaz jaz) throws IOException {
        return (jaz.O0000O0o() & 255) | ((jaz.O0000O0o() & 255) << 16) | ((jaz.O0000O0o() & 255) << 8);
    }

    static int lengthWithoutPadding(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
