package com.xiaomi.smarthome.scene.pluginrecommend;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfr;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gwq;
import _m_j.hnw;
import _m_j.hpq;
import _m_j.hps;
import _m_j.hpt;
import _m_j.hqt;
import _m_j.hqu;
import _m_j.hqv;
import _m_j.hqw;
import _m_j.hqx;
import _m_j.hqy;
import _m_j.hsi;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxr;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity;
import com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateSceneFromRecommendActivity extends BaseActivity implements hpt.O00000Oo, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleDraweeView f11179O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private View O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private View O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private TextView O0000OoO;
    private View O0000Ooo;
    private View O0000o;
    private View O0000o0;
    private View O0000o00;
    private View O0000o0O;
    private SwitchButton O0000o0o;
    private boolean O0000oO = false;
    private TextView O0000oO0;
    private boolean O0000oOO = false;
    private SceneApi.Action O0000oOo = null;
    private boolean O0000oo = false;
    private SceneApi.O000000o O0000oo0 = null;
    public Device device = null;
    public Home home = null;
    public boolean isNeedBleInfo = false;
    public boolean isRecommendSceneReady = false;
    public boolean isSceneReady = false;
    public XQProgressDialog mPD;
    public hqv mRecommendUI;
    public SceneApi.O000OOOo mScene;
    public int sr_id;

    public List<SceneApi.Action> getAdditionActions() {
        return null;
    }

    public List<SceneApi.O000000o> getAdditionConditions() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.plugin_rec_scene_main_activity);
        this.sr_id = getIntent().getIntExtra("sr_id", -1);
        String stringExtra = getIntent().getStringExtra("us_id");
        String stringExtra2 = getIntent().getStringExtra("did");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.device = fno.O000000o().O000000o(stringExtra2);
            this.home = ggb.O00000Oo().O0000o0(stringExtra2);
        }
        if (this.home == null) {
            this.home = ggb.O00000Oo().O0000Oo0();
        }
        if (this.sr_id <= 0 || this.device == null || this.home == null) {
            finish();
            return;
        }
        hxr hxr = hxi.O00000oO;
        String str = this.device.model;
        StringBuilder sb = new StringBuilder();
        sb.append(this.sr_id);
        hxr.O000000o(str, sb.toString());
        this.O0000Oo0 = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.entryDesc)) {
            this.O0000Oo0.setText((int) R.string.setting);
        } else {
            this.O0000Oo0.setText(hpt.O000000o().f492O000000o.intro);
        }
        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
            this.O0000Oo0.setText((int) R.string.setting);
        } else {
            this.O0000Oo0.setText(hpt.O000000o().f492O000000o.intro);
        }
        this.f11179O000000o = (SimpleDraweeView) findViewById(R.id.recommend_sdv);
        this.O00000oO = findViewById(R.id.listitem_condition_select);
        this.O0000o0 = findViewById(R.id.listitem_condition_detail_select);
        this.O0000o0O = findViewById(R.id.icon_go_detail);
        this.O00000Oo = (TextView) findViewById(R.id.tv_condition_device_name);
        this.O0000Oo = (TextView) findViewById(R.id.tv_condition_select);
        this.O00000o0 = (TextView) findViewById(R.id.tv_condition_detail_select);
        this.O00000o = (TextView) findViewById(R.id.tv_condition_detail_name);
        this.O0000Ooo = findViewById(R.id.listitem_delay_payload);
        this.O0000o0o = (SwitchButton) findViewById(R.id.open_check);
        this.O0000o = findViewById(R.id.divider);
        this.O0000o00 = findViewById(R.id.listitem_delay_minute);
        this.O00000oo = (TextView) findViewById(R.id.tv_delay_minute);
        this.O0000O0o = (TextView) findViewById(R.id.tv_timespan);
        this.O0000OOo = findViewById(R.id.listitem_timespan);
        this.O0000OoO = (TextView) findViewById(R.id.tv_enable);
        this.O0000o0 = findViewById(R.id.listitem_condition_detail_select);
        this.O0000oO0 = (TextView) findViewById(R.id.tv_not_connect_ble);
        updateData(stringExtra);
        if (hpt.O00000Oo(this.device.did)) {
            final String str2 = this.device.did;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            hps.O000000o();
            hps.O000000o(arrayList, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass6 */

                public final void onFailure(fso fso) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        JSONArray optJSONArray = jSONObject.optJSONArray(str2);
                        if (optJSONArray == null || optJSONArray.length() == 0) {
                            CreateSceneFromRecommendActivity.this.setNoBleVisible(true, false);
                        }
                    }
                }
            });
        }
    }

    public void setNoBleVisible(final boolean z, boolean z2) {
        String string = getString(R.string.device_rec_condition_no_ble);
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
        AnonymousClass1 r8 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass1 */

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
            public final void onClick(View view) {
                List<Device> O000000o2 = hpt.O000000o(CreateSceneFromRecommendActivity.this.home.getId());
                if (O000000o2 == null || O000000o2.size() == 0) {
                    hxi.O00000oO.O0000Oo0(CreateSceneFromRecommendActivity.this.device.model, hpt.O000000o().f492O000000o.sr_id);
                    Intent intent = new Intent(CreateSceneFromRecommendActivity.this, ActionConditionDeviceSelectActivity.class);
                    try {
                        intent.putExtra("sr_id", Integer.parseInt(hpt.O000000o().f492O000000o.sr_id));
                    } catch (Exception unused) {
                    }
                    intent.putExtra("home_id", CreateSceneFromRecommendActivity.this.home.getId());
                    intent.putExtra("is_only_ble", z);
                    intent.putExtra("only_buy_guide", true);
                    CreateSceneFromRecommendActivity.this.startActivity(intent);
                    return;
                }
                hxi.O00000oO.O0000OOo(CreateSceneFromRecommendActivity.this.device.model, hpt.O000000o().f492O000000o.sr_id);
                Intent intent2 = new Intent(CreateSceneFromRecommendActivity.this, LockDissConnectBleActivity.class);
                intent2.putExtra("home_id", CreateSceneFromRecommendActivity.this.home.getId());
                intent2.putExtra("sr_id", hpt.O000000o().f492O000000o.sr_id);
                CreateSceneFromRecommendActivity.this.startActivity(intent2);
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(CreateSceneFromRecommendActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                textPaint.setUnderlineText(true);
            }
        };
        if (indexOf >= 0 && indexOf2 > 0) {
            try {
                spannableStringBuilder.setSpan(r8, indexOf, indexOf2, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.O0000oO0.setText(spannableStringBuilder);
        this.O0000oO0.setHighlightColor(0);
        this.O0000oO0.setMovementMethod(LinkMovementMethod.getInstance());
        this.O0000oO0.setVisibility(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f5  */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            boolean z = false;
            if (i == 1003) {
                if (hqv.O000000o(hpt.O000000o().f492O000000o.mCommonActions.get(Integer.valueOf(this.mScene.O00000oo.get(0).O00000oo)), hpt.O000000o().O0000OOo)) {
                    O000000o();
                } else if (isSaveImmediately()) {
                    saveScene();
                }
            } else if (i == 1002) {
                if (this.mRecommendUI.O000000o(hpt.O000000o().f492O000000o.mCommonConditions.get(Integer.valueOf(this.mScene.O0000O0o.get(0).O00000o0.O0000OoO)))) {
                    O000000o();
                } else if (isSaveImmediately()) {
                    saveScene();
                }
            } else if (i == 1004) {
                if (isSaveImmediately()) {
                    saveScene();
                }
            } else if (i == 103 || i == 104) {
                SceneApi.O00000o0 o00000o0 = (SceneApi.O00000o0) this.mScene.O0000O0o.get(0).O00000o0;
                if (intent != null && intent.hasExtra("key_name")) {
                    o00000o0.O00000Oo = intent.getStringExtra("key_name");
                }
                if (intent == null || !intent.hasExtra("value")) {
                    o00000o0.O0000Ooo = hpt.O000000o().f492O000000o.mCommonConditions.get(Integer.valueOf(o00000o0.O0000OoO)).mValue;
                } else if (intent.getStringExtra("value") != null) {
                    boolean z2 = true;
                    try {
                        o00000o0.O0000Ooo = new JSONObject(intent.getStringExtra("value"));
                        z = true;
                    } catch (JSONException unused) {
                    }
                    if (!z) {
                        try {
                            o00000o0.O0000Ooo = new JSONArray(intent.getStringExtra("value"));
                        } catch (JSONException unused2) {
                        }
                        if (!z2) {
                            o00000o0.O0000Ooo = intent.getStringExtra("value");
                        }
                    }
                    z2 = z;
                    if (!z2) {
                    }
                } else {
                    o00000o0.O0000Ooo = intent.getExtras().get("value");
                }
                if (isSaveImmediately()) {
                    saveScene();
                }
            } else if (isSaveImmediately()) {
                this.mScene = hpt.O000000o().O0000OOo;
                saveScene();
            }
            configDataSetUI();
        } else if (i2 == 0 && intent != null && TextUtils.equals("no data", intent.getStringExtra("msg")) && i == 1004) {
            this.O00000oO.performClick();
        }
    }

    private void O000000o() {
        SceneApi.O000OOOo o000OOOo = this.mScene;
        if (o000OOOo != null) {
            if (o000OOOo.O00000oo != null && this.mScene.O00000oo.size() > 0) {
                this.O0000oOo = this.mScene.O00000oo.get(0);
                this.mRecommendUI.O000000o(this, this.mScene.O00000oo.get(0), new hpt.O000000o() {
                    /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass7 */

                    public final void O000000o(int i, Intent intent) {
                        CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                        createSceneFromRecommendActivity.onActionSelected(i, createSceneFromRecommendActivity.mScene.O00000oo.get(0), intent);
                    }
                });
            }
            if (this.mScene.O0000O0o != null && this.mScene.O0000O0o.size() > 0) {
                this.O0000oo0 = this.mScene.O0000O0o.get(0);
                this.mRecommendUI.O000000o(this, this.mScene.O0000O0o.get(0), new hpt.O000000o() {
                    /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass8 */

                    public final void O000000o(int i, Intent intent) {
                        CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                        createSceneFromRecommendActivity.onConditionSelected(i, createSceneFromRecommendActivity.mScene.O0000O0o.get(0), intent);
                    }
                });
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02cf, code lost:
        if (android.text.TextUtils.equals("action_tts", r4) != false) goto L_0x027c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01cf  */
    public void configUIfromScene(SceneApi.O000OOOo o000OOOo) {
        boolean z;
        String str;
        String str2;
        SceneApi.Action action;
        String str3;
        PluginRecommendSceneInfo.CommonSceneAction commonSceneAction;
        Object obj;
        String str4;
        PluginRecommendSceneInfo.CommonSceneAction commonSceneAction2;
        String str5;
        if (this.mScene.O0000Oo0) {
            this.O0000OoO.setText((int) R.string.light_rec_enable_1);
            this.O0000OoO.setBackgroundResource(R.drawable.common_flow_tag_item_normal_bg);
            this.O0000OoO.setTextColor(getResources().getColor(R.color.common_button));
        } else {
            this.O0000OoO.setText((int) R.string.light_rec_enable_0);
            this.O0000OoO.setBackgroundResource(R.drawable.selector_ble_mesh_button);
            this.O0000OoO.setTextColor(getResources().getColor(R.color.mj_color_white));
        }
        if (this.mScene.O00000oo == null || this.mScene.O00000oo.size() == 0 || this.mScene.O0000O0o == null || this.mScene.O0000O0o.size() == 0) {
            this.O0000OoO.setEnabled(this.mScene.O0000Oo0);
        } else {
            this.O0000OoO.setEnabled(true);
        }
        hnw.O000000o(this.mScene.O0000oO, this.O0000O0o, getString(R.string.scene_exetime_second_day));
        String str6 = null;
        if (this.mScene.O0000O0o == null || this.mScene.O0000O0o.size() <= 0) {
            str2 = null;
            str = null;
            z = false;
        } else {
            str2 = this.mRecommendUI.O000000o(this.mScene.O0000O0o.get(0));
            str = this.mRecommendUI.O00000Oo(this.mScene.O0000O0o.get(0));
            z = this.mRecommendUI.O00000o(this.mScene);
        }
        if (TextUtils.isEmpty(str2) && this.mScene.O00000oo != null && this.mScene.O00000oo.size() > 0) {
            hqv hqv = this.mRecommendUI;
            SceneApi.Action action2 = this.mScene.O00000oo.get(0);
            if (!(action2 == null || hqv.f539O000000o.mCommonActions == null || (commonSceneAction2 = hqv.f539O000000o.mCommonActions.get(Integer.valueOf(action2.O00000oo))) == null || !hqv.O000000o(commonSceneAction2, hpt.O000000o().O0000OOo))) {
                if (commonSceneAction2.mAttr != null && (commonSceneAction2.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker)) {
                    if (!TextUtils.isEmpty(hqv.f539O000000o.selectValueHint)) {
                        str4 = hqv.f539O000000o.selectValueHint;
                    } else if (!TextUtils.isEmpty(commonSceneAction2.mName)) {
                        str4 = commonSceneAction2.mName;
                    }
                    hqv hqv2 = this.mRecommendUI;
                    action = this.mScene.O00000oo.get(0);
                    if (!(action == null || hqv2.f539O000000o.mCommonActions == null || (commonSceneAction = hqv2.f539O000000o.mCommonActions.get(Integer.valueOf(action.O00000oo))) == null || !hqv.O000000o(commonSceneAction, hpt.O000000o().O0000OOo) || action.O0000O0o == null)) {
                        obj = ((SceneApi.O000OO0o) action.O0000O0o).O00000oO;
                        if (!(obj instanceof JSONObject)) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (commonSceneAction.mAttr != null && (commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker)) {
                                PluginRecommendSceneInfo.SceneAttrNumberPicker sceneAttrNumberPicker = (PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneAction.mAttr;
                                if ("min".equalsIgnoreCase(sceneAttrNumberPicker.jsonTag)) {
                                    str6 = jSONObject.optString("max");
                                    if (!TextUtils.isEmpty(sceneAttrNumberPicker.degree)) {
                                        str6 = str6 + sceneAttrNumberPicker.degree;
                                    }
                                } else if ("max".equalsIgnoreCase(sceneAttrNumberPicker.jsonTag)) {
                                    str6 = jSONObject.optString("min");
                                    if (!TextUtils.isEmpty(sceneAttrNumberPicker.degree)) {
                                        str6 = str6 + sceneAttrNumberPicker.degree;
                                    }
                                } else if ("equals".equalsIgnoreCase(sceneAttrNumberPicker.jsonTag)) {
                                    str6 = jSONObject.optString("equals");
                                    if (!TextUtils.isEmpty(sceneAttrNumberPicker.degree)) {
                                        str6 = str6 + sceneAttrNumberPicker.degree;
                                    }
                                }
                            } else if (jSONObject.has("text") && !TextUtils.isEmpty(jSONObject.optString("text"))) {
                                if (!TextUtils.equals("action_tts", jSONObject.optString("text"))) {
                                    str6 = jSONObject.optString("text");
                                }
                            }
                        } else if (obj instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) obj;
                            if (jSONArray != null && jSONArray.length() > 0) {
                                str6 = jSONArray.optString(0);
                            }
                        } else if (obj instanceof String) {
                            String str7 = (String) obj;
                            if (!TextUtils.isEmpty(str7)) {
                                if (commonSceneAction.mAttr != null && (commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker)) {
                                    PluginRecommendSceneInfo.SceneAttrNumberPicker sceneAttrNumberPicker2 = (PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneAction.mAttr;
                                    if (!TextUtils.isEmpty(sceneAttrNumberPicker2.degree)) {
                                        str6 = str7 + sceneAttrNumberPicker2.degree;
                                    }
                                }
                                str3 = str7;
                                z = this.mRecommendUI.O00000o0(this.mScene);
                            }
                        }
                        str3 = "";
                        z = this.mRecommendUI.O00000o0(this.mScene);
                    }
                    str3 = str6;
                    z = this.mRecommendUI.O00000o0(this.mScene);
                }
                if (action2 != null && !TextUtils.isEmpty(action2.O00000oO)) {
                    PluginPackageInfo O0000Oo2 = CoreApi.O000000o().O0000Oo(action2.O00000oO);
                    if (O0000Oo2 == null) {
                        str5 = "";
                    } else {
                        str5 = O0000Oo2.O00000o();
                    }
                    List<String> O00000o02 = hsi.O00000o0(str5);
                    if (!TextUtils.isEmpty(commonSceneAction2.mName)) {
                        str4 = commonSceneAction2.mName;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(action2.O00000oo);
                        if (O00000o02.contains(sb.toString())) {
                            str4 = action2.O00000Oo;
                        }
                    }
                    hqv hqv22 = this.mRecommendUI;
                    action = this.mScene.O00000oo.get(0);
                    obj = ((SceneApi.O000OO0o) action.O0000O0o).O00000oO;
                    if (!(obj instanceof JSONObject)) {
                    }
                    str3 = "";
                    z = this.mRecommendUI.O00000o0(this.mScene);
                }
                if (!TextUtils.isEmpty(commonSceneAction2.mName)) {
                    str4 = commonSceneAction2.mName;
                } else if (!TextUtils.isEmpty(commonSceneAction2.mParamAction)) {
                    str4 = action2.O00000Oo;
                }
                hqv hqv222 = this.mRecommendUI;
                action = this.mScene.O00000oo.get(0);
                obj = ((SceneApi.O000OO0o) action.O0000O0o).O00000oO;
                if (!(obj instanceof JSONObject)) {
                }
                str3 = "";
                z = this.mRecommendUI.O00000o0(this.mScene);
            }
            str4 = null;
            hqv hqv2222 = this.mRecommendUI;
            action = this.mScene.O00000oo.get(0);
            obj = ((SceneApi.O000OO0o) action.O0000O0o).O00000oO;
            if (!(obj instanceof JSONObject)) {
            }
            str3 = "";
            z = this.mRecommendUI.O00000o0(this.mScene);
        }
        if (TextUtils.isEmpty(str2)) {
            this.O0000o0.setVisibility(8);
        } else {
            this.O0000o0.setVisibility(0);
            this.O00000o0.setText(str2);
            if (z) {
                this.O0000o0O.setVisibility(0);
            } else {
                this.O0000o0O.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.O00000o.setText(str);
            } else {
                this.O00000o.setText("");
            }
        }
        String O00000Oo2 = this.mRecommendUI.O00000Oo(o000OOOo);
        if (TextUtils.isEmpty(O00000Oo2)) {
            hqv hqv3 = this.mRecommendUI;
            if (hqv3 instanceof hqt) {
                this.mScene.O0000O0o.clear();
            } else if (hqv3 instanceof hqw) {
                this.mScene.O00000oo.clear();
            }
            O00000Oo2 = getString(R.string.light_rec_non_condition);
        }
        if (!TextUtils.isEmpty(O00000Oo2)) {
            this.O00000Oo.setText(O00000Oo2);
        } else {
            this.O00000Oo.setText("");
        }
    }

    public boolean isSaveImmediately() {
        SceneApi.O000OOOo o000OOOo = this.mScene;
        if (o000OOOo != null && !TextUtils.isEmpty(o000OOOo.f11131O000000o) && this.mScene.O0000Oo0) {
            return true;
        }
        return false;
    }

    public void updateData(String str) {
        this.isRecommendSceneReady = false;
        this.isSceneReady = false;
        hpt.O000000o();
        hpt.O00000o0();
        hpt.O000000o().O0000O0o = this;
        final AnonymousClass9 r5 = new fsm<SceneApi.O000OOOo, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass9 */

            public final /* synthetic */ void onSuccess(Object obj) {
                hpt.O000000o().O0000OOo = CreateSceneFromRecommendActivity.this.checkDeleted((SceneApi.O000OOOo) obj);
                CreateSceneFromRecommendActivity.this.mScene = hpt.O000000o().O0000OOo;
                CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                createSceneFromRecommendActivity.isSceneReady = true;
                if (createSceneFromRecommendActivity.isRecommendSceneReady && CreateSceneFromRecommendActivity.this.isSceneReady) {
                    CreateSceneFromRecommendActivity.this.configDataSetUI();
                }
            }

            public final void onFailure(fso fso) {
                CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                createSceneFromRecommendActivity.configUIfromScene(createSceneFromRecommendActivity.mScene);
            }
        };
        hps.O000000o().O000000o(this.device.did, this.sr_id, new fsm<List<SceneApi.O000OOOo>, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass11 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (list == null || list.size() <= 0) {
                    r5.onSuccess(null);
                    return;
                }
                fsm fsm = r5;
                if (fsm != null) {
                    fsm.onSuccess(list.get(0));
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = r5;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
        hps.O000000o().O000000o(this.device.did, new fsm<PluginRecommendSceneInfo, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass10 */

            public final /* synthetic */ void onSuccess(Object obj) {
                hqv hqv;
                List<PluginRecommendSceneInfo.ConditionActionItem> list;
                PluginRecommendSceneInfo pluginRecommendSceneInfo = (PluginRecommendSceneInfo) obj;
                if (pluginRecommendSceneInfo != null) {
                    hpt O000000o2 = hpt.O000000o();
                    StringBuilder sb = new StringBuilder();
                    sb.append(CreateSceneFromRecommendActivity.this.sr_id);
                    O000000o2.f492O000000o = pluginRecommendSceneInfo.getItemBy(sb.toString());
                }
                if (hpt.O000000o().f492O000000o != null) {
                    if (TextUtils.equals(hpt.O000000o().f492O000000o.sr_id, "1003")) {
                        CreateSceneFromRecommendActivity.this.isNeedBleInfo = true;
                    }
                    hpt.O000000o().f492O000000o.mCommonActions.clear();
                    hpt.O000000o().f492O000000o.mCommonActions.putAll(pluginRecommendSceneInfo.mCommonActions);
                    hpt.O000000o().f492O000000o.mCommonConditions.clear();
                    hpt.O000000o().f492O000000o.mCommonConditions.putAll(pluginRecommendSceneInfo.mCommonConditions);
                    if (CreateSceneFromRecommendActivity.this.mRecommendUI == null) {
                        CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                        PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem = hpt.O000000o().f492O000000o;
                        if (recommendSceneItem.isConditionDevice || recommendSceneItem.isActionDevice) {
                            if (recommendSceneItem.isConditionDevice) {
                                hqv = new hqw(createSceneFromRecommendActivity, recommendSceneItem);
                            } else if (recommendSceneItem.isActionDevice) {
                                boolean z = false;
                                if (recommendSceneItem != null && (list = recommendSceneItem.mConditionList) != null && list.size() > 0 && TextUtils.equals(list.get(0).mConditionSrc, "cloud")) {
                                    z = true;
                                }
                                if (z) {
                                    hqv = new hqx(createSceneFromRecommendActivity, recommendSceneItem);
                                } else {
                                    hqv = hqv.O000000o(recommendSceneItem) ? new hqu(createSceneFromRecommendActivity, recommendSceneItem) : new hqt(createSceneFromRecommendActivity, recommendSceneItem);
                                }
                            }
                            createSceneFromRecommendActivity.mRecommendUI = hqv;
                        }
                        hqv = null;
                        createSceneFromRecommendActivity.mRecommendUI = hqv;
                    }
                    hpt.O000000o().O000000o(pluginRecommendSceneInfo.mConditionScIds, pluginRecommendSceneInfo.mActionSaIds);
                    hpt.O000000o().O00000Oo();
                    CreateSceneFromRecommendActivity.this.configUIfromRecommend(hpt.O000000o().f492O000000o);
                }
                CreateSceneFromRecommendActivity createSceneFromRecommendActivity2 = CreateSceneFromRecommendActivity.this;
                createSceneFromRecommendActivity2.isRecommendSceneReady = true;
                if (createSceneFromRecommendActivity2.isRecommendSceneReady && CreateSceneFromRecommendActivity.this.isSceneReady) {
                    CreateSceneFromRecommendActivity.this.configDataSetUI();
                }
            }

            public final void onFailure(fso fso) {
                CreateSceneFromRecommendActivity.this.configDataSetUI();
            }
        });
    }

    public SceneApi.O000OOOo checkDeleted(SceneApi.O000OOOo o000OOOo) {
        if (o000OOOo == null) {
            return null;
        }
        boolean z = false;
        if (o000OOOo.O0000O0o != null && o000OOOo.O0000O0o.size() > 0) {
            int size = o000OOOo.O0000O0o.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (o000OOOo.O0000O0o.get(size).O00000o0 != null && fno.O000000o().O000000o(o000OOOo.O0000O0o.get(size).O00000o0.f11122O000000o) == null) {
                        z = true;
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
        }
        if (!z && o000OOOo.O00000oo != null && o000OOOo.O00000oo.size() > 0) {
            int size2 = o000OOOo.O00000oo.size() - 1;
            while (true) {
                if (size2 >= 0) {
                    if (o000OOOo.O00000oo.get(size2).O0000O0o != null && (o000OOOo.O00000oo.get(size2).O0000O0o instanceof SceneApi.O000OO0o) && o000OOOo.O00000oo.get(size2).f11120O000000o == 0 && fno.O000000o().O000000o(o000OOOo.O00000oo.get(size2).O0000O0o.O00000o) == null) {
                        z = true;
                        break;
                    }
                    size2--;
                } else {
                    break;
                }
            }
        }
        if (z) {
            return null;
        }
        return o000OOOo;
    }

    public void configUIfromRecommend(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        if (hpt.O000000o().f492O000000o == null || TextUtils.isEmpty(hpt.O000000o().f492O000000o.intro)) {
            this.O0000Oo0.setText((int) R.string.setting);
        } else {
            this.O0000Oo0.setText(hpt.O000000o().f492O000000o.intro);
        }
        this.f11179O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(200).setPlaceholderImage(getResources().getDrawable(R.drawable.recommend_scene_list_default_icon)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        if (!TextUtils.isEmpty(recommendSceneItem.cardImgUrl)) {
            this.f11179O000000o.setImageURI(Uri.parse(recommendSceneItem.cardImgUrl));
        } else {
            this.f11179O000000o.setImageResource(R.drawable.recommend_scene_list_default_icon);
        }
        String str = null;
        if (hpt.O000000o().f492O000000o.isActionDevice) {
            str = hpt.O000000o().f492O000000o.selectConditionHint;
        } else if (hpt.O000000o().f492O000000o.isConditionDevice) {
            str = hpt.O000000o().f492O000000o.selectActionHint;
        }
        if (!TextUtils.isEmpty(str)) {
            TextView textView = this.O0000Oo;
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            objArr[0] = str;
            textView.setText(getString(R.string.light_rec_condition_name, objArr));
        } else {
            String str2 = hpt.O000000o().f492O000000o.selectDeviceHint;
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.light_rec_condition_name, new Object[]{""});
            }
            this.O0000Oo.setText(str2);
        }
        if (recommendSceneItem.needDelay) {
            this.O0000Ooo.setVisibility(0);
            this.O0000o00.setVisibility(0);
            return;
        }
        this.O0000Ooo.setVisibility(8);
        this.O0000o00.setVisibility(8);
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
        if (hpt.O000000o().f492O000000o == null) {
            if (gfr.O0000OOo) {
                gqg.O00000Oo("edit scene created by rec,but rec does not exist!");
            }
            if (this.mScene != null && !this.O0000oo) {
                this.O0000oo = true;
                Intent intent = new Intent(this, SmarthomeCreateAutoSceneActivity.class);
                intent.putExtra("extra_recommend_edit", false);
                Device device2 = this.device;
                if (device2 != null && !TextUtils.isEmpty(device2.did)) {
                    intent.putExtra("extra_device_id", this.device.did);
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
            this.mScene.O0000O0o = new ArrayList();
            if (hpt.O000000o().f492O000000o != null) {
                this.mRecommendUI.O000000o(this.mScene);
                this.mRecommendUI.O000000o(this.mScene, this.device);
            }
        }
        configUIfromScene(this.mScene);
        this.O00000oO.setOnClickListener(this);
        this.O0000o0.setOnClickListener(this);
        this.O0000Ooo.setOnClickListener(this);
        this.O0000o0o.setOnClickListener(this);
        this.O0000OOo.setOnClickListener(this);
        this.O0000OoO.setOnClickListener(this);
        if (!this.O0000oOO) {
            this.O0000oOO = true;
            if (hpt.O000000o().f492O000000o.isActionDevice) {
                if (this.mScene.O0000O0o == null || this.mScene.O0000O0o.size() == 0) {
                    hxr hxr = hxi.O00000oO;
                    String str = this.device.model;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.sr_id);
                    hxr.O00000oo(str, sb.toString());
                    return;
                }
                hxr hxr2 = hxi.O00000oO;
                String str2 = this.device.model;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.sr_id);
                hxr2.O00000oO(str2, sb2.toString());
            } else if (!hpt.O000000o().f492O000000o.isConditionDevice) {
            } else {
                if (this.mScene.O00000oo == null || this.mScene.O00000oo.size() == 0) {
                    hxr hxr3 = hxi.O00000oO;
                    String str3 = this.device.model;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.sr_id);
                    hxr3.O00000oo(str3, sb3.toString());
                    return;
                }
                hxr hxr4 = hxi.O00000oO;
                String str4 = this.device.model;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.sr_id);
                hxr4.O00000oO(str4, sb4.toString());
            }
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
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            finish();
        } else if (id == R.id.listitem_timespan) {
            hxk hxk = hxi.O00000o;
            String str = this.device.model;
            StringBuilder sb = new StringBuilder();
            sb.append(this.sr_id);
            hxk.O00000Oo(str, sb.toString());
            Intent intent = new Intent(this, SceneCreateTimeEdit2Activity.class);
            intent.putExtra("is_from_recommend", true);
            startActivityForResult(intent, 1011);
        } else if (id == R.id.tv_enable) {
            SceneApi.O000OOOo o000OOOo = this.mScene;
            o000OOOo.O0000Oo0 = !o000OOOo.O0000Oo0;
            if (this.mScene.O0000Oo0 && TextUtils.isEmpty(this.mScene.f11131O000000o)) {
                hxk hxk2 = hxi.O00000o;
                String str2 = this.device.model;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.sr_id);
                hxk2.O00000o0(str2, sb2.toString());
            }
            saveScene();
        } else if (id == R.id.listitem_condition_select) {
            hqv hqv = this.mRecommendUI;
            if (hqv instanceof hqx) {
                SceneApi.O000OOOo o000OOOo2 = this.mScene;
                new Object() {
                    /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass12 */
                };
                hqv.O00000oO(o000OOOo2);
                return;
            }
            Intent intent2 = new Intent(this, ActionConditionDeviceSelectActivity.class);
            intent2.putExtra("home_id", this.home.getId());
            intent2.putExtra("device_model", this.device.model);
            intent2.putExtra("sr_id", this.sr_id);
            if (hpt.O000000o().f492O000000o.isActionDevice) {
                if (!this.mScene.O0000O0o.isEmpty()) {
                    this.O0000oo0 = this.mScene.O0000O0o.get(0);
                }
                intent2.putExtra("need_condition", true);
                startActivityForResult(intent2, 1002);
                return;
            }
            if (!this.mScene.O00000oo.isEmpty()) {
                this.O0000oOo = this.mScene.O00000oo.get(0);
            }
            intent2.putExtra("need_action", true);
            startActivityForResult(intent2, 1003);
        } else if (id == R.id.listitem_condition_detail_select && this.O0000o0O.getVisibility() != 8) {
            SceneApi.O000OOOo o000OOOo3 = this.mScene;
            if (o000OOOo3 != null) {
                if (o000OOOo3.O00000oo != null && this.mScene.O00000oo.size() > 0) {
                    this.O0000oOo = this.mScene.O00000oo.get(0);
                }
                if (this.mScene.O0000O0o != null && this.mScene.O0000O0o.size() > 0) {
                    this.O0000oo0 = this.mScene.O0000O0o.get(0);
                }
            }
            if (this.mRecommendUI.O00000o) {
                if (this.mRecommendUI.O00000o(this.mScene)) {
                    this.mRecommendUI.O000000o(this, this.mScene.O0000O0o.get(0), new hpt.O000000o() {
                        /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass13 */

                        public final void O000000o(int i, Intent intent) {
                            CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                            createSceneFromRecommendActivity.onConditionSelected(i, createSceneFromRecommendActivity.mScene.O0000O0o.get(0), intent);
                        }
                    });
                } else {
                    this.mRecommendUI.O000000o(this, this.mScene.O00000oo.get(0), new hpt.O000000o() {
                        /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass2 */

                        public final void O000000o(int i, Intent intent) {
                            CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                            createSceneFromRecommendActivity.onActionSelected(i, createSceneFromRecommendActivity.mScene.O00000oo.get(0), intent);
                        }
                    });
                }
            }
            if (!this.mRecommendUI.O00000o0) {
                return;
            }
            if (this.mRecommendUI.O00000o0(this.mScene)) {
                this.mRecommendUI.O000000o(this, this.mScene, new hpt.O000000o() {
                    /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass3 */

                    public final void O000000o(int i, Intent intent) {
                        CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                        createSceneFromRecommendActivity.onActionSelected(i, createSceneFromRecommendActivity.mScene.O00000oo.get(0), intent);
                    }
                });
            } else {
                this.mRecommendUI.O000000o(this, this.mScene.O0000O0o.get(0), new hpt.O000000o() {
                    /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass4 */

                    public final void O000000o(int i, Intent intent) {
                        CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                        createSceneFromRecommendActivity.onConditionSelected(i, createSceneFromRecommendActivity.mScene.O0000O0o.get(0), intent);
                    }
                });
            }
        }
    }

    /* JADX WARN: Type inference failed for: r7v20, types: [com.xiaomi.smarthome.scene.api.SceneApi$O00000Oo] */
    /* JADX WARNING: Multi-variable type inference failed */
    public void onConditionSelected(int i, SceneApi.O000000o o000000o, Intent intent) {
        if (i == -1) {
            SceneApi.O000000o o000000o2 = new SceneApi.O000000o();
            SceneApi.O00000o0 o00000o0 = new SceneApi.O00000o0();
            o000000o2.f11121O000000o = LAUNCH_TYPE.DEVICE;
            o000000o2.O0000Ooo = o000000o.O0000Ooo;
            PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition = null;
            if (o000000o.O00000o0 != null && (o000000o.O00000o0 instanceof SceneApi.O00000o0)) {
                o00000o0 = o000000o.O00000o0;
                if (!(hpt.O000000o().f492O000000o == null || hpt.O000000o().f492O000000o.mCommonConditions == null || (commonSceneCondition = hpt.O000000o().f492O000000o.mCommonConditions.get(Integer.valueOf(o00000o0.O0000OoO))) == null)) {
                    o00000o0.O00000Oo = commonSceneCondition.mName;
                    o00000o0.O0000Oo = commonSceneCondition.mKey;
                    o00000o0.O0000Oo = commonSceneCondition.mKey;
                    o00000o0.O0000OoO = commonSceneCondition.id;
                }
            }
            if (intent != null && intent.hasExtra("key_name")) {
                o00000o0.O00000Oo = intent.getStringExtra("key_name");
            }
            o000000o2.O00000o0 = o00000o0;
            if (intent == null || !intent.hasExtra("value")) {
                if (commonSceneCondition != null) {
                    o00000o0.O0000Ooo = commonSceneCondition.mValue;
                }
            } else if (intent.getStringExtra("value") != null) {
                boolean z = false;
                try {
                    o00000o0.O0000Ooo = new JSONObject(intent.getStringExtra("value"));
                    z = true;
                } catch (JSONException unused) {
                }
                if (!z) {
                    try {
                        o00000o0.O0000Ooo = new JSONArray(intent.getStringExtra("value"));
                        z = true;
                    } catch (JSONException unused2) {
                    }
                }
                if (!z) {
                    o00000o0.O0000Ooo = intent.getStringExtra("value");
                }
            } else {
                o00000o0.O0000Ooo = intent.getExtras().get("value");
            }
            o000000o2.O00000o0 = o00000o0;
            if (this.mScene.O0000O0o == null) {
                this.mScene.O0000O0o = new ArrayList();
            }
            if (this.mScene.O0000O0o.size() == 0) {
                this.mScene.O0000O0o.add(o000000o2);
            } else {
                this.mScene.O0000O0o.clear();
                this.mScene.O0000O0o.add(o000000o2);
            }
            if (isSaveImmediately()) {
                saveScene();
            }
            configUIfromScene(this.mScene);
            return;
        }
        if (this.mScene.O0000O0o != null && !this.mScene.O0000O0o.isEmpty()) {
            this.mScene.O0000O0o.clear();
            if (this.O0000oo0 != null) {
                this.mScene.O0000O0o.add(this.O0000oo0);
            }
        }
        configUIfromScene(this.mScene);
    }

    public void onActionSelected(int i, SceneApi.Action action, Intent intent) {
        if (i == -1) {
            if (intent != null && intent.hasExtra("value") && intent.getStringExtra("value") != null) {
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
                if (this.mScene.O00000oo == null) {
                    this.mScene.O00000oo = new ArrayList();
                }
                if (this.mScene.O00000oo.size() == 0) {
                    this.mScene.O00000oo.add(action);
                } else {
                    this.mScene.O00000oo.clear();
                    this.mScene.O00000oo.add(action);
                }
                if (isSaveImmediately()) {
                    saveScene();
                }
                configUIfromScene(this.mScene);
            }
        } else if (i == 0) {
            if (this.mScene.O00000oo != null && !this.mScene.O00000oo.isEmpty()) {
                this.mScene.O00000oo.clear();
                if (this.O0000oOo != null) {
                    this.mScene.O00000oo.add(this.O0000oOo);
                }
            }
            configUIfromScene(this.mScene);
        }
    }

    public Map<String, List<SceneApi.Action>> getSelectionActions(Map<Integer, SceneApi.Action> map) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = hpt.O000000o().f492O000000o.mActionList.get(0).modelListJobj;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                List<Device> O000000o2 = O000000o(next, this.home);
                if (O000000o2.size() != 0) {
                    int optInt = jSONObject.optInt(next);
                    ArrayList arrayList = new ArrayList();
                    if (optInt == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(Integer.valueOf(optJSONArray.optInt(i)));
                        }
                    } else {
                        arrayList.add(Integer.valueOf(optInt));
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        SceneApi.Action action = map.get(arrayList.get(i2));
                        if (action != null) {
                            List<SceneApi.Action> O000000o3 = O000000o(action, O000000o2);
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
        return hashMap;
    }

    public Map<String, List<SceneApi.O000000o>> getSelctionConditions(Map<Integer, SceneApi.O000000o> map) {
        HashMap hashMap = new HashMap();
        List<PluginRecommendSceneInfo.ConditionActionItem> list = hpt.O000000o().f492O000000o.mConditionList;
        if (list != null && list.size() > 0) {
            String str = list.get(0).mConditionSrc;
            if (TextUtils.isEmpty(str)) {
                return hashMap;
            }
            for (int i = 0; i < list.size(); i++) {
                JSONObject jSONObject = list.get(i).modelListJobj;
                if (TextUtils.equals(str, "device")) {
                    if (jSONObject != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            List<Device> O000000o2 = O000000o(next, this.home);
                            if (O000000o2.size() != 0) {
                                int optInt = jSONObject.optInt(next);
                                ArrayList arrayList = new ArrayList();
                                if (optInt == 0) {
                                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i2)));
                                    }
                                } else {
                                    arrayList.add(Integer.valueOf(optInt));
                                }
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    Map<String, JSONObject> map2 = hpt.O000000o().O00000Oo;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(arrayList.get(i3));
                                    JSONObject jSONObject2 = map2.get(sb.toString());
                                    if (jSONObject2 != null) {
                                        List<SceneApi.O000000o> O000000o3 = O000000o(((Integer) arrayList.get(i3)).intValue(), jSONObject2, O000000o2);
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(arrayList.get(i3));
                                        if (hashMap.containsKey(sb2.toString())) {
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append(arrayList.get(i3));
                                            if (hashMap.get(sb3.toString()) != null) {
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append(arrayList.get(i3));
                                                ((List) hashMap.get(sb4.toString())).addAll(O000000o3);
                                            }
                                        }
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(arrayList.get(i3));
                                        hashMap.put(sb5.toString(), O000000o3);
                                    }
                                }
                            }
                        }
                    }
                } else if (TextUtils.equals(str, "cloud")) {
                    String optString = jSONObject.optString("virtual");
                    JSONObject jSONObject3 = hpt.O000000o().O00000Oo.get(String.valueOf(optString));
                    if (jSONObject3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            SceneApi.O000000o O000000o4 = SceneApi.O000000o.O000000o(jSONObject3);
                            if (O000000o4.O0000OoO == null) {
                                O000000o4.O0000OoO = new SceneApi.O0000o00();
                            }
                            O000000o4.O0000OoO.O00000o = Integer.parseInt(optString);
                            O000000o4.O0000OoO.O00000oO = gwq.O000000o().O00000o().O000000o();
                            O000000o4.O0000OoO.O00000oo = gwq.O000000o().O00000o().O00000o();
                            SceneApi.O0000o00 o0000o00 = O000000o4.O0000OoO;
                            o0000o00.O0000O0o = gwq.O000000o().O00000o().O00000o() + O000000o4.O0000OoO.O00000Oo;
                            arrayList2.add(O000000o4);
                            hashMap.put(String.valueOf(optString), arrayList2);
                        } catch (Exception unused) {
                        }
                    }
                } else if (!TextUtils.equals(str, "timer")) {
                    TextUtils.equals(str, "user");
                }
            }
        }
        return hashMap;
    }

    private static List<Device> O000000o(String str, Home home2) {
        ArrayList arrayList = new ArrayList();
        for (Device next : ggb.O00000Oo().O0000Oo(home2.getId())) {
            if (TextUtils.equals(str, next.model)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private List<SceneApi.O000000o> O000000o(int i, JSONObject jSONObject, List<Device> list) {
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
                        if (this.mRecommendUI.O00000oO.get(i, Boolean.FALSE).booleanValue()) {
                            O000000o2 = hqv.O00000o0(O000000o2);
                        }
                    }
                    arrayList.add(O000000o2);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private List<SceneApi.Action> O000000o(SceneApi.Action action, List<Device> list) {
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
                if (this.mRecommendUI.O00000oo.get(action.O00000oo, Boolean.FALSE).booleanValue()) {
                    O000000o3 = hqv.O000000o(O000000o3);
                }
                arrayList.add(O000000o3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void saveScene() {
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
            updateData(this.mScene.f11131O000000o);
            return;
        }
        hpt.O000000o(this.mScene, new hqy() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity.AnonymousClass5 */

            public final void onSaveLocalFail() {
                if (CreateSceneFromRecommendActivity.this.isValid()) {
                    CreateSceneFromRecommendActivity.this.mPD.dismiss();
                }
                if (gfr.f17662O000000o) {
                    gqg.O00000Oo("本地保存失败");
                } else {
                    gqg.O00000Oo((int) R.string.save_fail);
                }
                CreateSceneFromRecommendActivity.this.configDataSetUI();
            }

            public final void onSaveCloudSuccess(boolean z) {
                if (CreateSceneFromRecommendActivity.this.isValid()) {
                    CreateSceneFromRecommendActivity.this.mPD.dismiss();
                }
                CreateSceneFromRecommendActivity createSceneFromRecommendActivity = CreateSceneFromRecommendActivity.this;
                createSceneFromRecommendActivity.updateData(createSceneFromRecommendActivity.mScene.f11131O000000o);
            }

            public final void onSaveCloudFail(int i, String str) {
                if (CreateSceneFromRecommendActivity.this.isValid()) {
                    CreateSceneFromRecommendActivity.this.mPD.dismiss();
                }
                if (i == -9000) {
                    gqg.O00000Oo((int) R.string.smarthome_scene_getway_offline);
                } else if (gfr.f17662O000000o) {
                    StringBuilder sb = new StringBuilder("保存云端失败：");
                    sb.append(i);
                    sb.append(!TextUtils.isEmpty(str) ? ":  ".concat(String.valueOf(str)) : "");
                    gqg.O00000Oo(sb.toString());
                } else {
                    gqg.O00000Oo((int) R.string.save_fail);
                }
                CreateSceneFromRecommendActivity.this.configDataSetUI();
            }
        });
    }
}
