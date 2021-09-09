package com.mibi.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseEntryActivity;
import com.mibi.sdk.component.OrderBean;
import com.mibi.sdk.component.privacy.PrivacyManager;
import com.mibi.sdk.qrSignDeduct.signDeduct.QrSignDeductActivity;
import com.mibi.sdk.qrdeduct.deduct.QrDeductActivity;
import com.mibi.sdk.qrpay.pay.QrPayActivity;
import com.xiaomi.smarthome.R;

public class QrEntryActivity extends BaseEntryActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private OrderBean f5104O000000o;

    public void doPreCreate(Bundle bundle) {
        super.doPreCreate(bundle);
        this.f5104O000000o = (OrderBean) getIntent().getParcelableExtra("orderBean");
    }

    public boolean isNoAccount() {
        Log.d("QrEntryAct", "isNoAccount:" + this.f5104O000000o.mIsNoAccount);
        return this.f5104O000000o.mIsNoAccount;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    public void doEntrySuccess() {
        boolean z;
        Intent intent;
        Log.d("QrEntryAct", "entrySuccess");
        OrderBean orderBean = this.f5104O000000o;
        if (orderBean == null) {
            String string = getBaseContext().getResources().getString(R.string.mibi_msg_order_is_null);
            Log.e("QrEntryAct", string);
            returnError(0, string);
            finish();
            return;
        }
        if (TextUtils.isEmpty(orderBean.mChannel)) {
            Log.e("QrEntryAct", "channel is empty");
        } else if (TextUtils.isEmpty(this.f5104O000000o.mOrder)) {
            Log.e("QrEntryAct", "order is empty");
        } else {
            z = true;
            if (z) {
                String string2 = getBaseContext().getResources().getString(R.string.mibi_msg_order_illegal);
                Log.e("QrEntryAct", string2);
                returnError(0, string2);
                finish();
                return;
            }
            PrivacyManager.makePrivacyParam(getSession(), "105", "PAYMENTPAGE");
            if (this.f5104O000000o.mOrderType == 1) {
                intent = new Intent(this, QrPayActivity.class);
            } else if (this.f5104O000000o.mOrderType == 2) {
                intent = new Intent(this, QrDeductActivity.class);
            } else if (this.f5104O000000o.mOrderType == 3) {
                intent = new Intent(this, QrSignDeductActivity.class);
            } else {
                String str = "Illegal order type : " + this.f5104O000000o.mOrderType;
                MibiLog.d("QrEntryAct", str);
                doEntryFailed(9832, str);
                return;
            }
            intent.putExtra("orderBean", this.f5104O000000o);
            startActivityForResult(intent, 1);
            return;
        }
        z = false;
        if (z) {
        }
    }

    public void doEntryFailed(int i, String str) {
        Log.d("QrEntryAct", "doEntryFailed");
        returnError(i, str);
        finish();
    }

    public void doActivityResult(int i, int i2, Intent intent) {
        Log.d("QrEntryAct", "doActivityResult");
        super.doActivityResult(i, i2, intent);
        returnResult(i2, intent);
        finish();
    }
}
