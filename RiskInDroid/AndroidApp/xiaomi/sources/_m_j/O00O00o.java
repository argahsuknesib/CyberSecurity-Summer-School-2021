package _m_j;

import android.view.View;

public final class O00O00o implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f6624O000000o = 0;
    public int O00000Oo;
    public View.OnClickListener O00000o0;

    public O00O00o(View.OnClickListener onClickListener) {
        this.O00000o0 = onClickListener;
        this.O00000Oo = 500;
    }

    public O00O00o(View.OnClickListener onClickListener, int i) {
        this.O00000o0 = onClickListener;
        this.O00000Oo = i;
    }

    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6624O000000o > ((long) this.O00000Oo)) {
            this.f6624O000000o = currentTimeMillis;
            View.OnClickListener onClickListener = this.O00000o0;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
