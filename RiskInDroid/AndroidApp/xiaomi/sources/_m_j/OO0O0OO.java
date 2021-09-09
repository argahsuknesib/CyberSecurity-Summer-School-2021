package _m_j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

abstract class OO0O0OO {

    /* renamed from: O000000o  reason: collision with root package name */
    final Context f12291O000000o;
    o0OO00OO<ai, MenuItem> O00000Oo;
    o0OO00OO<aj, SubMenu> O00000o0;

    OO0O0OO(Context context) {
        this.f12291O000000o = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem O000000o(MenuItem menuItem) {
        if (!(menuItem instanceof ai)) {
            return menuItem;
        }
        ai aiVar = (ai) menuItem;
        if (this.O00000Oo == null) {
            this.O00000Oo = new o0OO00OO<>();
        }
        MenuItem menuItem2 = this.O00000Oo.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        OO0OOo0 oO0OOo0 = new OO0OOo0(this.f12291O000000o, aiVar);
        this.O00000Oo.put(aiVar, oO0OOo0);
        return oO0OOo0;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu O000000o(SubMenu subMenu) {
        if (!(subMenu instanceof aj)) {
            return subMenu;
        }
        aj ajVar = (aj) subMenu;
        if (this.O00000o0 == null) {
            this.O00000o0 = new o0OO00OO<>();
        }
        SubMenu subMenu2 = this.O00000o0.get(ajVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        OOO00Oo oOO00Oo = new OOO00Oo(this.f12291O000000o, ajVar);
        this.O00000o0.put(ajVar, oOO00Oo);
        return oOO00Oo;
    }
}
