package com.facebook.react.views.drawer;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.NativeGestureUtil;

class ReactDrawerLayout extends DrawerLayout {
    private int mDrawerPosition = 8388611;
    private int mDrawerWidth = -1;

    public ReactDrawerLayout(ReactContext reactContext) {
        super(reactContext);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (!super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
            return true;
        } catch (IllegalArgumentException e) {
            Log.w("ReactNative", "Error intercepting touch event.", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void openDrawer() {
        openDrawer(this.mDrawerPosition);
    }

    /* access modifiers changed from: package-private */
    public void closeDrawer() {
        closeDrawer(this.mDrawerPosition);
    }

    /* access modifiers changed from: package-private */
    public void setDrawerPosition(int i) {
        this.mDrawerPosition = i;
        setDrawerProperties();
    }

    /* access modifiers changed from: package-private */
    public void setDrawerWidth(int i) {
        this.mDrawerWidth = i;
        setDrawerProperties();
    }

    /* access modifiers changed from: package-private */
    public void setDrawerProperties() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.f2852O000000o = this.mDrawerPosition;
            layoutParams.width = this.mDrawerWidth;
            childAt.setLayoutParams(layoutParams);
            childAt.setClickable(true);
        }
    }
}
