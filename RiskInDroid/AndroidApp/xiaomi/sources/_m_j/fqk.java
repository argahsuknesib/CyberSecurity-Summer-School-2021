package _m_j;

import _m_j.fno;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.BleMeshDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class fqk implements fmr {
    private static final fqk INSTANCE = new fqk();
    private fmj mDeviceManagerInternal = fmj.O000000o();

    @cug
    public static fqk provideInstance() {
        return INSTANCE;
    }

    private fqk() {
    }

    public Device getDeviceByDid(String str) {
        return this.mDeviceManagerInternal.O000000o(str);
    }

    public Device getSubDeviceByDid(String str) {
        return this.mDeviceManagerInternal.O00000o(str);
    }

    public Device getDeviceOrSubDeviceByDid(String str) {
        return this.mDeviceManagerInternal.O00000oO(str);
    }

    public Device getDeviceByMac(String str) {
        fmj fmj = this.mDeviceManagerInternal;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<String, Device> value : fmj.O0000o0O.entrySet()) {
            Device device = (Device) value.getValue();
            if (str.equals(device.mac)) {
                return device;
            }
        }
        return null;
    }

    public List<Device> getSubDeviceByParentDid(String str) {
        fmj fmj = this.mDeviceManagerInternal;
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : fmj.O0000o0.entrySet()) {
            Device device = (Device) value.getValue();
            if (device.isSubDevice() && device.parentId.equals(str)) {
                arrayList.add(device);
            }
        }
        return arrayList.isEmpty() ? fmj.O00000o0(str) : arrayList;
    }

    public List<Device> getVirtualGroupDevices() {
        fmj fmj = this.mDeviceManagerInternal;
        if (fmj.O0000oOO != null) {
            return fmj.O0000oOO;
        }
        return new ArrayList();
    }

    public Device getVirtualGroupDeviceByDid(String str) {
        return this.mDeviceManagerInternal.O00000Oo(str);
    }

    public String getVirtualGroupStatus(String str) {
        fmj fmj = this.mDeviceManagerInternal;
        if (!fmj.O0000oOo.containsKey(str)) {
            return "3";
        }
        String str2 = fmj.O0000oOo.get(str);
        return Arrays.asList(gtf.O00000Oo).contains(str2) ? str2 : "3";
    }

    public boolean setVirtualGroupStatus(String str, String str2) {
        fmj fmj = this.mDeviceManagerInternal;
        if (!Arrays.asList(gtf.O00000Oo).contains(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        fmj.O0000oOo.put(str, str2);
        return true;
    }

    public Map<String, Device> getAllDevices() {
        return this.mDeviceManagerInternal.O0000o0O;
    }

    public List<Device> getExtraDevices() {
        return this.mDeviceManagerInternal.O0000o0o;
    }

    public Map<String, Device> getOnlineSubDevice() {
        return this.mDeviceManagerInternal.O0000o0;
    }

    public Map<String, Device> getOnlineDevice() {
        return this.mDeviceManagerInternal.O0000OoO;
    }

    public void startNotifySuccess() {
        fmj fmj = this.mDeviceManagerInternal;
        if (gfr.O0000Ooo || gfr.O0000OOo) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "startNotifySuccess in ");
        }
        fmj.O00000oo.post(new Runnable() {
            /* class _m_j.fmj.AnonymousClass1 */

            public final void run() {
                exo stateNotifier = ServiceApplication.getStateNotifier();
                LogType logType = LogType.DEVICE_LIST;
                gsy.O00000Oo(logType, "DeviceManagerInternal", "startNotifySuccess: outer want to startNotifyRefresh, mIsRefreshing = " + fmj.this.f16630O000000o.get());
                if (stateNotifier != null && stateNotifier.f15923O000000o == 4 && !fmj.this.f16630O000000o.get() && fmj.this.O00000Oo.get()) {
                    fmj.this.O000000o(false);
                }
            }
        });
    }

    public void setCurrentScrollToDid(String str) {
        this.mDeviceManagerInternal.O00000oo(str);
    }

    public void clear() {
        this.mDeviceManagerInternal.O0000Oo0();
    }

    public boolean isInDeviceListByMac(String str) {
        fmj fmj = this.mDeviceManagerInternal;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (Map.Entry<String, Device> value : fmj.O0000OoO.entrySet()) {
            if (TextUtils.equals(((Device) value.getValue()).mac, str)) {
                return true;
            }
        }
        return false;
    }

    public void forceUpdateDeviceRemote() {
        this.mDeviceManagerInternal.O0000OOo();
    }

    public void registerClientDeviceListener(fno.O000000o o000000o) {
        fmj fmj = this.mDeviceManagerInternal;
        synchronized (fmj.O0000Oo0) {
            if (!fmj.O0000Oo0.contains(o000000o)) {
                if (o000000o instanceof fno.O00000o0) {
                    fmj.O0000Oo0.add(o000000o);
                    gsy.O00000o0(LogType.DEVICE_LIST, "DeviceManagerInternal", "registerClientDeviceListener last listener:".concat(String.valueOf(o000000o)));
                } else {
                    fmj.O0000Oo0.add(0, o000000o);
                    gsy.O00000o0(LogType.DEVICE_LIST, "DeviceManagerInternal", "registerClientDeviceListener first listener:".concat(String.valueOf(o000000o)));
                }
            }
        }
    }

    public void unregisterClientDeviceListener(fno.O000000o o000000o) {
        fmj fmj = this.mDeviceManagerInternal;
        synchronized (fmj.O0000Oo0) {
            fmj.O0000Oo0.remove(o000000o);
            gsy.O00000o0(LogType.DEVICE_LIST, "DeviceManagerInternal", "unregisterClientDeviceListener listener:".concat(String.valueOf(o000000o)));
        }
    }

    public void updateDeviceByCache() {
        this.mDeviceManagerInternal.O0000O0o();
    }

    public void updateDeviceRemote() {
        this.mDeviceManagerInternal.O00000oo();
    }

    public void updateDeviceBatch(List<String> list, fsm<List<Device>, fso> fsm) {
        fmj fmj = this.mDeviceManagerInternal;
        if (list != null) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "updateDeviceBatch");
            CoreApi.O000000o().O00000o0(list, new fsm<List<Device>, fso>(fsm) {
                /* class _m_j.fmj.AnonymousClass4 */

                /* renamed from: O000000o */
                final /* synthetic */ fsm f16642O000000o;

                {
                    this.f16642O000000o = r2;
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    ArrayList arrayList;
                    List<Device> list = (List) obj;
                    fmj fmj = fmj.this;
                    if (list == null || list.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (Device device : list) {
                            Device O000000o2 = fmj.O000000o(device.getDid());
                            if (O000000o2 == null) {
                                O000000o2 = fmj.O00000o(device.getDid());
                            }
                            if (O000000o2 != null) {
                                DeviceFactory.O000000o(O000000o2, device);
                                arrayList.add(O000000o2);
                            }
                        }
                    }
                    fsm fsm = this.f16642O000000o;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(arrayList);
                    }
                }

                public final void onFailure(fso fso) {
                    fsm fsm = this.f16642O000000o;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                }
            });
        }
    }

    public void addDevice(Device device) {
        this.mDeviceManagerInternal.O000000o(device);
    }

    public void addDevices(List<Device> list) {
        this.mDeviceManagerInternal.O000000o(list);
    }

    public void delDevice(Device device) {
        this.mDeviceManagerInternal.O00000Oo(device);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fnp.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fnp.O000000o(java.util.Collection<? extends com.xiaomi.smarthome.device.Device>, com.xiaomi.smarthome.device.DeviceSearch$REMOTESTATE):void
      com.xiaomi.smarthome.device.DeviceSearch.O000000o(java.util.Collection<? extends com.xiaomi.smarthome.device.Device>, com.xiaomi.smarthome.device.DeviceSearch$REMOTESTATE):void
      _m_j.fnp.O000000o(java.lang.String, boolean):void */
    public void delDeviceBatch(List<String> list, Context context, fno.O00000Oo o00000Oo) {
        fmj fmj = this.mDeviceManagerInternal;
        if (list != null) {
            if (TextUtils.equals(CoreApi.O000000o().O0000o0(), "923522198")) {
                int i = 0;
                while (i < list.size()) {
                    if (!TextUtils.equals(list.get(i), "658906")) {
                        i++;
                    } else if (o00000Oo != null) {
                        o00000Oo.O000000o(new fso(-1, "Can't delete test device"));
                        return;
                    } else {
                        return;
                    }
                }
            }
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "delDeviceBatch");
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < list.size()) {
                if (list.get(i2).contains("config") || list.get(i2).contains("xiaofang")) {
                    arrayList.add(list.remove(i2));
                    i2--;
                }
                i2++;
            }
            for (String next : list) {
                Device O000000o2 = fmj.O000000o().O000000o(next);
                if (O000000o2 != null) {
                    if (next.startsWith("temprory_device")) {
                        fnp.O00000oo().O000000o(O000000o2.model, false);
                    } else {
                        if (O000000o2 instanceof MiTVDevice) {
                            fnh.O000000o().O000000o(next);
                        }
                        if (O000000o2 instanceof GeneralAPDevice) {
                            fmm.O00000oo().O00000Oo(O000000o2);
                        }
                    }
                }
            }
            CoreApi.O000000o().O00000Oo(list, new fsm<String, fso>(arrayList, o00000Oo) {
                /* class _m_j.fmj.AnonymousClass7 */

                /* renamed from: O000000o */
                final /* synthetic */ List f16645O000000o;
                final /* synthetic */ fno.O00000Oo O00000Oo;

                {
                    this.f16645O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    Context appContext;
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                int optInt = jSONObject.optInt(next);
                                Device O000000o2 = fmj.O000000o().O000000o(next);
                                if (O000000o2 != null) {
                                    if (DeviceFactory.O00000Oo(DeviceFactory.O000000o(O000000o2.model, O000000o2.bssid), O000000o2.bssid) == DeviceFactory.AP_TYPE.AP_MIBAP && (appContext = CommonApplication.getAppContext()) != null) {
                                        String str2 = O000000o2.mac;
                                        String str3 = "";
                                        if (!TextUtils.isEmpty(str2)) {
                                            String replace = str2.replace(":", str3);
                                            if (replace.length() >= 4) {
                                                str3 = replace.substring(replace.length() - 4);
                                            }
                                        }
                                        if (!TextUtils.isEmpty(str3)) {
                                            Intent intent = new Intent("smarthome.miconnect.ble.unbind");
                                            intent.setPackage(appContext.getPackageName());
                                            intent.putExtra("combo_key", str3);
                                            appContext.sendBroadcast(intent);
                                        }
                                    }
                                    if (optInt == 1) {
                                        O000000o2.setUnbind();
                                        if (O000000o2 instanceof MiTVDevice) {
                                            fnh.O000000o().O000000o(next);
                                        } else if (O000000o2 instanceof BleDevice) {
                                            fob.O000000o((BleDevice) O000000o2);
                                        } else if (O000000o2 instanceof BleMeshDevice) {
                                            fob.O000000o(O000000o2);
                                        } else if (O000000o2 instanceof RouterDevice) {
                                            if (O000000o2.isOwner()) {
                                                O000000o2.setOwner(false);
                                            } else if (O000000o2.isShared() || O000000o2.isFamily()) {
                                                O000000o2.setShared(false);
                                            }
                                            String str4 = O000000o2.did;
                                            if (str4.startsWith("miwifi.")) {
                                                str4 = str4.substring(7);
                                            }
                                            Intent intent2 = new Intent("com.xiaomi.router");
                                            intent2.putExtra("operation", "delete");
                                            intent2.putExtra("userId", CoreApi.O000000o().O0000o0());
                                            intent2.putExtra("id", str4);
                                            fmj.this.O0000O0o.sendBroadcast(intent2);
                                        }
                                        fmj.O000000o().O00000Oo(O000000o2);
                                    } else if (optInt == 0) {
                                        if (O000000o2 != null && (O000000o2 instanceof BleDevice)) {
                                            fob.O000000o((BleDevice) O000000o2);
                                        } else if (O000000o2 instanceof BleMeshDevice) {
                                            fob.O000000o(O000000o2);
                                        }
                                    }
                                }
                            }
                            for (String O000000o3 : this.f16645O000000o) {
                                Device O000000o4 = fmj.this.O000000o(O000000o3);
                                if (O000000o4 != null) {
                                    fmj.this.O00000Oo(O000000o4);
                                }
                            }
                            if (this.O00000Oo != null) {
                                this.O00000Oo.O000000o();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public final void onFailure(fso fso) {
                    fno.O00000Oo o00000Oo = this.O00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.O000000o(fso);
                    }
                }
            });
        }
    }

    public void setSubDeviceShownMode(boolean z, String str, Context context, ftt<Void> ftt) {
        DevicelibApi.setShowMode(context, str, z ? 1 : 0, new fsm<Boolean, fso>(str, z, ftt) {
            /* class _m_j.fmj.AnonymousClass2 */

            /* renamed from: O000000o */
            final /* synthetic */ String f16639O000000o;
            final /* synthetic */ int O00000Oo;
            final /* synthetic */ ftt O00000o0;

            {
                this.f16639O000000o = r2;
                this.O00000Oo = r3;
                this.O00000o0 = r4;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                Device O00000o2;
                if (((Boolean) obj).booleanValue() && (O00000o2 = fmj.this.O00000o(this.f16639O000000o)) != null) {
                    fmj.this.O00000Oo(O00000o2);
                    O00000o2.showMode = this.O00000Oo;
                    fmj.this.O000000o(O00000o2);
                    ftt ftt = this.O00000o0;
                    if (ftt != null) {
                        ftt.O000000o((Object) null);
                        return;
                    }
                }
                ftt ftt2 = this.O00000o0;
                if (ftt2 != null) {
                    ftt2.O000000o(ErrorCode.INVALID.getCode());
                }
            }

            public final void onFailure(fso fso) {
                ftt ftt = this.O00000o0;
                if (ftt != null) {
                    ftt.O000000o(fso.f17063O000000o);
                }
            }
        });
    }

    public void setSubDeviceShownMode(boolean z, Set<String> set, Context context, ftt<Void> ftt) {
        DevicelibApi.setShowMode(context, set, z ? 1 : 0, new fsm<Boolean, fso>(set, z, ftt) {
            /* class _m_j.fmj.AnonymousClass3 */

            /* renamed from: O000000o */
            final /* synthetic */ Set f16640O000000o;
            final /* synthetic */ int O00000Oo;
            final /* synthetic */ ftt O00000o0;

            {
                this.f16640O000000o = r2;
                this.O00000Oo = r3;
                this.O00000o0 = r4;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    for (String O00000o2 : this.f16640O000000o) {
                        Device O00000o3 = fmj.this.O00000o(O00000o2);
                        if (O00000o3 != null) {
                            for (DeviceSearch<?> O00000Oo2 : fmj.this.O0000OOo) {
                                O00000Oo2.O00000Oo(O00000o3);
                            }
                            O00000o3.showMode = this.O00000Oo;
                            for (DeviceSearch<?> O000000o2 : fmj.this.O0000OOo) {
                                O000000o2.O000000o(O00000o3);
                            }
                        }
                    }
                    fmj.this.O00000oo.post(new Runnable() {
                        /* class _m_j.fmj.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            fmj.this.O0000OOo();
                            fmj.this.O000000o(true);
                        }
                    });
                }
                ftt ftt = this.O00000o0;
                if (ftt != null) {
                    ftt.O000000o((Object) null);
                }
            }

            public final void onFailure(fso fso) {
                ftt ftt = this.O00000o0;
                if (ftt != null) {
                    ftt.O000000o(fso.f17063O000000o);
                }
            }
        });
    }

    public void refreshDevice(Device device) {
        fmj fmj = this.mDeviceManagerInternal;
        if (device != null) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "refreshDevice: name = " + device.name + ", did = " + device.did + ", model = " + device.model + ", mac = " + device.mac);
            synchronized (fmj.O0000Oo0) {
                for (int size = fmj.O0000Oo0.size() - 1; size >= 0; size--) {
                    if (fmj.O0000Oo0.get(size) != null) {
                        fmj.O0000Oo0.get(size).onRefreshClientDeviceChanged(2, device);
                    }
                }
            }
        }
    }

    public boolean checkIsSharedDevice(Device device) {
        return fmj.O00000o0(device);
    }

    public boolean checkIsNearbyDevice(Device device) {
        return fmj.O00000o(device);
    }

    public void forceUpdateDeviceByCache() {
        fmj fmj = this.mDeviceManagerInternal;
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "forceUpdateDeviceByCache");
        if (fmj.f16630O000000o.get()) {
            fmj.O00000o = true;
        } else {
            fmj.O0000O0o();
        }
    }

    public void isDeviceListReady(fno.O00000o o00000o) {
        fmj fmj = this.mDeviceManagerInternal;
        if (o00000o == null) {
            return;
        }
        if (fmj.O00000Oo.get()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                o00000o.onDeviceReady(fmj.O0000o0O);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable(o00000o) {
                    /* class _m_j.fmj.AnonymousClass5 */

                    /* renamed from: O000000o */
                    final /* synthetic */ fno.O00000o f16643O000000o;

                    {
                        this.f16643O000000o = r2;
                    }

                    public final void run() {
                        this.f16643O000000o.onDeviceReady(fmj.this.O0000o0O);
                    }
                });
            }
        } else if (fmj.f16630O000000o.get()) {
            synchronized (fmj.O0000Oo) {
                fmj.O0000Oo.add(o00000o);
            }
        } else {
            fmj.O00000oo();
            synchronized (fmj.O0000Oo) {
                fmj.O0000Oo.add(o00000o);
            }
        }
    }

    public boolean isDeviceInDeviceList(String str) {
        fmj fmj = this.mDeviceManagerInternal;
        return (fmj.O000000o(str) == null && fmj.O00000o(str) == null) ? false : true;
    }

    public boolean isInited() {
        return this.mDeviceManagerInternal.O00000Oo.get();
    }

    public boolean isRefreshing() {
        return this.mDeviceManagerInternal.f16630O000000o.get();
    }

    public void refreshDeviceAll() {
        fmj fmj = this.mDeviceManagerInternal;
        gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "refreshDeviceAll");
        synchronized (fmj.O0000Oo0) {
            for (int size = fmj.O0000Oo0.size() - 1; size >= 0; size--) {
                if (fmj.O0000Oo0.get(size) != null) {
                    fmj.O0000Oo0.get(size).onRefreshClientDeviceChanged(2, null);
                }
            }
        }
    }

    public List<Device> getOwnerDeviceByModel(String str) {
        fmj fmj = this.mDeviceManagerInternal;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : fmj.O0000OoO.entrySet()) {
            Device device = (Device) value.getValue();
            if (!TextUtils.isEmpty(device.model) && device.model.equalsIgnoreCase(str) && device.isOwner()) {
                arrayList.add(device);
            }
        }
        for (Map.Entry<String, Device> value2 : fmj.O0000o0.entrySet()) {
            Device device2 = (Device) value2.getValue();
            if (!TextUtils.isEmpty(device2.model) && device2.model.equalsIgnoreCase(str) && device2.isOwner()) {
                boolean z = true;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (device2.did.equalsIgnoreCase(((Device) arrayList.get(i)).did)) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(device2);
                }
            }
        }
        return arrayList;
    }

    public String getCurrentScrollToDid() {
        return this.mDeviceManagerInternal.O0000ooo;
    }

    public void cleanScrollToDid() {
        this.mDeviceManagerInternal.O0000ooo = null;
    }

    public void setCurrentScanDid(String str) {
        this.mDeviceManagerInternal.O00000oo(str);
    }

    public List<String> getVirtualGroup() {
        return new ArrayList(this.mDeviceManagerInternal.O0000oO0.keySet());
    }

    public List<Device> getVirtualGroupMemberList(String str) {
        fmj fmj = this.mDeviceManagerInternal;
        ArrayList arrayList = new ArrayList();
        List<String> list = fmj.O0000oO0.get(str);
        if (list != null && list.size() > 0) {
            for (String O00000Oo : list) {
                Device O00000Oo2 = fmj.O00000Oo(O00000Oo);
                if (O00000Oo2 != null) {
                    arrayList.add(O00000Oo2);
                }
            }
        }
        return arrayList;
    }

    public int getTotalOperatableDeviceCount() {
        boolean z;
        fmj fmj = this.mDeviceManagerInternal;
        if (!CoreApi.O000000o().O0000Ooo()) {
            return 0;
        }
        int size = fmj.O0000o0O.size();
        for (Map.Entry<String, Device> value : fmj.O0000o0O.entrySet()) {
            Device device = (Device) value.getValue();
            if (device == null || device.pid == Device.PID_VIRTUAL_DEVICE || ((device.isSubDevice() && device.isShowMainList()) || (device instanceof PhoneIRDevice))) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                size--;
            }
        }
        return Math.max(size, 0);
    }

    public DeviceStat getDeviceState(String str) {
        fmj fmj = this.mDeviceManagerInternal;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Device O000000o2 = fmj.O000000o(str);
        if (O000000o2 == null) {
            O000000o2 = fmj.O00000o(str);
        }
        if (O000000o2 != null) {
            return DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2);
        }
        return null;
    }

    public void setCacheDirty(ArrayList<String> arrayList) {
        fmj fmj = this.mDeviceManagerInternal;
        if (arrayList != null) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "setCacheDirty");
            Intent intent = new Intent();
            intent.setAction("device_status_change_action");
            intent.putStringArrayListExtra("device_status_change_dirty_dids", arrayList);
            ft.O000000o(fmj.O0000O0o).O000000o(intent);
        }
    }

    public Map<String, Device> getHideDevicesMap() {
        return this.mDeviceManagerInternal.O0000oo;
    }
}
