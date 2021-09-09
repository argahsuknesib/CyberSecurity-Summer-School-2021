package androidx.appcompat.widget;

import _m_j.OOO0oO;
import _m_j.OOOO0OO;
import _m_j.Oo000;
import _m_j.ca;
import _m_j.cs;
import _m_j.cy;
import _m_j.da;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.xiaomi.smarthome.R;

public class AppCompatButton extends Button implements ca, cs, da {
    private final OOO0oO mBackgroundTintHelper;
    private final OOOO0OO mTextHelper;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.mBackgroundTintHelper = new OOO0oO(this);
        this.mBackgroundTintHelper.O000000o(attributeSet, i);
        this.mTextHelper = new OOOO0OO(this);
        this.mTextHelper.O000000o(attributeSet, i);
        this.mTextHelper.O000000o();
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

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
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

    public void setSupportAllCaps(boolean z) {
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o(z);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(cy.O000000o(this, callback));
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.O000000o(colorStateList);
        this.mTextHelper.O000000o();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.O00000o0();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.O000000o(mode);
        this.mTextHelper.O000000o();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.O00000o();
    }
}
