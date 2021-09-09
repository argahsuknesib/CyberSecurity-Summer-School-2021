package com.xiaomi.smarthome.device.api;

public class FirmwareUpdateResult {
    public String curr;
    public String description;
    public boolean force;
    public boolean isLatest;
    public String latest;
    public int ota_progress;
    public String ota_status;
    public boolean rec;
    public int timeout;
    public boolean updating;

    public String toString() {
        return "updating:" + this.updating + " curr:" + this.curr + " latest:" + this.latest + " isLatest:" + this.isLatest + " description:" + this.description + " ota_progress:" + this.ota_progress + " ota_status:" + this.ota_status + " timeout:" + this.timeout + " force:" + this.force + " rec:" + this.rec;
    }
}
