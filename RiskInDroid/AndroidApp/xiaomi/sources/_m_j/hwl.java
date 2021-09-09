package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.qrcode.QrCodeParser;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class hwl extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f875O000000o;
    public String O00000Oo;
    private int O00000o;
    public byte O00000o0;
    private QrCodeParser O00000oO;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void z_() {
    }

    public final ArrayList<gke> O0000Oo0() {
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        arrayList.add(gke);
        return arrayList;
    }

    public final void O000000o(Context context) {
        gnk.O00000o0("NbiotStep is onCreateStep");
        this.O00000oO = new QrCodeParser((String) htr.O000000o().O000000o("scan_qr_code"));
        super.O000000o(context);
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 263) {
            O000000o(this.O00000oO);
        } else if (i != 264) {
            super.O000000o(message);
        } else {
            O000000o(this.O00000Oo, this.O00000oO);
        }
    }

    public final void O00000o0(int i) {
        this.O00000o = i;
        if (this.O00000o == 0) {
            this.O000O0o0.setCurrentIndex(0);
            if (this.O00000oO.f6584O000000o == QrCodeParser.QrCodeType.NBIOT) {
                O000000o(this.O00000oO);
            } else {
                b_(false);
            }
        }
    }

    private void O000000o(final QrCodeParser qrCodeParser) {
        gsy.O00000Oo(LogType.KUAILIAN, "NbiotStep", "response requestBindKey:".concat(String.valueOf(qrCodeParser)));
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class _m_j.hwl.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                hwl hwl = hwl.this;
                hwl.f875O000000o = 0;
                hwl.O00000Oo = str;
                hwl.O000000o(str, qrCodeParser);
            }

            public final void O000000o(hud hud) {
                hwl hwl = hwl.this;
                int i = hwl.f875O000000o;
                hwl.f875O000000o = i + 1;
                if (i < 3) {
                    hwl.this.x_().sendEmptyMessageDelayed(263, 3000);
                    return;
                }
                hwl.this.O000Oo0O.push(new hxy(0, hwl.this.O000OOOo, hwl.this.O0000O0o(5101), "", true));
                hwl hwl2 = hwl.this;
                hwl2.O00000o0 = 1;
                hwl2.O0000oOO();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
    public final void O000000o(String str, QrCodeParser qrCodeParser) {
        byte[] bArr;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(qrCodeParser.O00000o.O00000Oo.getBytes(), "HmacSHA256"));
            bArr = instance.doFinal(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            Log.e("NbiotStep", "fatal", e);
            bArr = null;
            if (bArr != null) {
            }
            this.O00000o0 = 5;
            this.O000Oo0O.push(new hxy(0, this.O000OOOo, O0000O0o(5201), "", true));
            O0000oOO();
            return;
        } catch (Exception e2) {
            Log.e("NbiotStep", "fatal", e2);
            bArr = null;
            if (bArr != null) {
            }
            this.O00000o0 = 5;
            this.O000Oo0O.push(new hxy(0, this.O000OOOo, O0000O0o(5201), "", true));
            O0000oOO();
            return;
        }
        if (bArr != null || bArr.length == 0) {
            this.O00000o0 = 5;
            this.O000Oo0O.push(new hxy(0, this.O000OOOo, O0000O0o(5201), "", true));
            O0000oOO();
            return;
        }
        htq.O000000o().O00000Oo(qrCodeParser.O00000o0.O00000Oo, str, got.O00000o0(bArr), new hua<JSONObject, hud>() {
            /* class _m_j.hwl.AnonymousClass2 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                gsy.O00000Oo(LogType.KUAILIAN, "NbiotStep", "response bindNbIotDevice:".concat(String.valueOf(jSONObject)));
                hwl.this.f875O000000o = 0;
                String optString = jSONObject.optString("did");
                if (TextUtils.isEmpty(optString)) {
                    hwl.this.O00000o0 = 6;
                    hwl.this.O000Oo0O.push(new hxy(0, hwl.this.O000OOOo, hwl.this.O0000O0o(5301), "", true));
                    hwl.this.O0000oOO();
                    return;
                }
                hwl hwl = hwl.this;
                hwl.O000OoO0 = true;
                hwl.O000000o(optString);
            }

            public final void O000000o(hud hud) {
                hwl hwl = hwl.this;
                int i = hwl.f875O000000o;
                hwl.f875O000000o = i + 1;
                if (i < 2) {
                    hwl.this.x_().sendEmptyMessageDelayed(264, 2000);
                    return;
                }
                try {
                    int optInt = new JSONObject(hud.O00000o0).optJSONObject("result").optInt("status");
                    if (optInt == -11) {
                        hwl.this.O00000o0 = 2;
                    } else if (optInt == -12) {
                        hwl.this.O00000o0 = 7;
                    } else {
                        hwl.this.O00000o0 = 4;
                    }
                    hwl.this.O000Oo0O.push(new hxy(0, hwl.this.O000OOOo, hwl.this.O0000O0o(5400 - optInt), "", true));
                } catch (Throwable unused) {
                    hwl.this.O00000o0 = 4;
                }
                hwl.this.O0000oOO();
            }
        });
    }

    public final void O000000o(final String str) {
        gnk.O00000o0(String.format("getDeviceInfo did = %s", str));
        htq.O000000o().O000000o(SmartConfigRouterFactory.getSmartConfigManager().getAppContext(), new String[]{str}, new hua<List<Device>, hud>() {
            /* class _m_j.hwl.AnonymousClass3 */

            public final /* synthetic */ void O000000o(Object obj) {
                List<Device> list = (List) obj;
                gnk.O00000o0(String.format("onSuccess size = %d", Integer.valueOf(list.size())));
                if (list.size() > 0) {
                    Device O000000o2 = fno.O000000o().O000000o(str);
                    if (O000000o2 != null) {
                        fno.O000000o().O00000Oo(O000000o2);
                    }
                    for (Device device : list) {
                        if (str.equals(device.did)) {
                            O000000o2 = device;
                        }
                    }
                    fno.O000000o().O000000o(O000000o2);
                    htk.O000000o();
                    htk.O00000Oo(str);
                    htr.O000000o().O00000Oo("connected_device", O000000o2);
                }
                hwl.this.e_(0);
            }

            public final void O000000o(hud hud) {
                gnk.O00000o0(String.format("onFailure %s", hud));
                hwl.this.e_(0);
            }
        });
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
        gnk.O00000o0(String.format("onStageTimeOut index = %d", Integer.valueOf(i)));
        if (i == 0) {
            byte b = this.O00000o0;
            if (b == 2) {
                O000000o((int) R.string.ble_new_auth_step_failed, (int) R.string.binding_scurity_nodevice, (int) R.drawable.common_bind_nodevice);
            } else if (b != 7) {
                this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_auth_step_success, (int) R.string.keep_phone_wifi_connect);
                this.O000O0o0.O000000o((int) R.string.ble_new_bind_step_loading, (int) R.string.keep_phone_wifi_connect);
                O000000o((int) R.string.device_bind_fail, (int) R.string.phone_wifi_error, (int) R.drawable.common_bind_device_has_binded_failed);
            } else {
                this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_auth_step_success, (int) R.string.keep_phone_wifi_connect);
                this.O000O0o0.O000000o((int) R.string.ble_new_bind_step_loading, (int) R.string.keep_phone_wifi_connect);
                O000000o((int) R.string.ble_new_bind_step_failed, (int) R.string.verifying_qrcode_same_device, (int) R.drawable.common_bind_device_has_binded_failed);
            }
            O000000o(false, 0, (SmartConfigStep.Step) null);
        }
        return null;
    }

    public final int O00000Oo() {
        gnk.O00000o0(String.format("getCurrentStageIndex return 0", new Object[0]));
        return 0;
    }

    public final void O0000O0o() {
        gnk.O00000o0(String.format("onFinishStep QRCodeStep", new Object[0]));
        x_().removeMessages(124);
        htk.O000000o().O00000Oo();
        if (!this.O000OoO0 && !this.O000Oo0O.isEmpty()) {
            hxy hxy = (hxy) this.O000Oo0O.pop();
            if (hxy != null && hxy.O00000oO) {
                hxy.O0000OoO = this.O00000Oo;
                if (eyr.O00000Oo().O00000o0(hxy.O00000Oo)) {
                    SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
                }
            }
            this.O000Oo0O.clear();
        }
        super.O0000O0o();
    }

    public final void B_() {
        super.B_();
        this.O000O0o0.O000000o((int) R.string.binding_device_scurity, (int) R.string.keep_phone_wifi_connect);
        this.O000O0o0.O000000o(4);
    }

    public final void C_() {
        super.C_();
        if (this.O00000o == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_auth_step_success, (int) R.string.keep_phone_wifi_connect);
            this.O000O0o0.O000000o((int) R.string.ble_new_bind_step_loading, (int) R.string.keep_phone_wifi_connect);
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.device_bind_success, (int) R.string.keep_phone_wifi_connect);
        }
    }

    public final void s_() {
        super.s_();
        this.O000O0o0.O000000o((int) R.string.binding_device_scurity, (int) R.string.keep_phone_wifi_connect);
        this.O000O0o0.O000000o(4);
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwl.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    hwl.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
