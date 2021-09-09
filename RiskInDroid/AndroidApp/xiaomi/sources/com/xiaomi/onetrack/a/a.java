package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.Configuration;

public class a {
    public static int a(Configuration configuration) {
        if (configuration == null) {
            return 0;
        }
        boolean isGAIDEnable = configuration.isGAIDEnable();
        if (configuration.isIMSIEnable()) {
            isGAIDEnable |= true;
        }
        if (configuration.isIMEIEnable()) {
            isGAIDEnable |= true;
        }
        if (configuration.isExceptionCatcherEnable()) {
            isGAIDEnable |= true;
        }
        return configuration.isOverrideMiuiRegionSetting() ? isGAIDEnable | true ? 1 : 0 : isGAIDEnable ? 1 : 0;
    }
}
