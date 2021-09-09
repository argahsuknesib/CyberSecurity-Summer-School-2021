package _m_j;

import _m_j.gjo;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class gjo extends gjq {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f17851O000000o;
    public String O00000Oo;
    boolean O00000o = false;
    public int O00000o0;
    private long O00000oO;
    private long O0000oo;
    private long O0000oo0;
    private hto O0000ooO = null;
    private int O0000ooo = 0;
    private htl O00oOooO = new htm() {
        /* class _m_j.gjo.AnonymousClass2 */

        public final void onDeviceConnectionSuccess(List<Device> list) {
            gjo.this.O0000Oo0();
            gjo.this.O0000Oo.O0000o0.onDeviceConnectionSuccess(list);
        }

        public final void onDeviceConnectionFailure() {
            gjo.this.O0000Oo.O0000o0.onDeviceConnectionFailure();
        }

        public final void onDeviceConnectionFailure(int i) {
            gjo.this.O0000Oo.O0000o0.onDeviceConnectionFailure(i);
        }
    };

    public gjo() {
        O00000oo = "ApConfigProcess";
    }

    /* access modifiers changed from: protected */
    public final void O000000o(List<gke> list) {
        if (list == null || list.size() != 3) {
            throw new RuntimeException("ApConfigProcess stepTimeouts size must be 3!");
        }
        this.O00000oO = list.get(0).O00000Oo;
        this.O0000oo0 = list.get(1).O00000Oo;
        this.O0000oo = list.get(2).O00000Oo;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Message message) {
        Message message2 = message;
        int i = message2.what;
        if (i == 101) {
            NetworkInfo networkInfo = (NetworkInfo) message2.obj;
            NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
            WifiInfo connectionInfo = O0000o0o.getConnectionInfo();
            if (connectionInfo == null) {
                O00000Oo("handle message network changed, wifiInfo is null,then return");
                return;
            }
            O000000o("handle message network changed: current Index(0:connect ap; 1:config router; 3:search device)=%d, wifi state(CONNECTING, CONNECTED, SUSPENDED, DISCONNECTING, DISCONNECTED, UNKNOWN)=%s, wifi ssid =%s", Integer.valueOf(this.O00000o0), networkInfo.getState().name(), connectionInfo.getSSID());
            ScanResult scanResult = this.O0000oO;
            if (scanResult == null) {
                O00000Oo("handle message network changed, ERROR: cache ScanResult is null, config route cloud not success");
            } else {
                O00000Oo("handle message network changed: cache scanResult not empty");
            }
            LogType logType = LogType.KUAILIAN;
            String str = O00000oo;
            StringBuilder sb = new StringBuilder();
            sb.append(detailedState.toString());
            sb.append(", ");
            sb.append(connectionInfo);
            sb.append(", ");
            String str2 = "";
            sb.append(networkInfo.getExtraInfo() != null ? networkInfo.getExtraInfo() : str2);
            sb.append(", ");
            if (networkInfo.getReason() != null) {
                str2 = networkInfo.getReason();
            }
            sb.append(str2);
            gsy.O00000Oo(logType, str, sb.toString());
            if (this.O00000o0 == 1 && networkInfo.getState() == NetworkInfo.State.DISCONNECTED && !this.O0000oOO && (connectionInfo == null || scanResult == null || !BaseWifiSettingUtils.O000000o(connectionInfo.getSSID(), scanResult.SSID))) {
                O00000Oo("handle message network changed, decide config router success");
                O0000OOo().sendEmptyMessage(112);
            } else if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>") && detailedState == NetworkInfo.DetailedState.CONNECTED && networkInfo.isConnected() && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED && scanResult != null && BaseWifiSettingUtils.O000000o(connectionInfo.getSSID(), scanResult.SSID) && this.O00000o0 == 0 && !this.O0000oOO) {
                O00000Oo("handle message network changed, decide connect ap success");
                if (O0000OOo() != null) {
                    O0000OOo().postDelayed(new Runnable() {
                        /* class _m_j.gjo.AnonymousClass6 */

                        public final void run() {
                            if (gjo.this.O00000o0 == 0 && gjo.this.O0000OoO()) {
                                gjo.this.O0000OOo().removeMessages(123);
                                gjo.this.O0000OOo().sendEmptyMessage(114);
                                gjo gjo = gjo.this;
                                gjo.O00000o0 = 1;
                                gjo.O000000o(103, 0, null, null);
                            }
                        }
                    }, 2000);
                }
            }
        } else if (i != 110) {
            String str3 = null;
            if (i == 112) {
                if (this.O00000o0 == 1) {
                    O0000Oo0();
                    this.O00000o0 = 3;
                    O0000OOo().sendEmptyMessageDelayed(110, this.O0000oo);
                }
                this.O0000O0o.O000000o(110, null);
                this.O00000o0 = 3;
                O0000OOo().removeMessages(112);
                O0000OOo().removeMessages(114);
                O00000Oo("onStopConnection");
                if (gnn.O00000oO) {
                    gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
                    this.O0000o.bindProcessToNetwork(null);
                }
                if (!htk.O000000o().O00000o) {
                    String str4 = this.O0000Oo.O00000o;
                    String str5 = this.O0000Oo.O00000oO;
                    String str6 = this.O0000Oo.O00000oo;
                    if (Build.VERSION.SDK_INT >= 29 && BaseWifiSettingUtils.O000000o(this.O0000Oo0) && this.O0000oO0 != null && this.O0000oO0.O00000o0 != null) {
                        this.O0000o.unregisterNetworkCallback(this.O0000oO0.O00000o0);
                        this.O0000oO0.O00000o0 = null;
                        this.O0000oO0 = null;
                    }
                    BaseWifiSettingUtils.O000000o(this.O0000o, O0000o0o, str4, str5, null, str6, null, false, true);
                }
                if (htk.O000000o().O00000o) {
                    O00000Oo("startSearchNewDevice: isFinding device,then return");
                    htk.O000000o().O00000oo = this.O00oOooO;
                    return;
                }
                hto hto = this.O0000ooO;
                if (hto == null) {
                    String str7 = this.O0000oO != null ? this.O0000oO.BSSID : null;
                    long j = this.f17851O000000o;
                    if (j != 0) {
                        str3 = String.valueOf(j);
                    }
                    this.O0000ooO = new hto(str7, str3, this.O0000o00, this.O0000Oo.O00000Oo);
                } else {
                    String str8 = this.O0000oO != null ? this.O0000oO.BSSID : null;
                    long j2 = this.f17851O000000o;
                    if (j2 != 0) {
                        str3 = String.valueOf(j2);
                    }
                    hto.O000000o(str8, str3, this.O0000o00, this.O0000Oo.O00000Oo);
                }
                htk.O000000o().O000000o(this.O0000ooO, this.O0000oo, this.O00oOooO);
            } else if (i == 114) {
                if (this.O00000o0 == 0) {
                    O0000Oo0();
                    this.O00000o0 = 1;
                    O0000OOo().sendEmptyMessageDelayed(110, this.O0000oo0);
                }
                O000000o("handle message send MSG_SEND_DEVICE_MSG isAssoTimetout=%s", String.valueOf(this.O00000o));
                if (this.O00000o) {
                    this.O0000O0o.O000000o(1000, null);
                    this.O00000o = false;
                } else if (this.O00000o0 == 1) {
                    O00000oo();
                }
            } else if (i == 123) {
                O0000OOo().removeMessages(123);
                this.O0000O0o.O000000o(102, null);
                if (this.O0000Oo.O0000o00 != null) {
                    this.O00000o0 = 0;
                    String O00000o02 = gog.O00000o0(this.O0000Oo0);
                    WifiInfo connectionInfo2 = O0000o0o.getConnectionInfo();
                    if (TextUtils.isEmpty(O00000o02) || !O00000o02.equals(this.O0000oO.SSID) || connectionInfo2 == null || connectionInfo2.getSupplicantState() != SupplicantState.COMPLETED) {
                        O000000o("startConnectToDeviceAp: wifi.ssid not equal scanResult.ssid, try to connect ap,current Index(expect 0)=%d", Integer.valueOf(this.O00000o0));
                        if (this.O0000oO0 == null || this.O0000oO0.O00000o0 == null) {
                            this.O0000oO0 = new iad() {
                                /* class _m_j.gjo.AnonymousClass5 */

                                public final void O000000o(Network network) {
                                    super.O000000o(network);
                                    gjo.O00000Oo("connectToAP ok: " + gjo.this.O0000oO.SSID);
                                }

                                public final void O000000o() {
                                    super.O000000o();
                                    gjo.O00000Oo("connectToAP onUnavailable!");
                                    if (gjo.this.O00000o0 == 0) {
                                        gjo.this.O0000OOo().post(new Runnable() {
                                            /* class _m_j.$$Lambda$gjo$5$F7dDa_dDqIOJkbMXy4QgeIcYZs */

                                            public final void run() {
                                                gjo.AnonymousClass5.this.O00000o0();
                                            }
                                        });
                                    }
                                }

                                /* access modifiers changed from: private */
                                public /* synthetic */ void O00000o0() {
                                    gjo.this.O000000o();
                                }

                                public final void O00000Oo(Network network) {
                                    super.O00000Oo(network);
                                    gjo.O00000Oo("connecttoAp onLost ");
                                    if (gjo.this.O00000o0 == 0) {
                                        gjo.this.O0000OOo().post(new Runnable() {
                                            /* class _m_j.$$Lambda$gjo$5$e04KB13ScS0QrX8atzoWb20JNfA */

                                            public final void run() {
                                                gjo.AnonymousClass5.this.O00000Oo();
                                            }
                                        });
                                    }
                                }

                                /* access modifiers changed from: private */
                                public /* synthetic */ void O00000Oo() {
                                    gjo.this.O000000o();
                                }
                            };
                            BaseWifiSettingUtils.O000000o(this.O0000o, O0000o0o, this.O0000oO.SSID, "", this.O0000oO.BSSID, this.O0000oO.capabilities, this.O0000oO0, true, false);
                            O0000OOo().sendEmptyMessageDelayed(123, 15000);
                            return;
                        }
                        return;
                    }
                    O000000o("startConnectToDeviceAp: wifi.ssid = scanResult.ssid, current Index(expect 0)=%d", Integer.valueOf(this.O00000o0));
                    if (O0000OOo() != null) {
                        O0000OOo().post(new Runnable() {
                            /* class _m_j.gjo.AnonymousClass4 */

                            public final void run() {
                                if (gjo.this.O00000o0 != 1) {
                                    gjo.this.O000000o(103, 0, null, null);
                                    gjo.this.O0000OOo().sendEmptyMessage(114);
                                }
                            }
                        });
                    }
                }
            } else if (i == 133) {
                O0000OOo().sendEmptyMessageDelayed(110, this.O00000oO);
                this.O0000O0o.O000000o(100, null);
                this.O00000o0 = 0;
                if (!TextUtils.isEmpty(this.O0000o00)) {
                    O0000OOo().sendEmptyMessage(123);
                } else {
                    gjn.O000000o().O000000o(this.O0000Oo.O00000Oo, String.valueOf(this.O0000Oo.O00000o0), new hua<JSONObject, hud>() {
                        /* class _m_j.gjo.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            gjo.O00000Oo(" getBindKeyX onSuccess:".concat(String.valueOf(jSONObject)));
                            if (jSONObject == null || jSONObject.length() == 0) {
                                O000000o((hud) null);
                                return;
                            }
                            gjo.this.O0000o0 = jSONObject.optLong("timestamp");
                            gjo.this.O0000o00 = jSONObject.optString("bindKey");
                            String optString = jSONObject.optString("bindKeyIndex");
                            gjo gjo = gjo.this;
                            if ("0".equals(optString)) {
                                optString = null;
                            }
                            gjo.O0000o0O = optString;
                            gjo gjo2 = gjo.this;
                            gjo2.O000000o(101, 0, "bindkey", gjo2.O0000o00);
                            gjo.this.O0000OOo().sendEmptyMessage(123);
                        }

                        public final void O000000o(hud hud) {
                            gjo.O00000Oo(" getBindKeyX onFailure onSuccess: ".concat(String.valueOf(hud)));
                            gjo.O00000Oo("force bind key=" + gjn.O000000o().O0000Ooo());
                            if (gjo.this.O0000Ooo && gjo.this.O00000o0 == 0) {
                                gjo.this.O000000o(new hua<String, hud>() {
                                    /* class _m_j.gjo.AnonymousClass1.AnonymousClass1 */

                                    public final /* synthetic */ void O000000o(Object obj) {
                                        String str = (String) obj;
                                        gjo.O00000Oo(" getBindKey onSuccess ".concat(String.valueOf(str)));
                                        gjo.this.O0000o00 = str;
                                        gjo.this.O000000o(101, 0, "bindkey", gjo.this.O0000o00);
                                        gjo.this.O0000OOo().sendEmptyMessage(123);
                                    }

                                    public final void O000000o(hud hud) {
                                        gjo.O00000Oo("getBindKey failed:".concat(String.valueOf(hud)));
                                        gjo.this.O000000o(101, -1, "bindkey", gjo.this.O0000o00);
                                        gjo.this.O0000OOo().sendEmptyMessage(123);
                                    }
                                }, 2);
                            }
                        }
                    });
                }
            }
        } else {
            O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        O00000Oo("onTimeout, mCurrentIndex = " + this.O00000o0);
        int i = this.O00000o0;
        if (i == 0) {
            if (Build.VERSION.SDK_INT >= 29 && BaseWifiSettingUtils.O000000o(this.O0000Oo0) && this.O0000oO0 != null && this.O0000oO0.O00000o0 != null) {
                this.O0000o.unregisterNetworkCallback(this.O0000oO0.O00000o0);
                this.O0000oO0.O00000o0 = null;
                this.O0000oO0 = null;
            }
            O0000OOo().removeMessages(123);
        } else if (i == 1) {
            O0000OOo().removeMessages(1);
            this.O00000o = true;
            return;
        } else if (i == 3) {
            if (this.O0000ooO != null) {
                htk.O000000o().O000000o(this.O0000ooO);
            } else {
                htk.O000000o().O00000Oo();
            }
        } else {
            return;
        }
        this.O0000O0o.O000000o(1000, null);
    }

    public final void O000000o(final hua<String, hud> hua, final int i) {
        gjn.O000000o().O000000o(new hua<String, hud>() {
            /* class _m_j.gjo.AnonymousClass3 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                gjo.O00000Oo("getBindKey onSuccess,key =".concat(String.valueOf(str)));
                hua.O000000o(str);
            }

            public final void O000000o(hud hud) {
                gjo.O00000Oo(String.format("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo));
                if (gjn.O000000o().O0000Ooo()) {
                    int i = i;
                    if (i == 0) {
                        String str = gjo.this.O0000Oo.O0000Ooo;
                        if (str == null || TextUtils.isEmpty(str)) {
                            gjo.this.O000000o();
                            return;
                        }
                        gjo.O00000Oo("getBindKey from local");
                        hua.O000000o(str);
                        return;
                    }
                    gjo.this.O000000o(hua, i - 1);
                    return;
                }
                String str2 = gjo.this.O0000Oo.O0000Ooo;
                if (str2 != null) {
                    String str3 = str2;
                    if (!TextUtils.isEmpty(str3)) {
                        gjo.O00000Oo("getBindKey from local");
                        hua.O000000o(str3);
                        return;
                    }
                }
                hua.O000000o(hud);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    private void O00000oo() {
        Network network;
        O00000Oo("startConnectionAsso");
        int i = 0;
        if (TextUtils.isEmpty(this.O0000o00)) {
            this.O00000o0 = 0;
            O000000o();
            return;
        }
        if (gnn.O00000oO) {
            Network[] allNetworks = this.O0000o.getAllNetworks();
            while (true) {
                try {
                    if (i >= allNetworks.length) {
                        break;
                    }
                    NetworkInfo networkInfo = this.O0000o.getNetworkInfo(allNetworks[i]);
                    if (networkInfo != null && networkInfo.getType() == 1) {
                        network = allNetworks[i];
                        break;
                    }
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (network == null) {
                gsy.O000000o(6, "ERROR", "Get Network ERROR");
            }
            this.O0000o.bindProcessToNetwork(network);
        }
        if (!TextUtils.isEmpty(this.O00000Oo) || !gjn.O000000o().O00000Oo(this.O0000Oo.O00000Oo)) {
            O00000Oo("start getToken");
            this.O0000O0o.O000000o(104, null);
            if (this.O0000OoO != null) {
                this.O0000OoO.f6027O000000o = true;
            }
            if (this.O0000oOo) {
                this.O0000OoO = MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), new dxe() {
                    /* class _m_j.gjo.AnonymousClass7 */

                    public final void onResponse(final String str) {
                        gjo.O00000Oo("getToken  onResponse");
                        if (gjo.this.O0000OOo() != null) {
                            gjo.this.O0000OOo().post(new Runnable() {
                                /* class _m_j.gjo.AnonymousClass7.AnonymousClass1 */

                                public final void run() {
                                    JSONObject O00000o0 = gjq.O00000o0(str);
                                    if (O00000o0 == null) {
                                        gjo.this.O000000o(101, -1, "error", str);
                                        if (gjo.this.O0000OOo() != null) {
                                            gjo.this.O0000OOo().sendEmptyMessageDelayed(114, 1000);
                                            return;
                                        }
                                        return;
                                    }
                                    gjo.this.f17851O000000o = Long.valueOf(O00000o0.optString("did")).longValue();
                                    gjo.this.O00000Oo = O00000o0.optString("token");
                                    htr.O000000o().O00000Oo("bind_device_did", Long.valueOf(gjo.this.f17851O000000o));
                                    htk.O000000o().O000000o(String.valueOf(gjo.this.f17851O000000o), gjo.this.O00000Oo);
                                    gjo.this.O000000o(101, "did", String.valueOf(gjo.this.f17851O000000o), "token", gjo.this.O00000Oo);
                                    if (gjn.O000000o().O00000o0(gjo.this.O0000Oo.O00000Oo)) {
                                        gjo.this.O00000Oo();
                                    } else {
                                        gjo.this.O00000o0();
                                    }
                                }
                            });
                        }
                    }
                }, 5);
                return;
            }
            return;
        } else if (this.O0000ooo <= 4) {
            O00000o0();
            return;
        } else if (O0000OOo() != null) {
            O0000OOo().sendEmptyMessageDelayed(112, 1000);
            return;
        } else {
            return;
        }
        network = null;
        if (network == null) {
        }
        this.O0000o.bindProcessToNetwork(network);
        if (!TextUtils.isEmpty(this.O00000Oo)) {
        }
        O00000Oo("start getToken");
        this.O0000O0o.O000000o(104, null);
        if (this.O0000OoO != null) {
        }
        if (this.O0000oOo) {
        }
    }

    public final void O00000Oo() {
        this.O0000O0o.O000000o(106, null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "miIO.info");
            jSONObject.put("params", new JSONObject());
            MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), jSONObject.toString(), this.f17851O000000o, this.O00000Oo, new dxe() {
                /* class _m_j.gjo.AnonymousClass8 */

                public final void onResponse(String str) {
                    JSONObject O00000o0 = gjq.O00000o0(str);
                    if (O00000o0 != null) {
                        gjo.this.O000000o(107, 0, "fw_ver", O00000o0.optString("fw_ver"));
                    } else {
                        gjo.this.O000000o(107, -1, "error", str);
                    }
                    gjo.O00000Oo("async_rpc info version onResponse: ".concat(String.valueOf(str)));
                    gjo.this.O00000o0();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void O00000o0() {
        this.O0000O0o.O000000o(108, null);
        this.O0000ooo++;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "miIO.config_router");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ssid", this.O0000Oo.O00000o);
            jSONObject2.put("passwd", this.O0000Oo.O00000oO);
            jSONObject2.put("uid", this.O0000Oo.O00000o0);
            jSONObject2.put("bind_key", this.O0000o00);
            if (!TextUtils.isEmpty(this.O0000o0O) && this.O0000o0 > 0) {
                jSONObject2.put("bind_index", this.O0000o0O);
                jSONObject2.put("bind_ts", this.O0000o0);
                O00000Oo("bind_ts: " + this.O0000o0 + "bindkey_index:" + this.O0000o0O);
            }
            jSONObject2.put("config_type", this.O0000Oo.O0000O0o);
            String str = this.O0000Oo.O0000OOo;
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("country_domain", str);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cc", this.O0000Oo.O0000Oo0);
            jSONObject2.put("wifi_config", jSONObject3);
            gsy.O00000Oo(O00000oo, "WifiConfigJson : " + jSONObject3.toString());
            jSONObject2.put("gmt_offset", this.O0000Oo.O0000Oo);
            jSONObject2.put("tz", this.O0000Oo.O0000OoO);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            gsy.O00000Oo(LogType.KUAILIAN, O00000oo, "setMiioRouter json error:" + Log.getStackTraceString(e));
        }
        String jSONObject4 = jSONObject.toString();
        O00000Oo("start config router, ssid: " + this.O0000Oo.O00000o);
        MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), jSONObject4, this.f17851O000000o, this.O00000Oo, new dxe() {
            /* class _m_j.gjo.AnonymousClass9 */

            public final void onResponse(String str) {
                gjo.O00000Oo("async_rpc device return data: ".concat(String.valueOf(str)));
                if (gjq.O00000o0(str) == null) {
                    gjo.this.O000000o(109, -1);
                    if (gjo.this.O0000OOo() != null) {
                        gjo.this.O0000OOo().sendEmptyMessageDelayed(114, 1000);
                        return;
                    }
                } else {
                    gjo.this.O00000o();
                }
                gjo.this.O000000o(109, 0);
                if (gjo.this.O0000OOo() != null) {
                    gjo.this.O0000OOo().sendEmptyMessageDelayed(112, 1000);
                }
            }
        });
    }

    public final void O00000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "miIO.stop_diag_mode");
            jSONObject.put("params", "");
        } catch (JSONException unused) {
        }
        MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), jSONObject.toString(), this.f17851O000000o, this.O00000Oo, new dxe() {
            /* class _m_j.gjo.AnonymousClass10 */

            public final void onResponse(String str) {
            }
        });
    }

    public final void O00000oO() {
        WifiManager wifiManager = (WifiManager) this.O0000Oo0.getApplicationContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
        if (!(this.O0000oO == null || connectionInfo == null || !this.O0000oO.BSSID.equalsIgnoreCase(wifiManager.getConnectionInfo().getBSSID()))) {
            BaseWifiSettingUtils.O000000o(this.O0000o, O0000o0o, this.O0000oO.SSID, this.O0000oO0);
        }
        if (htk.O000000o().O00000o) {
            htk.O000000o().O00000Oo();
        }
        htk.O000000o().O00000oo = null;
        super.O00000oO();
    }

    public final void O000000o(int i, Bundle bundle) {
        if (i == 0) {
            this.O0000Ooo = true;
            this.O0000oOO = false;
            int i2 = this.O00000o0;
            if (i2 == 0) {
                O0000OOo().sendEmptyMessage(133);
            } else if (i2 == 1) {
                O0000OOo().sendEmptyMessage(114);
            } else if (i2 == 3) {
                O0000OOo().sendEmptyMessage(112);
            }
        }
    }
}
