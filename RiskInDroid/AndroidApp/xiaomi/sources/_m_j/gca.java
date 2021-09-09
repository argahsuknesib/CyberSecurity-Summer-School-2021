package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.blurview.BlurViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class gca implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return new ArrayList();
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new BlurViewManager());
    }
}
