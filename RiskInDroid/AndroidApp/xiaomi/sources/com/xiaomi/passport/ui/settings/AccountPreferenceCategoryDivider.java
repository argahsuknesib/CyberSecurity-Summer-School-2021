package com.xiaomi.passport.ui.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class AccountPreferenceCategoryDivider extends View {
    public AccountPreferenceCategoryDivider(Context context) {
        super(context);
        O000000o();
    }

    public AccountPreferenceCategoryDivider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public AccountPreferenceCategoryDivider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        setBackground(getResources().getDrawable(R.drawable.account_preference_category_divider));
    }
}
