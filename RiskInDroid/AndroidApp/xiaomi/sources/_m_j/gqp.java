package _m_j;

import android.view.View;
import androidx.fragment.app.Fragment;

public abstract class gqp extends gqu {

    /* renamed from: O000000o  reason: collision with root package name */
    private ei f18154O000000o = null;
    public final ee O00000Oo;
    private Fragment O00000o = null;

    public abstract Fragment O000000o(int i);

    public gqp(ee eeVar) {
        this.O00000Oo = eeVar;
    }

    public final Object O000000o(View view, int i) {
        if (this.f18154O000000o == null) {
            this.f18154O000000o = this.O00000Oo.O000000o();
        }
        Fragment O000000o2 = this.O00000Oo.O000000o(O000000o(view.getId(), i));
        if (O000000o2 != null) {
            this.f18154O000000o.O00000oo(O000000o2);
        } else {
            O000000o2 = O000000o(i);
            this.f18154O000000o.O000000o(view.getId(), O000000o2, O000000o(view.getId(), i));
        }
        if (O000000o2 != this.O00000o) {
            O000000o2.setMenuVisibility(false);
        }
        return O000000o2;
    }

    public final void O000000o(Object obj) {
        if (this.f18154O000000o == null) {
            this.f18154O000000o = this.O00000Oo.O000000o();
        }
        this.f18154O000000o.O00000o((Fragment) obj);
    }

    public final void O00000Oo(Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.O00000o;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
            }
            this.O00000o = fragment;
        }
    }

    public final void O00000Oo() {
        ei eiVar = this.f18154O000000o;
        if (eiVar != null) {
            eiVar.O00000o0();
            this.f18154O000000o = null;
            this.O00000Oo.O00000Oo();
        }
    }

    public final boolean O000000o(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    private static String O000000o(int i, int i2) {
        return "android:switcher:" + i + ":" + i2;
    }
}
