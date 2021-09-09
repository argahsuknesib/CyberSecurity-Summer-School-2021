package _m_j;

import _m_j.ddt;
import _m_j.hzr;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ApiErrorWrapper;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.kuailian.tag.KuailianUwbTagManger;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;

public final class hzs {

    public interface O000000o {
        void O000000o(int i, String str);

        void O000000o(Object obj);

        void O00000Oo(int i, String str);
    }

    public static String O000000o(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOW" : "PROGRESS_ASSOCIATE_SUCCESS" : "PROGRESS_ASSOCIATING" : "PROGRESS_BIND_SUCCESS" : "PROGRESS_BLE_SCAN_FOUND" : "PROGRESS_SCANNING";
    }

    public static void O000000o(UwbScanDevice uwbScanDevice, Device device) {
        if (uwbScanDevice != null) {
            uwbScanDevice.setAccountInfoPlain(CoreApi.O000000o().O0000o0());
            uwbScanDevice.setAccountInfo(UwbDeviceUtil.getUwbHashFirst3B(CoreApi.O000000o().O0000o0()));
            if (device != null) {
                DidInfo didInfo = uwbScanDevice.getDidInfo();
                if (didInfo == null) {
                    didInfo = new DidInfo();
                    uwbScanDevice.setDidInfo(didInfo);
                }
                didInfo.setPlainDid(device.did);
                didInfo.setDid(UwbDeviceUtil.getUwbHashFirst3B(device.did));
            }
        }
    }

    public static void O000000o(final UwbScanDevice uwbScanDevice, Device device, final Device device2, final O000000o o000000o) {
        if (device == null) {
            O000000o(uwbScanDevice, new O000000o() {
                /* class _m_j.hzs.AnonymousClass1 */

                public final void O000000o(int i, String str) {
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O000000o(i, str);
                    }
                }

                public final void O000000o(Object obj) {
                    if (obj == null || !(obj instanceof Device)) {
                        O000000o o000000o = o000000o;
                        if (o000000o != null) {
                            o000000o.O00000Oo(-1, "bind device error");
                            return;
                        }
                        return;
                    }
                    hzs.O00000Oo(uwbScanDevice, (Device) obj, device2, o000000o);
                }

                public final void O00000Oo(int i, String str) {
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O00000Oo(i, str);
                    }
                }
            }, 3);
        } else {
            O00000Oo(uwbScanDevice, device, device2, o000000o);
        }
    }

    public static void O000000o(final UwbScanDevice uwbScanDevice, final O000000o o000000o, final int i) {
        UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startConfig start");
        if (dcp.O000000o().O00000Oo()) {
            dcp.O000000o().O00000Oo(true);
            o000000o.O000000o(0, "start");
            new hzr().O000000o(uwbScanDevice.getMacAddress(), new hzr.O000000o() {
                /* class _m_j.hzs.AnonymousClass3 */

                public final void O000000o(BleDevice bleDevice) {
                    O000000o o000000o = o000000o;
                    o000000o.O000000o(1, "ble device:" + bleDevice.mac);
                    UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startConfig ble device onFound");
                    KuailianUwbTagManger.getInstance(CommonApplication.getAppContext()).init(bleDevice);
                    if (KuailianUwbTagManger.getInstance(CommonApplication.getAppContext()).isOngoing()) {
                        KuailianUwbTagManger.getInstance(CommonApplication.getAppContext()).release();
                    }
                    KuailianUwbTagManger.getInstance(CommonApplication.getAppContext()).startConfig(new KuailianUwbTagManger.KuailianUwbTagListener() {
                        /* class _m_j.hzs.AnonymousClass3.AnonymousClass1 */

                        public final void onStepSuccess(int i) {
                            UwbLogUtil.d("Mijia-UWB-Binder", "startConfig onStepSuccess ".concat(String.valueOf(i)));
                        }

                        public final void onLastResponse(int i, Device device) {
                            dcp.O000000o().O00000Oo(false);
                            o000000o.O000000o(2, "绑定成功");
                            UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startConfig onLastResponse ".concat(String.valueOf(i)));
                            KuailianUwbTagManger.getInstance(CommonApplication.getAppContext()).release();
                            hzs.O000000o(uwbScanDevice, device);
                            if (o000000o != null) {
                                o000000o.O000000o(device);
                            }
                        }

                        public final void onError(int i, Object obj) {
                            dcp.O000000o().O00000Oo(false);
                            KuailianUwbTagManger.getInstance(CommonApplication.getAppContext()).release();
                            UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startConfig onError ".concat(String.valueOf(i)));
                            if (o000000o != null) {
                                O000000o o000000o = o000000o;
                                StringBuilder sb = new StringBuilder("KuailianUwbTagManger error:");
                                sb.append(obj == null ? "" : obj.toString());
                                o000000o.O00000Oo(i, sb.toString());
                            }
                        }
                    });
                }

                public final void O000000o() {
                    dcp.O000000o().O00000Oo(false);
                    UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder ble device onTimeout");
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O00000Oo(-1, "onTimeout");
                    }
                }
            });
        } else if (i <= 0) {
            o000000o.O00000Oo(11, "CODE_MIUI_SERVICE_NOT_CREATED");
        } else {
            dcp.O000000o().O000000o(CommonApplication.getAppContext());
            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class _m_j.hzs.AnonymousClass2 */

                public final void run() {
                    hzs.O000000o(uwbScanDevice, o000000o, i - 1);
                }
            }, 2000);
        }
    }

    public static void O00000Oo(final UwbScanDevice uwbScanDevice, Device device, final Device device2, final O000000o o000000o) {
        UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startBind start");
        HashMap hashMap = new HashMap();
        hashMap.put(device.did, device2 == null ? null : device2.did);
        StringBuilder sb = new StringBuilder("关联开始:");
        sb.append(device2 == null ? "hid" : device2.name);
        o000000o.O000000o(3, sb.toString());
        ddt.O0000O0o o0000O0o = ddt.O0000O0o.f14522O000000o;
        ddt.O0000O0o.O000000o(hashMap, UwbDeviceUtil.isUsbInserted(uwbScanDevice)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<ddt.O00000Oo>>() {
            /* class _m_j.hzs.AnonymousClass4 */

            public final void onComplete() {
            }

            public final void onSubscribe(@NonNull Disposable disposable) {
            }

            public final /* synthetic */ void onNext(@NonNull Object obj) {
                List list = (List) obj;
                hzs.O000000o(uwbScanDevice, device2);
                o000000o.O000000o(list.size() > 0 ? list.get(0) : null);
                o000000o.O000000o(4, "关联成功");
                UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startBind success");
            }

            public final void onError(@NonNull Throwable th) {
                if (th instanceof ApiErrorWrapper) {
                    ApiErrorWrapper apiErrorWrapper = (ApiErrorWrapper) th;
                    o000000o.O00000Oo(apiErrorWrapper.code, apiErrorWrapper.mExtra);
                } else {
                    o000000o.O00000Oo(-1, th.getMessage());
                }
                UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startBind onError");
            }
        });
    }
}
