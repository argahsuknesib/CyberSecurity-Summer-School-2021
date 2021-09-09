package com.xiaomi.smarthome.scene.pluginrecommend;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfr;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.hnw;
import _m_j.hod;
import _m_j.hpq;
import _m_j.hps;
import _m_j.hpt;
import _m_j.hqy;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxr;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerDelay;
import com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LightActionStartActivity extends BaseActivity implements hpt.O00000Oo, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleDraweeView f11193O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private View O00000o0;
    private TextView O00000oO;
    private View O00000oo;
    private TextView O0000O0o;
    private TextView O0000OOo;
    private View O0000Oo;
    private TextView O0000Oo0;
    private View O0000OoO;
    private SwitchButton O0000Ooo;
    private Device O0000o0 = null;
    private View O0000o00;
    private Home O0000o0O = null;
    private boolean O0000o0o = false;
    public boolean isNeedBleInfo = false;
    public boolean isRecommendSceneReady = false;
    public boolean isSceneReady = false;
    public XQProgressDialog mPD;
    public SceneApi.O000OOOo mScene;
    public int sr_id;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.light_rec_scene_action_activity);
        this.sr_id = getIntent().getIntExtra("sr_id", -1);
        String stringExtra = getIntent().getStringExtra("us_id");
        String stringExtra2 = getIntent().getStringExtra("did");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.O0000o0 = fno.O000000o().O000000o(stringExtra2);
            this.O0000o0O = ggb.O00000Oo().O0000o0(stringExtra2);
        }
        if (this.O0000o0O == null) {
            this.O0000o0O = ggb.O00000Oo().O0000Oo0();
        }
        if (this.sr_id <= 0 || this.O0000o0 == null || this.O0000o0O == null) {
            finish();
            return;
        }
        hxr hxr = hxi.O00000oO;
        String str = this.O0000o0.model;
        StringBuilder sb = new StringBuilder();
        sb.append(this.sr_id);
        hxr.O000000o(str, sb.toString());
        this.O0000O0o = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.entryDesc)) {
            this.O0000O0o.setText((int) R.string.setting);
        } else {
            this.O0000O0o.setText(hpt.O000000o().f492O000000o.intro);
        }
        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
            this.O0000O0o.setText((int) R.string.setting);
        } else {
            this.O0000O0o.setText(hpt.O000000o().f492O000000o.intro);
        }
        this.f11193O000000o = (SimpleDraweeView) findViewById(R.id.recommend_sdv);
        this.O00000o0 = findViewById(R.id.listitem_condition_select);
        this.O00000Oo = (TextView) findViewById(R.id.tv_condition_device_name);
        this.O0000OOo = (TextView) findViewById(R.id.tv_condition_select);
        this.O0000Oo = findViewById(R.id.listitem_delay_payload);
        this.O0000Ooo = (SwitchButton) findViewById(R.id.open_check);
        this.O0000o00 = findViewById(R.id.divider);
        this.O0000OoO = findViewById(R.id.listitem_delay_minute);
        this.O00000o = (TextView) findViewById(R.id.tv_delay_minute);
        this.O00000oO = (TextView) findViewById(R.id.tv_timespan);
        this.O00000oo = findViewById(R.id.listitem_timespan);
        this.O0000Oo0 = (TextView) findViewById(R.id.tv_enable);
        updateData(stringExtra);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            configDataSetUI();
            if (!O000000o()) {
                configUIfromScene(this.mScene);
            } else if (i == 1 || i == 1002 || i == 1011) {
                O00000o0();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private boolean O000000o() {
        SceneApi.O000OOOo o000OOOo = this.mScene;
        if (o000OOOo != null && !TextUtils.isEmpty(o000OOOo.f11131O000000o) && this.mScene.O0000Oo0) {
            return true;
        }
        return false;
    }

    public void updateData(String str) {
        SceneApi.O000OOOo O00000Oo2;
        this.isRecommendSceneReady = false;
        this.isSceneReady = false;
        hpt.O000000o();
        hpt.O00000o0();
        hpt.O000000o().O0000O0o = this;
        final AnonymousClass1 r0 = new fsm<SceneApi.O000OOOo, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.LightActionStartActivity.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                hpt.O000000o().O0000OOo = LightActionStartActivity.this.filterByHome((SceneApi.O000OOOo) obj);
                LightActionStartActivity.this.mScene = hpt.O000000o().O0000OOo;
                if (LightActionStartActivity.this.mScene != null) {
                    LightActionStartActivity lightActionStartActivity = LightActionStartActivity.this;
                    lightActionStartActivity.configUIfromScene(lightActionStartActivity.mScene);
                }
                LightActionStartActivity lightActionStartActivity2 = LightActionStartActivity.this;
                lightActionStartActivity2.isSceneReady = true;
                if (lightActionStartActivity2.isRecommendSceneReady && LightActionStartActivity.this.isSceneReady) {
                    LightActionStartActivity.this.configDataSetUI();
                }
            }

            public final void onFailure(fso fso) {
                LightActionStartActivity lightActionStartActivity = LightActionStartActivity.this;
                lightActionStartActivity.configUIfromScene(lightActionStartActivity.mScene);
            }
        };
        if (!TextUtils.isEmpty(str) && (O00000Oo2 = hod.O0000OoO().O00000Oo(str)) != null) {
            r0.onSuccess(O00000Oo2);
        }
        hps.O000000o().O000000o(this.O0000o0.did, this.sr_id, new fsm<List<SceneApi.O000OOOo>, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.LightActionStartActivity.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (list == null || list.size() <= 0) {
                    r0.onSuccess(null);
                    return;
                }
                fsm fsm = r0;
                if (fsm != null) {
                    fsm.onSuccess(list.get(0));
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = r0;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
        hps.O000000o().O000000o(this.O0000o0.did, new fsm<PluginRecommendSceneInfo, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.LightActionStartActivity.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                PluginRecommendSceneInfo pluginRecommendSceneInfo = (PluginRecommendSceneInfo) obj;
                if (pluginRecommendSceneInfo != null) {
                    hpt O000000o2 = hpt.O000000o();
                    StringBuilder sb = new StringBuilder();
                    sb.append(LightActionStartActivity.this.sr_id);
                    O000000o2.f492O000000o = pluginRecommendSceneInfo.getItemBy(sb.toString());
                }
                if (hpt.O000000o().f492O000000o != null) {
                    if (TextUtils.equals(hpt.O000000o().f492O000000o.sr_id, "1003")) {
                        LightActionStartActivity.this.isNeedBleInfo = true;
                    }
                    hpt.O000000o().O000000o(pluginRecommendSceneInfo.mConditionScIds, pluginRecommendSceneInfo.mActionSaIds);
                    hpt.O000000o().O00000Oo();
                    LightActionStartActivity.this.configUIfromRecommend(hpt.O000000o().f492O000000o);
                }
                LightActionStartActivity lightActionStartActivity = LightActionStartActivity.this;
                lightActionStartActivity.isRecommendSceneReady = true;
                if (lightActionStartActivity.isRecommendSceneReady && LightActionStartActivity.this.isSceneReady) {
                    LightActionStartActivity.this.configDataSetUI();
                }
            }

            public final void onFailure(fso fso) {
                LightActionStartActivity.this.configDataSetUI();
            }
        });
    }

    public SceneApi.O000OOOo filterByHome(SceneApi.O000OOOo o000OOOo) {
        Home O0000o02;
        if (o000OOOo == null) {
            return null;
        }
        if (o000OOOo.O0000O0o != null && o000OOOo.O0000O0o.size() > 0) {
            for (int size = o000OOOo.O0000O0o.size() - 1; size >= 0; size--) {
                if (o000OOOo.O0000O0o.get(size).O00000o0 != null && ((O0000o02 = ggb.O00000Oo().O0000o0(o000OOOo.O0000O0o.get(size).O00000o0.f11122O000000o)) == null || !TextUtils.equals(O0000o02.getId(), this.O0000o0O.getId()))) {
                    o000OOOo.O0000O0o.remove(size);
                }
            }
        }
        if (o000OOOo.O00000oo != null && o000OOOo.O00000oo.size() > 0) {
            for (int size2 = o000OOOo.O00000oo.size() - 1; size2 >= 0; size2--) {
                if (o000OOOo.O00000oo.get(size2).O0000O0o != null && (o000OOOo.O00000oo.get(size2).O0000O0o instanceof SceneApi.O000OO0o) && o000OOOo.O00000oo.get(size2).f11120O000000o == 0 && !TextUtils.equals(ggb.O00000Oo().O0000o0(o000OOOo.O00000oo.get(size2).O0000O0o.O00000o).getId(), this.O0000o0O.getId())) {
                    o000OOOo.O00000oo.remove(size2);
                }
            }
        }
        return o000OOOo;
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
    public void configDataSetUI() {
        List list;
        List list2;
        if (hpt.O000000o().f492O000000o == null) {
            if (gfr.O0000OOo) {
                gqg.O00000Oo("edit scene created by rec,but rec does not exist!");
            }
            if (this.mScene != null) {
                Intent intent = new Intent(this, SmarthomeCreateAutoSceneActivity.class);
                intent.putExtra("extra_recommend_edit", false);
                Device device = this.O0000o0;
                if (device != null && !TextUtils.isEmpty(device.did)) {
                    intent.putExtra("extra_device_id", this.O0000o0.did);
                }
                hpq.O000000o().O000000o(this.mScene);
                startActivity(intent);
            }
            finish();
            return;
        }
        if (this.mScene == null) {
            hpt.O000000o().O0000OOo = new SceneApi.O000OOOo();
            this.mScene = hpt.O000000o().O0000OOo;
            SceneApi.O000OOOo o000OOOo = this.mScene;
            o000OOOo.O0000Oo0 = false;
            o000OOOo.O0000Oo = true;
            o000OOOo.O00000o = this.sr_id;
            o000OOOo.O0000oO = new SceneApi.O0000o0();
            this.mScene.O00000oo = new ArrayList();
            SceneApi.Action action = null;
            if (!(hpt.O000000o().O00000oo == null || (list2 = hpt.O000000o().O00000oo.get(this.O0000o0.name)) == null || list2.size() <= 1)) {
                action = (SceneApi.Action) list2.get(0);
            }
            if (action != null) {
                this.mScene.O00000oo.add(action);
                List<SceneApi.Action> O00000Oo2 = O00000Oo();
                if (O00000Oo2 != null && O00000Oo2.size() == 2 && O00000Oo2.get(0).O0000O0o.O00000oo > 0) {
                    this.mScene.O00000oo.addAll(O00000Oo2);
                }
            } else if (gfr.f17662O000000o) {
                gqg.O00000Oo("配置出错");
            }
            if (hpt.O000000o().O00000oO != null && hpt.O000000o().O00000oO.size() > 0) {
                String[] strArr = (String[]) hpt.O000000o().O00000oO.keySet().toArray(new String[0]);
                if (strArr.length > 0 && (list = hpt.O000000o().O00000oO.get(strArr[0])) != null && list.size() > 0) {
                    this.mScene.O0000O0o.add(list.get(0));
                }
            }
        }
        configUIfromScene(this.mScene);
        this.O00000o0.setOnClickListener(this);
        this.O0000Oo.setOnClickListener(this);
        this.O0000Ooo.setOnClickListener(this);
        this.O0000Ooo.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$LightActionStartActivity$6Xo8wgEoiCkX9MnW5DCU4OPr320 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LightActionStartActivity.this.O000000o(compoundButton, z);
            }
        });
        this.O00000oo.setOnClickListener(this);
        this.O0000Oo0.setOnClickListener(this);
        if (!this.O0000o0o) {
            this.O0000o0o = true;
            if (this.mScene.O0000O0o == null || this.mScene.O0000O0o.size() == 0) {
                hxr hxr = hxi.O00000oO;
                String str = this.O0000o0.model;
                StringBuilder sb = new StringBuilder();
                sb.append(this.sr_id);
                hxr.O00000oo(str, sb.toString());
                return;
            }
            hxr hxr2 = hxi.O00000oO;
            String str2 = this.O0000o0.model;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.sr_id);
            hxr2.O00000oO(str2, sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
        O000000o(z);
    }

    private void O000000o(boolean z) {
        hxk hxk = hxi.O00000o;
        String str = this.O0000o0.model;
        StringBuilder sb = new StringBuilder();
        sb.append(this.sr_id);
        String sb2 = sb.toString();
        hxk.f952O000000o.O000000o("rec_auto_turnoff", "model", str, "sr_id", sb2);
        if (z) {
            this.O0000OoO.setVisibility(8);
            this.O0000o00.setVisibility(8);
        } else {
            this.O0000OoO.setVisibility(0);
            this.O0000o00.setVisibility(0);
        }
        if (z) {
            this.mScene.O00000oo.addAll(getAdditionActions());
        } else {
            this.mScene.O00000oo.remove(2);
            this.mScene.O00000oo.remove(1);
        }
        if (O000000o()) {
            O00000o0();
        } else {
            configUIfromScene(this.mScene);
        }
    }

    private List<SceneApi.Action> O00000Oo() {
        List list;
        SceneApi.Action action = new SceneApi.Action();
        action.f11120O000000o = 2;
        action.O00000Oo = ServiceApplication.getAppContext().getString(R.string.smarthome_scene_delay);
        action.O00000o0 = getString(R.string.smarthome_scene_delay);
        action.O00000oO = "delay";
        SceneApi.O000O0o0 o000O0o0 = new SceneApi.O000O0o0();
        o000O0o0.O00000oo = 300;
        o000O0o0.O00000o0 = action.O00000oO + ".delay";
        action.O0000O0o = o000O0o0;
        if (hpt.O000000o().O00000oo == null || (list = hpt.O000000o().O00000oo.get(this.O0000o0.name)) == null || list.size() <= 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(action);
        arrayList.add(list.get(1));
        return arrayList;
    }

    public void configUIfromScene(SceneApi.O000OOOo o000OOOo) {
        SceneApi.Action action;
        SceneApi.Action action2;
        String str;
        if (this.mScene.O0000Oo0) {
            this.O0000Oo0.setText((int) R.string.light_rec_enable_1);
            this.O0000Oo0.setBackgroundResource(R.drawable.common_flow_tag_item_normal_bg);
            this.O0000Oo0.setTextColor(getResources().getColor(R.color.common_button));
        } else {
            this.O0000Oo0.setText((int) R.string.light_rec_enable_0);
            this.O0000Oo0.setBackgroundResource(R.drawable.selector_ble_mesh_button);
            this.O0000Oo0.setTextColor(getResources().getColor(R.color.mj_color_white));
        }
        if (this.mScene.O00000oo == null || this.mScene.O00000oo.size() == 0 || this.mScene.O0000O0o == null || this.mScene.O0000O0o.size() == 0) {
            this.O0000Oo0.setEnabled(this.mScene.O0000Oo0);
        } else {
            this.O0000Oo0.setEnabled(true);
        }
        hnw.O000000o(this.mScene.O0000oO, this.O00000oO, getString(R.string.scene_exetime_second_day));
        if (o000OOOo.O00000oo != null && o000OOOo.O00000oo.size() > 0) {
            if (o000OOOo.O00000oo.size() == 1) {
                action = o000OOOo.O00000oo.get(0);
                action2 = null;
            } else if (o000OOOo.O00000oo.size() == 3) {
                SceneApi.Action action3 = o000OOOo.O00000oo.get(0);
                action2 = o000OOOo.O00000oo.get(1);
                action = action3;
            } else {
                action = null;
                action2 = null;
            }
            if (gfr.f17662O000000o && action == null) {
                gqg.O00000Oo("打开的动作构建失败了");
            }
            if (!(action == null || action.f11120O000000o != 0 || action.O0000O0o == null)) {
                if (action2 == null || action2.O0000O0o == null || action2.O0000O0o.O00000oo <= 0) {
                    this.O0000Ooo.setChecked(false);
                    this.O0000o00.setVisibility(8);
                    this.O0000OoO.setVisibility(8);
                    this.O0000OoO.setOnClickListener(null);
                } else {
                    this.O0000Ooo.setChecked(true);
                    this.O0000o00.setVisibility(0);
                    this.O0000OoO.setVisibility(0);
                    this.O0000OoO.setOnClickListener(this);
                    if (action2.O0000O0o.O00000oo < 60) {
                        str = getResources().getQuantityString(R.plurals.smarthome_scene_delay_detal_sec, action2.O0000O0o.O00000oo % 60, Integer.valueOf(action2.O0000O0o.O00000oo % 60));
                    } else if (action2.O0000O0o.O00000oo % 60 == 0) {
                        str = getResources().getQuantityString(R.plurals.smarthome_scene_delay_detal_min, action2.O0000O0o.O00000oo / 60, Integer.valueOf(action2.O0000O0o.O00000oo / 60));
                    } else {
                        str = String.format(getString(R.string.smarthome_scene_delay_detal_min_sec), getResources().getQuantityString(R.plurals.automation_minute, action2.O0000O0o.O00000oo / 60, Integer.valueOf(action2.O0000O0o.O00000oo / 60)), getResources().getQuantityString(R.plurals.automation_seconds, action2.O0000O0o.O00000oo % 60, Integer.valueOf(action2.O0000O0o.O00000oo % 60)));
                    }
                    this.O00000o.setText(str);
                }
            }
        }
        if (this.mScene.O0000O0o == null || this.mScene.O0000O0o.size() <= 0) {
            this.O00000Oo.setText((int) R.string.light_rec_non_condition);
        } else if (this.mScene.O0000O0o.get(0).O00000o0 == null) {
            this.O00000Oo.setText((int) R.string.light_rec_non_condition);
        } else if (fno.O000000o().O000000o(this.mScene.O0000O0o.get(0).O00000o0.f11122O000000o) != null) {
            String str2 = this.mScene.O0000O0o.get(0).O00000o0.O00000o0;
            TextView textView = this.O00000Oo;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            textView.setText(str2);
        } else {
            this.O00000Oo.setText((int) R.string.light_rec_non_condition);
            this.mScene.O0000O0o.clear();
        }
    }

    public void configUIfromRecommend(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
            this.O0000O0o.setText((int) R.string.setting);
        } else {
            this.O0000O0o.setText(hpt.O000000o().f492O000000o.intro);
        }
        this.f11193O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(200).setPlaceholderImage(getResources().getDrawable(R.drawable.recommend_scene_list_default_icon)).setActualImageScaleType(ScalingUtils.ScaleType.CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        if (!TextUtils.isEmpty(recommendSceneItem.cardImgUrl)) {
            this.f11193O000000o.setImageURI(Uri.parse(recommendSceneItem.cardImgUrl));
        } else {
            this.f11193O000000o.setImageResource(R.drawable.recommend_scene_list_default_icon);
        }
        if (recommendSceneItem.mConditionList.size() > 0) {
            String str = recommendSceneItem.mConditionList.get(0).name;
            TextView textView = this.O0000OOo;
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            objArr[0] = str;
            textView.setText(getString(R.string.light_rec_condition_name, objArr));
            return;
        }
        this.O0000OOo.setText(getString(R.string.light_rec_condition_name, new Object[]{""}));
    }

    private static List<Device> O000000o(String str, Home home) {
        ArrayList arrayList = new ArrayList();
        for (Device next : ggb.O00000Oo().O0000Oo(home.getId())) {
            if (TextUtils.equals(str, next.model)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static List<SceneApi.O000000o> O000000o(int i, JSONObject jSONObject, List<Device> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Device next : list) {
                String format = String.format(jSONObject.optString("key"), next.model);
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                jSONObject2.put("key", format);
                jSONObject2.put("model", next.model);
                SceneApi.O000000o O000000o2 = SceneApi.O000000o.O000000o(jSONObject2);
                if (O000000o2.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                    if (O000000o2.O00000o0 != null && (O000000o2.O00000o0 instanceof SceneApi.O00000o0)) {
                        ((SceneApi.O00000o0) O000000o2.O00000o0).f11122O000000o = next.did;
                        ((SceneApi.O00000o0) O000000o2.O00000o0).O00000o = next.model;
                        ((SceneApi.O00000o0) O000000o2.O00000o0).O00000o0 = next.name;
                        ((SceneApi.O00000o0) O000000o2.O00000o0).O0000OoO = i;
                    }
                    arrayList.add(O000000o2);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private void O00000o0() {
        this.mPD = XQProgressDialog.O000000o(this, null, getResources().getString(R.string.smarthome_scene_saving_scene));
        if (TextUtils.isEmpty(this.mScene.O00000Oo)) {
            SceneApi.O000OOOo o000OOOo = this.mScene;
            o000OOOo.O00000Oo = hnw.O000000o(o000OOOo);
        }
        SceneApi.O000OOOo o000OOOo2 = this.mScene;
        if (o000OOOo2 == null || o000OOOo2.O00000oo == null || this.mScene.O00000oo.size() == 0 || this.mScene.O0000O0o == null || this.mScene.O0000O0o.size() == 0) {
            if (isValid()) {
                this.mPD.dismiss();
            }
            gqg.O00000Oo((int) R.string.save_fail);
            updateData(null);
            return;
        }
        hpt.O000000o(this.mScene, new hqy() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.LightActionStartActivity.AnonymousClass4 */

            public final void onSaveLocalFail() {
                if (LightActionStartActivity.this.isValid()) {
                    LightActionStartActivity.this.mPD.dismiss();
                }
                gqg.O00000Oo((int) R.string.save_fail);
            }

            public final void onSaveCloudSuccess(boolean z) {
                if (LightActionStartActivity.this.isValid()) {
                    LightActionStartActivity.this.mPD.dismiss();
                }
                LightActionStartActivity.this.updateData(null);
            }

            public final void onSaveCloudFail(int i, String str) {
                if (LightActionStartActivity.this.isValid()) {
                    LightActionStartActivity.this.mPD.dismiss();
                }
                if (i == -9000) {
                    gqg.O00000Oo((int) R.string.smarthome_scene_getway_offline);
                } else {
                    gqg.O00000Oo((int) R.string.save_fail);
                }
            }
        });
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
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            finish();
        } else if (id == R.id.listitem_condition_select) {
            Intent intent = new Intent(this, LightConditionActivity.class);
            intent.putExtra("home_id", this.O0000o0O.getId());
            intent.putExtra("device_model", this.O0000o0.model);
            intent.putExtra("sr_id", this.sr_id);
            intent.putExtra("is_need_ble", this.isNeedBleInfo);
            startActivityForResult(intent, 1002);
        } else if (id == R.id.listitem_delay_minute) {
            hxk hxk = hxi.O00000o;
            String str = this.O0000o0.model;
            StringBuilder sb = new StringBuilder();
            sb.append(this.sr_id);
            String sb2 = sb.toString();
            hxk.f952O000000o.O000000o("rec_auto_delaytime", "model", str, "sr_id", sb2);
            Intent intent2 = new Intent(this, SmartHomeSceneTimerDelay.class);
            intent2.putExtra("is_from_recommend", true);
            intent2.putExtra("delay_action_pos", 1);
            startActivityForResult(intent2, 1);
        } else if (id == R.id.listitem_timespan) {
            hxk hxk2 = hxi.O00000o;
            String str2 = this.O0000o0.model;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.sr_id);
            hxk2.O00000Oo(str2, sb3.toString());
            Intent intent3 = new Intent(this, SceneCreateTimeEdit2Activity.class);
            intent3.putExtra("is_from_recommend", true);
            startActivityForResult(intent3, 1011);
        } else if (id == R.id.tv_enable) {
            SceneApi.O000OOOo o000OOOo = this.mScene;
            o000OOOo.O0000Oo0 = !o000OOOo.O0000Oo0;
            if (this.mScene.O0000Oo0 && TextUtils.isEmpty(this.mScene.f11131O000000o)) {
                hxk hxk3 = hxi.O00000o;
                String str3 = this.O0000o0.model;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.sr_id);
                hxk3.O00000o0(str3, sb4.toString());
            }
            O00000o0();
        } else if (id == R.id.listitem_delay_payload) {
            SwitchButton switchButton = this.O0000Ooo;
            switchButton.setChecked(!switchButton.isChecked());
            O000000o(this.O0000Ooo.isChecked());
        }
    }

    public Map<String, List<SceneApi.Action>> getSelectionActions(Map<Integer, SceneApi.Action> map) {
        HashMap hashMap = new HashMap();
        int optInt = hpt.O000000o().f492O000000o.mActionList.get(0).modelListJobj.optInt(this.O0000o0.model);
        SceneApi.Action action = map.get(Integer.valueOf(optInt));
        if (action != null) {
            action.O00000oo = optInt;
            action.O00000oO = this.O0000o0.model;
            action.f11120O000000o = 0;
            action.O0000O0o.O00000o = this.O0000o0.did;
            ArrayList arrayList = new ArrayList();
            arrayList.add(action);
            hashMap.put(this.O0000o0.name, arrayList);
            int optInt2 = hpt.O000000o().f492O000000o.mActionList.get(1).modelListJobj.optInt(this.O0000o0.model);
            SceneApi.Action action2 = map.get(Integer.valueOf(optInt2));
            if (action2 != null) {
                action2.O00000oo = optInt2;
                action2.O00000oO = this.O0000o0.model;
                action2.f11120O000000o = 0;
                action2.O0000O0o.O00000o = this.O0000o0.did;
                arrayList.add(action2);
            }
        }
        return hashMap;
    }

    public Map<String, List<SceneApi.O000000o>> getSelctionConditions(Map<Integer, SceneApi.O000000o> map) {
        HashMap hashMap = new HashMap();
        if (hpt.O000000o().f492O000000o.mConditionList != null && hpt.O000000o().f492O000000o.mConditionList.size() > 0) {
            for (int i = 0; i < hpt.O000000o().f492O000000o.mConditionList.size(); i++) {
                JSONObject jSONObject = hpt.O000000o().f492O000000o.mConditionList.get(i).modelListJobj;
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        List<Device> O000000o2 = O000000o(next, this.O0000o0O);
                        if (O000000o2.size() != 0) {
                            int optInt = jSONObject.optInt(next);
                            JSONObject jSONObject2 = hpt.O000000o().O00000Oo.get(String.valueOf(optInt));
                            if (jSONObject2 != null) {
                                List<SceneApi.O000000o> O000000o3 = O000000o(optInt, jSONObject2, O000000o2);
                                if (!hashMap.containsKey(String.valueOf(optInt)) || hashMap.get(String.valueOf(optInt)) == null) {
                                    hashMap.put(String.valueOf(optInt), O000000o3);
                                } else {
                                    ((List) hashMap.get(String.valueOf(optInt))).addAll(O000000o3);
                                }
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public List<SceneApi.Action> getAdditionActions() {
        ArrayList arrayList = new ArrayList();
        SceneApi.O000OOOo o000OOOo = this.mScene;
        if (o000OOOo != null && o000OOOo.O00000oo != null && this.mScene.O00000oo.size() == 3) {
            arrayList.add(this.mScene.O00000oo.get(1));
            arrayList.add(this.mScene.O00000oo.get(2));
        } else if (O00000Oo() != null) {
            arrayList.addAll(O00000Oo());
        }
        return arrayList;
    }

    public List<SceneApi.O000000o> getAdditionConditions() {
        return new ArrayList();
    }
}
