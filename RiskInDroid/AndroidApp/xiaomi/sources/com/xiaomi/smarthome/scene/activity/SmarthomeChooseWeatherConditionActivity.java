package com.xiaomi.smarthome.scene.activity;

import _m_j.gqd;
import _m_j.hpc;
import _m_j.hpq;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.bean.WeatherConditionType;
import java.util.ArrayList;
import java.util.List;

public class SmarthomeChooseWeatherConditionActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    LayoutInflater f10993O000000o;
    Context O00000Oo;
    hpc O00000o;
    List<WeatherData> O00000o0 = new ArrayList();
    O000000o O00000oO;
    @BindView(5703)
    ListView mListView;
    @BindView(5822)
    ImageView mReturnIV;
    @BindView(5826)
    TextView mTitleTV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_choose_weather_condition_layout);
        ButterKnife.bind(this);
        this.f10993O000000o = LayoutInflater.from(this);
        this.O00000Oo = this;
        this.mTitleTV.setText((int) R.string.condition_weather_outer_weather);
        this.O00000o = hpq.O000000o().O0000OoO;
        if (this.O00000o == null) {
            clickBack();
        }
        this.O00000o0.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.add(WeatherConditionType.TYPE_SUNRISE);
        arrayList.add(WeatherConditionType.TYPE_SUNSET);
        this.O00000o0.add(new WeatherData(getString(R.string.condition_weather_sunrise), R.drawable.scene_sun_icon, arrayList));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(WeatherConditionType.TYPE_ABOVE_TEMPERATURE);
        arrayList2.add(WeatherConditionType.TYPE_LESS_TEMPERATURE);
        this.O00000o0.add(new WeatherData(getString(R.string.condition_weather_temperature), R.drawable.scene_temperature_icon, arrayList2));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(WeatherConditionType.TYPE_ABOVE_HUMIDITY);
        arrayList3.add(WeatherConditionType.TYPE_LESS_HUMIDITY);
        this.O00000o0.add(new WeatherData(getString(R.string.condition_weather_humidity), R.drawable.scene_humidity_icon, arrayList3));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(WeatherConditionType.TYPE_ABOVE_AQI);
        arrayList4.add(WeatherConditionType.TYPE_LESS_AQI);
        this.O00000o0.add(new WeatherData(getString(R.string.condition_weather_aqi), R.drawable.scene_pm25_icon, arrayList4));
        this.mReturnIV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SmarthomeChooseWeatherConditionActivity.this.clickBack();
            }
        });
        this.O00000oO = new O000000o();
        this.mListView.setAdapter((ListAdapter) this.O00000oO);
    }

    public static class WeatherData implements Parcelable {
        public static final Parcelable.Creator<WeatherData> CREATOR = new Parcelable.Creator<WeatherData>() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionActivity.WeatherData.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WeatherData[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new WeatherData(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        String f10997O000000o;
        int O00000Oo;
        ArrayList<WeatherConditionType> O00000o0 = new ArrayList<>();

        public int describeContents() {
            return 0;
        }

        public WeatherData(String str, int i, ArrayList<WeatherConditionType> arrayList) {
            this.f10997O000000o = str;
            this.O00000Oo = i;
            this.O00000o0 = arrayList;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f10997O000000o);
            parcel.writeInt(this.O00000Oo);
            parcel.writeList(this.O00000o0);
        }

        protected WeatherData(Parcel parcel) {
            this.f10997O000000o = parcel.readString();
            this.O00000Oo = parcel.readInt();
            this.O00000o0 = new ArrayList<>();
            parcel.readList(this.O00000o0, WeatherConditionType.class.getClassLoader());
        }
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
            return SmarthomeChooseWeatherConditionActivity.this.O00000o0.size();
        }

        public final Object getItem(int i) {
            return SmarthomeChooseWeatherConditionActivity.this.O00000o0.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            final WeatherData weatherData = SmarthomeChooseWeatherConditionActivity.this.O00000o0.get(i);
            View inflate = SmarthomeChooseWeatherConditionActivity.this.f10993O000000o.inflate((int) R.layout.smarthome_condition_choose_item_layout, (ViewGroup) null);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) inflate.findViewById(R.id.content_icon);
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(SmarthomeChooseWeatherConditionActivity.this.O00000Oo.getResources()).setPlaceholderImage((int) R.drawable.device_list_phone_no).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
            simpleDraweeView.setImageURI(gqd.O000000o(weatherData.O00000Oo));
            ((TextView) inflate.findViewById(R.id.content)).setText(weatherData.f10997O000000o);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeChooseWeatherConditionActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(SmarthomeChooseWeatherConditionActivity.this.O00000Oo, SmarthomeChooseWeatherConditionDetailActivity.class);
                    intent.putExtra("weather_data", weatherData);
                    SmarthomeChooseWeatherConditionActivity.this.O00000o.O00000oO = weatherData.f10997O000000o;
                    SmarthomeChooseWeatherConditionActivity.this.startActivityForResult(intent, 106);
                }
            });
            return inflate;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 106 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }
}
