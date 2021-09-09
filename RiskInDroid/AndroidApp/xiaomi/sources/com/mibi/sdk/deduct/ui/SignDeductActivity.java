package com.mibi.sdk.deduct.ui;

import _m_j.cfo;
import _m_j.cge;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.LocalBroadcastManager;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;

public class SignDeductActivity extends BaseMvpActivity implements cfo.O00000o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5148O000000o;
    /* access modifiers changed from: private */
    public String O00000Oo;
    private BroadcastReceiver O00000o0 = new BroadcastReceiver() {
        /* class com.mibi.sdk.deduct.ui.SignDeductActivity.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            MibiLog.d("SignDeductActivity", "onReceive");
            String stringExtra = intent.getStringExtra("mibi_alipay_status");
            if (TextUtils.equals("9000", stringExtra)) {
                ((cfo.O00000Oo) SignDeductActivity.this.getPresenter()).O000000o();
            } else if (TextUtils.equals("6001", stringExtra)) {
                SignDeductActivity.this.a(9822, context.getResources().getString(R.string.mibi_sign_deduct_alipay_cancel), null);
            } else {
                SignDeductActivity.this.a(9823, "alipay sign deduct exception", null);
            }
        }
    };

    public void handleCreate(Bundle bundle) {
        String str;
        super.handleCreate(bundle);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.O00000o0, new IntentFilter("com.mibi.sdk.alipay.result.action"));
        if (bundle == null) {
            this.O00000Oo = getIntent().getExtras().getString("deductSignAndPayChannel");
        } else {
            this.O00000Oo = bundle.getString("deductSignAndPayChannel");
        }
        if (e.a.MIPAY.b().equals(this.O00000Oo)) {
            str = getString(R.string.mibi_progress_deduct_creating, new Object[]{getString(R.string.mibi_paytool_mipay)});
        } else if (e.a.ALIPAY.b().equals(this.O00000Oo)) {
            str = getString(R.string.mibi_progress_deduct_creating, new Object[]{getString(R.string.mibi_paytool_alipay)});
        } else if (e.a.WXPAY.b().equals(this.O00000Oo)) {
            str = getString(R.string.mibi_progress_deduct_creating, new Object[]{getString(R.string.mibi_paytool_weixin)});
        } else {
            throw new IllegalStateException("channelName is " + this.O00000Oo);
        }
        O000000o(true, str);
    }

    public IPresenter onCreatePresenter() {
        cge cge = new cge();
        cge.f13760O000000o = this;
        return cge;
    }

    public void a(int i, String str, Bundle bundle) {
        StringBuffer stringBuffer = new StringBuffer("returnResult errorCode : ");
        stringBuffer.append(i);
        stringBuffer.append(" ; errorDesc : ");
        stringBuffer.append(str);
        MibiLog.d("SignDeductActivity", stringBuffer.toString());
        O000000o(false, null);
        setResult(i, EntryResultUtils.makeResult(i, str, bundle));
        finish();
    }

    public void onResume() {
        super.onResume();
        ((cge) getPresenter()).O00000Oo();
    }

    public void a(boolean z) {
        O000000o(z, getResources().getString(R.string.mibi_progress_querying));
    }

    public void a(cfo.O000000o<Activity> o000000o) {
        o000000o.O000000o(this);
    }

    private void O000000o(boolean z, String str) {
        if (z) {
            if (this.f5148O000000o == null) {
                this.f5148O000000o = new SimpleProgressDialog(this);
                this.f5148O000000o.setCanceledOnTouchOutside(false);
                this.f5148O000000o.setCancelable(true);
                this.f5148O000000o.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.mibi.sdk.deduct.ui.SignDeductActivity.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        SignDeductActivity signDeductActivity = SignDeductActivity.this;
                        signDeductActivity.a(9822, SignDeductActivity.this.O00000Oo + " cancelled by user", null);
                        SignDeductActivity.this.finish();
                    }
                });
            }
            this.f5148O000000o.setMessage(str);
            this.f5148O000000o.show();
            return;
        }
        SimpleProgressDialog simpleProgressDialog = this.f5148O000000o;
        if (simpleProgressDialog == null || !simpleProgressDialog.isShowing()) {
            MibiLog.d("SignDeductActivity", "mProgressDialog is null or not showing");
        } else {
            this.f5148O000000o.dismiss();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("deductSignAndPayChannel", this.O00000Oo);
    }

    public void onDestroy() {
        SimpleProgressDialog simpleProgressDialog = this.f5148O000000o;
        if (simpleProgressDialog != null && simpleProgressDialog.isShowing()) {
            this.f5148O000000o.dismiss();
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.O00000o0);
        super.onDestroy();
    }
}
