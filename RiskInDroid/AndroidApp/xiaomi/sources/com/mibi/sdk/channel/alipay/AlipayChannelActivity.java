package com.mibi.sdk.channel.alipay;

import _m_j.cex;
import _m_j.cfa;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;

public class AlipayChannelActivity extends BaseMvpActivity implements cfa.O000000o, DialogInterface.OnCancelListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5113O000000o;

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        this.f5113O000000o = new SimpleProgressDialog(this);
        this.f5113O000000o.setMessage(getResources().getString(R.string.mibi_alipay_starting_mipay));
        this.f5113O000000o.setOnCancelListener(this);
    }

    public void onResume() {
        super.onResume();
        this.f5113O000000o.show();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f5113O000000o.dismiss();
    }

    public void a() {
        setResult(-1);
        finish();
    }

    public void a(int i, String str, Throwable th) {
        Log.d("AlipayChannelActivity", "errorCode:" + i + ",errorDesc:" + str);
        setResult(i, EntryResultUtils.makeResult(i, str));
        finish();
    }

    public IPresenter onCreatePresenter() {
        cex cex = new cex(cfa.O000000o.class);
        cex.f13700O000000o = this;
        return cex;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onCancel(DialogInterface dialogInterface) {
        Log.d("AlipayChannelActivity", "user progress dialog cancel");
        onBackPressed();
    }

    public boolean handleBackPressed() {
        setResult(9808, EntryResultUtils.makeResult(9808, getBaseContext().getResources().getString(R.string.mibi_msg_user_cancel_alipay)));
        return true;
    }
}
