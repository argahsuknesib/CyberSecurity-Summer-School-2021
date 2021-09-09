package com.xiaomi.smarthome.light.group;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gtf;
import _m_j.htv;
import _m_j.htw;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.light.group.LightGroupSettingActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class LightGroupSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    fno.O000000o f9367O000000o = new fno.O000000o() {
        /* class com.xiaomi.smarthome.light.group.LightGroupSettingActivity.AnonymousClass2 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            Device O000000o2 = fno.O000000o().O000000o(LightGroupSettingActivity.this.group_did);
            if (i == 3 && O000000o2 != null) {
                fno.O000000o().O00000Oo(LightGroupSettingActivity.this.f9367O000000o);
                if (LightGroupSettingActivity.this.mCreateMode) {
                    fbt fbt = new fbt(LightGroupSettingActivity.this, "initDeviceRoomActivity");
                    fbt.O000000o("device_id", LightGroupSettingActivity.this.group_did);
                    if (LightGroupSettingActivity.this.getIntent() != null) {
                        fbt.O000000o("lightGroupNeedInit", LightGroupSettingActivity.this.getIntent().getBooleanExtra("lightGroupNeedInit", false));
                    }
                    htw O000000o3 = htv.O000000o();
                    if (O000000o3 != null) {
                        O000000o3.setCurrentScrollToDid(LightGroupSettingActivity.this.group_did);
                    }
                    fno.O000000o().O0000OoO();
                    fbs.O000000o(fbt);
                } else {
                    LightGroupSettingActivity.this.setResult(-1, new Intent());
                }
                LightGroupSettingActivity.this.finish();
            }
        }
    };
    private String O00000Oo;
    private TextView O00000o;
    private Home O00000o0;
    private O000000o O00000oO;
    private ArrayList<O00000Oo> O00000oo = new ArrayList<>();
    private XQProgressDialog O0000O0o;
    private String O0000OOo = "";
    private TextView O0000Oo;
    private int O0000Oo0 = 0;
    public String group_did;
    public boolean mCreateMode;
    public String mGroupDid;
    public Set<String> mInitialCheckedMap = new HashSet();
    public String quantityString;

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public Device f9372O000000o;
        public String O00000Oo;
        public boolean O00000o;
        public String O00000o0;

        public O00000Oo(Device device, String str, String str2, boolean z) {
            this.f9372O000000o = device;
            this.O00000Oo = str;
            this.O00000o0 = str2 + " | " + str;
            this.O00000o = z;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String
     arg types: [com.xiaomi.smarthome.light.group.LightGroupSettingActivity, ?, int, int]
     candidates:
      _m_j.gqb.O000000o(android.content.Context, int, int, android.text.style.ClickableSpan):android.text.SpannableStringBuilder
      _m_j.gqb.O000000o(android.app.Activity, java.util.Locale, int, android.widget.TextView):boolean
      _m_j.gqb.O000000o(android.content.Context, int, int, java.lang.Object):java.lang.String */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_light_group_setting);
        this.O00000Oo = getIntent().getStringExtra("key_group_model");
        if (TextUtils.isEmpty(this.O00000Oo)) {
            finish();
            return;
        }
        this.mCreateMode = getIntent().getBooleanExtra("create_mode", true);
        this.mGroupDid = getIntent().getStringExtra("did");
        this.O00000o0 = ggb.O00000Oo().O0000o0(this.mGroupDid);
        if (this.O00000o0 == null) {
            this.O00000o0 = ggb.O00000Oo().O0000Oo0();
        }
        if (this.O00000o0 == null) {
            finish();
            return;
        }
        if (this.mCreateMode) {
            Device O000000o2 = fno.O000000o().O000000o(this.mGroupDid);
            if (O000000o2 != null) {
                this.O00000oo.add(new O00000Oo(O000000o2, getString(R.string.light_ungrouped), ggb.O00000Oo().O0000o0O(O000000o2.did), true));
                if (O000000o2.isOnline) {
                    this.mInitialCheckedMap.add(O000000o2.did);
                }
            }
            O00000Oo();
            List<String> O00000o2 = fno.O000000o().O00000o();
            for (int i = 0; i < O00000o2.size(); i++) {
                Device O000000o3 = fno.O000000o().O000000o(O00000o2.get(i));
                if (O000000o3 != null && this.O00000o0.equals(ggb.O00000Oo().O0000o0(O000000o3.did)) && TextUtils.equals(O000000o3.model, this.O00000Oo)) {
                    for (Device o00000Oo : fno.O000000o().O0000O0o(O000000o3.did)) {
                        this.O00000oo.add(new O00000Oo(o00000Oo, O000000o3.name, ggb.O00000Oo().O0000o0O(O000000o3.did), false));
                    }
                }
            }
        } else {
            List<Device> O0000O0o2 = fno.O000000o().O0000O0o(this.mGroupDid);
            Device O000000o4 = fno.O000000o().O000000o(this.mGroupDid);
            if (O000000o4 == null) {
                finish();
            } else {
                for (Device o00000Oo2 : O0000O0o2) {
                    this.O00000oo.add(new O00000Oo(o00000Oo2, O000000o4.name, ggb.O00000Oo().O0000o0O(O000000o4.did), true));
                }
                for (int i2 = 0; i2 < this.O00000oo.size(); i2++) {
                    this.mInitialCheckedMap.add(this.O00000oo.get(i2).f9372O000000o.did);
                }
                O00000Oo();
                List<String> O00000o3 = fno.O000000o().O00000o();
                for (int i3 = 0; i3 < O00000o3.size(); i3++) {
                    Device O000000o5 = fno.O000000o().O000000o(O00000o3.get(i3));
                    if (O000000o5 != null && this.O00000o0.equals(ggb.O00000Oo().O0000o0(O000000o5.did)) && !O000000o5.equals(O000000o4) && TextUtils.equals(O000000o5.model, O000000o4.model)) {
                        for (Device o00000Oo3 : fno.O000000o().O0000O0o(O000000o5.did)) {
                            this.O00000oo.add(new O00000Oo(o00000Oo3, O000000o5.name, ggb.O00000Oo().O0000o0O(O000000o5.did), false));
                        }
                    }
                }
            }
        }
        Iterator<O00000Oo> it = this.O00000oo.iterator();
        while (it.hasNext()) {
            O00000Oo next = it.next();
            if (next.O00000o && next.f9372O000000o.isOnline) {
                this.O0000Oo0++;
            }
        }
        this.quantityString = gqb.O000000o((Context) this, (int) R.plurals.light_group_child_max_size, 50, (Object) 50);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingActivity$Fp1GOsYOwcg4rXX_fprNgxWYjTM */

            public final void onClick(View view) {
                LightGroupSettingActivity.this.O00000o(view);
            }
        });
        findViewById(R.id.module_a_3_right_btn).setVisibility(8);
        this.O0000Oo = (TextView) findViewById(R.id.create_button);
        this.O0000Oo.setEnabled(false);
        if (this.mCreateMode) {
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.O00000Oo);
            ((ViewStub) findViewById(R.id.layout_top)).inflate();
            ((TextView) findViewById(R.id.tv_child_size)).setText(this.quantityString);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.bg_light);
            if (O00000oO2 != null) {
                textView.setText(O00000oO2.O0000Oo0());
                DeviceFactory.O00000Oo(this.O00000Oo, simpleDraweeView);
                this.O0000OOo = O00000oO2.O0000Oo0();
            }
            this.O0000Oo.setText((int) R.string.create);
            this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingActivity$n0ANyaW7uTha_ZuKVdLqC6Ng */

                public final void onClick(View view) {
                    LightGroupSettingActivity.this.O00000o0(view);
                }
            });
        } else {
            textView.setText((int) R.string.light_group_manager);
            this.O0000Oo.setText((int) R.string.save);
            ((TextView) findViewById(R.id.tv_child_size)).setText(this.quantityString);
            this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingActivity$uWifosv1PVcn431apPbDAIbBJEc */

                public final void onClick(View view) {
                    LightGroupSettingActivity.this.O00000Oo(view);
                }
            });
        }
        this.O00000o = (TextView) findViewById(R.id.module_a_3_right_text_btn);
        this.O00000o.setVisibility(0);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingActivity$B70hdJOLhWgcz0p5fhK2f_Ikb6s */

            public final void onClick(View view) {
                LightGroupSettingActivity.this.O000000o(view);
            }
        });
        if (this.O0000Oo0 <= 0) {
            this.O00000o.setEnabled(false);
        } else {
            this.O00000o.setEnabled(true);
            if (this.mInitialCheckedMap.size() < this.O0000Oo0) {
                this.O00000o.setText((int) R.string.select_all);
            } else {
                this.O00000o.setText((int) R.string.unselect_all);
            }
        }
        this.O00000oO = new O000000o(this, this.O00000oo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.O00000oO);
    }

    private void O00000Oo() {
        for (String O000000o2 : ggb.O00000Oo().O000000o(this.O00000o0.getId(), new boolean[0])) {
            Device O000000o3 = fno.O000000o().O000000o(O000000o2);
            if (O000000o3 != null && !TextUtils.equals(this.mGroupDid, O000000o3.did) && gtf.O000000o().O000000o(O000000o3, this.O00000Oo)) {
                this.O00000oo.add(new O00000Oo(O000000o3, getString(R.string.light_ungrouped), ggb.O00000Oo().O0000o0O(O000000o3.did), true));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        O000000o();
        fno.O000000o().O00000Oo(this.f9367O000000o);
    }

    private void O00000o0() {
        if (isValid()) {
            this.O0000O0o = new XQProgressDialog(this);
            this.O0000O0o.setMessage(getString(R.string.device_more_security_loading_operation));
            this.O0000O0o.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        XQProgressDialog xQProgressDialog = this.O0000O0o;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    public void updateActionItems(int i) {
        boolean z = true;
        if (this.mCreateMode) {
            TextView textView = this.O0000Oo;
            if (i < 2) {
                z = false;
            }
            textView.setEnabled(z);
        } else {
            TextView textView2 = this.O0000Oo;
            if (i <= 0) {
                z = false;
            }
            textView2.setEnabled(z);
        }
        int i2 = this.O0000Oo0;
        if ((i >= i2 && i2 > 0) || i >= 50) {
            this.O00000o.setText((int) R.string.unselect_all);
        } else if (this.O0000Oo0 > 0) {
            this.O00000o.setText((int) R.string.select_all);
        }
    }

    public class O000000o extends RecyclerView.O000000o<O00000o0> {

        /* renamed from: O000000o  reason: collision with root package name */
        List<O00000Oo> f9371O000000o = new ArrayList();
        public Set<String> O00000Oo = new LinkedHashSet();
        private LayoutInflater O00000o;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000o0 o00000o0 = (O00000o0) o000OOo0;
            Device device = this.f9371O000000o.get(i).f9372O000000o;
            if (device != null && o00000o0 != null) {
                o00000o0.O00000oO.setEnabled(true);
                int i2 = 0;
                if (!this.f9371O000000o.get(i).O00000o || !device.isOnline || (this.O00000Oo.size() >= 50 && !this.O00000Oo.contains(device.did))) {
                    o00000o0.O00000oO.setEnabled(false);
                }
                o00000o0.O00000oO.setVisibility(o00000o0.O00000oO.isEnabled() ? 0 : 4);
                o00000o0.O00000oO.setTag(device.did);
                o00000o0.O00000Oo.setText(device.name);
                o00000o0.O00000o0.setText(this.f9371O000000o.get(i).O00000o0);
                ImageView imageView = o00000o0.O00000oo;
                if (device.isOnline) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                DeviceFactory.O00000Oo(device.model, o00000o0.O00000o);
                if (this.O00000Oo != null) {
                    o00000o0.O00000oO.setChecked(this.O00000Oo.contains(device.did));
                }
                o00000o0.O00000oO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(o00000o0, device) {
                    /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingActivity$O000000o$DVG6rssDZhpdzT9Mpz4dmRVMTSQ */
                    private final /* synthetic */ LightGroupSettingActivity.O00000o0 f$1;
                    private final /* synthetic */ Device f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        LightGroupSettingActivity.O000000o.this.O000000o(this.f$1, this.f$2, compoundButton, z);
                    }
                });
                o00000o0.f9373O000000o.setOnClickListener(new View.OnClickListener(i, device, o00000o0) {
                    /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupSettingActivity$O000000o$u6mx3_83Buxfg9nmCmj5D7xEs */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ Device f$2;
                    private final /* synthetic */ LightGroupSettingActivity.O00000o0 f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onClick(View view) {
                        LightGroupSettingActivity.O000000o.this.O000000o(this.f$1, this.f$2, this.f$3, view);
                    }
                });
            }
        }

        public O000000o(Context context, ArrayList<O00000Oo> arrayList) {
            this.O00000o = LayoutInflater.from(context);
            this.f9371O000000o = arrayList;
            this.O00000Oo.addAll(LightGroupSettingActivity.this.mInitialCheckedMap);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000o0 o00000o0, Device device, CompoundButton compoundButton, boolean z) {
            if (z) {
                if (!this.O00000Oo.contains(o00000o0.O00000oO.getTag())) {
                    O000000o(device.did, true);
                }
            } else if (this.O00000Oo.contains(o00000o0.O00000oO.getTag())) {
                O000000o(device.did, false);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, Device device, O00000o0 o00000o0, View view) {
            if (!this.f9371O000000o.get(i).O00000o) {
                gqg.O00000Oo((int) R.string.light_already_grouped);
            } else if (!device.isOnline) {
                gqg.O00000Oo((int) R.string.offline_device);
            } else if (o00000o0.O00000oO.isEnabled()) {
                o00000o0.O00000oO.performClick();
            } else if (this.O00000Oo.size() >= 50) {
                gqg.O00000Oo(LightGroupSettingActivity.this.quantityString);
            }
        }

        public final int getItemCount() {
            return this.f9371O000000o.size();
        }

        private void O000000o(String str, boolean z) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!z) {
                        if (this.O00000Oo.size() >= 50) {
                            notifyDataSetChanged();
                        }
                        this.O00000Oo.remove(str);
                    } else if (this.O00000Oo.size() <= 50) {
                        this.O00000Oo.add(str);
                        if (this.O00000Oo.size() >= 50) {
                            gqg.O00000Oo(LightGroupSettingActivity.this.quantityString);
                            notifyDataSetChanged();
                        }
                    }
                    LightGroupSettingActivity.this.updateActionItems(this.O00000Oo.size());
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
            return new O00000o0(this.O00000o.inflate((int) R.layout.item_light_group, viewGroup, false));
        }
    }

    class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9373O000000o;
        TextView O00000Oo;
        SimpleDraweeView O00000o;
        TextView O00000o0;
        CheckBox O00000oO;
        ImageView O00000oo;

        public O00000o0(View view) {
            super(view);
            this.f9373O000000o = view;
            this.O00000Oo = (TextView) view.findViewById(R.id.title);
            this.O00000o0 = (TextView) view.findViewById(R.id.desc);
            this.O00000o = (SimpleDraweeView) view.findViewById(R.id.icon);
            this.O00000oO = (CheckBox) view.findViewById(R.id.checkbox);
            this.O00000oo = (ImageView) view.findViewById(R.id.offline);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    public /* synthetic */ void O000000o(View view) {
        boolean z;
        O000000o o000000o;
        int i;
        boolean z2;
        O000000o o000000o2;
        if (this.O00000oO.O00000Oo.size() >= 50) {
            o000000o2 = this.O00000oO;
        } else {
            o000000o2 = this.O00000oO;
            if (o000000o2.O00000Oo.size() < this.O0000Oo0) {
                o000000o = o000000o2;
                z = true;
                z2 = false;
                for (i = 0; i < o000000o.f9371O000000o.size(); i++) {
                    O00000Oo o00000Oo = o000000o.f9371O000000o.get(i);
                    boolean z3 = z && o00000Oo.O00000o && o00000Oo.f9372O000000o.isOnline;
                    if (!TextUtils.isEmpty(o00000Oo.f9372O000000o.did)) {
                        if (!z3) {
                            o000000o.O00000Oo.remove(o00000Oo.f9372O000000o.did);
                        } else if (o000000o.O00000Oo.size() >= 50) {
                            z2 = true;
                        } else {
                            o000000o.O00000Oo.add(o00000Oo.f9372O000000o.did);
                        }
                    }
                }
                if (z2) {
                    gqg.O00000Oo(LightGroupSettingActivity.this.quantityString);
                }
                LightGroupSettingActivity.this.updateActionItems(o000000o.O00000Oo.size());
                this.O00000oO.notifyDataSetChanged();
            }
        }
        o000000o = o000000o2;
        z = false;
        z2 = false;
        while (i < o000000o.f9371O000000o.size()) {
        }
        if (z2) {
        }
        LightGroupSettingActivity.this.updateActionItems(o000000o.O00000Oo.size());
        this.O00000oO.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        O00000o0();
        ArrayList arrayList = new ArrayList(this.O00000oO.O00000Oo);
        ArrayList arrayList2 = new ArrayList();
        for (String next : this.mInitialCheckedMap) {
            if (!arrayList.contains(next)) {
                arrayList2.add(next);
            }
        }
        arrayList.removeAll(this.mInitialCheckedMap);
        DeviceApi.getInstance().modLightGroupOld(this, this.mGroupDid, arrayList, arrayList2, new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.light.group.LightGroupSettingActivity.AnonymousClass1 */

            public final void onFailure(fso fso) {
                gqg.O00000Oo(fso.O00000Oo);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                LightGroupSettingActivity lightGroupSettingActivity = LightGroupSettingActivity.this;
                lightGroupSettingActivity.group_did = lightGroupSettingActivity.mGroupDid;
                fno.O000000o().O000000o(LightGroupSettingActivity.this.f9367O000000o);
                fno.O000000o().O0000Oo0();
                LightGroupSettingActivity.this.O000000o();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        O00000o0();
        DeviceApi.getInstance().createLightGroup(this, new ArrayList(this.O00000oO.O00000Oo), this.O0000OOo, new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.light.group.LightGroupSettingActivity.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    if (!jSONObject.isNull("group_did")) {
                        LightGroupSettingActivity.this.group_did = jSONObject.optString("group_did", "");
                    }
                    gqg.O00000Oo((int) R.string.light_group_create_succ);
                    fno.O000000o().O000000o(LightGroupSettingActivity.this.f9367O000000o);
                    fno.O000000o().O0000Oo0();
                    LightGroupSettingActivity.this.O000000o();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public final void onFailure(fso fso) {
                gqg.O00000Oo(fso.O00000Oo);
                LightGroupSettingActivity.this.O000000o();
            }
        });
    }
}
