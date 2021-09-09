package com.facebook.react.bridge;

import java.util.Map;

public abstract class BaseJavaModule implements NativeModule {
    public boolean canOverrideExistingModule() {
        return false;
    }

    public Map<String, Object> getConstants() {
        return null;
    }

    public boolean hasConstants() {
        return false;
    }

    public void initialize() {
    }

    public void invalidate() {
    }

    public void onCatalystInstanceDestroy() {
    }
}
