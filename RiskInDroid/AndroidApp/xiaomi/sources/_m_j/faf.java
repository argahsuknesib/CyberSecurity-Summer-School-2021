package _m_j;

import java.util.ArrayList;

public final class faf {

    /* renamed from: O000000o  reason: collision with root package name */
    final ArrayList<byte[]> f15995O000000o = new ArrayList<>();

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        return true;
     */
    public final boolean O000000o(byte[] bArr) {
        synchronized (this.f15995O000000o) {
            if (this.f15995O000000o.size() == 0) {
                return false;
            }
            int i = 0;
            int i2 = 0;
            while (i < this.f15995O000000o.size() && (i2 = i2 + this.f15995O000000o.get(i).length) < bArr.length) {
                i++;
            }
            if (i2 < bArr.length) {
                return false;
            }
            int i3 = 0;
            while (i > 0) {
                byte[] remove = this.f15995O000000o.remove(0);
                System.arraycopy(remove, 0, bArr, i3, remove.length);
                i3 += remove.length;
                i--;
            }
            int length = bArr.length - i3;
            byte[] remove2 = this.f15995O000000o.remove(0);
            if (remove2.length > length) {
                System.arraycopy(remove2, 0, bArr, i3, length);
                byte[] bArr2 = new byte[(remove2.length - length)];
                System.arraycopy(remove2, length, bArr2, 0, bArr2.length);
                this.f15995O000000o.add(0, bArr2);
            } else {
                System.arraycopy(remove2, 0, bArr, i3, length);
            }
        }
    }

    public final void O00000Oo(byte[] bArr) {
        synchronized (this.f15995O000000o) {
            this.f15995O000000o.add(bArr);
        }
    }

    public final void O000000o() {
        synchronized (this.f15995O000000o) {
            this.f15995O000000o.clear();
        }
    }

    public final int O00000Oo() {
        int size;
        synchronized (this.f15995O000000o) {
            size = this.f15995O000000o.size();
        }
        return size;
    }
}
