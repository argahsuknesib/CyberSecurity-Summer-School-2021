package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class GridImageView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    Bitmap[] f9187O000000o;
    String[] O00000Oo;
    Paint O00000o = new Paint();
    boolean O00000o0 = false;

    public GridImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000o.setAntiAlias(true);
    }

    public void setImageFiles(String[] strArr) {
        this.O00000Oo = strArr;
        this.O00000o0 = true;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public int getHorizalBitmapCount() {
        Bitmap[] bitmapArr = this.f9187O000000o;
        if (bitmapArr == null) {
            return 0;
        }
        int length = bitmapArr.length;
        int i = 1;
        if (length != 1) {
            i = 2;
            if (length == 2 || length == 3 || length == 4) {
                return i;
            }
            return 3;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public int getBitmapSize() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.grid_bitmap_margin);
        int horizalBitmapCount = getHorizalBitmapCount();
        return (getWidth() - (dimensionPixelSize * (horizalBitmapCount + 1))) / horizalBitmapCount;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000o0) {
            this.O00000o0 = false;
            String[] strArr = this.O00000Oo;
            if (strArr != null && strArr.length != 0) {
                if (this.f9187O000000o != null) {
                    int i = 0;
                    while (true) {
                        Bitmap[] bitmapArr = this.f9187O000000o;
                        if (i >= bitmapArr.length) {
                            break;
                        }
                        bitmapArr[i].recycle();
                        this.f9187O000000o[i] = null;
                        i++;
                    }
                }
                this.f9187O000000o = new Bitmap[this.O00000Oo.length];
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                int bitmapSize = getBitmapSize();
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.O00000Oo;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    Bitmap decodeFile = BitmapFactory.decodeFile(strArr2[i2], options);
                    Bitmap[] bitmapArr2 = this.f9187O000000o;
                    int width = decodeFile.getWidth();
                    int height = decodeFile.getHeight();
                    if (width != bitmapSize || height != bitmapSize) {
                        float min = ((float) bitmapSize) / ((float) Math.min(width, height));
                        Bitmap.Config config = decodeFile.getConfig();
                        if (config == null) {
                            config = Bitmap.Config.ARGB_8888;
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(bitmapSize, bitmapSize, config);
                        int round = Math.round(((float) decodeFile.getWidth()) * min);
                        int round2 = Math.round(((float) decodeFile.getHeight()) * min);
                        Canvas canvas2 = new Canvas(createBitmap);
                        canvas2.translate(((float) (bitmapSize - round)) / 2.0f, ((float) (bitmapSize - round2)) / 2.0f);
                        canvas2.scale(min, min);
                        canvas2.drawBitmap(decodeFile, 0.0f, 0.0f, new Paint(6));
                        decodeFile.recycle();
                        decodeFile = createBitmap;
                    }
                    bitmapArr2[i2] = decodeFile;
                    i2++;
                }
            }
        }
        Bitmap[] bitmapArr3 = this.f9187O000000o;
        if (bitmapArr3 != null && bitmapArr3.length != 0) {
            int length = bitmapArr3.length;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.grid_bitmap_margin);
            int horizalBitmapCount = getHorizalBitmapCount();
            int width2 = (getWidth() - ((horizalBitmapCount + 1) * dimensionPixelSize)) / horizalBitmapCount;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = width2 + dimensionPixelSize;
                canvas.drawBitmap(this.f9187O000000o[i3], (float) (((i3 % horizalBitmapCount) * i4) + dimensionPixelSize), (float) (((i3 / horizalBitmapCount) * i4) + (dimensionPixelSize * 2)), this.O00000o);
            }
        }
    }
}
