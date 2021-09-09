package _m_j;

import _m_j.jqs;
import _m_j.jqx;
import com.google.android.exoplayer2.C;
import gK.f;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ss.ss.ss.a;
import ss.ss.ss.g;

public final class jqy implements jrf {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Logger f2075O000000o = Logger.getLogger(O00000Oo.class.getName());
    /* access modifiers changed from: private */
    public static final f O00000Oo = f.O000000o("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* access modifiers changed from: private */
    public static IOException O00000o0(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    public final jqs O000000o(iqn iqn, boolean z) {
        return new O00000o0(iqn, z);
    }

    public final jqt O000000o(iqm iqm, boolean z) {
        return new O00000o(iqm, z);
    }

    static final class O000000o implements iqz {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2076O000000o;
        byte O00000Oo;
        int O00000o;
        int O00000o0;
        short O00000oO;
        private final iqn O00000oo;

        public O000000o(iqn iqn) {
            this.O00000oo = iqn;
        }

        public final ira O000000o() {
            return this.O00000oo.O000000o();
        }

        public final void close() throws IOException {
        }

        public final long O000000o(iql iql, long j) throws IOException {
            int i;
            do {
                int i2 = this.O00000o;
                if (i2 == 0) {
                    this.O00000oo.O00000oo((long) this.O00000oO);
                    this.O00000oO = 0;
                    if ((this.O00000Oo & 4) != 0) {
                        return -1;
                    }
                    i = this.O00000o0;
                    int O000000o2 = jqy.O000000o(this.O00000oo);
                    this.O00000o = O000000o2;
                    this.f2076O000000o = O000000o2;
                    byte O00000oo2 = (byte) (this.O00000oo.O00000oo() & 255);
                    this.O00000Oo = (byte) (this.O00000oo.O00000oo() & 255);
                    if (jqy.f2075O000000o.isLoggable(Level.FINE)) {
                        jqy.f2075O000000o.fine(O00000Oo.O000000o(true, this.O00000o0, this.f2076O000000o, O00000oo2, this.O00000Oo));
                    }
                    this.O00000o0 = this.O00000oo.O0000OOo() & Integer.MAX_VALUE;
                    if (O00000oo2 != 9) {
                        throw jqy.O00000o0("%s != TYPE_CONTINUATION", Byte.valueOf(O00000oo2));
                    }
                } else {
                    long O000000o3 = this.O00000oo.O000000o(iql, Math.min(j, (long) i2));
                    if (O000000o3 == -1) {
                        return -1;
                    }
                    this.O00000o = (int) (((long) this.O00000o) - O000000o3);
                    return O000000o3;
                }
            } while (this.O00000o0 == i);
            throw jqy.O00000o0("TYPE_CONTINUATION streamId changed", new Object[0]);
        }
    }

    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final String[] f2077O000000o = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        private static final String[] O00000Oo = new String[64];
        private static final String[] O00000o0 = new String[256];

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
                String[] strArr = O00000o0;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr[i2] = String.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
                i2++;
            }
            String[] strArr2 = O00000Oo;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i3 = 0; i3 <= 0; i3++) {
                int i4 = iArr[i3];
                O00000Oo[i4 | 8] = O00000Oo[i4] + "|PADDED";
            }
            String[] strArr3 = O00000Oo;
            strArr3[4] = "END_HEADERS";
            strArr3[32] = "PRIORITY";
            strArr3[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = iArr2[i5];
                for (int i7 = 0; i7 <= 0; i7++) {
                    int i8 = iArr[i7];
                    String[] strArr4 = O00000Oo;
                    int i9 = i8 | i6;
                    strArr4[i9] = O00000Oo[i8] + '|' + O00000Oo[i6];
                    O00000Oo[i9 | 8] = O00000Oo[i8] + '|' + O00000Oo[i6] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr5 = O00000Oo;
                if (i < strArr5.length) {
                    if (strArr5[i] == null) {
                        strArr5[i] = O00000o0[i];
                    }
                    i++;
                } else {
                    return;
                }
            }
        }

        O00000Oo() {
        }

        static String O000000o(boolean z, int i, int i2, byte b, byte b2) {
            String str;
            String str2;
            String str3;
            String[] strArr = f2077O000000o;
            String format = b < strArr.length ? strArr[b] : String.format("0x%02x", Byte.valueOf(b));
            if (b2 == 0) {
                str = "";
            } else {
                if (!(b == 2 || b == 3)) {
                    if (b == 4 || b == 6) {
                        str = b2 == 1 ? "ACK" : O00000o0[b2];
                    } else if (!(b == 7 || b == 8)) {
                        String[] strArr2 = O00000Oo;
                        String str4 = b2 < strArr2.length ? strArr2[b2] : O00000o0[b2];
                        if (b == 5 && (b2 & 4) != 0) {
                            str2 = "HEADERS";
                            str3 = "PUSH_PROMISE";
                        } else if (b != 0 || (b2 & 32) == 0) {
                            str = str4;
                        } else {
                            str2 = "PRIORITY";
                            str3 = "COMPRESSED";
                        }
                        str = str4.replace(str2, str3);
                    }
                }
                str = O00000o0[b2];
            }
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = format;
            objArr[4] = str;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    static final class O00000o implements jqt {

        /* renamed from: O000000o  reason: collision with root package name */
        private final iqm f2078O000000o;
        private final boolean O00000Oo;
        private final jqx.O00000Oo O00000o = new jqx.O00000Oo(this.O00000o0);
        private final iql O00000o0 = new iql();
        private int O00000oO = 16384;
        private boolean O00000oo;

        O00000o(iqm iqm, boolean z) {
            this.f2078O000000o = iqm;
            this.O00000Oo = z;
        }

        private void O000000o(int i, int i2, byte b, byte b2) throws IOException {
            if (jqy.f2075O000000o.isLoggable(Level.FINE)) {
                jqy.f2075O000000o.fine(O00000Oo.O000000o(false, i, i2, b, b2));
            }
            int i3 = this.O00000oO;
            if (i2 > i3) {
                throw jqy.O00000Oo("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
            } else if ((Integer.MIN_VALUE & i) == 0) {
                jqy.O000000o(this.f2078O000000o, i2);
                this.f2078O000000o.O0000OOo(b & 255);
                this.f2078O000000o.O0000OOo(b2 & 255);
                this.f2078O000000o.O00000oo(i & Integer.MAX_VALUE);
            } else {
                throw jqy.O00000Oo("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
            }
        }

        private void O00000Oo(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min((long) this.O00000oO, j);
                long j2 = (long) min;
                j -= j2;
                O000000o(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
                this.f2078O000000o.a_(this.O00000o0, j2);
            }
        }

        public final synchronized void O000000o() throws IOException {
            if (this.O00000oo) {
                throw new IOException("closed");
            } else if (this.O00000Oo) {
                if (jqy.f2075O000000o.isLoggable(Level.FINE)) {
                    jqy.f2075O000000o.fine(String.format(">> CONNECTION %s", jqy.O00000Oo.O00000Oo()));
                }
                this.f2078O000000o.O00000Oo(jqy.O00000Oo.O00000o());
                this.f2078O000000o.flush();
            }
        }

        public final synchronized void O000000o(int i, long j) throws IOException {
            if (this.O00000oo) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw jqy.O00000Oo("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(j)});
            } else {
                O000000o(i, 4, (byte) 8, (byte) 0);
                this.f2078O000000o.O00000oo((int) j);
                this.f2078O000000o.flush();
            }
        }

        public final synchronized void O000000o(int i, a aVar) throws IOException {
            if (this.O00000oo) {
                throw new IOException("closed");
            } else if (aVar.s != -1) {
                O000000o(i, 4, (byte) 3, (byte) 0);
                this.f2078O000000o.O00000oo(aVar.s);
                this.f2078O000000o.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final synchronized void O000000o(int i, a aVar, byte[] bArr) throws IOException {
            if (this.O00000oo) {
                throw new IOException("closed");
            } else if (aVar.s != -1) {
                O000000o(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f2078O000000o.O00000oo(i);
                this.f2078O000000o.O00000oo(aVar.s);
                if (bArr.length > 0) {
                    this.f2078O000000o.O00000Oo(bArr);
                }
                this.f2078O000000o.flush();
            } else {
                throw jqy.O00000Oo("errorCode.httpCode == -1", new Object[0]);
            }
        }

        public final synchronized void O000000o(boolean z, int i, int i2) throws IOException {
            if (!this.O00000oo) {
                O000000o(0, 8, (byte) 6, z ? (byte) 1 : 0);
                this.f2078O000000o.O00000oo(i);
                this.f2078O000000o.O00000oo(i2);
                this.f2078O000000o.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void O00000Oo() throws IOException {
            if (!this.O00000oo) {
                this.f2078O000000o.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final int O00000o0() {
            return this.O00000oO;
        }

        public final synchronized void close() throws IOException {
            this.O00000oo = true;
            this.f2078O000000o.close();
        }

        public final synchronized void O000000o(jrd jrd) throws IOException {
            if (!this.O00000oo) {
                int i = this.O00000oO;
                if ((jrd.f2087O000000o & 32) != 0) {
                    i = jrd.O00000o[5];
                }
                this.O00000oO = i;
                O000000o(0, 0, (byte) 4, (byte) 1);
                this.f2078O000000o.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void O000000o(boolean z, boolean z2, int i, int i2, List<jqw> list) throws IOException {
            if (!z2) {
                try {
                    if (this.O00000oo) {
                        throw new IOException("closed");
                    } else if (!this.O00000oo) {
                        this.O00000o.O000000o(list);
                        long j = this.O00000o0.O00000Oo;
                        int min = (int) Math.min((long) this.O00000oO, j);
                        long j2 = (long) min;
                        byte b = j == j2 ? (byte) 4 : 0;
                        if (z) {
                            b = (byte) (b | 1);
                        }
                        O000000o(i, min, (byte) 1, b);
                        this.f2078O000000o.a_(this.O00000o0, j2);
                        if (j > j2) {
                            O00000Oo(i, j - j2);
                        }
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

        public final synchronized void O000000o(boolean z, int i, iql iql, int i2) throws IOException {
            if (!this.O00000oo) {
                O000000o(i, i2, (byte) 0, z ? (byte) 1 : 0);
                if (i2 > 0) {
                    this.f2078O000000o.a_(iql, (long) i2);
                }
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void O00000Oo(jrd jrd) throws IOException {
            if (!this.O00000oo) {
                int i = 0;
                O000000o(0, Integer.bitCount(jrd.f2087O000000o) * 6, (byte) 4, (byte) 0);
                while (i < 10) {
                    if (jrd.O000000o(i)) {
                        this.f2078O000000o.O0000O0o(i == 4 ? 3 : i == 7 ? 4 : i);
                        this.f2078O000000o.O00000oo(jrd.O00000o[i]);
                    }
                    i++;
                }
                this.f2078O000000o.flush();
            } else {
                throw new IOException("closed");
            }
        }
    }

    static final class O00000o0 implements jqs {

        /* renamed from: O000000o  reason: collision with root package name */
        final jqx.O000000o f2079O000000o = new jqx.O000000o(4096, this.O00000o0);
        private final iqn O00000Oo;
        private final boolean O00000o;
        private final O000000o O00000o0 = new O000000o(this.O00000Oo);

        O00000o0(iqn iqn, boolean z) {
            this.O00000Oo = iqn;
            this.O00000o = z;
        }

        private List<jqw> O000000o(int i, short s, byte b, int i2) throws IOException {
            O000000o o000000o = this.O00000o0;
            o000000o.O00000o = i;
            o000000o.f2076O000000o = i;
            o000000o.O00000oO = s;
            o000000o.O00000Oo = b;
            o000000o.O00000o0 = i2;
            this.f2079O000000o.O00000Oo();
            return this.f2079O000000o.O00000o0();
        }

        private void O00000Oo() throws IOException {
            this.O00000Oo.O0000OOo();
            this.O00000Oo.O00000oo();
        }

        public final void close() throws IOException {
            this.O00000Oo.close();
        }

        public final void O000000o() throws IOException {
            if (!this.O00000o) {
                f O00000o02 = this.O00000Oo.O00000o0((long) jqy.O00000Oo.c.length);
                if (jqy.f2075O000000o.isLoggable(Level.FINE)) {
                    jqy.f2075O000000o.fine(String.format("<< CONNECTION %s", O00000o02.O00000Oo()));
                }
                if (!jqy.O00000Oo.equals(O00000o02)) {
                    throw jqy.O00000o0("Expected a connection header but was %s", O00000o02.O000000o());
                }
            }
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: short} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: short} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: short} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: boolean} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jqs.O000000o.O000000o(boolean, _m_j.jrd):void
         arg types: [int, _m_j.jrd]
         candidates:
          _m_j.jqs.O000000o.O000000o(int, long):void
          _m_j.jqs.O000000o.O000000o(int, java.util.List<_m_j.jqw>):void
          _m_j.jqs.O000000o.O000000o(int, ss.ss.ss.a):void
          _m_j.jqs.O000000o.O000000o(boolean, _m_j.jrd):void */
        /* JADX WARNING: Multi-variable type inference failed */
        public final boolean O000000o(jqs.O000000o o000000o) throws IOException {
            boolean z = false;
            try {
                this.O00000Oo.O000000o(9);
                int O000000o2 = jqy.O000000o(this.O00000Oo);
                if (O000000o2 < 0 || O000000o2 > 16384) {
                    throw jqy.O00000o0("FRAME_SIZE_ERROR: %s", Integer.valueOf(O000000o2));
                }
                byte O00000oo = (byte) (this.O00000Oo.O00000oo() & 255);
                byte O00000oo2 = (byte) (this.O00000Oo.O00000oo() & 255);
                int O0000OOo = this.O00000Oo.O0000OOo() & Integer.MAX_VALUE;
                if (jqy.f2075O000000o.isLoggable(Level.FINE)) {
                    jqy.f2075O000000o.fine(O00000Oo.O000000o(true, O0000OOo, O000000o2, O00000oo, O00000oo2));
                }
                switch (O00000oo) {
                    case 0:
                        boolean z2 = (O00000oo2 & 1) != 0;
                        if (!((O00000oo2 & 32) != 0)) {
                            if ((O00000oo2 & 8) != 0) {
                                z = (short) (this.O00000Oo.O00000oo() & 255);
                            }
                            o000000o.O000000o(z2, O0000OOo, this.O00000Oo, jqy.O000000o(O000000o2, O00000oo2, z));
                            this.O00000Oo.O00000oo(z ? 1 : 0);
                            break;
                        } else {
                            throw jqy.O00000o0("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                        }
                    case 1:
                        if (O0000OOo != 0) {
                            boolean z3 = (O00000oo2 & 1) != 0;
                            if ((O00000oo2 & 8) != 0) {
                                z = (short) (this.O00000Oo.O00000oo() & 255);
                            }
                            if ((O00000oo2 & 32) != 0) {
                                O00000Oo();
                                O000000o2 -= 5;
                            }
                            o000000o.O000000o(false, z3, O0000OOo, O000000o(jqy.O000000o(O000000o2, O00000oo2, z), z, O00000oo2, O0000OOo), g.HTTP_20_HEADERS);
                            break;
                        } else {
                            throw jqy.O00000o0("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                        }
                    case 2:
                        if (O000000o2 != 5) {
                            throw jqy.O00000o0("TYPE_PRIORITY length: %d != 5", Integer.valueOf(O000000o2));
                        } else if (O0000OOo != 0) {
                            O00000Oo();
                            break;
                        } else {
                            throw jqy.O00000o0("TYPE_PRIORITY streamId == 0", new Object[0]);
                        }
                    case 3:
                        if (O000000o2 != 4) {
                            throw jqy.O00000o0("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(O000000o2));
                        } else if (O0000OOo != 0) {
                            int O0000OOo2 = this.O00000Oo.O0000OOo();
                            a b = a.b(O0000OOo2);
                            if (b != null) {
                                o000000o.O000000o(O0000OOo, b);
                                break;
                            } else {
                                throw jqy.O00000o0("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(O0000OOo2));
                            }
                        } else {
                            throw jqy.O00000o0("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        }
                    case 4:
                        if (O0000OOo != 0) {
                            throw jqy.O00000o0("TYPE_SETTINGS streamId != 0", new Object[0]);
                        } else if ((O00000oo2 & 1) != 0) {
                            if (O000000o2 != 0) {
                                throw jqy.O00000o0("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                            }
                        } else if (O000000o2 % 6 == 0) {
                            jrd jrd = new jrd();
                            for (int i = 0; i < O000000o2; i += 6) {
                                short O0000O0o = this.O00000Oo.O0000O0o();
                                int O0000OOo3 = this.O00000Oo.O0000OOo();
                                if (O0000O0o != 1) {
                                    if (O0000O0o != 2) {
                                        if (O0000O0o == 3) {
                                            O0000O0o = 4;
                                        } else if (O0000O0o == 4) {
                                            O0000O0o = 7;
                                            if (O0000OOo3 < 0) {
                                                throw jqy.O00000o0("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                            }
                                        } else if (O0000O0o == 5 && (O0000OOo3 < 16384 || O0000OOo3 > 16777215)) {
                                            throw jqy.O00000o0("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(O0000OOo3));
                                        }
                                    } else if (!(O0000OOo3 == 0 || O0000OOo3 == 1)) {
                                        throw jqy.O00000o0("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                    }
                                }
                                jrd.O000000o(O0000O0o, 0, O0000OOo3);
                            }
                            o000000o.O000000o(false, jrd);
                            if (jrd.O000000o() >= 0) {
                                jqx.O000000o o000000o2 = this.f2079O000000o;
                                int O000000o3 = jrd.O000000o();
                                o000000o2.f2073O000000o = O000000o3;
                                o000000o2.O00000Oo = O000000o3;
                                o000000o2.O000000o();
                                break;
                            }
                        } else {
                            throw jqy.O00000o0("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(O000000o2));
                        }
                        break;
                    case 5:
                        if (O0000OOo != 0) {
                            if ((O00000oo2 & 8) != 0) {
                                z = (short) (this.O00000Oo.O00000oo() & 255);
                            }
                            o000000o.O000000o(this.O00000Oo.O0000OOo() & Integer.MAX_VALUE, O000000o(jqy.O000000o(O000000o2 - 4, O00000oo2, z), z, O00000oo2, O0000OOo));
                            break;
                        } else {
                            throw jqy.O00000o0("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                        }
                    case 6:
                        if (O000000o2 != 8) {
                            throw jqy.O00000o0("TYPE_PING length != 8: %s", Integer.valueOf(O000000o2));
                        } else if (O0000OOo == 0) {
                            int O0000OOo4 = this.O00000Oo.O0000OOo();
                            int O0000OOo5 = this.O00000Oo.O0000OOo();
                            if ((O00000oo2 & 1) != 0) {
                                z = true;
                            }
                            o000000o.O000000o(z, O0000OOo4, O0000OOo5);
                            break;
                        } else {
                            throw jqy.O00000o0("TYPE_PING streamId != 0", new Object[0]);
                        }
                    case 7:
                        if (O000000o2 < 8) {
                            throw jqy.O00000o0("TYPE_GOAWAY length < 8: %s", Integer.valueOf(O000000o2));
                        } else if (O0000OOo == 0) {
                            int O0000OOo6 = this.O00000Oo.O0000OOo();
                            int O0000OOo7 = this.O00000Oo.O0000OOo();
                            int i2 = O000000o2 - 8;
                            if (a.b(O0000OOo7) != null) {
                                f fVar = f.O00000Oo;
                                if (i2 > 0) {
                                    this.O00000Oo.O00000o0((long) i2);
                                }
                                o000000o.O000000o(O0000OOo6);
                                break;
                            } else {
                                throw jqy.O00000o0("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(O0000OOo7));
                            }
                        } else {
                            throw jqy.O00000o0("TYPE_GOAWAY streamId != 0", new Object[0]);
                        }
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        if (O000000o2 == 4) {
                            long O0000OOo8 = ((long) this.O00000Oo.O0000OOo()) & 2147483647L;
                            if (O0000OOo8 != 0) {
                                o000000o.O000000o(O0000OOo, O0000OOo8);
                                break;
                            } else {
                                throw jqy.O00000o0("windowSizeIncrement was 0", Long.valueOf(O0000OOo8));
                            }
                        } else {
                            throw jqy.O00000o0("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(O000000o2));
                        }
                    default:
                        this.O00000Oo.O00000oo((long) O000000o2);
                        break;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    static /* synthetic */ int O000000o(iqn iqn) throws IOException {
        return (iqn.O00000oo() & 255) | ((iqn.O00000oo() & 255) << 16) | ((iqn.O00000oo() & 255) << 8);
    }

    static /* synthetic */ int O000000o(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw O00000o0("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    static /* synthetic */ IllegalArgumentException O00000Oo(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    static /* synthetic */ void O000000o(iqm iqm, int i) throws IOException {
        iqm.O0000OOo((i >>> 16) & 255);
        iqm.O0000OOo((i >>> 8) & 255);
        iqm.O0000OOo(i & 255);
    }
}
