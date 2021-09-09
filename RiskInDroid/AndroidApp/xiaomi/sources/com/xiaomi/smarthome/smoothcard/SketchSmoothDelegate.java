package com.xiaomi.smarthome.smoothcard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

public class SketchSmoothDelegate {

    /* renamed from: O000000o  reason: collision with root package name */
    public Path f11849O000000o;
    private final Paint O00000Oo;
    private float O00000o = 0.0f;
    private float O00000o0 = 0.0f;
    private float O00000oO = 0.0f;
    private boolean O00000oo = true;
    private float O0000O0o = 0.0f;
    private float O0000OOo = 0.0f;
    private int O0000Oo = -1;
    private int O0000Oo0 = -1;
    private int O0000OoO = -1;
    private LinearGradient O0000Ooo = null;
    private boolean O0000o0 = true;
    private boolean O0000o00 = true;
    private boolean O0000o0O = true;
    private boolean O0000o0o = true;

    public SketchSmoothDelegate(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.bl, R.attr.br, R.attr.gradient_angle, R.attr.gradient_end_color, R.attr.gradient_start_color, R.attr.max_radius, R.attr.prefer_sketch_style_radius, R.attr.radius_bg, R.attr.tl, R.attr.tr});
            this.O00000oO = obtainStyledAttributes.getDimension(5, 0.0f);
            this.O00000oo = obtainStyledAttributes.getBoolean(6, true);
            this.O0000o00 = obtainStyledAttributes.getBoolean(8, true);
            this.O0000o0 = obtainStyledAttributes.getBoolean(9, true);
            this.O0000o0O = obtainStyledAttributes.getBoolean(0, true);
            this.O0000o0o = obtainStyledAttributes.getBoolean(1, true);
            this.O0000Oo0 = obtainStyledAttributes.getColor(7, -1);
            this.O0000Oo = obtainStyledAttributes.getColor(4, -1);
            this.O0000OoO = obtainStyledAttributes.getColor(3, -1);
            obtainStyledAttributes.recycle();
        }
        this.O00000Oo = new Paint();
        this.O00000Oo.setAntiAlias(true);
        this.f11849O000000o = new Path();
    }

    public final void O000000o(Canvas canvas) {
        canvas.clipPath(this.f11849O000000o);
        canvas.drawPath(this.f11849O000000o, this.O00000Oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, int, float, float, int[], ?[OBJECT, ARRAY], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    public final void O000000o(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i;
        int i7 = i2;
        float f = (float) i6;
        this.O00000o0 = f;
        float f2 = (float) i7;
        this.O00000o = f2;
        this.O0000O0o = (f * 1.0f) / 2.0f;
        this.O0000OOo = (1.0f * f2) / 2.0f;
        if (!(i6 == i3 && i7 == i4)) {
            float f3 = this.O00000oO;
            if (f3 == 0.0f) {
                Path path = new Path();
                path.addRect(0.0f, 0.0f, this.O00000o0, this.O00000o, Path.Direction.CCW);
                this.f11849O000000o = path;
            } else if (!this.O00000oo || f3 == Math.min(this.O00000o0, this.O00000o) / 2.0f) {
                float f4 = this.O00000o0;
                float f5 = this.O00000o;
                float f6 = this.O00000oO;
                this.f11849O000000o = O000000o(f4, f5, f6, f6, this.O0000o00, this.O0000o0, this.O0000o0O, this.O0000o0o);
            } else {
                this.f11849O000000o = O000000o(this.O00000o0, this.O00000o, this.O00000oO, this.O0000o00, this.O0000o0, this.O0000o0O, this.O0000o0o);
            }
        }
        int i8 = this.O0000Oo;
        if (i8 == -1 || (i5 = this.O0000OoO) == -1) {
            this.O00000Oo.setColor(this.O0000Oo0);
            return;
        }
        this.O0000Ooo = new LinearGradient(0.0f, 0.0f, f, f2, new int[]{i8, i5}, (float[]) null, Shader.TileMode.CLAMP);
        this.O00000Oo.setShader(null);
        this.O00000Oo.setShader(this.O0000Ooo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    private Path O000000o(float f, float f2, float f3, boolean z, boolean z2, boolean z3, boolean z4) {
        Path path = new Path();
        float f4 = f3 < 0.0f ? 0 : f3;
        float f5 = f - 0.0f;
        float f6 = f2 - 0.0f;
        float f7 = f5 / 2.0f;
        float f8 = this.O0000O0o - f7;
        float f9 = f6 / 2.0f;
        float f10 = this.O0000OOo - f9;
        float min = ((double) (f4 / Math.min(f7, f9))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f4 / Math.min(f7, f9)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float min2 = ((double) (f4 / Math.min(f7, f9))) > 0.6d ? 1.0f + (Math.min(1.0f, ((f4 / Math.min(f7, f9)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path.moveTo(f8 + f7, f10);
        if (!z2) {
            path.lineTo(f8 + f5, f10);
        } else {
            float f11 = f4 / 100.0f;
            float f12 = f11 * 128.19f * min;
            path.lineTo(Math.max(f7, f5 - f12) + f8, f10);
            float f13 = f8 + f5;
            float f14 = f11 * 83.62f * min2;
            float f15 = f11 * 67.45f;
            float f16 = f11 * 4.64f;
            float f17 = f11 * 51.16f;
            float f18 = f11 * 13.36f;
            path.cubicTo(f13 - f14, f10, f13 - f15, f10 + f16, f13 - f17, f10 + f18);
            float f19 = f11 * 34.86f;
            float f20 = f11 * 22.07f;
            Path path2 = path;
            path2.cubicTo(f13 - f19, f10 + f20, f13 - f20, f10 + f19, f13 - f18, f10 + f17);
            path2.cubicTo(f13 - f16, f10 + f15, f13, f10 + f14, f13, f10 + Math.min(f9, f12));
        }
        if (!z4) {
            path.lineTo(f5 + f8, f10 + f6);
        } else {
            float f21 = f8 + f5;
            float f22 = f4 / 100.0f;
            float f23 = f22 * 128.19f * min;
            path.lineTo(f21, Math.max(f9, f6 - f23) + f10);
            float f24 = f10 + f6;
            float f25 = f22 * 83.62f * min2;
            float f26 = f22 * 4.64f;
            float f27 = f22 * 67.45f;
            float f28 = f22 * 13.36f;
            float f29 = f22 * 51.16f;
            path.cubicTo(f21, f24 - f25, f21 - f26, f24 - f27, f21 - f28, f24 - f29);
            float f30 = f22 * 22.07f;
            float f31 = f22 * 34.86f;
            Path path3 = path;
            path3.cubicTo(f21 - f30, f24 - f31, f21 - f31, f24 - f30, f21 - f29, f24 - f28);
            path3.cubicTo(f21 - f27, f24 - f26, f21 - f25, f24, f8 + Math.max(f7, f5 - f23), f24);
        }
        if (!z3) {
            path.lineTo(f8, f6 + f10);
        } else {
            float f32 = f4 / 100.0f;
            float f33 = f32 * 128.19f * min;
            float f34 = f10 + f6;
            path.lineTo(Math.min(f7, f33) + f8, f34);
            float f35 = f32 * 83.62f * min2;
            float f36 = f32 * 67.45f;
            float f37 = f32 * 4.64f;
            float f38 = f32 * 51.16f;
            float f39 = f32 * 13.36f;
            float f40 = f34;
            path.cubicTo(f8 + f35, f34, f8 + f36, f34 - f37, f8 + f38, f34 - f39);
            float f41 = f32 * 34.86f;
            float f42 = f32 * 22.07f;
            Path path4 = path;
            path4.cubicTo(f8 + f41, f40 - f42, f8 + f42, f40 - f41, f8 + f39, f40 - f38);
            path4.cubicTo(f8 + f37, f40 - f36, f8, f40 - f35, f8, f10 + Math.max(f9, f6 - f33));
        }
        if (!z) {
            path.lineTo(f8, f10);
        } else {
            float f43 = f4 / 100.0f;
            float f44 = 128.19f * f43 * min;
            path.lineTo(f8, Math.min(f9, f44) + f10);
            float f45 = 83.62f * f43 * min2;
            float f46 = 4.64f * f43;
            float f47 = 67.45f * f43;
            float f48 = 13.36f * f43;
            float f49 = 51.16f * f43;
            Path path5 = path;
            path5.cubicTo(f8, f10 + f45, f8 + f46, f10 + f47, f8 + f48, f10 + f49);
            float f50 = 22.07f * f43;
            float f51 = f43 * 34.86f;
            path5.cubicTo(f8 + f50, f10 + f51, f8 + f51, f10 + f50, f8 + f49, f10 + f48);
            path5.cubicTo(f8 + f47, f10 + f46, f8 + f45, f10, Math.min(f7, f44) + f8, f10);
        }
        path.close();
        return path;
    }

    private static Path O000000o(float f, float f2, float f3, float f4, boolean z, boolean z2, boolean z3, boolean z4) {
        RectF rectF = new RectF(new Rect(0, 0, (int) f, (int) f2));
        Path path = new Path();
        float[] fArr = new float[8];
        fArr[0] = !z ? 0.0f : f3;
        fArr[1] = !z ? 0.0f : f4;
        fArr[2] = !z2 ? 0.0f : f3;
        fArr[3] = !z2 ? 0.0f : f4;
        fArr[4] = !z3 ? 0.0f : f3;
        fArr[5] = !z3 ? 0.0f : f4;
        if (!z4) {
            f3 = 0.0f;
        }
        fArr[6] = f3;
        if (!z4) {
            f4 = 0.0f;
        }
        fArr[7] = f4;
        path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        return path;
    }

    public final void O000000o(boolean z, boolean z2, boolean z3, boolean z4) {
        this.O0000o00 = false;
        this.O0000o0 = false;
        this.O0000o0O = z3;
        this.O0000o0o = z4;
        O000000o((int) this.O00000o0, (int) this.O00000o, 0, 0);
    }

    public final void O000000o(int i) {
        this.O0000Oo0 = i;
        this.O00000Oo.setColor(i);
        this.O00000Oo.setShader(null);
        this.O0000Oo = -1;
        this.O0000OoO = -1;
        this.O0000Ooo = null;
    }
}
