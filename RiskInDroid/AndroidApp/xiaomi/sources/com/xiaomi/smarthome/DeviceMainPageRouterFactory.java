package com.xiaomi.smarthome;

import _m_j.eyb;
import _m_j.eye;
import _m_j.fbs;
import androidx.annotation.Keep;

@Keep
public class DeviceMainPageRouterFactory {
    public static eyb getDeviceMainPageHelper() {
        return (eyb) fbs.O000000o(eyb.class, "key_device_main_page_helper_router");
    }

    public static eye getSmartHomeMainActivityProvider() {
        return (eye) fbs.O000000o(eye.class, "key_smart_home_main_activity_provider");
    }
}
