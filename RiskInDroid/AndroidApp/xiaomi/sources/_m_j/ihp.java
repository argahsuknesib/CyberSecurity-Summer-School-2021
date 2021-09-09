package _m_j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ihp {

    /* renamed from: O000000o  reason: collision with root package name */
    public BlockingQueue<ihq> f1302O000000o = new ArrayBlockingQueue(100);
    public int O00000Oo = 0;
    private int O00000o = 0;
    private int O00000o0 = 0;

    public final int O000000o(byte[] bArr, int i, int i2) {
        int i3 = i + 0;
        if (this.O00000Oo == 0) {
            this.O00000Oo = i2;
        }
        if (bArr != null && i3 > 0 && bArr.length > 0 && i <= bArr.length) {
            try {
                this.f1302O000000o.put(new ihq(bArr, 0, i, i2));
                return i3;
            } catch (InterruptedException unused) {
            }
        }
        return 0;
    }

    public final ihq O000000o() {
        if (this.f1302O000000o.isEmpty()) {
            return null;
        }
        try {
            return this.f1302O000000o.take();
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public final int O00000Oo(byte[] bArr, int i, int i2) {
        if (i <= 0) {
            return i;
        }
        if (bArr.length < i) {
            i = bArr.length;
        }
        try {
            this.f1302O000000o.put(new ihq(bArr, i, 0, i2));
            return i;
        } catch (InterruptedException unused) {
            return 0;
        }
    }
}
