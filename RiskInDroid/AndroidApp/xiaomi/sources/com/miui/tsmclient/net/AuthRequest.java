package com.miui.tsmclient.net;

import android.content.Context;
import com.miui.tsmclient.account.AccountInfo;
import com.miui.tsmclient.common.net.host.AuthHost;
import com.miui.tsmclient.common.net.host.Host;
import com.miui.tsmclient.util.DeviceUtils;
import com.miui.tsmclient.util.EnvironmentConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AuthRequest {
    public static final boolean STAGING = EnvironmentConfig.isStaging();
    public Map<String, String> mCookies;
    public Host mHost;
    public Map<String, String> mParams;
    public RespContentType mRespContentType;
    public String mUrl;

    public enum RespContentType {
        json,
        protobuf
    }

    private AuthRequest() {
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public Map<String, String> getCookies() {
        return this.mCookies;
    }

    public String getRequestFullUrl() {
        if (this.mUrl == null) {
            this.mUrl = "";
        }
        return String.format(getServer() + this.mUrl, this.mHost.getAuthType());
    }

    public RespContentType getRespContentType() {
        return this.mRespContentType;
    }

    private String getServer() {
        if (STAGING) {
            return this.mHost.getStagingHost();
        }
        return this.mHost.getOnlineHost();
    }

    public void addParams(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public static class AuthRequestBuilder {
        private Map<String, String> mCookies = new HashMap();
        private Host mHost;
        private Map<String, String> mParams = new HashMap();
        private RespContentType mRespContentType;
        private String mUrl;

        private AuthRequestBuilder() {
        }

        public static AuthRequestBuilder newBuilder(AccountInfo accountInfo, String str, RespContentType respContentType) {
            return newBuilder(accountInfo, new AuthHost(), str, respContentType);
        }

        public static AuthRequestBuilder newBuilder(AccountInfo accountInfo, Host host, String str, RespContentType respContentType) {
            AuthRequestBuilder authRequestBuilder = new AuthRequestBuilder();
            if (accountInfo != null) {
                authRequestBuilder.mCookies.put("userId", accountInfo.getUserId());
                authRequestBuilder.mCookies.put("serviceToken", accountInfo.getServiceToken());
                authRequestBuilder.mParams.put("userId", accountInfo.getUserId());
                authRequestBuilder.mParams.put("miuiRomType", DeviceUtils.getMIUIRomType(null));
                authRequestBuilder.mParams.put("miuiSystemVersion", DeviceUtils.getRomVersion());
                authRequestBuilder.mParams.put("androidVersion", DeviceUtils.getAndroidVersion());
                Context context = EnvironmentConfig.getContext();
                if (context != null) {
                    authRequestBuilder.mParams.put("tsmclientVersionCode", String.valueOf(DeviceUtils.getAppVersionCode(context, "com.miui.tsmclient")));
                    authRequestBuilder.mParams.put("tsmclientVersionName", String.valueOf(DeviceUtils.getAppVersionName(context, "com.miui.tsmclient")));
                    authRequestBuilder.mParams.put("appVersionName", String.valueOf(DeviceUtils.getAppVersionName(context)));
                    authRequestBuilder.mParams.put("appVersionCode", String.valueOf(DeviceUtils.getAppVersionCode(context)));
                    authRequestBuilder.mParams.put("appPackageName", context.getPackageName());
                }
            }
            authRequestBuilder.mHost = host;
            authRequestBuilder.mUrl = str;
            authRequestBuilder.mRespContentType = respContentType;
            authRequestBuilder.mParams.put("lang", Locale.getDefault().toString());
            return authRequestBuilder;
        }

        public AuthRequestBuilder addParams(String str, String str2) {
            this.mParams.put(str, str2);
            return this;
        }

        public AuthRequest create() {
            AuthRequest authRequest = new AuthRequest();
            authRequest.mParams = this.mParams;
            authRequest.mCookies = this.mCookies;
            authRequest.mHost = this.mHost;
            authRequest.mUrl = this.mUrl;
            authRequest.mRespContentType = this.mRespContentType;
            return authRequest;
        }
    }
}
