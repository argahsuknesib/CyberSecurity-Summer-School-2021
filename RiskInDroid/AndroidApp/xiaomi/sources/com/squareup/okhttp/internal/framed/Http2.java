package com.squareup.okhttp.internal.framed;

import _m_j.jax;
import _m_j.jay;
import _m_j.jaz;
import _m_j.jbn;
import _m_j.jbo;
import com.google.android.exoplayer2.C;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.framed.FrameReader;
import com.squareup.okhttp.internal.framed.Hpack;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;

public final class Http2 implements Variant {
    public static final ByteString CONNECTION_PREFACE = ByteString.O000000o("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final Logger logger = Logger.getLogger(FrameLogger.class.getName());

    public final Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public final FrameReader newReader(jaz jaz, boolean z) {
        return new Reader(jaz, 4096, z);
    }

    public final FrameWriter newWriter(jay jay, boolean z) {
        return new Writer(jay, z);
    }

    static final class Reader implements FrameReader {
        private final boolean client;
        private final ContinuationSource continuation = new ContinuationSource(this.source);
        final Hpack.Reader hpackReader;
        private final jaz source;

        Reader(jaz jaz, int i, boolean z) {
            this.source = jaz;
            this.client = z;
            this.hpackReader = new Hpack.Reader(i, this.continuation);
        }

        public final void readConnectionPreface() throws IOException {
            if (!this.client) {
                ByteString O00000o = this.source.O00000o((long) Http2.CONNECTION_PREFACE.O0000OOo());
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(String.format("<< CONNECTION %s", O00000o.O00000oo()));
                }
                if (!Http2.CONNECTION_PREFACE.equals(O00000o)) {
                    throw Http2.ioException("Expected a connection header but was %s", O00000o.O000000o());
                }
            }
        }

        public final boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                this.source.O000000o(9);
                int readMedium = Http2.readMedium(this.source);
                if (readMedium < 0 || readMedium > 16384) {
                    throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
                }
                byte O0000O0o = (byte) (this.source.O0000O0o() & 255);
                byte O0000O0o2 = (byte) (this.source.O0000O0o() & 255);
                int O0000Oo0 = this.source.O0000Oo0() & Integer.MAX_VALUE;
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(FrameLogger.formatHeader(true, O0000Oo0, readMedium, O0000O0o, O0000O0o2));
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
            } catch (IOException unused) {
                return false;
            }
        }

        private void readHeaders(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
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
                handler.headers(false, z, i2, -1, readHeaderBlock(Http2.lengthWithoutPadding(i, b, s), s, b, i2), HeadersMode.HTTP_20_HEADERS);
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

        private void readData(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            boolean z = true;
            short s = 0;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.source.O0000O0o() & 255);
                }
                handler.data(z2, i2, this.source, Http2.lengthWithoutPadding(i, b, s));
                this.source.O0000Oo0((long) s);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }

        private void readPriority(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            if (i != 5) {
                throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            } else if (i2 != 0) {
                readPriority(handler, i2);
            } else {
                throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
        }

        private void readPriority(FrameReader.Handler handler, int i) throws IOException {
            int O0000Oo0 = this.source.O0000Oo0();
            handler.priority(i, O0000Oo0 & Integer.MAX_VALUE, (this.source.O0000O0o() & 255) + 1, (Integer.MIN_VALUE & O0000Oo0) != 0);
        }

        private void readRstStream(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
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

        private void readSettings(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
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
                    short O0000OOo = this.source.O0000OOo();
                    int O0000Oo0 = this.source.O0000Oo0();
                    switch (O0000OOo) {
                        case 1:
                        case 6:
                            break;
                        case 2:
                            if (!(O0000Oo0 == 0 || O0000Oo0 == 1)) {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case 3:
                            O0000OOo = 4;
                            break;
                        case 4:
                            O0000OOo = 7;
                            if (O0000Oo0 >= 0) {
                                break;
                            } else {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        case 5:
                            if (O0000Oo0 >= 16384 && O0000Oo0 <= 16777215) {
                                break;
                            } else {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(O0000Oo0));
                            }
                            break;
                        default:
                            throw Http2.ioException("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(O0000OOo));
                    }
                    settings.set(O0000OOo, 0, O0000Oo0);
                }
                handler.settings(false, settings);
                if (settings.getHeaderTableSize() >= 0) {
                    this.hpackReader.headerTableSizeSetting(settings.getHeaderTableSize());
                }
            } else {
                throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            }
        }

        private void readPushPromise(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
            short s = 0;
            if (i2 != 0) {
                if ((b & 8) != 0) {
                    s = (short) (this.source.O0000O0o() & 255);
                }
                handler.pushPromise(i2, this.source.O0000Oo0() & Integer.MAX_VALUE, readHeaderBlock(Http2.lengthWithoutPadding(i - 4, b, s), s, b, i2));
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }

        private void readPing(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
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

        private void readGoAway(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
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

        private void readWindowUpdate(FrameReader.Handler handler, int i, byte b, int i2) throws IOException {
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
    }

    static final class Writer implements FrameWriter {
        private final boolean client;
        private boolean closed;
        private final jax hpackBuffer = new jax();
        private final Hpack.Writer hpackWriter = new Hpack.Writer(this.hpackBuffer);
        private int maxFrameSize = 16384;
        private final jay sink;

        Writer(jay jay, boolean z) {
            this.sink = jay;
            this.client = z;
        }

        public final synchronized void flush() throws IOException {
            if (!this.closed) {
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void ackSettings(Settings settings) throws IOException {
            if (!this.closed) {
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                frameHeader(0, 0, (byte) 4, (byte) 1);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void connectionPreface() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (this.client) {
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(String.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.O00000oo()));
                }
                this.sink.O00000o0(Http2.CONNECTION_PREFACE.O0000Oo0());
                this.sink.flush();
            }
        }

        public final synchronized void synStream(boolean z, boolean z2, int i, int i2, List<Header> list) throws IOException {
            if (!z2) {
                try {
                    if (!this.closed) {
                        headers(z, i, list);
                    } else {
                        throw new IOException("closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new UnsupportedOperationException();
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

        private void writeContinuationFrames(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min((long) this.maxFrameSize, j);
                long j2 = (long) min;
                j -= j2;
                frameHeader(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
                this.sink.write(this.hpackBuffer, j2);
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

        public final synchronized void close() throws IOException {
            this.closed = true;
            this.sink.close();
        }

        /* access modifiers changed from: package-private */
        public final void frameHeader(int i, int i2, byte b, byte b2) throws IOException {
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(false, i, i2, b, b2));
            }
            int i3 = this.maxFrameSize;
            if (i2 > i3) {
                throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            } else if ((Integer.MIN_VALUE & i) == 0) {
                Http2.writeMedium(this.sink, i2);
                this.sink.O0000Oo(b & 255);
                this.sink.O0000Oo(b2 & 255);
                this.sink.O0000OOo(i & Integer.MAX_VALUE);
            } else {
                throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i));
            }
        }
    }

    public static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
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

        public ContinuationSource(jaz jaz) {
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
            int readMedium = Http2.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte O0000O0o = (byte) (this.source.O0000O0o() & 255);
            this.flags = (byte) (this.source.O0000O0o() & 255);
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(true, this.streamId, this.length, O0000O0o, this.flags));
            }
            this.streamId = this.source.O0000Oo0() & Integer.MAX_VALUE;
            if (O0000O0o != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(O0000O0o));
            } else if (this.streamId != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    public static int lengthWithoutPadding(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    static final class FrameLogger {
        private static final String[] BINARY = new String[256];
        private static final String[] FLAGS = new String[64];
        private static final String[] TYPES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        FrameLogger() {
        }

        static String formatHeader(boolean z, int i, int i2, byte b, byte b2) {
            String[] strArr = TYPES;
            String format = b < strArr.length ? strArr[b] : String.format("0x%02x", Byte.valueOf(b));
            String formatFlags = formatFlags(b, b2);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = format;
            objArr[4] = formatFlags;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }

        static String formatFlags(byte b, byte b2) {
            if (b2 == 0) {
                return "";
            }
            if (!(b == 2 || b == 3)) {
                if (b == 4 || b == 6) {
                    return b2 == 1 ? "ACK" : BINARY[b2];
                }
                if (!(b == 7 || b == 8)) {
                    String[] strArr = FLAGS;
                    String str = b2 < strArr.length ? strArr[b2] : BINARY[b2];
                    if (b == 5 && (b2 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b != 0 || (b2 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
                }
            }
            return BINARY[b2];
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
         arg types: [int, int]
         candidates:
          ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
          ClspMth{java.lang.String.replace(char, char):java.lang.String} */
        static {
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = BINARY;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr[i2] = String.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
                i2++;
            }
            String[] strArr2 = FLAGS;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i3 = 0; i3 <= 0; i3++) {
                int i4 = iArr[i3];
                FLAGS[i4 | 8] = FLAGS[i4] + "|PADDED";
            }
            String[] strArr3 = FLAGS;
            strArr3[4] = "END_HEADERS";
            strArr3[32] = "PRIORITY";
            strArr3[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = iArr2[i5];
                for (int i7 = 0; i7 <= 0; i7++) {
                    int i8 = iArr[i7];
                    String[] strArr4 = FLAGS;
                    int i9 = i8 | i6;
                    strArr4[i9] = FLAGS[i8] + '|' + FLAGS[i6];
                    FLAGS[i9 | 8] = FLAGS[i8] + '|' + FLAGS[i6] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr5 = FLAGS;
                if (i < strArr5.length) {
                    if (strArr5[i] == null) {
                        strArr5[i] = BINARY[i];
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static int readMedium(jaz jaz) throws IOException {
        return (jaz.O0000O0o() & 255) | ((jaz.O0000O0o() & 255) << 16) | ((jaz.O0000O0o() & 255) << 8);
    }

    public static void writeMedium(jay jay, int i) throws IOException {
        jay.O0000Oo((i >>> 16) & 255);
        jay.O0000Oo((i >>> 8) & 255);
        jay.O0000Oo(i & 255);
    }
}
