package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class gen implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.api.userbanner.pushlistener";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return gep.provideInstance();
    }
}
