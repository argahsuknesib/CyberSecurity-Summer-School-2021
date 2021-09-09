package com.miui.tsmclient.net.request;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.FeeInfo;
import com.miui.tsmclient.entity.b;
import com.miui.tsmclient.util.DeviceUtils;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;

public class e extends SecureRequest<b> {

    /* renamed from: a  reason: collision with root package name */
    private CardInfo f3890a;

    public e(Context context, CardInfo cardInfo, FeeInfo feeInfo, Bundle bundle, ResponseListener<b> responseListener) {
        super(0, "api/%s/coupon/queryAvailableCoupons", b.class, responseListener);
        this.f3890a = cardInfo;
        if (feeInfo != null) {
            addParams("feeId", String.valueOf(feeInfo.mId));
        }
        addParams("deviceModel", DeviceUtils.getDeviceModel(this.f3890a));
        if (bundle.containsKey("extraCustomFee")) {
            addParams("extraCustomFee", bundle.getString("extraCustomFee"));
            LogUtils.d("QueryCouponsRequest extraCustomFee:" + bundle.getString("extraCustomFee"));
        }
    }

    public void addExtraParams() throws IOException {
        try {
            addParams("cplc", this.f3890a.getTerminal().getCPLC());
        } catch (IOException | InterruptedException e) {
            throw new IOException("QueryCouponsRequest getExtraParams failed", e);
        }
    }
}
