package _m_j;

import _m_j.dxe;
import _m_j.gjp;
import _m_j.hwa;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.smartconfig.step.ECCurve;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.security.interfaces.ECPublicKey;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gjp extends gjq {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17864O000000o;
    protected long O00000Oo;
    public long O00000o;
    protected String O00000o0;
    public boolean O00000oO;
    private long O0000oo;
    private hwa O0000oo0 = null;
    private long O0000ooO;
    private long O0000ooo = 50000;
    private htl O000O00o = new htm() {
        /* class _m_j.gjp.AnonymousClass3 */

        public final void onDeviceConnectionSuccess(List<Device> list) {
            gjp.this.O0000Oo0();
            gjp.this.O0000Oo.O0000o0.onDeviceConnectionSuccess(list);
        }

        public final void onDeviceConnectionFailure() {
            gjp.this.O0000Oo.O0000o0.onDeviceConnectionFailure();
        }

        public final void onDeviceConnectionFailure(int i) {
            gjp.this.O0000Oo.O0000o0.onDeviceConnectionFailure(i);
        }
    };
    private boolean O00oOooO = false;
    private hto O00oOooo = null;

    public final void O000000o(List<gke> list) {
        if (list == null || list.size() != 4) {
            throw new RuntimeException("ApConfigProcess stepTimeouts size must be 3!");
        }
        this.O0000oo = list.get(0).O00000Oo;
        this.O00000o = list.get(1).O00000Oo;
        this.O0000ooO = list.get(2).O00000Oo;
        this.O0000ooo = list.get(3).O00000Oo;
    }

    public final void O000000o(Message message) {
        if (O0000OOo() != null) {
            O0000OOo().removeMessages(message.what);
        }
        int i = message.what;
        if (i != 101) {
            String str = null;
            if (i == 112) {
                O00000Oo("handle message update device state");
                if (this.f17864O000000o == 2) {
                    O0000Oo0();
                }
                this.O0000O0o.O000000o(110, null);
                this.f17864O000000o = 3;
                O0000OOo().sendEmptyMessageDelayed(110, this.O0000ooo);
                O00000Oo("onStopConnection");
                O0000OOo().removeMessages(112);
                O00000Oo("onStopConnection");
                if (gnn.O00000oO) {
                    gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
                    this.O0000o.bindProcessToNetwork(null);
                }
                if (!htk.O000000o().O00000o) {
                    String str2 = this.O0000Oo.O00000o;
                    String str3 = this.O0000Oo.O00000oO;
                    String str4 = this.O0000Oo.O00000oo;
                    if (Build.VERSION.SDK_INT >= 29 && BaseWifiSettingUtils.O000000o(this.O0000Oo0) && this.O0000oO0 != null && this.O0000oO0.O00000o0 != null) {
                        this.O0000o.unregisterNetworkCallback(this.O0000oO0.O00000o0);
                        this.O0000oO0.O00000o0 = null;
                        this.O0000oO0 = null;
                    }
                    BaseWifiSettingUtils.O000000o(this.O0000o, O0000o0o, str2, str3, null, str4, null, false, true);
                }
                if (htk.O000000o().O00000o) {
                    O00000Oo("startSearchNewDevice but isFindingNew ,then return");
                    htk.O000000o().O00000oo = this.O000O00o;
                    return;
                }
                O00000Oo("startSearchNewDevice");
                hto hto = this.O00oOooo;
                if (hto == null) {
                    String str5 = this.O0000oO != null ? this.O0000oO.BSSID : null;
                    long j = this.O00000Oo;
                    if (j != 0) {
                        str = String.valueOf(j);
                    }
                    this.O00oOooo = new hto(str5, str, this.O0000o00, this.O0000Oo.O00000Oo);
                } else {
                    String str6 = this.O0000oO != null ? this.O0000oO.BSSID : null;
                    long j2 = this.O00000Oo;
                    if (j2 != 0) {
                        str = String.valueOf(j2);
                    }
                    hto.O000000o(str6, str, this.O0000o00, this.O0000Oo.O00000Oo);
                }
                htk.O000000o().O000000o(this.O00oOooo, this.O0000ooo, this.O000O00o);
            } else if (i == 123) {
                O0000OOo().removeMessages(123);
                O00000Oo("handle message connect ap");
                this.O0000O0o.O000000o(102, null);
                if (this.O0000oO0 == null || this.O0000oO0.O00000o0 == null) {
                    this.O0000oO0 = new iad() {
                        /* class _m_j.gjp.AnonymousClass6 */

                        public final void O000000o(Network network) {
                            super.O000000o(network);
                            gjp.O00000Oo("connectToAP ok: " + gjp.this.O0000oO.SSID);
                        }

                        public final void O000000o() {
                            super.O000000o();
                            gjp.O00000Oo("connectToAP onUnavailable!");
                            if (gjp.this.f17864O000000o == 0) {
                                gjp.this.O0000OOo().post(new Runnable() {
                                    /* class _m_j.$$Lambda$gjp$6$noqLtyvLpD1UkCKLrnfGWyUSXDo */

                                    public final void run() {
                                        gjp.AnonymousClass6.this.O00000o0();
                                    }
                                });
                            }
                        }

                        /* access modifiers changed from: private */
                        public /* synthetic */ void O00000o0() {
                            gjp.this.O000000o();
                        }

                        public final void O00000Oo(Network network) {
                            super.O00000Oo(network);
                            gjp.O00000Oo("connecttoAp onLost ");
                            if (gjp.this.f17864O000000o == 0) {
                                gjp.this.O0000OOo().post(new Runnable() {
                                    /* class _m_j.$$Lambda$gjp$6$jmK66OH0YPz60SEA5CJoMcnZgOU */

                                    public final void run() {
                                        gjp.AnonymousClass6.this.O00000Oo();
                                    }
                                });
                            }
                        }

                        /* access modifiers changed from: private */
                        public /* synthetic */ void O00000Oo() {
                            gjp.this.O000000o();
                        }
                    };
                    ScanResult scanResult = this.O0000Oo.O0000o00;
                    BaseWifiSettingUtils.O000000o(this.O0000o, O0000o0o, scanResult.SSID, "", scanResult.BSSID, scanResult.capabilities, this.O0000oO0, true, false);
                }
            } else if (i == 128) {
                O00000Oo("handle message getToken");
                O00000Oo();
            } else if (i == 130) {
                O00000Oo("handle message choose ecdh0");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", O0000Ooo());
                    jSONObject.put("method", "miIO.handshake");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", 1);
                    jSONObject.put("params", jSONObject2);
                    String jSONObject3 = jSONObject.toString();
                    O00000Oo("chooseECDH0:".concat(String.valueOf(jSONObject3)));
                    MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), jSONObject3, this.O00000Oo, this.O00000o0, new dxe.O000000o() {
                        /* class _m_j.gjp.AnonymousClass8 */

                        public final void O000000o(JSONObject jSONObject) {
                            int[] iArr;
                            int[] iArr2;
                            if (!gjp.this.O00000oO) {
                                gjp.O00000Oo("chooseECDH0 onSuccess");
                                JSONObject optJSONObject = jSONObject.optJSONObject("ecdh");
                                JSONArray optJSONArray = optJSONObject.optJSONArray("curve_suites");
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray("sign_suites");
                                gjp.O00000Oo("curve_suites: " + optJSONArray + ",sign_suites: " + optJSONArray2);
                                ECCurve eCCurve = null;
                                int i = 0;
                                while (i < optJSONArray.length() && (eCCurve = ECCurve.search(optJSONArray.optInt(i))) == null) {
                                    i++;
                                }
                                int i2 = 0;
                                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    i2 = optJSONArray2.optInt(i3);
                                    if (ECCurve.SignType.index(i2) != null) {
                                        break;
                                    }
                                }
                                if (eCCurve == null || i2 == 0) {
                                    izb.O000000o(gjn.O000000o().O000000o(), gjn.O000000o().O0000o0o(), 0).show();
                                    return;
                                }
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("oob");
                                gjp.O00000Oo("oob: ".concat(String.valueOf(optJSONObject2)));
                                if (optJSONObject2 != null) {
                                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("modes");
                                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("extents");
                                    if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                                        iArr = new int[]{optJSONObject2.optInt("modes")};
                                    } else {
                                        iArr = new int[optJSONArray3.length()];
                                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                            iArr[i4] = optJSONArray3.optInt(i4);
                                        }
                                    }
                                    if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                                        iArr2 = new int[]{optJSONObject2.optInt("extents")};
                                    } else {
                                        iArr2 = new int[optJSONArray4.length()];
                                        for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                                            iArr2[i5] = optJSONArray4.optInt(i5);
                                        }
                                    }
                                    gjp.this.O000000o(eCCurve, i2, iArr, iArr2);
                                    return;
                                }
                                gjp.this.O000000o(eCCurve, i2, (int[]) null, (int[]) null);
                            }
                        }

                        public final void O000000o(int i, String str, Throwable th) {
                            StringBuilder sb = new StringBuilder("chooseECDH0 onFail:");
                            if (str == null) {
                                str = Log.getStackTraceString(th);
                            }
                            sb.append(str);
                            gjp.O00000Oo(sb.toString());
                            if (!gjp.this.O0000oOo && !gjp.this.O0000oOO && !gjp.this.O00000oO) {
                                gjp.this.O00000o();
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (i == 133) {
                O0000OOo().sendEmptyMessageDelayed(110, this.O0000oo);
                this.O0000O0o.O000000o(100, null);
                this.f17864O000000o = 0;
                if (!TextUtils.isEmpty(this.O0000o00)) {
                    O00000Oo(false);
                } else {
                    O000000o(new hua<String, hud>() {
                        /* class _m_j.gjp.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            gjp.O00000Oo("getBindKey onSuccess,key =".concat(String.valueOf(str)));
                            gjp gjp = gjp.this;
                            gjp.O0000o00 = str;
                            gjp.O000000o(101, 0, "bindkey", gjp.O0000o00);
                            gjp.this.O00000Oo(false);
                        }

                        public final void O000000o(hud hud) {
                            gjp.O00000Oo("BleComboStep getBindKey failed:".concat(String.valueOf(hud)));
                            gjp gjp = gjp.this;
                            gjp.O0000o00 = "";
                            gjp.O000000o(101, -1, "bindkey", gjp.O0000o00);
                            gjp.this.O00000Oo(false);
                        }
                    }, 2);
                }
            }
        } else {
            O00000Oo("handleMessage:  NETWORK_STATE_CHANGED");
            O00000Oo(true);
        }
    }

    public final void O000000o() {
        this.O00000oO = true;
        int i = this.f17864O000000o;
        if (i == 0) {
            if (Build.VERSION.SDK_INT >= 29 && BaseWifiSettingUtils.O000000o(this.O0000Oo0) && this.O0000oO0 != null && this.O0000oO0.O00000o0 != null) {
                this.O0000o.unregisterNetworkCallback(this.O0000oO0.O00000o0);
                this.O0000oO0.O00000o0 = null;
                this.O0000oO0 = null;
            }
            O0000OOo().removeMessages(123);
        } else if (i == 1 || i == 2) {
            this.O0000O0o.O000000o(1000, null);
            return;
        } else if (i == 3) {
            if (this.O00oOooo != null) {
                htk.O000000o().O000000o(this.O00oOooo);
            } else {
                htk.O000000o().O00000Oo();
            }
        } else {
            return;
        }
        this.O0000O0o.O000000o(1000, null);
    }

    public final void O000000o(int i, Bundle bundle) {
        if (i == 0) {
            this.O00000oO = false;
            this.O0000Ooo = true;
            this.O0000oOO = false;
            int i2 = this.f17864O000000o;
            if (i2 == 0) {
                O0000OOo().sendEmptyMessage(133);
            } else if (i2 == 1 || i2 == 2) {
                this.f17864O000000o = 1;
                O0000OOo().sendEmptyMessage(NotificationCompat.FLAG_HIGH_PRIORITY);
            } else if (i2 == 3) {
                O0000OOo().sendEmptyMessage(112);
            }
        } else if (i == 1) {
            O000000o(bundle.getByteArray("shareKey"), bundle.getString("iv"));
        } else if (i == 6) {
            O000000o(bundle.getString("oob"));
        }
    }

    public final void O000000o(final hua<String, hud> hua, final int i) {
        gjn.O000000o().O000000o(this.O0000Oo.O00000Oo, String.valueOf(this.O0000Oo.O00000o0), new hua<JSONObject, hud>() {
            /* class _m_j.gjp.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                gjp.O000000o(" getBindKeyX onSuccess %s", jSONObject);
                if (jSONObject == null || jSONObject.length() == 0) {
                    O000000o((hud) null);
                    return;
                }
                gjp.this.O0000o0 = jSONObject.optLong("timestamp");
                String optString = jSONObject.optString("bindKey");
                String optString2 = jSONObject.optString("bindKeyIndex");
                gjp gjp = gjp.this;
                if ("0".equals(optString2)) {
                    optString2 = null;
                }
                gjp.O0000o0O = optString2;
                hua.O000000o(optString);
            }

            public final void O000000o(hud hud) {
                gjp.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                if (gjp.this.O0000Ooo && gjp.this.f17864O000000o == 0) {
                    gjn.O000000o().O000000o(new hua<String, hud>() {
                        /* class _m_j.gjp.AnonymousClass4.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            gjp.O00000Oo("getBindKey onSuccess,key =".concat(String.valueOf(str)));
                            hua.O000000o(str);
                            gjp.this.O0000o0 = 0;
                            gjp.this.O0000o0O = null;
                        }

                        public final void O000000o(hud hud) {
                            gjp.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                            gjp.O000000o("getBindKey retry count %d", Integer.valueOf(i));
                            if (gjn.O000000o().O0000Ooo()) {
                                gjp.O00000Oo("getBindKey ,ForceBindKey true");
                                if (i == 0) {
                                    String str = gjp.this.O0000Oo.O0000Ooo;
                                    if (str != null) {
                                        String str2 = str;
                                        if (!TextUtils.isEmpty(str2)) {
                                            gjp.O00000Oo("getBindKey from local");
                                            hua.O000000o(str2);
                                            return;
                                        }
                                    }
                                    gjp.this.O000000o();
                                    return;
                                }
                                gjp.this.O000000o(hua, i - 1);
                                return;
                            }
                            gjp.O00000Oo("getBindKey ,ForceBindKey false");
                            String str3 = gjp.this.O0000Oo.O0000Ooo;
                            if (str3 != null) {
                                String str4 = str3;
                                if (!TextUtils.isEmpty(str4)) {
                                    gjp.O00000Oo("getBindKey from local");
                                    hua.O000000o(str4);
                                    return;
                                }
                            }
                            hua.O000000o(hud);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: O000000o */
    public final void O00000Oo(boolean z) {
        O0000OOo().removeMessages(123);
        ScanResult scanResult = this.O0000Oo.O0000o00;
        WifiInfo connectionInfo = O0000o0o.getConnectionInfo();
        StringBuilder sb = new StringBuilder("checkConnectDeviceAp getConnectionInfo: ");
        sb.append(connectionInfo == null ? "null" : connectionInfo.getSSID());
        O00000Oo(sb.toString());
        if (scanResult != null && !this.O0000oOO && this.f17864O000000o != 3 && !this.O00000oO) {
            if (connectionInfo == null || !BaseWifiSettingUtils.O000000o(connectionInfo.getSSID(), scanResult.SSID)) {
                O00000Oo("checkConnectDeviceAp false ");
                if (!this.O00oOooO || this.f17864O000000o != 2) {
                    O0000OOo().sendEmptyMessageDelayed(123, z ? 5000 : 0);
                    return;
                }
                O00000Oo("handle message network changed, decide config router success");
                O0000OOo().sendEmptyMessage(112);
            } else if (O0000OOo() != null && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                O00000Oo("checkConnectDeviceAp true");
                if (O0000o0O()) {
                    this.O00oOooO = false;
                    O0000o0();
                    return;
                }
                O00000Oo("checkConnectDeviceAp false,try 1 second late");
                O0000OOo().postDelayed(new Runnable(z) {
                    /* class _m_j.$$Lambda$gjp$o_QxytkqR1qqOiVlaFkwuCVEj5o */
                    private final /* synthetic */ boolean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        gjp.this.O00000Oo(this.f$1);
                    }
                }, 1000);
            }
        }
    }

    private void O0000o0() {
        O00000Oo("onApConnected");
        O0000OOo().postDelayed(new Runnable() {
            /* class _m_j.gjp.AnonymousClass5 */

            public final void run() {
                if (gjp.this.f17864O000000o == 0 && gjp.this.O0000OoO()) {
                    gjp.this.O0000Oo0();
                    gjp gjp = gjp.this;
                    gjp.f17864O000000o = 1;
                    gjp.O0000OOo().sendEmptyMessageDelayed(110, gjp.this.O00000o);
                    if (gjp.this.O0000OOo() != null && (gjp.this.O00000Oo == 0 || TextUtils.isEmpty(gjp.this.O00000o0))) {
                        gjp.this.O0000OOo().sendEmptyMessage(NotificationCompat.FLAG_HIGH_PRIORITY);
                    }
                    gjp.this.O000000o(103, 0, (String) null, (String) null);
                }
            }
        }, (long) ((this.O0000Oo0 == null || !BaseWifiSettingUtils.O00000Oo(this.O0000Oo0) || Settings.canDrawOverlays(this.O0000Oo0)) ? 10 : 2000));
    }

    private boolean O0000o0O() {
        O000000o("startConnectionAsso mCurrentIndex:%d=", Integer.valueOf(this.f17864O000000o));
        if (!gnn.O00000oO) {
            return true;
        }
        Network network = null;
        Network[] allNetworks = this.O0000o.getAllNetworks();
        int i = 0;
        while (true) {
            try {
                if (i < allNetworks.length) {
                    NetworkInfo networkInfo = this.O0000o.getNetworkInfo(allNetworks[i]);
                    if (networkInfo != null && networkInfo.getType() == 1) {
                        network = allNetworks[i];
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (network != null) {
            return this.O0000o.bindProcessToNetwork(network);
        }
        O00000Oo(" startConnectionAsso Get Network ERROR");
        return false;
    }

    public final void O00000Oo() {
        O00000Oo("start getToken");
        if (TextUtils.isEmpty(this.O0000o00)) {
            this.f17864O000000o = 0;
            O000000o();
            return;
        }
        this.O0000O0o.O000000o(104, null);
        if (this.O0000OoO == null && !this.O00000oO && !this.O0000oOo) {
            if (this.O00000Oo == 0 || TextUtils.isEmpty(this.O00000o0)) {
                O0000o0O();
                this.O0000OoO = MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), new dxe.O000000o() {
                    /* class _m_j.gjp.AnonymousClass7 */

                    public final void O000000o(final JSONObject jSONObject) {
                        gjp.this.O0000OoO = null;
                        gjp.O00000Oo("getToken onSuccess");
                        if (gjp.this.O00000Oo == 0 || TextUtils.isEmpty(gjp.this.O00000o0)) {
                            gjp.this.O00000Oo = jSONObject.optLong("did");
                            gjp.this.O00000o0 = jSONObject.optString("token");
                            htk.O000000o().O000000o(String.valueOf(gjp.this.O00000Oo), gjp.this.O00000o0);
                            gjp gjp = gjp.this;
                            gjp.O000000o(105, "did", String.valueOf(gjp.O00000Oo), "token", gjp.this.O00000o0);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("id", gjq.O0000Ooo());
                                jSONObject2.put("method", "miIO.info");
                                jSONObject2.put("params", new JSONObject());
                                gjp.O00000Oo("after getToken success,do rpc method : miIO.info ,can get firmware version");
                                gjp.this.O0000O0o.O000000o(106, null);
                                MiioLocalAPI.O000000o(gkl.O000000o(gjp.this.O0000Oo0), jSONObject2.toString(), gjp.this.O00000Oo, gjp.this.O00000o0, new dxe() {
                                    /* class _m_j.gjp.AnonymousClass7.AnonymousClass1 */

                                    public final void onResponse(String str) {
                                        if (jSONObject != null) {
                                            gjp.O00000Oo("async_rpc info version: ".concat(String.valueOf(str)));
                                            gjp.this.O000000o(107, 0, "fw_ver", jSONObject.optString("fw_ver"));
                                        } else {
                                            gjp.this.O000000o(107, -1, "error", str);
                                        }
                                        gjp.this.O00000o0();
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    public final void O000000o(int i, String str, Throwable th) {
                        gjp.this.O0000OoO = null;
                        StringBuilder sb = new StringBuilder("getToken onFail:");
                        sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                        gjp.O00000Oo(sb.toString());
                        if (!gjp.this.O0000oOo && !gjp.this.O0000oOO && !gjp.this.O00000oO) {
                            gjp.this.O00000Oo();
                        }
                    }
                }, 3);
                return;
            }
            O00000o0();
        }
    }

    public final void O00000o0() {
        htr.O000000o().O00000Oo("bind_device_did", Long.valueOf(this.O00000Oo));
        htr.O000000o().O00000Oo("bind_device_token", this.O00000o0);
        O0000OOo().sendEmptyMessage(130);
    }

    public final void O00000o() {
        O000000o("FORCE_ECDH=%s", "true");
        O0000OOo().sendEmptyMessageDelayed(130, 1000);
    }

    public final void O000000o(ECCurve eCCurve, int i, int[] iArr, int[] iArr2) {
        int i2 = i;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "miIO.handshake");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("curve_suite", eCCurve.getIndex());
            jSONObject3.put("sign_suite", i2);
            jSONObject3.put("public_key", Base64.encodeToString(fio.O000000o((ECPublicKey) eCCurve.generateKeyPair().getPublic()), 2));
            jSONObject2.put("ecdh", jSONObject3);
            jSONObject.put("params", jSONObject2);
            String jSONObject4 = jSONObject.toString();
            O00000Oo("start chooseECDH");
            O00000Oo("curve_suite: " + eCCurve.getIndex() + ", sign_suite" + i2);
            final ECCurve eCCurve2 = eCCurve;
            final int i3 = i;
            final int[] iArr3 = iArr;
            final int[] iArr4 = iArr2;
            MiioLocalAPI.O00000Oo(gkl.O000000o(this.O0000Oo0), jSONObject4, this.O00000Oo, this.O00000o0, new dxe.O000000o() {
                /* class _m_j.gjp.AnonymousClass9 */

                public final void O000000o(final JSONObject jSONObject) {
                    gjp.this.O0000OOo().post(new Runnable() {
                        /* class _m_j.gjp.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            String str;
                            if (gjp.this.O00000oO) {
                                gjp.O00000Oo("chooseECDH onSuccess ,but timeout ");
                                return;
                            }
                            gjp.O00000Oo("chooseECDH onSuccess");
                            JSONObject optJSONObject = jSONObject.optJSONObject("ecdh");
                            String str2 = "";
                            if (optJSONObject != null) {
                                str2 = optJSONObject.optString("public_key");
                                str = optJSONObject.optString("sign");
                            } else {
                                str = str2;
                            }
                            byte[] verify = eCCurve2.verify(ECCurve.SignType.index(i3), gjp.this.O00000o0, Base64.decode(str2, 2), Base64.decode(str, 2));
                            if (verify == null) {
                                gjp.O00000Oo("chooseECDH ,verify fail, retry");
                                gjp.this.O00000o();
                            } else if (iArr3 == null || iArr3.length <= 0 || iArr4 == null || iArr4.length <= 0) {
                                gjp.this.O000000o(verify, (String) null);
                            } else {
                                int i = 0;
                                boolean z = false;
                                boolean z2 = false;
                                int i2 = 0;
                                while (i < iArr3.length && i < iArr4.length) {
                                    if (iArr3[i] == 2) {
                                        i2 = iArr4[i];
                                        z = true;
                                    } else if (iArr3[i] == 3) {
                                        z2 = true;
                                    }
                                    i++;
                                }
                                htr.O000000o().O00000Oo("sign", verify);
                                htr.O000000o().O00000Oo("length", Integer.valueOf(i2));
                                int i3 = iArr3[0];
                                if (z2) {
                                    i3 = 3;
                                } else if (z) {
                                    i3 = 2;
                                }
                                gjp.O000000o("chooseECDH, verify mode(1:keyboard;2:pincode;3:QRcode;4:digital display)=%d", Integer.valueOf(i3));
                                if (i3 == 1) {
                                    return;
                                }
                                if (i3 == 2) {
                                    gjp.O00000Oo("chooseECDH, verify mode is :OOB_MODE_VOICE,and then create pin step");
                                    gjp.this.O000000o(111, 0);
                                    gjp.this.O0000Oo();
                                } else if (i3 == 3) {
                                    gjp.O00000Oo("chooseECDH, verify mode is :OOB_MODE_QRCODE");
                                    String str3 = (String) htr.O000000o().O000000o("camera_qrcode_oob");
                                    gjp.O00000Oo("chooseECDH, did :" + gjp.this.O00000Oo + ", oob : " + ffr.O0000oO(String.valueOf(gjp.this.O00000Oo)));
                                    if (TextUtils.isEmpty(str3)) {
                                        str3 = ffr.O0000oO(String.valueOf(gjp.this.O00000Oo));
                                    }
                                    if (TextUtils.isEmpty(str3)) {
                                        gjp.O00000Oo("chooseECDH, verify mode is :OOB_MODE_QRCODE, but camera QR OOB is empty,so should jump ScanBarcodeActivity get oob");
                                        gjp.this.O0000OOo().removeMessages(110);
                                        Bundle bundle = new Bundle();
                                        bundle.putBoolean("hasVoiceOob", z);
                                        gjp.this.O000000o(bundle);
                                        gjp.this.O0000Oo();
                                        return;
                                    }
                                    gjp.this.O000000o(str3);
                                }
                            }
                        }
                    });
                }

                public final void O000000o(int i, String str, Throwable th) {
                    gjp.O00000Oo("chooseECDH rpc, onFail code=" + i + ",result=" + str + ",throwable=" + Log.getStackTraceString(th));
                    if (!gjp.this.O0000oOo && !gjp.this.O0000oOO && !gjp.this.O00000oO) {
                        gjp.this.O00000o();
                    }
                }
            });
        } catch (Exception e) {
            O00000Oo(Log.getStackTraceString(e));
        }
    }

    public final void O000000o(String str) {
        final byte[] bArr = (byte[]) htr.O000000o().O000000o("sign");
        hwa hwa = this.O0000oo0;
        if (hwa != null) {
            hwa.O000000o();
        }
        this.O0000oo0 = new hwa(this.O00000Oo, this.O00000o0, bArr, new hwa.O000000o() {
            /* class _m_j.gjp.AnonymousClass10 */

            public final void O000000o(final String str) {
                gjp.this.O0000OOo().post(new Runnable() {
                    /* class _m_j.gjp.AnonymousClass10.AnonymousClass1 */

                    public final void run() {
                        gjp.O00000Oo("chooseECDH, verify mode is :OOB_MODE_QRCODE, camera QR OOB exist, start bind onSuccess");
                        gjp.this.O000000o(bArr, str);
                    }
                });
            }

            public final void O000000o() {
                gjp.O00000Oo("chooseECDH, verify mode is :OOB_MODE_QRCODE, camera QR OOB exist, start bind onBindFailed");
                gjp.this.O0000OOo().post(new Runnable() {
                    /* class _m_j.gjp.AnonymousClass10.AnonymousClass2 */

                    public final void run() {
                        gjp.this.O0000O0o();
                        gjp.this.O000000o();
                        gjp.this.f17864O000000o = 1;
                    }
                });
            }
        });
        O00000Oo("onActivityResult, request scan code come back,start bind");
        this.O0000oo0.O000000o(str);
    }

    public final void O000000o(byte[] bArr, String str) {
        if (!this.O00000oO) {
            O0000Oo0();
            this.f17864O000000o = 2;
            O0000OOo().sendEmptyMessageDelayed(110, this.O0000ooO);
            O00000Oo("sharekey after decode = " + gru.O000000o(bArr));
            JSONObject jSONObject = new JSONObject();
            try {
                byte[] bArr2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                if (!TextUtils.isEmpty(str)) {
                    bArr2 = Base64.decode(str, 2);
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
                byte[] doFinal = instance.doFinal(O0000o0o().toString().getBytes());
                jSONObject.put("id", O0000Ooo());
                jSONObject.put("method", "miIO.config_router_safe");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", Base64.encodeToString(doFinal, 2));
                jSONObject2.put("sign", Base64.encodeToString(fir.O000000o(bArr, doFinal), 2));
                jSONObject.put("params", jSONObject2);
                O00000Oo("start sendECDHWifi");
                this.O0000O0o.O000000o(108, null);
                MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), jSONObject.toString(), this.O00000Oo, this.O00000o0, new dxe.O000000o() {
                    /* class _m_j.gjp.AnonymousClass11 */

                    public final void O000000o(JSONObject jSONObject) {
                        gjp.O00000Oo("sendECDHWifi, onSuccess");
                        if (gjp.this.O0000OOo() != null) {
                            gjp.this.O0000OOo().sendEmptyMessageDelayed(112, 1000);
                        }
                        gjp.this.O000000o(109, 0);
                    }

                    public final void O000000o(int i, String str, Throwable th) {
                        gjp.O00000Oo("sendECDHWifi, onFail:".concat(String.valueOf(str)));
                        if (!gjp.this.O0000oOo && !gjp.this.O0000oOO && !gjp.this.O00000oO && gjp.this.f17864O000000o != 3) {
                            gjp.this.O000000o(109, -1);
                        }
                    }
                }, 5000);
                this.O00oOooO = true;
            } catch (Exception e) {
                O00000Oo(Log.getStackTraceString(e));
            }
        }
    }

    public final void O00000oo() {
        this.O0000oOO = false;
        this.O00000oO = false;
        String str = (String) htr.O000000o().O000000o("ticket");
        byte[] bArr = (byte[]) htr.O000000o().O000000o("sign");
        O00000Oo("onResumeStep mCurrentIndex:" + this.f17864O000000o);
        if (this.f17864O000000o == 1 && bArr != null) {
            htr.O000000o().O00000Oo("sign");
            if (TextUtils.isEmpty(str)) {
                O0000O0o();
                O000000o();
                this.f17864O000000o = 1;
                return;
            }
            O000000o(bArr, str);
        }
    }

    private JSONObject O0000o0o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bind_key", this.O0000o00);
            if (!TextUtils.isEmpty(this.O0000o0O) && this.O0000o0 > 0) {
                jSONObject.put("bind_index", this.O0000o0O);
                jSONObject.put("bind_ts", this.O0000o0);
                O00000Oo("bind_ts: " + this.O0000o0 + "bindkey_index:" + this.O0000o0O);
            }
            jSONObject.put("config_type", this.O0000Oo.O0000O0o);
            String str = this.O0000Oo.O0000OOo;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("country_domain", str);
            }
            String str2 = this.O0000Oo.O0000oO0;
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("static_key", str2);
            }
            String str3 = this.O0000Oo.O0000oO;
            if (!TextUtils.isEmpty(str3)) {
                try {
                    jSONObject.put("static_key_number", Integer.parseInt(str3));
                } catch (NumberFormatException e) {
                    O000000o("[makeNormalWifiParams] + convert " + str3 + " to int failed", e);
                }
            }
            jSONObject.put("gmt_offset", this.O0000Oo.O0000Oo);
            jSONObject.put("passwd", this.O0000Oo.O00000oO);
            jSONObject.put("ssid", this.O0000Oo.O00000o);
            jSONObject.put("tz", this.O0000Oo.O0000OoO);
            jSONObject.put("uid", this.O0000Oo.O00000o0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cc", this.O0000Oo.O0000Oo0);
            jSONObject.put("wifi_config", jSONObject2);
            O00000Oo("WifiConfigJson : " + jSONObject2.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void O0000O0o() {
        O00000Oo("stopConnection");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "miIO.stop_diag_mode");
            jSONObject.put("params", "");
        } catch (JSONException unused) {
        }
        MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), jSONObject.toString(), this.O00000Oo, this.O00000o0, new dxe() {
            /* class _m_j.gjp.AnonymousClass2 */

            public final void onResponse(String str) {
            }
        });
    }

    public final void O00000oO() {
        this.O0000oOo = true;
        if (this.O0000OoO != null) {
            this.O0000OoO.f6027O000000o = true;
        }
        hwa hwa = this.O0000oo0;
        if (hwa != null) {
            hwa.O000000o();
            this.O0000oo0 = null;
        }
        O0000O0o();
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
}
