package _m_j;

public abstract class ffm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected byte[] f16223O000000o = new byte[0];
    private int O00000Oo;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(int, int):int}
     arg types: [byte, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int} */
    public ffm(byte[] bArr) {
        int min;
        if (bArr != null && bArr.length > 0) {
            this.O00000Oo = bArr[0];
            if (bArr.length > 1 && (min = Math.min((int) bArr[1], bArr.length - 2)) > 0) {
                this.f16223O000000o = new byte[min];
                System.arraycopy(bArr, 2, this.f16223O000000o, 0, min);
            }
        }
    }
}
