package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/passport/ui/internal/QQSSOAuthProvider;", "Lcom/xiaomi/passport/ui/internal/QQAuthProvider;", "()V", "getAppId", "", "context", "Landroid/content/Context;", "getIconRes", "", "getRequestCode", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "startLogin", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehm extends ehl {
    public final int O000000o() {
        return 11101;
    }

    public final void O000000o(Activity activity, int i, int i2, Intent intent) {
        ixe.O00000o0(activity, "activity");
        dka.O000000o(i, i2, intent, new ehn(activity, this));
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Activity activity) {
        ixe.O00000o0(activity, "activity");
        Context context = activity;
        dka O000000o2 = dka.O000000o(O000000o(context), context);
        diz.O00000o0("openSDK_LOG.Tencent", "login() with activity, scope is ".concat(""));
        dim dim = O000000o2.f14734O000000o;
        diz.O00000o0("openSDK_LOG.QQAuth", "login()");
        diz.O00000o0("openSDK_LOG.QQAuth", "-->login activity: ".concat(String.valueOf(activity)));
        dim.O000000o(activity, null, "", new ehn(activity, this), false);
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
        String string = context.getString(R.string.qq_application_id);
        ixe.O000000o((Object) string, "context.getString(R.string.qq_application_id)");
        return string;
    }
}
