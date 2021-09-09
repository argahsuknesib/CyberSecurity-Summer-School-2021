package com.facebook.react.uimanager;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.systrace.SystraceMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UIManagerModuleConstantsHelper {
    UIManagerModuleConstantsHelper() {
    }

    static Map<String, Object> createConstants(UIManagerModule.ViewManagerResolver viewManagerResolver) {
        Map<String, Object> constants = UIManagerModuleConstants.getConstants();
        if (!ReactFeatureFlags.lazilyLoadViewManagers) {
            constants.put("ViewManagerNames", viewManagerResolver.getViewManagerNames());
        }
        constants.put("LazyViewManagersEnabled", Boolean.TRUE);
        return constants;
    }

    static Map<String, Object> getDefaultExportableEventTypes() {
        return MapBuilder.of("bubblingEventTypes", UIManagerModuleConstants.getBubblingEventTypeConstants(), "directEventTypes", UIManagerModuleConstants.getDirectEventTypeConstants());
    }

    static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        Map<String, Object> constants = UIManagerModuleConstants.getConstants();
        Map bubblingEventTypeConstants = UIManagerModuleConstants.getBubblingEventTypeConstants();
        Map directEventTypeConstants = UIManagerModuleConstants.getDirectEventTypeConstants();
        if (map != null) {
            map.putAll(bubblingEventTypeConstants);
        }
        if (map2 != null) {
            map2.putAll(directEventTypeConstants);
        }
        for (ViewManager next : list) {
            String name = next.getName();
            SystraceMessage.beginSection(0, "UIManagerModuleConstantsHelper.createConstants").arg("ViewManager", name).arg("Lazy", Boolean.FALSE).flush();
            try {
                Map<String, Object> createConstantsForViewManager = createConstantsForViewManager(next, null, null, map, map2);
                if (!createConstantsForViewManager.isEmpty()) {
                    constants.put(name, createConstantsForViewManager);
                }
            } finally {
                SystraceMessage.endSection(0);
            }
        }
        constants.put("genericBubblingEventTypes", bubblingEventTypeConstants);
        constants.put("genericDirectEventTypes", directEventTypeConstants);
        return constants;
    }

    static Map<String, Object> createConstantsForViewManager(ViewManager viewManager, Map map, Map map2, Map map3, Map map4) {
        HashMap newHashMap = MapBuilder.newHashMap();
        Map<String, Object> exportedCustomBubblingEventTypeConstants = viewManager.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants != null) {
            recursiveMerge(map3, exportedCustomBubblingEventTypeConstants);
            recursiveMerge(exportedCustomBubblingEventTypeConstants, map);
            newHashMap.put("bubblingEventTypes", exportedCustomBubblingEventTypeConstants);
        } else if (map != null) {
            newHashMap.put("bubblingEventTypes", map);
        }
        Map<String, Object> exportedCustomDirectEventTypeConstants = viewManager.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants != null) {
            recursiveMerge(map4, exportedCustomDirectEventTypeConstants);
            recursiveMerge(exportedCustomDirectEventTypeConstants, map2);
            newHashMap.put("directEventTypes", exportedCustomDirectEventTypeConstants);
        } else if (map2 != null) {
            newHashMap.put("directEventTypes", map2);
        }
        Map<String, Object> exportedViewConstants = viewManager.getExportedViewConstants();
        if (exportedViewConstants != null) {
            newHashMap.put("Constants", exportedViewConstants);
        }
        Map<String, Integer> commandsMap = viewManager.getCommandsMap();
        if (commandsMap != null) {
            newHashMap.put("Commands", commandsMap);
        }
        Map<String, String> nativeProps = viewManager.getNativeProps();
        if (!nativeProps.isEmpty()) {
            newHashMap.put("NativeProps", nativeProps);
        }
        return newHashMap;
    }

    private static void recursiveMerge(Map map, Map map2) {
        if (map != null && map2 != null && !map2.isEmpty()) {
            for (Object next : map2.keySet()) {
                Object obj = map2.get(next);
                Object obj2 = map.get(next);
                if (obj2 == null || !(obj instanceof Map) || !(obj2 instanceof Map)) {
                    map.put(next, obj);
                } else {
                    recursiveMerge((Map) obj2, (Map) obj);
                }
            }
        }
    }
}
