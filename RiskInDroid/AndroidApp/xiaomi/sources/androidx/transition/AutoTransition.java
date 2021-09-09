package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        O000000o();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    private void O000000o() {
        O000000o(1);
        O000000o(new Fade(2)).O000000o(new ChangeBounds()).O000000o(new Fade(1));
    }
}
