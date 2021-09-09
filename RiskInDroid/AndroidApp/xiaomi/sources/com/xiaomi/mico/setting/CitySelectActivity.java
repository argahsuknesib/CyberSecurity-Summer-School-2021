package com.xiaomi.mico.setting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CitySelectActivity extends MicoBaseActivity {
    TextView currentCity;
    ListView listview;
    TitleBar titleBar;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
     arg types: [java.io.InputStreamReader, java.lang.Class]
     candidates:
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_city_select);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.currentCity = (TextView) findViewById(R.id.current_city);
        this.listview = (ListView) findViewById(R.id.listview);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.CitySelectActivity.AnonymousClass1 */

            public void onLeftIconClick() {
                CitySelectActivity.this.setResult(0);
                CitySelectActivity.this.finish();
            }
        });
        String string = getString(R.string.city_select_unknown);
        if (getIntent().hasExtra("current_city") && !TextUtils.isEmpty(getIntent().getStringExtra("current_city"))) {
            string = getIntent().getStringExtra("current_city");
        }
        this.currentCity.setText(getResources().getString(R.string.city_select_current_city, string));
        HashMap hashMap = ((ThirdPartyResponse.CityData) new Gson().fromJson((Reader) new InputStreamReader(getResources().openRawResource(R.raw.allcity)), ThirdPartyResponse.CityData.class)).city.get(0);
        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList, new Comparator<String>() {
            /* class com.xiaomi.mico.setting.CitySelectActivity.AnonymousClass2 */

            public int compare(String str, String str2) {
                if (str.equals("热门") || str2.equals("热门")) {
                    return -99;
                }
                return str.compareToIgnoreCase(str2);
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            arrayList2.add(new CityItem(str, true));
            for (ThirdPartyResponse.CityDetail cityDetail : (List) hashMap.get(str)) {
                arrayList2.add(new CityItem(cityDetail.name, false));
            }
        }
        this.listview.setAdapter((ListAdapter) new CityAdapter(arrayList2));
        this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.mico.setting.CitySelectActivity.AnonymousClass3 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                CityItem cityItem = (CityItem) adapterView.getItemAtPosition(i);
                if (!cityItem.index) {
                    Intent intent = new Intent();
                    intent.putExtra("selected_city", cityItem.name);
                    CitySelectActivity.this.setResult(-1, intent);
                    CitySelectActivity.this.finish();
                }
            }
        });
    }

    class CityAdapter extends BaseAdapter {
        private final List<CityItem> mData;

        public long getItemId(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 2;
        }

        public CityAdapter(List<CityItem> list) {
            this.mData = list;
        }

        public int getCount() {
            return this.mData.size();
        }

        public Object getItem(int i) {
            return this.mData.get(i);
        }

        public int getItemViewType(int i) {
            return ((CityItem) getItem(i)).index ? 0 : 1;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                if (getItemViewType(i) == 0) {
                    view = LayoutInflater.from(CitySelectActivity.this.getContext()).inflate((int) R.layout.city_index_item, (ViewGroup) null);
                } else {
                    view = LayoutInflater.from(CitySelectActivity.this.getContext()).inflate((int) R.layout.city_index_city, (ViewGroup) null);
                }
                view.setTag(new ItemViewHolder(view));
            }
            ((ItemViewHolder) view.getTag()).textView.setText(((CityItem) getItem(i)).name);
            return view;
        }
    }

    class ItemViewHolder {
        TextView textView;

        ItemViewHolder(View view) {
            this.textView = (TextView) view.findViewById(R.id.textview);
        }
    }

    class CityItem {
        public final boolean index;
        public final String name;

        public CityItem(String str, boolean z) {
            this.name = str;
            this.index = z;
        }
    }
}
