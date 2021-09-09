package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;
import java.util.HashMap;

public class ColorSeekbar extends PopSeekbar {
    Bitmap O0000Oo;
    Paint O0000OoO;
    Paint O0000Ooo;
    HashMap<Integer, Integer> O0000o0;
    int O0000o00;

    public ColorSeekbar(Context context) {
        super(context);
        O00000o0();
    }

    public ColorSeekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o0();
    }

    private void O00000o0() {
        this.O0000OoO = new Paint();
        this.O0000OoO.setStyle(Paint.Style.FILL);
        this.O0000OoO.setFlags(1);
        this.O0000OoO.setColor(-16777216);
        this.O0000Ooo = new Paint();
        this.O0000Ooo.setStyle(Paint.Style.STROKE);
        this.O0000Ooo.setFlags(1);
        this.O0000Ooo.setColor(Color.parseColor("#dfdfdf"));
        this.O0000Ooo.setStrokeWidth(1.0f);
        this.O0000o00 = gri.O000000o(8.0f);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.color_seekbar_bg);
        this.O0000Oo = bitmapDrawable.getBitmap();
        setProgressDrawable(bitmapDrawable);
        this.O0000o.setVisibility(0);
        this.O0000o0o.setVisibility(8);
        this.O0000oO = 100;
        O00000o();
    }

    private void O00000o() {
        this.O0000o0 = new HashMap<>();
        int showMax = getShowMax();
        if (showMax > 0) {
            for (int i = 0; i < showMax; i++) {
                int O000000o2 = O000000o(i);
                this.O0000o0.put(Integer.valueOf(O00000Oo(O000000o2)), Integer.valueOf(O000000o2));
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            int centerX = this.O00000oo.getBounds().centerX();
            this.O0000OoO.setColor(getSeekColor());
            float f = (float) centerX;
            float height = (float) (((getHeight() / 2) - gri.O000000o(1.0f)) - 1);
            canvas.drawCircle(f, height, (float) this.O0000o00, this.O0000OoO);
            canvas.drawCircle(f, height, (float) this.O0000o00, this.O0000Ooo);
        } catch (Exception unused) {
        }
    }

    public void setShowMax(int i) {
        super.setShowMax(i);
        O00000o();
    }

    public void setSeekColor(int i) {
        HashMap<Integer, Integer> hashMap = this.O0000o0;
        if (hashMap != null) {
            Integer num = hashMap.get(Integer.valueOf(i));
            if (num != null) {
                setProgress(num.intValue());
                return;
            }
            Integer num2 = null;
            double d = -1.0d;
            for (Integer next : this.O0000o0.keySet()) {
                int intValue = next.intValue();
                double red = (double) ((Color.red(intValue) + Color.red(i)) / 2);
                int red2 = Color.red(intValue) - Color.red(i);
                int green = Color.green(intValue) - Color.green(i);
                Double.isNaN(red);
                Double.isNaN(red);
                double d2 = (double) red2;
                Double.isNaN(d2);
                Double.isNaN(d2);
                double d3 = (double) green;
                Double.isNaN(d3);
                Double.isNaN(d3);
                double blue = (double) (Color.blue(intValue) - Color.blue(i));
                Double.isNaN(blue);
                Double.isNaN(blue);
                double sqrt = Math.sqrt((((red / 256.0d) + 2.0d) * d2 * d2) + (4.0d * d3 * d3) + ((((255.0d - red) / 256.0d) + 2.0d) * blue * blue));
                if (d < 0.0d || sqrt < d) {
                    num2 = next;
                    d = sqrt;
                }
            }
            if (num2 != null) {
                setProgress(this.O0000o0.get(num2).intValue());
            }
        }
    }

    public int getSeekColor() {
        return O00000Oo(getProgress());
    }

    private int O00000Oo(int i) {
        int width = (i * this.O0000Oo.getWidth()) / getMax();
        int height = this.O0000Oo.getHeight() / 2;
        if (width < this.O0000Oo.getWidth()) {
            return this.O0000Oo.getPixel(width, height);
        }
        Bitmap bitmap = this.O0000Oo;
        return bitmap.getPixel(bitmap.getWidth() - 1, height);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(float f, boolean z) {
        super.O000000o(f, z);
        ((GradientDrawable) this.O0000o.getDrawable()).setColor(getSeekColor());
    }
}
