package _m_j;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;

public class jch extends PKWareExtraHeader {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f1759O000000o;
    private PKWareExtraHeader.EncryptionAlgorithm O00000Oo;
    private int O00000o;
    private int O00000o0;
    private long O00000oO;
    private PKWareExtraHeader.HashAlgorithm O00000oo;
    private int O0000O0o;
    private byte[] O0000OOo;
    private byte[] O0000Oo;
    private byte[] O0000Oo0;
    private byte[] O0000OoO;
    private byte[] O0000Ooo;
    private byte[] O0000o00;

    public jch() {
        super(new ZipShort(23));
    }

    public final void O000000o(byte[] bArr, int i, int i2) {
        super.O000000o(bArr, i, i2);
        int O000000o2 = ZipShort.O000000o(bArr, i);
        this.O0000OOo = new byte[O000000o2];
        System.arraycopy(bArr, i + 4, this.O0000OOo, 0, O000000o2);
        int i3 = i + O000000o2;
        this.f1759O000000o = ZipShort.O000000o(bArr, i3 + 6);
        this.O00000Oo = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.O000000o(bArr, i3 + 8));
        this.O00000o0 = ZipShort.O000000o(bArr, i3 + 10);
        this.O00000o = ZipShort.O000000o(bArr, i3 + 12);
        int O000000o3 = ZipShort.O000000o(bArr, i3 + 14);
        this.O0000Oo0 = new byte[O000000o3];
        int i4 = i3 + 16;
        System.arraycopy(bArr, i4, this.O0000Oo0, 0, O000000o3);
        this.O00000oO = ZipLong.O000000o(bArr, i4 + O000000o3);
        System.out.println("rcount: " + this.O00000oO);
        if (this.O00000oO == 0) {
            int O000000o4 = ZipShort.O000000o(bArr, i3 + 20 + O000000o3);
            int i5 = O000000o4 - 4;
            this.O0000Ooo = new byte[i5];
            this.O0000o00 = new byte[4];
            int i6 = i3 + 22 + O000000o3;
            System.arraycopy(bArr, i6, this.O0000Ooo, 0, i5);
            System.arraycopy(bArr, (i6 + O000000o4) - 4, this.O0000o00, 0, 4);
            return;
        }
        this.O00000oo = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.O000000o(bArr, i3 + 20 + O000000o3));
        int i7 = i3 + 22 + O000000o3;
        this.O0000O0o = ZipShort.O000000o(bArr, i7);
        int i8 = i3 + 24 + O000000o3;
        int O000000o5 = ZipShort.O000000o(bArr, i8);
        int i9 = this.O0000O0o;
        this.O0000Oo = new byte[i9];
        this.O0000OoO = new byte[(O000000o5 - i9)];
        System.arraycopy(bArr, i8, this.O0000Oo, 0, i9);
        int i10 = this.O0000O0o;
        System.arraycopy(bArr, i8 + i10, this.O0000OoO, 0, O000000o5 - i10);
        int O000000o6 = ZipShort.O000000o(bArr, i3 + 26 + O000000o3 + O000000o5);
        int i11 = O000000o6 - 4;
        this.O0000Ooo = new byte[i11];
        this.O0000o00 = new byte[4];
        int i12 = i7 + O000000o5;
        System.arraycopy(bArr, i12, this.O0000Ooo, 0, i11);
        System.arraycopy(bArr, (i12 + O000000o6) - 4, this.O0000o00, 0, 4);
    }
}
