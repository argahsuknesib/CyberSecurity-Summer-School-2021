package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3.CvCameraModule;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3.CvCameraViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3.RNOpencv3Module;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class gdh implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RNOpencv3Module(reactApplicationContext), new CvCameraModule(reactApplicationContext));
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new CvCameraViewManager());
    }
}
