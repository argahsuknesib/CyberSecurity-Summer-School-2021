package com.scwang.smartrefresh.header.internal.pathview;

import _m_j.czj;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class PathsView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    protected czj f5549O000000o;

    public PathsView(Context context) {
        this(context, null);
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5549O000000o = new czj();
        this.f5549O000000o = new czj();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            this.f5549O000000o.O000000o(getTag().toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        czj czj = this.f5549O000000o;
        super.setMeasuredDimension(View.resolveSize(czj.getBounds().width() + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(czj.getBounds().height() + getPaddingTop() + getPaddingBottom(), i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5549O000000o.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i3 - i) - getPaddingRight(), getPaddingLeft()), Math.max((i4 - i2) - getPaddingTop(), getPaddingTop()));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f5549O000000o.draw(canvas);
    }

    public final void O000000o(int... iArr) {
        this.f5549O000000o.O000000o(iArr);
    }
}
