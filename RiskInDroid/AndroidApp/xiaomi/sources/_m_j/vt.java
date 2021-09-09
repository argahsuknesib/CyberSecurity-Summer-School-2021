package _m_j;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public final class vt implements vu {

    /* renamed from: O000000o  reason: collision with root package name */
    private final float f2563O000000o;

    public vt() {
        this((byte) 0);
    }

    private vt(byte b) {
        this.f2563O000000o = 0.0f;
    }

    public final Animator[] O000000o(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", this.f2563O000000o, 1.0f)};
    }
}
