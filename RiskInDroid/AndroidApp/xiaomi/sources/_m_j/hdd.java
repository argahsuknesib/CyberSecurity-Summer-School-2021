package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class hdd implements IPreModuleAware {
    public final String getModuleKey() {
        return "key.com.xiaomi.smarthome.card.profile.router.ControlCardInfoManager";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return hcv.provideInstance();
    }
}
