package com.google.android.material.internal;

import _m_j.OO0OOOO;
import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;

public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        OO0OOOO oo0oooo = (OO0OOOO) addInternal(i, i2, i3, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(getContext(), this, oo0oooo);
        oo0oooo.O000000o(navigationSubMenu);
        return navigationSubMenu;
    }
}
