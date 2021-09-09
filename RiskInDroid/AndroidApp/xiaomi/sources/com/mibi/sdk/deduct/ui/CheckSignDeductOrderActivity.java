package com.mibi.sdk.deduct.ui;

import _m_j.cfm;
import _m_j.cgc;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;

public class CheckSignDeductOrderActivity extends BaseMvpActivity implements cfm.O000000o, DialogInterface.OnCancelListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5144O000000o;

    public IPresenter onCreatePresenter() {
        return new cgc();
    }

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        this.f5144O000000o = new SimpleProgressDialog(this);
        this.f5144O000000o.setMessage(getResources().getString(R.string.mibi_progress_downloading));
        this.f5144O000000o.setOnCancelListener(this);
    }

    public void a(int i, String str, Bundle bundle) {
        MibiLog.d("CheckDeductOrderAct", "returnResult code : " + i + " ; msg : " + str);
        Intent intent = new Intent();
        intent.putExtra("message", str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        setResult(i, intent);
        a(false);
        finish();
    }

    public void a(Bundle bundle) {
        Log.d("CheckDeductOrderAct", "goDeduct");
        Intent intent = new Intent(this, SignDeductActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 120);
        a(false);
    }

    public void a(boolean z) {
        if (z) {
            this.f5144O000000o.show();
            return;
        }
        SimpleProgressDialog simpleProgressDialog = this.f5144O000000o;
        if (simpleProgressDialog != null && simpleProgressDialog.isShowing()) {
            this.f5144O000000o.dismiss();
        }
    }

    public void a() {
        MibiLog.d("CheckDeductOrderAct", "account frozen");
        Toast.makeText(this, getResources().getString(R.string.mibi_error_frozen_summary), 0).show();
        setResult(9801, EntryResultUtils.makeResult(9801, "account frozen"));
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        a(9821, getBaseContext().getResources().getString(R.string.mibi_msg_check_sign_deduct_order_cancel), null);
        finish();
    }
}
