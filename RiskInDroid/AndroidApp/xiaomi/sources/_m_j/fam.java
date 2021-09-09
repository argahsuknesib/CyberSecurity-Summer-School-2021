package _m_j;

import android.view.View;

public final class fam {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int[] f16023O000000o;

    public fam(int[] iArr) {
        this.f16023O000000o = iArr;
    }

    public final void O000000o(View view, int i) {
        for (int findViewById : this.f16023O000000o) {
            view.findViewById(findViewById).setVisibility(i);
        }
    }
}
