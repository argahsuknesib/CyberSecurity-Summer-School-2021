package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class hwp extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f903O000000o;
    public boolean O00000Oo;
    public Runnable O00000o = new Runnable() {
        /* class _m_j.hwp.AnonymousClass1 */

        public final void run() {
            if (hwp.this.O00000o0 != null && hwp.this.O00000Oo && !hwp.this.O000OO00) {
                htq.O000000o().O00000o(hwp.this.O00000o0.O00000Oo, hwp.this.O00000o0.O00000o, new hua<JSONObject, hud>() {
                    /* class _m_j.hwp.AnonymousClass1.AnonymousClass1 */

                    public final void O000000o(hud hud) {
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        int i;
                        JSONObject jSONObject = (JSONObject) obj;
                        gsy.O00000Oo(LogType.KUAILIAN, "PushNewDeviceStep", "isBoundDeviceStatus:".concat(String.valueOf(jSONObject)));
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null) {
                            i = 0;
                        } else {
                            i = optJSONObject.optInt("status");
                        }
                        if (i == 3) {
                            hwp.this.f903O000000o = 0;
                            hwp.this.O0000oOO();
                        } else if (i == 5) {
                            hwp.this.f903O000000o = 1;
                            hwp.this.O0000oOO();
                        } else if (i > 3) {
                            hwp.this.O00000Oo(1);
                            hwp.this.f903O000000o = 2;
                        } else if (i > 1) {
                            hwp.this.O00000Oo(0);
                            hwp.this.f903O000000o = 1;
                        } else {
                            hwp.this.f903O000000o = 0;
                        }
                    }
                });
                htq.O000000o().O000000o(hwp.this.O000O0oo, null, false, hwp.this.O00000o0.O00000o, hwp.this.O00000o0.O00000oO, hwp.this.O00000o0.O00000oo, null, hwp.this.O000OOOo, new hua<List<Device>, hud>() {
                    /* class _m_j.hwp.AnonymousClass1.AnonymousClass2 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        Device device;
                        List list = (List) obj;
                        if (list.size() == 0 || (device = (Device) list.get(0)) == null) {
                            O000000o();
                            return;
                        }
                        htr.O000000o().O00000Oo("connected_device", device);
                        fno.O000000o().O000000o(device);
                        fno.O000000o().O0000Oo0(device.did);
                        gsy.O00000Oo(LogType.KUAILIAN, "PushNewDeviceStep", "DeviceFinderCallback.onDeviceConnectionSuccess");
                        hwp.this.O000OoO0 = true;
                        hwp.this.O00000Oo(2);
                    }

                    public final void O000000o(hud hud) {
                        O000000o();
                    }

                    private void O000000o() {
                        hwp.this.x_().postDelayed(hwp.this.O00000o, 4000);
                    }
                });
            }
        }
    };
    public PushBindEntity O00000o0;
    private int O00000oO = -1;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void O00000Oo(int i) {
        for (int i2 = this.O00000oO; i2 < i; i2++) {
            e_(i);
        }
        this.O00000oO = i;
    }

    public final ArrayList<gke> O0000Oo0() {
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 60000;
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 60000;
        gke gke3 = new gke();
        gke3.f17943O000000o = 2;
        gke3.O00000Oo = 60000;
        arrayList.add(gke);
        arrayList.add(gke2);
        arrayList.add(gke3);
        return arrayList;
    }

    public final void C_() {
        O00000oO(this.f903O000000o);
    }

    private void O00000oO(int i) {
        if (this.O000O0o0.getStepIndex() == 1 && i >= 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.router_recongise_device_success, (int) R.string.ble_combo_device_title_error);
            this.O000O0o0.O000000o((int) R.string.kuailian_phone_sendmessage_device, (int) R.string.ble_combo_device_title_error);
            this.O000O0o0.O000000o(2);
        }
        if (this.O000O0o0.getStepIndex() == 2 && i > 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_sendmessage_success, (int) R.string.ble_combo_device_title_error);
            this.O000O0o0.O000000o((int) R.string.kuailian_device_connect_wifi, (int) R.string.make_device_near_router);
            this.O000O0o0.O000000o(3);
        }
        if (this.O000O0o0.getStepIndex() == 3 && 2 <= i) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.device_bind_success, (int) R.string.gateway_wifi_hintdevice);
        }
    }

    public final void O000000o(Context context) {
        gsy.O00000Oo(LogType.KUAILIAN, "PushNewDeviceStep", "onCreateStep");
        super.O000000o(context);
    }

    public final void O00000o0(int i) {
        this.O00000Oo = true;
        this.O00000oO = -1;
        this.f903O000000o = 0;
        this.O00000o0 = (PushBindEntity) htr.O000000o().O000000o("aiot_wifi");
        htr.O000000o().O00000Oo("device_model", this.O00000o0.f11457O000000o.O00000Oo());
        htr.O000000o().O00000Oo("key_report_hash_mac", this.O00000o0.O00000o);
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "PushNewDeviceStep", "startConnection:" + this.O00000o0);
        htq.O000000o().O000000o(this.O00000o0.f11457O000000o.O00000Oo(), this.O00000o0.O00000Oo, this.O00000o0.O00000o0, this.O00000o0.O00000o, new hua<JSONObject, hud>() {
            /* class _m_j.hwp.AnonymousClass2 */

            public final void O000000o(hud hud) {
                gsy.O00000Oo(LogType.KUAILIAN, "PushNewDeviceStep", "startConnection.onFailure");
                hwp.this.O0000oOO();
            }

            public final /* synthetic */ void O000000o(Object obj) {
                hwp.this.x_().postDelayed(hwp.this.O00000o, 4000);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.hwp.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    public final SmartConfigStep.Step O00000o(int i) {
        this.O00000Oo = false;
        gsy.O00000Oo(LogType.KUAILIAN, "PushNewDeviceStep", "onStageTimeOut index:".concat(String.valueOf(i)));
        O00000oO(i - 1);
        if (i == 0) {
            this.O000OoOo = "3000.7.1";
            O000000o((int) R.string.kuailian_phone_connect_device_fail, (int) R.string.kuailian_phone_connect_device_fail, (int) R.drawable.common_bind_device_has_binded_failed);
        } else if (i == 1) {
            this.O000OoOo = "3000.7.2";
            O000000o((int) R.string.kuailian_phone_sendmessage_fail, (int) R.string.ble_combo_device_title_error, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 2) {
            this.O000OoOo = "3000.7.3";
            O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.ble_combo_device_title_error, (int) R.drawable.common_bind_device_connect_network_failed);
        }
        O000000o(false, 0, (SmartConfigStep.Step) null);
        this.O000O0o0.setCommonBtnText(this.O000O0oo.getString(R.string.push_changewifi_fail_rechose));
        this.O000O0o0.setCommonBtnListener(new View.OnClickListener() {
            /* class _m_j.hwp.AnonymousClass3 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(hwp.this.O000O0oo, "ResetDevicePage").O000000o("model", hwp.this.O00000o0.f11457O000000o.O00000Oo()).O000000o(101));
            }
        });
        SmartConfigRouterFactory.getSmartConfigManager().addBlackList(this.O00000o0);
        return null;
    }

    public final void z_() {
        this.f903O000000o = 0;
    }

    public final int O00000Oo() {
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "PushNewDeviceStep", "getCurrentStageIndex mCurrentIndex:" + this.f903O000000o);
        return this.f903O000000o;
    }

    public final void O0000O0o() {
        htr.O000000o().O00000Oo("mi_router_info", null);
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "PushNewDeviceStep", "onFinishStep mCurrentIndex:" + this.f903O000000o);
        super.O0000O0o();
    }

    public final void B_() {
        this.O000O0o0.O000000o();
        this.O000O0o0.O000000o((int) R.string.wifi_recongise_device, (int) R.string.wifi_add_device);
        this.O000O0o0.O000000o(1);
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        ((Activity) this.O000O0oo).setResult(i2, intent);
        O000O0o();
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwp.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hwp.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
