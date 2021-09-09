package androidx.appcompat.widget;

import _m_j.OO0000o;
import _m_j.OOO;
import _m_j.OOO0oO;
import _m_j.OOOO0OO;
import _m_j.Oo;
import _m_j.Oo000;
import _m_j.ca;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import com.xiaomi.smarthome.R;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements ca {
    private static final int[] TINT_ATTRS = {16843126};
    private final OOO0oO mBackgroundTintHelper;
    private final OOOO0OO mTextHelper;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        Oo000.O000000o(this, getContext());
        Oo O000000o2 = Oo.O000000o(getContext(), attributeSet, TINT_ATTRS, i, 0);
        if (O000000o2.O0000O0o(0)) {
            setDropDownBackgroundDrawable(O000000o2.O000000o(0));
        }
        O000000o2.f12340O000000o.recycle();
        this.mBackgroundTintHelper = new OOO0oO(this);
        this.mBackgroundTintHelper.O000000o(attributeSet, i);
        this.mTextHelper = new OOOO0OO(this);
        this.mTextHelper.O000000o(attributeSet, i);
        this.mTextHelper.O000000o();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(OO0000o.O00000Oo(getContext(), i));
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

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return OOO.O000000o(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
