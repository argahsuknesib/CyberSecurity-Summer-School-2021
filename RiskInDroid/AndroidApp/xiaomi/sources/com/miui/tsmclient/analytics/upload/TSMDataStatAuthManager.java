package com.miui.tsmclient.analytics.upload;

import android.content.Context;
import com.miui.tsmclient.account.AccountInfo;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.AuthRequest;
import com.miui.tsmclient.net.BaseAuthManager;
import com.miui.tsmclient.util.DeviceUtils;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;
import java.util.Locale;

public class TSMDataStatAuthManager extends BaseAuthManager {
    public BaseResponse uploadDataStatInfo(Context context, String str) {
        int i;
        String str2;
        try {
            AccountInfo accountInfo = getAccountInfo(context);
            AuthRequest.AuthRequestBuilder addParams = AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/statistics/report/uploadEvent", AuthRequest.RespContentType.json).addParams("message", str).addParams("lang", Locale.getDefault().toString()).addParams("miuiRomType", DeviceUtils.getMIUIRomType(null)).addParams("miuiSystemVersion", DeviceUtils.getRomVersion()).addParams("deviceId", DeviceUtils.getDeviceId(context, null)).addParams("deviceModel", DeviceUtils.getDeviceModel(null)).addParams("tsmDataVersion", "1");
            if (EnvironmentConfig.isSupportNfc()) {
                addParams.addParams("cplc", getCplc(new CardInfo("DUMMY")));
            }
            sendRequest(context, accountInfo, addParams.create());
            LogUtils.d("upload data stat info success");
            str2 = "";
            i = 0;
        } catch (AuthApiException e) {
            LogUtils.e("upload data stat info failed with an exception", e);
            i = e.mErrorCode;
            str2 = e.mErrorMsg;
        }
        return new BaseResponse(i, str2, new Object[0]);
    }

    private String getCplc(CardInfo cardInfo) throws AuthApiException {
        try {
            return cardInfo.getTerminal().getCPLC();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LogUtils.e("failed to get cplc", e);
            throw new AuthApiException(11);
        } catch (IOException e2) {
            LogUtils.e("failed to get cplc", e2);
            throw new AuthApiException(13);
        }
    }
}
