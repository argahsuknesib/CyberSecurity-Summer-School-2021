package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.gpc;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ExpandRoomMenu extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private Path f10367O000000o;
    private RectF O00000Oo;
    private float O00000o;
    private Paint O00000o0;

    public ExpandRoomMenu(Context context) {
        this(context, null);
    }

    public ExpandRoomMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandRoomMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10367O000000o = new Path();
        this.O00000Oo = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.O00000o0 = new Paint(1);
        this.O00000o0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.O00000o = (float) gpc.O00000o0(context, 10.0f);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O00000Oo.set(0.0f, 0.0f, (float) i, (float) i2);
    }
}
