package _m_j;

import android.app.Activity;
import android.widget.Toast;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/passport/ui/internal/QQUiListener;", "Lcom/tencent/tauth/IUiListener;", "activity", "Landroid/app/Activity;", "authProvider", "Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "(Landroid/app/Activity;Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;)V", "getActivity", "()Landroid/app/Activity;", "onCancel", "", "onComplete", "result", "", "onError", "p0", "Lcom/tencent/tauth/UiError;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehn implements djz {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Activity f15294O000000o;
    private final ehr O00000Oo;

    public ehn(Activity activity, ehr ehr) {
        ixe.O00000o0(activity, "activity");
        ixe.O00000o0(ehr, "authProvider");
        this.f15294O000000o = activity;
        this.O00000Oo = ehr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void onComplete(Object obj) {
        if (obj instanceof JSONObject) {
            String string = ((JSONObject) obj).getString("access_token");
            ixe.O000000o((Object) string, "accessToken");
            this.O00000Oo.O00000Oo(this.f15294O000000o, string);
        }
        efu.O000000o(this.f15294O000000o, "ok");
    }

    public final void onCancel() {
        efu.O000000o(this.f15294O000000o, "cancelled");
    }

    public final void onError(dkb dkb) {
        Toast.makeText(this.f15294O000000o, "onError", 0).show();
        efu.O000000o(this.f15294O000000o, "error");
    }
}
