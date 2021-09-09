package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class eym implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.push-fcm-external.IPushFcmApi";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return eyn.provideInstance();
    }
}
