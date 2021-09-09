package com.xiaomi.smarthome.scene.activity;

import _m_j.gsy;
import _m_j.gwr;
import _m_j.gwu;
import _m_j.hpc;
import _m_j.hpq;
import _m_j.izb;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.WeatherConditionType;
import java.util.ArrayList;

public class SmarthomeChooseWeatherConditionDetailActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    LayoutInflater f10999O000000o;
    Context O00000Oo;
    O000000o O00000o;
    SmarthomeChooseWeatherConditionActivity.WeatherData O00000o0;
    hpc O00000oO;
    SceneApi.O000000o O00000oo;
    public boolean mIsEdit = false;
    @BindView(5703)
    ListView mListView;
    @BindView(5822)
    ImageView mReturnIV;
    @BindView(5826)
    TextView mTitleTV;

    public void onCreate(Bundle bundle) {
        SmarthomeChooseWeatherConditionActivity.WeatherData weatherData;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_choose_weather_condition_layout);
        ButterKnife.bind(this);
        this.f10999O000000o = LayoutInflater.from(this);
        this.O00000Oo = this;
        this.O00000oo = hpq.O000000o().O00000oO;
        SceneApi.O000000o o000000o = this.O00000oo;
        if (o000000o == null || !o000000o.O00000Oo()) {
            this.mIsEdit = false;
            Intent intent = getIntent();
            if (intent == null) {
                finish();
            } else {
                this.O00000o0 = (SmarthomeChooseWeatherConditionActivity.WeatherData) intent.getParcelableExtra("weather_data");
                SmarthomeChooseWeatherConditionActivity.WeatherData weatherData2 = this.O00000o0;
                if (weatherData2 == null || weatherData2.O00000o0 == null) {
                    finish();
                } else {
                    this.O00000oO = hpq.O000000o().O0000OoO;
                    if (this.O00000oO == null) {
                        finish();
                    }
                }
            }
        } else {
            this.mIsEdit = true;
            int i = this.O00000oo.O0000OoO.O00000o;
            if (i == WeatherConditionType.TYPE_SUNRISE.conditionId || i == WeatherConditionType.TYPE_SUNSET.conditionId) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(WeatherConditionType.TYPE_SUNRISE);
                arrayList.add(WeatherConditionType.TYPE_SUNSET);
                weatherData = new SmarthomeChooseWeatherConditionActivity.WeatherData(getString(R.string.condition_weather_sunrise), R.drawable.scene_sun_icon, arrayList);
            } else if (i == WeatherConditionType.TYPE_LESS_TEMPERATURE.conditionId || i == WeatherConditionType.TYPE_ABOVE_TEMPERATURE.conditionId) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(WeatherConditionType.TYPE_ABOVE_TEMPERATURE);
                arrayList2.add(WeatherConditionType.TYPE_LESS_TEMPERATURE);
                weatherData = new SmarthomeChooseWeatherConditionActivity.WeatherData(getString(R.string.condition_weather_temperature), R.drawable.scene_temperature_icon, arrayList2);
            } else if (i == WeatherConditionType.TYPE_ABOVE_HUMIDITY.conditionId || i == WeatherConditionType.TYPE_LESS_HUMIDITY.conditionId) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(WeatherConditionType.TYPE_ABOVE_HUMIDITY);
                arrayList3.add(WeatherConditionType.TYPE_LESS_HUMIDITY);
                weatherData = new SmarthomeChooseWeatherConditionActivity.WeatherData(getString(R.string.condition_weather_humidity), R.drawable.scene_humidity_icon, arrayList3);
            } else if (i == WeatherConditionType.TYPE_ABOVE_AQI.conditionId || i == WeatherConditionType.TYPE_LESS_AQI.conditionId) {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(WeatherConditionType.TYPE_ABOVE_AQI);
                arrayList4.add(WeatherConditionType.TYPE_LESS_AQI);
                weatherData = new SmarthomeChooseWeatherConditionActivity.WeatherData(getString(R.string.condition_weather_aqi), R.drawable.scene_pm25_icon, arrayList4);
            } else {
                weatherData = null;
            }
            this.O00000o0 = weatherData;
            SmarthomeChooseWeatherConditionActivity.WeatherData weatherData3 = this.O00000o0;
            if (weatherData3 == null || weatherData3.O00000o0 == null) {
                finish();
            } else {
                this.O00000oO = new hpc();
                this.O00000oO.O00000oO = this.O00000oo.O0000OoO.O00000Oo;
                this.O00000oO.O00000o = this.O00000oo.O0000OoO.O00000o;
            }
        }
        SmarthomeChooseWeatherConditionActivity.WeatherData weatherData4 = this.O00000o0;
        if (weatherData4 == null || TextUtils.isEmpty(weatherData4.f10997O000000o)) {
            finish();
            return;
        }
        this.mTitleTV.setText(this.O00000o0.f10997O000000o);
        this.mReturnIV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionDetailActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SmarthomeChooseWeatherConditionDetailActivity.this.clickBack();
            }
        });
        this.O00000o = new O000000o();
        this.mListView.setAdapter((ListAdapter) this.O00000o);
    }

    public void clickBack() {
        setResult(0);
        finish();
    }

    public void onBackPressed() {
        clickBack();
    }

    public class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o() {
        }

        public final int getCount() {
            return SmarthomeChooseWeatherConditionDetailActivity.this.O00000o0.O00000o0.size();
        }

        public final Object getItem(int i) {
            return SmarthomeChooseWeatherConditionDetailActivity.this.O00000o0.O00000o0.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(SmarthomeChooseWeatherConditionDetailActivity.this.O00000Oo).inflate((int) R.layout.smarthome_action_item, (ViewGroup) null);
            }
            final WeatherConditionType weatherConditionType = SmarthomeChooseWeatherConditionDetailActivity.this.O00000o0.O00000o0.get(i);
            TextView textView = (TextView) view.findViewById(R.id.description_text);
            ImageView imageView = (ImageView) view.findViewById(R.id.lock_item);
            textView.setText(weatherConditionType.conditionNameId);
            final boolean isEnable = SmarthomeChooseWeatherConditionDetailActivity.this.isEnable(weatherConditionType);
            if (SmarthomeChooseWeatherConditionDetailActivity.this.mIsEdit) {
                if (SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000o == weatherConditionType.conditionId) {
                    textView.setTextColor(SmarthomeChooseWeatherConditionDetailActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                } else {
                    textView.setTextColor(SmarthomeChooseWeatherConditionDetailActivity.this.getResources().getColor(R.color.mj_color_black_100_transparent));
                }
                imageView.setVisibility(8);
            } else {
                textView.setTextColor(SmarthomeChooseWeatherConditionDetailActivity.this.getResources().getColor(R.color.mj_color_black_100_transparent));
                if (isEnable) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionDetailActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    if (SmarthomeChooseWeatherConditionDetailActivity.this.mIsEdit || isEnable) {
                        SmarthomeChooseWeatherConditionDetailActivity.this.gotoActivity(weatherConditionType);
                    } else {
                        izb.O000000o(SmarthomeChooseWeatherConditionDetailActivity.this, (int) R.string.scene_unclickable_toast_2, 0).show();
                    }
                }
            });
            return view;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void
     arg types: [com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionDetailActivity, com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionDetailActivity$2]
     candidates:
      _m_j.gwu.O000000o(android.content.Context, android.location.Address):_m_j.gwr
      _m_j.gwu.O000000o(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
      _m_j.gwu.O000000o(android.content.Context, _m_j.gwu$O000000o):void
      _m_j.gwu.O000000o(android.content.Context, java.lang.String):void
      _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void */
    public void gotoActivity(WeatherConditionType weatherConditionType) {
        if (weatherConditionType == WeatherConditionType.TYPE_SUNRISE || weatherConditionType == WeatherConditionType.TYPE_SUNSET) {
            this.O00000oO.O00000o = weatherConditionType.conditionId;
            this.O00000oO.O0000OOo = getString(weatherConditionType.conditionNameId);
            this.O00000oO.O00000oO = getString(weatherConditionType.conditionNameId);
            gwu.O000000o((Activity) this, (gwu.O000000o) new gwu.O000000o() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionDetailActivity.AnonymousClass2 */

                public final void O000000o(String str, String str2) {
                    SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O0000O0o = str2;
                    SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000oo = str;
                    hpc hpc = SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO;
                    hpc.O0000OOo = SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000oo + " " + SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O0000OOo;
                    gsy.O00000Oo("SmarthomeChooseWeatherConditionDetailActivity", "cityId" + SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O0000O0o + "   cityname" + SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000oo);
                    if (SmarthomeChooseWeatherConditionDetailActivity.this.mIsEdit) {
                        SceneApi.O000000o O000000o2 = SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O000000o(SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000o, null);
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000o = O000000o2.O0000OoO.O00000o;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000o0 = O000000o2.O0000OoO.O00000o0;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000oo = O000000o2.O0000OoO.O00000oo;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000oO = O000000o2.O0000OoO.O00000oO;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O0000O0o = O000000o2.O0000OoO.O0000O0o;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.f11121O000000o = O000000o2.f11121O000000o;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000Ooo = O000000o2.O0000Ooo;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.f11126O000000o = O000000o2.O0000OoO.f11126O000000o;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000Oo = O000000o2.O0000OoO.O00000Oo;
                    }
                    SmarthomeChooseWeatherConditionDetailActivity.this.complete();
                }

                public final void O000000o(Context context, Address address) {
                    gwr O000000o2 = gwu.O000000o(context, address);
                    if (O000000o2 != null) {
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O0000O0o = O000000o2.O00000oo;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000oo = O000000o2.O00000oO;
                        hpc hpc = SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO;
                        hpc.O0000OOo = SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000oo + " " + SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O0000OOo;
                        gsy.O00000Oo("SmarthomeChooseWeatherConditionDetailActivity", "cityId" + SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O0000O0o + "   cityname" + SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000oo);
                    } else {
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000oo = address.getSubLocality();
                        hpc hpc2 = SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO;
                        hpc2.O0000OOo = SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000oo + " " + SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O0000OOo;
                        LogType logType = LogType.SCENE;
                        gsy.O00000o0(logType, "SmarthomeChooseWeatherConditionDetailActivity", address.getAdminArea() + address.getLocality() + address.getSubLocality() + " found cityId fail");
                    }
                    if (SmarthomeChooseWeatherConditionDetailActivity.this.mIsEdit) {
                        SceneApi.O000000o O000000o3 = SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O000000o(SmarthomeChooseWeatherConditionDetailActivity.this.O00000oO.O00000o, null);
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000o = O000000o3.O0000OoO.O00000o;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000o0 = O000000o3.O0000OoO.O00000o0;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000oo = O000000o3.O0000OoO.O00000oo;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000oO = O000000o3.O0000OoO.O00000oO;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O0000O0o = O000000o3.O0000OoO.O0000O0o;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.f11121O000000o = O000000o3.f11121O000000o;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000Ooo = O000000o3.O0000Ooo;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.f11126O000000o = O000000o3.O0000OoO.f11126O000000o;
                        SmarthomeChooseWeatherConditionDetailActivity.this.O00000oo.O0000OoO.O00000Oo = O000000o3.O0000OoO.O00000Oo;
                    }
                    SmarthomeChooseWeatherConditionDetailActivity.this.complete();
                }
            });
        } else if (weatherConditionType == WeatherConditionType.TYPE_ABOVE_TEMPERATURE) {
            this.O00000oO.O00000o = weatherConditionType.conditionId;
            O000000o(100.0f, -40.0f, "℃", 29.0f, getString(weatherConditionType.conditionNameId), "", 1.0f, "max");
        } else if (weatherConditionType == WeatherConditionType.TYPE_LESS_TEMPERATURE) {
            this.O00000oO.O00000o = weatherConditionType.conditionId;
            O000000o(100.0f, -40.0f, "℃", 26.0f, getString(weatherConditionType.conditionNameId), "", 1.0f, "min");
        } else if (weatherConditionType == WeatherConditionType.TYPE_ABOVE_HUMIDITY) {
            this.O00000oO.O00000o = weatherConditionType.conditionId;
            O000000o(100.0f, 0.0f, "%", 70.0f, getString(weatherConditionType.conditionNameId), "", 1.0f, "max");
        } else if (weatherConditionType == WeatherConditionType.TYPE_LESS_HUMIDITY) {
            this.O00000oO.O00000o = weatherConditionType.conditionId;
            O000000o(100.0f, 0.0f, "%", 30.0f, getString(weatherConditionType.conditionNameId), "", 1.0f, "min");
        } else if (weatherConditionType == WeatherConditionType.TYPE_ABOVE_AQI) {
            this.O00000oO.O00000o = weatherConditionType.conditionId;
            O000000o(2000.0f, 5.0f, "μg/m³", 75.0f, getString(weatherConditionType.conditionNameId), "", 5.0f, "max");
        } else if (weatherConditionType == WeatherConditionType.TYPE_LESS_AQI) {
            this.O00000oO.O00000o = weatherConditionType.conditionId;
            O000000o(2000.0f, 5.0f, "μg/m³", 35.0f, getString(weatherConditionType.conditionNameId), "", 5.0f, "min");
        }
    }

    public boolean isEnable(WeatherConditionType weatherConditionType) {
        SceneApi.O000OOOo o000OOOo = hpq.O000000o().O00000Oo;
        if (!(o000OOOo == null || o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() == 0)) {
            for (int i = 0; i < o000OOOo.O0000O0o.size(); i++) {
                SceneApi.O000000o o000000o = o000OOOo.O0000O0o.get(i);
                if (o000000o.O0000OoO != null && (o000000o.O0000OoO.O00000o == weatherConditionType.conditionId || !hpq.O000000o().O000000o(Integer.valueOf(weatherConditionType.compatibleId)))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void complete() {
        setResult(-1);
        finish();
    }

    private void O000000o(float f, float f2, String str, float f3, String str2, String str3, float f4, String str4) {
        Intent intent = new Intent(this.O00000Oo, SceneWeatherNumberPicker.class);
        intent.putExtra("max_value", f);
        intent.putExtra("min_value", f2);
        intent.putExtra("interval", f4);
        intent.putExtra("degree", str);
        intent.putExtra("json_tag", str4);
        intent.putExtra("default_value", f3);
        intent.putExtra("title", str2);
        intent.putExtra("formatter", str3);
        if (this.mIsEdit) {
            hpq.O000000o().O0000OoO = this.O00000oO;
        }
        startActivityForResult(intent, 106);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 106 || i2 != -1) {
            return;
        }
        if (!this.mIsEdit) {
            setResult(-1);
            finish();
            return;
        }
        hpc hpc = this.O00000oO;
        SceneApi.O000000o O000000o2 = hpc.O000000o(hpc.O00000o, null);
        this.O00000oo.O0000OoO.O00000o = O000000o2.O0000OoO.O00000o;
        this.O00000oo.O0000OoO.O00000o0 = O000000o2.O0000OoO.O00000o0;
        this.O00000oo.O0000OoO.O0000O0o = O000000o2.O0000OoO.O0000O0o;
        this.O00000oo.O0000OoO.O00000oo = O000000o2.O0000OoO.O00000oo;
        this.O00000oo.O0000OoO.O00000oO = O000000o2.O0000OoO.O00000oO;
        this.O00000oo.f11121O000000o = O000000o2.f11121O000000o;
        this.O00000oo.O0000Ooo = O000000o2.O0000Ooo;
        this.O00000oo.O0000OoO.f11126O000000o = O000000o2.O0000OoO.f11126O000000o;
        this.O00000oo.O0000OoO.O00000Oo = O000000o2.O0000OoO.O00000Oo;
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
