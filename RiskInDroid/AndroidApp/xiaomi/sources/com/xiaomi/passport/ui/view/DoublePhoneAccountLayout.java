package com.xiaomi.passport.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.view.PhoneAccountCard;
import com.xiaomi.smarthome.R;

public class DoublePhoneAccountLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public PhoneAccountCard f6330O000000o;
    public PhoneAccountCard O00000Oo;
    public O000000o O00000o;
    public TextView O00000o0;

    public interface O000000o extends PhoneAccountCard.O000000o {
        void O00000Oo();
    }

    public DoublePhoneAccountLayout(Context context) {
        super(context);
        O000000o(context);
    }

    public DoublePhoneAccountLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public DoublePhoneAccountLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.passport_layout_double_phone_account, this);
        findViewById(R$id.btn_login_other).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.passport.ui.view.DoublePhoneAccountLayout.AnonymousClass1 */

            public final void onClick(View view) {
                if (DoublePhoneAccountLayout.this.O00000o != null) {
                    DoublePhoneAccountLayout.this.O00000o.O00000Oo();
                }
            }
        });
        this.f6330O000000o = (PhoneAccountCard) findViewById(R$id.phone_account_1);
        this.O00000Oo = (PhoneAccountCard) findViewById(R$id.phone_account_2);
        this.O00000o0 = (TextView) findViewById(R$id.tv_page_title);
    }

    public void setOnActionListener(O000000o o000000o) {
        this.O00000o = o000000o;
        this.f6330O000000o.setOnActionListener(o000000o);
        this.O00000Oo.setOnActionListener(o000000o);
    }
}
