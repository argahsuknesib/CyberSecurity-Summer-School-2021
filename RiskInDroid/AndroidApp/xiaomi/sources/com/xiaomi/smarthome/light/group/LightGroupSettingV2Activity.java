package com.xiaomi.smarthome.light.group;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gtf;
import _m_j.hfa;
import _m_j.htv;
import _m_j.htw;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class LightGroupSettingV2Activity extends BaseActivity {
    private static final String O0000o0O = "LightGroupSettingV2Activity";

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f9374O000000o;
    SimpleDraweeView O00000Oo;
    ImageView O00000o;
    RecyclerView O00000o0;
    TextView O00000oO;
    ImageView O00000oo;
    TextView O0000O0o;
    TextView O0000OOo;
    TextView O0000Oo;
    TextView O0000Oo0;
    TextView O0000OoO;
    TextView O0000Ooo;
    private Home O0000o;
    fno.O000000o O0000o0 = new fno.O000000o() {
        /* class com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity.AnonymousClass3 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            Device O000000o2 = fno.O000000o().O000000o(LightGroupSettingV2Activity.this.group_did);
            if (i == 3 && O000000o2 != null) {
                fno.O000000o().O00000Oo(LightGroupSettingV2Activity.this.O0000o0);
                if (!LightGroupSettingV2Activity.this.mEditMode) {
                    htw O000000o3 = htv.O000000o();
                    if (O000000o3 != null) {
                        O000000o3.setCurrentScrollToDid(LightGroupSettingV2Activity.this.group_did);
                    }
                    fno.O000000o().O0000OoO();
                    if (LightGroupSettingV2Activity.this.alterDevice) {
                        LightGroupSettingV2Activity lightGroupSettingV2Activity = LightGroupSettingV2Activity.this;
                        LightGroupInitActivity.open(lightGroupSettingV2Activity, lightGroupSettingV2Activity.group_did, 100);
                    } else {
                        LightGroupSettingV2Activity lightGroupSettingV2Activity2 = LightGroupSettingV2Activity.this;
                        LightGroupTestActivity.open(lightGroupSettingV2Activity2, lightGroupSettingV2Activity2.group_did, 200);
                    }
                } else if (!LightGroupSettingV2Activity.this.modified) {
                    LightGroupSettingV2Activity.this.setResult(-1);
                    LightGroupSettingV2Activity.this.finish();
                } else {
                    fbt fbt = new fbt(LightGroupSettingV2Activity.this, "SmartHomeMainActivity");
                    fbt.O00000Oo(335544320);
                    fbs.O000000o(fbt);
                }
                LightGroupSettingV2Activity.this.hideProgressDialog();
            }
        }
    };
    TextView O0000o00;
    private List<String> O0000o0o;
    private Set<String> O0000oO = new HashSet();
    private ArrayList<O00000Oo> O0000oO0 = new ArrayList<>();
    private XQProgressDialog O0000oOO;
    private O000000o O0000oOo;
    private long O0000oo0;
    public View[] TAG_FUNC_VIEW;
    public boolean alterDevice;
    public Device firstDev;
    public String group_did;
    public ArrayList<O00000Oo> mDatas = new ArrayList<>();
    public boolean mEditMode = true;
    public Map<String, O00000Oo> mInitialCheckedMap = new HashMap();
    public boolean modified = false;

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public Device f9381O000000o;
        public String O00000Oo;
        public boolean O00000o;
        public String O00000o0;
        public int O00000oO = 0;

        public O00000Oo(Device device, String str, String str2, boolean z) {
            this.f9381O000000o = device;
            this.O00000Oo = str;
            this.O00000o0 = str2;
            this.O00000o = z;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_light_group_setting_v2);
        this.O0000oo0 = System.currentTimeMillis();
        this.mEditMode = getIntent().getBooleanExtra("args_key_edit_mode", false);
        this.O0000o0o = getIntent().getStringArrayListExtra("args_key_did_list");
        if (this.O0000o0o == null) {
            this.O0000o0o = new ArrayList();
        }
        if (this.O0000o0o.size() > 0) {
            this.firstDev = fno.O000000o().O000000o(this.O0000o0o.get(0));
            this.O0000o = ggb.O00000Oo().O0000o0(this.O0000o0o.get(0));
        }
        if (this.O0000o == null) {
            this.O0000o = ggb.O00000Oo().O0000Oo0();
        }
        if (this.O0000o == null) {
            gqg.O00000Oo("home == null");
            finish();
            return;
        }
        if (this.mEditMode) {
            if (this.firstDev != null) {
                hxi.O00000o0.f957O000000o.O000000o("lightgroup_edit_show", "model", this.firstDev.model);
            }
            O000000o();
        } else {
            hxi.O00000o0.f957O000000o.O000000o("addlightgroup_creat_show", "from", this.O0000o0o.size() > 2 ? "multiple devices" : "single device", "device_number", Integer.valueOf(this.O0000o0o.size()));
            O00000Oo();
        }
        O00000o();
        this.f9374O000000o = (TextView) findViewById(R.id.create_button);
        this.O00000Oo = (SimpleDraweeView) findViewById(R.id.bg_light);
        this.O00000o0 = (RecyclerView) findViewById(R.id.recyclerview);
        this.O00000o = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.O00000oO = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000oo = (ImageView) findViewById(R.id.module_a_3_right_img_btn);
        this.O0000O0o = (TextView) findViewById(R.id.title_left);
        this.O0000OOo = (TextView) findViewById(R.id.icon_on);
        this.O0000Oo0 = (TextView) findViewById(R.id.icon_bright);
        this.O0000Oo = (TextView) findViewById(R.id.icon_color_temperature);
        this.O0000OoO = (TextView) findViewById(R.id.icon_color);
        this.O0000Ooo = (TextView) findViewById(R.id.tv_light_group_top_1);
        this.O0000o00 = (TextView) findViewById(R.id.tv_light_group_top_2);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingV2Activity$I_IrXJ2nqFnbAYubTT2LKa4YCyU */

            public final void onClick(View view) {
                LightGroupSettingV2Activity.this.O00000Oo(view);
            }
        });
        TextView textView = this.O00000oO;
        boolean z = this.mEditMode;
        int i = R.string.device_light_group_create;
        textView.setText(z ? R.string.light_group_edit : R.string.device_light_group_create);
        this.O00000oo.setVisibility(8);
        this.f9374O000000o.setEnabled(!this.mEditMode && this.mInitialCheckedMap.size() >= 2);
        TextView textView2 = this.f9374O000000o;
        if (this.mEditMode) {
            i = R.string.save;
        }
        textView2.setText(i);
        this.f9374O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingV2Activity$0Dtca7WS7U_C9VwkbybmTk70 */

            public final void onClick(View view) {
                LightGroupSettingV2Activity.this.O000000o(view);
            }
        });
        this.O0000oOo = new O000000o(this, this.mDatas);
        this.O00000o0.setLayoutManager(new LinearLayoutManager(this));
        this.O00000o0.setAdapter(this.O0000oOo);
        this.O0000O0o.setText((int) R.string.light_group_current_function);
        this.TAG_FUNC_VIEW = new View[]{this.O0000OOo, this.O0000Oo0, this.O0000Oo, this.O0000OoO};
        if (this.mEditMode) {
            this.O0000Ooo.setVisibility(8);
            this.O0000o00.setVisibility(8);
            this.O00000Oo.setVisibility(8);
        }
        gtf.O000000o();
        gtf.O000000o(this.O0000oO, new fsm<SparseArray<List<String>>, fso>() {
            /* class com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                SparseArray sparseArray = (SparseArray) obj;
                LightGroupSettingV2Activity.this.hideProgressDialog();
                for (int i = 0; i < LightGroupSettingV2Activity.this.mDatas.size(); i++) {
                    O00000Oo o00000Oo = LightGroupSettingV2Activity.this.mDatas.get(i);
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        if (((List) sparseArray.get(i2)).contains(o00000Oo.f9381O000000o.model)) {
                            o00000Oo.O00000oO |= 1 << i2;
                        }
                    }
                }
                int i3 = 15;
                for (O00000Oo o00000Oo2 : LightGroupSettingV2Activity.this.mInitialCheckedMap.values()) {
                    i3 &= o00000Oo2.O00000oO;
                }
                LightGroupSettingV2Activity.this.updateLightGroupFuncView(i3);
            }

            public final void onFailure(fso fso) {
                LightGroupSettingV2Activity.this.hideProgressDialog();
                gqg.O00000Oo("queryModelFunction: " + fso.toString());
            }
        });
    }

    public void updateLightGroupFuncView(int i) {
        int i2 = 0;
        while (true) {
            View[] viewArr = this.TAG_FUNC_VIEW;
            if (i2 < viewArr.length) {
                View view = viewArr[i2];
                if (view != null) {
                    boolean z = true;
                    if (((1 << i2) & i) == 0) {
                        z = false;
                    }
                    view.setEnabled(z);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void O000000o() {
        if (this.firstDev == null) {
            finish();
            return;
        }
        for (Device next : fno.O000000o().O0000O0o(this.firstDev.did)) {
            O00000Oo o00000Oo = new O00000Oo(next, "", ggb.O00000Oo().O0000o0O(this.firstDev.did), true);
            if (next.isOnlineAdvance()) {
                this.mDatas.add(o00000Oo);
                if (this.mInitialCheckedMap.size() <= 50) {
                    this.mInitialCheckedMap.put(next.did, o00000Oo);
                }
            } else {
                this.O0000oO0.add(o00000Oo);
            }
            this.O0000oO.add(next.model);
        }
        if (!this.O0000oO0.isEmpty()) {
            this.mDatas.addAll(this.O0000oO0);
        }
    }

    private void O00000Oo() {
        List<String> list = this.O0000o0o;
        int i = 0;
        if (list == null || list.size() <= 1) {
            for (String O000000o2 : ggb.O00000Oo().O000000o(this.O0000o.getId(), new boolean[0])) {
                Device O000000o3 = fno.O000000o().O000000o(O000000o2);
                if (!O000000o(O000000o3)) {
                    O00000Oo o00000Oo = new O00000Oo(O000000o3, getString(R.string.light_ungrouped), ggb.O00000Oo().O0000o0O(O000000o3.did), true);
                    Device device = this.firstDev;
                    if (device != null && TextUtils.equals(device.did, O000000o3.did)) {
                        this.mDatas.add(0, o00000Oo);
                        if (O000000o3.isOnlineAdvance()) {
                            this.mInitialCheckedMap.put(O000000o3.did, o00000Oo);
                        }
                    } else if (O000000o3.isOnlineAdvance()) {
                        this.mDatas.add(o00000Oo);
                    } else {
                        this.O0000oO0.add(o00000Oo);
                    }
                    this.O0000oO.add(O000000o3.model);
                }
            }
            List<String> O00000o2 = fno.O000000o().O00000o();
            while (i < O00000o2.size()) {
                Device O000000o4 = fno.O000000o().O000000o(O00000o2.get(i));
                if (O000000o4 != null && this.O0000o.equals(ggb.O00000Oo().O0000o0(O000000o4.did))) {
                    for (Device next : fno.O000000o().O0000O0o(O000000o4.did)) {
                        this.mDatas.add(new O00000Oo(next, getString(R.string.light_grouped), ggb.O00000Oo().O0000o0O(O000000o4.did), false));
                        this.O0000oO.add(next.model);
                    }
                }
                i++;
            }
        } else {
            while (i < this.O0000o0o.size()) {
                Device O000000o5 = fno.O000000o().O000000o(this.O0000o0o.get(i));
                if (!O000000o(O000000o5)) {
                    O00000Oo o00000Oo2 = new O00000Oo(O000000o5, getString(R.string.light_ungrouped), "", true);
                    if (O000000o5.isOnlineAdvance()) {
                        this.mDatas.add(o00000Oo2);
                        if (this.mInitialCheckedMap.size() <= 50) {
                            this.mInitialCheckedMap.put(O000000o5.did, o00000Oo2);
                        }
                    } else {
                        this.O0000oO0.add(o00000Oo2);
                    }
                    this.O0000oO.add(O000000o5.model);
                }
                i++;
            }
        }
        if (!this.O0000oO0.isEmpty()) {
            this.mDatas.addAll(this.O0000oO0);
        }
    }

    private static boolean O000000o(Device device) {
        if (device == null || !TextUtils.equals("light", hfa.O00000Oo(device)) || device.pid == Device.PID_VIRTUAL_GROUP) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        String str;
        if (this.mEditMode) {
            O00000o();
            ArrayList arrayList = new ArrayList(this.O0000oOo.f9380O000000o.keySet());
            ArrayList arrayList2 = new ArrayList();
            for (String next : this.mInitialCheckedMap.keySet()) {
                if (!arrayList.contains(next)) {
                    arrayList2.add(next);
                }
            }
            arrayList.removeAll(this.mInitialCheckedMap.keySet());
            DeviceApi.getInstance().modLightGroup(this, this.firstDev.did, arrayList, arrayList2, new fsm<String, fso>() {
                /* class com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity.AnonymousClass4 */

                public final void onFailure(fso fso) {
                    gqg.O00000Oo(fso.O00000Oo);
                    LightGroupSettingV2Activity.this.hideProgressDialog();
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    LightGroupSettingV2Activity lightGroupSettingV2Activity = LightGroupSettingV2Activity.this;
                    lightGroupSettingV2Activity.group_did = lightGroupSettingV2Activity.firstDev.did;
                    fno.O000000o().O000000o(LightGroupSettingV2Activity.this.O0000o0);
                    fno.O000000o().O0000Oo0();
                }
            }, false);
            if (this.firstDev != null) {
                String O00000o02 = O00000o0();
                if (TextUtils.equals(this.firstDev.model.substring(this.firstDev.model.lastIndexOf(".")), O00000o02)) {
                    this.modified = false;
                    str = "not modified";
                } else {
                    str = "modified".concat(String.valueOf(O00000o02));
                    this.modified = true;
                }
                hxk hxk = hxi.O00000o;
                String str2 = this.firstDev.model;
                hxk.f952O000000o.O000000o("lightgroup_edit_save", "model", str2, "type", str);
                return;
            }
            return;
        }
        O00000o();
        final ArrayList arrayList3 = new ArrayList(this.O0000oOo.f9380O000000o.keySet());
        DeviceApi.getInstance().createLightGroupV2(this, arrayList3, "", new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    if (!jSONObject.isNull("group_did")) {
                        LightGroupSettingV2Activity.this.group_did = jSONObject.optString("group_did", "");
                    }
                    if (!jSONObject.isNull("need_alter_device")) {
                        LightGroupSettingV2Activity.this.alterDevice = jSONObject.optBoolean("need_alter_device", false);
                    }
                    Observable.fromIterable(arrayList3).subscribe($$Lambda$LightGroupSettingV2Activity$5$ekrLgV__G1ApVmNpqCMjWjIriD4.INSTANCE);
                    fno.O000000o().O000000o(LightGroupSettingV2Activity.this.O0000o0);
                    fno.O000000o().O0000Oo0();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public final void onFailure(fso fso) {
                gqg.O00000Oo(fso.O00000Oo);
                LightGroupSettingV2Activity.this.hideProgressDialog();
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        hxk hxk2 = hxi.O00000o;
        String O00000o03 = O00000o0();
        int size = this.O0000oOo.f9380O000000o.size();
        long j = currentTimeMillis - this.O0000oo0;
        hxk2.f952O000000o.O000000o("addlightgroup_creat_next", "type", O00000o03, "number", Integer.valueOf(size), "time", Long.valueOf(j));
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.firstDev != null) {
            hxk hxk = hxi.O00000o;
            String str = this.firstDev.model;
            hxk.f952O000000o.O000000o("lightgroup_edit_back", "model", str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if ((i == 100 || i == 200) && i2 != -1) {
            O00000o();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.group_did);
            fno.O000000o().O000000o(arrayList, this, new fno.O00000Oo() {
                /* class com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity.AnonymousClass2 */

                public final void O000000o() {
                    fno.O000000o().O0000Oo0();
                    LightGroupSettingV2Activity.this.hideProgressDialog();
                }

                public final void O000000o(fso fso) {
                    LightGroupSettingV2Activity.this.hideProgressDialog();
                }
            });
        } else if (i == 100) {
            LightGroupTestActivity.open(this, this.group_did, 200);
        } else if (i2 == -1) {
            finish();
        }
    }

    public void updateActionItems(Map<String, O00000Oo> map) {
        int i = 15;
        try {
            this.f9374O000000o.setEnabled(map.size() >= 2);
            for (O00000Oo o00000Oo : map.values()) {
                i &= o00000Oo.O00000oO;
            }
            if (map.values().size() == 0) {
                i = 0;
            }
            updateLightGroupFuncView(i);
            gsy.O00000Oo(O0000o0O, "updateActionItems: final = ".concat(String.valueOf(i)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String O00000o0() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (true) {
            View[] viewArr = this.TAG_FUNC_VIEW;
            if (i < viewArr.length) {
                View view = viewArr[i];
                if (view != null) {
                    i2 += view.isEnabled() ? 1 : 0;
                }
                i++;
            } else {
                sb.append("group");
                sb.append(i2);
                return sb.toString();
            }
        }
    }

    private void O00000o() {
        this.O0000oOO = new XQProgressDialog(this);
        this.O0000oOO.setCancelable(true);
        this.O0000oOO.setMessage(getResources().getString(R.string.loading_share_info));
        this.O0000oOO.show();
    }

    public void hideProgressDialog() {
        XQProgressDialog xQProgressDialog = this.O0000oOO;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    public class O000000o extends RecyclerView.O000000o<O00000o0> {

        /* renamed from: O000000o  reason: collision with root package name */
        public Map<String, O00000Oo> f9380O000000o = new HashMap();
        private List<O00000Oo> O00000o;
        private LayoutInflater O00000o0;

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gpc.O000000o(android.content.Context, float):int
         arg types: [com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity, int]
         candidates:
          _m_j.gpc.O000000o(android.app.Activity, float):int
          _m_j.gpc.O000000o(android.view.View, int):void
          _m_j.gpc.O000000o(android.content.Context, float):int */
        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000o0 o00000o0 = (O00000o0) o000OOo0;
            O00000Oo o00000Oo = this.O00000o.get(i);
            Device device = o00000Oo.f9381O000000o;
            if (device != null && o00000o0 != null) {
                o00000o0.O00000oo.setEnabled(true);
                if (!this.O00000o.get(i).O00000o || !device.isOnlineAdvance() || (this.f9380O000000o.size() >= 50 && !this.f9380O000000o.keySet().contains(device.did))) {
                    o00000o0.O00000oo.setEnabled(false);
                }
                o00000o0.O00000oo.setTag(device.did);
                o00000o0.O00000Oo.setText(device.name);
                o00000o0.O00000o0.setText(this.O00000o.get(i).O00000o0);
                int i2 = 8;
                o00000o0.O00000o0.setVisibility(TextUtils.isEmpty(this.O00000o.get(i).O00000o0) ? 8 : 0);
                o00000o0.O00000o.setText(this.O00000o.get(i).O00000Oo);
                o00000o0.O00000o.setTextColor(LightGroupSettingV2Activity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                o00000o0.O00000o.setVisibility(0);
                if (LightGroupSettingV2Activity.this.firstDev != null && TextUtils.equals(LightGroupSettingV2Activity.this.firstDev.did, device.did)) {
                    o00000o0.O00000o.setText((int) R.string.light_group_current_device);
                    o00000o0.O00000o.setTextColor(LightGroupSettingV2Activity.this.getResources().getColor(R.color.mj_color_green_normal));
                    o00000o0.O00000oo.setEnabled(false);
                }
                if (!device.isOnlineAdvance()) {
                    o00000o0.O00000o.setText((int) R.string.list_device_offline);
                } else if (LightGroupSettingV2Activity.this.mEditMode) {
                    o00000o0.O00000o.setText((int) R.string.list_device_online);
                }
                o00000o0.O0000Oo0.setVisibility(device.isOnlineAdvance() ? 8 : 0);
                CheckBox checkBox = o00000o0.O00000oo;
                if (device.isOnlineAdvance()) {
                    i2 = 0;
                }
                checkBox.setVisibility(i2);
                float f = device.isOnlineAdvance() ? 1.0f : 0.3f;
                o00000o0.O00000Oo.setAlpha(f);
                o00000o0.O00000o0.setAlpha(f);
                o00000o0.O00000o.setAlpha(f);
                o00000o0.O00000oo.setAlpha(f);
                o00000o0.O0000Oo0.setAlpha(f);
                DeviceFactory.O00000Oo(device.model, o00000o0.O00000oO);
                if (this.f9380O000000o != null) {
                    o00000o0.O00000oo.setChecked(this.f9380O000000o.keySet().contains(device.did));
                }
                o00000o0.O00000oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o00000o0, device, o00000Oo) {
                    /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingV2Activity$O000000o$pzpeIJ6FmLztgA1FRzqEL7katWg */
                    private final /* synthetic */ LightGroupSettingV2Activity.O00000o0 f$1;
                    private final /* synthetic */ Device f$2;
                    private final /* synthetic */ LightGroupSettingV2Activity.O00000Oo f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        LightGroupSettingV2Activity.O000000o.this.O000000o(this.f$1, this.f$2, this.f$3, compoundButton, z);
                    }
                });
                o00000o0.f9382O000000o.setOnClickListener(new View.OnClickListener(i, device, o00000o0) {
                    /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingV2Activity$O000000o$MNohYCJwcUAHiH1QWbJmDpYJ22g */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ Device f$2;
                    private final /* synthetic */ LightGroupSettingV2Activity.O00000o0 f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onClick(View view) {
                        LightGroupSettingV2Activity.O000000o.this.O000000o(this.f$1, this.f$2, this.f$3, view);
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) o00000o0.O0000OOo.getLayoutParams();
                if (i == getItemCount() - 1) {
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = gpc.O000000o((Context) LightGroupSettingV2Activity.this, 24.0f);
                }
            }
        }

        public O000000o(Context context, ArrayList<O00000Oo> arrayList) {
            this.O00000o0 = LayoutInflater.from(context);
            this.O00000o = arrayList;
            this.f9380O000000o.putAll(LightGroupSettingV2Activity.this.mInitialCheckedMap);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000o0 o00000o0, Device device, O00000Oo o00000Oo, CompoundButton compoundButton, boolean z) {
            if (z) {
                if (!this.f9380O000000o.keySet().contains(o00000o0.O00000oo.getTag())) {
                    O000000o(device.did, true, o00000Oo);
                }
            } else if (this.f9380O000000o.keySet().contains(o00000o0.O00000oo.getTag())) {
                O000000o(device.did, false, o00000Oo);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String
         arg types: [com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity, ?, int, int]
         candidates:
          _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder
          _m_j.gqb.O000000o(android.app.Activity, java.util.Locale, int, android.widget.TextView):boolean
          _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, Device device, O00000o0 o00000o0, View view) {
            if (!this.O00000o.get(i).O00000o) {
                gqg.O00000Oo((int) R.string.light_already_grouped_v2);
            } else if (!device.isOnlineAdvance()) {
                gqg.O00000Oo((int) R.string.light_already_offline);
            } else if (o00000o0.O00000oo.isEnabled()) {
                o00000o0.O00000oo.performClick();
            } else if (this.f9380O000000o.size() >= 50) {
                gqg.O00000Oo(gqb.O000000o((Context) LightGroupSettingV2Activity.this, (int) R.plurals.light_group_child_max_size, 50, (Object) 50));
            }
        }

        public final int getItemCount() {
            return this.O00000o.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String
         arg types: [com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity, ?, int, int]
         candidates:
          _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder
          _m_j.gqb.O000000o(android.app.Activity, java.util.Locale, int, android.widget.TextView):boolean
          _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String */
        private void O000000o(String str, boolean z, O00000Oo o00000Oo) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!z) {
                        if (this.f9380O000000o.size() >= 50) {
                            notifyDataSetChanged();
                        }
                        this.f9380O000000o.remove(str);
                    } else if (this.f9380O000000o.size() <= 50) {
                        this.f9380O000000o.put(str, o00000Oo);
                        if (this.f9380O000000o.size() >= 50) {
                            gqg.O00000Oo(gqb.O000000o((Context) LightGroupSettingV2Activity.this, (int) R.plurals.light_group_child_max_size, 50, (Object) 50));
                            notifyDataSetChanged();
                        }
                    }
                    LightGroupSettingV2Activity.this.updateActionItems(this.f9380O000000o);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000o0(this.O00000o0.inflate((int) R.layout.item_light_group, viewGroup, false));
        }
    }

    class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9382O000000o;
        TextView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        SimpleDraweeView O00000oO;
        CheckBox O00000oo;
        ImageView O0000O0o;
        View O0000OOo;
        ImageView O0000Oo0;

        O00000o0(View view) {
            super(view);
            this.f9382O000000o = view;
            this.O00000Oo = (TextView) view.findViewById(R.id.title);
            this.O00000o0 = (TextView) view.findViewById(R.id.desc);
            this.O00000o = (TextView) view.findViewById(R.id.desc_tips);
            this.O00000oO = (SimpleDraweeView) view.findViewById(R.id.icon);
            this.O00000oo = (CheckBox) view.findViewById(R.id.checkbox);
            this.O0000O0o = (ImageView) view.findViewById(R.id.offline);
            this.O0000OOo = view.findViewById(R.id.divider_item);
            this.O0000Oo0 = (ImageView) view.findViewById(R.id.iv_right);
        }
    }
}
