package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.ConfigStep;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;

public class hwe extends ConfigStep implements gkf {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f828O000000o;
    public String O00000Oo = "";
    public int O00000o;
    public String O00000o0;
    public boolean O00000oO = false;
    public gjr O00000oo;
    public boolean O0000O0o = false;
    private boolean O0000OOo = true;
    private String O0000Oo;
    private int O0000Oo0 = 0;
    private String O0000OoO = "";
    private String O0000Ooo = null;
    private long O0000o = 60000;
    private boolean O0000o0 = false;
    private Handler O0000o00;
    private boolean O0000o0O = false;
    private htl O0000o0o = new htm() {
        /* class _m_j.hwe.AnonymousClass1 */

        public final void onDeviceConnectionFailure(int i) {
            hwe hwe = hwe.this;
            hwe.O000000o("BleComboBleWayV2 DeviceFinderCallback.onDeviceConnectionFailure " + i + "currentIndex = " + hwe.this.O00000oo.f17885O000000o, new Object[0]);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwe.this.f828O000000o, BindStep.STEP_CHECK_BIND, i, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo("error", String.valueOf(i));
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (hwe.this.O00000oo.f17885O000000o == 2) {
                hwe hwe2 = hwe.this;
                hwe2.O000OoOo = "3000.2.5";
                hwe2.O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
                return;
            }
            if (i == -6) {
                hwe.this.O00000Oo(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                if (!hwe.this.O000OOoO) {
                    hwe.this.O000000o("BleComboBleWayV2 DeviceFinder already bind!", new Object[0]);
                    SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hwe.this.f828O000000o, 3);
                }
            }
            fob.O000000o(hwe.this.f828O000000o, hwe.this.O00000o0);
        }

        public final void onDeviceConnectionSuccess(List<Device> list) {
            hwe hwe = hwe.this;
            hwe.O000000o("BleComboBleWayV2 DeviceFinderCallback.onDeviceConnectionSuccess currentIndex = " + hwe.this.O00000oo.f17885O000000o, new Object[0]);
            fte.O00000Oo("BleComboBleWayStep DeviceFinderCallback.onDeviceConnectionSuccess currentIndex = " + hwe.this.O00000oo.f17885O000000o);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwe.this.f828O000000o, BindStep.STEP_CHECK_BIND);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(0);
            if (hwe.this.O00000oo.f17885O000000o == 2) {
                hwe.this.e_(2);
            }
            hwe.this.O00000oo.f17885O000000o = 3;
            hwe hwe2 = hwe.this;
            hwe2.O000OOo = false;
            hwe2.O000OoO0 = true;
            hwe2.e_(3);
            fob.O000000o(hwe.this.f828O000000o, hwe.this.O00000o0);
        }

        public final void onDeviceConnectionFailure() {
            hwe hwe = hwe.this;
            hwe.O000000o("BleComboBleWayV2 DeviceFinderCallback.onDeviceConnectionFailure currentIndex = " + hwe.this.O00000oo.f17885O000000o, new Object[0]);
            fte.O00000Oo("BleComboBleWayStep DeviceFinderCallback.onDeviceConnectionFailure currentIndex = " + hwe.this.O00000oo.f17885O000000o);
            SmartConfigRouterFactory.getStatBindManager().endBindStep(hwe.this.f828O000000o, BindStep.STEP_CHECK_BIND, "onDeviceConnectionFailure");
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(1201);
            if (hwe.this.O00000oo.f17885O000000o == 2) {
                hwe hwe2 = hwe.this;
                hwe2.O000OoOo = "3000.2.5";
                hwe2.O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
                return;
            }
            fob.O000000o(hwe.this.f828O000000o, hwe.this.O00000o0);
        }
    };
    private int O000OooO = -1;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void O000000o(Context context) {
        this.O0000o00 = new Handler(Looper.getMainLooper());
        this.f828O000000o = (String) htr.O000000o().O000000o("device_model");
        this.O00000o0 = (String) htr.O000000o().O000000o("combo_ble_mac");
        htr.O000000o().O00000Oo("key_report_hash_mac", this.O00000o0);
        this.O0000Oo = (String) htr.O000000o().O000000o("combo_ble_key");
        O000000o("BleComboBleWayV2 onCreateStep model = " + this.f828O000000o + ", combokey = " + this.O0000Oo, new Object[0]);
        htr.O000000o().O00000Oo("combo_strategy", 13);
        this.O00000oo = new gjr(this);
        gjr gjr = this.O00000oo;
        String O00000Oo2 = htr.O000000o().O00000Oo();
        String O00000o02 = htr.O000000o().O00000o0();
        long longValue = Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).longValue();
        String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
        String countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
        if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
            countryCode = "CN";
        }
        int intValue = ((Integer) htr.O000000o().O000000o("gmt_offset", 28800)).intValue();
        gkd gkd = new gkd();
        gkd.f17942O000000o = this.O000O0oo;
        gkd.O00000o = O00000Oo2;
        gkd.O00000oO = O00000o02;
        gkd.O00000o0 = longValue;
        gkd.O00000Oo = this.f828O000000o;
        gkd.O0000O0o = this.O0000oo0.type;
        gkd.O0000OOo = countryDomain;
        gkd.O0000Oo0 = countryCode;
        gkd.O0000Oo = intValue;
        gkd.O0000OoO = (String) htr.O000000o().O000000o("gmt_tz", "");
        gkd.O0000Ooo = (String) htr.O000000o().O000000o("wifi_bind_key");
        gkd.O0000oOO = this.O00000o0;
        gkd O00000Oo3 = gkd.O000000o().O00000Oo();
        O00000Oo3.O0000o = (long) (eyr.O00000Oo().O0000Oo0(this.f828O000000o) + 60000);
        O00000Oo3.O0000oOo = this.O0000Oo;
        gjr.O000000o(context, (List<gke>) null, O00000Oo3);
        super.O000000o(context);
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connecting_show(this.f828O000000o);
        if (!gnl.O00000Oo()) {
            this.O000OOo = false;
        }
    }

    public final void z_() {
        this.O00000oo.f17885O000000o = 0;
        this.O0000OOo = true;
    }

    public final SmartConfigStep.Step O00000o(int i) {
        int i2;
        int i3 = i;
        this.O000OOoo = true;
        fob.O000000o(this.f828O000000o, this.O00000o0);
        this.O00000oo.O000000o(i3);
        if (i3 == 0) {
            O000000o("BleComboBleWayV2 onStageTimeOut CONNECT_INDEX, mUseBleConfig = " + this.O0000OOo, new Object[0]);
            this.O000OoOo = "3000.2.2";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.f828O000000o, BindStep.STEP_TRANSFER_CONFIG, "ble connect failed");
            int i4 = 2101;
            if (TextUtils.isEmpty(this.O00000Oo)) {
                i4 = 2102;
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.f828O000000o, O0000O0o(i4), this.O0000OOo ? 1 : 0, "", "", this.O000Oo00, this.O00000Oo);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.f828O000000o, 1);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.f828O000000o, O0000O0o(i4), this.O000Oo00, this.O000OOo));
            }
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                return SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR;
            }
            this.O000OoOo = "3000.2.1";
            return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
        } else if (i3 == 1) {
            O000000o("BleComboBleWayV2 onStageTimeOut SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.O0000OOo, new Object[0]);
            this.O000OoOo = "3000.2.3";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.f828O000000o, BindStep.STEP_TRANSFER_CONFIG, "transfer info failed");
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    hve statPageV2Manager = SmartConfigRouterFactory.getStatPageV2Manager();
                    String str = this.f828O000000o;
                    int O0000O0o2 = O0000O0o(2401);
                    boolean z = this.O0000OOo;
                    statPageV2Manager.page_device_fail4Combo(0, str, O0000O0o2, z ? 1 : 0, "", "", this.O000Oo00, this.O00000Oo);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.f828O000000o, 2);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.f828O000000o, O0000O0o(2401), this.O000Oo00, this.O000OOo));
            }
            if (TextUtils.isEmpty(this.O00000Oo)) {
                return SmartConfigStep.Step.STEP_FORCE_BIND_KEY_ERROR;
            }
            if (!this.O0000OOo) {
                if (this.O0000Oo0 == 1) {
                    return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
                }
                PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.f828O000000o);
                if (pluginInfo == null || pluginInfo.O0000ooO() == 0) {
                    return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_ERROR;
                }
                return SmartConfigStep.Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR;
            } else if (this.O000OooO > 0) {
                hxi.O00000o0.O000000o(this.O000OooO, this.O0000OoO, this.f828O000000o);
                int i5 = this.O000OooO;
                if (i5 == 5) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_AUTHENTICATION_ERROR");
                    this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_transfer_device_step_success, (int) R.string.ble_combo_connect_title_loading);
                    Resources resources = this.O000O0o0.getResources();
                    ddg ddg = this.O000O0o0;
                    ddg.O000000o(resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), resources.getString(R.string.ble_combo_network_title_loading));
                    return SmartConfigStep.Step.STEP_BLE_PWD_ERROR;
                } else if (i5 == 4) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_UNKNONW_ERROR");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i5 == 9) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_AUTH_FAIL");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_AUTH_FAIL_09;
                } else if (i5 == 12) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_CONNECT_NETWORK_FAIL");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_NETWORK_0C;
                } else if (i5 == 8) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_FIND_ROUTER_FAIL");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_CANNOT_FIND_ROUTER_08;
                } else if (i5 == 10) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_WEAK_WIFI");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_WEAK_NETWORK_0A;
                } else if (i5 != 11) {
                    return null;
                } else {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_COMBO_BLE_ERROR_DHCP_FAIL");
                    return SmartConfigStep.Step.STEP_COMBO_BLE_ERROR_DHCP_FAIL_0B;
                }
            } else {
                hxi.O00000o0.O000000o(this.O00000o, this.O0000OoO, this.f828O000000o);
                int i6 = this.O00000o;
                if (i6 == 0) {
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                }
                if (i6 == 1) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_CONNECTING_ROUTER");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i6 == 2) {
                    fte.O00000Oo(">>> current notifyStatus == NOTIFY_CONNECTING_ROUTER");
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else if (i6 == 3) {
                    return SmartConfigStep.Step.STEP_BLE_SEND_ERROR;
                } else {
                    return null;
                }
            }
        } else if (i3 != 3) {
            return null;
        } else {
            O000000o("BleComboBleWayV2 onStageTimeOut GET_NEW_DEVICE_INDEX，mUseBleConfig = " + this.O0000OOo, new Object[0]);
            this.O000OoOo = "3000.2.4";
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.f828O000000o, BindStep.STEP_CHECK_BIND, "get new device failed");
            O00oOooO();
            if (!hze.O000000o(this.O000O0oo)) {
                this.O000OOo = false;
            }
            int i7 = this.O000OooO;
            if (i7 > 0) {
                i2 = O0000O0o(gon.O000000o(true, this.O00000oO, i7));
            } else {
                i2 = O0000O0o(gon.O000000o(true, this.O00000oO, this.O00000o));
            }
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                int i8 = this.O00000o == 3 ? 2 : 1;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.f828O000000o, i2, i8, "", this.O00000o0, this.O000Oo00, this.O00000Oo);
                }
                SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.f828O000000o, 3);
            }
            if (this.O000Oo0o) {
                this.O000Oo0O.push(new hxy(0L, this.f828O000000o, i2, this.O000Oo00, this.O000OOo));
            }
            return SmartConfigStep.Step.STEP_FIND_DEVICE_FAILED;
        }
    }

    public final void B_() {
        this.O000O0o0.O000000o((int) R.string.ble_combo_connect_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
        this.O000O0o0.O000000o(1);
    }

    public final void C_() {
        Resources resources = this.O000O0o0.getResources();
        int i = this.O00000oo.f17885O000000o;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_connect_device_step_success, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o((int) R.string.ble_combo_transfer_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(2);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_transfer_device_step_success, (int) R.string.ble_combo_connect_title_loading);
            if (O0000o0o()) {
                this.O000O0o0.O000000o((int) R.string.ble_new_bind_step_loading, (int) R.string.ble_combo_connect_title_loading);
            } else {
                ddg ddg = this.O000O0o0;
                ddg.O000000o(resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), resources.getString(R.string.ble_combo_network_title_loading));
            }
            this.O000O0o0.O000000o(3);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_new_bind_step_success, (int) R.string.ble_combo_connect_title_loading);
            ddg ddg2 = this.O000O0o0;
            ddg2.O000000o(resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), resources.getString(R.string.ble_combo_network_title_loading));
            this.O000O0o0.O000000o(3);
        } else if (i == 3) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.SUCCESS, (int) R.string.ble_combo_device_connect_network_step_success, (int) R.string.ble_combo_network_title_loading);
        }
    }

    public final void O00000o0(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", i);
        if (i == 0) {
            O000000o("BleComboBleWayV2 startConnection CONNECT_INDEX, mUseBleConfig = " + this.O0000OOo, new Object[0]);
            this.O00000oo.O000000o(0, bundle);
            SmartConfigRouterFactory.getStatBindManager().startBindStep(this.f828O000000o, BindStep.STEP_TRANSFER_CONFIG);
        } else if (i == 1) {
            O000000o("BleComboBleWayV2 startConnection SEND_SSID_AND_PASSWD_INDEX, mUseBleConfig = " + this.O0000OOo, new Object[0]);
            this.O00000oo.O000000o(0, bundle);
        } else if (i == 2) {
            this.O0000Ooo = (String) htr.O000000o().O000000o("sc_ble_login_url");
            O000000o("BleComboBleWayV2 startConnection SC_BIND_PASSPORT_INDEX mLoginUrl = " + this.O0000Ooo, new Object[0]);
            if (!TextUtils.isEmpty(this.O0000Ooo)) {
                this.O00000oo.O000000o(0, bundle);
                return;
            }
            this.O000OoOo = "3000.2.5";
            O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
        } else if (i == 3) {
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.f828O000000o, BindStep.STEP_TRANSFER_CONFIG);
            this.O00000oo.O000000o(0, bundle);
            this.O00000oo.f17885O000000o = 3;
        }
    }

    public boolean isComboWithLogin() {
        PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.f828O000000o);
        return pluginInfo != null && pluginInfo.O00000o() == 20;
    }

    public void onGetBindKeySuccess(String str) {
        this.O00000Oo = str;
    }

    public void onLoginResult(String str) {
        this.O0000Ooo = str;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void onError(int i, Object obj) {
        switch (i) {
            case 1:
                O00000Oo(SmartConfigStep.Step.STEP_BLE_SEND_ERROR);
                return;
            case 2:
                this.O0000o0 = true;
                return;
            case 3:
                this.O00000Oo = "";
                break;
            case 4:
                O00000Oo(SmartConfigStep.Step.STEP_BLE_PWD_ERROR);
                return;
            case 5:
                b_(true);
                return;
            case 6:
                if (!this.O000OOoO && this.O000OOo) {
                    this.O000OOoO = true;
                    if (!this.O000Oo0o) {
                        SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.f828O000000o, O0000O0o(2701), 1, "", this.O00000o0, this.O000Oo00, this.O00000Oo);
                    }
                }
                if (this.O000Oo0o) {
                    this.O000Oo0O.push(new hxy(0L, this.f828O000000o, O0000O0o(2701), this.O000Oo00, this.O000OOo));
                    return;
                }
                return;
            case 7:
                if (obj != null) {
                    int O0000O0o2 = O0000O0o(29000 - ((Integer) obj).intValue());
                    if (!this.O000OOoO && this.O000OOo) {
                        this.O000OOoO = true;
                        if (!this.O000Oo0o) {
                            SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.f828O000000o, O0000O0o2, 1, "", this.O00000o0, this.O000Oo00, this.O00000Oo);
                        }
                    }
                    if (this.O000Oo0o) {
                        this.O000Oo0O.push(new hxy(0L, this.f828O000000o, O0000O0o2, this.O000Oo00, this.O000OOo));
                        return;
                    }
                    return;
                }
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
            case 9:
                break;
            default:
                return;
        }
        O0000oOO();
    }

    public final boolean t_() {
        int i = this.O000OooO;
        if (i != 9 && i != 12 && i != 8 && i != 10 && i != 11 && i != 5) {
            return super.t_();
        }
        O0000oo0();
        return true;
    }

    public void onStartConnectBle(String str) {
        foc.O0000o(str);
        SmartConfigRouterFactory.getStatResultManager().get_bind_key_result(!TextUtils.isEmpty(this.O00000Oo), "BleComboBleWayV2", this.f828O000000o);
    }

    public void onConnectBleResult(int i, String str, String str2) {
        this.O000Oo00 = str;
        this.O0000OoO = str2;
        htr.O000000o().O00000Oo("bind_device_did", this.O0000OoO);
        this.O000OooO = -1;
        if (i == 0) {
            e_(this.O00000oo.f17885O000000o);
        } else if (i == -37) {
            this.O0000o0 = true;
        }
    }

    public void onSendPwdAndPwdResult(int i) {
        if (i == 0) {
            e_(1);
        }
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.f828O000000o, BindStep.STEP_TRANSFER_CONFIG);
    }

    public void notifyMessage(int i, Bundle bundle) {
        if (i == 125) {
            O000000o("BleComboBleWayV2 handleMessage MSG_CONNECT_BLE_TIME_OUT", new Object[0]);
            this.O000OoOo = "3000.2.2";
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(62000);
            fob.O000000o(this.f828O000000o, this.O00000o0);
            SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(this.f828O000000o, 1);
            if (!this.O000OOoO && this.O000OOo) {
                this.O000OOoO = true;
                if (!this.O000Oo0o) {
                    SmartConfigRouterFactory.getStatPageV2Manager().page_device_fail4Combo(0, this.f828O000000o, O0000O0o(2501), 1, "", this.O00000o0, this.O000Oo00, this.O00000Oo);
                }
            }
            if (this.O000Oo0o && this.O000Oo0O.isEmpty()) {
                this.O000Oo0O.push(new hxy(0L, this.f828O000000o, O0000O0o(2501), this.O000Oo00, this.O000OOo));
            }
            if (this.O0000o0) {
                O00000Oo(SmartConfigStep.Step.STEP_UNSUPPORT_VERSION_ERROR);
            } else {
                O00000Oo(SmartConfigStep.Step.STEP_BLE_CONNECT_ERROR);
            }
        } else if (i == 127) {
            O000000o("BleComboBleWayV2 handleMessage MSG_BLE_NOTIFY_TIME_OUT, current notifyStatus = " + this.O00000o + ",notifyError=" + this.O000OooO, new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000o0(2401);
            if (this.O00000oo.f17885O000000o == 2) {
                this.O000OoOo = "3000.2.5";
                O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
            }
        }
    }

    public boolean isRestoreWifi() {
        return ((Boolean) htr.O000000o().O000000o("restore_wifi", Boolean.FALSE)).booleanValue();
    }

    public void notifyBleStatus(int i) {
        if ((i < 0 || i > 3) && i != 6) {
            this.O000OooO = i;
        } else {
            this.O00000o = i;
        }
        if (i == 0 || i == 1) {
            hvo O000000o2 = hvg.O000000o(CommonApplication.getAppContext());
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            O000000o2.O000000o("w1", sb.toString());
        } else if (i == 2) {
            hvo O000000o3 = hvg.O000000o(CommonApplication.getAppContext());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            O000000o3.O000000o("w2", sb2.toString());
        } else if (i == 3) {
            hvo O000000o4 = hvg.O000000o(CommonApplication.getAppContext());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(System.currentTimeMillis());
            O000000o4.O000000o("w3", sb3.toString());
            this.O0000o0O = true;
        } else if (i == 6 && this.O00000oo.f17885O000000o == 2) {
            SmartConfigRouterFactory.getStatBindManager().endBindStep(this.f828O000000o, BindStep.STEP_TRANSFER_CONFIG);
        }
    }

    public void receiveBleDisconnect(String str, String str2) {
        fob.O000000o(str, str2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent} */
    public void startPassportAuth() {
        Boolean isMiAccountSystem = SmartConfigRouterFactory.getSmartConfigManager().isMiAccountSystem(this.O000O0oo);
        if (isMiAccountSystem != null) {
            if (isMiAccountSystem.booleanValue()) {
                O000000o("BleComboBleWayV2 startPassportAuth Use System Account", new Object[0]);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setClassName("com.xiaomi.account", "com.xiaomi.account.ui.AccountWebActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(this.O0000Ooo));
                if (this.O000Ooo0) {
                    intent.putExtra("style", "dialog");
                    intent.putExtra("show_title", true);
                    intent.putExtra("height_ratio", 0.7d);
                    dcp.O000000o().O000000o(true);
                }
                List<ResolveInfo> queryIntentActivities = this.O000O0oo.getPackageManager().queryIntentActivities(intent, 1);
                if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                    O000000o("BleComboBleWayV2 startPassportAuth No Acctivity Found!", new Object[0]);
                    this.O000OoOo = "3000.2.5";
                    O00000Oo(SmartConfigStep.Step.STEP_MITV_ACCOUNT_BIND_FAILED);
                    return;
                }
                ((Activity) this.O000O0oo).startActivityForResult(intent, 101);
                return;
            }
            O000000o("BleComboBleWayV2 startPassportAuth Use Local Account", new Object[0]);
            fbt fbt = new fbt(this.O000O0oo, "ScDeviceLocalAccountWebAuthActivity");
            if (this.O000Ooo0) {
                fbt.O000000o("height_ratio");
            }
            fbt.O000000o("login_url", this.O0000Ooo).O000000o(100);
            fbs.O000000o(fbt);
        }
    }

    public void onBindPassportSuccess() {
        e_(2);
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.f828O000000o, BindStep.STEP_TRANSFER_CONFIG);
    }

    private boolean O0000o0o() {
        PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.f828O000000o);
        return pluginInfo != null && pluginInfo.O00000o() == 20;
    }

    public final void O0000O0o() {
        super.O0000O0o();
        SmartConfigRouterFactory.getStatResultManager().combo_kuailian_result(this.f828O000000o, this.O0000OoO, true, !this.O0000o0O, this.O0000O0o);
        this.O0000o00.removeCallbacksAndMessages(null);
        this.O00000oo.O00000oO();
    }

    public void onStartPollNewDevice() {
        hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(210);
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.f828O000000o, BindStep.STEP_CHECK_BIND);
    }

    public htl getPollDeviceCallback() {
        return this.O0000o0o;
    }

    public final boolean G_() {
        try {
            new MLAlertDialog.Builder(this.O000O0oo).O000000o(this.O000O0oo.getString(R.string.stop_connect_device_title)).O00000Oo(this.O000O0oo.getString(R.string.stop_connect_device_message)).O000000o(this.O000O0oo.getString(R.string.confirm_button), new DialogInterface.OnClickListener() {
                /* class _m_j.hwe.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (htk.O000000o().O00000o) {
                        htk.O000000o().O00000Oo();
                    }
                    if (hwe.this.O00000oo.f17885O000000o == 3 && ((hwe.this.O00000o == 0 && !hwe.this.O00000oO) || !(hwe.this.O00000o == 0 || hwe.this.O00000o == 3))) {
                        hwe.this.O000OOo = false;
                    }
                    if (!hwe.this.O000OOoO && hwe.this.O000OOo && !hwe.this.O000OOoo) {
                        hwe hwe = hwe.this;
                        hwe.O000OOoO = true;
                        int O0000O0o = hwe.O0000O0o(gon.O000000o(hwe.O00000oo.f17885O000000o));
                        if (!hwe.this.O000Oo0o) {
                            hxy hxy = new hxy(0L, hwe.this.f828O000000o, O0000O0o, hwe.this.O000Oo00, true);
                            hxy.O0000OoO = hwe.this.O00000Oo;
                            SmartConfigRouterFactory.getStatPageV2Manager().pageDeviceFail(hxy);
                        } else if (hwe.this.O000Oo0O.isEmpty()) {
                            hwe.this.O000Oo0O.push(new hxy(0L, hwe.this.f828O000000o, O0000O0o, hwe.this.O000Oo00, true));
                        }
                        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_connect_fail_show(hwe.this.f828O000000o, 4);
                    }
                    hwe hwe2 = hwe.this;
                    hwe2.O0000O0o = true;
                    hwe2.b_(false);
                }
            }).O00000Oo(this.O000O0oo.getString(R.string.sh_common_cancel), (DialogInterface.OnClickListener) null).O000000o(this.O000O0oo.getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
        if (i == 100 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("login_result", false);
            this.O00000oo.O000000o(i, i2, intent);
            if (!booleanExtra) {
                this.O000OoOo = "3000.2.5";
                O00000Oo(SmartConfigStep.Step.STEP_SC_ACCOUNT_BIND_FAILED);
            }
        } else if (i == 101) {
            if (this.O000Ooo0) {
                dcp.O000000o().O000000o(false);
            }
            this.O00000oo.O000000o(i, i2, intent);
            if (this.O00000oo.O0000oo0) {
                SmartConfigRouterFactory.getStatBindManager().endBindStep(this.f828O000000o, BindStep.STEP_TRANSFER_CONFIG);
            }
        }
    }

    public final ArrayList<gke> O0000Oo0() {
        fte.O00000Oo("BleComboBleWayStep.getAllConfigStages");
        ArrayList<gke> arrayList = new ArrayList<>();
        gke gke = new gke();
        gke.f17943O000000o = 0;
        gke.O00000Oo = 90000;
        arrayList.add(gke);
        gke gke2 = new gke();
        gke2.f17943O000000o = 1;
        gke2.O00000Oo = 60000;
        arrayList.add(gke2);
        if (O0000o0o()) {
            gke gke3 = new gke();
            gke3.f17943O000000o = 2;
            gke3.O00000Oo = 20000;
            arrayList.add(gke3);
        }
        this.O0000o = (long) (eyr.O00000Oo().O0000Oo0(this.f828O000000o) + 60000);
        gke gke4 = new gke();
        gke4.f17943O000000o = 3;
        gke4.O00000Oo = this.O0000o;
        arrayList.add(gke4);
        return arrayList;
    }

    public final int O00000Oo() {
        return this.O00000oo.f17885O000000o;
    }

    public final void s_() {
        int i = this.O00000oo.f17885O000000o;
        if (i == 0) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.ble_combo_connect_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(1);
        } else if (i == 1) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.ble_combo_transfer_device_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(2);
        } else if (i == 2) {
            this.O000O0o0.O000000o(BaseBindView.StepStatus.LOADING, (int) R.string.ble_new_bind_step_loading, (int) R.string.ble_combo_connect_title_loading);
            this.O000O0o0.O000000o(3);
        } else if (i == 3) {
            Resources resources = this.O000O0o0.getResources();
            ddg ddg = this.O000O0o0;
            BaseBindView.StepStatus stepStatus = BaseBindView.StepStatus.LOADING;
            ddg.O000000o(stepStatus, resources.getString(R.string.ble_combo_device_connect_network_step_loading) + resources.getString(R.string.kuailian_connect_ble), R.string.ble_combo_network_title_loading, false);
            this.O000O0o0.O000000o(3);
        }
    }

    public byte[] getScanRecord(String str) {
        if (this.O000Ooo0) {
            return ((BluetoothSearchResult) htr.O000000o().O000000o("bluetooth_search_result")).O00000o0;
        }
        BleDevice O00000o02 = fob.O00000o0(str);
        if (O00000o02 != null) {
            return O00000o02.scanRecord;
        }
        return null;
    }
}
