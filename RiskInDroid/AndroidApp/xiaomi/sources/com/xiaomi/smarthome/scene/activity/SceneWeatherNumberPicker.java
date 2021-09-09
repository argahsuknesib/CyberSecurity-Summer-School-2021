package com.xiaomi.smarthome.scene.activity;

import _m_j.fju;
import _m_j.fjw;
import _m_j.fkv;
import _m_j.gwr;
import _m_j.gwu;
import _m_j.hpc;
import _m_j.hpq;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.NumberPicker;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import com.xiaomi.smarthome.scene.bean.WeatherConditionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class SceneWeatherNumberPicker extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    hpc f10879O000000o;
    Object O00000Oo;
    private float O00000o;
    Object O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private ArrayList<CommonSceneOnline.NumberPickerTag> O0000OOo = null;
    private int O0000Oo0 = -1;
    public String mDegree;
    public ArrayList<String> mDisplayIndexList = new ArrayList<>();
    public String mJsonTag = null;
    public float mMaxValue;
    public float mMinValue;
    public NumberPicker mNumberPicker;
    public ArrayList<String> mShowTags = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        boolean z;
        CommonSceneOnline.NumberPickerTag next;
        super.onCreate(bundle);
        setContentView((int) R.layout.scene_number_picker);
        this.f10879O000000o = hpq.O000000o().O0000OoO;
        if (this.f10879O000000o == null) {
            finish();
        }
        this.mMaxValue = getIntent().getFloatExtra("max_value", 0.0f);
        this.mMinValue = getIntent().getFloatExtra("min_value", 0.0f);
        this.O00000oo = getIntent().getFloatExtra("interval", 1.0f);
        this.mDegree = getIntent().getStringExtra("degree");
        this.mJsonTag = getIntent().getStringExtra("json_tag");
        this.O0000O0o = getIntent().getFloatExtra("default_value", 0.0f);
        this.O0000OOo = getIntent().getParcelableArrayListExtra("show_tags");
        String stringExtra = getIntent().getStringExtra("title");
        if (getIntent().hasExtra("last_value")) {
            String stringExtra2 = getIntent().getStringExtra("last_value");
            if (!TextUtils.isEmpty(this.mJsonTag)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra2);
                    if (this.mJsonTag.equalsIgnoreCase("max")) {
                        this.O0000O0o = (float) jSONObject.optDouble("min");
                    } else {
                        this.O0000O0o = (float) jSONObject.optDouble("max");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (TextUtils.equals("℃", this.mDegree)) {
            Pair<String, fkv<Object, Object>> O00000Oo2 = fju.O000000o().O00000Oo("℃");
            this.mDegree = (String) O00000Oo2.first;
            if (TextUtils.equals(this.mDegree, "°F")) {
                if (this.mMaxValue < 100.0f) {
                    this.O00000o = (float) Math.floor((double) ((Float) ((fkv) O00000Oo2.second).call(Float.valueOf(this.mMaxValue))).floatValue());
                } else {
                    this.O00000o = 212.0f;
                }
                if (this.mMinValue > -30.0f) {
                    this.O00000oO = (float) Math.ceil((double) ((Float) ((fkv) O00000Oo2.second).call(Float.valueOf(this.mMinValue))).floatValue());
                } else {
                    this.O00000oO = -22.0f;
                }
                this.O00000oo = 1.0f;
                this.O0000O0o = ((Float) ((fkv) O00000Oo2.second).call(Float.valueOf(this.O0000O0o))).floatValue();
            } else {
                this.O00000o = this.mMaxValue;
                this.O00000oO = this.mMinValue;
            }
        } else {
            this.O00000o = this.mMaxValue;
            this.O00000oO = this.mMinValue;
        }
        this.mNumberPicker = (NumberPicker) findViewById(R.id.scene_number_picker);
        float f = this.O00000oO;
        if (f >= this.O00000o) {
            z = false;
        } else {
            while (true) {
                float f2 = this.O00000o;
                if (f > f2 && ((double) Math.abs(f - f2)) >= 1.0E-4d) {
                    break;
                }
                int i = (int) f;
                if (((double) Math.abs(((float) i) - f)) < 1.0E-4d) {
                    this.mDisplayIndexList.add(String.format(Locale.US, "%d", Integer.valueOf(i)));
                } else {
                    this.mDisplayIndexList.add(String.format(Locale.US, "%.1f", Float.valueOf(f)));
                }
                if (((double) Math.abs(f - this.O0000O0o)) < 1.0E-4d) {
                    this.O0000Oo0 = this.mDisplayIndexList.size() - 1;
                }
                String str = "";
                ArrayList<CommonSceneOnline.NumberPickerTag> arrayList = this.O0000OOo;
                if (arrayList != null) {
                    Iterator<CommonSceneOnline.NumberPickerTag> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        next = it.next();
                        if (((double) Math.abs(f - next.f10656O000000o)) < 1.0E-4d || ((double) Math.abs(f - next.O00000Oo)) < 1.0E-4d || (f > next.f10656O000000o && f < next.O00000Oo)) {
                            str = str + next.O00000o0;
                        }
                    }
                    str = str + next.O00000o0;
                }
                this.mShowTags.add(str);
                f += this.O00000oo;
            }
            z = true;
        }
        if (!z) {
            finish();
            return;
        }
        String[] strArr = new String[this.mDisplayIndexList.size()];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = this.mDisplayIndexList.get(i2);
        }
        this.mNumberPicker.setMinValue(0);
        this.mNumberPicker.setMaxValue(this.mDisplayIndexList.size() - 1);
        this.mNumberPicker.setDisplayedValues(strArr);
        this.mNumberPicker.setWrapSelectorWheel(true);
        int i3 = this.O0000Oo0;
        if (i3 != -1) {
            this.mNumberPicker.setValue(i3);
            this.mNumberPicker.setLabel(this.mDegree + "  " + this.mShowTags.get(this.O0000Oo0));
        } else {
            this.mNumberPicker.setValue(0);
            this.mNumberPicker.setLabel(this.mDegree + "  " + this.mShowTags.get(0));
        }
        this.mNumberPicker.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.scene.activity.SceneWeatherNumberPicker.AnonymousClass1 */

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                NumberPicker numberPicker2 = SceneWeatherNumberPicker.this.mNumberPicker;
                numberPicker2.setLabel(SceneWeatherNumberPicker.this.mDegree + "  " + SceneWeatherNumberPicker.this.mShowTags.get(i2));
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneWeatherNumberPicker.AnonymousClass2 */

            public final void onClick(View view) {
                SceneWeatherNumberPicker.this.setResult(0);
                SceneWeatherNumberPicker.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.module_a_3_right_text_btn);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(stringExtra);
        textView.setText((int) R.string.mj_complete);
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneWeatherNumberPicker.AnonymousClass3 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void
             arg types: [com.xiaomi.smarthome.scene.activity.SceneWeatherNumberPicker, com.xiaomi.smarthome.scene.activity.SceneWeatherNumberPicker$3$1]
             candidates:
              _m_j.gwu.O000000o(android.content.Context, android.location.Address):_m_j.gwr
              _m_j.gwu.O000000o(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
              _m_j.gwu.O000000o(android.content.Context, _m_j.gwu$O000000o):void
              _m_j.gwu.O000000o(android.content.Context, java.lang.String):void
              _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void */
            public final void onClick(View view) {
                String str = SceneWeatherNumberPicker.this.mDisplayIndexList.get(SceneWeatherNumberPicker.this.mNumberPicker.getValue());
                float floatValue = Float.valueOf(str).floatValue();
                SceneWeatherNumberPicker.this.O00000o0 = Float.valueOf(floatValue);
                int i = (int) floatValue;
                if (((double) Math.abs(((float) i) - floatValue)) < 1.0E-4d) {
                    SceneWeatherNumberPicker.this.O00000o0 = Integer.valueOf(i);
                }
                SceneWeatherNumberPicker sceneWeatherNumberPicker = SceneWeatherNumberPicker.this;
                sceneWeatherNumberPicker.O00000Oo = sceneWeatherNumberPicker.getResultByUnit(str);
                if (!TextUtils.isEmpty(SceneWeatherNumberPicker.this.mJsonTag)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (SceneWeatherNumberPicker.this.mJsonTag.equals("max")) {
                            jSONObject.put("min", SceneWeatherNumberPicker.this.O00000Oo);
                            jSONObject.put("max", (double) SceneWeatherNumberPicker.this.mMaxValue);
                        } else {
                            jSONObject.put("min", (double) SceneWeatherNumberPicker.this.mMinValue);
                            jSONObject.put("max", SceneWeatherNumberPicker.this.O00000Oo);
                        }
                        SceneWeatherNumberPicker.this.f10879O000000o.O0000Oo0 = jSONObject;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    SceneWeatherNumberPicker.this.f10879O000000o.O0000Oo0 = SceneWeatherNumberPicker.this.O00000Oo;
                }
                if (SceneWeatherNumberPicker.this.O00000Oo instanceof Integer) {
                    SceneWeatherNumberPicker.this.f10879O000000o.O0000Oo = ((Integer) SceneWeatherNumberPicker.this.O00000Oo).intValue();
                }
                gwu.O000000o((Activity) SceneWeatherNumberPicker.this, (gwu.O000000o) new gwu.O000000o() {
                    /* class com.xiaomi.smarthome.scene.activity.SceneWeatherNumberPicker.AnonymousClass3.AnonymousClass1 */

                    public final void O000000o(String str, String str2) {
                        SceneWeatherNumberPicker.this.fillInnerCondition(str2, str);
                        SceneWeatherNumberPicker.this.complete();
                    }

                    public final void O000000o(Context context, Address address) {
                        gwr O000000o2 = gwu.O000000o(context, address);
                        SceneWeatherNumberPicker.this.fillInnerCondition(O000000o2.O00000oo, O000000o2.O00000oO);
                        SceneWeatherNumberPicker.this.complete();
                    }
                });
            }
        });
    }

    public void fillInnerCondition(String str, String str2) {
        hpc hpc = this.f10879O000000o;
        if (hpc != null) {
            hpc.O0000O0o = str;
            hpc.O00000oo = str2;
            String str3 = null;
            if (hpc.O00000o == WeatherConditionType.TYPE_ABOVE_HUMIDITY.conditionId) {
                str3 = getResources().getString(R.string.humidity_above_format);
            } else if (this.f10879O000000o.O00000o == WeatherConditionType.TYPE_LESS_HUMIDITY.conditionId) {
                str3 = getResources().getString(R.string.humidity_less_format);
            } else if (this.f10879O000000o.O00000o == WeatherConditionType.TYPE_ABOVE_TEMPERATURE.conditionId) {
                str3 = getResources().getString(R.string.temperature_above_format);
            } else if (this.f10879O000000o.O00000o == WeatherConditionType.TYPE_LESS_TEMPERATURE.conditionId) {
                str3 = getResources().getString(R.string.temperature_less_format);
            } else if (this.f10879O000000o.O00000o == WeatherConditionType.TYPE_ABOVE_AQI.conditionId) {
                str3 = getResources().getString(R.string.aqi_above_format);
            } else if (this.f10879O000000o.O00000o == WeatherConditionType.TYPE_LESS_AQI.conditionId) {
                str3 = getResources().getString(R.string.aqi_less_format);
            }
            if (str3 != null) {
                if (TextUtils.equals("°F", this.mDegree)) {
                    if (str3.contains("℃")) {
                        str3 = str3.replace("℃", "°F");
                    }
                    if (str3.contains("°C")) {
                        str3 = str3.replace("°C", "°F");
                    }
                }
                hpc hpc2 = this.f10879O000000o;
                hpc2.O0000OOo = String.format(str3, hpc2.O00000oo, this.O00000o0);
            }
        }
    }

    public Object getResultByUnit(String str) {
        float floatValue = Float.valueOf(str).floatValue();
        Object valueOf = Float.valueOf(floatValue);
        int i = (int) floatValue;
        if (((double) Math.abs(((float) i) - floatValue)) < 1.0E-4d) {
            valueOf = Integer.valueOf(i);
        }
        return TextUtils.equals(this.mDegree, "°F") ? ((fkv) fjw.O00000Oo.get("°F").get("℃")).call(valueOf) : valueOf;
    }

    public void complete() {
        setResult(-1);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
