package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class fbc implements IPreModuleAware {
    public final String getModuleKey() {
        return "key.com.xiaomi.smarthome.card.core.provider.api";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return fav.provideInstance();
    }
}
