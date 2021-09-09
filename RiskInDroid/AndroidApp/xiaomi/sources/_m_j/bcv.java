package _m_j;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.imagepicker.ImagePickerModule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class bcv implements ReactPackage {

    /* renamed from: O000000o */
    public static final int DefaultExplainingPermissionsTheme = 2132738349;
    private final int O00000Oo = DefaultExplainingPermissionsTheme;

    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ImagePickerModule(reactApplicationContext, this.O00000Oo));
    }

    public final List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
