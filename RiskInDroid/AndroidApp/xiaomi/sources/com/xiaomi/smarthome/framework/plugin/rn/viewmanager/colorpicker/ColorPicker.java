package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker;

import _m_j.gbg;
import _m_j.gbu;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.react.bridge.ReadableArray;
import java.util.Locale;

public class ColorPicker extends RelativeLayout implements View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f8588O000000o = "ColorPicker";
    private O00000Oo O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private float O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private ImageView O0000Oo;
    private int O0000Oo0;
    private ColorIndicatorView O0000OoO;
    private int O0000Ooo = 0;
    private boolean O0000o;
    private final int O0000o0 = O000000o(12.0f);
    private int O0000o00 = 0;
    private final int O0000o0O;
    private String O0000o0o;

    public interface O00000Oo {
        void O000000o();

        void O000000o(int i, String str);
    }

    public void setColorPickerListener(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    public ColorPicker(Context context) {
        super(context);
        int i = this.O0000o0;
        this.O0000o0O = i * i;
        this.O0000o0o = "";
        this.O0000o = false;
        this.O00000o0 = O000000o(23.0f);
        this.O00000oo = 1.3f;
        this.O00000o = O000000o(2.0f);
        this.O00000oO = O000000o(0.0f);
        this.O0000O0o = ColorIndicatorView.f8585O000000o;
        O00000Oo();
    }

    public ColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = this.O0000o0;
        this.O0000o0O = i * i;
        this.O0000o0o = "";
        this.O0000o = false;
        O000000o();
    }

    public ColorPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = this.O0000o0;
        this.O0000o0O = i2 * i2;
        this.O0000o0o = "";
        this.O0000o = false;
        O000000o();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        gbu.O000000o(f8588O000000o + ": onMeasure -> height: " + measuredHeight + ", width: " + measuredWidth);
        if (measuredWidth > 0 && measuredHeight > 0) {
            this.O0000OOo = measuredWidth;
            this.O0000Oo0 = measuredHeight;
            this.O0000Ooo = this.O0000OOo / 2;
            this.O0000o00 = this.O0000Oo0 / 2;
            this.O0000Oo.setImageBitmap(O000000o(measuredWidth, measuredHeight, new int[]{Color.parseColor("#E6312E"), Color.parseColor("#E6842E"), Color.parseColor("#E6D72E"), Color.parseColor("#98E62E"), Color.parseColor("#2EE62F"), Color.parseColor("#2EE67C"), Color.parseColor("#2ED5E6"), Color.parseColor("#2E79E6"), Color.parseColor("#302EE6"), Color.parseColor("#7D2EE6"), Color.parseColor("#E62EE3"), Color.parseColor("#E62EB5"), Color.parseColor("#E6312E")}, new float[]{0.0f, 0.083333336f, 0.16666667f, 0.25f, 0.33333334f, 0.41666666f, 0.5f, 0.5833333f, 0.6666667f, 0.75f, 0.8333333f, 0.9166667f, 1.0f}, 10.0f));
            O000000o(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        O00000Oo o00000Oo;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (!this.O0000o && (o00000Oo = this.O00000Oo) != null) {
                o00000Oo.O000000o();
            }
            this.O0000o = true;
        }
    }

    private void O000000o() {
        this.O00000o0 = O000000o(23.0f);
        this.O00000oo = O000000o(1.3f, 1.0f, 2.0f);
        this.O00000o = O000000o(2.0f);
        this.O00000oO = O000000o(0.0f);
        this.O0000O0o = ColorIndicatorView.f8585O000000o;
        O00000Oo();
    }

    public String getJsAccessibilityLabel() {
        return this.O0000o0o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    public String getAccessibilityLabel() {
        String str = "";
        try {
            String format = String.format("#%06x", Integer.valueOf(16777215 & getColor()));
            try {
                str = format.replace(str, " ");
            } catch (Exception e) {
                String str2 = format;
                e = e;
                str = str2;
                gbu.O00000Oo(e.toString());
                if (TextUtils.isEmpty(this.O0000o0o)) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            gbu.O00000Oo(e.toString());
            if (TextUtils.isEmpty(this.O0000o0o)) {
            }
        }
        if (TextUtils.isEmpty(this.O0000o0o)) {
            return str;
        }
        return this.O0000o0o + " " + str;
    }

    public void setJsAccessibilityLabel(String str) {
        this.O0000o0o = str;
    }

    private void O00000Oo() {
        this.O0000Oo = new ImageView(getContext());
        this.O0000Oo.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.O0000Oo);
        this.O0000OoO = new ColorIndicatorView(getContext(), this.O00000o0, this.O00000oo, this.O00000o, this.O00000oO, this.O0000O0o);
        int i = ((int) ((this.O00000oo * ((float) this.O00000o0)) + ((float) this.O00000oO))) * 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.setMargins(0, 0, 0, 0);
        this.O0000OoO.setLayoutParams(layoutParams);
        this.O0000OoO.setVisibility(4);
        addView(this.O0000OoO);
        setOnTouchListener(this);
    }

    private int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getColor() {
        return this.O0000OoO.getColor();
    }

    public void setColor(int i) {
        if (!this.O0000o) {
            getViewTreeObserver().addOnGlobalLayoutListener(new O000000o(i));
            return;
        }
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        int height = (int) (((float) getHeight()) - (((O000000o(fArr[1], 0.2f, 1.0f) - 0.2f) / 0.8f) * ((float) getHeight())));
        this.O0000Ooo = O000000o((int) ((fArr[0] / 360.0f) * ((float) getWidth())), getWidth() - 1);
        this.O0000o00 = O000000o(height, getHeight() - 1);
        O000000o(true);
    }

    class O000000o implements ViewTreeObserver.OnGlobalLayoutListener {
        private int O00000Oo;

        O000000o(int i) {
            this.O00000Oo = i;
        }

        public final void onGlobalLayout() {
            ColorPicker.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ColorPicker.this.setColor(this.O00000Oo);
        }
    }

    private void O000000o(boolean z) {
        if (z && this.O0000OoO.getVisibility() != 0) {
            this.O0000OoO.setVisibility(0);
        }
        ColorIndicatorView colorIndicatorView = this.O0000OoO;
        colorIndicatorView.setX((float) (this.O0000Ooo - (colorIndicatorView.getWidth() / 2)));
        ColorIndicatorView colorIndicatorView2 = this.O0000OoO;
        colorIndicatorView2.setY((float) (this.O0000o00 - (colorIndicatorView2.getHeight() / 2)));
        int pixel = ((BitmapDrawable) this.O0000Oo.getDrawable()).getBitmap().getPixel(this.O0000Ooo, this.O0000o00);
        float[] fArr = new float[3];
        Color.colorToHSV(pixel, fArr);
        float f = fArr[0];
        float f2 = fArr[2];
        float height = ((((float) (getHeight() - this.O0000o00)) / ((float) getHeight())) * 0.8f) + 0.2f;
        if (getHeight() == 0) {
            this.O0000OoO.setColor(pixel);
        } else {
            this.O0000OoO.setColor(Color.HSVToColor(new float[]{f, height, f2}));
        }
        invalidate();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, int, float, int, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [float, int, float, float, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    private Bitmap O000000o(int i, int i2, int[] iArr, float[] fArr, float f) {
        int i3 = i;
        int i4 = i2;
        gbu.O000000o(String.format(Locale.getDefault(), "width: %d, height: %d", Integer.valueOf(i), Integer.valueOf(i2)));
        float f2 = (float) i3;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f2, 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
        float f3 = (float) (i3 / 2);
        float f4 = (float) i4;
        LinearGradient linearGradient2 = new LinearGradient(f3, 0.0f, f3, f4, new int[]{Color.parseColor("#20FFFFFF"), Color.parseColor("#C0FFFFFF")}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f5 = f4;
        Paint paint2 = paint;
        canvas.drawRect(0.0f, 0.0f, f2, f5, paint2);
        paint.setShader(linearGradient2);
        canvas.drawRect(0.0f, 0.0f, f2, f5, paint2);
        Bitmap createBitmap2 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap2);
        Rect rect = new Rect(0, 0, i3, i4);
        RectF rectF = new RectF(new Rect(0, 0, i3, i4));
        paint.reset();
        paint.setAntiAlias(true);
        canvas2.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        int i5 = this.O0000o0;
        canvas2.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas2.drawBitmap(createBitmap, new Rect(0, 0, i3, i4), rect, paint);
        gbg.O000000o(getContext(), createBitmap2, f);
        return createBitmap2;
    }

    public final void O000000o(ReadableArray readableArray, ReadableArray readableArray2, double d) {
        float[] fArr;
        gbu.O000000o("configDrawPickerWithColors, colors: " + readableArray + ", positions: " + readableArray2 + ", blurRadius: " + d);
        int[] iArr = new int[readableArray.size()];
        float f = (float) d;
        for (int i = 0; i < readableArray.size(); i++) {
            iArr[i] = Color.parseColor(readableArray.getString(i));
        }
        if (readableArray2 == null || readableArray2.size() <= 0) {
            fArr = null;
        } else {
            fArr = new float[readableArray2.size()];
            for (int i2 = 0; i2 < readableArray2.size(); i2++) {
                fArr[i2] = (float) readableArray2.getDouble(i2);
            }
        }
        this.O0000Oo.setImageBitmap(O000000o(this.O0000OOo, this.O0000Oo0, iArr, fArr, f));
        O000000o(false);
    }

    private boolean O000000o(int i, int i2, int i3, int i4) {
        int i5 = this.O0000o0;
        if (i > i5 || i2 > i5) {
            int i6 = this.O0000o0;
            if (i > i6 || i2 < i4 - i6) {
                int i7 = this.O0000o0;
                if (i < i3 - i7 || i2 > i7) {
                    int i8 = this.O0000o0;
                    if (i >= i3 - i8 && i2 >= i4 - i8) {
                        int i9 = (i - i3) + i8;
                        int i10 = (i2 - i4) + i8;
                        if ((i9 * i9) + (i10 * i10) >= this.O0000o0O) {
                            return true;
                        }
                    }
                    return false;
                }
                int i11 = (i - i3) + i7;
                int i12 = i7 - i2;
                return (i11 * i11) + (i12 * i12) >= this.O0000o0O;
            }
            int i13 = i6 - i;
            int i14 = (i2 - i4) + i6;
            return (i13 * i13) + (i14 * i14) >= this.O0000o0O;
        }
        int i15 = i5 - i;
        int i16 = i5 - i2;
        return (i15 * i15) + (i16 * i16) >= this.O0000o0O;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.O0000OoO.setActivate(true);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int O000000o2 = O000000o(((int) motionEvent.getRawX()) - iArr[0], getWidth() - 1);
            int O000000o3 = O000000o(((int) motionEvent.getRawY()) - iArr[1], getHeight() - 1);
            if (O000000o(O000000o2, O000000o3, this.O0000OOo, this.O0000Oo0)) {
                return false;
            }
            this.O0000Ooo = O000000o2;
            this.O0000o00 = O000000o3;
            O000000o(true);
        } else if (motionEvent.getAction() == 2) {
            int[] iArr2 = new int[2];
            getLocationOnScreen(iArr2);
            int O000000o4 = O000000o(((int) motionEvent.getRawX()) - iArr2[0], getWidth() - 1);
            int O000000o5 = O000000o(((int) motionEvent.getRawY()) - iArr2[1], getHeight() - 1);
            if (O000000o(O000000o4, O000000o5, this.O0000OOo, this.O0000Oo0)) {
                return false;
            }
            this.O0000Ooo = O000000o4;
            this.O0000o00 = O000000o5;
            O000000o(true);
            O00000Oo o00000Oo = this.O00000Oo;
            if (o00000Oo != null) {
                o00000Oo.O000000o(getColor(), "continueTracking");
            }
        } else if (motionEvent.getAction() == 1) {
            this.O0000OoO.setActivate(false);
            O00000Oo o00000Oo2 = this.O00000Oo;
            if (o00000Oo2 != null) {
                o00000Oo2.O000000o(getColor(), "endTracking");
            }
        } else if (motionEvent.getAction() == 3) {
            this.O0000OoO.setActivate(false);
            O00000Oo o00000Oo3 = this.O00000Oo;
            if (o00000Oo3 != null) {
                o00000Oo3.O000000o(getColor(), "cancelTracking");
            }
        }
        return true;
    }

    private static int O000000o(int i, int i2) {
        return Math.min(Math.max(i, 0), i2);
    }

    private static float O000000o(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }
}
