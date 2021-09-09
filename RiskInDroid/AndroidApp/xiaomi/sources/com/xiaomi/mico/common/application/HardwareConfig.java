package com.xiaomi.mico.common.application;

public interface HardwareConfig {

    /* renamed from: com.xiaomi.mico.common.application.HardwareConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$hasCapabilityVideoAlarm(HardwareConfig hardwareConfig) {
            return false;
        }

        public static boolean $default$hasScreen(HardwareConfig hardwareConfig) {
            return false;
        }

        public static boolean $default$needAuthXiaomiAccount(HardwareConfig hardwareConfig) {
            return false;
        }

        public static boolean $default$needBindToServer(HardwareConfig hardwareConfig) {
            return true;
        }

        public static boolean $default$support5GHz(HardwareConfig hardwareConfig) {
            return true;
        }

        public static boolean $default$supportEap(HardwareConfig hardwareConfig) {
            return true;
        }

        public static boolean $default$supportIR(HardwareConfig hardwareConfig) {
            return false;
        }

        public static boolean $default$supportVoip(HardwareConfig hardwareConfig) {
            return true;
        }
    }

    String getAIClientId();

    int getAlarmVolume();

    int getBLEType();

    int getDefaultAlias();

    int getImageBig();

    int getMenuIcon();

    String getName();

    int getScanIcon();

    int getTimerVolume();

    int getUpgradeIcon();

    boolean hasCapabilityVideoAlarm();

    boolean hasScreen();

    boolean isAndroidRom();

    boolean needAuthXiaomiAccount();

    boolean needBindToServer();

    boolean support5GHz();

    boolean supportEap();

    boolean supportIR();

    boolean supportVoip();
}
