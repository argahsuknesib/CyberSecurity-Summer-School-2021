package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.RNCameraManagerModule;
import java.util.ArrayList;
import java.util.List;

public final class gcc implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNCameraManagerModule(reactApplicationContext));
        return arrayList;
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CameraRouterFactory.getRNCameraApi().createRNCameraViewManager());
        arrayList.add(CameraRouterFactory.getRNCameraApi().createHSVideoViewManager());
        return arrayList;
    }
}
