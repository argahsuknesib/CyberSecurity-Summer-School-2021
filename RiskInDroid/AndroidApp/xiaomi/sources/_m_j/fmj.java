package _m_j;

import _m_j.exo;
import _m_j.fno;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.device.ScanType;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceManagerInternal$5;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.device.WatchBandDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class fmj {
    private static final boolean O000O00o = (gfr.O0000OOo || gfr.O0000Oo);
    private static volatile fmj O000O0OO;

    /* renamed from: O000000o  reason: collision with root package name */
    public AtomicBoolean f16630O000000o = new AtomicBoolean(false);
    public AtomicBoolean O00000Oo = new AtomicBoolean(false);
    public volatile boolean O00000o = false;
    public volatile boolean O00000o0 = false;
    public volatile boolean O00000oO = false;
    public Handler O00000oo;
    public Context O0000O0o;
    public List<DeviceSearch<?>> O0000OOo = new ArrayList();
    public List<fno.O00000o> O0000Oo = new ArrayList();
    public final List<fno.O000000o> O0000Oo0 = new ArrayList();
    public fmz<String, Device> O0000OoO = new fmz<>(new ConcurrentHashMap());
    public fmz<String, Device> O0000Ooo = new fmz<>(new ConcurrentHashMap());
    public List<Device> O0000o;
    public fmz<String, Device> O0000o0 = new fmz<>(new ConcurrentHashMap());
    public fmz<String, Device> O0000o00 = new fmz<>(new ConcurrentHashMap());
    public fmz<String, Device> O0000o0O = new fmz<>(this.O0000OoO, this.O0000Ooo);
    public List<Device> O0000o0o = new ArrayList();
    public List<String> O0000oO = new ArrayList();
    public Map<String, List<String>> O0000oO0 = new ConcurrentHashMap();
    public List<Device> O0000oOO = new ArrayList();
    public Map<String, String> O0000oOo = new ConcurrentHashMap();
    public fmz<String, Device> O0000oo = new fmz<>(new ConcurrentHashMap());
    public Set<String> O0000oo0 = new HashSet();
    public Set<String> O0000ooO = new HashSet();
    public String O0000ooo;
    private BroadcastReceiver O000O0Oo;
    private String O00oOoOo;
    public volatile long O00oOooO = 0;
    public Runnable O00oOooo = new Runnable() {
        /* class _m_j.fmj.AnonymousClass10 */

        public final void run() {
            fmj.this.f16630O000000o.compareAndSet(true, false);
        }
    };

    public static fmj O000000o() {
        if (O000O0OO == null) {
            synchronized (fmj.class) {
                if (O000O0OO == null) {
                    O000O0OO = new fmj(CommonApplication.getAppContext());
                }
            }
        }
        return O000O0OO;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public Map<String, Device> f16648O000000o;
        public Map<String, Device> O00000Oo;
        public Map<String, Device> O00000o;
        public Map<String, Device> O00000o0;

        private O000000o() {
            this.f16648O000000o = new HashMap();
            this.O00000Oo = new HashMap();
            this.O00000o0 = new HashMap();
            this.O00000o = new HashMap();
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    private fmj(Context context) {
        this.O0000O0o = context.getApplicationContext();
        this.O0000OOo.add(new fnb());
        this.O0000OOo.add(new fme());
        this.O0000OOo.add(new fne());
        this.O0000OOo.add(fmm.O00000oo());
        this.O0000OOo.add(new fma());
        this.O0000OOo.add(new fng());
        this.O0000OOo.add(new fns());
        this.O0000OOo.add(new fnk());
        this.O0000OOo.add(new fmv());
        this.O0000OOo.add(new flx());
        this.O0000OOo.add(fnv.O00000oo());
        this.O0000OOo.add(fnp.O00000oo());
        this.O0000OOo.add(new fmb());
        this.O0000OOo.add(new fnt());
        this.O0000OOo.add(new fnj());
        this.O00000oo = new Handler(Looper.getMainLooper());
        if (this.O000O0Oo == null) {
            this.O000O0Oo = new O00000Oo(this);
            IntentFilter intentFilter = new IntentFilter("update_device_list_action");
            intentFilter.addAction("action_locale_changed");
            ft.O000000o(this.O0000O0o).O000000o(this.O000O0Oo, intentFilter);
        }
        O0000Oo();
    }

    private void O0000Oo() {
        List<GridViewData> miuiCacheDeviceList = fad.O000000o().getMiuiCacheDeviceList();
        O000000o o000000o = new O000000o((byte) 0);
        if (miuiCacheDeviceList != null && miuiCacheDeviceList.size() > 0) {
            for (GridViewData gridViewData : miuiCacheDeviceList) {
                Device device = gridViewData.O00000Oo;
                if (device != null && !TextUtils.isEmpty(device.did)) {
                    if (device.isHomeShared()) {
                        O000000o(device, o000000o.O00000o, o000000o.O00000o0);
                    } else {
                        O000000o(device, o000000o.O00000Oo, o000000o.f16648O000000o);
                    }
                }
            }
        }
        this.O0000OoO.f16680O000000o[0].clear();
        this.O0000OoO.f16680O000000o[0].putAll(o000000o.f16648O000000o);
        this.O0000o0.f16680O000000o[0].clear();
        this.O0000o0.f16680O000000o[0].putAll(o000000o.O00000Oo);
        this.O0000Ooo.f16680O000000o[0].clear();
        this.O0000Ooo.f16680O000000o[0].putAll(o000000o.O00000o0);
        this.O0000o00.f16680O000000o[0].clear();
        this.O0000o00.f16680O000000o[0].putAll(o000000o.O00000o);
    }

    public final Device O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Device device = this.O0000OoO.get(str);
        return device == null ? this.O0000Ooo.get(str) : device;
    }

    public final Device O00000Oo(String str) {
        for (Device next : this.O0000oOO) {
            if (TextUtils.equals(next.did, str)) {
                return next;
            }
        }
        return null;
    }

    public final List<Device> O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        Device O000000o2 = O000000o(str);
        if (O000000o2 == null || !O000000o2.isHomeShared()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : this.O0000o00.entrySet()) {
            Device device = (Device) value.getValue();
            if (device.isSubDevice() && device.parentId.equals(str)) {
                arrayList.add(device);
            }
        }
        return arrayList;
    }

    public final Device O00000o(String str) {
        Device device;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Device device2 = this.O0000o0.get(str);
        if (device2 != null && device2.isSubDevice()) {
            return device2;
        }
        if (TextUtils.isEmpty(str) || (device = this.O0000Ooo.get(str)) == null || !device.isSubDevice()) {
            return null;
        }
        return device;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        return r0;
     */
    public final synchronized Device O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Device O000000o2 = O000000o(str);
        if (O000000o2 == null) {
            O000000o2 = O00000o(str);
        }
        if (O000000o2 == null) {
            O000000o2 = fob.O00000Oo(str);
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    public final void O000000o(final boolean z) {
        if (gfr.O0000OOo || gfr.O0000Ooo) {
            LogType logType = LogType.DEVICE_LIST;
            gsy.O00000Oo(logType, "DeviceManagerInternal", "updateInnerDevice, isDeviceReady = " + z + Log.getStackTraceString(new Exception()));
        }
        gor.O000000o(new AsyncTask<Void, Void, O000000o>() {
            /* class _m_j.fmj.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                O000000o o000000o = (O000000o) obj;
                fmj.this.O00000oo.removeCallbacks(fmj.this.O00oOooo);
                fmj.this.O0000OoO.f16680O000000o[0].clear();
                fmj.this.O0000OoO.f16680O000000o[0].putAll(o000000o.f16648O000000o);
                fmj.this.O0000o0.f16680O000000o[0].clear();
                fmj.this.O0000o0.f16680O000000o[0].putAll(o000000o.O00000Oo);
                fmj.this.O0000Ooo.f16680O000000o[0].clear();
                fmj.this.O0000Ooo.f16680O000000o[0].putAll(o000000o.O00000o0);
                fmj.this.O0000o00.f16680O000000o[0].clear();
                fmj.this.O0000o00.f16680O000000o[0].putAll(o000000o.O00000o);
                fmj.this.f16630O000000o.compareAndSet(true, false);
                if (z) {
                    fmj.this.O00000Oo.compareAndSet(false, true);
                    synchronized (fmj.this.O0000Oo) {
                        for (fno.O00000o onDeviceReady : fmj.this.O0000Oo) {
                            onDeviceReady.onDeviceReady(fmj.this.O0000OoO);
                        }
                        fmj.this.O0000Oo.clear();
                    }
                }
                if (fmj.this.O0000OoO.size() == 0) {
                    gsy.O00000o0(LogType.DEVICE_LIST, "DeviceManagerInternal", "final devices to be notified size = " + fmj.this.O0000OoO.size() + ", core ready=" + CoreApi.O000000o().O0000O0o());
                }
                if (gfr.O0000Ooo || gfr.O0000o00) {
                    try {
                        for (Map.Entry next : fmj.this.O0000OoO.entrySet()) {
                            if (!(next == null || next.getKey() == null || next.getValue() == null)) {
                                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "final devices:" + ((String) next.getKey()));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ArrayList arrayList = new ArrayList(fmj.this.O0000Oo0.size());
                synchronized (fmj.this.O0000Oo0) {
                    arrayList.addAll(fmj.this.O0000Oo0);
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    fno.O000000o o000000o2 = (fno.O000000o) arrayList.get(size);
                    if (o000000o2 != null) {
                        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "final devices to be notified size = " + fmj.this.O0000OoO.size() + ", isDeviceReady = " + z + "  mIsRefreshing:" + fmj.this.f16630O000000o + " listener:" + o000000o2);
                        o000000o2.onRefreshClientDeviceSuccess(3);
                    }
                }
                arrayList.clear();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                for (DeviceSearch<?> O000000o2 : fmj.this.O0000OOo) {
                    O000000o2.O000000o();
                }
                O000000o o000000o = new O000000o((byte) 0);
                ArrayList<Device> arrayList = new ArrayList<>();
                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateInnerDevice doInBackground");
                for (DeviceSearch<?> O00000o0 : fmj.this.O0000OOo) {
                    List O00000o02 = O00000o0.O00000o0();
                    if (O00000o02 != null && O00000o02.size() > 0) {
                        arrayList.addAll(new ArrayList(O00000o02));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (Device device : arrayList) {
                    if (device != null) {
                        if (fmj.this.O0000oO.contains(device.did)) {
                            if (!arrayList2.contains(device)) {
                                arrayList2.add(device);
                            }
                        } else if (!fmj.this.O0000oo0.contains(device.did)) {
                            if (fmj.this.O0000ooO.contains(device.did)) {
                                concurrentHashMap.put(device.did, device);
                            }
                            if (device.isHomeShared()) {
                                fmj.this.O000000o(device, o000000o.O00000o, o000000o.O00000o0);
                            } else {
                                fmj.this.O000000o(device, o000000o.O00000Oo, o000000o.f16648O000000o);
                            }
                        }
                    }
                }
                fmj fmj = fmj.this;
                fmj.O0000oOO = arrayList2;
                fmj.O0000oo.f16680O000000o[0].clear();
                fmj.this.O0000oo.f16680O000000o[0].putAll(concurrentHashMap);
                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateInnerDevice doInBackground 556");
                fmi.O000000o().O00000Oo(o000000o.f16648O000000o);
                fmi O000000o3 = fmi.O000000o();
                Map<String, Device> map = o000000o.O00000Oo;
                if (O000000o3.f16629O000000o != null) {
                    O000000o3.f16629O000000o.O000000o(map);
                }
                fmi.O000000o().O00000o0(o000000o.f16648O000000o);
                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateInnerDevice doInBackground 561");
                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateInnerDevice doInBackground 586");
                return o000000o;
            }
        }, new Void[0]);
    }

    public final void O000000o(Device device, Map<String, Device> map, Map<String, Device> map2) {
        if (TextUtils.equals(device.model, "yeelink.uwb.tag1")) {
            this.O0000o0o.add(device);
            return;
        }
        map2.put(device.did, device);
        if (device.isSubDevice()) {
            map.put(device.did, device);
        }
    }

    public final void O000000o(Device device) {
        if (device != null) {
            LogType logType = LogType.DEVICE_LIST;
            gsy.O00000Oo(logType, "DeviceManagerInternal", "addDevice: name = " + device.name + ", did = " + device.did + ", model = " + device.model + ", mac = " + device.mac);
            O000000o(device, this.O0000o0.f16680O000000o[0], this.O0000OoO.f16680O000000o[0]);
            this.O00000oo.post(new Runnable() {
                /* class _m_j.$$Lambda$fmj$AI7ldk791d_aHIUjAEmYCN_EzTM */

                public final void run() {
                    fmj.this.O0000o00();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o00() {
        O0000OOo();
        O000000o(true);
    }

    public final void O000000o(List<Device> list) {
        if (list != null) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "addDevices");
            for (Device next : list) {
                if (next != null) {
                    O000000o(next, this.O0000o0.f16680O000000o[0], this.O0000OoO.f16680O000000o[0]);
                }
            }
            this.O00000oo.post(new Runnable() {
                /* class _m_j.$$Lambda$fmj$ZUPdLdrG9bzADSfWAQjwtPq779w */

                public final void run() {
                    fmj.this.O0000Ooo();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Ooo() {
        O0000OOo();
        O000000o(true);
    }

    public final void O00000Oo(Device device) {
        if (device != null) {
            LogType logType = LogType.DEVICE_LIST;
            gsy.O00000Oo(logType, "DeviceManagerInternal", "delDevice: name = " + device.name + ", did = " + device.did + ", model = " + device.model + ", mac = " + device.mac);
            this.O0000OoO.f16680O000000o[0].remove(device.did);
            this.O0000o0.f16680O000000o[0].remove(device.did);
            this.O00000oo.post(new Runnable() {
                /* class _m_j.$$Lambda$fmj$ZoPalygLmZHi_0ARVBelEyuJlo */

                public final void run() {
                    fmj.this.O0000OoO();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000OoO() {
        O0000OOo();
        O000000o(true);
    }

    public final void O00000Oo() {
        for (DeviceSearch next : this.O0000OOo) {
            next.O000000o(false);
            next.O00000Oo();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        if (gfr.O0000Ooo) {
            LogType logType = LogType.DEVICE_LIST;
            gsy.O00000Oo(logType, "DeviceManagerInternal", "updateSearchList start" + Log.getStackTraceString(new Exception()));
        }
        gor.O000000o(new AsyncTask<Void, Void, Pair<List<Device>, List<Device>>>() {
            /* class _m_j.fmj.AnonymousClass8 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Pair pair = (Pair) obj;
                List list = (List) pair.first;
                List list2 = (List) pair.second;
                LogType logType = LogType.DEVICE_LIST;
                gsy.O00000o0(logType, "DeviceManagerInternal", "updateSearchList onPostExecute devices size=" + list.size());
                LogType logType2 = LogType.DEVICE_LIST;
                gsy.O00000o0(logType2, "DeviceManagerInternal", "updateSearchList onPostExecute tagDevices size=" + list2.size());
                for (DeviceSearch next : fmj.this.O0000OOo) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(list);
                    next.O000000o(true);
                    next.O000000o(arrayList, DeviceSearch.REMOTESTATE.REMOTE_SUCCESS);
                }
                fmj.this.O0000o0o.clear();
                fmj.this.O0000o0o.addAll(list2);
                fmi.O000000o().O00000Oo();
                LogType logType3 = LogType.DEVICE_LIST;
                gsy.O00000Oo(logType3, "DeviceManagerInternal", "updateSearchList finish, mForceUpdate = " + fmj.this.O00000o0 + ", mForceUpdateCache = " + fmj.this.O00000o);
                if (fmj.this.O00000o0) {
                    fmj fmj = fmj.this;
                    fmj.O00000o0 = false;
                    fmj.O00000o = false;
                    fmj.O00000oo();
                } else if (fmj.this.O00000o) {
                    fmj fmj2 = fmj.this;
                    fmj2.O00000o = false;
                    fmj2.O0000O0o();
                }
                fmj.this.O000000o(true);
            }

            private Pair<List<Device>, List<Device>> O000000o() {
                String str;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (fmj.this.O0000o != null) {
                    try {
                        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateSearchList mCacheDeviceList size=" + fmj.this.O0000o.size());
                        ftm.O000000o(CommonApplication.getAppContext());
                        for (Device next : fmj.this.O0000o) {
                            Device O000000o2 = DeviceFactory.O000000o(next);
                            if (O000000o2 != null) {
                                arrayList2.add(O000000o2);
                                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "extra devices: " + O000000o2.toString());
                            } else {
                                Device O00000Oo = DeviceFactory.O00000Oo(next);
                                if (O00000Oo != null) {
                                    arrayList.add(O00000Oo);
                                } else {
                                    try {
                                        LogType logType = LogType.DEVICE_LIST;
                                        StringBuilder sb = new StringBuilder("updateSearchList DeviceFactory.createDevice return null,");
                                        if (next == null) {
                                            str = "null";
                                        } else {
                                            str = next.getModel() + ":" + next.getDid();
                                        }
                                        sb.append(str);
                                        sb.append(",pluginrecord size=");
                                        sb.append(PluginDeviceManager.instance.getPluginInfoMap().size());
                                        sb.append(",isInMainProcess=");
                                        sb.append(CoreApi.O000000o().O0000OOo);
                                        gsy.O00000o0(logType, "DeviceManagerInternal", sb.toString());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateSearchList doInBackground exception!! " + e2.getMessage() + ",result size" + arrayList.size());
                    }
                }
                return Pair.create(arrayList, arrayList2);
            }
        }, new Void[0]);
    }

    public final void O00000o() {
        this.O00000oo.post(new Runnable() {
            /* class _m_j.fmj.AnonymousClass9 */

            public final void run() {
                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "getRemoteFailed");
                for (DeviceSearch next : fmj.this.O0000OOo) {
                    next.O000000o(true);
                    next.O000000o(new ArrayList(), DeviceSearch.REMOTESTATE.REMOTE_FAILED);
                }
                fmj.this.O000000o(false);
            }
        });
    }

    public final void O00000oO() {
        if (gfr.O0000Ooo) {
            LogType logType = LogType.DEVICE_LIST;
            gsy.O00000Oo(logType, "DeviceManagerInternal", "getDeviceListFromCore start" + Log.getStackTraceString(new Exception()));
        }
        ArrayList<Device> O00000Oo2 = fjd.O000000o().O00000Oo();
        LogType logType2 = LogType.DEVICE_LIST;
        StringBuilder sb = new StringBuilder("getDeviceList onSuccess: ");
        sb.append(O00000Oo2.size() == 0 ? 0 : O00000Oo2.size());
        gsy.O00000o0(logType2, "DeviceManagerInternal", sb.toString());
        LogType logType3 = LogType.DEVICE_LIST;
        gsy.O00000Oo(logType3, "DeviceManagerInternal", "performance:get device from core costs " + (System.currentTimeMillis() - this.O00oOooO) + "ms");
        this.O00000oO = false;
        this.O0000o = O00000Oo2;
        ArrayList arrayList = new ArrayList();
        this.O0000ooO.clear();
        Iterator<Device> it = O00000Oo2.iterator();
        while (it.hasNext()) {
            Device next = it.next();
            if (next == null) {
                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "getDeviceListFromCore device is null");
            } else if (next.getPid() == Device.PID_VIRTUAL_GROUP) {
                arrayList.add(next);
            } else if (next.getHideMode() >= Device.HIDE_MODE_HIDE_MAIN_LIST) {
                this.O0000ooO.add(next.getDid());
                if (gfr.O0000Ooo) {
                    gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "getDeviceListFromCore hidemode == 1");
                }
            }
            if (gfr.O0000Ooo && next != null) {
                LogType logType4 = LogType.DEVICE_LIST;
                gsy.O00000Oo(logType4, "DeviceManagerInternal", "getDeviceListFromCore device: [ name = " + next.getName() + " , did = " + next.getDid() + " ,model = " + next.getModel() + " ]");
            }
        }
        O00000Oo(arrayList);
        O00000o0();
    }

    private void O00000Oo(List<Device> list) {
        if (list.size() == 0) {
            this.O0000oO = new ArrayList();
            this.O0000oOO = new ArrayList();
            this.O0000oO0 = new HashMap();
            this.O0000oOo = new HashMap();
            this.O0000oo0 = new HashSet();
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            try {
                String extraInfo = list.get(i).getExtraInfo();
                if (extraInfo != null) {
                    gtd gtd = new gtd(extraInfo);
                    gtd O000000o2 = gtd.optJSONObject("member_list");
                    if (!gtd.optBoolean("showGroupMember", false)) {
                        String optString = O000000o2.optString("group_did");
                        String optString2 = O000000o2.optString("status");
                        gtd O000000o3 = O000000o2.optJSONObject("member_ship");
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<String> keys = O000000o3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (next.startsWith("group")) {
                                hashSet.add(next);
                            } else {
                                if (!arrayList.contains(next)) {
                                    arrayList.add(next);
                                }
                                arrayList2.add(next);
                            }
                        }
                        hashMap.put(optString, arrayList2);
                        hashMap2.put(optString, optString2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.O0000oO = arrayList;
        this.O0000oO0 = hashMap;
        this.O0000oOo = hashMap2;
        this.O0000oo0 = hashSet;
        for (String next2 : this.O0000oo0) {
            this.O0000oO0.remove(next2);
            this.O0000oOo.remove(next2);
        }
    }

    public final void O00000Oo(final boolean z) {
        LogType logType = LogType.DEVICE_LIST;
        gsy.O00000o0(logType, "DeviceManagerInternal", "updateDevice useCache: " + z + " mIsRefreshing:" + this.f16630O000000o);
        goq.O000000o(new Runnable() {
            /* class _m_j.fmj.AnonymousClass11 */

            public final void run() {
                CoreApi.O000000o().O000000o(fmj.this.O0000O0o, new CoreApi.O0000o0() {
                    /* class _m_j.fmj.AnonymousClass11.AnonymousClass1 */

                    public final void onCoreReady() {
                        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                            LogType logType = LogType.DEVICE_LIST;
                            gsy.O00000Oo(logType, "DeviceManagerInternal", "not login clear useCache: " + z);
                            fmj.this.O0000Oo0();
                            fmj.this.O00000oo.post(new Runnable() {
                                /* class _m_j.fmj.AnonymousClass11.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    fmj.this.O000000o(false);
                                }
                            });
                        } else if (!fmj.this.f16630O000000o.get()) {
                            fmj.this.f16630O000000o.compareAndSet(false, true);
                            fmj.this.O00000oo.removeCallbacks(fmj.this.O00oOooo);
                            fmj.this.O00000oo.postDelayed(fmj.this.O00oOooo, 5000);
                            gsy.O00000o0(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateDevice isPluginCacheReady");
                            CoreApi.O000000o().O000000o(fmj.this.O0000O0o, new CoreApi.O0000o() {
                                /* class _m_j.fmj.AnonymousClass11.AnonymousClass1.AnonymousClass2 */

                                public final void onPluginCacheReady() {
                                    final int size = PluginDeviceManager.instance.getPluginInfoMap().size();
                                    gsy.O00000o0(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateDevice onPluginCacheReady callback in plugrecord size = ".concat(String.valueOf(size)));
                                    PluginDeviceManager.instance.updateConfig(false, new fkn() {
                                        /* class _m_j.fmj.AnonymousClass11.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                        public final void O000000o(boolean z, boolean z2) {
                                            LogType logType = LogType.DEVICE_LIST;
                                            gsy.O00000Oo(logType, "DeviceManagerInternal", "updateDevice onPluginCacheReady updateConfig onSuccess = " + PluginDeviceManager.instance.getPluginInfoMap().size());
                                            fmj.this.O00000Oo();
                                            fmj fmj = fmj.this;
                                            boolean z3 = z;
                                            LogType logType2 = LogType.DEVICE_LIST;
                                            gsy.O00000Oo(logType2, "DeviceManagerInternal", "scanDeviceList, useCache = " + z3 + ", mCacheDevicesDirty = " + fmj.O00000oO);
                                            if (!z3 || fmj.O00000oO) {
                                                fmj.O00oOooO = System.currentTimeMillis();
                                                fjd.O000000o().O000000o(ScanType.ALL, new DeviceManagerInternal$5(fmj, z3));
                                                return;
                                            }
                                            fmj.O00000o0();
                                        }

                                        public final void O000000o(fdg fdg) {
                                            LogType logType = LogType.DEVICE_LIST;
                                            gsy.O00000o0(logType, "DeviceManagerInternal", "updateDevice onPluginCacheReady updateConfig onFailure = " + size);
                                            O000000o(false, false);
                                        }
                                    });
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    public final void O00000oo() {
        exo stateNotifier = ServiceApplication.getStateNotifier();
        if (stateNotifier == null) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateDeviceRemote notifier is null");
            return;
        }
        LogType logType = LogType.DEVICE_LIST;
        gsy.O00000Oo(logType, "DeviceManagerInternal", "updateDeviceRemote login state=" + stateNotifier.f15923O000000o);
        stateNotifier.O000000o(new exo.O000000o() {
            /* class _m_j.fmj.AnonymousClass12 */

            public final void onLoginSuccess() {
                fmj.this.O00000Oo(false);
            }

            public final void onLoginFailed() {
                fmj.this.O00000Oo(false);
            }
        });
    }

    public final void O0000O0o() {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateDeviceByCache");
        O00000Oo(true);
    }

    public final void O0000OOo() {
        LogType logType = LogType.DEVICE_LIST;
        gsy.O00000Oo(logType, "DeviceManagerInternal", "forceUpdateDeviceRemote " + this.f16630O000000o.get());
        if (this.f16630O000000o.get()) {
            this.O00000o0 = true;
        } else {
            O00000oo();
        }
    }

    public final void O0000Oo0() {
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "clear");
        this.O00000Oo.compareAndSet(true, false);
        this.O0000o0.f16680O000000o[0].clear();
        this.O0000OoO.f16680O000000o[0].clear();
        this.O0000Ooo.f16680O000000o[0].clear();
        this.O0000o00.f16680O000000o[0].clear();
        this.O0000o0o.clear();
        gts O000000o2 = gts.O000000o();
        O000000o2.O00000Oo = false;
        O000000o2.f18269O000000o = false;
        O000000o2.O00000o = new ArrayList<>();
        O000000o2.O0000O0o = new ArrayList();
        for (DeviceSearch<?> O00000o2 : this.O0000OOo) {
            O00000o2.O00000o();
        }
    }

    public static boolean O00000o0(Device device) {
        if (device == null || !device.isBinded() || device.isOwner() || fqw.O000000o(device.did) || device.isVirtualDevice() || (device instanceof MiTVDevice) || (device instanceof RouterDevice) || (device instanceof GeneralAPDevice)) {
            return false;
        }
        if (!(device instanceof BleDevice) || !((BleDevice) device).O00000oO()) {
            return true;
        }
        return false;
    }

    public static boolean O00000o(Device device) {
        if ((device instanceof MiTVDevice) && !device.isOwner()) {
            return true;
        }
        if (((device instanceof RouterDevice) && !device.isOwner()) || (device instanceof GeneralAPDevice)) {
            return true;
        }
        if ((!(device instanceof BleDevice) || !((BleDevice) device).O00000oO()) && !(device instanceof WatchBandDevice)) {
            return false;
        }
        return true;
    }

    static class O00000Oo extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<fmj> f16649O000000o;

        public O00000Oo(fmj fmj) {
            this.f16649O000000o = new WeakReference<>(fmj);
        }

        public final void onReceive(Context context, Intent intent) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "MyBroadcastReceiver onReceive in");
            if (this.f16649O000000o != null) {
                gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "MyBroadcastReceiver onReceive 1430");
                final fmj fmj = this.f16649O000000o.get();
                if (fmj != null) {
                    gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "MyBroadcastReceiver onReceive 1435");
                    if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "MyBroadcastReceiver onReceive 1437");
                        if ("update_device_list_action".equals(intent.getAction())) {
                            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "MyBroadcastReceiver onReceive receive ACTION_UPDATE_DEVICE_LIST");
                            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                                /* class _m_j.fmj.O00000Oo.AnonymousClass1 */

                                public final void onCoreReady() {
                                    fmj.O00000oO();
                                }
                            });
                        } else if ("action_locale_changed".equals(intent.getAction())) {
                            boolean booleanExtra = intent.getBooleanExtra("key_isForeGround", false);
                            if (ftm.O000000o(context) && booleanExtra && fmj != null) {
                                fmj.O0000OOo();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void O00000oo(String str) {
        this.O0000ooo = str;
        this.O00oOoOo = str;
    }
}
