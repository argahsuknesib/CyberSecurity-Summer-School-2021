package _m_j;

import android.util.Log;

public final class dpu {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14843O000000o;
    public byte[] O00000Oo;
    public int O00000o;
    public int O00000o0;

    public final boolean O000000o(int i) {
        return O00000Oo(this.O00000o0 + i);
    }

    public final boolean O00000Oo(int i) {
        int i2 = this.O00000o;
        if (i > i2) {
            this.O00000o0 = i2;
            return false;
        } else if (i < 0) {
            this.O00000o0 = 0;
            return false;
        } else {
            this.O00000o0 = i;
            return true;
        }
    }

    public final byte O000000o() {
        int i;
        byte[] bArr = this.O00000Oo;
        if (bArr == null || (i = this.O00000o0) >= this.O00000o) {
            Log.e("CodeReader_TMTEST", "readByte error mCode:" + this.O00000Oo + "  mCurIndex:" + this.O00000o0 + "  mCount:" + this.O00000o);
            return -1;
        }
        this.O00000o0 = i + 1;
        return bArr[i];
    }

    public final short O00000Oo() {
        int i;
        byte[] bArr = this.O00000Oo;
        if (bArr == null || (i = this.O00000o0) >= this.O00000o - 1) {
            Log.e("CodeReader_TMTEST", "readShort error mCode:" + this.O00000Oo + "  mCurIndex:" + this.O00000o0 + "  mCount:" + this.O00000o);
            return -1;
        }
        this.O00000o0 = i + 1;
        int i2 = this.O00000o0;
        this.O00000o0 = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
    }

    public final int O00000o0() {
        int i;
        byte[] bArr = this.O00000Oo;
        if (bArr == null || (i = this.O00000o0) >= this.O00000o - 3) {
            Log.e("CodeReader_TMTEST", "readInt error mCode:" + this.O00000Oo + "  mCurIndex:" + this.O00000o0 + "  mCount:" + this.O00000o);
            return -1;
        }
        this.O00000o0 = i + 1;
        int i2 = this.O00000o0;
        this.O00000o0 = i2 + 1;
        byte b = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i3 = this.O00000o0;
        this.O00000o0 = i3 + 1;
        byte b2 = b | ((bArr[i3] & 255) << 8);
        int i4 = this.O00000o0;
        this.O00000o0 = i4 + 1;
        return (bArr[i4] & 255) | b2;
    }
}
