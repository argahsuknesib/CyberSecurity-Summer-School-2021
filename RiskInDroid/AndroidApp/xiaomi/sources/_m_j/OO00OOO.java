package _m_j;

import _m_j.OO00O0o;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public final class OO00OOO extends OO00O0o implements MenuBuilder.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f12285O000000o;
    private ActionBarContextView O00000Oo;
    private OO00O0o.O000000o O00000oO;
    private WeakReference<View> O00000oo;
    private boolean O0000O0o;
    private boolean O0000OOo;
    private MenuBuilder O0000Oo0;

    public OO00OOO(Context context, ActionBarContextView actionBarContextView, OO00O0o.O000000o o000000o, boolean z) {
        this.f12285O000000o = context;
        this.O00000Oo = actionBarContextView;
        this.O00000oO = o000000o;
        this.O0000Oo0 = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.O0000Oo0.setCallback(this);
        this.O0000OOo = z;
    }

    public final void O00000Oo(CharSequence charSequence) {
        this.O00000Oo.setTitle(charSequence);
    }

    public final void O000000o(CharSequence charSequence) {
        this.O00000Oo.setSubtitle(charSequence);
    }

    public final void O000000o(int i) {
        O00000Oo(this.f12285O000000o.getString(i));
    }

    public final void O00000Oo(int i) {
        O000000o(this.f12285O000000o.getString(i));
    }

    public final void O000000o(boolean z) {
        super.O000000o(z);
        this.O00000Oo.setTitleOptional(z);
    }

    public final boolean O0000OOo() {
        return this.O00000Oo.O0000O0o;
    }

    public final void O000000o(View view) {
        this.O00000Oo.setCustomView(view);
        this.O00000oo = view != null ? new WeakReference<>(view) : null;
    }

    public final void O00000o() {
        this.O00000oO.O00000Oo(this, this.O0000Oo0);
    }

    public final void O00000o0() {
        if (!this.O0000O0o) {
            this.O0000O0o = true;
            this.O00000Oo.sendAccessibilityEvent(32);
            this.O00000oO.O000000o(this);
        }
    }

    public final Menu O00000Oo() {
        return this.O0000Oo0;
    }

    public final CharSequence O00000oo() {
        return this.O00000Oo.getTitle();
    }

    public final CharSequence O0000O0o() {
        return this.O00000Oo.getSubtitle();
    }

    public final View O0000Oo0() {
        WeakReference<View> weakReference = this.O00000oo;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final MenuInflater O000000o() {
        return new SupportMenuInflater(this.O00000Oo.getContext());
    }

    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.O00000oO.O000000o(this, menuItem);
    }

    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        O00000o();
        this.O00000Oo.O000000o();
    }
}
