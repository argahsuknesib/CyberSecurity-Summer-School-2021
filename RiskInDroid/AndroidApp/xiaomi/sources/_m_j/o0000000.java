package _m_j;

import _m_j.OO0o000;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import com.xiaomi.smarthome.R;

public final class o0000000 implements OOOOO0o {

    /* renamed from: O000000o  reason: collision with root package name */
    Toolbar f2225O000000o;
    CharSequence O00000Oo;
    boolean O00000o;
    Window.Callback O00000o0;
    private int O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private Drawable O0000OOo;
    private Drawable O0000Oo;
    private Drawable O0000Oo0;
    private boolean O0000OoO;
    private CharSequence O0000Ooo;
    private Drawable O0000o;
    private ActionMenuPresenter O0000o0;
    private CharSequence O0000o00;
    private int O0000o0O;
    private int O0000o0o;

    public o0000000(Toolbar toolbar, boolean z) {
        this(toolbar, z, (byte) 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, androidx.appcompat.widget.Toolbar, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private o0000000(Toolbar toolbar, boolean z, byte b) {
        Drawable drawable;
        this.O0000o0O = 0;
        this.O0000o0o = 0;
        this.f2225O000000o = toolbar;
        this.O00000Oo = toolbar.getTitle();
        this.O0000Ooo = toolbar.getSubtitle();
        this.O0000OoO = this.O00000Oo != null;
        this.O0000Oo = toolbar.getNavigationIcon();
        Oo O000000o2 = Oo.O000000o(toolbar.getContext(), null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        this.O0000o = O000000o2.O000000o(15);
        if (z) {
            CharSequence O00000o02 = O000000o2.O00000o0(27);
            if (!TextUtils.isEmpty(O00000o02)) {
                O00000Oo(O00000o02);
            }
            CharSequence O00000o03 = O000000o2.O00000o0(25);
            if (!TextUtils.isEmpty(O00000o03)) {
                this.O0000Ooo = O00000o03;
                if ((this.O00000oO & 8) != 0) {
                    this.f2225O000000o.setSubtitle(O00000o03);
                }
            }
            Drawable O000000o3 = O000000o2.O000000o(20);
            if (O000000o3 != null) {
                O00000Oo(O000000o3);
            }
            Drawable O000000o4 = O000000o2.O000000o(17);
            if (O000000o4 != null) {
                O000000o(O000000o4);
            }
            if (this.O0000Oo == null && (drawable = this.O0000o) != null) {
                this.O0000Oo = drawable;
                O0000oOO();
            }
            O00000o0(O000000o2.O000000o(10, 0));
            int O0000O0o2 = O000000o2.O0000O0o(9, 0);
            if (O0000O0o2 != 0) {
                View inflate = LayoutInflater.from(this.f2225O000000o.getContext()).inflate(O0000O0o2, (ViewGroup) this.f2225O000000o, false);
                View view = this.O0000O0o;
                if (!(view == null || (this.O00000oO & 16) == 0)) {
                    this.f2225O000000o.removeView(view);
                }
                this.O0000O0o = inflate;
                if (!(inflate == null || (this.O00000oO & 16) == 0)) {
                    this.f2225O000000o.addView(this.O0000O0o);
                }
                O00000o0(this.O00000oO | 16);
            }
            int O00000oo2 = O000000o2.O00000oo(13, 0);
            if (O00000oo2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2225O000000o.getLayoutParams();
                layoutParams.height = O00000oo2;
                this.f2225O000000o.setLayoutParams(layoutParams);
            }
            int O00000o2 = O000000o2.O00000o(7, -1);
            int O00000o3 = O000000o2.O00000o(3, -1);
            if (O00000o2 >= 0 || O00000o3 >= 0) {
                this.f2225O000000o.setContentInsetsRelative(Math.max(O00000o2, 0), Math.max(O00000o3, 0));
            }
            int O0000O0o3 = O000000o2.O0000O0o(28, 0);
            if (O0000O0o3 != 0) {
                Toolbar toolbar2 = this.f2225O000000o;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), O0000O0o3);
            }
            int O0000O0o4 = O000000o2.O0000O0o(26, 0);
            if (O0000O0o4 != 0) {
                Toolbar toolbar3 = this.f2225O000000o;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), O0000O0o4);
            }
            int O0000O0o5 = O000000o2.O0000O0o(22, 0);
            if (O0000O0o5 != 0) {
                this.f2225O000000o.setPopupTheme(O0000O0o5);
            }
        } else {
            int i = 11;
            if (this.f2225O000000o.getNavigationIcon() != null) {
                this.O0000o = this.f2225O000000o.getNavigationIcon();
                i = 15;
            }
            this.O00000oO = i;
        }
        O000000o2.f12340O000000o.recycle();
        if (R.string.abc_action_bar_up_description != this.O0000o0o) {
            this.O0000o0o = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(this.f2225O000000o.getNavigationContentDescription())) {
                O00000o(this.O0000o0o);
            }
        }
        this.O0000o00 = this.f2225O000000o.getNavigationContentDescription();
        this.f2225O000000o.setNavigationOnClickListener(new View.OnClickListener() {
            /* class _m_j.o0000000.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final OO0O0O f2226O000000o = new OO0O0O(o0000000.this.f2225O000000o.getContext(), o0000000.this.O00000Oo);

            public final void onClick(View view) {
                if (o0000000.this.O00000o0 != null && o0000000.this.O00000o) {
                    o0000000.this.O00000o0.onMenuItemSelected(0, this.f2226O000000o);
                }
            }
        });
    }

    public final ViewGroup O000000o() {
        return this.f2225O000000o;
    }

    public final Context O00000Oo() {
        return this.f2225O000000o.getContext();
    }

    public final boolean O00000o0() {
        return this.f2225O000000o.hasExpandedActionView();
    }

    public final void O00000o() {
        this.f2225O000000o.collapseActionView();
    }

    public final void O000000o(Window.Callback callback) {
        this.O00000o0 = callback;
    }

    public final void O000000o(CharSequence charSequence) {
        if (!this.O0000OoO) {
            O00000o0(charSequence);
        }
    }

    public final CharSequence O00000oO() {
        return this.f2225O000000o.getTitle();
    }

    public final void O00000Oo(CharSequence charSequence) {
        this.O0000OoO = true;
        O00000o0(charSequence);
    }

    private void O00000o0(CharSequence charSequence) {
        this.O00000Oo = charSequence;
        if ((this.O00000oO & 8) != 0) {
            this.f2225O000000o.setTitle(charSequence);
        }
    }

    public final void O00000oo() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void O0000O0o() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void O000000o(Drawable drawable) {
        this.O0000OOo = drawable;
        O0000oO();
    }

    private void O00000Oo(Drawable drawable) {
        this.O0000Oo0 = drawable;
        O0000oO();
    }

    private void O0000oO() {
        Drawable drawable;
        int i = this.O00000oO;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.O0000Oo0;
            if (drawable == null) {
                drawable = this.O0000OOo;
            }
        } else {
            drawable = this.O0000OOo;
        }
        this.f2225O000000o.setLogo(drawable);
    }

    public final boolean O0000OOo() {
        return this.f2225O000000o.canShowOverflowMenu();
    }

    public final boolean O0000Oo0() {
        return this.f2225O000000o.isOverflowMenuShowing();
    }

    public final boolean O0000Oo() {
        return this.f2225O000000o.isOverflowMenuShowPending();
    }

    public final boolean O0000OoO() {
        return this.f2225O000000o.showOverflowMenu();
    }

    public final boolean O0000Ooo() {
        return this.f2225O000000o.hideOverflowMenu();
    }

    public final void O0000o00() {
        this.O00000o = true;
    }

    public final void O000000o(Menu menu, OO0o000.O000000o o000000o) {
        if (this.O0000o0 == null) {
            this.O0000o0 = new ActionMenuPresenter(this.f2225O000000o.getContext());
            this.O0000o0.O0000OOo = R.id.action_menu_presenter;
        }
        this.O0000o0.setCallback(o000000o);
        this.f2225O000000o.setMenu((MenuBuilder) menu, this.O0000o0);
    }

    public final void O0000o0() {
        this.f2225O000000o.dismissPopupMenus();
    }

    public final int O0000o0O() {
        return this.O00000oO;
    }

    public final void O00000o0(int i) {
        View view;
        int i2 = this.O00000oO ^ i;
        this.O00000oO = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    O0000oOo();
                }
                O0000oOO();
            }
            if ((i2 & 3) != 0) {
                O0000oO();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2225O000000o.setTitle(this.O00000Oo);
                    this.f2225O000000o.setSubtitle(this.O0000Ooo);
                } else {
                    this.f2225O000000o.setTitle((CharSequence) null);
                    this.f2225O000000o.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && (view = this.O0000O0o) != null) {
                if ((i & 16) != 0) {
                    this.f2225O000000o.addView(view);
                } else {
                    this.f2225O000000o.removeView(view);
                }
            }
        }
    }

    public final void O000000o(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.O00000oo;
        if (view != null && view.getParent() == (toolbar = this.f2225O000000o)) {
            toolbar.removeView(this.O00000oo);
        }
        this.O00000oo = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.O0000o0O == 2) {
            this.f2225O000000o.addView(this.O00000oo, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.O00000oo.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f2633O000000o = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public final void O000000o(boolean z) {
        this.f2225O000000o.setCollapsible(z);
    }

    public final int O0000o0o() {
        return this.O0000o0O;
    }

    public final ce O000000o(final int i, long j) {
        return cb.O0000o(this.f2225O000000o).O000000o(i == 0 ? 1.0f : 0.0f).O000000o(j).O000000o(new cg() {
            /* class _m_j.o0000000.AnonymousClass2 */
            private boolean O00000o0 = false;

            public final void O000000o(View view) {
                o0000000.this.f2225O000000o.setVisibility(0);
            }

            public final void O00000Oo(View view) {
                if (!this.O00000o0) {
                    o0000000.this.f2225O000000o.setVisibility(i);
                }
            }

            public final void O00000o0(View view) {
                this.O00000o0 = true;
            }
        });
    }

    private void O0000oOO() {
        if ((this.O00000oO & 4) != 0) {
            Toolbar toolbar = this.f2225O000000o;
            Drawable drawable = this.O0000Oo;
            if (drawable == null) {
                drawable = this.O0000o;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f2225O000000o.setNavigationIcon((Drawable) null);
    }

    private void O00000o(CharSequence charSequence) {
        this.O0000o00 = charSequence;
        O0000oOo();
    }

    private void O0000oOo() {
        if ((this.O00000oO & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.O0000o00)) {
            this.f2225O000000o.setNavigationContentDescription(this.O0000o0o);
        } else {
            this.f2225O000000o.setNavigationContentDescription(this.O0000o00);
        }
    }

    public final int O0000o() {
        return this.f2225O000000o.getHeight();
    }

    public final void O00000oO(int i) {
        this.f2225O000000o.setVisibility(i);
    }

    public final void O000000o(OO0o000.O000000o o000000o, MenuBuilder.O000000o o000000o2) {
        this.f2225O000000o.setMenuCallbacks(o000000o, o000000o2);
    }

    public final Menu O0000oO0() {
        return this.f2225O000000o.getMenu();
    }

    public final void O000000o(int i) {
        O000000o(i != 0 ? OO0000o.O00000Oo(this.f2225O000000o.getContext(), i) : null);
    }

    public final void O00000Oo(int i) {
        O00000Oo(i != 0 ? OO0000o.O00000Oo(this.f2225O000000o.getContext(), i) : null);
    }

    public final void O00000o(int i) {
        String str;
        if (i == 0) {
            str = null;
        } else {
            str = this.f2225O000000o.getContext().getString(i);
        }
        O00000o(str);
    }
}
