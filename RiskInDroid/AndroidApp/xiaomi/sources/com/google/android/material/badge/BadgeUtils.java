package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;
import com.xiaomi.smarthome.R;

@ExperimentalBadgeUtils
public class BadgeUtils {
    public static final boolean USE_COMPAT_PARENT = (Build.VERSION.SDK_INT < 18);

    private BadgeUtils() {
    }

    public static void updateBadgeBounds(Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, View view) {
        attachBadgeDrawable(badgeDrawable, view, (FrameLayout) null);
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        setBadgeDrawableBounds(badgeDrawable, view, frameLayout);
        if (badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
        } else if (!USE_COMPAT_PARENT) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, Toolbar toolbar, int i) {
        attachBadgeDrawable(badgeDrawable, toolbar, i, null);
    }

    public static void attachBadgeDrawable(final BadgeDrawable badgeDrawable, final Toolbar toolbar, final int i, final FrameLayout frameLayout) {
        toolbar.post(new Runnable() {
            /* class com.google.android.material.badge.BadgeUtils.AnonymousClass1 */

            public final void run() {
                ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(toolbar, i);
                if (actionMenuItemView != null) {
                    BadgeDrawable badgeDrawable = badgeDrawable;
                    badgeDrawable.setHorizontalOffset(badgeDrawable.getHorizontalOffset() + toolbar.getResources().getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
                    BadgeDrawable badgeDrawable2 = badgeDrawable;
                    badgeDrawable2.setVerticalOffset(badgeDrawable2.getVerticalOffset() + toolbar.getResources().getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
                    BadgeUtils.attachBadgeDrawable(badgeDrawable, actionMenuItemView, frameLayout);
                }
            }
        });
    }

    public static void detachBadgeDrawable(BadgeDrawable badgeDrawable, View view) {
        if (badgeDrawable != null) {
            if (USE_COMPAT_PARENT || badgeDrawable.getCustomBadgeParent() != null) {
                badgeDrawable.getCustomBadgeParent().setForeground(null);
            } else {
                view.getOverlay().remove(badgeDrawable);
            }
        }
    }

    public static void detachBadgeDrawable(BadgeDrawable badgeDrawable, Toolbar toolbar, int i) {
        if (badgeDrawable != null) {
            ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(toolbar, i);
            if (actionMenuItemView != null) {
                detachBadgeDrawable(badgeDrawable, actionMenuItemView);
            } else {
                Log.w("BadgeUtils", "Trying to remove badge from a null menuItemView: ".concat(String.valueOf(i)));
            }
        }
    }

    public static void setBadgeDrawableBounds(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.updateBadgeCoordinates(view, frameLayout);
    }

    public static ParcelableSparseArray createParcelableBadgeStates(SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        int i = 0;
        while (i < sparseArray.size()) {
            int keyAt = sparseArray.keyAt(i);
            BadgeDrawable valueAt = sparseArray.valueAt(i);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.getSavedState());
                i++;
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        int i = 0;
        while (i < parcelableSparseArray.size()) {
            int keyAt = parcelableSparseArray.keyAt(i);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i);
            if (savedState != null) {
                sparseArray.put(keyAt, BadgeDrawable.createFromSavedState(context, savedState));
                i++;
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }
}
