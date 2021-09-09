package _m_j;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;

public final class gqv extends Drawable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Paint f18160O000000o;
    public Shader.TileMode O00000Oo = Shader.TileMode.CLAMP;
    public boolean O00000o = true;
    public Shader.TileMode O00000o0 = Shader.TileMode.CLAMP;
    public float O00000oO = 0.0f;
    public final boolean[] O00000oo = {true, true, true, true};
    public boolean O0000O0o = false;
    public float O0000OOo = 0.0f;
    public ImageView.ScaleType O0000Oo = ImageView.ScaleType.FIT_CENTER;
    public ColorStateList O0000Oo0 = ColorStateList.valueOf(-16777216);
    private final RectF O0000OoO = new RectF();
    private final RectF O0000Ooo = new RectF();
    private final int O0000o;
    private final Bitmap O0000o0;
    private final RectF O0000o00 = new RectF();
    private final Paint O0000o0O;
    private final int O0000o0o;
    private final Matrix O0000oO = new Matrix();
    private final RectF O0000oO0 = new RectF();
    private final RectF O0000oOO = new RectF();

    public final int getOpacity() {
        return -3;
    }

    private gqv(Bitmap bitmap) {
        this.O0000o0 = bitmap;
        this.O0000o0o = bitmap.getWidth();
        this.O0000o = bitmap.getHeight();
        this.O0000o00.set(0.0f, 0.0f, (float) this.O0000o0o, (float) this.O0000o);
        this.O0000o0O = new Paint();
        this.O0000o0O.setStyle(Paint.Style.FILL);
        this.O0000o0O.setAntiAlias(true);
        this.f18160O000000o = new Paint();
        this.f18160O000000o.setStyle(Paint.Style.STROKE);
        this.f18160O000000o.setAntiAlias(true);
        this.f18160O000000o.setColor(this.O0000Oo0.getColorForState(getState(), -16777216));
        this.f18160O000000o.setStrokeWidth(this.O0000OOo);
    }

    public static gqv O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            return new gqv(bitmap);
        }
        return null;
    }

    public static Drawable O000000o(Drawable drawable) {
        if (drawable == null || (drawable instanceof gqv)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), O000000o(layerDrawable.getDrawable(i)));
            }
            return layerDrawable;
        }
        Bitmap O00000Oo2 = O00000Oo(drawable);
        return O00000Oo2 != null ? new gqv(O00000Oo2) : drawable;
    }

    private static Bitmap O00000Oo(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            gsy.O000000o(5, "RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public final boolean isStateful() {
        return this.O0000Oo0.isStateful();
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        int colorForState = this.O0000Oo0.getColorForState(iArr, 0);
        if (this.f18160O000000o.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f18160O000000o.setColor(colorForState);
        return true;
    }

    /* renamed from: _m_j.gqv$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f18161O000000o = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f18161O000000o[ImageView.ScaleType.CENTER.ordinal()] = 1;
            f18161O000000o[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            f18161O000000o[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            f18161O000000o[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            f18161O000000o[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            f18161O000000o[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            try {
                f18161O000000o[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O000000o() {
        float f;
        float f2;
        float f3;
        int i = AnonymousClass1.f18161O000000o[this.O0000Oo.ordinal()];
        if (i == 1) {
            this.O0000oO0.set(this.O0000OoO);
            RectF rectF = this.O0000oO0;
            float f4 = this.O0000OOo;
            rectF.inset(f4 / 2.0f, f4 / 2.0f);
            this.O0000oO.reset();
            this.O0000oO.setTranslate((float) ((int) (((this.O0000oO0.width() - ((float) this.O0000o0o)) * 0.5f) + 0.5f)), (float) ((int) (((this.O0000oO0.height() - ((float) this.O0000o)) * 0.5f) + 0.5f)));
        } else if (i == 2) {
            this.O0000oO0.set(this.O0000OoO);
            RectF rectF2 = this.O0000oO0;
            float f5 = this.O0000OOo;
            rectF2.inset(f5 / 2.0f, f5 / 2.0f);
            this.O0000oO.reset();
            float f6 = 0.0f;
            if (((float) this.O0000o0o) * this.O0000oO0.height() > this.O0000oO0.width() * ((float) this.O0000o)) {
                f2 = this.O0000oO0.height() / ((float) this.O0000o);
                f = (this.O0000oO0.width() - (((float) this.O0000o0o) * f2)) * 0.5f;
            } else {
                f2 = this.O0000oO0.width() / ((float) this.O0000o0o);
                f6 = (this.O0000oO0.height() - (((float) this.O0000o) * f2)) * 0.5f;
                f = 0.0f;
            }
            this.O0000oO.setScale(f2, f2);
            Matrix matrix = this.O0000oO;
            float f7 = this.O0000OOo;
            matrix.postTranslate(((float) ((int) (f + 0.5f))) + (f7 / 2.0f), ((float) ((int) (f6 + 0.5f))) + (f7 / 2.0f));
        } else if (i == 3) {
            this.O0000oO.reset();
            if (((float) this.O0000o0o) > this.O0000OoO.width() || ((float) this.O0000o) > this.O0000OoO.height()) {
                f3 = Math.min(this.O0000OoO.width() / ((float) this.O0000o0o), this.O0000OoO.height() / ((float) this.O0000o));
            } else {
                f3 = 1.0f;
            }
            this.O0000oO.setScale(f3, f3);
            this.O0000oO.postTranslate((float) ((int) (((this.O0000OoO.width() - (((float) this.O0000o0o) * f3)) * 0.5f) + 0.5f)), (float) ((int) (((this.O0000OoO.height() - (((float) this.O0000o) * f3)) * 0.5f) + 0.5f)));
            this.O0000oO0.set(this.O0000o00);
            this.O0000oO.mapRect(this.O0000oO0);
            RectF rectF3 = this.O0000oO0;
            float f8 = this.O0000OOo;
            rectF3.inset(f8 / 2.0f, f8 / 2.0f);
            this.O0000oO.setRectToRect(this.O0000o00, this.O0000oO0, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.O0000oO0.set(this.O0000o00);
            this.O0000oO.setRectToRect(this.O0000o00, this.O0000OoO, Matrix.ScaleToFit.END);
            this.O0000oO.mapRect(this.O0000oO0);
            RectF rectF4 = this.O0000oO0;
            float f9 = this.O0000OOo;
            rectF4.inset(f9 / 2.0f, f9 / 2.0f);
            this.O0000oO.setRectToRect(this.O0000o00, this.O0000oO0, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.O0000oO0.set(this.O0000o00);
            this.O0000oO.setRectToRect(this.O0000o00, this.O0000OoO, Matrix.ScaleToFit.START);
            this.O0000oO.mapRect(this.O0000oO0);
            RectF rectF5 = this.O0000oO0;
            float f10 = this.O0000OOo;
            rectF5.inset(f10 / 2.0f, f10 / 2.0f);
            this.O0000oO.setRectToRect(this.O0000o00, this.O0000oO0, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.O0000oO0.set(this.O0000o00);
            this.O0000oO.setRectToRect(this.O0000o00, this.O0000OoO, Matrix.ScaleToFit.CENTER);
            this.O0000oO.mapRect(this.O0000oO0);
            RectF rectF6 = this.O0000oO0;
            float f11 = this.O0000OOo;
            rectF6.inset(f11 / 2.0f, f11 / 2.0f);
            this.O0000oO.setRectToRect(this.O0000o00, this.O0000oO0, Matrix.ScaleToFit.FILL);
        } else {
            this.O0000oO0.set(this.O0000OoO);
            RectF rectF7 = this.O0000oO0;
            float f12 = this.O0000OOo;
            rectF7.inset(f12 / 2.0f, f12 / 2.0f);
            this.O0000oO.reset();
            this.O0000oO.setRectToRect(this.O0000o00, this.O0000oO0, Matrix.ScaleToFit.FILL);
        }
        this.O0000Ooo.set(this.O0000oO0);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.O0000OoO.set(rect);
        O000000o();
    }

    public final void draw(Canvas canvas) {
        if (this.O00000o) {
            BitmapShader bitmapShader = new BitmapShader(this.O0000o0, this.O00000Oo, this.O00000o0);
            if (this.O00000Oo == Shader.TileMode.CLAMP && this.O00000o0 == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.O0000oO);
            }
            this.O0000o0O.setShader(bitmapShader);
            this.O00000o = false;
        }
        if (this.O0000O0o) {
            if (this.O0000OOo > 0.0f) {
                canvas.drawOval(this.O0000Ooo, this.O0000o0O);
                canvas.drawOval(this.O0000oO0, this.f18160O000000o);
                return;
            }
            canvas.drawOval(this.O0000Ooo, this.O0000o0O);
        } else if (O000000o(this.O00000oo)) {
            float f = this.O00000oO;
            if (this.O0000OOo > 0.0f) {
                canvas.drawRoundRect(this.O0000Ooo, f, f, this.O0000o0O);
                canvas.drawRoundRect(this.O0000oO0, f, f, this.f18160O000000o);
                O000000o(canvas);
                if (!O00000Oo(this.O00000oo) && this.O00000oO != 0.0f) {
                    float f2 = this.O0000Ooo.left;
                    float f3 = this.O0000Ooo.top;
                    float width = f2 + this.O0000Ooo.width();
                    float height = f3 + this.O0000Ooo.height();
                    float f4 = this.O00000oO;
                    float f5 = this.O0000OOo / 2.0f;
                    if (!this.O00000oo[0]) {
                        canvas.drawLine(f2 - f5, f3, f2 + f4, f3, this.f18160O000000o);
                        canvas.drawLine(f2, f3 - f5, f2, f3 + f4, this.f18160O000000o);
                    }
                    if (!this.O00000oo[1]) {
                        Canvas canvas2 = canvas;
                        float f6 = width;
                        canvas2.drawLine((width - f4) - f5, f3, f6, f3, this.f18160O000000o);
                        canvas2.drawLine(width, f3 - f5, f6, f3 + f4, this.f18160O000000o);
                    }
                    if (!this.O00000oo[2]) {
                        Canvas canvas3 = canvas;
                        float f7 = height;
                        canvas3.drawLine((width - f4) - f5, height, width + f5, f7, this.f18160O000000o);
                        canvas3.drawLine(width, height - f4, width, f7, this.f18160O000000o);
                    }
                    if (!this.O00000oo[3]) {
                        canvas.drawLine(f2 - f5, height, f2 + f4, height, this.f18160O000000o);
                        canvas.drawLine(f2, height - f4, f2, height, this.f18160O000000o);
                        return;
                    }
                    return;
                }
                return;
            }
            canvas.drawRoundRect(this.O0000Ooo, f, f, this.O0000o0O);
            O000000o(canvas);
        } else {
            canvas.drawRect(this.O0000Ooo, this.O0000o0O);
            if (this.O0000OOo > 0.0f) {
                canvas.drawRect(this.O0000oO0, this.f18160O000000o);
            }
        }
    }

    private void O000000o(Canvas canvas) {
        if (!O00000Oo(this.O00000oo) && this.O00000oO != 0.0f) {
            float f = this.O0000Ooo.left;
            float f2 = this.O0000Ooo.top;
            float width = this.O0000Ooo.width() + f;
            float height = this.O0000Ooo.height() + f2;
            float f3 = this.O00000oO;
            if (!this.O00000oo[0]) {
                this.O0000oOO.set(f, f2, f + f3, f2 + f3);
                canvas.drawRect(this.O0000oOO, this.O0000o0O);
            }
            if (!this.O00000oo[1]) {
                this.O0000oOO.set(width - f3, f2, width, f3);
                canvas.drawRect(this.O0000oOO, this.O0000o0O);
            }
            if (!this.O00000oo[2]) {
                this.O0000oOO.set(width - f3, height - f3, width, height);
                canvas.drawRect(this.O0000oOO, this.O0000o0O);
            }
            if (!this.O00000oo[3]) {
                this.O0000oOO.set(f, height - f3, f3 + f, height);
                canvas.drawRect(this.O0000oOO, this.O0000o0O);
            }
        }
    }

    public final int getAlpha() {
        return this.O0000o0O.getAlpha();
    }

    public final void setAlpha(int i) {
        this.O0000o0O.setAlpha(i);
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.O0000o0O.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void setDither(boolean z) {
        this.O0000o0O.setDither(z);
        invalidateSelf();
    }

    public final void setFilterBitmap(boolean z) {
        this.O0000o0O.setFilterBitmap(z);
        invalidateSelf();
    }

    public final int getIntrinsicWidth() {
        return this.O0000o0o;
    }

    public final int getIntrinsicHeight() {
        return this.O0000o;
    }

    private static boolean O000000o(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean O00000Oo(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
