package _m_j;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.internal.MenuBuilder;
import java.util.Iterator;

public final class egn implements MenuItem {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f15251O000000o;
    public MenuBuilder O00000Oo;
    public ActionProvider O00000o;
    public int O00000o0 = 16;
    public ContextMenu.ContextMenuInfo O00000oO;
    private final int O00000oo;
    private final int O0000O0o;
    private final int O0000OOo;
    private CharSequence O0000Oo;
    private CharSequence O0000Oo0;
    private Intent O0000OoO;
    private char O0000Ooo;
    private Runnable O0000o;
    private Drawable O0000o0;
    private char O0000o00;
    private int O0000o0O = 0;
    private eid O0000o0o;
    private int O0000oO = 0;
    private MenuItem.OnMenuItemClickListener O0000oO0;
    private View O0000oOO;
    private MenuItem.OnActionExpandListener O0000oOo;
    private boolean O0000oo0 = false;

    public egn(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.O00000Oo = menuBuilder;
        this.O00000oo = i2;
        this.O0000O0o = i;
        this.O0000OOo = i3;
        this.f15251O000000o = i4;
        this.O0000Oo0 = charSequence;
        this.O0000oO = i5;
    }

    public final boolean O000000o() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.O0000oO0;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.O00000Oo;
        if (menuBuilder.O000000o(menuBuilder.O00000o0(), this)) {
            return true;
        }
        Runnable runnable = this.O0000o;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.O0000OoO != null) {
            try {
                this.O00000Oo.f6247O000000o.startActivity(this.O0000OoO);
                return true;
            } catch (ActivityNotFoundException e) {
                AccountLog.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        ActionProvider actionProvider = this.O00000o;
        if (actionProvider == null || !actionProvider.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.O00000o0 & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.O00000o0 |= 16;
        } else {
            this.O00000o0 &= -17;
        }
        this.O00000Oo.O000000o(false);
        return this;
    }

    public final int getGroupId() {
        return this.O0000O0o;
    }

    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.O00000oo;
    }

    public final int getOrder() {
        return this.O0000OOo;
    }

    public final Intent getIntent() {
        return this.O0000OoO;
    }

    public final MenuItem setIntent(Intent intent) {
        this.O0000OoO = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.O0000o00;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.O0000o00 == c) {
            return this;
        }
        this.O0000o00 = Character.toLowerCase(c);
        this.O00000Oo.O000000o(false);
        return this;
    }

    public final char getNumericShortcut() {
        return this.O0000Ooo;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.O0000Ooo == c) {
            return this;
        }
        this.O0000Ooo = c;
        this.O00000Oo.O000000o(false);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.O0000Ooo = c;
        this.O0000o00 = Character.toLowerCase(c2);
        this.O00000Oo.O000000o(false);
        return this;
    }

    public final SubMenu getSubMenu() {
        return this.O0000o0o;
    }

    public final boolean hasSubMenu() {
        return this.O0000o0o != null;
    }

    public final void O000000o(eid eid) {
        this.O0000o0o = eid;
        eid.setHeaderTitle(getTitle());
    }

    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.O0000Oo0;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.O0000Oo0 = charSequence;
        this.O00000Oo.O000000o(false);
        eid eid = this.O0000o0o;
        if (eid != null) {
            eid.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.O00000Oo.f6247O000000o.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.O0000Oo;
        return charSequence != null ? charSequence : this.O0000Oo0;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.O0000Oo = charSequence;
        this.O00000Oo.O000000o(false);
        return this;
    }

    public final Drawable getIcon() {
        Drawable drawable = this.O0000o0;
        if (drawable != null) {
            return drawable;
        }
        if (this.O0000o0O == 0) {
            return null;
        }
        Drawable drawable2 = this.O00000Oo.O00000Oo.getDrawable(this.O0000o0O);
        this.O0000o0O = 0;
        this.O0000o0 = drawable2;
        return drawable2;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.O0000o0O = 0;
        this.O0000o0 = drawable;
        this.O00000Oo.O000000o(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.O0000o0 = null;
        this.O0000o0O = i;
        this.O00000Oo.O000000o(false);
        return this;
    }

    public final boolean isCheckable() {
        return (this.O00000o0 & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.O00000o0;
        this.O00000o0 = z | (i & true) ? 1 : 0;
        if (i != this.O00000o0) {
            this.O00000Oo.O000000o(false);
        }
        return this;
    }

    public final boolean isChecked() {
        return (this.O00000o0 & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.O00000o0 & 4) != 0) {
            MenuBuilder menuBuilder = this.O00000Oo;
            int groupId = getGroupId();
            Iterator<egn> it = menuBuilder.O00000o0.iterator();
            while (it.hasNext()) {
                egn next = it.next();
                if (next.getGroupId() == groupId) {
                    boolean z2 = true;
                    if (((next.O00000o0 & 4) != 0) && next.isCheckable()) {
                        if (next != this) {
                            z2 = false;
                        }
                        next.O00000Oo(z2);
                    }
                }
            }
        } else {
            O00000Oo(z);
        }
        return this;
    }

    private void O00000Oo(boolean z) {
        int i = this.O00000o0;
        this.O00000o0 = (z ? 2 : 0) | (i & -3);
        if (i != this.O00000o0) {
            this.O00000Oo.O000000o(false);
        }
    }

    public final boolean isVisible() {
        ActionProvider actionProvider = this.O00000o;
        return (actionProvider == null || !actionProvider.overridesItemVisibility()) ? (this.O00000o0 & 8) == 0 : (this.O00000o0 & 8) == 0 && this.O00000o.isVisible();
    }

    public final boolean O000000o(boolean z) {
        int i = this.O00000o0;
        this.O00000o0 = (z ? 0 : 8) | (i & -9);
        if (i != this.O00000o0) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (O000000o(z)) {
            MenuBuilder menuBuilder = this.O00000Oo;
            menuBuilder.O00000o = true;
            menuBuilder.O000000o(true);
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.O0000oO0 = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.O0000Oo0.toString();
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.O00000oO;
    }

    public final void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            this.O0000oO = i;
            this.O00000Oo.O00000Oo();
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public final MenuItem setActionView(View view) {
        int i;
        this.O0000oOO = view;
        this.O00000o = null;
        if (view != null && view.getId() == -1 && (i = this.O00000oo) > 0) {
            view.setId(i);
        }
        this.O00000Oo.O00000Oo();
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final MenuItem setActionView(int i) {
        Context context = this.O00000Oo.f6247O000000o;
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    public final View getActionView() {
        View view = this.O0000oOO;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.O00000o;
        if (actionProvider == null) {
            return null;
        }
        this.O0000oOO = actionProvider.onCreateActionView(this);
        return this.O0000oOO;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("Implementation should use setSupportActionProvider!");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("Implementation should use getSupportActionProvider!");
    }

    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public final boolean expandActionView() {
        if ((this.O0000oO & 8) == 0 || this.O0000oOO == null) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.O0000oOo;
        return (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) && this.O00000Oo.O000000o(this);
    }

    public final boolean collapseActionView() {
        if ((this.O0000oO & 8) == 0) {
            return false;
        }
        if (this.O0000oOO == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.O0000oOo;
        return (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) && this.O00000Oo.O00000Oo(this);
    }

    public final boolean O00000Oo() {
        return ((this.O0000oO & 8) == 0 || this.O0000oOO == null) ? false : true;
    }

    public final boolean isActionViewExpanded() {
        return this.O0000oo0;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("Implementation should use setSupportOnActionExpandListener!");
    }
}
