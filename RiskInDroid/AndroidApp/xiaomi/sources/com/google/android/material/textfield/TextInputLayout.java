package com.google.android.material.textfield;

import _m_j.OO0000o;
import _m_j.OOO0o0;
import _m_j.OOOOOo0;
import _m_j.Oo;
import _m_j.ab;
import _m_j.av;
import _m_j.ax;
import _m_j.bh;
import _m_j.bn;
import _m_j.cb;
import _m_j.cl;
import _m_j.cy;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout {
    private static final int DEF_STYLE_RES = 2132739083;
    private ValueAnimator animator;
    private MaterialShapeDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private MaterialShapeDrawable boxUnderline;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private ColorStateList counterTextColor;
    private TextView counterView;
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    private int defaultStrokeColor;
    private int disabledColor;
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    private final SparseArray<EndIconDelegate> endIconDelegates;
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    public final CheckableImageButton endIconView;
    private final LinearLayout endLayout;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private final CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;
    private int focusedFilledBackgroundColor;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private int hoveredFilledBackgroundColor;
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    public boolean placeholderEnabled;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    private CharSequence prefixText;
    private final TextView prefixTextView;
    public boolean restoringSavedState;
    private ShapeAppearanceModel shapeAppearanceModel;
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final LinearLayout startLayout;
    private ColorStateList strokeErrorColor;
    private CharSequence suffixText;
    private final TextView suffixTextView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout textInputLayout, int i);
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.Oo.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      _m_j.Oo.O000000o(int, int):int
      _m_j.Oo.O000000o(int, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [com.google.android.material.internal.CheckableImageButton, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.FrameLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000OOo(android.view.View, int):void
     arg types: [android.widget.TextView, int]
     candidates:
      _m_j.cb.O0000OOo(android.view.View, float):void
      _m_j.cb.O0000OOo(android.view.View, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [com.google.android.material.textfield.TextInputLayout, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o(android.view.View, int):void
     arg types: [com.google.android.material.textfield.TextInputLayout, int]
     candidates:
      _m_j.cb.O00000o(android.view.View, float):void
      _m_j.cb.O00000o(android.view.View, int):void */
    /* JADX WARNING: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, r7, r8, DEF_STYLE_RES), r7, r8);
        boolean z;
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet<>();
        this.endIconMode = 0;
        this.endIconDelegates = new SparseArray<>();
        this.endIconChangedListeners = new LinkedHashSet<>();
        this.collapsingTextHelper = new CollapsingTextHelper(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.inputFrame = new FrameLayout(context2);
        this.inputFrame.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        this.startLayout = new LinearLayout(context2);
        this.startLayout.setOrientation(0);
        this.startLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        this.inputFrame.addView(this.startLayout);
        this.endLayout = new LinearLayout(context2);
        this.endLayout.setOrientation(0);
        this.endLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        this.inputFrame.addView(this.endLayout);
        this.endIconFrame = new FrameLayout(context2);
        this.endIconFrame.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setCollapsedTextGravity(8388659);
        Oo obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, new int[]{16842766, 16842906, 16843088, R.attr.boxBackgroundColor, R.attr.boxBackgroundMode, R.attr.boxCollapsedPaddingTop, R.attr.boxCornerRadiusBottomEnd, R.attr.boxCornerRadiusBottomStart, R.attr.boxCornerRadiusTopEnd, R.attr.boxCornerRadiusTopStart, R.attr.boxStrokeColor, R.attr.boxStrokeErrorColor, R.attr.boxStrokeWidth, R.attr.boxStrokeWidthFocused, R.attr.counterEnabled, R.attr.counterMaxLength, R.attr.counterOverflowTextAppearance, R.attr.counterOverflowTextColor, R.attr.counterTextAppearance, R.attr.counterTextColor, R.attr.endIconCheckable, R.attr.endIconContentDescription, R.attr.endIconDrawable, R.attr.endIconMode, R.attr.endIconTint, R.attr.endIconTintMode, R.attr.errorContentDescription, R.attr.errorEnabled, R.attr.errorIconDrawable, R.attr.errorIconTint, R.attr.errorIconTintMode, R.attr.errorTextAppearance, R.attr.errorTextColor, R.attr.expandedHintEnabled, R.attr.helperText, R.attr.helperTextEnabled, R.attr.helperTextTextAppearance, R.attr.helperTextTextColor, R.attr.hintAnimationEnabled, R.attr.hintEnabled, R.attr.hintTextAppearance, R.attr.hintTextColor, R.attr.passwordToggleContentDescription, R.attr.passwordToggleDrawable, R.attr.passwordToggleEnabled, R.attr.passwordToggleTint, R.attr.passwordToggleTintMode, R.attr.placeholderText, R.attr.placeholderTextAppearance, R.attr.placeholderTextColor, R.attr.prefixText, R.attr.prefixTextAppearance, R.attr.prefixTextColor, R.attr.shapeAppearance, R.attr.shapeAppearanceOverlay, R.attr.startIconCheckable, R.attr.startIconContentDescription, R.attr.startIconDrawable, R.attr.startIconTint, R.attr.startIconTintMode, R.attr.suffixText, R.attr.suffixTextAppearance, R.attr.suffixTextColor}, i, DEF_STYLE_RES, 18, 16, 31, 36, 40);
        this.hintEnabled = obtainTintedStyledAttributes.O000000o(39, true);
        setHint(obtainTintedStyledAttributes.O00000o0(2));
        this.hintAnimationEnabled = obtainTintedStyledAttributes.O000000o(38, true);
        this.expandedHintEnabled = obtainTintedStyledAttributes.O000000o(33, true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet2, i2, DEF_STYLE_RES).build();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = obtainTintedStyledAttributes.O00000o(5, 0);
        this.boxStrokeWidthDefaultPx = obtainTintedStyledAttributes.O00000oO(12, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = obtainTintedStyledAttributes.O00000oO(13, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float O00000oo = obtainTintedStyledAttributes.O00000oo(9);
        float O00000oo2 = obtainTintedStyledAttributes.O00000oo(8);
        float O00000oo3 = obtainTintedStyledAttributes.O00000oo(6);
        float O00000oo4 = obtainTintedStyledAttributes.O00000oo(7);
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
        if (O00000oo >= 0.0f) {
            builder.setTopLeftCornerSize(O00000oo);
        }
        if (O00000oo2 >= 0.0f) {
            builder.setTopRightCornerSize(O00000oo2);
        }
        if (O00000oo3 >= 0.0f) {
            builder.setBottomRightCornerSize(O00000oo3);
        }
        if (O00000oo4 >= 0.0f) {
            builder.setBottomLeftCornerSize(O00000oo4);
        }
        this.shapeAppearanceModel = builder.build();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 3);
        if (colorStateList != null) {
            this.defaultFilledBackgroundColor = colorStateList.getDefaultColor();
            this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                ColorStateList O000000o2 = OO0000o.O000000o(context2, R.color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = O000000o2.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = O000000o2.getColorForState(new int[]{16843623}, -1);
            }
        } else {
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (obtainTintedStyledAttributes.O0000O0o(1)) {
            ColorStateList O00000oO = obtainTintedStyledAttributes.O00000oO(1);
            this.focusedTextColor = O00000oO;
            this.defaultHintTextColor = O00000oO;
        }
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 10);
        this.focusedStrokeColor = obtainTintedStyledAttributes.O00000Oo(10, 0);
        this.defaultStrokeColor = ContextCompat.O00000o0(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.O00000o0(context2, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.O00000o0(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateList2 != null) {
            setBoxStrokeColorStateList(colorStateList2);
        }
        if (obtainTintedStyledAttributes.O0000O0o(11)) {
            setBoxStrokeErrorColor(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 11));
        }
        if (obtainTintedStyledAttributes.O0000O0o(40, -1) != -1) {
            setHintTextAppearance(obtainTintedStyledAttributes.O0000O0o(40, 0));
        }
        int O0000O0o = obtainTintedStyledAttributes.O0000O0o(31, 0);
        CharSequence O00000o0 = obtainTintedStyledAttributes.O00000o0(26);
        boolean O000000o3 = obtainTintedStyledAttributes.O000000o(27, false);
        this.errorIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate((int) R.layout.design_text_input_end_icon, (ViewGroup) this.endLayout, false);
        this.errorIconView.setId(R.id.text_input_error_icon);
        this.errorIconView.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            bn.O000000o((ViewGroup.MarginLayoutParams) this.errorIconView.getLayoutParams(), 0);
        }
        if (obtainTintedStyledAttributes.O0000O0o(28)) {
            setErrorIconDrawable(obtainTintedStyledAttributes.O000000o(28));
        }
        if (obtainTintedStyledAttributes.O0000O0o(29)) {
            setErrorIconTintList(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 29));
        }
        if (obtainTintedStyledAttributes.O0000O0o(30)) {
            setErrorIconTintMode(ViewUtils.parseTintMode(obtainTintedStyledAttributes.O000000o(30, -1), null));
        }
        this.errorIconView.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        cb.O00000oO((View) this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
        int O0000O0o2 = obtainTintedStyledAttributes.O0000O0o(36, 0);
        boolean O000000o4 = obtainTintedStyledAttributes.O000000o(35, false);
        CharSequence O00000o02 = obtainTintedStyledAttributes.O00000o0(34);
        int O0000O0o3 = obtainTintedStyledAttributes.O0000O0o(48, 0);
        CharSequence O00000o03 = obtainTintedStyledAttributes.O00000o0(47);
        int O0000O0o4 = obtainTintedStyledAttributes.O0000O0o(51, 0);
        CharSequence O00000o04 = obtainTintedStyledAttributes.O00000o0(50);
        int O0000O0o5 = obtainTintedStyledAttributes.O0000O0o(61, 0);
        CharSequence O00000o05 = obtainTintedStyledAttributes.O00000o0(60);
        int i3 = O0000O0o5;
        boolean O000000o5 = obtainTintedStyledAttributes.O000000o(14, false);
        setCounterMaxLength(obtainTintedStyledAttributes.O000000o(15, -1));
        this.counterTextAppearance = obtainTintedStyledAttributes.O0000O0o(18, 0);
        this.counterOverflowTextAppearance = obtainTintedStyledAttributes.O0000O0o(16, 0);
        CharSequence charSequence = O00000o05;
        int i4 = O0000O0o4;
        this.startIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate((int) R.layout.design_text_input_start_icon, (ViewGroup) this.startLayout, false);
        this.startIconView.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            bn.O00000Oo((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (obtainTintedStyledAttributes.O0000O0o(57)) {
            setStartIconDrawable(obtainTintedStyledAttributes.O000000o(57));
            if (obtainTintedStyledAttributes.O0000O0o(56)) {
                setStartIconContentDescription(obtainTintedStyledAttributes.O00000o0(56));
            }
            setStartIconCheckable(obtainTintedStyledAttributes.O000000o(55, true));
        }
        if (obtainTintedStyledAttributes.O0000O0o(58)) {
            setStartIconTintList(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 58));
        }
        if (obtainTintedStyledAttributes.O0000O0o(59)) {
            setStartIconTintMode(ViewUtils.parseTintMode(obtainTintedStyledAttributes.O000000o(59, -1), null));
        }
        setBoxBackgroundMode(obtainTintedStyledAttributes.O000000o(4, 0));
        this.endIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate((int) R.layout.design_text_input_end_icon, (ViewGroup) this.endIconFrame, false);
        this.endIconFrame.addView(this.endIconView);
        this.endIconView.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            z = false;
            bn.O000000o((ViewGroup.MarginLayoutParams) this.endIconView.getLayoutParams(), 0);
        } else {
            z = false;
        }
        this.endIconDelegates.append(-1, new CustomEndIconDelegate(this));
        this.endIconDelegates.append(z, new NoEndIconDelegate(this));
        this.endIconDelegates.append(1, new PasswordToggleEndIconDelegate(this));
        this.endIconDelegates.append(2, new ClearTextEndIconDelegate(this));
        this.endIconDelegates.append(3, new DropdownMenuEndIconDelegate(this));
        if (obtainTintedStyledAttributes.O0000O0o(23)) {
            setEndIconMode(obtainTintedStyledAttributes.O000000o(23, 0));
            if (obtainTintedStyledAttributes.O0000O0o(22)) {
                setEndIconDrawable(obtainTintedStyledAttributes.O000000o(22));
            }
            if (obtainTintedStyledAttributes.O0000O0o(21)) {
                setEndIconContentDescription(obtainTintedStyledAttributes.O00000o0(21));
            }
            setEndIconCheckable(obtainTintedStyledAttributes.O000000o(20, true));
        } else if (obtainTintedStyledAttributes.O0000O0o(44)) {
            setEndIconMode(obtainTintedStyledAttributes.O000000o(44, false) ? 1 : 0);
            setEndIconDrawable(obtainTintedStyledAttributes.O000000o(43));
            setEndIconContentDescription(obtainTintedStyledAttributes.O00000o0(42));
            if (obtainTintedStyledAttributes.O0000O0o(45)) {
                setEndIconTintList(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 45));
            }
            if (obtainTintedStyledAttributes.O0000O0o(46)) {
                setEndIconTintMode(ViewUtils.parseTintMode(obtainTintedStyledAttributes.O000000o(46, -1), null));
            }
        }
        if (!obtainTintedStyledAttributes.O0000O0o(44)) {
            if (obtainTintedStyledAttributes.O0000O0o(24)) {
                setEndIconTintList(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, 24));
            }
            if (obtainTintedStyledAttributes.O0000O0o(25)) {
                setEndIconTintMode(ViewUtils.parseTintMode(obtainTintedStyledAttributes.O000000o(25, -1), null));
            }
        }
        this.prefixTextView = new AppCompatTextView(context2);
        this.prefixTextView.setId(R.id.textinput_prefix_text);
        this.prefixTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        cb.O0000OOo((View) this.prefixTextView, 1);
        this.startLayout.addView(this.startIconView);
        this.startLayout.addView(this.prefixTextView);
        this.suffixTextView = new AppCompatTextView(context2);
        this.suffixTextView.setId(R.id.textinput_suffix_text);
        this.suffixTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        cb.O0000OOo((View) this.suffixTextView, 1);
        this.endLayout.addView(this.suffixTextView);
        this.endLayout.addView(this.errorIconView);
        this.endLayout.addView(this.endIconFrame);
        setHelperTextEnabled(O000000o4);
        setHelperText(O00000o02);
        setHelperTextTextAppearance(O0000O0o2);
        setErrorEnabled(O000000o3);
        setErrorTextAppearance(O0000O0o);
        setErrorContentDescription(O00000o0);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(O00000o03);
        setPlaceholderTextAppearance(O0000O0o3);
        setPrefixText(O00000o04);
        setPrefixTextAppearance(i4);
        setSuffixText(charSequence);
        setSuffixTextAppearance(i3);
        if (obtainTintedStyledAttributes.O0000O0o(32)) {
            setErrorTextColor(obtainTintedStyledAttributes.O00000oO(32));
        }
        if (obtainTintedStyledAttributes.O0000O0o(37)) {
            setHelperTextColor(obtainTintedStyledAttributes.O00000oO(37));
        }
        if (obtainTintedStyledAttributes.O0000O0o(41)) {
            setHintTextColor(obtainTintedStyledAttributes.O00000oO(41));
        }
        if (obtainTintedStyledAttributes.O0000O0o(19)) {
            setCounterTextColor(obtainTintedStyledAttributes.O00000oO(19));
        }
        if (obtainTintedStyledAttributes.O0000O0o(17)) {
            setCounterOverflowTextColor(obtainTintedStyledAttributes.O00000oO(17));
        }
        if (obtainTintedStyledAttributes.O0000O0o(49)) {
            setPlaceholderTextColor(obtainTintedStyledAttributes.O00000oO(49));
        }
        if (obtainTintedStyledAttributes.O0000O0o(52)) {
            setPrefixTextColor(obtainTintedStyledAttributes.O00000oO(52));
        }
        if (obtainTintedStyledAttributes.O0000O0o(62)) {
            setSuffixTextColor(obtainTintedStyledAttributes.O00000oO(62));
        }
        setCounterEnabled(O000000o5);
        setEnabled(obtainTintedStyledAttributes.O000000o(0, true));
        obtainTintedStyledAttributes.f12340O000000o.recycle();
        cb.O00000oO((View) this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            cb.O00000o((View) this, 1);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.boxBackgroundMode) {
            this.boxBackgroundMode = i;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void assignBoxBackgroundByMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
        } else if (i == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderline = new MaterialShapeDrawable();
        } else if (i == 2) {
            if (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
            }
            this.boxUnderline = null;
        } else {
            throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            cb.O000000o(this.editText, this.boxBackground);
        }
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText editText2 = this.editText;
        return (editText2 == null || this.boxBackground == null || editText2.getBackground() != null || this.boxBackgroundMode == 0) ? false : true;
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode != 1) {
            return;
        }
        if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
            this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
        } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
        }
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null && this.boxBackgroundMode == 1) {
            if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                EditText editText2 = this.editText;
                cb.O00000Oo(editText2, cb.O0000OoO(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), cb.O0000Ooo(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                EditText editText3 = this.editText;
                cb.O00000Oo(editText3, cb.O0000OoO(editText3), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), cb.O0000Ooo(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidth(int i) {
        this.boxStrokeWidthDefaultPx = i;
        updateTextInputBoxState();
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.boxStrokeWidthFocusedPx = i;
        updateTextInputBoxState();
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(ContextCompat.O00000o0(getContext(), i));
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            this.focusedFilledBackgroundColor = i;
            this.hoveredFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        this.defaultFilledBackgroundColor = colorStateList.getDefaultColor();
        this.boxBackgroundColor = this.defaultFilledBackgroundColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        applyBoxAttributes();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public void setBoxCornerRadiiResources(int i, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null || materialShapeDrawable.getTopLeftCornerResolvedSize() != f || this.boxBackground.getTopRightCornerResolvedSize() != f2 || this.boxBackground.getBottomRightCornerResolvedSize() != f4 || this.boxBackground.getBottomLeftCornerResolvedSize() != f3) {
            this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f).setTopRightCornerSize(f2).setBottomRightCornerSize(f4).setBottomLeftCornerSize(f3).build();
            applyBoxAttributes();
        }
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
    }

    public void setTypeface(Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.setTypefaces(typeface2);
            this.indicatorViewController.setTypefaces(typeface2);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface2);
            }
        }
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.originalHint != null) {
            boolean z = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint2 = editText2.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
            } finally {
                this.editText.setHint(hint2);
                this.isProvidingHint = z;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i);
            onProvideAutofillVirtualStructure(viewStructure, i);
            viewStructure.setChildCount(this.inputFrame.getChildCount());
            for (int i2 = 0; i2 < this.inputFrame.getChildCount(); i2++) {
                View childAt = this.inputFrame.getChildAt(i2);
                ViewStructure newChild = viewStructure.newChild(i2);
                childAt.dispatchProvideAutofillStructure(newChild, i);
                if (childAt == this.editText) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (this.endIconMode != 3 && !(editText2 instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText2;
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
            int gravity = this.editText.getGravity();
            this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
            this.collapsingTextHelper.setExpandedTextGravity(gravity);
            this.editText.addTextChangedListener(new TextWatcher() {
                /* class com.google.android.material.textfield.TextInputLayout.AnonymousClass1 */

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
                    if (TextInputLayout.this.counterEnabled) {
                        TextInputLayout.this.updateCounter(editable.length());
                    }
                    if (TextInputLayout.this.placeholderEnabled) {
                        TextInputLayout.this.updatePlaceholderText(editable.length());
                    }
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    this.originalHint = this.editText.getHint();
                    setHint(this.originalHint);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startLayout.bringToFront();
            this.endLayout.bringToFront();
            this.endIconFrame.bringToFront();
            this.errorIconView.bringToFront();
            dispatchOnEditTextAttached();
            updatePrefixTextViewPadding();
            updateSuffixTextViewPadding();
            if (!isEnabled()) {
                editText2.setEnabled(false);
            }
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    public int getBaseline() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            return editText2.getBaseline() + getPaddingTop() + calculateLabelMarginTop();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    private void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText2 = this.editText;
        boolean z3 = editText2 != null && !TextUtils.isEmpty(editText2.getText());
        EditText editText3 = this.editText;
        boolean z4 = editText3 != null && editText3.hasFocus();
        boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(colorForState));
        } else if (errorShouldBeShown) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (z3 || !this.expandedHintEnabled || (isEnabled() && z4)) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
            }
        } else if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    public EditText getEditText() {
        return this.editText;
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.collapsingTextHelper.setText(charSequence);
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!this.hintEnabled) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public void setHintTextAppearance(int i) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.setErrorEnabled(z);
    }

    public void setErrorTextAppearance(int i) {
        this.indicatorViewController.setErrorTextAppearance(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public void setHelperTextTextAppearance(int i) {
        this.indicatorViewController.setHelperTextAppearance(i);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.setHelperTextEnabled(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.indicatorViewController.setErrorContentDescription(charSequence);
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.getErrorContentDescription();
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.showError(charSequence);
        } else {
            this.indicatorViewController.hideError();
        }
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? OO0000o.O00000Oo(getContext(), i) : null);
        refreshErrorIconDrawableState();
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.isErrorEnabled());
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.errorIconTintList = colorStateList;
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = ab.O00000oo(drawable).mutate();
            ab.O000000o(drawable, colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = ab.O00000oo(drawable).mutate();
            ab.O000000o(drawable, mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                this.counterView = new AppCompatTextView(getContext());
                this.counterView.setId(R.id.textinput_counter);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.counterView.setTypeface(typeface2);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                bn.O000000o((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            EditText editText2 = this.editText;
            updateCounter(editText2 == null ? 0 : editText2.getText().length());
        }
    }

    /* access modifiers changed from: package-private */
    public void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        int i2 = this.counterMaxLength;
        String str = null;
        if (i2 == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i > i2;
            updateCounterContentDescription(getContext(), this.counterView, i, this.counterMaxLength, this.counterOverflowed);
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            av O000000o2 = av.O000000o();
            TextView textView = this.counterView;
            String string = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength));
            ax axVar = O000000o2.O00000o;
            if (string != null) {
                str = O000000o2.O000000o(string, axVar, true).toString();
            }
            textView.setText(str);
        }
        if (this.editText != null && z != this.counterOverflowed) {
            updateLabelState(false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    private static void updateCounterContentDescription(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (!this.placeholderEnabled || !TextUtils.isEmpty(charSequence)) {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        updatePlaceholderText();
    }

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000OOo(android.view.View, int):void
     arg types: [android.widget.TextView, int]
     candidates:
      _m_j.cb.O0000OOo(android.view.View, float):void
      _m_j.cb.O0000OOo(android.view.View, int):void */
    private void setPlaceholderTextEnabled(boolean z) {
        if (this.placeholderEnabled != z) {
            if (z) {
                this.placeholderTextView = new AppCompatTextView(getContext());
                this.placeholderTextView.setId(R.id.textinput_placeholder);
                cb.O0000OOo((View) this.placeholderTextView, 1);
                setPlaceholderTextAppearance(this.placeholderTextAppearance);
                setPlaceholderTextColor(this.placeholderTextColor);
                addPlaceholderTextView();
            } else {
                removePlaceholderTextView();
                this.placeholderTextView = null;
            }
            this.placeholderEnabled = z;
        }
    }

    private void updatePlaceholderText() {
        EditText editText2 = this.editText;
        updatePlaceholderText(editText2 == null ? 0 : editText2.getText().length());
    }

    public void updatePlaceholderText(int i) {
        if (i != 0 || this.hintExpanded) {
            hidePlaceholderText();
        } else {
            showPlaceholderText();
        }
    }

    private void showPlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView != null && this.placeholderEnabled) {
            textView.setText(this.placeholderText);
            this.placeholderTextView.setVisibility(0);
            this.placeholderTextView.bringToFront();
        }
    }

    private void hidePlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView != null && this.placeholderEnabled) {
            textView.setText((CharSequence) null);
            this.placeholderTextView.setVisibility(4);
        }
    }

    private void addPlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            this.inputFrame.addView(textView);
            this.placeholderTextView.setVisibility(0);
        }
    }

    private void removePlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            TextView textView = this.placeholderTextView;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public void setPlaceholderTextAppearance(int i) {
        this.placeholderTextAppearance = i;
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            cy.O000000o(textView, i);
        }
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public void setPrefixText(CharSequence charSequence) {
        this.prefixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.prefixTextView.setText(charSequence);
        updatePrefixTextVisibility();
    }

    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    private void updatePrefixTextVisibility() {
        this.prefixTextView.setVisibility((this.prefixText == null || isHintExpanded()) ? 8 : 0);
        updateDummyDrawables();
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    public void setPrefixTextAppearance(int i) {
        cy.O000000o(this.prefixTextView, i);
    }

    private void updatePrefixTextViewPadding() {
        if (this.editText != null) {
            cb.O00000Oo(this.prefixTextView, isStartIconVisible() ? 0 : cb.O0000OoO(this.editText), this.editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getCompoundPaddingBottom());
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.suffixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    private void updateSuffixTextVisibility() {
        int visibility = this.suffixTextView.getVisibility();
        int i = 0;
        boolean z = this.suffixText != null && !isHintExpanded();
        TextView textView = this.suffixTextView;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
        if (visibility != this.suffixTextView.getVisibility()) {
            getEndIconDelegate().onSuffixVisibilityChanged(z);
        }
        updateDummyDrawables();
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    public void setSuffixTextAppearance(int i) {
        cy.O000000o(this.suffixTextView, i);
    }

    private void updateSuffixTextViewPadding() {
        if (this.editText != null) {
            cb.O00000Oo(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getPaddingTop(), (isEndIconVisible() || isErrorIconVisible()) ? 0 : cb.O0000Ooo(this.editText), this.editText.getPaddingBottom());
        }
    }

    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.counterEnabled || !this.counterOverflowed || (textView = this.counterView) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    private void updateCounterTextAppearanceAndColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (this.counterOverflowed && (colorStateList = this.counterOverflowTextColor) != null) {
                this.counterView.setTextColor(colorStateList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setTextAppearanceCompatWithErrorFallback(TextView textView, int i) {
        boolean z = true;
        try {
            cy.O000000o(textView, i);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception unused) {
        }
        if (z) {
            cy.O000000o(textView, 2132738683);
            textView.setTextColor(ContextCompat.O00000o0(getContext(), R.color.design_error));
        }
    }

    private int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        if (i == 0 || i == 1) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else if (i != 2) {
            return 0;
        } else {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    private Rect calculateCollapsedTextBounds(Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            boolean z = cb.O0000Oo0(this) == 1;
            rect2.bottom = rect.bottom;
            int i = this.boxBackgroundMode;
            if (i == 1) {
                rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z);
                rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z);
                return rect2;
            } else if (i != 2) {
                rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z);
                rect2.top = getPaddingTop();
                rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z);
                return rect2;
            } else {
                rect2.left = rect.left + this.editText.getPaddingLeft();
                rect2.top = rect.top - calculateLabelMarginTop();
                rect2.right = rect.right - this.editText.getPaddingRight();
                return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private int getLabelLeftBoundAlightWithPrefix(int i, boolean z) {
        int compoundPaddingLeft = i + this.editText.getCompoundPaddingLeft();
        return (this.prefixText == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    }

    private int getLabelRightBoundAlignedWithSuffix(int i, boolean z) {
        int compoundPaddingRight = i - this.editText.getCompoundPaddingRight();
        return (this.prefixText == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.prefixTextView.getMeasuredWidth() - this.prefixTextView.getPaddingRight());
    }

    private Rect calculateExpandedTextBounds(Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
            rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
            rect2.top = calculateExpandedLabelTop(rect, expandedTextHeight);
            rect2.right = rect.right - this.editText.getCompoundPaddingRight();
            rect2.bottom = calculateExpandedLabelBottom(rect, rect2, expandedTextHeight);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int calculateExpandedLabelTop(Rect rect, float f) {
        if (isSingleLineFilledTextField()) {
            return (int) (((float) rect.centerY()) - (f / 2.0f));
        }
        return rect.top + this.editText.getCompoundPaddingTop();
    }

    private int calculateExpandedLabelBottom(Rect rect, Rect rect2, float f) {
        if (isSingleLineFilledTextField()) {
            return (int) (((float) rect2.top) + f);
        }
        return rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode != 1) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 16 || this.editText.getMinLines() <= 1) {
            return true;
        }
        return false;
    }

    private int calculateBoxBackgroundColor() {
        return this.boxBackgroundMode == 1 ? MaterialColors.layer(MaterialColors.getColor(this, (int) R.attr.colorSurface, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
            if (canDrawOutlineStroke()) {
                this.boxBackground.setStroke((float) this.boxStrokeWidthPx, this.boxStrokeColor);
            }
            this.boxBackgroundColor = calculateBoxBackgroundColor();
            this.boxBackground.setFillColor(ColorStateList.valueOf(this.boxBackgroundColor));
            if (this.endIconMode == 3) {
                this.editText.getBackground().invalidateSelf();
            }
            applyBoxUnderlineAttributes();
            invalidate();
        }
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline != null) {
            if (canDrawStroke()) {
                this.boxUnderline.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
            }
            invalidate();
        }
    }

    private boolean canDrawOutlineStroke() {
        return this.boxBackgroundMode == 2 && canDrawStroke();
    }

    private boolean canDrawStroke() {
        return this.boxStrokeWidthPx >= 0 && this.boxStrokeColor != 0;
    }

    /* access modifiers changed from: package-private */
    public void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 0 && (background = editText2.getBackground()) != null) {
            if (OOOOOo0.O00000o0(background)) {
                background = background.mutate();
            }
            if (this.indicatorViewController.errorShouldBeShown()) {
                background.setColorFilter(OOO0o0.O000000o(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                ab.O00000oO(background);
                this.editText.refreshDrawableState();
            } else {
                background.setColorFilter(OOO0o0.O000000o(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class com.google.android.material.textfield.TextInputLayout.SavedState.AnonymousClass1 */

            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence error;
        CharSequence helperText;
        CharSequence hintText;
        boolean isEndIconChecked;
        CharSequence placeholderText;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() != 1 ? false : true;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, i);
            TextUtils.writeToParcel(this.helperText, parcel, i);
            TextUtils.writeToParcel(this.placeholderText, parcel, i);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + " hint=" + ((Object) this.hintText) + " helperText=" + ((Object) this.helperText) + " placeholderText=" + ((Object) this.placeholderText) + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = hasEndIcon() && this.endIconView.isChecked();
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new Runnable() {
                /* class com.google.android.material.textfield.TextInputLayout.AnonymousClass2 */

                public void run() {
                    TextInputLayout.this.endIconView.performClick();
                    TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }
        return null;
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.expandedHintEnabled != z) {
            this.expandedHintEnabled = z;
            updateLabelState(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean updateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean updateDummyDrawables = updateDummyDrawables();
        if (updateEditTextHeightBasedOnIcon || updateDummyDrawables) {
            this.editText.post(new Runnable() {
                /* class com.google.android.material.textfield.TextInputLayout.AnonymousClass3 */

                public void run() {
                    TextInputLayout.this.editText.requestLayout();
                }
            });
        }
        updatePlaceholderMeasurementsBasedOnEditText();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int max;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (max = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(max);
        return true;
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        EditText editText2;
        if (this.placeholderTextView != null && (editText2 = this.editText) != null) {
            this.placeholderTextView.setGravity(editText2.getGravity());
            this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? OO0000o.O00000Oo(getContext(), i) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            refreshStartIconDrawableState();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    public void setStartIconVisible(boolean z) {
        if (isStartIconVisible() != z) {
            this.startIconView.setVisibility(z ? 0 : 8);
            updatePrefixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    public void refreshStartIconDrawableState() {
        refreshIconDrawableState(this.startIconView, this.startIconTintList);
    }

    public void setStartIconCheckable(boolean z) {
        this.startIconView.setCheckable(z);
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        this.endIconMode = i;
        dispatchOnEndIconChanged(i2);
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            applyEndIconTint();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i);
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.errorIconView, onLongClickListener);
    }

    public void refreshErrorIconDrawableState() {
        refreshIconDrawableState(this.errorIconView, this.errorIconTintList);
    }

    public void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 8);
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void refreshEndIconDrawableState() {
        refreshIconDrawableState(this.endIconView, this.endIconTintList);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? OO0000o.O00000Oo(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
        refreshEndIconDrawableState();
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void addOnEndIconChangedListener(OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    public void removeOnEndIconChangedListener(OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void removeOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.remove(onEditTextAttachedListener);
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? OO0000o.O00000Oo(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else if (!z) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            cb.O000000o(editText2, accessibilityDelegate);
        }
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate endIconDelegate = this.endIconDelegates.get(this.endIconMode);
        if (endIconDelegate != null) {
            return endIconDelegate;
        }
        return this.endIconDelegates.get(0);
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    private void dispatchOnEndIconChanged(int i) {
        Iterator<OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, i);
        }
    }

    private void tintEndIconOnError(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            applyEndIconTint();
            return;
        }
        Drawable mutate = ab.O00000oo(getEndIconDrawable()).mutate();
        ab.O000000o(mutate, this.indicatorViewController.getErrorViewCurrentTextColor());
        this.endIconView.setImageDrawable(mutate);
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
    private boolean updateDummyDrawables() {
        boolean z;
        if (this.editText == null) {
            return false;
        }
        boolean z2 = true;
        if (shouldUpdateStartDummyDrawable()) {
            int measuredWidth = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
            if (this.startDummyDrawable == null || this.startDummyDrawableWidth != measuredWidth) {
                this.startDummyDrawable = new ColorDrawable();
                this.startDummyDrawableWidth = measuredWidth;
                this.startDummyDrawable.setBounds(0, 0, this.startDummyDrawableWidth, 1);
            }
            Drawable[] O00000Oo = cy.O00000Oo(this.editText);
            Drawable drawable = O00000Oo[0];
            Drawable drawable2 = this.startDummyDrawable;
            if (drawable != drawable2) {
                cy.O000000o(this.editText, drawable2, O00000Oo[1], O00000Oo[2], O00000Oo[3]);
            }
            z = false;
            if (shouldUpdateEndDummyDrawable()) {
                int measuredWidth2 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
                CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
                if (endIconToUpdateDummyDrawable != null) {
                    measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + bn.O000000o((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
                }
                Drawable[] O00000Oo2 = cy.O00000Oo(this.editText);
                Drawable drawable3 = this.endDummyDrawable;
                if (drawable3 == null || this.endDummyDrawableWidth == measuredWidth2) {
                    if (this.endDummyDrawable == null) {
                        this.endDummyDrawable = new ColorDrawable();
                        this.endDummyDrawableWidth = measuredWidth2;
                        this.endDummyDrawable.setBounds(0, 0, this.endDummyDrawableWidth, 1);
                    }
                    Drawable drawable4 = O00000Oo2[2];
                    Drawable drawable5 = this.endDummyDrawable;
                    if (drawable4 != drawable5) {
                        this.originalEditTextEndDrawable = O00000Oo2[2];
                        cy.O000000o(this.editText, O00000Oo2[0], O00000Oo2[1], drawable5, O00000Oo2[3]);
                        return true;
                    }
                } else {
                    this.endDummyDrawableWidth = measuredWidth2;
                    drawable3.setBounds(0, 0, this.endDummyDrawableWidth, 1);
                    cy.O000000o(this.editText, O00000Oo2[0], O00000Oo2[1], this.endDummyDrawable, O00000Oo2[3]);
                    return true;
                }
            } else if (this.endDummyDrawable != null) {
                Drawable[] O00000Oo3 = cy.O00000Oo(this.editText);
                if (O00000Oo3[2] == this.endDummyDrawable) {
                    cy.O000000o(this.editText, O00000Oo3[0], O00000Oo3[1], this.originalEditTextEndDrawable, O00000Oo3[3]);
                } else {
                    z2 = z;
                }
                this.endDummyDrawable = null;
                return z2;
            }
            return z;
        }
        if (this.startDummyDrawable != null) {
            Drawable[] O00000Oo4 = cy.O00000Oo(this.editText);
            cy.O000000o(this.editText, null, O00000Oo4[1], O00000Oo4[2], O00000Oo4[3]);
            this.startDummyDrawable = null;
        }
        z = false;
        if (shouldUpdateEndDummyDrawable()) {
        }
        return z;
        z = true;
        if (shouldUpdateEndDummyDrawable()) {
        }
        return z;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        return !(getStartIconDrawable() == null && this.prefixText == null) && this.startLayout.getMeasuredWidth() > 0;
    }

    private boolean shouldUpdateEndDummyDrawable() {
        return (this.errorIconView.getVisibility() == 0 || ((hasEndIcon() && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0;
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (!hasEndIcon() || !isEndIconVisible()) {
            return null;
        }
        return this.endIconView;
    }

    private void applyIconTint(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = ab.O00000oo(drawable).mutate();
            if (z) {
                ab.O000000o(drawable, colorStateList);
            }
            if (z2) {
                ab.O000000o(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private static void setIconOnClickListener(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [com.google.android.material.internal.CheckableImageButton, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    private static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean O000OO = cb.O000OO(checkableImageButton);
        boolean z = false;
        int i = 1;
        boolean z2 = onLongClickListener != null;
        if (O000OO || z2) {
            z = true;
        }
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(O000OO);
        checkableImageButton.setPressable(O000OO);
        checkableImageButton.setLongClickable(z2);
        if (!z) {
            i = 2;
        }
        cb.O00000oO((View) checkableImageButton, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText2, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.recalculate();
                if (cutoutEnabled() && !this.hintExpanded) {
                    openCutout();
                }
            }
        }
    }

    private void updateBoxUnderlineBounds(Rect rect) {
        if (this.boxUnderline != null) {
            this.boxUnderline.setBounds(rect.left, rect.bottom - this.boxStrokeWidthFocusedPx, rect.right, rect.bottom);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    private void drawHint(Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    private void collapseHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
        updatePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF, this.editText.getWidth(), this.editText.getGravity());
            applyCutoutPadding(rectF);
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            ((CutoutDrawable) this.boxBackground).setCutout(rectF);
        }
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void applyCutoutPadding(RectF rectF) {
        rectF.left -= (float) this.boxLabelCutoutPaddingPx;
        rectF.top -= (float) this.boxLabelCutoutPaddingPx;
        rectF.right += (float) this.boxLabelCutoutPaddingPx;
        rectF.bottom += (float) this.boxLabelCutoutPaddingPx;
    }

    /* access modifiers changed from: package-private */
    public boolean cutoutIsOpen() {
        return cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.inDrawableStateChanged) {
            boolean z = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            boolean state = collapsingTextHelper2 != null ? collapsingTextHelper2.setState(drawableState) | false : false;
            if (this.editText != null) {
                if (!cb.O000O0oO(this) || !isEnabled()) {
                    z = false;
                }
                updateLabelState(z);
            }
            updateEditTextBackground();
            updateTextInputBoxState();
            if (state) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateTextInputBoxState() {
        TextView textView;
        EditText editText2;
        EditText editText3;
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            boolean z = false;
            boolean z2 = isFocused() || ((editText3 = this.editText) != null && editText3.hasFocus());
            boolean z3 = isHovered() || ((editText2 = this.editText) != null && editText2.isHovered());
            if (!isEnabled()) {
                this.boxStrokeColor = this.disabledColor;
            } else if (this.indicatorViewController.errorShouldBeShown()) {
                if (this.strokeErrorColor != null) {
                    updateStrokeErrorColor(z2, z3);
                } else {
                    this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
                }
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                if (z2) {
                    this.boxStrokeColor = this.focusedStrokeColor;
                } else if (z3) {
                    this.boxStrokeColor = this.hoveredStrokeColor;
                } else {
                    this.boxStrokeColor = this.defaultStrokeColor;
                }
            } else if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z2, z3);
            } else {
                this.boxStrokeColor = textView.getCurrentTextColor();
            }
            if (getErrorIconDrawable() != null && this.indicatorViewController.isErrorEnabled() && this.indicatorViewController.errorShouldBeShown()) {
                z = true;
            }
            setErrorIconVisible(z);
            refreshErrorIconDrawableState();
            refreshStartIconDrawableState();
            refreshEndIconDrawableState();
            if (getEndIconDelegate().shouldTintIconOnError()) {
                tintEndIconOnError(this.indicatorViewController.errorShouldBeShown());
            }
            if (!z2 || !isEnabled()) {
                this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
            } else {
                this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
            }
            if (this.boxBackgroundMode == 1) {
                if (!isEnabled()) {
                    this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                } else if (z3 && !z2) {
                    this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                } else if (z2) {
                    this.boxBackgroundColor = this.focusedFilledBackgroundColor;
                } else {
                    this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                }
            }
            applyBoxAttributes();
        }
    }

    private void updateStrokeErrorColor(boolean z, boolean z2) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.boxStrokeColor = colorForState2;
        } else if (z2) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    private void setErrorIconVisible(boolean z) {
        int i = 0;
        this.errorIconView.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.endIconFrame;
        if (z) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        updateSuffixTextViewPadding();
        if (!hasEndIcon()) {
            updateDummyDrawables();
        }
    }

    private boolean isErrorIconVisible() {
        return this.errorIconView.getVisibility() == 0;
    }

    private void refreshIconDrawableState(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(mergeIconState(checkableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = ab.O00000oo(drawable).mutate();
            ab.O000000o(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    private int[] mergeIconState(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void expandHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        } else {
            animateToExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout()) {
            closeCutout();
        }
        this.hintExpanded = true;
        hidePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    /* access modifiers changed from: package-private */
    public void animateToExpansionFraction(float f) {
        if (this.collapsingTextHelper.getExpansionFraction() != f) {
            if (this.animator == null) {
                this.animator = new ValueAnimator();
                this.animator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.animator.setDuration(167L);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.google.android.material.textfield.TextInputLayout.AnonymousClass4 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(this.collapsingTextHelper.getExpansionFraction(), f);
            this.animator.start();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    /* access modifiers changed from: package-private */
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    /* access modifiers changed from: package-private */
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public static class AccessibilityDelegate extends bh {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            cl clVar2 = clVar;
            super.onInitializeAccessibilityNodeInfo(view, clVar);
            EditText editText = this.layout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.layout.isHintExpanded();
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = false;
            boolean z6 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                clVar2.O00000o0(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                clVar2.O00000o0(charSequence);
                if (z3 && placeholderText != null) {
                    clVar2.O00000o0(charSequence + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                clVar2.O00000o0(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    clVar2.O00000oo(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    clVar2.O00000o0(charSequence);
                }
                if (!z) {
                    z5 = true;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    clVar2.f13980O000000o.setShowingHintText(z5);
                } else {
                    clVar2.O000000o(4, z5);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                clVar2.f13980O000000o.setMaxTextLength(counterMaxLength);
            }
            if (z6) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    clVar2.f13980O000000o.setError(error);
                }
            }
            if (Build.VERSION.SDK_INT >= 17 && editText != null) {
                editText.setLabelFor(R.id.textinput_helper_text);
            }
        }
    }
}
