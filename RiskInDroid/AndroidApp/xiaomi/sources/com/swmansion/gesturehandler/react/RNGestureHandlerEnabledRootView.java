package com.swmansion.gesturehandler.react;

import _m_j.des;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

public class RNGestureHandlerEnabledRootView extends ReactRootView {

    /* renamed from: O000000o  reason: collision with root package name */
    ReactInstanceManager f5766O000000o;
    des O00000Oo;

    public RNGestureHandlerEnabledRootView(Context context) {
        super(context);
    }

    public RNGestureHandlerEnabledRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        des des = this.O00000Oo;
        if (des != null) {
            des.O00000Oo();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        des des = this.O00000Oo;
        if (des == null || !des.O000000o(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        super.startReactApplication(reactInstanceManager, str, bundle);
        this.f5766O000000o = reactInstanceManager;
    }
}
