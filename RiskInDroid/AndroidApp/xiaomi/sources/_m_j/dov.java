package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;

public final class dov {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f14817O000000o = true;
    private static RectF O00000Oo = new RectF();
    private static Paint O00000o;
    private static Path O00000o0 = new Path();
    private static Paint O00000oO;

    public static void O000000o(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13 = i;
        int i14 = i2;
        int i15 = i3;
        int i16 = i4;
        if (canvas != null && i16 > 0 && i13 != 0) {
            if (O00000o == null) {
                Paint paint = new Paint();
                O00000o = paint;
                paint.setAntiAlias(true);
                O00000o.setStyle(Paint.Style.STROKE);
            }
            O00000o.setColor(i13);
            float f = (float) i16;
            O00000o.setStrokeWidth(f);
            if (!f14817O000000o) {
                i12 = 0;
                i11 = 0;
                i10 = 0;
                i9 = 0;
            } else {
                i12 = i5;
                i10 = i6;
                i11 = i7;
                i9 = i8;
            }
            float f2 = f / 2.0f;
            canvas.drawLine(f2, i12 > 0 ? ((float) i12) + f2 : 0.0f, f2, i11 > 0 ? ((float) (i15 - i11)) - f2 : (float) i15, O00000o);
            canvas.drawLine(i12 > 0 ? ((float) i12) + f2 : 0.0f, f2, i10 > 0 ? ((float) (i14 - i10)) - f2 : (float) i14, f2, O00000o);
            float f3 = (float) i14;
            float f4 = f3 - f2;
            canvas.drawLine(f4, i10 > 0 ? ((float) i10) + f2 : 0.0f, f4, i9 > 0 ? ((float) (i15 - i9)) - f2 : (float) i15, O00000o);
            float f5 = (float) i15;
            float f6 = f5 - f2;
            canvas.drawLine(i11 > 0 ? ((float) i11) + f2 : 0.0f, f6, i9 > 0 ? ((float) (i14 - i9)) - f2 : f3, f6, O00000o);
            if (i12 > 0) {
                float f7 = (float) (i12 * 2);
                O00000Oo.set(0.0f, 0.0f, f7, f7);
                O00000Oo.offset(f2, f2);
                canvas.drawArc(O00000Oo, 179.0f, 91.0f, false, O00000o);
            }
            if (i10 > 0) {
                int i17 = i10 * 2;
                O00000Oo.set((float) (i14 - i17), 0.0f, f3, (float) i17);
                O00000Oo.offset(-f2, f2);
                canvas.drawArc(O00000Oo, 269.0f, 91.0f, false, O00000o);
            }
            if (i9 > 0) {
                int i18 = i9 * 2;
                O00000Oo.set((float) (i14 - i18), (float) (i15 - i18), f3, f5);
                float f8 = -f2;
                O00000Oo.offset(f8, f8);
                canvas.drawArc(O00000Oo, -1.0f, 91.0f, false, O00000o);
            }
            if (i11 > 0) {
                int i19 = i11 * 2;
                O00000Oo.set(0.0f, (float) (i15 - i19), (float) i19, f5);
                O00000Oo.offset(f2, -f2);
                canvas.drawArc(O00000Oo, 89.0f, 91.0f, false, O00000o);
            }
        }
    }

    public static void O00000Oo(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        Canvas canvas2 = canvas;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        if (canvas2 != null) {
            if (O00000oO == null) {
                Paint paint = new Paint();
                O00000oO = paint;
                paint.setAntiAlias(true);
            }
            O00000oO.setColor(i);
            if (!f14817O000000o) {
                i12 = 0;
                i11 = 0;
                i10 = 0;
                i9 = 0;
            } else {
                i12 = i5;
                i11 = i6;
                i9 = i7;
                i10 = i8;
            }
            float f = (float) i15;
            float f2 = f / 2.0f;
            O00000o0.reset();
            O00000o0.moveTo((float) ((i12 > 0 ? i12 : 0) + i15), f);
            int i16 = i13 - i15;
            O00000o0.lineTo((float) (i16 - (i11 > 0 ? i11 : 0)), f);
            if (i11 > 0) {
                int i17 = i11 * 2;
                O00000Oo.set((float) (i13 - i17), 0.0f, (float) i13, (float) i17);
                O00000Oo.offset(-f2, f2);
                O00000o0.arcTo(O00000Oo, 270.0f, 90.0f);
            }
            float f3 = (float) i16;
            int i18 = i14 - i15;
            O00000o0.lineTo(f3, (float) (i18 - (i10 > 0 ? i10 : 0)));
            if (i10 > 0) {
                int i19 = i10 * 2;
                O00000Oo.set((float) (i13 - i19), (float) (i14 - i19), (float) i13, (float) i14);
                float f4 = -f2;
                O00000Oo.offset(f4, f4);
                O00000o0.arcTo(O00000Oo, 0.0f, 90.0f);
            }
            O00000o0.lineTo((float) ((i9 > 0 ? i9 : 0) + i15), (float) i18);
            if (i9 > 0) {
                int i20 = i9 * 2;
                O00000Oo.set(0.0f, (float) (i14 - i20), (float) i20, (float) i14);
                O00000Oo.offset(f2, -f2);
                O00000o0.arcTo(O00000Oo, 90.0f, 90.0f);
            }
            O00000o0.lineTo(f, (float) ((i12 > 0 ? i12 : 0) + i15));
            if (i12 > 0) {
                float f5 = (float) (i12 * 2);
                O00000Oo.set(0.0f, 0.0f, f5, f5);
                O00000Oo.offset(f2, f2);
                O00000o0.arcTo(O00000Oo, 180.0f, 90.0f);
            }
            canvas2.drawPath(O00000o0, O00000oO);
        }
    }

    public static void O000000o(View view, Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6) {
        if (canvas != null) {
            int i7 = 0;
            if (!f14817O000000o) {
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
            }
            if (i3 > 0 || i4 > 0 || i5 > 0 || i6 > 0) {
                O00000o0.reset();
                O00000o0.moveTo((float) (i3 > 0 ? i3 : 0), 0.0f);
                O00000o0.lineTo((float) (i - (i4 > 0 ? i4 : 0)), 0.0f);
                if (i4 > 0) {
                    int i8 = i4 * 2;
                    O00000Oo.set((float) (i - i8), 0.0f, (float) i, (float) i8);
                    O00000o0.arcTo(O00000Oo, 270.0f, 90.0f);
                }
                float f = (float) i;
                O00000o0.lineTo(f, (float) (i2 - (i6 > 0 ? i6 : 0)));
                if (i6 > 0) {
                    int i9 = i6 * 2;
                    O00000Oo.set((float) (i - i9), (float) (i2 - i9), f, (float) i2);
                    O00000o0.arcTo(O00000Oo, 0.0f, 90.0f);
                }
                float f2 = (float) i2;
                O00000o0.lineTo((float) (i5 > 0 ? i5 : 0), f2);
                if (i5 > 0) {
                    int i10 = i5 * 2;
                    O00000Oo.set(0.0f, (float) (i2 - i10), (float) i10, f2);
                    O00000o0.arcTo(O00000Oo, 90.0f, 90.0f);
                }
                Path path = O00000o0;
                if (i3 > 0) {
                    i7 = i3;
                }
                path.lineTo(0.0f, (float) i7);
                if (i3 > 0) {
                    float f3 = (float) (i3 * 2);
                    O00000Oo.set(0.0f, 0.0f, f3, f3);
                    O00000o0.arcTo(O00000Oo, 180.0f, 90.0f);
                }
                if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 18) {
                    view.setLayerType(1, null);
                }
                canvas.clipPath(O00000o0);
            }
        }
    }
}
