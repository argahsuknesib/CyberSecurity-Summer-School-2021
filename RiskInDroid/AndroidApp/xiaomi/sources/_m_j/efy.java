package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.passport.ui.internal.SnsAuthActivity;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0004J\b\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/passport/ui/internal/BaseWeiboAuthProvider;", "Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "()V", "getAnalyticsH5ViewEvent", "", "getAnalyticsStartLoginClickEvent", "getAppId", "context", "Landroid/content/Context;", "getIconRes", "", "getRedirectUri", "getRequestCode", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "startLogin", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public class efy extends ehr {
    public final int O000000o() {
        return 32973;
    }

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        return "weibo_login";
    }

    public final String O00000o0() {
        return null;
    }

    public efy() {
        super("WEIBO_AUTH_PROVIDER");
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
        String string = context.getString(R.string.weibo_application_id);
        ixe.O000000o((Object) string, "context.getString(R.string.weibo_application_id)");
        return string;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    protected static String O00000Oo(Context context) {
        ixe.O00000o0(context, "context");
        String string = context.getString(R.string.weibo_redirect_uri);
        ixe.O000000o((Object) string, "context.getString(R.string.weibo_redirect_uri)");
        return string;
    }

    /* access modifiers changed from: protected */
    public void O000000o(Activity activity) {
        ixe.O00000o0(activity, "activity");
        Context context = activity;
        Intent intent = new Intent(context, SnsAuthActivity.class);
        intent.putExtra("url", "https://api.weibo.com/oauth2/authorize?response_type=code&redirect_uri=" + O00000Oo(context) + "&client_id=" + O000000o(context));
        activity.startActivityForResult(intent, 32973);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ehr.O000000o(android.content.Context, java.lang.String):void
     arg types: [android.app.Activity, java.lang.String]
     candidates:
      _m_j.ehr.O000000o(android.content.Context, _m_j.efs):_m_j.eib<com.xiaomi.accountsdk.account.data.AccountInfo>
      _m_j.ehr.O000000o(android.app.Activity, java.lang.String):void
      _m_j.eft.O000000o(android.content.Context, _m_j.efs):_m_j.eib<com.xiaomi.accountsdk.account.data.AccountInfo>
      _m_j.ehr.O000000o(android.content.Context, java.lang.String):void */
    public void O000000o(Activity activity, int i, int i2, Intent intent) {
        ixe.O00000o0(activity, "activity");
        if (i == 32973 && i2 == -1) {
            if (intent == null) {
                ixe.O000000o();
            }
            String stringExtra = intent.getStringExtra("code");
            ixe.O000000o((Object) stringExtra, "code");
            O000000o((Context) activity, stringExtra);
        }
    }
}
