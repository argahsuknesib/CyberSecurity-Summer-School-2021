package com.xiaomi.smarthome.library.common.widget;

import _m_j.gqv;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import java.util.HashSet;

public class RoundedImageView extends ImageView {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Shader.TileMode DEFAULT_TILE_MODE = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] SCALE_TYPES = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Drawable mBackgroundDrawable;
    private int mBackgroundResource;
    private ColorStateList mBorderColor;
    private float mBorderWidth;
    private ColorFilter mColorFilter;
    private boolean mColorMod;
    private final float[] mCornerRadii;
    private Drawable mDrawable;
    private boolean mHasColorFilter;
    private boolean mIsOval;
    private boolean mMutateBackground;
    private int mResource;
    private ImageView.ScaleType mScaleType;
    private Shader.TileMode mTileModeX;
    private Shader.TileMode mTileModeY;

    public RoundedImageView(Context context) {
        super(context);
        this.mCornerRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.mBorderColor = ColorStateList.valueOf(-16777216);
        this.mBorderWidth = 0.0f;
        this.mColorFilter = null;
        this.mColorMod = false;
        this.mHasColorFilter = false;
        this.mIsOval = false;
        this.mMutateBackground = false;
        Shader.TileMode tileMode = DEFAULT_TILE_MODE;
        this.mTileModeX = tileMode;
        this.mTileModeY = tileMode;
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCornerRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.mBorderColor = ColorStateList.valueOf(-16777216);
        this.mBorderWidth = 0.0f;
        this.mColorFilter = null;
        this.mColorMod = false;
        this.mHasColorFilter = false;
        this.mIsOval = false;
        this.mMutateBackground = false;
        Shader.TileMode tileMode = DEFAULT_TILE_MODE;
        this.mTileModeX = tileMode;
        this.mTileModeY = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843037, R.attr.riv_border_color, R.attr.riv_border_width, R.attr.riv_corner_radius, R.attr.riv_corner_radius_bottom_left, R.attr.riv_corner_radius_bottom_right, R.attr.riv_corner_radius_top_left, R.attr.riv_corner_radius_top_right, R.attr.riv_mutate_background, R.attr.riv_oval, R.attr.riv_tile_mode, R.attr.riv_tile_mode_x, R.attr.riv_tile_mode_y}, i, 0);
        int i2 = obtainStyledAttributes.getInt(0, -1);
        if (i2 >= 0) {
            setScaleType(SCALE_TYPES[i2]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(3, -1);
        this.mCornerRadii[0] = (float) obtainStyledAttributes.getDimensionPixelSize(6, -1);
        this.mCornerRadii[1] = (float) obtainStyledAttributes.getDimensionPixelSize(7, -1);
        this.mCornerRadii[2] = (float) obtainStyledAttributes.getDimensionPixelSize(5, -1);
        this.mCornerRadii[3] = (float) obtainStyledAttributes.getDimensionPixelSize(4, -1);
        int length = this.mCornerRadii.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            float[] fArr = this.mCornerRadii;
            if (fArr[i3] < 0.0f) {
                fArr[i3] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.mCornerRadii.length;
            for (int i4 = 0; i4 < length2; i4++) {
                this.mCornerRadii[i4] = dimensionPixelSize;
            }
        }
        this.mBorderWidth = (float) obtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (this.mBorderWidth < 0.0f) {
            this.mBorderWidth = 0.0f;
        }
        this.mBorderColor = obtainStyledAttributes.getColorStateList(1);
        if (this.mBorderColor == null) {
            this.mBorderColor = ColorStateList.valueOf(-16777216);
        }
        this.mMutateBackground = obtainStyledAttributes.getBoolean(8, false);
        this.mIsOval = obtainStyledAttributes.getBoolean(9, false);
        int i5 = obtainStyledAttributes.getInt(10, -2);
        if (i5 != -2) {
            setTileModeX(parseTileMode(i5));
            setTileModeY(parseTileMode(i5));
        }
        int i6 = obtainStyledAttributes.getInt(11, -2);
        if (i6 != -2) {
            setTileModeX(parseTileMode(i6));
        }
        int i7 = obtainStyledAttributes.getInt(12, -2);
        if (i7 != -2) {
            setTileModeY(parseTileMode(i7));
        }
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(true);
        if (this.mMutateBackground) {
            super.setBackgroundDrawable(this.mBackgroundDrawable);
        }
        obtainStyledAttributes.recycle();
    }

    private static Shader.TileMode parseTileMode(int i) {
        if (i == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            switch (AnonymousClass1.f9246O000000o[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
        }
    }

    /* renamed from: com.xiaomi.smarthome.library.common.widget.RoundedImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f9246O000000o = new int[ImageView.ScaleType.values().length];

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
            f9246O000000o[ImageView.ScaleType.CENTER.ordinal()] = 1;
            f9246O000000o[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            f9246O000000o[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            f9246O000000o[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            f9246O000000o[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            f9246O000000o[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            try {
                f9246O000000o[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void setImageDrawable(Drawable drawable) {
        this.mResource = 0;
        this.mDrawable = gqv.O000000o(drawable);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mResource = 0;
        this.mDrawable = gqv.O000000o(bitmap);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    public void setImageResource(int i) {
        if (this.mResource != i) {
            this.mResource = i;
            this.mDrawable = resolveResource();
            updateDrawableAttrs();
            super.setImageDrawable(this.mDrawable);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable resolveResource() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.mResource;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.mResource, e);
                this.mResource = 0;
            }
        }
        return gqv.O000000o(drawable);
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int i) {
        if (this.mBackgroundResource != i) {
            this.mBackgroundResource = i;
            this.mBackgroundDrawable = resolveBackgroundResource();
            setBackgroundDrawable(this.mBackgroundDrawable);
        }
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundDrawable = new ColorDrawable(i);
        setBackgroundDrawable(this.mBackgroundDrawable);
    }

    private Drawable resolveBackgroundResource() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.mBackgroundResource;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.mBackgroundResource, e);
                this.mBackgroundResource = 0;
            }
        }
        return gqv.O000000o(drawable);
    }

    private void updateDrawableAttrs() {
        updateAttrs(this.mDrawable, this.mScaleType);
    }

    private void updateBackgroundDrawableAttrs(boolean z) {
        if (this.mMutateBackground) {
            if (z) {
                this.mBackgroundDrawable = gqv.O000000o(this.mBackgroundDrawable);
            }
            updateAttrs(this.mBackgroundDrawable, ImageView.ScaleType.FIT_XY);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mColorFilter != colorFilter) {
            this.mColorFilter = colorFilter;
            this.mHasColorFilter = true;
            this.mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    private void applyColorMod() {
        Drawable drawable = this.mDrawable;
        if (drawable != null && this.mColorMod) {
            this.mDrawable = drawable.mutate();
            if (this.mHasColorFilter) {
                this.mDrawable.setColorFilter(this.mColorFilter);
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean[]] */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private void updateAttrs(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable != null) {
            boolean z = 0;
            if (drawable instanceof gqv) {
                gqv gqv = (gqv) drawable;
                if (scaleType == null) {
                    scaleType = ImageView.ScaleType.FIT_CENTER;
                }
                if (gqv.O0000Oo != scaleType) {
                    gqv.O0000Oo = scaleType;
                    gqv.O000000o();
                }
                gqv.O0000OOo = this.mBorderWidth;
                gqv.f18160O000000o.setStrokeWidth(gqv.O0000OOo);
                ColorStateList colorStateList = this.mBorderColor;
                if (colorStateList == null) {
                    colorStateList = ColorStateList.valueOf(0);
                }
                gqv.O0000Oo0 = colorStateList;
                gqv.f18160O000000o.setColor(gqv.O0000Oo0.getColorForState(gqv.getState(), -16777216));
                gqv.O0000O0o = this.mIsOval;
                Shader.TileMode tileMode = this.mTileModeX;
                if (gqv.O00000Oo != tileMode) {
                    gqv.O00000Oo = tileMode;
                    gqv.O00000o = true;
                    gqv.invalidateSelf();
                }
                Shader.TileMode tileMode2 = this.mTileModeY;
                if (gqv.O00000o0 != tileMode2) {
                    gqv.O00000o0 = tileMode2;
                    gqv.O00000o = true;
                    gqv.invalidateSelf();
                }
                float[] fArr = this.mCornerRadii;
                if (fArr != null) {
                    float f = fArr[0];
                    float f2 = fArr[1];
                    float f3 = fArr[2];
                    float f4 = fArr[3];
                    HashSet hashSet = new HashSet(4);
                    hashSet.add(Float.valueOf(f));
                    hashSet.add(Float.valueOf(f2));
                    hashSet.add(Float.valueOf(f3));
                    hashSet.add(Float.valueOf(f4));
                    hashSet.remove(Float.valueOf(0.0f));
                    if (hashSet.size() <= 1) {
                        if (!hashSet.isEmpty()) {
                            float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                            if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(floatValue)));
                            }
                            gqv.O00000oO = floatValue;
                        } else {
                            gqv.O00000oO = 0.0f;
                        }
                        gqv.O00000oo[0] = f > 0.0f;
                        gqv.O00000oo[1] = f2 > 0.0f;
                        gqv.O00000oo[2] = f3 > 0.0f;
                        ? r11 = gqv.O00000oo;
                        if (f4 > 0.0f) {
                            z = 1;
                        }
                        r11[3] = z;
                    } else {
                        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
                    }
                }
                applyColorMod();
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                while (z < numberOfLayers) {
                    updateAttrs(layerDrawable.getDrawable(z), scaleType);
                    z++;
                }
            }
        }
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackgroundDrawable = drawable;
        updateBackgroundDrawableAttrs(true);
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f = 0.0f;
        for (float max : this.mCornerRadii) {
            f = Math.max(max, f);
        }
        return f;
    }

    public float getCornerRadius(int i) {
        return this.mCornerRadii[i];
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        setCornerRadius(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadiusDimen(int i, int i2) {
        setCornerRadius(i, (float) getResources().getDimensionPixelSize(i2));
    }

    public void setCornerRadius(float f) {
        setCornerRadius(f, f, f, f);
    }

    public void setCornerRadius(int i, float f) {
        float[] fArr = this.mCornerRadii;
        if (fArr[i] != f) {
            fArr[i] = f;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
        }
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        float[] fArr = this.mCornerRadii;
        if (fArr[0] != f || fArr[1] != f2 || fArr[2] != f4 || fArr[3] != f3) {
            float[] fArr2 = this.mCornerRadii;
            fArr2[0] = f;
            fArr2[1] = f2;
            fArr2[3] = f3;
            fArr2[2] = f4;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
        }
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.mBorderColor.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.mBorderColor;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.mBorderColor.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(-16777216);
            }
            this.mBorderColor = colorStateList;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            if (this.mBorderWidth > 0.0f) {
                invalidate();
            }
        }
    }

    public boolean isOval() {
        return this.mIsOval;
    }

    public void setOval(boolean z) {
        this.mIsOval = z;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.mTileModeX;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.mTileModeX != tileMode) {
            this.mTileModeX = tileMode;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
        }
    }

    public Shader.TileMode getTileModeY() {
        return this.mTileModeY;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.mTileModeY != tileMode) {
            this.mTileModeY = tileMode;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
        }
    }

    public boolean mutatesBackground() {
        return this.mMutateBackground;
    }

    public void mutateBackground(boolean z) {
        if (this.mMutateBackground != z) {
            this.mMutateBackground = z;
            updateBackgroundDrawableAttrs(true);
            invalidate();
        }
    }
}
