package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class DragSlideView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    DragSlideHorizontalView f9176O000000o;

    public DragSlideView(Context context) {
        super(context);
    }

    public DragSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DragSlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDragSlideHorizontalView(DragSlideHorizontalView dragSlideHorizontalView) {
        this.f9176O000000o = dragSlideHorizontalView;
    }

    public DragSlideHorizontalView getView() {
        return this.f9176O000000o;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setAboveView(View view) {
        DragSlideHorizontalView dragSlideHorizontalView = this.f9176O000000o;
        if (dragSlideHorizontalView != null) {
            dragSlideHorizontalView.setAboveView(view);
        }
    }

    public void setBehindView(View view) {
        DragSlideHorizontalView dragSlideHorizontalView = this.f9176O000000o;
        if (dragSlideHorizontalView != null) {
            dragSlideHorizontalView.setBehindView(view);
        }
    }

    public final boolean O000000o() {
        DragSlideHorizontalView dragSlideHorizontalView = this.f9176O000000o;
        return dragSlideHorizontalView != null && dragSlideHorizontalView.f9175O000000o;
    }

    public final void O00000Oo() {
        DragSlideHorizontalView dragSlideHorizontalView = this.f9176O000000o;
        if (dragSlideHorizontalView != null) {
            dragSlideHorizontalView.O000000o();
        }
    }
}
