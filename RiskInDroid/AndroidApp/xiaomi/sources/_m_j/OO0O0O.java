package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ActionProvider;

public final class OO0O0O implements ai {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f12290O000000o;
    private final int O00000Oo;
    private CharSequence O00000o;
    private final int O00000o0;
    private CharSequence O00000oO;
    private Intent O00000oo;
    private char O0000O0o;
    private int O0000OOo = 4096;
    private int O0000Oo = 4096;
    private char O0000Oo0;
    private Drawable O0000OoO;
    private Context O0000Ooo;
    private PorterDuff.Mode O0000o = null;
    private CharSequence O0000o0;
    private MenuItem.OnMenuItemClickListener O0000o00;
    private CharSequence O0000o0O;
    private ColorStateList O0000o0o = null;
    private boolean O0000oO = false;
    private boolean O0000oO0 = false;
    private int O0000oOO = 16;

    public final ActionProvider O000000o() {
        return null;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean expandActionView() {
        return false;
    }

    public final View getActionView() {
        return null;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final void setShowAsAction(int i) {
    }

    public OO0O0O(Context context, CharSequence charSequence) {
        this.O0000Ooo = context;
        this.f12290O000000o = 16908332;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O00000o = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.O0000Oo0;
    }

    public final int getAlphabeticModifiers() {
        return this.O0000Oo;
    }

    public final int getGroupId() {
        return this.O00000Oo;
    }

    public final Drawable getIcon() {
        return this.O0000OoO;
    }

    public final Intent getIntent() {
        return this.O00000oo;
    }

    public final int getItemId() {
        return this.f12290O000000o;
    }

    public final char getNumericShortcut() {
        return this.O0000O0o;
    }

    public final int getNumericModifiers() {
        return this.O0000OOo;
    }

    public final int getOrder() {
        return this.O00000o0;
    }

    public final CharSequence getTitle() {
        return this.O00000o;
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.O00000oO;
        return charSequence != null ? charSequence : this.O00000o;
    }

    public final boolean isCheckable() {
        return (this.O0000oOO & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.O0000oOO & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.O0000oOO & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.O0000oOO & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        this.O0000Oo0 = Character.toLowerCase(c);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.O0000Oo0 = Character.toLowerCase(c);
        this.O0000Oo = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.O0000oOO = z | (this.O0000oOO & true) ? 1 : 0;
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.O0000oOO = (z ? 2 : 0) | (this.O0000oOO & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.O0000oOO = (z ? 16 : 0) | (this.O0000oOO & -17);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.O0000OoO = drawable;
        O00000Oo();
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.O0000OoO = ContextCompat.O000000o(this.O0000Ooo, i);
        O00000Oo();
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.O00000oo = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        this.O0000O0o = c;
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        this.O0000O0o = c;
        this.O0000OOo = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.O0000o00 = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.O0000O0o = c;
        this.O0000Oo0 = Character.toLowerCase(c2);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.O0000O0o = c;
        this.O0000OOo = KeyEvent.normalizeMetaState(i);
        this.O0000Oo0 = Character.toLowerCase(c2);
        this.O0000Oo = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.O00000o = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.O00000o = this.O0000Ooo.getResources().getString(i);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.O00000oO = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.O0000oOO & 8;
        if (z) {
            i = 0;
        }
        this.O0000oOO = i2 | i;
        return this;
    }

    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final ai O000000o(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final ai O000000o(CharSequence charSequence) {
        this.O0000o0 = charSequence;
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.O0000o0;
    }

    public final ai O00000Oo(CharSequence charSequence) {
        this.O0000o0O = charSequence;
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.O0000o0O;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.O0000o0o = colorStateList;
        this.O0000oO0 = true;
        O00000Oo();
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.O0000o0o;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.O0000o = mode;
        this.O0000oO = true;
        O00000Oo();
        return this;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.O0000o;
    }

    private void O00000Oo() {
        if (this.O0000OoO == null) {
            return;
        }
        if (this.O0000oO0 || this.O0000oO) {
            this.O0000OoO = ab.O00000oo(this.O0000OoO);
            this.O0000OoO = this.O0000OoO.mutate();
            if (this.O0000oO0) {
                ab.O000000o(this.O0000OoO, this.O0000o0o);
            }
            if (this.O0000oO) {
                ab.O000000o(this.O0000OoO, this.O0000o);
            }
        }
    }

    public final /* synthetic */ MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        this.O0000o0O = charSequence;
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        this.O0000o0 = charSequence;
        return this;
    }
}
