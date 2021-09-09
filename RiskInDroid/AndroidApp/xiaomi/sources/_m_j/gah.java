package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.view.manager.OrbitViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.view.manager.OrbitViewModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class gah implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new OrbitViewModule(reactApplicationContext));
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OrbitViewManager());
        return arrayList;
    }
}
