package com.mibi.sdk.deduct.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseEntryActivity;
import com.mibi.sdk.component.OrderBean;

public class DeductEntryActivity extends BaseEntryActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private OrderBean f5147O000000o;

    public void doPreCreate(Bundle bundle) {
        super.doPreCreate(bundle);
        this.f5147O000000o = (OrderBean) getIntent().getParcelableExtra("orderBean");
    }

    public void doEntryFailed(int i, String str) {
        MibiLog.d("DeductEntryActivity", "entry failed code : " + i + " ; msg : " + str);
        returnError(i, str);
        finish();
    }

    public void doActivityResult(int i, int i2, Intent intent) {
        super.doActivityResult(i, i2, intent);
        MibiLog.d("DeductEntryActivity", "activity result req : " + i + " ; res : " + i2);
        if (i == 1) {
            if (i2 == 9810) {
                i2 = -1;
            }
            setResult(i2, intent);
        }
        finish();
    }

    public void doEntrySuccess() {
        if (!TextUtils.isEmpty(this.f5147O000000o.mQueryIntervalConfig)) {
            getSession().getMemoryStorage().put("mibi_extra_params", this.f5147O000000o.mQueryIntervalConfig);
        }
        String str = this.f5147O000000o.mOrder;
        String str2 = this.f5147O000000o.mChannel;
        if (TextUtils.isEmpty(str)) {
            MibiLog.d("DeductEntryActivity", "order is null");
            setResult(17);
            finish();
            return;
        }
        Intent intent = new Intent(this, CheckDeductOrderActivity.class);
        intent.putExtra("deductSignOrder", str);
        intent.putExtra("deductChannel", str2);
        startActivityForResult(intent, 1);
    }
}
