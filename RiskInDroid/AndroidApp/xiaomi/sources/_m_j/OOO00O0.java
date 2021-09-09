package _m_j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;

public class OOO00O0 extends MenuBuilder implements SubMenu {
    private OO0OOOO mItem;
    private MenuBuilder mParentMenu;

    public OOO00O0(Context context, MenuBuilder menuBuilder, OO0OOOO oo0oooo) {
        super(context);
        this.mParentMenu = menuBuilder;
        this.mItem = oo0oooo;
    }

    public void setQwertyMode(boolean z) {
        this.mParentMenu.setQwertyMode(z);
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public void setShortcutsVisible(boolean z) {
        this.mParentMenu.setShortcutsVisible(z);
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public void setCallback(MenuBuilder.O000000o o000000o) {
        this.mParentMenu.setCallback(o000000o);
    }

    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.dispatchMenuItemSelected(menuBuilder, menuItem) || this.mParentMenu.dispatchMenuItemSelected(menuBuilder, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.mItem.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public boolean expandItemActionView(OO0OOOO oo0oooo) {
        return this.mParentMenu.expandItemActionView(oo0oooo);
    }

    public boolean collapseItemActionView(OO0OOOO oo0oooo) {
        return this.mParentMenu.collapseItemActionView(oo0oooo);
    }

    public String getActionViewStatesKey() {
        OO0OOOO oo0oooo = this.mItem;
        int itemId = oo0oooo != null ? oo0oooo.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    public void setGroupDividerEnabled(boolean z) {
        this.mParentMenu.setGroupDividerEnabled(z);
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }
}
