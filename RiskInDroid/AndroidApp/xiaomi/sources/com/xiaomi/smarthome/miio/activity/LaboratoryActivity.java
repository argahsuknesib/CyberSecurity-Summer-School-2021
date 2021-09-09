package com.xiaomi.smarthome.miio.activity;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gns;
import _m_j.gpv;
import _m_j.gwk;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity;

public class LaboratoryActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f9674O000000o;
    private View O00000Oo;
    private View O00000o;
    private LinearLayout O00000o0;
    private SwitchButton O00000oO;
    public boolean mIsRNPluginDarkEnabled;
    public SwitchButton mRNPluginDarkModeSwitchButton;
    public View mXiaoAiRoomSetting;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
      _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
      _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.gpv.O000000o(android.content.Context, java.lang.String, long):void
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String, boolean):void
      _m_j.gpv.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_laboratory_layout);
        this.mXiaoAiRoomSetting = findViewById(R.id.xiaoai_room_setting);
        this.f9674O000000o = findViewById(R.id.rn_plugin_dark_setting);
        this.mRNPluginDarkModeSwitchButton = (SwitchButton) findViewById(R.id.rn_plugin_darkmode_setting_switcher);
        this.O00000Oo = findViewById(R.id.laboratory_empty);
        this.O00000o0 = (LinearLayout) findViewById(R.id.item_container);
        this.O00000o = findViewById(R.id.quick_feed_entrance);
        this.O00000oO = (SwitchButton) findViewById(R.id.quick_feed_entrance_switcher);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LaboratoryActivity.AnonymousClass1 */

            public final void onClick(View view) {
                LaboratoryActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.laboratory_setting);
        this.mXiaoAiRoomSetting.setVisibility(8);
        this.mXiaoAiRoomSetting.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LaboratoryActivity.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
              _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
              _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O00000o0(android.content.Context, java.lang.String, boolean):void
             arg types: [android.content.Context, java.lang.String, int]
             candidates:
              _m_j.gpv.O00000o0(android.content.SharedPreferences, java.lang.String, java.lang.String):void
              _m_j.gpv.O00000o0(android.content.Context, java.lang.String, boolean):void */
            public final void onClick(View view) {
                fbs.O000000o(new fbt(LaboratoryActivity.this, XiaoAiListActivity.TAG).O000000o("show_guide", !gpv.O000000o("lab_xiaoai_red_dot_shown", false)));
                gpv.O00000o0(LaboratoryActivity.this.getApplicationContext(), "lab_xiaoai_red_dot_shown", true);
                LaboratoryActivity.this.mXiaoAiRoomSetting.findViewById(R.id.img_xiaoai_dot).setVisibility(8);
            }
        });
        int i = 0;
        if (!gpv.O000000o("lab_xiaoai_red_dot_shown", false)) {
            this.mXiaoAiRoomSetting.findViewById(R.id.img_xiaoai_dot).setVisibility(0);
        } else {
            this.mXiaoAiRoomSetting.findViewById(R.id.img_xiaoai_dot).setVisibility(8);
        }
        this.mIsRNPluginDarkEnabled = gpv.O000000o(getApplicationContext(), "lab_rn_plugin_darkmode", false);
        this.f9674O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.LaboratoryActivity.AnonymousClass3 */

            public final void onClick(View view) {
                LaboratoryActivity.this.mRNPluginDarkModeSwitchButton.toggle();
                LaboratoryActivity laboratoryActivity = LaboratoryActivity.this;
                laboratoryActivity.mIsRNPluginDarkEnabled = !laboratoryActivity.mIsRNPluginDarkEnabled;
                gpv.O00000Oo(LaboratoryActivity.this.getContext(), "lab_rn_plugin_darkmode", LaboratoryActivity.this.mIsRNPluginDarkEnabled);
                Intent intent = new Intent("rn_plugin_darkmode_switch_changed");
                intent.setPackage(LaboratoryActivity.this.getContext().getPackageName());
                LaboratoryActivity.this.getContext().sendBroadcast(intent);
            }
        });
        this.mRNPluginDarkModeSwitchButton.setOnTouchEnable(false);
        this.mRNPluginDarkModeSwitchButton.setChecked(this.mIsRNPluginDarkEnabled);
        this.f9674O000000o.setVisibility(Build.VERSION.SDK_INT >= 29 ? 0 : 8);
        findViewById(R.id.uwb_test_container).setVisibility(8);
        boolean z = true;
        this.O00000o.setVisibility((!gns.O000000o() || !(ServiceApplication.getStateNotifier().f15923O000000o == 4)) ? 8 : 0);
        this.O00000oO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.miio.activity.LaboratoryActivity.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gwk.O000000o().O000000o(z);
            }
        });
        this.O00000oO.setChecked(gns.O00000o0());
        View view = this.O00000Oo;
        LinearLayout linearLayout = this.O00000o0;
        int childCount = linearLayout.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                z = false;
                break;
            } else if (linearLayout.getChildAt(i2).getVisibility() == 0) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
