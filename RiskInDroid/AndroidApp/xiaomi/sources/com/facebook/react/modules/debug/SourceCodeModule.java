package com.facebook.react.modules.debug;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "SourceCode")
public class SourceCodeModule extends BaseJavaModule {
    private final ReactContext mReactContext;

    public String getName() {
        return "SourceCode";
    }

    public SourceCodeModule(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("scriptURL", (String) Assertions.assertNotNull(this.mReactContext.getCatalystInstance().getSourceURL(), "No source URL loaded, have you initialised the instance?"));
        return hashMap;
    }
}
