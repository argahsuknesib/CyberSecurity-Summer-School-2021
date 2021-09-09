package com.xiaomi.smarthome.uwb.lib.auth;

public interface OobRequestCallback {
    void onRequestOob4DigitPin();

    void onRequestOobRanging1M();

    void onRequestOobRanging2M();
}
