package _m_j;

import _m_j.OO00O0o;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class OO0000 extends ActionBar implements ActionBarOverlayLayout.O000000o {
    private static final Interpolator O0000oO = new AccelerateInterpolator();
    private static final Interpolator O0000oOO = new DecelerateInterpolator();

    /* renamed from: O000000o  reason: collision with root package name */
    Context f6698O000000o;
    ActionBarOverlayLayout O00000Oo;
    OOOOO0o O00000o;
    ActionBarContainer O00000o0;
    ActionBarContextView O00000oO;
    View O00000oo;
    ScrollingTabContainerView O0000O0o;
    O000000o O0000OOo;
    OO00O0o.O000000o O0000Oo;
    OO00O0o O0000Oo0;
    boolean O0000OoO = true;
    boolean O0000Ooo;
    final cf O0000o = new cg() {
        /* class _m_j.OO0000.AnonymousClass2 */

        public final void O00000Oo(View view) {
            OO0000 oo0000 = OO0000.this;
            oo0000.O0000o0 = null;
            oo0000.O00000o0.requestLayout();
        }
    };
    OO00o00 O0000o0;
    boolean O0000o00;
    boolean O0000o0O;
    final cf O0000o0o = new cg() {
        /* class _m_j.OO0000.AnonymousClass1 */

        public final void O00000Oo(View view) {
            if (OO0000.this.O0000OoO && OO0000.this.O00000oo != null) {
                OO0000.this.O00000oo.setTranslationY(0.0f);
                OO0000.this.O00000o0.setTranslationY(0.0f);
            }
            OO0000.this.O00000o0.setVisibility(8);
            OO0000.this.O00000o0.setTransitioning(false);
            OO0000 oo0000 = OO0000.this;
            oo0000.O0000o0 = null;
            if (oo0000.O0000Oo != null) {
                oo0000.O0000Oo.O000000o(oo0000.O0000Oo0);
                oo0000.O0000Oo0 = null;
                oo0000.O0000Oo = null;
            }
            if (OO0000.this.O00000Oo != null) {
                cb.O0000ooO(OO0000.this.O00000Oo);
            }
        }
    };
    final ch O0000oO0 = new ch() {
        /* class _m_j.OO0000.AnonymousClass3 */

        public final void O000000o() {
            ((View) OO0000.this.O00000o0.getParent()).invalidate();
        }
    };
    private Context O0000oOo;
    private ArrayList<Object> O0000oo = new ArrayList<>();
    private Activity O0000oo0;
    private int O0000ooO = -1;
    private boolean O0000ooo;
    private boolean O000O00o;
    private int O000O0OO = 0;
    private boolean O000O0Oo;
    private boolean O000O0o0;
    private boolean O00oOoOo = true;
    private boolean O00oOooO;
    private ArrayList<Object> O00oOooo = new ArrayList<>();

    static boolean O000000o(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    public OO0000(Activity activity, boolean z) {
        this.O0000oo0 = activity;
        View decorView = activity.getWindow().getDecorView();
        O000000o(decorView);
        if (!z) {
            this.O00000oo = decorView.findViewById(16908290);
        }
    }

    public OO0000(Dialog dialog) {
        O000000o(dialog.getWindow().getDecorView());
    }

    private void O000000o(View view) {
        this.O00000Oo = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.O00000Oo;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.O00000o = O00000Oo(view.findViewById(R.id.action_bar));
        this.O00000oO = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.O00000o0 = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        OOOOO0o oOOOO0o = this.O00000o;
        if (oOOOO0o == null || this.O00000oO == null || this.O00000o0 == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f6698O000000o = oOOOO0o.O00000Oo();
        if ((this.O00000o.O0000o0O() & 4) != 0) {
            this.O0000ooo = true;
        }
        OO00O0 O000000o2 = OO00O0.O000000o(this.f6698O000000o);
        O000000o2.O00000o();
        O0000O0o(O000000o2.O00000Oo());
        TypedArray obtainStyledAttributes = this.f6698O000000o.obtainStyledAttributes(null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            O00000oo();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            O000000o((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private static OOOOO0o O00000Oo(View view) {
        if (view instanceof OOOOO0o) {
            return (OOOOO0o) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public final void O000000o(float f) {
        cb.O0000Oo(this.O00000o0, f);
    }

    public final void O000000o(Configuration configuration) {
        O0000O0o(OO00O0.O000000o(this.f6698O000000o).O00000Oo());
    }

    private void O0000O0o(boolean z) {
        this.O000O00o = z;
        if (!this.O000O00o) {
            this.O00000o.O000000o((ScrollingTabContainerView) null);
            this.O00000o0.setTabContainer(this.O0000O0o);
        } else {
            this.O00000o0.setTabContainer(null);
            this.O00000o.O000000o(this.O0000O0o);
        }
        boolean z2 = true;
        boolean z3 = O0000o0O() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.O0000O0o;
        if (scrollingTabContainerView != null) {
            if (z3) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.O00000Oo;
                if (actionBarOverlayLayout != null) {
                    cb.O0000ooO(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.O00000o.O000000o(!this.O000O00o && z3);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.O00000Oo;
        if (this.O000O00o || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    public final void O00000Oo(int i) {
        this.O000O0OO = i;
    }

    public final void O00000o0(boolean z) {
        OO00o00 oO00o00;
        this.O000O0o0 = z;
        if (!z && (oO00o00 = this.O0000o0) != null) {
            oO00o00.O00000Oo();
        }
    }

    public final void O00000o(boolean z) {
        if (z != this.O00oOooO) {
            this.O00oOooO = z;
            int size = this.O00oOooo.size();
            for (int i = 0; i < size; i++) {
                this.O00oOooo.get(i);
            }
        }
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

    public final void O000000o(CharSequence charSequence) {
        this.O00000o.O00000Oo(charSequence);
    }

    public final void O00000Oo(CharSequence charSequence) {
        this.O00000o.O000000o(charSequence);
    }

    private void O000000o(int i, int i2) {
        int O0000o0O2 = this.O00000o.O0000o0O();
        if ((i2 & 4) != 0) {
            this.O0000ooo = true;
        }
        this.O00000o.O00000o0((i & i2) | ((i2 ^ -1) & O0000o0O2));
    }

    private int O0000o0O() {
        return this.O00000o.O0000o0o();
    }

    public final int O00000o0() {
        return this.O00000o.O0000o0O();
    }

    public final OO00O0o O000000o(OO00O0o.O000000o o000000o) {
        O000000o o000000o2 = this.O0000OOo;
        if (o000000o2 != null) {
            o000000o2.O00000o0();
        }
        this.O00000Oo.setHideOnContentScrollEnabled(false);
        this.O00000oO.O00000o0();
        O000000o o000000o3 = new O000000o(this.O00000oO.getContext(), o000000o);
        if (!o000000o3.O00000oO()) {
            return null;
        }
        this.O0000OOo = o000000o3;
        o000000o3.O00000o();
        this.O00000oO.O000000o(o000000o3);
        O00000oo(true);
        this.O00000oO.sendAccessibilityEvent(32);
        return o000000o3;
    }

    public final int O00000o() {
        return this.O00000o0.getHeight();
    }

    public final void O00000oO(boolean z) {
        this.O0000OoO = z;
    }

    private void O0000o0o() {
        if (!this.O000O0Oo) {
            this.O000O0Oo = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.O00000Oo;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            O0000OOo(false);
        }
    }

    public final void O0000Ooo() {
        if (this.O0000o00) {
            this.O0000o00 = false;
            O0000OOo(true);
        }
    }

    private void O0000o() {
        if (this.O000O0Oo) {
            this.O000O0Oo = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.O00000Oo;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            O0000OOo(false);
        }
    }

    public final void O0000o00() {
        if (!this.O0000o00) {
            this.O0000o00 = true;
            O0000OOo(true);
        }
    }

    public final void O00000oo() {
        if (this.O00000Oo.O00000Oo) {
            this.O0000o0O = true;
            this.O00000Oo.setHideOnContentScrollEnabled(true);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    private void O0000OOo(boolean z) {
        if (O000000o(this.O0000Ooo, this.O0000o00, this.O000O0Oo)) {
            if (!this.O00oOoOo) {
                this.O00oOoOo = true;
                O0000Oo0(z);
            }
        } else if (this.O00oOoOo) {
            this.O00oOoOo = false;
            O0000Oo(z);
        }
    }

    private void O0000Oo0(boolean z) {
        View view;
        View view2;
        OO00o00 oO00o00 = this.O0000o0;
        if (oO00o00 != null) {
            oO00o00.O00000Oo();
        }
        this.O00000o0.setVisibility(0);
        if (this.O000O0OO != 0 || (!this.O000O0o0 && !z)) {
            this.O00000o0.setAlpha(1.0f);
            this.O00000o0.setTranslationY(0.0f);
            if (this.O0000OoO && (view = this.O00000oo) != null) {
                view.setTranslationY(0.0f);
            }
            this.O0000o.O00000Oo(null);
        } else {
            this.O00000o0.setTranslationY(0.0f);
            float f = (float) (-this.O00000o0.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.O00000o0.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.O00000o0.setTranslationY(f);
            OO00o00 oO00o002 = new OO00o00();
            ce O00000o02 = cb.O0000o(this.O00000o0).O00000o0(0.0f);
            O00000o02.O000000o(this.O0000oO0);
            oO00o002.O000000o(O00000o02);
            if (this.O0000OoO && (view2 = this.O00000oo) != null) {
                view2.setTranslationY(f);
                oO00o002.O000000o(cb.O0000o(this.O00000oo).O00000o0(0.0f));
            }
            oO00o002.O000000o(O0000oOO);
            oO00o002.O00000o0();
            oO00o002.O000000o(this.O0000o);
            this.O0000o0 = oO00o002;
            oO00o002.O000000o();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.O00000Oo;
        if (actionBarOverlayLayout != null) {
            cb.O0000ooO(actionBarOverlayLayout);
        }
    }

    private void O0000Oo(boolean z) {
        View view;
        OO00o00 oO00o00 = this.O0000o0;
        if (oO00o00 != null) {
            oO00o00.O00000Oo();
        }
        if (this.O000O0OO != 0 || (!this.O000O0o0 && !z)) {
            this.O0000o0o.O00000Oo(null);
            return;
        }
        this.O00000o0.setAlpha(1.0f);
        this.O00000o0.setTransitioning(true);
        OO00o00 oO00o002 = new OO00o00();
        float f = (float) (-this.O00000o0.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.O00000o0.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        ce O00000o02 = cb.O0000o(this.O00000o0).O00000o0(f);
        O00000o02.O000000o(this.O0000oO0);
        oO00o002.O000000o(O00000o02);
        if (this.O0000OoO && (view = this.O00000oo) != null) {
            oO00o002.O000000o(cb.O0000o(view).O00000o0(f));
        }
        oO00o002.O000000o(O0000oO);
        oO00o002.O00000o0();
        oO00o002.O000000o(this.O0000o0o);
        this.O0000o0 = oO00o002;
        oO00o002.O000000o();
    }

    public final void O00000oo(boolean z) {
        ce ceVar;
        ce ceVar2;
        if (z) {
            O0000o0o();
        } else {
            O0000o();
        }
        if (cb.O000O0oO(this.O00000o0)) {
            if (z) {
                ceVar = this.O00000o.O000000o(4, 100);
                ceVar2 = this.O00000oO.O000000o(0, 200);
            } else {
                ceVar2 = this.O00000o.O000000o(0, 200);
                ceVar = this.O00000oO.O000000o(8, 100);
            }
            OO00o00 oO00o00 = new OO00o00();
            oO00o00.O000000o(ceVar, ceVar2);
            oO00o00.O000000o();
        } else if (z) {
            this.O00000o.O00000oO(4);
            this.O00000oO.setVisibility(0);
        } else {
            this.O00000o.O00000oO(0);
            this.O00000oO.setVisibility(8);
        }
    }

    public final Context O00000oO() {
        if (this.O0000oOo == null) {
            TypedValue typedValue = new TypedValue();
            this.f6698O000000o.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.O0000oOo = new ContextThemeWrapper(this.f6698O000000o, i);
            } else {
                this.O0000oOo = this.f6698O000000o;
            }
        }
        return this.O0000oOo;
    }

    public final void O000000o(int i) {
        this.O00000o.O00000o(i);
    }

    public final void O0000o0() {
        OO00o00 oO00o00 = this.O0000o0;
        if (oO00o00 != null) {
            oO00o00.O00000Oo();
            this.O0000o0 = null;
        }
    }

    public final boolean O0000Oo() {
        OOOOO0o oOOOO0o = this.O00000o;
        if (oOOOO0o == null || !oOOOO0o.O00000o0()) {
            return false;
        }
        this.O00000o.O00000o();
        return true;
    }

    public class O000000o extends OO00O0o implements MenuBuilder.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final MenuBuilder f6702O000000o;
        private final Context O00000oO;
        private OO00O0o.O000000o O00000oo;
        private WeakReference<View> O0000O0o;

        public O000000o(Context context, OO00O0o.O000000o o000000o) {
            this.O00000oO = context;
            this.O00000oo = o000000o;
            this.f6702O000000o = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f6702O000000o.setCallback(this);
        }

        public final MenuInflater O000000o() {
            return new SupportMenuInflater(this.O00000oO);
        }

        public final Menu O00000Oo() {
            return this.f6702O000000o;
        }

        public final void O00000o0() {
            if (OO0000.this.O0000OOo == this) {
                if (!OO0000.O000000o(OO0000.this.O0000Ooo, OO0000.this.O0000o00, false)) {
                    OO0000 oo0000 = OO0000.this;
                    oo0000.O0000Oo0 = this;
                    oo0000.O0000Oo = this.O00000oo;
                } else {
                    this.O00000oo.O000000o(this);
                }
                this.O00000oo = null;
                OO0000.this.O00000oo(false);
                OO0000.this.O00000oO.O00000Oo();
                OO0000.this.O00000o.O000000o().sendAccessibilityEvent(32);
                OO0000.this.O00000Oo.setHideOnContentScrollEnabled(OO0000.this.O0000o0O);
                OO0000.this.O0000OOo = null;
            }
        }

        public final void O00000o() {
            if (OO0000.this.O0000OOo == this) {
                this.f6702O000000o.stopDispatchingItemsChanged();
                try {
                    this.O00000oo.O00000Oo(this, this.f6702O000000o);
                } finally {
                    this.f6702O000000o.startDispatchingItemsChanged();
                }
            }
        }

        public final boolean O00000oO() {
            this.f6702O000000o.stopDispatchingItemsChanged();
            try {
                return this.O00000oo.O000000o(this, this.f6702O000000o);
            } finally {
                this.f6702O000000o.startDispatchingItemsChanged();
            }
        }

        public final void O000000o(View view) {
            OO0000.this.O00000oO.setCustomView(view);
            this.O0000O0o = new WeakReference<>(view);
        }

        public final void O000000o(CharSequence charSequence) {
            OO0000.this.O00000oO.setSubtitle(charSequence);
        }

        public final void O00000Oo(CharSequence charSequence) {
            OO0000.this.O00000oO.setTitle(charSequence);
        }

        public final void O000000o(int i) {
            O00000Oo(OO0000.this.f6698O000000o.getResources().getString(i));
        }

        public final void O00000Oo(int i) {
            O000000o(OO0000.this.f6698O000000o.getResources().getString(i));
        }

        public final CharSequence O00000oo() {
            return OO0000.this.O00000oO.getTitle();
        }

        public final CharSequence O0000O0o() {
            return OO0000.this.O00000oO.getSubtitle();
        }

        public final void O000000o(boolean z) {
            super.O000000o(z);
            OO0000.this.O00000oO.setTitleOptional(z);
        }

        public final boolean O0000OOo() {
            return OO0000.this.O00000oO.O0000O0o;
        }

        public final View O0000Oo0() {
            WeakReference<View> weakReference = this.O0000O0o;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OO00O0o.O000000o o000000o = this.O00000oo;
            if (o000000o != null) {
                return o000000o.O000000o(this, menuItem);
            }
            return false;
        }

        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.O00000oo != null) {
                O00000o();
                OO0000.this.O00000oO.O000000o();
            }
        }
    }

    public final void O00000Oo(boolean z) {
        if (!this.O0000ooo) {
            O000000o(z);
        }
    }

    public final boolean O000000o(int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        O000000o o000000o = this.O0000OOo;
        if (o000000o == null || (menuBuilder = o000000o.f6702O000000o) == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        menuBuilder.setQwertyMode(z);
        return menuBuilder.performShortcut(i, keyEvent, 0);
    }
}
