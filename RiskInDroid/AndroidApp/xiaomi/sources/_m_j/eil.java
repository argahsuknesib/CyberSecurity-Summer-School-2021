package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/passport/ui/internal/WeiboSSOAuthProvider;", "Lcom/xiaomi/passport/ui/internal/BaseWeiboAuthProvider;", "()V", "mSsoHandler", "Lcom/sina/weibo/sdk/auth/sso/SsoHandler;", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "startLogin", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eil extends efy {
    private SsoHandler O00000Oo;

    public final void O000000o(Activity activity, int i, int i2, Intent intent) {
        ixe.O00000o0(activity, "activity");
        SsoHandler ssoHandler = this.O00000Oo;
        if (ssoHandler == null) {
            ixe.O000000o("mSsoHandler");
        }
        ssoHandler.authorizeCallBack(i, i2, intent);
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
        ixe.O000000o((Object) applicationContext, "context");
        WbSdk.install(applicationContext, new AuthInfo(applicationContext, O000000o(applicationContext), O00000Oo(applicationContext), ""));
        this.O00000Oo = new SsoHandler(activity);
        SsoHandler ssoHandler = this.O00000Oo;
        if (ssoHandler == null) {
            ixe.O000000o("mSsoHandler");
        }
        ssoHandler.authorize(new O000000o(this, activity));
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/passport/ui/internal/WeiboSSOAuthProvider$startLogin$1", "Lcom/sina/weibo/sdk/auth/WbAuthListener;", "(Lcom/xiaomi/passport/ui/internal/WeiboSSOAuthProvider;Landroid/app/Activity;)V", "cancel", "", "onFailure", "err", "Lcom/sina/weibo/sdk/auth/WbConnectErrorMessage;", "onSuccess", "token", "Lcom/sina/weibo/sdk/auth/Oauth2AccessToken;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o implements WbAuthListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eil f15321O000000o;
        final /* synthetic */ Activity O00000Oo;

        O000000o(eil eil, Activity activity) {
            this.f15321O000000o = eil;
            this.O00000Oo = activity;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void onSuccess(Oauth2AccessToken oauth2AccessToken) {
            ixe.O00000o0(oauth2AccessToken, "token");
            if (oauth2AccessToken.isSessionValid()) {
                String token = oauth2AccessToken.getToken();
                ixe.O000000o((Object) token, "token.token");
                this.f15321O000000o.O00000Oo(this.O00000Oo, token);
            }
            efu.O000000o(this.O00000Oo, "ok");
        }

        public final void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            Context context = this.O00000Oo;
            StringBuilder sb = new StringBuilder("onFailure: ");
            String str = null;
            sb.append(wbConnectErrorMessage != null ? wbConnectErrorMessage.getErrorMessage() : null);
            sb.append(", ");
            if (wbConnectErrorMessage != null) {
                str = wbConnectErrorMessage.getErrorCode();
            }
            sb.append(str);
            Toast.makeText(context, sb.toString(), 1).show();
            efu.O000000o(this.O00000Oo, "error");
        }

        public final void cancel() {
            efu.O000000o(this.O00000Oo, "cancelled");
        }
    }
}
