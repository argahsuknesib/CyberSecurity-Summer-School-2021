package _m_j;

import _m_j.ddt;
import _m_j.hzm;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import com.sankuai.waimai.router.annotation.RouterService;
import com.smarthome.uwb.ui.SecurityCodeActivity;
import com.smarthome.uwb.ui.UwbNoPermissionActivity;
import com.smarthome.uwb.ui.UwbTagBindLoadingActivity;
import com.smarthome.uwb.ui.UwbTagCommonDialogActivity;
import com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.kuailian.builtin.KuailianUwbBuiltinManager;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.UwbSdkConfig;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.processor.ProcessorCallback;
import com.xiaomi.smarthome.uwb.lib.processor.engine.DeviceBindHelper;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.tv.ThirdTvCardActivity;
import com.xiaomi.smarthome.uwb_mijia.bind.UwbDeviceBinder$1;
import java.util.ArrayList;
import java.util.List;

@RouterService
public class hzl implements hzg {
    private static final hzl INSTANCE = new hzl();

    static /* synthetic */ void lambda$refreshUwbData$0(ArrayList arrayList) throws Exception {
    }

    static /* synthetic */ void lambda$syncUwbConfig$1(hzk hzk) throws Exception {
    }

    static /* synthetic */ void lambda$syncUwbConfig$2(Integer num) throws Exception {
    }

    @cug
    public static hzl provideInstance() {
        return INSTANCE;
    }

    public void init() {
        hzm O000000o2 = hzm.O000000o();
        if (!O000000o2.O00000Oo.getAndSet(true)) {
            O000000o2.f1014O000000o = new ProcessorCallback() {
                /* class _m_j.hzm.AnonymousClass1 */

                public final void onDownloadMijia(int i) {
                }

                public final void onRetrieveMemberSpecificKey(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener) {
                }

                public final void handleTvType(UwbScanDevice uwbScanDevice) {
                    UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "UwbLogUtilPlus handleTvType");
                    if (UwbDeviceUtil.isMitvLogin(uwbScanDevice)) {
                        new AllReadyCallback(new Runnable() {
                            /* class _m_j.$$Lambda$hzm$1$5PLXCQ_5oOgM2VuCMvOxVwZ_eo */

                            public final void run() {
                                hzm.AnonymousClass1.O00000Oo(UwbScanDevice.this);
                            }
                        });
                    } else if (!UwbDeviceUtil.isMitvAuthAll(uwbScanDevice)) {
                        UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "UwbLogUtilPlus permission activity no login");
                        UwbNoPermissionActivity.startUwbNoPermissionActivity(UwbSdk.getApplication(), uwbScanDevice);
                    } else {
                        UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "UwbLogUtilPlus start SecurityCodeActivity no login");
                        SecurityCodeActivity.startSecurityCodeActivity(uwbScanDevice);
                    }
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void O00000Oo(UwbScanDevice uwbScanDevice) {
                    if (!hzq.O00000o0(uwbScanDevice) && !hzq.O00000Oo(uwbScanDevice) && !UwbDeviceUtil.isMitvAuthAll(uwbScanDevice)) {
                        UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "UwbLogUtilPlus permission activity login");
                        UwbNoPermissionActivity.startUwbNoPermissionActivity(UwbSdk.getApplication(), uwbScanDevice);
                    } else if (UwbDeviceUtil.isHidTagForMitv(uwbScanDevice)) {
                        UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "start ThirdTvCardActivity for mitv because tag is in hid mode");
                        ThirdTvCardActivity.startCardActivity(UwbSdk.getApplication(), uwbScanDevice);
                    } else {
                        UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "UwbLogUtilPlus start SecurityCodeActivity login");
                        SecurityCodeActivity.startSecurityCodeActivity(uwbScanDevice);
                    }
                }

                public final void handleThirdTagType(UwbScanDevice uwbScanDevice) {
                    UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "handleThirdTagType");
                    new AllReadyCallback(new Runnable() {
                        /* class _m_j.$$Lambda$hzm$1$PSEbMj_gvWxlP0wnCJ5iDjDwXyA */

                        public final void run() {
                            hzm.AnonymousClass1.O000000o(UwbScanDevice.this);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void O000000o(UwbScanDevice uwbScanDevice) {
                    if (hzn.O00000Oo(uwbScanDevice)) {
                        ThirdTvCardActivity.startCardActivity(UwbSdk.getApplication(), uwbScanDevice);
                    } else {
                        UwbNoPermissionActivity.startUwbNoPermissionActivity(UwbSdk.getApplication(), uwbScanDevice);
                    }
                }

                public final void handleIotDeviceType(UwbScanDevice uwbScanDevice) {
                    UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "handleIotDeviceType ".concat(String.valueOf(uwbScanDevice)));
                    hzn.O000000o(uwbScanDevice);
                }

                public final void onBindTag(UwbScanDevice uwbScanDevice, DeviceBindHelper.BindDeviceListener bindDeviceListener) {
                    boolean z;
                    UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "onBindTag");
                    WifiManager wifiManager = (WifiManager) UwbSdk.getApplication().getApplicationContext().getSystemService("wifi");
                    if (!wifiManager.isWifiEnabled()) {
                        UwbTagCommonDialogActivity.startShowWifiNotEnabledDialog();
                        z = false;
                    } else {
                        wifiManager.getConnectionInfo();
                        z = true;
                    }
                    if (z) {
                        UwbSdk.setBindDeviceListener(bindDeviceListener);
                        Intent intent = new Intent(UwbSdk.getApplication(), BindUwbTagDeviceActivity.class);
                        intent.putExtra("uwb_scan_device", uwbScanDevice);
                        intent.addFlags(268435456);
                        UwbSdk.getApplication().startActivity(intent);
                    }
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean
                 arg types: [?[OBJECT, ARRAY], int, ?]
                 candidates:
                  _m_j.fux.O000000o(android.app.Activity, int, _m_j.fux$O000000o):boolean
                  _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean */
                public final void onBindBuiltin(UwbScanDevice uwbScanDevice, DeviceBindHelper.BindDeviceListener bindDeviceListener) {
                    UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "onBindBuiltin");
                    if (fux.O000000o((Activity) null, false, (int) R.string.location_disable_hint)) {
                        String O00000Oo = CoreApi.O000000o().O00000Oo((int) uwbScanDevice.getPid());
                        UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startBindBuiltin start, pid = " + uwbScanDevice.getPid() + ", model = " + O00000Oo);
                        dcp.O000000o().O00000Oo(true);
                        KuailianUwbBuiltinManager.getInstance().doOpenUwbBleConfigActivity(uwbScanDevice.getMacAddress(), O00000Oo, new UwbDeviceBinder$1(uwbScanDevice));
                        return;
                    }
                    UwbTagBindLoadingActivity.startCheckPermission();
                }

                public final void startKeyRetrieve(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener) {
                    UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "startKeyRetrieve");
                }
            };
            UwbSdk.init(CommonApplication.getApplication(), new UwbSdkConfig.Builder().setMode(3).setMode(2).build(), null);
            UwbSdk.setProcessorCallback(O000000o2.f1014O000000o);
            UwbSdk.setUsingEncrypt(true);
        }
    }

    public void processUWBIntent(Context context, Intent intent, Uri uri) {
        hzm.O000000o().O000000o(context, intent, uri);
    }

    @SuppressLint({"CheckResult"})
    public void refreshUwbData() {
        ddt ddt = ddt.f14518O000000o;
        ddt.O00000Oo().subscribe($$Lambda$hzl$KGE3Yqkd66etPmcRh7VhHs9pQ.INSTANCE, $$Lambda$Jxp4LOjD5wh7hYvpBAWXzgH0LNY.INSTANCE);
    }

    public boolean isUwbAvailable() {
        return UwbIdmManager.getInstance().isUwbValid();
    }

    public List<Device> getTagDevices(String str) {
        return hzq.O00000Oo(str);
    }

    public List<Device> getTagDevicesAll() {
        return hzq.O000000o();
    }

    public boolean isTagType(String str) {
        return hzq.O000000o(str);
    }

    public void showUwbPermissionSettingDialog(Activity activity) {
        ddx ddx = ddx.f14529O000000o;
        ddx.O000000o(activity);
    }

    @SuppressLint({"CheckResult"})
    public void syncUwbConfig() {
        ddt.O00000o.getRemoteConfig().subscribe($$Lambda$hzl$r6BGYoeH4f5zmmXt1IEJX7F_l0.INSTANCE, $$Lambda$Jxp4LOjD5wh7hYvpBAWXzgH0LNY.INSTANCE);
        ddt.O000000o.O00000Oo().subscribe($$Lambda$hzl$81KzF809JWdJXqVkG7i21eq4JsA.INSTANCE, $$Lambda$Jxp4LOjD5wh7hYvpBAWXzgH0LNY.INSTANCE);
    }

    public void logD(String str, String str2) {
        UwbLogUtil.d(str, str2);
    }

    public void logE(String str, String str2) {
        UwbLogUtil.e(str, str2);
    }

    @SuppressLint({"CheckResult"})
    public void syncUwbBindInfos() {
        ddt ddt = ddt.f14518O000000o;
        ddt.O000000o(new Runnable() {
            /* class _m_j.hzl.AnonymousClass1 */

            public final void run() {
            }
        });
    }
}
