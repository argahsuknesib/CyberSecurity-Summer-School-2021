package com.zhy.view.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

public class TagView extends FrameLayout implements Checkable {
    private static final int[] O00000Oo = {16842912};

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f12252O000000o;

    public TagView(Context context) {
        super(context);
    }

    public View getTagView() {
        return getChildAt(0);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, O00000Oo);
        }
        return onCreateDrawableState;
    }

    public void setChecked(boolean z) {
        if (this.f12252O000000o != z) {
            this.f12252O000000o = z;
            refreshDrawableState();
        }
    }

    public boolean isChecked() {
        return this.f12252O000000o;
    }

    public void toggle() {
        setChecked(!this.f12252O000000o);
    }
}
