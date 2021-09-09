package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.Locale;

public class ReactViewBackgroundDrawable extends Drawable {
    private int mAlpha = 255;
    private Spacing mBorderAlpha;
    private float[] mBorderCornerRadii;
    private Spacing mBorderRGB;
    private float mBorderRadius = Float.NaN;
    private BorderStyle mBorderStyle;
    private Spacing mBorderWidth;
    private Path mCenterDrawPath;
    private int mColor = 0;
    private final Context mContext;
    private PointF mInnerBottomLeftCorner;
    private PointF mInnerBottomRightCorner;
    private Path mInnerClipPathForBorderRadius;
    private RectF mInnerClipTempRectForBorderRadius;
    private PointF mInnerTopLeftCorner;
    private PointF mInnerTopRightCorner;
    private int mLayoutDirection;
    private boolean mNeedUpdatePathForBorderRadius = false;
    private Path mOuterClipPathForBorderRadius;
    private RectF mOuterClipTempRectForBorderRadius;
    private final Paint mPaint = new Paint(1);
    private PathEffect mPathEffectForBorderStyle;
    private Path mPathForBorder;
    private Path mPathForBorderRadiusOutline;
    private RectF mTempRectForBorderRadiusOutline;
    private RectF mTempRectForCenterDrawPath;

    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    private static int colorFromAlphaAndRGBComponents(float f, float f2) {
        return ((((int) f) << 24) & -16777216) | (((int) f2) & 16777215);
    }

    private static int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = -1;
        int i10 = (i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1);
        if (i4 > 0) {
            i9 = i8;
        }
        int i11 = i9 & i10;
        if (i <= 0) {
            i5 = 0;
        }
        if (i2 <= 0) {
            i6 = 0;
        }
        int i12 = i5 | i6;
        if (i3 <= 0) {
            i7 = 0;
        }
        int i13 = i12 | i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        if (i11 == (i13 | i8)) {
            return i11;
        }
        return 0;
    }

    public boolean onResolvedLayoutDirectionChanged(int i) {
        return false;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* renamed from: com.facebook.react.views.view.ReactViewBackgroundDrawable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle = new int[BorderStyle.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[BorderStyle.SOLID.ordinal()] = 1;
            $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[BorderStyle.DASHED.ordinal()] = 2;
            try {
                $SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[BorderStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED;

        public static PathEffect getPathEffect(BorderStyle borderStyle, float f) {
            int i = AnonymousClass1.$SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[borderStyle.ordinal()];
            if (i == 1) {
                return null;
            }
            if (i == 2) {
                float f2 = f * 3.0f;
                return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
            } else if (i != 3) {
                return null;
            } else {
                return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
            }
        }
    }

    public ReactViewBackgroundDrawable(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        updatePathEffect();
        if (!hasRoundedBorders()) {
            drawRectangularBackgroundWithBorders(canvas);
        } else {
            drawRoundedBackgroundWithBorders(canvas);
        }
    }

    public boolean hasRoundedBorders() {
        if (!YogaConstants.isUndefined(this.mBorderRadius) && this.mBorderRadius > 0.0f) {
            return true;
        }
        float[] fArr = this.mBorderCornerRadii;
        if (fArr != null) {
            for (float f : fArr) {
                if (!YogaConstants.isUndefined(f) && f > 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getOpacity() {
        return ColorUtil.getOpacityFromColor(ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    public void getOutline(Outline outline) {
        if (Build.VERSION.SDK_INT < 21) {
            super.getOutline(outline);
        } else if ((YogaConstants.isUndefined(this.mBorderRadius) || this.mBorderRadius <= 0.0f) && this.mBorderCornerRadii == null) {
            outline.setRect(getBounds());
        } else {
            updatePath();
            outline.setConvexPath(this.mPathForBorderRadiusOutline);
        }
    }

    public void setBorderWidth(int i, float f) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new Spacing();
        }
        if (!FloatUtil.floatsEqual(this.mBorderWidth.getRaw(i), f)) {
            this.mBorderWidth.set(i, f);
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
                this.mNeedUpdatePathForBorderRadius = true;
            }
            invalidateSelf();
        }
    }

    public void setBorderColor(int i, float f, float f2) {
        setBorderRGB(i, f);
        setBorderAlpha(i, f2);
    }

    private void setBorderRGB(int i, float f) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing(0.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderRGB.getRaw(i), f)) {
            this.mBorderRGB.set(i, f);
            invalidateSelf();
        }
    }

    private void setBorderAlpha(int i, float f) {
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderAlpha.getRaw(i), f)) {
            this.mBorderAlpha.set(i, f);
            invalidateSelf();
        }
    }

    public void setBorderStyle(String str) {
        BorderStyle borderStyle;
        if (str == null) {
            borderStyle = null;
        } else {
            borderStyle = BorderStyle.valueOf(str.toUpperCase(Locale.US));
        }
        if (this.mBorderStyle != borderStyle) {
            this.mBorderStyle = borderStyle;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setRadius(float f) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f)) {
            this.mBorderRadius = f;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(float[], float):void}
     arg types: [float[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void} */
    public void setRadius(float f, int i) {
        if (this.mBorderCornerRadii == null) {
            this.mBorderCornerRadii = new float[8];
            Arrays.fill(this.mBorderCornerRadii, Float.NaN);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i], f)) {
            this.mBorderCornerRadii[i] = f;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public float getFullBorderRadius() {
        if (YogaConstants.isUndefined(this.mBorderRadius)) {
            return 0.0f;
        }
        return this.mBorderRadius;
    }

    public float getBorderRadius(BorderRadiusLocation borderRadiusLocation) {
        return getBorderRadiusOrDefaultTo(Float.NaN, borderRadiusLocation);
    }

    public float getBorderRadiusOrDefaultTo(float f, BorderRadiusLocation borderRadiusLocation) {
        float[] fArr = this.mBorderCornerRadii;
        if (fArr == null) {
            return f;
        }
        float f2 = fArr[borderRadiusLocation.ordinal()];
        return YogaConstants.isUndefined(f2) ? f : f2;
    }

    public void setColor(int i) {
        this.mColor = i;
        invalidateSelf();
    }

    public int getResolvedLayoutDirection() {
        return this.mLayoutDirection;
    }

    public boolean setResolvedLayoutDirection(int i) {
        if (this.mLayoutDirection == i) {
            return false;
        }
        this.mLayoutDirection = i;
        return onResolvedLayoutDirectionChanged(i);
    }

    @VisibleForTesting
    public int getColor() {
        return this.mColor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01c3  */
    private void drawRoundedBackgroundWithBorders(Canvas canvas) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        Canvas canvas2 = canvas;
        updatePath();
        canvas.save();
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            this.mPaint.setColor(multiplyColorAlpha);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas2.drawPath(this.mInnerClipPathForBorderRadius, this.mPaint);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        boolean z = false;
        int borderColor = getBorderColor(0);
        int borderColor2 = getBorderColor(1);
        int borderColor3 = getBorderColor(2);
        int borderColor4 = getBorderColor(3);
        if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.right > 0.0f) {
            float fullBorderWidth = getFullBorderWidth();
            int borderColor5 = getBorderColor(8);
            if (directionAwareBorderInsets.top != fullBorderWidth || directionAwareBorderInsets.bottom != fullBorderWidth || directionAwareBorderInsets.left != fullBorderWidth || directionAwareBorderInsets.right != fullBorderWidth || borderColor != borderColor5 || borderColor2 != borderColor5 || borderColor3 != borderColor5 || borderColor4 != borderColor5) {
                this.mPaint.setStyle(Paint.Style.FILL);
                canvas2.clipPath(this.mOuterClipPathForBorderRadius, Region.Op.INTERSECT);
                canvas2.clipPath(this.mInnerClipPathForBorderRadius, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT >= 17) {
                    if (getResolvedLayoutDirection() == 1) {
                        z = true;
                    }
                    int borderColor6 = getBorderColor(4);
                    int borderColor7 = getBorderColor(5);
                    if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                        if (isBorderColorDefined(4)) {
                            borderColor = borderColor6;
                        }
                        if (isBorderColorDefined(5)) {
                            borderColor3 = borderColor7;
                        }
                        i2 = z ? borderColor3 : borderColor;
                        if (!z) {
                            borderColor = borderColor3;
                        }
                        i = borderColor;
                    } else {
                        int i3 = z ? borderColor7 : borderColor6;
                        if (!z) {
                            borderColor6 = borderColor7;
                        }
                        boolean isBorderColorDefined = isBorderColorDefined(4);
                        boolean isBorderColorDefined2 = isBorderColorDefined(5);
                        boolean z2 = z ? isBorderColorDefined2 : isBorderColorDefined;
                        if (!z) {
                            isBorderColorDefined = isBorderColorDefined2;
                        }
                        if (z2) {
                            borderColor = i3;
                        }
                        if (isBorderColorDefined) {
                            i2 = borderColor;
                            i = borderColor6;
                        }
                    }
                    float f5 = this.mOuterClipTempRectForBorderRadius.left;
                    float f6 = this.mOuterClipTempRectForBorderRadius.right;
                    float f7 = this.mOuterClipTempRectForBorderRadius.top;
                    float f8 = this.mOuterClipTempRectForBorderRadius.bottom;
                    if (directionAwareBorderInsets.left <= 0.0f) {
                        f2 = f8;
                        f3 = f7;
                        f4 = f6;
                        f = f5;
                        drawQuadrilateral(canvas, i2, f5, f7, this.mInnerTopLeftCorner.x, this.mInnerTopLeftCorner.y, this.mInnerBottomLeftCorner.x, this.mInnerBottomLeftCorner.y, f5, f2);
                    } else {
                        f2 = f8;
                        f3 = f7;
                        f4 = f6;
                        f = f5;
                    }
                    if (directionAwareBorderInsets.top > 0.0f) {
                        drawQuadrilateral(canvas, borderColor2, f, f3, this.mInnerTopLeftCorner.x, this.mInnerTopLeftCorner.y, this.mInnerTopRightCorner.x, this.mInnerTopRightCorner.y, f4, f3);
                    }
                    if (directionAwareBorderInsets.right > 0.0f) {
                        drawQuadrilateral(canvas, i, f4, f3, this.mInnerTopRightCorner.x, this.mInnerTopRightCorner.y, this.mInnerBottomRightCorner.x, this.mInnerBottomRightCorner.y, f4, f2);
                    }
                    if (directionAwareBorderInsets.bottom > 0.0f) {
                        drawQuadrilateral(canvas, borderColor4, f, f2, this.mInnerBottomLeftCorner.x, this.mInnerBottomLeftCorner.y, this.mInnerBottomRightCorner.x, this.mInnerBottomRightCorner.y, f4, f2);
                    }
                }
                i2 = borderColor;
                i = borderColor3;
                float f52 = this.mOuterClipTempRectForBorderRadius.left;
                float f62 = this.mOuterClipTempRectForBorderRadius.right;
                float f72 = this.mOuterClipTempRectForBorderRadius.top;
                float f82 = this.mOuterClipTempRectForBorderRadius.bottom;
                if (directionAwareBorderInsets.left <= 0.0f) {
                }
                if (directionAwareBorderInsets.top > 0.0f) {
                }
                if (directionAwareBorderInsets.right > 0.0f) {
                }
                if (directionAwareBorderInsets.bottom > 0.0f) {
                }
            } else if (fullBorderWidth > 0.0f) {
                this.mPaint.setColor(ColorUtil.multiplyColorAlpha(borderColor5, this.mAlpha));
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(fullBorderWidth);
                canvas2.drawPath(this.mCenterDrawPath, this.mPaint);
            }
        }
        canvas.restore();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    private void updatePath() {
        if (this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            this.mInnerClipTempRectForBorderRadius.set(getBounds());
            this.mOuterClipTempRectForBorderRadius.set(getBounds());
            this.mTempRectForBorderRadiusOutline.set(getBounds());
            this.mTempRectForCenterDrawPath.set(getBounds());
            float fullBorderWidth = getFullBorderWidth();
            if (fullBorderWidth > 0.0f) {
                float f = fullBorderWidth * 0.5f;
                this.mTempRectForCenterDrawPath.inset(f, f);
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            this.mInnerClipTempRectForBorderRadius.top += directionAwareBorderInsets.top;
            this.mInnerClipTempRectForBorderRadius.bottom -= directionAwareBorderInsets.bottom;
            this.mInnerClipTempRectForBorderRadius.left += directionAwareBorderInsets.left;
            this.mInnerClipTempRectForBorderRadius.right -= directionAwareBorderInsets.right;
            float fullBorderRadius = getFullBorderRadius();
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
            float borderRadiusOrDefaultTo4 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z = getResolvedLayoutDirection() == 1;
                float borderRadius = getBorderRadius(BorderRadiusLocation.TOP_START);
                float borderRadius2 = getBorderRadius(BorderRadiusLocation.TOP_END);
                float borderRadius3 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
                float borderRadius4 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                    if (!YogaConstants.isUndefined(borderRadius)) {
                        borderRadiusOrDefaultTo = borderRadius;
                    }
                    if (!YogaConstants.isUndefined(borderRadius2)) {
                        borderRadiusOrDefaultTo2 = borderRadius2;
                    }
                    if (!YogaConstants.isUndefined(borderRadius3)) {
                        borderRadiusOrDefaultTo3 = borderRadius3;
                    }
                    if (!YogaConstants.isUndefined(borderRadius4)) {
                        borderRadiusOrDefaultTo4 = borderRadius4;
                    }
                    float f2 = z ? borderRadiusOrDefaultTo2 : borderRadiusOrDefaultTo;
                    if (z) {
                        borderRadiusOrDefaultTo2 = borderRadiusOrDefaultTo;
                    }
                    float f3 = z ? borderRadiusOrDefaultTo4 : borderRadiusOrDefaultTo3;
                    if (z) {
                        borderRadiusOrDefaultTo4 = borderRadiusOrDefaultTo3;
                    }
                    borderRadiusOrDefaultTo3 = f3;
                    borderRadiusOrDefaultTo = f2;
                } else {
                    float f4 = z ? borderRadius2 : borderRadius;
                    if (!z) {
                        borderRadius = borderRadius2;
                    }
                    float f5 = z ? borderRadius4 : borderRadius3;
                    if (!z) {
                        borderRadius3 = borderRadius4;
                    }
                    if (!YogaConstants.isUndefined(f4)) {
                        borderRadiusOrDefaultTo = f4;
                    }
                    if (!YogaConstants.isUndefined(borderRadius)) {
                        borderRadiusOrDefaultTo2 = borderRadius;
                    }
                    if (!YogaConstants.isUndefined(f5)) {
                        borderRadiusOrDefaultTo3 = f5;
                    }
                    if (!YogaConstants.isUndefined(borderRadius3)) {
                        borderRadiusOrDefaultTo4 = borderRadius3;
                    }
                }
            }
            float max = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.left, 0.0f);
            float max2 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f);
            float max3 = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.right, 0.0f);
            float max4 = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.top, 0.0f);
            float max5 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.right, 0.0f);
            float max6 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.bottom, 0.0f);
            float max7 = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.left, 0.0f);
            float max8 = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.bottom, 0.0f);
            float f6 = borderRadiusOrDefaultTo3;
            float f7 = borderRadiusOrDefaultTo4;
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, Path.Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo2, borderRadiusOrDefaultTo2, f7, f7, f6, f6}, Path.Direction.CW);
            Spacing spacing = this.mBorderWidth;
            float f8 = spacing != null ? spacing.get(8) / 2.0f : 0.0f;
            float f9 = borderRadiusOrDefaultTo + f8;
            float f10 = borderRadiusOrDefaultTo2 + f8;
            float f11 = f7 + f8;
            float f12 = f6 + f8;
            this.mPathForBorderRadiusOutline.addRoundRect(this.mTempRectForBorderRadiusOutline, new float[]{f9, f9, f10, f10, f11, f11, f12, f12}, Path.Direction.CW);
            Path path = this.mCenterDrawPath;
            RectF rectF = this.mTempRectForCenterDrawPath;
            float[] fArr = new float[8];
            fArr[0] = max + (borderRadiusOrDefaultTo > 0.0f ? f8 : 0.0f);
            fArr[1] = (borderRadiusOrDefaultTo > 0.0f ? f8 : 0.0f) + max2;
            fArr[2] = (borderRadiusOrDefaultTo2 > 0.0f ? f8 : 0.0f) + max3;
            fArr[3] = (borderRadiusOrDefaultTo2 > 0.0f ? f8 : 0.0f) + max4;
            fArr[4] = (f7 > 0.0f ? f8 : 0.0f) + max5;
            fArr[5] = (f7 > 0.0f ? f8 : 0.0f) + max6;
            fArr[6] = (f6 > 0.0f ? f8 : 0.0f) + max7;
            if (f6 <= 0.0f) {
                f8 = 0.0f;
            }
            fArr[7] = f8 + max8;
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            this.mInnerTopLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerTopLeftCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine((double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.top, (double) (this.mInnerClipTempRectForBorderRadius.left + (max * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.top + (max2 * 2.0f)), (double) this.mOuterClipTempRectForBorderRadius.left, (double) this.mOuterClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopLeftCorner);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            this.mInnerBottomLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerBottomLeftCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine((double) this.mInnerClipTempRectForBorderRadius.left, (double) (this.mInnerClipTempRectForBorderRadius.bottom - (max8 * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.left + (max7 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.bottom, (double) this.mOuterClipTempRectForBorderRadius.left, (double) this.mOuterClipTempRectForBorderRadius.bottom, (double) this.mInnerClipTempRectForBorderRadius.left, (double) this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomLeftCorner);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            this.mInnerTopRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerTopRightCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine((double) (this.mInnerClipTempRectForBorderRadius.right - (max3 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.right, (double) (this.mInnerClipTempRectForBorderRadius.top + (max4 * 2.0f)), (double) this.mOuterClipTempRectForBorderRadius.right, (double) this.mOuterClipTempRectForBorderRadius.top, (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopRightCorner);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            this.mInnerBottomRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerBottomRightCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine((double) (this.mInnerClipTempRectForBorderRadius.right - (max5 * 2.0f)), (double) (this.mInnerClipTempRectForBorderRadius.bottom - (max6 * 2.0f)), (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.bottom, (double) this.mOuterClipTempRectForBorderRadius.right, (double) this.mOuterClipTempRectForBorderRadius.bottom, (double) this.mInnerClipTempRectForBorderRadius.right, (double) this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomRightCorner);
        }
    }

    private static void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        double d9 = (d + d3) / 2.0d;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = d5 - d9;
        double d12 = d6 - d10;
        double abs = Math.abs(d3 - d) / 2.0d;
        double abs2 = Math.abs(d4 - d2) / 2.0d;
        double d13 = ((d8 - d10) - d12) / ((d7 - d9) - d11);
        double d14 = d12 - (d11 * d13);
        double d15 = abs2 * abs2;
        double d16 = abs * abs;
        double d17 = d15 + (d16 * d13 * d13);
        double d18 = abs * 2.0d * abs * d14 * d13;
        double d19 = (-(d16 * ((d14 * d14) - d15))) / d17;
        double d20 = d17 * 2.0d;
        double sqrt = ((-d18) / d20) - Math.sqrt(d19 + Math.pow(d18 / d20, 2.0d));
        double d21 = (d13 * sqrt) + d14;
        double d22 = sqrt + d9;
        double d23 = d21 + d10;
        if (!Double.isNaN(d22) && !Double.isNaN(d23)) {
            PointF pointF2 = pointF;
            pointF2.x = (float) d22;
            pointF2.y = (float) d23;
        }
    }

    public float getBorderWidthOrDefaultTo(float f, int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return f;
        }
        float raw = spacing.getRaw(i);
        return YogaConstants.isUndefined(raw) ? f : raw;
    }

    private void updatePathEffect() {
        BorderStyle borderStyle = this.mBorderStyle;
        this.mPathEffectForBorderStyle = borderStyle != null ? BorderStyle.getPathEffect(borderStyle, getFullBorderWidth()) : null;
        this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
    }

    public float getFullBorderWidth() {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null || YogaConstants.isUndefined(spacing.getRaw(8))) {
            return 0.0f;
        }
        return this.mBorderWidth.getRaw(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013b  */
    private void drawRectangularBackgroundWithBorders(Canvas canvas) {
        int i;
        int i2;
        int fastBorderCompatibleColorOrZero;
        int i3;
        ReactViewBackgroundDrawable reactViewBackgroundDrawable;
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            this.mPaint.setColor(multiplyColorAlpha);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(getBounds(), this.mPaint);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        int round = Math.round(directionAwareBorderInsets.left);
        int round2 = Math.round(directionAwareBorderInsets.top);
        int round3 = Math.round(directionAwareBorderInsets.right);
        int round4 = Math.round(directionAwareBorderInsets.bottom);
        if (round > 0 || round3 > 0 || round2 > 0 || round4 > 0) {
            Rect bounds = getBounds();
            int borderColor = getBorderColor(0);
            int borderColor2 = getBorderColor(1);
            int borderColor3 = getBorderColor(2);
            int borderColor4 = getBorderColor(3);
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z = getResolvedLayoutDirection() == 1;
                int borderColor5 = getBorderColor(4);
                int borderColor6 = getBorderColor(5);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                    if (isBorderColorDefined(4)) {
                        borderColor = borderColor5;
                    }
                    if (isBorderColorDefined(5)) {
                        borderColor3 = borderColor6;
                    }
                    int i4 = z ? borderColor3 : borderColor;
                    if (!z) {
                        borderColor = borderColor3;
                    }
                    i = borderColor;
                    i2 = i4;
                } else {
                    int i5 = z ? borderColor6 : borderColor5;
                    if (!z) {
                        borderColor5 = borderColor6;
                    }
                    boolean isBorderColorDefined = isBorderColorDefined(4);
                    boolean isBorderColorDefined2 = isBorderColorDefined(5);
                    boolean z2 = z ? isBorderColorDefined2 : isBorderColorDefined;
                    if (!z) {
                        isBorderColorDefined = isBorderColorDefined2;
                    }
                    if (z2) {
                        borderColor = i5;
                    }
                    if (isBorderColorDefined) {
                        i2 = borderColor;
                        i = borderColor5;
                    }
                }
                int i6 = bounds.left;
                int i7 = bounds.top;
                int i8 = i6;
                fastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(round, round2, round3, round4, i2, borderColor2, i, borderColor4);
                if (fastBorderCompatibleColorOrZero != 0) {
                    this.mPaint.setAntiAlias(false);
                    int width = bounds.width();
                    int height = bounds.height();
                    if (round > 0) {
                        float f = (float) i8;
                        float f2 = (float) (i8 + round);
                        int i9 = i7 + height;
                        i3 = i7;
                        drawQuadrilateral(canvas, i2, f, (float) i7, f2, (float) (i7 + round2), f2, (float) (i9 - round4), f, (float) i9);
                    } else {
                        i3 = i7;
                    }
                    if (round2 > 0) {
                        float f3 = (float) i3;
                        float f4 = (float) (i3 + round2);
                        int i10 = i8 + width;
                        drawQuadrilateral(canvas, borderColor2, (float) i8, f3, (float) (i8 + round), f4, (float) (i10 - round3), f4, (float) i10, f3);
                    }
                    if (round3 > 0) {
                        int i11 = i8 + width;
                        float f5 = (float) i11;
                        int i12 = i3 + height;
                        float f6 = (float) (i11 - round3);
                        drawQuadrilateral(canvas, i, f5, (float) i3, f5, (float) i12, f6, (float) (i12 - round4), f6, (float) (i3 + round2));
                    }
                    if (round4 > 0) {
                        int i13 = i3 + height;
                        float f7 = (float) i13;
                        int i14 = i8 + width;
                        float f8 = (float) (i13 - round4);
                        reactViewBackgroundDrawable = this;
                        reactViewBackgroundDrawable.drawQuadrilateral(canvas, borderColor4, (float) i8, f7, (float) i14, f7, (float) (i14 - round3), f8, (float) (i8 + round), f8);
                    } else {
                        reactViewBackgroundDrawable = this;
                    }
                    reactViewBackgroundDrawable.mPaint.setAntiAlias(true);
                    return;
                } else if (Color.alpha(fastBorderCompatibleColorOrZero) != 0) {
                    int i15 = bounds.right;
                    int i16 = bounds.bottom;
                    this.mPaint.setColor(fastBorderCompatibleColorOrZero);
                    if (round > 0) {
                        canvas.drawRect((float) i8, (float) i7, (float) (i8 + round), (float) (i16 - round4), this.mPaint);
                    }
                    if (round2 > 0) {
                        canvas.drawRect((float) (i8 + round), (float) i7, (float) i15, (float) (i7 + round2), this.mPaint);
                    }
                    if (round3 > 0) {
                        canvas.drawRect((float) (i15 - round3), (float) (i7 + round2), (float) i15, (float) i16, this.mPaint);
                    }
                    if (round4 > 0) {
                        canvas.drawRect((float) i8, (float) (i16 - round4), (float) (i15 - round3), (float) i16, this.mPaint);
                        return;
                    }
                    return;
                }
            }
            i2 = borderColor;
            i = borderColor3;
            int i62 = bounds.left;
            int i72 = bounds.top;
            int i82 = i62;
            fastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(round, round2, round3, round4, i2, borderColor2, i, borderColor4);
            if (fastBorderCompatibleColorOrZero != 0) {
            }
        }
    }

    private void drawQuadrilateral(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (i != 0) {
            if (this.mPathForBorder == null) {
                this.mPathForBorder = new Path();
            }
            this.mPaint.setColor(i);
            this.mPathForBorder.reset();
            this.mPathForBorder.moveTo(f, f2);
            this.mPathForBorder.lineTo(f3, f4);
            this.mPathForBorder.lineTo(f5, f6);
            this.mPathForBorder.lineTo(f7, f8);
            this.mPathForBorder.lineTo(f, f2);
            canvas.drawPath(this.mPathForBorder, this.mPaint);
        }
    }

    private int getBorderWidth(int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return 0;
        }
        float f = spacing.get(i);
        if (YogaConstants.isUndefined(f)) {
            return -1;
        }
        return Math.round(f);
    }

    private boolean isBorderColorDefined(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = Float.NaN;
        float f2 = spacing != null ? spacing.get(i) : Float.NaN;
        Spacing spacing2 = this.mBorderAlpha;
        if (spacing2 != null) {
            f = spacing2.get(i);
        }
        return !YogaConstants.isUndefined(f2) && !YogaConstants.isUndefined(f);
    }

    private int getBorderColor(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = spacing != null ? spacing.get(i) : 0.0f;
        Spacing spacing2 = this.mBorderAlpha;
        return colorFromAlphaAndRGBComponents(spacing2 != null ? spacing2.get(i) : 255.0f, f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (r1 != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0072, code lost:
        if (com.facebook.yoga.YogaConstants.isUndefined(r4) == false) goto L_0x0074;
     */
    public RectF getDirectionAwareBorderInsets() {
        float borderWidthOrDefaultTo = getBorderWidthOrDefaultTo(0.0f, 8);
        boolean z = true;
        float borderWidthOrDefaultTo2 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 1);
        float borderWidthOrDefaultTo3 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 3);
        float borderWidthOrDefaultTo4 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 0);
        float borderWidthOrDefaultTo5 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 2);
        if (Build.VERSION.SDK_INT >= 17 && this.mBorderWidth != null) {
            if (getResolvedLayoutDirection() != 1) {
                z = false;
            }
            float raw = this.mBorderWidth.getRaw(4);
            float raw2 = this.mBorderWidth.getRaw(5);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (YogaConstants.isUndefined(raw)) {
                    raw = borderWidthOrDefaultTo4;
                }
                if (!YogaConstants.isUndefined(raw2)) {
                    borderWidthOrDefaultTo5 = raw2;
                }
                borderWidthOrDefaultTo4 = z ? borderWidthOrDefaultTo5 : raw;
            } else {
                float f = z ? raw2 : raw;
                if (!z) {
                    raw = raw2;
                }
                if (!YogaConstants.isUndefined(f)) {
                    borderWidthOrDefaultTo4 = f;
                }
            }
            borderWidthOrDefaultTo5 = raw;
        }
        return new RectF(borderWidthOrDefaultTo4, borderWidthOrDefaultTo2, borderWidthOrDefaultTo5, borderWidthOrDefaultTo3);
    }
}
