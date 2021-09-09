package com.google.android.material.internal;

import _m_j.OO0OOOO;
import _m_j.OOO00O0;
import android.content.Context;
import androidx.appcompat.view.menu.MenuBuilder;

public class NavigationSubMenu extends OOO00O0 {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, OO0OOOO oo0oooo) {
        super(context, navigationMenu, oo0oooo);
    }

    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        ((MenuBuilder) getParentMenu()).onItemsChanged(z);
    }
}
