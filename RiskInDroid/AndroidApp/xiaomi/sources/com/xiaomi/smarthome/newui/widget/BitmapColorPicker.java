package com.xiaomi.smarthome.newui.widget;

import _m_j.goq;
import _m_j.gsy;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class BitmapColorPicker extends ImageView {
    private Bitmap bitmap;
    private View.OnTouchListener callback;
    private final Canvas canvas = new Canvas();
    private float mSelectX = -1.0f;
    private float mSelectY = -1.0f;
    private final Paint paint = new Paint();
    private float ratio = -1.0f;
    private int selectColor = -1;
    private int strawPixel = 1;
    private float touchScale = 0.1f;

    public BitmapColorPicker(Context context) {
        super(context);
        init();
    }

    public BitmapColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BitmapColorPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BitmapColorPicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        this.paint.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        float f = this.ratio;
        if (f > 0.0f) {
            setMeasuredDimension(measuredWidth, (int) (((float) measuredWidth) * f));
        }
    }

    public void setRatio(float f) {
        this.ratio = f;
    }

    public void setTouchScale(float f) {
        this.touchScale = f;
    }

    public int getSelectColor() {
        return this.selectColor;
    }

    public void setStrawPixel(int i) {
        this.strawPixel = i;
        this.bitmap = null;
    }

    public void setTouchCallback(View.OnTouchListener onTouchListener) {
        this.callback = onTouchListener;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setColorFilter((ColorFilter) null);
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas2) {
        super.onDraw(canvas2);
        if (this.mSelectX >= 0.0f && this.mSelectY >= 0.0f && isEnabled()) {
            float min = ((float) Math.min(getWidth(), getHeight())) * this.touchScale;
            this.paint.setColor(-7829368);
            float f = 1.05f * min;
            canvas2.drawCircle(this.mSelectX, this.mSelectY, f + 1.0f, this.paint);
            this.paint.setColor(-1);
            canvas2.drawCircle(this.mSelectX, this.mSelectY, f, this.paint);
            if (0.05f * min > 4.0f) {
                this.paint.setColor(-7829368);
                canvas2.drawCircle(this.mSelectX, this.mSelectY, 1.0f + min, this.paint);
            }
            this.paint.setColor(this.selectColor);
            canvas2.drawCircle(this.mSelectX, this.mSelectY, min, this.paint);
        }
    }

    @SuppressLint({"WrongCall"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.bitmap == null) {
            Canvas canvas2 = this.canvas;
            int i = this.strawPixel;
            Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            this.bitmap = createBitmap;
            canvas2.setBitmap(createBitmap);
        }
        this.canvas.save();
        this.canvas.translate(-this.mSelectX, -this.mSelectY);
        super.onDraw(this.canvas);
        int width = this.bitmap.getWidth() * this.bitmap.getHeight();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        while (i2 < this.bitmap.getWidth()) {
            long j5 = j3;
            long j6 = j2;
            long j7 = j;
            long j8 = j4;
            for (int i3 = 0; i3 < this.bitmap.getHeight(); i3++) {
                int pixel = this.bitmap.getPixel(i2, i3);
                j8 += (long) Color.alpha(pixel);
                j7 += (long) Color.red(pixel);
                j6 += (long) Color.green(pixel);
                j5 += (long) Color.blue(pixel);
            }
            i2++;
            j4 = j8;
            j = j7;
            j2 = j6;
            j3 = j5;
        }
        long j9 = (long) width;
        long j10 = j4 / j9;
        long j11 = j / j9;
        long j12 = j2 / j9;
        long j13 = j3 / j9;
        this.mSelectX = motionEvent.getX();
        this.mSelectY = motionEvent.getY();
        this.selectColor = (((int) j10) << 24) | (((int) j11) << 16) | (((int) j12) << 8) | ((int) j13);
        if (this.selectColor == 1) {
            gsy.O000000o(4, "TypeColorCardItem", j10 + " " + j11 + " " + j12 + " " + j13 + " " + width + Log.getStackTraceString(new Exception()));
        }
        View.OnTouchListener onTouchListener = this.callback;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        this.canvas.restore();
        invalidate();
        return true;
    }

    public void setCurrentColor(int i) {
        setCurrentColor(i, 100);
    }

    public void setCurrentColor(int i, int i2) {
        this.selectColor = i;
        $$Lambda$BitmapColorPicker$Yh8SHqammcBMTLvx2g81YXb0AEo r0 = new View.OnLayoutChangeListener(i, i2) {
            /* class com.xiaomi.smarthome.newui.widget.$$Lambda$BitmapColorPicker$Yh8SHqammcBMTLvx2g81YXb0AEo */
            private final /* synthetic */ int f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BitmapColorPicker.this.lambda$setCurrentColor$1$BitmapColorPicker(this.f$1, this.f$2, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        if (getWidth() == 0 && getHeight() == 0) {
            addOnLayoutChangeListener(r0);
        } else {
            r0.onLayoutChange(this, getLeft(), getTop(), getRight(), getBottom(), 0, 0, 0, 0);
        }
    }

    public /* synthetic */ void lambda$setCurrentColor$1$BitmapColorPicker(int i, int i2, View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        goq.O00000o(new Runnable(i, i2) {
            /* class com.xiaomi.smarthome.newui.widget.$$Lambda$BitmapColorPicker$fPJy04ec04Zbl03JmtAlWSmZic */
            private final /* synthetic */ int f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                BitmapColorPicker.this.lambda$null$0$BitmapColorPicker(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$null$0$BitmapColorPicker(int i, int i2) {
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        super.onDraw(new Canvas(createBitmap));
        double d = Double.MAX_VALUE;
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        while (i3 < createBitmap.getWidth()) {
            double d2 = d;
            int i6 = 0;
            while (i6 < createBitmap.getHeight()) {
                int pixel = createBitmap.getPixel(i3, i6);
                int i7 = i3;
                int i8 = alpha;
                int i9 = red;
                double pow = Math.pow((double) (Color.blue(pixel) - blue), 2.0d) + Math.pow((double) (Color.alpha(pixel) - alpha), 2.0d) + Math.pow((double) (Color.red(pixel) - red), 2.0d) + Math.pow((double) (Color.green(pixel) - green), 2.0d);
                if (pow < d2) {
                    d2 = pow;
                    i5 = i6;
                    i4 = i7;
                }
                i6++;
                i3 = i7;
                red = i9;
                alpha = i8;
            }
            i3++;
            d = d2;
        }
        gsy.O000000o(4, "BitmapColorPicker", "setCurrentColor width:" + createBitmap.getWidth() + "  height:" + createBitmap.getHeight() + "  diff:" + d);
        if (this.selectColor == i && ((double) i2) > d) {
            this.mSelectX = (float) i4;
            this.mSelectY = (float) i5;
            postInvalidate();
        }
    }
}
