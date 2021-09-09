package com.xiaomi.smarthome.homeroom;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gfz;
import _m_j.gzl;
import _m_j.hbo;
import _m_j.hft;
import _m_j.hxi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.newui.adapter.DviceEditInterface;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeDefaultRoomDeviceTransferGuide extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private RecyclerView f8839O000000o;
    public boolean currentIsSelectAll = false;
    public O000000o mCheckedModeAdapter;
    public TextView mConfirmBtn;
    public ImageView mSelectAllBtn;

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeDefaultRoomDeviceTransferGuide.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_default_room_device_transfer_guide);
        findViewById(R.id.container);
        this.mSelectAllBtn = (ImageView) findViewById(R.id.module_a_3_right_iv_setting_btn);
        this.mSelectAllBtn.setVisibility(0);
        this.mSelectAllBtn.setImageResource(R.drawable.all_select_selector);
        this.mSelectAllBtn.setContentDescription(getString(R.string.select_all));
        this.mSelectAllBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeDefaultRoomDeviceTransferGuide.AnonymousClass1 */

            public final void onClick(View view) {
                int i;
                HomeDefaultRoomDeviceTransferGuide homeDefaultRoomDeviceTransferGuide;
                boolean z = !HomeDefaultRoomDeviceTransferGuide.this.currentIsSelectAll;
                HomeDefaultRoomDeviceTransferGuide.this.mCheckedModeAdapter.a_(z);
                HomeDefaultRoomDeviceTransferGuide.this.mCheckedModeAdapter.notifyDataSetChanged();
                HomeDefaultRoomDeviceTransferGuide.this.mSelectAllBtn.setImageResource(z ? R.drawable.un_select_selector : R.drawable.all_select_selector);
                ImageView imageView = HomeDefaultRoomDeviceTransferGuide.this.mSelectAllBtn;
                if (z) {
                    homeDefaultRoomDeviceTransferGuide = HomeDefaultRoomDeviceTransferGuide.this;
                    i = R.string.unselect_all;
                } else {
                    homeDefaultRoomDeviceTransferGuide = HomeDefaultRoomDeviceTransferGuide.this;
                    i = R.string.select_all;
                }
                imageView.setContentDescription(homeDefaultRoomDeviceTransferGuide.getString(i));
                HomeDefaultRoomDeviceTransferGuide.this.currentIsSelectAll = z;
                hxi.O00000o.f952O000000o.O000000o("room_addroom_all", "type", Integer.valueOf(z ? 1 : 0));
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeDefaultRoomDeviceTransferGuide$7vRsHo2IRwkDv3IPmm6sIsGVyGY */

            public final void onClick(View view) {
                HomeDefaultRoomDeviceTransferGuide.this.O000000o(view);
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.assign_room);
        this.mConfirmBtn = (TextView) findViewById(R.id.confirm);
        this.mConfirmBtn.setEnabled(false);
        this.mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeDefaultRoomDeviceTransferGuide.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
             arg types: [java.lang.String, java.util.ArrayList]
             candidates:
              _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
              _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
            public final void onClick(View view) {
                List<String> O0000Oo0 = HomeDefaultRoomDeviceTransferGuide.this.mCheckedModeAdapter.O0000Oo0();
                if (!O0000Oo0.isEmpty()) {
                    fbt fbt = new fbt(HomeDefaultRoomDeviceTransferGuide.this.getContext(), "HomeRoomDeviceMoveActivity");
                    fbt.O000000o(955);
                    fbt.O000000o("key_checked_dids", (Serializable) new ArrayList(O0000Oo0));
                    fbt.O000000o("key_filter_room_id", "mijia.roomid.default");
                    fbs.O000000o(fbt);
                    hxi.O00000o.f952O000000o.O000000o("room_addroom_set", new Object[0]);
                }
            }
        });
        this.f8839O000000o = (RecyclerView) findViewById(R.id.recycler);
        this.f8839O000000o.setLayoutManager(new GridLayoutManager(this) {
            /* class com.xiaomi.smarthome.homeroom.HomeDefaultRoomDeviceTransferGuide.AnonymousClass3 */

            public final boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        gzl gzl = new gzl();
        this.mCheckedModeAdapter = new O000000o();
        gzl.O000000o(this.mCheckedModeAdapter);
        gzl.O00000Oo(new hbo());
        this.f8839O000000o.setAdapter(gzl);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }

    public void onResume() {
        super.onResume();
        PageBean O00000o0 = PageBean.O00000o0();
        this.mCheckedModeAdapter.O000000o(O00000o0, O000000o(gfz.f17670O000000o.O000000o(O00000o0)));
        updateConfirmButtonDesc();
        hxi.O00000o0.f957O000000o.O000000o("room_addroom_show", new Object[0]);
    }

    private static List<MainPageDeviceModel> O000000o(List<Device> list) {
        ArrayList arrayList = new ArrayList();
        for (Device O000000o2 : list) {
            MainPageDeviceModel O000000o3 = MainPageDeviceModel.O000000o(O000000o2);
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        return arrayList;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 955 && intent != null) {
            PageBean O00000o0 = PageBean.O00000o0();
            List<Device> O000000o2 = gfz.f17670O000000o.O000000o(O00000o0);
            if (O000000o2.isEmpty()) {
                finish();
                return;
            }
            this.mCheckedModeAdapter.O0000Oo0().clear();
            this.mConfirmBtn.setEnabled(false);
            this.currentIsSelectAll = false;
            this.mSelectAllBtn.setImageResource(R.drawable.all_select_selector);
            this.mSelectAllBtn.setContentDescription(getString(R.string.select_all));
            this.mCheckedModeAdapter.O000000o(O00000o0, O000000o(O000000o2));
            this.f8839O000000o.post(new Runnable() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeDefaultRoomDeviceTransferGuide$V5ryUetw21R7s95RHGysbCsn0qI */

                public final void run() {
                    HomeDefaultRoomDeviceTransferGuide.this.O000000o();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        this.mCheckedModeAdapter.notifyDataSetChanged();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    class O000000o extends hft {
        public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
            return 0;
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final boolean O00000o0() {
            return false;
        }

        public O000000o() {
        }

        public final void O000000o(String str, boolean z) {
            HomeDefaultRoomDeviceTransferGuide homeDefaultRoomDeviceTransferGuide;
            int i;
            super.O000000o(str, z);
            boolean z2 = true;
            HomeDefaultRoomDeviceTransferGuide.this.currentIsSelectAll = O0000Oo0().size() == getItemCount();
            HomeDefaultRoomDeviceTransferGuide.this.mSelectAllBtn.setImageResource(HomeDefaultRoomDeviceTransferGuide.this.currentIsSelectAll ? R.drawable.un_select_selector : R.drawable.all_select_selector);
            ImageView imageView = HomeDefaultRoomDeviceTransferGuide.this.mSelectAllBtn;
            if (HomeDefaultRoomDeviceTransferGuide.this.currentIsSelectAll) {
                homeDefaultRoomDeviceTransferGuide = HomeDefaultRoomDeviceTransferGuide.this;
                i = R.string.unselect_all;
            } else {
                homeDefaultRoomDeviceTransferGuide = HomeDefaultRoomDeviceTransferGuide.this;
                i = R.string.select_all;
            }
            imageView.setContentDescription(homeDefaultRoomDeviceTransferGuide.getString(i));
            TextView textView = HomeDefaultRoomDeviceTransferGuide.this.mConfirmBtn;
            if (O0000Oo0().size() == 0) {
                z2 = false;
            }
            textView.setEnabled(z2);
            HomeDefaultRoomDeviceTransferGuide.this.updateConfirmButtonDesc();
        }

        public final DviceEditInterface.HostPage O00000oO() {
            return DviceEditInterface.HostPage.TRANSFER_GUIDE_PAGE;
        }
    }

    public void updateConfirmButtonDesc() {
        int itemCount = this.mCheckedModeAdapter.getItemCount();
        int size = this.mCheckedModeAdapter.O0000Oo0().size();
        this.mConfirmBtn.setText(getString(R.string.assign_room) + "(" + size + "/" + itemCount + ")");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecyclerView.O000000o adapter = this.f8839O000000o.getAdapter();
        if (adapter instanceof gzl) {
            ((gzl) adapter).O000000o(this.f8839O000000o);
        }
    }
}
