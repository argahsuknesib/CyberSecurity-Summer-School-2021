package com.xiaomi.smarthome.scene.activity;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.hps;
import _m_j.hpt;
import _m_j.hpz;
import _m_j.hqy;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginRecommendSceneActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Set<Integer> f10804O000000o;
    private RecyclerView O00000Oo;
    private View O00000o;
    private O000000o O00000o0;
    private View O00000oO;
    public List<O00000o0> data = new ArrayList();
    public Device device = null;
    public Home home = null;
    public boolean isConditionListReady = false;
    public boolean isSceneListReady = false;
    public int is_connected_ble = -2;
    public XQProgressDialog mPD;
    public SceneApi.O000OOOo mScene;
    public TextView mTitle;
    public List<SceneApi.O000OOOo> sceneList = new ArrayList();
    public int sr_id;

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f10813O000000o = false;
        public SceneApi.O000OOOo O00000Oo;
        public List<SceneApi.O000000o> O00000o;
        public String O00000o0;
    }

    static {
        HashSet hashSet = new HashSet();
        f10804O000000o = hashSet;
        hashSet.add(1000);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_plugin_recommend_scene);
        this.sr_id = getIntent().getIntExtra("sr_id", -1);
        String stringExtra = getIntent().getStringExtra("did");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.device = fno.O000000o().O000000o(stringExtra);
            this.home = ggb.O00000Oo().O0000o0(stringExtra);
        }
        if (getIntent().getBooleanExtra("is_from_plugin", false)) {
            hxk hxk = hxi.O00000o;
            Device device2 = this.device;
            hxk.f952O000000o.O000000o("recommend_lockspeaker_plugin", "model", device2 == null ? "" : device2.model);
        }
        if (this.sr_id <= 0 || this.device == null) {
            finish();
            return;
        }
        if (getIntent().getBooleanExtra("is_from_home", false)) {
            hxi.O00000oO.O0000OoO(this.device.model, "plugin");
        } else {
            hxi.O00000oO.O0000OoO(this.device.model, "gt");
        }
        this.mTitle = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000Oo = (RecyclerView) findViewById(R.id.recycler_view);
        this.O00000Oo.setLayoutManager(new LinearLayoutManager(this));
        this.O00000o0 = new O000000o();
        this.O00000Oo.setAdapter(this.O00000o0);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
        findViewById(R.id.module_a_3_right_btn).setOnClickListener(this);
        ((ImageView) findViewById(R.id.module_a_3_right_btn)).setImageResource(R.drawable.btn_notice);
        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
            this.mTitle.setText((int) R.string.setting);
        } else {
            this.mTitle.setText(getString(R.string.plugin_rec_setting_title, new Object[]{hpt.O000000o().f492O000000o.intro}));
        }
        updateData();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1010) {
            SceneApi.O000OOOo o000OOOo = hpt.O000000o().O0000OOo;
            o000OOOo.O00000o = this.sr_id;
            o000OOOo.O0000oO0 = false;
            o000OOOo.O0000Oo0 = true;
            o000OOOo.O0000Oo = false;
            ((SceneApi.O000OO0o) this.mScene.O00000oo.get(0).O0000O0o).O0000Oo0 = null;
            if (o000OOOo.O0000O0o != null && o000OOOo.O0000O0o.size() > 0) {
                if (o000OOOo.O0000O0o.size() == 1) {
                    o000OOOo.O0000Ooo = 0;
                } else {
                    o000OOOo.O0000Ooo = 1;
                }
            }
            this.mPD = XQProgressDialog.O000000o(this, null, getResources().getString(R.string.smarthome_scene_saving_scene));
            if (o000OOOo == null || o000OOOo.O00000oo == null || o000OOOo.O00000oo.size() == 0 || o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() == 0) {
                if (isValid()) {
                    this.mPD.dismiss();
                }
                gqg.O00000Oo((int) R.string.save_fail);
                updateData();
                return;
            }
            hpt.O000000o(o000OOOo, new hqy() {
                /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity.AnonymousClass1 */

                public final void onSaveLocalFail() {
                    if (PluginRecommendSceneActivity.this.isValid()) {
                        PluginRecommendSceneActivity.this.mPD.dismiss();
                    }
                }

                public final void onSaveCloudSuccess(boolean z) {
                    PluginRecommendSceneActivity.this.updateData();
                }

                public final void onSaveCloudFail(int i, String str) {
                    if (PluginRecommendSceneActivity.this.isValid()) {
                        PluginRecommendSceneActivity.this.mPD.dismiss();
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public void showGuideView() {
        if (this.O00000o == null) {
            this.O00000o = ((ViewStub) findViewById(R.id.guide)).inflate();
        }
        if (!gpy.O00000o0((Context) this, CoreApi.O000000o().O0000o0() + this.sr_id, "first_in_recommend_scene_", true)) {
            this.O00000o.findViewById(R.id.go_setting).setVisibility(8);
        }
        gpy.O000000o((Context) this, CoreApi.O000000o().O0000o0() + this.sr_id, "first_in_recommend_scene_", false);
        this.O00000o.setVisibility(0);
        this.O00000o.findViewById(R.id.close).setOnClickListener(this);
        this.O00000o.findViewById(R.id.go_setting).setOnClickListener(this);
        this.O00000o.setOnClickListener(this);
        if (this.sr_id == 1000) {
            ((SimpleDraweeView) this.O00000o.findViewById(R.id.tips_gif)).setImageResource(R.drawable.ic_plugin_rec_scene_guide_1000);
        }
        if (hpt.O000000o().f492O000000o != null && !TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
            ((TextView) this.O00000o.findViewById(R.id.title)).setText(hpt.O000000o().f492O000000o.intro);
        }
        if (this.sr_id == 1000) {
            ((TextView) this.O00000o.findViewById(R.id.rec_desc)).setText((int) R.string.plugin_rec_guide_lockspeaker);
            this.O00000o.findViewById(R.id.rec_desc).setVisibility(0);
        } else if (!TextUtils.isEmpty(hpt.O000000o().f492O000000o.cardDesc)) {
            ((TextView) this.O00000o.findViewById(R.id.rec_desc)).setText(hpt.O000000o().f492O000000o.cardDesc);
            this.O00000o.findViewById(R.id.rec_desc).setVisibility(0);
        } else {
            this.O00000o.findViewById(R.id.rec_desc).setVisibility(8);
        }
    }

    public void updateData() {
        this.isSceneListReady = false;
        this.isConditionListReady = false;
        hpt.O000000o();
        hpt.O00000o0();
        hps.O000000o().O000000o(this.device.did, this.sr_id, new fsm<List<SceneApi.O000OOOo>, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity.AnonymousClass4 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                PluginRecommendSceneActivity.this.sceneList.clear();
                PluginRecommendSceneActivity.this.sceneList.addAll((List) obj);
                PluginRecommendSceneActivity pluginRecommendSceneActivity = PluginRecommendSceneActivity.this;
                pluginRecommendSceneActivity.isSceneListReady = true;
                if (pluginRecommendSceneActivity.isSceneListReady && PluginRecommendSceneActivity.this.isConditionListReady) {
                    PluginRecommendSceneActivity.this.configDataSetUI();
                }
            }
        });
        hps.O000000o().O000000o(this.device.did, new fsm<PluginRecommendSceneInfo, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
             arg types: [com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity, java.lang.String, java.lang.String, int]
             candidates:
              _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
              _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject optJSONObject;
                JSONObject optJSONObject2;
                PluginRecommendSceneInfo pluginRecommendSceneInfo = (PluginRecommendSceneInfo) obj;
                if (pluginRecommendSceneInfo != null) {
                    int i = 0;
                    while (true) {
                        if (i >= pluginRecommendSceneInfo.mSceneItems.size()) {
                            break;
                        }
                        String str = pluginRecommendSceneInfo.mSceneItems.get(i).sr_id;
                        StringBuilder sb = new StringBuilder();
                        sb.append(PluginRecommendSceneActivity.this.sr_id);
                        if (TextUtils.equals(str, sb.toString())) {
                            hpt.O000000o().f492O000000o = pluginRecommendSceneInfo.mSceneItems.get(i);
                            break;
                        }
                        i++;
                    }
                    if (hpt.O000000o().f492O000000o != null) {
                        PluginRecommendSceneActivity pluginRecommendSceneActivity = PluginRecommendSceneActivity.this;
                        if (gpy.O00000o0((Context) pluginRecommendSceneActivity, CoreApi.O000000o().O0000o0() + PluginRecommendSceneActivity.this.sr_id, "first_in_recommend_scene_", true)) {
                            PluginRecommendSceneActivity.this.showGuideView();
                        }
                        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
                            PluginRecommendSceneActivity.this.mTitle.setText((int) R.string.setting);
                        } else {
                            PluginRecommendSceneActivity.this.mTitle.setText(PluginRecommendSceneActivity.this.getString(R.string.plugin_rec_setting_title, new Object[]{hpt.O000000o().f492O000000o.intro}));
                        }
                        if (hpt.O000000o().f492O000000o.mConditionList != null && pluginRecommendSceneInfo.mConditionScIds != null) {
                            for (PluginRecommendSceneInfo.ConditionActionItem next : hpt.O000000o().f492O000000o.mConditionList) {
                                if (next.modelListJobj == null) {
                                    break;
                                }
                                Iterator<String> keys = next.modelListJobj.keys();
                                while (keys.hasNext()) {
                                    int optInt = next.modelListJobj.optInt(keys.next());
                                    if (!hpt.O000000o().O00000o0.containsKey(Integer.valueOf(optInt)) && optInt > 0 && (optJSONObject2 = pluginRecommendSceneInfo.mConditionScIds.optJSONObject(String.valueOf(optInt))) != null) {
                                        try {
                                            SceneApi.O000000o O000000o2 = SceneApi.O000000o.O000000o(optJSONObject2);
                                            O000000o2.O00000o0.O0000OoO = optInt;
                                            hpt.O000000o().O00000o0.put(Integer.valueOf(optInt), O000000o2);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        if (hpt.O000000o().f492O000000o.mActionList != null && pluginRecommendSceneInfo.mActionSaIds != null) {
                            for (PluginRecommendSceneInfo.ConditionActionItem next2 : hpt.O000000o().f492O000000o.mActionList) {
                                if (next2.modelListJobj == null) {
                                    break;
                                }
                                Iterator<String> keys2 = next2.modelListJobj.keys();
                                while (keys2.hasNext()) {
                                    String next3 = keys2.next();
                                    int optInt2 = next2.modelListJobj.optInt(next3);
                                    if (!hpt.O000000o().O00000o.containsKey(Integer.valueOf(optInt2)) && optInt2 > 0 && (optJSONObject = pluginRecommendSceneInfo.mActionSaIds.optJSONObject(String.valueOf(optInt2))) != null) {
                                        try {
                                            SceneApi.Action O000000o3 = SceneApi.Action.O000000o(optJSONObject);
                                            if (O000000o3.f11120O000000o == 0) {
                                                SceneApi.O000OO00 o000oo00 = O000000o3.O0000O0o;
                                                o000oo00.O00000o0 = next3 + "." + O000000o3.O0000O0o.O00000o0;
                                                O000000o3.O0000O0o.O0000O0o = 0;
                                            }
                                            hpt.O000000o().O00000o.put(Integer.valueOf(optInt2), O000000o3);
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        if (hpt.O000000o().f492O000000o.mConditionList != null && hpt.O000000o().f492O000000o.mConditionList.size() > 0) {
                            int optInt3 = hpt.O000000o().f492O000000o.mConditionList.get(0).modelListJobj.optInt(PluginRecommendSceneActivity.this.device.model);
                            if (optInt3 > 0) {
                                PluginRecommendSceneActivity.this.getDeviceConditions(optInt3);
                            } else {
                                PluginRecommendSceneActivity pluginRecommendSceneActivity2 = PluginRecommendSceneActivity.this;
                                pluginRecommendSceneActivity2.isConditionListReady = true;
                                if (pluginRecommendSceneActivity2.isSceneListReady && PluginRecommendSceneActivity.this.isConditionListReady) {
                                    PluginRecommendSceneActivity.this.configDataSetUI();
                                }
                            }
                        }
                        if (hpt.O000000o().f492O000000o.mActionList != null && hpt.O000000o().f492O000000o.mActionList.size() > 0) {
                            for (int i2 = 0; i2 < hpt.O000000o().f492O000000o.mActionList.size(); i2++) {
                                JSONObject jSONObject = hpt.O000000o().f492O000000o.mActionList.get(i2).modelListJobj;
                                if (jSONObject != null) {
                                    Iterator<String> keys3 = jSONObject.keys();
                                    while (keys3.hasNext()) {
                                        String next4 = keys3.next();
                                        PluginRecommendSceneActivity pluginRecommendSceneActivity3 = PluginRecommendSceneActivity.this;
                                        List<Device> findDeviceBy = pluginRecommendSceneActivity3.findDeviceBy(next4, pluginRecommendSceneActivity3.home);
                                        if (!(findDeviceBy == null || findDeviceBy.size() == 0)) {
                                            int optInt4 = jSONObject.optInt(next4);
                                            SceneApi.Action action = hpt.O000000o().O00000o.get(Integer.valueOf(optInt4));
                                            if (action != null && action.f11120O000000o == 0) {
                                                hpt.O000000o().O00000oo.put(String.valueOf(optInt4), PluginRecommendSceneActivity.this.fillCoreFromDevice(action, findDeviceBy));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        if (f10804O000000o.contains(Integer.valueOf(this.sr_id))) {
            this.is_connected_ble = -1;
            getIsConnectBle();
        }
    }

    public List<Device> findDeviceBy(String str, Home home2) {
        ArrayList arrayList = new ArrayList();
        for (Device next : ggb.O00000Oo().O0000Oo(home2.getId())) {
            if (TextUtils.equals(str, next.model)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void getDeviceConditions(final int i) {
        hps.O000000o();
        String str = this.device.did;
        new StringBuilder().append(i);
        hps.O00000Oo(str, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity.AnonymousClass3 */

            public final void onFailure(fso fso) {
            }

            /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0090 A[SYNTHETIC] */
            public final /* synthetic */ void onSuccess(Object obj) {
                SceneApi.O000000o o000000o;
                hpz hpz;
                JSONArray optJSONArray = ((JSONObject) obj).optJSONArray("members");
                if (!(optJSONArray == null || optJSONArray.length() <= 0 || (o000000o = hpt.O000000o().O00000o0.get(Integer.valueOf(i))) == null)) {
                    int i = 0;
                    while (i < optJSONArray.length()) {
                        try {
                            JSONObject jSONObject = optJSONArray.getJSONObject(i);
                            if (jSONObject == null) {
                                hpz = null;
                                if (hpz != null) {
                                    List<SceneApi.O000000o> fillCoreFromPkg = PluginRecommendSceneActivity.this.fillCoreFromPkg(o000000o, hpz.O00000Oo);
                                    if (fillCoreFromPkg == null || fillCoreFromPkg.size() <= 0) {
                                        hpt.O000000o().O00000oO.put(hpz.f514O000000o, null);
                                    } else {
                                        hpt.O000000o().O00000oO.put(hpz.f514O000000o, fillCoreFromPkg);
                                    }
                                }
                                i++;
                            } else {
                                hpz = new hpz();
                                hpz.f514O000000o = jSONObject.optString("name");
                                JSONArray optJSONArray2 = jSONObject.optJSONArray("fingerprints");
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                        hpz.O00000Oo.add(optJSONArray2.optJSONObject(i2));
                                    }
                                }
                                if (hpz != null) {
                                }
                                i++;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                PluginRecommendSceneActivity pluginRecommendSceneActivity = PluginRecommendSceneActivity.this;
                pluginRecommendSceneActivity.isConditionListReady = true;
                if (pluginRecommendSceneActivity.isSceneListReady && PluginRecommendSceneActivity.this.isConditionListReady) {
                    PluginRecommendSceneActivity.this.configDataSetUI();
                }
            }
        });
    }

    public List<SceneApi.Action> fillCoreFromDevice(SceneApi.Action action, List<Device> list) {
        ArrayList arrayList = new ArrayList();
        if (action.O0000O0o == null) {
            action.O0000O0o = new SceneApi.O000OO0o();
        }
        try {
            JSONObject O000000o2 = action.O000000o();
            for (Device next : list) {
                SceneApi.Action O000000o3 = SceneApi.Action.O000000o(O000000o2);
                O000000o3.O0000O0o.O00000o = next.did;
                O000000o3.O00000oO = next.model;
                arrayList.add(O000000o3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<SceneApi.O000000o> fillCoreFromPkg(SceneApi.O000000o o000000o, List<JSONObject> list) {
        JSONObject jSONObject;
        SceneApi.O000000o o000000o2 = o000000o;
        List<JSONObject> list2 = list;
        ArrayList arrayList = new ArrayList();
        if (o000000o2.f11121O000000o == LAUNCH_TYPE.DEVICE) {
            if (o000000o2.O00000o0 == null) {
                o000000o2.O00000o0 = new SceneApi.O00000o0();
            }
            try {
                JSONObject O000000o2 = o000000o.O000000o();
                int i = 0;
                while (i < list.size()) {
                    SceneApi.O000000o O000000o3 = SceneApi.O000000o.O000000o(O000000o2);
                    O000000o3.O00000o0.f11122O000000o = this.device.did;
                    O000000o3.O00000o0.O00000o0 = this.device.name;
                    O000000o3.O00000o0.O00000o = this.device.model;
                    if (!TextUtils.isEmpty(list2.get(i).optString("key"))) {
                        O000000o3.O00000o0.O0000Oo = list2.get(i).optString("key");
                    }
                    if (!TextUtils.isEmpty(list2.get(i).optString("did"))) {
                        O000000o3.O00000o0.f11122O000000o = list2.get(i).optString("did");
                    }
                    if (!TextUtils.isEmpty(list2.get(i).optString("name"))) {
                        O000000o3.O00000o0.O00000Oo = list2.get(i).optString("name");
                    }
                    if (list2.get(i).opt("keyid") == null) {
                        jSONObject = O000000o2;
                    } else if (this.sr_id == 1000) {
                        jSONObject = O000000o2;
                        ((SceneApi.O00000o0) O000000o3.O00000o0).O0000Ooo = "0002" + list2.get(i).opt("keyid");
                    } else {
                        jSONObject = O000000o2;
                        ((SceneApi.O00000o0) O000000o3.O00000o0).O0000Ooo = list2.get(i).opt("keyid");
                    }
                    if (!TextUtils.isEmpty(list2.get(i).optString("deviceName"))) {
                        O000000o3.O00000o0.O00000o0 = list2.get(i).optString("deviceName");
                    }
                    if (list2.get(i).optInt("tempId") > 0) {
                        O000000o3.O00000o0.O0000OoO = list2.get(i).optInt("tempId");
                    }
                    if (list2.get(i).optInt("sc_id") > 0) {
                        O000000o3.O00000o0.O0000OoO = list2.get(i).optInt("sc_id");
                    }
                    if (!TextUtils.isEmpty(list2.get(i).optString("extra"))) {
                        ((SceneApi.O00000o0) O000000o3.O00000o0).O0000o00 = list2.get(i).optString("extra");
                    }
                    ((SceneApi.O00000o0) O000000o3.O00000o0).O00000oO = -1;
                    ((SceneApi.O00000o0) O000000o3.O00000o0).O0000O0o = -1;
                    ((SceneApi.O00000o0) O000000o3.O00000o0).O00000oo = -1;
                    ((SceneApi.O00000o0) O000000o3.O00000o0).O0000OOo = -1;
                    arrayList.add(O000000o3);
                    i++;
                    O000000o2 = jSONObject;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public void getIsConnectBle() {
        hps.O000000o();
        String str = this.device.did;
        AnonymousClass5 r1 = new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(PluginRecommendSceneActivity.this.device.did);
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        PluginRecommendSceneActivity.this.is_connected_ble = 0;
                    } else {
                        PluginRecommendSceneActivity.this.is_connected_ble = 1;
                    }
                } else {
                    PluginRecommendSceneActivity.this.is_connected_ble = 0;
                }
            }

            public final void onFailure(fso fso) {
                PluginRecommendSceneActivity.this.is_connected_ble = -1;
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        hps.O000000o(arrayList, r1);
    }

    public void configDataSetUI() {
        this.data.clear();
        ArrayList<String> arrayList = new ArrayList<>();
        boolean z = true;
        for (String next : hpt.O000000o().O00000oO.keySet()) {
            List<SceneApi.O000000o> list = hpt.O000000o().O00000oO.get(next);
            O00000o0 o00000o0 = new O00000o0();
            SceneApi.O000OOOo O000000o2 = O000000o(list);
            if (O000000o2 != null) {
                o00000o0.O00000Oo = O000000o2;
                o00000o0.O00000Oo.O0000O0o = list;
                if (o00000o0.O00000Oo.O00000oo.size() > 0 && o00000o0.O00000Oo.O00000oo.get(0).f11120O000000o == 0 && (o00000o0.O00000Oo.O00000oo.get(0).O0000O0o instanceof SceneApi.O000OO0o)) {
                    SceneApi.O000OO0o o000OO0o = (SceneApi.O000OO0o) o00000o0.O00000Oo.O00000oo.get(0).O0000O0o;
                    Map<String, List<SceneApi.Action>> map = hpt.O000000o().O00000oo;
                    StringBuilder sb = new StringBuilder();
                    sb.append(o000OO0o.O0000OOo);
                    List list2 = map.get(sb.toString());
                    if (list2 != null && list2.size() > 0) {
                        for (int i = 0; i < list2.size(); i++) {
                            if (((SceneApi.Action) list2.get(i)).O0000O0o instanceof SceneApi.O000OO0o) {
                                o000OO0o.O0000Oo0 = ((SceneApi.O000OO0o) ((SceneApi.Action) list2.get(i)).O0000O0o).O0000Oo0;
                            }
                        }
                    }
                }
                o00000o0.O00000o0 = next;
                if (z) {
                    o00000o0.f10813O000000o = true;
                    z = false;
                }
                this.data.add(o00000o0);
                arrayList.add(next);
            }
        }
        for (String remove : arrayList) {
            hpt.O000000o().O00000oO.remove(remove);
        }
        boolean z2 = true;
        for (String next2 : hpt.O000000o().O00000oO.keySet()) {
            O00000o0 o00000o02 = new O00000o0();
            if (z2) {
                o00000o02.f10813O000000o = true;
                z2 = false;
            }
            o00000o02.O00000o0 = next2;
            o00000o02.O00000o = hpt.O000000o().O00000oO.get(next2);
            this.data.add(o00000o02);
        }
        XQProgressDialog xQProgressDialog = this.mPD;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mPD.dismiss();
        }
        this.O00000o0.notifyDataSetChanged();
        if (this.O00000o0.getItemCount() <= 0) {
            if (this.O00000oO == null) {
                this.O00000oO = ((ViewStub) findViewById(R.id.empty_view)).inflate();
            }
            this.O00000oO.findViewById(R.id.common_white_empty_view).setVisibility(0);
            if (this.sr_id == 1000) {
                ((TextView) this.O00000oO.findViewById(R.id.common_white_empty_text)).setText((int) R.string.plugin_rec_con_no_member);
            } else {
                ((TextView) this.O00000oO.findViewById(R.id.common_white_empty_text)).setText((int) R.string.no_data_tips);
            }
            if (this.sr_id == 1000) {
                ((ImageView) this.O00000oO.findViewById(R.id.empty_icon)).setImageResource(R.drawable.ic_plugin_rec_condition_null_1000);
                return;
            }
            return;
        }
        View view = this.O00000oO;
        if (view != null) {
            view.findViewById(R.id.common_white_empty_view).setVisibility(8);
        }
    }

    private SceneApi.O000OOOo O000000o(List<SceneApi.O000000o> list) {
        List<SceneApi.O000OOOo> list2;
        if (!(list == null || (list2 = this.sceneList) == null || list2.size() <= 0)) {
            for (SceneApi.O000OOOo next : this.sceneList) {
                boolean z = false;
                if (next.O0000O0o != null) {
                    for (SceneApi.O000000o next2 : next.O0000O0o) {
                        Iterator<SceneApi.O000000o> it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (isLockSpeakerSceneCondition(next2, it.next())) {
                                    z = true;
                                    continue;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        for (SceneApi.Action next3 : next.O00000oo) {
                            if (next3.f11120O000000o == 0 && (next3.O0000O0o instanceof SceneApi.O000OO0o)) {
                                String str = ((SceneApi.O000OO0o) next3.O0000O0o).O00000o;
                                if (fno.O000000o().O000000o(str) != null && TextUtils.equals(ggb.O00000Oo().O0000o0(str).getId(), this.home.getId())) {
                                    return next;
                                }
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public boolean isLockSpeakerSceneCondition(SceneApi.O000000o o000000o, SceneApi.O000000o o000000o2) {
        if (o000000o.f11121O000000o != o000000o2.f11121O000000o || !(o000000o.O00000o0 instanceof SceneApi.O00000o0) || !(o000000o2.O00000o0 instanceof SceneApi.O00000o0)) {
            return false;
        }
        SceneApi.O00000o0 o00000o0 = (SceneApi.O00000o0) o000000o.O00000o0;
        SceneApi.O00000o0 o00000o02 = (SceneApi.O00000o0) o000000o2.O00000o0;
        if (o00000o0.O0000Ooo.equals(o00000o02.O0000Ooo) && TextUtils.equals(o00000o0.f11122O000000o, o00000o02.f11122O000000o)) {
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.close || id == R.id.go_setting) {
            this.O00000o.setVisibility(8);
        } else if (id == R.id.module_a_3_right_btn) {
            showGuideView();
        } else if (id == R.id.module_a_3_return_btn) {
            finish();
        }
    }

    public class O000000o extends RecyclerView.O000000o<O00000Oo> {
        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            Object obj;
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            O00000o0 o00000o0 = PluginRecommendSceneActivity.this.data.get(i);
            if (o00000o0.f10813O000000o) {
                boolean z = o00000o0.O00000Oo != null;
                boolean z2 = i != 0;
                if (o00000Oo.O00000Oo == null) {
                    o00000Oo.O00000Oo = o00000Oo.f10812O000000o.inflate();
                    o00000Oo.O0000Oo0 = (TextView) o00000Oo.O00000Oo.findViewById(R.id.title);
                    o00000Oo.O0000Oo = o00000Oo.O00000Oo.findViewById(R.id.divider);
                }
                StringBuilder sb = new StringBuilder();
                if (hpt.O000000o().f492O000000o != null && !TextUtils.isEmpty(hpt.O000000o().f492O000000o.entryDesc)) {
                    sb.append(hpt.O000000o().f492O000000o.intro);
                    sb.append("-");
                }
                if (z) {
                    sb.append(PluginRecommendSceneActivity.this.getString(R.string.rec_setted));
                } else {
                    sb.append(PluginRecommendSceneActivity.this.getString(R.string.unset));
                }
                o00000Oo.O0000Oo0.setText(sb.toString());
                if (z2) {
                    o00000Oo.O0000Oo.setVisibility(0);
                } else {
                    o00000Oo.O0000Oo.setVisibility(8);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(o00000o0.O00000o0)) {
                sb2.append(o00000o0.O00000o0);
            }
            if (o00000o0.O00000Oo != null) {
                o00000Oo.O0000O0o.setVisibility(0);
                o00000Oo.O00000o.setVisibility(0);
                o00000Oo.O00000oO.setVisibility(8);
                o00000Oo.O00000oo.setVisibility(8);
                o00000Oo.O00000o.setChecked(o00000o0.O00000Oo.O0000Oo0);
                if (o00000o0.O00000Oo.O0000Oo0) {
                    o00000Oo.O0000OOo.setTextColor(PluginRecommendSceneActivity.this.getResources().getColor(R.color.mj_color_black));
                } else {
                    o00000Oo.O0000OOo.setTextColor(PluginRecommendSceneActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                }
                o00000Oo.O00000o.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o00000o0) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActivity$O000000o$Z0JUGJ2BkN1JF6cx1OgZgundkEc */
                    private final /* synthetic */ PluginRecommendSceneActivity.O00000o0 f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        PluginRecommendSceneActivity.O000000o.this.O000000o(this.f$1, compoundButton, z);
                    }
                });
                TextView textView = o00000Oo.O0000OOo;
                StringBuilder sb3 = new StringBuilder();
                if (PluginRecommendSceneActivity.this.sr_id == 1000) {
                    sb3.append(PluginRecommendSceneActivity.this.getString(R.string.plugin_rec_action_hint_lockspeaker));
                    if (o00000o0.O00000Oo != null && o00000o0.O00000Oo.O00000oo != null && o00000o0.O00000Oo.O00000oo.size() > 0 && o00000o0.O00000Oo.O00000oo.get(0).f11120O000000o == 0 && (o00000o0.O00000Oo.O00000oo.get(0).O0000O0o instanceof SceneApi.O000OO0o) && (obj = ((SceneApi.O000OO0o) o00000o0.O00000Oo.O00000oo.get(0).O0000O0o).O00000oO) != null) {
                        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                            sb3.append(obj);
                        } else if (obj instanceof JSONObject) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject != null && jSONObject.has("text") && !TextUtils.isEmpty(jSONObject.optString("text"))) {
                                sb3.append(jSONObject.optString("text"));
                            }
                        } else if (obj instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) obj;
                            if (jSONArray != null && jSONArray.length() == 3 && !TextUtils.isEmpty(jSONArray.optString(0))) {
                                sb3.append(jSONArray.optString(0));
                            } else if (jSONArray != null && jSONArray.length() == 1 && !TextUtils.isEmpty(jSONArray.optString(0))) {
                                sb3.append(jSONArray.optString(0));
                            }
                        }
                    }
                } else if (hpt.O000000o().f492O000000o != null && !TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
                    sb3.append(hpt.O000000o().f492O000000o.intro);
                }
                textView.setText(sb3.toString());
            } else {
                if (o00000o0.O00000o == null || o00000o0.O00000o.size() == 0) {
                    sb2.append(PluginRecommendSceneActivity.this.getString(R.string.plugin_rec_con_mem_null_finger));
                    o00000Oo.O00000o0.setTextColor(PluginRecommendSceneActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    o00000Oo.O0000OOo.setTextColor(PluginRecommendSceneActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    o00000Oo.O00000oO.setVisibility(8);
                    o00000Oo.O00000oo.setVisibility(8);
                } else {
                    o00000Oo.O00000o0.setTextColor(PluginRecommendSceneActivity.this.getResources().getColor(R.color.mj_color_black));
                    o00000Oo.O0000OOo.setTextColor(PluginRecommendSceneActivity.this.getResources().getColor(R.color.mj_color_black));
                    o00000Oo.O00000oO.setVisibility(0);
                    o00000Oo.O00000oo.setVisibility(0);
                }
                o00000Oo.O0000O0o.setVisibility(8);
                o00000Oo.O00000o.setVisibility(8);
                o00000Oo.O0000OOo.setText("");
                if (i == PluginRecommendSceneActivity.this.data.size() - 1) {
                    o00000Oo.O0000OoO.setVisibility(0);
                } else {
                    o00000Oo.O0000OoO.setVisibility(8);
                }
            }
            o00000Oo.O00000o0.setText(sb2.toString());
            o00000Oo.itemView.setOnClickListener(new View.OnClickListener(o00000o0) {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$PluginRecommendSceneActivity$O000000o$T3Qj4XYF3clcikbL7GYBHgz2YNM */
                private final /* synthetic */ PluginRecommendSceneActivity.O00000o0 f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PluginRecommendSceneActivity.O000000o.this.O000000o(this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000o0 o00000o0, final CompoundButton compoundButton, final boolean z) {
            PluginRecommendSceneActivity.this.mScene = o00000o0.O00000Oo;
            if (PluginRecommendSceneActivity.this.mScene != null) {
                PluginRecommendSceneActivity.this.mScene.O0000Oo0 = z;
                PluginRecommendSceneActivity pluginRecommendSceneActivity = PluginRecommendSceneActivity.this;
                pluginRecommendSceneActivity.mPD = XQProgressDialog.O000000o(pluginRecommendSceneActivity, null, pluginRecommendSceneActivity.getResources().getString(R.string.smarthome_scene_saving_scene));
                if (PluginRecommendSceneActivity.this.mScene == null || PluginRecommendSceneActivity.this.mScene.O00000oo == null || PluginRecommendSceneActivity.this.mScene.O00000oo.size() == 0 || PluginRecommendSceneActivity.this.mScene.O0000O0o == null || PluginRecommendSceneActivity.this.mScene.O0000O0o.size() == 0) {
                    if (PluginRecommendSceneActivity.this.isValid()) {
                        PluginRecommendSceneActivity.this.mPD.dismiss();
                    }
                    gqg.O00000Oo((int) R.string.save_fail);
                    PluginRecommendSceneActivity.this.mScene.O0000Oo0 = !PluginRecommendSceneActivity.this.mScene.O0000Oo0;
                    notifyDataSetChanged();
                    return;
                }
                hpt.O000000o(PluginRecommendSceneActivity.this.mScene, new hqy() {
                    /* class com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity.O000000o.AnonymousClass1 */

                    public final void onSaveLocalFail() {
                        if (PluginRecommendSceneActivity.this.isValid()) {
                            PluginRecommendSceneActivity.this.mPD.dismiss();
                            compoundButton.setChecked(!z);
                            O000000o.this.notifyDataSetChanged();
                        }
                    }

                    public final void onSaveCloudSuccess(boolean z) {
                        if (PluginRecommendSceneActivity.this.isValid()) {
                            PluginRecommendSceneActivity.this.mPD.dismiss();
                            O000000o.this.notifyDataSetChanged();
                            gqg.O00000Oo((int) R.string.save_success);
                        }
                    }

                    public final void onSaveCloudFail(int i, String str) {
                        if (PluginRecommendSceneActivity.this.isValid()) {
                            PluginRecommendSceneActivity.this.mPD.dismiss();
                            compoundButton.setChecked(!z);
                            O000000o.this.notifyDataSetChanged();
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000o0 o00000o0, View view) {
            if (PluginRecommendSceneActivity.this.is_connected_ble == -1) {
                PluginRecommendSceneActivity.this.getIsConnectBle();
            } else if (o00000o0.O00000Oo != null || (o00000o0.O00000o != null && o00000o0.O00000o.size() != 0)) {
                PluginRecommendSceneActivity.this.mScene = o00000o0.O00000Oo;
                if (PluginRecommendSceneActivity.this.mScene == null) {
                    PluginRecommendSceneActivity.this.mScene = new SceneApi.O000OOOo();
                    PluginRecommendSceneActivity.this.mScene.O0000O0o = o00000o0.O00000o;
                }
                hpt.O000000o().O0000OOo = PluginRecommendSceneActivity.this.mScene;
                SceneApi.O000OOOo o000OOOo = PluginRecommendSceneActivity.this.mScene;
                o000OOOo.O00000Oo = o00000o0.O00000o0 + hpt.O000000o().f492O000000o.intro;
                Intent intent = new Intent(PluginRecommendSceneActivity.this, PluginRecommendSceneActionActivity.class);
                intent.putExtra("connect_ble", PluginRecommendSceneActivity.this.is_connected_ble);
                intent.putExtra("did", PluginRecommendSceneActivity.this.device.did);
                if (PluginRecommendSceneActivity.this.home != null) {
                    intent.putExtra("home_id", PluginRecommendSceneActivity.this.home.getId());
                }
                PluginRecommendSceneActivity.this.startActivityForResult(intent, 1010);
            }
        }

        public final int getItemCount() {
            if (PluginRecommendSceneActivity.this.data == null) {
                return 0;
            }
            return PluginRecommendSceneActivity.this.data.size();
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000Oo(LayoutInflater.from(PluginRecommendSceneActivity.this).inflate((int) R.layout.item_plugin_recommend_scene, (ViewGroup) null));
        }
    }

    static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public ViewStub f10812O000000o;
        public View O00000Oo;
        public SwitchButton O00000o;
        public TextView O00000o0;
        public View O00000oO;
        public View O00000oo;
        public View O0000O0o;
        public TextView O0000OOo;
        public View O0000Oo;
        public TextView O0000Oo0;
        public View O0000OoO;

        public O00000Oo(View view) {
            super(view);
            this.f10812O000000o = (ViewStub) view.findViewById(R.id.group_title);
            this.O00000o0 = (TextView) view.findViewById(R.id.condition_name);
            this.O00000o = (SwitchButton) view.findViewById(R.id.open_check);
            this.O00000oO = view.findViewById(R.id.go_setting_arrow);
            this.O0000OoO = view.findViewById(R.id.divider1);
            this.O00000oo = view.findViewById(R.id.go_setting);
            this.O0000O0o = view.findViewById(R.id.action_layout);
            this.O0000OOo = (TextView) view.findViewById(R.id.action_name);
        }
    }
}
