package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.lineargradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;

public class LinearGradientView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Paint f8595O000000o = new Paint(1);
    private Path O00000Oo;
    private LinearGradient O00000o;
    private RectF O00000o0;
    private float[] O00000oO;
    private float[] O00000oo = {0.0f, 0.0f};
    private float[] O0000O0o = {0.0f, 1.0f};
    private int[] O0000OOo;
    private float[] O0000Oo = {0.5f, 0.5f};
    private boolean O0000Oo0 = false;
    private float O0000OoO = 45.0f;
    private int[] O0000Ooo = {0, 0};
    private float[] O0000o00 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    public LinearGradientView(Context context) {
        super(context);
    }

    public void setStartPosition(ReadableArray readableArray) {
        this.O00000oo = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        O000000o();
    }

    public void setEndPosition(ReadableArray readableArray) {
        this.O0000O0o = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        O000000o();
    }

    public void setColors(ReadableArray readableArray) {
        int[] iArr = new int[readableArray.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = readableArray.getInt(i);
        }
        this.O0000OOo = iArr;
        O000000o();
    }

    public void setLocations(ReadableArray readableArray) {
        float[] fArr = new float[readableArray.size()];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        this.O00000oO = fArr;
        O000000o();
    }

    public void setUseAngle(boolean z) {
        this.O0000Oo0 = z;
        O000000o();
    }

    public void setAngleCenter(ReadableArray readableArray) {
        this.O0000Oo = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        O000000o();
    }

    public void setAngle(float f) {
        this.O0000OoO = f;
        O000000o();
    }

    public void setBorderRadii(ReadableArray readableArray) {
        float[] fArr = new float[readableArray.size()];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = PixelUtil.toPixelFromDIP((float) readableArray.getDouble(i));
        }
        this.O0000o00 = fArr;
        O00000Oo();
        O000000o();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.O0000Ooo = new int[]{i, i2};
        O00000Oo();
        O000000o();
    }

    private static float[] O000000o(float f) {
        float sqrt = (float) Math.sqrt(2.0d);
        double d = (double) ((f - 90.0f) * 0.017453292f);
        return new float[]{((float) Math.cos(d)) * sqrt, ((float) Math.sin(d)) * sqrt};
    }

    private void O000000o() {
        int[] iArr = this.O0000OOo;
        if (iArr != null) {
            float[] fArr = this.O00000oO;
            if (fArr == null || iArr.length == fArr.length) {
                float[] fArr2 = this.O00000oo;
                float[] fArr3 = this.O0000O0o;
                if (this.O0000Oo0 && this.O0000Oo != null) {
                    float[] O000000o2 = O000000o(this.O0000OoO);
                    float[] fArr4 = this.O0000Oo;
                    float[] fArr5 = {fArr4[0] - (O000000o2[0] / 2.0f), fArr4[1] - (O000000o2[1] / 2.0f)};
                    fArr3 = new float[]{fArr4[0] + (O000000o2[0] / 2.0f), fArr4[1] + (O000000o2[1] / 2.0f)};
                    fArr2 = fArr5;
                }
                float f = fArr2[0];
                int[] iArr2 = this.O0000Ooo;
                float f2 = ((float) iArr2[0]) * f;
                float f3 = fArr2[1] * ((float) iArr2[1]);
                this.O00000o = new LinearGradient(f2, f3, fArr3[0] * ((float) iArr2[0]), fArr3[1] * ((float) iArr2[1]), this.O0000OOo, this.O00000oO, Shader.TileMode.CLAMP);
                this.f8595O000000o.setShader(this.O00000o);
                invalidate();
            }
        }
    }

    private void O00000Oo() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new Path();
            this.O00000o0 = new RectF();
        }
        this.O00000Oo.reset();
        RectF rectF = this.O00000o0;
        int[] iArr = this.O0000Ooo;
        rectF.set(0.0f, 0.0f, (float) iArr[0], (float) iArr[1]);
        this.O00000Oo.addRoundRect(this.O00000o0, this.O0000o00, Path.Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.O00000Oo;
        if (path == null) {
            canvas.drawPaint(this.f8595O000000o);
        } else {
            canvas.drawPath(path, this.f8595O000000o);
        }
    }
}
