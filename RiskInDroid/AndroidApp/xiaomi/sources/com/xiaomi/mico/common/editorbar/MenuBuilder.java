package com.xiaomi.mico.common.editorbar;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuBuilder {
    public Callback mCallback;
    private Context mContext;
    private List<MenuItem> mMenuItems = new ArrayList();

    interface Callback {
        void onMenuItemClick(MenuItem menuItem);
    }

    public interface MenuItem {
        int getId();

        View getMenu();
    }

    MenuBuilder(Context context, Callback callback) {
        this.mContext = context;
        this.mCallback = callback;
    }

    /* access modifiers changed from: package-private */
    public List<MenuItem> getMenuItems() {
        return this.mMenuItems;
    }

    public MenuBuilder add(int i, int i2, String str) {
        final IconMenuItem iconMenuItem = new IconMenuItem(this.mContext, i, i2, str);
        iconMenuItem.getMenu().setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.editorbar.MenuBuilder.AnonymousClass1 */

            public void onClick(View view) {
                if (MenuBuilder.this.mCallback != null) {
                    MenuBuilder.this.mCallback.onMenuItemClick(iconMenuItem);
                }
            }
        });
        this.mMenuItems.add(iconMenuItem);
        return this;
    }

    public MenuBuilder remove(int i) {
        Iterator<MenuItem> it = this.mMenuItems.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getId() == i) {
                    it.remove();
                    break;
                }
            } else {
                break;
            }
        }
        return this;
    }
}
