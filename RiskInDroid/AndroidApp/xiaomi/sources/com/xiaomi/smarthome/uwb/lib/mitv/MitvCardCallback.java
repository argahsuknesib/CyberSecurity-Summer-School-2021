package com.xiaomi.smarthome.uwb.lib.mitv;

public interface MitvCardCallback {
    void initUI();

    void onLoginClick();

    void refreshUI();

    void saveMitvBleMac(String str);

    void setContentView();

    void startShowAni();
}
