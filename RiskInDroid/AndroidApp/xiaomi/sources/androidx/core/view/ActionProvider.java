package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f2842O000000o;
    public O000000o O00000o;
    public O00000Oo O00000oO;

    public interface O000000o {
        void O000000o(boolean z);
    }

    public interface O00000Oo {
        void O000000o();
    }

    public abstract View O000000o();

    public void O000000o(SubMenu subMenu) {
    }

    public boolean O00000Oo() {
        return false;
    }

    public boolean O00000o() {
        return false;
    }

    public boolean O00000o0() {
        return false;
    }

    public boolean O00000oO() {
        return true;
    }

    public ActionProvider(Context context) {
        this.f2842O000000o = context;
    }

    public View O000000o(MenuItem menuItem) {
        return O000000o();
    }

    public final void O000000o(boolean z) {
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O000000o(z);
        }
    }

    public void O000000o(O00000Oo o00000Oo) {
        if (this.O00000oO != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.O00000oO = o00000Oo;
    }
}
