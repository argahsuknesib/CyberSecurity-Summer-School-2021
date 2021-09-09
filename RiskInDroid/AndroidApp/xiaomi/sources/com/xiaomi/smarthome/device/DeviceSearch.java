package com.xiaomi.smarthome.device;

import com.xiaomi.smarthome.device.Device;
import java.util.Collection;
import java.util.List;

public abstract class DeviceSearch<T extends Device> {
    protected boolean O0000O0o = false;
    protected boolean O0000OOo = false;
    protected boolean O0000Oo0 = false;

    public enum REMOTESTATE {
        REMOTE_NOT_UPDATING,
        REMOTE_SUCCESS,
        REMOTE_FAILED,
        REMOTE_NOT_LOGIN
    }

    public void O000000o() {
    }

    public void O000000o(Device device) {
    }

    public abstract void O000000o(Collection<? extends Device> collection, REMOTESTATE remotestate);

    public abstract void O00000Oo();

    public void O00000Oo(Device device) {
    }

    public void O00000o() {
    }

    public abstract List<T> O00000o0();

    public int O00000oO() {
        return -1;
    }

    public final void O000000o(boolean z) {
        this.O0000Oo0 = z;
    }
}
