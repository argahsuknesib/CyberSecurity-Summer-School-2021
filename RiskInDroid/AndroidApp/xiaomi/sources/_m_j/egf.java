package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 '2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J*\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/xiaomi/passport/ui/internal/FacebookAuthProvider;", "Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "()V", "EMAIL", "", "PUBLIC_PROFILE", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mScopes", "", "sCallbackManager", "Lcom/facebook/CallbackManager;", "getAnalyticsH5ViewEvent", "getAnalyticsStartLoginClickEvent", "getAppId", "getIconRes", "", "getRequestCode", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCancel", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "result", "startLogin", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egf extends ehr implements FacebookCallback<LoginResult> {
    public static final O000000o O00000o0 = new O000000o((byte) 0);
    public Context O00000Oo;
    private final String O0000OOo = "email";
    private final List<String> O0000Oo = new ArrayList();
    private final String O0000Oo0 = "public_profile";
    private CallbackManager O0000OoO;

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        return "fb_login";
    }

    public final String O00000o0() {
        return "FB_bind_email_H5";
    }

    public egf() {
        super("FACEBOOK_AUTH_PROVIDER");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.facebook.AccessToken, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final /* synthetic */ void onSuccess(Object obj) {
        LoginResult loginResult = (LoginResult) obj;
        Context context = this.O00000Oo;
        if (context == null) {
            ixe.O000000o("context");
        }
        if (loginResult == null) {
            ixe.O000000o();
        }
        AccessToken accessToken = loginResult.getAccessToken();
        ixe.O000000o((Object) accessToken, "result!!.accessToken");
        String token = accessToken.getToken();
        ixe.O000000o((Object) token, "result!!.accessToken.token");
        O00000Oo(context, token);
        Analytics.O00000o0("sns_fb_login_success");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/passport/ui/internal/FacebookAuthProvider$Companion;", "", "()V", "FACEBOOK_AUTH_TAG", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
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
        String string = context.getString(R.string.facebook_application_id);
        ixe.O000000o((Object) string, "context.getString(R.stri….facebook_application_id)");
        return string;
    }

    public final int O000000o() {
        if (!FacebookSdk.isInitialized()) {
            return super.O000000o();
        }
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.Context, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* access modifiers changed from: protected */
    public final void O000000o(Activity activity) {
        ixe.O00000o0(activity, "activity");
        Context applicationContext = activity.getApplicationContext();
        ixe.O000000o((Object) applicationContext, "activity.applicationContext");
        this.O00000Oo = applicationContext;
        this.O0000OoO = CallbackManager.Factory.create();
        LoginManager instance = LoginManager.getInstance();
        instance.registerCallback(this.O0000OoO, this);
        ArrayList arrayList = new ArrayList(this.O0000Oo);
        if (!arrayList.contains(this.O0000OOo)) {
            arrayList.add(this.O0000OOo);
        }
        if (!arrayList.contains(this.O0000Oo0)) {
            arrayList.add(this.O0000Oo0);
        }
        instance.logInWithReadPermissions(activity, arrayList);
    }

    public final void onCancel() {
        AccountLog.d("FacebookAuthProvider", "onCancel");
    }

    public final void onError(FacebookException facebookException) {
        Context context = this.O00000Oo;
        if (context == null) {
            ixe.O000000o("context");
        }
        Toast.makeText(context, facebookException != null ? facebookException.getMessage() : null, 0).show();
    }

    public final void O000000o(Activity activity, int i, int i2, Intent intent) {
        ixe.O00000o0(activity, "activity");
        CallbackManager callbackManager = this.O0000OoO;
        if (callbackManager != null) {
            callbackManager.onActivityResult(i, i2, intent);
        }
    }
}
