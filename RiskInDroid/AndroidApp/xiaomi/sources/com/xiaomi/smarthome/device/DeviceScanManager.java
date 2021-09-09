package com.xiaomi.smarthome.device;

import _m_j.eyr;
import _m_j.fnh;
import _m_j.fob;
import _m_j.fon;
import _m_j.fqr;
import _m_j.fsm;
import _m_j.ft;
import _m_j.fux;
import _m_j.ggb;
import _m_j.gnl;
import _m_j.gpv;
import _m_j.gpy;
import _m_j.gsy;
import _m_j.hmv;
import _m_j.hna;
import _m_j.htv;
import _m_j.htw;
import _m_j.hxi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceScanManager;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.sdk.SyncConfigCallback;
import com.xiaomi.smarthome.smartconfig.DevicePushBindManager;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public enum DeviceScanManager {
    instance;
    
    private static HashMap<String, Boolean> scType25Models = new HashMap<>();
    public boolean isResumed;
    private DevicePushBindManager.O00000Oo mAiotListener = new DevicePushBindManager.O00000Oo() {
        /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass11 */

        public final void O000000o(String str, PushBindEntity pushBindEntity) {
            gsy.O00000Oo("DeviceScanManager", "onScan bssid:".concat(String.valueOf(str)));
            if (pushBindEntity.O0000OoO) {
                DeviceScanManager.this.mHideWifiResult.put(str, pushBindEntity);
            } else {
                DeviceScanManager.this.mAiotWifiResult.put(str, pushBindEntity);
            }
            DeviceScanManager.this.updateScanDeviceView();
        }

        public final void O00000Oo(String str, PushBindEntity pushBindEntity) {
            gsy.O00000Oo("DeviceScanManager", "onDismiss bssid:".concat(String.valueOf(str)));
            if (pushBindEntity.O0000OoO) {
                DeviceScanManager.this.mHideWifiResult.remove(str);
            } else {
                DeviceScanManager.this.mAiotWifiResult.remove(str);
            }
            DeviceScanManager.this.updateScanDeviceView();
        }
    };
    public Map<String, PushBindEntity> mAiotWifiResult = new HashMap();
    public List<BleDevice> mBleDevices = new ArrayList();
    public final Runnable mBleSearch = new Runnable() {
        /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass1 */

        public final void run() {
            if (!DeviceScanManager.this.isResumed) {
                return;
            }
            if (fob.O00000Oo()) {
                DeviceScanManager.this.startBleScan();
            } else {
                DeviceScanManager.this.mHandler.postDelayed(DeviceScanManager.this.mBleSearch, 1000);
            }
        }
    };
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass10 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("wifi_scan_result_broadcast".equals(action)) {
                gsy.O00000Oo("DeviceScanManager", "onReceive WIFI_SCAN_BR");
                htw O000000o2 = htv.O000000o();
                if (O000000o2 != null && O000000o2.getWifiScanResult() != null) {
                    DeviceScanManager.this.mScanResult.clear();
                    DeviceScanManager.this.mScanResult.addAll(O000000o2.getWifiScanResult());
                    ArrayList arrayList = new ArrayList();
                    for (int size = DeviceScanManager.this.mScanResult.size() - 1; size >= 0; size--) {
                        if (!DeviceFactory.O0000OOo(DeviceScanManager.this.mScanResult.get(size))) {
                            ScanResult remove = DeviceScanManager.this.mScanResult.remove(size);
                            String O000000o3 = DeviceFactory.O000000o(remove);
                            if (DeviceFactory.O00000oo(O000000o3)) {
                                arrayList.add(new XiaomiRedMiRouter15(remove.SSID, O000000o3));
                            }
                        }
                    }
                    DeviceScanManager.this.mOldRouter15Devices.clear();
                    gsy.O00000Oo("DeviceScanManager", "XMRouter:check Xiaomi/Redmi sum(15) size " + arrayList.size());
                    DeviceScanManager.this.mOldRouter15Devices.addAll(arrayList);
                    DeviceScanManager.this.updateScanDeviceView();
                }
            } else if ("ap_device_msg".equals(action)) {
                gsy.O00000Oo("DeviceScanManager", "onReceive AP_DEVICE_MSG");
                if (DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice() != null && DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice().size() > 0) {
                    DeviceScanManager.this.mDeviceScanResult.clear();
                    DeviceScanManager.this.mDeviceScanResult.addAll(DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice());
                    DeviceScanManager.this.updateScanDeviceView();
                }
            } else if (fob.f16735O000000o.equals(action)) {
                gsy.O00000Oo("DeviceScanManager", "onReceive BLE_REFRESH_CHOOSE");
                List<BleDeviceGroup> O000000o4 = fob.O000000o();
                if (O000000o4 != null) {
                    DeviceScanManager.this.mBleDevices.clear();
                    DeviceScanManager.this.mBleDevices.addAll(O000000o4);
                    DeviceScanManager.this.updateScanDeviceView();
                }
            }
        }
    };
    public List<Object> mCacheScanResult = new ArrayList();
    public List<ScanResult> mDeviceScanResult = new ArrayList();
    public Handler mHandler = new Handler();
    public Map<String, PushBindEntity> mHideWifiResult = new HashMap();
    private final List<hmv> mListener = new ArrayList();
    public List<MiTVDevice> mMitvDevices = new ArrayList();
    public List<XiaomiRedMiRouter15> mOldRouter15Devices = new ArrayList();
    private final Runnable mScanInterval = new Runnable() {
        /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass8 */

        public final void run() {
            if (DeviceScanManager.this.isResumed) {
                DeviceScanManager.this.mHandler.postDelayed(this, 10000);
                if (!hna.O00000Oo().isSHMainActivityResumed()) {
                    DevicePushBindManager.instance.checkDeviceWifi();
                }
            }
        }
    };
    public List<ScanResult> mScanResult = new ArrayList();
    private Dialog mTmpDialog = null;
    private Runnable mUpdateView = new Runnable() {
        /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass9 */

        public final void run() {
            if (DeviceScanManager.this.isResumed) {
                ArrayList arrayList = new ArrayList(DeviceScanManager.this.mScanResult);
                ArrayList arrayList2 = new ArrayList(DeviceScanManager.this.mDeviceScanResult);
                ArrayList arrayList3 = new ArrayList(DeviceScanManager.this.mBleDevices);
                for (int size = arrayList3.size() - 1; size >= 0; size--) {
                    BleDevice bleDevice = (BleDevice) arrayList3.get(size);
                    if (bleDevice != null && TextUtils.equals(bleDevice.model, "yeelink.uwb.tag1")) {
                        arrayList3.remove(bleDevice);
                    }
                }
                Observable.create(new Observable.OnSubscribe(arrayList, arrayList2, arrayList3, new ArrayList(DeviceScanManager.this.mOldRouter15Devices)) {
                    /* class com.xiaomi.smarthome.device.$$Lambda$DeviceScanManager$9$hFvaRzwkqE6Kv5P0JcZdtk3IzY */
                    private final /* synthetic */ List f$1;
                    private final /* synthetic */ List f$2;
                    private final /* synthetic */ List f$3;
                    private final /* synthetic */ List f$4;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                    }

                    public final void call(Object obj) {
                        DeviceScanManager.AnonymousClass9.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, (Subscriber) obj);
                    }
                }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
                    /* class com.xiaomi.smarthome.device.$$Lambda$DeviceScanManager$9$eMHrWaZcZnOeRLCBYw0ZFbxAFd4 */

                    public final void call(Object obj) {
                        DeviceScanManager.AnonymousClass9.this.O000000o((Map) obj);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(List list, List list2, List list3, List list4, Subscriber subscriber) {
            String str;
            HashMap hashMap = new HashMap(DeviceScanManager.this.mHideWifiResult);
            HashMap hashMap2 = new HashMap(DeviceScanManager.this.mAiotWifiResult);
            for (Map.Entry key : hashMap.entrySet()) {
                String str2 = (String) key.getKey();
                PushBindEntity pushBindEntity = (PushBindEntity) hashMap2.get(str2);
                if (pushBindEntity == null) {
                    String O0000ooO = DeviceFactory.O0000ooO(str2);
                    str = O0000ooO;
                    pushBindEntity = (PushBindEntity) hashMap2.get(O0000ooO);
                } else {
                    str = str2;
                }
                if (pushBindEntity != null) {
                    if (pushBindEntity.O00000o0()) {
                        hashMap.remove(str2);
                        hashMap.put(str, pushBindEntity);
                    }
                    hashMap2.remove(str);
                }
            }
            hashMap.putAll(hashMap2);
            DeviceScanManager.this.removeDuplicateDevice(list, list2, list3, hashMap);
            HashMap hashMap3 = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ScanResult scanResult = (ScanResult) it.next();
                hashMap3.put(scanResult.BSSID, scanResult);
            }
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                ScanResult scanResult2 = (ScanResult) it2.next();
                hashMap3.put(scanResult2.BSSID, scanResult2);
            }
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                BleDevice bleDevice = (BleDevice) it3.next();
                if (!(bleDevice instanceof BleDeviceGroup)) {
                    hashMap3.put(bleDevice.mac, bleDevice);
                } else if (DeviceScanManager.isSpecialBleGroup(bleDevice)) {
                    hashMap3.put(bleDevice.mac, bleDevice);
                } else {
                    hashMap3.put(bleDevice.model, bleDevice);
                }
            }
            Iterator it4 = list4.iterator();
            while (it4.hasNext()) {
                XiaomiRedMiRouter15 xiaomiRedMiRouter15 = (XiaomiRedMiRouter15) it4.next();
                hashMap3.put(xiaomiRedMiRouter15.bssid, xiaomiRedMiRouter15);
            }
            for (Map.Entry value : hashMap.entrySet()) {
                PushBindEntity pushBindEntity2 = (PushBindEntity) value.getValue();
                hashMap3.put(pushBindEntity2.O00000o, pushBindEntity2);
            }
            for (MiTVDevice next : DeviceScanManager.this.mMitvDevices) {
                hashMap3.put(TextUtils.isEmpty(next.mac) ? next.did : next.mac, next);
            }
            subscriber.onNext(hashMap3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(Map map) {
            for (int size = DeviceScanManager.this.mCacheScanResult.size() - 1; size >= 0; size--) {
                Object obj = DeviceScanManager.this.mCacheScanResult.get(size);
                Object obj2 = null;
                if (obj instanceof ScanResult) {
                    obj2 = map.remove(((ScanResult) obj).BSSID);
                } else if (obj instanceof BleDeviceGroup) {
                    if (DeviceScanManager.isSpecialBleGroup((BleDevice) obj)) {
                        obj2 = map.remove(((BleDeviceGroup) obj).mac);
                    } else {
                        obj2 = map.remove(((BleDeviceGroup) obj).model);
                    }
                } else if (obj instanceof BleDevice) {
                    obj2 = map.remove(((BleDevice) obj).mac);
                } else if (obj instanceof PushBindEntity) {
                    obj2 = map.remove(((PushBindEntity) obj).O00000o);
                } else if (obj instanceof MiTVDevice) {
                    MiTVDevice miTVDevice = (MiTVDevice) obj;
                    obj2 = map.remove(TextUtils.isEmpty(miTVDevice.mac) ? miTVDevice.did : miTVDevice.mac);
                } else if (obj instanceof XiaomiRedMiRouter15) {
                    obj2 = map.remove(((XiaomiRedMiRouter15) obj).mRealModel);
                }
                if (obj2 == null) {
                    DeviceScanManager.this.mCacheScanResult.remove(size);
                } else {
                    DeviceScanManager.this.mCacheScanResult.set(size, obj2);
                }
            }
            if (map.size() != 0) {
                DeviceScanManager.this.mCacheScanResult.addAll(0, map.values());
            }
            DeviceScanManager deviceScanManager = DeviceScanManager.this;
            deviceScanManager.dispatchOnScan(deviceScanManager.mCacheScanResult);
        }
    };
    public boolean mWaitingLocationResult = false;
    private MLAlertDialog mlAlertBleDialog;

    public static boolean isScType25(String str) {
        Boolean bool = scType25Models.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O00000oO == null || O00000oO.O00000o() != 25) {
            scType25Models.put(str, Boolean.FALSE);
            return false;
        }
        scType25Models.put(str, Boolean.TRUE);
        return true;
    }

    public static boolean isSpecialBleGroup(BleDevice bleDevice) {
        if (isScType25(bleDevice.model)) {
            return true;
        }
        return bleDevice.model.startsWith("xiaomi.wifispeaker.");
    }

    public final void dispatchOnScan(List<?> list) {
        for (int i = 0; i < this.mListener.size(); i++) {
            this.mListener.get(i).onScan(list);
        }
    }

    public final void checkAll(Activity activity) {
        Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo0 == null || O0000Oo0.isOwner()) {
            checkTips(activity);
        } else {
            showSwitchHome(activity);
        }
    }

    private void showSwitchHome(final Activity activity) {
        Dialog dialog = this.mTmpDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mTmpDialog.dismiss();
        }
        this.mTmpDialog = new MLAlertDialog.Builder(activity).O00000Oo((int) R.string.share_home_adddevice_tips).O000000o((int) R.string.change_home, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass13 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                String str;
                List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
                if (list != null) {
                    Iterator<Home> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        Home next = it.next();
                        if (next != null && next.isOwner()) {
                            str = next.getId();
                            break;
                        }
                    }
                    ggb.O00000Oo().O000000o(str, (fsm) null);
                }
                DeviceScanManager.this.checkTips(activity);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass12 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                Activity activity = activity;
                if (activity != null) {
                    activity.finish();
                }
            }
        }).O000000o(false).O00000oo();
    }

    public final void checkTips(Activity activity) {
        checkPermission(activity);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    private void showFindDeviceTips(final Activity activity) {
        hxi.O00000oO.f958O000000o.O000000o("app_bottom_autodisc_popup", new Object[0]);
        gpv.O00000Oo("open_find_device_tips", false);
        Dialog dialog = this.mTmpDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mTmpDialog.dismiss();
        }
        this.mTmpDialog = new MLAlertDialog.Builder(activity).O000000o((int) R.string.setting_tips_title).O00000Oo((int) R.string.open_find_device_tips).O000000o((int) R.string.auto_discovery_setting_now, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass3 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
             arg types: [android.content.Context, java.lang.String, java.lang.String, int]
             candidates:
              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
              _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
            public final void onClick(DialogInterface dialogInterface, int i) {
                hxi.O00000o.f952O000000o.O000000o("app_popup_determine", new Object[0]);
                gpy.O000000o(CommonApplication.getAppContext(), "prefs_lite_config", "miui_auto_discovery", true);
            }
        }).O00000Oo((int) R.string.setting_later, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                hxi.O00000o.O00000o();
            }
        }).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass16 */

            public final void onCancel(DialogInterface dialogInterface) {
                hxi.O00000o.O00000o();
            }
        }).O000000o(new MLAlertDialog.O000000o() {
            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass14 */

            public final void beforeDismissCallBack() {
            }

            public final void afterDismissCallBack() {
                DeviceScanManager.this.checkPermission(activity);
            }
        }).O00000o();
        this.mTmpDialog.show();
    }

    public final void checkPermission(final Activity activity) {
        boolean z;
        try {
            z = ((WifiManager) activity.getApplicationContext().getSystemService("wifi")).isWifiEnabled();
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            Dialog dialog = this.mTmpDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mTmpDialog.dismiss();
            }
            this.mTmpDialog = new MLAlertDialog.Builder(activity).O00000Oo((int) R.string.wifi_disable_hint).O000000o((int) R.string.setting, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        activity.startActivity(new Intent("android.net.wifi.PICK_WIFI_NETWORK"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    dialogInterface.dismiss();
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).O00000oo();
        }
        if (!fux.O000000o()) {
            Dialog dialog2 = this.mTmpDialog;
            if (dialog2 != null && dialog2.isShowing()) {
                this.mTmpDialog.dismiss();
            }
            if (hna.O00000Oo().isMIUIInternational()) {
                hna.O000000o().checkPassedForLocation(activity, true, null, activity.getString(R.string.permission_location_rational_desc_new));
            } else {
                fux.O000000o(activity, (int) R.string.permission_location_rational_desc_new, new fux.O000000o() {
                    /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass6 */

                    public final void O000000o(boolean z) {
                        DeviceScanManager.this.mWaitingLocationResult = false;
                        hxi.O00000o0.O000000o(z ? 1 : 2, 1);
                    }

                    public final void O00000Oo(boolean z) {
                        DeviceScanManager.this.mWaitingLocationResult = false;
                        hxi.O00000o.O0000oo0(z ? 2 : 4);
                    }

                    public final void O00000o0(boolean z) {
                        hxi.O00000o.O0000oo0(z ? 1 : 3);
                        DeviceScanManager.this.mHandler.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                DeviceScanManager.this.mWaitingLocationResult = true;
                            }
                        }, 800);
                    }
                });
            }
        }
        if (!gnl.O00000Oo()) {
            openBluetooth(activity);
        } else {
            startBleScan();
        }
    }

    public final void getScanCache(hmv hmv) {
        hmv.onScan(this.mCacheScanResult);
    }

    public final void addDeviceOnResume() {
        if (this.mWaitingLocationResult) {
            this.mWaitingLocationResult = false;
            hxi.O00000o.O0000oo(fux.O000000o() ? 1 : 2);
        }
    }

    public final void onResume(hmv hmv) {
        gsy.O00000Oo("DeviceScanManager", "onResume ".concat(String.valueOf(hmv)));
        this.isResumed = true;
        if (hmv != null && !this.mListener.contains(hmv)) {
            this.mListener.add(hmv);
        }
        this.mScanResult.clear();
        htw O000000o2 = htv.O000000o();
        if (!(O000000o2 == null || O000000o2.getWifiScanResult() == null)) {
            this.mScanResult.addAll(O000000o2.getWifiScanResult());
        }
        ArrayList arrayList = new ArrayList();
        for (int size = this.mScanResult.size() - 1; size >= 0; size--) {
            if (!DeviceFactory.O0000OOo(this.mScanResult.get(size))) {
                ScanResult remove = this.mScanResult.remove(size);
                String O000000o3 = DeviceFactory.O000000o(remove);
                if (!TextUtils.isEmpty(O000000o3) && DeviceFactory.O00000oo(O000000o3)) {
                    arrayList.add(new XiaomiRedMiRouter15(remove.SSID, O000000o3));
                }
            }
        }
        this.mOldRouter15Devices.clear();
        this.mOldRouter15Devices.addAll(arrayList);
        this.mDeviceScanResult.clear();
        this.mDeviceScanResult.addAll(DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice());
        this.mBleDevices.clear();
        this.mBleDevices.addAll(fob.O000000o());
        this.mAiotWifiResult.clear();
        this.mAiotWifiResult.putAll(DevicePushBindManager.instance.getCache(false));
        this.mHideWifiResult.clear();
        this.mHideWifiResult.putAll(DevicePushBindManager.instance.getCache(true));
        this.mMitvDevices.clear();
        this.mMitvDevices.addAll(fnh.O000000o().O00000o0());
        updateScanDeviceView();
        IntentFilter intentFilter = new IntentFilter("wifi_scan_result_broadcast");
        intentFilter.addAction(fob.f16735O000000o);
        intentFilter.addAction("ap_device_msg");
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.mBroadcastReceiver, intentFilter);
        DevicePushBindManager.instance.registScanListener(this.mAiotListener);
        this.mHandler.post(this.mScanInterval);
        eyr.O00000Oo().O000000o(new SyncConfigCallback.Stub() {
            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass15 */

            public void onResponse(int i, String str) throws RemoteException {
                DeviceScanManager.this.mHandler.post(DeviceScanManager.this.mBleSearch);
                htw O000000o2 = htv.O000000o();
                if (O000000o2 != null) {
                    O000000o2.startScan(1);
                }
            }
        });
    }

    public final void onPause(hmv hmv) {
        gsy.O00000Oo("DeviceScanManager", "onPause ".concat(String.valueOf(hmv)));
        this.isResumed = false;
        this.mListener.remove(hmv);
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.mBroadcastReceiver);
        DevicePushBindManager.instance.unregistScanListener(this.mAiotListener);
        this.mHandler.removeCallbacks(this.mBleSearch);
        this.mHandler.removeCallbacks(this.mScanInterval);
        CoreApi.O000000o().O000O0OO();
        fob.O00000o0();
    }

    public final void startBleScan() {
        fob.O000000o((fon) null);
        this.mHandler.postDelayed(this.mBleSearch, 11000);
    }

    private void openBluetooth(Activity activity) {
        this.mlAlertBleDialog = fqr.O000000o(activity, new BleResponse() {
            /* class com.xiaomi.smarthome.device.DeviceScanManager.AnonymousClass7 */

            public final void onResponse(int i, Object obj) {
                hxi.O00000o.O00000o0();
                if (i == 0) {
                    DeviceScanManager.this.startBleScan();
                }
            }
        });
    }

    public final void onOrientaionChanged() {
        MLAlertDialog mLAlertDialog = this.mlAlertBleDialog;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.mlAlertBleDialog.dismiss();
            this.mlAlertBleDialog.show();
        }
    }

    public final void updateScanDeviceView() {
        this.mHandler.removeCallbacks(this.mUpdateView);
        this.mHandler.postDelayed(this.mUpdateView, 500);
    }

    private boolean isContainBssid(Map<String, PushBindEntity> map, String str) {
        if (!map.containsKey(str.toUpperCase(Locale.ENGLISH)) && !map.containsKey(DeviceFactory.O0000oo(str).toUpperCase(Locale.ENGLISH))) {
            return false;
        }
        return true;
    }

    public final void removeDuplicateDevice(List<ScanResult> list, List<ScanResult> list2, List<BleDevice> list3, Map<String, PushBindEntity> map) {
        String O00000o0;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, PushBindEntity> value : map.entrySet()) {
            PushBindEntity pushBindEntity = (PushBindEntity) value.getValue();
            if (pushBindEntity != null && ((DeviceFactory.O00000Oo(pushBindEntity.O00000o0, pushBindEntity.O00000o) == DeviceFactory.AP_TYPE.AP_MIBAP || pushBindEntity.O0000OoO) && (O00000o0 = DeviceFactory.O00000o0(pushBindEntity.O00000o, pushBindEntity.O00000o0)) != null)) {
                hashMap.put(O00000o0.toUpperCase(Locale.ENGLISH), pushBindEntity);
            }
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            ScanResult scanResult = list.get(size);
            String str = scanResult.BSSID;
            if (str == null || !isContainBssid(map, str)) {
                String O00000o02 = DeviceFactory.O00000o0(str, scanResult.SSID);
                if (O00000o02 != null) {
                    hashMap.put(O00000o02.toUpperCase(Locale.ENGLISH), scanResult);
                }
            } else {
                list.remove(size);
            }
        }
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            ScanResult scanResult2 = list2.get(size2);
            String O00000o03 = DeviceFactory.O00000o0(scanResult2.BSSID, scanResult2.SSID);
            if (O00000o03 != null) {
                hashMap.put(O00000o03.toUpperCase(Locale.ENGLISH), scanResult2);
            }
        }
        for (int size3 = list3.size() - 1; size3 >= 0; size3--) {
            BleDevice bleDevice = list3.get(size3);
            MiotBleAdvPacket O00000Oo = bleDevice.O00000Oo();
            if (DeviceFactory.O00000Oo(bleDevice) && O00000Oo != null && O00000Oo.O00000oo != null && hashMap.containsKey(O00000Oo.O00000oo.toUpperCase(Locale.ENGLISH))) {
                list3.remove(size3);
            }
        }
    }

    public final void removeMitv(MiTVDevice miTVDevice) {
        this.mMitvDevices.remove(miTVDevice);
    }
}
