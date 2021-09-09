package _m_j;

import android.view.View;

public abstract class lo implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2170O000000o = 1000;
    private long O00000Oo = 0;

    public abstract void O000000o();

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.O00000Oo > ((long) this.f2170O000000o)) {
            this.O00000Oo = currentTimeMillis;
            O000000o();
        }
    }
}
