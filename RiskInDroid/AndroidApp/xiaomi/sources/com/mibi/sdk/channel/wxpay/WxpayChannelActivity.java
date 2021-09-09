package com.mibi.sdk.channel.wxpay;

import _m_j.cfg;
import _m_j.cfj;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;

public class WxpayChannelActivity extends BaseMvpActivity implements cfg.O000000o, DialogInterface.OnCancelListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5121O000000o;

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        this.f5121O000000o = new SimpleProgressDialog(this);
        this.f5121O000000o.setMessage(getResources().getString(R.string.mibi_wxpay_starting_wxpay));
        this.f5121O000000o.setOnCancelListener(this);
    }

    public void a() {
        setResult(-1);
        finish();
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        a(false);
    }

    public void a(boolean z) {
        if (z) {
            this.f5121O000000o.show();
        } else {
            this.f5121O000000o.dismiss();
        }
    }

    public void a(int i, String str, Throwable th) {
        Log.d("WxpayChannelActivity", "errorCode:" + i + ",errorDesc:" + str);
        setResult(i, EntryResultUtils.makeResult(i, str));
        finish();
    }

    public IPresenter onCreatePresenter() {
        cfj cfj = new cfj(cfg.O000000o.class);
        cfj.f13716O000000o = this;
        return cfj;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onCancel(DialogInterface dialogInterface) {
        Log.d("WxpayChannelActivity", "user progress dialog cancel");
        onBackPressed();
    }

    public boolean handleBackPressed() {
        setResult(9809, EntryResultUtils.makeResult(9809, getBaseContext().getResources().getString(R.string.mibi_msg_wxpay_cancele)));
        return true;
    }
}
