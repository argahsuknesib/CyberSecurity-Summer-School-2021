package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class hde implements IPreModuleAware {
    public final String getModuleKey() {
        return "key.com.xiaomi.smarthome.card.api.router";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return hcw.provideInstance();
    }
}
