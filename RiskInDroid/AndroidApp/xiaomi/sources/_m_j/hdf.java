package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class hdf implements IPreModuleAware {
    public final String getModuleKey() {
        return "key.com.xiaomi.smarthome.card.spec.router.MiotSpecCardManager";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return hcz.provideInstance();
    }
}
