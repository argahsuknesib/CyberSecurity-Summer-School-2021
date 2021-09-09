package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.xiaomi.smarthome.R;

public class ImageFilterButton extends AppCompatImageButton {
    private float mCrossfade = 0.0f;
    private ImageFilterView.O000000o mImageMatrix = new ImageFilterView.O000000o();
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay = true;
    private Path mPath;
    RectF mRect;
    public float mRound = Float.NaN;
    public float mRoundPercent = 0.0f;
    ViewOutlineProvider mViewOutlineProvider;

    public ImageFilterButton(Context context) {
        super(context);
        init(context, null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.altSrc, R.attr.brightness, R.attr.contrast, R.attr.crossfade, R.attr.overlay, R.attr.round, R.attr.roundPercent, R.attr.saturation, R.attr.warmth});
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 3) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == 8) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 7) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 2) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 5) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == 6) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == 4) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
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
                super.setImageDrawable(this.mLayer);
            }
        }
    }

    private void setOverlay(boolean z) {
        this.mOverlay = z;
    }

    public void setSaturation(float f) {
        ImageFilterView.O000000o o000000o = this.mImageMatrix;
        o000000o.O00000oO = f;
        o000000o.O000000o(this);
    }

    public float getSaturation() {
        return this.mImageMatrix.O00000oO;
    }

    public void setContrast(float f) {
        ImageFilterView.O000000o o000000o = this.mImageMatrix;
        o000000o.O00000oo = f;
        o000000o.O000000o(this);
    }

    public float getContrast() {
        return this.mImageMatrix.O00000oo;
    }

    public void setWarmth(float f) {
        ImageFilterView.O000000o o000000o = this.mImageMatrix;
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
        ImageFilterView.O000000o o000000o = this.mImageMatrix;
        o000000o.O00000o = f;
        o000000o.O000000o(this);
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
                        /* class androidx.constraintlayout.utils.widget.ImageFilterButton.AnonymousClass1 */

                        public final void getOutline(View view, Outline outline) {
                            int width = ImageFilterButton.this.getWidth();
                            int height = ImageFilterButton.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.mRoundPercent) / 2.0f);
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
                        /* class androidx.constraintlayout.utils.widget.ImageFilterButton.AnonymousClass2 */

                        public final void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.mRound);
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
        if (Build.VERSION.SDK_INT >= 21 || this.mRound == 0.0f || this.mPath == null) {
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
