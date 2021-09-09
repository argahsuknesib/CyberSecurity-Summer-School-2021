package _m_j;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public final class O000o000 implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ O000o00 f6621O000000o;

    public O000o000(O000o00 o000o00) {
        this.f6621O000000o = o000o00;
    }

    public final void run() {
        O000o00 o000o00 = this.f6621O000000o;
        Animation loadAnimation = AnimationUtils.loadAnimation(o000o00.f6620O000000o, o000o00.O00000Oo.O00000Oo.O0000OOo);
        if (loadAnimation != null) {
            this.f6621O000000o.O00000o0.O00000o0.startAnimation(loadAnimation);
        }
    }
}
