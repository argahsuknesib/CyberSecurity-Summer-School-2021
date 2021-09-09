package com.xiaomi.smarthome.camera.activity.alarm;

public class IDMPairingInfo {
    public String idm_devDid = "";
    public String idm_eventType = "0";
    public String idm_idHash = "";
    public String idm_switch = "0";

    public String toString() {
        return "IDMPairingInfo{idm_devDid='" + this.idm_devDid + '\'' + ", idm_eventType='" + this.idm_eventType + '\'' + ", idm_switch='" + this.idm_switch + '\'' + ", idm_idHash='" + this.idm_idHash + '\'' + '}';
    }
}
