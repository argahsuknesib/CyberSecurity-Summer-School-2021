package _m_j;

import _m_j.gov;
import _m_j.hvw;
import android.content.DialogInterface;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class hvw extends ConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public ScanResult f755O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public int O00000oO;
    public OkHttpClient O00000oo;
    public gov O0000O0o;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    hvw() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.O00000oo = builder.connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
        if (this.f755O000000o == null) {
            this.f755O000000o = (ScanResult) htr.O000000o().O000000o("device_ap");
            if (this.f755O000000o == null) {
                return;
            }
        }
        long longValue = ((Long) htr.O000000o().O000000o("start_time")).longValue();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", "input_password_duration");
            jSONObject.put("duration", System.currentTimeMillis() - longValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SmartConfigRouterFactory.getCoreApiManager().addStatRecord(StatType.PLUGIN, "mihome", "Task", jSONObject.toString(), null, false);
    }

    public final ArrayList<gke> O0000Oo0() {
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        arrayList.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        arrayList.add(gke2);
        gke gke3 = new gke();
        gke3.f17943O000000o = 2;
        gke3.O00000Oo = 25000;
        arrayList.add(gke3);
        gke gke4 = new gke();
        gke4.f17943O000000o = 3;
        gke4.O00000Oo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        arrayList.add(gke4);
        return arrayList;
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.ConfigStep.O000000o(boolean, int, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step):void
     arg types: [int, ?, com.xiaomi.smarthome.smartconfig.step.SmartConfigStep$Step]
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
        gov gov = this.O0000O0o;
        if (gov != null) {
            gov.O00000Oo();
        }
        if (i == 0) {
            O0000o0o();
            O000000o(false, 0, (SmartConfigStep.Step) null);
            return null;
        } else if (i != 1) {
            if (i == 2) {
                O0000o0o();
                O000000o(false, 0, (SmartConfigStep.Step) null);
                return null;
            } else if (i != 3) {
                return SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED;
            } else {
                O0000o0o();
                O000000o(false, 0, (SmartConfigStep.Step) null);
                return null;
            }
        } else if (!iag.O00000Oo(this.O000O0oo) || Settings.canDrawOverlays(this.O000O0oo)) {
            O0000o0o();
            if (TextUtils.isEmpty(this.O00000o0)) {
                O000000o(false, 0, (SmartConfigStep.Step) null);
                return null;
            }
            O000000o(true, (int) R.string.switch_router_manually, SmartConfigStep.Step.STEP_CONNECT_AP_ERROR);
            return null;
        } else {
            if (!(this.O00oOooO == null || this.O00oOooO.O00000o0 == null)) {
                this.O0000ooo.unregisterNetworkCallback(this.O00oOooO.O00000o0);
                this.O00oOooO.O00000o0 = null;
                this.O00oOooO = null;
            }
            return SmartConfigStep.Step.STEP_CONNECT_MIDR_AP_ERROR;
        }
    }

    public final void z_() {
        this.O00000oO = 0;
    }

    public final int O00000Oo() {
        return this.O00000oO;
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 101) {
            NetworkInfo networkInfo = (NetworkInfo) message.obj;
            NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
            WifiInfo connectionInfo = O0000ooO.getConnectionInfo();
            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>")) {
                O000000o("handle message network changed: current Index(0:connect ap; 1:config router; 3:search device)=%d, wifi state(CONNECTING, CONNECTED, SUSPENDED, DISCONNECTING, DISCONNECTED, UNKNOWN)=%s, wifi ssid =%s", Integer.valueOf(this.O00000oO), networkInfo.getState().name(), connectionInfo.getSSID());
                if (detailedState == NetworkInfo.DetailedState.CONNECTED && networkInfo.isConnected() && iag.O000000o(connectionInfo.getSSID(), ((ScanResult) htr.O000000o().O000000o("device_ap")).SSID) && !this.O000OO0o) {
                    if (this.O00000oO == 1) {
                        O000000o("handle message network changed, decide connect ap success", new Object[0]);
                        if (x_() != null) {
                            x_().postDelayed(new Runnable() {
                                /* class _m_j.hvw.AnonymousClass3 */

                                public final void run() {
                                    if (hvw.this.O00000oO == 1 && hvw.this.O000O00o()) {
                                        hvw hvw = hvw.this;
                                        hvw.e_(hvw.O00000oO);
                                        hvw.this.O00000o0(2);
                                    }
                                }
                            }, 2000);
                        }
                    }
                    x_().removeMessages(123);
                }
            }
        } else if (i != 126) {
            super.O000000o(message);
        } else {
            O0000oO0();
        }
    }

    public final void O00000o0(int i) {
        if (!this.O000OO00) {
            this.O00000oO = i;
            if (i == 0) {
                huw installInfo = SmartConfigRouterFactory.getCoreApiManager().getInstallInfo(DeviceFactory.O00000o(this.f755O000000o));
                if (installInfo == null) {
                    e_(this.O00000oO);
                    O00000o0(1);
                } else if (installInfo.O000000o()) {
                    e_(this.O00000oO);
                    O00000o0(1);
                } else {
                    SmartConfigRouterFactory.getCoreApiManager().downloadPlugin(DeviceFactory.O00000o(this.f755O000000o), new huh() {
                        /* class _m_j.hvw.AnonymousClass1 */
                        private long O00000Oo = 0;

                        public final void O000000o(float f) {
                        }

                        public final void O000000o() {
                            this.O00000Oo = System.currentTimeMillis();
                        }

                        public final void O000000o(String str) {
                            if (this.O00000Oo > 0) {
                                SmartConfigRouterFactory.getStatResultManager().app_stat_plugin_downTime(System.currentTimeMillis() - this.O00000Oo, str);
                            }
                            hvw hvw = hvw.this;
                            hvw.e_(hvw.O00000oO);
                            hvw.this.O00000o0(1);
                        }

                        public final void O00000Oo() {
                            hvw.this.O0000oOO();
                        }

                        public final void O00000o0() {
                            hvw.this.O0000oOO();
                        }
                    });
                }
            } else if (i == 1) {
                O0000o();
            } else if (i != 2) {
                if (i == 3) {
                    O0000oO0();
                }
            } else if (TextUtils.isEmpty(this.O00000o0)) {
                O0000o();
            } else {
                this.O00000oO = 2;
                if (gnn.O00000oO) {
                    Network network = null;
                    Network[] allNetworks = this.O0000ooo.getAllNetworks();
                    int i2 = 0;
                    while (true) {
                        if (i2 < allNetworks.length) {
                            NetworkInfo networkInfo = this.O0000ooo.getNetworkInfo(allNetworks[i2]);
                            if (networkInfo != null && networkInfo.getType() == 1) {
                                network = allNetworks[i2];
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    if (network == null) {
                        gsy.O000000o(6, "ERROR", "Get Network ERROR");
                    }
                    this.O0000ooo.bindProcessToNetwork(network);
                }
                gor.O000000o(new AsyncTask<Void, Void, Boolean>() {
                    /* class _m_j.hvw.AnonymousClass5 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        Boolean bool = (Boolean) obj;
                        if (gnn.O00000oO) {
                            hvw.this.O0000ooo.bindProcessToNetwork(null);
                        }
                        if (bool.booleanValue()) {
                            hvw hvw = hvw.this;
                            hvw.e_(hvw.O00000oO);
                            hvw hvw2 = hvw.this;
                            hvw2.O00000oO = 3;
                            hvw2.O0000o00();
                            hvw.this.x_().sendEmptyMessage(126);
                        }
                    }

                    private Boolean O000000o() {
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (hvw.this.O000OO00) {
                            return Boolean.FALSE;
                        }
                        try {
                            Response execute = hvw.this.O00000oo.newCall(new Request.Builder().url("http://" + hvw.this.O0000o0() + "/cgi-bin/Config.cgi?action=set&property=UserConfirm&value=10").build()).execute();
                            if (!execute.isSuccessful()) {
                                return Boolean.FALSE;
                            }
                            execute.body().string();
                            if (!execute.message().equals("OK")) {
                                return Boolean.FALSE;
                            }
                            if (hvw.this.O000OO00) {
                                return Boolean.FALSE;
                            }
                            try {
                                Response execute2 = hvw.this.O00000oo.newCall(new Request.Builder().url("http://" + hvw.this.O0000o0() + "/cgi-bin/Config.cgi?action=get&property=DidToken").build()).execute();
                                if (execute2.isSuccessful()) {
                                    String string = execute2.body().string();
                                    if (execute2.message().equals("OK")) {
                                        String[] split = string.split("\n");
                                        if (split.length > 0) {
                                            String str = split[split.length - 1];
                                            if (str.startsWith("DidToken=")) {
                                                String[] split2 = str.substring(9).split("\\+");
                                                if (split2.length == 2 && !TextUtils.isEmpty(split2[0]) && !split2[0].equals("null")) {
                                                    hvw.this.O00000o0 = split2[0];
                                                }
                                            }
                                        }
                                    }
                                }
                                if (!TextUtils.isEmpty(hvw.this.O00000o0) && hvw.this.O00000o0.equals("null")) {
                                    return Boolean.FALSE;
                                }
                                if (hvw.this.O000OO00) {
                                    return Boolean.FALSE;
                                }
                                try {
                                    execute2 = hvw.this.O00000oo.newCall(new Request.Builder().url("http://" + hvw.this.O0000o0() + "/cgi-bin/Config.cgi?action=set&property=DidToken&value=" + hvw.this.O00000o0 + "+" + hvw.this.O00000o).build()).execute();
                                    if (execute2.isSuccessful()) {
                                        String message = execute2.message();
                                        String string2 = execute2.body().string();
                                        if (message.equals("OK")) {
                                            if (!string2.startsWith("709")) {
                                                Boolean bool = Boolean.TRUE;
                                                gpg.O000000o(execute2);
                                                return bool;
                                            }
                                        }
                                        Boolean bool2 = Boolean.FALSE;
                                        gpg.O000000o(execute2);
                                        return bool2;
                                    }
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                } catch (Throwable th) {
                                    gpg.O000000o(execute2);
                                    throw th;
                                }
                                gpg.O000000o(execute2);
                                return Boolean.FALSE;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return Boolean.FALSE;
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return Boolean.FALSE;
                        }
                    }
                }, new Void[0]);
            }
        }
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.kuailian_init_plugin, (int) R.string.keep_phone_wifi_connect);
        this.O000O0o0.O000000o(0);
    }

    public final void C_() {
        int i = this.O00000oO;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_init_plugin_success, (int) R.string.keep_phone_wifi_connect);
            this.O000O0o0.O000000o((int) R.string.kuailian_phone_connect_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(1);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_connect_device_success, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o((int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o(2);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_phone_sendmessage_success, (int) R.string.kuailian_phone_connect_device_des);
            this.O000O0o0.O000000o((int) R.string.kuailian_device_connect_wifi, (int) R.string.make_device_near_router);
            this.O000O0o0.O000000o(3);
        } else if (i == 3) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.kuailian_device_connect_wifi_success, (int) R.string.make_device_near_router);
        }
    }

    public final void s_() {
        int i = this.O00000oO;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_init_plugin, (int) R.string.keep_phone_wifi_connect);
            this.O000O0o0.O000000o(0);
        } else if (i != 1) {
            if (i == 2) {
                this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_sendmessage_device, (int) R.string.kuailian_phone_connect_device_des);
                this.O000O0o0.O000000o(2);
                return;
            } else if (i == 3) {
                this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_device_connect_wifi, (int) R.string.make_device_near_router);
                this.O000O0o0.O000000o(3);
                return;
            } else {
                return;
            }
        }
        this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.kuailian_phone_connect_device, (int) R.string.kuailian_phone_connect_device_des);
        this.O000O0o0.O000000o(1);
    }

    private void O0000o0o() {
        int i = this.O00000oO;
        if (i == 0) {
            O000000o((int) R.string.kuailian_init_plugin_timeout, (int) R.string.phone_wifi_error, (int) R.drawable.common_bind_app_connect_network_failed);
        } else if (i == 1) {
            O000000o((int) R.string.kuailian_phone_connect_device_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 2) {
            O000000o((int) R.string.kuailian_phone_sendmessage_fail, (int) R.string.kuailian_phone_connect_device_fail_desc, (int) R.drawable.common_bind_app_connect_device_failed);
        } else if (i == 3) {
            if (!hze.O000000o(this.O000O0oo)) {
                O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.phone_wifi_error, (int) R.drawable.common_bind_app_connect_network_failed);
            } else {
                O000000o((int) R.string.kuailian_device_connect_wifi_fail, (int) R.string.make_device_near_router, (int) R.drawable.common_bind_device_connect_network_failed);
            }
        }
    }

    private void O0000o() {
        if (TextUtils.isEmpty(this.O00000o)) {
            this.O00000o = O0000oO();
        }
        if (this.f755O000000o == null) {
            this.f755O000000o = (ScanResult) htr.O000000o().O000000o("device_ap");
            if (this.f755O000000o == null) {
                return;
            }
        }
        int i = 100;
        if (O0000ooO.getConnectionInfo() != null && !TextUtils.isEmpty(O0000ooO.getConnectionInfo().getSSID()) && iag.O000000o(this.f755O000000o.SSID, O0000ooO.getConnectionInfo().getSSID())) {
            O0000o00();
            i = 3000;
        }
        this.O00000Oo = htr.O000000o().O00000o0();
        if (TextUtils.isEmpty(this.O00000o0)) {
            x_().postDelayed(new Runnable() {
                /* class _m_j.hvw.AnonymousClass2 */

                public final void run() {
                    htq.O000000o().O000000o(hvw.this.f755O000000o.BSSID, hvw.this.O00000o, DeviceFactory.O00000o(hvw.this.f755O000000o), new hua<JSONObject, hud>() {
                        /* class _m_j.hvw.AnonymousClass2.AnonymousClass1 */

                        public final void O000000o(hud hud) {
                        }

                        public final /* synthetic */ void O000000o(Object obj) {
                            hvw.this.O00000o0 = ((JSONObject) obj).optString("did");
                            if (!TextUtils.isEmpty(hvw.this.O00000o0)) {
                                hvw.this.O00000o0();
                            }
                        }
                    });
                }
            }, (long) i);
        } else {
            O00000o0();
        }
    }

    public final void O00000o0() {
        if (this.O00oOooO == null || this.O00oOooO.O00000o0 == null) {
            this.O00oOooO = new iad() {
                /* class _m_j.hvw.AnonymousClass4 */

                public final void O000000o(Network network) {
                    super.O000000o(network);
                    hvw hvw = hvw.this;
                    hvw.O000000o("connectToAP ok: " + hvw.this.f755O000000o.SSID, new Object[0]);
                }

                public final void O000000o() {
                    super.O000000o();
                    hvw.this.O000000o("connectToAP onUnavailable!", new Object[0]);
                    if (hvw.this.O00000oO == 1) {
                        hvw.this.x_().post(new Runnable() {
                            /* class _m_j.$$Lambda$hvw$4$omwvCJmepjFw8r81jUWIJaEI7k */

                            public final void run() {
                                hvw.AnonymousClass4.this.O00000o0();
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000o0() {
                    hvw.this.O0000oOO();
                }

                public final void O00000Oo(Network network) {
                    super.O00000Oo(network);
                    hvw.this.O000000o("connecttoAp onLost ", new Object[0]);
                    if (hvw.this.O00000oO == 1) {
                        hvw.this.x_().post(new Runnable() {
                            /* class _m_j.$$Lambda$hvw$4$4RnvI8gH7MQTYcTThzKOGISzy6w */

                            public final void run() {
                                hvw.AnonymousClass4.this.O00000Oo();
                            }
                        });
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo() {
                    hvw.this.O0000oOO();
                }
            };
            iag.O000000o(this.O0000ooo, O0000ooO, this.f755O000000o.SSID, this.O00000Oo, this.f755O000000o.BSSID, this.f755O000000o.capabilities, this.O00oOooO, true, true);
        }
    }

    public final void O0000o00() {
        iag.O000000o(this.O0000ooo, O0000ooO, this.f755O000000o.SSID, this.O00oOooO);
    }

    public final String O000000o(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public final String O0000o0() {
        return O000000o((long) ((WifiManager) this.O000O0oo.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
    }

    private void O0000oO0() {
        gov gov = this.O0000O0o;
        if (gov != null) {
            gov.O00000Oo();
        }
        this.O0000O0o = new gov();
        this.O0000O0o.O000000o(new gov.O000000o() {
            /* class _m_j.hvw.AnonymousClass6 */

            public final void O000000o() {
                htq.O000000o().O000000o(hvw.this.f755O000000o.BSSID, hvw.this.O00000o, DeviceFactory.O00000o(hvw.this.f755O000000o), hvw.this.O00000o0, hvw.this.O00000Oo, new hua<JSONObject, hud>() {
                    /* class _m_j.hvw.AnonymousClass6.AnonymousClass1 */

                    public final void O000000o(hud hud) {
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        DeviceRouterFactory.getApDeviceManager().changeScanResultToOnline(hvw.this.f755O000000o);
                        hvw.this.O0000O0o.O00000Oo();
                        hvw.this.O000000o(hvw.this.O00000o0);
                    }
                });
                hvw.this.O0000O0o.O00000o0();
            }
        }, 5000);
        this.O0000O0o.O000000o();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final String str) {
        htq.O000000o().O000000o(this.O000O0oo, new String[]{str}, new hua<List<Device>, hud>() {
            /* class _m_j.hvw.AnonymousClass7 */

            public final /* synthetic */ void O000000o(Object obj) {
                List<Device> list = (List) obj;
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
                    if (O000000o2 != null) {
                        O000000o2.isNew = true;
                    }
                    fno.O000000o().O000000o(O000000o2);
                    htk.O000000o();
                    htk.O00000Oo(str);
                    htr.O000000o().O00000Oo("connected_device", O000000o2);
                    hvw.this.e_(3);
                    long longValue = ((Long) htr.O000000o().O000000o("start_time")).longValue();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", "total_duration");
                        jSONObject.put("duration", System.currentTimeMillis() - longValue);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    SmartConfigRouterFactory.getCoreApiManager().addStatRecord(StatType.PLUGIN, "mihome", "Task", jSONObject.toString(), null, false);
                }
            }

            public final void O000000o(hud hud) {
                hvw.this.e_(3);
            }
        });
    }

    private static String O0000oO() {
        Random random = new Random(System.currentTimeMillis());
        String str = "";
        for (int i = 0; i < 32; i++) {
            str = str + "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(62));
        }
        return str;
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hvw.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WifiManager wifiManager = (WifiManager) hvw.this.O000O0oo.getApplicationContext().getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                    if (!(hvw.this.f755O000000o == null || connectionInfo == null || !hvw.this.f755O000000o.BSSID.equalsIgnoreCase(wifiManager.getConnectionInfo().getBSSID()))) {
                        hvw.this.O0000o00();
                    }
                    if (htk.O000000o().O00000o) {
                        htk.O000000o().O00000Oo();
                    }
                    hvw.this.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
