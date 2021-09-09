package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class fty implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.api.remote.pushlistener";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return fub.provideInstance();
    }
}
