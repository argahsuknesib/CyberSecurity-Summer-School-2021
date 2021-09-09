package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;

public class hwj extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f867O000000o;
    private String O00000Oo;
    private String O00000o0;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final SmartConfigStep.Step O00000o(int i) {
        return null;
    }

    public final ArrayList<gke> O0000Oo0() {
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 10;
        arrayList.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        return arrayList;
    }

    public final void O000000o(Context context) {
        gnk.O00000o0("GatewaySubdeviceStep is onCreateStep");
        this.O00000o0 = (String) htr.O000000o().O000000o("bind_device_did");
        htr.O000000o().O000000o("scan_qr_code");
        this.O00000Oo = (String) htr.O000000o().O000000o("device_model");
        super.O000000o(context);
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 111) {
            super.O000000o(message);
        } else if (i != 263 && i == 264) {
        }
    }

    public final void O00000o0(int i) {
        Device O000000o2 = fno.O000000o().O000000o(this.O00000o0);
        gsy.O00000Oo("GatewaySubdeviceStep", "did:" + this.O00000o0 + " device:" + O000000o2);
        htr.O000000o().O00000Oo("connected_device", O000000o2);
        this.O000O0o0.O000000o((int) R.string.ble_new_bind_step_loading, (int) R.string.gateway_online_check);
        this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.device_bind_success, (int) R.string.gateway_online_check);
        e_(0);
    }

    public final void z_() {
        this.f867O000000o = 0;
    }

    public final int O00000Oo() {
        gnk.O00000o0(String.format("getCurrentStageIndex return 0", new Object[0]));
        return this.f867O000000o;
    }

    public final void O0000O0o() {
        gnk.O00000o0(String.format("onFinishStep GatewaySubdeviceStep", new Object[0]));
        x_().removeMessages(264);
        super.O0000O0o();
    }

    public final void B_() {
        super.B_();
    }

    public final void C_() {
        super.C_();
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwj.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hwj.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
