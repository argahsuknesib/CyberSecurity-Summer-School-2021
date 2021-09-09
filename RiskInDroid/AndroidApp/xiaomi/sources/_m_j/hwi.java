package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.qrcode2.ScanBarcodeActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class hwi extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    View f862O000000o;
    View O00000Oo;
    private String O00000o;
    TextView O00000o0;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final void O00000Oo() {
        SmartConfigRouterFactory.getSmartConfigManager().checkPassedForCamera((Activity) this.O000O0oo, true, new huf() {
            /* class _m_j.$$Lambda$hwi$t2YZ6GZizvvo5NyINct0N9e92VQ */

            public final void accept(String str) {
                hwi.this.O000000o(str);
            }
        });
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        if (this.O000Ooo0) {
            dcp.O000000o().O000000o(false);
        }
        if (i == 100 && i2 == -1) {
            String stringExtra = intent.getStringExtra("sc_device");
            if (!TextUtils.isEmpty(stringExtra)) {
                Uri parse = Uri.parse(stringExtra);
                this.O00000o = parse.getQueryParameter("did");
                gsy.O00000Oo("BleScScanStep", "parseQrCode did = " + this.O00000o);
                String str = new String(Base64.decode(parse.getQueryParameter("url"), 0));
                gsy.O00000Oo("BleScScanStep", "parseQrCode loginUrl = ".concat(str));
                if (!TextUtils.isEmpty(str)) {
                    htr.O000000o().O00000Oo("sc_ble_login_url", str);
                    G_();
                }
            }
        }
    }

    public final boolean G_() {
        O000O0o();
        return true;
    }

    public final void O000000o(Context context) {
        if (this.O000Ooo0) {
            O000000o(context, (int) R.layout.miconnect_ble_sc_scan_step_layout);
            this.O00000o0 = (TextView) this.O000O0oO.findViewById(R.id.common_bottom_tv);
            this.O00000o0.setText((int) R.string.sc_scan_btn_text);
            this.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hwi.AnonymousClass1 */

                public final void onClick(View view) {
                    hwi.this.O00000Oo();
                }
            });
            this.O000O0oO.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hwi.AnonymousClass2 */

                public final void onClick(View view) {
                    hwi.this.O000O0o();
                }
            });
            return;
        }
        O000000o(context, (int) R.layout.smart_config_ble_sc_scan_ui);
        this.f862O000000o = this.O000O0oO.findViewById(R.id.title_bar);
        gwg.O000000o(this.f862O000000o);
        this.O00000Oo = this.O000O0oO.findViewById(R.id.module_a_3_return_btn);
        this.O00000o0 = (TextView) this.O000O0oO.findViewById(R.id.common_btn);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hwi.AnonymousClass3 */

            public final void onClick(View view) {
                hwi.this.G_();
            }
        });
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hwi.AnonymousClass4 */

            public final void onClick(View view) {
                hwi.this.O00000Oo();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str) {
        if (this.O000Ooo0) {
            dcp.O000000o().O000000o(true);
        }
        fbs.O000000o(new fbt(this.O000O0oo, ScanBarcodeActivity.TAG).O000000o("from", 300).O000000o(100));
    }
}
