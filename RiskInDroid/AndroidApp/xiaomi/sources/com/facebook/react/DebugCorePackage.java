package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;

class DebugCorePackage extends LazyReactPackage {
    DebugCorePackage() {
    }

    public List<ModuleSpec> getNativeModules(final ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ModuleSpec.nativeModuleSpec(JSCHeapCapture.class, new Provider<NativeModule>() {
            /* class com.facebook.react.DebugCorePackage.AnonymousClass1 */

            public NativeModule get() {
                return new JSCHeapCapture(reactApplicationContext);
            }
        }));
        return arrayList;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
    }
}
