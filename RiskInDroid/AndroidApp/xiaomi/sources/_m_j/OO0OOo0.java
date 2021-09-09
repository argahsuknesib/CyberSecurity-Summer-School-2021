package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

public final class OO0OOo0 extends OO0O0OO implements MenuItem {
    public final ai O00000o;
    public Method O00000oO;

    public OO0OOo0(Context context, ai aiVar) {
        super(context);
        if (aiVar != null) {
            this.O00000o = aiVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public final int getItemId() {
        return this.O00000o.getItemId();
    }

    public final int getGroupId() {
        return this.O00000o.getGroupId();
    }

    public final int getOrder() {
        return this.O00000o.getOrder();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.O00000o.setTitle(charSequence);
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.O00000o.setTitle(i);
        return this;
    }

    public final CharSequence getTitle() {
        return this.O00000o.getTitle();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.O00000o.setTitleCondensed(charSequence);
        return this;
    }

    public final CharSequence getTitleCondensed() {
        return this.O00000o.getTitleCondensed();
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.O00000o.setIcon(drawable);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.O00000o.setIcon(i);
        return this;
    }

    public final Drawable getIcon() {
        return this.O00000o.getIcon();
    }

    public final MenuItem setIntent(Intent intent) {
        this.O00000o.setIntent(intent);
        return this;
    }

    public final Intent getIntent() {
        return this.O00000o.getIntent();
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.O00000o.setShortcut(c, c2);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.O00000o.setShortcut(c, c2, i, i2);
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        this.O00000o.setNumericShortcut(c);
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        this.O00000o.setNumericShortcut(c, i);
        return this;
    }

    public final char getNumericShortcut() {
        return this.O00000o.getNumericShortcut();
    }

    public final int getNumericModifiers() {
        return this.O00000o.getNumericModifiers();
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        this.O00000o.setAlphabeticShortcut(c);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.O00000o.setAlphabeticShortcut(c, i);
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.O00000o.getAlphabeticShortcut();
    }

    public final int getAlphabeticModifiers() {
        return this.O00000o.getAlphabeticModifiers();
    }

    public final MenuItem setCheckable(boolean z) {
        this.O00000o.setCheckable(z);
        return this;
    }

    public final boolean isCheckable() {
        return this.O00000o.isCheckable();
    }

    public final MenuItem setChecked(boolean z) {
        this.O00000o.setChecked(z);
        return this;
    }

    public final boolean isChecked() {
        return this.O00000o.isChecked();
    }

    public final MenuItem setVisible(boolean z) {
        return this.O00000o.setVisible(z);
    }

    public final boolean isVisible() {
        return this.O00000o.isVisible();
    }

    public final MenuItem setEnabled(boolean z) {
        this.O00000o.setEnabled(z);
        return this;
    }

    public final boolean isEnabled() {
        return this.O00000o.isEnabled();
    }

    public final boolean hasSubMenu() {
        return this.O00000o.hasSubMenu();
    }

    public final SubMenu getSubMenu() {
        return O000000o(this.O00000o.getSubMenu());
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.O00000o.setOnMenuItemClickListener(onMenuItemClickListener != null ? new O0000O0o(onMenuItemClickListener) : null);
        return this;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.O00000o.getMenuInfo();
    }

    public final void setShowAsAction(int i) {
        this.O00000o.setShowAsAction(i);
    }

    public final MenuItem setShowAsActionFlags(int i) {
        this.O00000o.setShowAsActionFlags(i);
        return this;
    }

    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new O00000o0(view);
        }
        this.O00000o.setActionView(view);
        return this;
    }

    public final MenuItem setActionView(int i) {
        this.O00000o.setActionView(i);
        View actionView = this.O00000o.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.O00000o.setActionView(new O00000o0(actionView));
        }
        return this;
    }

    public final View getActionView() {
        View actionView = this.O00000o.getActionView();
        return actionView instanceof O00000o0 ? (View) ((O00000o0) actionView).f12303O000000o : actionView;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.view.ActionProvider actionProvider2;
        if (Build.VERSION.SDK_INT >= 16) {
            actionProvider2 = new O00000Oo(this.f12291O000000o, actionProvider);
        } else {
            actionProvider2 = new O000000o(this.f12291O000000o, actionProvider);
        }
        ai aiVar = this.O00000o;
        if (actionProvider == null) {
            actionProvider2 = null;
        }
        aiVar.O000000o(actionProvider2);
        return this;
    }

    public final ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider O000000o2 = this.O00000o.O000000o();
        if (O000000o2 instanceof O000000o) {
            return ((O000000o) O000000o2).f12301O000000o;
        }
        return null;
    }

    public final boolean expandActionView() {
        return this.O00000o.expandActionView();
    }

    public final boolean collapseActionView() {
        return this.O00000o.collapseActionView();
    }

    public final boolean isActionViewExpanded() {
        return this.O00000o.isActionViewExpanded();
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.O00000o.setOnActionExpandListener(onActionExpandListener != null ? new O00000o(onActionExpandListener) : null);
        return this;
    }

    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.O00000o.O000000o(charSequence);
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.O00000o.getContentDescription();
    }

    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.O00000o.O00000Oo(charSequence);
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.O00000o.getTooltipText();
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.O00000o.setIconTintList(colorStateList);
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.O00000o.getIconTintList();
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.O00000o.setIconTintMode(mode);
        return this;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.O00000o.getIconTintMode();
    }

    class O0000O0o implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener O00000Oo;

        O0000O0o(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.O00000Oo = onMenuItemClickListener;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return this.O00000Oo.onMenuItemClick(OO0OOo0.this.O000000o(menuItem));
        }
    }

    class O00000o implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener O00000Oo;

        O00000o(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.O00000Oo = onActionExpandListener;
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.O00000Oo.onMenuItemActionExpand(OO0OOo0.this.O000000o(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.O00000Oo.onMenuItemActionCollapse(OO0OOo0.this.O000000o(menuItem));
        }
    }

    class O000000o extends androidx.core.view.ActionProvider {

        /* renamed from: O000000o  reason: collision with root package name */
        final ActionProvider f12301O000000o;

        O000000o(Context context, ActionProvider actionProvider) {
            super(context);
            this.f12301O000000o = actionProvider;
        }

        public final View O000000o() {
            return this.f12301O000000o.onCreateActionView();
        }

        public final boolean O00000Oo() {
            return this.f12301O000000o.onPerformDefaultAction();
        }

        public final boolean O00000o0() {
            return this.f12301O000000o.hasSubMenu();
        }

        public final void O000000o(SubMenu subMenu) {
            this.f12301O000000o.onPrepareSubMenu(OO0OOo0.this.O000000o(subMenu));
        }
    }

    class O00000Oo extends O000000o implements ActionProvider.VisibilityListener {
        private ActionProvider.O00000Oo O00000oo;

        O00000Oo(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public final View O000000o(MenuItem menuItem) {
            return this.f12301O000000o.onCreateActionView(menuItem);
        }

        public final boolean O00000o() {
            return this.f12301O000000o.overridesItemVisibility();
        }

        public final boolean O00000oO() {
            return this.f12301O000000o.isVisible();
        }

        public final void O000000o(ActionProvider.O00000Oo o00000Oo) {
            this.O00000oo = o00000Oo;
            this.f12301O000000o.setVisibilityListener(this);
        }

        public final void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.O00000Oo o00000Oo = this.O00000oo;
            if (o00000Oo != null) {
                o00000Oo.O000000o();
            }
        }
    }

    static class O00000o0 extends FrameLayout implements OO00O {

        /* renamed from: O000000o  reason: collision with root package name */
        final CollapsibleActionView f12303O000000o;

        O00000o0(View view) {
            super(view.getContext());
            this.f12303O000000o = (CollapsibleActionView) view;
            addView(view);
        }

        public final void O000000o() {
            this.f12303O000000o.onActionViewExpanded();
        }

        public final void O00000Oo() {
            this.f12303O000000o.onActionViewCollapsed();
        }
    }
}
