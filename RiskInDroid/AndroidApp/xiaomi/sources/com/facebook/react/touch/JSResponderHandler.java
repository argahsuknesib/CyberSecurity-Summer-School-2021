package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;

public class JSResponderHandler implements OnInterceptTouchEventListener {
    private volatile int mCurrentJSResponder = -1;
    private ViewParent mViewParentBlockingNativeResponder;

    public void setJSResponder(int i, ViewParent viewParent) {
        this.mCurrentJSResponder = i;
        maybeUnblockNativeResponder();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
            this.mViewParentBlockingNativeResponder = viewParent;
        }
    }

    public void clearJSResponder() {
        this.mCurrentJSResponder = -1;
        maybeUnblockNativeResponder();
    }

    private void maybeUnblockNativeResponder() {
        ViewParent viewParent = this.mViewParentBlockingNativeResponder;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
            this.mViewParentBlockingNativeResponder = null;
        }
    }

    public boolean onInterceptTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent) {
        int i = this.mCurrentJSResponder;
        if (i == -1 || motionEvent.getAction() == 1 || viewGroup.getId() != i) {
            return false;
        }
        return true;
    }
}
