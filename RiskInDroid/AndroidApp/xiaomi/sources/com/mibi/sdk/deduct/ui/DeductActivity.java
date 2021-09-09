package com.mibi.sdk.deduct.ui;

import _m_j.cfn;
import _m_j.cgd;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;

public class DeductActivity extends BaseMvpActivity implements cfn.O00000o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5145O000000o;
    /* access modifiers changed from: private */
    public String O00000Oo;

    public void handleCreate(Bundle bundle) {
        String str;
        super.handleCreate(bundle);
        if (bundle == null) {
            this.O00000Oo = getIntent().getExtras().getString("deductChannel");
        } else {
            this.O00000Oo = bundle.getString("deductChannel");
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
        O000000o(true, str, true);
    }

    public IPresenter onCreatePresenter() {
        return new cgd();
    }

    public void a(int i, String str, Bundle bundle) {
        MibiLog.d("DeductActivity", "return result code : " + i + " ; msg : " + str);
        O000000o(false, null, false);
        setResult(i, EntryResultUtils.makeResult(i, str));
        finish();
    }

    public void onResume() {
        super.onResume();
        ((cfn.O00000Oo) getPresenter()).O000000o();
    }

    public void a(boolean z) {
        O000000o(z, getResources().getString(R.string.mibi_progress_querying), true);
    }

    public void a(cfn.O000000o<Activity> o000000o) {
        o000000o.O000000o(this);
    }

    private void O000000o(boolean z, String str, final boolean z2) {
        if (z) {
            if (this.f5145O000000o == null) {
                this.f5145O000000o = new SimpleProgressDialog(this);
                this.f5145O000000o.setCanceledOnTouchOutside(false);
                this.f5145O000000o.setCancelable(true);
                this.f5145O000000o.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.mibi.sdk.deduct.ui.DeductActivity.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (z2) {
                            DeductActivity deductActivity = DeductActivity.this;
                            deductActivity.a(9811, DeductActivity.this.O00000Oo + " cancelled by user", null);
                            DeductActivity.this.finish();
                        }
                    }
                });
            }
            this.f5145O000000o.setMessage(str);
            this.f5145O000000o.show();
            return;
        }
        SimpleProgressDialog simpleProgressDialog = this.f5145O000000o;
        if (simpleProgressDialog != null && simpleProgressDialog.isShowing()) {
            this.f5145O000000o.dismiss();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("deductChannel", this.O00000Oo);
    }

    public void onDestroy() {
        SimpleProgressDialog simpleProgressDialog = this.f5145O000000o;
        if (simpleProgressDialog != null && simpleProgressDialog.isShowing()) {
            this.f5145O000000o.dismiss();
        }
        super.onDestroy();
    }
}
