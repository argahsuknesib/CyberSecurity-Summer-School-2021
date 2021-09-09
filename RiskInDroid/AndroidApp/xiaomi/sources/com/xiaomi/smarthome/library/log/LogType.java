package com.xiaomi.smarthome.library.log;

public enum LogType {
    ILLEGAL_TYPE(0),
    LOG_INTERNAL(1),
    GENERAL(2),
    STARTUP(3),
    LOGIN(4),
    NETWORK(5),
    MAIN_PAGE(6),
    PLUGIN(7),
    HOME_ROOM(8),
    KUAILIAN(9),
    BLUETOOTH(10),
    PAGE_SWITCH(11),
    WEBVIEW(12),
    DEVICE_LIST(13),
    PUSH(14),
    CARD(15),
    CAMERA(16),
    DEVICE_CONTROL(17),
    MICONNECT(18),
    SCENE(19),
    SERIOUS_EXCEPTION(20),
    MONITOR(21),
    NATIVE_CAMERA(22),
    NATIVE_MISS(23),
    NATIVE_GENERAL(24),
    REQUEST_OUTPUT(25),
    LOG_ANALYSIS(26),
    LOG_UWB(27),
    OTA(28),
    MIJIA_WIDGET(29),
    MIJIA_WIDGET_CACHE(30),
    MICO(31);
    
    private int value = 0;

    private LogType(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }
}
