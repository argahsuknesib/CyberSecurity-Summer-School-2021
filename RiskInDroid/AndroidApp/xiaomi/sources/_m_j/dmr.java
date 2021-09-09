package _m_j;

import android.util.Log;

public final class dmr {

    /* renamed from: O000000o  reason: collision with root package name */
    public bnt f14792O000000o;
    public int O00000Oo;
    int O00000o0;

    public final void O000000o(int i) {
        this.O00000Oo = this.O00000o0 + i;
    }

    public final byte O000000o() {
        bnt bnt = this.f14792O000000o;
        if (bnt == null || this.O00000Oo >= bnt.O00000o0) {
            Log.e("CodeReader", "readByte error mCode:" + this.f14792O000000o + "  mCurIndex:" + this.O00000Oo);
            return 0;
        }
        byte[] bArr = this.f14792O000000o.f13148O000000o;
        int i = this.O00000Oo;
        this.O00000Oo = i + 1;
        return bArr[i];
    }

    public final int O00000Oo() {
        bnt bnt = this.f14792O000000o;
        if (bnt == null || this.O00000Oo >= bnt.O00000o0 - 3) {
            Log.e("CodeReader", "readInt error mCode:" + this.f14792O000000o + "  mCurIndex:" + this.O00000Oo);
            return 0;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte[] bArr = this.f14792O000000o.f13148O000000o;
            int i4 = this.O00000Oo;
            this.O00000Oo = i4 + 1;
            i |= (bArr[i4] & 255) << i2;
            i2 += 8;
        }
        return i;
    }
}
