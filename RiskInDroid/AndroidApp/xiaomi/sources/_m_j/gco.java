package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.ColorPickerLightModule;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.RCTColorPickerManager;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.RCTWhitePickerManager;
import java.util.Arrays;
import java.util.List;

public final class gco implements ReactPackage {
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ColorPickerLightModule(reactApplicationContext));
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RCTWhitePickerManager(reactApplicationContext), new RCTColorPickerManager(reactApplicationContext));
    }
}
