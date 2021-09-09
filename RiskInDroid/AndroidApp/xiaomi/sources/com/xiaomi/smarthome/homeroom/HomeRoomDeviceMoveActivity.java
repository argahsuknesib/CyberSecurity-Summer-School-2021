package com.xiaomi.smarthome.homeroom;

import _m_j.eza;
import _m_j.ezc;
import _m_j.fno;
import _m_j.fso;
import _m_j.ft;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.haf;
import _m_j.hxi;
import _m_j.hxp;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.HomeRoomDeviceMoveActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.HomeListDialogHelper;
import java.util.ArrayList;
import java.util.List;

public class HomeRoomDeviceMoveActivity extends BaseActivity {
    public static String KEY_CHECKED_DIDS = "key_checked_dids";
    public static String KEY_FILTER_ROOM_ID = "key_filter_room_id";
    public static String KEY_TRANSFER_ROOM_NAME = "key_transfer_room_name";

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f8882O000000o;
    private O0000O0o O00000Oo;
    private ArrayList<String> O00000o;
    private Dialog O00000o0;
    private boolean O00000oO = false;
    private BroadcastReceiver O00000oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.homeroom.HomeRoomDeviceMoveActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            HomeRoomDeviceMoveActivity.this.refresh();
        }
    };
    private String O0000O0o;
    @BindView(5357)
    ImageView mBack;
    public String mFilterRoomID;
    @BindView(5776)
    LinearLayout mGroupTitle;
    public String mHomeId;
    @BindView(5047)
    ListView mListView;
    @BindView(5309)
    View mMaskView;
    @BindView(5174)
    ImageView mMenuIcom;
    @BindView(5361)
    TextView mTitle;
    @BindView(5760)
    FrameLayout mTitleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_room_device_move);
        ButterKnife.bind(this);
        this.mHomeId = ggb.O00000Oo().O0000OOo();
        if (TextUtils.isEmpty(this.mHomeId)) {
            finish();
            return;
        }
        Intent intent = getIntent();
        this.O00000o = intent.getStringArrayListExtra(KEY_CHECKED_DIDS);
        ArrayList<String> arrayList = this.O00000o;
        if (arrayList == null || arrayList.isEmpty()) {
            finish();
            return;
        }
        this.mFilterRoomID = intent.getStringExtra(KEY_FILTER_ROOM_ID);
        Home O00000o2 = ggb.O00000Oo().O00000o(this.mHomeId);
        if (O00000o2 == null) {
            finish();
        } else {
            findViewById(R.id.title_bar).setBackgroundColor(getResources().getColor(R.color.mj_color_white));
            TextView textView = this.mTitle;
            ggb.O00000Oo();
            textView.setText(ggb.O000000o(O00000o2));
            this.mBack.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomDeviceMoveActivity$IVqqbl4g_afslAKMkSvgSyWuoKw */

                public final void onClick(View view) {
                    HomeRoomDeviceMoveActivity.this.O00000o0(view);
                }
            });
            this.mMenuIcom.setVisibility(0);
            this.mGroupTitle.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomDeviceMoveActivity$vRwCRsnwrwdE2QMXASg9_8yPDOM */

                public final void onClick(View view) {
                    HomeRoomDeviceMoveActivity.this.O00000Oo(view);
                }
            });
            View inflate = LayoutInflater.from(this).inflate((int) R.layout.item_home_room_device_move_footer, (ViewGroup) null);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomDeviceMoveActivity$IyBNGc7HOa5itD8cK02G3hwbtM */

                public final void onClick(View view) {
                    HomeRoomDeviceMoveActivity.this.O000000o(view);
                }
            });
            this.f8882O000000o = (TextView) inflate.findViewById(R.id.footer_tv);
            this.mListView.addFooterView(inflate);
            this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomDeviceMoveActivity$7nGZggbyJBCAppHXqZtVUrhJTUs */

                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    HomeRoomDeviceMoveActivity.this.O000000o(adapterView, view, i, j);
                }
            });
            this.O00000Oo = new O0000O0o(this, ggb.O00000Oo().O000000o(this.mHomeId));
            this.mListView.setAdapter((ListAdapter) this.O00000Oo);
            refresh();
        }
        ft.O000000o(this).O000000o(this.O00000oo, new IntentFilter("home_room_updated"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        Home O00000o2 = ggb.O00000Oo().O00000o(this.mHomeId);
        if (O00000o2 != null) {
            hxi.O00000o.f952O000000o.O000000o("room_movedevice_newroom", new Object[0]);
            O000000o(new O00000o0(O00000o2), this.O00000o);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(AdapterView adapterView, View view, int i, long j) {
        Home O00000o2;
        Room room = (Room) adapterView.getAdapter().getItem(i);
        if (room != null && !TextUtils.equals(room.getId(), this.mFilterRoomID) && (O00000o2 = ggb.O00000Oo().O00000o(this.mHomeId)) != null) {
            hxi.O00000o.f952O000000o.O000000o("room_movedevice_clickroom", "type", Integer.valueOf(TextUtils.equals(O00000o2.getId(), ggb.O00000Oo().O0000OOo()) ? 1 : 0));
            String string = room == null ? getString(R.string.default_room) : room.getName();
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            String string2 = getString(R.string.move_room_desc);
            ggb.O00000Oo();
            this.O00000o0 = builder.O00000Oo(String.format(string2, ggb.O000000o(O00000o2), string)).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(room, O00000o2) {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomDeviceMoveActivity$ciQMUSUBh661qeKQoASXayzGf9A */
                private final /* synthetic */ Room f$1;
                private final /* synthetic */ Home f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    HomeRoomDeviceMoveActivity.this.O000000o(this.f$1, this.f$2, dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
        }
    }

    public void refresh() {
        Home O00000o2;
        if (!TextUtils.isEmpty(this.mHomeId) && isValid() && (O00000o2 = ggb.O00000Oo().O00000o(this.mHomeId)) != null) {
            TextView textView = this.mTitle;
            ggb.O00000Oo();
            textView.setText(ggb.O000000o(O00000o2));
            this.O00000Oo.O000000o(ggb.O00000Oo().O000000o(this.mHomeId));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Room room, Home home, DialogInterface dialogInterface, int i) {
        if (room == null) {
            O000000o(new O00000Oo(home), this.O00000o);
        } else {
            O000000o(new O000000o(room), this.O00000o);
        }
    }

    private void O000000o(O00000o o00000o, List<String> list) {
        o00000o.O000000o(list);
        this.O00000oO = true;
    }

    class O00000o {
        /* access modifiers changed from: package-private */
        public void O000000o(List<String> list) {
        }

        O00000o() {
        }
    }

    class O00000Oo extends O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Home f8887O000000o;

        O00000Oo(Home home) {
            super();
            this.f8887O000000o = home;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(List<String> list) {
            if (this.f8887O000000o.getDids() == null || !this.f8887O000000o.getDids().containsAll(list)) {
                ggb.O00000Oo().O000000o(this.f8887O000000o, list, new ggb.O00000o() {
                    /* class com.xiaomi.smarthome.homeroom.HomeRoomDeviceMoveActivity.O00000Oo.AnonymousClass1 */

                    public final void O000000o() {
                        HomeRoomDeviceMoveActivity.this.onEditSuccess(HomeRoomDeviceMoveActivity.this.getString(R.string.default_room));
                        ggb.O00000Oo().O00000o0();
                    }

                    public final void O000000o(int i, fso fso) {
                        HomeRoomDeviceMoveActivity.this.onEditFail(i, fso);
                    }
                });
                return;
            }
            HomeRoomDeviceMoveActivity homeRoomDeviceMoveActivity = HomeRoomDeviceMoveActivity.this;
            homeRoomDeviceMoveActivity.onEditSuccess(homeRoomDeviceMoveActivity.getString(R.string.default_room));
        }
    }

    class O000000o extends O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Room f8885O000000o;

        O000000o(Room room) {
            super();
            this.f8885O000000o = room;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(List<String> list) {
            ggb.O00000Oo().O000000o(this.f8885O000000o, list, (List<String>) null, new ggb.O00000o() {
                /* class com.xiaomi.smarthome.homeroom.HomeRoomDeviceMoveActivity.O000000o.AnonymousClass1 */

                public final void O000000o() {
                    HomeRoomDeviceMoveActivity.this.onEditSuccess(O000000o.this.f8885O000000o.getName());
                    HomeRoomDeviceMoveActivity.this.refresh();
                }

                public final void O000000o(int i, fso fso) {
                    HomeRoomDeviceMoveActivity.this.onEditFail(i, fso);
                }
            });
        }
    }

    class O00000o0 extends O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Home f8889O000000o;

        O00000o0(Home home) {
            super();
            this.f8889O000000o = home;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(List<String> list) {
            haf.O000000o(this.f8889O000000o.getId(), HomeRoomDeviceMoveActivity.this, list, new haf.O000000o() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomDeviceMoveActivity$O00000o0$4aFRT1t3gXeVZU_MouWnmyEXDNA */

                public final void onSuccess(String str) {
                    HomeRoomDeviceMoveActivity.O00000o0.this.O000000o(str);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(String str) {
            HomeRoomDeviceMoveActivity.this.onEditSuccess(str);
            HomeRoomDeviceMoveActivity.this.refresh();
        }
    }

    public void onEditSuccess(String str) {
        this.O0000O0o = str;
        if (isValid()) {
            Device O000000o2 = fno.O000000o().O000000o(this.O00000o.get(0));
            if (O000000o2 == null) {
                gsy.O00000Oo(LogType.HOME_ROOM, "HomeRoomDeviceMoveActiv", "no device find,fail.");
                return;
            }
            if (this.O00000o.size() == 1) {
                gqg.O00000Oo(getString(R.string.move_single_device_to_room, new Object[]{O000000o2.getName(), str}));
            } else {
                gqg.O00000Oo(getString(R.string.move_multiple_devices_to_room, new Object[]{O000000o2.getName(), str}));
            }
            ft.O000000o(getContext()).O000000o(new Intent("action_device_move_to home_or_room"));
            onBackPressed();
        }
    }

    public void onEditFail(int i, fso fso) {
        if (isValid()) {
            if (fso == null || fso.f17063O000000o != -35) {
                gqg.O00000Oo((int) R.string.add_failed);
            } else {
                gqg.O00000Oo((int) R.string.name_repeat);
            }
        }
    }

    public void onResume() {
        hxp hxp = hxi.O00000o0;
        int count = this.O00000Oo.getCount();
        int O00000oo2 = ggb.O00000Oo().O00000oo();
        int size = this.O00000o.size();
        hxp.f957O000000o.O000000o("room_movedevice_show", "room_number", Integer.valueOf(count), "family_number", Integer.valueOf(O00000oo2), "device_number", Integer.valueOf(size));
        super.onResume();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void finish() {
        if (!this.O00000oO || TextUtils.isEmpty(this.O0000O0o)) {
            setResult(0);
        } else {
            Intent intent = new Intent();
            intent.putExtra(KEY_TRANSFER_ROOM_NAME, this.O0000O0o);
            setResult(-1, intent);
        }
        super.finish();
    }

    public void onDestroy() {
        super.onDestroy();
        Dialog dialog = this.O00000o0;
        if (dialog != null && dialog.isShowing()) {
            this.O00000o0.dismiss();
            this.O00000o0 = null;
        }
        this.mMaskView.clearAnimation();
        this.mMenuIcom.clearAnimation();
        ft.O000000o(this).O000000o(this.O00000oo);
    }

    public void doDropDownAnimation(boolean z) {
        this.mMenuIcom.animate().rotation(z ? -180.0f : 0.0f).setDuration(200).setInterpolator(new AccelerateDecelerateInterpolator());
        this.mMaskView.setVisibility(z ? 0 : 8);
        this.mMaskView.setAnimation(AnimationUtils.loadAnimation(CommonApplication.getAppContext(), z ? R.anim.dd_mask_in : R.anim.dd_mask_out));
    }

    class O0000O0o extends eza<Room> {
        public final int O000000o() {
            return R.layout.tag_child_item_sort_edit;
        }

        O0000O0o(Context context, List<Room> list) {
            super(context, list);
        }

        public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
            String str;
            Room room = (Room) this.O00000Oo.get(i);
            if (room != null) {
                TextView textView = (TextView) ezc.O000000o((int) R.id.title);
                TextView textView2 = (TextView) ezc.O000000o((int) R.id.desc);
                ezc.O000000o((int) R.id.next_btn).setVisibility(8);
                textView.setTextSize(2, 17.0f);
                if (TextUtils.equals(room.getId(), HomeRoomDeviceMoveActivity.this.mFilterRoomID)) {
                    str = room.getName() + HomeRoomDeviceMoveActivity.this.getString(R.string.inter_current);
                } else {
                    str = room.getName();
                }
                textView.setText(str);
                int O000000o2 = ggb.O00000Oo().O000000o(room);
                if (O000000o2 <= 1) {
                    textView2.setText(HomeRoomDeviceMoveActivity.this.getResources().getQuantityString(R.plurals.choose_device_device_count, O000000o2, Integer.valueOf(O000000o2)));
                } else {
                    textView2.setText(HomeRoomDeviceMoveActivity.this.getResources().getQuantityString(R.plurals.choose_device_device_counts, O000000o2, Integer.valueOf(O000000o2)));
                }
                float f = 0.3f;
                textView.setAlpha(TextUtils.equals(room.getId(), HomeRoomDeviceMoveActivity.this.mFilterRoomID) ? 0.3f : 1.0f);
                if (!TextUtils.equals(room.getId(), HomeRoomDeviceMoveActivity.this.mFilterRoomID)) {
                    f = 1.0f;
                }
                textView2.setAlpha(f);
                ezc.O000000o((int) R.id.root).setBackgroundResource(TextUtils.equals(room.getId(), HomeRoomDeviceMoveActivity.this.mFilterRoomID) ? R.color.mj_color_white : R.drawable.selector_list_item);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        doDropDownAnimation(true);
        HomeListDialogHelper.O000000o(this, this.mTitleBar, this.mHomeId, true, new HomeListDialogHelper.O000000o() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomDeviceMoveActivity.AnonymousClass2 */

            public final void O000000o() {
                HomeRoomDeviceMoveActivity.this.doDropDownAnimation(false);
            }

            public final void O000000o(Home home) {
                if (home != null && !TextUtils.isEmpty(home.getId())) {
                    HomeRoomDeviceMoveActivity.this.mHomeId = home.getId();
                    HomeRoomDeviceMoveActivity.this.refresh();
                }
            }
        });
        hxi.O00000o.f952O000000o.O000000o("room_movedevice_switchhome", new Object[0]);
    }
}
