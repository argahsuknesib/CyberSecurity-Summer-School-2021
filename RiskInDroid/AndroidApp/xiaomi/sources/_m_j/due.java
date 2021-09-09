package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

public final class due implements uu<Bitmap> {
    private ux O00000Oo = uo.O000000o().O00000Oo();
    private boolean O00000o;
    private float O00000o0;
    private boolean O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;

    public final void O000000o(boolean z, boolean z2, boolean z3, boolean z4) {
        this.O00000o = z;
        this.O00000oO = z2;
        this.O00000oo = z3;
        this.O0000O0o = z4;
    }

    public due(float f) {
        this.O00000o0 = f;
    }

    public final uw<Bitmap> O000000o(Context context, uw<Bitmap> uwVar, int i, int i2) {
        int i3;
        int i4;
        Bitmap O000000o2 = uwVar.O000000o();
        if (i > i2) {
            float f = (float) i2;
            float f2 = (float) i;
            i3 = O000000o2.getWidth();
            i4 = (int) (((float) O000000o2.getWidth()) * (f / f2));
            if (i4 > O000000o2.getHeight()) {
                i4 = O000000o2.getHeight();
                i3 = (int) (((float) O000000o2.getHeight()) * (f2 / f));
            }
        } else if (i < i2) {
            float f3 = (float) i;
            float f4 = (float) i2;
            int height = O000000o2.getHeight();
            int height2 = (int) (((float) O000000o2.getHeight()) * (f3 / f4));
            if (height2 > O000000o2.getWidth()) {
                i3 = O000000o2.getWidth();
                i4 = (int) (((float) O000000o2.getWidth()) * (f4 / f3));
            } else {
                int i5 = height;
                i3 = height2;
                i4 = i5;
            }
        } else {
            i3 = O000000o2.getHeight();
            i4 = i3;
        }
        this.O00000o0 *= ((float) i4) / ((float) i2);
        Bitmap O000000o3 = this.O00000Oo.O000000o(i3, i4, Bitmap.Config.ARGB_8888);
        if (O000000o3 == null) {
            O000000o3 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(O000000o3);
        Paint paint = new Paint();
        paint.setColor(-65536);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(O000000o2, tileMode, tileMode);
        O000000o2.getWidth();
        O000000o2.getHeight();
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        float f5 = this.O00000o0;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        if (this.O00000o) {
            float f6 = this.O00000o0;
            canvas.drawRect(0.0f, 0.0f, f6, f6, paint);
        }
        if (this.O00000oO) {
            canvas.drawRect(((float) canvas.getWidth()) - this.O00000o0, 0.0f, (float) canvas.getWidth(), this.O00000o0, paint);
        }
        if (this.O00000oo) {
            float f7 = this.O00000o0;
            canvas.drawRect(0.0f, ((float) canvas.getHeight()) - f7, f7, (float) canvas.getHeight(), paint);
        }
        if (this.O0000O0o) {
            canvas.drawRect(((float) canvas.getWidth()) - this.O00000o0, ((float) canvas.getHeight()) - this.O00000o0, (float) canvas.getWidth(), (float) canvas.getHeight(), paint);
        }
        return uy.O000000o(O000000o3);
    }
}
