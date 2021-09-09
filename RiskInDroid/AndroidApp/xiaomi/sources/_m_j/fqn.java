package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class fqn implements IPreModuleAware {
    public final String getModuleKey() {
        return "key.com.xiaomi.smarthome.device.manager.router";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return fqk.provideInstance();
    }
}
