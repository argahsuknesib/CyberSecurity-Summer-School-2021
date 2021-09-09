package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.view.manager;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.view.widget.OrbitView;

public class OrbitViewModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "MHOrbitViewManager";
    }

    public OrbitViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void canRevoke(final int i, final Callback callback) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.view.manager.OrbitViewModule.AnonymousClass1 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                callback.invoke(Boolean.valueOf(((OrbitView) nativeViewHierarchyManager.resolveView(i)).O000000o()));
            }
        });
    }
}
