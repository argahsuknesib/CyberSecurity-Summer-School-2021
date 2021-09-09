package _m_j;

import com.xiaomi.smarthome.module.IPreModuleAware;

public final class gfv implements IPreModuleAware {
    public final String getModuleKey() {
        return "com.xiaomi.smarthome.globalshop.IGlobalShopApi";
    }

    public final void onModuleCreate() {
    }

    public final gze getModuleClass() {
        return gfs.provideInstance();
    }
}
