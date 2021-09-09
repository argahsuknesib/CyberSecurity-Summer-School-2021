package _m_j;

import _m_j.gsk;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.text.DecimalFormat;
import okhttp3.Response;
import org.json.JSONObject;

public final class fnm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DecimalFormat f16698O000000o = new DecimalFormat("0.#");
    Dialog O00000Oo = null;
    public RouterDevice O00000o;
    public Context O00000o0;
    public ftt<Void> O00000oO;
    public MLAlertDialog O00000oo = null;
    String O0000O0o = "";
    public View O0000OOo;
    public ToggleButton O0000Oo;
    public EditText O0000Oo0;
    public View O0000OoO;

    public final void O000000o() {
        Dialog dialog = this.O00000Oo;
        if (dialog != null) {
            dialog.dismiss();
            this.O00000Oo = null;
        }
    }

    public static void O000000o(String str, ftt<String> ftt) {
        fuc O000000o2 = fuc.O000000o();
        CommonApplication.getAppContext();
        gsy.O000000o(3, "RemoteCameraApi", "getRouterSecret");
        if (TextUtils.isEmpty(fuc.f17154O000000o)) {
            ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
        }
        gsg.O000000o(O000000o2.O00000o, new gsk.O000000o().O000000o("GET").O00000Oo(String.format("http://%s/cgi-bin/luci/;stok=%s/api/xqdatacenter/identify_device", fuc.f17154O000000o, str)).O000000o(), new gso(ftt) {
            /* class _m_j.fuc.AnonymousClass5 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ ftt f17159O000000o;

            {
                this.f17159O000000o = r2;
            }

            public final /* synthetic */ void onSuccess(Object obj, Response response) {
                O000000o((String) obj);
            }

            public final void O000000o(String str) {
                gsy.O000000o(3, "RemoteCameraApi", "getRouterToken onSuccess:".concat(String.valueOf(str)));
                try {
                    String optString = new JSONObject(str).optString("info");
                    if (!TextUtils.isEmpty(optString)) {
                        if (this.f17159O000000o != null) {
                            this.f17159O000000o.O000000o(optString);
                        }
                    } else if (this.f17159O000000o != null) {
                        this.f17159O000000o.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                    }
                } catch (Exception unused) {
                    ftt ftt = this.f17159O000000o;
                    if (ftt != null) {
                        ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                    }
                }
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                ftt ftt = this.f17159O000000o;
                if (ftt != null) {
                    ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                }
            }
        });
    }
}
