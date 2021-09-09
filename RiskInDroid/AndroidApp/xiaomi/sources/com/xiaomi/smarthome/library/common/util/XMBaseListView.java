package com.xiaomi.smarthome.library.common.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class XMBaseListView extends ListView {
    public XMBaseListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public XMBaseListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XMBaseListView(Context context) {
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException | IndexOutOfBoundsException unused) {
            return false;
        }
    }
}
