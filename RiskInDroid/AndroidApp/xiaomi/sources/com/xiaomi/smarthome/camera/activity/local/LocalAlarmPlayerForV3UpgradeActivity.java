package com.xiaomi.smarthome.camera.activity.local;

import _m_j.civ;
import _m_j.clc;
import _m_j.cle;
import _m_j.clf;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hyy;
import _m_j.izb;
import _m_j.me;
import _m_j.mg;
import _m_j.mk;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
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
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmMp4Player;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.camera.exopackage.MJExoPlayer;
import com.xiaomi.smarthome.camera.view.ControlMatrixView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalAlarmPlayerForV3UpgradeActivity extends CameraBaseActivity implements View.OnClickListener {
    private final int EVENT_UPDATE_PROGRESS = 102;
    CheckBox cbTogglePlay;
    public long curTime = 0;
    public String currentPlayFilePath = null;
    private ControlMatrixView custom_control_matrix;
    private FrameLayout fl_container;
    private boolean isInit = false;
    private boolean isMute = false;
    public boolean isNetShowing = false;
    private boolean isResumed = false;
    ImageView ivFullScreen;
    public boolean mActivePause = false;
    clc mAlarItem;
    cle mAlarmFileManager;
    View mBottomViewContainer;
    private boolean mCanRetry = false;
    public TextView mDurationView;
    ImageView mFullScreenView;
    public boolean mHasStart = false;
    public boolean mIsPlaying = false;
    AnimationDrawable mLoadingAnimation;
    private LocalAudioPlay mLocalAudioPlay = null;
    private boolean mPlayAutoPause = false;
    public TextView mPlayingView;
    SeekBar mProgressBar;
    View mProgressBarContainer;
    private int mRotation = 0;
    private SeekBar.OnSeekBarChangeListener mSeekBarChange = new SeekBar.OnSeekBarChangeListener() {
        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass6 */

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (LocalAlarmPlayerForV3UpgradeActivity.this.mSeekBarTouched) {
                civ.O000000o("LocalAlarmPlayerV2Activity", "onProgressChanged ");
                LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity = LocalAlarmPlayerForV3UpgradeActivity.this;
                localAlarmPlayerForV3UpgradeActivity.curTime = 0;
                localAlarmPlayerForV3UpgradeActivity.mjExoPlayer.seekTo((long) i);
                LocalAlarmPlayerForV3UpgradeActivity.this.mPlayingView.setText(LocalAlarmPlayerForV3UpgradeActivity.convertMMSS(i / 1000));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity = LocalAlarmPlayerForV3UpgradeActivity.this;
            localAlarmPlayerForV3UpgradeActivity.mSeekBarTouched = true;
            localAlarmPlayerForV3UpgradeActivity.mjExoPlayer.pausePlay();
            LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.removeMessages(102);
            civ.O000000o("LocalAlarmPlayerV2Activity", "onStartTrackingTouch ");
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            civ.O000000o("LocalAlarmPlayerV2Activity", "onStopTrackingTouch ");
            if (!LocalAlarmPlayerForV3UpgradeActivity.this.mActivePause) {
                LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity = LocalAlarmPlayerForV3UpgradeActivity.this;
                localAlarmPlayerForV3UpgradeActivity.mSeekBarTouched = false;
                localAlarmPlayerForV3UpgradeActivity.mjExoPlayer.resumePlay();
                LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity2 = LocalAlarmPlayerForV3UpgradeActivity.this;
                localAlarmPlayerForV3UpgradeActivity2.mIsPlaying = true;
                localAlarmPlayerForV3UpgradeActivity2.sendMsgUpdateProgressOnce();
            }
        }
    };
    boolean mSeekBarTouched = false;
    SimpleDateFormat mTimeFormat;
    LinearLayout mToastCenter;
    ImageView mToastImg;
    View mTopViewContainer;
    private String mUrl = "";
    XmMp4Player mVideoPlayerRender;
    XmVideoViewGl mVideoView;
    FrameLayout mVideoViewFrame;
    public MJExoPlayer mjExoPlayer;
    private FrameLayout title_bar;
    public String videoFilePath;
    private ImageView videoMute;

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i != 1 && i != 2) {
            if (i == 3) {
                this.mCanRetry = false;
            } else if (i != 102) {
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
                this.mDurationView.setText(convertMMSS(this.mProgressBar.getMax() / 1000));
                long currentPosition = this.mjExoPlayer.getCurrentPosition();
                if (this.curTime > currentPosition) {
                    this.mHandler.sendEmptyMessageDelayed(102, 100);
                    return;
                }
                if (currentPosition > this.mjExoPlayer.getDuration()) {
                    currentPosition = this.mjExoPlayer.getDuration();
                }
                this.curTime = currentPosition;
                int i2 = (int) ((long) ((((int) (currentPosition + 500)) / 1000) * 1000));
                this.mProgressBar.setProgress(i2);
                this.mPlayingView.setText(convertMMSS(i2 / 1000));
                this.mHandler.sendEmptyMessageDelayed(102, 100);
                if (this.mjExoPlayer.getPlaybackState() == 4) {
                    this.mHandler.removeMessages(102);
                    this.mIsPlaying = false;
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
            }
        }
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_alarm_video_play_for_v3_upgrade);
        AudioManager audioManager = (AudioManager) activity().getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(null, 3, 1);
        }
        this.mAlarmFileManager = this.mCameraDevice.O0000o0o();
        String stringExtra = getIntent().getStringExtra("alarmItem");
        civ.O000000o("LocalAlarmPlayerV2Activity", "fileId:".concat(String.valueOf(stringExtra)));
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mAlarItem = new clc(stringExtra);
        }
        boolean booleanExtra = getIntent().getBooleanExtra("push", false);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        initView();
        initViewNew();
        showNetAlarm();
        if (booleanExtra) {
            this.mCanRetry = true;
            this.mHandler.sendEmptyMessageDelayed(3, 18000);
        }
        if (this.mAlarItem != null) {
            playVideo();
        }
    }

    private void initView() {
        this.videoMute = (ImageView) findViewById(R.id.video_mute);
        this.videoMute.setOnClickListener(this);
        this.mToastCenter = (LinearLayout) findViewById(R.id.toast_container_center);
        this.mToastCenter.setOnClickListener(this);
        this.mToastImg = (ImageView) findViewById(R.id.toast_icon);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_loading);
        this.mToastImg.setImageDrawable(this.mLoadingAnimation);
        this.mToastImg.setOnClickListener(this);
        this.title_bar = (FrameLayout) findViewById(R.id.title_bar);
        findViewById(R.id.title_bar_title);
        this.title_bar.bringToFront();
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mBottomViewContainer = findViewById(R.id.bottom_tools_container);
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
        this.mFullScreenView = (ImageView) findViewById(R.id.full_screen);
        this.cbTogglePlay = (CheckBox) findViewById(R.id.cbTogglePlay);
        this.cbTogglePlay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    LocalAlarmPlayerForV3UpgradeActivity.this.pausePlay();
                    LocalAlarmPlayerForV3UpgradeActivity.this.cbTogglePlay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, LocalAlarmPlayerForV3UpgradeActivity.this.getResources().getDrawable(R.drawable.home_icon_play02), (Drawable) null);
                    return;
                }
                LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity = LocalAlarmPlayerForV3UpgradeActivity.this;
                localAlarmPlayerForV3UpgradeActivity.mIsPlaying = true;
                localAlarmPlayerForV3UpgradeActivity.playVideo();
                LocalAlarmPlayerForV3UpgradeActivity.this.cbTogglePlay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, LocalAlarmPlayerForV3UpgradeActivity.this.getResources().getDrawable(R.drawable.home_icon_pause02), (Drawable) null);
            }
        });
        this.ivFullScreen = (ImageView) findViewById(R.id.ivFullScreen);
        this.ivFullScreen.setOnClickListener(this);
        this.mFullScreenView.setOnClickListener(this);
        findViewById(R.id.flip).setOnClickListener(this);
        findViewById(R.id.local_share).setOnClickListener(this);
        findViewById(R.id.local_delete).setOnClickListener(this);
        findViewById(R.id.local_save).setOnClickListener(this);
    }

    private void initViewNew() {
        this.custom_control_matrix = (ControlMatrixView) findViewById(R.id.custom_control_matrix);
        this.fl_container = (FrameLayout) findViewById(R.id.fl_container);
        this.mjExoPlayer = XmPluginHostApi.instance().createExoPlayer(this, this.fl_container, null, 0);
        this.mjExoPlayer.setVolume(0.0f);
        this.mjExoPlayer.setPlayerListener(new MJExoPlayer.MJExoPlayerListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass2 */

            public void onLoadingChanged(boolean z) {
            }

            public void onPlaybackParametersChanged(float f) {
            }

            public void onPlayerError(int i) {
            }

            public void onPlayerStateChanged(boolean z, int i) {
            }

            public void onPositionDiscontinuity(int i) {
            }

            public void onRepeatModeChanged(int i) {
            }

            public void onSeekProcessed() {
            }

            public void onShuffleModeEnabledChanged(boolean z) {
            }

            public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            }

            public void onVideoSurfaceViewClicked(View view) {
            }

            public void onVideoSurfaceViewLongClicked(View view) {
            }

            public void onRenderedFirstFrame() {
                LocalAlarmPlayerForV3UpgradeActivity.this.mLoadingAnimation.stop();
                long duration = LocalAlarmPlayerForV3UpgradeActivity.this.mjExoPlayer.getDuration();
                gsy.O00000Oo("LocalAlarmPlayerV2Activity", "onRenderedFirstFrame len=".concat(String.valueOf(duration)));
                int i = (((int) (duration + 500)) / 1000) * 1000;
                gsy.O00000Oo("LocalAlarmPlayerV2Activity", "onRenderedFirstFrame max=".concat(String.valueOf(i)));
                LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBar.setMax(i);
                LocalAlarmPlayerForV3UpgradeActivity.this.sendMsgUpdateProgressOnce();
            }
        });
        this.custom_control_matrix.setListener(new ControlMatrixView.ClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass3 */

            public void onClick() {
                if (LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBarContainer.isShown()) {
                    AnimationUtils.loadAnimation(LocalAlarmPlayerForV3UpgradeActivity.this.activity(), R.anim.slide_out_top).setFillAfter(true);
                    Animation loadAnimation = AnimationUtils.loadAnimation(LocalAlarmPlayerForV3UpgradeActivity.this.activity(), R.anim.slide_out_bottom);
                    loadAnimation.setFillAfter(true);
                    LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBarContainer.setClickable(false);
                    LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBarContainer.setVisibility(8);
                    LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBarContainer.startAnimation(loadAnimation);
                    return;
                }
                AnimationUtils.loadAnimation(LocalAlarmPlayerForV3UpgradeActivity.this.activity(), R.anim.slide_in_top).setFillAfter(true);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(LocalAlarmPlayerForV3UpgradeActivity.this.activity(), R.anim.slide_in_bottom);
                loadAnimation2.setFillAfter(true);
                LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBarContainer.setClickable(true);
                LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBarContainer.setVisibility(0);
                LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBarContainer.startAnimation(loadAnimation2);
            }
        });
    }

    public void sendMsgUpdateProgressOnce() {
        this.mHandler.removeMessages(102);
        this.mHandler.sendEmptyMessage(102);
    }

    public void onResume() {
        super.onResume();
        this.isResumed = true;
        MJExoPlayer mJExoPlayer = this.mjExoPlayer;
        if (mJExoPlayer != null) {
            int playbackState = mJExoPlayer.getPlaybackState();
            if (playbackState != 2 && !this.mActivePause) {
                this.curTime = 0;
                this.mjExoPlayer.resumePlay();
                sendMsgUpdateProgressOnce();
            } else if (playbackState == 2) {
                this.curTime = 0;
                this.mjExoPlayer.startPlay(this.mUrl);
                sendMsgUpdateProgressOnce();
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.isResumed = false;
        MJExoPlayer mJExoPlayer = this.mjExoPlayer;
        if (mJExoPlayer != null) {
            mJExoPlayer.pausePlay();
        }
        this.mIsPlaying = false;
        this.mHandler.removeMessages(102);
    }

    public void onStop() {
        super.onStop();
        this.mHandler.removeMessages(102);
    }

    /* access modifiers changed from: package-private */
    public void startPlay() {
        if (!TextUtils.isEmpty(this.currentPlayFilePath) && this.isInit) {
            if (this.isMute) {
                this.mVideoPlayerRender.setVolume(0);
            } else {
                this.mVideoPlayerRender.setVolume(1);
            }
            this.mPlayAutoPause = false;
            this.mVideoPlayerRender.openVideoPlayer(this.currentPlayFilePath);
        }
        this.mHandler.sendEmptyMessage(1);
    }

    public void pausePlay() {
        this.mIsPlaying = false;
        this.mActivePause = true;
        this.mjExoPlayer.pausePlay();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        AnimationDrawable animationDrawable = this.mLoadingAnimation;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.mLoadingAnimation.stop();
        }
        MJExoPlayer mJExoPlayer = this.mjExoPlayer;
        if (mJExoPlayer != null) {
            mJExoPlayer.stopPlay();
        }
        this.mHandler.removeMessages(102);
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(this.mCameraDevice.getModel());
        } else {
            super.onBackPressed();
        }
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
            this.ivFullScreen.setImageResource(R.drawable.alarm_icon_mixscreen);
            return;
        }
        getWindow().clearFlags(1024);
        this.title_bar.setVisibility(0);
        this.title_bar.bringToFront();
        this.mBottomViewContainer.setVisibility(0);
        this.ivFullScreen.setImageResource(R.drawable.alarm_icon_fullscreen);
    }

    private void showNetAlarm() {
        if (!TextUtils.isEmpty(this.mCameraDevice.O0000oOo()) && mg.O00000o0(activity()) && !this.isNetShowing) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
            builder.O00000Oo((int) R.string.push_net_alarm);
            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    LocalAlarmPlayerForV3UpgradeActivity.this.finish();
                }
            });
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass5 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    LocalAlarmPlayerForV3UpgradeActivity.this.isNetShowing = false;
                }
            });
            builder.O00000oo();
            this.isNetShowing = true;
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
        izb.O000000o(activity(), (int) R.string.sdcard_video_download_failed, 0).show();
        civ.O00000o("CameraPlay", "Error alarm ".concat(String.valueOf(str)));
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
    }

    public void hideProgress() {
        if (this.mLoadingAnimation.isRunning()) {
            this.mLoadingAnimation.stop();
        }
        if (this.mToastCenter.getVisibility() == 0) {
            this.mToastCenter.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.local_delete) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
            builder.O000000o((int) R.string.delete_title);
            builder.O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass7 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (LocalAlarmPlayerForV3UpgradeActivity.this.mAlarItem != null) {
                        ArrayList<clc> arrayList = new ArrayList<>();
                        arrayList.add(LocalAlarmPlayerForV3UpgradeActivity.this.mAlarItem);
                        LocalAlarmPlayerForV3UpgradeActivity.this.activity().setResult(-1);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("did", LocalAlarmPlayerForV3UpgradeActivity.this.mCameraDevice.getDid());
                            JSONArray jSONArray = new JSONArray();
                            for (clc clc : arrayList) {
                                jSONArray.put(clc.O0000O0o);
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("fileIds", jSONArray);
                            jSONObject.put("fileIds", jSONObject2);
                            gsy.O00000Oo("LocalAlarmPlayerV2Activity", "jsonObject.toString()=" + jSONObject.toString());
                            clf O000000o2 = clf.O000000o();
                            String model = LocalAlarmPlayerForV3UpgradeActivity.this.mCameraDevice.getModel();
                            String jSONObject3 = jSONObject.toString();
                            AnonymousClass1 r11 = new Callback<JSONObject>() {
                                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass7.AnonymousClass1 */

                                public void onSuccess(JSONObject jSONObject) {
                                    if (!LocalAlarmPlayerForV3UpgradeActivity.this.isFinishing()) {
                                        if (jSONObject == null) {
                                            LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                                            gqg.O000000o((int) R.string.delete_failed);
                                        } else if (jSONObject.optInt("code") == 0) {
                                            LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                                            gqg.O000000o((int) R.string.delete_sucess);
                                        } else {
                                            LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                                            gqg.O000000o((int) R.string.delete_failed);
                                        }
                                        LocalAlarmPlayerForV3UpgradeActivity.this.finish();
                                    }
                                }

                                public void onFailure(int i, String str) {
                                    if (!LocalAlarmPlayerForV3UpgradeActivity.this.isFinishing()) {
                                        LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                                        gqg.O000000o((int) R.string.delete_failed);
                                        LocalAlarmPlayerForV3UpgradeActivity.this.finish();
                                    }
                                }
                            };
                            if (!TextUtils.isEmpty(model)) {
                                XmPluginHostApi.instance().callSmartHomeApi(model, "business.smartcamera.", "/common/app/v2/delete/files", "POST", jSONObject3, new Callback<JSONObject>(r11) {
                                    /* class _m_j.clf.AnonymousClass11 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ Callback f14039O000000o;

                                    {
                                        this.f14039O000000o = r2;
                                    }

                                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        Callback callback = this.f14039O000000o;
                                        if (callback != null) {
                                            callback.onSuccess(jSONObject);
                                        }
                                    }

                                    public final void onFailure(int i, String str) {
                                        Callback callback = this.f14039O000000o;
                                        if (callback != null) {
                                            callback.onFailure(i, str);
                                        }
                                    }
                                }, Parser.DEFAULT_PARSER);
                            }
                        } catch (JSONException unused) {
                            LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                            gqg.O000000o((int) R.string.delete_failed);
                            LocalAlarmPlayerForV3UpgradeActivity.this.finish();
                        }
                    }
                }
            });
            builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            builder.O00000oo();
        } else if (id == R.id.local_share) {
            onShareClicked();
        } else if (id == R.id.local_save) {
            startDownloadVideo(false);
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
                        this.mjExoPlayer.setVolume(1.0f);
                        return;
                    }
                    this.videoMute.setImageResource(R.drawable.camera_alarm_icon_mute);
                    this.isMute = true;
                    this.mjExoPlayer.setVolume(0.0f);
                } else if (id == R.id.ivFullScreen) {
                    if (!this.mFullScreen) {
                        enterPadFullScreen();
                        setOrientation(true);
                        return;
                    }
                    setOrientation(false);
                } else if (id == R.id.toast_icon) {
                    hideFail();
                    if (this.mAlarItem != null) {
                        playVideo();
                    }
                }
            }
        }
    }

    public void onShareClicked() {
        civ.O000000o("LocalAlarmPlayerV2Activity", "分享了 videoFilePath=" + this.videoFilePath);
        if (TextUtils.isEmpty(this.videoFilePath)) {
            startDownloadVideo(true);
        } else if (!new File(this.videoFilePath).exists()) {
            startDownloadVideo(true);
        } else {
            toShare(this.videoFilePath);
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
            final String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                new Thread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass8 */

                    public void run() {
                        try {
                            LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(16);
                            FileInputStream fileInputStream = new FileInputStream(LocalAlarmPlayerForV3UpgradeActivity.this.currentPlayFilePath);
                            FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream.close();
                            LocalAlarmPlayerForV3UpgradeActivity.this.toShare(O000000o2);
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(17);
                            throw th;
                        }
                        LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(17);
                    }
                }).start();
                return;
            }
            return;
        }
        this.mHandler.sendEmptyMessage(15);
    }

    public void toShare(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (XmPluginHostApi.instance().getApiLevel() >= 29) {
            CameraJumpUtils.openShareActivity(this, "", "", str, 17);
        } else {
            CameraJumpUtils.openShareActivity(this, "", "", str);
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
            final String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                new Thread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass9 */

                    public void run() {
                        try {
                            LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(16);
                            FileInputStream fileInputStream = new FileInputStream(LocalAlarmPlayerForV3UpgradeActivity.this.currentPlayFilePath);
                            FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream.close();
                            fileOutputStream.close();
                            LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(14);
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(17);
                            throw th;
                        }
                        LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(17);
                    }
                }).start();
                return;
            }
            return;
        }
        this.mHandler.sendEmptyMessage(15);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    private void startDownloadVideo(final boolean z) {
        this.videoFilePath = me.O000000o(true, this.mCameraDevice.getDid());
        if (TextUtils.isEmpty(this.videoFilePath)) {
            this.videoFilePath = me.O000000o(true, this.mCameraDevice.getDid());
        }
        gsy.O00000Oo("LocalAlarmPlayerV2Activity", "startDownloadVideo videoFilePath=" + this.videoFilePath);
        if (!mk.O000000o(activity(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            activity();
            gqg.O000000o(activity().getString(R.string.no_write_permission));
        } else if (!this.mHasStart) {
            this.mHandler.sendEmptyMessage(16);
            this.mHasStart = true;
            this.mCameraDevice.O0000o0o();
            cle.O000000o(this.mDeviceStat.model, this.mDeviceStat.did, this.mAlarItem.O0000O0o, this.videoFilePath, new clf.O000000o() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass10 */

                public void onProgress(int i) {
                }

                public void onStart() {
                    gsy.O00000Oo("LocalAlarmPlayerV2Activity", "startDownloadVideo onStart");
                }

                public void onComplete() {
                    gsy.O00000Oo("LocalAlarmPlayerV2Activity", "startDownloadVideo onComplete");
                    LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity = LocalAlarmPlayerForV3UpgradeActivity.this;
                    localAlarmPlayerForV3UpgradeActivity.mHasStart = false;
                    localAlarmPlayerForV3UpgradeActivity.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass10.AnonymousClass1 */

                        public void run() {
                            LocalAlarmPlayerForV3UpgradeActivity.this.hideProgress();
                            if (z) {
                                LocalAlarmPlayerForV3UpgradeActivity.this.toShare(LocalAlarmPlayerForV3UpgradeActivity.this.videoFilePath);
                                return;
                            }
                            LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(14);
                            LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(17);
                        }
                    });
                }

                public void onError(final int i, String str) {
                    gsy.O00000Oo("LocalAlarmPlayerV2Activity", "startDownloadVideo onError");
                    LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity = LocalAlarmPlayerForV3UpgradeActivity.this;
                    localAlarmPlayerForV3UpgradeActivity.mHasStart = false;
                    File file = new File(localAlarmPlayerForV3UpgradeActivity.videoFilePath);
                    if (file.exists()) {
                        file.delete();
                    }
                    LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass10.AnonymousClass2 */

                        public void run() {
                            LocalAlarmPlayerForV3UpgradeActivity.this.hideProgress();
                            int i = i;
                            if (i == 1002) {
                                gqg.O000000o(LocalAlarmPlayerForV3UpgradeActivity.this.activity(), LocalAlarmPlayerForV3UpgradeActivity.this.getString(R.string.net_wrong), 0);
                            } else if (i == 103) {
                                if (z) {
                                    LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                                    gqg.O000000o((int) R.string.share_fail, 0);
                                    return;
                                }
                                LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                                gqg.O000000o((int) R.string.download_fail, 0);
                            } else if (i == -4001) {
                                LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                                gqg.O000000o((int) R.string.no_write_permission, 0);
                            } else {
                                Activity activity = LocalAlarmPlayerForV3UpgradeActivity.this.activity();
                                gqg.O000000o(activity, LocalAlarmPlayerForV3UpgradeActivity.this.getString(R.string.download_err) + i, 0);
                            }
                        }
                    });
                    LocalAlarmPlayerForV3UpgradeActivity.this.mHandler.sendEmptyMessage(17);
                }
            });
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

    private void getAlarmFile(clc clc) {
        showProgress();
        this.mCameraDevice.O0000o0o().O000000o(this, clc, new cle.O000000o<String>() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerForV3UpgradeActivity.AnonymousClass11 */

            public void onSuccess(String str, Object obj) {
                if (!LocalAlarmPlayerForV3UpgradeActivity.this.isFinishing()) {
                    LocalAlarmPlayerForV3UpgradeActivity.this.hideProgress();
                    civ.O000000o("LocalAlarmPlayerV2Activity", "result mCurrentPath:".concat(String.valueOf(str)));
                    if (!TextUtils.isEmpty(str)) {
                        LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity = LocalAlarmPlayerForV3UpgradeActivity.this;
                        localAlarmPlayerForV3UpgradeActivity.currentPlayFilePath = str;
                        if (!TextUtils.isEmpty(localAlarmPlayerForV3UpgradeActivity.currentPlayFilePath)) {
                            LocalAlarmPlayerForV3UpgradeActivity localAlarmPlayerForV3UpgradeActivity2 = LocalAlarmPlayerForV3UpgradeActivity.this;
                            long extractVideoDuration = localAlarmPlayerForV3UpgradeActivity2.extractVideoDuration(localAlarmPlayerForV3UpgradeActivity2.currentPlayFilePath);
                            LocalAlarmPlayerForV3UpgradeActivity.this.mProgressBar.setMax((int) (extractVideoDuration / 1000));
                            TextView textView = LocalAlarmPlayerForV3UpgradeActivity.this.mDurationView;
                            textView.setText(LocalAlarmPlayerForV3UpgradeActivity.this.mTimeFormat.format(Long.valueOf(extractVideoDuration)));
                        }
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!LocalAlarmPlayerForV3UpgradeActivity.this.isFinishing()) {
                    LocalAlarmPlayerForV3UpgradeActivity.this.hideProgress();
                    LocalAlarmPlayerForV3UpgradeActivity.this.showFail(String.valueOf(i));
                    LocalAlarmPlayerForV3UpgradeActivity.this.currentPlayFilePath = null;
                    civ.O000000o("LocalAlarmPlayerV2Activity", "errorCode:" + i + " errorMessage:" + str);
                }
            }
        });
    }

    public void playVideo() {
        gsy.O00000Oo("LocalAlarmPlayerV2Activity", "走了playVideo");
        this.mActivePause = false;
        this.curTime = 0;
        if (this.isMute) {
            this.mjExoPlayer.setVolume(0.0f);
        } else {
            this.mjExoPlayer.setVolume(1.0f);
        }
        gsy.O00000Oo("LocalAlarmPlayerV2Activity", "播放前的视屏地址mUrl=" + this.mUrl);
        if (TextUtils.isEmpty(this.mUrl)) {
            this.mCameraDevice.O0000o0o();
            this.mUrl = cle.O000000o(this.mDeviceStat.model, this.mDeviceStat.did, this.mAlarItem.O0000O0o);
            gsy.O00000Oo("LocalAlarmPlayerV2Activity", "m3u8 URL=" + this.mUrl);
            this.mjExoPlayer.startPlay(this.mUrl);
        } else if (this.mjExoPlayer.getPlaybackState() == 3) {
            this.mjExoPlayer.resumePlay();
        } else if (this.mjExoPlayer.getPlaybackState() == 4) {
            this.mjExoPlayer.startPlay(this.mUrl);
            this.mDurationView.setText(convertMMSS(0));
            this.mProgressBar.setProgress(0);
        }
        this.mIsPlaying = true;
        sendMsgUpdateProgressOnce();
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

    public static String convertMMSS(int i) {
        String str;
        int i2 = i % 3600;
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        if (i3 < 10) {
            str = "" + "0" + i3;
        } else {
            str = "" + i3;
        }
        if (i4 < 10) {
            return str + ":0" + i4;
        }
        return str + ":" + i4;
    }
}
