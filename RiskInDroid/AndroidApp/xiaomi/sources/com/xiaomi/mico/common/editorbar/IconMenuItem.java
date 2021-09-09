package com.xiaomi.mico.common.editorbar;

import android.content.Context;
import android.view.View;
import com.xiaomi.mico.common.editorbar.MenuBuilder;
import com.xiaomi.mico.common.widget.IconMenu;

class IconMenuItem implements MenuBuilder.MenuItem {
    private int mId;
    private IconMenu mMenu;

    IconMenuItem(Context context, int i, int i2, String str) {
        this.mId = i;
        this.mMenu = new IconMenu(context);
        this.mMenu.setIcon(i2);
        this.mMenu.setText(str);
    }

    public int getId() {
        return this.mId;
    }

    public View getMenu() {
        return this.mMenu;
    }
}
