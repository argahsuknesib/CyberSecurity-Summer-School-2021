package _m_j;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.accountsdk.account.stat.AccountStatInterface;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.request.log.HttpMethod;
import com.xiaomi.accountsdk.request.log.ProtocolLogHelper;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.phonenum.PhoneNumKeeper;
import com.xiaomi.phonenum.PhoneNumKeeperFactory;
import com.xiaomi.phonenum.innetdate.InNetDateResult;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class eky {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15590O000000o = (URLs.URL_ACCOUNT_BASE + "/recyclePhoneCheck");

    public static RegisterUserInfo O000000o(Context context, RegisterUserInfo registerUserInfo, O000000o o000000o, boolean z) {
        int i;
        if (z) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long O000000o2 = O000000o(context, registerUserInfo);
            HashMap hashMap = new HashMap();
            hashMap.put("time", String.valueOf((SystemClock.elapsedRealtime() - elapsedRealtime) / 1000));
            AccountStatInterface.getInstance().statCountEvent("in_net_date", "time", hashMap);
            if (O000000o2 > 0) {
                if (O000000o2 > registerUserInfo.bindTime) {
                    i = RegisterUserInfo.RegisterStatus.STATUS_NOT_REGISTERED.value;
                } else {
                    i = RegisterUserInfo.RegisterStatus.STATUS_REGISTERED_NOT_RECYCLED.value;
                }
                return RegisterUserInfo.copyFrom(registerUserInfo).status(i).build();
            }
        }
        return RegisterUserInfo.copyFrom(registerUserInfo).status(O000000o(registerUserInfo, o000000o)).build();
    }

    private static long O000000o(Context context, RegisterUserInfo registerUserInfo) {
        PhoneNumKeeper createPhoneNumKeeper = new PhoneNumKeeperFactory().createPhoneNumKeeper(context, "2882303761517565051");
        for (int i = 0; i < createPhoneNumKeeper.getSlotCount(); i++) {
            try {
                InNetDateResult inNetDate = createPhoneNumKeeper.getInNetDate(context, i);
                if (inNetDate.isFailure()) {
                    AccountLog.i("InNetDateController", "getInNetDate failed for " + i + " " + inNetDate.getMassage());
                } else {
                    AccountLog.i("InNetDateController", "getInNetDate success for ".concat(String.valueOf(i)));
                    if (TextUtils.isDigitsOnly(registerUserInfo.phone)) {
                        if (registerUserInfo.phone.equals(inNetDate.getPhoneNum())) {
                            AccountLog.i("InNetDateController", "getInNetDate phone match for ".concat(String.valueOf(i)));
                            return inNetDate.getInNetDate();
                        }
                    }
                    if (O000000o(registerUserInfo.phone).equals(O000000o(inNetDate.getPhoneNum()))) {
                        AccountLog.i("InNetDateController", "getInNetDate phone match for ".concat(String.valueOf(i)));
                        return inNetDate.getInNetDate();
                    }
                }
            } catch (IOException e) {
                AccountLog.e("InNetDateController", "getInNetDate", e);
            }
        }
        return -1;
    }

    private static String O000000o(String str) {
        if (str == null || str.length() != 11) {
            return str;
        }
        return str.substring(0, 3) + "****" + str.substring(7, 11);
    }

    private static int O000000o(RegisterUserInfo registerUserInfo, O000000o o000000o) {
        String str = f15590O000000o;
        EasyMap easyPut = new EasyMap().easyPut("_json", "true");
        EasyMap easyPutOpt = new EasyMap().easyPutOpt("ticketToken", registerUserInfo.ticketToken);
        if (o000000o != null) {
            easyPut.easyPutOpt("user", o000000o.f15591O000000o).easyPutOpt("ticket", o000000o.O00000Oo);
            ActivatorPhoneInfo activatorPhoneInfo = o000000o.O00000o0;
            if (activatorPhoneInfo != null) {
                easyPut.easyPutOpt("userHash", activatorPhoneInfo.phoneHash);
                easyPutOpt.easyPutOpt("activatorToken", activatorPhoneInfo.activatorToken);
            }
        }
        try {
            ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"ticketToken", "ticket", "userHash", "activatorToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(easyPutOpt).log();
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str, easyPut, easyPutOpt, true);
            ProtocolLogHelper.newResponseLog(str).stringResponseOrNull(postAsString).log();
            if (postAsString != null) {
                JSONObject jSONObject = new JSONObject(XMPassport.removeSafePrefixAndGetRealBody(postAsString));
                int i = jSONObject.getInt("code");
                String str2 = "code: " + i + ", desc: " + jSONObject.optString("description");
                if (i == 0) {
                    return jSONObject.getJSONObject("data").getInt("status");
                }
                throw new InvalidResponseException(str2);
            }
            throw new InvalidResponseException("result content is null");
        } catch (IOException e) {
            AccountLog.e("InNetDateController", "queryStatusFromServer", e);
            return RegisterUserInfo.RegisterStatus.STATUS_USED_POSSIBLY_RECYCLED.value;
        } catch (AccessDeniedException e2) {
            AccountLog.e("InNetDateController", "queryStatusFromServer", e2);
            return RegisterUserInfo.RegisterStatus.STATUS_USED_POSSIBLY_RECYCLED.value;
        } catch (AuthenticationFailureException e3) {
            AccountLog.e("InNetDateController", "queryStatusFromServer", e3);
            return RegisterUserInfo.RegisterStatus.STATUS_USED_POSSIBLY_RECYCLED.value;
        } catch (InvalidResponseException e4) {
            AccountLog.e("InNetDateController", "queryStatusFromServer", e4);
            return RegisterUserInfo.RegisterStatus.STATUS_USED_POSSIBLY_RECYCLED.value;
        } catch (JSONException e5) {
            AccountLog.e("InNetDateController", "queryStatusFromServer", e5);
            return RegisterUserInfo.RegisterStatus.STATUS_USED_POSSIBLY_RECYCLED.value;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f15591O000000o;
        public final String O00000Oo;
        public final ActivatorPhoneInfo O00000o0;

        public O000000o(String str, String str2, ActivatorPhoneInfo activatorPhoneInfo) {
            this.f15591O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = activatorPhoneInfo;
        }
    }
}
