package com.xiaomi.smarthome.mibrain.roomsetting;

import _m_j.fno;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.grk;
import _m_j.grl;
import _m_j.gsy;
import _m_j.gvr;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.Section;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.mibrain.roomsetting.model.XiaoAiVoiceCategory;
import com.xiaomi.smarthome.ui.DeviceBigHeaderView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class XiaoAiSpeechListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeviceBigHeaderView f9488O000000o;
    private TextView O00000Oo;
    private grl O00000o;
    private RecyclerView O00000o0;
    private View O00000oO;
    private XQProgressDialog O00000oo;
    public List<String> mDids;
    public Home mHome;
    public Room mRoom;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_xiaoai_speech_list_layout);
        this.f9488O000000o = (DeviceBigHeaderView) findViewById(R.id.device_big_header_view);
        this.O00000Oo = (TextView) findViewById(R.id.home_room_name_tv);
        this.O00000o0 = (RecyclerView) findViewById(R.id.recyclerview);
        this.O00000o0.setLayoutManager(new LinearLayoutManager(this));
        this.O00000o = new grl();
        this.O00000o0.setAdapter(this.O00000o);
        this.O00000oO = findViewById(R.id.multi_xiaoai_tips_tv);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.mi_brain_most_used_speech_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechListActivity.AnonymousClass1 */

            public final void onClick(View view) {
                XiaoAiSpeechListActivity.this.finish();
            }
        });
        String stringExtra = intent.getStringExtra("home_id");
        this.mHome = ggb.O00000Oo().O00000o(stringExtra);
        if (this.mHome == null) {
            LogType logType = LogType.GENERAL;
            gsy.O00000Oo(logType, "XiaoAiSpeechListActivity", "mHome is null for homeId=" + stringExtra + ", finish activity");
            finish();
            return;
        }
        this.mRoom = ggb.O00000Oo().O00000o0(intent.getStringExtra("room_id"));
        this.mDids = intent.getStringArrayListExtra("dids_list_id");
        if (this.mDids.size() > 0) {
            dismissProgressDialog();
            this.O00000oo = XQProgressDialog.O000000o(this, null, getString(R.string.mj_loading));
            gvr O000000o2 = gvr.O000000o();
            Room room = this.mRoom;
            String str = this.mDids.get(0);
            AnonymousClass2 r2 = new fsm<List<XiaoAiVoiceCategory>, fso>() {
                /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechListActivity.AnonymousClass2 */

                public final /* synthetic */ void onCache(Object obj) {
                    List list = (List) obj;
                    if (XiaoAiSpeechListActivity.this.isValid()) {
                        XiaoAiSpeechListActivity.this.dismissProgressDialog();
                        XiaoAiSpeechListActivity.this.populateSpeechData(list);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    if (XiaoAiSpeechListActivity.this.isValid()) {
                        XiaoAiSpeechListActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechListActivity.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                XiaoAiSpeechListActivity.this.dismissProgressDialog();
                            }
                        });
                        XiaoAiSpeechListActivity.this.populateSpeechData(list);
                    }
                }

                public final void onFailure(fso fso) {
                    if (XiaoAiSpeechListActivity.this.isValid()) {
                        XiaoAiSpeechListActivity.this.dismissProgressDialog();
                    }
                }
            };
            if (room == null || TextUtils.isEmpty(str)) {
                r2.onFailure(new fso(-1, "room and did cannot be empty"));
            } else {
                String id = room.getId();
                fru.O000000o().O00000Oo(id, str, new fsm<JSONObject, fso>(r2, id) {
                    /* class _m_j.gvr.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fsm f18388O000000o;
                    final /* synthetic */ String O00000Oo;

                    {
                        this.f18388O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject == null) {
                            try {
                                if (this.f18388O000000o != null) {
                                    this.f18388O000000o.onFailure(new fso(-1, "response is null or result is null"));
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        JSONArray optJSONArray = jSONObject.optJSONArray("result");
                        if (optJSONArray == null) {
                            fsm fsm = this.f18388O000000o;
                            if (fsm != null) {
                                fsm.onFailure(new fso(-1, "result cannot cast to JSONArray"));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                arrayList.add(XiaoAiVoiceCategory.O000000o(optJSONObject));
                            }
                        }
                        Room O00000o02 = ggb.O00000Oo().O00000o0(this.O00000Oo);
                        if (O00000o02 != null) {
                            gvr.this.O00000Oo.put(gvr.O000000o(O00000o02), arrayList);
                        }
                        fsm fsm2 = this.f18388O000000o;
                        if (fsm2 != null) {
                            fsm2.onSuccess(arrayList);
                        }
                    }

                    public final void onFailure(fso fso) {
                        fsm fsm = this.f18388O000000o;
                        if (fsm != null) {
                            fsm.onFailure(fso);
                        }
                    }
                });
                List list = O000000o2.O00000Oo.get(gvr.O000000o(room));
                if (list != null) {
                    r2.onCache(list);
                }
            }
        }
        O000000o();
    }

    private void O000000o() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mDids.size(); i++) {
            Device O000000o2 = fno.O000000o().O000000o(this.mDids.get(i));
            if (O000000o2 != null) {
                arrayList.add(new DeviceBigHeaderView.O000000o(O000000o2.model, O000000o2.name));
            }
        }
        this.f9488O000000o.setModel(arrayList);
        TextView textView = this.O00000Oo;
        StringBuilder sb = new StringBuilder();
        ggb.O00000Oo();
        sb.append(ggb.O000000o(this.mHome));
        sb.append(" | ");
        Room room = this.mRoom;
        sb.append(room == null ? getResources().getString(R.string.default_room) : room.getName());
        textView.setText(sb.toString());
        if (arrayList.size() > 1) {
            this.O00000oO.setVisibility(0);
        } else {
            this.O00000oO.setVisibility(8);
        }
    }

    public void populateSpeechData(List<XiaoAiVoiceCategory> list) {
        if (list != null) {
            this.O00000o.f18182O000000o.clear();
            this.O00000o.O000000o(new O000000o(list));
            this.O00000o.notifyDataSetChanged();
        }
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.O00000oo;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000oo.dismiss();
        }
    }

    class O000000o extends Section {
        private List<XiaoAiVoiceCategory> O00000Oo;

        public O000000o(List<XiaoAiVoiceCategory> list) {
            super(new grk.O000000o(R.layout.xiaoai_speech_list_item_section).O000000o(R.layout.xiaoai_list_setting_item_section_header).O000000o());
            this.O00000Oo = list;
        }

        public final int O000000o() {
            return this.O00000Oo.size();
        }

        public final RecyclerView.O000OOo0 O000000o(View view) {
            return new O00000Oo(view);
        }

        public final RecyclerView.O000OOo0 O00000Oo(View view) {
            return new C0082O000000o(view);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
            r8 = r6.O00000Oo.get(r8);
         */
        public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            final XiaoAiVoiceCategory xiaoAiVoiceCategory;
            List<String> list;
            if (i >= 0 && i < this.O00000Oo.size() && (list = xiaoAiVoiceCategory.O00000o0) != null) {
                C0082O000000o o000000o = (C0082O000000o) o000OOo0;
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    sb.append("“" + list.get(i2) + "”");
                    if (i2 < list.size() - 1) {
                        sb.append("、");
                    }
                }
                o000000o.f9494O000000o.setText(sb.toString());
                o000OOo0.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechListActivity.O000000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        Intent intent = new Intent(XiaoAiSpeechListActivity.this, XiaoAiSpeechSettingActivity.class);
                        intent.putExtra("home_id", XiaoAiSpeechListActivity.this.mHome.getId());
                        intent.putExtra("room_id", XiaoAiSpeechListActivity.this.mRoom == null ? "" : XiaoAiSpeechListActivity.this.mRoom.getId());
                        intent.putExtra("intent_id", xiaoAiVoiceCategory.f9513O000000o);
                        intent.putStringArrayListExtra("dids_list_id", (ArrayList) XiaoAiSpeechListActivity.this.mDids);
                        XiaoAiSpeechListActivity.this.startActivity(intent);
                    }
                });
            }
        }

        class O00000Oo extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9495O000000o;

            public O00000Oo(View view) {
                super(view);
                this.f9495O000000o = (TextView) view.findViewById(R.id.name_tv);
                this.f9495O000000o.setText((int) R.string.mi_brain_select_follow_xiaoai_to_control);
            }
        }

        /* renamed from: com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiSpeechListActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0082O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9494O000000o;

            public C0082O000000o(View view) {
                super(view);
                this.f9494O000000o = (TextView) view.findViewById(R.id.speech_tv);
            }
        }
    }
}
