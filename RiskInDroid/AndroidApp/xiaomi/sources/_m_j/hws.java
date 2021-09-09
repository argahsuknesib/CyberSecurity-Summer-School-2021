package _m_j;

import _m_j.htk;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.qrcode2.ScanBarcodeActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hws extends SmartConfigStep implements htk.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f921O000000o;
    AnimationDrawable O00000Oo;
    private int O00000o;
    private String O00000o0;
    private String O00000oO;
    private String O00000oo;
    private String O0000O0o;
    private TextView O0000OOo;
    private PieProgressBar O0000Oo;
    private ImageView O0000Oo0;
    private TextView O0000OoO;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
        if (message.what == 1827) {
            int i = message.arg1;
            if (i >= 0) {
                this.O0000OOo.setText(String.format("%d", Integer.valueOf(i)));
            }
            if (i >= 0) {
                Handler x_ = x_();
                Message obtainMessage = x_.obtainMessage(1827, i - 1, 0);
                this.O0000Oo.setPercent(((float) (60 - i)) / 0.6f);
                x_.sendMessageDelayed(obtainMessage, 1000);
                return;
            }
            htk.O000000o().O00000Oo();
            O000000o(SmartConfigStep.Step.STEP_XIAOXUN_ERROR);
        }
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.scan_barcode_connect_activity);
        gwg.O00000Oo(((Activity) this.O000O0oo).getWindow());
        this.f921O000000o = (String) htr.O000000o().O000000o("device_model");
        this.O0000OOo = (TextView) this.O000O0oO.findViewById(R.id.timing);
        this.O0000Oo0 = (ImageView) this.O000O0oO.findViewById(R.id.icon);
        this.O0000OoO = (TextView) this.O000O0oO.findViewById(R.id.tips);
        this.O0000Oo = (PieProgressBar) this.O000O0oO.findViewById(R.id.pbar);
        if (!(this.O000O0oo == null || ((Activity) this.O000O0oo).getIntent() == null)) {
            this.O00000o0 = ((Activity) this.O000O0oo).getIntent().getStringExtra("scan_result");
            if (!TextUtils.isEmpty(this.O00000o0)) {
                O000000o("ScanQRPrepareStep from scan entrance directly", new Object[0]);
                htr.O000000o().O00000Oo("scan_qr_code", this.O00000o0);
                if (O0000Oo()) {
                    O000000o("ScanQRPrepareStep is xiaoxun", new Object[0]);
                    O000000o(this.O00000o0);
                    return;
                }
                x_().postDelayed(new Runnable() {
                    /* class _m_j.hws.AnonymousClass1 */

                    public final void run() {
                        hws.this.O000O0o();
                    }
                }, 10);
            }
        }
        if (TextUtils.isEmpty(this.O00000o0)) {
            SmartConfigRouterFactory.getSmartConfigManager().checkPassedForCamera((Activity) context, true, new huf() {
                /* class _m_j.$$Lambda$hws$SWV7K92YL7kgNNbLQGQ85kxhlLQ */

                public final void accept(String str) {
                    hws.this.O00000Oo(str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(String str) {
        fbs.O000000o(new fbt(this.O000O0oo, ScanBarcodeActivity.TAG).O000000o("model", this.f921O000000o).O000000o("from", 100).O000000o(100));
    }

    private void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            b_(false);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.O00000oO = jSONObject.optString("sid");
            this.O00000oo = jSONObject.optString("did");
            this.O0000O0o = jSONObject.optString("nickname");
            this.O00000o = jSONObject.optInt("bindType", -1);
            if (!TextUtils.isEmpty(this.O00000oo)) {
                if (this.O00000o != -1) {
                    O00000o();
                    return;
                }
            }
            this.O000Oo0O.push(new hxy(0, this.f921O000000o, O0000O0o(6103), "", true));
            O000000o(SmartConfigStep.Step.STEP_XIAOXUN_ERROR);
        } catch (JSONException e) {
            e.printStackTrace();
            b_(false);
        }
    }

    private void O00000o() {
        this.O000O0oO.setBackgroundColor(Color.parseColor("#fe6e46"));
        int i = this.O00000o;
        if (i == 0) {
            this.O0000Oo0.setVisibility(0);
            this.O0000Oo0.setBackgroundResource(R.drawable.xiaoxun_frame);
            this.O0000OoO.setText((int) R.string.xiaoxun_tips_1);
            this.O00000Oo = (AnimationDrawable) this.O0000Oo0.getBackground();
            this.O0000Oo.setVisibility(8);
            this.O00000Oo.start();
        } else if (i == 1) {
            this.O0000Oo0.setVisibility(8);
            this.O0000Oo.setVisibility(0);
            TextView textView = this.O0000OoO;
            Context context = this.O000O0oo;
            String str = this.O0000O0o;
            textView.setText(context.getString(R.string.xiaoxun_tips_2, str, str));
        }
        O0000Oo0();
        O00000Oo();
    }

    private void O0000Oo0() {
        Handler x_ = x_();
        x_.sendMessage(x_.obtainMessage(1827, 60, 0));
    }

    public final void O00000Oo() {
        gnk.O00000o0(String.format("scanXiaoxunWatch model = %s, sid = %s, did = %s", this.f921O000000o, this.O00000oO, this.O00000oo));
        if (this.O000OO00) {
            gnk.O00000o0(String.format("isFinished %b", Boolean.valueOf(this.O000OO00)));
            return;
        }
        htk.O000000o().O000000o(new htm() {
            /* class _m_j.hws.AnonymousClass2 */

            public final void onDeviceConnectionFailure(int i) {
                if (i == -9) {
                    hws.this.O000Oo0O.push(new hxy(0, hws.this.f921O000000o, hws.this.O0000O0o(6104), "", true));
                    hws.this.O000000o(SmartConfigStep.Step.STEP_XIAOXUN_ERROR);
                }
            }

            public final void onDeviceConnectionSuccess(List<Device> list) {
                gnk.O00000o0(String.format("onDeviceConnectionSuccess", new Object[0]));
                if (list != null) {
                    for (Device next : list) {
                        gnk.O00000o0(String.format("name = %s, did = %s", next.name, next.did));
                    }
                }
                hws hws = hws.this;
                if (hws.O00000Oo != null) {
                    hws.O00000Oo.stop();
                }
                hws.x_().removeMessages(1827);
                hws hws2 = hws.this;
                hws2.O000OoO0 = true;
                hws2.O000O0o();
            }

            public final void onDeviceConnectionFailure() {
                gnk.O00000o0(String.format("onDeviceConnectionFailure", new Object[0]));
                if (hws.this.x_().hasMessages(1827)) {
                    hws.this.O00000Oo();
                    return;
                }
                hws.this.O000Oo0O.push(new hxy(0, hws.this.f921O000000o, hws.this.O0000O0o(6105), "", true));
                hws.this.O000000o(SmartConfigStep.Step.STEP_XIAOXUN_ERROR);
            }
        }, this.f921O000000o, this.O00000oO, this.O00000oo, this);
    }

    private boolean O0000Oo() {
        return !TextUtils.isEmpty(this.f921O000000o) && DeviceFactory.O0000oo0(this.f921O000000o);
    }

    public final void O000000o(int i, int i2, Intent intent) {
        if (i != 100) {
            return;
        }
        if (i2 == -1) {
            this.O00000o0 = intent.getStringExtra("scan_result");
            htr.O000000o().O00000Oo("scan_qr_code", this.O00000o0);
            if (O0000Oo()) {
                O000000o(this.O00000o0);
            } else {
                O000O0o();
            }
        } else {
            b_(false);
        }
    }

    public final void O0000O0o() {
        gnk.O00000o0(String.format("onFinishStep", new Object[0]));
        if (O0000Oo()) {
            x_().removeCallbacksAndMessages(null);
            htk.O000000o().O00000Oo();
        }
        if (!this.O000OoO0 && !this.O000Oo0O.isEmpty()) {
            hxy hxy = (hxy) this.O000Oo0O.pop();
            if (hxy != null && hxy.O00000oO && eyr.O00000Oo().O00000o0(hxy.O00000Oo)) {
                SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
            }
            this.O000Oo0O.clear();
        }
    }

    public final void O000000o(String str, String str2, hua<List<Device>, hud> hua) {
        htq O000000o2 = htq.O000000o();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put("sid", str);
                jSONObject.put("did", str2);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o3 = o000000o.O000000o("/home/pseudo_device_new");
        O000000o3.O00000o0 = arrayList;
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3.O000000o(), new huc(new hub<List<Device>>() {
            /* class _m_j.htq.AnonymousClass25 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                gnk.O00000o0(String.format("/app/home/pseudo_device_new: %s", jSONObject));
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        Device O000000o2 = DeviceFactory.O000000o(optJSONArray.getJSONObject(i));
                        if (O000000o2 != null) {
                            arrayList.add(O000000o2);
                        }
                    }
                }
                return arrayList;
            }
        }, hua) {
            /* class _m_j.htq.AnonymousClass26 */

            /* renamed from: O000000o */
            final /* synthetic */ hub f665O000000o;
            final /* synthetic */ hua O00000Oo;

            {
                this.f665O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, this.f665O000000o, this.O00000Oo);
            }

            public final void O000000o(int i, String str) {
                hua hua = this.O00000Oo;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public final boolean G_() {
        b_(false);
        return true;
    }
}
