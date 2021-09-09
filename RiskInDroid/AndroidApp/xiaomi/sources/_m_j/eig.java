package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/passport/ui/internal/WeChatAuthProvider;", "Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "()V", "getAnalyticsH5ViewEvent", "", "getAnalyticsStartLoginClickEvent", "getAppId", "context", "Landroid/content/Context;", "getIconRes", "", "getScope", "getState", "getTintColor", "handleWxIntent", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "isPackageInstalled", "packageName", "isWxInstall", "startLogin", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eig extends ehr {
    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        return "wechat_login";
    }

    public final String O00000o0() {
        return null;
    }

    public eig() {
        super("WECHAT_AUTH_PROVIDER");
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
        String string = context.getString(R.string.wechat_application_id);
        ixe.O000000o((Object) string, "context.getString(R.string.wechat_application_id)");
        return string;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Activity activity) {
        ixe.O00000o0(activity, "activity");
        Context context = activity;
        if (!O00000o0(context, "com.tencent.mm")) {
            Toast.makeText(context, activity.getString(R.string.passport_wechat_not_install), 0).show();
            return;
        }
        String O000000o2 = O000000o(context);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, O000000o2, true);
        createWXAPI.registerApp(O000000o2);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wx_api_passport";
        createWXAPI.sendReq(req);
    }

    public final boolean O000000o(Activity activity, Intent intent) {
        ixe.O00000o0(activity, "activity");
        Context context = activity;
        String O000000o2 = O000000o(context);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, O000000o2, true);
        createWXAPI.registerApp(O000000o2);
        return createWXAPI.handleIntent(intent, new O000000o(this, activity));
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/passport/ui/internal/WeChatAuthProvider$handleWxIntent$1", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "(Lcom/xiaomi/passport/ui/internal/WeChatAuthProvider;Landroid/app/Activity;)V", "getWXAPIEventHandler", "onReq", "", "req", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "resp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o implements IWXAPIEventHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eig f15317O000000o;
        final /* synthetic */ Activity O00000Oo;

        O000000o(eig eig, Activity activity) {
            this.f15317O000000o = eig;
            this.O00000Oo = activity;
        }

        public final void onReq(BaseReq baseReq) {
            IWXAPIEventHandler O000000o2 = O000000o();
            if (O000000o2 != null) {
                O000000o2.onReq(baseReq);
            }
        }

        private static IWXAPIEventHandler O000000o() {
            egt egt = egt.f15254O000000o;
            Object O0000OOo = egt.O0000OOo();
            if (!(O0000OOo instanceof IWXAPIEventHandler)) {
                O0000OOo = null;
            }
            return (IWXAPIEventHandler) O0000OOo;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
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
          _m_j.eig.O000000o(android.app.Activity, android.content.Intent):boolean
          _m_j.ehr.O000000o(android.content.Context, _m_j.efs):_m_j.eib<com.xiaomi.accountsdk.account.data.AccountInfo>
          _m_j.ehr.O000000o(android.app.Activity, java.lang.String):void
          _m_j.eft.O000000o(android.content.Context, _m_j.efs):_m_j.eib<com.xiaomi.accountsdk.account.data.AccountInfo>
          _m_j.ehr.O000000o(android.content.Context, java.lang.String):void */
        public final void onResp(BaseResp baseResp) {
            if (baseResp instanceof SendAuth.Resp) {
                SendAuth.Resp resp = (SendAuth.Resp) baseResp;
                if (ixe.O000000o((Object) resp.state, (Object) "wx_api_passport") || baseResp.errCode != 0) {
                    if (baseResp.errCode == 0) {
                        String str = resp.code;
                        ixe.O000000o((Object) str, "resp.code");
                        this.f15317O000000o.O000000o((Context) this.O00000Oo, str);
                        efu.O000000o(this.O00000Oo, "ok");
                        return;
                    }
                    efu.O000000o(this.O00000Oo, "error");
                    return;
                }
            }
            IWXAPIEventHandler O000000o2 = O000000o();
            if (O000000o2 != null) {
                O000000o2.onResp(baseResp);
            }
        }
    }

    private static boolean O00000o0(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
