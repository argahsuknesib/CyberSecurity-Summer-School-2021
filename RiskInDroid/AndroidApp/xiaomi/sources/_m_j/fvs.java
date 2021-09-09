package _m_j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public abstract class fvs extends fvm implements fvq {

    /* renamed from: O000000o  reason: collision with root package name */
    public View f17283O000000o;
    private boolean O00000Oo;
    private long O00000o0 = 0;

    /* access modifiers changed from: protected */
    public final void O000000o(boolean z) {
        View view;
        if (z) {
            this.O00000o0 = hxi.O00000Oo.O000000o(this, null);
        } else if (this.O00000o0 > 0) {
            hxi.O00000Oo.O000000o(this, this.O00000o0, null);
            this.O00000o0 = 0;
        }
        if (z && (view = this.f17283O000000o) != null) {
            view.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean titleBarSettled() {
        if (this.O00000Oo) {
            return true;
        }
        this.O00000Oo = true;
        return false;
    }

    public void onDestroyView() {
        ViewParent parent;
        super.onDestroyView();
        View view = this.f17283O000000o;
        if (!(view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup))) {
            ((ViewGroup) parent).removeView(this.f17283O000000o);
        }
        this.O00000Oo = false;
    }

    public void refreshTitleBar() {
        gwg.O00000Oo(getActivity().getWindow());
    }
}
