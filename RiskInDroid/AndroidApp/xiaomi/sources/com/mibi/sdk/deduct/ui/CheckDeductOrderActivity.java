package com.mibi.sdk.deduct.ui;

import _m_j.cfl;
import _m_j.cgb;
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

public class CheckDeductOrderActivity extends BaseMvpActivity implements cfl.O00000Oo, DialogInterface.OnCancelListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5143O000000o;

    public IPresenter onCreatePresenter() {
        return new cgb();
    }

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        this.f5143O000000o = new SimpleProgressDialog(this);
        this.f5143O000000o.setMessage(getResources().getString(R.string.mibi_progress_downloading));
        this.f5143O000000o.setOnCancelListener(this);
    }

    public void a(int i, String str) {
        MibiLog.d("CheckDeductOrderAct", "return result code : " + i + " ; msg : " + str);
        Intent intent = new Intent();
        intent.putExtra("message", str);
        setResult(i, intent);
        a(false);
        finish();
    }

    public void a(Bundle bundle) {
        Log.d("CheckDeductOrderAct", "goDeduct");
        Intent intent = new Intent(this, DeductActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 120);
        a(false);
    }

    public void a(boolean z) {
        if (z) {
            this.f5143O000000o.show();
            return;
        }
        SimpleProgressDialog simpleProgressDialog = this.f5143O000000o;
        if (simpleProgressDialog != null && simpleProgressDialog.isShowing()) {
            this.f5143O000000o.dismiss();
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        MibiLog.d("CheckDeductOrderAct", "dialog cancel");
        a(9815, getBaseContext().getResources().getString(R.string.mibi_msg_check_deduct_order_cancel));
        finish();
    }

    public void a() {
        MibiLog.d("CheckDeductOrderAct", "account frozen");
        Toast.makeText(this, getResources().getString(R.string.mibi_error_frozen_summary), 0).show();
        setResult(9801, EntryResultUtils.makeResult(9801, "account frozen"));
        finish();
    }
}
