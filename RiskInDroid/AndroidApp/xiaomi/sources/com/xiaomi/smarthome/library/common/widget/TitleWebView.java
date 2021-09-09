package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

public class TitleWebView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f9283O000000o;
    private boolean O00000Oo;

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public TitleWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt != null) {
            i3 = childAt.getMeasuredHeight();
        }
        this.f9283O000000o = i3;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = true;
        if (actionMasked == 0) {
            if (motionEvent.getY() > ((float) O000000o())) {
                z2 = false;
            }
            this.O00000Oo = z2;
        } else if (actionMasked == 1 || actionMasked == 3) {
            z = this.O00000Oo;
            this.O00000Oo = false;
            if ((!this.O00000Oo || z) && (childAt = getChildAt(0)) != null) {
                motionEvent.offsetLocation(0.0f, (float) getScrollY());
                return childAt.dispatchTouchEvent(motionEvent);
            }
            motionEvent.offsetLocation(0.0f, (float) (-this.f9283O000000o));
            return super.dispatchTouchEvent(motionEvent);
        }
        z = false;
        if (!this.O00000Oo) {
        }
        motionEvent.offsetLocation(0.0f, (float) getScrollY());
        return childAt.dispatchTouchEvent(motionEvent);
    }

    private int O000000o() {
        return this.f9283O000000o - getScrollY();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.offsetLeftAndRight(i - childAt.getLeft());
        }
        float contentHeight = (((float) getContentHeight()) * getScale()) - ((float) (getHeight() + getScrollY()));
        if (contentHeight == 0.0f && this.f9283O000000o != 0) {
            System.out.println("WebView滑动到了底端");
            this.f9283O000000o = 0;
        }
        if (contentHeight >= ((float) childAt.getMeasuredHeight()) && this.f9283O000000o == 0) {
            System.out.println("WebView滑动到了底端");
            this.f9283O000000o = childAt.getMeasuredHeight();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.save();
        int O000000o2 = O000000o();
        if (O000000o2 > 0) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            canvas.clipRect(scrollX, O000000o2 + scrollY, getWidth() + scrollX, scrollY + getHeight());
        }
        canvas.translate(0.0f, (float) this.f9283O000000o);
        super.onDraw(canvas);
        canvas.restore();
    }
}
