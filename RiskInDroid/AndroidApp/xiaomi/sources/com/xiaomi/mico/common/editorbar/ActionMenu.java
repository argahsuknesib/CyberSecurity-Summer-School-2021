package com.xiaomi.mico.common.editorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.xiaomi.mico.common.editorbar.MenuBuilder;
import com.xiaomi.smarthome.R;
import java.util.List;

public class ActionMenu extends LinearLayout {
    public Finishing mFinishing;
    private Selector mSelector;

    public interface MenuCallback extends MenuBuilder.Callback {
        void onPrepareMenu(MenuBuilder menuBuilder);
    }

    public ActionMenu(Context context) {
        super(context);
    }

    public ActionMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public void setFinishing(Finishing finishing) {
        this.mFinishing = finishing;
    }

    /* access modifiers changed from: package-private */
    public void setSelector(Selector selector) {
        this.mSelector = selector;
    }

    /* access modifiers changed from: package-private */
    public void onCountChange(int i, int i2) {
        updateStatus(i, i2);
    }

    /* access modifiers changed from: package-private */
    public void startAction(final MenuCallback menuCallback) {
        MenuBuilder menuBuilder = new MenuBuilder(getContext(), new MenuBuilder.Callback() {
            /* class com.xiaomi.mico.common.editorbar.ActionMenu.AnonymousClass1 */

            public void onMenuItemClick(MenuBuilder.MenuItem menuItem) {
                menuCallback.onMenuItemClick(menuItem);
                if (ActionMenu.this.mFinishing != null) {
                    ActionMenu.this.mFinishing.finishAction();
                }
            }
        });
        menuCallback.onPrepareMenu(menuBuilder);
        List<MenuBuilder.MenuItem> menuItems = menuBuilder.getMenuItems();
        for (int i = 0; i < menuItems.size(); i++) {
            View menu = menuItems.get(i).getMenu();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            addView(menu, layoutParams);
        }
        updateStatus(this.mSelector.getSelectedCount(), this.mSelector.getTotalCount());
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mico_action_menu_in));
    }

    /* access modifiers changed from: package-private */
    public void finishAction() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.mico_action_menu_out));
    }

    /* access modifiers changed from: package-private */
    public void removeMenus() {
        removeAllViews();
    }

    private void updateStatus(int i, int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).setEnabled(i > 0 && i2 > 0);
        }
    }
}
