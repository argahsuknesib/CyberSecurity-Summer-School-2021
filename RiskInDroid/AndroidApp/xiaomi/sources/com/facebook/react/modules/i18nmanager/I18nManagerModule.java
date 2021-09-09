package com.facebook.react.modules.i18nmanager;

import android.content.Context;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ReactModule(name = "I18nManager")
public class I18nManagerModule extends ContextBaseJavaModule {
    private final I18nUtil sharedI18nUtilInstance = I18nUtil.getInstance();

    public String getName() {
        return "I18nManager";
    }

    public I18nManagerModule(Context context) {
        super(context);
    }

    public Map<String, Object> getConstants() {
        Context context = getContext();
        Locale locale = context.getResources().getConfiguration().locale;
        HashMap newHashMap = MapBuilder.newHashMap();
        newHashMap.put("isRTL", Boolean.valueOf(this.sharedI18nUtilInstance.isRTL(context)));
        newHashMap.put("doLeftAndRightSwapInRTL", Boolean.valueOf(this.sharedI18nUtilInstance.doLeftAndRightSwapInRTL(context)));
        newHashMap.put("localeIdentifier", locale.toString());
        return newHashMap;
    }

    @ReactMethod
    public void allowRTL(boolean z) {
        this.sharedI18nUtilInstance.allowRTL(getContext(), z);
    }

    @ReactMethod
    public void forceRTL(boolean z) {
        this.sharedI18nUtilInstance.forceRTL(getContext(), z);
    }

    @ReactMethod
    public void swapLeftAndRightInRTL(boolean z) {
        this.sharedI18nUtilInstance.swapLeftAndRightInRTL(getContext(), z);
    }
}
