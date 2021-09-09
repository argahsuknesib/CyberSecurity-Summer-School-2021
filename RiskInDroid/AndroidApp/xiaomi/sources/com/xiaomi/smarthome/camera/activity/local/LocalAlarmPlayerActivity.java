package com.xiaomi.smarthome.camera.activity.local;

import _m_j.cin;
import _m_j.civ;
import _m_j.clb;
import _m_j.cld;
import _m_j.clg;
import _m_j.clj;
import _m_j.fsa;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.izb;
import _m_j.me;
import _m_j.mg;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
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
import com.Utils.MediaStoreUtil;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmMp4Player;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class LocalAlarmPlayerActivity extends CameraBaseActivity implements View.OnClickListener {
    CheckBox cbTogglePlay;
    public boolean isFromRn;
    public boolean isInit = false;
    private boolean isMute = false;
    public boolean isNetShowing = false;
    ImageView ivFullScreen;
    clb mAlarItem;
    cld mAlarmFileManager;
    private long mAlarmTime = 0;
    View mBottomViewContainer;
    public boolean mCanRetry = false;
    public TextView mDurationView;
    ImageView mFullScreenView;
    AnimationDrawable mLoadingAnimation;
    private LocalAudioPlay mLocalAudioPlay = null;
    clj.O000000o mLocalFile;
    private boolean mNeedCheck = false;
    protected boolean mNeedPincode = false;
    clg.O00000Oo mOnDownloadListener = new clg.O00000Oo() {
        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass8 */

        public void onDownloading(clg.O000000o o000000o, String str, final int i) {
            if (LocalAlarmPlayerActivity.this.mAlarItem != null && o000000o.f14062O000000o.O00000Oo == LocalAlarmPlayerActivity.this.mAlarItem.O00000Oo) {
                LocalAlarmPlayerActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass8.AnonymousClass1 */

                    public void run() {
                        LocalAlarmPlayerActivity.this.mToastText.setText(LocalAlarmPlayerActivity.this.getString(R.string.mj_loading) + i + "%");
                    }
                });
            }
        }

        public void onDownloadSuccess(clg.O000000o o000000o, final String str) {
            if (LocalAlarmPlayerActivity.this.mAlarItem != null && o000000o.f14062O000000o.O00000Oo == LocalAlarmPlayerActivity.this.mAlarItem.O00000Oo) {
                LocalAlarmPlayerActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass8.AnonymousClass2 */

                    public void run() {
                        LocalAlarmPlayerActivity.this.hideProgress();
                        LocalAlarmPlayerActivity.this.mLocalFile = LocalAlarmPlayerActivity.this.mCameraDevice.O0000O0o().O00000Oo(str);
                        TextView textView = (TextView) LocalAlarmPlayerActivity.this.findViewById(R.id.title_bar_title);
                        if (LocalAlarmPlayerActivity.this.mLocalFile != null) {
                            textView.setText(LocalAlarmPlayerActivity.this.mLocalFile.O00000o0.getName());
                            LocalAlarmPlayerActivity.this.mDurationView.setText(LocalAlarmPlayerActivity.this.mTimeFormat.format(new Date(LocalAlarmPlayerActivity.this.mLocalFile.O00000Oo)));
                            LocalAlarmPlayerActivity.this.mProgressBar.setMax((int) (LocalAlarmPlayerActivity.this.mLocalFile.O00000Oo / 1000));
                            if (LocalAlarmPlayerActivity.this.isInit) {
                                LocalAlarmPlayerActivity.this.startPlay();
                            }
                        }
                    }
                });
            }
        }

        public void onDownloadFailed(clg.O000000o o000000o, String str, int i, final String str2) {
            if (LocalAlarmPlayerActivity.this.mAlarItem != null && o000000o.f14062O000000o.O00000Oo == LocalAlarmPlayerActivity.this.mAlarItem.O00000Oo) {
                LocalAlarmPlayerActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass8.AnonymousClass3 */

                    public void run() {
                        if (LocalAlarmPlayerActivity.this.mCanRetry) {
                            LocalAlarmPlayerActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass8.AnonymousClass3.AnonymousClass1 */

                                public void run() {
                                    LocalAlarmPlayerActivity.this.doDown();
                                }
                            }, 2000);
                            return;
                        }
                        LocalAlarmPlayerActivity.this.mLocalFile = null;
                        LocalAlarmPlayerActivity.this.showFail(str2);
                    }
                });
            }
        }
    };
    public boolean mPlayAutoPause = false;
    public TextView mPlayingView;
    SeekBar mProgressBar;
    View mProgressBarContainer;
    private int mRotation = 0;
    private SeekBar.OnSeekBarChangeListener mSeekBarChange = new SeekBar.OnSeekBarChangeListener() {
        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass14 */

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (LocalAlarmPlayerActivity.this.mSeekBarTouched) {
                LocalAlarmPlayerActivity.this.mHandler.removeMessages(2);
                LocalAlarmPlayerActivity.this.mPlayingView.setText(LocalAlarmPlayerActivity.this.mTimeFormat.format(Integer.valueOf(i * 1000)));
                Message obtainMessage = LocalAlarmPlayerActivity.this.mHandler.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i;
                obtainMessage.sendToTarget();
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            LocalAlarmPlayerActivity.this.mSeekBarTouched = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            LocalAlarmPlayerActivity.this.mSeekBarTouched = false;
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
    private boolean skipPwd;
    private FrameLayout title_bar;
    private ImageView videoMute;

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 1) {
            this.mHandler.removeMessages(1);
            if (!this.mSeekBarTouched) {
                int currentPosition = this.mVideoPlayerRender.getCurrentPosition();
                this.mPlayingView.setText(this.mTimeFormat.format(Integer.valueOf(currentPosition)));
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
        setContentView((int) R.layout.camera_activity_alarm_video_play);
        this.mNeedCheck = getIntent().getBooleanExtra("check", false);
        this.skipPwd = getIntent().getBooleanExtra("skipPwd", false);
        this.isFromRn = getIntent().getBooleanExtra("isFromRn", false);
        civ.O00000o("alarm", "need check " + this.mNeedCheck);
        if ((TextUtils.isEmpty(XmPluginHostApi.instance().getDevicePincode(this.mDid)) || this.mNeedCheck) && !this.skipPwd) {
            globalPinCodeVerifyFunc();
            civ.O00000o("alarm", "enableVerifyPincode " + this.mDeviceStat.isSetPinCode);
            if (this.mCameraDevice.O0000oO()) {
                this.mNeedPincode = true;
                civ.O00000o("alarm", "need pincode ");
            }
        }
        long j = this.mAlarmTime;
        if (j > 0) {
            this.mAlarItem = this.mAlarmFileManager.O000000o(j);
        }
        AudioManager audioManager = (AudioManager) activity().getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(null, 3, 1);
        }
        this.mAlarmFileManager = this.mCameraDevice.O0000o0O();
        this.mAlarmTime = getIntent().getLongExtra("time", 0) * 1000;
        boolean booleanExtra = getIntent().getBooleanExtra("push", false);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        initView();
        showNetAlarm();
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
        this.title_bar = (FrameLayout) findViewById(R.id.title_bar);
        TextView textView = (TextView) findViewById(R.id.title_bar_title);
        this.title_bar.bringToFront();
        clj.O000000o o000000o = this.mLocalFile;
        if (o000000o != null) {
            textView.setText(o000000o.O00000o0.getName());
        }
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mBottomViewContainer = findViewById(R.id.bottom_tools_container);
        this.mTopViewContainer = findViewById(R.id.top_tools_container);
        this.mProgressBarContainer = findViewById(R.id.progress_bar_container);
        this.mProgressBar = (SeekBar) findViewById(R.id.progress_bar);
        this.mDurationView = (TextView) findViewById(R.id.progress_duration);
        this.mPlayingView = (TextView) findViewById(R.id.progress_playtime);
        clj.O000000o o000000o2 = this.mLocalFile;
        if (o000000o2 != null) {
            this.mProgressBar.setMax((int) (o000000o2.O00000Oo / 1000));
            this.mDurationView.setText(this.mTimeFormat.format(new Date(this.mLocalFile.O00000Oo)));
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
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass1 */

            public void onCompletion(MediaPlayer mediaPlayer) {
                LocalAlarmPlayerActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        LocalAlarmPlayerActivity.this.mHandler.removeMessages(1);
                        LocalAlarmPlayerActivity.this.mProgressBar.setProgress(LocalAlarmPlayerActivity.this.mProgressBar.getMax());
                        LocalAlarmPlayerActivity.this.mPlayingView.setText(LocalAlarmPlayerActivity.this.mDurationView.getText());
                        LocalAlarmPlayerActivity.this.cbTogglePlay.setChecked(true);
                        if (LocalAlarmPlayerActivity.this.mProgressBarContainer.getVisibility() == 8) {
                            AnimationUtils.loadAnimation(LocalAlarmPlayerActivity.this.activity(), R.anim.slide_in_top).setFillAfter(true);
                            Animation loadAnimation = AnimationUtils.loadAnimation(LocalAlarmPlayerActivity.this.activity(), R.anim.slide_in_bottom);
                            loadAnimation.setFillAfter(true);
                            LocalAlarmPlayerActivity.this.mProgressBarContainer.setClickable(true);
                            LocalAlarmPlayerActivity.this.mProgressBarContainer.setVisibility(0);
                            LocalAlarmPlayerActivity.this.mProgressBarContainer.startAnimation(loadAnimation);
                        }
                    }
                });
            }
        });
        this.mVideoPlayerRender.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass2 */

            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                LocalAlarmPlayerActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        LocalAlarmPlayerActivity.this.mProgressBar.setProgress(LocalAlarmPlayerActivity.this.mVideoPlayerRender.getCurrentPosition() / 1000);
                        LocalAlarmPlayerActivity.this.mPlayingView.setText(LocalAlarmPlayerActivity.this.mTimeFormat.format(Integer.valueOf(LocalAlarmPlayerActivity.this.mVideoPlayerRender.getCurrentPosition())));
                        LocalAlarmPlayerActivity.this.cbTogglePlay.setChecked(true);
                    }
                });
                return true;
            }
        });
        this.mVideoView.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass3 */

            public void onVideoViewClick() {
                if (LocalAlarmPlayerActivity.this.mProgressBarContainer.isShown()) {
                    AnimationUtils.loadAnimation(LocalAlarmPlayerActivity.this.activity(), R.anim.slide_out_top).setFillAfter(true);
                    Animation loadAnimation = AnimationUtils.loadAnimation(LocalAlarmPlayerActivity.this.activity(), R.anim.slide_out_bottom);
                    loadAnimation.setFillAfter(true);
                    LocalAlarmPlayerActivity.this.mProgressBarContainer.setClickable(false);
                    LocalAlarmPlayerActivity.this.mProgressBarContainer.setVisibility(8);
                    LocalAlarmPlayerActivity.this.mProgressBarContainer.startAnimation(loadAnimation);
                    return;
                }
                AnimationUtils.loadAnimation(LocalAlarmPlayerActivity.this.activity(), R.anim.slide_in_top).setFillAfter(true);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(LocalAlarmPlayerActivity.this.activity(), R.anim.slide_in_bottom);
                loadAnimation2.setFillAfter(true);
                LocalAlarmPlayerActivity.this.mProgressBarContainer.setClickable(true);
                LocalAlarmPlayerActivity.this.mProgressBarContainer.setVisibility(0);
                LocalAlarmPlayerActivity.this.mProgressBarContainer.startAnimation(loadAnimation2);
            }
        });
        this.mFullScreenView = (ImageView) findViewById(R.id.full_screen);
        this.cbTogglePlay = (CheckBox) findViewById(R.id.cbTogglePlay);
        this.cbTogglePlay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass4 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    LocalAlarmPlayerActivity.this.pausePlay();
                    LocalAlarmPlayerActivity.this.cbTogglePlay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, LocalAlarmPlayerActivity.this.getResources().getDrawable(R.drawable.camera_icon_play02), (Drawable) null);
                    return;
                }
                LocalAlarmPlayerActivity.this.startPlay();
                LocalAlarmPlayerActivity.this.cbTogglePlay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, LocalAlarmPlayerActivity.this.getResources().getDrawable(R.drawable.camera_icon_pause02), (Drawable) null);
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
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass5 */

            public void onInitialed() {
                LocalAlarmPlayerActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass5.AnonymousClass1 */

                    public void run() {
                        LocalAlarmPlayerActivity.this.isInit = true;
                        if (LocalAlarmPlayerActivity.this.mLocalFile != null) {
                            LocalAlarmPlayerActivity.this.startPlay();
                        }
                    }
                });
            }
        });
        this.mCameraDevice.O0000o().O000000o(this.mOnDownloadListener);
    }

    public void onResume() {
        super.onResume();
        String devicePincode = XmPluginHostApi.instance().getDevicePincode(this.mDid);
        civ.O00000o("alarm", "onResume ".concat(String.valueOf(devicePincode)));
        if (TextUtils.isEmpty(this.mCameraDevice.O0000oOo())) {
            civ.O00000o("alarm", "isEmpty ");
            if (!this.mNeedPincode || !TextUtils.isEmpty(devicePincode)) {
                this.mCameraDevice.O00000Oo(new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass6 */

                    public void onSuccess(Void voidR) {
                        if (!LocalAlarmPlayerActivity.this.isFinishing() && LocalAlarmPlayerActivity.this.mLocalFile == null) {
                            LocalAlarmPlayerActivity.this.showNetAlarm();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!LocalAlarmPlayerActivity.this.isFinishing()) {
                            LocalAlarmPlayerActivity.this.activity();
                            gqg.O000000o((int) R.string.camera_play_error2);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(devicePincode) && this.mLocalFile == null && this.mNeedCheck) {
            showNetAlarm();
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass7 */

            public void run() {
                if (LocalAlarmPlayerActivity.this.mPlayAutoPause) {
                    LocalAlarmPlayerActivity.this.startPlay();
                }
            }
        }, 500);
    }

    public void onPause() {
        super.onPause();
        XmMp4Player xmMp4Player = this.mVideoPlayerRender;
        if (xmMp4Player != null && xmMp4Player.isPlaying()) {
            pausePlay();
            this.mPlayAutoPause = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void startPlay() {
        clj.O000000o o000000o = this.mLocalFile;
        if (!(o000000o == null || o000000o.O00000o0 == null)) {
            if (this.isMute) {
                this.mVideoPlayerRender.setVolume(0);
            } else {
                this.mVideoPlayerRender.setVolume(1);
            }
            this.mVideoPlayerRender.openVideoPlayer(this.mLocalFile.O00000o0.getAbsolutePath());
            this.mPlayAutoPause = false;
        }
        this.mHandler.sendEmptyMessage(1);
    }

    public void pausePlay() {
        this.mVideoPlayerRender.pause();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mCameraDevice != null) {
            clg O0000o = this.mCameraDevice.O0000o();
            clg.O00000Oo o00000Oo = this.mOnDownloadListener;
            if (O0000o.O00000o0 != null && O0000o.O00000o0.equals(o00000Oo)) {
                O0000o.O00000o0 = null;
            }
        }
        this.mHandler.removeMessages(1);
        AnimationDrawable animationDrawable = this.mLoadingAnimation;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.mLoadingAnimation.stop();
        }
        this.mOnDownloadListener = null;
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
        if (1 != getRequestedOrientation()) {
            setOrientation(false);
            return;
        }
        if (count == 1 && this.isV4 && !this.isFromRn) {
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
    }

    private void setWindow(Configuration configuration) {
        if (configuration.orientation != 1) {
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
        this.mBottomViewContainer.setVisibility(0);
        this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2);
        this.mVideoView.setVideoFrameSize(-1, -1, false);
    }

    public void showNetAlarm() {
        if (TextUtils.isEmpty(this.mCameraDevice.O0000oOo())) {
            this.mCameraDevice.O00000Oo(new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass9 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Void voidR) {
                    LocalAlarmPlayerActivity.this.showNetAlarm();
                }
            });
        } else if (!mg.O00000o0(activity())) {
            doDown();
        } else if (!this.isNetShowing) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
            builder.O00000Oo((int) R.string.push_net_alarm);
            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass10 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    LocalAlarmPlayerActivity.this.finish();
                }
            });
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass11 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    LocalAlarmPlayerActivity.this.doDown();
                }
            });
            builder.O000000o(new MLAlertDialog.O000000o() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass12 */

                public void beforeDismissCallBack() {
                }

                public void afterDismissCallBack() {
                    LocalAlarmPlayerActivity.this.isNetShowing = false;
                }
            });
            builder.O00000oo();
            this.isNetShowing = true;
        }
    }

    public void doDown() {
        showProgress();
        if (this.mAlarItem != null) {
            this.mCameraDevice.O0000o().O000000o(this.mAlarItem);
        } else {
            this.mAlarmFileManager.O000000o(this.mAlarmTime, new Callback<clb>() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass13 */

                public void onSuccess(clb clb) {
                    LocalAlarmPlayerActivity localAlarmPlayerActivity = LocalAlarmPlayerActivity.this;
                    localAlarmPlayerActivity.mAlarItem = clb;
                    if (localAlarmPlayerActivity.mAlarItem != null) {
                        LocalAlarmPlayerActivity.this.mCameraDevice.O0000o().O000000o(LocalAlarmPlayerActivity.this.mAlarItem);
                    } else {
                        LocalAlarmPlayerActivity.this.showFail("no file");
                    }
                }

                public void onFailure(int i, String str) {
                    LocalAlarmPlayerActivity.this.showFail(str);
                }
            });
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
        this.mToastCenter.setTag(1);
        izb.O000000o(activity(), (int) R.string.sdcard_video_download_failed, 0).show();
        civ.O00000o("CameraPlay", "Error alarm ".concat(String.valueOf(str)));
    }

    private void showProgress() {
        if (this.mToastCenter.getVisibility() == 8) {
            this.mToastCenter.setVisibility(0);
        }
        this.mToastImg.setImageDrawable(this.mLoadingAnimation);
        this.mLoadingAnimation.start();
        this.mToastCenter.setTag(null);
        this.mToastText.setText(getString(R.string.mj_loading) + 0 + "%");
    }

    public void hideProgress() {
        if (this.mLoadingAnimation.isRunning()) {
            this.mLoadingAnimation.stop();
        }
        if (this.mToastCenter.getVisibility() == 0) {
            this.mToastCenter.setVisibility(8);
            this.mToastCenter.setTag(null);
            this.mToastText.setText("");
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.local_delete) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
            builder.O000000o((int) R.string.delete_title);
            builder.O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass15 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (LocalAlarmPlayerActivity.this.mAlarItem != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(LocalAlarmPlayerActivity.this.mAlarItem);
                        LocalAlarmPlayerActivity.this.activity().setResult(-1);
                        LocalAlarmPlayerActivity.this.mAlarmFileManager.O000000o(arrayList, new Callback<Void>() {
                            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass15.AnonymousClass1 */

                            public void onSuccess(Void voidR) {
                                if (!LocalAlarmPlayerActivity.this.isFinishing()) {
                                    if (LocalAlarmPlayerActivity.this.mLocalFile != null) {
                                        LocalAlarmPlayerActivity.this.mLocalFile.O00000o0.delete();
                                    }
                                    LocalAlarmPlayerActivity.this.runMainThread(new Runnable() {
                                        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass15.AnonymousClass1.AnonymousClass1 */

                                        public void run() {
                                            izb.O000000o(LocalAlarmPlayerActivity.this.activity(), (int) R.string.local_file_delete_success, 0).show();
                                            LocalAlarmPlayerActivity.this.finish();
                                        }
                                    });
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (!LocalAlarmPlayerActivity.this.isFinishing()) {
                                    LocalAlarmPlayerActivity.this.runMainThread(new Runnable() {
                                        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass15.AnonymousClass1.AnonymousClass2 */

                                        public void run() {
                                            izb.O000000o(LocalAlarmPlayerActivity.this.activity(), (int) R.string.local_file_delete_failed, 0).show();
                                        }
                                    });
                                }
                            }
                        });
                    }
                }
            });
            builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            builder.O00000oo();
        } else if (id == R.id.local_share) {
            if (this.mLocalFile != null) {
                CameraJumpUtils.openShareActivity(activity(), "", "", this.mLocalFile.O00000o0.getAbsolutePath(), 1);
            }
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
                doDown();
            } else if (id == R.id.video_mute) {
                if (this.isMute) {
                    this.videoMute.setImageResource(R.drawable.camera_alarm_icon_unmute);
                    this.isMute = false;
                    this.mVideoPlayerRender.setVolume(1);
                    return;
                }
                this.videoMute.setImageResource(R.drawable.camera_alarm_icon_mute);
                this.isMute = true;
                this.mVideoPlayerRender.setVolume(0);
            } else if (id != R.id.ivFullScreen) {
            } else {
                if (1 == getRequestedOrientation()) {
                    setOrientation(true);
                } else {
                    setOrientation(false);
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    private void saveMediaFile() {
        clj.O000000o o000000o = this.mLocalFile;
        if (o000000o == null || o000000o.O00000o0 == null || TextUtils.isEmpty(this.mLocalFile.O00000o0.getAbsolutePath())) {
            this.mHandler.sendEmptyMessage(15);
            return;
        }
        final String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
        if (!TextUtils.isEmpty(O000000o2)) {
            new Thread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity.AnonymousClass16 */

                /* JADX WARNING: Removed duplicated region for block: B:47:0x00dc A[SYNTHETIC, Splitter:B:47:0x00dc] */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x00f6 A[SYNTHETIC, Splitter:B:52:0x00f6] */
                /* JADX WARNING: Removed duplicated region for block: B:60:0x0119 A[SYNTHETIC, Splitter:B:60:0x0119] */
                /* JADX WARNING: Removed duplicated region for block: B:65:0x0133 A[SYNTHETIC, Splitter:B:65:0x0133] */
                public void run() {
                    FileOutputStream fileOutputStream;
                    if (LocalAlarmPlayerActivity.this.isFromRn) {
                        try {
                            LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(16);
                            MediaStoreUtil.O00000Oo(LocalAlarmPlayerActivity.this.getContext(), LocalAlarmPlayerActivity.this.mLocalFile.O00000o0.getAbsolutePath(), LocalAlarmPlayerActivity.this.mDid, LocalAlarmPlayerActivity.this.mLocalFile.O00000o0.getName());
                            LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(14);
                        } catch (Exception unused) {
                            LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                        }
                    } else {
                        FileInputStream fileInputStream = null;
                        try {
                            LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(16);
                            FileInputStream fileInputStream2 = new FileInputStream(LocalAlarmPlayerActivity.this.mLocalFile.O00000o0.getAbsolutePath());
                            try {
                                fileOutputStream = new FileOutputStream(O000000o2);
                            } catch (IOException e) {
                                e = e;
                                fileOutputStream = null;
                                fileInputStream = fileInputStream2;
                                try {
                                    gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e2) {
                                            gsy.O000000o(6, "alarm", e2.getLocalizedMessage());
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e3) {
                                            gsy.O000000o(6, "alarm", e3.getLocalizedMessage());
                                        }
                                    }
                                    LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e4) {
                                            gsy.O000000o(6, "alarm", e4.getLocalizedMessage());
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                            gsy.O000000o(6, "alarm", e5.getLocalizedMessage());
                                        }
                                    }
                                    LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                                throw th;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = fileInputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(14);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e6) {
                                    gsy.O000000o(6, "alarm", e6.getLocalizedMessage());
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    gsy.O000000o(6, "alarm", e7.getLocalizedMessage());
                                }
                                LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                            } catch (IOException e8) {
                                e = e8;
                                fileInputStream = fileInputStream2;
                                gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                                throw th;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            fileOutputStream = null;
                            gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = null;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            LocalAlarmPlayerActivity.this.mHandler.sendEmptyMessage(17);
                            throw th;
                        }
                    }
                }
            }).start();
        }
    }

    /* access modifiers changed from: protected */
    public void setOrientation(boolean z) {
        if (z) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }
}
