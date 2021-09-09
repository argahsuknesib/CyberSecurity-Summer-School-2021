package _m_j;

import android.view.View;

public final class lw extends lr {
    public final void O000000o(View view) {
    }

    public final void O000000o(View view, float f) {
        cb.O000000o(view, ((float) (-view.getWidth())) * f);
        cb.O00000oO(view, 180.0f * f);
        if (((double) f) > -0.5d) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    public final void O00000Oo(View view, float f) {
        cb.O000000o(view, ((float) (-view.getWidth())) * f);
        cb.O00000oO(view, 180.0f * f);
        if (((double) f) < 0.5d) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }
}
