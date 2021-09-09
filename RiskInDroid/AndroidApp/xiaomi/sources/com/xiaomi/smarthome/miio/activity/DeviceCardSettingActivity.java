package com.xiaomi.smarthome.miio.activity;

import _m_j.exu;
import _m_j.faw;
import _m_j.gku;
import _m_j.gpy;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hzf;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.VideoView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.api.ProgressCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;

public class DeviceCardSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f9659O000000o;
    public VideoView mVv;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_card_setting);
        findViewById(R.id.title_bar).setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.device_card_shortcut);
        this.f9659O000000o = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", "lite_config_device_card_shortcut", false);
        final SwitchButton switchButton = (SwitchButton) findViewById(R.id.device_card_shortcut_btn);
        switchButton.setOnTouchEnable(false);
        switchButton.setChecked(this.f9659O000000o);
        findViewById(R.id.device_card_shortcut).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.DeviceCardSettingActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SwitchButton switchButton = switchButton;
                switchButton.setChecked(!switchButton.isChecked());
                hzf.O000000o((CompoundButton) switchButton);
                gpy.O000000o(ServiceApplication.getAppContext(), "prefs_lite_config", "lite_config_device_card_shortcut", switchButton.isChecked());
                DeviceCardSettingActivity.this.mHandler.removeCallbacksAndMessages(null);
                DeviceCardSettingActivity.this.mVv.stopPlayback();
                DeviceCardSettingActivity.this.showVideoUri(switchButton.isChecked());
                hxi.O00000o.f952O000000o.O000000o("set_cardquick_click", "type", switchButton.isChecked() ? "1" : "2");
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.DeviceCardSettingActivity.AnonymousClass2 */

            public final void onClick(View view) {
                DeviceCardSettingActivity.this.onBackPressed();
            }
        });
        this.mVv = (VideoView) findViewById(R.id.video_view);
        if (Build.VERSION.SDK_INT >= 26) {
            this.mVv.setAudioFocusRequest(0);
        }
        this.mVv.setOnErrorListener($$Lambda$DeviceCardSettingActivity$gjXiLdJiqv3_3sfId5439k3dRY8.INSTANCE);
        this.mVv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$DeviceCardSettingActivity$ccio067koUd3b7B36wuxNfjc5Mc */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                DeviceCardSettingActivity.this.O00000Oo(mediaPlayer);
            }
        });
        this.mVv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$DeviceCardSettingActivity$_M2BnP_IRgMp5sSc36rfLugvo40 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                DeviceCardSettingActivity.this.O000000o(mediaPlayer);
            }
        });
        showVideoUri(this.f9659O000000o);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O00000Oo(MediaPlayer mediaPlayer, int i, int i2) {
        LogType logType = LogType.CARD;
        gsy.O00000o0(logType, "DeviceCardSettingActivity", mediaPlayer + " " + i + " " + i2);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$DeviceCardSettingActivity$l8yKawy2dNm28seE2DKa78gwsN0 */

            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                return DeviceCardSettingActivity.this.O000000o(mediaPlayer, i, i2);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O000000o(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return true;
        }
        this.mVv.setBackgroundColor(0);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(MediaPlayer mediaPlayer) {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$DeviceCardSettingActivity$jp8Ca3R4jwD7wfgF1VbmIZslwMI */

            public final void run() {
                DeviceCardSettingActivity.this.O000000o();
            }
        }, 2000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        if (isValid()) {
            this.mVv.start();
        }
    }

    public void showVideoUri(boolean z) {
        StringBuilder sb = new StringBuilder("video_example_");
        sb.append(gku.O000000o(getContext()) ? "black" : "white");
        sb.append("_");
        sb.append(z ? "card" : "plugin");
        String sb2 = sb.toString();
        exu.O000000o o000000o = exu.f15933O000000o;
        exu O000000o2 = exu.O000000o.O000000o();
        O000000o2.O000000o(new File(getExternalCacheDir() + File.separator + "app_download" + File.separator + sb2), faw.O000000o().getCardIconPath(sb2), new ProgressCallback<File>() {
            /* class com.xiaomi.smarthome.miio.activity.DeviceCardSettingActivity.AnonymousClass3 */

            public final void onProgress(long j, long j2) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                DeviceCardSettingActivity.this.mVv.setVideoURI(Uri.fromFile((File) obj));
                DeviceCardSettingActivity.this.mVv.start();
                DeviceCardSettingActivity.this.mVv.requestFocus();
            }

            public final void onFailure(int i, String str) {
                LogType logType = LogType.CARD;
                gsy.O00000o0(logType, "DeviceCardSettingActivity", i + "  " + str);
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (!this.mVv.isPlaying()) {
            this.mVv.start();
            this.mVv.requestFocus();
        }
    }

    public void onPause() {
        super.onPause();
        this.mVv.pause();
        this.mVv.clearFocus();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mVv.stopPlayback();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onBackPressed() {
        if (this.f9659O000000o != gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", "lite_config_device_card_shortcut", false)) {
            setResult(-1);
        } else {
            setResult(0);
        }
        finish();
    }
}
