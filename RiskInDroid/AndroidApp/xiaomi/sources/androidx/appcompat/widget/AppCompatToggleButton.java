package androidx.appcompat.widget;

import _m_j.OOOO0OO;
import _m_j.Oo000;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class AppCompatToggleButton extends ToggleButton {
    private final OOOO0OO mTextHelper;

    public AppCompatToggleButton(Context context) {
        this(context, null);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.mTextHelper = new OOOO0OO(this);
        this.mTextHelper.O000000o(attributeSet, i);
    }
}
