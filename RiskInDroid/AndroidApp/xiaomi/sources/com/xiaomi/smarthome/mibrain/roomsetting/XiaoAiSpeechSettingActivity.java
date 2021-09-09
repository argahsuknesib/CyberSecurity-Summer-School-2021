package com.xiaomi.smarthome.mibrain.roomsetting;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gvr;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.mibrain.roomsetting.model.ControllableDevice;
import com.xiaomi.smarthome.mibrain.roomsetting.model.XiaoAiRoomItem;
import com.xiaomi.smarthome.mibrain.roomsetting.model.XiaoAiVoiceCategory;
import com.xiaomi.smarthome.ui.DeviceBigHeaderView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XiaoAiSpeechSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f9496O000000o = "XiaoAiSpeechSettingActivity";
    private Home O00000Oo;
    private XiaoAiVoiceCategory O00000o;
    private String O00000o0;
    private XiaoAiRoomItem O00000oO;
    private DeviceBigHeaderView O00000oo;
    private ViewGroup O0000O0o;
    private View O0000OOo;
    private TextView O0000Oo;
    private View O0000Oo0;
    private RecyclerView O0000OoO;
    private View O0000Ooo;
    private XQProgressDialog O0000o0;
    private View O0000o00;
    public O000000o mAdapter;
    public List<String> mDids;
    public Room mRoom;
    public boolean mUsingXiaoAiDefault = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_xiaoai_speech_setting_layout);
        this.O00000oo = (DeviceBigHeaderView) findViewById(R.id.device_big_header_view);
        this.O0000Oo = (TextView) findViewById(R.id.home_room_name_tv);
        this.O0000OoO = (RecyclerView) findViewById(R.id.recyclerview);
        this.O0000OoO.setLayoutManager(new LinearLayoutManager(this));
        this.O0000Ooo = findViewById(R.id.common_white_empty_view);
        this.O0000O0o = (ViewGroup) findViewById(R.id.speech_list_container);
        this.O0000OOo = findViewById(R.id.auto_select_container);
        this.O0000Oo0 = findViewById(R.id.manually_select_container);
        this.O0000o00 = findViewById(R.id.multi_xiaoai_tips_tv);
        ((ImageView) this.O0000Ooo.findViewById(R.id.empty_icon)).setImageResource(R.drawable.emptypage_icon_nodevice_nor_1);
        ((TextView) this.O0000Ooo.findViewById(R.id.common_white_empty_text)).setText((int) R.string.no_device_in_room);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.mi_brain_most_used_speech_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity.AnonymousClass1 */

            public final void onClick(View view) {
                if (XiaoAiSpeechSettingActivity.this.mAdapter != null && XiaoAiSpeechSettingActivity.this.mAdapter.O00000o0) {
                    XiaoAiSpeechSettingActivity.this.mAdapter.O000000o();
                }
                XiaoAiSpeechSettingActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.speech_list_header).findViewById(R.id.name_tv)).setText((int) R.string.when_speaking_to_xiaoai);
        ((TextView) findViewById(R.id.device_list_header).findViewById(R.id.name_tv)).setText((int) R.string.execute_actions_to_devices);
        this.O00000Oo = ggb.O00000Oo().O00000o(intent.getStringExtra("home_id"));
        this.mRoom = ggb.O00000Oo().O00000o0(intent.getStringExtra("room_id"));
        this.mDids = intent.getStringArrayListExtra("dids_list_id");
        XiaoAiRoomItem xiaoAiRoomItem = this.O00000oO;
        this.mUsingXiaoAiDefault = xiaoAiRoomItem == null ? true : xiaoAiRoomItem.O000000o(this.O00000o);
        this.O00000o0 = intent.getStringExtra("intent_id");
        if (this.mDids.size() > 0) {
            dismissProgressDialog();
            this.O0000o0 = XQProgressDialog.O000000o(this, null, getString(R.string.mj_loading));
            gvr.O000000o().O000000o(this.mRoom, new fsm<List<XiaoAiRoomItem>, fso>() {
                /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    XiaoAiSpeechSettingActivity.this.populateSpeechData((List) obj);
                }

                public final void onFailure(fso fso) {
                    XiaoAiSpeechSettingActivity.this.dismissProgressDialog();
                }
            });
        }
        O000000o();
        updateXXSelectView(this.mUsingXiaoAiDefault);
        O00000Oo();
    }

    public void updateXXSelectView(boolean z) {
        O000000o o000000o = this.mAdapter;
        if (o000000o == null || o000000o.getItemCount() != 0) {
            this.O0000OOo.setVisibility(0);
            this.O0000Oo0.setVisibility(0);
            if (z) {
                this.O0000OOo.findViewById(R.id.auto_select_indicator).setVisibility(0);
                this.O0000Oo0.findViewById(R.id.manually_select_indicator).setVisibility(4);
            } else {
                this.O0000OOo.findViewById(R.id.auto_select_indicator).setVisibility(4);
                this.O0000Oo0.findViewById(R.id.manually_select_indicator).setVisibility(0);
            }
            this.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    if (!XiaoAiSpeechSettingActivity.this.mUsingXiaoAiDefault && XiaoAiSpeechSettingActivity.this.mAdapter != null) {
                        XiaoAiSpeechSettingActivity.this.mAdapter.O00000o0 = true;
                    }
                    XiaoAiSpeechSettingActivity xiaoAiSpeechSettingActivity = XiaoAiSpeechSettingActivity.this;
                    xiaoAiSpeechSettingActivity.mUsingXiaoAiDefault = true;
                    xiaoAiSpeechSettingActivity.updateXXSelectView(xiaoAiSpeechSettingActivity.mUsingXiaoAiDefault);
                }
            });
            this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    if (XiaoAiSpeechSettingActivity.this.mUsingXiaoAiDefault && XiaoAiSpeechSettingActivity.this.mAdapter != null) {
                        XiaoAiSpeechSettingActivity.this.mAdapter.O00000o0 = true;
                    }
                    XiaoAiSpeechSettingActivity xiaoAiSpeechSettingActivity = XiaoAiSpeechSettingActivity.this;
                    xiaoAiSpeechSettingActivity.mUsingXiaoAiDefault = false;
                    xiaoAiSpeechSettingActivity.updateXXSelectView(xiaoAiSpeechSettingActivity.mUsingXiaoAiDefault);
                }
            });
            O000000o o000000o2 = this.mAdapter;
            if (o000000o2 != null) {
                o000000o2.notifyDataSetChanged();
                return;
            }
            return;
        }
        this.O0000OOo.setVisibility(8);
        this.O0000Oo0.setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o() {
        List<String> list;
        XiaoAiVoiceCategory xiaoAiVoiceCategory = this.O00000o;
        if (xiaoAiVoiceCategory != null && (list = xiaoAiVoiceCategory.O00000o0) != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    View inflate = LayoutInflater.from(getApplicationContext()).inflate((int) R.layout.xiaoai_speech_list_item, this.O0000O0o, false);
                    ((TextView) inflate.findViewById(R.id.speech_tv)).setText("“" + str + "”");
                    this.O0000O0o.addView(inflate);
                }
            }
            this.O0000O0o.requestLayout();
        }
    }

    private void O00000Oo() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mDids.size(); i++) {
            Device O000000o2 = fno.O000000o().O000000o(this.mDids.get(i));
            if (O000000o2 != null) {
                arrayList.add(new DeviceBigHeaderView.O000000o(O000000o2.model, O000000o2.name));
            }
        }
        this.O00000oo.setModel(arrayList);
        TextView textView = this.O0000Oo;
        StringBuilder sb = new StringBuilder();
        ggb.O00000Oo();
        sb.append(ggb.O000000o(this.O00000Oo));
        sb.append(" | ");
        Room room = this.mRoom;
        sb.append(room == null ? getResources().getString(R.string.default_room) : room.getName());
        textView.setText(sb.toString());
        if (arrayList.size() > 1) {
            this.O0000o00.setVisibility(0);
        } else {
            this.O0000o00.setVisibility(8);
        }
    }

    private void O00000o0() {
        this.O0000Ooo.setVisibility(0);
        this.O0000OoO.setVisibility(8);
        this.O0000OOo.setVisibility(8);
        this.O0000Oo0.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.O0000Ooo.findViewById(R.id.empty_icon).getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = gpc.O000000o(42.0f);
        }
        ViewGroup.LayoutParams layoutParams2 = this.O0000Ooo.findViewById(R.id.common_white_empty_text).getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams2).bottomMargin = gpc.O000000o(29.0f);
        }
    }

    public void populateSpeechData(List<XiaoAiRoomItem> list) {
        List list2;
        dismissProgressDialog();
        if (list != null) {
            int i = 0;
            while (true) {
                if (i < list.size()) {
                    XiaoAiRoomItem xiaoAiRoomItem = list.get(i);
                    if (xiaoAiRoomItem != null && TextUtils.equals(xiaoAiRoomItem.O00000Oo, this.O00000o0)) {
                        this.O00000oO = xiaoAiRoomItem;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (this.O00000oO == null) {
                this.O00000oO = new XiaoAiRoomItem();
            }
            this.O00000oO.O00000Oo = this.O00000o0;
            gvr O000000o2 = gvr.O000000o();
            Room room = this.mRoom;
            if (room == null) {
                list2 = null;
            } else {
                list2 = O000000o2.O00000Oo.get(gvr.O000000o(room));
            }
            if (list2 == null || list2.isEmpty()) {
                LogType logType = LogType.GENERAL;
                String str = f9496O000000o;
                gsy.O00000Oo(logType, str, "empty XiaoAiVoiceCategory list for " + this.mRoom.getName());
                O00000o0();
                return;
            }
            this.O00000o = new XiaoAiVoiceCategory();
            this.O00000o.f9513O000000o = this.O00000oO.O00000Oo;
            int i2 = 0;
            while (true) {
                if (i2 < list2.size()) {
                    XiaoAiVoiceCategory xiaoAiVoiceCategory = (XiaoAiVoiceCategory) list2.get(i2);
                    if (xiaoAiVoiceCategory != null && TextUtils.equals(xiaoAiVoiceCategory.f9513O000000o, this.O00000o0)) {
                        this.O00000o = xiaoAiVoiceCategory;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            XiaoAiVoiceCategory xiaoAiVoiceCategory2 = this.O00000o;
            if (xiaoAiVoiceCategory2 == null) {
                LogType logType2 = LogType.GENERAL;
                String str2 = f9496O000000o;
                gsy.O00000Oo(logType2, str2, "XiaoAiVoiceCategory not found for " + this.mRoom.getName());
                O00000o0();
                return;
            }
            this.mAdapter = new O000000o(this.O00000oO, xiaoAiVoiceCategory2);
            boolean z = true;
            this.mAdapter.setHasStableIds(true);
            if (this.mAdapter.getItemCount() > 0) {
                this.O0000Ooo.setVisibility(8);
                this.O0000OoO.setVisibility(0);
                this.O0000OoO.setAdapter(this.mAdapter);
                runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity.AnonymousClass5 */

                    public final void run() {
                        XiaoAiSpeechSettingActivity.this.mAdapter.notifyDataSetChanged();
                    }
                });
            } else {
                O00000o0();
            }
            XiaoAiRoomItem xiaoAiRoomItem2 = this.O00000oO;
            if (xiaoAiRoomItem2 != null) {
                z = xiaoAiRoomItem2.O000000o(this.O00000o);
            }
            this.mUsingXiaoAiDefault = z;
            O000000o();
            updateXXSelectView(this.mUsingXiaoAiDefault);
            O00000Oo();
        }
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.O0000o0;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O0000o0.dismiss();
        }
    }

    class O000000o extends RecyclerView.O000000o<C0083O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public Set<ControllableDevice> f9502O000000o;
        public XiaoAiVoiceCategory O00000Oo;
        public boolean O00000o0 = true;
        private List<ControllableDevice> O00000oO;
        private XiaoAiRoomItem O00000oo;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ControllableDevice controllableDevice;
            C0083O000000o o000000o = (C0083O000000o) o000OOo0;
            if (i >= 0 && i < this.O00000oO.size() && (controllableDevice = this.O00000oO.get(i)) != null) {
                o000000o.f9504O000000o.setOnCheckedChangeListener(null);
                o000000o.O00000Oo.setText(ControllableDevice.O000000o(controllableDevice));
                o000000o.f9504O000000o.setButtonDrawable(o000000o.O00000o);
                o000000o.f9504O000000o.setChecked(O000000o.this.f9502O000000o.contains(controllableDevice));
                Device O000000o2 = fno.O000000o().O000000o(controllableDevice.f9511O000000o);
                if (O000000o2 != null) {
                    DeviceFactory.O00000Oo(O000000o2.model, o000000o.O00000o0);
                }
                if (XiaoAiSpeechSettingActivity.this.mUsingXiaoAiDefault) {
                    o000000o.O00000o0.setAlpha(0.5f);
                    o000000o.O00000Oo.setAlpha(0.5f);
                    o000000o.f9504O000000o.setVisibility(4);
                    return;
                }
                o000000o.O00000o0.setAlpha(1.0f);
                o000000o.O00000Oo.setAlpha(1.0f);
                o000000o.f9504O000000o.setVisibility(0);
                o000000o.f9504O000000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(controllableDevice) {
                    /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity.O000000o.C0083O000000o.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ ControllableDevice f9506O000000o;

                    {
                        this.f9506O000000o = r2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            if (O000000o.this.O00000Oo.O00000Oo == 1) {
                                O000000o.this.f9502O000000o.clear();
                            }
                            O000000o.this.f9502O000000o.add(this.f9506O000000o);
                            O000000o.this.O00000o0 = true;
                        } else if (O000000o.this.f9502O000000o.size() == 1) {
                            if (O000000o.this.O00000Oo.O00000Oo == 1) {
                                gqg.O00000Oo((int) R.string.must_select_one_device_for_single_select);
                            } else {
                                gqg.O00000Oo((int) R.string.must_select_one_device_for_multi_select);
                            }
                        } else if (O000000o.this.f9502O000000o.size() > 1) {
                            O000000o.this.f9502O000000o.remove(this.f9506O000000o);
                            O000000o.this.O00000o0 = true;
                        }
                        O000000o.this.notifyDataSetChanged();
                    }
                });
            }
        }

        public O000000o(XiaoAiRoomItem xiaoAiRoomItem, XiaoAiVoiceCategory xiaoAiVoiceCategory) {
            this.O00000oo = xiaoAiRoomItem;
            this.O00000Oo = xiaoAiVoiceCategory;
            List<ControllableDevice> list = this.O00000oo == null ? null : xiaoAiRoomItem.O00000o;
            this.f9502O000000o = new HashSet();
            this.O00000oO = xiaoAiVoiceCategory.O00000o == null ? new ArrayList<>() : xiaoAiVoiceCategory.O00000o;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    ControllableDevice controllableDevice = (ControllableDevice) list.get(i);
                    if (controllableDevice != null && this.O00000oO.contains(controllableDevice)) {
                        this.f9502O000000o.add(controllableDevice);
                    }
                }
            }
        }

        public final void O000000o() {
            if (this.O00000o0) {
                XiaoAiRoomItem xiaoAiRoomItem = new XiaoAiRoomItem();
                xiaoAiRoomItem.f9512O000000o = XiaoAiSpeechSettingActivity.this.mRoom.getId();
                xiaoAiRoomItem.O00000Oo = this.O00000Oo.f9513O000000o;
                xiaoAiRoomItem.O00000o0 = XiaoAiSpeechSettingActivity.this.mUsingXiaoAiDefault;
                xiaoAiRoomItem.O00000o = XiaoAiSpeechSettingActivity.this.mUsingXiaoAiDefault ? null : new ArrayList(this.f9502O000000o);
                gvr.O000000o().O000000o(XiaoAiSpeechSettingActivity.this.mDids, xiaoAiRoomItem, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity.O000000o.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    }
                });
            }
        }

        public final int getItemCount() {
            return this.O00000oO.size();
        }

        /* renamed from: com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0083O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public CheckBox f9504O000000o;
            TextView O00000Oo;
            Drawable O00000o = CommonApplication.getAppContext().getResources().getDrawable(R.drawable.mj_checkbox_layout);
            SimpleDraweeView O00000o0;
            private TextView O00000oo;
            private View O0000O0o;
            private Drawable O0000OOo = CommonApplication.getAppContext().getResources().getDrawable(R.drawable.tag_other_checkbox_layout);

            public C0083O000000o(View view) {
                super(view);
                view.findViewById(R.id.root_item).setOnClickListener(new View.OnClickListener(O000000o.this) {
                    /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechSettingActivity.O000000o.C0083O000000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        C0083O000000o.this.f9504O000000o.setChecked(!C0083O000000o.this.f9504O000000o.isChecked());
                    }
                });
                this.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.icon);
                this.f9504O000000o = (CheckBox) view.findViewById(R.id.select_check);
                this.O00000Oo = (TextView) view.findViewById(R.id.title);
                this.O00000oo = (TextView) view.findViewById(R.id.room);
                this.O00000oo.setVisibility(8);
                this.O0000O0o = view.findViewById(R.id.divider_item);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0083O000000o(LayoutInflater.from(XiaoAiSpeechSettingActivity.this.getApplicationContext()).inflate((int) R.layout.item_device_icon_select, viewGroup, false));
        }
    }

    public void onBackPressed() {
        O000000o o000000o = this.mAdapter;
        if (o000000o != null) {
            o000000o.O000000o();
        }
        super.onBackPressed();
    }
}
