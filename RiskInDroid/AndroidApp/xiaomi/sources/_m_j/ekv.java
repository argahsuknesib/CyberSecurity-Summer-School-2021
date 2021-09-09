package _m_j;

import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.request.log.HttpMethod;
import com.xiaomi.accountsdk.request.log.ProtocolLogHelper;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ekv {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f15586O000000o = (URLs.ACCOUNT_DOMAIN + "/pass/preference");

    public static eey O000000o() throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException {
        String buildUrlWithLocaleQueryParam = XMPassportUtil.buildUrlWithLocaleQueryParam(f15586O000000o);
        ProtocolLogHelper.newRequestLog(buildUrlWithLocaleQueryParam, HttpMethod.GET).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(buildUrlWithLocaleQueryParam, null, null, true);
        ProtocolLogHelper.newResponseLog(buildUrlWithLocaleQueryParam).stringResponseOrNull(asString).log();
        if (asString != null) {
            String removeSafePrefixAndGetRealBody = XMPassport.removeSafePrefixAndGetRealBody(asString);
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody);
                eey eey = new eey();
                eey.O00000Oo = jSONObject.optString("diagnosisDomain", null);
                eey.f15196O000000o = jSONObject.optString("dataCenterZone", null);
                return eey;
            } catch (JSONException e) {
                AccountLog.e("PassportOnlinePreference", "realBody", e);
                throw new InvalidResponseException(removeSafePrefixAndGetRealBody);
            }
        } else {
            throw new InvalidResponseException("result content is null");
        }
    }
}
