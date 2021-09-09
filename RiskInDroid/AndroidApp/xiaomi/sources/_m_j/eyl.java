package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class eyl implements IPreModuleAware {
    public final String getModuleKey() {
        return "key.com.xiaomi.smarthome.card.main.router.MainPageOpManager";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return eyi.provideInstance();
    }
}
