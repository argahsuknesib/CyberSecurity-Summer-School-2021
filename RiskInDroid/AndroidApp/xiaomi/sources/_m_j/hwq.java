package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;

public class hwq extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    String f910O000000o;
    public int O00000Oo;
    private String O00000o0;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void z_() {
    }

    public final ArrayList<gke> O0000Oo0() {
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 50000;
        arrayList.add(gke);
        return arrayList;
    }

    public final void O000000o(Context context) {
        this.O000Ooo = hwq.class.getName();
        this.O00000o0 = (String) htr.O000000o().O000000o("device_model");
        O000000o(String.format("model is %s", this.O00000o0), new Object[0]);
        super.O000000o(context);
    }

    public final void O000000o(Message message) {
        int i = message.what;
        super.O000000o(message);
    }

    private boolean O0000o0o() {
        return !TextUtils.isEmpty(this.O00000o0) && DeviceFactory.O0000oo0(this.O00000o0);
    }

    public final void O00000o0(int i) {
        String str;
        O000000o(String.format("startConnection index = %d, fromXiaoxun = %b", Integer.valueOf(i), Boolean.valueOf(O0000o0o())), new Object[0]);
        this.O00000Oo = i;
        if (this.O00000Oo == 0) {
            this.O000O0o0.setCurrentIndex(0);
            if (!O0000o0o() && (str = (String) htr.O000000o().O000000o("scan_qr_code")) != null) {
                if (TextUtils.isEmpty(str)) {
                    b_(false);
                    return;
                }
                this.f910O000000o = str;
            }
            if (O0000o0o()) {
                x_().postDelayed(new Runnable() {
                    /* class _m_j.hwq.AnonymousClass1 */

                    public final void run() {
                        hwq hwq = hwq.this;
                        hwq.e_(hwq.O00000Oo);
                    }
                }, 5000);
                return;
            }
            final String str2 = this.f910O000000o;
            if (str2 != null) {
                O000000o(String.format("getDeviceInfo did = %s", gnj.O000000o(str2)), new Object[0]);
                htq.O000000o().O000000o(this.O000O0oo, new String[]{str2}, new hua<List<Device>, hud>() {
                    /* class _m_j.hwq.AnonymousClass2 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        List<Device> list = (List) obj;
                        hwq.this.O000000o(String.format("onSuccess size = %d", Integer.valueOf(list.size())), new Object[0]);
                        if (list.size() > 0) {
                            Device O000000o2 = fno.O000000o().O000000o(str2);
                            if (O000000o2 != null) {
                                fno.O000000o().O00000Oo(O000000o2);
                            }
                            for (Device device : list) {
                                if (device != null && str2.equals(device.did)) {
                                    O000000o2 = device;
                                }
                            }
                            fno.O000000o().O000000o(O000000o2);
                            htk.O000000o();
                            htk.O00000Oo(str2);
                            htr.O000000o().O00000Oo("connected_device", O000000o2);
                            hwq.this.e_(0);
                        }
                    }

                    public final void O000000o(hud hud) {
                        hwq.this.O000000o(String.format("onFailure %s", hud), new Object[0]);
                        hwq.this.e_(0);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, int, ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, com.xiaomi.smarthome.smartconfig.step.ConfigStep$O000000o, long):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, int, boolean):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, int):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void */
    public final SmartConfigStep.Step O00000o(int i) {
        O000000o(String.format("onStageTimeOut index = %d", Integer.valueOf(i)), new Object[0]);
        if (i == 0) {
            if (!hze.O000000o(this.O000O0oo)) {
                O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.phone_wifi_error, (int) R.drawable.common_bind_app_connect_network_failed);
            } else {
                O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.make_device_near_router, (int) R.drawable.common_bind_device_connect_network_failed);
            }
            htk.O000000o().O00000Oo();
            O000000o(false, 0, (SmartConfigStep.Step) null);
        }
        return null;
    }

    public final int O00000Oo() {
        O000000o(String.format("getCurrentStageIndex return 0", new Object[0]), new Object[0]);
        return 0;
    }

    public final void O0000O0o() {
        O000000o(String.format("onFinishStep QRCodeStep", new Object[0]), new Object[0]);
        x_().removeMessages(124);
        htk.O000000o().O00000Oo();
        super.O0000O0o();
    }

    public final void B_() {
        super.B_();
        this.O000O0o0.O000000o((int) R.string.connecting_device, (int) R.string.keep_phone_wifi_connect);
        this.O000O0o0.O000000o(3);
    }

    public final void C_() {
        super.C_();
        if (this.O00000Oo == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.device_bind_success, (int) R.string.keep_phone_wifi_connect);
        }
    }

    public final void s_() {
        super.s_();
        this.O000O0o0.O000000o((int) R.string.connecting_device, (int) R.string.keep_phone_wifi_connect);
        this.O000O0o0.O000000o(3);
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwq.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (htk.O000000o().O00000o) {
                        htk.O000000o().O00000Oo();
                    }
                    hwq.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
