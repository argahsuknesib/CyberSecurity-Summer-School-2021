package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class hsb implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.assistant.IAssistantApi";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return hsa.provideInstance();
    }
}
