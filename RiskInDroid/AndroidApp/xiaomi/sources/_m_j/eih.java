package _m_j;

import _m_j.eia;
import _m_j.eii;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/passport/ui/internal/WebAuth;", "", "()V", "getAuthFragment", "Lcom/xiaomi/passport/ui/internal/SignInFragment;", "sid", "", "url", "getFindPswFragment", "getNotificationFragment", "getSignUpFragment", "region", "getSnsBindFragment", "e", "Lcom/xiaomi/passport/ui/internal/NeedBindSnsException;", "getSnsWebLoginFragment", "Lcom/xiaomi/passport/snscorelib/internal/request/SNSRequest$RedirectToWebLoginException;", "snsAuthProvider", "Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "getUserSettingFragment", "Landroidx/fragment/app/Fragment;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eih {
    public static ehu O000000o(String str, String str2) {
        ixe.O00000o0(str, "sid");
        String str3 = URLs.ACCOUNT_DOMAIN + "/pass/register?sid=" + str;
        if (str2 != null) {
            str3 = str3 + "&_uRegion=" + str2;
        }
        return O00000Oo(str, str3);
    }

    public static ehu O000000o(String str) {
        ixe.O00000o0(str, "url");
        eii.O000000o o000000o = eii.f15318O000000o;
        return eii.O000000o.O000000o(str);
    }

    public static ehu O000000o(SNSRequest.RedirectToWebLoginException redirectToWebLoginException, ehr ehr) {
        ixe.O00000o0(redirectToWebLoginException, "e");
        ixe.O00000o0(ehr, "snsAuthProvider");
        eia.O000000o o000000o = eia.f15308O000000o;
        return eia.O000000o.O000000o(redirectToWebLoginException, ehr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    static ehu O00000Oo(String str, String str2) {
        String str3 = XMPassportUtil.buildUrlWithLocaleQueryParam(str2) + "&_bannerBiz=" + str;
        eii.O000000o o000000o = eii.f15318O000000o;
        ixe.O000000o((Object) str3, "urlWithLocale");
        return eii.O000000o.O000000o(str3);
    }
}
