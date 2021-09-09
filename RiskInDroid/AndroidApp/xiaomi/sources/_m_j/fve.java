package _m_j;

import _m_j.exo;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.SmartHomeMainActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public final class fve extends fvf {
    public fve(Activity activity) {
        super(activity);
    }

    public final void O000000o(Intent intent) {
        Object obj;
        final Intent intent2 = intent;
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            O000000o();
            this.f17254O000000o.finish();
            return;
        }
        String str = "";
        if ("com.xiaomi.smarthome.action.viewdevice".equals(action)) {
            XQProgressDialog.O000000o(this.f17254O000000o, "", this.f17254O000000o.getString(R.string.mj_loading), true, true, new DialogInterface.OnCancelListener() {
                /* class _m_j.fve.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    Activity activity = fve.this.f17254O000000o;
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }).show();
            final boolean booleanExtra = intent2.getBooleanExtra("from_main_activity", false);
            Bundle extras = intent.getExtras();
            if (!(extras == null || (obj = extras.get("user_id")) == null)) {
                String obj2 = obj.toString();
                if (!"0".equals(obj2)) {
                    str = obj2;
                }
            }
            String stringExtra = intent2.getStringExtra("device_mac");
            if (!TextUtils.isEmpty(stringExtra)) {
                stringExtra = stringExtra.toLowerCase();
            }
            String str2 = stringExtra;
            String stringExtra2 = intent2.getStringExtra("device_id");
            hxi.f950O000000o.f951O000000o.O000000o("entry_shortcut_device", "creator", str, "did", stringExtra2);
            if ("MiControlsProviderService".equals(intent2.getStringExtra("from"))) {
                hxi.O00000o.f952O000000o.O000000o("miui_card_control_press", "model", intent2.getStringExtra("user_model"), "total", Integer.valueOf(intent2.getIntExtra("total", 1)), "serial", Integer.valueOf(intent2.getIntExtra("serial", 1)));
            }
            if (booleanExtra) {
                final String str3 = str;
                final String str4 = stringExtra2;
                final String str5 = str2;
                final Intent intent3 = intent;
                CoreApi.O000000o().O000000o(this.f17254O000000o, new CoreApi.O0000o0() {
                    /* class _m_j.fve.AnonymousClass2 */

                    public final void onCoreReady() {
                        fve.this.O000000o(true, booleanExtra, str3, str4, str5, intent3);
                    }
                });
                return;
            }
            return;
        }
        if ("com.xiaomi.smarthome.action.openshop".equals(action)) {
            Intent intent4 = new Intent(this.f17254O000000o, SmartHomeMainActivity.class);
            intent4.putExtras(intent2);
            intent4.putExtra("source", 6);
            intent4.setFlags(268468224);
            intent4.setAction("com.xiaomi.smarthome.action.viewdevice");
            this.f17254O000000o.startActivity(intent4);
        } else if ("com.xiaomi.smarthome.action.scandevice".equals(action)) {
            ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
                /* class _m_j.fve.AnonymousClass3 */

                public final void onLoginSuccess() {
                    fbt fbt = new fbt(fve.this.f17254O000000o, "ChooseDeviceActivity");
                    fbt.O00000Oo(536870912);
                    fbt.O000000o("search_word", intent2.getStringExtra("search_word"));
                    fbs.O000000o(fbt);
                }

                public final void onLoginFailed() {
                    fve.this.f17254O000000o.startActivity(new Intent(fve.this.f17254O000000o, SmartHomeMainActivity.class));
                }
            });
            return;
        } else if (action.equalsIgnoreCase("pluignservice.startForeground.notification.pendingIntent")) {
            String stringExtra3 = intent2.getStringExtra("model");
            Intent intent5 = (Intent) intent2.getParcelableExtra("params");
            String stringExtra4 = intent2.getStringExtra("did");
            hxi.f950O000000o.f951O000000o.O000000o("entry_notice_board", "model", stringExtra3, "did", stringExtra4);
            if (TextUtils.isEmpty(stringExtra3)) {
                gsy.O000000o(3, str, "model is null");
                return;
            }
            PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), stringExtra3, 17, intent5, fno.O000000o().O0000o00(stringExtra4), null, false, null);
        }
        this.f17254O000000o.finish();
    }
}
