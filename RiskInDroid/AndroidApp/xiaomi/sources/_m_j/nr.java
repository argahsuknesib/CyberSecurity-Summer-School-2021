package _m_j;

import android.support.v4.app.NotificationCompat;
import com.adobe.xmp.XMPException;

public final class nr extends np {
    public nr() {
    }

    public nr(int i) throws XMPException {
        super(i);
    }

    public final nr O000000o(boolean z) {
        O000000o(16, z);
        return this;
    }

    public final boolean O000000o() {
        return O000000o(32);
    }

    public final nr O00000Oo(boolean z) {
        O000000o(64, z);
        return this;
    }

    public final boolean O00000Oo() {
        return O000000o(64);
    }

    public final nr O00000o(boolean z) {
        O000000o(256, z);
        return this;
    }

    public final boolean O00000o() {
        return O000000o(512);
    }

    public final nr O00000o0(boolean z) {
        O000000o(NotificationCompat.FLAG_HIGH_PRIORITY, z);
        return this;
    }

    public final void O00000o0(int i) throws XMPException {
        if ((i & 256) > 0 && (i & 512) > 0) {
            throw new XMPException("IsStruct and IsArray options are mutually exclusive", 103);
        } else if ((i & 2) > 0 && (i & 768) > 0) {
            throw new XMPException("Structs and arrays can't have \"value\" options", 103);
        }
    }

    public final boolean O00000o0() {
        return O000000o(256);
    }

    /* access modifiers changed from: protected */
    public final int O00000oO() {
        return -2147475470;
    }

    public final nr O00000oo() {
        O000000o(512, true);
        return this;
    }

    public final boolean O0000O0o() {
        return O000000o(1024);
    }

    public final nr O0000OOo() {
        O000000o(1024, true);
        return this;
    }

    public final nr O0000Oo() {
        O000000o(2048, true);
        return this;
    }

    public final boolean O0000Oo0() {
        return O000000o(2048);
    }

    public final boolean O0000OoO() {
        return O000000o(4096);
    }

    public final nr O0000Ooo() {
        O000000o(4096, true);
        return this;
    }

    public final nr O0000o0() {
        O000000o(Integer.MIN_VALUE, true);
        return this;
    }

    public final boolean O0000o00() {
        return O000000o(Integer.MIN_VALUE);
    }

    public final boolean O0000o0O() {
        return (this.f2207O000000o & 768) > 0;
    }

    public final void O000000o(nr nrVar) throws XMPException {
        if (nrVar != null) {
            O00000Oo(nrVar.f2207O000000o | this.f2207O000000o);
        }
    }
}
