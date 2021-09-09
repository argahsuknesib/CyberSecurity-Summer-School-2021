package com.swmansion.gesturehandler.react;

import _m_j.des;
import android.content.Context;
import android.view.MotionEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.views.view.ReactViewGroup;

public class RNGestureHandlerRootView extends ReactViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    des f5769O000000o;

    public RNGestureHandlerRootView(Context context) {
        super(context);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5769O000000o == null) {
            this.f5769O000000o = new des((ReactContext) getContext(), this);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (((des) Assertions.assertNotNull(this.f5769O000000o)).O000000o(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        ((des) Assertions.assertNotNull(this.f5769O000000o)).O00000Oo();
        super.requestDisallowInterceptTouchEvent(z);
    }
}
