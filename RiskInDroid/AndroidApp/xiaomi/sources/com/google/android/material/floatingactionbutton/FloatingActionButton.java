package com.google.android.material.floatingactionbutton;

import _m_j.OOO0o0;
import _m_j.OOOO00O;
import _m_j.ab;
import _m_j.bf;
import _m_j.ca;
import _m_j.cb;
import _m_j.db;
import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class FloatingActionButton extends VisibilityAwareImageButton implements ca, db, CoordinatorLayout.O000000o, ExpandableTransformationWidget, Shapeable {
    private static final int DEF_STYLE_RES = 2132739077;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;
    private final ExpandableWidgetHelper expandableWidgetHelper;
    private final OOOO00O imageHelper;
    private PorterDuff.Mode imageMode;
    public int imagePadding;
    private ColorStateList imageTint;
    private FloatingActionButtonImpl impl;
    private int maxImageSize;
    private ColorStateList rippleColor;
    final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    public static abstract class OnVisibilityChangedListener {
        public void onHidden(FloatingActionButton floatingActionButton) {
        }

        public void onShown(FloatingActionButton floatingActionButton) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, new int[]{16842766, R.attr.backgroundTint, R.attr.backgroundTintMode, R.attr.borderWidth, R.attr.elevation, R.attr.ensureMinTouchTargetSize, R.attr.fabCustomSize, R.attr.fabSize, R.attr.fab_colorNormal, R.attr.fab_colorPressed, R.attr.fab_shadow, R.attr.fab_type, R.attr.hideMotionSpec, R.attr.hoveredFocusedTranslationZ, R.attr.maxImageSize, R.attr.pressedTranslationZ, R.attr.rippleColor, R.attr.shapeAppearance, R.attr.shapeAppearanceOverlay, R.attr.showMotionSpec, R.attr.useCompatPadding}, i, DEF_STYLE_RES, new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 1);
        this.backgroundTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(2, -1), null);
        this.rippleColor = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 16);
        this.size = obtainStyledAttributes.getInt(7, -1);
        this.customSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        float dimension = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(13, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(15, 0.0f);
        this.compatPadding = obtainStyledAttributes.getBoolean(20, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        this.maxImageSize = obtainStyledAttributes.getDimensionPixelSize(14, 0);
        MotionSpec createFromAttribute = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, 19);
        MotionSpec createFromAttribute2 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, 12);
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES, ShapeAppearanceModel.PILL).build();
        boolean z = obtainStyledAttributes.getBoolean(5, false);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        this.imageHelper = new OOOO00O(this);
        this.imageHelper.O000000o(attributeSet, i);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().setShapeAppearance(build);
        getImpl().initializeBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().setMinTouchTargetSize(dimensionPixelSize);
        getImpl().setElevation(dimension);
        getImpl().setHoveredFocusedTranslationZ(dimension2);
        getImpl().setPressedTranslationZ(dimension3);
        getImpl().setMaxImageSize(this.maxImageSize);
        getImpl().setShowMotionSpec(createFromAttribute);
        getImpl().setHideMotionSpec(createFromAttribute2);
        getImpl().setEnsureMinTouchTargetSize(z);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int min = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        setMeasuredDimension(this.shadowPadding.left + min + this.shadowPadding.right, min + this.shadowPadding.top + this.shadowPadding.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().setRippleColor(this.rippleColor);
        }
    }

    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            getImpl().setBackgroundTintList(colorStateList);
        }
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            getImpl().setBackgroundTintMode(mode);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    private void onApplySupportImageTint() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.imageTint;
            if (colorStateList == null) {
                ab.O00000oO(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.imageMode;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(OOO0o0.O000000o(colorForState, mode));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(int i) {
        this.imageHelper.O000000o(i);
        onApplySupportImageTint();
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().updateImageMatrixScale();
            if (this.imageTint != null) {
                onApplySupportImageTint();
            }
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().setShapeAppearance(shapeAppearanceModel);
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return (ShapeAppearanceModel) bf.O000000o(getImpl().getShapeAppearance());
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().getEnsureMinTouchTargetSize();
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().getEnsureMinTouchTargetSize()) {
            getImpl().setEnsureMinTouchTargetSize(z);
            requestLayout();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void show() {
        show(null);
    }

    public void show(OnVisibilityChangedListener onVisibilityChangedListener) {
        show(onVisibilityChangedListener, true);
    }

    /* access modifiers changed from: package-private */
    public void show(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().show(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().addOnShowAnimationListener(animatorListener);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().removeOnShowAnimationListener(animatorListener);
    }

    public void hide() {
        hide(null);
    }

    public void hide(OnVisibilityChangedListener onVisibilityChangedListener) {
        hide(onVisibilityChangedListener, true);
    }

    /* access modifiers changed from: package-private */
    public void hide(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().hide(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().addOnHideAnimationListener(animatorListener);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().removeOnHideAnimationListener(animatorListener);
    }

    public boolean setExpanded(boolean z) {
        return this.expandableWidgetHelper.setExpanded(z);
    }

    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    public void setExpandedComponentIdHint(int i) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(i);
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.compatPadding != z) {
            this.compatPadding = z;
            getImpl().onCompatShadowChanged();
        }
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void setSize(int i) {
        this.customSize = 0;
        if (i != this.size) {
            this.size = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.size;
    }

    private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new FloatingActionButtonImpl.InternalVisibilityChangedListener() {
            /* class com.google.android.material.floatingactionbutton.FloatingActionButton.AnonymousClass1 */

            public void onShown() {
                onVisibilityChangedListener.onShown(FloatingActionButton.this);
            }

            public void onHidden() {
                onVisibilityChangedListener.onHidden(FloatingActionButton.this);
            }
        };
    }

    public boolean isOrWillBeHidden() {
        return getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return getImpl().isOrWillBeShown();
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i != this.customSize) {
            this.customSize = i;
            requestLayout();
        }
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    private int getSizeDimension(int i) {
        while (true) {
            int i2 = this.customSize;
            if (i2 != 0) {
                return i2;
            }
            Resources resources = getResources();
            if (i == -1) {
                i = Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? 1 : 0;
            } else if (i != 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            } else {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.extendableStates.put("expandableWidgetHelper", this.expandableWidgetHelper.onSaveInstanceState());
        return extendableSavedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.expandableWidgetHelper.onRestoreInstanceState((Bundle) bf.O000000o(extendableSavedState.extendableStates.get("expandableWidgetHelper")));
    }

    @Deprecated
    public boolean getContentRect(Rect rect) {
        if (!cb.O000O0oO(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(rect);
        return true;
    }

    public void getMeasuredContentRect(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(rect);
    }

    private void offsetRectWithShadow(Rect rect) {
        rect.left += this.shadowPadding.left;
        rect.top += this.shadowPadding.top;
        rect.right -= this.shadowPadding.right;
        rect.bottom -= this.shadowPadding.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().getContentBackground();
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size2);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size2;
        }
        throw new IllegalArgumentException();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !getContentRect(this.touchArea) || this.touchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.O00000o o00000o) {
            super.onAttachedToLayoutParams(o00000o);
        }

        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i);
        }

        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean z) {
            super.setAutoHideEnabled(z);
        }

        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            super.setInternalAutoHideListener(onVisibilityChangedListener);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private boolean autoHideEnabled;
        private OnVisibilityChangedListener internalAutoHideListener;
        private Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.behavior_autoHide});
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        public void setAutoHideEnabled(boolean z) {
            this.autoHideEnabled = z;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public void onAttachedToLayoutParams(CoordinatorLayout.O00000o o00000o) {
            if (o00000o.O0000OOo == 0) {
                o00000o.O0000OOo = 80;
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!isBottomSheet(view)) {
                return false;
            } else {
                updateFabVisibilityForBottomSheet(view, floatingActionButton);
                return false;
            }
        }

        private static boolean isBottomSheet(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.O00000o) {
                return ((CoordinatorLayout.O00000o) layoutParams).f2811O000000o instanceof BottomSheetBehavior;
            }
            return false;
        }

        public void setInternalAutoHideListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.internalAutoHideListener = onVisibilityChangedListener;
        }

        private boolean shouldUpdateVisibility(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.O00000o o00000o = (CoordinatorLayout.O00000o) floatingActionButton.getLayoutParams();
            if (this.autoHideEnabled && o00000o.O00000oo == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(this.internalAutoHideListener, false);
                return true;
            }
            floatingActionButton.show(this.internalAutoHideListener, false);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.O00000o) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.hide(this.internalAutoHideListener, false);
                return true;
            }
            floatingActionButton.show(this.internalAutoHideListener, false);
            return true;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, floatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            offsetIfNeeded(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cb.O0000Oo0(android.view.View, int):void
         arg types: [com.google.android.material.floatingactionbutton.FloatingActionButton, int]
         candidates:
          _m_j.cb.O0000Oo0(android.view.View, float):void
          _m_j.cb.O0000Oo0(android.view.View, int):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cb.O0000Oo(android.view.View, int):void
         arg types: [com.google.android.material.floatingactionbutton.FloatingActionButton, int]
         candidates:
          _m_j.cb.O0000Oo(android.view.View, float):void
          _m_j.cb.O0000Oo(android.view.View, int):void */
        private void offsetIfNeeded(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.shadowPadding;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.O00000o o00000o = (CoordinatorLayout.O00000o) floatingActionButton.getLayoutParams();
                int i2 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - o00000o.rightMargin) {
                    i = rect.right;
                } else {
                    i = floatingActionButton.getLeft() <= o00000o.leftMargin ? -rect.left : 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - o00000o.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= o00000o.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    cb.O0000Oo0((View) floatingActionButton, i2);
                }
                if (i != 0) {
                    cb.O0000Oo((View) floatingActionButton, i);
                }
            }
        }
    }

    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().updateShapeElevation(f);
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public void setCompatElevation(float f) {
        getImpl().setElevation(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().getHoveredFocusedTranslationZ();
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().setHoveredFocusedTranslationZ(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().getPressedTranslationZ();
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().setPressedTranslationZ(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().getShowMotionSpec();
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().setShowMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().getHideMotionSpec();
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().setHideMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void addTransformationCallback(TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        getImpl().addTransformationCallback(new TransformationCallbackWrapper(transformationCallback));
    }

    public void removeTransformationCallback(TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        getImpl().removeTransformationCallback(new TransformationCallbackWrapper(transformationCallback));
    }

    class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {
        private final TransformationCallback<T> listener;

        TransformationCallbackWrapper(TransformationCallback<T> transformationCallback) {
            this.listener = transformationCallback;
        }

        public void onTranslationChanged() {
            this.listener.onTranslationChanged(FloatingActionButton.this);
        }

        public void onScaleChanged() {
            this.listener.onScaleChanged(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).listener.equals(this.listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }
    }

    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().onTranslationChanged();
    }

    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().onTranslationChanged();
    }

    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().onTranslationChanged();
    }

    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().onScaleChanged();
    }

    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().onScaleChanged();
    }

    public void setShadowPaddingEnabled(boolean z) {
        getImpl().setShadowPaddingEnabled(z);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = createImpl();
        }
        return this.impl;
    }

    private FloatingActionButtonImpl createImpl() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
        }
        return new FloatingActionButtonImpl(this, new ShadowDelegateImpl());
    }

    class ShadowDelegateImpl implements ShadowViewDelegate {
        ShadowDelegateImpl() {
        }

        public float getRadius() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        public void setShadowPadding(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.shadowPadding.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.imagePadding, i2 + FloatingActionButton.this.imagePadding, i3 + FloatingActionButton.this.imagePadding, i4 + FloatingActionButton.this.imagePadding);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        public boolean isCompatPaddingEnabled() {
            return FloatingActionButton.this.compatPadding;
        }
    }
}
