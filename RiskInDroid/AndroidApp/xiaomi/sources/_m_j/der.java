package _m_j;

import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;

public final class der implements def {

    /* renamed from: O000000o  reason: collision with root package name */
    private final SparseArray<dec> f14556O000000o = new SparseArray<>();
    private final SparseArray<Integer> O00000Oo = new SparseArray<>();
    private final SparseArray<ArrayList<dec>> O00000o0 = new SparseArray<>();

    public final synchronized void O000000o(dec dec) {
        this.f14556O000000o.put(dec.O00000oO, dec);
    }

    public final synchronized dec O000000o(int i) {
        return this.f14556O000000o.get(i);
    }

    public final synchronized boolean O000000o(int i, int i2) {
        dec dec = this.f14556O000000o.get(i);
        if (dec == null) {
            return false;
        }
        O00000Oo(dec);
        O000000o(i2, dec);
        return true;
    }

    private synchronized void O000000o(int i, dec dec) {
        if (this.O00000Oo.get(dec.O00000oO) == null) {
            this.O00000Oo.put(dec.O00000oO, Integer.valueOf(i));
            ArrayList arrayList = this.O00000o0.get(i);
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(dec);
                this.O00000o0.put(i, arrayList2);
                return;
            }
            arrayList.add(dec);
            return;
        }
        throw new IllegalStateException("Handler " + dec + " already attached");
    }

    private synchronized void O00000Oo(dec dec) {
        Integer num = this.O00000Oo.get(dec.O00000oO);
        if (num != null) {
            this.O00000Oo.remove(dec.O00000oO);
            ArrayList arrayList = this.O00000o0.get(num.intValue());
            if (arrayList != null) {
                arrayList.remove(dec);
                if (arrayList.size() == 0) {
                    this.O00000o0.remove(num.intValue());
                }
            }
        }
        if (dec.O00000oo != null) {
            dec.O00000o0();
        }
    }

    public final synchronized void O00000Oo(int i) {
        dec dec = this.f14556O000000o.get(i);
        if (dec != null) {
            O00000Oo(dec);
            this.f14556O000000o.remove(i);
        }
    }

    public final synchronized void O000000o() {
        this.f14556O000000o.clear();
        this.O00000Oo.clear();
        this.O00000o0.clear();
    }

    private synchronized ArrayList<dec> O00000o0(int i) {
        return this.O00000o0.get(i);
    }

    public final synchronized ArrayList<dec> O000000o(View view) {
        return O00000o0(view.getId());
    }
}
