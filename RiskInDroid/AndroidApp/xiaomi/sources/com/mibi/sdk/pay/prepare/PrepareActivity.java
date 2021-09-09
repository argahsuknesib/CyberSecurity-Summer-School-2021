package com.mibi.sdk.pay.prepare;

import _m_j.cgn;
import _m_j.cgo;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.mibi.sdk.basic.auth.PaymentCheckPasswordActivity;
import com.mibi.sdk.basic.sms.PaymentVerifySMSCodeActivity;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.QueryPaymentException;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.pay.task.RxAccountGetRechargeTypeTask;
import com.mibi.sdk.pay.task.RxStartAccountPaymentTask;
import com.mibi.sdk.widget.AlertDialog;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class PrepareActivity extends BaseMvpActivity implements cgn.O00000Oo, DialogInterface.OnCancelListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5155O000000o;
    /* access modifiers changed from: private */
    public boolean O00000Oo = false;

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        this.f5155O000000o = new SimpleProgressDialog(this);
        this.f5155O000000o.setMessage(getResources().getString(R.string.mibi_creating_order));
        this.f5155O000000o.setOnCancelListener(this);
    }

    public void onResume() {
        super.onResume();
        if (!this.O00000Oo) {
            this.f5155O000000o.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f5155O000000o.dismiss();
    }

    public void a() {
        this.f5155O000000o.setMessage(getResources().getString(R.string.mibi_querying_result));
    }

    public void a(RxStartAccountPaymentTask.Result result, RxAccountGetRechargeTypeTask.Result result2) {
        MibiLog.d("PrepareActivity", "go to account ui");
        Intent intent = new Intent("com.mibi.sdk.pay.ui.orderinfo.ACTION");
        intent.setPackage(getPackageName());
        intent.putExtra("processId", ((cgn.O000000o) getPresenter()).O000000o());
        intent.putExtra("pay_type_result", result);
        intent.putExtra("recharge_types_result", result2);
        startActivityForResult(intent, 203);
    }

    public void a(ArrayList<RechargeType> arrayList) {
        MibiLog.d("PrepareActivity", "goToNaUi");
        Intent intent = new Intent("com.mibi.sdk.pay.ui.paytypes.ACTION");
        intent.setPackage(getPackageName());
        intent.putExtra("recharge_types", arrayList);
        startActivityForResult(intent, 204);
    }

    public void a(int i, String str, Throwable th) {
        MibiLog.d("PrepareActivity", "handle error code : " + i + " ; desc : " + str);
        setResult(i, EntryResultUtils.makeResult(i, str, th instanceof QueryPaymentException ? ((QueryPaymentException) th).getArguments() : null));
        finish();
    }

    public void a(int i, Bundle bundle) {
        StringBuilder sb = new StringBuilder("handleError arguments is null ? ");
        sb.append(bundle == null);
        Log.d("PrepareActivity", sb.toString());
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
        Log.d("PrepareActivity", "success");
        setResult(-1, EntryResultUtils.makeResult(-1, "success", bundle));
        finish();
    }

    public void a(Intent intent) {
        intent.setPackage(Client.getAppInfo().getPackage());
        startActivityForResult(intent, 100);
    }

    public IPresenter onCreatePresenter() {
        return new cgo();
    }

    public void onCancel(DialogInterface dialogInterface) {
        Log.d("PrepareActivity", "user progress dialog cancel");
        onBackPressed();
    }

    public void onPasswordCheck() {
        Intent intent = new Intent(this, PaymentCheckPasswordActivity.class);
        intent.putExtra("processId", ((cgn.O000000o) getPresenter()).O000000o());
        startActivityForResult(intent, 201);
    }

    public void onSMSCodeCheck(Bundle bundle) {
        Intent intent = new Intent(this, PaymentVerifySMSCodeActivity.class);
        intent.putExtra("processId", ((cgn.O000000o) getPresenter()).O000000o());
        intent.putExtras(bundle);
        startActivityForResult(intent, 202);
    }

    public void onBindPhoneCheck(Bundle bundle) {
        final String str;
        Log.d("PrepareActivity", "onBindPhoneCheck");
        this.f5155O000000o.dismiss();
        if (bundle == null) {
            str = null;
        } else {
            str = bundle.getString("bindPhoneUrl");
        }
        String string = getResources().getString(R.string.mibi_title_bind_phone);
        AlertDialog create = new AlertDialog.Builder(this).setTitle(string).setMessage(getResources().getString(R.string.mibi_summary_bind_phone)).setClickable(true).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            /* class com.mibi.sdk.pay.prepare.PrepareActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean unused = PrepareActivity.this.O00000Oo = false;
                PrepareActivity.this.setResult(9807, EntryResultUtils.makeResult(9807, "user need bind phone"));
                dialogInterface.dismiss();
                PrepareActivity.this.finish();
            }
        }).setPositiveButton((int) R.string.mibi_button_bind_phone, new DialogInterface.OnClickListener() {
            /* class com.mibi.sdk.pay.prepare.PrepareActivity.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean unused = PrepareActivity.this.O00000Oo = false;
                PrepareActivity.this.setResult(9807, EntryResultUtils.makeResult(9807, "user need bind phone"));
                dialogInterface.dismiss();
                String accountBaseUrl = CommonConstants.getAccountBaseUrl("/upgradeUser");
                if (!TextUtils.isEmpty(str)) {
                    accountBaseUrl = str;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(accountBaseUrl));
                intent.addFlags(67108864);
                intent.addFlags(8388608);
                PrepareActivity.this.startActivity(intent);
                PrepareActivity.this.finish();
            }
        }).create();
        create.setCancelable(false);
        create.show();
        this.O00000Oo = true;
    }

    public void onAccountFrozen() {
        MibiLog.d("PrepareActivity", "account frozen");
        Toast.makeText(this, getResources().getString(R.string.mibi_error_frozen_summary), 0).show();
        setResult(9801, EntryResultUtils.makeResult(9801, "account frozen"));
        finish();
    }
}
