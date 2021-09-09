package com.mibi.sdk.channel.wxpay;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.WXUtils;
import com.mibi.sdk.common.utils.MibiLog;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    public void onReq(BaseReq baseReq) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        MibiLog.d("WXPayEntryActivity", "onCreate");
        super.onCreate(bundle);
        if (WxResultHelper.getInterceptor() == null) {
            MibiLog.d("WXPayEntryActivity", "interceptor is null");
            str = WXUtils.getString(this, "appid");
        } else {
            MibiLog.d("WXPayEntryActivity", "interceptor not null");
            str = WxResultHelper.getWxAppId();
        }
        if (TextUtils.isEmpty(str)) {
            MibiLog.d("WXPayEntryActivity", "appId is null");
            finish();
            return;
        }
        WXAPIFactory.createWXAPI(getApplicationContext(), str, false).handleIntent(getIntent(), this);
    }

    public void onResp(BaseResp baseResp) {
        MibiLog.d("WXPayEntryActivity", "onResp resp.errCode : " + baseResp.errCode + " ; type : " + baseResp.getType());
        if (WxResultHelper.intercept(baseResp)) {
            MibiLog.d("WXPayEntryActivity", "wxpay result intercepted");
            finish();
            return;
        }
        if (baseResp.getType() == 5) {
            WXUtils.putString(getApplicationContext(), ((PayResp) baseResp).prepayId, String.valueOf(baseResp.errCode));
        }
        finish();
    }
}
