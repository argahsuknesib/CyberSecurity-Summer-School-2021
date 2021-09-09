package com.xiaomi.smarthome.mibrain.roomsetting;

import _m_j.fh;
import _m_j.fno;
import _m_j.fo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.grk;
import _m_j.grl;
import _m_j.gsy;
import _m_j.gvr;
import _m_j.gvs;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.Section;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XiaoAiListActivity extends BaseActivity {
    public static final String TAG = "XiaoAiListActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    private View f9478O000000o;
    private RecyclerView O00000Oo;
    private XQProgressDialog O00000o;
    private grl O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_xiaoai_list_layout);
        this.f9478O000000o = findViewById(R.id.common_white_empty_view);
        ((ImageView) this.f9478O000000o.findViewById(R.id.empty_icon)).setImageResource(R.drawable.emptypage_icon_nodevice_nor_1);
        ((TextView) this.f9478O000000o.findViewById(R.id.common_white_empty_text)).setText((int) R.string.no_xiaoai_at_home);
        this.O00000Oo = (RecyclerView) findViewById(R.id.recyclerview);
        this.O00000Oo.setLayoutManager(new LinearLayoutManager(this));
        this.O00000o0 = new grl();
        this.O00000Oo.setAdapter(this.O00000o0);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.voice_control_room_shortcut_instruction);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity.AnonymousClass1 */

            public final void onClick(View view) {
                XiaoAiListActivity.this.finish();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.module_a_3_right_iv_setting_btn);
        imageView.setContentDescription(getString(R.string.menu_edit_more));
        imageView.setImageResource(R.drawable.title_right_info_drawable);
        imageView.setVisibility(0);
        imageView.setContentDescription(getString(R.string.voice_control_room_shortcut_instruction_i));
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity.AnonymousClass2 */

            public final void onClick(View view) {
                XiaoAiListActivity xiaoAiListActivity = XiaoAiListActivity.this;
                xiaoAiListActivity.startActivity(new Intent(xiaoAiListActivity, XiaoAiTutorialActivity.class));
            }
        });
        ((gvs) fo.O000000o(this).O000000o(gvs.class)).f18385O000000o.observe(this, new fh<gvs.O000000o>() {
            /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity.AnonymousClass3 */

            public final /* synthetic */ void onChanged(Object obj) {
                XiaoAiListActivity.this.populateData((gvs.O000000o) obj);
                XiaoAiListActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        XiaoAiListActivity.this.dismissProgressDialog();
                    }
                });
            }
        });
        dismissProgressDialog();
        this.O00000o = XQProgressDialog.O000000o(this, null, getString(R.string.mj_loading));
        gvr O000000o2 = gvr.O000000o();
        gvs.AnonymousClass1 r2 = new fsm<List<String>, fso>() {
            /* class _m_j.gvs.AnonymousClass1 */

            public final /* synthetic */ void onCache(Object obj) {
                List list = (List) obj;
                if (list != null) {
                    gvs.this.f18385O000000o.postValue(new O000000o(ErrorCode.SUCCESS_CACHE.getCode(), list));
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gvs.this.f18385O000000o.postValue(new O000000o(ErrorCode.SUCCESS.getCode(), (List) obj));
            }

            public final void onFailure(fso fso) {
                gvs.this.f18385O000000o.postValue(new O000000o(fso.f17063O000000o, null));
            }
        };
        if (!O000000o2.f18386O000000o.isEmpty()) {
            r2.onCache(O000000o2.f18386O000000o);
        }
        gvr.O000000o(r2);
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("show_guide", false)) {
            startActivity(new Intent(this, XiaoAiTutorialActivity.class));
        }
    }

    public void populateData(gvs.O000000o o000000o) {
        if (o000000o != null && o000000o.O00000o0 != null) {
            this.O00000o0.f18182O000000o.clear();
            for (Map.Entry next : o000000o.O00000o0.entrySet()) {
                Home O00000o2 = ggb.O00000Oo().O00000o((String) next.getKey());
                if (O00000o2 != null) {
                    this.O00000o0.O000000o(new O000000o(O00000o2, (Map) next.getValue()));
                }
            }
            if (this.O00000o0.getItemCount() == 0) {
                this.f9478O000000o.setVisibility(0);
                this.O00000Oo.setVisibility(8);
                return;
            }
            this.f9478O000000o.setVisibility(8);
            this.O00000Oo.setVisibility(0);
            this.O00000o0.notifyDataSetChanged();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1001 == i && i2 != 0) {
            String stringExtra = intent.getStringExtra("room_id");
            gotoXiaoAiSpeechListActivity(ggb.O00000Oo().O00000o0(stringExtra), intent.getStringArrayListExtra("device_list_id"));
            finish();
        }
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.O00000o;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000o.dismiss();
        }
    }

    public void gotoXiaoAiSpeechListActivity(Room room, ArrayList<String> arrayList) {
        if (room != null) {
            Intent intent = new Intent(this, XiaoAiSpeechListActivity.class);
            intent.putExtra("home_id", room.getParentid());
            intent.putExtra("room_id", room.getId());
            intent.putStringArrayListExtra("dids_list_id", arrayList);
            startActivity(intent);
        }
    }

    class O000000o extends Section {
        private Map<String, List<String>> O00000Oo;
        private Home O00000o0;
        private String[] O0000o0;
        private String[] O0000o0O;

        public O000000o(Home home, Map<String, List<String>> map) {
            super(new grk.O000000o(R.layout.xiaoai_list_setting_item_section).O000000o(R.layout.xiaoai_list_setting_item_section_header).O000000o());
            this.O00000Oo = map == null ? new HashMap<>() : map;
            String[] strArr = map == null ? new String[0] : (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                List list = this.O00000Oo.get(str);
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                } else if (list != null && this.O0000o0O == null) {
                    this.O0000o0O = (String[]) list.toArray(new String[0]);
                }
            }
            this.O0000o0 = (String[]) arrayList.toArray(new String[0]);
            this.O00000o0 = home;
        }

        public final int O000000o() {
            int length = this.O0000o0.length;
            String[] strArr = this.O0000o0O;
            return length + (strArr == null ? 0 : strArr.length);
        }

        public final RecyclerView.O000OOo0 O000000o(View view) {
            return new O00000Oo(view);
        }

        public final RecyclerView.O000OOo0 O00000Oo(View view) {
            return new C0081O000000o(view);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            final String str;
            String str2;
            if (i >= 0) {
                String[] strArr = this.O0000o0;
                final List list = null;
                String str3 = "";
                if (i < strArr.length) {
                    str3 = strArr[i];
                    list = this.O00000Oo.get(str3);
                    str = null;
                } else {
                    int length = strArr.length;
                    String[] strArr2 = this.O0000o0O;
                    str = i < length + (strArr2 == null ? 0 : strArr2.length) ? this.O0000o0O[i - this.O0000o0.length] : null;
                }
                final Room O00000o02 = ggb.O00000Oo().O00000o0(str3);
                if (O00000o02 == null) {
                    str2 = o000OOo0.itemView.getResources().getString(R.string.room_not_set);
                } else {
                    str2 = O00000o02.getName();
                }
                C0081O000000o o000000o = (C0081O000000o) o000OOo0;
                o000000o.O00000Oo.setText(str2);
                if (list == null || list.isEmpty()) {
                    if (!TextUtils.isEmpty(str)) {
                        Device O000000o2 = fno.O000000o().O000000o(str);
                        if (O000000o2 != null) {
                            o000000o.f9486O000000o.setText(O000000o2.getName());
                        }
                    } else {
                        o000000o.f9486O000000o.setText((int) R.string.tag_no_device);
                        gsy.O00000Oo(LogType.GENERAL, XiaoAiListActivity.TAG, "XiaoAiSection no device 1:".concat(String.valueOf(str)));
                    }
                } else if (list.size() == 1) {
                    Device O000000o3 = fno.O000000o().O000000o((String) list.get(0));
                    if (O000000o3 == null) {
                        gsy.O00000Oo(LogType.GENERAL, XiaoAiListActivity.TAG, "XiaoAiSection no device 2:" + ((String) list.get(0)));
                        o000000o.f9486O000000o.setText((int) R.string.tag_no_device);
                    } else {
                        o000000o.f9486O000000o.setText(O000000o3.getName());
                    }
                } else {
                    o000000o.f9486O000000o.setText(o000000o.f9486O000000o.getResources().getQuantityString(R.plurals.room_xiaoai_count, list.size(), Integer.valueOf(list.size())));
                }
                o000000o.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity.O000000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        if (O00000o02 != null) {
                            XiaoAiListActivity.this.gotoXiaoAiSpeechListActivity(O00000o02, (ArrayList) list);
                        } else if (TextUtils.isEmpty(str)) {
                            gsy.O000000o(3, XiaoAiListActivity.TAG, "empty did list for xiaoai");
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(str);
                            O000000o o000000o = O000000o.this;
                            new MLAlertDialog.Builder(XiaoAiListActivity.this).O00000Oo((int) R.string.select_a_room_for_xiaoai).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.setting, new DialogInterface.OnClickListener(arrayList) {
                                /* class com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity.O000000o.AnonymousClass2 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ List f9485O000000o;

                                {
                                    this.f9485O000000o = r2;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    Home O0000o0 = ggb.O00000Oo().O0000o0((String) this.f9485O000000o.get(0));
                                    if (O0000o0 != null) {
                                        SetDeviceRoomActivity.startActivity(XiaoAiListActivity.this, O0000o0.getId(), (ArrayList) this.f9485O000000o, 1001);
                                    }
                                    dialogInterface.dismiss();
                                }
                            }).O00000oo();
                        }
                    }
                });
            }
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
            TextView textView = ((O00000Oo) o000OOo0).f9487O000000o;
            ggb.O00000Oo();
            textView.setText(ggb.O000000o(this.O00000o0));
        }

        class O00000Oo extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9487O000000o;

            public O00000Oo(View view) {
                super(view);
                this.f9487O000000o = (TextView) view.findViewById(R.id.name_tv);
            }
        }

        /* renamed from: com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0081O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9486O000000o;
            TextView O00000Oo;

            public C0081O000000o(View view) {
                super(view);
                this.f9486O000000o = (TextView) view.findViewById(R.id.device_cnt_tv);
                this.O00000Oo = (TextView) view.findViewById(R.id.room_name_tv);
            }
        }
    }
}
