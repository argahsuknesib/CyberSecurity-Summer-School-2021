package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class DevicePtrFrameLayout extends PtrFrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f9173O000000o = false;

    public DevicePtrFrameLayout(Context context) {
        super(context);
    }

    public DevicePtrFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DevicePtrFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.f9173O000000o = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f9173O000000o) {
            return dispatchTouchEventSupper(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
