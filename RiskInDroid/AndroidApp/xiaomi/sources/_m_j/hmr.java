package _m_j;

import _m_j.fnu;
import android.content.Context;
import android.content.IntentFilter;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.format.Formatter;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.miot.BinderParcel;
import com.xiaomi.qrcode.ScanBarcodeActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.ChooseGatewayDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceScanManager;
import com.xiaomi.smarthome.device.api.DeviceRssiApi;
import com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity;
import com.xiaomi.smarthome.device.choosedevice.ResetPageRoute;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miui.FindDeviceDialogActivity;
import com.xiaomi.smarthome.service.DeviceObserveService;
import com.xiaomi.smarthome.smartconfig.DevicePushBindManager;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler;
import java.util.List;
import java.util.Map;

@RouterService
public class hmr implements hms {
    public List<Device> getGatewayDevices(String str) {
        return ChooseGatewayDevice.getGatewayDevices(str);
    }

    public void doScanOnResume(hmv hmv) {
        DeviceScanManager.instance.onResume(hmv);
    }

    public void doScanOnPause(hmv hmv) {
        DeviceScanManager.instance.onPause(hmv);
    }

    public void checkAiotDeviceWifi() {
        DevicePushBindManager.instance.checkDeviceWifi();
    }

    public void clearAiotDeviceWifi() {
        DevicePushBindManager.instance.clear();
    }

    public Class<?> getChooseDeviceActivity() {
        return ChooseDeviceActivity.class;
    }

    public Class<?> getScanBarcodeActivityClass() {
        return ScanBarcodeActivity.class;
    }

    public Class<?> getResetPageRouteClass() {
        return ResetPageRoute.class;
    }

    public void pauseMainConnectScanManager() {
        fmy O00000o0 = fmy.O00000o0();
        dct.O000000o();
        dct.O00000Oo("pause");
        if (O00000o0.O00000o0 != null && !O00000o0.O00000o0.isDisposed()) {
            dct.O00000o("disposable getSetting");
            O00000o0.O00000o0.dispose();
        }
        if (O00000o0.O0000Oo) {
            O00000o0.O0000Oo = false;
            if (O00000o0.O00000Oo) {
                ft.O000000o(CommonApplication.getAppContext()).O000000o(O00000o0.O0000OoO);
            }
            O00000o0.O0000Oo0.removeCallbacksAndMessages(null);
            fob.O00000o0();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public void resumeMainConnectScanManager() {
        fmy O00000o0 = fmy.O00000o0();
        boolean O00000o02 = gpy.O00000o0(CommonApplication.getAppContext(), "prefs_lite_config", "nearby_auto_discovery", true);
        dcp.O000000o().O000000o(CommonApplication.getAppContext());
        if (!O00000o02) {
            O00000o0.O00000Oo = false;
            dct.O00000o0("nearby disable auto discovery");
            return;
        }
        O00000o0.O00000o0 = null;
        if (fmy.O00000o != null) {
            fmy.O00000o = null;
        }
        dct.O00000Oo("resume");
        fmk O000000o2 = fmk.O000000o();
        if (O000000o2.O00000o0 == null || O000000o2.O00000o == null) {
            if (O000000o2.O00000o0 == null) {
                O000000o2.O00000o0 = new gpq("DeviceRssiMatchHelper");
                O000000o2.O00000o0.start();
            }
            if (O000000o2.O00000o == null) {
                O000000o2.O00000o = new Handler(O000000o2.O00000o0.getLooper()) {
                    /* class _m_j.fmk.AnonymousClass1 */

                    public final void handleMessage(Message message) {
                        if (message.what == 1) {
                            fmk fmk = fmk.this;
                            if (!fmk.f16651O000000o) {
                                fmk.f16651O000000o = true;
                                DeviceRssiApi.getInstance().requestAllRssiConfig(CommonApplication.getAppContext(), Build.MODEL, new fsm<Map<String, Integer>, fso>() {
                                    /* class _m_j.fmk.AnonymousClass2 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        Map map = (Map) obj;
                                        if (map != null && !map.isEmpty()) {
                                            fmk.this.O00000Oo.putAll(map);
                                        }
                                        fmk.this.f16651O000000o = false;
                                    }

                                    public final void onFailure(fso fso) {
                                        LogType logType = LogType.MICONNECT;
                                        gsy.O000000o(logType, "DeviceRssiMatchHelper", "requestAllRssiConfig error, detail = " + fso.O00000Oo);
                                        fmk fmk = fmk.this;
                                        fmk.f16651O000000o = false;
                                        if (fmk.O00000o != null) {
                                            fmk.this.O00000o.sendEmptyMessageDelayed(1, 3000);
                                        }
                                    }
                                });
                            }
                        }
                    }
                };
            }
        }
        O000000o2.O00000o.sendEmptyMessage(1);
        dct.O000000o();
        O00000o0.O0000Oo = true;
        ft.O000000o(CommonApplication.getAppContext()).O000000o(O00000o0.O0000OoO, new IntentFilter(fob.f16735O000000o));
        O00000o0.O00000Oo = true;
        O00000o0.O0000Oo0.postDelayed(O00000o0.O0000Ooo, fmy.f16674O000000o.longValue());
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new CoreApi.O0000o0() {
            /* class _m_j.fmy.AnonymousClass4 */

            public final void onCoreReady() {
                fmy.this.O00000Oo();
                fmy.this.O00000oO = System.currentTimeMillis();
            }
        });
    }

    public void onStartSmartConfig(String str) {
        DeviceObserveService.O000000o().O000000o(str);
    }

    public void onFinishSmartConfig(String str, boolean z) {
        DeviceObserveService.O000000o().O000000o(str, z);
    }

    public void startDeviceObserveService() {
        DeviceObserveService.O000000o().O00000Oo();
    }

    public void addBlackListForDevicePushBindManager(PushBindEntity pushBindEntity) {
        DevicePushBindManager.instance.addBlackList(pushBindEntity);
    }

    public void doBindForDevicePushBindManager(String str) {
        DevicePushBindManager.instance.bind(str);
    }

    public void clearDevicePushBind() {
        DevicePushBindManager.instance.clear();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.miot.BinderParcel]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    public void doOpenUwbBleConfigActivity(String str, String str2, IConfigCompletionHandler iConfigCompletionHandler) {
        htr.O000000o().O00000Oo.clear();
        fbt fbt = new fbt(CommonApplication.getAppContext(), "MiConnectConfigActivity");
        fbt.O000000o("is_uwb", true);
        fbt.O000000o("handler", (Parcelable) new BinderParcel(iConfigCompletionHandler.asBinder()));
        fbt.O000000o("model", str2);
        fbt.O000000o("mac_suffix", str);
        PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(str2);
        htx O000000o2 = hty.O000000o();
        if (O000000o2 != null) {
            fbt = O000000o2.setQrStep(fbt, pluginInfo.O00000o());
        }
        fbt.O00000Oo(268435456);
        fbs.O000000o(fbt);
    }

    public boolean isFindDeviceDialogShowing() {
        return FindDeviceDialogActivity.sResumed || fnu.O000000o.f16724O000000o.O000000o() || dcp.O000000o().O00000o0();
    }

    public Class<?> getDeviceObserveServiceClass() {
        return DeviceObserveService.class;
    }

    public void pauseXiaoMiRouterConnectionManager() {
        fnu.O000000o.f16724O000000o.f16714O000000o = null;
    }

    public void resumeXiaoMiRouterConnectionManager(Context context) {
        fnu fnu = fnu.O000000o.f16724O000000o;
        fnu.f16714O000000o = context;
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.fnu.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fnu.O000000o(java.lang.String, boolean):void
             arg types: [java.lang.String, int]
             candidates:
              _m_j.fnu.O000000o(java.lang.String, java.lang.Object[]):void
              _m_j.fnu.O000000o(java.lang.String, boolean):void */
            /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
                if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x002f;
             */
            public final void run() {
                String str;
                DhcpInfo dhcpInfo;
                gsy.O00000o0(LogType.KUAILIAN, "XiaoMiRouter", "getGatewayIpAddress,");
                WifiManager wifiManager = (WifiManager) CommonApplication.getApplication().getApplicationContext().getSystemService("wifi");
                if (!(wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null)) {
                    str = Formatter.formatIpAddress(dhcpInfo.gateway);
                }
                str = "miwifi.com";
                fnu.this.O000000o(str, false);
            }
        });
    }
}
