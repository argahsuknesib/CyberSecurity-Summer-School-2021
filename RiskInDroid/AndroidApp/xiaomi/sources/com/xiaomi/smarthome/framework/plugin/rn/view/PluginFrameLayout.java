package com.xiaomi.smarthome.framework.plugin.rn.view;

import _m_j.hyy;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.xiaomi.smarthome.library.common.widget.CardFrameLayout;

public class PluginFrameLayout extends CardFrameLayout implements ReactPointerEventsView {
    public final FrameLayout.LayoutParams O000000o(FrameLayout.LayoutParams layoutParams) {
        return layoutParams;
    }

    public PluginFrameLayout(Context context) {
        super(context);
    }

    public void requestLayout() {
        int i;
        int i2;
        super.requestLayout();
        try {
            View view = (View) getParent();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                DisplayMetrics O00000Oo = hyy.O00000Oo(getContext() instanceof Activity ? ((Activity) getContext()).getIntent() : null);
                i = O00000Oo.widthPixels;
                i2 = O00000Oo.heightPixels;
            } else {
                i = view.getWidth();
                i2 = view.getHeight();
            }
            measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
            layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } catch (Exception unused) {
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        requestLayout();
    }

    public PointerEvents getPointerEvents() {
        if (getVisibility() == 0) {
            return PointerEvents.BOX_NONE;
        }
        return PointerEvents.NONE;
    }
}
