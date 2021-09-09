package _m_j;

import com.xiaomi.zxing.NotFoundException;

public final class icy {

    /* renamed from: O000000o  reason: collision with root package name */
    public final icx f1204O000000o;
    private idm O00000Oo;

    public icy(icx icx) {
        if (icx != null) {
            this.f1204O000000o = icx;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public final int O000000o() {
        return this.f1204O000000o.f1203O000000o.O00000Oo;
    }

    public final idm O00000Oo() throws NotFoundException {
        if (this.O00000Oo == null) {
            this.O00000Oo = this.f1204O000000o.O000000o();
        }
        return this.O00000Oo;
    }

    public final String toString() {
        try {
            return O00000Oo().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
