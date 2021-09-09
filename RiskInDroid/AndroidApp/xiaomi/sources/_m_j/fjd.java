package _m_j;

import _m_j.fjf;
import _m_j.fjz;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.device.MiTVDevice;
import com.xiaomi.smarthome.core.entity.device.MiioDevice;
import com.xiaomi.smarthome.core.entity.device.RouterDevice;
import com.xiaomi.smarthome.core.entity.device.ScanState;
import com.xiaomi.smarthome.core.entity.device.ScanType;
import com.xiaomi.smarthome.core.entity.message.CoreMessageType;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.server.internal.device.MiioDeviceSearch;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fjd implements fja, fjz.O00000Oo {
    private static volatile fjd O0000Oo;
    private static Object O0000OoO = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f16443O000000o = null;
    public boolean O00000Oo = false;
    public boolean O00000o = false;
    public boolean O00000o0 = false;
    public fdi O00000oO = null;
    public volatile List<Device> O00000oo = new ArrayList();
    public boolean O0000O0o = false;
    public boolean O0000OOo = false;
    public int O0000Oo0 = 0;
    private fja O0000Ooo = new fja() {
        /* class _m_j.fjd.AnonymousClass1 */

        public final void O000000o(Device device) {
            fjd.O00000o();
        }

        public final void O00000Oo(Device device) {
            fjd.O00000o();
        }
    };
    private List<IClientCallback> O0000o = new ArrayList();
    private volatile List<Device> O0000o0 = new ArrayList();
    private Runnable O0000o00 = new Runnable() {
        /* class _m_j.fjd.AnonymousClass8 */

        public final void run() {
            if (!fjd.this.O00000Oo) {
                return;
            }
            if (gfr.O0000OOo) {
                CommonApplication.getGlobalHandler().post($$Lambda$fjd$8$zzF_r9fJFvDKZxkVLwl4seRYNXQ.INSTANCE);
            } else {
                fjd.this.O00000Oo = false;
            }
        }
    };
    private List<fjf> O0000o0O = new ArrayList();
    private ExecutorService O0000o0o;
    private boolean O0000oO = false;
    private List<IClientCallback> O0000oO0 = new ArrayList();
    private boolean O0000oOO = false;
    private boolean O0000oOo = false;

    private fjd() {
        this.O0000o0O.add(new MiioDeviceSearch(CommonApplication.getAppContext()));
        this.O0000o0O.add(new fjj());
        fqc.O0000O0o().O000000o(this.O0000Ooo);
        this.O0000o0o = Executors.newCachedThreadPool();
        this.f16443O000000o = new Handler(CommonApplication.getGlobalWorkerHandler().getLooper());
        fqc.O0000O0o().O000000o();
        fji.O000000o().O00000Oo();
        fqa.O00000Oo().O000000o(CommonApplication.getAppContext());
        O0000Ooo();
    }

    public static fjd O000000o() {
        if (O0000Oo == null) {
            synchronized (O0000OoO) {
                if (O0000Oo == null) {
                    O0000Oo = new fjd();
                }
            }
        }
        return O0000Oo;
    }

    public final void O000000o(ScanType scanType, IClientCallback iClientCallback) {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "scanDeviceList in");
        fjz.O000000o().O000000o(this);
        if (scanType.ordinal() == ScanType.BLUETOOTH.ordinal()) {
            O000000o(scanType);
        } else if (O000000o(scanType, iClientCallback, true)) {
            O000000o(ScanState.START_SUCCESS);
        }
    }

    private boolean O000000o(ScanType scanType, IClientCallback iClientCallback, boolean z) {
        this.O0000oOO = z | this.O0000oOO;
        LogType logType = LogType.DEVICE_LIST;
        gsy.O00000o0(logType, "DeviceManager", "doScanDeviceList mScanLocal=" + this.O0000oOO + ",mIsWorking=" + this.O00000Oo + "mIsDownloading=" + this.O00000o + ",mDownloaded=" + this.O00000o0 + ",mForceUpdate=" + this.O0000oO + ",mIsCacheLoading=" + this.O0000O0o + ",mIsCacheLoaded=" + this.O0000OOo);
        if (this.O00000Oo) {
            if (iClientCallback != null) {
                if (this.O0000OOo) {
                    O000000o(ScanState.LOAD_CACHE_SUCCESS, iClientCallback);
                }
                this.O0000o.add(iClientCallback);
                if (this.O0000OOo) {
                    O000000o(ScanState.LOAD_CACHE_SUCCESS);
                }
            } else {
                this.O0000oO = true;
            }
            return false;
        }
        this.O0000oO0.clear();
        this.O0000oO0.addAll(this.O0000o);
        if (iClientCallback != null) {
            this.O0000oO0.add(iClientCallback);
        }
        if (this.O0000oO0.isEmpty() && !this.O0000oO) {
            return false;
        }
        this.O0000o.clear();
        this.O0000oO = false;
        this.O00000Oo = true;
        this.O0000Oo0 = 0;
        this.f16443O000000o.removeCallbacks(this.O0000o00);
        this.f16443O000000o.postDelayed(this.O0000o00, 60000);
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "doScanDeviceList 176");
        if (iClientCallback != null || !this.O0000oO0.isEmpty()) {
            if (fju.O000000o().O00000oO()) {
                fqc.O0000O0o().O00000o();
                fqc.O0000O0o().O00000o0();
            } else if (this.O0000oOo) {
                fqc.O0000O0o().O00000Oo();
            }
            fji.O000000o().O00000Oo();
        }
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "doScanDeviceList 187");
        O0000Ooo();
        O000000o(iClientCallback);
        if (this.O0000oOO) {
            this.O0000oOO = false;
            O000000o(scanType);
        }
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "doScanDeviceList end");
        return true;
    }

    public final void O000000o(ScanState scanState) {
        LogType logType = LogType.DEVICE_LIST;
        gsy.O00000o0(logType, "DeviceManager", "notifyScanState state=" + scanState + ",mScanningState=" + this.O0000Oo0 + ",mIsWorking=" + this.O00000Oo + "mIsDownloading=" + this.O00000o + ",mDownloaded=" + this.O00000o0 + ",mForceUpdate=" + this.O0000oO + ",mIsCacheLoading=" + this.O0000O0o + ",mIsCacheLoaded=" + this.O0000OOo + ",mWorkingList size=" + this.O0000oO0.size());
        if (!(scanState == ScanState.LOAD_CACHE_SUCCESS && this.O0000Oo0 == 3 && this.O00000o0)) {
            if (!this.O0000oO0.isEmpty()) {
                for (int i = 0; i < this.O0000oO0.size(); i++) {
                    try {
                        IClientCallback iClientCallback = this.O0000oO0.get(i);
                        if (iClientCallback != null) {
                            O000000o(scanState, iClientCallback);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                O00000o();
            }
        }
        if (this.O0000Oo0 == 3) {
            this.O00000Oo = false;
            if (!this.O0000o.isEmpty()) {
                O000000o(ScanType.ALL, (IClientCallback) null);
            }
            this.O0000oO0.clear();
        }
    }

    private static void O000000o(ScanState scanState, IClientCallback iClientCallback) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("result", scanState.ordinal());
            iClientCallback.onSuccess(bundle);
        } catch (RemoteException unused) {
        }
    }

    private void O000000o(IClientCallback iClientCallback) {
        LogType logType = LogType.DEVICE_LIST;
        gsy.O00000Oo(logType, "DeviceManager", "downloadDeviceList in mIsDownloading=" + this.O00000o);
        if (iClientCallback != null || !this.O00000o) {
            this.O00000o = true;
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "downloadDeviceList issue device_list req");
            try {
                fqa.O00000Oo().O000000o(new fkv<Integer, Integer>() {
                    /* class _m_j.fjd.AnonymousClass9 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
                     arg types: [java.lang.String, int]
                     candidates:
                      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
                      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
                      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
                      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
                      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
                      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
                      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
                      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
                    /* access modifiers changed from: private */
                    /* renamed from: O000000o */
                    public Integer call(Integer num) {
                        int intValue = num.intValue();
                        gsy.O00000o0(LogType.BLUETOOTH, "DeviceManager", String.format("Bluetooth cache status is %d(1:unload;2:loading;3:loaded) ", Integer.valueOf(intValue)));
                        fjd fjd = fjd.this;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            String O00000Oo = gog.O00000Oo(CommonApplication.getAppContext());
                            String O00000o0 = gog.O00000o0(CommonApplication.getAppContext());
                            if (!TextUtils.isEmpty(O00000o0) && !TextUtils.isEmpty(O00000Oo) && !TextUtils.equals(O00000Oo, "02:00:00:00:00:00")) {
                                jSONObject.put("ssid", O00000o0);
                                jSONObject.put("bssid", O00000Oo.toUpperCase());
                            }
                            jSONObject.put("getVirtualModel", true);
                            jSONObject.put("getHuamiDevices", 1);
                        } catch (JSONException unused) {
                        }
                        fjd.O00000oO = new fjr().O000000o(jSONObject, new fdh<ArrayList<Device>, NetError>() {
                            /* class _m_j.fjd.AnonymousClass10 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                final ArrayList arrayList = (ArrayList) obj;
                                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "downloadDeviceList device_list req onSuccess");
                                fjd.this.f16443O000000o.post(new Runnable() {
                                    /* class _m_j.fjd.AnonymousClass10.AnonymousClass1 */

                                    public final void run() {
                                        fjd.this.O00000oO = null;
                                        fjd.this.O00000o = false;
                                        fjd.this.O000000o((ArrayList<Device>) arrayList);
                                        fjd.this.O00000o0 = true;
                                        fjd.this.O0000Oo0 |= 2;
                                        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "downloadDeviceList start notifyScanState SYNC_SERVER_SUCCESS");
                                        fjd.this.O000000o(ScanState.SYNC_SERVER_SUCCESS);
                                    }
                                });
                            }

                            public final /* synthetic */ void onFailure(Error error) {
                                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "downloadDeviceList device_list req onFailure");
                                fjd.this.f16443O000000o.post(new Runnable() {
                                    /* class _m_j.fjd.AnonymousClass10.AnonymousClass2 */

                                    public final void run() {
                                        fjd.this.O00000oO = null;
                                        fjd.this.O00000o = false;
                                        fjd.this.O0000Oo0 |= 2;
                                        fjd.this.O000000o(ScanState.SYNC_SERVER_FAILED);
                                    }
                                });
                            }
                        });
                        return 0;
                    }
                });
            } catch (Exception e) {
                LogType logType2 = LogType.DEVICE_LIST;
                gsy.O00000o0(logType2, "DeviceManager", "downloadDeviceList bluetoothCacheIsCacheReady: " + e.getMessage());
            }
        }
    }

    private void O000000o(ScanType scanType) {
        for (fjf O000000o2 : this.O0000o0O) {
            O000000o2.O000000o(scanType, new fjf.O000000o() {
                /* class _m_j.fjd.AnonymousClass11 */

                public final void O000000o(final List<Device> list) {
                    fjd.this.f16443O000000o.post(new Runnable() {
                        /* class _m_j.fjd.AnonymousClass11.AnonymousClass1 */

                        public final void run() {
                            List list;
                            if (fjd.this.O000000o(list) && (list = list) != null && !list.isEmpty()) {
                                fjd.O00000o();
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        return r0;
     */
    public final synchronized boolean O000000o(List<Device> list) {
        boolean z = false;
        if (list == null) {
            return false;
        }
        if (this.O00000o0) {
            for (Device next : this.O0000o0) {
                if (next instanceof MiioDevice) {
                    MiioDevice miioDevice = (MiioDevice) next;
                    for (Device next2 : list) {
                        if (next2 instanceof MiioDevice) {
                            MiioDevice miioDevice2 = (MiioDevice) next2;
                            if (!(miioDevice.getDid() == null || miioDevice2.getDid() == null || !miioDevice.getDid().equalsIgnoreCase(miioDevice2.getDid()) || miioDevice.getLocation() == miioDevice2.getLocation())) {
                                miioDevice.setLocation(miioDevice2.getLocation());
                                z = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public final synchronized boolean O000000o(ArrayList<Device> arrayList) {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "processResult in");
        this.O0000o0.clear();
        O00000Oo(arrayList);
        List<Device> O00000oo2 = fqc.O0000O0o().O00000oo();
        if (O00000oo2.size() != 0) {
            ArrayList arrayList2 = new ArrayList(O00000oo2.size());
            Iterator<Device> it = O00000oo2.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                Device next = it.next();
                int size = this.O0000o0.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (this.O0000o0.get(i).getDid().equals(next.getDid())) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    arrayList2.add(next);
                }
            }
            this.O0000o0.addAll(0, arrayList2);
        }
        O0000OoO();
        return true;
    }

    private synchronized void O00000Oo(ArrayList<Device> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            Device device = arrayList.get(i);
            if (!TextUtils.isEmpty(device.getDid()) && (!device.getModel().startsWith("xiaomi.router") || device.isBinded())) {
                this.O0000o0.add(device);
            }
        }
    }

    public final synchronized ArrayList<Device> O00000Oo() {
        O0000Oo();
        O00000o0(fqc.O0000O0o().O00000oO());
        O00000o0(fqa.O00000Oo().O000000o());
        for (fjf O000000o2 : this.O0000o0O) {
            O000000o(O000000o2.O000000o());
        }
        if (this.O00000o0) {
            return new ArrayList<>(this.O0000o0);
        }
        return new ArrayList<>(this.O00000oo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        return;
     */
    private synchronized void O0000Oo() {
        RouterDevice routerDevice = fji.O000000o().O00000o0;
        if (routerDevice != null) {
            if (!TextUtils.isEmpty(routerDevice.getDid())) {
                if (this.O00000o0) {
                    if (!O000000o(this.O0000o0, routerDevice)) {
                        this.O0000o0.add(routerDevice);
                    }
                } else if (!O000000o(this.O00000oo, routerDevice)) {
                    this.O00000oo.add(routerDevice);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        return;
     */
    private synchronized void O00000o0(List<Device> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (this.O00000o0) {
                    for (Device next : list) {
                        if (!O000000o(this.O0000o0, next)) {
                            this.O0000o0.add(next);
                        }
                    }
                    return;
                }
                for (Device next2 : list) {
                    if (!O000000o(this.O00000oo, next2)) {
                        this.O00000oo.add(next2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0016  */
    private static boolean O000000o(List<Device> list, Device device) {
        if (device != null && !TextUtils.isEmpty(device.getDid())) {
            for (Device next : list) {
                if (device.isSameDevice(next) || next.isSameDevice(device)) {
                    next.setLocation(Device.Location.LOCAL);
                    return true;
                }
                while (r2.hasNext()) {
                }
            }
        }
        return false;
    }

    private synchronized void O0000OoO() {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.O0000o0);
        this.O0000o0o.submit(new Runnable() {
            /* class _m_j.fjd.AnonymousClass12 */

            public final void run() {
                fjd.O00000o0();
                fjd.O00000Oo(arrayList);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public static void O00000o0() {
        gpy.O000000o(CommonApplication.getAppContext(), "DiscoverManager.DEVICE_MANAGER_SARE", "DiscoverManager.DEVICE_CACHE_READY39", true);
        new File(fje.O000000o(fcn.O000000o().O00000Oo())).delete();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public static void O00000Oo(List<Device> list) {
        File file = new File(fje.O000000o(fcn.O000000o().O00000Oo()));
        try {
            if (file.exists()) {
                file.delete();
            }
            file.getParentFile().mkdirs();
            file.createNewFile();
            gsc.O000000o(CommonApplication.getAppContext(), Uri.fromFile(file), fje.O000000o(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        fqa.O00000Oo().O000000o(list);
        gpy.O000000o(CommonApplication.getAppContext(), "DiscoverManager.DEVICE_MANAGER_SARE", "DiscoverManager.DEVICE_CACHE_READY39", false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    private void O0000Ooo() {
        boolean O00000o02 = gpy.O00000o0(CommonApplication.getAppContext(), "DiscoverManager.DEVICE_MANAGER_SARE", "DiscoverManager.DEVICE_CACHE_READY39", true);
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "loadCacheDeviceList in mIsCacheLoaded=" + this.O0000OOo + ",mIsCacheLoading=" + this.O0000O0o + ",first=" + O00000o02);
        synchronized (this) {
            if (!this.O0000OOo && !this.O0000O0o) {
                if (!O00000o02) {
                    this.O0000O0o = true;
                    this.O0000o0o.submit(new Runnable() {
                        /* class _m_j.fjd.AnonymousClass13 */

                        public final void run() {
                            List<Device> list;
                            long currentTimeMillis = System.currentTimeMillis();
                            String O00000Oo = fcn.O000000o().O00000Oo();
                            if (TextUtils.isEmpty(O00000Oo)) {
                                list = new ArrayList<>();
                            } else {
                                File file = new File(fje.O000000o(O00000Oo));
                                if (!file.exists()) {
                                    list = fje.O000000o();
                                } else {
                                    list = fje.O000000o(file);
                                }
                            }
                            LogType logType = LogType.DEVICE_LIST;
                            StringBuilder sb = new StringBuilder(" deviceRecordList size = ");
                            sb.append(list == null ? null : Integer.valueOf(list.size()));
                            gsy.O00000Oo(logType, "DeviceManager", sb.toString());
                            LogType logType2 = LogType.DEVICE_LIST;
                            gsy.O00000Oo(logType2, "DeviceManager", "performance:DeviceManager reading Local devices costs " + (System.currentTimeMillis() - currentTimeMillis));
                            fjd.this.O00000oo = list;
                            synchronized (this) {
                                fjd.this.O0000OOo = true;
                                fjd.this.O0000O0o = false;
                                fjd.this.O0000Oo0 = 1 | fjd.this.O0000Oo0;
                            }
                            fjd.this.O000000o(ScanState.LOAD_CACHE_SUCCESS);
                        }
                    });
                    return;
                }
            }
            this.O0000Oo0 |= 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008b, code lost:
        return;
     */
    public final synchronized void O000000o(Device device) {
        boolean z;
        if (device != null) {
            if (!TextUtils.isEmpty(device.getDid())) {
                LogType logType = LogType.BLUETOOTH;
                gsy.O00000o0(logType, "DeviceManager", " onAddDevice ---->" + device.toString());
                Iterator<Device> it = this.O0000o0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    Device next = it.next();
                    if (TextUtils.equals(next.getDid(), device.getDid())) {
                        if (!TextUtils.isEmpty(device.getLocalIP())) {
                            next.setLocalIP(device.getLocalIP());
                        }
                        next.setLocation(device.getLocation());
                        if (!TextUtils.isEmpty(device.getToken())) {
                            next.setToken(device.getToken());
                        }
                        z = false;
                    }
                }
                if (z) {
                    this.O0000oO = true;
                    O000000o(ScanType.ALL, null, false);
                    return;
                }
                O00000o();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        return;
     */
    public final synchronized void O00000Oo(Device device) {
        boolean z;
        if (device != null) {
            if (!TextUtils.isEmpty(device.getDid())) {
                LogType logType = LogType.BLUETOOTH;
                gsy.O00000o0(logType, "DeviceManager", " onRemoveDevice ---->" + device.toString());
                Iterator<Device> it = this.O0000o0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (TextUtils.equals(it.next().getDid(), device.getDid())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    this.O0000oO = true;
                    O000000o(ScanType.ALL, null, false);
                    return;
                }
                O00000o();
            }
        }
    }

    public static void O00000o() {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManager", "notifyClient UPDATE_DEVICE_LIST");
        fcy.O000000o().O000000o(CoreMessageType.UPDATE_DEVICE_LIST, new Bundle());
    }

    public final void O00000oO() {
        fqc.O0000O0o().O00000o();
        if (fju.O000000o().O00000oO()) {
            fqc.O0000O0o().O00000o0();
        } else if (this.O0000oOo) {
            fqc.O0000O0o().O00000Oo();
        }
        fji.O000000o().O00000o0 = null;
        fji.O000000o().O00000Oo();
        this.O0000oO = true;
        O000000o(ScanType.ALL, null, true);
    }

    public final synchronized Device O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<Device> O00000Oo2 = O00000Oo();
        if (O00000Oo2.isEmpty()) {
            return null;
        }
        for (Device next : O00000Oo2) {
            if (TextUtils.equals(str, next.getDid())) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized void O00000oo() {
        this.O0000o0o.submit(new Runnable() {
            /* class _m_j.fjd.AnonymousClass14 */

            public final void run() {
                fjd.O00000o0();
            }
        });
        this.f16443O000000o.post(new Runnable() {
            /* class _m_j.fjd.AnonymousClass15 */

            public final void run() {
                if (fjd.this.O00000oO != null) {
                    fjd.this.O00000oO.O000000o();
                    fjd.this.O00000oO = null;
                }
            }
        });
        fqc.O0000O0o().O00000o();
        fqc.O0000O0o().O00000o0();
        fji.O000000o().O00000o0 = null;
        this.O0000o0.clear();
        this.O00000oo.clear();
        this.O00000o0 = false;
        this.O0000OOo = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized void O0000O0o() {
        this.f16443O000000o.post(new Runnable() {
            /* class _m_j.fjd.AnonymousClass2 */

            public final void run() {
                if (fjd.this.O00000oO != null) {
                    fjd.this.O00000oO.O000000o();
                    fjd.this.O00000oO = null;
                }
            }
        });
        fqc.O0000O0o().O00000o();
        fqc.O0000O0o().O00000o0();
        fji.O000000o().O00000o0 = null;
        this.O0000o0.clear();
        this.O00000oo.clear();
        this.O00000o0 = false;
        this.O0000OOo = false;
    }

    public final synchronized void O0000OOo() {
        if (!this.O0000oOo) {
            fqc.O0000O0o().O00000Oo(this);
            fqc.O0000O0o().O00000Oo();
            fjz.O000000o().O000000o(this);
            this.O0000oOo = true;
        }
    }

    public final synchronized void O0000Oo0() {
        gsy.O00000o0(LogType.BLUETOOTH, "DeviceManager", " applicationEnterBackground");
        fqc.O0000O0o().O00000o0();
        fjz.O000000o().O00000Oo(this);
        this.O0000oOo = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        return;
     */
    public final synchronized void O000000o(String str, String str2) {
        List<Device> list = this.O00000o0 ? this.O0000o0 : this.O00000oo;
        if (list != null) {
            if (!list.isEmpty()) {
                for (Device device : list) {
                    if (TextUtils.equals(str, device.getDid())) {
                        device.setName(str2);
                        return;
                    }
                }
            }
        }
    }

    public final fdi O000000o(List<String> list, final IClientCallback iClientCallback) {
        JSONArray jSONArray = new JSONArray();
        final ArrayList arrayList = new ArrayList();
        for (String next : list) {
            Device O000000o2 = O000000o(next);
            if (O000000o2 != null) {
                if (fqa.O00000Oo().O00000Oo(O000000o2) || ((O000000o2 instanceof MiTVDevice) && !O000000o2.isOwner() && !O000000o2.isShared())) {
                    arrayList.add(O000000o2);
                } else {
                    int pid = O000000o2.getPid();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("did", next);
                        jSONObject.put("pid", pid);
                    } catch (JSONException unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
        }
        if (jSONArray.length() > 0) {
            fjq.O000000o();
            return fjq.O000000o(jSONArray, new fdh<NetResult, NetError>() {
                /* class _m_j.fjd.AnonymousClass4 */

                public final /* synthetic */ void onFailure(Error error) {
                    NetError netError = (NetError) error;
                    if (!arrayList.isEmpty()) {
                        fjd.this.O000000o(0, arrayList, new JSONObject(), iClientCallback);
                    } else if (iClientCallback != null) {
                        Bundle bundle = new Bundle();
                        if (netError != null) {
                            bundle.putParcelable("error", netError);
                        }
                        try {
                            iClientCallback.onFailure(bundle);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    NetResult netResult = (NetResult) obj;
                    if (netResult != null && !TextUtils.isEmpty(netResult.O00000o0)) {
                        try {
                            JSONObject jSONObject = new JSONObject(netResult.O00000o0);
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            if (optJSONObject != null) {
                                fjd.this.O000000o(0, arrayList, optJSONObject, iClientCallback);
                            } else if (iClientCallback != null) {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("error", new NetError(jSONObject.optInt("code", -9999), jSONObject.optString("message", "unknown error")));
                                try {
                                    iClientCallback.onFailure(bundle);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            if (iClientCallback != null) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putParcelable("error", new NetError(-9999, "unknown error"));
                                try {
                                    iClientCallback.onFailure(bundle2);
                                } catch (RemoteException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                    } else if (!arrayList.isEmpty()) {
                        fjd.this.O000000o(0, arrayList, new JSONObject(), iClientCallback);
                    } else if (iClientCallback != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("error", new NetError(-9999, "unknown error"));
                        try {
                            iClientCallback.onFailure(bundle3);
                        } catch (RemoteException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            });
        }
        O000000o(0, arrayList, new JSONObject(), iClientCallback);
        return null;
    }

    public final void O000000o(int i, List<Device> list, final JSONObject jSONObject, final IClientCallback iClientCallback) {
        if (i >= 0 && i < list.size()) {
            Device device = list.get(i);
            try {
                if (device instanceof MiTVDevice) {
                    jSONObject.put(device.getDid(), 1);
                    O000000o(i + 1, list, jSONObject, iClientCallback);
                } else if (fqa.O00000Oo().O000000o(device)) {
                    jSONObject.put(device.getDid(), 1);
                    O000000o(i + 1, list, jSONObject, iClientCallback);
                } else if (device instanceof RouterDevice) {
                    final JSONObject jSONObject2 = jSONObject;
                    final Device device2 = device;
                    final int i2 = i;
                    final List<Device> list2 = list;
                    final IClientCallback iClientCallback2 = iClientCallback;
                    fjs.O000000o().O000000o(device, new fdh<NetResult, NetError>() {
                        /* class _m_j.fjd.AnonymousClass6 */

                        public final /* synthetic */ void onFailure(Error error) {
                            fjd.this.O000000o(i2 + 1, list2, jSONObject2, iClientCallback2);
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            try {
                                jSONObject2.put(device2.getDid(), 1);
                                fjd.this.O000000o(i2 + 1, list2, jSONObject2, iClientCallback2);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (iClientCallback != null) {
            this.f16443O000000o.post(new Runnable() {
                /* class _m_j.fjd.AnonymousClass5 */

                public final void run() {
                    JSONObject jSONObject = jSONObject;
                    if (jSONObject != null) {
                        fjd.this.O000000o(jSONObject);
                        Bundle bundle = new Bundle();
                        bundle.putString("result", jSONObject.toString());
                        try {
                            iClientCallback.onSuccess(bundle);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public final synchronized void O000000o(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            int optInt = jSONObject.optInt(next);
            Device O000000o2 = O000000o(next);
            if (O000000o2 != null && optInt == 1) {
                (this.O00000o0 ? this.O0000o0 : this.O00000oo).remove(O000000o2);
            }
        }
    }
}
