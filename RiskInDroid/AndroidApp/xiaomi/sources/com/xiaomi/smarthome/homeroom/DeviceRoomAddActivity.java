package com.xiaomi.smarthome.homeroom;

import _m_j.fso;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.haf;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;

public class DeviceRoomAddActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private PullDownDragListView f8822O000000o;
    private Room O00000Oo;
    private String O00000o0;
    public O000000o mAdapter;
    public Room mCheckedRoom;
    public Room mDefaultRoom = new Room();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.PullDownDragListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000o0 = getIntent().getStringExtra("did");
        if (TextUtils.isEmpty(this.O00000o0)) {
            finish();
            gsy.O000000o(LogType.HOME_ROOM, "", "ABC: did null!");
            return;
        }
        setContentView((int) R.layout.activity_device_room_add);
        this.f8822O000000o = (PullDownDragListView) findViewById(R.id.room_list);
        this.f8822O000000o.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.f8822O000000o, false));
        this.f8822O000000o.O00000Oo();
        this.f8822O000000o.setCanPullDown(false);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.room_loc_title);
        findViewById(R.id.module_a_3_right_img_btn).setEnabled(true);
        ((ImageView) findViewById(R.id.module_a_3_right_img_btn)).setImageResource(R.drawable.title_right_tick_drawable);
        findViewById(R.id.module_a_3_right_img_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DeviceRoomAddActivity.this.onConfirm();
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.AnonymousClass2 */

            public final void onClick(View view) {
                DeviceRoomAddActivity.this.finish();
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.AnonymousClass3 */

            public final void onClick(View view) {
                haf.O000000o(DeviceRoomAddActivity.this, new ArrayList(), new haf.O000000o() {
                    /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.AnonymousClass3.AnonymousClass1 */

                    public final void onSuccess(String str) {
                        if (DeviceRoomAddActivity.this.mAdapter != null && DeviceRoomAddActivity.this.isValid()) {
                            DeviceRoomAddActivity.this.mAdapter.O000000o();
                            DeviceRoomAddActivity.this.mAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        });
        this.mAdapter = new O000000o();
        this.f8822O000000o.setAdapter((ListAdapter) this.mAdapter);
        this.O00000Oo = ggb.O00000Oo().O0000o00(this.O00000o0);
        if (this.O00000Oo == null) {
            this.O00000Oo = this.mDefaultRoom;
        }
        this.mCheckedRoom = this.O00000Oo;
        ggb.O00000Oo().O00000o0();
    }

    public void onConfirm() {
        if (this.mCheckedRoom == this.O00000Oo) {
            finish();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.O00000o0);
        ArrayList arrayList2 = new ArrayList();
        Room room = this.mCheckedRoom;
        if (room == this.mDefaultRoom) {
            room = this.O00000Oo;
            arrayList.clear();
            arrayList2.add(this.O00000o0);
        }
        if (!ggb.O0000oO(room.getName())) {
            gqg.O00000Oo((int) R.string.room_name_too_long);
        } else {
            ggb.O00000Oo().O000000o(room, arrayList, arrayList2, new ggb.O00000o() {
                /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.AnonymousClass4 */

                public final void O000000o() {
                    DeviceRoomAddActivity.this.finish();
                }

                public final void O000000o(int i, fso fso) {
                    if (fso == null || fso.f17063O000000o != -35) {
                        gqg.O00000Oo((int) R.string.add_failed);
                    } else {
                        gqg.O00000Oo((int) R.string.name_repeat);
                    }
                }
            });
        }
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<Room> f8828O000000o;

        public final long getItemId(int i) {
            return 0;
        }

        public O000000o() {
            O000000o();
        }

        public final void O000000o() {
            List<Room> O00000o = ggb.O00000Oo().O00000o();
            if (O00000o == null) {
                O00000o = new ArrayList<>();
            }
            this.f8828O000000o = O00000o;
        }

        public final int getCount() {
            return this.f8828O000000o.size() + 1;
        }

        public final Object getItem(int i) {
            if (i < 0 || i > this.f8828O000000o.size()) {
                return null;
            }
            if (i == this.f8828O000000o.size()) {
                return DeviceRoomAddActivity.this.mDefaultRoom;
            }
            return this.f8828O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            final C0074O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(DeviceRoomAddActivity.this).inflate((int) R.layout.room_child_item_select_edit, viewGroup, false);
                o000000o = new C0074O000000o(this, (byte) 0);
                view.setTag(o000000o);
                o000000o.f8834O000000o = (CheckBox) view.findViewById(R.id.select_checkbox);
                o000000o.O00000Oo = (TextView) view.findViewById(R.id.tv_title);
                o000000o.O00000o0 = view.findViewById(R.id.sort_icon);
                o000000o.O00000o = view.findViewById(R.id.divider_item);
                o000000o.O00000oO = view.findViewById(R.id.delete_btn);
            } else {
                o000000o = (C0074O000000o) view.getTag();
            }
            final Room room = (Room) getItem(i);
            if (i == getCount() - 1) {
                o000000o.O00000Oo.setText((int) R.string.tag_recommend_defaultroom);
                o000000o.O00000oO.setEnabled(false);
                o000000o.f8834O000000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.O000000o.AnonymousClass1 */

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            DeviceRoomAddActivity.this.mCheckedRoom = DeviceRoomAddActivity.this.mDefaultRoom;
                        }
                        O000000o.this.notifyDataSetChanged();
                    }
                });
            } else {
                o000000o.O00000Oo.setText(room.getName());
                o000000o.f8834O000000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.O000000o.AnonymousClass2 */

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            DeviceRoomAddActivity.this.mCheckedRoom = room;
                        }
                        O000000o.this.notifyDataSetChanged();
                    }
                });
                if (ggb.O00000Oo().O000000o(room) > 0) {
                    o000000o.O00000oO.setEnabled(false);
                } else {
                    o000000o.O00000oO.setEnabled(true);
                }
                o000000o.O00000oO.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.O000000o.AnonymousClass3 */

                    public final void onClick(View view) {
                        new MLAlertDialog.Builder(o000000o.O00000oO.getContext()).O000000o(String.format(o000000o.O00000oO.getContext().getString(R.string.tag_remove_confirm), room.getName())).O000000o((int) R.string.tag_remove, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.O000000o.AnonymousClass3.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ggb.O00000Oo().O000000o(room, new ggb.O00000o() {
                                    /* class com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity.O000000o.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                    public final void O000000o() {
                                        O000000o.this.f8828O000000o.remove(room);
                                        O000000o.this.notifyDataSetChanged();
                                    }

                                    public final void O000000o(int i, fso fso) {
                                        gqg.O00000Oo((int) R.string.room_delete_failed);
                                    }
                                });
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o(o000000o.O00000oO.getContext().getResources().getColor(R.color.mj_color_red_normal), -1).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
                    }
                });
            }
            o000000o.O00000o.setVisibility(i == getCount() - 1 ? 8 : 0);
            if (TextUtils.equals(room.getId(), DeviceRoomAddActivity.this.mCheckedRoom.getId())) {
                o000000o.f8834O000000o.setChecked(true);
            } else {
                o000000o.f8834O000000o.setChecked(false);
            }
            return view;
        }

        /* renamed from: com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0074O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public CheckBox f8834O000000o;
            public TextView O00000Oo;
            public View O00000o;
            public View O00000o0;
            public View O00000oO;

            private C0074O000000o() {
            }

            /* synthetic */ C0074O000000o(O000000o o000000o, byte b) {
                this();
            }
        }
    }
}
