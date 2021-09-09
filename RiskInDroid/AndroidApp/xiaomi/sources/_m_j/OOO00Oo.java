package _m_j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class OOO00Oo extends OO0o0 implements SubMenu {
    private final aj O00000o;

    OOO00Oo(Context context, aj ajVar) {
        super(context, ajVar);
        this.O00000o = ajVar;
    }

    public final SubMenu setHeaderTitle(int i) {
        this.O00000o.setHeaderTitle(i);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        this.O00000o.setHeaderTitle(charSequence);
        return this;
    }

    public final SubMenu setHeaderIcon(int i) {
        this.O00000o.setHeaderIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        this.O00000o.setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        this.O00000o.setHeaderView(view);
        return this;
    }

    public final void clearHeader() {
        this.O00000o.clearHeader();
    }

    public final SubMenu setIcon(int i) {
        this.O00000o.setIcon(i);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        this.O00000o.setIcon(drawable);
        return this;
    }

    public final MenuItem getItem() {
        return O000000o(this.O00000o.getItem());
    }
}
