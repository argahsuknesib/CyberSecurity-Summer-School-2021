package com.xiaomi.smarthome.camera.activity.local;

import _m_j.cid;
import _m_j.cin;
import _m_j.civ;
import _m_j.cki;
import _m_j.clc;
import _m_j.cle;
import _m_j.clf;
import _m_j.clj;
import _m_j.fsa;
import _m_j.goq;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hyy;
import _m_j.izb;
import _m_j.me;
import _m_j.mg;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmMp4Player;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity;
import com.xiaomi.smarthome.camera.view.widget.FeedbackDialog;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalAlarmPlayerV2Activity extends CameraBaseActivity implements View.OnClickListener {
    CheckBox cbTogglePlay;
    public String currentPlayFilePath = null;
    private boolean isMute = false;
    ImageView ivFullScreen;
    clc mAlarItem;
    cle mAlarmFileManager;
    View mBottomViewContainer;
    private boolean mCanRetry = false;
    public TextView mDurationView;
    ImageView mFullScreenView;
    AnimationDrawable mLoadingAnimation;
    private LocalAudioPlay mLocalAudioPlay = null;
    private boolean mNeedCheck = false;
    private boolean mPlayAutoPause = false;
    public TextView mPlayingView;
    SeekBar mProgressBar;
    View mProgressBarContainer;
    private int mRotation = 0;
    private SeekBar.OnSeekBarChangeListener mSeekBarChange = new SeekBar.OnSeekBarChangeListener() {
        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity.AnonymousClass2 */

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (LocalAlarmPlayerV2Activity.this.mSeekBarTouched) {
                LocalAlarmPlayerV2Activity.this.mHandler.removeMessages(2);
                String format = LocalAlarmPlayerV2Activity.this.mTimeFormat.format(Integer.valueOf(i * 1000));
                if (!TextUtils.isEmpty(format)) {
                    LocalAlarmPlayerV2Activity.this.mPlayingView.setText(format);
                }
                Message obtainMessage = LocalAlarmPlayerV2Activity.this.mHandler.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i;
                obtainMessage.sendToTarget();
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            LocalAlarmPlayerV2Activity.this.mSeekBarTouched = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            LocalAlarmPlayerV2Activity.this.mSeekBarTouched = false;
        }
    };
    boolean mSeekBarTouched = false;
    SimpleDateFormat mTimeFormat;
    LinearLayout mToastCenter;
    ImageView mToastImg;
    TextView mToastText;
    View mTopViewContainer;
    XmMp4Player mVideoPlayerRender;
    XmVideoViewGl mVideoView;
    FrameLayout mVideoViewFrame;
    private FrameLayout title_bar;
    private ImageView videoMute;

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 1) {
            this.mHandler.removeMessages(1);
            if (!this.mSeekBarTouched) {
                int currentPosition = this.mVideoPlayerRender.getCurrentPosition();
                String format = this.mTimeFormat.format(Integer.valueOf(currentPosition));
                if (!TextUtils.isEmpty(format)) {
                    this.mPlayingView.setText(format);
                }
                this.mProgressBar.setProgress(currentPosition / 1000);
            }
            this.mHandler.sendEmptyMessageDelayed(1, 1000);
        } else if (i == 2) {
            this.mVideoPlayerRender.seekTo(this.mProgressBar.getProgress() * 1000);
        } else if (i != 3) {
            switch (i) {
                case 14:
                    activity();
                    gqg.O000000o((int) R.string.save_success);
                    return;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    activity();
                    gqg.O000000o((int) R.string.retry_download_media_file);
                    return;
                case 16:
                case 17:
                    return;
                default:
                    return;
            }
        } else {
            this.mCanRetry = false;
        }
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_video_play_v2);
        this.mNeedCheck = getIntent().getBooleanExtra("check", false);
        civ.O00000o("alarm", "need check " + this.mNeedCheck);
        if (this.mNeedCheck) {
            globalPinCodeVerifyFunc();
            civ.O00000o("alarm", "enableVerifyPincode " + this.mDeviceStat.isSetPinCode);
        }
        AudioManager audioManager = (AudioManager) activity().getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(null, 3, 1);
        }
        this.mAlarmFileManager = this.mCameraDevice.O0000o0o();
        String stringExtra = getIntent().getStringExtra("alarmItem");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mAlarItem = new clc(stringExtra);
        }
        boolean booleanExtra = getIntent().getBooleanExtra("push", false);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        initView();
        if (booleanExtra) {
            this.mCanRetry = true;
            this.mHandler.sendEmptyMessageDelayed(3, 18000);
        }
    }

    private void initView() {
        this.videoMute = (ImageView) findViewById(R.id.video_mute);
        this.videoMute.setOnClickListener(this);
        this.mToastCenter = (LinearLayout) findViewById(R.id.toast_container_center);
        this.mToastCenter.setOnClickListener(this);
        this.mToastText = (TextView) findViewById(R.id.toast_title);
        this.mToastImg = (ImageView) findViewById(R.id.toast_icon);
        if (this.isV4) {
            this.mToastText.setVisibility(0);
            this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.anim_alarm_loading_v4);
        } else {
            this.mToastText.setVisibility(8);
            this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_loading);
        }
        this.mToastImg.setImageDrawable(this.mLoadingAnimation);
        this.mToastImg.setOnClickListener(this);
        this.title_bar = (FrameLayout) findViewById(R.id.title_bar);
        this.title_bar.bringToFront();
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mBottomViewContainer = findViewById(R.id.bottom_tools_container);
        if (!this.mCameraDevice.isReadOnlyShared()) {
            this.mBottomViewContainer.setVisibility(0);
        } else {
            this.mBottomViewContainer.setVisibility(8);
        }
        this.mTopViewContainer = findViewById(R.id.top_tools_container);
        this.mProgressBarContainer = findViewById(R.id.progress_bar_container);
        this.mProgressBar = (SeekBar) findViewById(R.id.progress_bar);
        this.mDurationView = (TextView) findViewById(R.id.progress_duration);
        this.mPlayingView = (TextView) findViewById(R.id.progress_playtime);
        clc clc = this.mAlarItem;
        if (clc != null) {
            this.mProgressBar.setMax((int) clc.f13987O000000o);
            this.mDurationView.setText(this.mTimeFormat.format(new Date(this.mAlarItem.f13987O000000o * 1000)));
        }
        this.mProgressBar.setOnSeekBarChangeListener(this.mSeekBarChange);
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(activity());
        this.mVideoViewFrame.addView(frameLayout, 0, layoutParams);
        boolean contains = cin.f13904O000000o.contains(Build.MODEL);
        this.mVideoView = XmPluginHostApi.instance().createMp4View(activity(), frameLayout, !contains);
        this.mVideoView.setMiniScale(true);
        this.mVideoPlayerRender = this.mVideoView.getMp4Player();
        if (contains) {
            this.mLocalAudioPlay = new LocalAudioPlay(activity());
            this.mVideoPlayerRender.setAudioListener(this.mLocalAudioPlay);
        }
        this.mVideoPlayerRender.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$ypUL6g0i36Kg2Dw6cMZsrHAWcI8 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                LocalAlarmPlayerV2Activity.this.lambda$initView$1$LocalAlarmPlayerV2Activity(mediaPlayer);
            }
        });
        this.mVideoPlayerRender.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$4DjBQud3A4kBZubj_GU77LyOw4 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                LocalAlarmPlayerV2Activity.this.lambda$initView$2$LocalAlarmPlayerV2Activity(mediaPlayer);
            }
        });
        this.mVideoPlayerRender.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$9EEFnxKhl9prV1GxEB9KrQdydWg */

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return LocalAlarmPlayerV2Activity.this.lambda$initView$4$LocalAlarmPlayerV2Activity(mediaPlayer, i, i2);
            }
        });
        this.mVideoView.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$mBcpQ4mvD9rXiuEZu2U2hkcpWI */

            public final void onVideoViewClick() {
                LocalAlarmPlayerV2Activity.this.lambda$initView$5$LocalAlarmPlayerV2Activity();
            }
        });
        this.mFullScreenView = (ImageView) findViewById(R.id.full_screen);
        this.cbTogglePlay = (CheckBox) findViewById(R.id.cbTogglePlay);
        this.cbTogglePlay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$71b18EKmdjJtYm1PM82QMQgYJYQ */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LocalAlarmPlayerV2Activity.this.lambda$initView$6$LocalAlarmPlayerV2Activity(compoundButton, z);
            }
        });
        this.ivFullScreen = (ImageView) findViewById(R.id.ivFullScreen);
        this.ivFullScreen.setOnClickListener(this);
        this.mFullScreenView.setOnClickListener(this);
        findViewById(R.id.flip).setOnClickListener(this);
        findViewById(R.id.local_share).setOnClickListener(this);
        findViewById(R.id.local_delete).setOnClickListener(this);
        findViewById(R.id.local_save).setOnClickListener(this);
        this.mVideoView.initial();
        this.mVideoPlayerRender.setRenderCallback(new XmMp4Player.RenderCallback() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$pa0p1fDUFIHzrCxhASoyGwNTbto */

            public final void onInitialed() {
                LocalAlarmPlayerV2Activity.this.lambda$initView$8$LocalAlarmPlayerV2Activity();
            }
        });
    }

    public /* synthetic */ void lambda$initView$1$LocalAlarmPlayerV2Activity(MediaPlayer mediaPlayer) {
        cki.O00000o("LocalAlarmPlayerV2Activity", "onCompletion ");
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$DIxz2RhWSqxe0lGoAHJlpt9_LMM */

            public final void run() {
                LocalAlarmPlayerV2Activity.this.lambda$null$0$LocalAlarmPlayerV2Activity();
            }
        });
    }

    public /* synthetic */ void lambda$null$0$LocalAlarmPlayerV2Activity() {
        this.mHandler.removeMessages(1);
        SeekBar seekBar = this.mProgressBar;
        seekBar.setProgress(seekBar.getMax());
        if (!TextUtils.isEmpty(this.mDurationView.getText())) {
            this.mPlayingView.setText(this.mDurationView.getText());
        }
        this.cbTogglePlay.setChecked(true);
        if (this.mProgressBarContainer.getVisibility() == 8) {
            AnimationUtils.loadAnimation(activity(), R.anim.slide_in_top).setFillAfter(true);
            Animation loadAnimation = AnimationUtils.loadAnimation(activity(), R.anim.slide_in_bottom);
            loadAnimation.setFillAfter(true);
            this.mProgressBarContainer.setClickable(true);
            this.mProgressBarContainer.setVisibility(0);
            this.mProgressBarContainer.startAnimation(loadAnimation);
        }
    }

    public /* synthetic */ void lambda$initView$2$LocalAlarmPlayerV2Activity(MediaPlayer mediaPlayer) {
        this.cbTogglePlay.setChecked(false);
    }

    public /* synthetic */ boolean lambda$initView$4$LocalAlarmPlayerV2Activity(MediaPlayer mediaPlayer, int i, int i2) {
        cki.O00000o("LocalAlarmPlayerV2Activity", "onError ".concat(String.valueOf(i)));
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$fYxil8K1E1wskVFaY_EzijWGruo */

            public final void run() {
                LocalAlarmPlayerV2Activity.this.lambda$null$3$LocalAlarmPlayerV2Activity();
            }
        });
        return true;
    }

    public /* synthetic */ void lambda$null$3$LocalAlarmPlayerV2Activity() {
        this.mProgressBar.setProgress(this.mVideoPlayerRender.getCurrentPosition() / 1000);
        String format = this.mTimeFormat.format(Integer.valueOf(this.mVideoPlayerRender.getCurrentPosition()));
        if (!TextUtils.isEmpty(format)) {
            this.mPlayingView.setText(format);
        }
        this.cbTogglePlay.setChecked(true);
    }

    public /* synthetic */ void lambda$initView$5$LocalAlarmPlayerV2Activity() {
        if (this.mProgressBarContainer.isShown()) {
            AnimationUtils.loadAnimation(activity(), R.anim.slide_out_top).setFillAfter(true);
            Animation loadAnimation = AnimationUtils.loadAnimation(activity(), R.anim.slide_out_bottom);
            loadAnimation.setFillAfter(true);
            this.mProgressBarContainer.setClickable(false);
            this.mProgressBarContainer.setVisibility(8);
            this.mProgressBarContainer.startAnimation(loadAnimation);
            return;
        }
        AnimationUtils.loadAnimation(activity(), R.anim.slide_in_top).setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(activity(), R.anim.slide_in_bottom);
        loadAnimation2.setFillAfter(true);
        this.mProgressBarContainer.setClickable(true);
        this.mProgressBarContainer.setVisibility(0);
        this.mProgressBarContainer.startAnimation(loadAnimation2);
    }

    public /* synthetic */ void lambda$initView$6$LocalAlarmPlayerV2Activity(CompoundButton compoundButton, boolean z) {
        if (z) {
            pausePlay();
            this.cbTogglePlay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.camera_icon_play02), (Drawable) null);
            return;
        }
        startPlay();
        this.cbTogglePlay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.camera_icon_pause02), (Drawable) null);
    }

    public /* synthetic */ void lambda$initView$8$LocalAlarmPlayerV2Activity() {
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$UnnfIIgAsU6LG005jI_Im3M_A */

            public final void run() {
                LocalAlarmPlayerV2Activity.this.lambda$null$7$LocalAlarmPlayerV2Activity();
            }
        });
    }

    public /* synthetic */ void lambda$null$7$LocalAlarmPlayerV2Activity() {
        if (!this.mNeedCheck || !this.mCameraDevice.O0000oO()) {
            showNetAlarm();
        }
    }

    private void initFeedback() {
        clc clc;
        final String str;
        if (XmPluginHostApi.instance().getApiLevel() >= 22 && XmPluginHostApi.instance().getGlobalSettingServer() != null && XmPluginHostApi.instance().getGlobalSettingServer().equals("cn") && (clc = this.mAlarItem) != null && !TextUtils.isEmpty(clc.O0000Oo)) {
            boolean contains = this.mAlarItem.O0000Oo.contains("people");
            System.out.println("mytest:getOnlyPeopleStatus:".concat(String.valueOf(contains)));
            if (contains) {
                ((TextView) findViewById(R.id.tvFeedback)).setText((int) R.string.nobody_video);
                str = getString(R.string.nobody_title);
            } else {
                ((TextView) findViewById(R.id.tvFeedback)).setText((int) R.string.hasbody_video);
                str = getString(R.string.hasbody_title);
            }
            findViewById(R.id.tvFeedback).setVisibility(0);
            findViewById(R.id.tvFeedback).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity.AnonymousClass1 */

                public void onClick(View view) {
                    FeedbackDialog feedbackDialog = new FeedbackDialog(LocalAlarmPlayerV2Activity.this.getContext());
                    feedbackDialog.setTitle(str);
                    feedbackDialog.setModel(LocalAlarmPlayerV2Activity.this.mCameraDevice.getModel());
                    feedbackDialog.setOnClickListener(new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity.AnonymousClass1.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
                         arg types: [java.lang.String, int]
                         candidates:
                          org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
                          org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
                          org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
                          org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
                          org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
                          org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
                          org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
                          org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            cid cid = LocalAlarmPlayerV2Activity.this.mCameraDevice;
                            String str = LocalAlarmPlayerV2Activity.this.mAlarItem.O0000OOo;
                            AnonymousClass1 r0 = new Callback<String>() {
                                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public void onSuccess(String str) {
                                    izb.O000000o(LocalAlarmPlayerV2Activity.this.activity(), (int) R.string.thanks_feedback, 1).show();
                                }

                                public void onFailure(int i, String str) {
                                    izb.O000000o(LocalAlarmPlayerV2Activity.this.activity(), (int) R.string.action_fail, 1).show();
                                }
                            };
                            if (XmPluginHostApi.instance().getApiLevel() >= 58) {
                                JSONObject jSONObject = new JSONObject();
                                new JSONArray();
                                try {
                                    jSONObject.put("did", cid.getDid());
                                    jSONObject.put("fileId", Base64.encodeToString(new JSONObject().put("storeId", str).toString().getBytes(), 0));
                                    jSONObject.put("model", cid.getModel());
                                    jSONObject.put("isVisible", true);
                                    XmPluginHostApi.instance().callSmartHomeApi(cid.getModel(), "business.smartcamera.", "/miot/camera/app/v1/feedback", "POST", jSONObject, new Callback<String>(r0) {
                                        /* class _m_j.cid.AnonymousClass5 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ Callback f13886O000000o;

                                        {
                                            this.f13886O000000o = r2;
                                        }

                                        public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                            this.f13886O000000o.onSuccess((String) obj);
                                        }

                                        public final void onFailure(int i, String str) {
                                            this.f13886O000000o.onFailure(i, str);
                                        }
                                    }, new Parser<String>() {
                                        /* class _m_j.cid.AnonymousClass6 */

                                        public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                                            return str;
                                        }
                                    });
                                } catch (JSONException unused) {
                                    r0.onFailure(-10000, null);
                                }
                            }
                        }
                    });
                    feedbackDialog.show();
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mPlayAutoPause) {
            startPlay();
        }
    }

    public void onPause() {
        super.onPause();
        XmMp4Player xmMp4Player = this.mVideoPlayerRender;
        if (xmMp4Player != null && xmMp4Player.isPlaying()) {
            pausePlay();
            this.mPlayAutoPause = true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 9999) {
            return;
        }
        if (!TextUtils.isEmpty(XmPluginHostApi.instance().getDevicePincode(this.mDid))) {
            showNetAlarm();
            this.mCameraDevice.O00000Oo((Callback<Void>) null);
            return;
        }
        gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "getDevicePincode empty ");
    }

    /* access modifiers changed from: package-private */
    public void startPlay() {
        gsy.O00000Oo("LocalAlarmPlayerV2Activity", "startPlay");
        if (!TextUtils.isEmpty(this.currentPlayFilePath)) {
            this.mVideoPlayerRender.openVideoPlayer(this.currentPlayFilePath);
            if (this.isMute) {
                this.mVideoPlayerRender.setVolume(0);
            } else {
                this.mVideoPlayerRender.setVolume(1);
            }
            this.mPlayAutoPause = false;
        }
        this.mHandler.sendEmptyMessage(1);
    }

    private void pausePlay() {
        this.mVideoPlayerRender.pause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        AnimationDrawable animationDrawable = this.mLoadingAnimation;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.mLoadingAnimation.stop();
        }
        XmVideoViewGl xmVideoViewGl = this.mVideoView;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.release();
        }
        LocalAudioPlay localAudioPlay = this.mLocalAudioPlay;
        if (localAudioPlay != null) {
            localAudioPlay.release();
        }
        XmMp4Player xmMp4Player = this.mVideoPlayerRender;
        if (xmMp4Player != null && (xmMp4Player instanceof fsa)) {
            ((fsa) xmMp4Player).O00000oo();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(this.mCameraDevice.getModel());
            return;
        }
        if (count == 1 && this.isV4) {
            Intent intent = new Intent();
            intent.setClass(this, CameraPlayerNewActivity.class);
            if (!TextUtils.isEmpty(XmPluginHostApi.instance().getDevicePincode(this.mDeviceStat.did))) {
                intent.putExtra("pincod", true);
            }
            startActivity(intent);
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setWindow(configuration);
        hyy.O00000Oo(this, this.mFullScreen);
    }

    private void setWindow(Configuration configuration) {
        if (this.mFullScreen) {
            getWindow().setFlags(1024, 1024);
            this.title_bar.setVisibility(8);
            this.mBottomViewContainer.setVisibility(8);
            this.ivFullScreen.setImageResource(R.drawable.camera_alarm_icon_mixscreen);
            this.mVideoView.setVideoFrameSize(-1, -1, true);
            return;
        }
        getWindow().clearFlags(1024);
        this.title_bar.setVisibility(0);
        this.title_bar.bringToFront();
        if (!this.mCameraDevice.isReadOnlyShared()) {
            this.mBottomViewContainer.setVisibility(0);
        } else {
            this.mBottomViewContainer.setVisibility(8);
        }
        this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2);
        this.mVideoView.setVideoFrameSize(-1, -1, false);
    }

    private void showNetAlarm() {
        if (mg.O00000o0(activity())) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
            builder.O00000Oo((int) R.string.push_net_alarm);
            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$X62s3aPX2PH8tEn9krnb5XoMPg */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LocalAlarmPlayerV2Activity.this.lambda$showNetAlarm$9$LocalAlarmPlayerV2Activity(dialogInterface, i);
                }
            });
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$gPThOEV0YulO6omoTtjr5u5ANjY */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LocalAlarmPlayerV2Activity.this.lambda$showNetAlarm$10$LocalAlarmPlayerV2Activity(dialogInterface, i);
                }
            });
            builder.O00000oo();
            return;
        }
        clc clc = this.mAlarItem;
        if (clc != null) {
            getAlarmFile(clc);
        } else {
            parseIntent();
        }
    }

    public /* synthetic */ void lambda$showNetAlarm$9$LocalAlarmPlayerV2Activity(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        finish();
    }

    public /* synthetic */ void lambda$showNetAlarm$10$LocalAlarmPlayerV2Activity(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        clc clc = this.mAlarItem;
        if (clc != null) {
            getAlarmFile(clc);
        } else {
            parseIntent();
        }
    }

    public void showFail(String str) {
        if (this.mToastCenter.getVisibility() == 8) {
            this.mToastCenter.setVisibility(0);
        }
        if (this.mLoadingAnimation.isRunning()) {
            this.mLoadingAnimation.stop();
        }
        this.mToastImg.setImageResource(R.drawable.camera_icon_refresh_nor);
        this.mToastText.setText((int) R.string.load_refresh);
        izb.O000000o(activity(), (int) R.string.sdcard_video_download_failed, 0).show();
        gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "Error alarm ".concat(String.valueOf(str)));
    }

    private void hideFail() {
        this.mToastCenter.setVisibility(8);
    }

    private void showProgress() {
        if (this.mToastCenter.getVisibility() == 8) {
            this.mToastCenter.setVisibility(0);
        }
        this.mToastImg.setImageDrawable(this.mLoadingAnimation);
        this.mLoadingAnimation.start();
        this.mToastText.setText(getString(R.string.mj_loading));
    }

    public void hideProgress() {
        if (this.mLoadingAnimation.isRunning()) {
            this.mLoadingAnimation.stop();
        }
        if (this.mToastCenter.getVisibility() == 0) {
            this.mToastCenter.setVisibility(8);
            this.mToastText.setText("");
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.local_delete) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
            builder.O000000o((int) R.string.delete_title);
            builder.O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$x54Kp1SN1WQlvUO1gxbxBDcx5uM */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    LocalAlarmPlayerV2Activity.this.lambda$onClick$11$LocalAlarmPlayerV2Activity(dialogInterface, i);
                }
            });
            builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            builder.O00000oo();
        } else if (id == R.id.local_share) {
            saveMediaFileWithoutHint();
        } else if (id == R.id.local_save) {
            saveMediaFile();
        } else if (id == R.id.flip) {
            this.mRotation += 90;
            this.mRotation %= 360;
            this.mVideoView.setRotation(this.mRotation);
        } else if (id == R.id.full_screen) {
        } else {
            if (id == R.id.title_bar_return) {
                finish();
            } else if (id == R.id.toast_container_center) {
            } else {
                if (id == R.id.video_mute) {
                    if (this.isMute) {
                        this.videoMute.setImageResource(R.drawable.camera_alarm_icon_unmute);
                        this.isMute = false;
                        this.mVideoPlayerRender.setVolume(1);
                        return;
                    }
                    this.videoMute.setImageResource(R.drawable.camera_alarm_icon_mute);
                    this.isMute = true;
                    this.mVideoPlayerRender.setVolume(0);
                } else if (id == R.id.ivFullScreen) {
                    if (this.mFullScreen) {
                        setOrientation(false);
                        return;
                    }
                    enterPadFullScreen();
                    setOrientation(true);
                } else if (id == R.id.toast_icon) {
                    hideFail();
                    clc clc = this.mAlarItem;
                    if (clc != null) {
                        getAlarmFile(clc);
                    }
                }
            }
        }
    }

    public /* synthetic */ void lambda$onClick$11$LocalAlarmPlayerV2Activity(DialogInterface dialogInterface, int i) {
        if (this.mAlarItem != null) {
            ArrayList<clc> arrayList = new ArrayList<>();
            arrayList.add(this.mAlarItem);
            activity().setResult(-1);
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (clc clc : arrayList) {
                    jSONArray.put(clc.O0000O0o);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("fileIds", jSONArray);
                jSONObject.put("fileIds", jSONObject2);
                jSONObject.put("model", this.mCameraDevice.getModel());
                jSONObject.put("did", this.mCameraDevice.getDid());
                clf.O000000o().O0000Oo0(this.mCameraDevice.getModel(), jSONObject.toString(), new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity.AnonymousClass3 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!LocalAlarmPlayerV2Activity.this.isFinishing()) {
                            if (jSONObject == null) {
                                LocalAlarmPlayerV2Activity.this.activity();
                                gqg.O000000o((int) R.string.delete_failed);
                            } else if (jSONObject.optInt("code") == 0) {
                                LocalAlarmPlayerV2Activity.this.activity();
                                gqg.O000000o((int) R.string.delete_sucess);
                            } else {
                                LocalAlarmPlayerV2Activity.this.activity();
                                gqg.O000000o((int) R.string.delete_failed);
                            }
                            LocalAlarmPlayerV2Activity.this.finish();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!LocalAlarmPlayerV2Activity.this.isFinishing()) {
                            LocalAlarmPlayerV2Activity.this.activity();
                            gqg.O000000o((int) R.string.delete_failed);
                            LocalAlarmPlayerV2Activity.this.finish();
                        }
                    }
                });
            } catch (JSONException unused) {
                activity();
                gqg.O000000o((int) R.string.delete_failed);
                finish();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    private void saveMediaFileWithoutHint() {
        if (!TextUtils.isEmpty(this.currentPlayFilePath)) {
            String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                goq.O000000o(new Runnable(O000000o2) {
                    /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$7_Dh2KCBlhWIhbAzjlFyostEXBE */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        LocalAlarmPlayerV2Activity.this.lambda$saveMediaFileWithoutHint$12$LocalAlarmPlayerV2Activity(this.f$1);
                    }
                });
                return;
            }
            return;
        }
        this.mHandler.sendEmptyMessage(15);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008a A[SYNTHETIC, Splitter:B:38:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a4 A[SYNTHETIC, Splitter:B:43:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b2 A[SYNTHETIC, Splitter:B:49:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cc A[SYNTHETIC, Splitter:B:54:0x00cc] */
    public /* synthetic */ void lambda$saveMediaFileWithoutHint$12$LocalAlarmPlayerV2Activity(String str) {
        FileOutputStream fileOutputStream;
        StringBuilder sb;
        FileInputStream fileInputStream = null;
        try {
            this.mHandler.sendEmptyMessage(16);
            FileInputStream fileInputStream2 = new FileInputStream(this.currentPlayFilePath);
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    toShare(str);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e.getLocalizedMessage());
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        sb = new StringBuilder("IOException:");
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    try {
                        gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e.getLocalizedMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e4.getLocalizedMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                e = e5;
                                sb = new StringBuilder("IOException:");
                            }
                        }
                        this.mHandler.sendEmptyMessage(17);
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        this.mHandler.sendEmptyMessage(17);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e6.getLocalizedMessage());
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e7.getLocalizedMessage());
                        }
                    }
                    this.mHandler.sendEmptyMessage(17);
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e.getLocalizedMessage());
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                this.mHandler.sendEmptyMessage(17);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                this.mHandler.sendEmptyMessage(17);
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            fileOutputStream = null;
            gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e.getLocalizedMessage());
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            this.mHandler.sendEmptyMessage(17);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            this.mHandler.sendEmptyMessage(17);
            throw th;
        }
        this.mHandler.sendEmptyMessage(17);
        sb.append(e.getLocalizedMessage());
        gsy.O000000o(6, "LocalAlarmPlayerV2Activity", sb.toString());
        this.mHandler.sendEmptyMessage(17);
    }

    private void toShare(String str) {
        if (!TextUtils.isEmpty(str)) {
            CameraJumpUtils.openShareActivity(activity(), "", "", str, 1);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    private void saveMediaFile() {
        if (!TextUtils.isEmpty(this.currentPlayFilePath)) {
            String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                goq.O000000o(new Runnable(O000000o2) {
                    /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalAlarmPlayerV2Activity$UXHQzdTgDbiigHb5ca3g_3G4fYM */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        LocalAlarmPlayerV2Activity.this.lambda$saveMediaFile$13$LocalAlarmPlayerV2Activity(this.f$1);
                    }
                });
                return;
            }
            return;
        }
        this.mHandler.sendEmptyMessage(15);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e A[SYNTHETIC, Splitter:B:38:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a8 A[SYNTHETIC, Splitter:B:43:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6 A[SYNTHETIC, Splitter:B:49:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d0 A[SYNTHETIC, Splitter:B:54:0x00d0] */
    public /* synthetic */ void lambda$saveMediaFile$13$LocalAlarmPlayerV2Activity(String str) {
        FileOutputStream fileOutputStream;
        StringBuilder sb;
        FileInputStream fileInputStream = null;
        try {
            this.mHandler.sendEmptyMessage(16);
            FileInputStream fileInputStream2 = new FileInputStream(this.currentPlayFilePath);
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    this.mHandler.sendEmptyMessage(14);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e.getLocalizedMessage());
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        sb = new StringBuilder("IOException:");
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    try {
                        gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e.getLocalizedMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e4.getLocalizedMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                e = e5;
                                sb = new StringBuilder("IOException:");
                            }
                        }
                        this.mHandler.sendEmptyMessage(17);
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e6.getLocalizedMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e7) {
                                gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e7.getLocalizedMessage());
                            }
                        }
                        this.mHandler.sendEmptyMessage(17);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    this.mHandler.sendEmptyMessage(17);
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e.getLocalizedMessage());
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                this.mHandler.sendEmptyMessage(17);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                this.mHandler.sendEmptyMessage(17);
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            fileOutputStream = null;
            gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "IOException:" + e.getLocalizedMessage());
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            this.mHandler.sendEmptyMessage(17);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            this.mHandler.sendEmptyMessage(17);
            throw th;
        }
        this.mHandler.sendEmptyMessage(17);
        sb.append(e.getLocalizedMessage());
        gsy.O000000o(6, "LocalAlarmPlayerV2Activity", sb.toString());
        this.mHandler.sendEmptyMessage(17);
    }

    /* access modifiers changed from: protected */
    public void setOrientation(boolean z) {
        if (z) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    public void getAlarmFile(clc clc) {
        initFeedback();
        showProgress();
        this.mCameraDevice.O0000o0o().O000000o(this, clc, new cle.O000000o<String>() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity.AnonymousClass4 */

            public void onSuccess(String str, Object obj) {
                if (!LocalAlarmPlayerV2Activity.this.isFinishing()) {
                    LocalAlarmPlayerV2Activity.this.hideProgress();
                    gsy.O00000Oo("LocalAlarmPlayerV2Activity", "result mCurrentPath:".concat(String.valueOf(str)));
                    if (!TextUtils.isEmpty(str)) {
                        LocalAlarmPlayerV2Activity localAlarmPlayerV2Activity = LocalAlarmPlayerV2Activity.this;
                        localAlarmPlayerV2Activity.currentPlayFilePath = str;
                        TextView textView = (TextView) localAlarmPlayerV2Activity.findViewById(R.id.title_bar_title);
                        if (!TextUtils.isEmpty(LocalAlarmPlayerV2Activity.this.currentPlayFilePath)) {
                            clj.O000000o O00000Oo = LocalAlarmPlayerV2Activity.this.mCameraDevice.O0000O0o().O00000Oo(str);
                            if (O00000Oo != null) {
                                textView.setText(O00000Oo.O00000o0.getName());
                            }
                            LocalAlarmPlayerV2Activity localAlarmPlayerV2Activity2 = LocalAlarmPlayerV2Activity.this;
                            long extractVideoDuration = localAlarmPlayerV2Activity2.extractVideoDuration(localAlarmPlayerV2Activity2.currentPlayFilePath);
                            LocalAlarmPlayerV2Activity.this.mProgressBar.setMax((int) (extractVideoDuration / 1000));
                            TextView textView2 = LocalAlarmPlayerV2Activity.this.mDurationView;
                            textView2.setText(LocalAlarmPlayerV2Activity.this.mTimeFormat.format(Long.valueOf(extractVideoDuration)));
                        }
                        LocalAlarmPlayerV2Activity.this.startPlay();
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!LocalAlarmPlayerV2Activity.this.isFinishing()) {
                    LocalAlarmPlayerV2Activity.this.hideProgress();
                    LocalAlarmPlayerV2Activity.this.showFail(String.valueOf(i));
                    LocalAlarmPlayerV2Activity.this.currentPlayFilePath = null;
                    gsy.O000000o(6, "LocalAlarmPlayerV2Activity", "errorCode:" + i + " errorMessage:" + str);
                }
            }
        });
    }

    private void parseIntent() {
        String stringExtra = getIntent().getStringExtra("extra");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                long optLong = jSONObject.optLong("createTime");
                String optString = jSONObject.optString("fileId");
                if (optLong > 0 && !TextUtils.isEmpty(optString)) {
                    loadAlarmVideo(optString);
                }
            } catch (JSONException unused) {
            }
        }
    }

    private void loadAlarmVideo(final String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", this.mCameraDevice.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("fileId", str);
                showProgress();
                clf O000000o2 = clf.O000000o();
                String model = this.mCameraDevice.getModel();
                String jSONObject2 = jSONObject.toString();
                AnonymousClass5 r0 = new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerV2Activity.AnonymousClass5 */

                    public void onSuccess(JSONObject jSONObject) {
                        JSONObject optJSONObject;
                        if (!LocalAlarmPlayerV2Activity.this.isFinishing()) {
                            LocalAlarmPlayerV2Activity.this.hideProgress();
                            if (jSONObject != null && jSONObject.optInt("code") == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                String optString = optJSONObject.optString("videoStoreId");
                                if (!TextUtils.isEmpty(optString)) {
                                    LocalAlarmPlayerV2Activity.this.mAlarItem = new clc();
                                    LocalAlarmPlayerV2Activity.this.mAlarItem.O0000O0o = str;
                                    LocalAlarmPlayerV2Activity.this.mAlarItem.O0000OOo = optString;
                                    LocalAlarmPlayerV2Activity localAlarmPlayerV2Activity = LocalAlarmPlayerV2Activity.this;
                                    localAlarmPlayerV2Activity.getAlarmFile(localAlarmPlayerV2Activity.mAlarItem);
                                }
                            }
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!LocalAlarmPlayerV2Activity.this.isFinishing()) {
                            gsy.O000000o(6, "LocalAlarmPlayerV2Activity", " getAlarmStoreId errorCode:" + i + " :" + str);
                            LocalAlarmPlayerV2Activity.this.hideProgress();
                        }
                    }
                };
                if (!TextUtils.isEmpty(model) && !TextUtils.isEmpty(jSONObject2)) {
                    XmPluginHostApi.instance().callSmartHomeApi(model, "business.smartcamera.", "/miot/camera/app/v1/alarm/videoStoreId", "GET", jSONObject2, new Callback<JSONObject>(r0) {
                        /* class _m_j.clf.AnonymousClass6 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Callback f14050O000000o;

                        {
                            this.f14050O000000o = r2;
                        }

                        public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            Callback callback = this.f14050O000000o;
                            if (callback != null) {
                                callback.onSuccess(jSONObject);
                            }
                        }

                        public final void onFailure(int i, String str) {
                            Callback callback = this.f14050O000000o;
                            if (callback != null) {
                                callback.onFailure(i, str);
                            }
                        }
                    }, Parser.DEFAULT_PARSER);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public long extractVideoDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (!TextUtils.isEmpty(extractMetadata)) {
                long longValue = Long.valueOf(extractMetadata).longValue();
                mediaMetadataRetriever.release();
                return longValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
        mediaMetadataRetriever.release();
        return 0;
    }
}
