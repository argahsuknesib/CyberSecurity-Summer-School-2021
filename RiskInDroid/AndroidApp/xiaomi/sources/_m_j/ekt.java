package _m_j;

import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import com.xiaomi.passport.data.LoginPreference;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ekt {
    public static LoginPreference O000000o(String str, String str2) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, InvalidPhoneNumException {
        SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(XMPassportUtil.buildUrlWithLocaleQueryParam(ekv.f15586O000000o), new EasyMap().easyPut("phone", str).easyPutOpt("region", str2), null, true);
        if (postAsString != null) {
            String removeSafePrefixAndGetRealBody = XMPassport.removeSafePrefixAndGetRealBody(postAsString);
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody);
                int i = jSONObject.getInt("code");
                String string = jSONObject.getString("description");
                ServerError serverError = new ServerError(jSONObject);
                if (i == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    return new LoginPreference(jSONObject2.optString("idcZone"), jSONObject2.optString("userRegion"), LoginPreference.PhoneLoginType.valueOf(jSONObject2.getString("type")));
                } else if (i != 70008) {
                    throw new InvalidResponseException(i, string, serverError);
                } else {
                    throw new InvalidPhoneNumException(string);
                }
            } catch (JSONException e) {
                AccountLog.e("PhoneLoginPreferenceConfig", "realBody", e);
                throw new InvalidResponseException(removeSafePrefixAndGetRealBody);
            }
        } else {
            throw new InvalidResponseException("result content is null");
        }
    }
}
