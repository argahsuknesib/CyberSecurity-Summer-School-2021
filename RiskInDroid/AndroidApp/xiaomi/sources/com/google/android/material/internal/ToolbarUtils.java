package com.google.android.material.internal;

import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

public class ToolbarUtils {
    private ToolbarUtils() {
    }

    public static View getSecondaryActionMenuItemView(Toolbar toolbar) {
        ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null || actionMenuView.getChildCount() <= 1) {
            return null;
        }
        return actionMenuView.getChildAt(0);
    }

    public static ActionMenuView getActionMenuView(Toolbar toolbar) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View childAt = toolbar.getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public static ImageButton getNavigationIconButton(Toolbar toolbar) {
        if (toolbar.getChildCount() <= 0) {
            return null;
        }
        View childAt = toolbar.getChildAt(0);
        if (childAt instanceof ImageButton) {
            return (ImageButton) childAt;
        }
        return null;
    }

    public static ActionMenuItemView getActionMenuItemView(Toolbar toolbar, int i) {
        ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null) {
            return null;
        }
        for (int i2 = 0; i2 < actionMenuView.getChildCount(); i2++) {
            View childAt = actionMenuView.getChildAt(i2);
            if (childAt instanceof ActionMenuItemView) {
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i) {
                    return actionMenuItemView;
                }
            }
        }
        return null;
    }
}
