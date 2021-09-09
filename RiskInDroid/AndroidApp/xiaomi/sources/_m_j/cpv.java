package _m_j;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

final class cpv {

    /* renamed from: O000000o  reason: collision with root package name */
    LinkedBlockingQueue<cpu> f14218O000000o;
    private int O00000Oo = 2;
    private O000000o O00000o;
    private int O00000o0;

    interface O000000o {
        void O000000o(byte[] bArr);
    }

    cpv(O000000o o000000o) {
        this.O00000o = o000000o;
        this.f14218O000000o = new LinkedBlockingQueue<>(this.O00000Oo);
        this.O00000o0 = -1;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        Iterator<cpu> it = this.f14218O000000o.iterator();
        while (it.hasNext()) {
            cpu next = it.next();
            next.f14217O000000o = null;
            next.O000000o();
        }
        this.f14218O000000o.clear();
        this.O00000o0 = -1;
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(int i, cpz cpz) {
        this.O00000o0 = O00000Oo(i, cpz);
        for (int i2 = 0; i2 < this.O00000Oo; i2++) {
            this.O00000o.O000000o(new byte[this.O00000o0]);
        }
        return this.O00000o0;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(cpu cpu) {
        O000000o o000000o;
        byte[] bArr = cpu.O00000Oo;
        if (!this.f14218O000000o.offer(cpu)) {
            cpu.f14217O000000o = null;
        }
        if (bArr != null && (o000000o = this.O00000o) != null && bArr.length == this.O00000o0) {
            o000000o.O000000o(bArr);
        }
    }

    private static int O00000Oo(int i, cpz cpz) {
        double d = (double) ((long) (cpz.O00000Oo * cpz.f14222O000000o * i));
        Double.isNaN(d);
        return (int) Math.ceil(d / 8.0d);
    }
}
