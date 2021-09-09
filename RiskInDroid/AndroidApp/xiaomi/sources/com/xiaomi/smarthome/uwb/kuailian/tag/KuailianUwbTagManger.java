package com.xiaomi.smarthome.uwb.kuailian.tag;

import _m_j.dcp;
import _m_j.eyr;
import _m_j.fob;
import _m_j.foc;
import _m_j.fte;
import _m_j.gjr;
import _m_j.gkd;
import _m_j.gke;
import _m_j.gkf;
import _m_j.gsy;
import _m_j.htl;
import _m_j.htm;
import _m_j.htr;
import _m_j.jdn;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class KuailianUwbTagManger {
    private static KuailianUwbTagManger sInstance;
    private boolean isOngoing = false;
    public BleDevice mBleDevice;
    public htl mCallback = new htm() {
        /* class com.xiaomi.smarthome.uwb.kuailian.tag.KuailianUwbTagManger.AnonymousClass2 */

        public void onDeviceConnectionSuccess(List<Device> list) {
            KuailianUwbTagManger.this.mKuailianUwbTagListener.onStepSuccess(3);
            KuailianUwbTagManger.this.mKuailianUwbTagListener.onLastResponse(0, list.get(0));
        }

        public void onDeviceConnectionFailure() {
            KuailianUwbTagManger.this.mKuailianUwbTagListener.onLastResponse(-1, null);
        }

        public void onDeviceConnectionBind(List<Device> list) {
            KuailianUwbTagManger.this.mKuailianUwbTagListener.onStepSuccess(3);
            KuailianUwbTagManger.this.mKuailianUwbTagListener.onLastResponse(0, list.get(0));
        }

        public void onDeviceConnectionFailure(int i) {
            KuailianUwbTagManger.this.mKuailianUwbTagListener.onLastResponse(-1, null);
        }
    };
    private gjr mComboBinder;
    private gkf mComboBleConfigListener;
    private Context mContext;
    private int mFreq;
    public KuailianUwbTagListener mKuailianUwbTagListener;
    public String mLoginUrl = null;
    public String mModel;
    private String mPasswd;
    private String mSsid;

    public interface KuailianUwbTagListener {
        void onError(int i, Object obj);

        void onLastResponse(int i, Device device);

        void onStepSuccess(int i);
    }

    private KuailianUwbTagManger(Context context) {
        this.mContext = context;
    }

    public static KuailianUwbTagManger getInstance(Context context) {
        if (sInstance == null) {
            synchronized (KuailianUwbTagManger.class) {
                if (sInstance == null) {
                    sInstance = new KuailianUwbTagManger(context);
                }
            }
        }
        return sInstance;
    }

    public void init(BleDevice bleDevice) {
        this.mBleDevice = bleDevice;
        this.mModel = bleDevice.model;
        initComboBleConfigListener();
        this.mComboBinder = new gjr(this.mComboBleConfigListener);
        gkd buildConfigBuidler = buildConfigBuidler();
        gsy.O00000o0(LogType.KUAILIAN, "KuailianUwbTagManger", " init. Builder:");
        this.mComboBinder.O000000o(this.mContext, (List<gke>) null, buildConfigBuidler);
    }

    public void startConfig(KuailianUwbTagListener kuailianUwbTagListener) {
        if (this.isOngoing) {
            writeLog("Last process is Not finished!");
            this.mKuailianUwbTagListener.onError(10, "CODE_LAST_PROCESS_NOT_FINISHED");
            return;
        }
        this.mKuailianUwbTagListener = kuailianUwbTagListener;
        fob.O00000o0();
        if (checkCondition()) {
            this.isOngoing = true;
            Bundle bundle = new Bundle();
            bundle.putInt("index", 0);
            this.mComboBinder.O000000o(0, bundle);
        }
    }

    private boolean checkCondition() {
        if (TextUtils.isEmpty(this.mSsid) || TextUtils.isEmpty(this.mPasswd)) {
            writeLog("ssid or passwd is Empty!");
            this.mKuailianUwbTagListener.onError(8, "CODE_WIFI_SSID_OR_PASSWD_EMPTY");
            return false;
        }
        PluginDeviceInfo O00000oo = CoreApi.O000000o().O00000oo(this.mModel);
        if (O00000oo == null) {
            writeLog("pluginDeviceInfo is Empty, model is " + this.mModel);
            return false;
        } else if (O00000oo.O00000oo()) {
            return true;
        } else {
            if (this.mFreq <= 4900 && !DeviceFactory.O00000o(this.mSsid)) {
                return true;
            }
            this.mKuailianUwbTagListener.onError(9, "CODE_WIFI_5G_NOT_SUPPORT");
            return false;
        }
    }

    public boolean isOngoing() {
        return this.isOngoing;
    }

    public void release() {
        this.isOngoing = false;
        this.mComboBinder.O00000oO();
    }

    private gkd buildConfigBuidler() {
        this.mSsid = htr.O000000o().O00000Oo();
        this.mPasswd = htr.O000000o().O00000o0();
        writeLog("select ssid: " + this.mSsid + ", pwd: " + fte.O000000o(this.mPasswd));
        WifiManager wifiManager = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (TextUtils.isEmpty(this.mSsid) || TextUtils.isEmpty(this.mPasswd)) {
            this.mSsid = connectionInfo.getSSID();
            this.mPasswd = dcp.O000000o().O00000o0(this.mSsid);
            if (Build.VERSION.SDK_INT >= 21) {
                this.mFreq = connectionInfo.getFrequency();
            }
        }
        if (TextUtils.isEmpty(this.mSsid) || this.mSsid.contains("unknown ssid")) {
            this.mSsid = BaseWifiSettingUtils.O000000o(this.mContext, wifiManager);
        }
        if (this.mSsid.startsWith(jdn.f1779O000000o) && this.mSsid.length() > 2) {
            String str = this.mSsid;
            this.mSsid = str.substring(1, str.length() - 1);
        }
        writeLog("config ssid: " + this.mSsid + ", pwd: " + fte.O000000o(this.mPasswd) + ", state:" + connectionInfo.getSupplicantState());
        long longValue = Long.valueOf(SmartConfigRouterFactory.getCoreApiManager().getMiId()).longValue();
        String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
        String countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
        if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
            countryCode = "CN";
        }
        int convert = (int) TimeUnit.SECONDS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
        String id = TimeZone.getDefault().getID();
        gkd gkd = new gkd();
        gkd.f17942O000000o = this.mContext;
        gkd.O00000o = this.mSsid;
        gkd.O00000oO = this.mPasswd;
        gkd.O00000o0 = longValue;
        gkd.O00000Oo = this.mModel;
        gkd.O0000O0o = "app";
        gkd.O0000OOo = countryDomain;
        gkd.O0000Oo0 = countryCode;
        gkd.O0000Oo = convert;
        gkd.O0000OoO = id;
        gkd.O0000oOO = this.mBleDevice.mac;
        gkd O00000Oo = gkd.O000000o().O00000Oo();
        O00000Oo.O0000o = (long) (eyr.O00000Oo().O0000Oo0(this.mModel) + 60000);
        O00000Oo.O0000oOo = this.mBleDevice.O00000Oo() != null ? this.mBleDevice.O00000Oo().O00000oo : "";
        return O00000Oo;
    }

    private void writeLog(String str) {
        gsy.O00000o0(LogType.KUAILIAN, "KuailianUwbTagManger", str);
    }

    private void initComboBleConfigListener() {
        this.mComboBleConfigListener = new gkf() {
            /* class com.xiaomi.smarthome.uwb.kuailian.tag.KuailianUwbTagManger.AnonymousClass1 */

            public boolean isRestoreWifi() {
                return false;
            }

            public void notifyBleStatus(int i) {
            }

            public void notifyMessage(int i, Bundle bundle) {
            }

            public void onBindPassportSuccess() {
            }

            public void onGetBindKeySuccess(String str) {
            }

            public void onStartPollNewDevice() {
            }

            public void startPassportAuth() {
            }

            public boolean isComboWithLogin() {
                PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(KuailianUwbTagManger.this.mModel);
                return pluginInfo != null && pluginInfo.O00000o() == 20;
            }

            public byte[] getScanRecord(String str) {
                return KuailianUwbTagManger.this.mBleDevice.scanRecord;
            }

            public void onError(int i, Object obj) {
                KuailianUwbTagManger.this.mKuailianUwbTagListener.onError(i, obj);
            }

            public void onStartConnectBle(String str) {
                foc.O0000o(str);
            }

            public void onConnectBleResult(int i, String str, String str2) {
                if (i == 0) {
                    KuailianUwbTagManger.this.mKuailianUwbTagListener.onStepSuccess(0);
                }
            }

            public void onSendPwdAndPwdResult(int i) {
                if (i == 0) {
                    KuailianUwbTagManger.this.mKuailianUwbTagListener.onStepSuccess(1);
                }
            }

            public void onLoginResult(String str) {
                KuailianUwbTagManger.this.mLoginUrl = str;
            }

            public void receiveBleDisconnect(String str, String str2) {
                fob.O000000o(str, str2);
            }

            public htl getPollDeviceCallback() {
                return KuailianUwbTagManger.this.mCallback;
            }
        };
    }
}
