package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker;

import _m_j.gbu;
import android.graphics.Color;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.ColorPicker;
import java.util.Map;

public class RCTColorPickerManager extends SimpleViewManager {
    private ReactApplicationContext mCallerContext;

    public String getName() {
        return "RCTColorPickerView";
    }

    public RCTColorPickerManager(ReactApplicationContext reactApplicationContext) {
        this.mCallerContext = reactApplicationContext;
    }

    public View createViewInstance(final ThemedReactContext themedReactContext) {
        final ColorPicker colorPicker = new ColorPicker(themedReactContext);
        colorPicker.setFocusable(true);
        colorPicker.setTag(R.id.accessibility_role, ReactAccessibilityDelegate.AccessibilityRole.fromValue("adjustable"));
        colorPicker.setColorPickerListener(new ColorPicker.O00000Oo() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.colorpicker.RCTColorPickerManager.AnonymousClass1 */

            public final void O000000o() {
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(colorPicker.getId(), "initialized", Arguments.createMap());
            }

            public final void O000000o(int i, String str) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("color", String.format("#%06x", Integer.valueOf(i & 16777215)));
                createMap.putString("trackType", str);
                if ("endTracking".equals(str)) {
                    RCTColorPickerManager rCTColorPickerManager = RCTColorPickerManager.this;
                    ColorPicker colorPicker = colorPicker;
                    RCTColorPickerManager.super.setAccessibilityLabel(colorPicker, colorPicker.getAccessibilityLabel());
                }
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(colorPicker.getId(), "colorChange", createMap);
            }
        });
        return colorPicker;
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put("colorChange", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onColorChange")));
        builder.put("initialized", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onInit")));
        return builder.build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("showColor", 1, "configDrawPicker", 2);
    }

    @ReactProp(name = "accessible")
    public void setAccessible(View view, boolean z) {
        view.setFocusable(z);
    }

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(View view, String str) {
        if (view instanceof ColorPicker) {
            ColorPicker colorPicker = (ColorPicker) view;
            colorPicker.setJsAccessibilityLabel(str);
            str = colorPicker.getAccessibilityLabel();
        }
        super.setAccessibilityLabel(view, str);
    }

    public void receiveCommand(View view, int i, ReadableArray readableArray) {
        gbu.O000000o(String.format(": int command id: %d", Integer.valueOf(i)));
        try {
            if ((view instanceof ColorPicker) && readableArray != null) {
                if (i != 1) {
                    if (i == 2) {
                        gbu.O000000o("receiveCommand: configDrawPicker, args: ".concat(String.valueOf(readableArray)));
                        if (readableArray.size() == 3 && !readableArray.isNull(0) && !readableArray.isNull(2)) {
                            ReadableArray array = readableArray.getArray(0);
                            ReadableArray array2 = readableArray.getArray(1);
                            double d = readableArray.getDouble(2);
                            if (d > 0.0d) {
                                if (d <= 25.0d) {
                                    ((ColorPicker) view).O000000o(array, array2, d);
                                    return;
                                }
                            }
                            gbu.O00000Oo("blur radius out of range, Supported range 0 < radius <= 25");
                        }
                    }
                } else if (!readableArray.isNull(0)) {
                    ((ColorPicker) view).setColor(Color.parseColor(readableArray.getString(0)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiveCommand(View view, String str, ReadableArray readableArray) {
        gbu.O000000o(String.format(": string command id: %s", str));
        try {
            if ((view instanceof ColorPicker) && readableArray != null) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1929332122) {
                    if (hashCode == -1027943468) {
                        if (str.equals("configDrawPicker")) {
                            c = 1;
                        }
                    }
                } else if (str.equals("showColor")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c == 1) {
                        gbu.O000000o("receiveCommand: configDrawPicker, args: ".concat(String.valueOf(readableArray)));
                        if (readableArray.size() == 3 && !readableArray.isNull(0) && readableArray.getArray(0).size() > 0) {
                            if (!readableArray.isNull(2)) {
                                ReadableArray array = readableArray.getArray(0);
                                ReadableArray array2 = readableArray.getArray(1);
                                double d = readableArray.getDouble(2);
                                if (d > 0.0d) {
                                    if (d <= 25.0d) {
                                        ((ColorPicker) view).O000000o(array, array2, d);
                                        return;
                                    }
                                }
                                gbu.O00000Oo("blur radius out of range, Supported range 0 < radius <= 25");
                                return;
                            }
                        }
                        gbu.O00000Oo("some arguments are null or invalid");
                    }
                } else if (!readableArray.isNull(0)) {
                    ((ColorPicker) view).setColor(Color.parseColor(readableArray.getString(0)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
