package _m_j;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.CameraApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import java.util.Locale;
import org.json.JSONObject;

public final class fop {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16770O000000o = "";
    public foq O00000Oo;
    public BleDevice O00000o;
    public Context O00000o0;
    public BleConnectOptions O00000oO;
    public ISecureConnectHandler O00000oo;
    public boolean O0000O0o = false;
    public int O0000OOo;
    public BleComboWifiConfig O0000Oo0;

    public fop(Context context, String str) {
        this.O00000o0 = context;
        this.f16770O000000o = str;
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 31000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 15000;
        this.O00000oO = o000000o.O000000o();
    }

    public final void O000000o(String str) {
        BleConnectOptions bleConnectOptions = this.O00000oO;
        if (str == null) {
            bleConnectOptions.O00000oO = "";
        } else {
            bleConnectOptions.O00000oO = str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0135  */
    public final void O000000o(boolean z, final gle gle) {
        boolean z2;
        htj.O000000o(this.O00000o0, this.O00000o.model, this.O00000o.mac);
        int i = 1;
        if (!this.O00000o.isOwner() && !fno.O000000o().O0000OoO(this.O00000o.mac)) {
            this.O00000o.setOwner(true);
            BleDevice bleDevice = this.O00000o;
            bleDevice.ownerId = "";
            bleDevice.ownerName = "";
            this.O00000o = bleDevice;
            foc.O00000o(this.O00000o.mac, "");
            foc.O00000Oo(this.O00000o.mac, "");
            foc.O0000Oo0(this.O00000o.mac);
        }
        if (O000000o()) {
            fte.O00000Oo(String.format(Locale.getDefault(), "%s Start bleMeshBind, rssi = %d", this.f16770O000000o, Integer.valueOf(this.O00000o.rssi)));
            this.O0000OOo = 4;
            fpo.O00000o(this.O00000o.mac, this.O00000oO, gle);
            return;
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.O00000o.model);
        if (O00000oO2 == null || O00000oO2.O000O00o() != 1) {
            BleDevice O00000o02 = fob.O00000o0(this.O00000o.mac);
            MiotBleAdvPacket O00000Oo2 = this.O00000o.O00000Oo();
            MiotBleAdvPacket miotBleAdvPacket = null;
            if (O00000o02 != null) {
                miotBleAdvPacket = O00000o02.O00000Oo();
            }
            if ((O00000Oo2 == null || O00000Oo2.f6871O000000o == null || O00000Oo2.f6871O000000o.O0000OOo != 1) && (miotBleAdvPacket == null || miotBleAdvPacket.f6871O000000o == null || miotBleAdvPacket.f6871O000000o.O0000OOo != 1)) {
                z2 = false;
                if (z2) {
                    fte.O00000Oo(String.format(Locale.getDefault(), "%s Start Normal Bind, rssi = %d", this.f16770O000000o, Integer.valueOf(this.O00000o.rssi)));
                    BleDevice O00000o03 = fob.O00000o0(this.O00000o.mac);
                    if (O00000o03 == null || O00000o03.O00000Oo() == null || O00000o03.O00000Oo().f6871O000000o == null) {
                        fte.O00000Oo(String.format(Locale.getDefault(), "%s get auth type, rssi = %d", this.f16770O000000o, Integer.valueOf(this.O00000o.rssi)));
                        O000000o(new Response.BleConnectResponse(gle, z) {
                            /* class _m_j.$$Lambda$fop$SDzAKRWQ4caHF4gOtOO2mWwpyk */
                            private final /* synthetic */ gle f$1;
                            private final /* synthetic */ boolean f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onResponse(int i, Object obj) {
                                fop.this.O000000o(this.f$1, this.f$2, i, (Bundle) obj);
                            }
                        }, 1);
                        return;
                    } else if (O00000o03.O00000Oo().f6871O000000o.O0000OOo == 2) {
                        fte.O00000Oo(String.format("%s Start bleStandardAuthBind", this.f16770O000000o));
                        this.O0000OOo = 2;
                        this.O00000oo = fpo.O00000oo(this.O00000o.mac, this.O00000oO, gle);
                        return;
                    } else {
                        fte.O00000Oo(String.format("%s Start secureConnect", this.f16770O000000o));
                        this.O0000OOo = 1;
                        this.O00000oo = fpo.O000000o(this.O00000o.mac, this.O00000oO, gle);
                        return;
                    }
                } else if (this.O0000O0o) {
                    fte.O00000Oo(String.format(Locale.getDefault(), "%s Start securityChipConnect, rssi = %d", this.f16770O000000o, Integer.valueOf(this.O00000o.rssi)));
                    this.O0000OOo = 3;
                    if (this.O0000Oo0 == null) {
                        this.O00000oo = fpo.O00000o0(this.O00000o.mac, this.O00000oO, gle);
                        return;
                    } else {
                        O000000o(new Response.BleResponse() {
                            /* class _m_j.fop.AnonymousClass1 */

                            public final void onResponse(int i, Object obj) {
                                fop fop = fop.this;
                                fop.O00000oo = fpo.O00000o0(fop.O00000o.mac, fop.this.O00000oO, gle);
                            }
                        });
                        return;
                    }
                } else {
                    fte.O00000Oo(String.format(Locale.getDefault(), "%s get lock version after connect, rssi = %d", this.f16770O000000o, Integer.valueOf(this.O00000o.rssi)));
                    if (eyr.O00000Oo().O0000Ooo(this.O00000o.model)) {
                        i = 10;
                    }
                    O000000o(new Response.BleConnectResponse(gle, z) {
                        /* class _m_j.$$Lambda$fop$y_0I_gJhE44jp21OPGsOqX5rCc */
                        private final /* synthetic */ gle f$1;
                        private final /* synthetic */ boolean f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onResponse(int i, Object obj) {
                            fop.this.O00000Oo(this.f$1, this.f$2, i, (Bundle) obj);
                        }
                    }, i);
                    return;
                }
            }
        }
        z2 = true;
        if (z2) {
        }
    }

    public final String O000000o(int i, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("error code = ".concat(String.valueOf(i)));
            sb.append(", isScanned = ".concat(String.valueOf(z)));
            int i2 = 0;
            BleDevice O00000o02 = fob.O00000o0(this.O00000o.mac);
            if (O00000o02 != null) {
                i2 = O00000o02.rssi;
            }
            sb.append(", rssi = ".concat(String.valueOf(i2)));
            sb.append(", model = " + this.O00000o.model);
            sb.append(", defaultLocale = " + Locale.getDefault());
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo == null) {
                O00oOooo = Locale.getDefault();
            }
            sb.append(", chooseLocale = ".concat(String.valueOf(O00oOooo)));
            ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
            StringBuilder sb2 = new StringBuilder(", server = ");
            if (O000000o2 == null) {
                str = null;
            } else {
                str = O000000o2.f7546O000000o + ":" + O000000o2.O00000Oo + ":" + O000000o2.O00000o0;
            }
            sb2.append(str);
            sb.append(sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public final String O000000o(int i, int i2) {
        return ((Object) this.O00000o0.getResources().getText(i)) + " (" + i2 + ")";
    }

    public final boolean O000000o() {
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.O00000o.model);
        if (O00000oO2 != null && O00000oO2.O0000o() == Device.PID_BLE_MESH) {
            return true;
        }
        BleDevice O00000o02 = fob.O00000o0(this.O00000o.mac);
        MiotBleAdvPacket O00000Oo2 = this.O00000o.O00000Oo();
        MiotBleAdvPacket miotBleAdvPacket = null;
        if (O00000o02 != null) {
            miotBleAdvPacket = O00000o02.O00000Oo();
        }
        if ((O00000Oo2 == null || O00000Oo2.f6871O000000o == null || !O00000Oo2.f6871O000000o.O00000oO) && (O00000o02 == null || miotBleAdvPacket == null || miotBleAdvPacket.f6871O000000o == null || !miotBleAdvPacket.f6871O000000o.O00000oO)) {
            return false;
        }
        return true;
    }

    public final int O00000Oo() {
        int i = this.O0000OOo;
        if (i == 1) {
            return R.string.ble_new_normal_auth_step_success;
        }
        if (i != 2) {
            return (i == 3 || i != 4) ? R.string.ble_new_auth_step_success : R.string.ble_new_mesh_auth_step_success;
        }
        return R.string.ble_new_standard_auth_step_success;
    }

    public final int O00000o0() {
        int i = this.O0000OOo;
        if (i == 1) {
            return R.string.ble_new_normal_auth_step_failed;
        }
        if (i != 2) {
            return (i == 3 || i != 4) ? R.string.ble_new_auth_step_failed : R.string.ble_new_mesh_auth_step_failed;
        }
        return R.string.ble_new_standard_auth_step_failed;
    }

    public final String O000000o(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return ((Object) this.O00000o0.getResources().getText(R.string.ble_new_bind_step_failed)) + " (" + i + ")";
        }
        return ((Object) this.O00000o0.getResources().getText(R.string.ble_new_bind_step_failed)) + " (" + i + ", did = " + str + ")";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(final gle gle, final boolean z, int i, Bundle bundle) {
        if (O00000oo()) {
            if (i == 0) {
                XmBluetoothManager.getInstance().getBleMeshFirmwareVersion(this.O00000o.mac, new Response.BleReadFirmwareVersionResponse() {
                    /* class _m_j.fop.AnonymousClass2 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        String str = (String) obj;
                        if (i != 0 || TextUtils.isEmpty(str)) {
                            dco O000000o2 = dco.O000000o();
                            O000000o2.O00000Oo(fop.this.f16770O000000o + " read lock version failed: " + fop.this.O000000o(i, z));
                            fte.O00000Oo(String.format(Locale.getDefault(), "%s read lock version failed: %d", fop.this.f16770O000000o, Integer.valueOf(i)));
                            if (fop.this.O00000Oo != null) {
                                fop.this.O00000Oo.refreshUI(i, 11);
                            }
                            fop.this.O00000o.O00000oo();
                            return;
                        }
                        fop.this.O0000O0o = true;
                        if (!fqx.O00000Oo(str) || fop.this.O00000Oo == null) {
                            fte.O00000Oo(String.format(Locale.getDefault(), "%s Start securityChipConnect, rssi = %d", fop.this.f16770O000000o, Integer.valueOf(fop.this.O00000o.rssi)));
                            fop fop = fop.this;
                            fop.O0000OOo = 3;
                            if (fop.O0000Oo0 == null) {
                                fop fop2 = fop.this;
                                fop2.O00000oo = fpo.O00000o0(fop2.O00000o.mac, fop.this.O00000oO, gle);
                                return;
                            }
                            fop.this.O000000o(new Response.BleResponse() {
                                /* class _m_j.fop.AnonymousClass2.AnonymousClass1 */

                                public final void onResponse(int i, Object obj) {
                                    fop.this.O00000oo = fpo.O00000o0(fop.this.O00000o.mac, fop.this.O00000oO, gle);
                                }
                            });
                            return;
                        }
                        fop.this.O00000Oo.gotoPage();
                    }
                });
                return;
            }
            dco O000000o2 = dco.O000000o();
            O000000o2.O00000Oo(this.f16770O000000o + " connect failed when read lock version: " + O000000o(i, z));
            fte.O00000Oo(String.format(Locale.getDefault(), "%s connect failed when read lock version: %d", this.f16770O000000o, Integer.valueOf(i)));
            foq foq = this.O00000Oo;
            if (foq != null) {
                foq.refreshUI(i, 11);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final gle gle, boolean z, int i, Bundle bundle) {
        if (O00000oo()) {
            if (i == 0) {
                XmBluetoothManager.getInstance().isBleCharacterExist(this.O00000o.mac, glb.f17954O000000o, glb.O0000o, new Response.BleResponse<Void>() {
                    /* class _m_j.fop.AnonymousClass3 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        if (i == 0) {
                            fte.O00000Oo(String.format("%s Start bleStandardAuthBind after read character", fop.this.f16770O000000o));
                            fop fop = fop.this;
                            fop.O0000OOo = 2;
                            fop.O00000oo = fpo.O00000oo(fop.O00000o.mac, fop.this.O00000oO, gle);
                            return;
                        }
                        fte.O00000Oo(String.format("%s Start secureConnect after read character", fop.this.f16770O000000o));
                        fop fop2 = fop.this;
                        fop2.O0000OOo = 1;
                        fop2.O00000oo = fpo.O000000o(fop2.O00000o.mac, fop.this.O00000oO, gle);
                    }
                });
                return;
            }
            dco O000000o2 = dco.O000000o();
            O000000o2.O00000Oo(this.f16770O000000o + " connect failed when read device character: " + O000000o(i, z));
            fte.O00000Oo(String.format(Locale.getDefault(), "%s connect failed when read device character: %d", this.f16770O000000o, Integer.valueOf(i)));
            foq foq = this.O00000Oo;
            if (foq != null) {
                foq.refreshUI(i, 11);
            }
        }
    }

    private void O000000o(Response.BleConnectResponse bleConnectResponse, int i) {
        fte.O00000Oo("connectDirect retrytime: ".concat(String.valueOf(i)));
        if (O00000oo()) {
            XmBluetoothManager.getInstance().connect(this.O00000o.mac, new Response.BleConnectResponse(bleConnectResponse, i) {
                /* class _m_j.$$Lambda$fop$18IygvcUuzrvTPWxpILMCyRd3mo */
                private final /* synthetic */ Response.BleConnectResponse f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onResponse(int i, Object obj) {
                    fop.this.O000000o(this.f$1, this.f$2, i, (Bundle) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Response.BleConnectResponse bleConnectResponse, int i, int i2, Bundle bundle) {
        int i3;
        if (i2 == 0 || i <= 0) {
            bleConnectResponse.onResponse(i2, bundle);
            return;
        }
        if (eyr.O00000Oo().O0000Ooo(this.O00000o.model)) {
            CoreApi.O000000o().O000000o((String) null, 30, (Bundle) null, (IBleResponse) null);
        }
        eyr O00000Oo2 = eyr.O00000Oo();
        if (eyr.O000000o(this.O00000o.model, O00000Oo2.O0000oo0)) {
            i3 = O00000Oo2.O0000oo;
        } else {
            i3 = 2000;
        }
        CommonApplication.getGlobalHandler().postDelayed(new Runnable(bleConnectResponse, i) {
            /* class _m_j.$$Lambda$fop$E2G_U4wwUKKMKRHTYOdJTKhiTuA */
            private final /* synthetic */ Response.BleConnectResponse f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                fop.this.O00000Oo(this.f$1, this.f$2);
            }
        }, (long) i3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Response.BleConnectResponse bleConnectResponse, int i) {
        O000000o(bleConnectResponse, i - 1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
     arg types: [java.lang.String, int, _m_j.fop$4]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void */
    public final void O00000o() {
        fte.O00000Oo(String.format("%s Start load plugin", this.f16770O000000o));
        if (CoreApi.O000000o().O0000OoO(this.O00000o.model) == null && CoreApi.O000000o().O0000Oo(this.O00000o.model) == null) {
            CoreApi.O000000o().O000000o(this.O00000o.model, true, (CoreApi.O0000OOo) new CoreApi.O0000OOo() {
                /* class _m_j.fop.AnonymousClass4 */
                private long O00000Oo = 0;

                public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                }

                public final void onProgress(String str, float f) {
                }

                public final void onStart(String str, PluginDownloadTask pluginDownloadTask) {
                    this.O00000Oo = System.currentTimeMillis();
                }

                public final void onSuccess(String str) {
                    if (this.O00000Oo > 0 && str != null) {
                        hxi.O0000Oo.O000000o(System.currentTimeMillis() - this.O00000Oo, str);
                    }
                    if (fop.this.O00000oo()) {
                        fte.O00000Oo(String.format("%s Plugin Download onSuccess", fop.this.f16770O000000o));
                        fop.this.O00000Oo.onSuccess();
                    }
                }

                public final void onFailure(PluginError pluginError) {
                    if (fop.this.O00000oo()) {
                        fop.this.O00000Oo.onFailed();
                        fte.O00000Oo(String.format("%s Plugin Download onFailure %s", fop.this.f16770O000000o, pluginError.O000000o(fop.this.O00000o0)));
                        fok.O000000o(fop.this.O00000o.mac, "bluetooth_download_plugin_failure");
                    }
                }

                public final void onCancel() {
                    if (fop.this.O00000oo()) {
                        fop.this.O00000Oo.onFailed();
                        fte.O00000Oo(String.format("%s Plugin Download onCancel", fop.this.f16770O000000o));
                        fok.O000000o(fop.this.O00000o.mac, "bluetooth_download_plugin_failure");
                    }
                }
            });
            return;
        }
        foq foq = this.O00000Oo;
        if (foq != null) {
            foq.onSuccess();
        }
        fte.O00000Oo(String.format("%s Plugin Download onSuccess", this.f16770O000000o));
    }

    public final void O00000oO() {
        Activity activity = (Activity) this.O00000o0;
        if (activity != null) {
            activity.finish();
            dcp.O000000o().O000000o(activity);
        }
    }

    public static void O000000o(BleResponse bleResponse) {
        if (gnl.O00000Oo()) {
            fmd.O00000Oo(new BleResponse() {
                /* class _m_j.$$Lambda$fop$c_j53ET3it4LFIgtYGQy4pFa8 */

                public final void onResponse(int i, Object obj) {
                    fmd.O000000o(BleResponse.this);
                }
            });
        } else {
            fmd.O000000o(bleResponse);
        }
    }

    public final boolean O00000oo() {
        Activity activity = (Activity) this.O00000o0;
        if (activity == null || this.O00000Oo == null) {
            return false;
        }
        return gqd.O000000o(activity);
    }

    public static boolean O000000o(String... strArr) {
        boolean z;
        if (strArr != null) {
            for (String str : strArr) {
                Context appContext = CommonApplication.getAppContext();
                if (Build.VERSION.SDK_INT >= 23 && (appContext.getApplicationInfo().targetSdkVersion >= 23 ? appContext.checkSelfPermission(str) != 0 : g.O000000o(appContext, str, Binder.getCallingPid(), Binder.getCallingUid(), appContext.getPackageName()) != 0)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void O000000o(final Response.BleResponse bleResponse) {
        CameraApi.getInstance().getBindKeyAndExpireTime(this.O00000o0, new fsm<JSONObject, fso>() {
            /* class _m_j.fop.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                fte.O00000Oo(" get bind key onSuccess: ".concat(String.valueOf(jSONObject)));
                fop.this.O0000Oo0.O0000OOo = jSONObject.optString("bindkey");
                bleResponse.onResponse(0, "");
            }

            public final void onFailure(fso fso) {
                bleResponse.onResponse(-1, "");
            }
        });
    }
}
