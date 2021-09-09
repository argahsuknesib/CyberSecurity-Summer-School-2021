package com.transitionseverywhere;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        O00000Oo();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    private void O00000Oo() {
        O000000o(1);
        O000000o(new Fade(2)).O000000o(new ChangeBounds()).O000000o(new Fade(1));
    }
}
