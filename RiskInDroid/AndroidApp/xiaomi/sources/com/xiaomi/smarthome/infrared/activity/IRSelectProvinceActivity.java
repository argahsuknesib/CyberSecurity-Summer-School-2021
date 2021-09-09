package com.xiaomi.smarthome.infrared.activity;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.gil;
import _m_j.gjc;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.infrared.bean.NameIdEntity;
import com.xiaomi.smarthome.infrared.widget.SideBar;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class IRSelectProvinceActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f9007O000000o;
    private SideBar O00000Oo;
    private gjc O00000o = new gjc();
    private TextView O00000o0;
    private int O00000oO = 0;
    private ImageView O00000oo;
    public gil mAdapter;
    public ArrayList<NameIdEntity> mList;
    public ListView mListView;

    public static void startProvince(Activity activity, int i) {
        Intent intent = new Intent(activity, IRSelectProvinceActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("intent_key_show_type", 102);
        activity.startActivityForResult(intent, i);
    }

    public static void startCity(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, IRSelectProvinceActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("intent_key_show_type", 101);
        intent.putExtra("intent_province_id_key", str);
        intent.putExtra("intent_province_name_key", str2);
        activity.startActivityForResult(intent, i);
    }

    public static void startArea(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, IRSelectProvinceActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("intent_key_show_type", 103);
        intent.putExtra("intent_city_name_key", str2);
        intent.putExtra("intent_city_id_key", str);
        activity.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.O00000oO = intent.getIntExtra("intent_key_show_type", 0);
        int i = this.O00000oO;
        if (i == 101) {
            str = intent.getStringExtra("intent_province_id_key");
        } else {
            str = i == 103 ? intent.getStringExtra("intent_city_id_key") : null;
        }
        setContentView((int) R.layout.activity_ir_matching_brand);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        View findViewById2 = findViewById(R.id.module_a_3_return_more_more_btn);
        findViewById2.setVisibility(4);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.ir_select_area_title);
        this.O00000o.f17826O000000o = this;
        this.mListView = (ListView) findViewById(R.id.ir_select_tv_brand_list);
        this.O00000Oo = (SideBar) findViewById(R.id.ir_select_index_bar);
        this.O00000o0 = (TextView) findViewById(R.id.ir_select_index_dialog);
        this.f9007O000000o = findViewById(R.id.ir_imi_progress);
        this.O00000oo = (ImageView) findViewById(R.id.ivProgress);
        TextView textView = (TextView) findViewById(R.id.ir_search_text);
        textView.setText((int) R.string.inifrare_search);
        this.O00000Oo.setTextView(this.O00000o0);
        this.O00000Oo.setOnTouchingLetterChangedListener(new SideBar.O000000o() {
            /* class com.xiaomi.smarthome.infrared.activity.IRSelectProvinceActivity.AnonymousClass2 */

            public final void O000000o(String str) {
                int O000000o2 = IRSelectProvinceActivity.this.mAdapter.O000000o(str.charAt(0));
                if (O000000o2 != -1) {
                    IRSelectProvinceActivity.this.mListView.setSelection(O000000o2);
                }
            }
        });
        this.O00000Oo.setVisibility(4);
        this.f9007O000000o.setVisibility(0);
        Drawable drawable = this.O00000oo.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
        int i2 = this.O00000oO;
        if (i2 == 102) {
            gjc gjc = this.O00000o;
            AnonymousClass4 r0 = new fsm<ArrayList<NameIdEntity>, fso>() {
                /* class com.xiaomi.smarthome.infrared.activity.IRSelectProvinceActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    IRSelectProvinceActivity iRSelectProvinceActivity = IRSelectProvinceActivity.this;
                    iRSelectProvinceActivity.mList = (ArrayList) obj;
                    iRSelectProvinceActivity.onRefreshListView();
                    IRSelectProvinceActivity.this.closeMissProgressBar();
                }

                public final void onFailure(fso fso) {
                    IRSelectProvinceActivity.this.closeMissProgressBar();
                }
            };
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/ircode/area/provinces/china").O000000o(arrayList).O000000o();
            gjc.O000000o o000000o = new gjc.O000000o(r0);
            gjc.O000000o(CoreApi.O000000o().O000000o(gjc.f17826O000000o, O000000o2, new fss<ArrayList<NameIdEntity>>() {
                /* class _m_j.gjc.AnonymousClass9 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return NameIdEntity.O000000o(jSONObject.optJSONArray("provinces"));
                }
            }, Crypto.RC4, o000000o), o000000o);
        } else if (i2 == 101) {
            gjc gjc2 = this.O00000o;
            AnonymousClass3 r2 = new fsm<ArrayList<NameIdEntity>, fso>() {
                /* class com.xiaomi.smarthome.infrared.activity.IRSelectProvinceActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    IRSelectProvinceActivity iRSelectProvinceActivity = IRSelectProvinceActivity.this;
                    iRSelectProvinceActivity.mList = (ArrayList) obj;
                    iRSelectProvinceActivity.onRefreshListView();
                    IRSelectProvinceActivity.this.closeMissProgressBar();
                }

                public final void onFailure(fso fso) {
                    IRSelectProvinceActivity.this.closeMissProgressBar();
                }
            };
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("province_id", Integer.parseInt(str));
            } catch (Throwable th) {
                Log.e("InifraredRequestApi", "requestAllCity", th);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new KeyValuePair("data", jSONObject2.toString()));
            NetRequest O000000o3 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/ircode/area/province/cities").O000000o(arrayList2).O000000o();
            gjc.O000000o o000000o2 = new gjc.O000000o(r2);
            gjc2.O000000o(CoreApi.O000000o().O000000o(gjc2.f17826O000000o, O000000o3, new fss<ArrayList<NameIdEntity>>() {
                /* class _m_j.gjc.AnonymousClass8 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return NameIdEntity.O000000o(jSONObject.optJSONArray("cities"));
                }
            }, Crypto.RC4, o000000o2), o000000o2);
        } else if (i2 == 103) {
            gjc gjc3 = this.O00000o;
            AnonymousClass5 r22 = new fsm<ArrayList<NameIdEntity>, fso>() {
                /* class com.xiaomi.smarthome.infrared.activity.IRSelectProvinceActivity.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    IRSelectProvinceActivity iRSelectProvinceActivity = IRSelectProvinceActivity.this;
                    iRSelectProvinceActivity.mList = (ArrayList) obj;
                    iRSelectProvinceActivity.onRefreshListView();
                    IRSelectProvinceActivity.this.closeMissProgressBar();
                }

                public final void onFailure(fso fso) {
                    IRSelectProvinceActivity.this.closeMissProgressBar();
                }
            };
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("city_id", Integer.parseInt(str));
            } catch (Throwable th2) {
                Log.e("InifraredRequestApi", "requestAllArea", th2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(new KeyValuePair("data", jSONObject3.toString()));
            NetRequest O000000o4 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/ircode/area/city/areas").O000000o(arrayList3).O000000o();
            gjc.O000000o o000000o3 = new gjc.O000000o(r22);
            gjc3.O000000o(CoreApi.O000000o().O000000o(gjc3.f17826O000000o, O000000o4, new fss<ArrayList<NameIdEntity>>() {
                /* class _m_j.gjc.AnonymousClass10 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return NameIdEntity.O000000o(jSONObject.optJSONArray("areas"));
                }
            }, Crypto.RC4, o000000o3), o000000o3);
        }
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        textView.setOnClickListener(this);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.infrared.activity.IRSelectProvinceActivity.AnonymousClass1 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                IRSelectProvinceActivity.this.selectLocation(IRSelectProvinceActivity.this.mList.get(i));
            }
        });
    }

    public void closeMissProgressBar() {
        this.f9007O000000o.setVisibility(8);
        Drawable drawable = this.O00000oo.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void selectLocation(NameIdEntity nameIdEntity) {
        int i = this.O00000oO;
        if (i == 103) {
            String str = nameIdEntity.f9041O000000o;
            String str2 = nameIdEntity.O00000Oo;
            Intent intent = getIntent();
            intent.putExtra("intent_area_name_key", str2);
            intent.putExtra("intent_area_id_key", str);
            intent.putExtra("xmplugin_finish_location", true);
            setResult(-1, intent);
            onBackPressed();
        } else if (i == 102) {
            String str3 = nameIdEntity.f9041O000000o;
            startCity(this, String.valueOf(str3), nameIdEntity.O00000Oo, 101);
        } else {
            String str4 = nameIdEntity.f9041O000000o;
            startArea(this, String.valueOf(str4), nameIdEntity.O00000Oo, 102);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            finish();
        } else if (id == R.id.ir_search_text) {
            IRSearchProvinceActivity.showActivity(this, this.mList, this.O00000oO);
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
    }

    public void onRefreshListView() {
        gil gil = this.mAdapter;
        if (gil == null) {
            this.mAdapter = new gil(this, this.mList);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            return;
        }
        gil.O000000o(this.mList);
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000o.O000000o();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            return;
        }
        if (intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        } else if (intent.getBooleanExtra("xmplugin_finish_location", false)) {
            setResult(-1, intent);
            finish();
        } else if (i == this.O00000oO && -1 == i2) {
            selectLocation((NameIdEntity) intent.getParcelableExtra("intent_location_key"));
        }
    }
}
