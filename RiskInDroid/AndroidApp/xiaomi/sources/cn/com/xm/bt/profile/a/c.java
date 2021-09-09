package cn.com.xm.bt.profile.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f3100a = 0;
    private int b = 0;
    private byte[] c = null;
    private int d = 0;

    public c(int i, int i2) {
        this.f3100a = i;
        this.b = i2;
    }

    public c(int i, int i2, int i3) {
        this.f3100a = i;
        this.b = i2;
        this.d = i3;
    }

    public c(int i) {
        this.f3100a = i;
    }

    public c() {
    }

    public int a() {
        return this.f3100a;
    }

    public int b() {
        return this.b;
    }

    public void a(byte[] bArr) {
        this.c = bArr;
    }

    public int c() {
        byte[] bArr = this.c;
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        return ((bArr[1] & 15) << 8) | (bArr[0] & 255);
    }

    public String toString() {
        return "HMAuthState{mState=" + this.f3100a + ", mError=" + this.b + ", mRandomValue=" + cn.com.xm.bt.c.c.a(this.c) + ", randomSimple=" + c() + ", internalState=" + this.d + '}';
    }
}
