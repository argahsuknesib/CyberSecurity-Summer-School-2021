package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class ghu implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.usercenter.IUserCenterApi";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return gid.provideInstance();
    }
}
