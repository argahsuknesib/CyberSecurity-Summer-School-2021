package com.xiaomi.smarthome.scene.activity;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqg;
import _m_j.hjp;
import _m_j.hnw;
import _m_j.hps;
import _m_j.hpt;
import _m_j.hqy;
import _m_j.hxi;
import _m_j.hxr;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginRecommendSceneActionActivity extends BaseActivity {
    private static String O00000oO = "{\"1000\":{\"xiaomi.wifispeaker.lx06\":\"https://m.xiaomiyoupin.com/detail?gid=113331&source=mijia_p_sh2009\",\"xiaomi.wifispeaker.l06a \":\"https://m.xiaomiyoupin.com/detail?gid=113328&source=mijia_p_sh2010\",\"xiaomi.wifispeaker.lx04\":\"https://m.xiaomiyoupin.com/detail?gid=105569&source=mijia_p_sh2011\",\"xiaomi.wifispeaker.lx5a\":\"https://m.xiaomiyoupin.com/detail?gid=107496&source=mijia_p_sh2012\",\"xiaomi.wifispeaker.lx05\":\"https://m.xiaomiyoupin.com/detail?gid=108117&source=mijia_p_sh2013\",\"zimi.clock.myk01\":\"https://m.xiaomiyoupin.com/detail?gid=103705&source=mijia_p_sh2014\"}}";

    /* renamed from: O000000o  reason: collision with root package name */
    private String f10790O000000o;
    private int O00000Oo = -2;
    private View O00000o;
    private TextView O00000o0;
    private View O00000oo;
    private SharedPreferences O0000O0o;
    public O0000O0o adapter;
    public O00000o0 buyAdapter;
    public Device conditionDevice;
    public SceneApi.O000OOOo curScene;
    public List<O0000Oo0> data = new ArrayList();
    public XQProgressDialog mPD;
    public RecyclerView rcBuyList;
    public int selectedPos = 0;

    public static class O0000Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10803O000000o = 1;
        public Device O00000Oo;
        public SceneApi.Action O00000o0;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_plugin_recommend_scene_action);
        this.f10790O000000o = getIntent().getStringExtra("home_id");
        this.conditionDevice = fno.O000000o().O000000o(getIntent().getStringExtra("did"));
        this.O00000Oo = getIntent().getIntExtra("connect_ble", -2);
        this.O00000o0 = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActionActivity$MpHF7AMpujHDEMDVflMQFXrrGiM */

            public final void onClick(View view) {
                PluginRecommendSceneActionActivity.this.O00000Oo(view);
            }
        });
        if (this.O00000Oo == -1) {
            finish();
            return;
        }
        this.curScene = hpt.O000000o().O0000OOo;
        if (this.curScene == null) {
            finish();
            return;
        }
        hxr hxr = hxi.O00000oO;
        String str = this.conditionDevice.model;
        hxr.f958O000000o.O000000o("recommend_lockspeaker_chosespeaker", "model", str);
        int i = this.O00000Oo;
        if (i == 0) {
            final List<Device> O000000o2 = hpt.O000000o(this.f10790O000000o);
            if (O000000o2 == null || O000000o2.size() == 0) {
                O000000o();
                return;
            }
            if (hpt.O000000o().f492O000000o != null && !TextUtils.isEmpty(hpt.O000000o().f492O000000o.entryDesc)) {
                this.O00000o0.setText(hpt.O000000o().f492O000000o.intro);
            }
            RecyclerView recyclerView = (RecyclerView) ((ViewStub) findViewById(R.id.ble_list_view)).inflate().findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new RecyclerView.O000000o<O00000Oo>() {
                /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity.AnonymousClass4 */

                public final long getItemId(int i) {
                    return (long) i;
                }

                public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                    O00000Oo o00000Oo = (O00000Oo) o000OOo0;
                    if (i == O000000o2.size() - 1) {
                        o00000Oo.O00000o0.setVisibility(0);
                    } else {
                        o00000Oo.O00000o0.setVisibility(8);
                    }
                    String str = ((Device) O000000o2.get(i)).name;
                    if (!TextUtils.isEmpty(str)) {
                        o00000Oo.O00000Oo.setText(str);
                    } else {
                        o00000Oo.O00000Oo.setText("");
                    }
                    DeviceFactory.O00000Oo(((Device) O000000o2.get(i)).model, o00000Oo.f10798O000000o);
                }

                public final int getItemCount() {
                    List list = O000000o2;
                    if (list == null) {
                        return 0;
                    }
                    return list.size();
                }

                public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                    return new O00000Oo(LayoutInflater.from(PluginRecommendSceneActionActivity.this).inflate((int) R.layout.item_plugin_rec_action_connect_ble, (ViewGroup) null));
                }
            });
        } else if (i == 1) {
            Map<String, List<SceneApi.Action>> map = hpt.O000000o().O00000oo;
            this.data.clear();
            for (Map.Entry<String, List<SceneApi.Action>> value : map.entrySet()) {
                for (SceneApi.Action action : (List) value.getValue()) {
                    O0000Oo0 o0000Oo0 = new O0000Oo0();
                    o0000Oo0.O00000o0 = action;
                    o0000Oo0.O00000Oo = fno.O000000o().O000000o(action.O0000O0o.O00000o);
                    o0000Oo0.O00000o0.O0000O0o.O00000o = o0000Oo0.O00000Oo.did;
                    if (!(o0000Oo0.O00000Oo == null || action == null)) {
                        this.data.add(o0000Oo0);
                    }
                }
            }
            List<O0000Oo0> list = this.data;
            if (list == null || list.size() == 0) {
                O000000o();
                return;
            }
            O0000Oo0 o0000Oo02 = new O0000Oo0();
            o0000Oo02.f10803O000000o = 2;
            this.data.add(o0000Oo02);
            View inflate = ((ViewStub) findViewById(R.id.action_list_view)).inflate();
            this.O00000o = inflate.findViewById(R.id.next_step);
            RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R.id.recycler_view);
            recyclerView2.setLayoutManager(new LinearLayoutManager(this));
            this.adapter = new O0000O0o();
            recyclerView2.setAdapter(this.adapter);
            if (this.curScene.O00000oo != null && this.curScene.O00000oo.size() > 0 && (this.curScene.O00000oo.get(0).O0000O0o instanceof SceneApi.O000OO0o)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.data.size()) {
                        break;
                    } else if (TextUtils.equals(((SceneApi.O000OO0o) this.curScene.O00000oo.get(0).O0000O0o).O00000o, this.data.get(i2).O00000Oo.did)) {
                        this.selectedPos = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
                this.O00000o0.setText((int) R.string.setting);
            } else {
                this.O00000o0.setText(getString(R.string.plugin_rec_setting_title, new Object[]{hpt.O000000o().f492O000000o.intro}));
            }
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActionActivity$uhwMaU3uamviB8AUZEbaOiuxXWY */

                public final void onClick(View view) {
                    PluginRecommendSceneActionActivity.this.O000000o(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1011) {
            O0000O0o o0000O0o = this.adapter;
            if (o0000O0o != null) {
                o0000O0o.notifyDataSetChanged();
            }
            SceneApi.O000OOOo o000OOOo = this.curScene;
            if (o000OOOo != null && !TextUtils.isEmpty(o000OOOo.f11131O000000o)) {
                this.mPD = XQProgressDialog.O000000o(this, null, getResources().getString(R.string.smarthome_scene_saving_scene));
                SceneApi.O000OOOo o000OOOo2 = this.curScene;
                if (o000OOOo2 == null || o000OOOo2.O00000oo == null || this.curScene.O00000oo.size() == 0 || this.curScene.O0000O0o == null || this.curScene.O0000O0o.size() == 0) {
                    if (isValid()) {
                        this.mPD.dismiss();
                    }
                    gqg.O00000Oo((int) R.string.save_fail);
                    return;
                }
                hpt.O000000o(this.curScene, new hqy() {
                    /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity.AnonymousClass1 */

                    public final void onSaveLocalFail() {
                        if (PluginRecommendSceneActionActivity.this.isValid()) {
                            PluginRecommendSceneActionActivity.this.mPD.dismiss();
                            gqg.O00000Oo((int) R.string.save_fail);
                        }
                    }

                    public final void onSaveCloudSuccess(boolean z) {
                        if (PluginRecommendSceneActionActivity.this.isValid()) {
                            PluginRecommendSceneActionActivity.this.mPD.dismiss();
                            gqg.O00000Oo((int) R.string.save_success);
                        }
                    }

                    public final void onSaveCloudFail(int i, String str) {
                        if (PluginRecommendSceneActionActivity.this.isValid()) {
                            PluginRecommendSceneActionActivity.this.mPD.dismiss();
                            gqg.O00000Oo((int) R.string.save_fail);
                            if (PluginRecommendSceneActionActivity.this.adapter != null) {
                                PluginRecommendSceneActionActivity.this.adapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        Object obj;
        int i = this.selectedPos;
        if (i >= 0 && i < this.data.size() && this.data.get(this.selectedPos).O00000o0.f11120O000000o == 0 && ((SceneApi.O000OO0o) this.data.get(this.selectedPos).O00000o0.O0000O0o).O0000Oo0 != null) {
            final O0000Oo0 o0000Oo0 = this.data.get(this.selectedPos);
            final Intent intent = new Intent(((SceneApi.O000OO0o) o0000Oo0.O00000o0.O0000O0o).O0000Oo0);
            intent.putExtra("action", o0000Oo0.O00000o0.O0000O0o.O00000o0);
            SceneApi.Action action = o0000Oo0.O00000o0;
            SceneApi.O000OOOo o000OOOo = this.curScene;
            Object obj2 = null;
            if (o000OOOo != null && o000OOOo.O00000oo != null && this.curScene.O00000oo.size() > 0 && TextUtils.equals("1000", hpt.O000000o().f492O000000o.sr_id)) {
                SceneApi.Action action2 = this.curScene.O00000oo.get(0);
                if (!TextUtils.isEmpty(action.O00000oO) && TextUtils.equals(action2.O00000oO, action.O00000oO) && action2.f11120O000000o == 0 && action.f11120O000000o == 0 && (action2.O0000O0o instanceof SceneApi.O000OO0o) && (obj = ((SceneApi.O000OO0o) action2.O0000O0o).O00000oO) != null) {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str)) {
                            obj2 = str;
                        }
                    }
                    if (obj instanceof JSONObject) {
                        obj2 = (JSONObject) obj;
                    } else if (obj instanceof JSONArray) {
                        obj2 = (JSONArray) obj;
                    }
                }
            }
            if (obj2 != null && (obj2 instanceof String)) {
                intent.putExtra("value", (String) obj2);
            } else if (obj2 != null) {
                intent.putExtra("value", obj2.toString());
            }
            intent.putExtra("actionId", o0000Oo0.O00000o0.O00000oo);
            intent.putExtra("plug_id", ((SceneApi.O000OO0o) o0000Oo0.O00000o0.O0000O0o).O0000Oo0);
            intent.putExtra("name", o0000Oo0.O00000o0.O00000Oo);
            intent.putExtra("tr_id", o0000Oo0.O00000o0.O00000o);
            intent.putExtra("scene_type", 2);
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity.AnonymousClass5 */

                public final void run() {
                    PluginRecommendSceneActionActivity.this.sendMessage(o0000Oo0, 3, intent);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
     arg types: [com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity, int, int, int]
     candidates:
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
    private void O000000o() {
        hxi.O00000oO.O00000Oo("lockspeaker");
        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
            this.O00000o0.setText((int) R.string.setting);
        } else {
            this.O00000o0.setText(getString(R.string.plugin_rec_setting_title, new Object[]{hpt.O000000o().f492O000000o.intro}));
        }
        if (this.O00000oo == null) {
            this.O00000oo = ((ViewStub) findViewById(R.id.vs_buy_guide)).inflate();
        }
        this.O00000oo.findViewById(R.id.common_white_empty_view).setBackgroundColor(Color.parseColor("#f7f7f7"));
        this.O00000oo.findViewById(R.id.common_white_empty_view).setVisibility(0);
        ((ImageView) this.O00000oo.findViewById(R.id.empty_icon)).setImageResource(R.drawable.ic_plug_rec_action_empty_1000);
        this.rcBuyList = (RecyclerView) this.O00000oo.findViewById(R.id.buy_list);
        this.rcBuyList.setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
        this.buyAdapter = new O00000o0();
        this.rcBuyList.setAdapter(this.buyAdapter);
        TextView textView = (TextView) this.O00000oo.findViewById(R.id.common_white_empty_text);
        if (hpt.O000000o().f492O000000o == null || !TextUtils.equals(hpt.O000000o().f492O000000o.sr_id, "1000")) {
            textView.setText((int) R.string.rec_action_empty);
        } else {
            textView.setText((int) R.string.plugin_rec_action_no_speaker);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(hpt.O000000o().f492O000000o.sr_id);
        O000000o(arrayList, new fsm<List<JSONObject>, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                PluginRecommendSceneActionActivity.this.rcBuyList.setVisibility(0);
                O00000o0 o00000o0 = PluginRecommendSceneActionActivity.this.buyAdapter;
                o00000o0.f10800O000000o.clear();
                o00000o0.f10800O000000o.addAll((List) obj);
                PluginRecommendSceneActionActivity.this.buyAdapter.notifyDataSetChanged();
            }

            public final void onFailure(fso fso) {
                PluginRecommendSceneActionActivity.this.rcBuyList.setVisibility(8);
            }
        });
    }

    private void O000000o(final List<String> list, final fsm<List<JSONObject>, fso> fsm) {
        JSONObject jSONObject;
        String popCache = popCache("scene_rec_result_temp_youpin");
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(popCache)) {
                jSONObject = new JSONObject(O00000oO);
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
                JSONObject jSONObject2 = new JSONObject(O00000oO);
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
            /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity.AnonymousClass3 */

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
                        PluginRecommendSceneActionActivity.this.pushCache("scene_rec_result_temp_youpin", jSONObject.toString());
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
        if (this.O0000O0o == null) {
            this.O0000O0o = ServiceApplication.getAppContext().getSharedPreferences("recommend_scene_buy_guide", 0);
        }
        SharedPreferences sharedPreferences = this.O0000O0o;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public String popCache(String str) {
        if (this.O0000O0o == null) {
            this.O0000O0o = ServiceApplication.getAppContext().getSharedPreferences("recommend_scene_buy_guide", 0);
        }
        SharedPreferences sharedPreferences = this.O0000O0o;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, "");
        }
        return "";
    }

    public void onActionSelected(int i, SceneApi.Action action, Intent intent) {
        if (i == -1 && intent != null && intent.hasExtra("value") && intent.getStringExtra("value") != null) {
            if (intent != null && intent.hasExtra("key_name")) {
                action.O00000o0 = intent.getStringExtra("key_name");
            }
            SceneApi.O000OO0o o000OO0o = new SceneApi.O000OO0o();
            o000OO0o.O00000o = action.O0000O0o.O00000o;
            o000OO0o.O0000OOo = ((SceneApi.O000OO0o) action.O0000O0o).O0000OOo;
            o000OO0o.O00000o0 = ((SceneApi.O000OO0o) action.O0000O0o).O00000o0;
            o000OO0o.O0000Oo0 = ((SceneApi.O000OO0o) action.O0000O0o).O0000Oo0;
            if (intent == null || !intent.hasExtra("value")) {
                o000OO0o.O00000oO = action.O0000O0o.O00000oO;
            } else if (intent.getStringExtra("value") != null) {
                boolean z = false;
                try {
                    o000OO0o.O00000oO = new JSONObject(intent.getStringExtra("value"));
                    z = true;
                } catch (JSONException unused) {
                }
                if (!z) {
                    try {
                        o000OO0o.O00000oO = new JSONArray(intent.getStringExtra("value"));
                        z = true;
                    } catch (JSONException unused2) {
                    }
                }
                if (!z) {
                    o000OO0o.O00000oO = intent.getStringExtra("value");
                }
            } else {
                o000OO0o.O00000oO = intent.getExtras().get("value");
            }
            action.O0000O0o = o000OO0o;
            if (this.curScene.O00000oo == null) {
                this.curScene.O00000oo = new ArrayList();
            }
            if (this.curScene.O00000oo.size() == 0) {
                this.curScene.O00000oo.add(action);
            } else {
                this.curScene.O00000oo.clear();
                this.curScene.O00000oo.add(action);
            }
            setResult(-1);
            finish();
        }
    }

    public void sendMessage(O0000Oo0 o0000Oo0, int i, Intent intent) {
        O0000Oo0 o0000Oo02 = o0000Oo0;
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(o0000Oo02.O00000Oo.model);
        final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(this, getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0() + getString(R.string.plugin));
        final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        final boolean z = CoreApi.O000000o().O0000Oo(o0000Oo02.O00000Oo.model) == null && CoreApi.O000000o().O0000OoO(o0000Oo02.O00000Oo.model) == null;
        PluginApi instance = PluginApi.getInstance();
        String str = o0000Oo02.O00000Oo.model;
        DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat(o0000Oo02.O00000Oo);
        final O0000Oo0 o0000Oo03 = o0000Oo0;
        instance.sendMessage(this, str, i, intent, newDeviceStat, null, true, new SendMessageCallback() {
            /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActionActivity.AnonymousClass6 */

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                pluginDownloadTask.O000000o(pluginDownloadTask);
                if (O000000o2 != null && !PluginRecommendSceneActionActivity.this.isFinishing() && !PluginRecommendSceneActionActivity.this.isDestroyed()) {
                    O000000o2.O000000o(100, 0);
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    xQProgressHorizontalDialog.f9117O000000o = false;
                    xQProgressHorizontalDialog.setCancelable(true);
                    O000000o2.show();
                    O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener(pluginDownloadTask) {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActionActivity$6$zV6DM6FxYShzLDsCb9rZrRWYgyI */
                        private final /* synthetic */ PluginDownloadTask f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            CoreApi.O000000o().O000000o(PluginRecommendSceneActionActivity.O0000Oo0.this.O00000Oo.model, this.f$1);
                        }
                    });
                }
            }

            public final void onDownloadProgress(String str, float f) {
                if (z) {
                    int i = (int) (f * 100.0f);
                    if (i >= 99) {
                        i = 99;
                    }
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.O000000o(100, i);
                        return;
                    }
                    return;
                }
                XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                if (xQProgressHorizontalDialog2 != null) {
                    xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (!z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onSendSuccess(Bundle bundle) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onSendFailure(fso fso) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onSendCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(O0000Oo0 o0000Oo0, Intent intent) {
                PluginRecommendSceneActionActivity.this.onActionSelected(-1, o0000Oo0.O00000o0, intent);
            }

            public final void onMessageSuccess(Intent intent) {
                PluginRecommendSceneActionActivity.this.mHandler.post(new Runnable(o0000Oo03, intent) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActionActivity$6$lKAM31M9Le2sdX07F4JoCIMNE3I */
                    private final /* synthetic */ PluginRecommendSceneActionActivity.O0000Oo0 f$1;
                    private final /* synthetic */ Intent f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        PluginRecommendSceneActionActivity.AnonymousClass6.this.O000000o(this.f$1, this.f$2);
                    }
                });
                this.mObj = null;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(O0000Oo0 o0000Oo0) {
                PluginRecommendSceneActionActivity.this.onActionSelected(0, o0000Oo0.O00000o0, null);
            }

            public final void onMessageFailure(int i, String str) {
                PluginRecommendSceneActionActivity.this.mHandler.post(new Runnable(o0000Oo03) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActionActivity$6$PSgLbS0btAHLBa3y3wy_OZvNpQ */
                    private final /* synthetic */ PluginRecommendSceneActionActivity.O0000Oo0 f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        PluginRecommendSceneActionActivity.AnonymousClass6.this.O000000o(this.f$1);
                    }
                });
                this.mObj = null;
            }
        });
    }

    public static class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f10799O000000o;
        public SimpleDraweeView O00000Oo;

        public O00000o(View view) {
            super(view);
            this.f10799O000000o = (TextView) view.findViewById(R.id.model_name);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.sd_model_img);
        }
    }

    public static class O0000OOo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f10802O000000o;

        public O0000OOo(View view) {
            super(view);
            this.f10802O000000o = (TextView) view.findViewById(R.id.time);
        }
    }

    public static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f10797O000000o;
        public View O00000Oo;
        public View O00000o;
        public View O00000o0;

        public O000000o(View view) {
            super(view);
            this.f10797O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = view.findViewById(R.id.divider_x);
            this.O00000o0 = view.findViewById(R.id.divider_last);
            this.O00000o = view.findViewById(R.id.icon_selected);
        }
    }

    public static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public SimpleDraweeView f10798O000000o;
        public TextView O00000Oo;
        public View O00000o0;

        public O00000Oo(View view) {
            super(view);
            this.f10798O000000o = (SimpleDraweeView) view.findViewById(R.id.device_icon);
            this.O00000Oo = (TextView) view.findViewById(R.id.device_name);
            this.O00000o0 = view.findViewById(R.id.divider_last);
        }
    }

    public class O0000O0o extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        public final long getItemId(int i) {
            return (long) i;
        }

        public O0000O0o() {
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new O000000o(LayoutInflater.from(PluginRecommendSceneActionActivity.this).inflate((int) R.layout.item_plugin_rec_action, (ViewGroup) null));
            }
            if (i == 2) {
                return new O0000OOo(LayoutInflater.from(PluginRecommendSceneActionActivity.this).inflate((int) R.layout.item_plugin_rec_timespan, (ViewGroup) null));
            }
            return null;
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (getItemViewType(i) == 1) {
                O000000o o000000o = (O000000o) o000OOo0;
                O0000Oo0 o0000Oo0 = PluginRecommendSceneActionActivity.this.data.get(i);
                if (o0000Oo0 != null) {
                    if (o0000Oo0.O00000Oo == null || TextUtils.isEmpty(o0000Oo0.O00000Oo.name)) {
                        o000000o.f10797O000000o.setText("");
                    } else if (o0000Oo0.O00000Oo.isOnline) {
                        o000000o.f10797O000000o.setText(o0000Oo0.O00000Oo.name);
                    } else {
                        TextView textView = o000000o.f10797O000000o;
                        textView.setText(o0000Oo0.O00000Oo.name + "(" + PluginRecommendSceneActionActivity.this.getString(R.string.offline_device) + ")");
                    }
                    if (PluginRecommendSceneActionActivity.this.selectedPos == i) {
                        o000000o.f10797O000000o.setTextColor(PluginRecommendSceneActionActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                        o000000o.O00000o.setVisibility(0);
                    } else {
                        o000000o.f10797O000000o.setTextColor(PluginRecommendSceneActionActivity.this.getResources().getColor(R.color.black));
                        o000000o.O00000o.setVisibility(8);
                    }
                    o000000o.itemView.setOnClickListener(new View.OnClickListener(i) {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActionActivity$O0000O0o$c_PeWVleLRhEXCZBLiYkq_QbQF8 */
                        private final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            PluginRecommendSceneActionActivity.O0000O0o.this.O000000o(this.f$1, view);
                        }
                    });
                }
            } else if (getItemViewType(i) == 2) {
                O0000OOo o0000OOo = (O0000OOo) o000OOo0;
                hnw.O000000o(PluginRecommendSceneActionActivity.this.curScene.O0000oO, o0000OOo.f10802O000000o, PluginRecommendSceneActionActivity.this.getString(R.string.scene_exetime_second_day));
                o0000OOo.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActionActivity$O0000O0o$gCvk4cD3ykhgcv43cpkxE2GpxNo */

                    public final void onClick(View view) {
                        PluginRecommendSceneActionActivity.O0000O0o.this.O000000o(view);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            PluginRecommendSceneActionActivity.this.selectedPos = i;
            notifyDataSetChanged();
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
        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            Intent intent = new Intent(PluginRecommendSceneActionActivity.this, SceneCreateTimeEdit2Activity.class);
            intent.putExtra("is_from_recommend", true);
            PluginRecommendSceneActionActivity.this.startActivityForResult(intent, 1011);
        }

        public final int getItemViewType(int i) {
            if (PluginRecommendSceneActionActivity.this.data == null) {
                return super.getItemViewType(i);
            }
            return PluginRecommendSceneActionActivity.this.data.get(i).f10803O000000o;
        }

        public final int getItemCount() {
            if (PluginRecommendSceneActionActivity.this.data == null) {
                return 0;
            }
            return PluginRecommendSceneActionActivity.this.data.size();
        }
    }

    public class O00000o0 extends RecyclerView.O000000o<O00000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        List<JSONObject> f10800O000000o = new ArrayList();

        public final long getItemId(int i) {
            return (long) i;
        }

        public O00000o0() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000o o00000o = (O00000o) o000OOo0;
            JSONObject jSONObject = this.f10800O000000o.get(i);
            String next = jSONObject.keys().next();
            if (!TextUtils.isEmpty(next)) {
                DeviceFactory.O00000Oo(next, o00000o.O00000Oo);
                PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(next);
                if (O00000oO == null || TextUtils.isEmpty(O00000oO.O0000Oo0())) {
                    o00000o.f10799O000000o.setText("");
                } else {
                    o00000o.f10799O000000o.setText(O00000oO.O0000Oo0());
                }
                o00000o.itemView.setOnClickListener(new View.OnClickListener(jSONObject, next) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActionActivity$O00000o0$ZRzqAdO4L8utN5YX4r7je7QwlE */
                    private final /* synthetic */ JSONObject f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        PluginRecommendSceneActionActivity.O00000o0.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(JSONObject jSONObject, String str, View view) {
            hxi.O00000o.f952O000000o.O000000o("recommend_lockspeaker_touchspeaker", "type", "lockspeaker", "model", PluginRecommendSceneActionActivity.this.conditionDevice == null ? "" : PluginRecommendSceneActionActivity.this.conditionDevice.model);
            hjp.O000000o(jSONObject.optString(str));
        }

        public final int getItemCount() {
            List<JSONObject> list = this.f10800O000000o;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000o(LayoutInflater.from(PluginRecommendSceneActionActivity.this).inflate((int) R.layout.light_rec_scene_buy_item, (ViewGroup) null));
        }
    }
}
