package com.otaliastudios.cameraview;

import android.content.Context;
import android.graphics.PointF;
import android.widget.FrameLayout;

abstract class GestureLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f5388O000000o;
    protected Gesture O00000Oo;
    protected PointF[] O00000o0;

    protected static float O000000o(float f, float f2, float f3, float f4) {
        if (f2 < f3) {
            f2 = f3;
        }
        if (f2 > f4) {
            f2 = f4;
        }
        float f5 = ((f4 - f3) / 50.0f) / 2.0f;
        return (f2 < f - f5 || f2 > f5 + f) ? f2 : f;
    }

    public abstract float O000000o(float f, float f2, float f3);

    /* access modifiers changed from: protected */
    public void O000000o(Context context) {
    }

    public GestureLayout(Context context) {
        super(context);
        O000000o(context);
    }

    public final void O000000o(boolean z) {
        this.f5388O000000o = z;
    }

    public final Gesture O000000o() {
        return this.O00000Oo;
    }

    public final PointF[] O00000Oo() {
        return this.O00000o0;
    }
}
