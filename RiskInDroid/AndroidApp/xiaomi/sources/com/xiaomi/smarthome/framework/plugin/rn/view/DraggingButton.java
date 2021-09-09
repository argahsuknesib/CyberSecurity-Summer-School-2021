package com.xiaomi.smarthome.framework.plugin.rn.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatButton;

public class DraggingButton extends AppCompatButton {
    private int beginX;
    private int beginY;
    private boolean isFirstInit;
    private boolean isFromDragLayout;
    private int lastLayoutBottom;
    private int lastLayoutLeft;
    private int lastLayoutRight;
    private int lastLayoutTop;
    private int lastX;
    private int lastY;
    private int screenHeight;
    private int screenWidth;

    public DraggingButton(Context context) {
        this(context, null);
    }

    public DraggingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DraggingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastX = 0;
        this.lastY = 0;
        this.beginX = 0;
        this.beginY = 0;
        this.screenWidth = 720;
        this.screenHeight = 1280;
        this.isFirstInit = true;
        this.isFromDragLayout = false;
        initData(context);
    }

    private void initData(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.isFirstInit = true;
        this.isFromDragLayout = false;
    }

    public void layout(int i, int i2, int i3, int i4) {
        if (this.isFirstInit) {
            super.layout(i, i2, i3, i4);
        } else if (this.isFromDragLayout) {
            super.layout(i, i2, i3, i4);
        } else {
            super.layout(this.lastLayoutLeft, this.lastLayoutTop, this.lastLayoutRight, this.lastLayoutBottom);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            int i = 0;
            if (action == 1) {
                this.isFromDragLayout = false;
                if (Math.abs(this.lastX - this.beginX) < 10 && Math.abs(this.lastY - this.beginY) < 10) {
                    return super.onTouchEvent(motionEvent);
                }
                setPressed(false);
                return true;
            } else if (action == 2) {
                int rawX = ((int) motionEvent.getRawX()) - this.lastX;
                int rawY = ((int) motionEvent.getRawY()) - this.lastY;
                int left = getLeft() + rawX;
                int top = getTop() + rawY;
                int right = getRight() + rawX;
                int bottom = getBottom() + rawY;
                if (left < 0) {
                    right = getWidth() + 0;
                    left = 0;
                }
                int i2 = this.screenWidth;
                if (right > i2) {
                    left = i2 - getWidth();
                } else {
                    i2 = right;
                }
                if (top < 0) {
                    bottom = getHeight() + 0;
                } else {
                    i = top;
                }
                int i3 = this.screenHeight;
                if (bottom > i3) {
                    i = i3 - getHeight();
                    bottom = i3;
                }
                updateLayoutData(left, i, i2, bottom);
                layout(left, i, i2, bottom);
                this.lastX = (int) motionEvent.getRawX();
                this.lastY = (int) motionEvent.getRawY();
            }
        } else {
            this.lastX = (int) motionEvent.getRawX();
            this.lastY = (int) motionEvent.getRawY();
            this.beginX = this.lastX;
            this.beginY = this.lastY;
            this.isFromDragLayout = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void updateLayoutData(int i, int i2, int i3, int i4) {
        this.isFirstInit = false;
        this.lastLayoutLeft = i;
        this.lastLayoutTop = i2;
        this.lastLayoutRight = i3;
        this.lastLayoutBottom = i4;
    }
}
