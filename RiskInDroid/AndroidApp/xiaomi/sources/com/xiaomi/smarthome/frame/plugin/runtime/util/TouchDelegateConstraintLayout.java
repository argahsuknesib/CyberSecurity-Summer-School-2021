package com.xiaomi.smarthome.frame.plugin.runtime.util;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;

public class TouchDelegateConstraintLayout extends ConstraintLayout implements ReactPointerEventsView {
    boolean mIsShowing;

    public TouchDelegateConstraintLayout(Context context) {
        this(context, null);
    }

    public TouchDelegateConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TouchDelegateConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsShowing = true;
    }

    public void setDialogIsShowing(boolean z) {
        this.mIsShowing = z;
    }

    public PointerEvents getPointerEvents() {
        return this.mIsShowing ? PointerEvents.BOX_ONLY : PointerEvents.BOX_NONE;
    }
}
