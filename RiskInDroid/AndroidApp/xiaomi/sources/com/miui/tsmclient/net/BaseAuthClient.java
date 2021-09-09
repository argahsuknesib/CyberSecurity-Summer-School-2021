package com.miui.tsmclient.net;

import android.text.TextUtils;
import com.miui.tsmclient.net.AuthRequest;
import com.miui.tsmclient.util.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseAuthClient implements IAuthClient {
    /* access modifiers changed from: protected */
    public Object handleResult(String str, AuthRequest.RespContentType respContentType) throws AuthApiException {
        if (TextUtils.isEmpty(str)) {
            throw new AuthApiException(16);
        } else if (respContentType != AuthRequest.RespContentType.json) {
            return str;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errCode");
                if (optInt == 200) {
                    return jSONObject.opt("data");
                }
                throw new AuthApiException(optInt, jSONObject.optString("errDesc"));
            } catch (JSONException e) {
                LogUtils.e("failed to parse tsm api response", e);
                throw new AuthApiException(16);
            }
        }
    }
}
