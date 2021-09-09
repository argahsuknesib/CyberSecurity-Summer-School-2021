package com.xiaomi.smarthome.module;

import _m_j.gze;

public interface IPreModuleAware {
    gze getModuleClass();

    String getModuleKey();

    void onModuleCreate();
}
