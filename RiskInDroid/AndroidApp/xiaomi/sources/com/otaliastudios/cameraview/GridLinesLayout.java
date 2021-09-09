package com.otaliastudios.cameraview;

import _m_j.cqd;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

class GridLinesLayout extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    Grid f5389O000000o;
    cqd<Integer> O00000Oo;
    private Drawable O00000o;
    private Drawable O00000o0;
    private final float O00000oO;

    public GridLinesLayout(Context context) {
        this(context, null);
    }

    public GridLinesLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000Oo = new cqd<>();
        this.O00000o0 = new ColorDrawable(-1);
        this.O00000o0.setAlpha(160);
        this.O00000o = new ColorDrawable(-1);
        this.O00000o.setAlpha(160);
        this.O00000oO = TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O00000o0.setBounds(i, 0, i3, (int) this.O00000oO);
        this.O00000o.setBounds(0, i2, (int) this.O00000oO, i4);
    }

    /* renamed from: com.otaliastudios.cameraview.GridLinesLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5390O000000o = new int[Grid.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f5390O000000o[Grid.OFF.ordinal()] = 1;
            f5390O000000o[Grid.DRAW_3X3.ordinal()] = 2;
            f5390O000000o[Grid.DRAW_PHI.ordinal()] = 3;
            try {
                f5390O000000o[Grid.DRAW_4X4.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private int O000000o() {
        int i = AnonymousClass1.f5390O000000o[this.f5389O000000o.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 0 : 3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.O00000Oo.O000000o();
        int O000000o2 = O000000o();
        int i = 0;
        while (i < O000000o2) {
            float O000000o3 = this.f5389O000000o == Grid.DRAW_PHI ? i == 1 ? 0.38196602f : 0.618034f : (1.0f / ((float) (O000000o() + 1))) * (((float) i) + 1.0f);
            canvas.translate(0.0f, ((float) getHeight()) * O000000o3);
            this.O00000o0.draw(canvas);
            float f = -O000000o3;
            canvas.translate(0.0f, ((float) getHeight()) * f);
            canvas.translate(O000000o3 * ((float) getWidth()), 0.0f);
            this.O00000o.draw(canvas);
            canvas.translate(f * ((float) getWidth()), 0.0f);
            i++;
        }
        this.O00000Oo.O000000o(Integer.valueOf(O000000o2));
    }
}
