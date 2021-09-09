package _m_j;

import _m_j.OO0o00;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ActionProvider;

public final class OO0OOOO implements ai {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f12299O000000o;
    public int O00000Oo = 4096;
    public MenuBuilder O00000o;
    public int O00000o0 = 4096;
    public int O00000oO = 0;
    public ActionProvider O00000oo;
    public ContextMenu.ContextMenuInfo O0000O0o;
    private final int O0000OOo;
    private final int O0000Oo;
    private final int O0000Oo0;
    private CharSequence O0000OoO;
    private CharSequence O0000Ooo;
    private int O0000o = 0;
    private char O0000o0;
    private Intent O0000o00;
    private char O0000o0O;
    private Drawable O0000o0o;
    private Runnable O0000oO;
    private OOO00O0 O0000oO0;
    private MenuItem.OnMenuItemClickListener O0000oOO;
    private CharSequence O0000oOo;
    private ColorStateList O0000oo = null;
    private CharSequence O0000oo0;
    private PorterDuff.Mode O0000ooO = null;
    private boolean O0000ooo = false;
    private int O000O00o = 16;
    private View O000O0OO;
    private MenuItem.OnActionExpandListener O000O0Oo;
    private boolean O00oOoOo = false;
    private boolean O00oOooO = false;
    private boolean O00oOooo = false;

    public OO0OOOO(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.O00000o = menuBuilder;
        this.O0000OOo = i2;
        this.O0000Oo0 = i;
        this.O0000Oo = i3;
        this.f12299O000000o = i4;
        this.O0000OoO = charSequence;
        this.O00000oO = i5;
    }

    public final boolean O00000Oo() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.O0000oOO;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.O00000o;
        if (menuBuilder.dispatchMenuItemSelected(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.O0000oO;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.O0000o00 != null) {
            try {
                this.O00000o.getContext().startActivity(this.O0000o00);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        ActionProvider actionProvider = this.O00000oo;
        if (actionProvider == null || !actionProvider.O00000Oo()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.O000O00o & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.O000O00o |= 16;
        } else {
            this.O000O00o &= -17;
        }
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final int getGroupId() {
        return this.O0000Oo0;
    }

    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.O0000OOo;
    }

    public final int getOrder() {
        return this.O0000Oo;
    }

    public final Intent getIntent() {
        return this.O0000o00;
    }

    public final MenuItem setIntent(Intent intent) {
        this.O0000o00 = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.O0000o0O;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.O0000o0O == c) {
            return this;
        }
        this.O0000o0O = Character.toLowerCase(c);
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.O0000o0O == c && this.O00000o0 == i) {
            return this;
        }
        this.O0000o0O = Character.toLowerCase(c);
        this.O00000o0 = KeyEvent.normalizeMetaState(i);
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final int getAlphabeticModifiers() {
        return this.O00000o0;
    }

    public final char getNumericShortcut() {
        return this.O0000o0;
    }

    public final int getNumericModifiers() {
        return this.O00000Oo;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.O0000o0 == c) {
            return this;
        }
        this.O0000o0 = c;
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.O0000o0 == c && this.O00000Oo == i) {
            return this;
        }
        this.O0000o0 = c;
        this.O00000Oo = KeyEvent.normalizeMetaState(i);
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.O0000o0 = c;
        this.O0000o0O = Character.toLowerCase(c2);
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.O0000o0 = c;
        this.O00000Oo = KeyEvent.normalizeMetaState(i);
        this.O0000o0O = Character.toLowerCase(c2);
        this.O00000o0 = KeyEvent.normalizeMetaState(i2);
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final char O00000o0() {
        return this.O00000o.isQwertyMode() ? this.O0000o0O : this.O0000o0;
    }

    public static void O000000o(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    public final boolean O00000o() {
        return this.O00000o.isShortcutsVisible() && O00000o0() != 0;
    }

    public final SubMenu getSubMenu() {
        return this.O0000oO0;
    }

    public final boolean hasSubMenu() {
        return this.O0000oO0 != null;
    }

    public final void O000000o(OOO00O0 ooo00o0) {
        this.O0000oO0 = ooo00o0;
        ooo00o0.setHeaderTitle(getTitle());
    }

    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.O0000OoO;
    }

    public final CharSequence O000000o(OO0o00.O000000o o000000o) {
        if (o000000o.prefersCondensedTitle()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.O0000OoO = charSequence;
        this.O00000o.onItemsChanged(false);
        OOO00O0 ooo00o0 = this.O0000oO0;
        if (ooo00o0 != null) {
            ooo00o0.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.O00000o.getContext().getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.O0000Ooo;
        if (charSequence == null) {
            charSequence = this.O0000OoO;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.O0000Ooo = charSequence;
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final Drawable getIcon() {
        Drawable drawable = this.O0000o0o;
        if (drawable != null) {
            return O000000o(drawable);
        }
        if (this.O0000o == 0) {
            return null;
        }
        Drawable O00000Oo2 = OO0000o.O00000Oo(this.O00000o.getContext(), this.O0000o);
        this.O0000o = 0;
        this.O0000o0o = O00000Oo2;
        return O000000o(O00000Oo2);
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.O0000o = 0;
        this.O0000o0o = drawable;
        this.O00oOooo = true;
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.O0000o0o = null;
        this.O0000o = i;
        this.O00oOooo = true;
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.O0000oo = colorStateList;
        this.O0000ooo = true;
        this.O00oOooo = true;
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.O0000oo;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.O0000ooO = mode;
        this.O00oOooO = true;
        this.O00oOooo = true;
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.O0000ooO;
    }

    private Drawable O000000o(Drawable drawable) {
        if (drawable != null && this.O00oOooo && (this.O0000ooo || this.O00oOooO)) {
            drawable = ab.O00000oo(drawable).mutate();
            if (this.O0000ooo) {
                ab.O000000o(drawable, this.O0000oo);
            }
            if (this.O00oOooO) {
                ab.O000000o(drawable, this.O0000ooO);
            }
            this.O00oOooo = false;
        }
        return drawable;
    }

    public final boolean isCheckable() {
        return (this.O000O00o & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.O000O00o;
        this.O000O00o = z | (i & true) ? 1 : 0;
        if (i != this.O000O00o) {
            this.O00000o.onItemsChanged(false);
        }
        return this;
    }

    public final void O000000o(boolean z) {
        this.O000O00o = (z ? 4 : 0) | (this.O000O00o & -5);
    }

    public final boolean O00000oO() {
        return (this.O000O00o & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.O000O00o & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.O000O00o & 4) != 0) {
            this.O00000o.setExclusiveItemChecked(this);
        } else {
            O00000Oo(z);
        }
        return this;
    }

    public final void O00000Oo(boolean z) {
        int i = this.O000O00o;
        this.O000O00o = (z ? 2 : 0) | (i & -3);
        if (i != this.O000O00o) {
            this.O00000o.onItemsChanged(false);
        }
    }

    public final boolean isVisible() {
        ActionProvider actionProvider = this.O00000oo;
        return (actionProvider == null || !actionProvider.O00000o()) ? (this.O000O00o & 8) == 0 : (this.O000O00o & 8) == 0 && this.O00000oo.O00000oO();
    }

    public final boolean O00000o0(boolean z) {
        int i = this.O000O00o;
        this.O000O00o = (z ? 0 : 8) | (i & -9);
        if (i != this.O000O00o) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (O00000o0(z)) {
            this.O00000o.onItemVisibleChanged(this);
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.O0000oOO = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.O0000OoO;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.O0000O0o;
    }

    public final boolean O00000oo() {
        return (this.O000O00o & 32) == 32;
    }

    public final boolean O0000O0o() {
        return (this.O00000oO & 1) == 1;
    }

    public final boolean O0000OOo() {
        return (this.O00000oO & 2) == 2;
    }

    public final void O00000o(boolean z) {
        if (z) {
            this.O000O00o |= 32;
        } else {
            this.O000O00o &= -33;
        }
    }

    public final void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            this.O00000oO = i;
            this.O00000o.onItemActionRequestChanged(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ai setActionView(View view) {
        int i;
        this.O000O0OO = view;
        this.O00000oo = null;
        if (view != null && view.getId() == -1 && (i = this.O0000OOo) > 0) {
            view.setId(i);
        }
        this.O00000o.onItemActionRequestChanged(this);
        return this;
    }

    public final View getActionView() {
        View view = this.O000O0OO;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.O00000oo;
        if (actionProvider == null) {
            return null;
        }
        this.O000O0OO = actionProvider.O000000o(this);
        return this.O000O0OO;
    }

    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final ActionProvider O000000o() {
        return this.O00000oo;
    }

    public final ai O000000o(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.O00000oo;
        if (actionProvider2 != null) {
            actionProvider2.O00000oO = null;
            actionProvider2.O00000o = null;
        }
        this.O000O0OO = null;
        this.O00000oo = actionProvider;
        this.O00000o.onItemsChanged(true);
        ActionProvider actionProvider3 = this.O00000oo;
        if (actionProvider3 != null) {
            actionProvider3.O000000o(new ActionProvider.O00000Oo() {
                /* class _m_j.OO0OOOO.AnonymousClass1 */

                public final void O000000o() {
                    OO0OOOO.this.O00000o.onItemVisibleChanged(OO0OOOO.this);
                }
            });
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!O0000Oo0()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.O000O0Oo;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.O00000o.expandItemActionView(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.O00000oO & 8) == 0) {
            return false;
        }
        if (this.O000O0OO == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.O000O0Oo;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.O00000o.collapseItemActionView(this);
        }
        return false;
    }

    public final boolean O0000Oo0() {
        ActionProvider actionProvider;
        if ((this.O00000oO & 8) != 0) {
            if (this.O000O0OO == null && (actionProvider = this.O00000oo) != null) {
                this.O000O0OO = actionProvider.O000000o(this);
            }
            if (this.O000O0OO != null) {
                return true;
            }
        }
        return false;
    }

    public final void O00000oO(boolean z) {
        this.O00oOoOo = z;
        this.O00000o.onItemsChanged(false);
    }

    public final boolean isActionViewExpanded() {
        return this.O00oOoOo;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.O000O0Oo = onActionExpandListener;
        return this;
    }

    /* renamed from: O000000o */
    public final ai setContentDescription(CharSequence charSequence) {
        this.O0000oOo = charSequence;
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.O0000oOo;
    }

    /* renamed from: O00000Oo */
    public final ai setTooltipText(CharSequence charSequence) {
        this.O0000oo0 = charSequence;
        this.O00000o.onItemsChanged(false);
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.O0000oo0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ MenuItem setActionView(int i) {
        Context context = this.O00000o.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }
}
