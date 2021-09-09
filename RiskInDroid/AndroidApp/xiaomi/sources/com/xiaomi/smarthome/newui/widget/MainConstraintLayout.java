package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayoutSpringBehavior;
import com.xiaomi.smarthome.R;

public class MainConstraintLayout extends ConstraintLayout implements AppBarLayoutSpringBehavior.PullToRefreshCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10313O000000o = 0;
    private ConstraintLayout O00000Oo = null;

    public void onComplete() {
    }

    public void onDrag(int i, boolean z) {
    }

    public void onRefresh() {
    }

    public MainConstraintLayout(Context context) {
        super(context);
        O000000o();
    }

    public MainConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public MainConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000Oo = (ConstraintLayout) findViewById(R.id.title_bar_content);
    }

    public void onOffsetChanged(int i) {
        this.O00000Oo.setPadding(0, i, 0, 0);
    }
}
