package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_orientation.OrientationModule;
import java.util.Arrays;
import java.util.List;

public final class gaj implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new OrientationModule(reactApplicationContext));
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[0]);
    }
}
