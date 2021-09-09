package com.mibi.sdk.qrSignDeduct.signDeduct;

import _m_j.cgt;
import _m_j.cgu;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.mibi.sdk.common.exception.QueryPaymentException;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;

public class QrSignDeductActivity extends BaseMvpActivity implements cgt.O000000o, DialogInterface.OnCancelListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5166O000000o;

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        this.f5166O000000o = new SimpleProgressDialog(this);
        this.f5166O000000o.setMessage(getResources().getString(R.string.mibi_creating_order));
        this.f5166O000000o.setOnCancelListener(this);
    }

    public void onResume() {
        super.onResume();
        this.f5166O000000o.show();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f5166O000000o.dismiss();
    }

    public void onCancel(DialogInterface dialogInterface) {
        MibiLog.d("QrSignDeductActivity", "user progress dialog cancel");
        onBackPressed();
    }

    public IPresenter onCreatePresenter() {
        return new cgu();
    }

    public void a(int i, String str, Throwable th) {
        MibiLog.d("QrSignDeductActivity", "handleError errorCode : " + i + " ; errorDesc : " + str);
        setResult(i, EntryResultUtils.makeResult(i, str, th instanceof QueryPaymentException ? ((QueryPaymentException) th).getArguments() : null));
        finish();
    }

    public void a(int i, Bundle bundle) {
        StringBuilder sb = new StringBuilder("handleError arguments is null ? ");
        sb.append(bundle == null);
        MibiLog.d("QrSignDeductActivity", sb.toString());
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
        this.f5166O000000o.dismiss();
        setResult(-1, EntryResultUtils.makeResult(-1, "success", bundle));
        finish();
    }
}
