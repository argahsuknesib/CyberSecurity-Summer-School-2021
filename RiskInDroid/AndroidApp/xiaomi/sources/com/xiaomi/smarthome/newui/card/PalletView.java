package com.xiaomi.smarthome.newui.card;

import _m_j.gsy;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;

public class PalletView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    float f10222O000000o;
    float O00000Oo;
    boolean O00000o;
    boolean O00000o0;
    boolean O00000oO;
    float O00000oo;
    float O0000O0o;
    private Paint O0000OOo;
    private Paint O0000Oo;
    private Paint O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private final int O0000o;
    private int O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private final int O0000o0o;
    private final int O0000oO;
    private final int O0000oO0;
    private final int O0000oOO;
    private final int O0000oOo;
    private float O0000oo;
    private float O0000oo0;
    private int O0000ooO;
    private int O0000ooo;
    private Bitmap O000O00o;
    private int O000O0OO;
    private int O000O0Oo;
    private int O00oOoOo;
    private int O00oOooO;
    private int O00oOooo;

    public void setmThumbRadiusOutter(int i) {
        this.O0000o00 = i;
    }

    public void setmThumbRadiusInner(int i) {
        this.O0000o0 = i;
    }

    public void setmThumbShadowRadius(int i) {
        this.O0000o0O = i;
    }

    public void setColorThumbOuter(int i) {
        this.O000O0Oo = i;
    }

    public void setColorThumbInner(int i) {
        this.O00oOoOo = i;
    }

    public void setThumbRadiusOutter(int i) {
        this.O0000o00 = i;
    }

    public void setThumbRadiusInner(int i) {
        this.O0000o0 = i;
    }

    public PalletView(Context context) {
        this(context, null);
    }

    public PalletView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PalletView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OOo = new Paint();
        this.O0000Oo0 = new Paint(1);
        this.O0000Oo = new Paint(1);
        this.O0000OoO = -1;
        this.O0000Ooo = -1;
        this.O0000oo0 = -1.0f;
        this.O0000oo = -1.0f;
        this.f10222O000000o = -1.0f;
        this.O00000Oo = -1.0f;
        this.O00000o0 = false;
        this.O00000o = true;
        this.O00000oO = false;
        this.O000O00o = BitmapFactory.decodeResource(getResources(), R.drawable.pallet_nor);
        this.O000O0OO = 0;
        this.O0000Oo.setColor(-3355444);
        this.O0000Oo.setStyle(Paint.Style.STROKE);
        this.O0000Oo.setStrokeWidth(3.0f);
        this.O0000Oo.setAlpha(150);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.pallet_height, R.attr.pallet_width, R.attr.thumb_inner_color, R.attr.thumb_inner_color_disable, R.attr.thumb_outter_color, R.attr.thumb_outter_color_disable, R.attr.thumb_radius_inner, R.attr.thumb_radius_inner_pressed, R.attr.thumb_radius_outter, R.attr.thumb_radius_outter_pressed, R.attr.thumb_shadow_radius, R.attr.thumb_shadow_radius_pressed}, i, 0);
        this.O0000o0o = (int) obtainStyledAttributes.getDimension(8, 0.0f);
        this.O0000o = (int) obtainStyledAttributes.getDimension(9, 0.0f);
        this.O0000oO0 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
        this.O0000oO = (int) obtainStyledAttributes.getDimension(7, 0.0f);
        this.O0000oOO = (int) obtainStyledAttributes.getDimension(10, 0.0f);
        this.O0000oOo = (int) obtainStyledAttributes.getDimension(11, 0.0f);
        this.O00oOoOo = obtainStyledAttributes.getColor(2, context.getResources().getColor(R.color.mj_color_gradient_yellow_start));
        this.O000O0Oo = obtainStyledAttributes.getColor(4, context.getResources().getColor(R.color.mj_color_white));
        this.O0000o00 = this.O0000o0o;
        this.O0000o0 = this.O0000oO0;
        this.O0000o0O = this.O0000oOO;
        obtainStyledAttributes.recycle();
    }

    public void setColorTempratureMax(int i) {
        this.O0000ooO = i;
    }

    public void setBrightMax(int i) {
        this.O0000ooo = i;
    }

    public void setBrightMin(int i) {
        this.O00oOooO = i;
    }

    public void setColorTempratureMin(int i) {
        this.O00oOooo = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
     arg types: [float, int, int, int]
     candidates:
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() > 0 && getHeight() > 0) {
            this.O0000Oo0.setShadowLayer((float) this.O0000o0O, 2.0f, 2.0f, 1145324612);
            this.O0000Oo0.setAntiAlias(true);
            this.O0000Oo0.setColor(this.O000O0Oo);
            canvas.drawCircle(this.O0000oo0, this.O0000oo, (float) this.O0000o00, this.O0000Oo0);
            canvas.drawCircle(this.O0000oo0, this.O0000oo, (float) this.O0000o00, this.O0000Oo);
            this.O0000Oo0.clearShadowLayer();
            this.O0000Oo0.setColor(this.O00oOoOo);
            canvas.drawCircle(this.O0000oo0, this.O0000oo, (float) this.O0000o0, this.O0000Oo0);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0 && this.O0000oo0 == -1.0f && this.O0000oo == -1.0f) {
            this.O0000oo0 = (float) (getWidth() / 2);
            this.O0000oo = (float) (getHeight() / 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x00f4;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O00000o) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.O00000oO) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        this.O0000oo0 += x - this.O00000oo;
                        this.O0000oo += y - this.O0000O0o;
                        this.O00000oo = x;
                        this.O0000O0o = y;
                        invalidate();
                    }
                }
            }
            if (this.O00000oO) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.O0000oo0 += x2 - this.O00000oo;
                this.O0000oo += y2 - this.O0000O0o;
                this.O00000oo = x2;
                this.O0000O0o = y2;
                invalidate();
            }
            this.O00000oO = false;
        } else {
            this.O00000oo = motionEvent.getX();
            this.O0000O0o = motionEvent.getY();
            float f = this.O00000oo;
            float f2 = this.O0000O0o;
            double sqrt = Math.sqrt((double) ((Math.abs(f - this.O0000oo0) * Math.abs(f - this.O0000oo0)) + (Math.abs(f2 - this.O0000oo) * Math.abs(f2 - this.O0000oo))));
            gsy.O000000o(4, "PalletView", "distance:" + sqrt + ",radius:" + this.O0000o00 + "pointerX:" + f + " ,pointerY:" + f2 + ",centerX:" + this.O0000oo0 + " ,centerY:" + this.O0000oo);
            if (sqrt <= ((double) this.O0000o00)) {
                this.O00000oO = true;
            } else {
                this.O00000oO = false;
            }
        }
        return true;
    }
}
