package _m_j;

import android.text.TextUtils;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.account.exception.InvalidBindAddressException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.ReachLimitException;
import com.xiaomi.accountsdk.account.exception.UsedEmailAddressException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.accountsdk.utils.UserSpaceIdUtil;
import java.io.IOException;

final class ejw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15546O000000o = (URLs.URL_ACCOUNT_SAFE_API_BASE + "/user/sendEmailActivateMessage");

    static void O000000o(PassportInfo passportInfo, String str, String str2, String str3, String str4, String str5) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidBindAddressException, NeedCaptchaException, UsedEmailAddressException, ReachLimitException {
        if (passportInfo != null) {
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("address", str).easyPut("sid", passportInfo.getServiceId()).easyPut("deviceId", str3).easyPutOpt("userSpaceId", UserSpaceIdUtil.getNullableUserSpaceIdCookie()).easyPut("authST", str2).easyPut("icode", str4);
            if (passportInfo != null) {
                EasyMap easyPut2 = new EasyMap().easyPut("serviceToken", passportInfo.getServiceToken());
                if (TextUtils.isEmpty(passportInfo.getEncryptedUserId())) {
                    easyPut2.easyPut("userId", passportInfo.getUserId());
                } else {
                    easyPut2.easyPut("cUserId", passportInfo.getEncryptedUserId());
                }
                easyPut2.easyPut("ick", str5);
                SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(f15546O000000o, easyPut, easyPut2, true, passportInfo.getSecurity());
                if (postAsMap != null) {
                    Integer num = (Integer) postAsMap.getFromBody("code");
                    String str6 = (String) postAsMap.getFromBody("description");
                    String str7 = "code: " + num + " ;description: " + str6;
                    ServerError serverError = new ServerError(postAsMap);
                    switch (num.intValue()) {
                        case 0:
                            break;
                        case 20031:
                        case 87001:
                            throw new NeedCaptchaException(num.intValue(), str6, (String) postAsMap.getFromBody("info"));
                        case 70006:
                            throw new InvalidBindAddressException(str7);
                        case 70013:
                        case 70021:
                            throw new UsedEmailAddressException(str7);
                        case 70022:
                            throw new ReachLimitException(str7);
                        default:
                            throw new InvalidResponseException(serverError);
                    }
                    return;
                }
                throw new IOException("failed to checkAvailabilityOfBindingEmail");
            }
            throw new IllegalArgumentException("passportInfo is null");
        }
        throw new IllegalArgumentException("passportInfo is null");
    }
}
