package com.xiaomi.smarthome.device;

import _m_j.fbs;
import _m_j.fmn;
import _m_j.fmp;
import _m_j.fmq;
import _m_j.fmr;
import _m_j.fms;
import _m_j.fmt;
import androidx.annotation.Keep;

@Keep
public class DeviceRouterFactory {
    public static void selfCheck() {
        if (getDeviceManager() == null) {
            throw new RuntimeException("IDeviceManage does not implement classes");
        } else if (getDeviceHelper() == null) {
            throw new RuntimeException("IDeviceHelper does not implement classes");
        } else if (getBleManager() == null) {
            throw new RuntimeException("IBleManager does not implement classes");
        } else if (getApDeviceManager() == null) {
            throw new RuntimeException("IApDeviceManager does not implement classes");
        } else if (getDeviceProviderImp() == null) {
            throw new RuntimeException("IDeviceProvider does not implement classes");
        } else if (getDeviceWrapper() == null) {
            throw new RuntimeException("IDeviceWrapper does not implement classes");
        }
    }

    public static fmr getDeviceManager() {
        return (fmr) fbs.O000000o(fmr.class, "key.com.xiaomi.smarthome.device.manager.router");
    }

    public static fmq getDeviceHelper() {
        return (fmq) fbs.O000000o(fmq.class, "key.com.xiaomi.smarthome.device.helper.router");
    }

    public static fmp getBleManager() {
        return (fmp) fbs.O000000o(fmp.class, "key.com.xiaomi.smarthome.ble.manager.router");
    }

    public static fmn getApDeviceManager() {
        return (fmn) fbs.O000000o(fmn.class, "key.com.xiaomi.smarthome.ap.device.manager.router");
    }

    public static fms getDeviceProviderImp() {
        return (fms) fbs.O000000o(fms.class, "key.com.xiaomi.smarthome.device.provider.router");
    }

    public static fmt getDeviceWrapper() {
        return (fmt) fbs.O000000o(fmt.class, "key.com.xiaomi.smarthome.device.wrapper.router");
    }
}
