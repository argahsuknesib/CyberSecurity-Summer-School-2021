package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class fqo implements IPreModuleAware {
    public final String getModuleKey() {
        return "key.com.xiaomi.smarthome.device.wrapper.router";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return fql.provideInstance();
    }
}
