package com.google.android.material.tooltip;

import _m_j.q;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.xiaomi.smarthome.R;

public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int DEFAULT_STYLE = 2132739201;
    private static final int DEFAULT_THEME_ATTR = 2131822378;
    private int arrowSize;
    private final View.OnLayoutChangeListener attachedViewLayoutChangeListener = new View.OnLayoutChangeListener() {
        /* class com.google.android.material.tooltip.TooltipDrawable.AnonymousClass1 */

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            TooltipDrawable.this.updateLocationOnScreen(view);
        }
    };
    private final Context context;
    private final Rect displayFrame = new Rect();
    private final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    private float labelOpacity = 1.0f;
    private int layoutMargin;
    private int locationOnScreenX;
    private int minHeight;
    private int minWidth;
    private int padding;
    private CharSequence text;
    private final TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
    private final float tooltipPivotX = 0.5f;
    private float tooltipPivotY = 0.5f;
    private float tooltipScaleX = 1.0f;
    private float tooltipScaleY = 1.0f;

    public static TooltipDrawable createFromAttributes(Context context2, AttributeSet attributeSet, int i, int i2) {
        TooltipDrawable tooltipDrawable = new TooltipDrawable(context2, attributeSet, i, i2);
        tooltipDrawable.loadFromAttributes(attributeSet, i, i2);
        return tooltipDrawable;
    }

    public static TooltipDrawable createFromAttributes(Context context2, AttributeSet attributeSet) {
        return createFromAttributes(context2, attributeSet, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static TooltipDrawable create(Context context2) {
        return createFromAttributes(context2, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    private TooltipDrawable(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
        this.context = context2;
        this.textDrawableHelper.getTextPaint().density = context2.getResources().getDisplayMetrics().density;
        this.textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
    }

    private void loadFromAttributes(AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, new int[]{16842804, 16842965, 16842998, 16843071, 16843072, 16843087, R.attr.backgroundTint}, i, i2, new int[0]);
        this.arrowSize = this.context.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
        setText(obtainStyledAttributes.getText(5));
        setTextAppearance(MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, 0));
        setFillColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(6, MaterialColors.layer(q.O00000Oo(MaterialColors.getColor(this.context, 16842801, TooltipDrawable.class.getCanonicalName()), 229), q.O00000Oo(MaterialColors.getColor(this.context, (int) R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName()), 153)))));
        setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(this.context, (int) R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
        this.padding = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.minWidth = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.minHeight = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.layoutMargin = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
    }

    public CharSequence getText() {
        return this.text;
    }

    public void setTextResource(int i) {
        setText(this.context.getResources().getString(i));
    }

    public void setText(CharSequence charSequence) {
        if (!TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textDrawableHelper.setTextWidthDirty(true);
            invalidateSelf();
        }
    }

    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(new TextAppearance(this.context, i));
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public void setMinWidth(int i) {
        this.minWidth = i;
        invalidateSelf();
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public void setMinHeight(int i) {
        this.minHeight = i;
        invalidateSelf();
    }

    public int getTextPadding() {
        return this.padding;
    }

    public void setTextPadding(int i) {
        this.padding = i;
        invalidateSelf();
    }

    public int getLayoutMargin() {
        return this.layoutMargin;
    }

    public void setLayoutMargin(int i) {
        this.layoutMargin = i;
        invalidateSelf();
    }

    public void setRevealFraction(float f) {
        this.tooltipPivotY = 1.2f;
        this.tooltipScaleX = f;
        this.tooltipScaleY = f;
        this.labelOpacity = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, f);
        invalidateSelf();
    }

    public void setRelativeToView(View view) {
        if (view != null) {
            updateLocationOnScreen(view);
            view.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
        }
    }

    public void detachView(View view) {
        if (view != null) {
            view.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
        }
    }

    public int getIntrinsicWidth() {
        return (int) Math.max(((float) (this.padding * 2)) + getTextWidth(), (float) this.minWidth);
    }

    public int getIntrinsicHeight() {
        return (int) Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), (float) this.minHeight);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        float calculatePointerOffset = calculatePointerOffset();
        double d = (double) this.arrowSize;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d);
        double d2 = d * sqrt;
        double d3 = (double) this.arrowSize;
        Double.isNaN(d3);
        canvas.scale(this.tooltipScaleX, this.tooltipScaleY, ((float) getBounds().left) + (((float) getBounds().width()) * 0.5f), ((float) getBounds().top) + (((float) getBounds().height()) * this.tooltipPivotY));
        canvas.translate(calculatePointerOffset, (float) (-(d2 - d3)));
        super.draw(canvas);
        drawText(canvas);
        canvas.restore();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void updateLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.locationOnScreenX = iArr[0];
        view.getWindowVisibleDisplayFrame(this.displayFrame);
    }

    private float calculatePointerOffset() {
        int i;
        if (((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin < 0) {
            i = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
        } else if (((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin <= 0) {
            return 0.0f;
        } else {
            i = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        }
        return (float) i;
    }

    private EdgeTreatment createMarkerEdge() {
        double width = (double) getBounds().width();
        double d = (double) this.arrowSize;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d);
        Double.isNaN(width);
        float f = ((float) (width - (d * sqrt))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment((float) this.arrowSize), Math.min(Math.max(-calculatePointerOffset(), -f), f));
    }

    private void drawText(Canvas canvas) {
        if (this.text != null) {
            Rect bounds = getBounds();
            int calculateTextOriginAndAlignment = (int) calculateTextOriginAndAlignment(bounds);
            if (this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
                this.textDrawableHelper.getTextPaint().setAlpha((int) (this.labelOpacity * 255.0f));
            }
            CharSequence charSequence = this.text;
            canvas.drawText(charSequence, 0, charSequence.length(), (float) bounds.centerX(), (float) calculateTextOriginAndAlignment, this.textDrawableHelper.getTextPaint());
        }
    }

    private float getTextWidth() {
        CharSequence charSequence = this.text;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.textDrawableHelper.getTextWidth(charSequence.toString());
    }

    private float calculateTextOriginAndAlignment(Rect rect) {
        return ((float) rect.centerY()) - calculateTextCenterFromBaseline();
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
    }
}
