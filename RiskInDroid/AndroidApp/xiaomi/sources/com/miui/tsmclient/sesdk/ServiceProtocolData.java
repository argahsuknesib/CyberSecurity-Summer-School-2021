package com.miui.tsmclient.sesdk;

import android.text.TextUtils;
import com.miui.tsmclient.entity.VersionControlInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.net.TSMAuthManager;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.b;

public class ServiceProtocolData {
    private String mCardType;
    private VersionControlInfo mVersionInfo;

    public ServiceProtocolData(VersionControlInfo versionControlInfo, String str) {
        this.mVersionInfo = versionControlInfo;
        this.mCardType = str;
    }

    public void confirm() {
        b.a(EnvironmentConfig.getContext(), this.mVersionInfo.mServiceName, this.mVersionInfo.mVersionControlId);
    }

    public int getCaptchaVerifyType() {
        return this.mVersionInfo.mCaptchaVerifyType;
    }

    public String getUrl() {
        return this.mVersionInfo.mContent;
    }

    public boolean isNeedConfirm() {
        return this.mVersionInfo.mNeedConfirm && b.a(EnvironmentConfig.getContext(), this.mVersionInfo.mServiceName) < this.mVersionInfo.mVersionControlId && !TextUtils.isEmpty(this.mVersionInfo.mContent);
    }

    public boolean isNeedPhone() {
        return this.mVersionInfo.mNeedPhone;
    }

    public BaseResponse requestCaptcha(String str) {
        return requestCaptcha(str, 1);
    }

    public BaseResponse requestCaptcha(String str, int i) {
        if (i == 0) {
            i = 1;
        }
        return new TSMAuthManager().sendVerificationCode(EnvironmentConfig.getContext(), str, this.mCardType, Integer.toString(i));
    }
}
