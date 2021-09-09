package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.Error;
import com.xiaomi.smarthome.plugin.devicesubscribe.PluginSubscribeCallback;
import com.xiaomi.smarthome.plugin.devicesubscribe.PluginUnSubscribeCallback;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class gbc {

    /* renamed from: O000000o  reason: collision with root package name */
    public HandlerThread f17487O000000o;
    public Handler O00000Oo;
    DeviceStat O00000o;
    public O000000o O00000o0;
    List<String> O00000oO = new ArrayList();
    public String O00000oo;

    public interface O000000o {
        void O000000o(String str, String str2, JSONArray jSONArray);
    }

    public gbc(DeviceStat deviceStat, O000000o o000000o) {
        this.O00000o = deviceStat;
        this.O00000o0 = o000000o;
        this.O00000oO.add("event.dev_online");
        this.O00000oO.add("event.dev_offline");
        this.f17487O000000o = new HandlerThread("RnDevicePropSubscriber");
        this.f17487O000000o.start();
        this.O00000Oo = new Handler(this.f17487O000000o.getLooper()) {
            /* class _m_j.gbc.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    gbc gbc = gbc.this;
                    if (gbc.O00000o != null) {
                        XmPluginHostApi.instance().subscribeDeviceV2(gbc.O00000o.did, gbc.O00000o.pid, gbc.O00000oO, 10, new PluginSubscribeCallback() {
                            /* class _m_j.gbc.AnonymousClass2 */

                            public final void onSuccess(String str) {
                                if (!TextUtils.isEmpty(gbc.this.O00000oo) && !gbc.this.O00000oo.equals(str)) {
                                    gbc.this.O000000o();
                                }
                                gbc.this.O00000oo = str;
                                gbu.O000000o("RnDevicePropSubscriber  subscribeDevice onSuccess...  subId=".concat(String.valueOf(str)));
                            }

                            public final void onFailure(Error error) {
                                gbu.O00000Oo("RnDevicePropSubscriber  subscribeDevice  onFailure..." + error.toString());
                                gbc gbc = gbc.this;
                                gbc.O00000oo = "";
                                gbc.O00000Oo.sendMessageDelayed(gbc.this.O00000Oo.obtainMessage(1), 5000);
                            }

                            public final void onReceive(String str, String str2, JSONArray jSONArray) {
                                gbu.O000000o("RnDevicePropSubscriber  onReceive:  " + jSONArray.toString());
                                if (gbc.this.O00000o0 != null) {
                                    gbc.this.O00000o0.O000000o(str, str2, jSONArray);
                                }
                            }
                        });
                    }
                }
            }
        };
        Handler handler = this.O00000Oo;
        handler.sendMessageDelayed(handler.obtainMessage(1), 5000);
        gbu.O000000o("RnDevicePropSubscriber  init...");
    }

    public final void O000000o() {
        if (this.O00000o != null && !TextUtils.isEmpty(this.O00000oo)) {
            XmPluginHostApi.instance().unsubscribeDeviceV2(this.O00000o.did, this.O00000o.pid, this.O00000oO, this.O00000oo, new PluginUnSubscribeCallback() {
                /* class _m_j.gbc.AnonymousClass3 */

                public final void onSuccess() {
                    gbu.O000000o("RnDevicePropSubscriber  unsubscribeMessages...");
                }

                public final void onFailure(Error error) {
                    gbu.O00000Oo("RnDevicePropSubscriber  unsubscribeMessages..." + error.toString());
                }
            });
        }
    }
}
