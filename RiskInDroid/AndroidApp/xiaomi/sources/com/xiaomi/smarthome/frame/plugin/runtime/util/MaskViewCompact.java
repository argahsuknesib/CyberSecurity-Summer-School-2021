package com.xiaomi.smarthome.frame.plugin.runtime.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;

public class MaskViewCompact extends View implements ReactPointerEventsView {
    public MaskViewCompact(Context context) {
        super(context);
    }

    public MaskViewCompact(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaskViewCompact(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PointerEvents getPointerEvents() {
        return PointerEvents.BOX_ONLY;
    }
}
