package com.miui.tsmclient.common.net.request;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.ErrorInfo;
import com.miui.tsmclient.common.net.RequestCallback;
import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.host.AuthHost;
import com.miui.tsmclient.common.net.host.Host;
import com.miui.tsmclient.model.ErrorCode;
import com.miui.tsmclient.util.CardEnvironmentConfig;
import com.miui.tsmclient.util.DeviceUtils;
import com.miui.tsmclient.util.EnvironmentConfig;
import java.util.Locale;

public class SecureRequest<T extends CommonResponseInfo> extends GsonRequest<T> {
    public SecureRequest(int i, String str, TypeToken<T> typeToken) {
        this(i, str, typeToken, (ResponseListener) null);
    }

    public SecureRequest(int i, String str, Class<T> cls) {
        this(i, str, TypeToken.get((Class) cls));
    }

    public SecureRequest(int i, String str, Class cls, ResponseListener responseListener) {
        this(i, str, TypeToken.get(cls), responseListener);
    }

    public SecureRequest(int i, String str, TypeToken typeToken, final ResponseListener responseListener) {
        super(i, str, typeToken, new RequestCallback<T>() {
            /* class com.miui.tsmclient.common.net.request.SecureRequest.AnonymousClass1 */

            public void onResponse(T t) {
                if (ResponseListener.this != null) {
                    if (t.isSuccess()) {
                        ResponseListener.this.onSuccess(t);
                    } else {
                        ResponseListener.this.onFailed(t.getErrorCode(), t.getErrorDesc(), t);
                    }
                }
            }

            public void onFailed(ErrorInfo errorInfo) {
                if (ResponseListener.this != null) {
                    ErrorInfo mapError = SecureRequest.mapError(errorInfo);
                    ResponseListener.this.onFailed(mapError.mErrorCode, mapError.mErrorDesc, null);
                }
            }
        });
        this.mRequestType = CardEnvironmentConfig.getDefaultSecureType();
        addParams("miuiRomType", DeviceUtils.getMIUIRomType(null));
        addParams("miuiSystemVersion", DeviceUtils.getRomVersion());
        addParams("androidVersion", DeviceUtils.getAndroidVersion());
        addParams("deviceModel", DeviceUtils.getDeviceModel(null));
        addParams("lang", Locale.getDefault().toString());
        Context context = EnvironmentConfig.getContext();
        if (context != null) {
            addParams("tsmclientVersionCode", String.valueOf(DeviceUtils.getAppVersionCode(context, "com.miui.tsmclient")));
            addParams("tsmclientVersionName", String.valueOf(DeviceUtils.getAppVersionName(context, "com.miui.tsmclient")));
            addParams("appVersionName", String.valueOf(DeviceUtils.getAppVersionName(context)));
            addParams("appVersionCode", String.valueOf(DeviceUtils.getAppVersionCode(context)));
            addParams("appPackageName", context.getPackageName());
        }
    }

    public String getUrl() {
        String stagingHost = EnvironmentConfig.isStaging() ? this.mHost.getStagingHost() : this.mHost.getOnlineHost();
        return String.format(stagingHost + this.mPath, this.mHost.getAuthType());
    }

    public Host onCreateHost() {
        return new AuthHost();
    }

    public boolean isSuccess() {
        return super.isSuccess() && getResult() != null && ((CommonResponseInfo) getResult()).isSuccess();
    }

    public static ErrorInfo mapError(ErrorInfo errorInfo) {
        if (errorInfo == null) {
            errorInfo = ErrorInfo.DEFAULT_ERROR_INFO;
        }
        int i = errorInfo.mErrorCode;
        int i2 = errorInfo.mErrorCode;
        if (i2 == -1) {
            i = 2;
        } else if (i2 == 14) {
            i = 14;
        }
        return new ErrorInfo(i, ErrorCode.findText(EnvironmentConfig.getContext(), i));
    }
}
