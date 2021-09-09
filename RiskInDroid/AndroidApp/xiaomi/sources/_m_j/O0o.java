package _m_j;

import _m_j.OO0o000;
import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public final class O0o extends ActionBar {

    /* renamed from: O000000o  reason: collision with root package name */
    OOOOO0o f6689O000000o;
    boolean O00000Oo;
    private boolean O00000o;
    public Window.Callback O00000o0;
    private boolean O00000oO;
    private ArrayList<Object> O00000oo = new ArrayList<>();
    private final Runnable O0000O0o = new Runnable() {
        /* class _m_j.O0o.AnonymousClass1 */

        public final void run() {
            O0o o0o = O0o.this;
            Menu O0000Ooo = o0o.O0000Ooo();
            MenuBuilder menuBuilder = O0000Ooo instanceof MenuBuilder ? (MenuBuilder) O0000Ooo : null;
            if (menuBuilder != null) {
                menuBuilder.stopDispatchingItemsChanged();
            }
            try {
                O0000Ooo.clear();
                if (!o0o.O00000o0.onCreatePanelMenu(0, O0000Ooo) || !o0o.O00000o0.onPreparePanel(0, null, O0000Ooo)) {
                    O0000Ooo.clear();
                }
            } finally {
                if (menuBuilder != null) {
                    menuBuilder.startDispatchingItemsChanged();
                }
            }
        }
    };
    private final Toolbar.O00000Oo O0000OOo = new Toolbar.O00000Oo() {
        /* class _m_j.O0o.AnonymousClass2 */

        public final boolean O000000o(MenuItem menuItem) {
            return O0o.this.O00000o0.onMenuItemSelected(0, menuItem);
        }
    };

    public final void O00000Oo(boolean z) {
    }

    public final void O00000o0(boolean z) {
    }

    public O0o(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f6689O000000o = new o0000000(toolbar, false);
        this.O00000o0 = new O00000o0(callback);
        this.f6689O000000o.O000000o(this.O00000o0);
        toolbar.setOnMenuItemClickListener(this.O0000OOo);
        this.f6689O000000o.O000000o(charSequence);
    }

    public final void O000000o(float f) {
        cb.O0000Oo(this.f6689O000000o.O000000o(), f);
    }

    public final Context O00000oO() {
        return this.f6689O000000o.O00000Oo();
    }

    public final void O000000o(int i) {
        this.f6689O000000o.O00000o(i);
    }

    public final void O000000o(Configuration configuration) {
        super.O000000o(configuration);
    }

    public final void O000000o(CharSequence charSequence) {
        this.f6689O000000o.O00000Oo(charSequence);
    }

    public final void O00000Oo(CharSequence charSequence) {
        this.f6689O000000o.O000000o(charSequence);
    }

    private void O000000o(int i, int i2) {
        this.f6689O000000o.O00000o0((i & i2) | ((i2 ^ -1) & this.f6689O000000o.O0000o0O()));
    }

    public final void O000000o() {
        O000000o(2, 2);
    }

    public final void O000000o(boolean z) {
        O000000o(z ? 4 : 0, 4);
    }

    public final void O00000Oo() {
        O000000o(0, 8);
    }

    public final int O00000o0() {
        return this.f6689O000000o.O0000o0O();
    }

    public final int O00000o() {
        return this.f6689O000000o.O0000o();
    }

    public final boolean O0000O0o() {
        return this.f6689O000000o.O0000OoO();
    }

    public final boolean O0000OOo() {
        return this.f6689O000000o.O0000Ooo();
    }

    public final boolean O0000Oo0() {
        this.f6689O000000o.O000000o().removeCallbacks(this.O0000O0o);
        cb.O000000o(this.f6689O000000o.O000000o(), this.O0000O0o);
        return true;
    }

    public final boolean O0000Oo() {
        if (!this.f6689O000000o.O00000o0()) {
            return false;
        }
        this.f6689O000000o.O00000o();
        return true;
    }

    public final boolean O000000o(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            O0000O0o();
        }
        return true;
    }

    public final boolean O000000o(int i, KeyEvent keyEvent) {
        Menu O0000Ooo = O0000Ooo();
        if (O0000Ooo == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        O0000Ooo.setQwertyMode(z);
        return O0000Ooo.performShortcut(i, keyEvent, 0);
    }

    public final void O0000OoO() {
        this.f6689O000000o.O000000o().removeCallbacks(this.O0000O0o);
    }

    public final void O00000o(boolean z) {
        if (z != this.O00000oO) {
            this.O00000oO = z;
            int size = this.O00000oo.size();
            for (int i = 0; i < size; i++) {
                this.O00000oo.get(i);
            }
        }
    }

    class O00000o0 extends OO0O00o {
        public O00000o0(Window.Callback callback) {
            super(callback);
        }

        public final boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !O0o.this.O00000Oo) {
                O0o.this.f6689O000000o.O0000o00();
                O0o.this.O00000Oo = true;
            }
            return onPreparePanel;
        }

        public final View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(O0o.this.f6689O000000o.O00000Oo());
            }
            return super.onCreatePanelView(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final Menu O0000Ooo() {
        if (!this.O00000o) {
            this.f6689O000000o.O000000o(new O000000o(), new O00000Oo());
            this.O00000o = true;
        }
        return this.f6689O000000o.O0000oO0();
    }

    final class O000000o implements OO0o000.O000000o {
        private boolean O00000Oo;

        O000000o() {
        }

        public final boolean O000000o(MenuBuilder menuBuilder) {
            if (O0o.this.O00000o0 == null) {
                return false;
            }
            O0o.this.O00000o0.onMenuOpened(108, menuBuilder);
            return true;
        }

        public final void O000000o(MenuBuilder menuBuilder, boolean z) {
            if (!this.O00000Oo) {
                this.O00000Oo = true;
                O0o.this.f6689O000000o.O0000o0();
                if (O0o.this.O00000o0 != null) {
                    O0o.this.O00000o0.onPanelClosed(108, menuBuilder);
                }
                this.O00000Oo = false;
            }
        }
    }

    final class O00000Oo implements MenuBuilder.O000000o {
        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        O00000Oo() {
        }

        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            if (O0o.this.O00000o0 == null) {
                return;
            }
            if (O0o.this.f6689O000000o.O0000Oo0()) {
                O0o.this.O00000o0.onPanelClosed(108, menuBuilder);
            } else if (O0o.this.O00000o0.onPreparePanel(0, null, menuBuilder)) {
                O0o.this.O00000o0.onMenuOpened(108, menuBuilder);
            }
        }
    }
}
