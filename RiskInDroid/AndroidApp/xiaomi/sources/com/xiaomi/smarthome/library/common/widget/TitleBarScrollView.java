package com.xiaomi.smarthome.library.common.widget;

import _m_j.bs;
import _m_j.bv;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;

public class TitleBarScrollView extends ScrollView implements bs {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f9282O000000o = 0;
    private int O00000Oo = 0;
    private View O00000o;
    private WebView O00000o0;
    private boolean O00000oO = true;
    private bv O00000oo = new bv();

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return !z;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
    }

    public TitleBarScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TitleBarScrollView(Context context) {
        super(context);
    }

    public void setTitleBar(View view) {
        this.O00000o = view;
    }

    public void setWebView(WebView webView) {
        this.O00000o0 = webView;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        scrollTo(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        scrollTo(0, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r0 != 3) goto L_0x002d;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.f9282O000000o == 0) {
                this.f9282O000000o = this.O00000o.getHeight();
            }
            if (this.O00000Oo == 0) {
                this.O00000Oo = this.O00000o0.getHeight();
            }
        } else if (action != 1) {
        }
        if (this.O00000oO) {
            this.O00000oO = false;
            return true;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.O00000oo.O000000o(i, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        super.setNestedScrollingEnabled(z);
    }
}
