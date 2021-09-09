package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper.MiotMapSweeperModule;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper.MiotMapSweeperViewManager;
import java.util.ArrayList;
import java.util.List;

public final class gct implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MiotMapSweeperModule(reactApplicationContext));
        return arrayList;
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MiotMapSweeperViewManager());
        return arrayList;
    }
}