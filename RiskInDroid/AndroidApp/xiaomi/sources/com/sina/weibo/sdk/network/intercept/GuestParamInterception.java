package com.sina.weibo.sdk.network.intercept;

import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.base.WbUserInfo;
import com.sina.weibo.sdk.network.base.WbUserInfoHelper;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.wcfc.sobusiness.UtilitySo;

public class GuestParamInterception implements IRequestIntercept {
    public boolean needIntercept(IRequestParam iRequestParam, Bundle bundle) {
        String url = iRequestParam.getUrl();
        if (!TextUtils.isEmpty(url)) {
            return !url.startsWith("https://api.weibo.cn/2/sdk/login") && !url.startsWith("http://api.weibo.cn/2/sdk/login");
        }
        return true;
    }

    public boolean doIntercept(IRequestParam iRequestParam, Bundle bundle) throws InterceptException {
        WbUserInfo userInfo = WbUserInfoHelper.getInstance().getUserInfo(iRequestParam.getContext());
        if (userInfo == null) {
            return false;
        }
        bundle.putString("gsid", userInfo.getGsid());
        bundle.putString("uid", userInfo.getUid());
        bundle.putString("s", UtilitySo.getInstance().calculateS(iRequestParam.getContext(), userInfo.getUid()));
        return false;
    }
}
