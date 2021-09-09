package com.xiaomi.mico.common.application;

import com.xiaomi.mico.application.MicoManager;

public class MicoCapabilityUtil {
    public static boolean hasCapabilityVideoAlarm() {
        return MicoManager.getInstance().getCurrentMico().getHardwareType().hasCapabilityVideoAlarm();
    }

    public static boolean hasCapabilityChinaMobileIms() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.CHINA_MOBILE_IMS);
    }

    public static boolean hasMusicSourceChangeable(Hardware hardware) {
        return hardware.hasScreen();
    }
}
