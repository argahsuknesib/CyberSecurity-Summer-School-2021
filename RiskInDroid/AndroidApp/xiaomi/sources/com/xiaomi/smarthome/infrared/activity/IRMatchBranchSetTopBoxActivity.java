package com.xiaomi.smarthome.infrared.activity;

import _m_j.fag;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.fuy;
import _m_j.gip;
import _m_j.gis;
import _m_j.gjc;
import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.infrared.bean.IRSTBData;
import com.xiaomi.smarthome.infrared.bean.IRType;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class IRMatchBranchSetTopBoxActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f8992O000000o;
    private gjc O00000Oo = new gjc();
    public gip mAdapter;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ir_match_set_top_box);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        ListView listView = (ListView) findViewById(R.id.ir_match_set_top_box_list);
        this.f8992O000000o = (TextView) findViewById(R.id.ir_match_location);
        this.O00000Oo.f17826O000000o = this;
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.ir_match_set_top_box);
        this.mAdapter = new gip(this, new ArrayList());
        listView.setAdapter((ListAdapter) this.mAdapter);
        this.f8992O000000o.setText(getString(R.string.ir_match_location_unknown));
        addMatchingBranchList(fuy.O000000o().O00000o0);
        fuy.O000000o().O000000o(new fuy.O000000o() {
            /* class com.xiaomi.smarthome.infrared.activity.IRMatchBranchSetTopBoxActivity.AnonymousClass2 */

            public final void O000000o(String str, Location location) {
                IRMatchBranchSetTopBoxActivity.this.addMatchingBranchList(location);
            }
        });
        findViewById.setOnClickListener(this);
        this.f8992O000000o.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.infrared.activity.IRMatchBranchSetTopBoxActivity.AnonymousClass1 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                IRSTBData iRSTBData = (IRSTBData) IRMatchBranchSetTopBoxActivity.this.mAdapter.getItem(i);
                if (iRSTBData.f9038O000000o == 1) {
                    IRMatchingBrandActivity.showMatchingBrandActivity(IRMatchBranchSetTopBoxActivity.this, iRSTBData, IRType.STB.value());
                } else {
                    IRSingleMatchBaseActivity.showStbSingleMatchActivity(IRMatchBranchSetTopBoxActivity.this, IRType.STB.value(), iRSTBData);
                }
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ir_match_location) {
            IRSelectProvinceActivity.startProvince(this, 100);
        } else if (id == R.id.module_a_3_return_btn) {
            finish();
        }
    }

    public void addMatchingBranchList(Location location) {
        Bundle extras;
        if (location != null && (extras = location.getExtras()) != null) {
            Object obj = extras.get("address");
            if (obj instanceof Address) {
                Address address = (Address) obj;
                String adminArea = address.getAdminArea();
                String locality = address.getLocality();
                String subLocality = address.getSubLocality();
                if (TextUtils.isEmpty(subLocality)) {
                    subLocality = locality;
                    locality = adminArea;
                }
                if (!TextUtils.isEmpty(adminArea) && !TextUtils.isEmpty(locality)) {
                    TextView textView = this.f8992O000000o;
                    String string = getString(R.string.ir_match_location_format);
                    Object[] objArr = new Object[3];
                    objArr[0] = adminArea;
                    objArr[1] = adminArea.equals(locality) ? "" : locality;
                    objArr[2] = subLocality;
                    textView.setText(String.format(string, objArr));
                    gjc gjc = this.O00000Oo;
                    AnonymousClass3 r3 = new fsm<gis, fso>() {
                        /* class com.xiaomi.smarthome.infrared.activity.IRMatchBranchSetTopBoxActivity.AnonymousClass3 */

                        public final void onFailure(fso fso) {
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            gis gis = (gis) obj;
                            IRMatchBranchSetTopBoxActivity.this.addMatchingBranchForID(gis.O00000Oo, gis.f17815O000000o);
                        }
                    };
                    if (gjc.f17826O000000o != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("province", adminArea);
                            jSONObject.put("city", locality);
                            jSONObject.put("area", subLocality);
                        } catch (Throwable th) {
                            Log.e("InifraredRequestApi", "requestAreaid", th);
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/ircode/area/area_id").O000000o(arrayList).O000000o();
                        gjc.O000000o o000000o = new gjc.O000000o(r3);
                        gjc.O000000o(CoreApi.O000000o().O000000o(gjc.f17826O000000o, O000000o2, new fss<gis>() {
                            /* class _m_j.gjc.AnonymousClass6 */

                            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                                return gis.O000000o(jSONObject);
                            }
                        }, Crypto.RC4, o000000o), o000000o);
                    }
                }
            }
        }
    }

    public void addMatchingBranchForID(final String str, String str2) {
        gjc gjc = this.O00000Oo;
        AnonymousClass4 r1 = new fsm<ArrayList<IRSTBData>, fso>() {
            /* class com.xiaomi.smarthome.infrared.activity.IRMatchBranchSetTopBoxActivity.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                ArrayList arrayList = (ArrayList) obj;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((IRSTBData) it.next()).O00000o = str;
                }
                IRMatchBranchSetTopBoxActivity.this.mAdapter.O000000o(arrayList);
            }

            public final void onFailure(fso fso) {
                fag.O000000o(IRMatchBranchSetTopBoxActivity.this, (int) R.string.ir_toast_get_data_failed, 1);
            }
        };
        if (gjc.f17826O000000o != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("area_id", Integer.parseInt(str2));
            } catch (Throwable th) {
                Log.e("InifraredRequestApi", "requestLineups", th);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/ircode/area/lineups").O000000o(arrayList).O000000o();
            gjc.O000000o o000000o = new gjc.O000000o(r1);
            gjc.O000000o(CoreApi.O000000o().O000000o(gjc.f17826O000000o, O000000o2, new fss<ArrayList<IRSTBData>>() {
                /* class _m_j.gjc.AnonymousClass7 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return IRSTBData.O000000o(jSONObject.optJSONArray("lineups"));
                }
            }, Crypto.RC4, o000000o), o000000o);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000Oo.O000000o();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            return;
        }
        if (intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        } else if (i == 100 && i2 == -1) {
            String stringExtra = intent.getStringExtra("intent_province_name_key");
            String stringExtra2 = intent.getStringExtra("intent_city_name_key");
            String stringExtra3 = intent.getStringExtra("intent_area_name_key");
            String stringExtra4 = intent.getStringExtra("intent_city_id_key");
            String stringExtra5 = intent.getStringExtra("intent_area_id_key");
            if (TextUtils.equals(stringExtra, stringExtra2)) {
                stringExtra2 = "";
            }
            this.f8992O000000o.setText(String.format(getResources().getString(R.string.ir_match_location_format), substringLocalName(stringExtra), substringLocalName(stringExtra2), stringExtra3));
            addMatchingBranchForID(stringExtra4, String.valueOf(stringExtra5));
        }
    }

    public static String substringLocalName(String str) {
        if (str.length() <= 1) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }
}
