package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.List;
import java.util.Map;

public class fno {
    private static volatile fno O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public fmr f16707O000000o = DeviceRouterFactory.getDeviceManager();

    public interface O000000o {
        void onRefreshClientDeviceChanged(int i, Device device);

        void onRefreshClientDeviceSuccess(int i);
    }

    public interface O00000Oo {
        void O000000o();

        void O000000o(fso fso);
    }

    public interface O00000o {
        void onDeviceReady(Map<String, Device> map);
    }

    public interface O00000o0 extends O000000o {
    }

    private fno() {
    }

    public static fno O000000o() {
        if (O00000Oo == null) {
            synchronized (fno.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fno();
                }
            }
        }
        return O00000Oo;
    }

    public final Device O000000o(String str) {
        return this.f16707O000000o.getDeviceByDid(str);
    }

    public final Device O00000Oo(String str) {
        return this.f16707O000000o.getSubDeviceByDid(str);
    }

    public final Device O00000o0(String str) {
        return this.f16707O000000o.getDeviceOrSubDeviceByDid(str);
    }

    public final Device O00000o(String str) {
        return this.f16707O000000o.getDeviceByMac(str);
    }

    public final List<Device> O00000oO(String str) {
        return this.f16707O000000o.getSubDeviceByParentDid(str);
    }

    public final Map<String, Device> O00000Oo() {
        return this.f16707O000000o.getOnlineSubDevice();
    }

    public final List<Device> O00000o0() {
        return this.f16707O000000o.getVirtualGroupDevices();
    }

    public final Device O00000oo(String str) {
        return this.f16707O000000o.getVirtualGroupDeviceByDid(str);
    }

    public final List<String> O00000o() {
        return this.f16707O000000o.getVirtualGroup();
    }

    public final List<Device> O0000O0o(String str) {
        return this.f16707O000000o.getVirtualGroupMemberList(str);
    }

    public final Map<String, Device> O00000oO() {
        return this.f16707O000000o.getAllDevices();
    }

    public final List<Device> O00000oo() {
        return this.f16707O000000o.getExtraDevices();
    }

    public final Device O0000OOo(String str) {
        List<Device> O00000oo = O00000oo();
        if (O00000oo == null) {
            return null;
        }
        for (Device next : O00000oo) {
            if (next != null && next.did.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final Map<String, Device> O0000O0o() {
        return this.f16707O000000o.getOnlineDevice();
    }

    public final void O0000OOo() {
        this.f16707O000000o.startNotifySuccess();
    }

    public final void O0000Oo0(String str) {
        this.f16707O000000o.setCurrentScrollToDid(str);
    }

    public final void O000000o(O000000o o000000o) {
        this.f16707O000000o.registerClientDeviceListener(o000000o);
    }

    public final void O00000Oo(O000000o o000000o) {
        this.f16707O000000o.unregisterClientDeviceListener(o000000o);
    }

    public final void O0000Oo0() {
        this.f16707O000000o.updateDeviceRemote();
    }

    public final void O000000o(List<String> list, fsm<List<Device>, fso> fsm) {
        this.f16707O000000o.updateDeviceBatch(list, fsm);
    }

    public final void O000000o(Device device) {
        this.f16707O000000o.addDevice(device);
    }

    public final void O000000o(List<Device> list) {
        this.f16707O000000o.addDevices(list);
    }

    public final void O00000Oo(Device device) {
        this.f16707O000000o.delDevice(device);
    }

    public final void O000000o(List<String> list, Context context, O00000Oo o00000Oo) {
        this.f16707O000000o.delDeviceBatch(list, context, o00000Oo);
    }

    public final void O0000Oo() {
        this.f16707O000000o.clear();
    }

    public final void O00000o0(Device device) {
        this.f16707O000000o.refreshDevice(device);
    }

    public final boolean O00000o(Device device) {
        return this.f16707O000000o.checkIsSharedDevice(device);
    }

    public final boolean O00000oO(Device device) {
        return this.f16707O000000o.checkIsNearbyDevice(device);
    }

    public final void O0000OoO() {
        this.f16707O000000o.updateDeviceByCache();
    }

    public final void O0000Ooo() {
        this.f16707O000000o.forceUpdateDeviceByCache();
    }

    public final void O000000o(O00000o o00000o) {
        this.f16707O000000o.isDeviceListReady(o00000o);
    }

    public final boolean O0000Oo(String str) {
        return this.f16707O000000o.isDeviceInDeviceList(str);
    }

    public final boolean O0000o00() {
        return this.f16707O000000o.isInited();
    }

    public final boolean O0000o0() {
        return this.f16707O000000o.isRefreshing();
    }

    public final void O0000o0O() {
        this.f16707O000000o.forceUpdateDeviceRemote();
    }

    public final boolean O0000OoO(String str) {
        return this.f16707O000000o.isInDeviceListByMac(str);
    }

    public final List<Device> O0000Ooo(String str) {
        return this.f16707O000000o.getOwnerDeviceByModel(str);
    }

    public final String O0000o0o() {
        return this.f16707O000000o.getCurrentScrollToDid();
    }

    public final int O0000o() {
        return this.f16707O000000o.getTotalOperatableDeviceCount();
    }

    public final DeviceStat O0000o00(String str) {
        return this.f16707O000000o.getDeviceState(str);
    }
}
