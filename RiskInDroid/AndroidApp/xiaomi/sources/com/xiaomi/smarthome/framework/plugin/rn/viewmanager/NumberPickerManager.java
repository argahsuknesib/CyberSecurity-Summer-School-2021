package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.gbu;
import _m_j.gpc;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
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

public class NumberPickerManager extends SimpleViewManager {
    private static String REACT_CLASS = "MIOTNumberPicker";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public O000000o createViewInstance(ThemedReactContext themedReactContext) {
        O000000o o000000o = new O000000o(themedReactContext);
        o000000o.setPickerType(2);
        o000000o.setFocusable(true);
        o000000o.setTag(R.id.accessibility_role, ReactAccessibilityDelegate.AccessibilityRole.fromValue("adjustable"));
        return o000000o;
    }

    @ReactProp(name = "maxValue")
    public void setMaxValue(O000000o o000000o, float f) {
        o000000o.O00000Oo = f;
    }

    @ReactProp(defaultFloat = 0.0f, name = "minValue")
    public void setMinValue(O000000o o000000o, float f) {
        o000000o.O00000o0 = f;
    }

    @ReactProp(defaultFloat = 1.0f, name = "interval")
    public void setInterval(O000000o o000000o, float f) {
        o000000o.O00000o = f;
    }

    @ReactProp(name = "defaultValue")
    public void setDefaultValue(O000000o o000000o, float f) {
        o000000o.O00000oO = f;
        setAccessibilityLabel(o000000o, o000000o.O0000O0o);
    }

    @ReactProp(name = "valueFormat")
    public void setValueFormat(O000000o o000000o, String str) {
        o000000o.O00000oo = str;
    }

    @ReactProp(customType = "Color", name = "lineColor")
    public void setLineColor(O000000o o000000o, int i) {
        o000000o.f8510O000000o = String.valueOf(i);
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
        setAccessibilityLabel(o000000o, o000000o.O0000O0o);
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

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(O000000o o000000o, String str) {
        o000000o.O0000O0o = str;
        setAccessibilityLabel(o000000o, str, o000000o.O00000oO, o000000o.getUnit(), o000000o.O00000oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.BaseViewManager.setAccessibilityLabel(android.view.View, java.lang.String):void
     arg types: [com.xiaomi.smarthome.framework.plugin.rn.viewmanager.NumberPickerManager$O000000o, java.lang.String]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.NumberPickerManager.setAccessibilityLabel(com.xiaomi.smarthome.framework.plugin.rn.viewmanager.NumberPickerManager$O000000o, java.lang.String):void
      com.facebook.react.uimanager.BaseViewManager.setAccessibilityLabel(android.view.View, java.lang.String):void */
    public void setAccessibilityLabel(O000000o o000000o, String str, float f, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "%.0f";
        }
        super.setAccessibilityLabel((View) o000000o, str + " " + String.format(str3, Float.valueOf(f)) + " " + o000000o.getUnit());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.NumberPickerManager.O000000o.O000000o(float, int):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, int):int
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(boolean, long):void
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.NumberPickerManager.O000000o.O000000o(float, int):void */
    @ReactProp(name = "lineStyle")
    @Deprecated
    public void setLineStyle(O000000o o000000o, String str) {
        if (TextUtils.isEmpty(str) || "none".equalsIgnoreCase(str)) {
            o000000o.O000000o(0.0f, 0);
            return;
        }
        float f = 0.5f;
        if ("default".equalsIgnoreCase(str)) {
            o000000o.O000000o(0.5f, -7829368);
            return;
        }
        int indexOf = str.indexOf(44);
        if (indexOf > 0) {
            try {
                f = Float.parseFloat(str.substring(0, indexOf).trim());
                str = str.substring(indexOf + 1).trim();
            } catch (Exception unused) {
                return;
            }
        }
        o000000o.O000000o(f, Color.parseColor(str));
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onValueChanged", MapBuilder.of("registrationName", "onValueChanged")).put("onChangeStart", MapBuilder.of("registrationName", "onChangeStart")).build();
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, View view) {
        if (view instanceof O000000o) {
            ((O000000o) view).setOnValueChangedListener(new StringPicker.O0000OOo() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.NumberPickerManager.AnonymousClass1 */

                public final void O000000o(StringPicker stringPicker, int i, int i2) {
                }

                public final void O00000Oo(StringPicker stringPicker, int i, int i2) {
                    O000000o o000000o = (O000000o) stringPicker;
                    WritableMap createMap = Arguments.createMap();
                    float O000000o2 = o000000o.O000000o(i2);
                    createMap.putString("oldValue", Float.toString(o000000o.O000000o(i)));
                    createMap.putString("newValue", Float.toString(O000000o2));
                    ((RCTEventEmitter) ((ReactContext) stringPicker.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(stringPicker.getId(), "onValueChanged", createMap);
                    NumberPickerManager.this.setAccessibilityLabel(o000000o, o000000o.O0000O0o, O000000o2, stringPicker.getUnit(), o000000o.O00000oo);
                }

                public final void O00000o0(StringPicker stringPicker, int i, int i2) {
                    gbu.O000000o("MiotNumberPicker  onChangeStart...oldIndex=" + i + "  newIndex=" + i2);
                    ((RCTEventEmitter) ((ReactContext) stringPicker.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(stringPicker.getId(), "onChangeStart", Arguments.createMap());
                }
            });
        }
        super.addEventEmitters(themedReactContext, view);
    }

    public void onAfterUpdateTransaction(View view) {
        if (view != null && (view instanceof O000000o)) {
            ((O000000o) view).O000000o();
        }
        super.onAfterUpdateTransaction(view);
    }

    class O000000o extends StringPicker {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f8510O000000o;
        public float O00000Oo = 100.0f;
        public float O00000o = 1.0f;
        public float O00000o0 = 0.0f;
        public float O00000oO = 0.0f;
        public String O00000oo = null;
        public String O0000O0o = "";
        private boolean O000OO = false;
        private Paint O000OO0o;

        public O000000o(Context context) {
            super(context);
        }

        public final void O000000o() {
            int i;
            String str = this.f8510O000000o;
            boolean z = true;
            if (TextUtils.isEmpty(str)) {
                Paint paint = this.O000OO0o;
                if (paint != null) {
                    this.O000O0OO = paint;
                }
            } else {
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    gbu.O00000Oo("MHStringPicker  " + e.toString());
                    i = -7829368;
                }
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setColor(i);
                paint2.setStrokeWidth(0.5f);
                this.O000O0OO = paint2;
            }
            if (this.O00000o == 0.0f) {
                this.O00000o = 1.0f;
            }
            if (TextUtils.isEmpty(this.O00000oo)) {
                this.O00000oo = "%.0f";
            }
            this.O00oOoOo = Math.max(Math.max(Math.max(Math.max(Math.max(O000000o(this.O00000o0), O000000o(this.O00000Oo)), O000000o(this.O00000oO)), O000000o(this.O00000o0 + this.O00000o)), O000000o(this.O00000Oo + this.O00000o)), O000000o(this.O00000oO + this.O00000o));
            float f = (this.O00000Oo - this.O00000o0) / this.O00000o;
            if (f <= 0.0f) {
                z = false;
            }
            this.O000OO = z;
            int abs = Math.abs((int) f);
            setMinValue(0);
            setMaxValue(abs);
            setValue(Math.min(abs, Math.max((int) Math.abs((this.O00000oO - this.O00000o0) / this.O00000o), 0)));
            setFormatter(new StringPicker.O00000o0() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.NumberPickerManager.O000000o.AnonymousClass1 */

                public final String O000000o(int i) {
                    return String.format(O000000o.this.O00000oo, Float.valueOf(O000000o.this.O000000o(i)));
                }
            });
        }

        public final float O000000o(int i) {
            if (!this.O000OO) {
                i *= -1;
            }
            return this.O00000o0 + (((float) i) * this.O00000o);
        }

        /* access modifiers changed from: package-private */
        @Deprecated
        public final void O000000o(float f, int i) {
            this.O000OO0o = null;
            if (f > 1.0E-5f) {
                this.O000OO0o = new Paint();
                this.O000OO0o.setAntiAlias(true);
                this.O000OO0o.setColor(i);
                this.O000OO0o.setStrokeWidth(f);
            }
        }

        private float O000000o(float f) {
            return O00000Oo(String.format(this.O00000oo, Float.valueOf(f)));
        }
    }
}
