package com.xiaomi.smarthome.scene.pluginrecommend;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.hjp;
import _m_j.hna;
import _m_j.hps;
import _m_j.hpt;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxr;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.DeviceCategory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.pluginrecommend.LightConditionActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LightConditionActivity extends BaseActivity implements View.OnClickListener {
    private static String O0000OOo = "{\"1003\":{\"loock.lock.v6\":\"https://www.xiaomiyoupin.com/detail?gid=109790\",\"loock.lock.v5\":\"https://www.xiaomiyoupin.com/detail?gid=108055\",\"lumi.lock.mcn01\":\"https://www.xiaomiyoupin.com/detail?gid=105377\"},\"1001\":{\"lumi.sensor_motion.aq2\":\"https://www.xiaomiyoupin.com/detail?gid=730&pid=2651\",\"lumi.sensor_motion.v2\":\"https://www.xiaomiyoupin.com/detail?gid=103152&pid=15148\"},\"1002\":{\"lumi.sensor_magnet.v2\":\"https://www.xiaomiyoupin.com/detail?gid=101464\"},\"zigbee_gateway\":{\"lumi.gateway.v3\":\"https://www.xiaomiyoupin.com/detail?gid=103292\"},\"ble_gateway\":{\"xiaomi.wifispeaker.lx04\":\"https://www.xiaomiyoupin.com/detail?gid=105569\",\"zimi.clock.myk01\":\"https://www.xiaomiyoupin.com/detail?gid=103705\"}}";

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f11198O000000o;
    private View O00000Oo;
    private TextView O00000o;
    private View O00000o0;
    private O0000O0o O00000oO;
    private SharedPreferences O00000oo;
    private ImageView O0000O0o;
    public O000000o buyAdapter;
    public List<SceneApi.O000000o> data = new ArrayList();
    public String deviceModel;
    public Home home;
    public boolean isNeedBle = false;
    public boolean isOnlyCondition = true;
    public boolean isShowBleBuyGuide = true;
    public Set<String> offLineBleLockDids = new HashSet();
    public RecyclerView rcBuyList;
    public int srId;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.light_rec_scene_condition_activity);
        this.isNeedBle = getIntent().getBooleanExtra("is_need_ble", false);
        this.srId = getIntent().getIntExtra("sr_id", -1);
        this.home = ggb.O00000Oo().O00000o(getIntent().getStringExtra("home_id"));
        if (this.home == null) {
            this.home = ggb.O00000Oo().O0000Oo0();
        }
        this.deviceModel = getIntent().getStringExtra("device_model");
        this.f11198O000000o = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
        if (hpt.O000000o().f492O000000o.mConditionList.size() > 0) {
            String str = hpt.O000000o().f492O000000o.mConditionList.get(0).name;
            TextView textView = this.f11198O000000o;
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            objArr[0] = str;
            textView.setText(getString(R.string.light_rec_condition_name, objArr));
        } else {
            this.f11198O000000o.setText(getString(R.string.light_rec_condition_name, new Object[]{""}));
        }
        if (hpt.O000000o().O00000oO != null && hpt.O000000o().O00000oO.size() > 0) {
            for (Map.Entry<String, List<SceneApi.O000000o>> value : hpt.O000000o().O00000oO.entrySet()) {
                this.data.addAll((Collection) value.getValue());
            }
        }
        if (this.data.size() > 0) {
            hxr hxr = hxi.O00000oO;
            String str2 = this.deviceModel;
            StringBuilder sb = new StringBuilder();
            sb.append(this.srId);
            hxr.O00000Oo(str2, sb.toString());
            if (this.isNeedBle) {
                O000000o();
            } else {
                showConditionList();
            }
        } else {
            showBuyGuide();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
     arg types: [com.xiaomi.smarthome.scene.pluginrecommend.LightConditionActivity, int, int, int]
     candidates:
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
    public void showBuyGuide() {
        boolean z;
        if (this.O00000o0 == null) {
            this.O00000o0 = ((ViewStub) findViewById(R.id.vs_buy_guide)).inflate();
        }
        View view = this.O00000Oo;
        if (view != null) {
            view.setVisibility(8);
        }
        this.O00000o0.findViewById(R.id.common_white_empty_view).setBackgroundColor(Color.parseColor("#f7f7f7"));
        this.O00000o0.findViewById(R.id.common_white_empty_view).setVisibility(0);
        ((ImageView) this.O00000o0.findViewById(R.id.empty_icon)).setImageResource(R.drawable.ic_plug_rec_action_empty_1000);
        String string = getString(R.string.light_rec_non_condition_type0, new Object[]{hpt.O000000o().f492O000000o.mConditionList.get(0).name});
        this.rcBuyList = (RecyclerView) this.O00000o0.findViewById(R.id.buy_list);
        this.rcBuyList.setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
        this.buyAdapter = new O000000o();
        this.rcBuyList.setAdapter(this.buyAdapter);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append(this.srId);
        arrayList.add(sb.toString());
        int i = this.srId;
        if (i == 1001 || i == 1002) {
            Iterator<Device> it = hna.O00000o0().getGatewayDevices(null).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals(ggb.O00000Oo().O0000o0(it.next().did).getId(), this.home.getId())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                this.isOnlyCondition = false;
                arrayList.add("zigbee_gateway");
                string = getString(R.string.light_rec_non_condition_type1, new Object[]{hpt.O000000o().f492O000000o.mConditionList.get(0).name});
                hxr hxr = hxi.O00000oO;
                String str = this.deviceModel;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.srId);
                hxr.O00000o(str, sb2.toString());
            } else {
                this.isOnlyCondition = true;
                hxr hxr2 = hxi.O00000oO;
                String str2 = this.deviceModel;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.srId);
                hxr2.O00000o0(str2, sb3.toString());
            }
        } else if (i == 1003) {
            if (this.data.size() > 0) {
                arrayList.clear();
            } else {
                List<Device> O000000o2 = hpt.O000000o(this.home.getId());
                if (O000000o2 == null || O000000o2.size() == 0) {
                    this.isOnlyCondition = false;
                    arrayList.add("ble_gateway");
                    string = getString(R.string.light_rec_non_condition_type2, new Object[]{hpt.O000000o().f492O000000o.mConditionList.get(0).name});
                    hxr hxr3 = hxi.O00000oO;
                    String str3 = this.deviceModel;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.srId);
                    hxr3.O00000o(str3, sb4.toString());
                } else {
                    this.isOnlyCondition = true;
                    hxr hxr4 = hxi.O00000oO;
                    String str4 = this.deviceModel;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.srId);
                    hxr4.O00000o0(str4, sb5.toString());
                }
            }
        }
        ((TextView) this.O00000o0.findViewById(R.id.common_white_empty_text)).setText(string);
        O000000o(arrayList, new fsm<List<JSONObject>, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.LightConditionActivity.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                LightConditionActivity.this.rcBuyList.setVisibility(0);
                O000000o o000000o = LightConditionActivity.this.buyAdapter;
                o000000o.f11203O000000o.clear();
                o000000o.f11203O000000o.addAll((List) obj);
                LightConditionActivity.this.buyAdapter.notifyDataSetChanged();
            }

            public final void onFailure(fso fso) {
                LightConditionActivity.this.rcBuyList.setVisibility(8);
            }
        });
    }

    public void showConditionList() {
        if (this.O00000Oo == null) {
            this.O00000Oo = ((ViewStub) findViewById(R.id.vs_condition_list)).inflate();
            this.O00000o = (TextView) this.O00000Oo.findViewById(R.id.tv_not_connect_ble);
            String string = getString(R.string.light_rec_condition_no_ble);
            int indexOf = string.indexOf("#start#");
            int indexOf2 = string.indexOf("#end#") - 7;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
            AnonymousClass2 r0 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.scene.pluginrecommend.LightConditionActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    List<Device> O000000o2 = hpt.O000000o(LightConditionActivity.this.home.getId());
                    if (O000000o2 == null || O000000o2.size() == 0) {
                        hxr hxr = hxi.O00000oO;
                        String str = LightConditionActivity.this.deviceModel;
                        StringBuilder sb = new StringBuilder();
                        sb.append(LightConditionActivity.this.srId);
                        hxr.O0000Oo0(str, sb.toString());
                        LightConditionActivity lightConditionActivity = LightConditionActivity.this;
                        lightConditionActivity.isShowBleBuyGuide = true;
                        lightConditionActivity.showBuyGuide();
                        return;
                    }
                    hxr hxr2 = hxi.O00000oO;
                    String str2 = LightConditionActivity.this.deviceModel;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(LightConditionActivity.this.srId);
                    hxr2.O0000OOo(str2, sb2.toString());
                    Intent intent = new Intent(LightConditionActivity.this, LockDissConnectBleActivity.class);
                    intent.putExtra("home_id", LightConditionActivity.this.home.getId());
                    LightConditionActivity.this.startActivity(intent);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(LightConditionActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                    textPaint.setUnderlineText(true);
                }
            };
            if (indexOf >= 0 && indexOf2 > 0) {
                try {
                    spannableStringBuilder.setSpan(r0, indexOf, indexOf2, 33);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.O00000o.setText(spannableStringBuilder);
            this.O00000o.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (!this.isNeedBle || this.offLineBleLockDids.size() <= 0) {
            this.O00000o.setVisibility(8);
        } else {
            this.O00000o.setVisibility(0);
            hxr hxr = hxi.O00000oO;
            String str = this.deviceModel;
            StringBuilder sb = new StringBuilder();
            sb.append(this.srId);
            hxr.O0000O0o(str, sb.toString());
        }
        this.O0000O0o = (ImageView) this.O00000Oo.findViewById(R.id.mj_loading);
        RecyclerView recyclerView = (RecyclerView) this.O00000Oo.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.O00000oO = new O0000O0o();
        recyclerView.setAdapter(this.O00000oO);
        View view = this.O00000o0;
        if (view != null) {
            view.setVisibility(8);
        }
        this.O0000O0o.setVisibility(8);
    }

    private void O000000o() {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).O00000o0 != null && isBleLock(this.data.get(i).O00000o0.f11122O000000o)) {
                arrayList.add(this.data.get(i).O00000o0.f11122O000000o);
            }
        }
        if (arrayList.size() > 0) {
            hps.O000000o();
            hps.O000000o(arrayList, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.pluginrecommend.LightConditionActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            JSONArray optJSONArray = jSONObject.optJSONArray((String) arrayList.get(i));
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                LightConditionActivity.this.offLineBleLockDids.add(arrayList.get(i));
                            }
                        }
                    }
                    LightConditionActivity.this.showConditionList();
                }

                public final void onFailure(fso fso) {
                    LightConditionActivity.this.showConditionList();
                }
            });
            return;
        }
        showConditionList();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            finish();
        }
    }

    public boolean isBleLock(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null && DeviceCategory.fromPid(O000000o2.pid) == DeviceCategory.Bluetooth) {
            return true;
        }
        return false;
    }

    private void O000000o(final List<String> list, final fsm<List<JSONObject>, fso> fsm) {
        JSONObject jSONObject;
        String popCache = popCache("scene_rec_result_temp_youpin");
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(popCache)) {
                jSONObject = new JSONObject(O0000OOo);
            } else {
                jSONObject = new JSONObject(popCache);
            }
            for (String next : list) {
                if (jSONObject.has(next)) {
                    arrayList.add(jSONObject.optJSONObject(next));
                }
            }
            fsm.onSuccess(arrayList);
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                JSONObject jSONObject2 = new JSONObject(O0000OOo);
                for (String next2 : list) {
                    if (jSONObject2.has(next2)) {
                        arrayList.add(jSONObject2.optJSONObject(next2));
                    }
                }
                fsm.onSuccess(arrayList);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        hps.O000000o().O000000o(new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.LightConditionActivity.AnonymousClass4 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONObject != null) {
                    for (String str : list) {
                        if (jSONObject.has(str)) {
                            JSONObject optJSONObject = jSONObject.optJSONObject(str);
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(next, optJSONObject.optString(next));
                                    arrayList.add(jSONObject2);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        LightConditionActivity.this.pushCache("scene_rec_result_temp_youpin", jSONObject.toString());
                    }
                }
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(arrayList);
                }
            }
        });
    }

    public void pushCache(String str, String str2) {
        if (this.O00000oo == null) {
            this.O00000oo = ServiceApplication.getAppContext().getSharedPreferences("recommend_scene_buy_guide", 0);
        }
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public String popCache(String str) {
        if (this.O00000oo == null) {
            this.O00000oo = ServiceApplication.getAppContext().getSharedPreferences("recommend_scene_buy_guide", 0);
        }
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, "");
        }
        return "";
    }

    public class O0000O0o extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        public O0000O0o() {
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new O00000o0(LayoutInflater.from(LightConditionActivity.this).inflate((int) R.layout.light_rec_scene_condition_item_1, (ViewGroup) null));
            }
            if (i == 0) {
                return new O00000o(LayoutInflater.from(LightConditionActivity.this).inflate((int) R.layout.light_rec_scene_condition_item_0, (ViewGroup) null));
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0119  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0127  */
        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            String O0000o0O;
            String str = "";
            if (getItemViewType(i) == 0) {
                ggb.O00000Oo();
                String O000000o2 = ggb.O000000o(LightConditionActivity.this.home);
                TextView textView = ((O00000o) o000OOo0).f11205O000000o;
                if (TextUtils.isEmpty(O000000o2)) {
                    O000000o2 = str;
                }
                textView.setText(O000000o2);
                return;
            }
            boolean z = true;
            if (getItemViewType(i) == 1) {
                O00000o0 o00000o0 = (O00000o0) o000OOo0;
                int i2 = i - 1;
                if (LightConditionActivity.this.data.get(i2).O00000o0 != null) {
                    Device O000000o3 = fno.O000000o().O000000o(LightConditionActivity.this.data.get(i2).O00000o0.f11122O000000o);
                    if (O000000o3 == null) {
                        O000000o3 = DeviceFactory.O0000o0O(LightConditionActivity.this.data.get(i2).O00000o0.O00000o);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(TextUtils.isEmpty(LightConditionActivity.this.data.get(i2).O00000o0.O00000o0) ? str : LightConditionActivity.this.data.get(i2).O00000o0.O00000o0);
                    if (LightConditionActivity.this.isNeedBle) {
                        LightConditionActivity lightConditionActivity = LightConditionActivity.this;
                        if (lightConditionActivity.isBleLock(lightConditionActivity.data.get(i2).O00000o0.f11122O000000o)) {
                            if (LightConditionActivity.this.offLineBleLockDids.contains(LightConditionActivity.this.data.get(i2).O00000o0.f11122O000000o)) {
                                sb.append("(");
                                sb.append(LightConditionActivity.this.getString(R.string.cant_connect_ble));
                                sb.append(")");
                            }
                            o00000o0.f11206O000000o.setText(sb.toString());
                            O0000o0O = ggb.O00000Oo().O0000o0O(LightConditionActivity.this.data.get(i2).O00000o0.f11122O000000o);
                            TextView textView2 = o00000o0.O00000oO;
                            if (!TextUtils.isEmpty(O0000o0O)) {
                                str = O0000o0O;
                            }
                            textView2.setText(str);
                            if (O000000o3 == null) {
                                DeviceFactory.O00000Oo(O000000o3.model, o00000o0.O00000oo);
                            } else {
                                DeviceFactory.O00000Oo((String) null, o00000o0.O00000oo);
                            }
                        }
                    }
                    if (!O000000o3.isOnline) {
                        sb.append("(");
                        sb.append(LightConditionActivity.this.getString(R.string.offline_device));
                        sb.append(")");
                    }
                    o00000o0.f11206O000000o.setText(sb.toString());
                    O0000o0O = ggb.O00000Oo().O0000o0O(LightConditionActivity.this.data.get(i2).O00000o0.f11122O000000o);
                    TextView textView22 = o00000o0.O00000oO;
                    if (!TextUtils.isEmpty(O0000o0O)) {
                    }
                    textView22.setText(str);
                    if (O000000o3 == null) {
                    }
                } else {
                    DeviceFactory.O00000Oo((String) null, o00000o0.O00000oo);
                    o00000o0.f11206O000000o.setText(str);
                }
                o00000o0.O00000Oo.setVisibility(i < LightConditionActivity.this.data.size() ? 0 : 8);
                o00000o0.O00000o0.setVisibility(i == LightConditionActivity.this.data.size() ? 0 : 8);
                if (hpt.O000000o().O0000OOo.O0000O0o == null) {
                    hpt.O000000o().O0000OOo.O0000O0o = new ArrayList();
                }
                if (hpt.O000000o().O0000OOo.O0000O0o.size() == 0) {
                    hpt.O000000o().O0000OOo.O0000O0o.add(LightConditionActivity.this.data.get(0));
                }
                SceneApi.O000000o o000000o = hpt.O000000o().O0000OOo.O0000O0o.get(0);
                SceneApi.O000000o o000000o2 = LightConditionActivity.this.data.get(i2);
                if (o000000o == null || o000000o2 == null || o000000o.f11121O000000o != o000000o2.f11121O000000o || o000000o.O00000o0 == null || o000000o2.O00000o0 == null || !TextUtils.equals(o000000o.O00000o0.f11122O000000o, o000000o2.O00000o0.f11122O000000o)) {
                    z = false;
                }
                if (z) {
                    o00000o0.O00000o.setVisibility(0);
                    o00000o0.O00000oO.setTextColor(LightConditionActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                    o00000o0.O00000oO.setAlpha(0.6f);
                    o00000o0.f11206O000000o.setTextColor(LightConditionActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                } else {
                    o00000o0.O00000o.setVisibility(8);
                    o00000o0.O00000oO.setTextColor(LightConditionActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    o00000o0.O00000oO.setAlpha(1.0f);
                    o00000o0.f11206O000000o.setTextColor(LightConditionActivity.this.getResources().getColor(R.color.mj_color_black));
                }
                o00000o0.itemView.setOnClickListener(new View.OnClickListener(i) {
                    /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$LightConditionActivity$O0000O0o$E5_ffrACMI4vPmhYTIlsPjZ43OY */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        LightConditionActivity.O0000O0o.this.O000000o(this.f$1, view);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            hpt.O000000o().O0000OOo.O0000O0o.clear();
            hpt.O000000o().O0000OOo.O0000O0o.add(LightConditionActivity.this.data.get(i - 1));
            notifyDataSetChanged();
            LightConditionActivity.this.setResult(-1);
            LightConditionActivity.this.finish();
        }

        public final int getItemCount() {
            if (LightConditionActivity.this.data == null) {
                return 1;
            }
            return LightConditionActivity.this.data.size() + 1;
        }
    }

    public class O000000o extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        List<JSONObject> f11203O000000o = new ArrayList();

        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            JSONObject jSONObject = this.f11203O000000o.get(i);
            String next = jSONObject.keys().next();
            if (!TextUtils.isEmpty(next)) {
                DeviceFactory.O00000Oo(next, o00000Oo.O00000Oo);
                o00000Oo.f11204O000000o.setText(CoreApi.O000000o().O00000oO(next).O0000Oo0());
                o00000Oo.itemView.setOnClickListener(new View.OnClickListener(next, jSONObject) {
                    /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$LightConditionActivity$O000000o$jvfMy8IfR87XiKAWgVal9AYzooI */
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ JSONObject f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        LightConditionActivity.O000000o.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(String str, JSONObject jSONObject, View view) {
            if (LightConditionActivity.this.data == null || LightConditionActivity.this.data.size() == 0) {
                if (LightConditionActivity.this.isOnlyCondition) {
                    hxk hxk = hxi.O00000o;
                    String str2 = LightConditionActivity.this.deviceModel;
                    StringBuilder sb = new StringBuilder();
                    sb.append(LightConditionActivity.this.srId);
                    hxk.O000000o(str2, sb.toString(), str);
                } else {
                    hxk hxk2 = hxi.O00000o;
                    String str3 = LightConditionActivity.this.deviceModel;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(LightConditionActivity.this.srId);
                    hxk2.O00000Oo(str3, sb2.toString(), str);
                }
            }
            if (LightConditionActivity.this.isShowBleBuyGuide) {
                hxk hxk3 = hxi.O00000o;
                String str4 = LightConditionActivity.this.deviceModel;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(LightConditionActivity.this.srId);
                hxk3.O00000o0(str4, sb3.toString(), str);
            }
            hjp.O000000o(jSONObject.optString(str));
        }

        public final int getItemCount() {
            List<JSONObject> list = this.f11203O000000o;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000Oo(LayoutInflater.from(LightConditionActivity.this).inflate((int) R.layout.light_rec_scene_buy_item, (ViewGroup) null));
        }
    }

    public static class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11206O000000o;
        public View O00000Oo;
        public View O00000o;
        public View O00000o0;
        public TextView O00000oO;
        public SimpleDraweeView O00000oo;

        public O00000o0(View view) {
            super(view);
            this.f11206O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = view.findViewById(R.id.divider_x);
            this.O00000o0 = view.findViewById(R.id.divider_last);
            this.O00000o = view.findViewById(R.id.icon_selected);
            this.O00000oO = (TextView) view.findViewById(R.id.room_name);
            this.O00000oo = (SimpleDraweeView) view.findViewById(R.id.sd_device_img);
        }
    }

    public static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11204O000000o;
        public SimpleDraweeView O00000Oo;

        public O00000Oo(View view) {
            super(view);
            this.f11204O000000o = (TextView) view.findViewById(R.id.model_name);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.sd_model_img);
        }
    }

    public static class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11205O000000o;

        public O00000o(View view) {
            super(view);
            this.f11205O000000o = (TextView) view.findViewById(R.id.tv_room_name);
        }
    }
}
