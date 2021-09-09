package com.mi.blockcanary.ui;

import _m_j.byh;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public final class DisplayConnectorView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Paint f4581O000000o = new Paint(1);
    private static final Paint O00000Oo = new Paint(1);
    private static final Paint O00000o = new Paint(1);
    private static final Paint O00000o0 = new Paint(1);
    private Type O00000oO = Type.NODE;
    private Bitmap O00000oo;

    public enum Type {
        START,
        NODE,
        END
    }

    static {
        f4581O000000o.setColor(-4539718);
        O00000Oo.setColor(-8083771);
        O00000o0.setColor(-5155506);
        O00000o.setColor(0);
        O00000o.setXfermode(byh.f13407O000000o);
    }

    public DisplayConnectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        Bitmap bitmap = this.O00000oo;
        if (!(bitmap == null || (bitmap.getWidth() == width && this.O00000oo.getHeight() == height))) {
            this.O00000oo.recycle();
            this.O00000oo = null;
        }
        if (this.O00000oo == null) {
            this.O00000oo = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(this.O00000oo);
            float f = (float) width;
            float f2 = f / 2.0f;
            float f3 = (float) height;
            float f4 = f3 / 2.0f;
            float f5 = f / 3.0f;
            float O000000o2 = byh.O000000o(4.0f, getResources());
            f4581O000000o.setStrokeWidth(O000000o2);
            O00000Oo.setStrokeWidth(O000000o2);
            int i = AnonymousClass1.f4582O000000o[this.O00000oO.ordinal()];
            if (i == 1) {
                canvas2.drawLine(f2, 0.0f, f2, f3, f4581O000000o);
                canvas2.drawCircle(f2, f4, f2, f4581O000000o);
                canvas2.drawCircle(f2, f4, f5, O00000o);
            } else if (i != 2) {
                canvas2.drawLine(f2, 0.0f, f2, f4, f4581O000000o);
                canvas2.drawCircle(f2, f4, f5, O00000o0);
            } else {
                float f6 = f2 - (O000000o2 / 2.0f);
                canvas2.drawRect(0.0f, 0.0f, f, f6, O00000Oo);
                canvas2.drawCircle(0.0f, f6, f6, O00000o);
                canvas2.drawCircle(f, f6, f6, O00000o);
                Canvas canvas3 = canvas2;
                float f7 = f2;
                float f8 = f2;
                canvas3.drawLine(f7, 0.0f, f8, f4, O00000Oo);
                canvas3.drawLine(f7, f4, f8, f3, f4581O000000o);
                canvas2.drawCircle(f2, f4, f2, f4581O000000o);
                canvas2.drawCircle(f2, f4, f5, O00000o);
            }
        }
        canvas.drawBitmap(this.O00000oo, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: com.mi.blockcanary.ui.DisplayConnectorView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f4582O000000o = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f4582O000000o[Type.NODE.ordinal()] = 1;
            f4582O000000o[Type.START.ordinal()] = 2;
        }
    }

    public final void setType(Type type) {
        if (type != this.O00000oO) {
            this.O00000oO = type;
            Bitmap bitmap = this.O00000oo;
            if (bitmap != null) {
                bitmap.recycle();
                this.O00000oo = null;
            }
            invalidate();
        }
    }
}
