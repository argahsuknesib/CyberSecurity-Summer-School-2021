package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class gem implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.api.scene.pushlistener";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return geo.provideInstance();
    }
}
