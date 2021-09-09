package com.xiaomi.smarthome.library.common.widget;

import _m_j.bo;
import _m_j.br;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class NestedWebView extends WebView implements bo {

    /* renamed from: O000000o  reason: collision with root package name */
    GestureDetector.SimpleOnGestureListener f9228O000000o = new GestureDetector.SimpleOnGestureListener() {
        /* class com.xiaomi.smarthome.library.common.widget.NestedWebView.AnonymousClass1 */

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return motionEvent.getX() >= 1200.0f || motionEvent.getX() <= 80.0f;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            LinearLayout linearLayout = (LinearLayout) NestedWebView.this.getParent();
            int scrollY = (int) ((((float) NestedWebView.this.getScrollY()) - motionEvent.getY()) + motionEvent2.getY());
            if (scrollY > 0 || NestedWebView.this.getHeight() >= linearLayout.getHeight()) {
                return false;
            }
            NestedWebView.this.dispatchNestedScroll(0, 0, 0, scrollY, null);
            return true;
        }
    };
    private br O00000Oo;
    private GestureDetector O00000o0;

    public NestedWebView(Context context) {
        super(context);
        O000000o();
    }

    public NestedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public NestedWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000Oo = new br(this);
        this.O00000o0 = new GestureDetector(getContext(), this.f9228O000000o);
        setNestedScrollingEnabled(true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            startNestedScroll(2);
        } else if (action == 1) {
            stopNestedScroll();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.O00000Oo.O000000o(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.O00000Oo.f13211O000000o;
    }

    public boolean startNestedScroll(int i) {
        return this.O00000Oo.O000000o(i, 0);
    }

    public void stopNestedScroll() {
        this.O00000Oo.O00000Oo(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.O00000Oo.O000000o(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.O00000Oo.O000000o(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.O00000Oo.O000000o(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.O00000Oo.O000000o(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.O00000Oo.O000000o(f, f2);
    }
}
