package com.xiaomi.smarthome.scene.activity;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gqg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.scene.activity.SceneSpeakerSettingActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class SceneSpeakerSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f10873O000000o;
    LinearLayoutManager O00000Oo;
    Set<String> O00000o = new HashSet();
    ArrayList<O00000o0> O00000o0 = new ArrayList<>();
    private String O00000oO;
    @BindView(5272)
    View emptyView;
    @BindView(5414)
    ImageView imgEmpty;
    @BindView(5351)
    RecyclerView mDeviceList;
    @BindView(5822)
    View mModuleA4ReturnBtn;
    public XQProgressDialog mPD;
    @BindView(5270)
    TextView txtEmpty;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scene_voice_contrl_devices);
        ButterKnife.bind(this);
        this.mModuleA4ReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SceneSpeakerSettingActivity$NJvjXdpK_7fgHH5W4gWu_VWXGJw */

            public final void onClick(View view) {
                SceneSpeakerSettingActivity.this.O000000o(view);
            }
        });
        this.O00000Oo = new LinearLayoutManager(this);
        this.mDeviceList.setLayoutManager(this.O00000Oo);
        this.f10873O000000o = new O000000o(this, (byte) 0);
        this.mDeviceList.setAdapter(this.f10873O000000o);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("voice_control_list");
        ArrayList<String> stringArrayListExtra2 = getIntent().getStringArrayListExtra("voice_control_deny_list");
        if (stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0) {
            this.O00000o.addAll(stringArrayListExtra2);
        }
        if (stringArrayListExtra != null) {
            List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < stringArrayListExtra.size(); i++) {
                Home O0000o0 = ggb.O00000Oo().O0000o0(stringArrayListExtra.get(i));
                if (O0000o0 != null) {
                    hashSet.add(O0000o0);
                }
            }
            arrayList.remove(hashSet);
            list.remove(arrayList);
            this.O00000o0.addAll(O000000o(list, stringArrayListExtra));
        }
        ArrayList<O00000o0> arrayList2 = this.O00000o0;
        if (arrayList2 == null || arrayList2.size() == 0) {
            this.emptyView.setVisibility(0);
            this.mDeviceList.setVisibility(8);
        } else {
            this.emptyView.setVisibility(8);
            this.mDeviceList.setVisibility(0);
        }
        this.txtEmpty.setText((int) R.string.scene_alias_no_speaker);
        this.imgEmpty.setImageResource(R.drawable.ic_plug_rec_action_empty_1000);
        this.O00000oO = getIntent().getStringExtra("scene_id");
        this.f10873O000000o.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O00000Oo();
    }

    private static Collection<O00000o0> O000000o(List<Home> list, ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(ggb.O00000Oo().O000000o(list.get(i).getId(), true));
            arrayList3.retainAll(arrayList);
            if (arrayList3.size() != 0) {
                ggb.O00000Oo();
                arrayList2.add(new O00000o0(0, ggb.O000000o(list.get(i))));
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    arrayList2.add(new O00000o0(1, (String) arrayList3.get(i2)));
                }
            }
        }
        return arrayList2;
    }

    private ArrayList<String> O000000o() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!this.O00000o.isEmpty()) {
            arrayList.addAll(this.O00000o);
        }
        return arrayList;
    }

    public void onBackPressed() {
        O00000Oo();
    }

    private void O00000Oo() {
        final ArrayList<String> O000000o2 = O000000o();
        if (TextUtils.isEmpty(this.O00000oO)) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("voice_control_deny_list", O000000o2);
            setResult(-1, intent);
            finish();
            return;
        }
        this.mPD = XQProgressDialog.O000000o(this, null, getResources().getString(R.string.smarthome_scene_saving_scene));
        DeviceApi.getInstance().updateSceneAuthData(this, O000000o2, this.O00000oO, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.activity.SceneSpeakerSettingActivity.AnonymousClass1 */

            public final void onFailure(fso fso) {
                if (SceneSpeakerSettingActivity.this.mPD != null && SceneSpeakerSettingActivity.this.isValid()) {
                    SceneSpeakerSettingActivity.this.mPD.dismiss();
                }
                gqg.O00000Oo((int) R.string.code_unknown_error);
                SceneSpeakerSettingActivity.this.finish();
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (SceneSpeakerSettingActivity.this.mPD != null && SceneSpeakerSettingActivity.this.isValid()) {
                    SceneSpeakerSettingActivity.this.mPD.dismiss();
                }
                Intent intent = new Intent();
                intent.putStringArrayListExtra("voice_control_deny_list", O000000o2);
                SceneSpeakerSettingActivity.this.setResult(-1, intent);
                SceneSpeakerSettingActivity.this.finish();
            }
        });
    }

    class O000000o extends RecyclerView.O000000o<O00000Oo> {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(SceneSpeakerSettingActivity sceneSpeakerSettingActivity, byte b) {
            this();
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            Device device;
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                o00000Oo.f10876O000000o.setText(SceneSpeakerSettingActivity.this.O00000o0.get(i).O00000o0);
                o00000Oo.O00000oO.setVisibility(i == 0 ? 8 : 0);
            } else if (itemViewType == 1 && (device = fno.O000000o().O0000O0o().get(SceneSpeakerSettingActivity.this.O00000o0.get(i).O00000Oo)) != null) {
                if (!TextUtils.isEmpty(device.name)) {
                    o00000Oo.f10876O000000o.setText(device.name);
                }
                DeviceFactory.O00000Oo(device.model, o00000Oo.O00000o);
                Room O0000o00 = ggb.O00000Oo().O0000o00(SceneSpeakerSettingActivity.this.O00000o0.get(i).O00000Oo);
                String name = O0000o00 != null ? O0000o00.getName() : null;
                if (!TextUtils.isEmpty(name)) {
                    o00000Oo.O00000o0.setText(name);
                }
                o00000Oo.O00000Oo.setOnCheckedChangeListener(null);
                o00000Oo.O00000Oo.setChecked(true ^ SceneSpeakerSettingActivity.this.O00000o.contains(SceneSpeakerSettingActivity.this.O00000o0.get(i).O00000Oo));
                o00000Oo.O00000Oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(i) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SceneSpeakerSettingActivity$O000000o$dnGXV1gAQxPZ2INnfKU4h_vGvSA */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        SceneSpeakerSettingActivity.O000000o.this.O000000o(this.f$1, compoundButton, z);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, CompoundButton compoundButton, boolean z) {
            if (z) {
                SceneSpeakerSettingActivity.this.O00000o.remove(SceneSpeakerSettingActivity.this.O00000o0.get(i).O00000Oo);
            } else {
                SceneSpeakerSettingActivity.this.O00000o.add(SceneSpeakerSettingActivity.this.O00000o0.get(i).O00000Oo);
            }
        }

        public final int getItemViewType(int i) {
            return SceneSpeakerSettingActivity.this.O00000o0.get(i).f10877O000000o;
        }

        public final int getItemCount() {
            if (SceneSpeakerSettingActivity.this.O00000o0 == null) {
                return 0;
            }
            return SceneSpeakerSettingActivity.this.O00000o0.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                SceneSpeakerSettingActivity sceneSpeakerSettingActivity = SceneSpeakerSettingActivity.this;
                return new O00000Oo(LayoutInflater.from(sceneSpeakerSettingActivity).inflate((int) R.layout.item_scene_vc_device, viewGroup, false));
            }
            SceneSpeakerSettingActivity sceneSpeakerSettingActivity2 = SceneSpeakerSettingActivity.this;
            return new O00000Oo(LayoutInflater.from(sceneSpeakerSettingActivity2).inflate((int) R.layout.item_scene_vc_home, viewGroup, false));
        }
    }

    public class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f10876O000000o;
        CheckBox O00000Oo;
        SimpleDraweeView O00000o;
        TextView O00000o0;
        View O00000oO;

        public O00000Oo(View view) {
            super(view);
            this.f10876O000000o = (TextView) view.findViewById(R.id.title);
            this.O00000Oo = (CheckBox) view.findViewById(R.id.ratio_btn);
            this.O00000o0 = (TextView) view.findViewById(R.id.home_room_name);
            this.O00000o = (SimpleDraweeView) view.findViewById(R.id.device_icon);
            this.O00000oO = view.findViewById(R.id.divider);
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10877O000000o;
        String O00000Oo;
        String O00000o0;

        public O00000o0(int i, String str) {
            this.f10877O000000o = i;
            if (i == 0) {
                this.O00000o0 = str;
            } else {
                this.O00000Oo = str;
            }
        }
    }
}
