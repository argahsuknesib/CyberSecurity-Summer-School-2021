package _m_j;

public final class bau {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final byte[] f12755O000000o = {73, 67, 65, 77};
    protected final int O00000Oo = 23;
    protected byte O00000o = 4;
    protected final String O00000o0 = "CameraLProtoMsgReturn";
    private bav O00000oO;
    private int O00000oo = 4;
    private final int O0000O0o = 1024;
    private byte[] O0000OOo = new byte[1024];
    private int O0000Oo = 0;
    private int O0000Oo0 = 0;

    public final bav O000000o(byte[] bArr) {
        this.O00000oO = new bav();
        if (baw.O000000o(bArr).booleanValue()) {
            byte[] bArr2 = new byte[2];
            bat.O000000o(bArr2, 0, bArr, 4, 5);
            this.O00000oO.f12756O000000o = bat.O000000o(bArr2);
            byte[] bArr3 = new byte[8];
            bat.O000000o(bArr3, 0, bArr, 7, 14);
            this.O00000oO.O00000Oo = bArr3;
            this.O00000oO.O00000o0 = bat.O00000o0(bArr);
            byte[] bArr4 = new byte[4];
            bat.O000000o(bArr4, 0, bArr, 15, 18);
            int O00000Oo2 = bat.O00000Oo(bArr4);
            bav bav = this.O00000oO;
            bav.O00000oO = O00000Oo2;
            if (O00000Oo2 > 0) {
                byte[] bArr5 = new byte[O00000Oo2];
                bat.O000000o(bArr5, 0, bArr, 23, (O00000Oo2 + 23) - 1);
                this.O00000oO.O00000o = bArr5;
            } else {
                bav.O00000o = null;
            }
        } else {
            this.O00000oO = null;
        }
        return this.O00000oO;
    }
}
