package _m_j;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class iw implements ix {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ViewGroupOverlay f1639O000000o;

    iw(ViewGroup viewGroup) {
        this.f1639O000000o = viewGroup.getOverlay();
    }

    public final void O000000o(Drawable drawable) {
        this.f1639O000000o.add(drawable);
    }

    public final void O00000Oo(Drawable drawable) {
        this.f1639O000000o.remove(drawable);
    }

    public final void O000000o(View view) {
        this.f1639O000000o.add(view);
    }

    public final void O00000Oo(View view) {
        this.f1639O000000o.remove(view);
    }
}
