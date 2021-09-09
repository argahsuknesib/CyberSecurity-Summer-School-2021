package com.xiaomi.smarthome.scene.activity;

import _m_j.fju;
import _m_j.fjw;
import _m_j.fkv;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.NumberPicker;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SceneNumberPicker extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f10850O000000o;
    private float O00000Oo;
    private float O00000o;
    private float O00000o0;
    private ArrayList<CommonSceneOnline.NumberPickerTag> O00000oO = null;
    private int O00000oo = -1;
    public JSONObject initValue;
    public String mDegree;
    public ArrayList<String> mDisplayIndexList = new ArrayList<>();
    public String mFormatter = null;
    public String mJsonTag = null;
    public float mMaxValue;
    public float mMinValue;
    public NumberPicker mNumberPicker;
    public ArrayList<String> mShowTags = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setContentView((int) R.layout.scene_number_picker);
        this.mMaxValue = getIntent().getFloatExtra("max_value", 0.0f);
        this.mMinValue = getIntent().getFloatExtra("min_value", 0.0f);
        this.O00000o0 = getIntent().getFloatExtra("interval", 1.0f);
        this.mDegree = getIntent().getStringExtra("degree");
        this.mJsonTag = getIntent().getStringExtra("json_tag");
        this.O00000o = getIntent().getFloatExtra("default_value", 0.0f);
        this.O00000oO = getIntent().getParcelableArrayListExtra("show_tags");
        String stringExtra = getIntent().getStringExtra("title");
        this.mFormatter = getIntent().getStringExtra("formatter");
        fixPrecentFormat();
        if (getIntent().hasExtra("init_value")) {
            try {
                JSONArray jSONArray = new JSONArray(getIntent().getStringExtra("init_value"));
                if (jSONArray.length() > 0) {
                    this.initValue = jSONArray.optJSONObject(0);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (getIntent().hasExtra("last_value")) {
            String stringExtra2 = getIntent().getStringExtra("last_value");
            if (!TextUtils.isEmpty(this.mJsonTag)) {
                if (this.mJsonTag.equalsIgnoreCase("equal")) {
                    try {
                        this.O00000o = Float.valueOf(stringExtra2).floatValue();
                    } catch (NumberFormatException unused) {
                    }
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra2);
                        if (this.mJsonTag.equalsIgnoreCase("max")) {
                            this.O00000o = (float) jSONObject.optDouble("min");
                        } else {
                            this.O00000o = (float) jSONObject.optDouble("max");
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (TextUtils.equals("℃", this.mDegree)) {
            Pair<String, fkv<Object, Object>> O00000Oo2 = fju.O000000o().O00000Oo("℃");
            this.mDegree = (String) O00000Oo2.first;
            if (TextUtils.equals(this.mDegree, "°F")) {
                if (this.mMaxValue < 100.0f) {
                    this.f10850O000000o = (float) Math.floor((double) ((Float) ((fkv) O00000Oo2.second).call(Float.valueOf(this.mMaxValue))).floatValue());
                } else {
                    this.f10850O000000o = 212.0f;
                }
                if (this.mMinValue > -30.0f) {
                    this.O00000Oo = (float) Math.ceil((double) ((Float) ((fkv) O00000Oo2.second).call(Float.valueOf(this.mMinValue))).floatValue());
                } else {
                    this.O00000Oo = -22.0f;
                }
                this.O00000o0 = 1.0f;
                this.O00000o = (float) Math.round(((Float) ((fkv) O00000Oo2.second).call(Float.valueOf(this.O00000o))).floatValue());
            } else {
                this.f10850O000000o = this.mMaxValue;
                this.O00000Oo = this.mMinValue;
            }
        } else {
            this.f10850O000000o = this.mMaxValue;
            this.O00000Oo = this.mMinValue;
        }
        this.mNumberPicker = (NumberPicker) findViewById(R.id.scene_number_picker);
        if (this.O00000Oo >= this.f10850O000000o) {
            z = false;
        } else {
            double d = (double) this.mMinValue;
            int i = (this.O00000o0 * 100.0f) % 10.0f == 0.0f ? 1 : 2;
            while (true) {
                float f = this.f10850O000000o;
                if (d > ((double) f) && Math.abs(O000000o(d, (double) f)) >= 1.0E-4d) {
                    break;
                }
                int i2 = (int) d;
                double d2 = (double) i2;
                Double.isNaN(d2);
                if (Math.abs(d2 - d) < 1.0E-4d) {
                    this.mDisplayIndexList.add(String.format("%d", Integer.valueOf(i2)));
                } else {
                    this.mDisplayIndexList.add(String.format("%." + i + "f", Double.valueOf(d)));
                }
                if (Math.abs(O000000o(d, (double) this.O00000o)) < 1.0E-4d) {
                    this.O00000oo = this.mDisplayIndexList.size() - 1;
                }
                String str = "";
                ArrayList<CommonSceneOnline.NumberPickerTag> arrayList = this.O00000oO;
                if (arrayList != null) {
                    Iterator<CommonSceneOnline.NumberPickerTag> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CommonSceneOnline.NumberPickerTag next = it.next();
                        if (Math.abs(O000000o(d, (double) next.f10656O000000o)) < 1.0E-4d || Math.abs(O000000o(d, (double) next.O00000Oo)) < 1.0E-4d || (d > ((double) next.f10656O000000o) && d < ((double) next.O00000Oo))) {
                            str = str + next.O00000o0;
                        }
                    }
                }
                this.mShowTags.add(str);
                double d3 = (double) this.O00000o0;
                Double.isNaN(d3);
                d += d3;
            }
            z = true;
        }
        if (!z) {
            finish();
            return;
        }
        String[] strArr = new String[this.mDisplayIndexList.size()];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr[i3] = this.mDisplayIndexList.get(i3);
        }
        this.mNumberPicker.setMinValue(0);
        this.mNumberPicker.setMaxValue(this.mDisplayIndexList.size() - 1);
        this.mNumberPicker.setDisplayedValues(strArr);
        this.mNumberPicker.setWrapSelectorWheel(true);
        int i4 = this.O00000oo;
        if (i4 != -1) {
            this.mNumberPicker.setValue(i4);
            this.mNumberPicker.setLabel(this.mDegree + "  " + this.mShowTags.get(this.O00000oo));
        } else {
            this.mNumberPicker.setValue(0);
            this.mNumberPicker.setLabel(this.mDegree + "  " + this.mShowTags.get(0));
        }
        this.mNumberPicker.setOnValueChangedListener(new NumberPicker.O0000Oo0() {
            /* class com.xiaomi.smarthome.scene.activity.SceneNumberPicker.AnonymousClass1 */

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                NumberPicker numberPicker2 = SceneNumberPicker.this.mNumberPicker;
                numberPicker2.setLabel(SceneNumberPicker.this.mDegree + "  " + SceneNumberPicker.this.mShowTags.get(i2));
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneNumberPicker.AnonymousClass2 */

            public final void onClick(View view) {
                SceneNumberPicker.this.setResult(0);
                SceneNumberPicker.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.module_a_3_right_text_btn);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(stringExtra);
        textView.setText((int) R.string.mj_complete);
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneNumberPicker.AnonymousClass3 */

            public final void onClick(View view) {
                String str;
                String str2 = SceneNumberPicker.this.mDisplayIndexList.get(SceneNumberPicker.this.mNumberPicker.getValue());
                float floatValue = Float.valueOf(str2).floatValue();
                Object valueOf = Float.valueOf(floatValue);
                int i = (int) floatValue;
                if (((double) Math.abs(((float) i) - floatValue)) < 1.0E-4d) {
                    valueOf = Integer.valueOf(i);
                }
                Object resultByUnit = SceneNumberPicker.this.getResultByUnit(str2);
                Intent intent = new Intent();
                JSONObject jSONObject = null;
                if (TextUtils.isEmpty(SceneNumberPicker.this.mJsonTag) || SceneNumberPicker.this.mJsonTag.equals("equal")) {
                    jSONObject = resultByUnit;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (SceneNumberPicker.this.mJsonTag.equals("max")) {
                            jSONObject2.put("min", resultByUnit);
                            jSONObject2.put("max", (double) SceneNumberPicker.this.mMaxValue);
                        } else {
                            jSONObject2.put("min", (double) SceneNumberPicker.this.mMinValue);
                            jSONObject2.put("max", resultByUnit);
                        }
                        jSONObject = jSONObject2;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (SceneNumberPicker.this.isSpec()) {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        JSONObject jSONObject3 = new JSONObject(SceneNumberPicker.this.initValue.toString());
                        if (jSONObject3.has("value")) {
                            jSONObject3.remove("value");
                        }
                        jSONObject3.put("value", jSONObject);
                        jSONArray.put(jSONObject3);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    intent.putExtra("value", jSONArray.toString());
                } else if (jSONObject instanceof JSONObject) {
                    intent.putExtra("value", jSONObject.toString());
                } else if (jSONObject instanceof Integer) {
                    intent.putExtra("value", (Integer) jSONObject);
                } else if (jSONObject instanceof Float) {
                    intent.putExtra("value", (Float) jSONObject);
                }
                if (!TextUtils.isEmpty(SceneNumberPicker.this.mFormatter)) {
                    try {
                        if (TextUtils.equals("°F", SceneNumberPicker.this.mDegree)) {
                            if (SceneNumberPicker.this.mFormatter.contains("℃")) {
                                SceneNumberPicker.this.mFormatter = SceneNumberPicker.this.mFormatter.replace("℃", "°F");
                            }
                            if (SceneNumberPicker.this.mFormatter.contains("°C")) {
                                SceneNumberPicker.this.mFormatter = SceneNumberPicker.this.mFormatter.replace("°C", "°F");
                            }
                        }
                        if (valueOf instanceof Integer) {
                            str = String.format(SceneNumberPicker.this.mFormatter, (Integer) valueOf);
                        } else {
                            str = String.format(SceneNumberPicker.this.mFormatter, (Float) valueOf);
                        }
                        if (TextUtils.equals(SceneNumberPicker.this.mFormatter, str)) {
                            SceneNumberPicker sceneNumberPicker = SceneNumberPicker.this;
                            sceneNumberPicker.mFormatter = SceneNumberPicker.this.mFormatter + "%s" + SceneNumberPicker.this.mDegree;
                            SceneNumberPicker.this.fixPrecentFormat();
                            if (resultByUnit instanceof Integer) {
                                str = String.format(SceneNumberPicker.this.mFormatter, String.valueOf(valueOf));
                            } else {
                                String str3 = SceneNumberPicker.this.mFormatter;
                                StringBuilder sb = new StringBuilder();
                                sb.append((Float) valueOf);
                                str = String.format(str3, sb.toString());
                            }
                        }
                        intent.putExtra("key_name", str);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        intent.putExtra("key_name", String.valueOf(resultByUnit));
                    }
                }
                SceneNumberPicker.this.setResult(-1, intent);
                SceneNumberPicker.this.finish();
            }
        });
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

    public void fixPrecentFormat() {
        if (!TextUtils.isEmpty(this.mFormatter)) {
            if (this.mFormatter.contains("d%") && !this.mFormatter.contains("d%%")) {
                this.mFormatter = this.mFormatter.replace("d%", "d%%");
            } else if (this.mFormatter.contains("f%") && !this.mFormatter.contains("f%%")) {
                this.mFormatter = this.mFormatter.replace("f%", "f%%");
            } else if (this.mFormatter.contains("s%") && !this.mFormatter.contains("s%%")) {
                this.mFormatter = this.mFormatter.replace("s%", "s%%");
            }
        }
    }

    private static double O000000o(double d, double d2) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        try {
            bigDecimal = new BigDecimal(Double.toString(d));
        } catch (NumberFormatException unused) {
            bigDecimal = new BigDecimal("0");
        } catch (Exception unused2) {
            bigDecimal = new BigDecimal("0");
        }
        try {
            bigDecimal2 = new BigDecimal(Double.toString(d2));
        } catch (NumberFormatException unused3) {
            bigDecimal2 = new BigDecimal("0");
        } catch (Exception unused4) {
            bigDecimal2 = new BigDecimal("0");
        }
        return bigDecimal.subtract(bigDecimal2).doubleValue();
    }

    public boolean isSpec() {
        JSONObject jSONObject = this.initValue;
        return jSONObject != null && jSONObject.has("value");
    }
}
