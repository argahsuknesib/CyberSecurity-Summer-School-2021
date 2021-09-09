package cn.com.xm.bt.profile.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f3107a = 1;
    private int b = 1;
    private int c = 0;

    public b(int i, int i2, int i3) {
        this.f3107a = i;
        this.b = i2;
        this.c = i3;
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        return this.f3107a == 1;
    }

    public boolean c() {
        return this.b == 1;
    }

    public String toString() {
        return "PieceResult{pieceState=" + this.f3107a + ", profileState=" + this.b + ", timeout=" + this.c + '}';
    }
}
