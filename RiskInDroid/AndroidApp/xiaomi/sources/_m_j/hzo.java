package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class hzo implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.uwb_external.IUwbApiFactory";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return hzl.provideInstance();
    }
}
