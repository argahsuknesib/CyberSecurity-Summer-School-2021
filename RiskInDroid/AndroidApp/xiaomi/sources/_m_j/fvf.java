package _m_j;

import _m_j.exo;
import _m_j.fno;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.SmartHomeMainActivity;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.login.MijiaLoginManager;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Iterator;
import java.util.Map;

public abstract class fvf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Activity f17254O000000o;
    public O000000o O00000Oo;

    public abstract void O000000o(Intent intent);

    class O000000o implements fno.O000000o {
        private String O00000Oo;
        private String O00000o;
        private String O00000o0;
        private Intent O00000oO;
        private boolean O00000oo;

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        O000000o(String str, String str2, String str3, Intent intent, boolean z) {
            this.O00000Oo = str;
            this.O00000o0 = str2;
            this.O00000o = str3;
            this.O00000oO = intent;
            this.O00000oo = z;
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                fvf.this.O000000o(false, this.O00000oo, this.O00000o, this.O00000Oo, this.O00000o0, this.O00000oO);
                fno.O000000o().O00000Oo(this);
                ggb.O00000Oo().O00000o0();
            }
        }
    }

    fvf(Activity activity) {
        this.f17254O000000o = activity;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        Intent intent = new Intent(this.f17254O000000o, SmartHomeMainActivity.class);
        intent.setFlags(268468224);
        this.f17254O000000o.startActivity(intent);
    }

    public final boolean O00000Oo() {
        if ((Build.VERSION.SDK_INT < 17 || !this.f17254O000000o.isDestroyed()) && !this.f17254O000000o.isFinishing()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z, boolean z2, String str, String str2, String str3, Intent intent) {
        if (TextUtils.isEmpty(str2)) {
            this.f17254O000000o.finish();
            return;
        }
        gsy.O00000o0(LogType.PLUGIN, "SmartHomeJumper", "openDevicePage did:".concat(String.valueOf(str2)));
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Intent intent2 = intent;
        final boolean z3 = z2;
        final boolean z4 = z;
        ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
            /* class _m_j.fvf.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:49:0x0151  */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0257  */
            public final void onLoginSuccess() {
                Device device;
                Device device2;
                Bundle bundle = null;
                if (TextUtils.isEmpty(str4) || ServiceApplication.getStateNotifier().f15923O000000o != 4 || CoreApi.O000000o().O0000o0().equals(str4)) {
                    Device O000000o2 = fno.O000000o().O000000o(str5);
                    if (O000000o2 == null) {
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "SmartHomeJumper", "getDeviceByDid = null did:" + str5);
                        Map<String, Device> O00000oO2 = fno.O000000o().O00000oO();
                        if (O00000oO2 != null) {
                            Iterator<Map.Entry<String, Device>> it = O00000oO2.entrySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                device2 = (Device) it.next().getValue();
                                if ((TextUtils.isEmpty(str6) || !(device2 instanceof MiTVDevice) || !str6.equals(((MiTVDevice) device2).active_mac)) && ((TextUtils.isEmpty(str6) || TextUtils.isEmpty(device2.mac) || !str6.equals(device2.mac.toLowerCase())) && (TextUtils.isEmpty(str5) || TextUtils.isEmpty(device2.did) || !str5.equals(device2.did)))) {
                                }
                            }
                            O000000o2 = device2;
                        }
                    }
                    if (O000000o2 == null) {
                        LogType logType2 = LogType.PLUGIN;
                        gsy.O00000o0(logType2, "SmartHomeJumper", "getOnlineSubDevice = null did:" + str5);
                        Map<String, Device> O00000Oo2 = fno.O000000o().O00000Oo();
                        if (O00000Oo2 != null) {
                            Iterator<Map.Entry<String, Device>> it2 = O00000Oo2.entrySet().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Device device3 = (Device) it2.next().getValue();
                                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(device3.did) && str5.equals(device3.did)) {
                                    device = device3;
                                    break;
                                }
                            }
                            if (device != null) {
                                LogType logType3 = LogType.PLUGIN;
                                gsy.O00000o0(logType3, "SmartHomeJumper", "did:" + str5 + " device = null isRefreshDevice:" + z4);
                                if (z4) {
                                    fvf fvf = fvf.this;
                                    fvf.O00000Oo = new O000000o(str5, str6, str4, intent2, z3);
                                    fno.O000000o().O000000o(fvf.this.O00000Oo);
                                    fno.O000000o().O0000Oo0();
                                    return;
                                }
                                izb.O000000o(fvf.this.f17254O000000o, (int) R.string.open_device_not_found_erro_removed, 0).show();
                                fvf.this.f17254O000000o.finish();
                                return;
                            } else if (!device.isBinded() && !device.canUseNotBind) {
                                new MLAlertDialog.Builder(fvf.this.f17254O000000o).O00000Oo(fvf.this.f17254O000000o.getString(R.string.open_device_not_bound_alert)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                                    /* class _m_j.fvf.AnonymousClass1.AnonymousClass4 */

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }).O000000o(new MLAlertDialog.O000000o() {
                                    /* class _m_j.fvf.AnonymousClass1.AnonymousClass3 */

                                    public final void beforeDismissCallBack() {
                                    }

                                    public final void afterDismissCallBack() {
                                        fvf.this.f17254O000000o.finish();
                                    }
                                }).O00000oo();
                                return;
                            } else if (CoreApi.O000000o().O00000o(device.model)) {
                                LogType logType4 = LogType.PLUGIN;
                                gsy.O00000o0(logType4, "SmartHomeJumper", "isPluginDevice did:" + str5);
                                PluginDeviceInfo O00000oO3 = CoreApi.O000000o().O00000oO(device.model);
                                Intent intent = new Intent();
                                Intent intent2 = intent2;
                                if (intent2 != null) {
                                    intent.putExtras(intent2);
                                }
                                Activity activity = fvf.this.f17254O000000o;
                                final XQProgressHorizontalDialog O000000o3 = XQProgressHorizontalDialog.O000000o(activity, fvf.this.f17254O000000o.getString(R.string.plugin_downloading) + O00000oO3.O0000Oo0() + fvf.this.f17254O000000o.getString(R.string.plugin));
                                PluginApi.getInstance().sendMessage(fvf.this.f17254O000000o, device.model, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), null, false, new SendMessageCallback() {
                                    /* class _m_j.fvf.AnonymousClass1.AnonymousClass5 */

                                    public final void onDownloadStart(final String str, final PluginDownloadTask pluginDownloadTask) {
                                        XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                        if (z3 && fvf.this.O00000Oo() && (xQProgressHorizontalDialog = O000000o3) != null) {
                                            xQProgressHorizontalDialog.O000000o(true);
                                            XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o3;
                                            xQProgressHorizontalDialog2.f9117O000000o = false;
                                            xQProgressHorizontalDialog2.setCancelable(true);
                                            O000000o3.show();
                                            O000000o3.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                                /* class _m_j.fvf.AnonymousClass1.AnonymousClass5.AnonymousClass1 */

                                                public final void onCancel(DialogInterface dialogInterface) {
                                                    CoreApi.O000000o().O000000o(str, pluginDownloadTask);
                                                }
                                            });
                                        }
                                    }

                                    public final void onDownloadProgress(String str, float f) {
                                        XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                        if (z3 && fvf.this.O00000Oo() && (xQProgressHorizontalDialog = O000000o3) != null && xQProgressHorizontalDialog.isShowing()) {
                                            O000000o3.O000000o(100, (int) (f * 100.0f));
                                        }
                                    }

                                    public final void onDownloadSuccess(String str) {
                                        XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                        if (z3 && fvf.this.O00000Oo() && (xQProgressHorizontalDialog = O000000o3) != null && xQProgressHorizontalDialog.isShowing()) {
                                            O000000o3.dismiss();
                                        }
                                    }

                                    public final void onDownloadFailure(PluginError pluginError) {
                                        XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                        if (!TextUtils.isEmpty(intent2.getStringExtra("action_device_launcher_plugin_fail_no_net")) && !gof.O000000o()) {
                                            izb.O000000o(ServiceApplication.getAppContext(), intent2.getStringExtra("action_device_launcher_plugin_fail_no_net"), 0).show();
                                        } else if (intent2.getBooleanExtra("action_device_launcher_from_widget", false) && fvf.this.O00000Oo()) {
                                            gqg.O00000Oo(pluginError.O000000o(fvf.this.f17254O000000o));
                                        }
                                        if (z3 && fvf.this.O00000Oo() && (xQProgressHorizontalDialog = O000000o3) != null && xQProgressHorizontalDialog.isShowing()) {
                                            O000000o3.dismiss();
                                        }
                                    }

                                    public final void onDownloadCancel() {
                                        XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                        if (z3 && fvf.this.O00000Oo() && (xQProgressHorizontalDialog = O000000o3) != null && xQProgressHorizontalDialog.isShowing()) {
                                            O000000o3.dismiss();
                                        }
                                    }

                                    public final void onSendSuccess(Bundle bundle) {
                                        fvf.this.f17254O000000o.finish();
                                    }

                                    public final void onSendCancel() {
                                        fvf.this.f17254O000000o.finish();
                                    }

                                    public final void onSendFailure(fso fso) {
                                        fvf.this.f17254O000000o.finish();
                                    }
                                });
                                return;
                            } else {
                                LogType logType5 = LogType.PLUGIN;
                                gsy.O00000o0(logType5, "SmartHomeJumper", "getDeviceRenderProvider did:" + str5);
                                Intent intent3 = intent2;
                                if (intent3 != null) {
                                    bundle = intent3.getExtras();
                                }
                                Intent action = ext.O000000o(device).getAction(device, fvf.this.f17254O000000o.getApplicationContext(), bundle, false, null);
                                if (action != null) {
                                    try {
                                        fvf.this.f17254O000000o.startActivity(action);
                                    } catch (Exception unused) {
                                    }
                                }
                                fvf.this.f17254O000000o.finish();
                                return;
                            }
                        }
                    }
                    device = O000000o2;
                    if (device != null) {
                    }
                } else {
                    new MLAlertDialog.Builder(fvf.this.f17254O000000o).O00000Oo(fvf.this.f17254O000000o.getString(R.string.open_device_account_erro)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class _m_j.fvf.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MijiaLoginManager.O000000o().O000000o(new fsm<Void, fso>() {
                                /* class _m_j.fvf.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                    fvf.this.f17254O000000o.finish();
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    Intent intent = new Intent(fvf.this.f17254O000000o, SmartHomeMainActivity.class);
                                    intent.putExtra("user_id", str4);
                                    fvf.this.f17254O000000o.startActivity(intent);
                                    fvf.this.f17254O000000o.finish();
                                }
                            }, "SmartHomeJumper#openDevicePage#onLOginSuccess");
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o(new MLAlertDialog.O000000o() {
                        /* class _m_j.fvf.AnonymousClass1.AnonymousClass1 */

                        public final void beforeDismissCallBack() {
                        }

                        public final void afterDismissCallBack() {
                            fvf.this.f17254O000000o.finish();
                        }
                    }).O00000oo();
                }
            }

            public final void onLoginFailed() {
                gge.O000000o().O00000Oo();
                fno.O000000o().O0000Oo();
                hor.O000000o().clearSceneManager();
                fno.O000000o().O0000Oo0();
                Intent intent = new Intent(fvf.this.f17254O000000o, SmartHomeMainActivity.class);
                intent.putExtra("user_id", str4);
                fvf.this.f17254O000000o.startActivity(intent);
                fvf.this.f17254O000000o.finish();
            }
        });
    }
}
