package _m_j;

import _m_j.fno;
import android.content.Context;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface fmr extends gze {
    void addDevice(Device device);

    void addDevices(List<Device> list);

    boolean checkIsNearbyDevice(Device device);

    boolean checkIsSharedDevice(Device device);

    void cleanScrollToDid();

    void clear();

    void delDevice(Device device);

    void delDeviceBatch(List<String> list, Context context, fno.O00000Oo o00000Oo);

    void forceUpdateDeviceByCache();

    void forceUpdateDeviceRemote();

    Map<String, Device> getAllDevices();

    String getCurrentScrollToDid();

    Device getDeviceByDid(String str);

    Device getDeviceByMac(String str);

    Device getDeviceOrSubDeviceByDid(String str);

    DeviceStat getDeviceState(String str);

    List<Device> getExtraDevices();

    Map<String, Device> getOnlineDevice();

    Map<String, Device> getOnlineSubDevice();

    List<Device> getOwnerDeviceByModel(String str);

    Device getSubDeviceByDid(String str);

    List<Device> getSubDeviceByParentDid(String str);

    int getTotalOperatableDeviceCount();

    List<String> getVirtualGroup();

    Device getVirtualGroupDeviceByDid(String str);

    List<Device> getVirtualGroupDevices();

    List<Device> getVirtualGroupMemberList(String str);

    String getVirtualGroupStatus(String str);

    boolean isDeviceInDeviceList(String str);

    void isDeviceListReady(fno.O00000o o00000o);

    boolean isInDeviceListByMac(String str);

    boolean isInited();

    boolean isRefreshing();

    void refreshDevice(Device device);

    void refreshDeviceAll();

    void registerClientDeviceListener(fno.O000000o o000000o);

    void setCacheDirty(ArrayList<String> arrayList);

    void setCurrentScanDid(String str);

    void setCurrentScrollToDid(String str);

    void setSubDeviceShownMode(boolean z, String str, Context context, ftt<Void> ftt);

    void setSubDeviceShownMode(boolean z, Set<String> set, Context context, ftt<Void> ftt);

    boolean setVirtualGroupStatus(String str, String str2);

    void startNotifySuccess();

    void unregisterClientDeviceListener(fno.O000000o o000000o);

    void updateDeviceBatch(List<String> list, fsm<List<Device>, fso> fsm);

    void updateDeviceByCache();

    void updateDeviceRemote();
}
