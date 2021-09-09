package androidx.appcompat.widget;

import _m_j.OO0000o;
import _m_j.OOO;
import _m_j.OOOO0OO;
import _m_j.Oo;
import _m_j.Oo000;
import _m_j.cy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] TINT_ATTRS = {16843016};
    private final OOOO0OO mTextHelper;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.mTextHelper = new OOOO0OO(this);
        this.mTextHelper.O000000o(attributeSet, i);
        this.mTextHelper.O000000o();
        Oo O000000o2 = Oo.O000000o(getContext(), attributeSet, TINT_ATTRS, i, 0);
        setCheckMarkDrawable(O000000o2.O000000o(0));
        O000000o2.f12340O000000o.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(OO0000o.O00000Oo(getContext(), i));
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
        OOOO0OO oooo0oo = this.mTextHelper;
        if (oooo0oo != null) {
            oooo0oo.O000000o();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return OOO.O000000o(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(cy.O000000o(this, callback));
    }
}
