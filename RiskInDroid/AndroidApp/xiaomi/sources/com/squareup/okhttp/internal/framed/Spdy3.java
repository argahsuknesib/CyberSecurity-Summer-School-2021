package com.squareup.okhttp.internal.framed;

import _m_j.jax;
import _m_j.jay;
import _m_j.jaz;
import _m_j.jba;
import _m_j.jbg;
import _m_j.jbm;
import com.google.android.exoplayer2.C;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okio.ByteString;

public final class Spdy3 implements Variant {
    static final byte[] DICTIONARY;

    public final Protocol getProtocol() {
        return Protocol.SPDY_3;
    }

    static {
        try {
            DICTIONARY = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    public final FrameReader newReader(jaz jaz, boolean z) {
        return new Reader(jaz, z);
    }

    public final FrameWriter newWriter(jay jay, boolean z) {
        return new Writer(jay, z);
    }

    static final class Reader implements FrameReader {
        private final boolean client;
        private final NameValueBlockReader headerBlockReader = new NameValueBlockReader(this.source);
        private final jaz source;

        public final void readConnectionPreface() {
        }

        Reader(jaz jaz, boolean z) {
            this.source = jaz;
            this.client = z;
        }

        public final boolean nextFrame(FrameReader.Handler handler) throws IOException {
            boolean z = false;
            try {
                int O0000Oo0 = this.source.O0000Oo0();
                int O0000Oo02 = this.source.O0000Oo0();
                int i = (-16777216 & O0000Oo02) >>> 24;
                int i2 = O0000Oo02 & 16777215;
                if ((Integer.MIN_VALUE & O0000Oo0) != 0) {
                    int i3 = (2147418112 & O0000Oo0) >>> 16;
                    int i4 = O0000Oo0 & 65535;
                    if (i3 == 3) {
                        switch (i4) {
                            case 1:
                                readSynStream(handler, i, i2);
                                return true;
                            case 2:
                                readSynReply(handler, i, i2);
                                return true;
                            case 3:
                                readRstStream(handler, i, i2);
                                return true;
                            case 4:
                                readSettings(handler, i, i2);
                                return true;
                            case 5:
                            default:
                                this.source.O0000Oo0((long) i2);
                                return true;
                            case 6:
                                readPing(handler, i, i2);
                                return true;
                            case 7:
                                readGoAway(handler, i, i2);
                                return true;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                readHeaders(handler, i, i2);
                                return true;
                            case 9:
                                readWindowUpdate(handler, i, i2);
                                return true;
                        }
                    } else {
                        throw new ProtocolException("version != 3: ".concat(String.valueOf(i3)));
                    }
                } else {
                    int i5 = O0000Oo0 & Integer.MAX_VALUE;
                    if ((i & 1) != 0) {
                        z = true;
                    }
                    handler.data(z, i5, this.source, i2);
                    return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        private void readSynStream(FrameReader.Handler handler, int i, int i2) throws IOException {
            int O0000Oo0 = this.source.O0000Oo0() & Integer.MAX_VALUE;
            int O0000Oo02 = this.source.O0000Oo0() & Integer.MAX_VALUE;
            this.source.O0000OOo();
            List<Header> readNameValueBlock = this.headerBlockReader.readNameValueBlock(i2 - 10);
            handler.headers((i & 2) != 0, (i & 1) != 0, O0000Oo0, O0000Oo02, readNameValueBlock, HeadersMode.SPDY_SYN_STREAM);
        }

        private void readSynReply(FrameReader.Handler handler, int i, int i2) throws IOException {
            handler.headers(false, (i & 1) != 0, this.source.O0000Oo0() & Integer.MAX_VALUE, -1, this.headerBlockReader.readNameValueBlock(i2 - 4), HeadersMode.SPDY_REPLY);
        }

        private void readRstStream(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 == 8) {
                int O0000Oo0 = this.source.O0000Oo0() & Integer.MAX_VALUE;
                int O0000Oo02 = this.source.O0000Oo0();
                ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(O0000Oo02);
                if (fromSpdy3Rst != null) {
                    handler.rstStream(O0000Oo0, fromSpdy3Rst);
                } else {
                    throw ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(O0000Oo02));
                }
            } else {
                throw ioException("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
        }

        private void readHeaders(FrameReader.Handler handler, int i, int i2) throws IOException {
            handler.headers(false, false, this.source.O0000Oo0() & Integer.MAX_VALUE, -1, this.headerBlockReader.readNameValueBlock(i2 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 == 8) {
                int O0000Oo0 = this.source.O0000Oo0() & Integer.MAX_VALUE;
                long O0000Oo02 = (long) (this.source.O0000Oo0() & Integer.MAX_VALUE);
                if (O0000Oo02 != 0) {
                    handler.windowUpdate(O0000Oo0, O0000Oo02);
                } else {
                    throw ioException("windowSizeIncrement was 0", Long.valueOf(O0000Oo02));
                }
            } else {
                throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
        }

        private void readPing(FrameReader.Handler handler, int i, int i2) throws IOException {
            boolean z = true;
            if (i2 == 4) {
                int O0000Oo0 = this.source.O0000Oo0();
                if (this.client != ((O0000Oo0 & 1) == 1)) {
                    z = false;
                }
                handler.ping(z, O0000Oo0, 0);
                return;
            }
            throw ioException("TYPE_PING length: %d != 4", Integer.valueOf(i2));
        }

        private void readGoAway(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 == 8) {
                int O0000Oo0 = this.source.O0000Oo0() & Integer.MAX_VALUE;
                int O0000Oo02 = this.source.O0000Oo0();
                ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(O0000Oo02);
                if (fromSpdyGoAway != null) {
                    handler.goAway(O0000Oo0, fromSpdyGoAway, ByteString.O00000Oo);
                } else {
                    throw ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(O0000Oo02));
                }
            } else {
                throw ioException("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
        }

        private void readSettings(FrameReader.Handler handler, int i, int i2) throws IOException {
            int O0000Oo0 = this.source.O0000Oo0();
            boolean z = false;
            if (i2 == (O0000Oo0 * 8) + 4) {
                Settings settings = new Settings();
                for (int i3 = 0; i3 < O0000Oo0; i3++) {
                    int O0000Oo02 = this.source.O0000Oo0();
                    int i4 = (-16777216 & O0000Oo02) >>> 24;
                    settings.set(O0000Oo02 & 16777215, i4, this.source.O0000Oo0());
                }
                if ((i & 1) != 0) {
                    z = true;
                }
                handler.settings(z, settings);
                return;
            }
            throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(O0000Oo0));
        }

        private static IOException ioException(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        public final void close() throws IOException {
            this.headerBlockReader.close();
        }
    }

    static final class Writer implements FrameWriter {
        private final boolean client;
        private boolean closed;
        private final jax headerBlockBuffer = new jax();
        private final jay headerBlockOut;
        private final jay sink;

        public final void ackSettings(Settings settings) {
        }

        public final int maxDataLength() {
            return 16383;
        }

        public final void pushPromise(int i, int i2, List<Header> list) throws IOException {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jba.<init>(_m_j.jbm, java.util.zip.Deflater):void
         arg types: [_m_j.jax, java.util.zip.Deflater]
         candidates:
          _m_j.jba.<init>(_m_j.jay, java.util.zip.Deflater):void
          _m_j.jba.<init>(_m_j.jbm, java.util.zip.Deflater):void */
        Writer(jay jay, boolean z) {
            this.sink = jay;
            this.client = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(Spdy3.DICTIONARY);
            this.headerBlockOut = jbg.O000000o(new jba((jbm) this.headerBlockBuffer, deflater));
        }

        public final synchronized void connectionPreface() {
        }

        public final synchronized void flush() throws IOException {
            if (!this.closed) {
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void synStream(boolean z, boolean z2, int i, int i2, List<Header> list) throws IOException {
            if (!this.closed) {
                writeNameValueBlockToBuffer(list);
                int i3 = (int) (this.headerBlockBuffer.O00000Oo + 10);
                boolean z3 = z | (z2 ? (char) 2 : 0);
                this.sink.O0000OOo(-2147287039);
                this.sink.O0000OOo(((z3 & true ? 1 : 0) << true) | (i3 & 16777215));
                this.sink.O0000OOo(i & Integer.MAX_VALUE);
                this.sink.O0000OOo(Integer.MAX_VALUE & i2);
                this.sink.O0000Oo0(0);
                this.sink.O000000o(this.headerBlockBuffer);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
            if (!this.closed) {
                writeNameValueBlockToBuffer(list);
                int i2 = z ? 1 : 0;
                int i3 = (int) (this.headerBlockBuffer.O00000Oo + 4);
                this.sink.O0000OOo(-2147287038);
                this.sink.O0000OOo(((i2 & 255) << 24) | (i3 & 16777215));
                this.sink.O0000OOo(i & Integer.MAX_VALUE);
                this.sink.O000000o(this.headerBlockBuffer);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void headers(int i, List<Header> list) throws IOException {
            if (!this.closed) {
                writeNameValueBlockToBuffer(list);
                int i2 = (int) (this.headerBlockBuffer.O00000Oo + 4);
                this.sink.O0000OOo(-2147287032);
                this.sink.O0000OOo((i2 & 16777215) | 0);
                this.sink.O0000OOo(i & Integer.MAX_VALUE);
                this.sink.O000000o(this.headerBlockBuffer);
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.spdyRstCode != -1) {
                this.sink.O0000OOo(-2147287037);
                this.sink.O0000OOo(8);
                this.sink.O0000OOo(i & Integer.MAX_VALUE);
                this.sink.O0000OOo(errorCode.spdyRstCode);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final synchronized void data(boolean z, int i, jax jax, int i2) throws IOException {
            sendDataFrame(i, z ? 1 : 0, jax, i2);
        }

        /* access modifiers changed from: package-private */
        public final void sendDataFrame(int i, int i2, jax jax, int i3) throws IOException {
            if (!this.closed) {
                long j = (long) i3;
                if (j <= 16777215) {
                    this.sink.O0000OOo(i & Integer.MAX_VALUE);
                    this.sink.O0000OOo(((i2 & 255) << 24) | (16777215 & i3));
                    if (i3 > 0) {
                        this.sink.write(jax, j);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: ".concat(String.valueOf(i3)));
            }
            throw new IOException("closed");
        }

        private void writeNameValueBlockToBuffer(List<Header> list) throws IOException {
            this.headerBlockOut.O0000OOo(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString byteString = list.get(i).name;
                this.headerBlockOut.O0000OOo(byteString.O0000OOo());
                this.headerBlockOut.O00000o0(byteString);
                ByteString byteString2 = list.get(i).value;
                this.headerBlockOut.O0000OOo(byteString2.O0000OOo());
                this.headerBlockOut.O00000o0(byteString2);
            }
            this.headerBlockOut.flush();
        }

        public final synchronized void settings(Settings settings) throws IOException {
            if (!this.closed) {
                int size = settings.size();
                this.sink.O0000OOo(-2147287036);
                this.sink.O0000OOo((((size * 8) + 4) & 16777215) | 0);
                this.sink.O0000OOo(size);
                for (int i = 0; i <= 10; i++) {
                    if (settings.isSet(i)) {
                        this.sink.O0000OOo(((settings.flags(i) & 255) << 24) | (i & 16777215));
                        this.sink.O0000OOo(settings.get(i));
                    }
                }
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void ping(boolean z, int i, int i2) throws IOException {
            if (!this.closed) {
                boolean z2 = false;
                if (this.client != ((i & 1) == 1)) {
                    z2 = true;
                }
                if (z == z2) {
                    this.sink.O0000OOo(-2147287034);
                    this.sink.O0000OOo(4);
                    this.sink.O0000OOo(i);
                    this.sink.flush();
                } else {
                    throw new IllegalArgumentException("payload != reply");
                }
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.spdyGoAwayCode != -1) {
                this.sink.O0000OOo(-2147287033);
                this.sink.O0000OOo(8);
                this.sink.O0000OOo(i);
                this.sink.O0000OOo(errorCode.spdyGoAwayCode);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
        }

        public final synchronized void windowUpdate(int i, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: ".concat(String.valueOf(j)));
            } else {
                this.sink.O0000OOo(-2147287031);
                this.sink.O0000OOo(8);
                this.sink.O0000OOo(i);
                this.sink.O0000OOo((int) j);
                this.sink.flush();
            }
        }

        public final synchronized void close() throws IOException {
            this.closed = true;
            Util.closeAll(this.sink, this.headerBlockOut);
        }
    }
}
