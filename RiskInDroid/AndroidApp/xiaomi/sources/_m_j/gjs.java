package _m_j;

import _m_j.gjs;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public final class gjs implements gjw {
    protected static WifiManager O0000o00 = null;
    private static long O0000oOO = 62000;
    private static long O0000oOo = 50000;
    private static long O0000oo0 = 50000;

    /* renamed from: O000000o  reason: collision with root package name */
    public gkd f17894O000000o;
    Context O00000Oo;
    public String O00000o = null;
    public int O00000o0;
    protected long O00000oO;
    protected String O00000oo;
    public String O0000O0o;
    protected String O0000OOo = "";
    public gkj O0000Oo = new gki();
    public gjy O0000Oo0;
    public String O0000OoO;
    public boolean O0000Ooo = true;
    public Handler O0000o = new Handler(Looper.getMainLooper()) {
        /* class _m_j.gjs.AnonymousClass1 */

        public final void handleMessage(Message message) {
            gjs.this.O000000o(message);
        }
    };
    protected ConnectivityManager O0000o0;
    protected iad O0000o0O;
    public gkg O0000o0o;
    public String O0000oO;
    public long O0000oO0;
    private int O0000oo;
    private boolean O0000ooO = false;
    private hto O0000ooo = null;
    private BroadcastReceiver O000O00o = new BroadcastReceiver() {
        /* class _m_j.gjs.AnonymousClass8 */

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("key_device_address");
                int intExtra = intent.getIntExtra("key_connect_status", 5);
                if (TextUtils.equals(stringExtra, gjs.this.O0000OoO)) {
                    gjs.O00000Oo("  bluetooth connect status = ".concat(String.valueOf(intExtra)));
                }
                if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equalsIgnoreCase(action) && TextUtils.equals(stringExtra, gjs.this.O0000OoO) && intExtra == 32) {
                    gjs.O00000Oo("  disconnect mac = " + fte.O000000o(gjs.this.O0000OoO));
                    gjs.this.O0000o0o.O00000o(gjs.this.O0000OoO);
                    gjs gjs = gjs.this;
                    gjs.O0000Ooo = false;
                    gjs.O0000o.removeMessages(127);
                    gjs.this.O000000o(0L);
                }
            }
        }
    };
    private MiioLocalAPI.O000000o O00oOooO;
    private int O00oOooo;

    public gjs(gkg gkg) {
        this.O0000o0o = gkg;
    }

    public final void O000000o(Context context, gkd gkd) {
        this.O00000Oo = context;
        this.f17894O000000o = gkd;
        O0000o00 = (WifiManager) this.O00000Oo.getApplicationContext().getSystemService("wifi");
        this.O0000o0 = (ConnectivityManager) this.O00000Oo.getSystemService("connectivity");
        if (gkd.O0000o > 0) {
            O0000oo0 = gkd.O0000o;
        }
        if (gkd.O0000o0O > 0) {
            O0000oOO = gkd.O0000o0O;
        }
        if (gkd.O0000o0o > 0) {
            O0000oOo = gkd.O0000o0o;
        }
    }

    public final void O000000o(Bundle bundle) {
        O00000oO(bundle.getInt("index", 0));
    }

    public final void O000000o(int i) {
        iad iad;
        if (i == 0) {
            if (Build.VERSION.SDK_INT >= 29 && BaseWifiSettingUtils.O000000o(this.O00000Oo) && (iad = this.O0000o0O) != null && iad.O00000o0 != null) {
                this.O0000o0.unregisterNetworkCallback(this.O0000o0O.O00000o0);
                this.O0000o0O.O00000o0 = null;
                this.O0000o0O = null;
            }
            if (TextUtils.isEmpty(this.O00000o)) {
                if (this.O0000Ooo) {
                    this.O0000o.removeMessages(125);
                } else {
                    this.O0000o.removeMessages(123);
                }
            } else if (!this.O0000Ooo) {
                this.O0000o.removeMessages(123);
            }
        } else if (i == 1) {
            O00000Oo(" .onStageTimeOut SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.O0000Ooo);
        } else if (i == 2) {
            O00000Oo(" .onStageTimeOut GET_NEW_DEVICE_INDEX，mUseBleConfig = " + this.O0000Ooo);
            if (this.O0000Ooo) {
                return;
            }
            if (this.O0000ooo == null) {
                htk.O000000o().O00000Oo();
            } else {
                htk.O000000o().O000000o(this.O0000ooo);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gkj.O000000o(boolean, java.lang.String):void
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gkj.O000000o(java.lang.String, java.lang.String):void
      _m_j.gkj.O000000o(java.lang.String, boolean):void
      _m_j.gkj.O000000o(boolean, java.lang.String):void */
    public final void O000000o(Message message) {
        this.O0000o0o.a_(message);
        int i = message.what;
        if (i == 101) {
            O00000Oo(" .handleMessage NETWORK_STATE_CHANGED");
            if (!this.O0000o0o.O00000o() && !this.O0000Ooo) {
                NetworkInfo networkInfo = (NetworkInfo) message.obj;
                NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
                WifiInfo connectionInfo = O0000o00.getConnectionInfo();
                ScanResult O000000o2 = this.O0000o0o.O000000o();
                if (this.O00000o0 == 1 && networkInfo.getState() == NetworkInfo.State.DISCONNECTED && !this.O0000o0o.O00000o0()) {
                    if (connectionInfo == null || O000000o2 == null || !BaseWifiSettingUtils.O000000o(connectionInfo.getSSID(), O000000o2.SSID)) {
                        this.O0000Oo.O000000o(true, connectionInfo.getSSID());
                        this.O0000o.sendEmptyMessage(112);
                        return;
                    }
                    O00000Oo("wifi ssid not equal scanResult ssid");
                }
                this.O0000Oo.O000000o(false, connectionInfo.getSSID());
                if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()) || connectionInfo.getSSID().contains("<unknown ssid>")) {
                    O00000Oo("handle message network changed.error unknown wifiInfo:");
                } else if (detailedState != NetworkInfo.DetailedState.CONNECTED || !networkInfo.isConnected()) {
                    O00000Oo("error otherstate state:".concat(String.valueOf(detailedState)));
                } else if (O000000o2 == null || !BaseWifiSettingUtils.O000000o(connectionInfo.getSSID(), O000000o2.SSID) || this.O00000o0 != 0 || this.O0000o0o.O00000o0()) {
                    O00000Oo(" wifi state connected,but wifi ssid not equal scanResult ssid");
                } else {
                    Handler handler = this.O0000o;
                    if (handler != null) {
                        handler.postDelayed(new Runnable() {
                            /* class _m_j.gjs.AnonymousClass6 */

                            public final void run() {
                                if (gjs.this.O00000o0 == 0 && gjs.this.O00000o0()) {
                                    gjs.this.O0000o0o.O00000oO();
                                    gjs.this.O0000o.removeMessages(123);
                                    gjs.this.O00000Oo();
                                    gjs.this.O00000o0 = 1;
                                }
                            }
                        }, 2000);
                    }
                }
            }
        } else if (i == 112) {
            O00000Oo(" .handleMessage MSG_UPDATE_DEVICE_STATE");
            Handler handler2 = this.O0000o;
            if (handler2 != null) {
                handler2.removeMessages(112);
                this.O0000o.removeMessages(114);
            }
            this.O0000Ooo = false;
            if (this.O00000o0 == 1) {
                this.O00000o0 = 2;
                O00000oO();
            }
        } else if (i == 114) {
            O00000Oo(" .handleMessage MSG_SEND_DEVICE_MSG");
            if (this.O00000o0 == 1) {
                O00000Oo();
            }
        } else if (i == 123) {
            O00000Oo(" .handleMessage MSG_RECONNECT_DEVICE_AP");
            O000000o();
            this.O0000Ooo = false;
        } else if (i == 125) {
            O00000Oo(" .handleMessage MSG_CONNECT_BLE_TIME_OUT");
            this.O0000Ooo = false;
            gsy.O000000o(4, "stopScan", "BComboS stop");
            fiz.O000000o().O00000Oo();
            O0000OOo();
            this.O0000Oo0.O00000o();
            if (!this.O0000ooO && !this.O0000o0o.O00000oo()) {
                O000000o();
            }
        } else if (i == 127) {
            O00000Oo(" .handleMessage MSG_BLE_NOTIFY_TIME_OUT, current notifyStatus = " + this.O0000oo);
            this.O0000o.removeMessages(127);
            this.O0000Ooo = false;
            O0000OOo();
            this.O0000Oo0.O00000o();
            int i2 = this.O00oOooo;
            if (i2 != 8 && i2 != 10 && i2 != 11) {
                O000000o(0L);
            }
        }
    }

    public final void O000000o() {
        this.O0000o0o.F_();
        this.O00000o0 = 0;
        String O00000o02 = gog.O00000o0(this.O00000Oo);
        WifiInfo connectionInfo = O0000o00.getConnectionInfo();
        final ScanResult O000000o2 = this.O0000o0o.O000000o();
        if (TextUtils.isEmpty(O00000o02) || !O00000o02.equals(O000000o2.SSID) || connectionInfo == null || connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
            String O0000OOo2 = this.O0000o0o.O0000OOo();
            iad iad = this.O0000o0O;
            if (iad == null || iad.O00000o0 == null) {
                this.O0000o0O = new iad() {
                    /* class _m_j.gjs.AnonymousClass4 */

                    public final void O000000o(Network network) {
                        super.O000000o(network);
                        gjs.O00000Oo("connectToAP ok: " + O000000o2.SSID);
                    }

                    public final void O000000o() {
                        super.O000000o();
                        gjs.O00000Oo("connectToAP onUnavailable!");
                        if (gjs.this.O00000o0 == 0) {
                            gjs.this.O0000o.post(new Runnable() {
                                /* class _m_j.$$Lambda$gjs$4$fq9QfcDFAaj0dRh1yQiUiWJB4s */

                                public final void run() {
                                    gjs.AnonymousClass4.this.O00000o0();
                                }
                            });
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O00000o0() {
                        gjs.this.O0000o0o.O000000o(11, (Object) null);
                    }

                    public final void O00000Oo(Network network) {
                        super.O00000Oo(network);
                        gjs.O00000Oo("connecttoAp onLost ");
                        if (gjs.this.O00000o0 == 0) {
                            gjs.this.O0000o.post(new Runnable() {
                                /* class _m_j.$$Lambda$gjs$4$puqi35Fug2Tj8rVhLCsHCTHNt2w */

                                public final void run() {
                                    gjs.AnonymousClass4.this.O00000Oo();
                                }
                            });
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O00000Oo() {
                        gjs.this.O0000o0o.O000000o(11, (Object) null);
                    }
                };
                BaseWifiSettingUtils.O000000o(this.O0000o0, O0000o00, O000000o2.SSID, O0000OOo2, O000000o2.BSSID, O000000o2.capabilities, this.O0000o0O, true, false);
                this.O0000o.sendEmptyMessageDelayed(123, 15000);
                return;
            }
            return;
        }
        Handler handler = this.O0000o;
        if (handler != null) {
            handler.post(new Runnable() {
                /* class _m_j.gjs.AnonymousClass3 */

                public final void run() {
                    if (gjs.this.O00000o0 != 1) {
                        gjs.this.O0000o0o.E_();
                        gjs.this.O00000Oo();
                        gjs.this.O00000o0 = 1;
                    }
                }
            });
        }
    }

    public final void O00000Oo() {
        Network network;
        O00000Oo(" .startConnectionAsso");
        if (TextUtils.isEmpty(this.O00000o)) {
            this.O0000o0o.O000000o(3, (Object) null);
            return;
        }
        this.O0000o0o.O0000Oo();
        this.O00000o0 = 1;
        if (gnn.O00000oO) {
            Network[] allNetworks = this.O0000o0.getAllNetworks();
            int i = 0;
            while (true) {
                if (i >= allNetworks.length) {
                    network = null;
                    break;
                }
                NetworkInfo networkInfo = this.O0000o0.getNetworkInfo(allNetworks[i]);
                if (networkInfo != null && networkInfo.getType() == 1) {
                    network = allNetworks[i];
                    break;
                }
                i++;
            }
            if (network == null) {
                gsy.O000000o(6, "ERROR", "Get Network ERROR");
            }
            this.O0000o0.bindProcessToNetwork(network);
        }
        String str = this.f17894O000000o.O00000o;
        String str2 = this.f17894O000000o.O00000oO;
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (!gjn.O000000o().O0000o()) {
            O00000Oo("setMiioRouter,but user not login");
            this.O0000o0o.O000000o(10, (Object) null);
        } else {
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", currentTimeMillis);
                jSONObject.put("method", "miIO.config_router");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ssid", str);
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject2.put("passwd", str2);
                jSONObject2.put("uid", this.f17894O000000o.O00000o0);
                jSONObject2.put("bind_key", this.O00000o);
                if (!TextUtils.isEmpty(this.O00000oo) && this.O00000oO > 0) {
                    jSONObject2.put("bind_index", this.O00000oo);
                    jSONObject2.put("bind_ts", this.O00000oO);
                }
                jSONObject2.put("config_type", this.f17894O000000o.O0000O0o);
                String str3 = this.f17894O000000o.O0000OOo;
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("country_domain", str3);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("cc", this.f17894O000000o.O0000Oo0);
                jSONObject2.put("wifi_config", jSONObject3);
                gsy.O00000Oo("ComboProcess", "WifiConfigJson : " + jSONObject3.toString());
                jSONObject2.put("gmt_offset", this.f17894O000000o.O0000Oo);
                jSONObject2.put("tz", this.f17894O000000o.O0000OoO);
                jSONObject.put("params", jSONObject2);
            } catch (JSONException e) {
                O00000Oo("setMiioRouter json error:" + Log.getStackTraceString(e));
            }
            MiioLocalAPI.O000000o o000000o = this.O00oOooO;
            if (o000000o != null) {
                o000000o.f6027O000000o = true;
            }
            O00000Oo("setMiioRouter, rpc getToken");
            String O000000o2 = gkl.O000000o(this.O00000Oo);
            this.O0000Oo.O000000o(O000000o2);
            this.O00oOooO = MiioLocalAPI.O000000o(O000000o2, new dxe() {
                /* class _m_j.gjs.AnonymousClass5 */

                public final void onResponse(final String str) {
                    gjs.O00000Oo("RPC getToken onResponse ");
                    if (gjs.this.O0000o != null) {
                        gjs.this.O0000o.post(new Runnable() {
                            /* class _m_j.gjs.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                JSONObject O00000o0 = gjq.O00000o0(str);
                                if (O00000o0 == null) {
                                    gjs.O00000Oo("get token fail, error =" + str);
                                    gjs.this.O0000Oo.O00000Oo(str);
                                    if (gjs.this.O0000o != null) {
                                        gjs.this.O0000o.sendEmptyMessageDelayed(114, 1000);
                                        return;
                                    }
                                    return;
                                }
                                gjs.this.O0000oO0 = Long.valueOf(O00000o0.optString("did")).longValue();
                                gjs.this.O0000oO = O00000o0.optString("token");
                                if (TextUtils.isEmpty(gjs.this.O0000O0o)) {
                                    gjs.this.O0000o0o.a_(gjs.this.O0000oO0);
                                }
                                htk.O000000o().O000000o(String.valueOf(gjs.this.O0000oO0), gjs.this.O0000oO);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", new Random().nextInt(C.MSG_CUSTOM_BASE) + 1);
                                    jSONObject.put("method", "miIO.info");
                                    jSONObject.put("params", new JSONObject());
                                    gjs.this.O0000Oo.O000000o();
                                    MiioLocalAPI.O000000o(gkl.O000000o(gjs.this.O00000Oo), jSONObject.toString(), gjs.this.O0000oO0, gjs.this.O0000oO, new dxe() {
                                        /* class _m_j.gjs.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                        public final void onResponse(String str) {
                                            JSONObject O00000o0 = gjq.O00000o0(str);
                                            if (O00000o0 != null) {
                                                String optString = O00000o0.optString("fw_ver");
                                                gjs.this.O0000Oo.O000000o(optString, str);
                                                if (!TextUtils.isEmpty(optString)) {
                                                    gjs.this.O0000OOo = optString;
                                                }
                                            }
                                            gjs.O00000Oo("async_rpc info version: " + gjs.this.O0000OOo + ", data = " + str);
                                            String jSONObject = jSONObject.toString();
                                            gjs.O00000Oo(" async rpc config wifi");
                                            MiioLocalAPI.O000000o(gkl.O000000o(gjs.this.O00000Oo), jSONObject, gjs.this.O0000oO0, gjs.this.O0000oO, new dxe() {
                                                /* class _m_j.gjs.AnonymousClass5.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                public final void onResponse(String str) {
                                                    gjs.O00000Oo("async_rpc device return data: ".concat(String.valueOf(str)));
                                                    JSONObject O00000o0 = gjq.O00000o0(str);
                                                    gjs.this.O0000Oo.O000000o(str, O00000o0 == null);
                                                    if (O00000o0 == null && gjs.this.O0000o != null) {
                                                        gjs.this.O0000o.sendEmptyMessageDelayed(114, 1000);
                                                    }
                                                    if (gjs.this.O0000o != null) {
                                                        gjs.this.O000000o(1000L);
                                                    }
                                                }
                                            });
                                        }
                                    });
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }, 5);
        }
        this.O00000o0 = 1;
    }

    private void O00000oO() {
        long j = this.O0000oO0;
        String str = null;
        String valueOf = j == 0 ? null : String.valueOf(j);
        if (TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(this.O0000O0o)) {
            valueOf = this.O0000O0o;
        }
        O00000Oo("BleComboStep.scanNewDevice mDid = " + fte.O000000o(valueOf));
        this.O0000o0o.O0000OoO();
        this.O00000o0 = 2;
        ScanResult O000000o2 = this.O0000o0o.O000000o();
        if (this.O0000o0o.O00000oo()) {
            String O00000o02 = fef.O00000o0(O000000o2);
            String str2 = this.O0000OoO;
            if (!(str2 == null || str2.length() != 17 || O00000o02 == null || O00000o02.length() != 4 || O000000o2 == null)) {
                char[] charArray = this.O0000OoO.toCharArray();
                charArray[12] = O00000o02.charAt(0);
                charArray[13] = O00000o02.charAt(1);
                charArray[15] = O00000o02.charAt(2);
                charArray[16] = O00000o02.charAt(3);
                String replaceAll = Arrays.toString(charArray).replaceAll("[\\[\\]\\s,]", "");
                O00000Oo(" .scanNewDevice change deviceMac: " + fte.O000000o(replaceAll));
                O000000o2.BSSID = replaceAll;
            }
        }
        hto hto = this.O0000ooo;
        if (hto == null) {
            if (O000000o2 != null) {
                str = O000000o2.BSSID;
            }
            this.O0000ooo = new hto(str, valueOf, this.O00000o, this.f17894O000000o.O00000Oo);
        } else {
            if (O000000o2 != null) {
                str = O000000o2.BSSID;
            }
            hto.O000000o(str, valueOf, this.O00000o, this.f17894O000000o.O00000Oo);
        }
        htk.O000000o().O000000o(this.O0000ooo, O0000oo0, this.O0000o0o.O0000Ooo());
    }

    public final boolean O00000o0() {
        WifiInfo connectionInfo;
        ScanResult O000000o2;
        WifiManager wifiManager = O0000o00;
        if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && !TextUtils.isEmpty(connectionInfo.getSSID()) && !connectionInfo.getSSID().contains("<unknown ssid>") && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED && (O000000o2 = this.O0000o0o.O000000o()) != null && BaseWifiSettingUtils.O000000o(connectionInfo.getSSID(), O000000o2.SSID)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public void O00000oO(int i) {
        if (this.O0000o0o.O000000o() == null) {
            if (this.O0000o0o.O0000o00()) {
                this.O0000o.postDelayed(new Runnable(i) {
                    /* class _m_j.$$Lambda$gjs$hfO4Bl7zTxfzDk9jiZBnI9UufP4 */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        gjs.this.O00000oO(this.f$1);
                    }
                }, 2000);
            }
        } else if (i == 0) {
            O0000O0o();
        } else if (i == 1) {
            O00000Oo(" .startConnection SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.O0000Ooo);
            if (this.O0000Ooo) {
                O00000Oo(" >>> current mNotifyStatus = " + O00000o(this.O0000oo));
                int i2 = this.O0000oo;
                if (i2 == 0) {
                    this.O00000o0 = 1;
                } else if (i2 == 4) {
                    O00000oo();
                } else if (i2 == 3) {
                    this.O0000Ooo = true;
                    this.O0000o.sendEmptyMessageDelayed(127, O0000oOo);
                    O00000Oo(this.O0000oo);
                } else if (gnl.O00000o0(this.O0000OoO)) {
                    this.O0000Ooo = true;
                    this.O0000o.sendEmptyMessageDelayed(127, O0000oOo);
                    O00000Oo(this.O0000oo);
                } else {
                    this.O0000Ooo = false;
                    this.O0000o.removeMessages(127);
                    O000000o(0L);
                }
            } else {
                O00000Oo();
            }
        } else if (i == 2) {
            O00000Oo(" .startConnection GET_NEW_DEVICE_INDEX");
            O00000Oo(" >>> current mNotifyStatus = " + O00000o(this.O0000oo));
            O00000oO();
        }
    }

    private void O00000oo() {
        O00000Oo(" .retryComboConnect");
        this.O0000oo = 0;
        this.O0000Ooo = true;
        this.O0000Oo0.O00000o0();
        this.O0000o.removeMessages(125);
        this.O0000o.removeMessages(127);
        this.O0000Oo0.O000000o();
        this.O0000o.sendEmptyMessageDelayed(127, O0000oOo);
    }

    private void O0000O0o() {
        O00000Oo(" .startConnection CONNECT_INDEX, mUseBleConfig = " + this.O0000Ooo);
        O000000o(new hua<String, hud>() {
            /* class _m_j.gjs.AnonymousClass7 */

            public final /* synthetic */ void O000000o(Object obj) {
                gjs.O00000Oo("getBindKey  onSuccess");
                gjs gjs = gjs.this;
                gjs.O00000o = (String) obj;
                gjs.O0000o0o.O000000o(gjs.this.O00000o);
                if (gjs.this.O0000Ooo) {
                    gjs.this.O00000o();
                } else {
                    gjs.this.O000000o();
                }
            }

            public final void O000000o(hud hud) {
                gjs.O00000Oo(" getBindKey failed");
                gjs gjs = gjs.this;
                gjs.O00000o = "";
                if (gjs.O0000Ooo) {
                    gjs.this.O00000o();
                } else {
                    gjs.this.O000000o();
                }
            }
        });
    }

    public final void O00000o() {
        O00000Oo(" startConnectToBle");
        this.O00000o0 = 0;
        if (TextUtils.isEmpty(this.O00000o)) {
            this.O0000o0o.O000000o(3, (Object) null);
            return;
        }
        this.O0000Oo0 = new gjz(this);
        ScanResult O000000o2 = this.O0000o0o.O000000o();
        this.O0000o0o.D_();
        if (O000000o2 != null) {
            this.O0000Oo0.O000000o(O000000o2);
        } else {
            this.O0000o0o.O000000o(4, (Object) null);
        }
        this.O0000o.sendEmptyMessageDelayed(125, O0000oOO);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gkg.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gkg.O000000o(int, java.lang.Object):void
      _m_j.gkg.O000000o(java.lang.String, boolean):void */
    public final void O000000o(String str) {
        int i;
        boolean z;
        O00000Oo("onSearchComboAddress,if mac empty,will try ap connect");
        this.O0000o0o.O00000Oo(str);
        if (!TextUtils.isEmpty(str)) {
            MiotBleAdvPacket O00000o02 = this.O0000o0o.O00000o0(str);
            boolean z2 = false;
            if (O00000o02 == null || O00000o02.f6871O000000o == null) {
                z = true;
                i = 0;
            } else {
                i = O00000o02.f6871O000000o.O0000OOo;
                z = fea.O000000o(O00000o02.f6871O000000o.O0000Oo0);
            }
            if ((i == 0 || i == 2) && z) {
                this.O0000OoO = str;
                if (i == 0) {
                    z2 = true;
                }
                this.O0000o0o.O000000o(str, true);
                gjy gjy = this.O0000Oo0;
                gju gju = new gju();
                gju.O00000Oo = this.O00000o;
                gju.O00000oO = this.O00000oO;
                gju.O00000oo = this.O00000oo;
                gju.O00000o0 = this.f17894O000000o.O00000o;
                gju.O00000o = this.f17894O000000o.O00000oO;
                gju.O0000O0o = this.f17894O000000o.O0000O0o;
                gju.O0000OoO = this.f17894O000000o.O0000Oo0;
                gju.O0000Oo0 = this.f17894O000000o.O0000OOo;
                gju.f17913O000000o = String.valueOf(this.f17894O000000o.O00000o0);
                gju.O0000Oo = this.f17894O000000o.O0000OoO;
                gjy.O000000o(z2, gju);
                return;
            }
            O00000Oo("don't support authMode = ".concat(String.valueOf(i)));
            this.O0000ooO = true;
            this.O0000o0o.O000000o(str, false);
            if (this.O0000o.hasMessages(125)) {
                this.O0000o.removeMessages(125);
                this.O0000o.sendEmptyMessage(125);
            }
        } else if (this.O0000o.hasMessages(125)) {
            this.O0000o.removeMessages(125);
            this.O0000o.sendEmptyMessage(125);
        }
    }

    public final void O000000o(int i, String str, String str2) {
        O00000Oo("BleComboStep.onSendSSIDAndPassWd code = " + i + ", firmwareVersion = " + str + ", deviceDid = " + str2);
        this.O0000OOo = str;
        this.O0000O0o = str2;
        this.O00oOooo = -1;
        this.O0000o0o.O000000o(i, str, str2);
        if (i != 0) {
            if (i == -37) {
                this.O0000ooO = true;
            }
            if (this.O0000o.hasMessages(125)) {
                this.O0000o.removeMessages(125);
                this.O0000o0o.O000000o(7, Integer.valueOf(i));
                if (i == -6) {
                    this.O0000o.sendEmptyMessageDelayed(125, 2000);
                } else {
                    this.O0000o.sendEmptyMessage(125);
                }
            }
        } else if (this.O0000Ooo) {
            this.O00000Oo.registerReceiver(this.O000O00o, new IntentFilter("com.xiaomi.smarthome.bluetooth.connect_status_changed"));
            this.O0000o.removeMessages(125);
            this.O0000Oo0.O000000o();
            O00000oO(1);
            this.O0000o.sendEmptyMessageDelayed(127, O0000oOo);
        }
    }

    private static String O00000o(int i) {
        if (i == 0) {
            return "NOTIFY_START";
        }
        if (i == 1) {
            return "connecting router";
        }
        if (i == 2) {
            return "router connected";
        }
        if (i == 3) {
            return "server connected";
        }
        if (i != 4) {
            return i != 5 ? "unknown ".concat(String.valueOf(i)) : "pwd error";
        }
        return "unknown error";
    }

    private void O0000OOo() {
        try {
            this.O00000Oo.unregisterReceiver(this.O000O00o);
        } catch (Exception unused) {
        }
    }

    public final void O00000Oo(int i) {
        O00000Oo("  onNotifyStatus " + O00000o(i));
        if (this.O0000Ooo && this.O0000o.hasMessages(127)) {
            this.O0000oo = i;
            if (i >= 4 && i != 6) {
                this.O00oOooo = i;
            }
            this.O0000o0o.O000000o(i);
            if (i == 3) {
                O0000OOo();
                this.O0000Oo0.O00000o();
                this.O0000o.removeMessages(127);
                O000000o(0L);
            } else if (i == 4 || i == 5) {
                O0000OOo();
                this.O0000o.removeMessages(127);
            } else if (i == 9) {
                O0000OOo();
                this.O0000o.removeMessages(127);
                this.O0000Oo0.O00000o();
                this.O0000o0o.O000000o(8, (Object) null);
            } else if (i == 12) {
                O0000OOo();
                this.O0000o.removeMessages(127);
                this.O0000Oo0.O00000o();
                this.O0000o0o.O000000o(9, (Object) null);
            }
        }
    }

    public final void O000000o(long j) {
        this.O0000o.sendEmptyMessageDelayed(112, j);
    }

    private void O000000o(final hua<String, hud> hua) {
        gjn.O000000o().O000000o(this.f17894O000000o.O00000Oo, String.valueOf(this.f17894O000000o.O00000o0), new hua<JSONObject, hud>() {
            /* class _m_j.gjs.AnonymousClass9 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                gjs.O00000Oo(" getBindKeyX onSuccess ".concat(String.valueOf(jSONObject)));
                if (jSONObject == null || jSONObject.length() == 0) {
                    O000000o((hud) null);
                    return;
                }
                gjs.this.O00000oO = jSONObject.optLong("timestamp");
                String optString = jSONObject.optString("bindKey");
                String optString2 = jSONObject.optString("bindKeyIndex");
                gjs gjs = gjs.this;
                if ("0".equals(optString2)) {
                    optString2 = null;
                }
                gjs.O00000oo = optString2;
                hua.O000000o(optString);
            }

            public final void O000000o(hud hud) {
                gjs.O00000Oo(" getBindKeyX onFailure ".concat(String.valueOf(hud)));
                if (gjs.this.O0000o0o.O0000o00()) {
                    gjs.this.O000000o(new hua<String, hud>() {
                        /* class _m_j.gjs.AnonymousClass9.AnonymousClass1 */

                        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                            gjs.this.O00000oO = 0;
                            gjs.this.O00000oo = null;
                            hua.O000000o((String) obj);
                        }

                        public final void O000000o(hud hud) {
                            hua.O000000o(hud);
                        }
                    }, 2);
                }
            }
        });
    }

    public final void O000000o(final hua<String, hud> hua, final int i) {
        gjn.O000000o().O000000o(new hua<String, hud>() {
            /* class _m_j.gjs.AnonymousClass10 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                gjs.O00000Oo("getBindKey onSuccess,key =".concat(String.valueOf(str)));
                hua.O000000o(str);
            }

            public final void O000000o(hud hud) {
                gjs.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                int i = i;
                if (i == 0) {
                    String str = gjs.this.f17894O000000o.O0000Ooo;
                    if (str != null) {
                        String str2 = str;
                        if (!TextUtils.isEmpty(str2)) {
                            gjs.O00000Oo("getBindKey from local");
                            hua.O000000o(str2);
                            return;
                        }
                    }
                    gjs.this.O0000o0o.O000000o(3, (Object) null);
                    return;
                }
                gjs.this.O000000o(hua, i - 1);
            }
        });
    }

    protected static void O00000Oo(String str) {
        gjn.O000000o().O000000o("ComboProcess", str);
    }

    protected static void O000000o(String str, Object... objArr) {
        gjn.O000000o().O000000o("ComboProcess", String.format(str, objArr));
    }

    public final void O00000Oo(boolean z) {
        MiioLocalAPI.O000000o o000000o = this.O00oOooO;
        if (o000000o != null) {
            o000000o.f6027O000000o = true;
        }
        this.O0000o0O = null;
        O00000Oo(String.format("wifi restore ? -> %b", Boolean.valueOf(z)));
        O0000OOo();
        this.O0000o.removeCallbacksAndMessages(null);
        fiz.O000000o().O00000Oo();
        gjy gjy = this.O0000Oo0;
        if (gjy == null) {
            return;
        }
        if (z) {
            gjy.O000000o(new gjx() {
                /* class _m_j.gjs.AnonymousClass2 */

                public final void O000000o() {
                    gjs.this.O0000Oo0.O00000o();
                }
            });
        } else {
            gjy.O00000o();
        }
    }

    public final void O000000o(boolean z) {
        iad iad;
        this.O0000o.removeMessages(112);
        this.O0000o.removeMessages(114);
        if (gnn.O00000oO) {
            gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
            this.O0000o0.bindProcessToNetwork(null);
        }
        if (z) {
            if (Build.VERSION.SDK_INT >= 29 && BaseWifiSettingUtils.O000000o(this.O00000Oo) && (iad = this.O0000o0O) != null && iad.O00000o0 != null) {
                this.O0000o0.unregisterNetworkCallback(this.O0000o0O.O00000o0);
                this.O0000o0O.O00000o0 = null;
                this.O0000o0O = null;
            }
            BaseWifiSettingUtils.O000000o(this.O0000o0, O0000o00, this.f17894O000000o.O00000o, this.f17894O000000o.O00000oO, null, this.f17894O000000o.O00000oo, null, false, true);
        }
    }
}
