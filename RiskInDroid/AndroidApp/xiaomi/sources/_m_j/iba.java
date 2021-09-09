package _m_j;

import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class iba {
    public static iau O000000o(String str) {
        try {
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str, new EasyMap().easyPut("type", "2"), null, null, true);
            if (asString == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(asString.getBody());
            int optInt = jSONObject.optInt("maxDuration");
            int optInt2 = jSONObject.optInt("frequency");
            iau iau = new iau();
            iau.f1139O000000o = optInt;
            iau.O00000Oo = optInt2;
            return iau;
        } catch (JSONException e) {
            AccountLog.w("VerifyRequest", "fail to parse JSONObject", e);
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (AccessDeniedException e3) {
            e3.printStackTrace();
            return null;
        } catch (AuthenticationFailureException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
