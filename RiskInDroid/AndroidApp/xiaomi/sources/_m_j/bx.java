package _m_j;

import android.view.View;
import android.view.ViewTreeObserver;

public final class bx implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private final View f13373O000000o;
    private ViewTreeObserver O00000Oo;
    private final Runnable O00000o0;

    private bx(View view, Runnable runnable) {
        this.f13373O000000o = view;
        this.O00000Oo = view.getViewTreeObserver();
        this.O00000o0 = runnable;
    }

    public static bx O000000o(View view, Runnable runnable) {
        if (view != null) {
            bx bxVar = new bx(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(bxVar);
            view.addOnAttachStateChangeListener(bxVar);
            return bxVar;
        }
        throw new NullPointerException("view == null");
    }

    public final boolean onPreDraw() {
        O000000o();
        this.O00000o0.run();
        return true;
    }

    private void O000000o() {
        if (this.O00000Oo.isAlive()) {
            this.O00000Oo.removeOnPreDrawListener(this);
        } else {
            this.f13373O000000o.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f13373O000000o.removeOnAttachStateChangeListener(this);
    }

    public final void onViewAttachedToWindow(View view) {
        this.O00000Oo = view.getViewTreeObserver();
    }

    public final void onViewDetachedFromWindow(View view) {
        O000000o();
    }
}
