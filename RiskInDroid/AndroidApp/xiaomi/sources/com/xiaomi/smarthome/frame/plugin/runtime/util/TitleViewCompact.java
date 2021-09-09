package com.xiaomi.smarthome.frame.plugin.runtime.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;

public class TitleViewCompact extends View implements ReactPointerEventsView {
    public TitleViewCompact(Context context) {
        super(context);
    }

    public TitleViewCompact(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TitleViewCompact(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PointerEvents getPointerEvents() {
        return ((TouchDelegateConstraintLayout) getParent()).mIsShowing ? PointerEvents.BOX_ONLY : PointerEvents.NONE;
    }
}
