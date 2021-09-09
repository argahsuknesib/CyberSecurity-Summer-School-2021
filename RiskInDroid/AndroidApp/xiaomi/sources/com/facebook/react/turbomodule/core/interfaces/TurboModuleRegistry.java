package com.facebook.react.turbomodule.core.interfaces;

import java.util.Collection;

public interface TurboModuleRegistry {
    TurboModule getModule(String str);

    Collection<TurboModule> getModules();

    boolean hasModule(String str);
}
