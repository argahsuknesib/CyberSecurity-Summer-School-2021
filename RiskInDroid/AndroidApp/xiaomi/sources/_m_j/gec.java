package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class gec implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.push.IPushApi";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return gee.provideInstance();
    }
}
