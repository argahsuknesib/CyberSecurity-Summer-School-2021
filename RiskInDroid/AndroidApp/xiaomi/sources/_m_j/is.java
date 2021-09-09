package _m_j;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class is {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Map<String, Object> f1596O000000o = new HashMap();
    public View O00000Oo;
    public final ArrayList<Transition> O00000o0 = new ArrayList<>();

    @Deprecated
    public is() {
    }

    public is(View view) {
        this.O00000Oo = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof is)) {
            return false;
        }
        is isVar = (is) obj;
        return this.O00000Oo == isVar.O00000Oo && this.f1596O000000o.equals(isVar.f1596O000000o);
    }

    public final int hashCode() {
        return (this.O00000Oo.hashCode() * 31) + this.f1596O000000o.hashCode();
    }

    public final String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.O00000Oo + "\n") + "    values:";
        for (String next : this.f1596O000000o.keySet()) {
            str = str + "    " + next + ": " + this.f1596O000000o.get(next) + "\n";
        }
        return str;
    }
}
