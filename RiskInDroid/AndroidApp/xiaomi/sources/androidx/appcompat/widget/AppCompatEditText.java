package androidx.appcompat.widget;

import _m_j.OOO;
import _m_j.OOO0oO;
import _m_j.OOOO0O;
import _m_j.OOOO0OO;
import _m_j.Oo000;
import _m_j.ca;
import _m_j.cy;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import com.xiaomi.smarthome.R;

public class AppCompatEditText extends EditText implements ca {
    private final OOO0oO mBackgroundTintHelper;
    private final OOOO0O mTextClassifierHelper;
    private final OOOO0OO mTextHelper;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.mBackgroundTintHelper = new OOO0oO(this);
        this.mBackgroundTintHelper.O000000o(attributeSet, i);
        this.mTextHelper = new OOOO0OO(this);
        this.mTextHelper.O000000o(attributeSet, i);
        this.mTextHelper.O000000o();
        this.mTextClassifierHelper = new OOOO0O(this);
    }

    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(cy.O000000o(this, callback));
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
}
