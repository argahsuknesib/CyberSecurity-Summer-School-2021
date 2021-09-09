package com.xiaomi.smarthome.framework.page;

import _m_j.be;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gwg;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.OfflineViewDelegate;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import java.text.NumberFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceNetworkInfoActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f7733O000000o;
    protected Device O00000Oo;
    boolean O00000o0 = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = 0;
        this.O00000o0 = false;
        overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        this.f7733O000000o = this;
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.device_network_activity);
        String stringExtra = getIntent().getStringExtra("did");
        this.O00000Oo = fno.O000000o().O000000o(stringExtra);
        if (this.O00000Oo == null) {
            this.O00000Oo = fno.O000000o().O00000Oo(stringExtra);
            if (this.O00000Oo == null) {
                finish();
                return;
            }
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceNetworkInfoActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DeviceNetworkInfoActivity.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (textView != null) {
            textView.setText((int) R.string.device_more_activity_network_info);
        }
        TextView textView2 = (TextView) findViewById(R.id.wifi_name);
        if (textView2 != null) {
            textView2.setText(this.O00000Oo.ssid);
        }
        TextView textView3 = (TextView) findViewById(R.id.wifi_signal);
        if (this.O00000Oo.rssi >= -30) {
            i = 100;
        } else if (this.O00000Oo.rssi > -85) {
            i = ((Math.abs(-85) + this.O00000Oo.rssi) * 100) / 55;
        }
        if (textView3 != null) {
            String language = getResources().getConfiguration().locale.getLanguage();
            if (TextUtils.isEmpty(language) || !language.contains("tr")) {
                textView3.setText(i + "%");
            } else {
                textView3.setText("%".concat(String.valueOf(i)));
            }
        }
        TextView textView4 = (TextView) findViewById(R.id.rssi);
        if (textView4 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.O00000Oo.rssi);
            textView4.setText(sb.toString());
        }
        TextView textView5 = (TextView) findViewById(R.id.network_type);
        if (textView5 != null) {
            textView5.setText((int) R.string.network_info_loading);
        }
        if (this.O00000Oo instanceof CameraDevice) {
            XmPluginHostApi.instance().callHttpApiV13("yunyi.camera.v1", "http://" + this.O00000Oo.ip + "/cgi-bin/isxiaoyi.cgi", "GET", null, new Callback<String>() {
                /* class com.xiaomi.smarthome.framework.page.DeviceNetworkInfoActivity.AnonymousClass2 */

                public final void onFailure(int i, String str) {
                    TextView textView;
                    if (DeviceNetworkInfoActivity.this.isValid() && (textView = (TextView) DeviceNetworkInfoActivity.this.findViewById(R.id.network_type)) != null) {
                        textView.setText((int) R.string.network_info_extranet);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    TextView textView;
                    if (DeviceNetworkInfoActivity.this.isValid() && (textView = (TextView) DeviceNetworkInfoActivity.this.findViewById(R.id.network_type)) != null) {
                        textView.setText((int) R.string.network_info_intranet);
                    }
                }
            }, new Parser<String>() {
                /* class com.xiaomi.smarthome.framework.page.DeviceNetworkInfoActivity.AnonymousClass3 */

                public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                    return str;
                }
            });
        } else {
            XmPluginHostApi.instance().localPing(this.O00000Oo.did, new Callback<Void>() {
                /* class com.xiaomi.smarthome.framework.page.DeviceNetworkInfoActivity.AnonymousClass4 */

                public final void onFailure(int i, String str) {
                    TextView textView;
                    if (DeviceNetworkInfoActivity.this.isValid() && (textView = (TextView) DeviceNetworkInfoActivity.this.findViewById(R.id.network_type)) != null) {
                        textView.setText((int) R.string.network_info_extranet);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (DeviceNetworkInfoActivity.this.isValid()) {
                        DeviceNetworkInfoActivity.this.O00000Oo.location = Device.Location.LOCAL;
                        TextView textView = (TextView) DeviceNetworkInfoActivity.this.findViewById(R.id.network_type);
                        if (textView != null) {
                            textView.setText((int) R.string.network_info_intranet);
                        }
                    }
                }
            });
        }
        TextView textView6 = (TextView) findViewById(R.id.network_ip);
        if (textView6 != null) {
            textView6.setText(this.O00000Oo.ip);
        }
        TextView textView7 = (TextView) findViewById(R.id.network_mac);
        if (textView7 != null) {
            textView7.setText(this.O00000Oo.mac);
        }
        final ImageView imageView = (ImageView) findViewById(R.id.iv_rssi_signal);
        final TextView textView8 = (TextView) findViewById(R.id.tv_rssi_details);
        final TextView textView9 = (TextView) findViewById(R.id.packet_loss_rate);
        OfflineViewDelegate.checkDeviceRssi(this, new fsm<be<Integer, JSONObject>, fso>() {
            /* class com.xiaomi.smarthome.framework.page.DeviceNetworkInfoActivity.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                be beVar = (be) obj;
                if (beVar != null && DeviceNetworkInfoActivity.this.isValid() && beVar.f12896O000000o != null && beVar.O00000Oo != null) {
                    imageView.setBackgroundResource(((Integer) beVar.f12896O000000o).intValue() == 0 ? R.drawable.weak_rssi_wifi_big_enable : R.drawable.weak_rssi_wifi_big_disable);
                    String optString = ((JSONObject) beVar.O00000Oo).optString("note");
                    if (!TextUtils.isEmpty(optString)) {
                        textView8.setText(optString);
                    }
                    double optDouble = ((JSONObject) beVar.O00000Oo).optDouble("lost_rate");
                    NumberFormat percentInstance = NumberFormat.getPercentInstance();
                    percentInstance.setMaximumFractionDigits(2);
                    textView9.setText(percentInstance.format(optDouble));
                }
            }

            public final void onFailure(fso fso) {
                if (!DeviceNetworkInfoActivity.this.isValid()) {
                }
            }
        }, this.O00000Oo.did, 1);
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000o0 = true;
    }
}
