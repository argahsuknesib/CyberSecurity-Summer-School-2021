package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.hht;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ClipScrollView extends ScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10359O000000o;
    private int O00000Oo;
    private Path O00000o0;

    public ClipScrollView(Context context) {
        this(context, null);
    }

    public ClipScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.clipPath(this.O00000o0);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f10359O000000o != i || this.O00000Oo != i2) {
            this.f10359O000000o = i;
            this.O00000Oo = i2;
            float O000000o2 = (float) hht.O000000o(getContext(), 10.0d);
            this.O00000o0 = new Path();
            this.O00000o0.addRoundRect(new RectF(0.0f, 0.0f, (float) this.f10359O000000o, (float) (this.O00000Oo * 2)), new float[]{O000000o2, O000000o2, O000000o2, O000000o2, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        }
    }
}
