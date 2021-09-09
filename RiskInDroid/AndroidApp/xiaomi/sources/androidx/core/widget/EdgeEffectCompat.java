package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {

    /* renamed from: O000000o  reason: collision with root package name */
    public EdgeEffect f2846O000000o;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.f2846O000000o = new EdgeEffect(context);
    }

    @Deprecated
    public final void O000000o(int i, int i2) {
        this.f2846O000000o.setSize(i, i2);
    }

    @Deprecated
    public final boolean O000000o(float f) {
        this.f2846O000000o.onPull(f);
        return true;
    }

    @Deprecated
    public final boolean O00000Oo(float f) {
        O000000o(this.f2846O000000o, f, 0.5f);
        return true;
    }

    public static void O000000o(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f, f2);
        } else {
            edgeEffect.onPull(f);
        }
    }

    @Deprecated
    public final boolean O000000o() {
        this.f2846O000000o.onRelease();
        return this.f2846O000000o.isFinished();
    }

    @Deprecated
    public final boolean O000000o(Canvas canvas) {
        return this.f2846O000000o.draw(canvas);
    }
}
