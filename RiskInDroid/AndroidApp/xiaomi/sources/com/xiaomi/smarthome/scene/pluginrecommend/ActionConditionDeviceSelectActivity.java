package com.xiaomi.smarthome.scene.pluginrecommend;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.hjp;
import _m_j.hna;
import _m_j.hps;
import _m_j.hpt;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxr;
import android.content.Context;
import android.content.Intent;
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
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ActionConditionDeviceSelectActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f11168O000000o;
    private View O00000Oo;
    private TextView O00000o;
    private View O00000o0;
    private O0000O0o O00000oO;
    private ImageView O00000oo;
    private boolean O0000O0o;
    private boolean O0000OOo;
    private boolean O0000Oo0;
    public List<SceneApi.Action> actionData = new ArrayList();
    public O000000o buyAdapter;
    public List<SceneApi.O000000o> conditionData = new ArrayList();
    public String deviceModel;
    public Home home;
    public boolean isOnlyCondition;
    public boolean isShowBleBuyGuide;
    public Set<String> offLineBleLockDids = new HashSet();
    public RecyclerView rcBuyList;
    public boolean showAction = false;
    public boolean showCondition = false;
    public int srId;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.rec_scene_condition_action_activity);
        this.showCondition = getIntent().getBooleanExtra("need_condition", false);
        this.showAction = getIntent().getBooleanExtra("need_action", false);
        this.O0000O0o = getIntent().getBooleanExtra("only_buy_guide", false);
        this.O0000OOo = getIntent().getBooleanExtra("is_only_ble", false);
        this.O0000Oo0 = getIntent().getBooleanExtra("is_only_zigbee", false);
        this.srId = getIntent().getIntExtra("sr_id", -1);
        if (hpt.O000000o().f492O000000o != null) {
            String str = hpt.O000000o().f492O000000o.sr_id;
            StringBuilder sb = new StringBuilder();
            sb.append(this.srId);
            if (TextUtils.equals(str, sb.toString())) {
                this.home = ggb.O00000Oo().O00000o(getIntent().getStringExtra("home_id"));
                if (this.home == null) {
                    this.home = ggb.O00000Oo().O0000Oo0();
                }
                this.deviceModel = getIntent().getStringExtra("device_model");
                this.f11168O000000o = (TextView) findViewById(R.id.module_a_3_return_title);
                findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
                O000000o();
                return;
            }
        }
        finish();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
     arg types: [com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity, int, int, int]
     candidates:
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
    private void O000000o() {
        if (this.O0000O0o) {
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
            ((TextView) this.O00000o0.findViewById(R.id.common_white_empty_text)).setText((int) R.string.device_rec_no_gateway);
            this.rcBuyList = (RecyclerView) this.O00000o0.findViewById(R.id.buy_list);
            this.rcBuyList.setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
            this.buyAdapter = new O000000o();
            this.rcBuyList.setAdapter(this.buyAdapter);
            ArrayList arrayList = new ArrayList();
            if (this.O0000OOo) {
                arrayList.add("ble_gateway");
            }
            if (this.O0000Oo0) {
                arrayList.add("zigbee_gateway");
            }
            O000000o(arrayList, new fsm<List<JSONObject>, fso>() {
                /* class com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    ActionConditionDeviceSelectActivity.this.rcBuyList.setVisibility(0);
                    ActionConditionDeviceSelectActivity.this.buyAdapter.O000000o((List) obj);
                    ActionConditionDeviceSelectActivity.this.buyAdapter.notifyDataSetChanged();
                }

                public final void onFailure(fso fso) {
                    ActionConditionDeviceSelectActivity.this.rcBuyList.setVisibility(8);
                }
            });
            return;
        }
        String str = null;
        if (this.showCondition) {
            if (hpt.O000000o().f492O000000o.isActionDevice) {
                str = hpt.O000000o().f492O000000o.selectConditionHint;
            } else if (hpt.O000000o().f492O000000o.isConditionDevice) {
                str = hpt.O000000o().f492O000000o.selectActionHint;
            }
            if (!TextUtils.isEmpty(str)) {
                TextView textView = this.f11168O000000o;
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
                this.f11168O000000o.setText(str2);
            }
            if (hpt.O000000o().O00000oO != null && hpt.O000000o().O00000oO.size() > 0) {
                for (Map.Entry<String, List<SceneApi.O000000o>> value : hpt.O000000o().O00000oO.entrySet()) {
                    this.conditionData.addAll((Collection) value.getValue());
                }
            }
            if (this.conditionData.size() > 0) {
                hxr hxr = hxi.O00000oO;
                String str3 = this.deviceModel;
                StringBuilder sb = new StringBuilder();
                sb.append(this.srId);
                hxr.O00000Oo(str3, sb.toString());
                O00000o0();
                return;
            }
            showBuyGuide();
        } else if (this.showAction) {
            if (hpt.O000000o().f492O000000o.isActionDevice) {
                str = hpt.O000000o().f492O000000o.selectConditionHint;
            } else if (hpt.O000000o().f492O000000o.isConditionDevice) {
                str = hpt.O000000o().f492O000000o.selectActionHint;
            }
            if (!TextUtils.isEmpty(str)) {
                TextView textView2 = this.f11168O000000o;
                Object[] objArr2 = new Object[1];
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                objArr2[0] = str;
                textView2.setText(getString(R.string.light_rec_condition_name, objArr2));
            } else {
                String str4 = hpt.O000000o().f492O000000o.selectDeviceHint;
                if (TextUtils.isEmpty(str4)) {
                    str4 = getString(R.string.light_rec_condition_name, new Object[]{""});
                }
                this.f11168O000000o.setText(str4);
            }
            if (hpt.O000000o().O00000oo != null && hpt.O000000o().O00000oo.size() > 0) {
                for (Map.Entry<String, List<SceneApi.Action>> value2 : hpt.O000000o().O00000oo.entrySet()) {
                    this.actionData.addAll((Collection) value2.getValue());
                }
            }
            if (this.actionData.size() > 0) {
                hxr hxr2 = hxi.O00000oO;
                String str5 = this.deviceModel;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.srId);
                hxr2.O00000Oo(str5, sb2.toString());
                O00000o0();
                return;
            }
            showBuyGuide();
        }
    }

    public void showActionConditionList() {
        String str;
        if (this.O00000Oo == null) {
            this.O00000Oo = ((ViewStub) findViewById(R.id.vs_condition_list)).inflate();
            this.O00000o = (TextView) this.O00000Oo.findViewById(R.id.tv_not_connect_ble);
            if (this.srId == 1000) {
                str = getString(R.string.light_rec_condition_no_ble);
            } else {
                str = getString(R.string.device_rec_condition_no_gateway);
            }
            int indexOf = str.indexOf("#start#");
            int indexOf2 = str.indexOf("#end#") - 7;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) str.replace("#start#", "").replace("#end#", ""));
            AnonymousClass1 r0 = new ClickableSpan() {
                /* class com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    List<Device> O000000o2 = hpt.O000000o(ActionConditionDeviceSelectActivity.this.home.getId());
                    if (O000000o2 == null || O000000o2.size() == 0) {
                        hxr hxr = hxi.O00000oO;
                        String str = ActionConditionDeviceSelectActivity.this.deviceModel;
                        StringBuilder sb = new StringBuilder();
                        sb.append(ActionConditionDeviceSelectActivity.this.srId);
                        hxr.O0000Oo0(str, sb.toString());
                        ActionConditionDeviceSelectActivity actionConditionDeviceSelectActivity = ActionConditionDeviceSelectActivity.this;
                        actionConditionDeviceSelectActivity.isShowBleBuyGuide = true;
                        actionConditionDeviceSelectActivity.showBuyGuide();
                        return;
                    }
                    hxr hxr2 = hxi.O00000oO;
                    String str2 = ActionConditionDeviceSelectActivity.this.deviceModel;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(ActionConditionDeviceSelectActivity.this.srId);
                    hxr2.O0000OOo(str2, sb2.toString());
                    Intent intent = new Intent(ActionConditionDeviceSelectActivity.this, LockDissConnectBleActivity.class);
                    intent.putExtra("home_id", ActionConditionDeviceSelectActivity.this.home.getId());
                    intent.putExtra("sr_id", ActionConditionDeviceSelectActivity.this.srId);
                    ActionConditionDeviceSelectActivity.this.startActivity(intent);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_green_normal));
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
        if (this.offLineBleLockDids.size() > 0) {
            this.O00000o.setVisibility(0);
            hxr hxr = hxi.O00000oO;
            String str2 = this.deviceModel;
            StringBuilder sb = new StringBuilder();
            sb.append(this.srId);
            hxr.O0000O0o(str2, sb.toString());
        } else {
            this.O00000o.setVisibility(8);
        }
        this.O00000oo = (ImageView) this.O00000Oo.findViewById(R.id.mj_loading);
        RecyclerView recyclerView = (RecyclerView) this.O00000Oo.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.O00000oO = new O0000O0o();
        this.O00000oO.O000000o(this.conditionData);
        recyclerView.setAdapter(this.O00000oO);
        View view = this.O00000o0;
        if (view != null) {
            view.setVisibility(8);
        }
        this.O00000oo.setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
     arg types: [com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity, int, int, int]
     candidates:
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
      androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
    public void showBuyGuide() {
        boolean z;
        String str;
        boolean z2;
        if (this.O00000o0 == null) {
            this.O00000o0 = ((ViewStub) findViewById(R.id.vs_buy_guide)).inflate();
        }
        View view = this.O00000Oo;
        if (view != null) {
            view.setVisibility(8);
        }
        this.O00000o0.findViewById(R.id.common_white_empty_view).setVisibility(0);
        ((ImageView) this.O00000o0.findViewById(R.id.empty_icon)).setImageResource(R.drawable.ic_plug_rec_action_empty_1000);
        String string = getString(R.string.light_rec_non_condition_type2, new Object[]{""});
        if (TextUtils.isEmpty(hpt.O000000o().f492O000000o.selectActionHint) && TextUtils.isEmpty(hpt.O000000o().f492O000000o.selectConditionHint)) {
            string = getString(R.string.light_rec_non_condition_type0, new Object[]{getString(R.string.smarthome_scene_create_auto_device)});
        } else if (hpt.O000000o().f492O000000o.isConditionDevice) {
            string = getString(R.string.light_rec_non_condition_type0, new Object[]{hpt.O000000o().f492O000000o.selectActionHint});
        } else if (hpt.O000000o().f492O000000o.isActionDevice) {
            string = getString(R.string.light_rec_non_condition_type0, new Object[]{hpt.O000000o().f492O000000o.selectConditionHint});
        }
        this.rcBuyList = (RecyclerView) this.O00000o0.findViewById(R.id.buy_list);
        this.rcBuyList.setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
        this.buyAdapter = new O000000o();
        this.rcBuyList.setAdapter(this.buyAdapter);
        ArrayList arrayList = new ArrayList();
        if (hpt.O000000o().f492O000000o.isActionDevice && this.conditionData.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.srId);
            arrayList.add(sb.toString());
        } else if (hpt.O000000o().f492O000000o.isConditionDevice && this.actionData.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.srId);
            arrayList.add(sb2.toString());
        }
        if (hpt.O000000o().f492O000000o.isConditionDevice) {
            z = O000000o(hpt.O000000o().f492O000000o.mActionList);
        } else {
            z = hpt.O000000o().f492O000000o.isActionDevice ? O000000o(hpt.O000000o().f492O000000o.mConditionList) : false;
        }
        if (z) {
            Iterator<Device> it = hna.O00000o0().getGatewayDevices(null).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals(ggb.O00000Oo().O0000o0(it.next().did).getId(), this.home.getId())) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                this.isOnlyCondition = false;
                arrayList.add("zigbee_gateway");
                if (TextUtils.isEmpty(hpt.O000000o().f492O000000o.selectActionHint) && TextUtils.isEmpty(hpt.O000000o().f492O000000o.selectConditionHint)) {
                    string = getString(R.string.light_rec_non_condition_type1, new Object[]{getString(R.string.smarthome_scene_create_auto_device)});
                } else if (hpt.O000000o().f492O000000o.isConditionDevice) {
                    string = getString(R.string.light_rec_non_condition_type1, new Object[]{hpt.O000000o().f492O000000o.selectActionHint});
                } else if (hpt.O000000o().f492O000000o.isActionDevice) {
                    string = getString(R.string.light_rec_non_condition_type1, new Object[]{hpt.O000000o().f492O000000o.selectConditionHint});
                }
                hxr hxr = hxi.O00000oO;
                String str2 = this.deviceModel;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.srId);
                hxr.O00000o(str2, sb3.toString());
            } else {
                this.isOnlyCondition = true;
                hxr hxr2 = hxi.O00000oO;
                String str3 = this.deviceModel;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.srId);
                hxr2.O00000o0(str3, sb4.toString());
            }
        } else if (O00000Oo()) {
            if ((!this.showAction || this.actionData.size() <= 0) && (!this.showCondition || this.conditionData.size() <= 0)) {
                List<Device> O000000o2 = hpt.O000000o(this.home.getId());
                if (O000000o2 == null || O000000o2.size() == 0) {
                    this.isOnlyCondition = false;
                    arrayList.add("ble_gateway");
                    if (TextUtils.isEmpty(hpt.O000000o().f492O000000o.selectActionHint) && TextUtils.isEmpty(hpt.O000000o().f492O000000o.selectConditionHint)) {
                        str = getString(R.string.light_rec_non_condition_type2, new Object[]{getString(R.string.smarthome_scene_create_auto_device)});
                    } else if (hpt.O000000o().f492O000000o.isConditionDevice) {
                        str = getString(R.string.light_rec_non_condition_type2, new Object[]{hpt.O000000o().f492O000000o.selectActionHint});
                    } else {
                        if (hpt.O000000o().f492O000000o.isActionDevice) {
                            str = getString(R.string.light_rec_non_condition_type2, new Object[]{hpt.O000000o().f492O000000o.selectConditionHint});
                        }
                        hxr hxr3 = hxi.O00000oO;
                        String str4 = this.deviceModel;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(this.srId);
                        hxr3.O00000o(str4, sb5.toString());
                    }
                    string = str;
                    hxr hxr32 = hxi.O00000oO;
                    String str42 = this.deviceModel;
                    StringBuilder sb52 = new StringBuilder();
                    sb52.append(this.srId);
                    hxr32.O00000o(str42, sb52.toString());
                } else {
                    this.isOnlyCondition = true;
                    hxr hxr4 = hxi.O00000oO;
                    String str5 = this.deviceModel;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(this.srId);
                    hxr4.O00000o0(str5, sb6.toString());
                }
            } else {
                arrayList.clear();
            }
        }
        ((TextView) this.O00000o0.findViewById(R.id.common_white_empty_text)).setText(string);
        O000000o(arrayList, new fsm<List<JSONObject>, fso>() {
            /* class com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                ActionConditionDeviceSelectActivity.this.rcBuyList.setVisibility(0);
                ActionConditionDeviceSelectActivity.this.buyAdapter.O000000o((List) obj);
                ActionConditionDeviceSelectActivity.this.buyAdapter.notifyDataSetChanged();
            }

            public final void onFailure(fso fso) {
                ActionConditionDeviceSelectActivity.this.rcBuyList.setVisibility(8);
            }
        });
    }

    private void O000000o(List<String> list, fsm<List<JSONObject>, fso> fsm) {
        boolean contains = list.contains("zigbee_gateway");
        boolean contains2 = list.contains("ble_gateway");
        hps.O000000o();
        StringBuilder sb = new StringBuilder();
        sb.append(this.srId);
        hps.O000000o(sb.toString(), hpt.O000000o().f492O000000o.isActionDevice ? "Trigger" : "Action", contains2, contains, fsm);
    }

    private static boolean O00000Oo() {
        List<PluginRecommendSceneInfo.ConditionActionItem> list;
        if (hpt.O000000o().f492O000000o.isConditionDevice) {
            list = hpt.O000000o().f492O000000o.mActionList;
        } else {
            list = hpt.O000000o().f492O000000o.isActionDevice ? hpt.O000000o().f492O000000o.mConditionList : null;
        }
        if (list == null || list.isEmpty()) {
            return false;
        }
        int i = 0;
        boolean z = false;
        while (i < list.size() && list.get(i) != null && ((PluginRecommendSceneInfo.ConditionActionItem) list.get(i)).modelListJobj != null) {
            Iterator<String> keys = ((PluginRecommendSceneInfo.ConditionActionItem) list.get(i)).modelListJobj.keys();
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(keys.next());
                if (O00000oO2 == null || O00000oO2.O0000o() != Device.PID_BLUETOOTH) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                break;
            }
            i++;
        }
        if (z) {
            return false;
        }
        return true;
    }

    private static boolean O000000o(List<PluginRecommendSceneInfo.ConditionActionItem> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        int i = 0;
        boolean z = false;
        while (true) {
            if (i < list.size()) {
                if (list.get(i) != null && list.get(i).modelListJobj != null) {
                    Iterator<String> keys = list.get(i).modelListJobj.keys();
                    while (true) {
                        if (!keys.hasNext()) {
                            break;
                        }
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(next);
                            if (O00000oO2 == null || O00000oO2.O0000o() != Device.PID_SUBDEVICE) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        break;
                    }
                    i++;
                } else {
                    z = true;
                }
            } else {
                break;
            }
        }
        z = true;
        if (z) {
            return false;
        }
        return true;
    }

    private void O00000o0() {
        final ArrayList arrayList = new ArrayList();
        int i = 0;
        if (hpt.O000000o().f492O000000o.isActionDevice) {
            while (i < this.conditionData.size()) {
                if (this.conditionData.get(i).O00000o0 != null && hpt.O00000Oo(this.conditionData.get(i).O00000o0.f11122O000000o)) {
                    arrayList.add(this.conditionData.get(i).O00000o0.f11122O000000o);
                }
                i++;
            }
        } else if (hpt.O000000o().f492O000000o.isConditionDevice) {
            while (i < this.actionData.size()) {
                if (this.actionData.get(i).O0000O0o != null && hpt.O00000Oo(this.actionData.get(i).O0000O0o.O00000o)) {
                    arrayList.add(this.actionData.get(i).O0000O0o.O00000o);
                }
                i++;
            }
        }
        if (arrayList.size() > 0) {
            hps.O000000o();
            hps.O000000o(arrayList, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            JSONArray optJSONArray = jSONObject.optJSONArray((String) arrayList.get(i));
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                ActionConditionDeviceSelectActivity.this.offLineBleLockDids.add(arrayList.get(i));
                            }
                        }
                    }
                    ActionConditionDeviceSelectActivity.this.showActionConditionList();
                }

                public final void onFailure(fso fso) {
                    ActionConditionDeviceSelectActivity.this.showActionConditionList();
                }
            });
            return;
        }
        showActionConditionList();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            finish();
        }
    }

    public static class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11175O000000o;

        public O00000o(View view) {
            super(view);
            this.f11175O000000o = (TextView) view.findViewById(R.id.tv_room_name);
        }
    }

    public static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11174O000000o;
        public SimpleDraweeView O00000Oo;

        public O00000Oo(View view) {
            super(view);
            this.f11174O000000o = (TextView) view.findViewById(R.id.model_name);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.sd_model_img);
        }
    }

    public class O0000O0o extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private boolean O00000Oo = false;
        private List<SceneApi.O000000o> O00000o0 = new ArrayList();

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        public O0000O0o() {
        }

        public final void O000000o(List<SceneApi.O000000o> list) {
            if (list == null) {
                this.O00000o0.clear();
                return;
            }
            HashSet hashSet = new HashSet();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).O00000o0 != null && !hashSet.contains(list.get(i).O00000o0.f11122O000000o)) {
                    hashSet.add(list.get(i).O00000o0.f11122O000000o);
                    this.O00000o0.add(list.get(i));
                }
            }
            if (hashSet.size() != list.size()) {
                this.O00000Oo = true;
            }
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                ActionConditionDeviceSelectActivity actionConditionDeviceSelectActivity = ActionConditionDeviceSelectActivity.this;
                return new O00000o0(LayoutInflater.from(actionConditionDeviceSelectActivity).inflate((int) R.layout.light_rec_scene_condition_item_1, (ViewGroup) null));
            } else if (i == 0) {
                return new O00000o(LayoutInflater.from(ActionConditionDeviceSelectActivity.this).inflate((int) R.layout.light_rec_scene_condition_item_0, (ViewGroup) null));
            } else {
                return null;
            }
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            int i2 = i;
            String str = "";
            if (getItemViewType(i2) == 0) {
                ggb.O00000Oo();
                String O000000o2 = ggb.O000000o(ActionConditionDeviceSelectActivity.this.home);
                TextView textView = ((O00000o) o000OOo0).f11175O000000o;
                if (TextUtils.isEmpty(O000000o2)) {
                    O000000o2 = str;
                }
                textView.setText(O000000o2);
            } else if (getItemViewType(i2) == 1) {
                O00000o0 o00000o0 = (O00000o0) o000OOo0;
                if (ActionConditionDeviceSelectActivity.this.showCondition) {
                    int i3 = i2 - 1;
                    if (this.O00000o0.get(i3).O00000o0 != null) {
                        SceneApi.O00000Oo o00000Oo = this.O00000o0.get(i3).O00000o0;
                        Device O000000o3 = fno.O000000o().O000000o(o00000Oo.f11122O000000o);
                        if (O000000o3 == null) {
                            O000000o3 = DeviceFactory.O0000o0O(o00000Oo.O00000o);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(TextUtils.isEmpty(o00000Oo.O00000o0) ? str : o00000Oo.O00000o0);
                        if (hpt.O00000Oo(o00000Oo.f11122O000000o)) {
                            if (ActionConditionDeviceSelectActivity.this.offLineBleLockDids.contains(o00000Oo.f11122O000000o)) {
                                sb.append("(");
                                sb.append(ActionConditionDeviceSelectActivity.this.getString(R.string.cant_connect_ble));
                                sb.append(")");
                            }
                        } else if (!O000000o3.isOnline) {
                            sb.append("(");
                            sb.append(ActionConditionDeviceSelectActivity.this.getString(R.string.offline_device));
                            sb.append(")");
                        }
                        o00000o0.f11176O000000o.setText(sb.toString());
                        String O0000o0O = ggb.O00000Oo().O0000o0O(o00000Oo.f11122O000000o);
                        TextView textView2 = o00000o0.O00000oO;
                        if (!TextUtils.isEmpty(O0000o0O)) {
                            str = O0000o0O;
                        }
                        textView2.setText(str);
                        if (O000000o3 != null) {
                            DeviceFactory.O00000Oo(O000000o3.model, o00000o0.O00000oo);
                        } else {
                            DeviceFactory.O00000Oo((String) null, o00000o0.O00000oo);
                        }
                        if (hpt.O000000o().O0000OOo.O0000O0o != null && hpt.O000000o().O0000OOo.O0000O0o.size() > 0) {
                            SceneApi.O000000o o000000o = hpt.O000000o().O0000OOo.O0000O0o.get(0);
                            SceneApi.O000000o o000000o2 = this.O00000o0.get(i3);
                            if ((o000000o == null || o000000o2 == null || o000000o.f11121O000000o != o000000o2.f11121O000000o || o000000o.O00000o0 == null || o000000o2.O00000o0 == null || !TextUtils.equals(o000000o.O00000o0.f11122O000000o, o000000o2.O00000o0.f11122O000000o)) ? false : true) {
                                o00000o0.O00000o.setVisibility(0);
                                o00000o0.O00000oO.setTextColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                                o00000o0.O00000oO.setAlpha(0.6f);
                                o00000o0.f11176O000000o.setTextColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                                o00000o0.itemView.setOnClickListener(new View.OnClickListener(i2) {
                                    /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$52lHOq_F1JuBZIth5bkY8lQX9Y */
                                    private final /* synthetic */ int f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final void onClick(View view) {
                                        ActionConditionDeviceSelectActivity.O0000O0o.this.O00000Oo(this.f$1, view);
                                    }
                                });
                                return;
                            }
                        }
                        o00000o0.O00000o.setVisibility(8);
                        o00000o0.O00000oO.setTextColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                        o00000o0.O00000oO.setAlpha(1.0f);
                        o00000o0.f11176O000000o.setTextColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_black));
                        o00000o0.itemView.setOnClickListener(new View.OnClickListener(i2) {
                            /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$52lHOq_F1JuBZIth5bkY8lQX9Y */
                            private final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                ActionConditionDeviceSelectActivity.O0000O0o.this.O00000Oo(this.f$1, view);
                            }
                        });
                        return;
                    }
                }
                if (ActionConditionDeviceSelectActivity.this.showAction) {
                    int i4 = i2 - 1;
                    if (ActionConditionDeviceSelectActivity.this.actionData.get(i4) != null) {
                        SceneApi.Action action = ActionConditionDeviceSelectActivity.this.actionData.get(i4);
                        if (action.O0000O0o != null) {
                            Device O000000o4 = fno.O000000o().O000000o(action.O0000O0o.O00000o);
                            if (O000000o4 == null) {
                                O000000o4 = DeviceFactory.O0000o0O(action.O00000oO);
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(TextUtils.isEmpty(O000000o4.name) ? str : O000000o4.name);
                            if (hpt.O00000Oo(O000000o4.did)) {
                                if (ActionConditionDeviceSelectActivity.this.offLineBleLockDids.contains(O000000o4.did)) {
                                    sb2.append("(");
                                    sb2.append(ActionConditionDeviceSelectActivity.this.getString(R.string.cant_connect_ble));
                                    sb2.append(")");
                                }
                            } else if (!O000000o4.isOnline) {
                                sb2.append("(");
                                sb2.append(ActionConditionDeviceSelectActivity.this.getString(R.string.offline_device));
                                sb2.append(")");
                            }
                            o00000o0.f11176O000000o.setText(sb2.toString());
                            String O0000o0O2 = ggb.O00000Oo().O0000o0O(O000000o4.did);
                            TextView textView3 = o00000o0.O00000oO;
                            if (!TextUtils.isEmpty(O0000o0O2)) {
                                str = O0000o0O2;
                            }
                            textView3.setText(str);
                            if (O000000o4 != null) {
                                DeviceFactory.O00000Oo(O000000o4.model, o00000o0.O00000oo);
                            } else {
                                DeviceFactory.O00000Oo((String) null, o00000o0.O00000oo);
                            }
                        }
                        if (hpt.O000000o().O0000OOo.O00000oo != null && hpt.O000000o().O0000OOo.O00000oo.size() > 0) {
                            SceneApi.Action action2 = hpt.O000000o().O0000OOo.O00000oo.get(0);
                            SceneApi.Action action3 = ActionConditionDeviceSelectActivity.this.actionData.get(i4);
                            if ((action2 == null || action3 == null || action2.f11120O000000o != action3.f11120O000000o || action2.O0000O0o == null || action3.O0000O0o == null || !TextUtils.equals(action2.O0000O0o.O00000o, action3.O0000O0o.O00000o)) ? false : true) {
                                o00000o0.O00000o.setVisibility(0);
                                o00000o0.O00000oO.setTextColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                                o00000o0.O00000oO.setAlpha(0.6f);
                                o00000o0.f11176O000000o.setTextColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                                o00000o0.itemView.setOnClickListener(new View.OnClickListener(i2) {
                                    /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$6R5Gr1nuGQP9iRcFe_NIV2i2Qec */
                                    private final /* synthetic */ int f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final void onClick(View view) {
                                        ActionConditionDeviceSelectActivity.O0000O0o.this.O000000o(this.f$1, view);
                                    }
                                });
                                return;
                            }
                        }
                        o00000o0.O00000o.setVisibility(8);
                        o00000o0.O00000oO.setTextColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                        o00000o0.O00000oO.setAlpha(1.0f);
                        o00000o0.f11176O000000o.setTextColor(ActionConditionDeviceSelectActivity.this.getResources().getColor(R.color.mj_color_black));
                        o00000o0.itemView.setOnClickListener(new View.OnClickListener(i2) {
                            /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$6R5Gr1nuGQP9iRcFe_NIV2i2Qec */
                            private final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                ActionConditionDeviceSelectActivity.O0000O0o.this.O000000o(this.f$1, view);
                            }
                        });
                        return;
                    }
                }
                DeviceFactory.O00000Oo((String) null, o00000o0.O00000oo);
                o00000o0.f11176O000000o.setText(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(int i, View view) {
            hpt.O000000o().O0000OOo.O0000O0o.clear();
            hpt.O000000o().O0000OOo.O0000O0o.add(this.O00000o0.get(i - 1));
            notifyDataSetChanged();
            ActionConditionDeviceSelectActivity.this.setResult(-1);
            ActionConditionDeviceSelectActivity.this.finish();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(final int i, View view) {
            int i2 = i - 1;
            SceneApi.Action action = ActionConditionDeviceSelectActivity.this.actionData.get(i2);
            PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(action.O00000oO);
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(action.O00000oO);
            if (O00000oO == null || DeviceConstant.isNativePlugin(action.O00000oO) || O0000Oo != null) {
                if (!hpt.O000000o().O0000OOo.O00000oo.isEmpty() && hpt.O000000o().O0000OOo.O00000oo.get(0).O00000oo == ActionConditionDeviceSelectActivity.this.actionData.get(i2).O00000oo && ActionConditionDeviceSelectActivity.this.actionData.get(i2).O0000O0o != null && hpt.O000000o().O0000OOo.O00000oo.get(0).O0000O0o != null) {
                    ActionConditionDeviceSelectActivity.this.actionData.get(i2).O0000O0o.O00000oO = hpt.O000000o().O0000OOo.O00000oo.get(0).O0000O0o.O00000oO;
                }
                hpt.O000000o().O0000OOo.O00000oo.clear();
                hpt.O000000o().O0000OOo.O00000oo.add(ActionConditionDeviceSelectActivity.this.actionData.get(i2));
                notifyDataSetChanged();
                ActionConditionDeviceSelectActivity.this.setResult(-1);
                ActionConditionDeviceSelectActivity.this.finish();
                return;
            }
            final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(ActionConditionDeviceSelectActivity.this, ActionConditionDeviceSelectActivity.this.getString(R.string.plugin_downloading) + O00000oO.O0000Oo0() + ActionConditionDeviceSelectActivity.this.getString(R.string.plugin));
            final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
            String str = action.O00000oO;
            if (TextUtils.equals("mxiang.camera.mwc11", action.O00000oO)) {
                str = "mxiang.camera.mwc10";
            }
            PluginApi.getInstance().installPlugin(ServiceApplication.getAppContext(), str, new SendMessageCallback() {
                /* class com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.O0000O0o.AnonymousClass1 */
                final /* synthetic */ boolean O00000o0 = true;

                public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    pluginDownloadTask.O000000o(pluginDownloadTask);
                    if (O000000o2 != null && ActionConditionDeviceSelectActivity.this.isValid()) {
                        O000000o2.O000000o(100, 0);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        xQProgressHorizontalDialog.f9117O000000o = false;
                        xQProgressHorizontalDialog.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: INVOKE  
                              (wrap: com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog : 0x0029: IGET  (r4v8 com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog) = (r2v0 'this' com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity$O0000O0o$1 A[THIS]) com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.O0000O0o.1.O00000Oo com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog)
                              (wrap: com.xiaomi.smarthome.scene.pluginrecommend.-$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$1$6YPwS9O-rmYnZ5RQ5UlB_z5vGt4 : 0x002f: CONSTRUCTOR  (r1v1 com.xiaomi.smarthome.scene.pluginrecommend.-$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$1$6YPwS9O-rmYnZ5RQ5UlB_z5vGt4) = 
                              (r3v0 'str' java.lang.String)
                              (wrap: com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask : 0x002b: IGET  (r0v3 com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask) = (r2v0 'this' com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity$O0000O0o$1 A[THIS]) com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.O0000O0o.1.O000000o com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask)
                             call: com.xiaomi.smarthome.scene.pluginrecommend.-$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$1$6YPwS9O-rmYnZ5RQ5UlB_z5vGt4.<init>(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void type: CONSTRUCTOR)
                             type: VIRTUAL call: com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog.setOnCancelListener(android.content.DialogInterface$OnCancelListener):void in method: com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.O0000O0o.1.onDownloadStart(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002f: CONSTRUCTOR  (r1v1 com.xiaomi.smarthome.scene.pluginrecommend.-$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$1$6YPwS9O-rmYnZ5RQ5UlB_z5vGt4) = 
                              (r3v0 'str' java.lang.String)
                              (wrap: com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask : 0x002b: IGET  (r0v3 com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask) = (r2v0 'this' com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity$O0000O0o$1 A[THIS]) com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.O0000O0o.1.O000000o com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask)
                             call: com.xiaomi.smarthome.scene.pluginrecommend.-$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$1$6YPwS9O-rmYnZ5RQ5UlB_z5vGt4.<init>(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.O0000O0o.1.onDownloadStart(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 90 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.scene.pluginrecommend.-$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$1$6YPwS9O-rmYnZ5RQ5UlB_z5vGt4, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 96 more
                            */
                        /*
                            this = this;
                            com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask r0 = r1
                            r4.O000000o(r0)
                            com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog r4 = r0
                            if (r4 == 0) goto L_0x0035
                            com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity$O0000O0o r4 = com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.O0000O0o.this
                            com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity r4 = com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.this
                            boolean r4 = r4.isValid()
                            if (r4 != 0) goto L_0x0014
                            return
                        L_0x0014:
                            com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog r4 = r0
                            r0 = 100
                            r1 = 0
                            r4.O000000o(r0, r1)
                            com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog r4 = r0
                            r4.f9117O000000o = r1
                            r0 = 1
                            r4.setCancelable(r0)
                            com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog r4 = r0
                            r4.show()
                            com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog r4 = r0
                            com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask r0 = r1
                            com.xiaomi.smarthome.scene.pluginrecommend.-$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$1$6YPwS9O-rmYnZ5RQ5UlB_z5vGt4 r1 = new com.xiaomi.smarthome.scene.pluginrecommend.-$$Lambda$ActionConditionDeviceSelectActivity$O0000O0o$1$6YPwS9O-rmYnZ5RQ5UlB_z5vGt4
                            r1.<init>(r3, r0)
                            r4.setOnCancelListener(r1)
                        L_0x0035:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDeviceSelectActivity.O0000O0o.AnonymousClass1.onDownloadStart(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void");
                    }

                    public final void onDownloadProgress(String str, float f) {
                        if (ActionConditionDeviceSelectActivity.this.isValid()) {
                            if (this.O00000o0) {
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
                    }

                    public final void onDownloadSuccess(String str) {
                        XQProgressHorizontalDialog xQProgressHorizontalDialog;
                        if (ActionConditionDeviceSelectActivity.this.isValid() && !this.O00000o0 && (xQProgressHorizontalDialog = O000000o2) != null) {
                            xQProgressHorizontalDialog.dismiss();
                        }
                    }

                    public final void onDownloadFailure(PluginError pluginError) {
                        XQProgressHorizontalDialog xQProgressHorizontalDialog;
                        if (!ActionConditionDeviceSelectActivity.this.isValid()) {
                            if (!this.O00000o0 && (xQProgressHorizontalDialog = O000000o2) != null) {
                                xQProgressHorizontalDialog.dismiss();
                            }
                            gqg.O00000Oo(pluginError.O000000o(ActionConditionDeviceSelectActivity.this.getContext()));
                        }
                    }

                    public final void onDownloadCancel() {
                        XQProgressHorizontalDialog xQProgressHorizontalDialog;
                        if (ActionConditionDeviceSelectActivity.this.isValid() && !this.O00000o0 && (xQProgressHorizontalDialog = O000000o2) != null) {
                            xQProgressHorizontalDialog.dismiss();
                        }
                    }

                    public final void onInstallSuccess(String str) {
                        if (ActionConditionDeviceSelectActivity.this.isValid()) {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                            if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                                O000000o2.dismiss();
                            }
                            if (!hpt.O000000o().O0000OOo.O00000oo.isEmpty() && hpt.O000000o().O0000OOo.O00000oo.get(0).O00000oo == ActionConditionDeviceSelectActivity.this.actionData.get(i - 1).O00000oo && ActionConditionDeviceSelectActivity.this.actionData.get(i - 1).O0000O0o != null && hpt.O000000o().O0000OOo.O00000oo.get(0).O0000O0o != null) {
                                ActionConditionDeviceSelectActivity.this.actionData.get(i - 1).O0000O0o.O00000oO = hpt.O000000o().O0000OOo.O00000oo.get(0).O0000O0o.O00000oO;
                            }
                            hpt.O000000o().O0000OOo.O00000oo.clear();
                            hpt.O000000o().O0000OOo.O00000oo.add(ActionConditionDeviceSelectActivity.this.actionData.get(i - 1));
                            O0000O0o.this.notifyDataSetChanged();
                            ActionConditionDeviceSelectActivity.this.setResult(-1);
                            ActionConditionDeviceSelectActivity.this.finish();
                        }
                    }

                    public final void onInstallFailure(PluginError pluginError) {
                        if (ActionConditionDeviceSelectActivity.this.isValid()) {
                            XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                            if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                                O000000o2.dismiss();
                            }
                            gqg.O00000Oo((int) R.string.device_enter_failed);
                        }
                    }
                });
            }

            public final int getItemCount() {
                int size;
                if (ActionConditionDeviceSelectActivity.this.showAction) {
                    if (ActionConditionDeviceSelectActivity.this.actionData == null) {
                        return 1;
                    }
                    size = ActionConditionDeviceSelectActivity.this.actionData.size();
                } else if (!ActionConditionDeviceSelectActivity.this.showCondition) {
                    return 0;
                } else {
                    List<SceneApi.O000000o> list = this.O00000o0;
                    if (list == null) {
                        return 1;
                    }
                    size = list.size();
                }
                return size + 1;
            }
        }

        public class O00000o0 extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public TextView f11176O000000o;
            public View O00000Oo;
            public View O00000o;
            public View O00000o0;
            public TextView O00000oO;
            public SimpleDraweeView O00000oo;

            public O00000o0(View view) {
                super(view);
                this.f11176O000000o = (TextView) view.findViewById(R.id.device_name);
                this.O00000Oo = view.findViewById(R.id.divider_x);
                this.O00000o0 = view.findViewById(R.id.divider_last);
                this.O00000o = view.findViewById(R.id.icon_selected);
                this.O00000oO = (TextView) view.findViewById(R.id.room_name);
                this.O00000oo = (SimpleDraweeView) view.findViewById(R.id.sd_device_img);
            }
        }

        public class O000000o extends RecyclerView.O000000o<O00000Oo> {
            private List<JSONObject> O00000Oo = new ArrayList();

            public final long getItemId(int i) {
                return (long) i;
            }

            public O000000o() {
            }

            public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                O00000Oo o00000Oo = (O00000Oo) o000OOo0;
                JSONObject jSONObject = this.O00000Oo.get(i);
                String trim = jSONObject.keys().next().trim();
                if (!TextUtils.isEmpty(trim)) {
                    DeviceFactory.O00000Oo(trim, o00000Oo.O00000Oo);
                    PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(trim);
                    if (O00000oO == null || TextUtils.isEmpty(O00000oO.O0000Oo0())) {
                        o00000Oo.f11174O000000o.setText("");
                    } else {
                        o00000Oo.f11174O000000o.setText(O00000oO.O0000Oo0());
                    }
                    o00000Oo.itemView.setOnClickListener(new View.OnClickListener(trim, jSONObject) {
                        /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$ActionConditionDeviceSelectActivity$O000000o$Xy_KmEn6aO0nepxUsZnuU_rfshM */
                        private final /* synthetic */ String f$1;
                        private final /* synthetic */ JSONObject f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            ActionConditionDeviceSelectActivity.O000000o.this.O000000o(this.f$1, this.f$2, view);
                        }
                    });
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(String str, JSONObject jSONObject, View view) {
                if (ActionConditionDeviceSelectActivity.this.showAction) {
                    if (ActionConditionDeviceSelectActivity.this.conditionData == null || ActionConditionDeviceSelectActivity.this.conditionData.size() == 0) {
                        if (ActionConditionDeviceSelectActivity.this.isOnlyCondition) {
                            hxk hxk = hxi.O00000o;
                            String str2 = ActionConditionDeviceSelectActivity.this.deviceModel;
                            StringBuilder sb = new StringBuilder();
                            sb.append(ActionConditionDeviceSelectActivity.this.srId);
                            hxk.O000000o(str2, sb.toString(), str);
                        } else {
                            hxk hxk2 = hxi.O00000o;
                            String str3 = ActionConditionDeviceSelectActivity.this.deviceModel;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(ActionConditionDeviceSelectActivity.this.srId);
                            hxk2.O00000Oo(str3, sb2.toString(), str);
                        }
                    }
                } else if (ActionConditionDeviceSelectActivity.this.showCondition && (ActionConditionDeviceSelectActivity.this.actionData == null || ActionConditionDeviceSelectActivity.this.actionData.size() == 0)) {
                    if (ActionConditionDeviceSelectActivity.this.isOnlyCondition) {
                        hxk hxk3 = hxi.O00000o;
                        String str4 = ActionConditionDeviceSelectActivity.this.deviceModel;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(ActionConditionDeviceSelectActivity.this.srId);
                        hxk3.O000000o(str4, sb3.toString(), str);
                    } else {
                        hxk hxk4 = hxi.O00000o;
                        String str5 = ActionConditionDeviceSelectActivity.this.deviceModel;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(ActionConditionDeviceSelectActivity.this.srId);
                        hxk4.O00000Oo(str5, sb4.toString(), str);
                    }
                }
                if (ActionConditionDeviceSelectActivity.this.isShowBleBuyGuide) {
                    hxk hxk5 = hxi.O00000o;
                    String str6 = ActionConditionDeviceSelectActivity.this.deviceModel;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(ActionConditionDeviceSelectActivity.this.srId);
                    hxk5.O00000o0(str6, sb5.toString(), str);
                }
                hjp.O000000o(jSONObject.optString(str));
            }

            public final int getItemCount() {
                List<JSONObject> list = this.O00000Oo;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }

            public final void O000000o(List<JSONObject> list) {
                Iterator<String> keys;
                this.O00000Oo.clear();
                for (int i = 0; i < list.size(); i++) {
                    if (!(list.get(i) == null || (keys = list.get(i).keys()) == null || CoreApi.O000000o().O00000oO(keys.next().trim()) == null)) {
                        this.O00000Oo.add(list.get(i));
                    }
                }
            }

            public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new O00000Oo(LayoutInflater.from(ActionConditionDeviceSelectActivity.this).inflate((int) R.layout.light_rec_scene_buy_item, (ViewGroup) null));
            }
        }
    }
