package com.xiaomi.smarthome.framework.page;

import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ful;
import _m_j.gqg;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class TimezoneActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f7791O000000o;
    ListView O00000Oo;
    ImageView O00000o;
    EditText O00000o0;
    O000000o O00000oO;
    String O00000oo;
    private TextWatcher O0000O0o = new TextWatcher() {
        /* class com.xiaomi.smarthome.framework.page.TimezoneActivity.AnonymousClass1 */

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            ArrayList arrayList = new ArrayList();
            String obj = TimezoneActivity.this.O00000o0.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                TimezoneActivity.this.O00000o.setVisibility(0);
                for (ful next : TimezoneActivity.this.mTimezoneAll) {
                    if (next.O00000Oo.toLowerCase().contains(obj.toLowerCase())) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() > 0) {
                    TimezoneActivity.this.O00000oO.f7797O000000o = arrayList;
                } else {
                    TimezoneActivity.this.O00000oO.f7797O000000o = TimezoneActivity.this.mTimezoneAll;
                }
            } else {
                TimezoneActivity.this.O00000o.setVisibility(8);
                TimezoneActivity.this.O00000oO.f7797O000000o = TimezoneActivity.this.mTimezoneAll;
            }
            TimezoneActivity.this.O00000oO.notifyDataSetChanged();
        }
    };
    public boolean mShouldSyncDevice = false;
    public List<ful> mTimezoneAll = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_timezone);
        this.O00000oo = getIntent().getStringExtra("extra_device_did");
        this.mShouldSyncDevice = getIntent().getBooleanExtra("sync_device", false);
        if (TextUtils.isEmpty(this.O00000oo)) {
            finish();
            return;
        }
        this.O00000Oo = (ListView) findViewById(R.id.list);
        this.O00000o0 = (EditText) findViewById(R.id.search_et);
        this.O00000o0.addTextChangedListener(this.O0000O0o);
        this.O00000o = (ImageView) findViewById(R.id.search_clear_bt);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.TimezoneActivity.AnonymousClass2 */

            public final void onClick(View view) {
                TimezoneActivity.this.O00000o0.setText("");
                TimezoneActivity.this.O00000oO.f7797O000000o = TimezoneActivity.this.mTimezoneAll;
                TimezoneActivity.this.O00000oO.notifyDataSetChanged();
            }
        });
        findViewById(R.id.search_back_img).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.TimezoneActivity.AnonymousClass3 */

            public final void onClick(View view) {
                TimezoneActivity.this.onBackPressed();
            }
        });
        this.f7791O000000o = this;
        String[] availableIDs = TimeZone.getAvailableIDs();
        TimeZone timeZone = TimeZone.getDefault();
        int i = 0;
        for (String str : getResources().getStringArray(R.array.city_timezone)) {
            int length = availableIDs.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (availableIDs[i2].equals(str)) {
                    TimeZone timeZone2 = TimeZone.getTimeZone(str);
                    TimeZone.setDefault(timeZone2);
                    ful ful = new ful();
                    ful.f17190O000000o = str;
                    ful.O00000Oo = getResources().getStringArray(R.array.timezone_city_name)[i];
                    ful.O00000o0 = timeZone2.getDisplayName(timeZone2.inDaylightTime(new Date()), 0);
                    this.mTimezoneAll.add(ful);
                    break;
                } else {
                    i2++;
                }
            }
            i++;
        }
        TimeZone.setDefault(timeZone);
        this.O00000oO = new O000000o(this.mTimezoneAll, this.f7791O000000o);
        this.O00000Oo.setAdapter((ListAdapter) this.O00000oO);
        this.O00000Oo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.framework.page.TimezoneActivity.AnonymousClass4 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = TimezoneActivity.this.O00000oO.f7797O000000o.get(i).f17190O000000o;
                final TimeZone timeZone = TimeZone.getTimeZone(str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sync_device", TimezoneActivity.this.mShouldSyncDevice);
                } catch (JSONException unused) {
                }
                fru.O000000o().O000000o(TimezoneActivity.this.O00000oo, str, jSONObject, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.framework.page.TimezoneActivity.AnonymousClass4.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        gqg.O00000Oo(TimezoneActivity.this.getString(R.string.phone_wifi_error));
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        Intent intent = new Intent();
                        intent.putExtra("TimeZone", timeZone);
                        TimezoneActivity.this.setResult(4, intent);
                        TimezoneActivity.this.finish();
                    }
                });
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    static class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        List<ful> f7797O000000o = Collections.EMPTY_LIST;
        Context O00000Oo;
        int O00000o0 = -1;

        public final long getItemId(int i) {
            return (long) i;
        }

        O000000o(List<ful> list, Context context) {
            this.f7797O000000o = list;
            this.O00000Oo = context;
        }

        public final int getCount() {
            return this.f7797O000000o.size();
        }

        public final Object getItem(int i) {
            return this.f7797O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000Oo o00000Oo;
            if (view == null) {
                view = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.item_timezone, viewGroup, false);
                o00000Oo = new O00000Oo();
                o00000Oo.f7798O000000o = (TextView) view.findViewById(R.id.text_name);
                o00000Oo.O00000Oo = (TextView) view.findViewById(R.id.text_gmt);
                view.setTag(o00000Oo);
            } else {
                o00000Oo = (O00000Oo) view.getTag();
            }
            if (i < this.f7797O000000o.size()) {
                ful ful = this.f7797O000000o.get(i);
                String str = ful.O00000Oo;
                if (this.O00000o0 == i) {
                    str = str + this.O00000Oo.getResources().getString(R.string.timezone_activity_current);
                }
                o00000Oo.f7798O000000o.setText(str);
                o00000Oo.O00000Oo.setText(ful.O00000o0);
            }
            return view;
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f7798O000000o;
        TextView O00000Oo;

        O00000Oo() {
        }
    }
}
