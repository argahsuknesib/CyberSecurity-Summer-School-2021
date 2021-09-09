package com.xiaomi.push;

import _m_j.esb;
import _m_j.esc;
import _m_j.esd;
import _m_j.esf;
import _m_j.esk;
import com.xiaomi.push.jh;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class jr extends jh {
    private static int O00000oo = 10000;
    private static int O0000O0o = 10000;
    private static int O0000OOo = 10000;
    private static int O0000Oo = 104857600;
    private static int O0000Oo0 = 10485760;

    public static class a extends jh.a {
        public a() {
            super((byte) 0);
        }

        public a(int i) {
            super(true, true, i);
        }

        public final esd O000000o(esk esk) {
            jr jrVar = new jr(esk, this.f180a, this.b);
            if (this.f6452a != 0) {
                jrVar.O00000o0(this.f6452a);
            }
            return jrVar;
        }
    }

    public jr(esk esk, boolean z, boolean z2) {
        super(esk, z, z2);
    }

    public final esb O00000o() {
        byte O0000O0o2 = O0000O0o();
        int O0000Oo02 = O0000Oo0();
        if (O0000Oo02 <= O0000O0o) {
            return new esb(O0000O0o2, O0000Oo02);
        }
        throw new jm(3, "Thrift list size " + O0000Oo02 + " out of range!");
    }

    public final esc O00000o0() {
        byte O0000O0o2 = O0000O0o();
        byte O0000O0o3 = O0000O0o();
        int O0000Oo02 = O0000Oo0();
        if (O0000Oo02 <= O00000oo) {
            return new esc(O0000O0o2, O0000O0o3, O0000Oo02);
        }
        throw new jm(3, "Thrift map size " + O0000Oo02 + " out of range!");
    }

    public final esf O00000oO() {
        byte O0000O0o2 = O0000O0o();
        int O0000Oo02 = O0000Oo0();
        if (O0000Oo02 <= O0000OOo) {
            return new esf(O0000O0o2, O0000Oo02);
        }
        throw new jm(3, "Thrift set size " + O0000Oo02 + " out of range!");
    }

    public final String O0000Ooo() {
        int O0000Oo02 = O0000Oo0();
        if (O0000Oo02 > O0000Oo0) {
            throw new jm(3, "Thrift string size " + O0000Oo02 + " out of range!");
        } else if (this.O00000oO.O00000o0() < O0000Oo02) {
            return O00000Oo(O0000Oo02);
        } else {
            try {
                String str = new String(this.O00000oO.O000000o(), this.O00000oO.O00000Oo(), O0000Oo02, "UTF-8");
                this.O00000oO.O000000o(O0000Oo02);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new jf("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    public final ByteBuffer O0000o00() {
        int O0000Oo02 = O0000Oo0();
        if (O0000Oo02 <= O0000Oo) {
            O00000o(O0000Oo02);
            if (this.O00000oO.O00000o0() >= O0000Oo02) {
                ByteBuffer wrap = ByteBuffer.wrap(this.O00000oO.O000000o(), this.O00000oO.O00000Oo(), O0000Oo02);
                this.O00000oO.O000000o(O0000Oo02);
                return wrap;
            }
            byte[] bArr = new byte[O0000Oo02];
            this.O00000oO.O00000o0(bArr, 0, O0000Oo02);
            return ByteBuffer.wrap(bArr);
        }
        throw new jm(3, "Thrift binary size " + O0000Oo02 + " out of range!");
    }
}
