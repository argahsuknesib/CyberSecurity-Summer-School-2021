package _m_j;

import com.xiaomi.zxing.ChecksumException;

public final class igq {

    /* renamed from: O000000o  reason: collision with root package name */
    public final igr f1278O000000o = igr.f1279O000000o;

    public final int[] O000000o(igs igs) throws ChecksumException {
        int length = igs.O00000Oo.length - 1;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 1; i2 < this.f1278O000000o.O00000oo && i < length; i2++) {
            if (igs.O00000Oo(i2) == 0) {
                iArr[i] = this.f1278O000000o.O000000o(i2);
                i++;
            }
        }
        if (i == length) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    public final int[] O000000o(igs igs, igs igs2, int[] iArr) {
        int length = igs2.O00000Oo.length - 1;
        int[] iArr2 = new int[length];
        for (int i = 1; i <= length; i++) {
            iArr2[length - i] = this.f1278O000000o.O00000o(i, igs2.O000000o(i));
        }
        igs igs3 = new igs(this.f1278O000000o, iArr2);
        int length2 = iArr.length;
        int[] iArr3 = new int[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            int O000000o2 = this.f1278O000000o.O000000o(iArr[i2]);
            iArr3[i2] = this.f1278O000000o.O00000o(this.f1278O000000o.O00000o0(0, igs.O00000Oo(O000000o2)), this.f1278O000000o.O000000o(igs3.O00000Oo(O000000o2)));
        }
        return iArr3;
    }
}
