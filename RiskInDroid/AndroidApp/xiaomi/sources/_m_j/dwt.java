package _m_j;

import com.xiaomi.mi_connect.nfc.exception.NfcParseActionRecordException;

public final class dwt implements dws {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15007O000000o;
    public int O00000Oo;
    public byte[] O00000o;
    public byte O00000o0;
    private byte O00000oO;

    public static dwt O000000o(byte[] bArr) throws NfcParseActionRecordException {
        if (bArr.length >= 5) {
            short O000000o2 = dwx.O000000o(bArr, 0);
            byte b = bArr[2];
            byte b2 = bArr[3];
            byte b3 = bArr[4];
            int length = bArr.length - 5;
            byte[] bArr2 = null;
            if (length > 0) {
                bArr2 = new byte[length];
                System.arraycopy(bArr, 5, bArr2, 0, length);
            }
            return new dwt(O000000o2, b, b3, b2, bArr2);
        }
        throw new NfcParseActionRecordException("invalidate action record");
    }

    public final byte[] O000000o() {
        byte[] bArr = this.O00000o;
        byte[] bArr2 = new byte[(bArr == null ? 5 : bArr.length + 5)];
        byte[] O000000o2 = dwx.O000000o((short) this.f15007O000000o);
        bArr2[0] = O000000o2[0];
        bArr2[1] = O000000o2[1];
        bArr2[2] = (byte) this.O00000Oo;
        bArr2[3] = this.O00000oO;
        bArr2[4] = this.O00000o0;
        byte[] bArr3 = this.O00000o;
        if (bArr3 != null) {
            System.arraycopy(bArr3, 0, bArr2, 5, bArr3.length);
        }
        return bArr2;
    }

    public final <T extends dws> T O000000o(Class<T> cls) {
        if (cls.equals(dwt.class)) {
            return this;
        }
        return null;
    }

    public dwt(short s, byte b, byte b2, byte b3, byte[] bArr) {
        this.f15007O000000o = s;
        this.O00000Oo = b;
        this.O00000oO = b3;
        this.O00000o0 = b2;
        this.O00000o = bArr;
    }
}
