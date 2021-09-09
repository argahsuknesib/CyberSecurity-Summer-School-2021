package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class gta implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.log_external.GlobalMijiaLogFactory";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return gsw.provideInstance();
    }
}
