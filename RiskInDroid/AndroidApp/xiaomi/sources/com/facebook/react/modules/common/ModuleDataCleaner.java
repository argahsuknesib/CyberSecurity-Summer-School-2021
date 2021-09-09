package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;

public class ModuleDataCleaner {

    public interface Cleanable {
        void clearSensitiveData();
    }

    public static void cleanDataFromModules(CatalystInstance catalystInstance) {
        for (NativeModule next : catalystInstance.getNativeModules()) {
            if (next instanceof Cleanable) {
                FLog.d("ReactNative", "Cleaning data from " + next.getName());
                ((Cleanable) next).clearSensitiveData();
            }
        }
    }
}
