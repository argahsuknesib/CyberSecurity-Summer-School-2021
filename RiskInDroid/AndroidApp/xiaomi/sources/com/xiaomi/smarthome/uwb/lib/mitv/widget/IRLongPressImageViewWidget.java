package com.xiaomi.smarthome.uwb.lib.mitv.widget;

import _m_j.bh;
import _m_j.cb;
import _m_j.gsy;
import _m_j.hzf;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public abstract class IRLongPressImageViewWidget extends ImageView {
    private GestureDetector mGestureDetector;
    public Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.uwb.lib.mitv.widget.IRLongPressImageViewWidget.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message.what == 100) {
                gsy.O000000o(4, "IRLongPressWidget", "longPress, handler msg");
                if (!IRLongPressImageViewWidget.this.mUpPressed) {
                    IRLongPressImageViewWidget.this.onActionExecute(true);
                    Message obtain = Message.obtain();
                    obtain.what = 100;
                    IRLongPressImageViewWidget.this.mHandler.sendMessageDelayed(obtain, (long) IRLongPressImageViewWidget.this.mPressInterval);
                } else if (IRLongPressImageViewWidget.this.isLongClickable()) {
                    IRLongPressImageViewWidget.this.performLongClick();
                }
            }
        }
    };
    private boolean mIsLongClickable = true;
    private IRVolChOnGestureListener mOnGestureListener = new IRVolChOnGestureListener();
    public int mPressInterval = 300;
    public boolean mUpPressed = true;

    /* access modifiers changed from: protected */
    public void onActionDown() {
    }

    /* access modifiers changed from: protected */
    public abstract void onActionExecute(boolean z);

    /* access modifiers changed from: protected */
    public void onActionUp() {
    }

    public IRLongPressImageViewWidget(Context context) {
        super(context);
        init();
    }

    public IRLongPressImageViewWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mGestureDetector = new GestureDetector(getContext(), this.mOnGestureListener);
        setClickable(true);
        if (Build.VERSION.SDK_INT == 26) {
            cb.O000000o(this, new bh() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.widget.IRLongPressImageViewWidget.AnonymousClass2 */

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    if (accessibilityEvent.getEventType() != 1) {
                        return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                    }
                    gsy.O000000o(3, "IRLongPressWidget", "accessibility event clicked");
                    IRLongPressImageViewWidget.this.onActionExecute(false);
                    IRLongPressImageViewWidget.this.stopPress();
                    return true;
                }
            });
        }
    }

    public void setIrLongClickable(boolean z) {
        this.mIsLongClickable = z;
        if (!z) {
            this.mUpPressed = true;
        }
    }

    public void setPressInterval(int i) {
        this.mPressInterval = i;
    }

    public void onCancel() {
        setPressed(false);
        this.mUpPressed = true;
        this.mHandler.removeMessages(100);
    }

    public void startPress() {
        hzf.O00000o(this);
        setPressed(true);
        if (this.mIsLongClickable) {
            this.mUpPressed = false;
        }
        Message obtain = Message.obtain();
        obtain.what = 100;
        this.mHandler.sendMessageDelayed(obtain, 700);
        onActionDown();
    }

    public void stopPress() {
        setPressed(false);
        this.mHandler.removeMessages(100);
        onActionUp();
        this.mUpPressed = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (isClickable()) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1 || action == 3) {
            stopPress();
        }
        return super.onTouchEvent(motionEvent);
    }

    class IRVolChOnGestureListener implements GestureDetector.OnGestureListener {
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        private IRVolChOnGestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            gsy.O000000o(6, "IRLongPressWidget", "OnGestureListener onDown");
            IRLongPressImageViewWidget.this.startPress();
            return false;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            gsy.O000000o(6, "IRLongPressWidget", "onSingleTapUp");
            IRLongPressImageViewWidget.this.onActionExecute(false);
            return false;
        }
    }
}
