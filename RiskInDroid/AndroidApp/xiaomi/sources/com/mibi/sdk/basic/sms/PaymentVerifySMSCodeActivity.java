package com.mibi.sdk.basic.sms;

import _m_j.cev;
import _m_j.cew;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.ProgressButton;
import com.xiaomi.smarthome.R;
import java.util.Locale;

public class PaymentVerifySMSCodeActivity extends BaseMvpActivity implements cev.O00000Oo {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public ProgressButton f5110O000000o;
    private ProgressButton O00000Oo;
    /* access modifiers changed from: private */
    public TextView O00000o;
    /* access modifiers changed from: private */
    public EditText O00000o0;
    private TextView O00000oO;
    private ProgressButton.IOnClickListener O00000oo = new ProgressButton.IOnClickListener() {
        /* class com.mibi.sdk.basic.sms.PaymentVerifySMSCodeActivity.AnonymousClass1 */

        public final void onClick(View view) {
            PaymentVerifySMSCodeActivity.this.f5110O000000o.setVisibility(0);
            PaymentVerifySMSCodeActivity.this.f5110O000000o.startProgress();
            ((cev.O000000o) PaymentVerifySMSCodeActivity.this.getPresenter()).O000000o();
        }
    };
    private ProgressButton.IOnClickListener O0000O0o = new ProgressButton.IOnClickListener() {
        /* class com.mibi.sdk.basic.sms.PaymentVerifySMSCodeActivity.AnonymousClass2 */

        public final void onClick(View view) {
            String obj = PaymentVerifySMSCodeActivity.this.O00000o0.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                PaymentVerifySMSCodeActivity.this.O00000o.setVisibility(0);
                PaymentVerifySMSCodeActivity.this.O00000o.setText(PaymentVerifySMSCodeActivity.this.getString(R.string.mibi_sms_code_empty));
                return;
            }
            PaymentVerifySMSCodeActivity.this.O00000o.setVisibility(8);
            ((cev.O000000o) PaymentVerifySMSCodeActivity.this.getPresenter()).O000000o(obj);
        }
    };

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        setContentView((int) R.layout.mibi_payment_verify_sms_code);
        this.f5110O000000o = (ProgressButton) findViewById(R.id.button_reget_sms_code);
        this.f5110O000000o.setClickListener(this.O00000oo);
        this.O00000Oo = (ProgressButton) findViewById(R.id.btn_confirm_balance_info);
        this.O00000Oo.setClickListener(this.O0000O0o);
        this.O00000o0 = (EditText) findViewById(R.id.edit_sms_code);
        this.O00000o = (TextView) findViewById(R.id.sms_code_error_info);
        this.O00000oO = (TextView) findViewById(R.id.remain_seconds);
        TextView textView = (TextView) findViewById(R.id.sms_code_summary);
        String stringExtra = getIntent().getStringExtra("payment_phone_num");
        if (!TextUtils.isEmpty(stringExtra)) {
            int length = stringExtra.length();
            if (length > 4) {
                stringExtra = stringExtra.substring(length - 4);
            }
            textView.setText(getString(R.string.mibi_summary_sms_code, new Object[]{stringExtra}));
            return;
        }
        throw new IllegalArgumentException("PhoneNum should not be null in PaymentVerifySMSCodeFragment");
    }

    public IPresenter onCreatePresenter() {
        return new cew(cev.O00000Oo.class);
    }

    public void a(int i) {
        if (i > 0) {
            this.O00000oO.setVisibility(0);
            this.f5110O000000o.setVisibility(8);
            this.O00000oO.setText(String.format(Locale.ENGLISH, "%d", Integer.valueOf(i)));
            return;
        }
        this.O00000oO.setVisibility(8);
        this.f5110O000000o.setVisibility(0);
        this.f5110O000000o.stopProgress();
    }

    public void a() {
        setResult(-1);
        finish();
    }

    public void a(String str, Throwable th) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o.setVisibility(0);
            this.O00000o.setText(str);
        }
        this.O00000Oo.stopProgress();
    }

    public void a(int i, String str) {
        setResult(i, EntryResultUtils.makeResult(i, str));
        finish();
    }

    public void b() {
        setResult(1104, EntryResultUtils.makeResult(1985, "need re-login"));
        finish();
    }

    public void a(Bundle bundle) {
        this.O00000Oo.stopProgress();
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(1104, intent);
        finish();
    }
}
