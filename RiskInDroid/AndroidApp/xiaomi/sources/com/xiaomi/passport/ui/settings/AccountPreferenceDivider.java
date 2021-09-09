package com.xiaomi.passport.ui.settings;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class AccountPreferenceDivider extends View {
    public AccountPreferenceDivider(Context context) {
        super(context);
        O000000o();
    }

    public AccountPreferenceDivider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public AccountPreferenceDivider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        setBackground(new ColorDrawable(getResources().getColor(R.color.preference_divider_color)));
    }
}
