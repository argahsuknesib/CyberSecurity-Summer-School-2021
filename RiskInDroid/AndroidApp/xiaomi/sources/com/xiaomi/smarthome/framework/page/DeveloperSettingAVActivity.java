package com.xiaomi.smarthome.framework.page;

import _m_j.fvo;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import java.util.ArrayList;
import java.util.List;

public class DeveloperSettingAVActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<View> f7663O000000o = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.developer_setting_av_list_activity);
        setTitle("音视频设置");
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.$$Lambda$DeveloperSettingAVActivity$HoaZLG2tjg_QIhPlLQWNPwQ4vsc */

            public final void onClick(View view) {
                DeveloperSettingAVActivity.this.O000000o(view);
            }
        });
        SwitchButton switchButton = (SwitchButton) findViewById(R.id.sb_full_log);
        fvo.O000000o();
        switchButton.setChecked(fvo.O0000ooo());
        switchButton.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$rq5AC1gVbE8WODMc6lbmmWiemPI.INSTANCE);
        SwitchButton switchButton2 = (SwitchButton) findViewById(R.id.sb_soft_decoder);
        fvo.O000000o();
        switchButton2.setChecked(fvo.O0000o());
        switchButton2.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$Q7lnYVZINbRDXkwJArtD3aEe3Q4.INSTANCE);
        SwitchButton switchButton3 = (SwitchButton) findViewById(R.id.sb_save_video);
        fvo.O000000o();
        switchButton3.setChecked(fvo.O0000oO0());
        switchButton3.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$0hwguodfMASX37E9s7QWHbl1phI.INSTANCE);
        SwitchButton switchButton4 = (SwitchButton) findViewById(R.id.sb_save_app_audio);
        fvo.O000000o();
        switchButton4.setChecked(fvo.O0000oO());
        switchButton4.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$04wN7PlSbJPLCkTrz1X_ht1_A.INSTANCE);
        SwitchButton switchButton5 = (SwitchButton) findViewById(R.id.sb_rn_ijk);
        fvo.O000000o();
        switchButton5.setChecked(fvo.O0000oOO());
        switchButton5.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$Oh5Epr9udFEinA2OmkPWIonZMw.INSTANCE);
        SwitchButton switchButton6 = (SwitchButton) findViewById(R.id.sb_camera_ijk);
        fvo.O000000o();
        switchButton6.setChecked(fvo.O0000oOo());
        switchButton6.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$GK1lS7n9EiCvQcImvEFUkyP7BYw.INSTANCE);
        SwitchButton switchButton7 = (SwitchButton) findViewById(R.id.sb_cloud_ijk);
        fvo.O000000o();
        switchButton7.setChecked(fvo.O00oOooO());
        switchButton7.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$aC3vJw0SViaymsbNWhOr74agr2U.INSTANCE);
        SwitchButton switchButton8 = (SwitchButton) findViewById(R.id.sb_force_camera_api1);
        fvo.O000000o();
        switchButton8.setChecked(fvo.O0000oo());
        switchButton8.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$cHaYajoFnY5hxgB30Q_qIzOp3_E.INSTANCE);
        SwitchButton switchButton9 = (SwitchButton) findViewById(R.id.sb_super_resolution_enable);
        fvo.O000000o();
        switchButton9.setChecked(fvo.O0000ooO());
        switchButton9.setOnCheckedChangeListener($$Lambda$DeveloperSettingAVActivity$7iUVxahItVWmKDdAUb0a_rpV4o.INSTANCE);
        this.f7663O000000o.add(switchButton2);
        this.f7663O000000o.add(switchButton3);
        this.f7663O000000o.add(switchButton4);
        this.f7663O000000o.add(switchButton5);
        this.f7663O000000o.add(switchButton6);
        this.f7663O000000o.add(switchButton7);
        this.f7663O000000o.add(switchButton8);
        this.f7663O000000o.add(switchButton9);
        SwitchButton switchButton10 = (SwitchButton) findViewById(R.id.sb_av_setting_enable);
        fvo.O000000o();
        switchButton10.setChecked(fvo.O0000oo0());
        switchButton10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.$$Lambda$DeveloperSettingAVActivity$Mg16NU7i_8vQczKDIa7YgkOofU */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DeveloperSettingAVActivity.this.O000000o(compoundButton, z);
            }
        });
        fvo.O000000o();
        O000000o(fvo.O0000oo0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O0000Oo(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000oO(z);
        CameraRouterFactory.getCameraManagerApi().setFullLogEnable(z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O0000Oo0(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000OoO(z);
        CameraRouterFactory.getCameraManagerApi().setForceUseSoftDecode(z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O0000OOo(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000Ooo(z);
        CameraRouterFactory.getCameraManagerApi().setSaveVideoRawData(z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O0000O0o(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000o00(z);
        CameraRouterFactory.getCameraManagerApi().setSaveAppAudioRawData(z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000oo(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000o0(z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000oO(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000o0O(z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000oOO(z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o0(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000o(z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000oO0(z);
        CameraRouterFactory.getCameraManagerApi().setSuperResolutionEnable(z);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
        fvo.O000000o();
        fvo.O0000o0o(z);
        O000000o(z);
    }

    private void O000000o(boolean z) {
        for (View enabled : this.f7663O000000o) {
            enabled.setEnabled(z);
        }
    }
}
