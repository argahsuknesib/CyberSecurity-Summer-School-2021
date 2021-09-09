package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.xiaomi.smarthome.R;

public class ImageFilterViewCopy extends AppCompatImageView {
    private float mCrossfade = 0.0f;
    private O000000o mImageMatrix = new O000000o();
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay = true;
    float mPanX = Float.NaN;
    float mPanY = Float.NaN;
    private Path mPath;
    RectF mRect;
    float mRotate = Float.NaN;
    public float mRound = Float.NaN;
    public float mRoundPercent = 0.0f;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom = Float.NaN;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        float[] f10311O000000o = new float[20];
        ColorMatrix O00000Oo = new ColorMatrix();
        float O00000o = 1.0f;
        ColorMatrix O00000o0 = new ColorMatrix();
        float O00000oO = 1.0f;
        float O00000oo = 1.0f;
        float O0000O0o = 1.0f;

        O000000o() {
        }

        private void O000000o(float f) {
            float f2 = 1.0f - f;
            float f3 = 0.2999f * f2;
            float f4 = 0.587f * f2;
            float f5 = f2 * 0.114f;
            float[] fArr = this.f10311O000000o;
            fArr[0] = f3 + f;
            fArr[1] = f4;
            fArr[2] = f5;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f3;
            fArr[6] = f4 + f;
            fArr[7] = f5;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f3;
            fArr[11] = f4;
            fArr[12] = f5 + f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(float, float):float} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(float, float):float}
         arg types: [float, int]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(long, long):long}
          ClspMth{java.lang.Math.max(float, float):float} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(float, float):float}
         arg types: [int, int]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(long, long):long}
          ClspMth{java.lang.Math.max(float, float):float} */
        private void O00000Oo(float f) {
            float f2;
            float f3;
            if (f <= 0.0f) {
                f = 0.01f;
            }
            float f4 = (5000.0f / f) / 100.0f;
            if (f4 > 66.0f) {
                double d = (double) (f4 - 60.0f);
                f3 = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                f2 = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
            } else {
                f2 = (((float) Math.log((double) f4)) * 99.4708f) - 161.11957f;
                f3 = 255.0f;
            }
            float log = f4 < 66.0f ? f4 > 19.0f ? (((float) Math.log((double) (f4 - 10.0f))) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f3, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f2, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log(50.0d)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log(40.0d)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f10311O000000o;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void O00000o0(float f) {
            float[] fArr = this.f10311O000000o;
            fArr[0] = f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(ImageView imageView) {
            boolean z;
            this.O00000Oo.reset();
            float f = this.O00000oO;
            if (f != 1.0f) {
                O000000o(f);
                this.O00000Oo.set(this.f10311O000000o);
                z = true;
            } else {
                z = false;
            }
            float f2 = this.O00000oo;
            if (f2 != 1.0f) {
                this.O00000o0.setScale(f2, f2, f2, 1.0f);
                this.O00000Oo.postConcat(this.O00000o0);
                z = true;
            }
            float f3 = this.O0000O0o;
            if (f3 != 1.0f) {
                O00000Oo(f3);
                this.O00000o0.set(this.f10311O000000o);
                this.O00000Oo.postConcat(this.O00000o0);
                z = true;
            }
            float f4 = this.O00000o;
            if (f4 != 1.0f) {
                O00000o0(f4);
                this.O00000o0.set(this.f10311O000000o);
                this.O00000Oo.postConcat(this.O00000o0);
                z = true;
            }
            if (z) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.O00000Oo));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public void setImagePanX(float f) {
        this.mPanX = f;
        updateViewMatrix();
    }

    public void setImagePanY(float f) {
        this.mPanY = f;
        updateViewMatrix();
    }

    public void setImageZoom(float f) {
        this.mZoom = f;
        updateViewMatrix();
    }

    public void setImageRotate(float f) {
        this.mRotate = f;
        updateViewMatrix();
    }

    private void updateViewMatrix() {
        if (!Float.isNaN(this.mPanX) || !Float.isNaN(this.mPanY) || !Float.isNaN(this.mZoom) || !Float.isNaN(this.mRotate)) {
            float f = 0.0f;
            float f2 = Float.isNaN(this.mPanX) ? 0.0f : this.mPanX;
            float f3 = Float.isNaN(this.mPanY) ? 0.0f : this.mPanY;
            float f4 = Float.isNaN(this.mZoom) ? 0.0f : this.mZoom;
            if (!Float.isNaN(this.mRotate)) {
                f = this.mRotate;
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            float width = (float) getWidth();
            float height = (float) getHeight();
            float f5 = f4 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
            matrix.postScale(f5, f5);
            float f6 = intrinsicWidth * f5;
            float f7 = f5 * intrinsicHeight;
            matrix.postTranslate((((f2 * (width - f6)) + width) - f6) * 0.5f, (((f3 * (height - f7)) + height) - f7) * 0.5f);
            matrix.postRotate(f, width / 2.0f, height / 2.0f);
            setImageMatrix(matrix);
            setScaleType(ImageView.ScaleType.MATRIX);
            return;
        }
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public ImageFilterViewCopy(Context context) {
        super(context);
        init(context, null);
    }

    public ImageFilterViewCopy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ImageFilterViewCopy(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.sh_altSrc, R.attr.sh_blendSrc, R.attr.sh_brightness, R.attr.sh_contrast, R.attr.sh_crossfade, R.attr.sh_imagePanX, R.attr.sh_imagePanY, R.attr.sh_imageRotate, R.attr.sh_imageZoom, R.attr.sh_overlay, R.attr.sh_round, R.attr.sh_roundPercent, R.attr.sh_saturation, R.attr.sh_warmth});
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 4) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == 13) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 12) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 3) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 2) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 10) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == 11) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == 9) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                } else if (index == 5) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.mPanX));
                } else if (index == 6) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.mPanY));
                } else if (index == 7) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.mRotate));
                } else if (index == 8) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.mZoom));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                this.mLayers = new Drawable[2];
                this.mLayers[0] = getDrawable();
                Drawable[] drawableArr = this.mLayers;
                drawableArr[1] = drawable;
                this.mLayer = new LayerDrawable(drawableArr);
                this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
                if (!this.mOverlay) {
                    this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
                }
                super.setImageDrawable(this.mLayer);
            }
        }
    }

    private void setOverlay(boolean z) {
        this.mOverlay = z;
    }

    public void setSaturation(float f) {
        O000000o o000000o = this.mImageMatrix;
        o000000o.O00000oO = f;
        o000000o.O000000o(this);
    }

    public float getSaturation() {
        return this.mImageMatrix.O00000oO;
    }

    public void setContrast(float f) {
        O000000o o000000o = this.mImageMatrix;
        o000000o.O00000oo = f;
        o000000o.O000000o(this);
    }

    public float getContrast() {
        return this.mImageMatrix.O00000oo;
    }

    public void setWarmth(float f) {
        O000000o o000000o = this.mImageMatrix;
        o000000o.O0000O0o = f;
        o000000o.O000000o(this);
    }

    public float getWarmth() {
        return this.mImageMatrix.O0000O0o;
    }

    public void setCrossfade(float f) {
        this.mCrossfade = f;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public void setBrightness(float f) {
        O000000o o000000o = this.mImageMatrix;
        o000000o.O00000o = f;
        o000000o.O000000o(this);
    }

    public float getBrightness() {
        return this.mImageMatrix.O00000o;
    }

    public void setRoundPercent(float f) {
        boolean z = this.mRoundPercent != f;
        this.mRoundPercent = f;
        if (this.mRoundPercent != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    this.mViewOutlineProvider = new ViewOutlineProvider() {
                        /* class com.xiaomi.smarthome.newui.widget.ImageFilterViewCopy.AnonymousClass1 */

                        public final void getOutline(View view, Outline outline) {
                            int width = ImageFilterViewCopy.this.getWidth();
                            int height = ImageFilterViewCopy.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterViewCopy.this.mRoundPercent) / 2.0f);
                        }
                    };
                    setOutlineProvider(this.mViewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, (float) width, (float) height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.mRound = f;
            float f2 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.mRound != f;
        this.mRound = f;
        if (this.mRound != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    this.mViewOutlineProvider = new ViewOutlineProvider() {
                        /* class com.xiaomi.smarthome.newui.widget.ImageFilterViewCopy.AnonymousClass2 */

                        public final void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterViewCopy.this.getWidth(), ImageFilterViewCopy.this.getHeight(), ImageFilterViewCopy.this.mRound);
                        }
                    };
                    setOutlineProvider(this.mViewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.mRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f3 = this.mRound;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getRound() {
        return this.mRound;
    }

    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.mRoundPercent == 0.0f || this.mPath == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.mPath);
        }
        super.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }
}
