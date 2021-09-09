package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

public final class duf extends dud {
    private float O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private boolean O00000oO;
    private boolean O00000oo;

    public duf(float f) {
        this.O00000Oo = f;
    }

    public final void O000000o(boolean z, boolean z2, boolean z3, boolean z4) {
        this.O00000o0 = z;
        this.O00000o = z2;
        this.O00000oO = z3;
        this.O00000oo = z4;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        if (r10 > r9.getHeight()) goto L_0x0038;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7  */
    public final Bitmap O000000o(ux uxVar, Bitmap bitmap, int i, int i2) {
        int i3;
        if (i > i2) {
            i3 = (int) (((float) bitmap.getWidth()) * (((float) i2) / ((float) i)));
        } else if (i < i2) {
            float f = (float) i;
            float f2 = (float) i2;
            int height = bitmap.getHeight();
            if (((int) (((float) bitmap.getHeight()) * (f / f2))) > bitmap.getWidth()) {
                i3 = (int) (((float) bitmap.getWidth()) * (f2 / f));
            } else {
                i3 = height;
            }
            this.O00000Oo *= ((float) i3) / ((float) i2);
            Bitmap O000000o2 = uxVar.O000000o(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            O000000o2.setHasAlpha(true);
            Canvas canvas = new Canvas(O000000o2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            float f3 = this.O00000Oo;
            canvas.drawRoundRect(rectF, f3, f3, paint);
            if (this.O00000o0) {
                float f4 = this.O00000Oo;
                canvas.drawRect(0.0f, 0.0f, f4, f4, paint);
            }
            if (this.O00000o) {
                canvas.drawRect(((float) canvas.getWidth()) - this.O00000Oo, 0.0f, (float) canvas.getWidth(), this.O00000Oo, paint);
            }
            if (this.O00000oO) {
                float f5 = this.O00000Oo;
                canvas.drawRect(0.0f, ((float) canvas.getHeight()) - f5, f5, (float) canvas.getHeight(), paint);
            }
            if (this.O00000oo) {
                canvas.drawRect(((float) canvas.getWidth()) - this.O00000Oo, ((float) canvas.getHeight()) - this.O00000Oo, (float) canvas.getWidth(), (float) canvas.getHeight(), paint);
            }
            return O000000o2;
        }
        i3 = bitmap.getHeight();
        this.O00000Oo *= ((float) i3) / ((float) i2);
        Bitmap O000000o22 = uxVar.O000000o(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        O000000o22.setHasAlpha(true);
        Canvas canvas2 = new Canvas(O000000o22);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(bitmap, tileMode2, tileMode2));
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) canvas2.getWidth(), (float) canvas2.getHeight());
        float f32 = this.O00000Oo;
        canvas2.drawRoundRect(rectF2, f32, f32, paint2);
        if (this.O00000o0) {
        }
        if (this.O00000o) {
        }
        if (this.O00000oO) {
        }
        if (this.O00000oo) {
        }
        return O000000o22;
    }
}
