package com.xiaomi.smarthome.wificonfig;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ChangeNewWifiActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        setContentView((int) R.layout.change_new_router);
        final String string = getIntent().getExtras().getString("did");
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.ChangeNewWifiActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ChangeNewWifiActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_right_text_btn)).setText((int) R.string.mj_complete);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.wifi_input_wifi);
        findViewById(R.id.module_a_3_right_text_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.ChangeNewWifiActivity.AnonymousClass2 */

            public final void onClick(View view) {
                for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
                    Device device = (Device) value.getValue();
                    if (device.did.equalsIgnoreCase(string)) {
                        String obj = ((EditText) ChangeNewWifiActivity.this.findViewById(R.id.ssid_editor)).getText().toString();
                        String obj2 = ((EditText) ChangeNewWifiActivity.this.findViewById(R.id.passwd_editor)).getText().toString();
                        MiioDeviceV2 miioDeviceV2 = (MiioDeviceV2) device;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("method", "miIO.config_router");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("ssid", obj);
                            jSONObject2.put("passwd", obj2);
                            jSONObject.put("params", jSONObject2);
                        } catch (JSONException unused) {
                        }
                        CoreApi.O000000o().O000000o(miioDeviceV2.did, miioDeviceV2.token, jSONObject.toString(), (fsm<JSONObject, fso>) null);
                        ChangeNewWifiActivity.this.finish();
                    }
                }
            }
        });
    }
}
