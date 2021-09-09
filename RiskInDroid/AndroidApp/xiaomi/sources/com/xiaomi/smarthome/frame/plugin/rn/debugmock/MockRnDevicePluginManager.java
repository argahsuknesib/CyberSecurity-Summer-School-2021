package com.xiaomi.smarthome.frame.plugin.rn.debugmock;

import _m_j.hsj;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.HashMap;
import java.util.Map;

public class MockRnDevicePluginManager {
    private static volatile MockRnDevicePluginManager instance;
    private Map<String, DeviceStat> mapMockDviceStat = new HashMap();
    private Map<String, Boolean> mapMockModel = new HashMap();
    private Map<String, PluginPackageInfo> mapMockPackageInfo = new HashMap();
    private Map<String, PluginDeviceInfo> mapMockPluginDeviceInfo = new HashMap();
    private Map<String, String> mapMockPluginDownloadUrl = new HashMap();

    private MockRnDevicePluginManager() {
        init();
    }

    public static MockRnDevicePluginManager getInstance() {
        if (instance == null) {
            synchronized (MockRnDevicePluginManager.class) {
                if (instance == null) {
                    instance = new MockRnDevicePluginManager();
                }
            }
        }
        return instance;
    }

    private void init() {
        this.mapMockModel.put("t.t.t", Boolean.TRUE);
        this.mapMockPackageInfo.put("t.t.t", MockRnDevicePluginUtil.mockPluginPackageInfo(2100000000));
        this.mapMockPluginDeviceInfo.put("t.t.t", MockRnDevicePluginUtil.mockPluginInfo("t.t.t", "mock_name"));
        this.mapMockDviceStat.put("00-00-00-00-00-00", hsj.O000000o());
        addMockInfo("mock.did.xiaomi.demo", "mock.model.xiaomi.demo", "com.xiaomi.demo", 2100000001);
        addMockInfo("mock.did.miot.curtain", "mock.model.miot.curtain", "com.miot.curtain", 2100000002);
        addMockInfo("mock.did.miot.plug", "mock.model.miot.plug", "com.miot.plug", 2100000003);
        addMockInfo("mock.did.miot.light", "mock.model.miot.light", "com.miot.light", 2100000004);
        this.mapMockPluginDownloadUrl.put("mock.did.xiaomi.demo", "http://cdn.cnbj0.fds.api.mi-img.com/miio.files/commonfile_zip_a348bd8c21030ba605d47331d4eb4663.zip");
        this.mapMockPluginDownloadUrl.put("mock.did.miot.curtain", "http://cdn.cnbj0.fds.api.mi-img.com/miio.files/commonfile_zip_d5d28f498b7a10f969cca70a488d0a85.zip");
        this.mapMockPluginDownloadUrl.put("mock.did.miot.plug", "http://cdn.cnbj0.fds.api.mi-img.com/miio.files/commonfile_zip_aeb0f7b0d37b779017c5b02291c1440a.zip");
        this.mapMockPluginDownloadUrl.put("mock.did.miot.light", "http://cdn.cnbj0.fds.api.mi-img.com/miio.files/commonfile_zip_a63e2f5f4fde2f587b1cc659de438ab0.zip");
    }

    private void addMockInfo(String str, String str2, String str3, long j) {
        this.mapMockModel.put(str2, Boolean.TRUE);
        this.mapMockPackageInfo.put(str2, MockRnDevicePluginUtil.mockPluginPackageInfo(j));
        this.mapMockPluginDeviceInfo.put(str2, MockRnDevicePluginUtil.mockPluginInfo(str2, str3));
        this.mapMockDviceStat.put(str, MockRnDevicePluginUtil.mockDeviceStat(str, str2, str3));
    }

    public void addMockInfo(DeviceStat deviceStat) {
        this.mapMockModel.put(deviceStat.model, Boolean.TRUE);
        this.mapMockPackageInfo.put(deviceStat.model, MockRnDevicePluginUtil.mockPluginPackageInfo(2100001001));
        this.mapMockPluginDeviceInfo.put(deviceStat.model, MockRnDevicePluginUtil.mockPluginInfo(deviceStat.model, deviceStat.name));
        this.mapMockDviceStat.put(deviceStat.did, deviceStat);
    }

    public boolean modelIsMockModel(String str) {
        return this.mapMockModel.containsKey(str);
    }

    public PluginPackageInfo getMockPluginPackageInfo(String str) {
        return this.mapMockPackageInfo.get(str);
    }

    public PluginDeviceInfo getMockPluginDeviceInfo(String str) {
        return this.mapMockPluginDeviceInfo.get(str);
    }

    public boolean didIsMockDid(String str) {
        return this.mapMockDviceStat.containsKey(str);
    }

    public DeviceStat getMockDeviceStat(String str) {
        return this.mapMockDviceStat.get(str);
    }

    public String getMockPluginDownloadUrl(String str) {
        return this.mapMockPluginDownloadUrl.get(str);
    }
}
