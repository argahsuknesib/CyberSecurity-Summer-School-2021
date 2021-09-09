package com.xiaomi.smarthome.camera.api;

import _m_j.gze;
import com.xiaomi.smarthome.module.IPreModuleAware;

public class PreModuleAwareCameraManagerApi implements IPreModuleAware {
    public String getModuleKey() {
        return "com.xiaomi.smarthome.camera.api.ICameraManagerApi";
    }

    public void onModuleCreate() {
    }

    public gze getModuleClass() {
        return CameraManagerApiImpl.provideInstance();
    }
}
