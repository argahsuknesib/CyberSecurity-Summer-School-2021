package _m_j;

import _m_j.jqs;
import com.google.android.exoplayer2.C;
import gK.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import ss.ss.ss.a;
import ss.ss.ss.g;

public final class jre implements jrf {

    /* renamed from: O000000o  reason: collision with root package name */
    static final byte[] f2088O000000o;

    static {
        try {
            f2088O000000o = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(jqp.O00000o0.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    public final jqs O000000o(iqn iqn, boolean z) {
        return new O000000o(iqn, z);
    }

    public final jqt O000000o(iqm iqm, boolean z) {
        return new O00000Oo(iqm, z);
    }

    static final class O00000Oo implements jqt {

        /* renamed from: O000000o  reason: collision with root package name */
        private final iqm f2090O000000o;
        private final iql O00000Oo = new iql();
        private final boolean O00000o;
        private final iqm O00000o0;
        private boolean O00000oO;

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.iqo.<init>(_m_j.iqy, java.util.zip.Deflater):void
         arg types: [_m_j.iql, java.util.zip.Deflater]
         candidates:
          _m_j.iqo.<init>(_m_j.iqm, java.util.zip.Deflater):void
          _m_j.iqo.<init>(_m_j.iqy, java.util.zip.Deflater):void */
        O00000Oo(iqm iqm, boolean z) {
            this.f2090O000000o = iqm;
            this.O00000o = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(jre.f2088O000000o);
            this.O00000o0 = iqt.O000000o(new iqo((iqy) this.O00000Oo, deflater));
        }

        public final synchronized void O000000o() {
        }

        public final synchronized void O000000o(int i, long j) throws IOException {
            if (this.O00000oO) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: ".concat(String.valueOf(j)));
            } else {
                this.f2090O000000o.O00000oo(-2147287031);
                this.f2090O000000o.O00000oo(8);
                this.f2090O000000o.O00000oo(i);
                this.f2090O000000o.O00000oo((int) j);
                this.f2090O000000o.flush();
            }
        }

        public final synchronized void O000000o(int i, a aVar) throws IOException {
            if (this.O00000oO) {
                throw new IOException("closed");
            } else if (aVar.t != -1) {
                this.f2090O000000o.O00000oo(-2147287037);
                this.f2090O000000o.O00000oo(8);
                this.f2090O000000o.O00000oo(i & Integer.MAX_VALUE);
                this.f2090O000000o.O00000oo(aVar.t);
                this.f2090O000000o.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final synchronized void O000000o(int i, a aVar, byte[] bArr) throws IOException {
            if (this.O00000oO) {
                throw new IOException("closed");
            } else if (aVar.u != -1) {
                this.f2090O000000o.O00000oo(-2147287033);
                this.f2090O000000o.O00000oo(8);
                this.f2090O000000o.O00000oo(i);
                this.f2090O000000o.O00000oo(aVar.u);
                this.f2090O000000o.flush();
            } else {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
        }

        public final void O000000o(jrd jrd) {
        }

        public final synchronized void O000000o(boolean z, int i, int i2) throws IOException {
            if (!this.O00000oO) {
                boolean z2 = false;
                if (this.O00000o != ((i & 1) == 1)) {
                    z2 = true;
                }
                if (z == z2) {
                    this.f2090O000000o.O00000oo(-2147287034);
                    this.f2090O000000o.O00000oo(4);
                    this.f2090O000000o.O00000oo(i);
                    this.f2090O000000o.flush();
                } else {
                    throw new IllegalArgumentException("payload != reply");
                }
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void O00000Oo() throws IOException {
            if (!this.O00000oO) {
                this.f2090O000000o.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final int O00000o0() {
            return 16383;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void
         arg types: [_m_j.iqm, _m_j.iqm]
         candidates:
          _m_j.jqp.O000000o(ss.q, boolean):java.lang.String
          _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean
          _m_j.jqp.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.jqp.O000000o(java.lang.String[], java.lang.String):boolean
          _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void */
        public final synchronized void close() throws IOException {
            this.O00000oO = true;
            jqp.O000000o((Closeable) this.f2090O000000o, (Closeable) this.O00000o0);
        }

        public final synchronized void O000000o(boolean z, boolean z2, int i, int i2, List<jqw> list) throws IOException {
            if (!this.O00000oO) {
                O000000o(list);
                int i3 = (int) (this.O00000Oo.O00000Oo + 10);
                boolean z3 = z | (z2 ? (char) 2 : 0);
                this.f2090O000000o.O00000oo(-2147287039);
                this.f2090O000000o.O00000oo(((z3 & true ? 1 : 0) << true) | (i3 & 16777215));
                this.f2090O000000o.O00000oo(Integer.MAX_VALUE & i);
                this.f2090O000000o.O00000oo(0);
                this.f2090O000000o.O0000O0o(0);
                this.f2090O000000o.O000000o(this.O00000Oo);
                this.f2090O000000o.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void O000000o(boolean z, int i, iql iql, int i2) throws IOException {
            int i3 = z ? 1 : 0;
            if (!this.O00000oO) {
                long j = (long) i2;
                if (j <= 16777215) {
                    this.f2090O000000o.O00000oo(i & Integer.MAX_VALUE);
                    this.f2090O000000o.O00000oo(((i3 & 255) << 24) | (16777215 & i2));
                    if (i2 > 0) {
                        this.f2090O000000o.a_(iql, j);
                    }
                } else {
                    throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: ".concat(String.valueOf(i2)));
                }
            } else {
                throw new IOException("closed");
            }
        }

        private void O000000o(List<jqw> list) throws IOException {
            this.O00000o0.O00000oo(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                f fVar = list.get(i).O0000OOo;
                this.O00000o0.O00000oo(fVar.c.length);
                this.O00000o0.O00000Oo(fVar);
                f fVar2 = list.get(i).O0000Oo0;
                this.O00000o0.O00000oo(fVar2.c.length);
                this.O00000o0.O00000Oo(fVar2);
            }
            this.O00000o0.flush();
        }

        public final synchronized void O00000Oo(jrd jrd) throws IOException {
            if (!this.O00000oO) {
                int bitCount = Integer.bitCount(jrd.f2087O000000o);
                this.f2090O000000o.O00000oo(-2147287036);
                this.f2090O000000o.O00000oo((((bitCount * 8) + 4) & 16777215) | 0);
                this.f2090O000000o.O00000oo(bitCount);
                for (int i = 0; i <= 10; i++) {
                    if (jrd.O000000o(i)) {
                        this.f2090O000000o.O00000oo(((jrd.O00000Oo(i) & 255) << 24) | (i & 16777215));
                        this.f2090O000000o.O00000oo(jrd.O00000o[i]);
                    }
                }
                this.f2090O000000o.flush();
            } else {
                throw new IOException("closed");
            }
        }
    }

    static final class O000000o implements jqs {

        /* renamed from: O000000o  reason: collision with root package name */
        private final iqn f2089O000000o;
        private final boolean O00000Oo;
        private final jra O00000o0 = new jra(this.f2089O000000o);

        O000000o(iqn iqn, boolean z) {
            this.f2089O000000o = iqn;
            this.O00000Oo = z;
        }

        private static IOException O000000o(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        private void O000000o(jqs.O000000o o000000o, int i, int i2) throws IOException {
            int O0000OOo = this.f2089O000000o.O0000OOo();
            boolean z = false;
            if (i2 == (O0000OOo * 8) + 4) {
                jrd jrd = new jrd();
                for (int i3 = 0; i3 < O0000OOo; i3++) {
                    int O0000OOo2 = this.f2089O000000o.O0000OOo();
                    int i4 = (-16777216 & O0000OOo2) >>> 24;
                    jrd.O000000o(O0000OOo2 & 16777215, i4, this.f2089O000000o.O0000OOo());
                }
                if ((i & 1) != 0) {
                    z = true;
                }
                o000000o.O000000o(z, jrd);
                return;
            }
            throw O000000o("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(O0000OOo));
        }

        public final void O000000o() {
        }

        public final boolean O000000o(jqs.O000000o o000000o) throws IOException {
            boolean z = false;
            try {
                int O0000OOo = this.f2089O000000o.O0000OOo();
                int O0000OOo2 = this.f2089O000000o.O0000OOo();
                int i = (-16777216 & O0000OOo2) >>> 24;
                int i2 = O0000OOo2 & 16777215;
                if ((Integer.MIN_VALUE & O0000OOo) != 0) {
                    int i3 = (2147418112 & O0000OOo) >>> 16;
                    int i4 = O0000OOo & 65535;
                    if (i3 == 3) {
                        switch (i4) {
                            case 1:
                                int O0000OOo3 = this.f2089O000000o.O0000OOo();
                                this.f2089O000000o.O0000OOo();
                                int i5 = O0000OOo3 & Integer.MAX_VALUE;
                                this.f2089O000000o.O0000O0o();
                                o000000o.O000000o((i & 2) != 0, (i & 1) != 0, i5, this.O00000o0.O000000o(i2 - 10), g.SPDY_SYN_STREAM);
                                return true;
                            case 2:
                                o000000o.O000000o(false, (i & 1) != 0, this.f2089O000000o.O0000OOo() & Integer.MAX_VALUE, this.O00000o0.O000000o(i2 - 4), g.SPDY_REPLY);
                                return true;
                            case 3:
                                if (i2 == 8) {
                                    int O0000OOo4 = this.f2089O000000o.O0000OOo() & Integer.MAX_VALUE;
                                    int O0000OOo5 = this.f2089O000000o.O0000OOo();
                                    a a2 = a.a(O0000OOo5);
                                    if (a2 != null) {
                                        o000000o.O000000o(O0000OOo4, a2);
                                        return true;
                                    }
                                    throw O000000o("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(O0000OOo5));
                                }
                                throw O000000o("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
                            case 4:
                                O000000o(o000000o, i, i2);
                                return true;
                            case 5:
                            default:
                                this.f2089O000000o.O00000oo((long) i2);
                                return true;
                            case 6:
                                if (i2 == 4) {
                                    int O0000OOo6 = this.f2089O000000o.O0000OOo();
                                    o000000o.O000000o(this.O00000Oo == ((O0000OOo6 & 1) == 1), O0000OOo6, 0);
                                    return true;
                                }
                                throw O000000o("TYPE_PING length: %d != 4", Integer.valueOf(i2));
                            case 7:
                                if (i2 == 8) {
                                    int O0000OOo7 = this.f2089O000000o.O0000OOo() & Integer.MAX_VALUE;
                                    int O0000OOo8 = this.f2089O000000o.O0000OOo();
                                    if (a.c(O0000OOo8) != null) {
                                        f fVar = f.O00000Oo;
                                        o000000o.O000000o(O0000OOo7);
                                        return true;
                                    }
                                    throw O000000o("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(O0000OOo8));
                                }
                                throw O000000o("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                o000000o.O000000o(false, false, this.f2089O000000o.O0000OOo() & Integer.MAX_VALUE, this.O00000o0.O000000o(i2 - 4), g.SPDY_HEADERS);
                                return true;
                            case 9:
                                if (i2 == 8) {
                                    int O0000OOo9 = this.f2089O000000o.O0000OOo() & Integer.MAX_VALUE;
                                    long O0000OOo10 = (long) (this.f2089O000000o.O0000OOo() & Integer.MAX_VALUE);
                                    if (O0000OOo10 != 0) {
                                        o000000o.O000000o(O0000OOo9, O0000OOo10);
                                        return true;
                                    }
                                    throw O000000o("windowSizeIncrement was 0", Long.valueOf(O0000OOo10));
                                }
                                throw O000000o("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
                        }
                    } else {
                        throw new ProtocolException("version != 3: ".concat(String.valueOf(i3)));
                    }
                } else {
                    int i6 = O0000OOo & Integer.MAX_VALUE;
                    if ((i & 1) != 0) {
                        z = true;
                    }
                    o000000o.O000000o(z, i6, this.f2089O000000o, i2);
                    return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        public final void close() throws IOException {
            this.O00000o0.O00000Oo.close();
        }
    }
}
