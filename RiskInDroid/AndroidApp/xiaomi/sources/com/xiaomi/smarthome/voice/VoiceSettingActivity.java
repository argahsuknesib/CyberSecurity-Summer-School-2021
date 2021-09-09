package com.xiaomi.smarthome.voice;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.ftn;
import _m_j.gpv;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.mibrain.roomsetting.XiaoAiListActivity;

public class VoiceSettingActivity extends BaseActivity {
    @BindView(5252)
    ImageView mAnoterNameDot;
    @BindView(5962)
    View mAnotherNameSetting;
    @BindView(5069)
    View mDeviceAuth;
    @BindView(5257)
    ImageView mXiaoaiRoomDot;
    @BindView(5987)
    View mXiaoaiRoomSetting;
    @BindView(5253)
    ImageView mdeviceauthdot;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_voice_setting);
        ButterKnife.bind(this);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.voice.VoiceSettingActivity.AnonymousClass1 */

            public final void onClick(View view) {
                VoiceSettingActivity.this.back();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.audio_setting);
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.mAnotherNameSetting.setVisibility(8);
        } else {
            this.mAnotherNameSetting.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.voice.$$Lambda$VoiceSettingActivity$HQa_jgx0tA_P8fe0deiGTzuFchg */

                public final void onClick(View view) {
                    VoiceSettingActivity.this.O00000o0(view);
                }
            });
        }
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.mXiaoaiRoomSetting.setVisibility(8);
        } else {
            this.mXiaoaiRoomSetting.setVisibility(0);
            this.mXiaoaiRoomSetting.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.voice.$$Lambda$VoiceSettingActivity$f6axCpNrIAGe1bSwaXksOoBUsnE */

                public final void onClick(View view) {
                    VoiceSettingActivity.this.O00000Oo(view);
                }
            });
        }
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (!CoreApi.O000000o().O0000Ooo() || (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && !ftn.O00000oo(O0000ooO))) {
            this.mDeviceAuth.setVisibility(8);
            return;
        }
        this.mDeviceAuth.setVisibility(0);
        this.mDeviceAuth.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.voice.$$Lambda$VoiceSettingActivity$ABYcO9wAtvYA_ycR39Iv2rbKLLc */

            public final void onClick(View view) {
                VoiceSettingActivity.this.O000000o(view);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000o0(android.content.Context, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.gpv.O00000o0(android.content.SharedPreferences, java.lang.String, java.lang.String):void
      _m_j.gpv.O00000o0(android.content.Context, java.lang.String, boolean):void */
    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        fbs.O000000o(new fbt(this, "AnotherNameDevListActivity").O000000o("show_guide", this.mAnoterNameDot.getVisibility() == 0));
        gpv.O00000o0(getApplicationContext(), "voice_another_name_setting", true);
        this.mAnoterNameDot.setVisibility(8);
    }

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
    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        Intent intent = new Intent(this, XiaoAiListActivity.class);
        intent.putExtra("show_guide", !gpv.O000000o("lab_xiaoai_red_dot_shown", false));
        startActivity(intent);
        gpv.O00000o0(getApplicationContext(), "lab_xiaoai_red_dot_shown", true);
        this.mXiaoaiRoomDot.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        fbs.O000000o(new fbt(this, "/setting/DeviceAuthMasterListActivity"));
    }

    public void onBackPressed() {
        super.onBackPressed();
        back();
    }

    public void back() {
        finish();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }
}
