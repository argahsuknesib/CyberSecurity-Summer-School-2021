package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(AttributeSet attributeSet) {
        super.O000000o(attributeSet);
        this.O0000o0 = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O00000o0();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        O00000o0();
    }

    public void setElevation(float f) {
        super.setElevation(f);
        O00000o0();
    }

    public final void O000000o() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.O000o0o0.O00000oO(0);
        layoutParams.O000o0o0.O00000oo(0);
    }
}
