package com.mibi.sdk.pay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseEntryActivity;
import com.mibi.sdk.component.OrderBean;
import com.mibi.sdk.component.privacy.PrivacyManager;
import com.mibi.sdk.pay.prepare.PrepareActivity;
import com.xiaomi.smarthome.R;

public class ChannelPayEntryActivity extends BaseEntryActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private OrderBean f5152O000000o;

    public void doPreCreate(Bundle bundle) {
        super.doPreCreate(bundle);
        this.f5152O000000o = (OrderBean) getIntent().getParcelableExtra("orderBean");
    }

    public boolean isNoAccount() {
        MibiLog.d("ChannelPayEntryActivity", "isNoAccount:" + this.f5152O000000o.mIsNoAccount);
        return this.f5152O000000o.mIsNoAccount;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067  */
    public void doEntrySuccess() {
        boolean z;
        MibiLog.d("ChannelPayEntryActivity", "entrySuccess");
        OrderBean orderBean = this.f5152O000000o;
        if (orderBean == null) {
            String string = getBaseContext().getResources().getString(R.string.mibi_msg_order_is_null);
            MibiLog.e("ChannelPayEntryActivity", string);
            returnError(0, string);
            finish();
            return;
        }
        if (TextUtils.isEmpty(orderBean.mOrder)) {
            MibiLog.e("ChannelPayEntryActivity", "order is empty");
        } else if (this.f5152O000000o.mUseUi || !TextUtils.isEmpty(this.f5152O000000o.mChannel)) {
            z = true;
            if (z) {
                String string2 = getBaseContext().getResources().getString(R.string.mibi_msg_order_illegal);
                MibiLog.e("ChannelPayEntryActivity", string2);
                returnError(0, string2);
                finish();
                return;
            }
            if (!TextUtils.isEmpty(this.f5152O000000o.mQueryIntervalConfig)) {
                getSession().getMemoryStorage().put("mibi_extra_params", this.f5152O000000o.mQueryIntervalConfig);
            }
            PrivacyManager.makePrivacyParam(getSession(), "105", "PAYMENTPAGE");
            Intent intent = new Intent(this, PrepareActivity.class);
            intent.putExtra("orderBean", this.f5152O000000o);
            startActivityForResult(intent, 1);
            return;
        } else {
            MibiLog.e("ChannelPayEntryActivity", "channel is empty");
        }
        z = false;
        if (z) {
        }
    }

    public void doEntryFailed(int i, String str) {
        MibiLog.d("ChannelPayEntryActivity", "doEntryFailed");
        returnError(i, str);
        finish();
    }

    public void doActivityResult(int i, int i2, Intent intent) {
        MibiLog.d("ChannelPayEntryActivity", "doActivityResult req : " + i + " ; res : " + i2);
        super.doActivityResult(i, i2, intent);
        returnResult(i2, intent);
        finish();
    }
}
