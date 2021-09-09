package com.facebook.react.fabric;

import java.util.HashMap;
import java.util.Map;

public class FabricComponents {
    private static final Map<String, String> sComponentNames;

    static {
        HashMap hashMap = new HashMap();
        sComponentNames = hashMap;
        hashMap.put("View", "RCTView");
        sComponentNames.put("Image", "RCTImageView");
        sComponentNames.put("ScrollView", "RCTScrollView");
        sComponentNames.put("Slider", "RCTSlider");
        sComponentNames.put("ModalHostView", "RCTModalHostView");
        sComponentNames.put("Paragraph", "RCTText");
        sComponentNames.put("Text", "RCText");
        sComponentNames.put("RawText", "RCTRawText");
        sComponentNames.put("ActivityIndicatorView", "AndroidProgressBar");
        sComponentNames.put("ShimmeringView", "RKShimmeringView");
        sComponentNames.put("TemplateView", "RCTTemplateView");
        sComponentNames.put("AxialGradientView", "RCTAxialGradientView");
    }

    static String getFabricComponentName(String str) {
        String str2 = sComponentNames.get(str);
        return str2 != null ? str2 : str;
    }
}
