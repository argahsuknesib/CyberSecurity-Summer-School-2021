package com.xiaomi.passport.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;

public class AccountLoginPageHeader extends FrameLayout implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f6329O000000o;
    private View O00000Oo;
    private O000000o O00000o;
    private TextView O00000o0;

    public interface O000000o {
        void onBackClicked(View view);

        void onCountryNameClicked(View view);

        void onHelpClicked(View view);
    }

    public AccountLoginPageHeader(Context context) {
        super(context);
        O000000o(context);
    }

    public AccountLoginPageHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public AccountLoginPageHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.passport_layout_account_login_page_header, this);
        this.f6329O000000o = findViewById(R$id.header_back);
        this.f6329O000000o.setOnClickListener(this);
        this.O00000Oo = findViewById(R$id.header_help);
        this.O00000Oo.setOnClickListener(this);
        this.O00000o0 = (TextView) findViewById(R$id.header_country_name);
        this.O00000o0.setOnClickListener(this);
    }

    public void setOnActionListener(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public void onClick(View view) {
        if (this.O00000o != null) {
            int id = view.getId();
            if (id == R$id.header_back) {
                this.O00000o.onBackClicked(view);
            } else if (id == R$id.header_help) {
                this.O00000o.onHelpClicked(view);
            } else if (id == R$id.header_country_name) {
                this.O00000o.onCountryNameClicked(view);
            } else {
                throw new IllegalStateException("unknown id ".concat(String.valueOf(id)));
            }
        }
    }

    public final void O000000o(boolean z) {
        int i = 0;
        setVisibility(0);
        TextView textView = this.O00000o0;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public final void O000000o(String str) {
        this.O00000o0.setText(str);
    }
}
