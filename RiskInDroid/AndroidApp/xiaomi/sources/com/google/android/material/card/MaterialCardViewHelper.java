package com.google.android.material.card;

import _m_j.ab;
import _m_j.cb;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.xiaomi.smarthome.R;

class MaterialCardViewHelper {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    private Drawable checkedIcon;
    private int checkedIconMargin;
    private int checkedIconSize;
    private ColorStateList checkedIconTint;
    private LayerDrawable clickableForegroundDrawable;
    private MaterialShapeDrawable compatRippleDrawable;
    private Drawable fgDrawable;
    private final MaterialShapeDrawable foregroundContentDrawable;
    private MaterialShapeDrawable foregroundShapeDrawable;
    private boolean isBackgroundOverwritten = false;
    private final MaterialCardView materialCardView;
    private ColorStateList rippleColor;
    private Drawable rippleDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private ColorStateList strokeColor;
    private int strokeWidth;
    private final Rect userContentPadding = new Rect();

    public MaterialCardViewHelper(MaterialCardView materialCardView2, AttributeSet attributeSet, int i, int i2) {
        this.materialCardView = materialCardView2;
        this.bgDrawable = new MaterialShapeDrawable(materialCardView2.getContext(), attributeSet, i, i2);
        this.bgDrawable.initializeElevationOverlay(materialCardView2.getContext());
        this.bgDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = this.bgDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView2.getContext().obtainStyledAttributes(attributeSet, new int[]{16843071, 16843072, R.attr.cardBackgroundColor, R.attr.cardCornerRadius, R.attr.cardElevation, R.attr.cardMaxElevation, R.attr.cardPreventCornerOverlap, R.attr.cardUseCompatPadding, R.attr.contentPadding, R.attr.contentPaddingBottom, R.attr.contentPaddingLeft, R.attr.contentPaddingRight, R.attr.contentPaddingTop}, i, R.style.CardView);
        if (obtainStyledAttributes.hasValue(3)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(3, 0.0f));
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(TypedArray typedArray) {
        this.strokeColor = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, 10);
        if (this.strokeColor == null) {
            this.strokeColor = ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(11, 0);
        this.checkable = typedArray.getBoolean(0, false);
        this.materialCardView.setLongClickable(this.checkable);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, 5);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, 2));
        setCheckedIconSize(typedArray.getDimensionPixelSize(4, 0));
        setCheckedIconMargin(typedArray.getDimensionPixelSize(3, 0));
        this.rippleColor = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, 6);
        if (this.rippleColor == null) {
            this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, R.attr.colorControlHighlight));
        }
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, 1));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        this.fgDrawable = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    /* access modifiers changed from: package-private */
    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundOverwritten(boolean z) {
        this.isBackgroundOverwritten = z;
    }

    /* access modifiers changed from: package-private */
    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    /* access modifiers changed from: package-private */
    public int getStrokeColor() {
        ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    /* access modifiers changed from: package-private */
    public void setStrokeWidth(int i) {
        if (i != this.strokeWidth) {
            this.strokeWidth = i;
            updateStroke();
        }
    }

    /* access modifiers changed from: package-private */
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    /* access modifiers changed from: package-private */
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    /* access modifiers changed from: package-private */
    public void setCardForegroundColor(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    /* access modifiers changed from: package-private */
    public void setUserContentPadding(int i, int i2, int i3, int i4) {
        this.userContentPadding.set(i, i2, i3, i4);
        updateContentPadding();
    }

    /* access modifiers changed from: package-private */
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    /* access modifiers changed from: package-private */
    public void updateClickable() {
        Drawable drawable = this.fgDrawable;
        this.fgDrawable = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        Drawable drawable2 = this.fgDrawable;
        if (drawable != drawable2) {
            updateInsetForeground(drawable2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setCornerRadius(float f) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    /* access modifiers changed from: package-private */
    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    /* access modifiers changed from: package-private */
    public void setProgress(float f) {
        this.bgDrawable.setInterpolation(f);
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f);
        }
    }

    /* access modifiers changed from: package-private */
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    /* access modifiers changed from: package-private */
    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    /* access modifiers changed from: package-private */
    public void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    /* access modifiers changed from: package-private */
    public void updateStroke() {
        this.foregroundContentDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
    }

    /* access modifiers changed from: package-private */
    public void updateContentPadding() {
        int calculateActualCornerPadding = (int) ((shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f) - getParentCardViewCalculatedCornerPadding());
        this.materialCardView.setAncestorContentPadding(this.userContentPadding.left + calculateActualCornerPadding, this.userContentPadding.top + calculateActualCornerPadding, this.userContentPadding.right + calculateActualCornerPadding, this.userContentPadding.bottom + calculateActualCornerPadding);
    }

    /* access modifiers changed from: package-private */
    public void setCheckable(boolean z) {
        this.checkable = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isCheckable() {
        return this.checkable;
    }

    /* access modifiers changed from: package-private */
    public void setRippleColor(ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            ab.O000000o(drawable, colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* access modifiers changed from: package-private */
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIcon(Drawable drawable) {
        this.checkedIcon = drawable;
        if (drawable != null) {
            this.checkedIcon = ab.O00000oo(drawable.mutate());
            ab.O000000o(this.checkedIcon, this.checkedIconTint);
        }
        if (this.clickableForegroundDrawable != null) {
            this.clickableForegroundDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, createCheckedIconLayer());
        }
    }

    /* access modifiers changed from: package-private */
    public int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIconSize(int i) {
        this.checkedIconSize = i;
    }

    /* access modifiers changed from: package-private */
    public int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    /* access modifiers changed from: package-private */
    public void setCheckedIconMargin(int i) {
        this.checkedIconMargin = i;
    }

    /* access modifiers changed from: package-private */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.clickableForegroundDrawable != null) {
            int i5 = this.checkedIconMargin;
            int i6 = this.checkedIconSize;
            int i7 = (i - i5) - i6;
            int i8 = (i2 - i5) - i6;
            if ((Build.VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
                i8 -= (int) Math.ceil((double) (calculateVerticalBackgroundPadding() * 2.0f));
                i7 -= (int) Math.ceil((double) (calculateHorizontalBackgroundPadding() * 2.0f));
            }
            int i9 = i8;
            int i10 = this.checkedIconMargin;
            if (cb.O0000Oo0(this.materialCardView) == 1) {
                i3 = i7;
                i4 = i10;
            } else {
                i4 = i7;
                i3 = i10;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i4, this.checkedIconMargin, i3, i9);
        }
    }

    /* access modifiers changed from: package-private */
    public void forceRippleRedraw() {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
        MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
        materialShapeDrawable.setShadowBitmapDrawingEnable(!materialShapeDrawable.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundContentDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel2);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.foregroundShapeDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel2);
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.compatRippleDrawable;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel2);
        }
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    private void updateInsetForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.materialCardView.getForeground() instanceof InsetDrawable)) {
            this.materialCardView.setForeground(insetDrawable(drawable));
        } else {
            ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        }
    }

    private Drawable insetDrawable(Drawable drawable) {
        int i;
        int i2;
        if ((Build.VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((double) calculateVerticalBackgroundPadding());
            i2 = (int) Math.ceil((double) calculateHorizontalBackgroundPadding());
            i = ceil;
        } else {
            i2 = 0;
            i = 0;
        }
        return new InsetDrawable(drawable, i2, i, i2, i) {
            /* class com.google.android.material.card.MaterialCardViewHelper.AnonymousClass1 */

            public int getMinimumHeight() {
                return -1;
            }

            public int getMinimumWidth() {
                return -1;
            }

            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * 1.5f) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private boolean canClipToOutline() {
        return Build.VERSION.SDK_INT >= 21 && this.bgDrawable.isRoundRect();
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (!this.materialCardView.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (Build.VERSION.SDK_INT >= 21 && !this.materialCardView.getUseCompatPadding()) {
            return 0.0f;
        }
        double d = 1.0d - COS_45;
        double cardViewRadius = (double) this.materialCardView.getCardViewRadius();
        Double.isNaN(cardViewRadius);
        return (float) (d * cardViewRadius);
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding();
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            double d = (double) f;
            Double.isNaN(d);
            return (float) ((1.0d - COS_45) * d);
        } else if (cornerTreatment instanceof CutCornerTreatment) {
            return f / 2.0f;
        } else {
            return 0.0f;
        }
    }

    private Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            this.clickableForegroundDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, createCheckedIconLayer()});
            this.clickableForegroundDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    private Drawable createForegroundRippleDrawable() {
        if (!RippleUtils.USE_FRAMEWORK_RIPPLE) {
            return createCompatRippleDrawable();
        }
        this.foregroundShapeDrawable = createForegroundShapeDrawable();
        return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
    }

    private Drawable createCompatRippleDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.compatRippleDrawable = createForegroundShapeDrawable();
        this.compatRippleDrawable.setFillColor(this.rippleColor);
        stateListDrawable.addState(new int[]{16842919}, this.compatRippleDrawable);
        return stateListDrawable;
    }

    private void updateRippleColor() {
        Drawable drawable;
        if (!RippleUtils.USE_FRAMEWORK_RIPPLE || (drawable = this.rippleDrawable) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setFillColor(this.rippleColor);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.rippleColor);
    }

    private Drawable createCheckedIconLayer() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            stateListDrawable.addState(CHECKED_STATE_SET, drawable);
        }
        return stateListDrawable;
    }

    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }
}
