package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.gbu;
import _m_j.gpc;
import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker;
import java.util.Map;

public class StringPickerManager extends SimpleViewManager {
    private static String REACT_CLASS = "MHStringPicker";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public O000000o createViewInstance(ThemedReactContext themedReactContext) {
        O000000o o000000o = new O000000o(themedReactContext);
        o000000o.setPickerType(1);
        o000000o.setFocusable(true);
        o000000o.setTag(R.id.accessibility_role, ReactAccessibilityDelegate.AccessibilityRole.fromValue("adjustable"));
        return o000000o;
    }

    @ReactProp(name = "defaultValue")
    public void setDefaultValue(O000000o o000000o, String str) {
        o000000o.f8522O000000o = str;
        setAccessibilityLabel(o000000o, o000000o.O00000o);
    }

    @ReactProp(name = "dataSource")
    public void setDataSource(O000000o o000000o, ReadableArray readableArray) {
        if (readableArray != null) {
            int size = readableArray.size();
            o000000o.O00000Oo = new String[size];
            for (int i = 0; i < size; i++) {
                o000000o.O00000Oo[i] = readableArray.getString(i);
            }
        }
    }

    @ReactProp(customType = "Color", name = "lineColor")
    public void setLineColor(O000000o o000000o, int i) {
        o000000o.O00000o0 = String.valueOf(i);
    }

    @ReactProp(customType = "Color", name = "textColor")
    public void setTextColor(O000000o o000000o, int i) {
        o000000o.setUnSelectTextColor(i);
    }

    @ReactProp(customType = "Color", name = "selectTextColor")
    public void setSelectTextColor(O000000o o000000o, int i) {
        o000000o.setSelectTextColor(i);
    }

    @ReactProp(name = "fontSize")
    public void setFontSize(O000000o o000000o, int i) {
        o000000o.setUnSelectTextSize(gpc.O00000Oo(o000000o.getContext(), (float) i));
    }

    @ReactProp(name = "selectFontSize")
    public void setSelectFontSize(O000000o o000000o, int i) {
        o000000o.setSelectTextSize(gpc.O00000Oo(o000000o.getContext(), (float) i));
    }

    @ReactProp(customType = "Color", name = "selectBgColor")
    public void setSelectBgColor(O000000o o000000o, int i) {
        o000000o.setSelectItemBgColor(i);
    }

    @ReactProp(name = "unit")
    public void setUnit(O000000o o000000o, String str) {
        o000000o.setUnit(str);
        setAccessibilityLabel(o000000o, o000000o.O00000o);
    }

    @ReactProp(name = "unitFontSize")
    public void setUnitFontSize(O000000o o000000o, int i) {
        o000000o.setUnitFontSize(gpc.O00000Oo(o000000o.getContext(), (float) i));
    }

    @ReactProp(customType = "Color", name = "unitTextColor")
    public void setUnitTextColor(O000000o o000000o, int i) {
        o000000o.setUnitTextColor(i);
    }

    @ReactProp(name = "accessible")
    public void setAccessible(O000000o o000000o, boolean z) {
        o000000o.setFocusable(z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.BaseViewManager.setAccessibilityLabel(android.view.View, java.lang.String):void
     arg types: [com.xiaomi.smarthome.framework.plugin.rn.viewmanager.StringPickerManager$O000000o, java.lang.String]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.StringPickerManager.setAccessibilityLabel(com.xiaomi.smarthome.framework.plugin.rn.viewmanager.StringPickerManager$O000000o, java.lang.String):void
      com.facebook.react.uimanager.BaseViewManager.setAccessibilityLabel(android.view.View, java.lang.String):void */
    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(O000000o o000000o, String str) {
        o000000o.O00000o = str;
        super.setAccessibilityLabel((View) o000000o, str + " " + o000000o.f8522O000000o + " " + o000000o.getUnit());
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onValueChanged", MapBuilder.of("registrationName", "onValueChanged")).put("onChangeStart", MapBuilder.of("registrationName", "onChangeStart")).put("onValueFastChanged", MapBuilder.of("registrationName", "onValueFastChanged")).build();
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, View view) {
        if (view instanceof O000000o) {
            gbu.O000000o("MHStringPicker addEventEmitters...");
            O000000o o000000o = (O000000o) view;
            o000000o.setOnValueChangedListener(o000000o.O00000oO);
        }
        super.addEventEmitters(themedReactContext, view);
    }

    public void onAfterUpdateTransaction(View view) {
        gbu.O000000o("MHStringPicker  onAfterUpdateTransaction...");
        if (view != null && (view instanceof O000000o)) {
            O000000o o000000o = (O000000o) view;
            if (!(o000000o.O00000Oo == null || o000000o.O00000Oo.length == 0)) {
                o000000o.O000000o();
                o000000o.O000000o(o000000o.O00000o0);
                o000000o.O0000Ooo = 0;
                o000000o.O0000o00 = o000000o.O00000Oo.length - 1;
                o000000o.O0000o0 = 0;
                o000000o.setDisplayedValues(o000000o.O00000Oo);
                o000000o.setMinValue(0);
                o000000o.setMaxValue(o000000o.O00000Oo.length - 1);
                int i = 0;
                while (true) {
                    if (i >= o000000o.O00000Oo.length) {
                        i = 0;
                        break;
                    } else if (o000000o.f8522O000000o.equalsIgnoreCase(o000000o.O00000Oo[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                o000000o.setValue(i);
                o000000o.O00000Oo();
                o000000o.setWrapSelectorWheel(false);
            }
        }
        super.onAfterUpdateTransaction(view);
    }

    class O000000o extends StringPicker {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f8522O000000o = "";
        public String[] O00000Oo = null;
        public String O00000o = "";
        public String O00000o0;
        public StringPicker.O0000OOo O00000oO = new StringPicker.O0000OOo() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.StringPickerManager.O000000o.AnonymousClass1 */

            public final void O000000o(StringPicker stringPicker, int i, int i2) {
                gbu.O000000o("MHStringPicker  onValueChange...   newIndex=".concat(String.valueOf(i2)));
                O000000o o000000o = (O000000o) stringPicker;
                String O000000o2 = o000000o.O000000o(i);
                String O000000o3 = o000000o.O000000o(i2);
                gbu.O000000o("MHStringPicker  onLastValueChange...  oldValue=" + O000000o2 + "  newIndex=" + i2 + "  newValue=" + O000000o3);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("oldValue", O000000o2);
                createMap.putString("newValue", O000000o3);
                ((RCTEventEmitter) ((ReactContext) o000000o.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onValueFastChanged", createMap);
            }

            public final void O00000Oo(StringPicker stringPicker, int i, int i2) {
                O000000o o000000o = (O000000o) stringPicker;
                String O000000o2 = o000000o.O000000o(i);
                String O000000o3 = o000000o.O000000o(i2);
                gbu.O000000o("MHStringPicker  onLastValueChange...  oldValue=" + O000000o2 + "  newIndex=" + i2 + "  newValue=" + O000000o3);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("oldValue", O000000o2);
                createMap.putString("newValue", O000000o3);
                ((RCTEventEmitter) ((ReactContext) o000000o.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onValueChanged", createMap);
                O000000o.super.setAccessibilityLabel(o000000o, O000000o.this.O00000o + " " + O000000o3 + " " + o000000o.getUnit());
            }

            public final void O00000o0(StringPicker stringPicker, int i, int i2) {
                O000000o o000000o = (O000000o) stringPicker;
                gbu.O000000o("MHStringPicker  onChangeStart...oldIndex=" + i + "  newIndex=" + i2);
                ((RCTEventEmitter) ((ReactContext) o000000o.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onChangeStart", Arguments.createMap());
            }
        };

        public final String O000000o(int i) {
            if (i < 0) {
                gbu.O00000Oo("StringPickerNanager   index is smaller than 0");
                return "";
            }
            String[] strArr = this.O00000Oo;
            if (strArr != null && strArr.length > 0 && strArr.length > i) {
                return strArr[i];
            }
            gbu.O00000Oo("StringPickerNanager  dataSource is null");
            return "";
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.O0000oo0 = false;
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            String str = "";
            int i = 0;
            while (true) {
                String[] strArr = this.O00000Oo;
                if (i < strArr.length) {
                    if (strArr[i].length() > str.length()) {
                        str = this.O00000Oo[i];
                    }
                    i++;
                } else {
                    this.O00oOoOo = O00000Oo(str);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(String str) {
            int i;
            if (!TextUtils.isEmpty(str)) {
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    gbu.O00000Oo("MHStringPicker  " + e.toString());
                    i = -7829368;
                }
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setColor(i);
                paint.setStrokeWidth(0.5f);
                this.O000O0OO = paint;
            }
        }

        public O000000o(Context context) {
            super(context);
        }
    }
}
