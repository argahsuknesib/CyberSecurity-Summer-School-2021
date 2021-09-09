package _m_j;

import _m_j.eib;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import com.xiaomi.passport.ui.internal.SNSAuthProvider$signInWithAuthCredential$1;
import com.xiaomi.passport.ui.onetrack.Analytics;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 -2\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\n\u001a\u00020\u0003H$J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0004J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H$J\u0016\u0010%\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0003J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0003H\u0004J\u0016\u0010+\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006."}, d2 = {"Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "Lcom/xiaomi/passport/ui/internal/AuthProvider;", "name", "", "(Ljava/lang/String;)V", "sid", "getSid", "()Ljava/lang/String;", "setSid", "getAnalyticsH5ViewEvent", "getAnalyticsStartLoginClickEvent", "getAppId", "context", "Landroid/content/Context;", "getIconRes", "", "getPhoneNumInfo", "getRequestCode", "getTintColor", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "signInWithAuthCredential", "Lcom/xiaomi/passport/ui/internal/Source;", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "credential", "Lcom/xiaomi/passport/ui/internal/AuthCredential;", "signInWithSnsCodeAuthCredential", "authCredential", "Lcom/xiaomi/passport/ui/internal/SnsCodeAuthCredential;", "signInWithSnsTokenAuthCredential", "Lcom/xiaomi/passport/ui/internal/SnsTokenAuthCredential;", "startLogin", "storeBindParameter", "parameter", "Lcom/xiaomi/passport/snscorelib/internal/entity/SNSBindParameter;", "storeSnsCode", "code", "storeSnsToken", "token", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public abstract class ehr extends eft {
    public static SNSBindParameter O00000oO;
    public static ehq O00000oo;
    public static final O000000o O0000O0o = new O000000o((byte) 0);
    public String O00000o;

    public int O000000o() {
        return -100;
    }

    public abstract String O000000o(Context context);

    /* access modifiers changed from: protected */
    public abstract void O000000o(Activity activity);

    public void O000000o(Activity activity, int i, int i2, Intent intent) {
        ixe.O00000o0(activity, "activity");
    }

    /* access modifiers changed from: protected */
    public abstract String O00000Oo();

    public abstract String O00000o0();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ehr(String str) {
        super(str);
        ixe.O00000o0(str, "name");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SNSAuthProvider$Companion;", "", "()V", "ACTION_PASSPORT_SNS_EVENTS", "", "EXTRA_KEY_SNS_RESULT", "VALUE_SNS_CANCELLED", "VALUE_SNS_ERROR", "VALUE_SNS_OK", "authCredential", "Lcom/xiaomi/passport/ui/internal/SNSAuthCredential;", "getAuthCredential", "()Lcom/xiaomi/passport/ui/internal/SNSAuthCredential;", "setAuthCredential", "(Lcom/xiaomi/passport/ui/internal/SNSAuthCredential;)V", "snsBindParameter", "Lcom/xiaomi/passport/snscorelib/internal/entity/SNSBindParameter;", "getSnsBindParameter", "()Lcom/xiaomi/passport/snscorelib/internal/entity/SNSBindParameter;", "setSnsBindParameter", "(Lcom/xiaomi/passport/snscorelib/internal/entity/SNSBindParameter;)V", "invalidAuthCredential", "", "invalidBindParameter", "isBindingSnsAccount", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        public static boolean O000000o() {
            return ehr.O00000oO != null;
        }
    }

    public static void O000000o(SNSBindParameter sNSBindParameter) {
        O00000oO = sNSBindParameter;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Context context, String str) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(str, "code");
        String str2 = this.f15234O000000o;
        String O000000o2 = O000000o(context);
        String str3 = this.O00000o;
        if (str3 == null) {
            ixe.O000000o("sid");
        }
        O00000oo = new ehx(str2, O000000o2, str, str3);
    }

    public final void O00000Oo(Context context, String str) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(str, "token");
        String str2 = this.f15234O000000o;
        String O000000o2 = O000000o(context);
        String str3 = this.O00000o;
        if (str3 == null) {
            ixe.O000000o("sid");
        }
        O00000oo = new ehy(str2, O000000o2, str, str3);
    }

    public final void O000000o(Activity activity, String str) {
        ixe.O00000o0(activity, "activity");
        ixe.O00000o0(str, "sid");
        this.O00000o = str;
        O000000o(activity);
        Analytics.O00000Oo(O00000Oo());
    }

    /* access modifiers changed from: protected */
    public final eib<AccountInfo> O000000o(Context context, efs efs) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(efs, "credential");
        if (efs instanceof ehq) {
            eib.O000000o o000000o = eib.f15310O000000o;
            return eib.O000000o.O000000o(new SNSAuthProvider$signInWithAuthCredential$1(this, efs, context));
        }
        throw new IllegalStateException("not support originAuthCredential:".concat(String.valueOf(efs)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.egs.O000000o(android.content.Context, java.lang.String, boolean):_m_j.eib<java.util.List<com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo>>
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.egs.O000000o(com.xiaomi.passport.ui.internal.PhoneWrapper, _m_j.ega, _m_j.eif):_m_j.eib<java.lang.String>
      _m_j.egr.O000000o(com.xiaomi.passport.ui.internal.PhoneWrapper, _m_j.ega, _m_j.eif):_m_j.eib<java.lang.String>
      _m_j.egs.O000000o(android.content.Context, java.lang.String, boolean):_m_j.eib<java.util.List<com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo>> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final String O00000o0(Context context) {
        JSONObject jSONObject = new JSONObject();
        egt egt = egt.f15254O000000o;
        if (!egt.O00000oO()) {
            egs egs = new egs();
            String str = this.O00000o;
            if (str == null) {
                ixe.O000000o("sid");
            }
            List<ActivatorPhoneInfo> O00000Oo = egs.O000000o(context, str, false).O00000Oo();
            if (O00000Oo != null) {
                for (ActivatorPhoneInfo activatorPhoneInfo : O00000Oo) {
                    jSONObject.putOpt(activatorPhoneInfo.phoneHash, activatorPhoneInfo.activatorToken);
                }
            }
        }
        String jSONObject2 = jSONObject.toString();
        ixe.O000000o((Object) jSONObject2, "phones.toString()");
        return jSONObject2;
    }
}
