package com.xiaomi.smarthome.infrared.activity;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.gim;
import _m_j.gir;
import _m_j.gjc;
import _m_j.gje;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.infrared.bean.IRBrandType;
import com.xiaomi.smarthome.infrared.bean.IRSTBData;
import com.xiaomi.smarthome.infrared.bean.IRType;
import com.xiaomi.smarthome.infrared.widget.SideBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class IRMatchingBrandActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private IRSTBData f8997O000000o;
    private gjc O00000Oo = new gjc();
    private View O00000o;
    private TextView O00000o0;
    private ImageView O00000oO;
    public gim mAdapter;
    public ArrayList<IRBrandType> mBranchList = new ArrayList<>();
    public int mDeviceType;
    public ListView mListView;
    public SideBar mSideBar;

    public static void showMatchingBrandActivity(Activity activity, IRSTBData iRSTBData, int i) {
        Intent intent = new Intent(activity, IRMatchingBrandActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("intent_stb_data_key", iRSTBData);
        intent.putExtra("intent_device_type_key", i);
        activity.startActivityForResult(intent, C.MSG_CUSTOM_BASE);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mDeviceType = intent.getIntExtra("intent_device_type_key", 0);
        if (this.mDeviceType == IRType.STB.value()) {
            this.f8997O000000o = (IRSTBData) intent.getParcelableExtra("intent_stb_data_key");
        }
        setContentView((int) R.layout.activity_ir_matching_brand);
        this.O00000Oo.f17826O000000o = this;
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        gir O000000o2 = gje.O000000o(this.mDeviceType);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(String.format(getResources().getString(R.string.ir_matching_brand_title), getResources().getString(O000000o2.O00000Oo)));
        this.mListView = (ListView) findViewById(R.id.ir_select_tv_brand_list);
        this.mAdapter = new gim(this, this.mBranchList);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mSideBar = (SideBar) findViewById(R.id.ir_select_index_bar);
        this.O00000o0 = (TextView) findViewById(R.id.ir_select_index_dialog);
        this.O00000o = findViewById(R.id.ir_imi_progress);
        this.O00000oO = (ImageView) findViewById(R.id.ivProgress);
        TextView textView = (TextView) findViewById(R.id.ir_search_text);
        this.mSideBar.setTextView(this.O00000o0);
        this.mSideBar.setOnTouchingLetterChangedListener(new SideBar.O000000o() {
            /* class com.xiaomi.smarthome.infrared.activity.IRMatchingBrandActivity.AnonymousClass2 */

            public final void O000000o(String str) {
                int O000000o2;
                if (IRMatchingBrandActivity.this.mAdapter != null && (O000000o2 = IRMatchingBrandActivity.this.mAdapter.O000000o(str.charAt(0))) != -1) {
                    IRMatchingBrandActivity.this.mListView.setSelection(O000000o2);
                }
            }
        });
        this.O00000o.setVisibility(0);
        Drawable drawable = this.O00000oO.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
        AnonymousClass3 r0 = new fsm<ArrayList<IRBrandType>, fso>() {
            /* class com.xiaomi.smarthome.infrared.activity.IRMatchingBrandActivity.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                IRMatchingBrandActivity.this.mBranchList.clear();
                IRMatchingBrandActivity.this.mBranchList.addAll((ArrayList) obj);
                Collections.sort(IRMatchingBrandActivity.this.mBranchList);
                if (IRMatchingBrandActivity.this.mDeviceType != IRType.AC.value()) {
                    IRBrandType iRBrandType = new IRBrandType();
                    String string = IRMatchingBrandActivity.this.getResources().getString(R.string.ir_device_type_unknown);
                    iRBrandType.f9036O000000o = string;
                    iRBrandType.O00000o = string;
                    iRBrandType.O00000o0 = "#";
                    iRBrandType.O00000oO = "#";
                    IRMatchingBrandActivity.this.mBranchList.add(iRBrandType);
                }
                ArrayList arrayList = new ArrayList();
                String str = null;
                Iterator<IRBrandType> it = IRMatchingBrandActivity.this.mBranchList.iterator();
                while (it.hasNext()) {
                    IRBrandType next = it.next();
                    if (!TextUtils.equals(str, next.O00000oO)) {
                        str = next.O00000oO;
                        arrayList.add(str);
                    }
                }
                SideBar.f9045O000000o = (String[]) arrayList.toArray(new String[arrayList.size()]);
                IRMatchingBrandActivity.this.mSideBar.invalidate();
                IRMatchingBrandActivity.this.mAdapter.notifyDataSetChanged();
                IRMatchingBrandActivity.this.closeMissProgressBar();
            }

            public final void onFailure(fso fso) {
                IRMatchingBrandActivity.this.closeMissProgressBar();
            }
        };
        if (this.mDeviceType == IRType.STB.value()) {
            gjc gjc = this.O00000Oo;
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            NetRequest O000000o3 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/ircode/iptv/brands").O000000o(arrayList).O000000o();
            gjc.O000000o o000000o = new gjc.O000000o(r0);
            gjc.O000000o(CoreApi.O000000o().O000000o(gjc.f17826O000000o, O000000o3, new fss<ArrayList<IRBrandType>>() {
                /* class _m_j.gjc.AnonymousClass11 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return IRBrandType.O000000o(jSONObject.optJSONArray("brands"));
                }
            }, Crypto.RC4, o000000o), o000000o);
        } else {
            gjc gjc2 = this.O00000Oo;
            int i = this.mDeviceType;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("category", i);
            } catch (Throwable th) {
                Log.e("InifraredRequestApi", "requestStandardBrand", th);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new KeyValuePair("data", jSONObject2.toString()));
            NetRequest O000000o4 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/ircode/category/brands").O000000o(arrayList2).O000000o();
            gjc.O000000o o000000o2 = new gjc.O000000o(r0);
            gjc2.O000000o(CoreApi.O000000o().O000000o(gjc2.f17826O000000o, O000000o4, new fss<ArrayList<IRBrandType>>() {
                /* class _m_j.gjc.AnonymousClass12 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return IRBrandType.O000000o(jSONObject.optJSONArray("brands"));
                }
            }, Crypto.RC4, o000000o2), o000000o2);
        }
        findViewById.setOnClickListener(this);
        textView.setOnClickListener(this);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.infrared.activity.IRMatchingBrandActivity.AnonymousClass1 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                IRMatchingBrandActivity iRMatchingBrandActivity = IRMatchingBrandActivity.this;
                iRMatchingBrandActivity.doItemClick(iRMatchingBrandActivity.mBranchList.get(i));
            }
        });
    }

    public void closeMissProgressBar() {
        this.O00000o.setVisibility(8);
        Drawable drawable = this.O00000oO.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            finish();
        } else if (id == R.id.ir_search_text) {
            IRSearchActivity.showSearchActivity(this, this.mBranchList, 11);
        }
    }

    public void doItemClick(IRBrandType iRBrandType) {
        if (getResources().getString(R.string.ir_device_type_unknown).equals(iRBrandType.f9036O000000o)) {
            Intent intent = new Intent(this, IRStudyActivity.class);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            }
            intent.putExtra("intent_device_type_key", this.mDeviceType);
            startActivityForResult(intent, C.MSG_CUSTOM_BASE);
        } else if (this.mDeviceType == IRType.STB.value()) {
            this.f8997O000000o.O00000o0 = iRBrandType.O00000Oo;
            this.f8997O000000o.O00000oO = iRBrandType.f9036O000000o;
            IRSingleMatchBaseActivity.showStbSingleMatchActivity(this, IRType.STB.value(), this.f8997O000000o);
        } else {
            IRSingleMatchBaseActivity.showSingleMatchActivity(this, this.mDeviceType, iRBrandType.O00000Oo, iRBrandType);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000Oo.O000000o();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            boolean z = false;
            if (intent.getBooleanExtra("infrared_finish", false)) {
                setResult(-1, intent);
                finish();
                return;
            }
            boolean z2 = 11 == i;
            if (-1 == i2) {
                z = true;
            }
            if (z2 && z) {
                doItemClick((IRBrandType) intent.getParcelableExtra("intent_IRBrandType_key"));
            }
        }
    }
}
