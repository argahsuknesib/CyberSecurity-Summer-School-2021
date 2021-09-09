package com.google.android.material.textfield;

import _m_j.OO0000o;
import _m_j.cb;
import _m_j.cl;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.xiaomi.smarthome.R;

class DropdownMenuEndIconDelegate extends EndIconDelegate {
    public static final boolean IS_LOLLIPOP = (Build.VERSION.SDK_INT >= 21);
    public final TextInputLayout.AccessibilityDelegate accessibilityDelegate = new TextInputLayout.AccessibilityDelegate(this.textInputLayout) {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass3 */

        public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            super.onInitializeAccessibilityNodeInfo(view, clVar);
            if (!DropdownMenuEndIconDelegate.isEditable(DropdownMenuEndIconDelegate.this.textInputLayout.getEditText())) {
                clVar.O00000Oo((CharSequence) Spinner.class.getName());
            }
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 26) {
                z = clVar.f13980O000000o.isShowingHintText();
            } else {
                Bundle O00000oO = clVar.O00000oO();
                if (O00000oO != null && (O00000oO.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4) {
                    z = true;
                }
            }
            if (z) {
                clVar.O00000oo((CharSequence) null);
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView castAutoCompleteTextViewOrThrow = DropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
            if (accessibilityEvent.getEventType() == 1 && DropdownMenuEndIconDelegate.this.accessibilityManager.isTouchExplorationEnabled() && !DropdownMenuEndIconDelegate.isEditable(DropdownMenuEndIconDelegate.this.textInputLayout.getEditText())) {
                DropdownMenuEndIconDelegate.this.showHideDropdown(castAutoCompleteTextViewOrThrow);
            }
        }
    };
    public AccessibilityManager accessibilityManager;
    private final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass4 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cb.O00000oO(android.view.View, int):void
         arg types: [com.google.android.material.internal.CheckableImageButton, int]
         candidates:
          _m_j.cb.O00000oO(android.view.View, float):void
          _m_j.cb.O00000oO(android.view.View, int):void */
        public void onEditTextAttached(TextInputLayout textInputLayout) {
            AutoCompleteTextView castAutoCompleteTextViewOrThrow = DropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(textInputLayout.getEditText());
            DropdownMenuEndIconDelegate.this.setPopupBackground(castAutoCompleteTextViewOrThrow);
            DropdownMenuEndIconDelegate.this.addRippleEffect(castAutoCompleteTextViewOrThrow);
            DropdownMenuEndIconDelegate.this.setUpDropdownShowHideBehavior(castAutoCompleteTextViewOrThrow);
            castAutoCompleteTextViewOrThrow.setThreshold(0);
            castAutoCompleteTextViewOrThrow.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
            castAutoCompleteTextViewOrThrow.addTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!DropdownMenuEndIconDelegate.isEditable(castAutoCompleteTextViewOrThrow)) {
                cb.O00000oO((View) DropdownMenuEndIconDelegate.this.endIconView, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.this.accessibilityDelegate);
            textInputLayout.setEndIconVisible(true);
        }
    };
    public long dropdownPopupActivatedAt = Long.MAX_VALUE;
    public boolean dropdownPopupDirty = false;
    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass5 */

        public void onEndIconChanged(TextInputLayout textInputLayout, int i) {
            final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i == 3) {
                autoCompleteTextView.post(new Runnable() {
                    /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass5.AnonymousClass1 */

                    public void run() {
                        autoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
                    }
                });
                if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.onFocusChangeListener) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                if (DropdownMenuEndIconDelegate.IS_LOLLIPOP) {
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
        }
    };
    public final TextWatcher exposedDropdownEndIconTextWatcher = new TextWatcherAdapter() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass1 */

        public void afterTextChanged(Editable editable) {
            final AutoCompleteTextView castAutoCompleteTextViewOrThrow = DropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
            if (DropdownMenuEndIconDelegate.this.accessibilityManager.isTouchExplorationEnabled() && DropdownMenuEndIconDelegate.isEditable(castAutoCompleteTextViewOrThrow) && !DropdownMenuEndIconDelegate.this.endIconView.hasFocus()) {
                castAutoCompleteTextViewOrThrow.dismissDropDown();
            }
            castAutoCompleteTextViewOrThrow.post(new Runnable() {
                /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass1.AnonymousClass1 */

                public void run() {
                    boolean isPopupShowing = castAutoCompleteTextViewOrThrow.isPopupShowing();
                    DropdownMenuEndIconDelegate.this.setEndIconChecked(isPopupShowing);
                    DropdownMenuEndIconDelegate.this.dropdownPopupDirty = isPopupShowing;
                }
            });
        }
    };
    public ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private StateListDrawable filledPopupBackground;
    public boolean isEndIconChecked = false;
    public final View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass2 */

        public void onFocusChange(View view, boolean z) {
            DropdownMenuEndIconDelegate.this.textInputLayout.setEndIconActivated(z);
            if (!z) {
                DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
                DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
            }
        }
    };
    private MaterialShapeDrawable outlinedPopupBackground;

    /* access modifiers changed from: package-private */
    public boolean isBoxBackgroundModeSupported(int i) {
        return i != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldTintIconOnError() {
        return true;
    }

    DropdownMenuEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    public void initialize() {
        float dimensionPixelOffset = (float) this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.outlinedPopupBackground = popUpMaterialShapeDrawable;
        this.filledPopupBackground = new StateListDrawable();
        this.filledPopupBackground.addState(new int[]{16842922}, popUpMaterialShapeDrawable);
        this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
        this.textInputLayout.setEndIconDrawable(OO0000o.O00000Oo(this.context, IS_LOLLIPOP ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass6 */

            public void onClick(View view) {
                DropdownMenuEndIconDelegate.this.showHideDropdown((AutoCompleteTextView) DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
    }

    public void showHideDropdown(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView != null) {
            if (isDropdownPopupActive()) {
                this.dropdownPopupDirty = false;
            }
            if (!this.dropdownPopupDirty) {
                if (IS_LOLLIPOP) {
                    setEndIconChecked(!this.isEndIconChecked);
                } else {
                    this.isEndIconChecked = !this.isEndIconChecked;
                    this.endIconView.toggle();
                }
                if (this.isEndIconChecked) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            this.dropdownPopupDirty = false;
        }
    }

    public void setPopupBackground(AutoCompleteTextView autoCompleteTextView) {
        if (IS_LOLLIPOP) {
            int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.outlinedPopupBackground);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.filledPopupBackground);
            }
        }
    }

    public void addRippleEffect(AutoCompleteTextView autoCompleteTextView) {
        if (!isEditable(autoCompleteTextView)) {
            int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
            MaterialShapeDrawable boxBackground = this.textInputLayout.getBoxBackground();
            int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorControlHighlight);
            int[][] iArr = {new int[]{16842919}, new int[0]};
            if (boxBackgroundMode == 2) {
                addRippleEffectOnOutlinedLayout(autoCompleteTextView, color, iArr, boxBackground);
            } else if (boxBackgroundMode == 1) {
                addRippleEffectOnFilledLayout(autoCompleteTextView, color, iArr, boxBackground);
            }
        }
    }

    private void addRippleEffectOnOutlinedLayout(AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, MaterialShapeDrawable materialShapeDrawable) {
        LayerDrawable layerDrawable;
        int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorSurface);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int layer = MaterialColors.layer(i, color, 0.1f);
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
        if (IS_LOLLIPOP) {
            materialShapeDrawable2.setTint(color);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, color});
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
            materialShapeDrawable3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable});
        }
        cb.O000000o(autoCompleteTextView, layerDrawable);
    }

    private void addRippleEffectOnFilledLayout(AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, MaterialShapeDrawable materialShapeDrawable) {
        int boxBackgroundColor = this.textInputLayout.getBoxBackgroundColor();
        int[] iArr2 = {MaterialColors.layer(i, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (IS_LOLLIPOP) {
            cb.O000000o(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
            return;
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable, materialShapeDrawable2});
        int O0000OoO = cb.O0000OoO(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int O0000Ooo = cb.O0000Ooo(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        cb.O000000o(autoCompleteTextView, layerDrawable);
        cb.O00000Oo(autoCompleteTextView, O0000OoO, paddingTop, O0000Ooo, paddingBottom);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setUpDropdownShowHideBehavior(final AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass7 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (DropdownMenuEndIconDelegate.this.isDropdownPopupActive()) {
                        DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
                    }
                    DropdownMenuEndIconDelegate.this.showHideDropdown(autoCompleteTextView);
                }
                return false;
            }
        });
        autoCompleteTextView.setOnFocusChangeListener(this.onFocusChangeListener);
        if (IS_LOLLIPOP) {
            autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
                /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass8 */

                public void onDismiss() {
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                    dropdownMenuEndIconDelegate.dropdownPopupDirty = true;
                    dropdownMenuEndIconDelegate.dropdownPopupActivatedAt = System.currentTimeMillis();
                    DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
                }
            });
        }
    }

    private MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f, float f2, float f3, int i) {
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomLeftCornerSize(f2).setBottomRightCornerSize(f2).build();
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.context, f3);
        createWithElevationOverlay.setShapeAppearanceModel(build);
        createWithElevationOverlay.setPadding(0, i, 0, i);
        return createWithElevationOverlay;
    }

    public boolean isDropdownPopupActive() {
        long currentTimeMillis = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    public static AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean isEditable(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public void setEndIconChecked(boolean z) {
        if (this.isEndIconChecked != z) {
            this.isEndIconChecked = z;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(67, 0.0f, 1.0f);
        this.fadeOutAnim = getAlphaAnimator(50, 1.0f, 0.0f);
        this.fadeOutAnim.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass9 */

            public void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate.this.endIconView.setChecked(DropdownMenuEndIconDelegate.this.isEndIconChecked);
                DropdownMenuEndIconDelegate.this.fadeInAnim.start();
            }
        });
    }

    private ValueAnimator getAlphaAnimator(int i, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration((long) i);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.DropdownMenuEndIconDelegate.AnonymousClass10 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }
}
