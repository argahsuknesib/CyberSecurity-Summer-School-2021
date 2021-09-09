package androidx.appcompat.widget;

import _m_j.OO0000o;
import _m_j.OOO0o00;
import _m_j.OOO0oO;
import _m_j.OOOO0OO;
import _m_j.Oo000;
import _m_j.ca;
import _m_j.cz;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.xiaomi.smarthome.R;

public class AppCompatRadioButton extends RadioButton implements ca, cz {
    private final OOO0oO mBackgroundTintHelper;
    private final OOO0o00 mCompoundButtonHelper;
    private final OOOO0OO mTextHelper;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.mCompoundButtonHelper = new OOO0o00(this);
        this.mCompoundButtonHelper.O000000o(attributeSet, i);
        this.mBackgroundTintHelper = new OOO0oO(this);
        this.mBackgroundTintHelper.O000000o(attributeSet, i);
        this.mTextHelper = new OOOO0OO(this);
        this.mTextHelper.O000000o(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        OOO0o00 oOO0o00 = this.mCompoundButtonHelper;
        if (oOO0o00 != null) {
            oOO0o00.O000000o();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(OO0000o.O00000Oo(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        OOO0o00 oOO0o00 = this.mCompoundButtonHelper;
        return oOO0o00 != null ? oOO0o00.O000000o(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        OOO0o00 oOO0o00 = this.mCompoundButtonHelper;
        if (oOO0o00 != null) {
            oOO0o00.O000000o(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        OOO0o00 oOO0o00 = this.mCompoundButtonHelper;
        if (oOO0o00 != null) {
            return oOO0o00.f12323O000000o;
        }
        return null;
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        OOO0o00 oOO0o00 = this.mCompoundButtonHelper;
        if (oOO0o00 != null) {
            oOO0o00.O000000o(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        OOO0o00 oOO0o00 = this.mCompoundButtonHelper;
        if (oOO0o00 != null) {
            return oOO0o00.O00000Oo;
        }
        return null;
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

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(i);
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
}
