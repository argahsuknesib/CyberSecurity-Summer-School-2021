package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class CurtainControlView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Paint f10277O000000o = new Paint();
    private int O00000Oo;
    private int[] O00000o;
    private float O00000o0;
    private List<int[]> O00000oO;
    private LinearGradient O00000oo;
    private final List<LinearGradient> O0000O0o = new ArrayList();
    private View.OnTouchListener O0000OOo;
    private float O0000Oo;
    private float O0000Oo0;
    private int O0000OoO = -1;
    private int[] O0000Ooo = {-1, 0};
    private float O0000o0 = 0.15f;
    private RadialGradient O0000o00;

    public CurtainControlView(Context context) {
        super(context);
    }

    public CurtainControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CurtainControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CurtainControlView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f10277O000000o.setColorFilter(null);
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.f10277O000000o.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    public final void O000000o(int[] iArr, List<int[]> list) {
        this.O00000o = iArr;
        this.O00000oO = list;
        this.O00000oo = null;
        this.O0000O0o.clear();
        invalidate();
    }

    public void setMode(int i) {
        this.O00000Oo = i;
    }

    public float getOpenPercent() {
        return this.O00000o0;
    }

    public void setOpenPercent(float f) {
        this.O00000o0 = f;
        invalidate();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, int, int, float, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    private static LinearGradient O000000o(int i, int[] iArr) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i, iArr, O000000o(iArr), Shader.TileMode.CLAMP);
    }

    private static float[] O000000o(int[] iArr) {
        float[] fArr = new float[iArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = (((float) i) * 1.0f) / ((float) (fArr.length - 1));
        }
        return fArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, int, float, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        List<int[]> list;
        super.onDraw(canvas);
        if (this.O00000oo == null && this.O00000o != null) {
            this.O00000oo = O000000o(getBottom(), this.O00000o);
        }
        if (this.O0000O0o.size() == 0 && (list = this.O00000oO) != null) {
            for (int[] O000000o2 : list) {
                this.O0000O0o.add(O000000o(getBottom(), O000000o2));
            }
        }
        if (this.O0000o00 == null && this.O0000Ooo != null) {
            float f = this.O0000o0;
            int[] iArr = this.O0000Ooo;
            this.O0000o00 = new RadialGradient(0.0f, 0.0f, ((float) Math.min(getWidth(), getHeight())) * f, iArr, O000000o(iArr), Shader.TileMode.MIRROR);
        }
        this.f10277O000000o.setShader(this.O00000oo);
        canvas.drawRect(0.0f, 0.0f, (float) getRight(), (float) getBottom(), this.f10277O000000o);
        int i = this.O00000Oo;
        if (i == 0) {
            O000000o(canvas, 0.0f, ((float) getWidth()) * this.O00000o0);
        } else if (i == 1) {
            O000000o(canvas, 0.0f, (((float) getWidth()) * this.O00000o0) / 2.0f);
            O000000o(canvas, (float) getWidth(), ((float) getWidth()) - ((((float) getWidth()) * this.O00000o0) / 2.0f));
        }
        if (isEnabled()) {
            int i2 = this.O0000OoO;
            if (i2 == 0 || i2 == 2) {
                this.f10277O000000o.setShader(this.O0000o00);
                canvas.translate(this.O0000Oo0, this.O0000Oo);
                canvas.drawCircle(0.0f, 0.0f, this.O0000o0 * ((float) Math.min(getWidth(), getHeight())), this.f10277O000000o);
            }
        }
    }

    private void O000000o(Canvas canvas, float f, float f2) {
        float size = (f2 - f) / ((float) this.O0000O0o.size());
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            this.f10277O000000o.setShader(this.O0000O0o.get(i));
            if (size > 0.0f) {
                canvas.drawRect(f + (((float) i) * size), 0.0f, f + (((float) (i + 1)) * size), (float) getBottom(), this.f10277O000000o);
            } else {
                canvas.drawRect(f + (((float) (i + 1)) * size), 0.0f, f + (((float) i) * size), (float) getBottom(), this.f10277O000000o);
            }
        }
    }

    public void setTouchCallback(View.OnTouchListener onTouchListener) {
        this.O0000OOo = onTouchListener;
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
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        this.O0000OoO = motionEvent.getAction();
        float x = motionEvent.getX();
        if (this.O0000OoO != 0) {
            float f = this.O0000Oo0;
            float f2 = x - f;
            int i = this.O00000Oo;
            if (i == 0) {
                this.O00000o0 += f2 / ((float) getWidth());
            } else if (i == 1) {
                if (f > ((float) getWidth()) / 2.0f) {
                    this.O00000o0 = (((float) getWidth()) - f2) / (((float) getWidth()) / 2.0f);
                } else {
                    this.O00000o0 = f2 / (((float) getWidth()) / 2.0f);
                }
            }
            this.O00000o0 = Math.max(0.0f, Math.min(this.O00000o0, 1.0f));
        }
        this.O0000Oo0 = x;
        this.O0000Oo = motionEvent.getY();
        View.OnTouchListener onTouchListener = this.O0000OOo;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        invalidate();
        return true;
    }
}
