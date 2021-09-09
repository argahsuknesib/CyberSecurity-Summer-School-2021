package _m_j;

import com.xiaomi.zxing.FormatException;

final class iga extends igb {

    /* renamed from: O000000o  reason: collision with root package name */
    final int f1265O000000o;
    final int O00000Oo;

    iga(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f1265O000000o = i2;
        this.O00000Oo = i3;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        return this.f1265O000000o == 10;
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo() {
        return this.O00000Oo == 10;
    }
}
