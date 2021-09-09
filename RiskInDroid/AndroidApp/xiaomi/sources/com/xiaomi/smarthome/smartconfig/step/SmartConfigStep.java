package com.xiaomi.smarthome.smartconfig.step;

import _m_j.eyr;
import _m_j.gsy;
import _m_j.htr;
import _m_j.hts;
import _m_j.hvr;
import _m_j.hvs;
import _m_j.hvt;
import _m_j.hvu;
import _m_j.hvv;
import _m_j.hvw;
import _m_j.hvx;
import _m_j.hvy;
import _m_j.hwc;
import _m_j.hwd;
import _m_j.hwe;
import _m_j.hwf;
import _m_j.hwg;
import _m_j.hwh;
import _m_j.hwi;
import _m_j.hwj;
import _m_j.hwk;
import _m_j.hwl;
import _m_j.hwm;
import _m_j.hwp;
import _m_j.hwq;
import _m_j.hwr;
import _m_j.hws;
import _m_j.hwt;
import _m_j.hxy;
import _m_j.hze;
import _m_j.iae;
import _m_j.iag;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public abstract class SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashMap<Step, Class> f11819O000000o;
    public View O000O0oO;
    public Context O000O0oo;
    public long O000OO;
    public boolean O000OO00 = false;
    public boolean O000OO0o = false;
    public String O000OOOo;
    public boolean O000OOo = true;
    public O000000o O000OOo0;
    public boolean O000OOoO = false;
    public boolean O000OOoo = false;
    public ScanResult O000Oo0;
    public String O000Oo00 = "";
    public Stack<hxy> O000Oo0O = new Stack<>();
    public boolean O000Oo0o = false;
    protected int O000OoO = 0;
    public boolean O000OoO0 = false;
    protected int O000OoOO = -1;
    public String O000OoOo;
    protected String O000Ooo = "SmartConfigStep";
    public boolean O000Ooo0;
    protected boolean O00O0Oo = false;

    public interface O000000o {
        void O000000o();

        void O000000o(Step step);

        void O000000o(boolean z);

        Handler O00000Oo();

        void O00000Oo(Step step);
    }

    public enum Step {
        STEP_DEVICE_INFO,
        STEP_GET_ROUTER_INFO,
        STEP_CHOOSE_WIFI,
        STEP_SMART_CONFIG_STEP,
        STEP_AP_CONFIG_STEP,
        STEP_CONNECT_AP_ERROR,
        STEP_CONNECT_AP_ERROR2,
        STEP_CONNECT_MIDR_AP_ERROR,
        STEP_CONNECT_ROUTER_ERROR,
        STEP_SEND_ROUTER_INFO_ERROR,
        STEP_SEND_ROUTER_INFO_FINAL_ERROR,
        STEP_CONNECT_SELECTED_AP_FAILED,
        STEP_DOWNLOAD_PLUGIN_FAILED,
        STEP_FIND_DEVICE_FAILED,
        STEP_FIND_DEVICE_FAILED_ERROR,
        STEP_NORMAL_FAILED_STEP,
        STEP_SUCCESS,
        STEP_QR_SCAN,
        STEP_QR_CONFIG,
        STEP_QR_HELP,
        STEP_QR_CAMERA,
        STEP_SW_CAMERA,
        STEP_NBIOT,
        STEP_XIAOFANG_RESET,
        STEP_CAMERA_RESET,
        STEP_SCAN_QR,
        STEP_PREPARE_SCAN_QR,
        STEP_SCAN_QR_FAIL_BIND,
        STEP_SCAN_QR_FAIL_FIND,
        STEP_BLE_COMBO_CONFIG,
        STEP_COMBO_BLE_WAY_CONFIG,
        STEP_BLE_PWD_ERROR,
        STEP_BLE_SEND_ERROR,
        STEP_BLE_CONNECT_ERROR,
        STEP_AP_DEVICE_CONFIG_PASSWD_CHOOSER,
        STEP_AP_DEVICE_CONFIG_STEP,
        STEP_BIND_KEY,
        STEP_AP_DEVICE_USER_ERROR,
        STEP_AP_INPUT_SSID_PASSWD_CONFIG,
        STEP_XIAOXUN_ERROR,
        STEP_BIND_DEVICE_FROM_THIRD_APP,
        STEP_BIND_BY_OTHER_ERROR,
        STEP_GATEWAY_SUBDEVICE,
        STEP_APSECURE_CONFIG_STEP,
        STEP_APSECURE_PIN_STEP,
        STEP_PUSH_NEWDEVICE,
        STEP_UNSUPPORT_VERSION_ERROR,
        STEP_BLE_SC_SCAN,
        STEP_SC_ACCOUNT_BIND_FAILED,
        STEP_CHECK_AIOT_DEVICE_STATUS,
        STEP_LOCK_WIFI_CONFIG,
        STEP_BLE_MITV,
        STEP_MITV_ACCOUNT_BIND_FAILED,
        STEP_FORCE_BIND_KEY_ERROR,
        STEP_AP_CONFIG_STEP_V2,
        STEP_SECURITY_AP_CONFIG_V2,
        STEP_APSECURE_PIN_STEP_V2,
        STEP_COMBO_ONLY_BLE_CONFIG_V2,
        STEP_COMBO_MIX_CONFIG_V2,
        STEP_COMBO_BLE_ERROR_AUTH_FAIL_09,
        STEP_COMBO_BLE_ERROR_NETWORK_0C,
        STEP_COMBO_BLE_ERROR_CANNOT_FIND_ROUTER_08,
        STEP_COMBO_BLE_ERROR_WEAK_NETWORK_0A,
        STEP_COMBO_BLE_ERROR_DHCP_FAIL_0B
    }

    public abstract Step A_();

    public boolean G_() {
        return false;
    }

    public abstract void H_();

    public abstract void I_();

    public void O000000o(int i, int i2, Intent intent) {
    }

    public abstract void O000000o(Context context);

    public void O000000o(Configuration configuration) {
    }

    public abstract void O000000o(Message message);

    public abstract void O0000O0o();

    static {
        HashMap<Step, Class> hashMap = new HashMap<>();
        f11819O000000o = hashMap;
        hashMap.put(Step.STEP_GET_ROUTER_INFO, RouterInfoStep.class);
        f11819O000000o.put(Step.STEP_DEVICE_INFO, DeviceInfoStep.class);
        f11819O000000o.put(Step.STEP_CHOOSE_WIFI, ChooseWifiStepV2.class);
        f11819O000000o.put(Step.STEP_AP_CONFIG_STEP, hvu.class);
        f11819O000000o.put(Step.STEP_AP_CONFIG_STEP_V2, hvv.class);
        f11819O000000o.put(Step.STEP_CONNECT_AP_ERROR, ApConnectFailedStep.class);
        f11819O000000o.put(Step.STEP_CONNECT_AP_ERROR2, ApConnectFailed2Step.class);
        f11819O000000o.put(Step.STEP_CONNECT_MIDR_AP_ERROR, ApConnectMidrFailedStep.class);
        f11819O000000o.put(Step.STEP_CONNECT_ROUTER_ERROR, ConnectRouterErrorStep.class);
        f11819O000000o.put(Step.STEP_SEND_ROUTER_INFO_ERROR, PasswdSendFailedStep.class);
        f11819O000000o.put(Step.STEP_SEND_ROUTER_INFO_FINAL_ERROR, PasswdSendFinalFailedStep.class);
        f11819O000000o.put(Step.STEP_NORMAL_FAILED_STEP, hwm.class);
        f11819O000000o.put(Step.STEP_CONNECT_SELECTED_AP_FAILED, ConnectSelectApFailedStep.class);
        f11819O000000o.put(Step.STEP_FIND_DEVICE_FAILED, FindDeviceFailedStep.class);
        f11819O000000o.put(Step.STEP_FIND_DEVICE_FAILED_ERROR, FindDeviceFailedFinalStep.class);
        f11819O000000o.put(Step.STEP_SUCCESS, SuccessStep.class);
        f11819O000000o.put(Step.STEP_DOWNLOAD_PLUGIN_FAILED, DownloadPluginFailedStep.class);
        f11819O000000o.put(Step.STEP_QR_CONFIG, QRConfigStep.class);
        f11819O000000o.put(Step.STEP_QR_CAMERA, QRCameraStep.class);
        f11819O000000o.put(Step.STEP_SW_CAMERA, SWCameraStep.class);
        f11819O000000o.put(Step.STEP_QR_SCAN, hwr.class);
        f11819O000000o.put(Step.STEP_QR_HELP, QRHelpStep.class);
        f11819O000000o.put(Step.STEP_PREPARE_SCAN_QR, hws.class);
        f11819O000000o.put(Step.STEP_SCAN_QR_FAIL_BIND, ScanQRBindFailStep.class);
        f11819O000000o.put(Step.STEP_SCAN_QR_FAIL_FIND, QRScanFindFailedStep.class);
        f11819O000000o.put(Step.STEP_SCAN_QR, hwq.class);
        f11819O000000o.put(Step.STEP_BLE_COMBO_CONFIG, hwf.class);
        f11819O000000o.put(Step.STEP_COMBO_MIX_CONFIG_V2, hwg.class);
        f11819O000000o.put(Step.STEP_COMBO_BLE_WAY_CONFIG, hwd.class);
        f11819O000000o.put(Step.STEP_COMBO_ONLY_BLE_CONFIG_V2, hwe.class);
        f11819O000000o.put(Step.STEP_BLE_PWD_ERROR, BlePwdErrorStep.class);
        f11819O000000o.put(Step.STEP_BLE_SEND_ERROR, BleErrorStep.class);
        f11819O000000o.put(Step.STEP_AP_DEVICE_CONFIG_PASSWD_CHOOSER, ApDevicePasswdChooseStep.class);
        f11819O000000o.put(Step.STEP_AP_DEVICE_CONFIG_STEP, hvw.class);
        f11819O000000o.put(Step.STEP_XIAOFANG_RESET, XiaofangResetStep.class);
        f11819O000000o.put(Step.STEP_CAMERA_RESET, CameraResetStep.class);
        f11819O000000o.put(Step.STEP_BIND_KEY, hwc.class);
        f11819O000000o.put(Step.STEP_AP_DEVICE_USER_ERROR, ApDeviceUserErrorStep.class);
        f11819O000000o.put(Step.STEP_AP_INPUT_SSID_PASSWD_CONFIG, WifiExtApPasswdInputStep.class);
        f11819O000000o.put(Step.STEP_XIAOXUN_ERROR, XiaoxunErrorStep.class);
        f11819O000000o.put(Step.STEP_BIND_DEVICE_FROM_THIRD_APP, hwt.class);
        f11819O000000o.put(Step.STEP_BIND_BY_OTHER_ERROR, HaveBindByOtherErrorStep.class);
        f11819O000000o.put(Step.STEP_NBIOT, hwl.class);
        f11819O000000o.put(Step.STEP_GATEWAY_SUBDEVICE, hwj.class);
        f11819O000000o.put(Step.STEP_APSECURE_CONFIG_STEP, hvx.class);
        f11819O000000o.put(Step.STEP_APSECURE_PIN_STEP, hvr.class);
        f11819O000000o.put(Step.STEP_SECURITY_AP_CONFIG_V2, hvy.class);
        f11819O000000o.put(Step.STEP_APSECURE_PIN_STEP_V2, hvs.class);
        f11819O000000o.put(Step.STEP_PUSH_NEWDEVICE, hwp.class);
        f11819O000000o.put(Step.STEP_BLE_SC_SCAN, hwi.class);
        f11819O000000o.put(Step.STEP_BLE_MITV, hwh.class);
        f11819O000000o.put(Step.STEP_CHECK_AIOT_DEVICE_STATUS, hvt.class);
        f11819O000000o.put(Step.STEP_LOCK_WIFI_CONFIG, hwk.class);
    }

    public static SmartConfigStep O00000o0(Step step) {
        Class cls = f11819O000000o.get(step);
        if (cls != null) {
            try {
                return (SmartConfigStep) hze.O000000o(cls, new Object[0]);
            } catch (Exception unused) {
                gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigStep", Log.getStackTraceString(new Exception("fatal createNewStep is null step:".concat(String.valueOf(step)))));
                return null;
            }
        } else {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigStep", Log.getStackTraceString(new Exception("fatal createNewStep is null step:".concat(String.valueOf(step)))));
            return null;
        }
    }

    public final void O000000o(String str, Object... objArr) {
        hts.O000000o(this.O000Ooo, str, objArr);
    }

    public final void O000000o(String str, String str2, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            hts.O000000o(this.O000Ooo, str2, objArr);
        } else {
            hts.O000000o(str, str2, objArr);
        }
    }

    public final void O000000o(String str, Throwable th) {
        String str2 = this.O000Ooo;
        if (str != null) {
            str = str + " : " + hts.O000000o(th);
        }
        if (str == null) {
            str = hts.O000000o(th);
        }
        gsy.O00000o0(LogType.KUAILIAN, str2, str);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Context context, int i) {
        this.O000O0oO = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        ButterKnife.bind(this, this.O000O0oO);
    }

    /* access modifiers changed from: protected */
    public final void O000O0OO() {
        this.O000OOOo = (String) htr.O000000o().O000000o("device_model", "");
        this.O000OO = System.currentTimeMillis();
        String O00000Oo = htr.O000000o().O00000Oo();
        int intValue = ((Integer) htr.O000000o().O000000o("selected_ap_level", 0)).intValue();
        eyr O00000Oo2 = eyr.O00000Oo();
        boolean z = !eyr.O000000o(this.O000OOOo, O00000Oo2.O0000O0o, O00000Oo2.O0000OOo, O00000Oo2.O00000oo);
        if ((DeviceFactory.O00000oO(O00000Oo) && !DeviceFactory.O00000Oo(this.O000OOOo)) || ((!TextUtils.isEmpty(O00000Oo) && hze.O000000o(O00000Oo)) || (z && iag.O00000Oo(intValue) <= 60))) {
            this.O000OOo = false;
        }
        this.O000Oo0o = eyr.O00000Oo().O000000o(this.O000OOOo);
        this.O00O0Oo = eyr.O00000Oo().O00000Oo(this.O000OOOo);
    }

    public final View O000O0Oo() {
        return this.O000O0oO;
    }

    public Handler x_() {
        O000000o o000000o = this.O000OOo0;
        if (o000000o != null) {
            return o000000o.O00000Oo();
        }
        return new Handler(Looper.getMainLooper());
    }

    public final void O00000o0(Context context) {
        this.O000OO00 = false;
        this.O000OO0o = false;
        this.O000O0oo = context;
        O000000o(context);
    }

    public final void O00oOoOo() {
        this.O000OO0o = false;
        H_();
    }

    public final void O00000o(Step step) {
        if (!this.O000OO0o) {
            this.O000OO0o = true;
            I_();
            O000000o o000000o = this.O000OOo0;
            A_();
            o000000o.O00000Oo(step);
        }
    }

    public final void O000O0o0() {
        if (!this.O000OO00) {
            this.O000OO0o = true;
            this.O000OO00 = true;
            O0000O0o();
            this.O000OOo0 = null;
            this.O000O0oo = null;
        }
    }

    public final void O000O0o() {
        if (!this.O000OO00) {
            this.O000OO0o = true;
            this.O000OO00 = true;
            O0000O0o();
            this.O000O0oo = null;
            this.O000OOo0.O000000o();
            this.O000OOo0 = null;
        }
    }

    public void O000000o(Step step) {
        if (!this.O000OO00) {
            this.O000OO0o = true;
            this.O000OO00 = true;
            O0000O0o();
            this.O000O0oo = null;
            O000000o o000000o = this.O000OOo0;
            A_();
            o000000o.O000000o(step);
            this.O000OOo0 = null;
        }
    }

    public void b_(boolean z) {
        if (!this.O000OO00) {
            this.O000OO0o = true;
            this.O000OO00 = true;
            O0000O0o();
            this.O000O0oo = null;
            this.O000OOo0.O000000o(z);
            this.O000OOo0 = null;
        }
    }

    public String O000000o(long j) {
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

    /* access modifiers changed from: protected */
    public ScanResult y_() {
        if (this.O000Oo0 == null) {
            this.O000Oo0 = (ScanResult) htr.O000000o().O000000o("device_ap");
            if (this.O000Oo0 == null) {
                String str = (String) htr.O000000o().O000000o("wifi_ssid");
                ArrayList<ScanResult> arrayList = iae.O00000o0;
                if (arrayList != null) {
                    Iterator<ScanResult> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ScanResult next = it.next();
                        if (iag.O000000o(next.SSID, str)) {
                            this.O000Oo0 = next;
                            break;
                        }
                    }
                }
            }
        }
        return this.O000Oo0;
    }

    public final int O0000O0o(int i) {
        this.O000OoOO = i;
        Context context = this.O000O0oo;
        if (context instanceof SmartConfigMainActivity) {
            ((SmartConfigMainActivity) context).onError(i);
        }
        return i;
    }

    public final void O000O0oO() {
        this.O000OoO++;
        Context context = this.O000O0oo;
        if (context instanceof SmartConfigMainActivity) {
            ((SmartConfigMainActivity) context).onRetry();
        }
    }
}
