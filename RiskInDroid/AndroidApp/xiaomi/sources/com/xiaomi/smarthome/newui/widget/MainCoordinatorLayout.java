package com.xiaomi.smarthome.newui.widget;

import _m_j.gpc;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.xiaomi.smarthome.R;

public class MainCoordinatorLayout extends CoordinatorLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f10314O000000o = gpc.O000000o(10.0f);

    public MainCoordinatorLayout(Context context) {
        super(context);
    }

    public MainCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        ViewGroup viewGroup;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        View findViewById = findViewById(R.id.top_indicator);
        int i = this.f10314O000000o;
        Rect rect = null;
        if (!(findViewById == null || (viewGroup = (ViewGroup) findViewById.getParent()) == null || viewGroup.getWidth() * viewGroup.getHeight() == 0)) {
            int width = findViewById.getWidth();
            int height = findViewById.getHeight();
            if (width * height != 0) {
                int[] iArr = new int[2];
                float[] fArr = {(float) iArr[0], (float) iArr[1]};
                findViewById.getMatrix().mapPoints(fArr);
                findViewById.getScaleX();
                fArr[0] = fArr[0] + ((float) findViewById.getLeft());
                fArr[1] = fArr[1] + ((float) findViewById.getTop());
                ViewParent parent = findViewById.getParent();
                while ((parent instanceof View) && parent != viewGroup) {
                    View view = (View) parent;
                    view.getMatrix().mapPoints(fArr);
                    view.getScaleX();
                    fArr[0] = fArr[0] + ((float) (view.getLeft() - view.getScrollX()));
                    fArr[1] = fArr[1] + ((float) (view.getTop() - view.getScrollY()));
                    parent = view.getParent();
                }
                iArr[0] = Math.round(fArr[0]);
                iArr[1] = Math.round(fArr[1]);
                rect = new Rect(iArr[0] - 0, iArr[1] - i, iArr[0] + width + 0, iArr[1] + height + i);
            }
        }
        if (rect == null || !rect.contains((int) obtain.getX(), (int) obtain.getY())) {
            z = false;
        } else {
            obtain.setLocation(obtain.getX(), ((float) findViewById.getHeight()) / 2.0f);
            z = findViewById.dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        return z || super.dispatchTouchEvent(motionEvent);
    }
}
