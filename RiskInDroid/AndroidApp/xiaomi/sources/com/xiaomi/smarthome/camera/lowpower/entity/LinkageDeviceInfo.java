package com.xiaomi.smarthome.camera.lowpower.entity;

import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.ArrayList;
import java.util.List;

public class LinkageDeviceInfo {
    private List<String> connectedDids = new ArrayList();
    private DeviceStat deviceStat;
    private boolean isBinded = false;
    private boolean isSelected = false;

    public LinkageDeviceInfo(DeviceStat deviceStat2, List<String> list) {
        this.deviceStat = deviceStat2;
        this.connectedDids.addAll(list);
    }

    public boolean isBinded() {
        return this.isBinded;
    }

    public void setBinded(boolean z) {
        this.isBinded = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public DeviceStat getDeviceStat() {
        return this.deviceStat;
    }

    public void setDeviceStat(DeviceStat deviceStat2) {
        this.deviceStat = deviceStat2;
    }

    public List<String> getConnectedDids() {
        return this.connectedDids;
    }

    public void setConnectedDids(List<String> list) {
        this.connectedDids = list;
    }
}
