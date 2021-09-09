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

public class WhiteColorPicker extends RelativeLayout implements View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f8592O000000o = "WhiteColorPicker";
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
    private float O0000o;
    private final int O0000o0 = O000000o(12.0f);
    private int O0000o00 = 0;
    private final int O0000o0O;
    private final float O0000o0o;
    private boolean O0000oO;
    private String O0000oO0;

    public interface O00000Oo {
        void O000000o();

        void O000000o(int i, String str, float f);
    }

    public void setWhitePickerListener(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.WhiteColorPicker.O000000o(float, float, float):float
     arg types: [int, int, int]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.WhiteColorPicker.O000000o(int, int, int):int
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.WhiteColorPicker.O000000o(com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableArray, double):void
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.WhiteColorPicker.O000000o(float, float, float):float */
    public WhiteColorPicker(Context context) {
        super(context);
        int i = this.O0000o0;
        this.O0000o0O = i * i;
        this.O0000o0o = (float) Math.sqrt(2.0d);
        this.O0000oO0 = "";
        this.O0000oO = false;
        this.O00000o0 = O000000o(23.0f);
        this.O00000oo = O000000o(1.3f, 1.0f, 2.0f);
        this.O00000o = O000000o(2.0f);
        this.O00000oO = O000000o(0.0f);
        this.O0000O0o = ColorIndicatorView.f8585O000000o;
        O00000Oo();
    }

    public WhiteColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = this.O0000o0;
        this.O0000o0O = i * i;
        this.O0000o0o = (float) Math.sqrt(2.0d);
        this.O0000oO0 = "";
        this.O0000oO = false;
        O000000o();
    }

    public WhiteColorPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = this.O0000o0;
        this.O0000o0O = i2 * i2;
        this.O0000o0o = (float) Math.sqrt(2.0d);
        this.O0000oO0 = "";
        this.O0000oO = false;
        O000000o();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        gbu.O000000o("onMeasure -> height: " + measuredHeight + ", width: " + measuredWidth);
        if (measuredWidth > 0 && measuredHeight > 0) {
            this.O0000OOo = measuredWidth;
            this.O0000Oo0 = measuredHeight;
            int i3 = this.O0000o0;
            this.O0000o = (float) Math.sqrt((double) (((measuredWidth - (i3 * 2)) * (measuredWidth - (i3 * 2))) + ((measuredHeight - (i3 * 2)) * (measuredHeight - (i3 * 2)))));
            this.O0000Ooo = this.O0000OOo / 2;
            this.O0000o00 = this.O0000Oo0 / 2;
            this.O0000Oo.setImageBitmap(O000000o(measuredWidth, measuredHeight, new int[]{Color.parseColor("#EDF4FF"), Color.parseColor("#EDF4FF"), Color.parseColor("#FEFDD9"), Color.parseColor("#FBD26C"), Color.parseColor("#FFB127"), Color.parseColor("#FF9E42"), Color.parseColor("#F67F00")}, new float[]{0.0f, 0.16666667f, 0.33333334f, 0.5f, 0.6666667f, 0.8333333f, 1.0f}, 10.0f));
            O000000o(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        O00000Oo o00000Oo;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (!this.O0000oO && (o00000Oo = this.O00000Oo) != null) {
                o00000Oo.O000000o();
            }
            this.O0000oO = true;
        }
    }

    private void O000000o() {
        this.O00000o0 = O000000o(23.0f);
        this.O00000oo = 1.3f;
        this.O00000o = O000000o(2.0f);
        this.O00000oO = O000000o(0.0f);
        this.O0000O0o = ColorIndicatorView.f8585O000000o;
        O00000Oo();
    }

    public String getJsAccessibilityLabel() {
        return this.O0000oO0;
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
                if (TextUtils.isEmpty(this.O0000oO0)) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            gbu.O00000Oo(e.toString());
            if (TextUtils.isEmpty(this.O0000oO0)) {
            }
        }
        if (TextUtils.isEmpty(this.O0000oO0)) {
            return str;
        }
        return this.O0000oO0 + " " + str;
    }

    public void setJsAccessibilityLabel(String str) {
        this.O0000oO0 = str;
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
        int i2;
        if (!this.O0000oO) {
            getViewTreeObserver().addOnGlobalLayoutListener(new O000000o(i));
            return;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        Bitmap bitmap = ((BitmapDrawable) this.O0000Oo.getDrawable()).getBitmap();
        int O000000o2 = O000000o(getMeasuredWidth(), 1, 1000);
        float measuredWidth = ((float) getMeasuredWidth()) / ((float) O000000o2);
        int i3 = 0;
        while (true) {
            if (i3 >= O000000o2) {
                i2 = -1;
                break;
            }
            i2 = (int) (((float) i3) * measuredWidth);
            if (O000000o(red, green, blue, bitmap.getPixel(i2, (getMeasuredHeight() - 1) - i2))) {
                break;
            }
            i3++;
        }
        int measuredWidth2 = (i2 != -1 || !O000000o(red, green, blue, bitmap.getPixel(getMeasuredWidth() - 1, getMeasuredHeight() - getMeasuredWidth()))) ? i2 : getMeasuredWidth() - 1;
        if (measuredWidth2 == -1) {
            measuredWidth2 = 0;
        }
        this.O0000Ooo = measuredWidth2;
        this.O0000o00 = (getMeasuredHeight() - 1) - this.O0000Ooo;
        O000000o(true);
    }

    private static boolean O000000o(int i, int i2, int i3, int i4) {
        return Math.abs(i - Color.red(i4)) < 5 && Math.abs(i2 - Color.green(i4)) < 5 && Math.abs(i3 - Color.blue(i4)) < 5;
    }

    class O000000o implements ViewTreeObserver.OnGlobalLayoutListener {
        private int O00000Oo;

        O000000o(int i) {
            this.O00000Oo = i;
        }

        public final void onGlobalLayout() {
            WhiteColorPicker.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WhiteColorPicker.this.setColor(this.O00000Oo);
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
        this.O0000OoO.setColor(((BitmapDrawable) this.O0000Oo.getDrawable()).getBitmap().getPixel(this.O0000Ooo, this.O0000o00));
        invalidate();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [float, int, int, float, int[], float[], android.graphics.Shader$TileMode]
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
        float f3 = (float) i4;
        LinearGradient linearGradient = new LinearGradient(f2, 0.0f, 0.0f, f3, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawRect(0.0f, 0.0f, f2, f3, paint);
        Bitmap createBitmap2 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Rect rect = new Rect(0, 0, i3, i4);
        RectF rectF = new RectF(new Rect(0, 0, i3, i4));
        paint.reset();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        int i5 = this.O0000o0;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(createBitmap, new Rect(0, 0, i3, i4), rect, paint);
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

    private boolean O00000Oo(int i, int i2, int i3, int i4) {
        int i5 = this.O0000o0;
        if (i >= i5 || i2 >= i5) {
            int i6 = this.O0000o0;
            if (i >= i6 || i2 < i4 - i6) {
                int i7 = this.O0000o0;
                if (i < i3 - i7 || i2 >= i7) {
                    int i8 = this.O0000o0;
                    if (i >= i3 - i8 && i2 >= i4 - i8) {
                        int i9 = (i - i3) + i8;
                        int i10 = (i2 - i4) + i8;
                        if ((i9 * i9) + (i10 * i10) > this.O0000o0O) {
                            return true;
                        }
                    }
                    return false;
                }
                int i11 = (i - i3) + i7;
                int i12 = i7 - i2;
                return (i11 * i11) + (i12 * i12) > this.O0000o0O;
            }
            int i13 = i6 - i;
            int i14 = (i2 - i4) + i6;
            return (i13 * i13) + (i14 * i14) > this.O0000o0O;
        }
        int i15 = i5 - i;
        int i16 = i5 - i2;
        return (i15 * i15) + (i16 * i16) > this.O0000o0O;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.O0000OoO.setActivate(true);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int O000000o2 = O000000o(((int) motionEvent.getRawX()) - iArr[0], 0, getWidth() - 1);
            int O000000o3 = O000000o(((int) motionEvent.getRawY()) - iArr[1], 0, getHeight() - 1);
            if (O00000Oo(O000000o2, O000000o3, this.O0000OOo, this.O0000Oo0)) {
                return false;
            }
            this.O0000Ooo = O000000o2;
            this.O0000o00 = O000000o3;
            O000000o(true);
        } else if (motionEvent.getAction() == 2) {
            int[] iArr2 = new int[2];
            getLocationOnScreen(iArr2);
            int O000000o4 = O000000o(((int) motionEvent.getRawX()) - iArr2[0], 0, getWidth() - 1);
            int O000000o5 = O000000o(((int) motionEvent.getRawY()) - iArr2[1], 0, getHeight() - 1);
            if (O00000Oo(O000000o4, O000000o5, this.O0000OOo, this.O0000Oo0)) {
                return false;
            }
            this.O0000Ooo = O000000o4;
            this.O0000o00 = O000000o5;
            float O00000o02 = O00000o0(this.O0000Ooo, this.O0000o00, this.O0000OOo, this.O0000Oo0);
            O000000o(true);
            O00000Oo o00000Oo = this.O00000Oo;
            if (o00000Oo != null) {
                o00000Oo.O000000o(getColor(), "continueTracking", O00000o02);
            }
        } else if (motionEvent.getAction() == 1) {
            this.O0000OoO.setActivate(false);
            float O00000o03 = O00000o0(this.O0000Ooo, this.O0000o00, this.O0000OOo, this.O0000Oo0);
            O00000Oo o00000Oo2 = this.O00000Oo;
            if (o00000Oo2 != null) {
                o00000Oo2.O000000o(getColor(), "endTracking", O00000o03);
            }
        } else if (motionEvent.getAction() == 3) {
            this.O0000OoO.setActivate(false);
            float O00000o04 = O00000o0(this.O0000Ooo, this.O0000o00, this.O0000OOo, this.O0000Oo0);
            O00000Oo o00000Oo3 = this.O00000Oo;
            if (o00000Oo3 != null) {
                o00000Oo3.O000000o(getColor(), "cancelTracking", O00000o04);
            }
        }
        return true;
    }

    private float O00000o0(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        int i5 = this.O0000o0;
        if (i > i5 || i2 < i3 - i5) {
            int i6 = this.O0000o0;
            if (i < i4 - i6 || i2 > i6) {
                int i7 = this.O0000o0;
                int O000000o2 = O000000o(i, i7, i4 - i7);
                int i8 = this.O0000o0;
                int i9 = O000000o2 - i8;
                int O000000o3 = O000000o(i2, i8, i3 - i8);
                int i10 = this.O0000o0;
                int i11 = O000000o3 - i10;
                int i12 = i3 - (i10 * 2);
                int i13 = i4 - (i10 * 2);
                if (i12 != i13) {
                    gbu.O000000o("WhiteColorPicker not a square, width not equals to height");
                }
                int i14 = i12 - i11;
                if (i9 >= i14) {
                    float f3 = this.O0000o0o;
                    f = ((float) i9) * f3;
                    f2 = ((float) (i9 - i14)) / f3;
                } else {
                    int i15 = i13 - i9;
                    float f4 = this.O0000o0o;
                    f2 = (((float) i15) * f4) - (((float) (i15 - i11)) / f4);
                    f = this.O0000o;
                }
                float O000000o4 = 1.0f - O000000o((f - f2) / this.O0000o, 0.0f, 1.0f);
                gbu.O00000o0("ratio: ".concat(String.valueOf(O000000o4)));
                return O000000o4;
            }
            gbu.O00000o0("ratio: 0.0");
            return 0.0f;
        }
        gbu.O00000o0("ratio: 1.0");
        return 1.0f;
    }

    private static int O000000o(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private static float O000000o(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }
}
