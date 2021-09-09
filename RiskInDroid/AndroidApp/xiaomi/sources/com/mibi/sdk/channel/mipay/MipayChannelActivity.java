package com.mibi.sdk.channel.mipay;

import _m_j.cfd;
import _m_j.cfe;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.widget.SimpleProgressDialog;
import com.xiaomi.smarthome.R;

public class MipayChannelActivity extends BaseMvpActivity implements cfd.O000000o, DialogInterface.OnCancelListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleProgressDialog f5117O000000o;

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        this.f5117O000000o = new SimpleProgressDialog(this);
        this.f5117O000000o.setMessage(getResources().getString(R.string.mibi_mipay_starting_mipay));
        this.f5117O000000o.setOnCancelListener(this);
    }

    public void onResume() {
        super.onResume();
        this.f5117O000000o.show();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f5117O000000o.dismiss();
    }

    public void a(Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public void a(int i, String str, Throwable th) {
        Log.d("MipayChannelActivity", "errorCode:" + i + ",errorDesc:" + str);
        setResult(i, EntryResultUtils.makeResult(i, str));
        finish();
    }

    public IPresenter onCreatePresenter() {
        cfe cfe = new cfe(cfd.O000000o.class);
        cfe.f13712O000000o = this;
        return cfe;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onCancel(DialogInterface dialogInterface) {
        Log.d("MipayChannelActivity", "user progress dialog cancel");
        onBackPressed();
    }
}
