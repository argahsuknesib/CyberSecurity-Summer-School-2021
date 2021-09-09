package com.xiaomi.smarthome.library.common.widget.crop;

import _m_j.gra;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

public class ImageViewTouchBase extends ImageView {
    protected Matrix mBaseMatrix = new Matrix();
    protected final gra mBitmapDisplayed = new gra(null);
    int mBottom;
    private final Matrix mDisplayMatrix = new Matrix();
    protected Handler mHandler = new Handler();
    int mLeft;
    private final float[] mMatrixValues = new float[9];
    float mMaxZoom;
    private Runnable mOnLayoutRunnable = null;
    private O000000o mRecycler;
    int mRight;
    protected Matrix mSuppMatrix = new Matrix();
    int mThisHeight = -1;
    int mThisWidth = -1;
    int mTop;

    public interface O000000o {
    }

    public void setRecycler(O000000o o000000o) {
        this.mRecycler = o000000o;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mLeft = i;
        this.mRight = i3;
        this.mTop = i2;
        this.mBottom = i4;
        this.mThisWidth = i3 - i;
        this.mThisHeight = i4 - i2;
        Runnable runnable = this.mOnLayoutRunnable;
        if (runnable != null) {
            this.mOnLayoutRunnable = null;
            runnable.run();
        }
        if (this.mBitmapDisplayed.f18174O000000o != null) {
            getProperBaseMatrix(this.mBitmapDisplayed, this.mBaseMatrix);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || getScale() <= 1.0f) {
            return super.onKeyDown(i, keyEvent);
        }
        zoomTo(1.0f);
        return true;
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, 0);
    }

    private void setImageBitmap(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        gra gra = this.mBitmapDisplayed;
        gra.f18174O000000o = bitmap;
        gra.O00000Oo = i;
    }

    public void clear() {
        setImageBitmapResetBase(null, true);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        setImageRotateBitmapResetBase(new gra(bitmap), z);
    }

    public void setImageRotateBitmapResetBase(final gra gra, final boolean z) {
        if (getWidth() <= 0) {
            this.mOnLayoutRunnable = new Runnable() {
                /* class com.xiaomi.smarthome.library.common.widget.crop.ImageViewTouchBase.AnonymousClass1 */

                public final void run() {
                    ImageViewTouchBase.this.setImageRotateBitmapResetBase(gra, z);
                }
            };
            return;
        }
        if (gra.f18174O000000o != null) {
            getProperBaseMatrix(gra, this.mBaseMatrix);
            setImageBitmap(gra.f18174O000000o, gra.O00000Oo);
        } else {
            this.mBaseMatrix.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.mSuppMatrix.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.mMaxZoom = maxZoom();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    public void center(boolean z, boolean z2) {
        float f;
        float f2;
        float height;
        float f3;
        if (this.mBitmapDisplayed.f18174O000000o != null) {
            Matrix imageViewMatrix = getImageViewMatrix();
            float f4 = 0.0f;
            RectF rectF = new RectF(0.0f, 0.0f, (float) this.mBitmapDisplayed.f18174O000000o.getWidth(), (float) this.mBitmapDisplayed.f18174O000000o.getHeight());
            imageViewMatrix.mapRect(rectF);
            float height2 = rectF.height();
            float width = rectF.width();
            if (z2) {
                float height3 = (float) getHeight();
                if (height2 < height3) {
                    height = (height3 - height2) / 2.0f;
                    f3 = rectF.top;
                } else if (rectF.top > 0.0f) {
                    f = -rectF.top;
                    if (z) {
                        float width2 = (float) getWidth();
                        if (width < width2) {
                            width2 = (width2 - width) / 2.0f;
                            f2 = rectF.left;
                        } else if (rectF.left > 0.0f) {
                            f4 = -rectF.left;
                        } else if (rectF.right < width2) {
                            f2 = rectF.right;
                        }
                        f4 = width2 - f2;
                    }
                    postTranslate(f4, f);
                    setImageMatrix(getImageViewMatrix());
                } else if (rectF.bottom < height3) {
                    height = (float) getHeight();
                    f3 = rectF.bottom;
                }
                f = height - f3;
                if (z) {
                }
                postTranslate(f4, f);
                setImageMatrix(getImageViewMatrix());
            }
            f = 0.0f;
            if (z) {
            }
            postTranslate(f4, f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* access modifiers changed from: protected */
    public float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    /* access modifiers changed from: protected */
    public float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    /* access modifiers changed from: protected */
    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    private void getProperBaseMatrix(gra gra, Matrix matrix) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float O00000Oo = (float) gra.O00000Oo();
        float O000000o2 = (float) gra.O000000o();
        matrix.reset();
        float min = Math.min(Math.min(width / O00000Oo, 2.0f), Math.min(height / O000000o2, 2.0f));
        Matrix matrix2 = new Matrix();
        if (gra.O00000Oo != 0) {
            matrix2.preTranslate((float) (-(gra.f18174O000000o.getWidth() / 2)), (float) (-(gra.f18174O000000o.getHeight() / 2)));
            matrix2.postRotate((float) gra.O00000Oo);
            matrix2.postTranslate((float) (gra.O00000Oo() / 2), (float) (gra.O000000o() / 2));
        }
        matrix.postConcat(matrix2);
        matrix.postScale(min, min);
        matrix.postTranslate((width - (O00000Oo * min)) / 2.0f, (height - (O000000o2 * min)) / 2.0f);
    }

    /* access modifiers changed from: protected */
    public Matrix getImageViewMatrix() {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(this.mSuppMatrix);
        return this.mDisplayMatrix;
    }

    /* access modifiers changed from: protected */
    public float maxZoom() {
        if (this.mBitmapDisplayed.f18174O000000o == null) {
            return 1.0f;
        }
        return Math.max(((float) this.mBitmapDisplayed.O00000Oo()) / ((float) this.mThisWidth), ((float) this.mBitmapDisplayed.O000000o()) / ((float) this.mThisHeight)) * 4.0f;
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3) {
        float f4 = this.mMaxZoom;
        if (f > f4) {
            f = f4;
        }
        float scale = f / getScale();
        this.mSuppMatrix.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3, float f4) {
        final float scale = (f - getScale()) / f4;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        final float f5 = f4;
        final float f6 = f2;
        final float f7 = f3;
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.library.common.widget.crop.ImageViewTouchBase.AnonymousClass2 */

            public final void run() {
                float min = Math.min(f5, (float) (System.currentTimeMillis() - currentTimeMillis));
                ImageViewTouchBase.this.zoomTo(scale2 + (scale * min), f6, f7);
                if (min < f5) {
                    ImageViewTouchBase.this.mHandler.post(this);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f) {
        zoomTo(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    /* access modifiers changed from: protected */
    public void zoomIn() {
        zoomIn(1.25f);
    }

    /* access modifiers changed from: protected */
    public void zoomOut() {
        zoomOut(1.25f);
    }

    /* access modifiers changed from: protected */
    public void zoomIn(float f) {
        if (getScale() < this.mMaxZoom && this.mBitmapDisplayed.f18174O000000o != null) {
            this.mSuppMatrix.postScale(f, f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    /* access modifiers changed from: protected */
    public void zoomOut(float f) {
        if (this.mBitmapDisplayed.f18174O000000o != null) {
            float width = ((float) getWidth()) / 2.0f;
            float height = ((float) getHeight()) / 2.0f;
            Matrix matrix = new Matrix(this.mSuppMatrix);
            float f2 = 1.0f / f;
            matrix.postScale(f2, f2, width, height);
            if (getScale(matrix) < 1.0f) {
                this.mSuppMatrix.setScale(1.0f, 1.0f, width, height);
            } else {
                this.mSuppMatrix.postScale(f2, f2, width, height);
            }
            setImageMatrix(getImageViewMatrix());
            center(true, true);
        }
    }

    /* access modifiers changed from: protected */
    public void postTranslate(float f, float f2) {
        this.mSuppMatrix.postTranslate(f, f2);
    }

    /* access modifiers changed from: protected */
    public void panBy(float f, float f2) {
        postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }
}
