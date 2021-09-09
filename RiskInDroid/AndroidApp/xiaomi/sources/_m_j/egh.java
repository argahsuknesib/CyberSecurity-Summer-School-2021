package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/xiaomi/passport/ui/internal/GoogleAuthProvider;", "Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getAnalyticsH5ViewEvent", "", "getAnalyticsStartLoginClickEvent", "getAppId", "getIconRes", "", "getRequestCode", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "startLogin", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egh extends ehr {
    public static final O000000o O00000Oo = new O000000o((byte) 0);

    public final int O000000o() {
        return 32;
    }

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        return "google_login";
    }

    public final String O00000o0() {
        return "Google_bind_email_H5";
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/passport/ui/internal/GoogleAuthProvider$Companion;", "", "()V", "GOOGLE_AUTH_TAG", "", "REQUEST_CODE_GOOGLE", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public egh() {
        super("GOOGLE_AUTH_PROVIDER");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final String O000000o(Context context) {
        ixe.O00000o0(context, "context");
        String string = context.getString(R.string.google_application_id);
        ixe.O000000o((Object) string, "context.getString(R.string.google_application_id)");
        return string;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.google.android.gms.auth.api.signin.GoogleSignInClient, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* access modifiers changed from: protected */
    public final void O000000o(Activity activity) {
        ixe.O00000o0(activity, "activity");
        GoogleSignInClient client = GoogleSignIn.getClient(activity, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestServerAuthCode(O000000o((Context) activity)).requestEmail().build());
        ixe.O000000o((Object) client, "googleSignInClient");
        activity.startActivityForResult(client.getSignInIntent(), 32);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ehr.O000000o(android.content.Context, java.lang.String):void
     arg types: [android.app.Activity, java.lang.String]
     candidates:
      _m_j.ehr.O000000o(android.content.Context, _m_j.efs):_m_j.eib<com.xiaomi.accountsdk.account.data.AccountInfo>
      _m_j.ehr.O000000o(android.app.Activity, java.lang.String):void
      _m_j.eft.O000000o(android.content.Context, _m_j.efs):_m_j.eib<com.xiaomi.accountsdk.account.data.AccountInfo>
      _m_j.ehr.O000000o(android.content.Context, java.lang.String):void */
    public final void O000000o(Activity activity, int i, int i2, Intent intent) {
        String serverAuthCode;
        ixe.O00000o0(activity, "activity");
        if (i == 32) {
            try {
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) GoogleSignIn.getSignedInAccountFromIntent(intent).getResult(ApiException.class);
                if (googleSignInAccount != null && (serverAuthCode = googleSignInAccount.getServerAuthCode()) != null) {
                    O000000o((Context) activity, serverAuthCode);
                    Analytics.O00000o0("sns_google_login_success");
                }
            } catch (ApiException e) {
                AccountLog.w("GoogleAuthProvider", "Google sign in failed", e);
            }
        }
    }
}
