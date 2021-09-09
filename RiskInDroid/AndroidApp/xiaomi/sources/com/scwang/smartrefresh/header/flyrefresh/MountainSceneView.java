package com.scwang.smartrefresh.header.flyrefresh;

import _m_j.cq;
import _m_j.q;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.xiaomi.smarthome.R;

public class MountainSceneView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f5546O000000o;
    protected int O00000Oo;
    protected int O00000o;
    protected int O00000o0;
    protected int O00000oO;
    protected int O00000oo;
    protected int O0000O0o;
    protected int O0000OOo;
    protected int O0000Oo;
    protected int O0000Oo0;
    protected Paint O0000OoO;
    protected Paint O0000Ooo;
    protected Path O0000o;
    protected Paint O0000o0;
    protected Paint O0000o00;
    protected Path O0000o0O;
    protected Path O0000o0o;
    protected Path O0000oO;
    protected Path O0000oO0;
    protected Matrix O0000oOO;
    protected float O0000oOo;
    protected float O0000oo;
    protected float O0000oo0;
    protected float O0000ooO;
    protected float O0000ooo;
    protected int O00oOooO;

    public MountainSceneView(Context context) {
        this(context, null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, boolean):void
     arg types: [float, int]
     candidates:
      com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, int):void
      com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, boolean):void */
    public MountainSceneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5546O000000o = -8466743;
        this.O00000Oo = -7939369;
        this.O00000o0 = -12807524;
        this.O00000o = -12689549;
        this.O00000oO = -14716553;
        this.O00000oo = -15974840;
        this.O0000O0o = -13334385;
        this.O0000OOo = -14982807;
        this.O0000Oo0 = -11030098;
        this.O0000Oo = -10312531;
        this.O0000OoO = new Paint();
        this.O0000Ooo = new Paint();
        this.O0000o00 = new Paint();
        this.O0000o0 = new Paint();
        this.O0000o0O = new Path();
        this.O0000o0o = new Path();
        this.O0000o = new Path();
        this.O0000oO0 = new Path();
        this.O0000oO = new Path();
        this.O0000oOO = new Matrix();
        this.O0000oOo = 5.0f;
        this.O0000oo0 = 5.0f;
        this.O0000oo = 0.0f;
        this.O0000ooO = 1.0f;
        this.O0000ooo = Float.MAX_VALUE;
        this.O00oOooO = 0;
        this.O0000OoO.setAntiAlias(true);
        this.O0000OoO.setStyle(Paint.Style.FILL);
        this.O0000Ooo.setAntiAlias(true);
        this.O0000o00.setAntiAlias(true);
        this.O0000o0.setAntiAlias(true);
        this.O0000o0.setStyle(Paint.Style.STROKE);
        this.O0000o0.setStrokeWidth(2.0f);
        this.O0000o0.setStrokeJoin(Paint.Join.ROUND);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.msvPrimaryColor, R.attr.msvViewportHeight});
        if (obtainStyledAttributes.hasValue(0)) {
            setPrimaryColor(obtainStyledAttributes.getColor(0, -16777216));
        }
        this.O00oOooO = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        obtainStyledAttributes.recycle();
        O000000o(this.O0000oo, 180);
        O000000o(this.O0000oo, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, boolean):void
     arg types: [float, int]
     candidates:
      com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, int):void
      com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, boolean):void */
    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.O0000oOo = (((float) measuredWidth) * 1.0f) / 240.0f;
        int i3 = this.O00oOooO;
        if (i3 <= 0) {
            i3 = measuredHeight;
        }
        this.O0000oo0 = (((float) i3) * 1.0f) / 180.0f;
        O000000o(this.O0000oo, measuredHeight);
        O000000o(this.O0000oo, true);
    }

    private void O000000o(float f, int i) {
        this.O0000oOO.reset();
        this.O0000oOO.setScale(this.O0000oOo, this.O0000oo0);
        float f2 = 10.0f * f;
        this.O0000o0O.reset();
        this.O0000o0O.moveTo(0.0f, 95.0f + f2);
        this.O0000o0O.lineTo(55.0f, 74.0f + f2);
        this.O0000o0O.lineTo(146.0f, f2 + 104.0f);
        this.O0000o0O.lineTo(227.0f, 72.0f + f2);
        this.O0000o0O.lineTo(240.0f, f2 + 80.0f);
        this.O0000o0O.lineTo(240.0f, 180.0f);
        this.O0000o0O.lineTo(0.0f, 180.0f);
        this.O0000o0O.close();
        this.O0000o0O.transform(this.O0000oOO);
        float f3 = 20.0f * f;
        this.O0000o0o.reset();
        this.O0000o0o.moveTo(0.0f, 103.0f + f3);
        this.O0000o0o.lineTo(67.0f, 90.0f + f3);
        this.O0000o0o.lineTo(165.0f, 115.0f + f3);
        this.O0000o0o.lineTo(221.0f, 87.0f + f3);
        this.O0000o0o.lineTo(240.0f, f3 + 100.0f);
        this.O0000o0o.lineTo(240.0f, 180.0f);
        this.O0000o0o.lineTo(0.0f, 180.0f);
        this.O0000o0o.close();
        this.O0000o0o.transform(this.O0000oOO);
        float f4 = f * 30.0f;
        this.O0000o.reset();
        this.O0000o.moveTo(0.0f, 114.0f + f4);
        this.O0000o.cubicTo(30.0f, f4 + 106.0f, 196.0f, f4 + 97.0f, 240.0f, f4 + 104.0f);
        float f5 = (float) i;
        this.O0000o.lineTo(240.0f, f5 / this.O0000oo0);
        this.O0000o.lineTo(0.0f, f5 / this.O0000oo0);
        this.O0000o.close();
        this.O0000o.transform(this.O0000oOO);
    }

    private void O000000o(float f, boolean z) {
        int i;
        if (f != this.O0000ooo || z) {
            Interpolator O000000o2 = cq.O000000o(0.8f, -0.5f * f);
            float f2 = f * 30.000002f;
            float[] fArr = new float[26];
            float[] fArr2 = new float[26];
            int i2 = 0;
            float f3 = 0.0f;
            float f4 = 200.0f;
            while (true) {
                if (i2 > 25) {
                    break;
                }
                fArr[i2] = (O000000o2.getInterpolation(f3) * f2) + 50.0f;
                fArr2[i2] = f4;
                f4 -= 0.5f;
                f3 += 0.04f;
                i2++;
            }
            this.O0000oO0.reset();
            this.O0000oO0.moveTo(45.0f, 200.0f);
            for (int i3 = 0; i3 < 17; i3++) {
                if (i3 < 8) {
                    this.O0000oO0.lineTo(fArr[i3] - 5.0f, fArr2[i3]);
                } else {
                    this.O0000oO0.lineTo(fArr[i3] - ((((float) (17 - i3)) * 5.0f) / 9.0f), fArr2[i3]);
                }
            }
            for (int i4 = 16; i4 >= 0; i4--) {
                if (i4 < 8) {
                    this.O0000oO0.lineTo(fArr[i4] + 5.0f, fArr2[i4]);
                } else {
                    this.O0000oO0.lineTo(fArr[i4] + ((((float) (17 - i4)) * 5.0f) / 9.0f), fArr2[i4]);
                }
            }
            this.O0000oO0.close();
            this.O0000oO.reset();
            this.O0000oO.moveTo(fArr[10] - 20.0f, fArr2[10]);
            this.O0000oO.addArc(new RectF(fArr[10] - 20.0f, fArr2[10] - 20.0f, fArr[10] + 20.0f, fArr2[10] + 20.0f), 0.0f, 180.0f);
            for (int i5 = 10; i5 <= 25; i5++) {
                float f5 = ((float) (i5 - 10)) / 15.0f;
                this.O0000oO.lineTo((fArr[i5] - 20.0f) + (f5 * f5 * 20.0f), fArr2[i5]);
            }
            for (i = 25; i >= 10; i--) {
                float f6 = ((float) (i - 10)) / 15.0f;
                this.O0000oO.lineTo((fArr[i] + 20.0f) - ((f6 * f6) * 20.0f), fArr2[i]);
            }
        }
    }

    private void O000000o(Canvas canvas, float f, float f2, float f3, int i, int i2) {
        canvas.save();
        canvas.translate(f2 - ((100.0f * f) / 2.0f), f3 - (200.0f * f));
        canvas.scale(f, f);
        this.O0000o00.setColor(i2);
        canvas.drawPath(this.O0000oO, this.O0000o00);
        this.O0000Ooo.setColor(i);
        canvas.drawPath(this.O0000oO0, this.O0000Ooo);
        this.O0000o0.setColor(i);
        canvas.drawPath(this.O0000oO, this.O0000o0);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.f5546O000000o);
        this.O0000OoO.setColor(this.O00000Oo);
        canvas.drawPath(this.O0000o0O, this.O0000OoO);
        canvas.save();
        canvas.scale(-1.0f, 1.0f, (float) (getWidth() / 2), 0.0f);
        float f = this.O0000oOo;
        O000000o(canvas, f * 0.12f, f * 180.0f, ((this.O0000oo * 20.0f) + 93.0f) * this.O0000oo0, this.O0000Oo, this.O0000Oo0);
        float f2 = this.O0000oOo;
        O000000o(canvas, f2 * 0.1f, f2 * 200.0f, ((this.O0000oo * 20.0f) + 96.0f) * this.O0000oo0, this.O0000Oo, this.O0000Oo0);
        canvas.restore();
        this.O0000OoO.setColor(this.O00000o0);
        canvas.drawPath(this.O0000o0o, this.O0000OoO);
        float f3 = this.O0000oOo;
        O000000o(canvas, f3 * 0.2f, f3 * 160.0f, ((this.O0000oo * 30.0f) + 105.0f) * this.O0000oo0, this.O00000oo, this.O00000oO);
        float f4 = this.O0000oOo;
        O000000o(canvas, f4 * 0.14f, f4 * 180.0f, ((this.O0000oo * 30.0f) + 105.0f) * this.O0000oo0, this.O0000OOo, this.O0000O0o);
        float f5 = this.O0000oOo;
        O000000o(canvas, f5 * 0.16f, f5 * 140.0f, ((this.O0000oo * 30.0f) + 105.0f) * this.O0000oo0, this.O0000OOo, this.O0000O0o);
        this.O0000OoO.setColor(this.O00000o);
        canvas.drawPath(this.O0000o, this.O0000OoO);
    }

    public void setPrimaryColor(int i) {
        this.f5546O000000o = i;
        this.O00000Oo = q.O000000o(-1711276033, i);
        this.O00000o0 = q.O000000o(-1724083556, i);
        this.O00000o = q.O000000o(-868327565, i);
        this.O00000oO = q.O000000o(1428124023, i);
        this.O00000oo = q.O000000o(-871612856, i);
        this.O0000O0o = q.O000000o(1429506191, i);
        this.O0000OOo = q.O000000o(-870620823, i);
        this.O0000Oo0 = q.O000000o(1431810478, i);
        this.O0000Oo = q.O000000o(-865950547, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, boolean):void
     arg types: [float, int]
     candidates:
      com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, int):void
      com.scwang.smartrefresh.header.flyrefresh.MountainSceneView.O000000o(float, boolean):void */
    public final void O000000o(float f) {
        this.O0000ooO = f;
        float max = Math.max(0.0f, f);
        this.O0000oo = Math.max(0.0f, this.O0000ooO);
        int measuredHeight = getMeasuredHeight();
        float f2 = this.O0000oo;
        if (measuredHeight <= 0) {
            measuredHeight = 180;
        }
        O000000o(f2, measuredHeight);
        O000000o(max, false);
    }
}
