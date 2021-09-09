package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.ImageFactoryModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.PickImageModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class fzm implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PickImageModule(reactApplicationContext));
        arrayList.add(new ImageFactoryModule(reactApplicationContext));
        return arrayList;
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
