package com.xiaomi.smarthome.miio.page.msgcentersetting;

import _m_j.fh;
import _m_j.fo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gxy;
import _m_j.gya;
import _m_j.hte;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hzf;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.family.api.MessageApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.newui.HomeListDialogHelper;
import java.util.ArrayList;
import java.util.List;

public class DevicePushSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private XQProgressDialog f9911O000000o;
    public Home currentHome;
    public gxy devicePushViewModel;
    public O00000o0 mAdapter;
    public List<gya> mList = new ArrayList();
    public int mMainSwitch = 3;
    @BindView(5372)
    View mMaskView;
    @BindView(5230)
    ImageView mMenuIcon;
    @BindView(5870)
    View mTitleGroup;
    @BindView(5422)
    ImageView moduleA3ReturnBtn;
    @BindView(5426)
    TextView moduleA3ReturnTitle;
    public String pageType;
    @BindView(5721)
    RecyclerView settingList;
    @BindView(5854)
    View titleBar;

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(DialogInterface dialogInterface) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_push_setting);
        ButterKnife.bind(this);
        this.pageType = getIntent().getStringExtra("device_push");
        if (TextUtils.isEmpty(this.pageType)) {
            finish();
            return;
        }
        this.currentHome = ggb.O00000Oo().O0000Oo0();
        if (this.currentHome == null) {
            finish();
            return;
        }
        this.devicePushViewModel = (gxy) fo.O000000o(this).O000000o(gxy.class);
        this.devicePushViewModel.f18385O000000o.observe(this, new fh() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.$$Lambda$DevicePushSettingActivity$hNjsqtV8WeVSWePdrbasbS3pWMA */

            public final void onChanged(Object obj) {
                DevicePushSettingActivity.this.O000000o((List) obj);
            }
        });
        this.settingList.setLayoutManager(new LinearLayoutManager(this));
        int i = 0;
        this.mAdapter = new O00000o0(this, (byte) 0);
        this.settingList.setAdapter(this.mAdapter);
        if (TextUtils.equals(this.pageType, "home_device")) {
            ImageView imageView = this.mMenuIcon;
            if (ggb.O00000Oo().O0000OoO.O00000Oo.size() <= 1) {
                i = 8;
            }
            imageView.setVisibility(i);
            TextView textView = this.moduleA3ReturnTitle;
            ggb.O00000Oo();
            textView.setText(ggb.O000000o(this.currentHome));
            this.mTitleGroup.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.page.msgcentersetting.$$Lambda$DevicePushSettingActivity$QEIdGpnUDyXg4b3aErySwYvRKmg */

                public final void onClick(View view) {
                    DevicePushSettingActivity.this.O00000Oo(view);
                }
            });
        } else {
            this.mMenuIcon.setVisibility(8);
            this.moduleA3ReturnTitle.setText((int) R.string.shared_device_room_name);
        }
        this.titleBar.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        this.mMenuIcon.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.$$Lambda$DevicePushSettingActivity$R9_LgLIWh2OMY90b9Cdd2wAV9eg */

            public final void onClick(View view) {
                DevicePushSettingActivity.this.O000000o(view);
            }
        });
        showProcessDialog();
        this.devicePushViewModel.O000000o(this.currentHome.getId(), TextUtils.equals(this.pageType, "share_device"));
    }

    @OnClick({5422})
    public void onClick(View view) {
        finish();
    }

    public void onBackPressed() {
        this.moduleA3ReturnBtn.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        if (this.mMenuIcon.getVisibility() == 0) {
            this.mMenuIcon.performClick();
        }
    }

    public void doDropDownAnimation(boolean z) {
        ImageView imageView;
        if (isValid() && (imageView = this.mMenuIcon) != null && this.mMaskView != null) {
            imageView.animate().rotation(z ? -180.0f : 0.0f).setDuration(200).setInterpolator(new AccelerateDecelerateInterpolator());
            this.mMaskView.setVisibility(z ? 0 : 8);
            this.mMaskView.setAnimation(AnimationUtils.loadAnimation(ServiceApplication.getAppContext(), z ? R.anim.dd_mask_in : R.anim.dd_mask_out));
        }
    }

    public void updateMipushSwitch(final gya gya) {
        boolean equals = TextUtils.equals(this.pageType, "share_device");
        ArrayList arrayList = new ArrayList();
        if (gya != null) {
            arrayList.add(gya);
            if (TextUtils.equals(this.pageType, "share_device")) {
                hxi.O00000o.f952O000000o.O000000o("notification_shareddevicenotification_singleswitch_click", "switch", Integer.valueOf(this.mMainSwitch < 3 ? 0 : 1), "model", gya.O00000oO);
            } else {
                hxi.O00000o.f952O000000o.O000000o("notification_familydevicenotification_singleswitch_click", "switch", Integer.valueOf(this.mMainSwitch < 3 ? 0 : 1), "model", gya.O00000oO);
            }
        } else {
            hxk hxk = hxi.O00000o;
            int i = this.mMainSwitch < 3 ? 0 : 1;
            List<gya> list = this.mList;
            hxk.f952O000000o.O000000o("notification_familydevicenotification_mainswitch_click", "switch", Integer.valueOf(i), "number", Integer.valueOf(list == null ? 0 : list.size()));
        }
        MessageApi.instance.setDevMsgSwitch(equals ? null : this.currentHome, this.mMainSwitch, arrayList, new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.DevicePushSettingActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
                if (DevicePushSettingActivity.this.isValid()) {
                    hte.O000000o(DevicePushSettingActivity.this, (int) R.string.home_set_failed);
                    if (DevicePushSettingActivity.this.mList != null && gya != null) {
                        if (DevicePushSettingActivity.this.mList.contains(gya)) {
                            gya gya = gya;
                            gya.O00000oo = Integer.valueOf(gya.O00000oo.intValue() == 0 ? 3 : 0);
                        }
                        DevicePushSettingActivity.this.mAdapter.notifyDataSetChanged();
                    }
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (DevicePushSettingActivity.this.isValid()) {
                    DevicePushSettingActivity.this.mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void showProcessDialog() {
        if (this.f9911O000000o == null) {
            this.f9911O000000o = new XQProgressDialog(this);
            this.f9911O000000o.setCancelable(false);
            this.f9911O000000o.setMessage(getResources().getString(R.string.loading_share_info));
            this.f9911O000000o.setCancelable(true);
            this.f9911O000000o.setOnDismissListener($$Lambda$DevicePushSettingActivity$8oYP_1DVTzBJykbqb0Ui_EIogVY.INSTANCE);
        }
        if (!this.f9911O000000o.isShowing()) {
            this.f9911O000000o.show();
        }
    }

    class O00000o0 extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O00000o0() {
        }

        /* synthetic */ O00000o0(DevicePushSettingActivity devicePushSettingActivity, byte b) {
            this();
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater from = LayoutInflater.from(DevicePushSettingActivity.this);
            if (i == 0) {
                return new O00000Oo(from.inflate((int) R.layout.item_msg_setting_system, (ViewGroup) null));
            }
            if (i != 2) {
                return null;
            }
            return new O000000o(from.inflate((int) R.layout.item_msg_setting_device, (ViewGroup) null));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            boolean z = true;
            int i2 = 0;
            if (o000OOo0 instanceof O00000Oo) {
                O00000Oo o00000Oo = (O00000Oo) o000OOo0;
                o00000Oo.f9916O000000o.setText((int) R.string.message_device_setting_title_v2);
                SwitchButton switchButton = o00000Oo.O00000Oo;
                if (DevicePushSettingActivity.this.mMainSwitch < 3) {
                    z = false;
                }
                switchButton.setChecked(z);
                o00000Oo.itemView.setOnClickListener(o00000Oo.O00000o0);
                o00000Oo.O00000Oo.setOnClickListener(o00000Oo.O00000o0);
            } else if (o000OOo0 instanceof O000000o) {
                O000000o o000000o = (O000000o) o000OOo0;
                if (TextUtils.equals(DevicePushSettingActivity.this.pageType, "home_device")) {
                    i--;
                }
                gya gya = DevicePushSettingActivity.this.mList.get(i);
                if (gya != null) {
                    o000000o.f9914O000000o.setText(gya.O00000o0);
                    if (gya.O00000oO != null) {
                        DeviceFactory.O00000Oo(gya.O00000oO, o000000o.O00000o);
                    } else {
                        o000000o.O00000o.setImageResource(R.drawable.device_list_phone_no);
                    }
                    if (gya.O00000oo.intValue() < 3) {
                        z = false;
                    }
                    o000000o.O00000o0.setChecked(z);
                    if (TextUtils.equals(DevicePushSettingActivity.this.pageType, "share_device")) {
                        o000000o.O00000Oo.setText((int) R.string.shared_device_room_name);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        ggb.O00000Oo();
                        sb.append(ggb.O000000o(DevicePushSettingActivity.this.currentHome));
                        Room O00000o0 = ggb.O00000Oo().O00000o0(gya.O00000o);
                        sb.append(" | ");
                        sb.append(O00000o0 == null ? DevicePushSettingActivity.this.getString(R.string.default_room) : O00000o0.getName());
                        o000000o.O00000Oo.setText(sb.toString().trim());
                        View view = o000000o.itemView;
                        if (DevicePushSettingActivity.this.mMainSwitch < 3) {
                            i2 = 8;
                        }
                        view.setVisibility(i2);
                    }
                    o000000o.itemView.setOnClickListener(o000000o.O00000oO);
                    o000000o.itemView.setTag(Integer.valueOf(i));
                }
            }
        }

        public final int getItemCount() {
            if (DevicePushSettingActivity.this.mList == null) {
                return 0;
            }
            if (TextUtils.equals(DevicePushSettingActivity.this.pageType, "share_device")) {
                if (DevicePushSettingActivity.this.mList == null) {
                    return 0;
                }
                return DevicePushSettingActivity.this.mList.size();
            } else if (!TextUtils.equals(DevicePushSettingActivity.this.pageType, "home_device")) {
                return 0;
            } else {
                if (DevicePushSettingActivity.this.mList == null) {
                    return 1;
                }
                return DevicePushSettingActivity.this.mList.size() + 1;
            }
        }

        public final int getItemViewType(int i) {
            int i2;
            if (DevicePushSettingActivity.this.mList == null) {
                return -1;
            }
            if (TextUtils.equals(DevicePushSettingActivity.this.pageType, "home_device")) {
                if (i == 0) {
                    return 0;
                }
                if (DevicePushSettingActivity.this.mList == null || i - 1 < 0 || i2 >= DevicePushSettingActivity.this.mList.size()) {
                    return -1;
                }
                return 2;
            } else if (TextUtils.equals(DevicePushSettingActivity.this.pageType, "share_device")) {
                return 2;
            }
            return -1;
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f9916O000000o;
        public SwitchButton O00000Oo;
        View.OnClickListener O00000o0 = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.DevicePushSettingActivity.O00000Oo.AnonymousClass1 */

            public final void onClick(View view) {
                O00000Oo.this.O00000Oo.setChecked(!O00000Oo.this.O00000Oo.isChecked());
                hzf.O000000o((CompoundButton) O00000Oo.this.O00000Oo);
                DevicePushSettingActivity.this.mMainSwitch = O00000Oo.this.O00000Oo.isChecked() ? 3 : 0;
                DevicePushSettingActivity.this.updateMipushSwitch(null);
            }
        };

        public O00000Oo(View view) {
            super(view);
            this.f9916O000000o = (TextView) view.findViewById(R.id.device_push_item_title);
            this.O00000Oo = (SwitchButton) view.findViewById(R.id.device_push_item_btn);
            this.O00000Oo.setOnTouchEnable(false);
        }
    }

    class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f9914O000000o;
        public TextView O00000Oo;
        public SimpleDraweeView O00000o;
        public SwitchButton O00000o0;
        View.OnClickListener O00000oO = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.DevicePushSettingActivity.O000000o.AnonymousClass1 */

            public final void onClick(View view) {
                int i;
                try {
                    i = ((Integer) view.getTag()).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    i = -1;
                }
                gya gya = null;
                if (i >= 0 && i < DevicePushSettingActivity.this.mList.size()) {
                    gya = DevicePushSettingActivity.this.mList.get(i);
                }
                if (gya != null && !TextUtils.isEmpty(gya.O00000Oo)) {
                    boolean z = false;
                    if (gya.O00000oo.intValue() >= 3) {
                        gya.O00000oo = 0;
                    } else {
                        gya.O00000oo = 3;
                        z = true;
                    }
                    O000000o.this.O00000o0.setChecked(z);
                    hzf.O000000o((CompoundButton) O000000o.this.O00000o0);
                    DevicePushSettingActivity.this.updateMipushSwitch(gya);
                }
            }
        };

        public O000000o(View view) {
            super(view);
            this.f9914O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = (TextView) view.findViewById(R.id.room_name);
            this.O00000o0 = (SwitchButton) view.findViewById(R.id.device_push_item_btn);
            this.O00000o = (SimpleDraweeView) view.findViewById(R.id.device_icon);
            this.O00000o0.setOnTouchEnable(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        doDropDownAnimation(true);
        hxi.O00000o.f952O000000o.O000000o("notification_familydevicenotification_switchfamily_click", new Object[0]);
        HomeListDialogHelper.O000000o(this, this.titleBar, this.currentHome.getId(), false, new HomeListDialogHelper.O000000o() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.DevicePushSettingActivity.AnonymousClass1 */

            public final void O000000o() {
                DevicePushSettingActivity.this.doDropDownAnimation(false);
            }

            public final void O000000o(Home home) {
                if (home == null || TextUtils.equals(home.getId(), DevicePushSettingActivity.this.currentHome.getId())) {
                    hxi.O00000o.O0000OOo(0);
                    return;
                }
                hxi.O00000o.O0000OOo(1);
                DevicePushSettingActivity devicePushSettingActivity = DevicePushSettingActivity.this;
                devicePushSettingActivity.currentHome = home;
                TextView textView = devicePushSettingActivity.moduleA3ReturnTitle;
                ggb.O00000Oo();
                textView.setText(ggb.O000000o(DevicePushSettingActivity.this.currentHome));
                DevicePushSettingActivity.this.showProcessDialog();
                DevicePushSettingActivity.this.devicePushViewModel.O000000o(DevicePushSettingActivity.this.currentHome.getId(), TextUtils.equals(DevicePushSettingActivity.this.pageType, "share_device"));
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list) {
        XQProgressDialog xQProgressDialog = this.f9911O000000o;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.f9911O000000o.dismiss();
        }
        if (this.devicePushViewModel.O00000o0.getValue() != null) {
            this.mMainSwitch = this.devicePushViewModel.O00000o0.getValue().intValue();
        }
        if ((list == null || list.size() == 0) && TextUtils.equals(this.pageType, "share_device")) {
            findViewById(R.id.empty_view).setVisibility(0);
        }
        this.mList = list;
        this.mAdapter.notifyDataSetChanged();
    }
}
