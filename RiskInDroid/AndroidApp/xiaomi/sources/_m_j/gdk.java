package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class gdk implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return new ArrayList();
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(CameraRouterFactory.getRNCameraApi().createRTSPViewManager());
    }
}
