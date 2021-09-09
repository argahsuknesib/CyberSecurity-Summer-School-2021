package _m_j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.xiaomi.passport.ui.internal.MenuBuilder;

public final class eid extends MenuBuilder implements SubMenu {
    private MenuBuilder O0000OOo;
    private egn O0000Oo0;

    public final void clearHeader() {
    }

    public eid(Context context, MenuBuilder menuBuilder, egn egn) {
        super(context);
        this.O0000OOo = menuBuilder;
        this.O0000Oo0 = egn;
    }

    public final void setQwertyMode(boolean z) {
        this.O0000OOo.setQwertyMode(z);
    }

    public final boolean O000000o() {
        return this.O0000OOo.O000000o();
    }

    public final MenuItem getItem() {
        return this.O0000Oo0;
    }

    public final void O000000o(MenuBuilder.O000000o o000000o) {
        this.O0000OOo.O000000o(o000000o);
    }

    public final MenuBuilder O00000o0() {
        return this.O0000OOo;
    }

    public final boolean O000000o(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.O000000o(menuBuilder, menuItem) || this.O0000OOo.O000000o(menuBuilder, menuItem);
    }

    public final SubMenu setIcon(Drawable drawable) {
        this.O0000Oo0.setIcon(drawable);
        return this;
    }

    public final SubMenu setIcon(int i) {
        this.O0000Oo0.setIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        super.O000000o(drawable);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        super.O000000o(charSequence);
        return this;
    }

    public final boolean O000000o(egn egn) {
        return this.O0000OOo.O000000o(egn);
    }

    public final boolean O00000Oo(egn egn) {
        return this.O0000OOo.O00000Oo(egn);
    }

    public final SubMenu setHeaderIcon(int i) {
        super.O000000o(this.f6247O000000o.getResources().getDrawable(i));
        return this;
    }

    public final SubMenu setHeaderTitle(int i) {
        super.O000000o(this.f6247O000000o.getResources().getString(i));
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        super.O000000o((CharSequence) null, (Drawable) null, view);
        return this;
    }
}
