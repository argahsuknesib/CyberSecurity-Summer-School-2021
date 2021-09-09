package com.transitionseverywhere.utils;

import _m_j.drl;
import _m_j.drm;
import _m_j.drn;
import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
class ViewOverlayPreJellybean extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Field f5915O000000o = drl.O000000o(View.class, "mParent");
    private List<Drawable> O00000Oo;

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public ViewOverlayPreJellybean(Context context) {
        super(context);
        O000000o();
    }

    public ViewOverlayPreJellybean(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public ViewOverlayPreJellybean(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000Oo = new ArrayList();
    }

    public void addView(View view, int i, int i2) {
        LayoutTransition layoutTransition;
        Field field;
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.getLayoutTransition() != null) {
                layoutTransition = viewGroup.getLayoutTransition();
                viewGroup.setLayoutTransition(null);
            } else {
                layoutTransition = null;
            }
            viewGroup.removeView(view);
            if (layoutTransition != null) {
                viewGroup.setLayoutTransition(layoutTransition);
            }
            if (view.getParent() != null) {
                drm.O000000o(viewGroup);
                if (!(view.getParent() == null || (field = f5915O000000o) == null)) {
                    drl.O000000o(view, field, (Object) null);
                }
            }
            if (view.getParent() != null) {
                return;
            }
        }
        view.setTag(R.id.overlay_layout_params_backup, view.getLayoutParams());
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i3 = i - iArr[0];
        int i4 = i2 - iArr[1];
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i4;
        view.setLeft(i3);
        view.setTop(i4);
        if (view.getMeasuredWidth() != 0) {
            layoutParams.width = view.getMeasuredWidth();
            view.setRight(i3 + layoutParams.width);
        }
        if (view.getMeasuredHeight() != 0) {
            layoutParams.height = view.getMeasuredHeight();
            view.setBottom(i4 + layoutParams.height);
        }
        addView(view, layoutParams);
        invalidate();
    }

    public void removeView(View view) {
        super.removeView(view);
        drn.O000000o(view, (ViewGroup.LayoutParams) view.getTag(R.id.overlay_layout_params_backup));
        view.setTag(R.id.overlay_layout_params_backup, null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Drawable draw : this.O00000Oo) {
            draw.draw(canvas);
        }
    }
}
