package _m_j;

public final class fga {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f16253O000000o;
    public int O00000Oo;
    public byte[] O00000o0;

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Type: 0x%02x, ", Integer.valueOf(this.O00000Oo)));
        sb.append(String.format("Len: %d, ", Integer.valueOf(this.f16253O000000o)));
        int i = this.O00000Oo;
        String str = (i == 8 || i == 9) ? "%c" : "%02x ";
        try {
            byte[] bArr = this.O00000o0;
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format(str, Byte.valueOf(bArr[i2])));
            }
        } catch (Throwable th) {
            gnk.O000000o(th);
        }
        return sb.toString();
    }
}
