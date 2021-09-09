package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConfig;

public class ReactYogaConfigProvider {
    private static YogaConfig YOGA_CONFIG;

    public static YogaConfig get() {
        if (YOGA_CONFIG == null) {
            YogaConfig yogaConfig = new YogaConfig();
            YOGA_CONFIG = yogaConfig;
            yogaConfig.setPointScaleFactor(0.0f);
            YOGA_CONFIG.setUseLegacyStretchBehaviour(true);
        }
        return YOGA_CONFIG;
    }
}
