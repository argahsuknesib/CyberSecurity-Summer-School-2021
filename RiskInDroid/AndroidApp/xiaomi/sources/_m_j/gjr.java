package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class gjr extends gjq implements gjw {
    private static long O0000ooo = 62000;
    private static long O00oOooO = 50000;
    private static long O00oOooo = 50000;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17885O000000o;
    gkf O00000Oo;
    public String O00000o = "";
    public String O00000o0;
    public String O00000oO;
    public gjv O0000oo;
    public boolean O0000oo0 = false;
    public hua<String, hud> O0000ooO = new hua<String, hud>() {
        /* class _m_j.gjr.AnonymousClass3 */

        public final /* synthetic */ void O000000o(Object obj) {
            gjr gjr = gjr.this;
            gjr.O0000o00 = (String) obj;
            gjr.O00000Oo.onGetBindKeySuccess(gjr.this.O0000o00);
            gjr.this.O00000Oo();
        }

        public final void O000000o(hud hud) {
            gjr.O00000Oo("BleComboProcess getBindKey failed");
            gjr.this.O00000Oo.onError(3, null);
        }
    };
    private int O000O00o;
    private String O000O0OO = "";
    private int O000O0Oo;
    private BroadcastReceiver O000O0o = new BroadcastReceiver() {
        /* class _m_j.gjr.AnonymousClass7 */

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("key_device_address");
                int intExtra = intent.getIntExtra("key_connect_status", 5);
                if (TextUtils.equals(stringExtra, gjr.this.O00000oO)) {
                    fte.O00000Oo("BleComboBleWayStep bluetooth connect status = ".concat(String.valueOf(intExtra)));
                }
                if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equalsIgnoreCase(action) && TextUtils.equals(stringExtra, gjr.this.O00000oO) && intExtra == 32) {
                    gjr.O00000Oo("BleComboProcess disconnect mac = " + fte.O000000o(gjr.this.O00000oO));
                    gjr.this.O0000OOo().removeMessages(127);
                    gjr.this.O00000o0();
                    gjr.this.O00000Oo.receiveBleDisconnect(gjr.this.O0000Oo.O00000Oo, gjr.this.O00000oO);
                }
            }
        }
    };
    private hto O000O0o0 = null;
    private int O00oOoOo;

    /* access modifiers changed from: protected */
    public final void O000000o() {
    }

    /* access modifiers changed from: protected */
    public final void O000000o(List<gke> list) {
    }

    public gjr(gkf gkf) {
        this.O00000Oo = gkf;
    }

    public final void O000000o(Context context, List<gke> list, gkd gkd) {
        super.O000000o(context, list, gkd);
        if (gkd.O0000o0O > 0) {
            O0000ooo = gkd.O0000o0O;
        }
        if (gkd.O0000o0o > 0) {
            O00oOooO = gkd.O0000o0o;
        }
        if (gkd.O0000o > 0) {
            O00oOooo = gkd.O0000o;
        }
    }

    public final void O00000oO() {
        super.O00000oO();
        O00000oo();
        if (this.O0000oo != null) {
            if (this.O00000Oo.isRestoreWifi()) {
                this.O0000oo.O000000o(new gjx() {
                    /* class _m_j.gjr.AnonymousClass1 */

                    public final void O000000o() {
                        gjr.this.O0000oo.O00000o();
                    }
                });
            } else {
                this.O0000oo.O00000o();
            }
        }
        fiz.O000000o().O00000Oo();
    }

    public final void O000000o(int i) {
        O00000Oo("onstageTimeout:".concat(String.valueOf(i)));
        if (i == 0 && TextUtils.isEmpty(this.O0000o00)) {
            O0000OOo().removeMessages(125);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Message message) {
        O00000Oo("handleConfigMessage:".concat(String.valueOf(message)));
        int i = message.what;
        if (i == 112) {
            this.O00000Oo.notifyMessage(message.what, null);
            O00000Oo("BleComboProcess handleMessage MSG_UPDATE_DEVICE_STATE");
            if (O0000OOo() != null) {
                O0000OOo().removeMessages(112);
                O0000OOo().removeMessages(114);
            }
            if (this.f17885O000000o == 1) {
                O00000o();
                this.O00000Oo.onSendPwdAndPwdResult(0);
                O0000O0o();
            }
        } else if (i == 115) {
            this.O00000Oo.notifyMessage(message.what, null);
            O00000Oo("BleComboProcess handleMessage MSG_DISCONNECT_TIME_OUT");
            O00000o();
        } else if (i == 125) {
            Bundle bundle = new Bundle();
            bundle.putString("model", this.O0000Oo.O00000Oo);
            bundle.putString("mac", this.O00000oO);
            this.O00000Oo.notifyMessage(message.what, bundle);
            fiz.O000000o().O00000Oo();
            O00000oo();
            this.O0000oo.O00000o();
        } else if (i == 127) {
            this.O00000Oo.notifyMessage(message.what, null);
            O00000Oo("BleComboProcess handleMessage MSG_BLE_NOTIFY_TIME_OUT, current notifyStatus = " + this.O000O00o);
            O0000OOo().removeMessages(127);
            this.O0000oo0 = true;
            if (this.f17885O000000o != 2) {
                O00000oo();
                this.O0000oo.O00000o();
                int i2 = this.O00oOoOo;
                if (i2 != 8 && i2 != 10 && i2 != 11) {
                    O00000o0();
                }
            }
        }
    }

    private void O00000o() {
        O00000Oo("BleComboProcess onStopConnection");
        O0000OOo().removeMessages(112);
        O0000OOo().removeMessages(114);
        if (gnn.O00000oO) {
            gsy.O000000o(6, "WifiSettingUap", "Bind Network to NULL");
            this.O0000o.bindProcessToNetwork(null);
        }
    }

    public final void O000000o(int i, Bundle bundle) {
        if (i == 0) {
            int i2 = bundle.getInt("index", 0);
            this.O0000Ooo = true;
            O00000Oo("startConfigCombo".concat(String.valueOf(i2)));
            if (i2 != 0) {
                if (i2 == 1) {
                    O0000o0O();
                } else if (i2 == 2) {
                    O0000O0o();
                } else if (i2 == 3) {
                    O00000o();
                    this.f17885O000000o = 3;
                    O0000o0();
                }
            } else if (this.O00000Oo.isComboWithLogin()) {
                gjn.O000000o().O00000Oo(new hua<Pair<String, String>, hud>() {
                    /* class _m_j.gjr.AnonymousClass2 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        Pair pair = (Pair) obj;
                        gjr.this.O00000o0 = (String) pair.first;
                        gjr.this.O00000o = (String) pair.second;
                        gjr.this.O00000Oo.onLoginResult(gjr.this.O00000o0);
                        gjr gjr = gjr.this;
                        gjr.O000000o(gjr.O0000ooO);
                    }

                    public final void O000000o(hud hud) {
                        if (gjr.this.O00000Oo != null) {
                            gjr.this.O00000Oo.onError(1, hud);
                        }
                    }
                });
            } else {
                O000000o(this.O0000ooO);
            }
        }
    }

    public final void O00000Oo() {
        O00000Oo("BleComboProcess startConnectToBle");
        this.f17885O000000o = 0;
        this.O000O0Oo = 0;
        if (TextUtils.isEmpty(this.O0000o00)) {
            this.O00000Oo.onError(3, null);
            return;
        }
        if (this.O0000oo == null) {
            this.O0000oo = new gjz(this);
        }
        if (!TextUtils.isEmpty(this.O0000Oo.O0000oOO)) {
            this.O0000oo.O000000o(this.O0000Oo.O0000oOO);
        } else {
            this.O00000Oo.onError(5, null);
        }
        O0000OOo().sendEmptyMessageDelayed(125, O0000ooo);
    }

    public final void O000000o(final hua<String, hud> hua) {
        gjn.O000000o().O000000o(this.O0000Oo.O00000Oo, String.valueOf(this.O0000Oo.O00000o0), new hua<JSONObject, hud>() {
            /* class _m_j.gjr.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                gjr.O00000Oo(" getBindKeyX onSuccess ".concat(String.valueOf(jSONObject)));
                if (jSONObject == null || jSONObject.length() == 0) {
                    O000000o((hud) null);
                    return;
                }
                gjr.this.O0000o0 = jSONObject.optLong("timestamp");
                String optString = jSONObject.optString("bindKey");
                String optString2 = jSONObject.optString("bindKeyIndex");
                gjr gjr = gjr.this;
                if ("0".equals(optString2)) {
                    optString2 = null;
                }
                gjr.O0000o0O = optString2;
                hua.O000000o(optString);
            }

            public final void O000000o(hud hud) {
                gjr.O00000Oo(" getBindKeyX onFailure ".concat(String.valueOf(hud)));
                if (gjr.this.O0000Ooo) {
                    gjr.this.O000000o(new hua<String, hud>() {
                        /* class _m_j.gjr.AnonymousClass4.AnonymousClass1 */

                        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                            gjr.this.O0000o0 = 0;
                            gjr.this.O0000o0O = null;
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
            /* class _m_j.gjr.AnonymousClass5 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                gjr.O00000Oo("getBindKey onSuccess,key =".concat(String.valueOf(str)));
                hua.O000000o(str);
            }

            public final void O000000o(hud hud) {
                gjr.O000000o("getBindKey onFailure, code %d,msg %s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                int i = i;
                if (i == 0) {
                    String str = gjr.this.O0000Oo.O0000Ooo;
                    if (str != null) {
                        String str2 = str;
                        if (!TextUtils.isEmpty(str2)) {
                            gjr.O00000Oo("getBindKey from local");
                            hua.O000000o(str2);
                            return;
                        }
                    }
                    gjr.this.O00000Oo.onError(3, null);
                    return;
                }
                gjr.this.O000000o(hua, i - 1);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gjv.O000000o(boolean, _m_j.gju):void
     arg types: [int, _m_j.gju]
     candidates:
      _m_j.gjv.O000000o(java.lang.String, java.lang.Object[]):void
      _m_j.gjv.O000000o(boolean, _m_j.gju):void */
    public final void O000000o(String str) {
        int i;
        boolean z;
        MiotBleAdvPacket O000000o2;
        if (TextUtils.isEmpty(str)) {
            O00000Oo("BleComboProcessonSearchComboAddress mac is empty! ");
            if (O0000OOo().hasMessages(125)) {
                O0000OOo().removeMessages(125);
                O0000OOo().sendEmptyMessage(125);
            }
            this.O00000Oo.onError(6, null);
            return;
        }
        byte[] scanRecord = this.O00000Oo.getScanRecord(str);
        boolean z2 = true;
        if (scanRecord == null || (O000000o2 = O000000o(scanRecord)) == null || O000000o2.f6871O000000o == null) {
            z = true;
            i = 0;
        } else {
            i = O000000o2.f6871O000000o.O0000OOo;
            z = fea.O000000o(O000000o2.f6871O000000o.O0000Oo0);
        }
        if ((i == 0 || i == 2) && z) {
            this.O00000oO = str;
            this.O000O0Oo++;
            gju gju = new gju();
            gju.O00000Oo = this.O0000o00;
            gju.O00000oO = this.O0000o0;
            gju.O00000oo = this.O0000o0O;
            gju.O00000o0 = this.O0000Oo.O00000o;
            gju.O00000o = this.O0000Oo.O00000oO;
            gju.O0000O0o = this.O0000Oo.O0000O0o;
            gju.O0000OoO = this.O0000Oo.O0000Oo0;
            gju.O0000Oo0 = this.O0000Oo.O0000OOo;
            gju.f17913O000000o = String.valueOf(this.O0000Oo.O00000o0);
            gju.O0000OOo = this.O00000o;
            gju.O0000Oo = this.O0000Oo.O0000OoO;
            gkf gkf = this.O00000Oo;
            if (gkf != null) {
                gkf.onStartConnectBle(this.O00000oO);
            }
            if (this.O00000Oo.isComboWithLogin()) {
                this.O0000oo.O000000o(false, gju);
                return;
            }
            if (i != 0) {
                z2 = false;
            }
            this.O0000oo.O000000o(z2, gju);
            return;
        }
        O00000Oo("BleComboProcess don't support authMode = ".concat(String.valueOf(i)));
        if (O0000OOo().hasMessages(125)) {
            O0000OOo().removeMessages(125);
            O0000OOo().sendEmptyMessage(125);
        }
        this.O00000Oo.onError(2, null);
    }

    public final void O000000o(int i, String str, String str2) {
        O00000Oo("BleComboProcess onSendSSIDAndPassWd code = " + i + ", firmwareVersion = " + str + ", deviceDid = " + str2);
        this.O000O0OO = str2;
        this.O00000Oo.onConnectBleResult(i, str, str2);
        this.O00oOoOo = -1;
        if (i == 0) {
            if (!this.O0000oOo) {
                if (this.O0000Oo0 != null) {
                    this.O0000Oo0.registerReceiver(this.O000O0o, new IntentFilter("com.xiaomi.smarthome.bluetooth.connect_status_changed"));
                }
                O0000OOo().removeMessages(125);
                this.O0000oo.O000000o();
                this.O0000oo0 = false;
                O0000o0O();
                O0000OOo().sendEmptyMessageDelayed(127, O00oOooO);
            }
        } else if (i != -6 || this.O000O0Oo > 2) {
            if (O0000OOo().hasMessages(125)) {
                O0000OOo().removeMessages(125);
                this.O00000Oo.onError(7, Integer.valueOf(i));
                if (i == -6) {
                    fea.O000000o(this.O00000oO, 0);
                    O0000OOo().sendEmptyMessageDelayed(125, 2000);
                    return;
                }
                O0000OOo().sendEmptyMessage(125);
            }
        } else if (!this.O0000oOo) {
            fea.O000000o(this.O00000oO, 0);
            O0000OOo().postDelayed(new Runnable() {
                /* class _m_j.gjr.AnonymousClass6 */

                public final void run() {
                    gjr gjr = gjr.this;
                    gjr.O000000o(gjr.O00000oO);
                }
            }, 3000);
        }
    }

    private void O00000oo() {
        try {
            if (this.O0000Oo0 != null) {
                this.O0000Oo0.unregisterReceiver(this.O000O0o);
            }
        } catch (Exception unused) {
        }
    }

    private void O0000O0o() {
        O00000Oo("BleComboProcess onScDeviceBindToPassport isScComboWithLogin = " + this.O00000Oo.isComboWithLogin());
        if (this.O00000Oo.isComboWithLogin()) {
            this.f17885O000000o = 2;
            this.O00000Oo.startPassportAuth();
            return;
        }
        this.f17885O000000o = 3;
        O0000o0();
    }

    public final void O00000Oo(int i) {
        this.O000O00o = i;
        StringBuilder sb = new StringBuilder("BleComboProcess onNotifyStatus ");
        sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown ".concat(String.valueOf(i)) : "pwd error" : "unknown error" : "server connected" : "router connected" : "connecting router" : "NOTIFY_START");
        O00000Oo(sb.toString());
        if (O0000OOo().hasMessages(127)) {
            if (i >= 4 && i != 6) {
                this.O00oOoOo = i;
            }
            this.O00000Oo.notifyBleStatus(i);
            if (i != 2) {
                if (i == 3) {
                    O00000oo();
                    if (this.f17885O000000o == 2) {
                        this.O00000Oo.onBindPassportSuccess();
                    }
                    this.O0000oo.O00000o();
                    O0000OOo().removeMessages(127);
                    O00000o0();
                } else if (i == 4 || i == 5) {
                    O00000oo();
                    O0000OOo().removeMessages(127);
                    this.O00000Oo.onError(4, null);
                } else if (i != 6) {
                    if (i == 9) {
                        O00000oo();
                        O0000OOo().removeMessages(127);
                        this.O0000oo.O00000o();
                        this.O00000Oo.onError(8, null);
                    } else if (i == 12) {
                        O00000oo();
                        O0000OOo().removeMessages(127);
                        this.O0000oo.O00000o();
                        this.O00000Oo.onError(9, null);
                    }
                } else if (this.f17885O000000o == 2) {
                    this.O00000Oo.onBindPassportSuccess();
                    this.f17885O000000o = 3;
                    O0000o0();
                }
            } else if (this.O00000Oo.isComboWithLogin() && this.f17885O000000o == 1) {
                this.O00000Oo.onSendPwdAndPwdResult(0);
                this.f17885O000000o = 2;
                this.O00000Oo.startPassportAuth();
            }
        }
    }

    public final void O00000o0() {
        if (O0000OOo() != null) {
            O0000OOo().sendEmptyMessageDelayed(112, 0);
        }
    }

    private String O00000o(String str) {
        String str2 = this.O0000Oo.O0000oOo;
        if (TextUtils.isEmpty(str2) || str2.length() != 4) {
            return null;
        }
        try {
            return str.substring(0, 12) + str2.substring(0, 2) + ":" + str2.substring(2, 4);
        } catch (Exception unused) {
            return "";
        }
    }

    private void O0000o0() {
        String O00000o2 = O00000o(this.O00000oO);
        O00000Oo("BleComboProcess scanNewDevice bssid = " + O00000o2 + ", mDeviceDid = " + this.O000O0OO + ", mBindKey = " + this.O0000o00);
        hto hto = this.O000O0o0;
        if (hto == null) {
            this.O000O0o0 = new hto(O00000o2, this.O000O0OO, this.O0000o00, this.O0000Oo.O00000Oo);
        } else {
            hto.O000000o(O00000o2, this.O000O0OO, this.O0000o00, this.O0000Oo.O00000Oo);
        }
        this.O00000Oo.onStartPollNewDevice();
        htk.O000000o().O000000o(this.O000O0o0, O00oOooo, this.O00000Oo.getPollDeviceCallback());
    }

    private void O0000o0O() {
        int i = this.O000O00o;
        if (i == 0) {
            this.f17885O000000o = 1;
        } else if (i == 4) {
            O0000o0o();
        } else if (i == 3) {
            O0000OOo().sendEmptyMessageDelayed(127, O00oOooO);
            O00000Oo(this.O000O00o);
        } else if (gnl.O00000o0(this.O00000oO)) {
            O0000OOo().sendEmptyMessageDelayed(127, O00oOooO);
            O00000Oo(this.O000O00o);
        } else {
            O0000OOo().removeMessages(127);
            O00000o0();
        }
    }

    private void O0000o0o() {
        O00000Oo("BleComboProcess retryComboConnect");
        this.O000O00o = 0;
        this.O0000oo.O00000o0();
        O0000OOo().removeMessages(125);
        O0000OOo().removeMessages(127);
        this.O0000oo.O000000o();
        O0000OOo().sendEmptyMessageDelayed(127, O00oOooO);
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012 A[Catch:{ Exception -> 0x001e }] */
    private static MiotBleAdvPacket O000000o(byte[] bArr) {
        fgb fgb = new fgb(bArr);
        MiotBleAdvPacket miotBleAdvPacket = null;
        try {
            Iterator<fga> it = fgb.f16254O000000o.iterator();
            while (it.hasNext() && (miotBleAdvPacket = fgc.O000000o(it.next())) == null) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
            }
        } catch (Exception unused) {
        }
        return miotBleAdvPacket;
    }

    public final void O000000o(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("login_result", false);
            O00000Oo("BleComboProcess onActivityResult login_result = ".concat(String.valueOf(booleanExtra)));
            if (booleanExtra) {
                if (this.f17885O000000o == 2) {
                    this.O00000Oo.onBindPassportSuccess();
                }
                this.f17885O000000o = 3;
                O0000o0();
            }
        } else if (i == 101) {
            O00000Oo("BleComboProcess onActivityResult REQUEST_CODE_SYSTEM_ACCOUNT");
            if (this.O0000oo0) {
                O0000o0();
            }
        }
    }
}
