package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.fuw;
import _m_j.fwq;
import _m_j.fwz;
import _m_j.fyc;
import _m_j.fyf;
import _m_j.fyv;
import _m_j.fyy;
import _m_j.fyz;
import _m_j.fza;
import _m_j.fzb;
import _m_j.gbq;
import _m_j.gbu;
import _m_j.gdu;
import _m_j.gdv;
import _m_j.hzb;
import _m_j.iad;
import _m_j.iag;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Parcelable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.amap.api.location.AMapLocation;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.volume.VolumeChangeObserver;
import java.net.InetAddress;
import java.util.Iterator;

public class MIOTSystemModule extends MIOTBaseJavaModule {
    private fyv mAccelerometerSensor;
    private fyy mCompassSensor;
    private fyz mGyroscopeSensor;
    private O000000o mReceiver = null;
    private Callback mScanCodeResultCallback;
    private fzb mShakeSensor;
    private VolumeChangeObserver mVolumeChangeObserver;
    iad qConnectCallback = null;

    public String getName() {
        return "MIOTSystem";
    }

    public MIOTSystemModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getBatteryInfo(Callback callback) {
        fyc.O000000o("MIOTSystemModule", "getBatteryInfo,");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            fyc.O00000o0("MIOTSystemModule", "getBatteryInfo,getCurrentActivity returns null");
        } else if (callback == null) {
            fyc.O00000o0("MIOTSystemModule", "getBatteryInfo,callback null");
        } else {
            Intent registerReceiver = currentActivity.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("status", -1);
            int intExtra2 = registerReceiver.getIntExtra("level", -1);
            if (intExtra2 < 0 || intExtra2 > 100) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.DEVICE_ERROR, "illegal level"));
                return;
            }
            boolean z = intExtra == 2;
            fyc.O000000o("MIOTSystemModule", "getBatteryInfo,level:" + intExtra2 + ",isCharging:" + z);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("level", String.valueOf(intExtra2));
            createMap.putBoolean("isCharging", z);
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
        }
    }

    @ReactMethod
    public void startAccelerometer(String str, Callback callback) {
        fyv fyv = this.mAccelerometerSensor;
        if (fyv != null) {
            fyv.O00000o0();
            this.mAccelerometerSensor = null;
        }
        this.mAccelerometerSensor = new fyv();
        this.mAccelerometerSensor.O000000o(getReactApplicationContext(), str);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void stopAccelerometer(Callback callback) {
        fyv fyv = this.mAccelerometerSensor;
        if (fyv != null) {
            fyv.O00000o0();
            this.mAccelerometerSensor = null;
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void startCompass(String str, Callback callback) {
        fyy fyy = this.mCompassSensor;
        if (fyy != null) {
            fyy.O000000o();
            this.mCompassSensor = null;
        }
        this.mCompassSensor = new fyy();
        this.mCompassSensor.O000000o(getReactApplicationContext(), str);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void stopCompass(Callback callback) {
        fyy fyy = this.mCompassSensor;
        if (fyy != null) {
            fyy.O000000o();
            this.mCompassSensor = null;
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void startGyroscope(String str, Callback callback) {
        fyz fyz = this.mGyroscopeSensor;
        if (fyz != null) {
            fyz.O00000o0();
            this.mGyroscopeSensor = null;
        }
        this.mGyroscopeSensor = new fyz();
        this.mGyroscopeSensor.O000000o(getReactApplicationContext(), str);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void stopGyroscope(Callback callback) {
        fyz fyz = this.mGyroscopeSensor;
        if (fyz != null) {
            fyz.O00000o0();
            this.mGyroscopeSensor = null;
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void vibrateShort() {
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(15);
        } else {
            fyc.O00000o("MIOTSystemModule", "vibrateLong,not hasVibrator");
        }
    }

    @ReactMethod
    public void vibrateLong() {
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(400);
        } else {
            fyc.O00000o("MIOTSystemModule", "vibrateLong,not hasVibrator");
        }
    }

    @ReactMethod
    public final void getLocation(String str, final Callback callback) {
        fyc.O000000o("MIOTSystemModule", "getLocation,accuracy:".concat(String.valueOf(str)));
        fuw.O000000o().O000000o(new fuw.O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSystemModule.AnonymousClass1 */

            public final void O000000o(AMapLocation aMapLocation) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("country", aMapLocation.getCountry());
                createMap.putString("aoiname", aMapLocation.getAoiName());
                createMap.putString("district", aMapLocation.getDistrict());
                createMap.putString("street", aMapLocation.getStreet());
                createMap.putString("city", aMapLocation.getCity());
                createMap.putString("citycode", aMapLocation.getCityCode());
                createMap.putString("province", aMapLocation.getProvince());
                createMap.putString("adcode", aMapLocation.getAdCode());
                createMap.putString("address", aMapLocation.getAddress());
                StringBuilder sb = new StringBuilder();
                sb.append(aMapLocation.getLatitude());
                createMap.putString("latitude", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aMapLocation.getLongitude());
                createMap.putString("longitude", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(aMapLocation.getAccuracy());
                createMap.putString("accuracy", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(aMapLocation.getAltitude());
                createMap.putString("altitude", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(aMapLocation.getSpeed());
                createMap.putString("speed", sb5.toString());
                callback.invoke(Boolean.TRUE, createMap);
            }

            public final void O000000o() {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.DEVICE_ERROR, "getLocation fail"));
            }
        }, str);
    }

    @ReactMethod
    public void scanCode(Callback callback) {
        fyc.O000000o("MIOTSystemModule", "scanCode,");
        Intent intent = new Intent();
        intent.setClass(getReactApplicationContext(), ((gdu) gdv.f17570O000000o.getUiInterface()).O00000o());
        intent.putExtra("from", 400);
        try {
            getCurrentActivity().startActivityForResult(intent, 400);
            this.mScanCodeResultCallback = callback;
        } catch (Exception e) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
            }
        }
    }

    public void scanCodeResultCallback(boolean z, WritableMap writableMap) {
        fyc.O000000o("MIOTSystemModule", "scanCodeResultCallback,params:".concat(String.valueOf(writableMap)));
        Callback callback = this.mScanCodeResultCallback;
        if (callback != null) {
            callback.invoke(Boolean.valueOf(z), writableMap);
            this.mScanCodeResultCallback = null;
            return;
        }
        gbu.O00000Oo("scanCodeResultCallback is null...");
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        this.mScanCodeResultCallback = null;
        fyz fyz = this.mGyroscopeSensor;
        if (fyz != null) {
            fyz.O00000o0();
            this.mGyroscopeSensor = null;
        }
        fyv fyv = this.mAccelerometerSensor;
        if (fyv != null) {
            fyv.O00000o0();
            this.mAccelerometerSensor = null;
        }
        fyy fyy = this.mCompassSensor;
        if (fyy != null) {
            fyy.O000000o();
            this.mCompassSensor = null;
        }
        VolumeChangeObserver volumeChangeObserver = this.mVolumeChangeObserver;
        if (volumeChangeObserver != null) {
            volumeChangeObserver.O00000Oo();
            this.mVolumeChangeObserver = null;
        }
        fzb fzb = this.mShakeSensor;
        if (fzb != null) {
            fzb.O000000o();
            this.mShakeSensor = null;
        }
        unRegisterReceiver();
        fwz.O000000o().O000000o(false);
    }

    @ReactMethod
    public void getVolumeInfo(Callback callback) {
        fyc.O000000o("MIOTSystemModule", "getVolumeInfo,");
        if (this.mVolumeChangeObserver == null) {
            this.mVolumeChangeObserver = new VolumeChangeObserver(getReactApplicationContext());
        }
        double O000000o2 = this.mVolumeChangeObserver.O000000o();
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("volume", O000000o2);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
    }

    @ReactMethod
    public void startVolume(ReadableMap readableMap, Callback callback) {
        fyc.O000000o("MIOTSystemModule", "startVolume,");
        if (this.mVolumeChangeObserver == null) {
            this.mVolumeChangeObserver = new VolumeChangeObserver(getReactApplicationContext());
        }
        VolumeChangeObserver volumeChangeObserver = this.mVolumeChangeObserver;
        gbu.O00000o0("registerVolumeReceiver,");
        if (volumeChangeObserver.f8443O000000o != null && volumeChangeObserver.O00000Oo == null) {
            gbu.O00000o0("registerVolumeReceiver, need to register");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            volumeChangeObserver.O00000Oo = new VolumeChangeObserver.VolumeReceiver(volumeChangeObserver);
            volumeChangeObserver.f8443O000000o.registerReceiver(volumeChangeObserver.O00000Oo, intentFilter);
        }
        if (fyf.O000000o(readableMap, "hideSystemSlider")) {
            fwz.O000000o().O000000o(true);
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void stopVolume(Callback callback) {
        fyc.O000000o("MIOTSystemModule", "stopVolume,");
        VolumeChangeObserver volumeChangeObserver = this.mVolumeChangeObserver;
        if (volumeChangeObserver != null) {
            volumeChangeObserver.O00000Oo();
            this.mVolumeChangeObserver = null;
        }
        fwz.O000000o().O000000o(false);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void getGatewayIpAddress(Callback callback) {
        fyc.O000000o("MIOTSystemModule", "getGatewayIpAddress,");
        WifiManager wifiManager = (WifiManager) getReactApplicationContext().getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "wifi service error"));
            return;
        }
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        if (dhcpInfo == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "getDhcpInfo error"));
            return;
        }
        String formatIpAddress = Formatter.formatIpAddress(dhcpInfo.gateway);
        WritableMap createMap = Arguments.createMap();
        fyc.O000000o("MIOTSystemModule", "getGatewayIpAddress,ipAddress:".concat(String.valueOf(formatIpAddress)));
        createMap.putString("ipAddress", formatIpAddress);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
    }

    @ReactMethod
    public void getNfcInfo(Callback callback) {
        if (getCurrentActivity() == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "internal error:context is null"));
            return;
        }
        try {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(getCurrentActivity());
            WritableMap createMap = Arguments.createMap();
            if (defaultAdapter == null) {
                createMap.putInt("status", -1);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
            } else if (defaultAdapter.isEnabled()) {
                createMap.putInt("status", 1);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
            } else {
                createMap.putInt("status", 0);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
            }
        } catch (Throwable th) {
            fyc.O000000o("MIOTSystemModule", "getNfcStatus error:", th);
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "internal error"));
        }
    }

    @ReactMethod
    public void startShakeListener(Callback callback) {
        fyc.O000000o("MIOTSystemModule", "startShakeListener,");
        if (this.mShakeSensor == null) {
            this.mShakeSensor = new fzb();
        }
        fzb fzb = this.mShakeSensor;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null && fzb.f17429O000000o == null) {
            fzb.f17429O000000o = new fza(new fza.O000000o() {
                /* class _m_j.fzb.AnonymousClass1 */

                public final void O000000o() {
                    ReactContext currentReactContext;
                    gbu.O00000o0("onShake,");
                    gbu.O00000o0("sendChangeEvent,");
                    WritableMap createMap = Arguments.createMap();
                    ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
                    if (reactInstanceManager != null && (currentReactContext = reactInstanceManager.getCurrentReactContext()) != null) {
                        gbu.O00000o0("sendChangeEvent,emit");
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onShakeChange_36621", createMap);
                    }
                }
            });
            fza fza = fzb.f17429O000000o;
            SensorManager sensorManager = (SensorManager) reactApplicationContext.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor != null) {
                fza.f17428O000000o = sensorManager;
                fza.O00000Oo = -1;
                fza.f17428O000000o.registerListener(fza, defaultSensor, 2);
                fza.O00000o0 = 0;
                fza.O00000Oo();
            }
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void stopShakeListener(Callback callback) {
        fyc.O000000o("MIOTSystemModule", "stopShakeListener,");
        fzb fzb = this.mShakeSensor;
        if (fzb != null) {
            fzb.O000000o();
            this.mShakeSensor = null;
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, null, "success"));
    }

    @ReactMethod
    public void getWifiBroadcastAddress(Callback callback) {
        if (callback != null) {
            InetAddress O000000o2 = hzb.O000000o(getReactApplicationContext());
            if (O000000o2 != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("address", O000000o2.getHostAddress());
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                return;
            }
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "not connect wifi..."));
        }
    }

    @ReactMethod
    public void connectWifi(String str, String str2) {
        ScanResult scanResult;
        iad iad;
        gbu.O00000o0("connectWifi ssid=".concat(String.valueOf(str)));
        WifiManager wifiManager = (WifiManager) getCurrentActivity().getApplicationContext().getSystemService("wifi");
        ConnectivityManager connectivityManager = (ConnectivityManager) getCurrentActivity().getSystemService("connectivity");
        if (Build.VERSION.SDK_INT < 29 || (iad = this.qConnectCallback) == null || iad.O00000o0 == null) {
            this.qConnectCallback = new iad() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSystemModule.AnonymousClass2 */

                public final void O000000o(Network network) {
                    super.O000000o(network);
                }

                public final void O000000o() {
                    super.O000000o();
                }

                public final void O00000Oo(Network network) {
                    super.O00000Oo(network);
                }
            };
            Iterator<ScanResult> it = wifiManager.getScanResults().iterator();
            while (true) {
                if (!it.hasNext()) {
                    scanResult = null;
                    break;
                }
                scanResult = it.next();
                if (scanResult.SSID.equalsIgnoreCase(str)) {
                    break;
                }
            }
            iag.O000000o(connectivityManager, wifiManager, str, str2, scanResult != null ? scanResult.BSSID : "", "", this.qConnectCallback, true, !TextUtils.isEmpty(str2));
            if (this.mReceiver != null) {
                getCurrentActivity().unregisterReceiver(this.mReceiver);
                this.mReceiver = null;
            }
            if (this.mReceiver == null) {
                this.mReceiver = new O000000o(str);
                getCurrentActivity().registerReceiver(this.mReceiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
                return;
            }
            return;
        }
        gbu.O00000o0("connect wifi , android Q+, callback !=null, return");
    }

    @ReactMethod
    public void getLocationServerState(Callback callback) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("state", fwq.O00000Oo() ? 1 : 0);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
    }

    private void unRegisterReceiver() {
        fyc.O000000o("MIOTSystemModule", "onActivityDestroyed");
        if (this.mReceiver != null && getCurrentActivity() != null) {
            getCurrentActivity().unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
        }
    }

    class O000000o extends BroadcastReceiver {
        private String O00000Oo;

        public O000000o(String str) {
            this.O00000Oo = str;
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
        public final void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            boolean z;
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE") && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
                WifiInfo connectionInfo = ((WifiManager) MIOTSystemModule.this.getCurrentActivity().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    Intent intent2 = new Intent("NETWORK.CONNECTION.CHANGED");
                    intent2.putExtra("ssid", connectionInfo.getSSID());
                    if (detailedState == NetworkInfo.DetailedState.CONNECTED && networkInfo.isConnected() && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        intent2.putExtra("connected", true);
                        z = true;
                    } else {
                        intent2.putExtra("connected", false);
                        z = false;
                    }
                    gbu.O00000o0(String.format("WifiReceiver network state changed, dest ssid=%s, current ssid=%s, connected = %s", this.O00000Oo, connectionInfo.getSSID(), String.valueOf(z)));
                    context.sendBroadcast(intent2);
                }
            }
        }
    }
}
