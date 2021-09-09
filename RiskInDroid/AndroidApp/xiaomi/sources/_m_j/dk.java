package _m_j;

import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.List;

public final class dk<C, T, A> implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<C> f14733O000000o;
    private long O00000Oo;
    private int O00000o;
    private long[] O00000o0;

    public static abstract class O000000o<C, T, A> {
    }

    public final synchronized void O000000o(ViewDataBinding viewDataBinding, int i) {
        this.O00000o++;
        int size = this.f14733O000000o.size();
        int length = this.O00000o0 == null ? -1 : this.O00000o0.length - 1;
        O000000o(viewDataBinding, i, null, length);
        O000000o(viewDataBinding, i, null, (length + 2) * 64, size, 0);
        this.O00000o--;
        if (this.O00000o == 0) {
            if (this.O00000o0 != null) {
                for (int length2 = this.O00000o0.length - 1; length2 >= 0; length2--) {
                    long j = this.O00000o0[length2];
                    if (j != 0) {
                        O000000o((length2 + 1) * 64, j);
                        this.O00000o0[length2] = 0;
                    }
                }
            }
            if (this.O00000Oo != 0) {
                O000000o(0, this.O00000Oo);
                this.O00000Oo = 0;
            }
        }
    }

    private void O000000o(T t, int i, A a2) {
        O000000o(t, i, a2, 0, Math.min(64, this.f14733O000000o.size()), this.O00000Oo);
    }

    private void O000000o(T t, int i, A a2, int i2) {
        if (i2 < 0) {
            O000000o(t, i, a2);
            return;
        }
        long j = this.O00000o0[i2];
        int i3 = (i2 + 1) * 64;
        int min = Math.min(this.f14733O000000o.size(), i3 + 64);
        O000000o(t, i, a2, i2 - 1);
        O000000o(t, i, a2, i3, min, j);
    }

    private void O000000o(T t, int i, A a2, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.f14733O000000o.get(i2);
            }
            j2 <<= 1;
            i2++;
        }
    }

    private void O000000o(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = (i + 64) - 1; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.f14733O000000o.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A[Catch:{ CloneNotSupportedException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0058 A[SYNTHETIC] */
    /* renamed from: O000000o */
    public synchronized dk<C, T, A> clone() {
        dk<C, T, A> dkVar;
        CloneNotSupportedException e;
        int i;
        try {
            dkVar = (dk) super.clone();
            try {
                dkVar.O00000Oo = 0;
                dkVar.O00000o0 = null;
                dkVar.O00000o = 0;
                dkVar.f14733O000000o = new ArrayList();
                int size = this.f14733O000000o.size();
                for (int i2 = 0; i2 < size; i2++) {
                    boolean z = true;
                    if (i2 < 64) {
                        if (((1 << i2) & this.O00000Oo) != 0) {
                            if (!z) {
                                dkVar.f14733O000000o.add(this.f14733O000000o.get(i2));
                            }
                        }
                    } else if (this.O00000o0 != null && (i = (i2 / 64) - 1) < this.O00000o0.length) {
                        if (((1 << (i2 % 64)) & this.O00000o0[i]) != 0) {
                            if (!z) {
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return dkVar;
            }
        } catch (CloneNotSupportedException e3) {
            CloneNotSupportedException cloneNotSupportedException = e3;
            dkVar = null;
            e = cloneNotSupportedException;
            e.printStackTrace();
            return dkVar;
        }
        return dkVar;
    }
}
