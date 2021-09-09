package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.xiaomi.smarthome.R;

final class o0O0O0o0 extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    static O000000o f2236O000000o;
    private static final double O0000O0o = Math.cos(Math.toRadians(45.0d));
    float O00000Oo;
    float O00000o;
    float O00000o0;
    ColorStateList O00000oO;
    boolean O00000oo = true;
    private final int O0000OOo;
    private Paint O0000Oo;
    private Paint O0000Oo0;
    private Paint O0000OoO;
    private final RectF O0000Ooo;
    private boolean O0000o = true;
    private float O0000o0;
    private Path O0000o00;
    private final int O0000o0O;
    private final int O0000o0o;
    private boolean O0000oO0 = false;

    interface O000000o {
        void O000000o(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public final int getOpacity() {
        return -3;
    }

    o0O0O0o0(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.O0000o0O = resources.getColor(R.color.cardview_shadow_start_color);
        this.O0000o0o = resources.getColor(R.color.cardview_shadow_end_color);
        this.O0000OOo = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.O0000Oo0 = new Paint(5);
        O000000o(colorStateList);
        this.O0000Oo = new Paint(5);
        this.O0000Oo.setStyle(Paint.Style.FILL);
        this.O00000Oo = (float) ((int) (f + 0.5f));
        this.O0000Ooo = new RectF();
        this.O0000OoO = new Paint(this.O0000Oo);
        this.O0000OoO.setAntiAlias(false);
        O000000o(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.O00000oO = colorStateList;
        this.O0000Oo0.setColor(this.O00000oO.getColorForState(getState(), this.O00000oO.getDefaultColor()));
    }

    private static int O000000o(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) {
        this.O0000o = z;
        invalidateSelf();
    }

    public final void setAlpha(int i) {
        this.O0000Oo0.setAlpha(i);
        this.O0000Oo.setAlpha(i);
        this.O0000OoO.setAlpha(i);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.O00000oo = true;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 >= 0.0f) {
            float O000000o2 = (float) O000000o(f);
            float O000000o3 = (float) O000000o(f2);
            if (O000000o2 > O000000o3) {
                if (!this.O0000oO0) {
                    this.O0000oO0 = true;
                }
                O000000o2 = O000000o3;
            }
            if (this.O00000o != O000000o2 || this.O00000o0 != O000000o3) {
                this.O00000o = O000000o2;
                this.O00000o0 = O000000o3;
                this.O0000o0 = (float) ((int) ((O000000o2 * 1.5f) + ((float) this.O0000OOo) + 0.5f));
                this.O00000oo = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) O000000o(this.O00000o0, this.O00000Oo, this.O0000o));
        int ceil2 = (int) Math.ceil((double) O00000Oo(this.O00000o0, this.O00000Oo, this.O0000o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float O000000o(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        double d = (double) (f * 1.5f);
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (d + ((1.0d - O0000O0o) * d2));
    }

    static float O00000Oo(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = (double) f;
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (d + ((1.0d - O0000O0o) * d2));
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.O00000oO;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.O0000Oo0.getColor() == colorForState) {
            return false;
        }
        this.O0000Oo0.setColor(colorForState);
        this.O00000oo = true;
        invalidateSelf();
        return true;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.O00000oO;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.O0000Oo0.setColorFilter(colorFilter);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, int, float, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, float, int, float, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2 = canvas;
        if (this.O00000oo) {
            Rect bounds = getBounds();
            float f = this.O00000o0 * 1.5f;
            this.O0000Ooo.set(((float) bounds.left) + this.O00000o0, ((float) bounds.top) + f, ((float) bounds.right) - this.O00000o0, ((float) bounds.bottom) - f);
            float f2 = this.O00000Oo;
            RectF rectF = new RectF(-f2, -f2, f2, f2);
            RectF rectF2 = new RectF(rectF);
            float f3 = this.O0000o0;
            rectF2.inset(-f3, -f3);
            Path path = this.O0000o00;
            if (path == null) {
                this.O0000o00 = new Path();
            } else {
                path.reset();
            }
            this.O0000o00.setFillType(Path.FillType.EVEN_ODD);
            this.O0000o00.moveTo(-this.O00000Oo, 0.0f);
            this.O0000o00.rLineTo(-this.O0000o0, 0.0f);
            this.O0000o00.arcTo(rectF2, 180.0f, 90.0f, false);
            this.O0000o00.arcTo(rectF, 270.0f, -90.0f, false);
            this.O0000o00.close();
            float f4 = this.O00000Oo;
            float f5 = this.O0000o0;
            Paint paint = this.O0000Oo;
            int i2 = this.O0000o0O;
            RadialGradient radialGradient = r12;
            RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f4 + f5, new int[]{i2, i2, this.O0000o0o}, new float[]{0.0f, f4 / (f4 + f5), 1.0f}, Shader.TileMode.CLAMP);
            paint.setShader(radialGradient);
            Paint paint2 = this.O0000OoO;
            float f6 = this.O00000Oo;
            float f7 = this.O0000o0;
            int i3 = this.O0000o0O;
            paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i3, i3, this.O0000o0o}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.O0000OoO.setAntiAlias(false);
            this.O00000oo = false;
        }
        canvas2.translate(0.0f, this.O00000o / 2.0f);
        float f8 = this.O00000Oo;
        float f9 = (-f8) - this.O0000o0;
        float f10 = f8 + ((float) this.O0000OOo) + (this.O00000o / 2.0f);
        float f11 = f10 * 2.0f;
        boolean z = this.O0000Ooo.width() - f11 > 0.0f;
        boolean z2 = this.O0000Ooo.height() - f11 > 0.0f;
        int save = canvas.save();
        canvas2.translate(this.O0000Ooo.left + f10, this.O0000Ooo.top + f10);
        canvas2.drawPath(this.O0000o00, this.O0000Oo);
        if (z) {
            i = save;
            canvas.drawRect(0.0f, f9, this.O0000Ooo.width() - f11, -this.O00000Oo, this.O0000OoO);
        } else {
            i = save;
        }
        canvas2.restoreToCount(i);
        int save2 = canvas.save();
        canvas2.translate(this.O0000Ooo.right - f10, this.O0000Ooo.bottom - f10);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.O0000o00, this.O0000Oo);
        if (z) {
            canvas.drawRect(0.0f, f9, this.O0000Ooo.width() - f11, (-this.O00000Oo) + this.O0000o0, this.O0000OoO);
        }
        canvas2.restoreToCount(save2);
        int save3 = canvas.save();
        canvas2.translate(this.O0000Ooo.left + f10, this.O0000Ooo.bottom - f10);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.O0000o00, this.O0000Oo);
        if (z2) {
            canvas.drawRect(0.0f, f9, this.O0000Ooo.height() - f11, -this.O00000Oo, this.O0000OoO);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        canvas2.translate(this.O0000Ooo.right - f10, this.O0000Ooo.top + f10);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.O0000o00, this.O0000Oo);
        if (z2) {
            canvas.drawRect(0.0f, f9, this.O0000Ooo.height() - f11, -this.O00000Oo, this.O0000OoO);
        }
        canvas2.restoreToCount(save4);
        canvas2.translate(0.0f, (-this.O00000o) / 2.0f);
        f2236O000000o.O000000o(canvas2, this.O0000Ooo, this.O00000Oo, this.O0000Oo0);
    }

    /* access modifiers changed from: package-private */
    public final float O000000o() {
        float f = this.O00000o0;
        return (Math.max(f, this.O00000Oo + ((float) this.O0000OOo) + (f / 2.0f)) * 2.0f) + ((this.O00000o0 + ((float) this.O0000OOo)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public final float O00000Oo() {
        float f = this.O00000o0;
        return (Math.max(f, this.O00000Oo + ((float) this.O0000OOo) + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.O00000o0 * 1.5f) + ((float) this.O0000OOo)) * 2.0f);
    }
}
