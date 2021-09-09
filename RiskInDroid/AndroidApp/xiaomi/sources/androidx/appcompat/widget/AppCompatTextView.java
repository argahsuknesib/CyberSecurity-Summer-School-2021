package androidx.appcompat.widget;

import _m_j.OO0000o;
import _m_j.OOO;
import _m_j.OOO0oO;
import _m_j.OOOO0O;
import _m_j.OOOO0OO;
import _m_j.Oo000;
import _m_j.ca;
import _m_j.cs;
import _m_j.cy;
import _m_j.da;
import _m_j.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements ca, cs, da {
    private final OOO0oO mBackgroundTintHelper;
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private final OOOO0O mTextClassifierHelper;
    private final OOOO0OO mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.mBackgroundTintHelper = new OOO0oO(this);
        this.mBackgroundTintHelper.O000000o(attributeSet, i);
        this.mTextHelper = new OOOO0OO(this);
        this.mTextHelper.O000000o(attributeSet, i);
        this.mTextHelper.O000000o();
        this.mTextClassifierHelper = new OOOO0O(this);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            return oOO0oO.O00000Oo();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            return oOO0oO.O00000o0();
        }
        return null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O00000o();
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O00000Oo();
        }
    }

    public void setTextSize(int i, float f) {
        if (f14293O000000o) {
            super.setTextSize(i, f);
            return;
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o(i, f);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.mTextHelper != null && !f14293O000000o && this.mTextHelper.f12328O000000o.O00000Oo()) {
            this.mTextHelper.f12328O000000o.O000000o();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f14293O000000o) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o(i);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (f14293O000000o) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (f14293O000000o) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o(iArr, i);
        }
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!f14293O000000o) {
            OOOO0OO oooo0oo = this.mTextHelper;
            if (oooo0oo != null) {
                return oooo0oo.f12328O000000o.f12330O000000o;
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (f14293O000000o) {
            return super.getAutoSizeStepGranularity();
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            return Math.round(oooo0oo.f12328O000000o.O00000Oo);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f14293O000000o) {
            return super.getAutoSizeMinTextSize();
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            return Math.round(oooo0oo.f12328O000000o.O00000o0);
        }
        return -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (f14293O000000o) {
            return super.getAutoSizeMaxTextSize();
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            return Math.round(oooo0oo.f12328O000000o.O00000o);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f14293O000000o) {
            return super.getAutoSizeTextAvailableSizes();
        }
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            return oooo0oo.f12328O000000o.O00000oO;
        }
        return new int[0];
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return OOO.O000000o(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            cy.O00000Oo(this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            cy.O00000o0(this, i);
        }
    }

    public void setLineHeight(int i) {
        cy.O00000o(this, i);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(cy.O000000o(this, callback));
    }

    public PrecomputedTextCompat.O000000o getTextMetricsParamsCompat() {
        return cy.O00000o0(this);
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        cy.O000000o(this, precomputedTextCompat);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                cy.O000000o(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        OOOO0O oooo0o;
        if (Build.VERSION.SDK_INT >= 28 || (oooo0o = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            oooo0o.f12327O000000o = textClassifier;
        }
    }

    public TextClassifier getTextClassifier() {
        OOOO0O oooo0o;
        if (Build.VERSION.SDK_INT >= 28 || (oooo0o = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        return oooo0o.O000000o();
    }

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i, i2);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable O00000Oo = i != 0 ? OO0000o.O00000Oo(context, i) : null;
        Drawable O00000Oo2 = i2 != 0 ? OO0000o.O00000Oo(context, i2) : null;
        Drawable O00000Oo3 = i3 != 0 ? OO0000o.O00000Oo(context, i3) : null;
        if (i4 != 0) {
            drawable = OO0000o.O00000Oo(context, i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(O00000Oo, O00000Oo2, O00000Oo3, drawable);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable O00000Oo = i != 0 ? OO0000o.O00000Oo(context, i) : null;
        Drawable O00000Oo2 = i2 != 0 ? OO0000o.O00000Oo(context, i2) : null;
        Drawable O00000Oo3 = i3 != 0 ? OO0000o.O00000Oo(context, i3) : null;
        if (i4 != 0) {
            drawable = OO0000o.O00000Oo(context, i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(O00000Oo, O00000Oo2, O00000Oo3, drawable);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.O00000o0();
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.O000000o(colorStateList);
        this.mTextHelper.O000000o();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.O00000o();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.O000000o(mode);
        this.mTextHelper.O000000o();
    }

    public void setTypeface(Typeface typeface, int i) {
        Typeface O000000o2 = (typeface == null || i <= 0) ? null : t.O000000o(getContext(), typeface, i);
        if (O000000o2 != null) {
            typeface = O000000o2;
        }
        super.setTypeface(typeface, i);
    }

    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.O000000o o000000o) {
        int i;
        if (Build.VERSION.SDK_INT >= 18) {
            TextDirectionHeuristic textDirectionHeuristic = o000000o.O00000Oo;
            if (!(textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
                if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                    i = 2;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                    i = 3;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                    i = 4;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                    i = 5;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                    i = 6;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                    i = 7;
                }
                setTextDirection(i);
            }
            i = 1;
            setTextDirection(i);
        }
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = o000000o.f2838O000000o.getTextScaleX();
            getPaint().set(o000000o.f2838O000000o);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
            return;
        }
        getPaint().set(o000000o.f2838O000000o);
        setBreakStrategy(o000000o.O00000o0);
        setHyphenationFrequency(o000000o.O00000o);
    }
}
