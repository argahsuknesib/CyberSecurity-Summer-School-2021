package com.xiaomi.mico.common.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class AndroidBug5497Workaround {
    private FrameLayout.LayoutParams frameLayoutParams;
    private View mChildOfContent;
    private int mNavbarHeight = 0;
    private int mStatusbarHeight = 0;
    private int usableHeightPrevious;

    public static void assistActivity(Activity activity) {
        new AndroidBug5497Workaround(activity);
    }

    private AndroidBug5497Workaround(Activity activity) {
        this.mChildOfContent = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.mico.common.util.AndroidBug5497Workaround.AnonymousClass1 */

            public void onGlobalLayout() {
                AndroidBug5497Workaround.this.possiblyResizeChildOfContent();
            }
        });
        this.frameLayoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
        int identifier = this.mChildOfContent.getContext().getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.mNavbarHeight = activity.getResources().getDimensionPixelSize(identifier);
        }
        int identifier2 = this.mChildOfContent.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier2 > 0) {
            this.mStatusbarHeight = activity.getResources().getDimensionPixelSize(identifier2);
        }
    }

    public void possiblyResizeChildOfContent() {
        int computeUsableHeight = computeUsableHeight();
        if (computeUsableHeight != this.usableHeightPrevious) {
            int height = this.mChildOfContent.getRootView().getHeight();
            int i = height - computeUsableHeight;
            if (i > height / 4) {
                this.frameLayoutParams.height = (height - i) + this.mStatusbarHeight;
            } else {
                this.frameLayoutParams.height = this.mStatusbarHeight + computeUsableHeight;
            }
            this.mChildOfContent.requestLayout();
            this.usableHeightPrevious = computeUsableHeight;
        }
    }

    private int computeUsableHeight() {
        Rect rect = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }
}
