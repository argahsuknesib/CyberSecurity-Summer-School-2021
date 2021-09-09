package com.mibi.sdk.qrpay.pay;

import _m_j.che;
import _m_j.chf;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.mibi.sdk.basic.auth.PaymentCheckPasswordActivity;
import com.mibi.sdk.basic.sms.PaymentVerifySMSCodeActivity;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.QueryPaymentException;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.AlertDialog;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;

public class QrPayActivity extends BaseMvpActivity implements che.O00000Oo, DialogInterface.OnCancelListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5176O000000o;

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        this.f5176O000000o = new SimpleProgressDialog(this);
        this.f5176O000000o.setMessage(getResources().getString(R.string.mibi_creating_order));
        this.f5176O000000o.setOnCancelListener(this);
    }

    public void onResume() {
        super.onResume();
        this.f5176O000000o.show();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f5176O000000o.dismiss();
    }

    public void a(int i, String str, Throwable th) {
        setResult(i, EntryResultUtils.makeResult(i, str, th instanceof QueryPaymentException ? ((QueryPaymentException) th).getArguments() : null));
        finish();
    }

    public void a(int i, Bundle bundle) {
        StringBuilder sb = new StringBuilder("handleError arguments is null ? ");
        sb.append(bundle == null);
        Log.d("QrPayActivity", sb.toString());
        if (bundle != null) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
    }

    public void a(Bundle bundle) {
        Log.d("QrPayActivity", "success");
        this.f5176O000000o.dismiss();
        setResult(-1, EntryResultUtils.makeResult(-1, "success", bundle));
        finish();
    }

    public IPresenter onCreatePresenter() {
        return new chf();
    }

    public void onCancel(DialogInterface dialogInterface) {
        Log.d("QrPayActivity", "user progress dialog cancel");
        onBackPressed();
    }

    public void onPasswordCheck() {
        Intent intent = new Intent(this, PaymentCheckPasswordActivity.class);
        intent.putExtra("processId", ((che.O000000o) getPresenter()).O000000o());
        startActivityForResult(intent, 201);
    }

    public void onSMSCodeCheck(Bundle bundle) {
        Intent intent = new Intent(this, PaymentVerifySMSCodeActivity.class);
        intent.putExtra("processId", ((che.O000000o) getPresenter()).O000000o());
        intent.putExtras(bundle);
        startActivityForResult(intent, 202);
    }

    public void onBindPhoneCheck(Bundle bundle) {
        Log.d("QrPayActivity", "onBindPhoneCheck");
        final String string = bundle.getString("bindPhoneUrl");
        String string2 = getResources().getString(R.string.mibi_title_bind_phone);
        AlertDialog create = new AlertDialog.Builder(this).setTitle(string2).setMessage(getResources().getString(R.string.mibi_summary_bind_phone)).setClickable(true).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            /* class com.mibi.sdk.qrpay.pay.QrPayActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                QrPayActivity.this.setResult(0);
                dialogInterface.dismiss();
                QrPayActivity.this.finish();
            }
        }).setPositiveButton((int) R.string.mibi_button_bind_phone, new DialogInterface.OnClickListener() {
            /* class com.mibi.sdk.qrpay.pay.QrPayActivity.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                String accountBaseUrl = CommonConstants.getAccountBaseUrl("/upgradeUser");
                if (!TextUtils.isEmpty(string)) {
                    accountBaseUrl = string;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(accountBaseUrl));
                intent.addFlags(67108864);
                intent.addFlags(8388608);
                QrPayActivity.this.startActivity(intent);
                QrPayActivity.this.setResult(-1);
                dialogInterface.dismiss();
                QrPayActivity.this.finish();
            }
        }).create();
        create.setCancelable(false);
        create.show();
        setResult(9807, EntryResultUtils.makeResult(9807, "user need bind phone"));
        finish();
    }

    public void onAccountFrozen() {
        Toast.makeText(this, getResources().getString(R.string.mibi_error_frozen_summary), 0).show();
        setResult(9801, EntryResultUtils.makeResult(9801, "account frozen"));
        finish();
    }
}
