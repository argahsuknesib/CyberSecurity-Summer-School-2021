package com.xiaomi.passport.ui.settings;

import android.content.Context;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;

public class AccountValuePreference extends Preference {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f6282O000000o;
    private boolean O00000Oo;
    private int O00000o;
    private CharSequence O00000o0;

    public AccountValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6282O000000o = false;
        this.O00000Oo = false;
        this.O00000o = -1;
        setLayoutResource(R.layout.account_preference_item);
    }

    public AccountValuePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6282O000000o = false;
        this.O00000Oo = false;
        this.O00000o = -1;
        setLayoutResource(R.layout.account_preference_item);
    }

    public AccountValuePreference(Context context) {
        this(context, null);
        setLayoutResource(R.layout.account_preference_item);
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        view.setPadding(0, 0, 0, 0);
        TextView textView = (TextView) view.findViewById(R$id.value_right);
        if (textView != null) {
            CharSequence charSequence = this.O00000o0;
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }
}
