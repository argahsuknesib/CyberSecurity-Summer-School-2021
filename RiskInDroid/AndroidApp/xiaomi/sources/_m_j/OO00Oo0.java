package _m_j;

import _m_j.OO00O0o;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public final class OO00Oo0 extends ActionMode {

    /* renamed from: O000000o  reason: collision with root package name */
    final Context f12286O000000o;
    final OO00O0o O00000Oo;

    public OO00Oo0(Context context, OO00O0o oO00O0o) {
        this.f12286O000000o = context;
        this.O00000Oo = oO00O0o;
    }

    public final Object getTag() {
        return this.O00000Oo.O00000o0;
    }

    public final void setTag(Object obj) {
        this.O00000Oo.O00000o0 = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.O00000Oo.O00000Oo(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.O00000Oo.O000000o(charSequence);
    }

    public final void invalidate() {
        this.O00000Oo.O00000o();
    }

    public final void finish() {
        this.O00000Oo.O00000o0();
    }

    public final Menu getMenu() {
        return new OO0o0(this.f12286O000000o, (ah) this.O00000Oo.O00000Oo());
    }

    public final CharSequence getTitle() {
        return this.O00000Oo.O00000oo();
    }

    public final void setTitle(int i) {
        this.O00000Oo.O000000o(i);
    }

    public final CharSequence getSubtitle() {
        return this.O00000Oo.O0000O0o();
    }

    public final void setSubtitle(int i) {
        this.O00000Oo.O00000Oo(i);
    }

    public final View getCustomView() {
        return this.O00000Oo.O0000Oo0();
    }

    public final void setCustomView(View view) {
        this.O00000Oo.O000000o(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.O00000Oo.O000000o();
    }

    public final boolean getTitleOptionalHint() {
        return this.O00000Oo.O00000o;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.O00000Oo.O000000o(z);
    }

    public final boolean isTitleOptional() {
        return this.O00000Oo.O0000OOo();
    }

    public static class O000000o implements OO00O0o.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final ActionMode.Callback f12287O000000o;
        final Context O00000Oo;
        final o0OO00OO<Menu, Menu> O00000o = new o0OO00OO<>();
        final ArrayList<OO00Oo0> O00000o0 = new ArrayList<>();

        public O000000o(Context context, ActionMode.Callback callback) {
            this.O00000Oo = context;
            this.f12287O000000o = callback;
        }

        public final boolean O000000o(OO00O0o oO00O0o, Menu menu) {
            return this.f12287O000000o.onCreateActionMode(O00000Oo(oO00O0o), O000000o(menu));
        }

        public final boolean O00000Oo(OO00O0o oO00O0o, Menu menu) {
            return this.f12287O000000o.onPrepareActionMode(O00000Oo(oO00O0o), O000000o(menu));
        }

        public final boolean O000000o(OO00O0o oO00O0o, MenuItem menuItem) {
            return this.f12287O000000o.onActionItemClicked(O00000Oo(oO00O0o), new OO0OOo0(this.O00000Oo, (ai) menuItem));
        }

        public final void O000000o(OO00O0o oO00O0o) {
            this.f12287O000000o.onDestroyActionMode(O00000Oo(oO00O0o));
        }

        private Menu O000000o(Menu menu) {
            Menu menu2 = this.O00000o.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            OO0o0 oO0o0 = new OO0o0(this.O00000Oo, (ah) menu);
            this.O00000o.put(menu, oO0o0);
            return oO0o0;
        }

        public final ActionMode O00000Oo(OO00O0o oO00O0o) {
            int size = this.O00000o0.size();
            for (int i = 0; i < size; i++) {
                OO00Oo0 oO00Oo0 = this.O00000o0.get(i);
                if (oO00Oo0 != null && oO00Oo0.O00000Oo == oO00O0o) {
                    return oO00Oo0;
                }
            }
            OO00Oo0 oO00Oo02 = new OO00Oo0(this.O00000Oo, oO00O0o);
            this.O00000o0.add(oO00Oo02);
            return oO00Oo02;
        }
    }
}
