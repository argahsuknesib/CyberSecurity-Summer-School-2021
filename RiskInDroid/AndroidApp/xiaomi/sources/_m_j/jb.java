package _m_j;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class jb implements jc {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ViewOverlay f1722O000000o;

    jb(View view) {
        this.f1722O000000o = view.getOverlay();
    }

    public final void O000000o(Drawable drawable) {
        this.f1722O000000o.add(drawable);
    }

    public final void O00000Oo(Drawable drawable) {
        this.f1722O000000o.remove(drawable);
    }
}
