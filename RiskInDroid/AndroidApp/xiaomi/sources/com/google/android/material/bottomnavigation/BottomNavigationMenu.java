package com.google.android.material.bottomnavigation;

import _m_j.OO0OOOO;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;

public final class BottomNavigationMenu extends MenuBuilder {
    public BottomNavigationMenu(Context context) {
        super(context);
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    public final MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 <= 5) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i, i2, i3, charSequence);
            if (addInternal instanceof OO0OOOO) {
                ((OO0OOOO) addInternal).O000000o(true);
            }
            startDispatchingItemsChanged();
            return addInternal;
        }
        throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }
}
