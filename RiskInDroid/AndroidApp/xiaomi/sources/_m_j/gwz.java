package _m_j;

import _m_j.fno;
import android.app.Activity;
import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONObject;

public class gwz extends gwy implements fno.O00000o0 {
    private static final String O00000Oo = "gwz";
    private String O00000o;
    private String O00000o0;
    private String O00000oO;
    private Context O00000oo;

    public void onRefreshClientDeviceChanged(int i, Device device) {
    }

    public gwz(Context context, String str, String str2, String str3) {
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000oO = str3;
        this.O00000oo = context;
    }

    public final void O00000Oo() {
        if (this.O00000oo instanceof Activity) {
            boolean O0000o00 = fno.O000000o().O0000o00();
            if (O0000o00) {
                O000000o((Activity) this.O00000oo, true);
            } else {
                fno.O000000o().O000000o(this);
            }
            gsy.O00000Oo(LogType.PUSH, O00000Oo, "devices inited == ".concat(String.valueOf(O0000o00)));
        }
    }

    public final void O000000o(final Activity activity, boolean z) {
        Device O000000o2 = fno.O000000o().O000000o(this.O00000o0);
        if (O000000o2 == null) {
            Home O00000o2 = ggb.O00000Oo().O00000o(String.valueOf(this.O00000o));
            if (!z || O00000o2 == null || O00000o2.isOwner()) {
                activity.runOnUiThread($$Lambda$gwz$MkujSXC3lZIYpppXxdE6EeMkPE.INSTANCE);
                return;
            }
            final XQProgressHorizontalDialog O000000o3 = XQProgressHorizontalDialog.O000000o(activity, activity.getString(R.string.loading_data) + activity.getString(R.string.plugin));
            O000000o3.show();
            ggw.O000000o().O000000o(Long.parseLong(this.O00000o), new fsm() {
                /* class _m_j.gwz.AnonymousClass1 */

                public final void onSuccess(Object obj) {
                    if (!activity.isFinishing() && !activity.isDestroyed()) {
                        O000000o3.dismiss();
                        gwz.this.O000000o(activity, false);
                    }
                }

                public final void onFailure(fso fso) {
                    if (!activity.isFinishing() && !activity.isDestroyed()) {
                        O000000o3.dismiss();
                        activity.runOnUiThread($$Lambda$gwz$1$uAu4BKI3Gqez3hGuzGntma8QtuI.INSTANCE);
                    }
                }
            });
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("model", O000000o2.model);
            jSONObject.put("did", O000000o2.did);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("extra", this.O00000oO);
            jSONObject.put("from_where", "miuiP0");
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(O000000o2.model);
            hxi.O00000oO.O00000o0(O000000o2.model);
            if (O00000oO2 == null) {
                ezo.O000000o().dispatchMessage("", jSONObject.toString(), false);
            } else {
                guh.O000000o(activity, jSONObject.toString(), O00000oO2, O000000o2, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onRefreshClientDeviceSuccess(int i) {
        if (i == 3) {
            O000000o((Activity) this.O00000oo, true);
            fno.O000000o().O00000Oo(this);
        }
    }
}
