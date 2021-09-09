package cn.com.xm.bt.profile.a;

import cn.com.xm.bt.c.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f3099a;
    private int b;
    private byte[] c;

    public int a() {
        return this.f3099a;
    }

    public void a(int i) {
        this.f3099a = i;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public byte[] c() {
        return this.c;
    }

    public void a(byte[] bArr) {
        this.c = bArr;
    }

    public String toString() {
        return "{" + "version=" + this.f3099a + ", algorithm=" + this.b + ", publicKeyHash=" + c.a(this.c) + '}';
    }
}
