package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class fts implements IPreModuleAware {
    public final String getModuleKey() {
        return "key.com.xiaomi.smarthome.login.ILoginApi";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return ftq.provideInstance();
    }
}
