package com.xiaomi.smarthome.library.common.widget.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;

public class SaturationBar extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f9295O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private Paint O0000O0o;
    private Paint O0000OOo;
    private RectF O0000Oo = new RectF();
    private Paint O0000Oo0;
    private Shader O0000OoO;
    private boolean O0000Ooo;
    private ColorPicker O0000o = null;
    private float[] O0000o0 = new float[3];
    private int O0000o00;
    private float O0000o0O;
    private float O0000o0o;
    private O000000o O0000oO;
    private boolean O0000oO0;
    private int O0000oOO;

    public interface O000000o {
    }

    public void setOnSaturationChangedListener(O000000o o000000o) {
        this.O0000oO = o000000o;
    }

    public O000000o getOnSaturationChangedListener() {
        return this.O0000oO;
    }

    public SaturationBar(Context context) {
        super(context);
        O000000o(null, 0);
    }

    public SaturationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet, 0);
    }

    public SaturationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet, i);
    }

    private void O000000o(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.bar_length, R.attr.bar_orientation_horizontal, R.attr.bar_pointer_halo_radius, R.attr.bar_pointer_radius, R.attr.bar_thickness}, i, 0);
        Resources resources = getContext().getResources();
        this.f9295O000000o = obtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(R.dimen.bar_thickness));
        this.O00000Oo = obtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(R.dimen.bar_length));
        this.O00000o0 = this.O00000Oo;
        this.O00000o = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(R.dimen.bar_pointer_radius));
        this.O00000oO = obtainStyledAttributes.getDimensionPixelSize(2, resources.getDimensionPixelSize(R.dimen.bar_pointer_halo_radius));
        this.O0000oO0 = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
        this.O0000O0o = new Paint(1);
        this.O0000O0o.setShader(this.O0000OoO);
        this.O00000oo = this.O00000Oo + this.O00000oO;
        this.O0000Oo0 = new Paint(1);
        this.O0000Oo0.setColor(-16777216);
        this.O0000Oo0.setAlpha(80);
        this.O0000OOo = new Paint(1);
        this.O0000OOo.setColor(-8257792);
        int i2 = this.O00000Oo;
        this.O0000o0O = 1.0f / ((float) i2);
        this.O0000o0o = ((float) i2) / 1.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.O00000o0 + (this.O00000oO * 2);
        if (!this.O0000oO0) {
            i = i2;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i3 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(i3, size);
        }
        int i4 = this.O00000oO * 2;
        this.O00000Oo = i3 - i4;
        if (!this.O0000oO0) {
            setMeasuredDimension(i4, this.O00000Oo + i4);
        } else {
            setMeasuredDimension(this.O00000Oo + i4, i4);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [float, int, float, float, int[], ?[OBJECT, ARRAY], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onSizeChanged(i, i2, i3, i4);
        if (this.O0000oO0) {
            int i7 = this.O00000Oo;
            int i8 = this.O00000oO;
            i6 = i7 + i8;
            int i9 = this.f9295O000000o;
            this.O00000Oo = i - (i8 * 2);
            this.O0000Oo.set((float) i8, (float) (i8 - (i9 / 2)), (float) (this.O00000Oo + i8), (float) (i8 + (i9 / 2)));
            i5 = i9;
        } else {
            i6 = this.f9295O000000o;
            int i10 = this.O00000Oo;
            int i11 = this.O00000oO;
            i5 = i10 + i11;
            this.O00000Oo = i2 - (i11 * 2);
            this.O0000Oo.set((float) (i11 - (i6 / 2)), (float) i11, (float) ((i6 / 2) + i11), (float) (this.O00000Oo + i11));
        }
        if (!isInEditMode()) {
            this.O0000OoO = new LinearGradient((float) this.O00000oO, 0.0f, (float) i6, (float) i5, new int[]{-1, Color.HSVToColor(255, this.O0000o0)}, (float[]) null, Shader.TileMode.CLAMP);
        } else {
            this.O0000OoO = new LinearGradient((float) this.O00000oO, 0.0f, (float) i6, (float) i5, new int[]{-1, -8257792}, (float[]) null, Shader.TileMode.CLAMP);
            Color.colorToHSV(-8257792, this.O0000o0);
        }
        this.O0000O0o.setShader(this.O0000OoO);
        int i12 = this.O00000Oo;
        this.O0000o0O = 1.0f / ((float) i12);
        this.O0000o0o = ((float) i12) / 1.0f;
        float[] fArr = new float[3];
        Color.colorToHSV(this.O0000o00, fArr);
        if (!isInEditMode()) {
            this.O00000oo = Math.round((this.O0000o0o * fArr[1]) + ((float) this.O00000oO));
        } else {
            this.O00000oo = this.O00000Oo + this.O00000oO;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        canvas.drawRect(this.O0000Oo, this.O0000O0o);
        if (this.O0000oO0) {
            i2 = this.O00000oo;
            i = this.O00000oO;
        } else {
            i2 = this.O00000oO;
            i = this.O00000oo;
        }
        float f = (float) i2;
        float f2 = (float) i;
        canvas.drawCircle(f, f2, (float) this.O00000oO, this.O0000Oo0);
        canvas.drawCircle(f, f2, (float) this.O00000o, this.O0000OOo);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        int i;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.O0000oO0) {
            f = motionEvent.getX();
        } else {
            f = motionEvent.getY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O0000Ooo = true;
            int i2 = this.O00000oO;
            if (f >= ((float) i2) && f <= ((float) (i2 + this.O00000Oo))) {
                this.O00000oo = Math.round(f);
                O000000o(Math.round(f));
                this.O0000OOo.setColor(this.O0000o00);
                invalidate();
            }
        } else if (action == 1) {
            this.O0000Ooo = false;
        } else if (action == 2) {
            if (this.O0000Ooo) {
                int i3 = this.O00000oO;
                if (f < ((float) i3) || f > ((float) (i3 + this.O00000Oo))) {
                    int i4 = this.O00000oO;
                    if (f < ((float) i4)) {
                        this.O00000oo = i4;
                        this.O0000o00 = -1;
                        this.O0000OOo.setColor(this.O0000o00);
                        ColorPicker colorPicker = this.O0000o;
                        if (colorPicker != null) {
                            colorPicker.changeValueBarColor(this.O0000o00);
                            this.O0000o.changeOpacityBarColor(this.O0000o00);
                        }
                        invalidate();
                    } else {
                        int i5 = this.O00000Oo;
                        if (f > ((float) (i4 + i5))) {
                            this.O00000oo = i4 + i5;
                            this.O0000o00 = Color.HSVToColor(this.O0000o0);
                            this.O0000OOo.setColor(this.O0000o00);
                            ColorPicker colorPicker2 = this.O0000o;
                            if (colorPicker2 != null) {
                                colorPicker2.changeValueBarColor(this.O0000o00);
                                this.O0000o.changeOpacityBarColor(this.O0000o00);
                            }
                            invalidate();
                        }
                    }
                } else {
                    this.O00000oo = Math.round(f);
                    O000000o(Math.round(f));
                    this.O0000OOo.setColor(this.O0000o00);
                    ColorPicker colorPicker3 = this.O0000o;
                    if (colorPicker3 != null) {
                        colorPicker3.changeValueBarColor(this.O0000o00);
                        this.O0000o.changeOpacityBarColor(this.O0000o00);
                    }
                    invalidate();
                }
            }
            if (!(this.O0000oO == null || this.O0000oOO == (i = this.O0000o00))) {
                this.O0000oOO = i;
            }
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [float, int, float, float, int[], ?[OBJECT, ARRAY], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    public void setColor(int i) {
        int i2;
        int i3;
        if (this.O0000oO0) {
            i3 = this.O00000Oo + this.O00000oO;
            i2 = this.f9295O000000o;
        } else {
            i3 = this.f9295O000000o;
            i2 = this.O00000Oo + this.O00000oO;
        }
        Color.colorToHSV(i, this.O0000o0);
        this.O0000OoO = new LinearGradient((float) this.O00000oO, 0.0f, (float) i3, (float) i2, new int[]{-1, i}, (float[]) null, Shader.TileMode.CLAMP);
        this.O0000O0o.setShader(this.O0000OoO);
        O000000o(this.O00000oo);
        this.O0000OOo.setColor(this.O0000o00);
        ColorPicker colorPicker = this.O0000o;
        if (colorPicker != null) {
            if (colorPicker.hasValueBar()) {
                this.O0000o.changeValueBarColor(this.O0000o00);
            } else if (this.O0000o.hasOpacityBar()) {
                this.O0000o.changeOpacityBarColor(this.O0000o00);
            }
        }
        invalidate();
    }

    public void setSaturation(float f) {
        this.O00000oo = Math.round(this.O0000o0o * f) + this.O00000oO;
        O000000o(this.O00000oo);
        this.O0000OOo.setColor(this.O0000o00);
        ColorPicker colorPicker = this.O0000o;
        if (colorPicker != null) {
            colorPicker.changeValueBarColor(this.O0000o00);
            this.O0000o.changeOpacityBarColor(this.O0000o00);
        }
        invalidate();
    }

    private void O000000o(int i) {
        int i2 = i - this.O00000oO;
        if (i2 < 0) {
            i2 = 0;
        } else {
            int i3 = this.O00000Oo;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        this.O0000o00 = Color.HSVToColor(new float[]{this.O0000o0[0], this.O0000o0O * ((float) i2), 1.0f});
    }

    public int getColor() {
        return this.O0000o00;
    }

    public void setColorPicker(ColorPicker colorPicker) {
        this.O0000o = colorPicker;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("parent", onSaveInstanceState);
        bundle.putFloatArray("color", this.O0000o0);
        float[] fArr = new float[3];
        Color.colorToHSV(this.O0000o00, fArr);
        bundle.putFloat("saturation", fArr[1]);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("parent"));
        setColor(Color.HSVToColor(bundle.getFloatArray("color")));
        setSaturation(bundle.getFloat("saturation"));
    }
}
