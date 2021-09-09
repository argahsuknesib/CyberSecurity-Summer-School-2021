package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.C0118cif;
import _m_j.chr;
import _m_j.chv;
import _m_j.chx;
import _m_j.cin;
import _m_j.civ;
import _m_j.ciw;
import _m_j.ckq;
import _m_j.clj;
import _m_j.cln;
import _m_j.ft;
import _m_j.ftn;
import _m_j.goq;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hyy;
import _m_j.me;
import _m_j.mg;
import _m_j.mi;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicReviewActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity;
import com.xiaomi.smarthome.camera.v4.utils.CameraToastUtil;
import com.xiaomi.smarthome.camera.view.TextViewS;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineWithDatePickView;
import com.xiaomi.smarthome.camera.view.widget.CenterDrawableCheckBox;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class SDCardTimeLinePlayerActivity extends CameraPlayerBaseActivity {
    private int UPDATE_DURATION = 500;
    public CenterDrawableCheckBox cdcCameraRecord;
    private CenterDrawableCheckBox cdcToggleAudio;
    private ImageView cdcTogglePlay;
    boolean isFirst = true;
    private boolean isInEnding = false;
    private boolean isOnFileEnd;
    boolean isVideoPlaying = true;
    private ImageView ivCameraShot;
    private ImageView ivFullScreen;
    public LinearLayout land_bottom_ctrl_ll;
    public LinearLayout llFuncPopup;
    private LinearLayout llVideoViewBottomCtrl;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass14 */

        public void onReceive(Context context, Intent intent) {
            if (SDCardTimeLinePlayerActivity.this.mCameraSdcardFileManager.O00000oO().equals(intent.getAction()) && !SDCardTimeLinePlayerActivity.this.isFinishing()) {
                SDCardTimeLinePlayerActivity.this.mTimeLineControlView.setTimeItems(SDCardTimeLinePlayerActivity.this.mCameraSdcardFileManager.O00000oo());
                SDCardTimeLinePlayerActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass14.AnonymousClass1 */

                    public void run() {
                        if (SDCardTimeLinePlayerActivity.this.isFirst) {
                            SDCardTimeLinePlayerActivity.this.startPlay();
                        }
                    }
                });
            }
        }
    };
    public cln mCameraSdcardFileManager;
    public int mCurrentTime = 0;
    private Date mDate;
    private int mDay;
    private int mDuration;
    private int mEndTime;
    private FrameLayout mFLTitleBar;
    private int mHour;
    private boolean mIsSetPlayTime;
    private boolean mIsSetTime = false;
    private int mLastOffsetTime = 0;
    private long mLastSetPlayTime;
    private int mLastSetStart;
    private long mLastSetTime = 0;
    public int mLastTime = 0;
    private long mLastUpdateTime = 0;
    private ft mLocalBroadcastManager;
    private boolean mNeedSetTime = false;
    private View mPlayerHint1;
    private View mPlayerHint2;
    private View mSeeAllVieo;
    public boolean mSeekBarTouched = false;
    private int mSelectTime;
    SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("mm:ss");
    private int mStartTime;
    public TextView mTVRecordTimer;
    private TimeLineControlView.TimeLineCallback mTimeCallBack = new TimeLineControlView.TimeLineCallback() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass15 */

        public void onUpdateTime(long j) {
            SDCardTimeLinePlayerActivity.this.mTimeUpdateView.setText(mi.O000000o(j));
            if (SDCardTimeLinePlayerActivity.this.mNeedSpeed) {
                SDCardTimeLinePlayerActivity.this.mHandler.removeMessages(4000);
                SDCardTimeLinePlayerActivity.this.mNeedSpeed = false;
            }
            if (SDCardTimeLinePlayerActivity.this.mTimeUpdateView.getVisibility() != 0) {
                SDCardTimeLinePlayerActivity.this.mTimeUpdateView.setVisibility(0);
            }
        }

        public void onSelectTime(long j) {
            if (j != 0) {
                SDCardTimeLinePlayerActivity.this.mHandler.removeMessages(2);
            }
            SDCardTimeLinePlayerActivity.this.setPlayTime(j, true);
            SDCardTimeLinePlayerActivity.this.mTimeUpdateView.setVisibility(8);
        }

        public void onPlayLive() {
            SDCardTimeLinePlayerActivity.this.toSdFilesEnd();
            SDCardTimeLinePlayerActivity.this.mTimeUpdateView.setVisibility(8);
        }

        public void onCancel() {
            if (SDCardTimeLinePlayerActivity.this.mTimeUpdateView.getVisibility() == 0) {
                SDCardTimeLinePlayerActivity.this.mTimeUpdateView.setVisibility(8);
            }
        }
    };
    private TimeItem mTimeItem;
    public TimeLineWithDatePickView mTimeLineControlView;
    public TextView mTimeUpdateView;
    private FrameLayout root;
    private SimpleDateFormat sdfHHmm;
    private SimpleDateFormat sdfMMdd;
    private FrameLayout time_line_land;
    private ImageView title_bar_return;
    private TextViewS tvsMultiSpeed;
    private View zhanwei_land;

    public void detectSDCard() {
    }

    public boolean isHistory() {
        return true;
    }

    public boolean supportOrientationListen() {
        return true;
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        civ.O000000o("SDCardPlayerActivity", "onCreate");
        setContentView((int) R.layout.camera_activity_today_sdcard_player);
        this.mFLTitleBar = (FrameLayout) findViewById(R.id.title_bar);
        this.mFLTitleBar.setBackgroundResource(R.drawable.camera_shape_gradient_bg);
        this.title_bar_return = (ImageView) findViewById(R.id.title_bar_return);
        this.title_bar_return.setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mFLTitleBar.bringToFront();
        this.mDate = new Date();
        initView();
        this.mCameraSdcardFileManager = this.mCameraDevice.O0000OOo();
        this.sdfMMdd = new SimpleDateFormat(getString(R.string.simple_date_format_mm_dd));
        this.sdfMMdd.setTimeZone(mi.O000000o());
        this.sdfHHmm = new SimpleDateFormat(getString(R.string.simple_date_format_hh_mm));
        this.sdfHHmm.setTimeZone(mi.O000000o());
        this.mNetworkMonitor.O000000o(this);
    }

    private void initView() {
        this.zhanwei_land = findViewById(R.id.zhanwei_land);
        this.mSimpleDateFormat = new SimpleDateFormat("mm:ss");
        this.mSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        this.root = (FrameLayout) findViewById(R.id.root);
        this.land_bottom_ctrl_ll = (LinearLayout) findViewById(R.id.land_bottom_ctrl_ll);
        this.time_line_land = (FrameLayout) findViewById(R.id.time_line_land);
        this.cdcCameraRecord = (CenterDrawableCheckBox) findViewById(R.id.cdcCameraRecord);
        this.mTVRecordTimer = (TextView) findViewById(R.id.tvRecordTimer);
        this.cdcCameraRecord.setVisibility(0);
        this.ivCameraShot = (ImageView) findViewById(R.id.ivCameraShot);
        this.ivCameraShot.setOnClickListener(this);
        this.llVideoViewBottomCtrl = (LinearLayout) findViewById(R.id.llVideoViewBottomCtrl);
        this.tvsMultiSpeed = (TextViewS) findViewById(R.id.tvsMultiSpeed);
        this.tvsMultiSpeed.setOnClickListener(this);
        this.cdcToggleAudio = (CenterDrawableCheckBox) findViewById(R.id.cdcToggleAudio);
        this.cdcToggleAudio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                civ.O000000o("SDCardPlayerActivity", "cdcToggleAudio isChecked:".concat(String.valueOf(z)));
                if (SDCardTimeLinePlayerActivity.this.mCameraPlayer == null) {
                    return;
                }
                if (z) {
                    SDCardTimeLinePlayerActivity.this.mCameraPlayer.O000000o(false);
                } else {
                    SDCardTimeLinePlayerActivity.this.mCameraPlayer.O000000o(true);
                }
            }
        });
        this.cdcTogglePlay = (ImageView) findViewById(R.id.cdcTogglePlay);
        this.cdcTogglePlay.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass2 */

            public void onClick(View view) {
                SDCardTimeLinePlayerActivity.this.switchPlayBtnStatus();
            }
        });
        findViewById(R.id.togglePlay).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass3 */

            public void onClick(View view) {
                SDCardTimeLinePlayerActivity.this.switchPlayBtnStatus();
            }
        });
        changePlayBtnBg(this.isVideoPlaying);
        this.ivFullScreen = (ImageView) findViewById(R.id.ivFullScreen);
        this.ivFullScreen.setOnClickListener(this);
        this.llFuncPopup = (LinearLayout) findViewById(R.id.llFuncPopup);
        this.llFuncPopup.setOnClickListener(this);
        this.mTimeUpdateView = (TextView) findViewById(R.id.time_container_center);
        this.mTitleView = (TextView) findViewById(R.id.title_bar_title);
        this.mTitleView.setText((int) R.string.item_storage);
        this.mTitleView.setTextColor(getResources().getColor(R.color.mj_color_white));
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        this.mVideoLayout = new FrameLayout(activity());
        this.mVideoViewFrame.addView(this.mVideoLayout, 0, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mLoadingView = LayoutInflater.from(this).inflate((int) R.layout.camera_progress, (ViewGroup) null);
        this.mVideoLayout.addView(this.mLoadingView, layoutParams);
        this.mLoadingView.setVisibility(8);
        this.mLoadingProgress = (TextView) this.mLoadingView.findViewById(R.id.loading_progress);
        this.mLoadingTitle = (TextView) this.mLoadingView.findViewById(R.id.loading_title);
        this.mLoadingImageView = (ImageView) this.mLoadingView.findViewById(R.id.loading_anim);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_camera_loading);
        this.mLoadingImageView.setImageDrawable(this.mLoadingAnimation);
        if (this.isV4) {
            this.mErrorRetryView = LayoutInflater.from(this).inflate((int) R.layout.camera_v4_error_retry, (ViewGroup) null);
        } else {
            this.mErrorRetryView = LayoutInflater.from(this).inflate((int) R.layout.camera_error_retry, (ViewGroup) null);
        }
        this.mVideoLayout.addView(this.mErrorRetryView, layoutParams);
        this.mErrorRetryView.setVisibility(8);
        this.mRetryView = this.mErrorRetryView.findViewById(R.id.retry_btn);
        this.mErrorInfoView = (TextView) this.mErrorRetryView.findViewById(R.id.error_info);
        if (this.isV4) {
            this.mPowerOffView = LayoutInflater.from(this).inflate((int) R.layout.camera_closed_v4, (ViewGroup) null);
        } else {
            this.mPowerOffView = LayoutInflater.from(this).inflate((int) R.layout.camera_closed, (ViewGroup) null);
        }
        this.mVideoLayout.addView(this.mPowerOffView, layoutParams);
        this.mPowerOffView.setVisibility(8);
        this.mPauseView = findViewById(R.id.pause_view);
        this.mCameraDevice.O00000Oo().O000000o(this.mPropertyChangeListener);
        this.mCameraDevice.O00000Oo().O000000o();
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mPauseView.setOnClickListener(this);
        this.mCameraDevice.O000000o().O000000o(chx.f13863O000000o, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass4 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Void voidR) {
                SDCardTimeLinePlayerActivity.this.refreshUI();
            }
        });
        initTimeSelectView();
        initOtherView();
        initForFirstEnter();
        this.cdcCameraRecord.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass5 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SDCardTimeLinePlayerActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    return false;
                }
                CameraToastUtil.showPowerOffToast(SDCardTimeLinePlayerActivity.this.mCameraDevice.getModel(), SDCardTimeLinePlayerActivity.this, R.string.sleep_recode_error);
                return true;
            }
        });
        final Drawable drawable = getResources().getDrawable(R.drawable.home_icon_camera_recording_small);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        final Drawable drawable2 = getResources().getDrawable(R.drawable.home_icon_camera_record_small);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.cdcCameraRecord.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass6 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
             arg types: [int, java.lang.String]
             candidates:
              _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cin.O000000o(android.content.Context, int):java.lang.String
             arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity, int]
             candidates:
              _m_j.cin.O000000o(int, boolean):int
              _m_j.cin.O000000o(android.content.Context, float):int
              _m_j.cin.O000000o(java.lang.String, java.lang.String):int
              _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
              _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
              _m_j.cin.O000000o(android.content.Context, int):java.lang.String */
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("SDCardPlayerActivity", "mCDCCameraRecord:".concat(String.valueOf(z)));
                chr.O000000o(chr.O000oO0O);
                SDCardTimeLinePlayerActivity.this.onRecordStateChange(z);
                if (z) {
                    SDCardTimeLinePlayerActivity.this.cdcCameraRecord.setCompoundDrawables(null, null, drawable, null);
                    SDCardTimeLinePlayerActivity sDCardTimeLinePlayerActivity = SDCardTimeLinePlayerActivity.this;
                    sDCardTimeLinePlayerActivity.mLastTime = 0;
                    sDCardTimeLinePlayerActivity.mCurrentTime = 0;
                    String O000000o2 = me.O000000o(true, sDCardTimeLinePlayerActivity.mCameraDevice.getDid());
                    if (SDCardTimeLinePlayerActivity.this.mCameraPlayer != null && !SDCardTimeLinePlayerActivity.this.mCameraPlayer.O000000o()) {
                        gqg.O000000o((int) R.string.record_not_connect);
                        SDCardTimeLinePlayerActivity.this.cdcCameraRecord.setCompoundDrawables(null, null, drawable2, null);
                        SDCardTimeLinePlayerActivity.this.cdcCameraRecord.setChecked(false);
                    } else if (!XmPluginHostApi.instance().checkAndRequestPermisson(SDCardTimeLinePlayerActivity.this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        gqg.O000000o((int) R.string.no_write_permission);
                        SDCardTimeLinePlayerActivity.this.cdcCameraRecord.setCompoundDrawables(null, null, drawable2, null);
                        SDCardTimeLinePlayerActivity.this.cdcCameraRecord.setChecked(false);
                    } else if (!TextUtils.isEmpty(O000000o2)) {
                        if (SDCardTimeLinePlayerActivity.this.mCameraPlayer != null) {
                            if ("mijia.camera.v3".equals(SDCardTimeLinePlayerActivity.this.mCameraDevice.getModel())) {
                                SDCardTimeLinePlayerActivity.this.mCameraPlayer.O000000o(O000000o2, 1);
                            } else {
                                SDCardTimeLinePlayerActivity.this.mCameraPlayer.O000000o(O000000o2, 2);
                            }
                        }
                        SDCardTimeLinePlayerActivity sDCardTimeLinePlayerActivity2 = SDCardTimeLinePlayerActivity.this;
                        sDCardTimeLinePlayerActivity2.upDateTimeTitle(cin.O000000o((Context) sDCardTimeLinePlayerActivity2, 0));
                        SDCardTimeLinePlayerActivity.this.mTVRecordTimer.setVisibility(0);
                        gsy.O00000Oo("SDCardPlayerActivity", "startRecord");
                        chr.O0000oOO();
                    } else {
                        gqg.O000000o((int) R.string.snip_video_failed);
                    }
                } else {
                    chr.O0000oOo();
                    SDCardTimeLinePlayerActivity.this.cdcCameraRecord.setCompoundDrawables(null, null, drawable2, null);
                    SDCardTimeLinePlayerActivity.this.doStopRecord();
                }
            }
        });
    }

    public void onRecordStateChange(boolean z) {
        this.mTimeLineControlView.setEnabled(!z);
        this.mSeeAllVieo.setEnabled(!z);
        this.time_line_land.setEnabled(!z);
    }

    private void initForFirstEnter() {
        this.mPlayerHint1.setVisibility(8);
        this.mPlayerHint2.setVisibility(8);
        this.mSeeAllVieo.setVisibility(8);
        this.mTimeLineControlView.setVisibility(8);
        this.llVideoViewBottomCtrl.setVisibility(8);
    }

    private void showHideViews() {
        this.mPlayerHint1.setVisibility(8);
        this.mPlayerHint2.setVisibility(8);
        this.mSeeAllVieo.setVisibility(0);
        this.mTimeLineControlView.setVisibility(0);
        this.llVideoViewBottomCtrl.setVisibility(0);
    }

    public void switchPlayBtnStatus() {
        if (this.isVideoPlaying) {
            this.isVideoPlaying = false;
            pauseCamera();
            this.mUserPause = true;
        } else {
            this.isVideoPlaying = true;
            if (this.mCameraPlayer == null || !this.mCameraPlayer.O000000o()) {
                this.mUserPause = false;
                startPlay();
            } else {
                return;
            }
        }
        changePlayBtnBg(this.isVideoPlaying);
    }

    private void changePlayBtnBg(boolean z) {
        if (z) {
            this.cdcTogglePlay.setImageResource(R.drawable.camera_icon_pause02_nor);
        } else {
            this.cdcTogglePlay.setImageResource(R.drawable.camera_icon_play_nor);
        }
    }

    private void initOtherView() {
        this.mSeeAllVieo = findViewById(R.id.see_all_video);
        this.mPlayerHint1 = findViewById(R.id.play_hint_1);
        this.mPlayerHint2 = findViewById(R.id.play_hint_2);
        this.mSeeAllVieo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass7 */

            public void onClick(View view) {
                SDCardTimeLinePlayerActivity sDCardTimeLinePlayerActivity = SDCardTimeLinePlayerActivity.this;
                sDCardTimeLinePlayerActivity.startActivity(new Intent(sDCardTimeLinePlayerActivity, SDCardActivity.class));
            }
        });
    }

    private void initTimeSelectView() {
        this.mLocalBroadcastManager = ft.O000000o(this);
        this.mTimeLineControlView = (TimeLineWithDatePickView) findViewById(R.id.time_line_date_pick);
        this.mTimeLineControlView.synCurrentTime(System.currentTimeMillis());
        this.mTimeLineControlView.setTimeLineCallback(this.mTimeCallBack);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mNetworkMonitor != null) {
            this.mNetworkMonitor.O00000Oo();
        }
    }

    public void onResume() {
        chr.O00000oO();
        this.mVideoView = XmPluginHostApi.instance().createVideoViewOnFront(activity(), this.mVideoLayout, true, 1);
        this.mVideoView.setMaxScale(6.0f, 6.0f);
        this.mVideoView.initial();
        this.mVideoView.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass8 */

            public void onVideoViewClick() {
                if (SDCardTimeLinePlayerActivity.this.land_bottom_ctrl_ll.getTranslationY() > 0.0f) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(SDCardTimeLinePlayerActivity.this.land_bottom_ctrl_ll, "translationY", (float) SDCardTimeLinePlayerActivity.this.land_bottom_ctrl_ll.getHeight(), 0.0f);
                    ofFloat.setDuration(200L);
                    ofFloat.start();
                    return;
                }
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(SDCardTimeLinePlayerActivity.this.land_bottom_ctrl_ll, "translationY", 0.0f, (float) SDCardTimeLinePlayerActivity.this.land_bottom_ctrl_ll.getHeight());
                ofFloat2.setDuration(200L);
                ofFloat2.start();
            }
        });
        if (ciw.O000000o(getRequestedOrientation())) {
            this.mFullScreen = true;
            this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (this.mVideoView != null) {
                this.mVideoView.setIsFull(true);
            }
            this.mTimeLineControlView.setBackgroundColor(getResources().getColor(R.color.mj_color_gray_heavier));
            this.mSeeAllVieo.setVisibility(8);
            this.mTitleView.setVisibility(8);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.mCameraSdcardFileManager.O00000oO());
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver, intentFilter);
        this.mCameraSdcardFileManager.O0000O0o();
        this.mCameraSdcardFileManager.O000000o();
        this.mTimeLineControlView.setTimeItems(this.mCameraSdcardFileManager.O00000oo());
        super.onResume();
        showLoading();
        if (this.mCameraPlayer != null) {
            this.mCameraPlayer.O000000o(true);
            TextViewS textViewS = this.tvsMultiSpeed;
            textViewS.setText(this.mCameraPlayer.O0000oo0 + "X");
        } else {
            this.tvsMultiSpeed.setText("1X");
        }
        if (!this.isFirst) {
            startPlay();
        }
    }

    public void onPause() {
        if (this.mCameraPlayer != null) {
            this.mCameraPlayer.O0000O0o();
            this.mCameraPlayer = null;
        }
        if (this.mVideoView != null) {
            this.mVideoView.releaseOnlySelf();
            this.mVideoView = null;
        }
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver);
        this.mCameraSdcardFileManager.O00000Oo();
        super.onPause();
        chr.O00000oo();
    }

    public void doResume() {
        if (this.mUserPause && !this.isVideoPlaying) {
            return;
        }
        if (getEndTimeOfLastVideo() == 0) {
            pauseCamera();
        } else {
            setPlayTime(this.mTimeLineControlView.getSelectTime(), false);
        }
    }

    public void refreshUI() {
        if (this.mCameraPlayer == null || this.mCameraPlayer.O0000o00) {
            this.cdcToggleAudio.setChecked(false);
        } else {
            this.cdcToggleAudio.setChecked(true);
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 2) {
            StringBuilder sb = new StringBuilder("MSG_UPDATE_PLAY_TIME:");
            sb.append(this.mCameraPlayer == null ? "null" : "not null");
            gsy.O00000Oo("SDCardPlayerActivity", sb.toString());
            if (this.mCameraPlayer != null) {
                long j = this.mCameraPlayer.O0000o0;
                gsy.O00000Oo("SDCardPlayerActivity", "current play timestamp:".concat(String.valueOf(j)));
                if (this.mLastUpdateTime == j || this.mSeekBarTouched || !this.mCameraPlayer.O000000o()) {
                    this.mHandler.removeMessages(2);
                    this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
                    return;
                }
                if (j >= 0) {
                    setIsConnected();
                }
                if (getEndTimeOfLastVideo() == 0 || getEndTimeOfLastVideo() - (j * 1000) >= ((long) this.UPDATE_DURATION)) {
                    this.mLastUpdateTime = j;
                    int i2 = (int) (j - (this.mTimeItem.f5243O000000o / 1000));
                    if (this.mIsSetTime) {
                        if (Math.abs(this.mLastOffsetTime - i2) <= 3 || System.currentTimeMillis() - this.mLastSetTime > 6000) {
                            this.mIsSetTime = false;
                            hideLoading();
                        } else {
                            this.mHandler.removeMessages(2);
                            this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
                            return;
                        }
                    }
                    this.mHandler.removeMessages(2);
                    this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
                    if (this.mTimeLineControlView.getIsPress()) {
                        return;
                    }
                    if (!this.mIsSetPlayTime) {
                        this.mTimeLineControlView.updatePlayTime(j * 1000, false);
                    } else if (Math.abs(((long) this.mSelectTime) - j) < 10 || System.currentTimeMillis() - this.mLastSetPlayTime > 10000) {
                        this.mIsSetPlayTime = false;
                        this.mTimeLineControlView.updatePlayTime(j * 1000, false);
                        hideLoading();
                        civ.O000000o("CameraPlay", "update " + Math.abs(((long) this.mSelectTime) - j) + "  " + ((System.currentTimeMillis() - this.mLastSetPlayTime) / 1000));
                    }
                } else if (!this.isInEnding) {
                    toSdFilesEnd();
                }
            }
        } else if (i == 4000) {
            this.mNeedSpeed = false;
            this.mTimeUpdateView.setVisibility(8);
        }
    }

    public void toSdFilesEnd() {
        List<TimeItem> O00000oo = this.mCameraSdcardFileManager.O00000oo();
        if (O00000oo == null || O00000oo.size() <= 0) {
            initOtherView();
            return;
        }
        this.mTimeLineControlView.updatePlayTime(getEndTimeOfLastVideo(), false);
        pauseCamera();
        this.isOnFileEnd = true;
    }

    private long getEndTimeOfLastVideo() {
        List<TimeItem> O00000oo = this.mCameraSdcardFileManager.O00000oo();
        if (O00000oo == null || O00000oo.size() == 0) {
            return 0;
        }
        return O00000oo.get(O00000oo.size() - 1).O00000o0;
    }

    public void startPlay() {
        if (TextUtils.isEmpty(this.mCameraDevice.O0000oOo()) || TextUtils.isEmpty(this.mCameraDevice.O00oOooo())) {
            hideLoading();
            showError(getString(R.string.camera_play_error2));
            return;
        }
        if (this.mCameraPlayer == null) {
            this.mCameraPlayer = new chv(this, this.mCameraDevice, this, this.mVideoView);
            this.mCameraPlayer.O0000oo = true;
            this.mCameraPlayer.O00000oO = this.mIRecodeTimeListener;
        }
        if (!mg.O00000o0(activity()) || this.mAllowMobileNetwork) {
            startPlayVideo();
        } else {
            pauseCamera();
        }
    }

    public void upDateTimeTitle(String str) {
        this.mTVRecordTimer.setText(str);
    }

    public void resumeCamera() {
        this.mPauseView.setVisibility(8);
        if (mg.O00000o0(activity())) {
            this.mAllowMobileNetwork = true;
        }
        refreshUI();
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
        this.isVideoPlaying = true;
        changePlayBtnBg(true);
        startPlay();
    }

    private void startPlayVideo() {
        if (!this.isFirst && this.mTimeLineControlView.getSelectTime() < getEndTimeOfLastVideo()) {
            setPlayTime(this.mTimeLineControlView.getSelectTime(), false);
        } else if (this.mCameraSdcardFileManager.O00000oo() != null && this.mCameraSdcardFileManager.O00000oo().size() != 0) {
            if (this.isFirst) {
                showHideViews();
            }
            this.isFirst = false;
            TimeItem timeItem = this.mCameraSdcardFileManager.O00000oo().get(this.mCameraSdcardFileManager.O00000oo().size() - 1);
            if (timeItem != null) {
                setPlayTime(timeItem.f5243O000000o, false);
            }
        }
    }

    public void onClick(View view) {
        doOnClick(view);
        int id = view.getId();
        if (id == R.id.tvsMultiSpeed) {
            if (this.mCameraPlayer == null || !this.mCameraPlayer.O0000Ooo) {
                toggleSpeed();
            } else {
                gqg.O000000o((int) R.string.record_resolution_block);
            }
        } else if (id == R.id.ivFullScreen) {
            if (!this.mFullScreen) {
                setOrientation(true);
            } else {
                setOrientation(false);
            }
        } else if (id == R.id.ivCameraShot) {
            snapShot();
        }
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(this.mCameraDevice.getModel());
        }
        super.onBackPressed();
    }

    public void onServerCmd(int i, byte[] bArr) {
        String optString;
        char c;
        if (!isFinishing() && i == 61442) {
            civ.O00000o0("CameraPlay", "onServerCmd thread " + Thread.currentThread());
            try {
                String str = new String(bArr);
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("id", -1);
                civ.O00000o0("CameraPlay", "id ".concat(str));
                if (optInt == this.mStartTime && (optString = jSONObject.optString("status", null)) != null) {
                    switch (optString.hashCode()) {
                        case -1897432978:
                            if (optString.equals("endoffile")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1309954170:
                            if (optString.equals("filefound")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1107950030:
                            if (optString.equals("readerror")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 250180107:
                            if (optString.equals("filenotfound")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c == 0) {
                        int optInt2 = jSONObject.optInt("duration", -1);
                        if (optInt2 > 0 && this.mDuration != optInt2) {
                            this.mDuration = optInt2;
                            this.mEndTime = this.mStartTime + optInt2;
                        }
                    } else if (c == 1) {
                        hideLoading();
                        pauseCamera();
                        showError(getString(R.string.camera_play_error_file));
                    } else if (c == 2) {
                        this.mHandler.removeMessages(2);
                        this.isInEnding = false;
                        pauseCamera();
                    } else if (c == 3) {
                        hideLoading();
                        pauseCamera();
                        showError(getString(R.string.sd_read_fail));
                        jSONObject.optInt("starttime");
                    }
                    civ.O00000o0("CameraPlay", " onServerCmd status ".concat(String.valueOf(optString)));
                }
            } catch (Exception e) {
                civ.O00000o0("CameraPlay", e.toString());
            }
        }
    }

    public void onDisConnected() {
        this.mNeedSetTime = true;
        this.mTimeLineControlView.setTimeItems(new ArrayList());
    }

    public void onDisconnectedWithCode(int i) {
        this.mNeedSetTime = true;
        this.mTimeLineControlView.setTimeItems(new ArrayList());
    }

    public void onConnected() {
        super.onConnected();
        if (this.mNeedSetTime) {
            if (this.isVideoPlaying) {
                startPlayVideo();
            }
            this.mNeedSetTime = false;
            civ.O00000o0("CameraPlay", "SDCardPlayer reconnect");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    /* access modifiers changed from: protected */
    public void setOrientation(boolean z) {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            activity();
            gqg.O000000o((int) R.string.power_off);
        } else if (z) {
            enterPadFullScreen();
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [android.app.Activity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyy.O000000o(android.app.Activity, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity, boolean]
     candidates:
      _m_j.hyy.O000000o(android.app.Activity, int):void
      _m_j.hyy.O000000o(android.app.Activity, android.content.Intent):void
      _m_j.hyy.O000000o(android.app.Activity, android.content.res.Configuration):void
      _m_j.hyy.O000000o(android.app.Activity, java.lang.Runnable):void
      _m_j.hyy.O000000o(android.content.Intent, android.content.Intent):void
      _m_j.hyy.O000000o(android.content.Intent, boolean):void
      _m_j.hyy.O000000o(android.view.Window, android.widget.FrameLayout):void
      _m_j.hyy.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.hyy.O000000o(android.app.Activity, boolean):void */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setWindow(configuration);
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llFuncPopup.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mTVRecordTimer.getLayoutParams();
            if (this.mFullScreen) {
                this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                if (this.mVideoView != null) {
                    this.mVideoView.setIsFull(true);
                }
                this.mTimeLineControlView.setBackgroundColor(getResources().getColor(R.color.mj_color_gray_heavier));
                this.mSeeAllVieo.setVisibility(8);
                this.mTitleView.setVisibility(8);
                this.time_line_land.removeAllViews();
                this.root.removeAllViews();
                this.time_line_land.addView(this.mTimeLineControlView);
                this.time_line_land.setVisibility(0);
                this.zhanwei_land.setVisibility(0);
                int O000000o2 = ckq.O000000o(this);
                this.llVideoViewBottomCtrl.setPadding(O000000o2, 0, O000000o2, 0);
                this.mTimeLineControlView.setPadding(O000000o2, 0, O000000o2, 0);
                FrameLayout frameLayout = this.mFLTitleBar;
                frameLayout.setPadding(O000000o2, frameLayout.getPaddingTop(), O000000o2, 0);
                layoutParams.bottomMargin = this.llVideoViewBottomCtrl.getHeight() + cin.O000000o((Context) activity(), 90.0f);
                this.llFuncPopup.setLayoutParams(layoutParams);
                layoutParams2.topMargin = cin.O000000o((Context) this, 30.0f);
                this.mTVRecordTimer.setLayoutParams(layoutParams2);
                this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2_exit);
            } else {
                this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, cin.O000000o((Context) activity(), 350.0f)));
                if (this.mVideoView != null) {
                    this.mVideoView.setIsFull(false);
                }
                this.mTimeLineControlView.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
                this.mSeeAllVieo.setVisibility(0);
                this.mTitleView.setVisibility(0);
                this.time_line_land.removeAllViews();
                this.time_line_land.setVisibility(8);
                this.root.removeAllViews();
                this.root.addView(this.mTimeLineControlView);
                this.zhanwei_land.setVisibility(8);
                this.llVideoViewBottomCtrl.setPadding(0, 0, 0, 0);
                this.mTimeLineControlView.setPadding(0, 0, 0, 0);
                this.mFLTitleBar.setPadding(0, this.mFLTitleBar.getPaddingTop(), 0, 0);
                layoutParams.bottomMargin = this.llVideoViewBottomCtrl.getHeight() + cin.O000000o((Context) activity(), 6.0f);
                this.llFuncPopup.setLayoutParams(layoutParams);
                layoutParams2.topMargin = cin.O000000o((Context) this, 65.0f);
                this.mTVRecordTimer.setLayoutParams(layoutParams2);
                this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2);
            }
        } catch (Exception e) {
            gsy.O000000o(6, "SDCardPlayerActivity", "onConfigurationChanged:" + e.getLocalizedMessage());
        }
        hyy.O000000o((Activity) this, this.mFullScreen);
    }

    private void toggleSpeed() {
        if (this.mCameraPlayer == null || !this.mCameraPlayer.O000000o()) {
            activity();
            gqg.O000000o((int) R.string.sd_card_video_not_playing);
            return;
        }
        int i = this.mCameraPlayer.O0000oo0;
        civ.O000000o("SDCardPlayerActivity", "speed:".concat(String.valueOf(i)));
        int i2 = 16;
        if (i == 1) {
            i2 = 4;
        } else if (i != 4) {
            i2 = 1;
        }
        this.mCameraPlayer.O00000o0(i2);
        if (i2 == 1) {
            this.cdcToggleAudio.setEnabled(true);
        } else {
            if (this.cdcToggleAudio.isChecked()) {
                this.cdcToggleAudio.performClick();
            }
            this.cdcToggleAudio.setEnabled(false);
        }
        TextViewS textViewS = this.tvsMultiSpeed;
        textViewS.setText(i2 + "X");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    private void snapShot() {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            activity();
            gqg.O000000o((int) R.string.power_off);
        } else if (this.mCameraDevice == null || this.mCameraDevice.O000000o() == null || !this.mCameraDevice.O000000o().O000000o("power", true)) {
            activity();
            gqg.O000000o((int) R.string.power_off);
        } else if (this.mCameraPlayer == null || !this.mCameraPlayer.O00000oO()) {
            activity();
            gqg.O000000o((int) R.string.snap_failed_paused);
        } else {
            this.mVideoView.snap(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass9 */

                public void onSnap(Bitmap bitmap) {
                    goq.O000000o(new Runnable(bitmap) {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerActivity$9$LODDJ9N0EvBWzCJXlirkyO7xm40 */
                        private final /* synthetic */ Bitmap f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            SDCardTimeLinePlayerActivity.AnonymousClass9.this.lambda$onSnap$0$SDCardTimeLinePlayerActivity$9(this.f$1);
                        }
                    });
                }

                public /* synthetic */ void lambda$onSnap$0$SDCardTimeLinePlayerActivity$9(Bitmap bitmap) {
                    SDCardTimeLinePlayerActivity.this.onSnapShot(bitmap);
                }
            });
        }
    }

    public void dismissSnapshotPopupRunnable(long j) {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass10 */

            public void run() {
                if (SDCardTimeLinePlayerActivity.this.llFuncPopup.getVisibility() != 8) {
                    SDCardTimeLinePlayerActivity.this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(SDCardTimeLinePlayerActivity.this.activity(), R.anim.anim_snap_shot_out));
                    SDCardTimeLinePlayerActivity.this.llFuncPopup.setVisibility(8);
                }
            }
        }, j);
    }

    public void doStopRecord() {
        this.mLastTime = 0;
        this.mCurrentTime = 0;
        if (this.mCameraPlayer == null || !this.mCameraPlayer.O0000Ooo) {
            this.cdcCameraRecord.setChecked(false);
        } else {
            this.mCameraPlayer.O000000o(new XmMp4Record.IRecordListener() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass11 */

                public void onSuccess(String str) {
                    SDCardTimeLinePlayerActivity.this.mTVRecordTimer.setVisibility(8);
                    SDCardTimeLinePlayerActivity.this.onVideoRecorded(str);
                    if (SDCardTimeLinePlayerActivity.this.cdcCameraRecord.isChecked()) {
                        SDCardTimeLinePlayerActivity.this.cdcCameraRecord.setChecked(false);
                    }
                }

                public void onFailed(int i, String str) {
                    SDCardTimeLinePlayerActivity.this.mTVRecordTimer.setVisibility(8);
                    if (SDCardTimeLinePlayerActivity.this.cdcCameraRecord.isChecked()) {
                        SDCardTimeLinePlayerActivity.this.cdcCameraRecord.setChecked(false);
                    }
                    if (i == -2) {
                        gqg.O000000o((int) R.string.snip_video_failed_time_mini);
                    } else {
                        gqg.O000000o((int) R.string.snip_video_failed);
                    }
                }
            });
        }
    }

    public void onVideoRecorded(String str) {
        File file = new File(str);
        if (file.exists()) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            final clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null && this.mVideoView != null) {
                this.mVideoView.snap(new XmVideoViewGl.PhotoSnapCallback() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass12 */

                    public void onSnap(Bitmap bitmap) {
                        if (bitmap != null) {
                            final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 200, (bitmap.getHeight() * 200) / bitmap.getWidth(), false);
                            SDCardTimeLinePlayerActivity.this.runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass12.AnonymousClass1 */

                                public void run() {
                                    if (createScaledBitmap != null) {
                                        ImageView imageView = (ImageView) SDCardTimeLinePlayerActivity.this.findViewById(R.id.ivShotPic);
                                        imageView.setImageBitmap(createScaledBitmap);
                                        if (SDCardTimeLinePlayerActivity.this.llFuncPopup.getVisibility() == 0) {
                                            SDCardTimeLinePlayerActivity.this.llFuncPopup.setVisibility(4);
                                        }
                                        SDCardTimeLinePlayerActivity.this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(SDCardTimeLinePlayerActivity.this, R.anim.anim_snap_shot_in));
                                        SDCardTimeLinePlayerActivity.this.llFuncPopup.setVisibility(0);
                                        SDCardTimeLinePlayerActivity.this.dismissSnapshotPopupRunnable(3000);
                                        imageView.setOnClickListener(new View.OnClickListener() {
                                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass12.AnonymousClass1.AnonymousClass1 */

                                            public void onClick(View view) {
                                                if (SDCardTimeLinePlayerActivity.this.canStepOut(R.string.speaking_block, R.string.recording_block)) {
                                                    SDCardTimeLinePlayerActivity.this.dismissSnapshotPopupRunnable(0);
                                                    Intent intent = new Intent();
                                                    intent.putExtra("file_path", O00000Oo.O00000o);
                                                    intent.setClass(SDCardTimeLinePlayerActivity.this, LocalPicActivity.class);
                                                    SDCardTimeLinePlayerActivity.this.startActivity(intent);
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public void pauseCamera() {
        super.pauseCamera();
        changePlayBtnBg(false);
        this.isVideoPlaying = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    /* access modifiers changed from: package-private */
    public void onSnapShot(Bitmap bitmap) {
        final String O000000o2 = me.O000000o(false, this.mCameraDevice.getDid());
        if (O000000o2 != null && bitmap != null) {
            if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                bitmap = C0118cif.O000000o(bitmap, activity());
            }
            if (bitmap != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(O000000o2);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException unused) {
                    return;
                }
            }
            final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 200, (bitmap.getHeight() * 200) / bitmap.getWidth(), false);
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass13 */

                public void run() {
                    if (new File(O000000o2).exists()) {
                        ImageView imageView = (ImageView) SDCardTimeLinePlayerActivity.this.findViewById(R.id.ivShotPic);
                        if (SDCardTimeLinePlayerActivity.this.llFuncPopup.getVisibility() == 0) {
                            SDCardTimeLinePlayerActivity.this.llFuncPopup.setVisibility(8);
                        }
                        SDCardTimeLinePlayerActivity.this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(SDCardTimeLinePlayerActivity.this.activity(), R.anim.anim_snap_shot_in));
                        SDCardTimeLinePlayerActivity.this.llFuncPopup.setVisibility(0);
                        SDCardTimeLinePlayerActivity.this.dismissSnapshotPopupRunnable(3000);
                        Bitmap bitmap = createScaledBitmap;
                        if (bitmap != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                        ContentValues contentValues = new ContentValues(4);
                        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                        contentValues.put("_data", O000000o2);
                        contentValues.put("mime_type", "image/jpeg");
                        try {
                            if (!Build.MODEL.equals("HM 1SC")) {
                                SDCardTimeLinePlayerActivity.this.activity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                            }
                            civ.O000000o("SDCardPlayerActivity", "snap success");
                        } catch (Throwable unused) {
                        }
                        final clj.O000000o O00000Oo = SDCardTimeLinePlayerActivity.this.mCameraDevice.O0000O0o().O00000Oo(O000000o2);
                        if (O00000Oo != null) {
                            imageView.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerActivity.AnonymousClass13.AnonymousClass1 */

                                public void onClick(View view) {
                                    if (SDCardTimeLinePlayerActivity.this.mCameraPlayer == null || !SDCardTimeLinePlayerActivity.this.mCameraPlayer.O0000Ooo) {
                                        SDCardTimeLinePlayerActivity.this.dismissSnapshotPopupRunnable(0);
                                        Intent intent = new Intent(SDCardTimeLinePlayerActivity.this.activity(), LocalPicReviewActivity.class);
                                        intent.putExtra("file_path", O00000Oo.O00000o);
                                        SDCardTimeLinePlayerActivity.this.startActivity(intent);
                                        return;
                                    }
                                    gqg.O00000Oo((int) R.string.recording_block);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    public void setPlayTime(long j, boolean z) {
        int i;
        TimeItem timeItem;
        long j2 = j;
        TimeItem O000000o2 = this.mCameraSdcardFileManager.O000000o(j2);
        if (O000000o2 != null) {
            civ.O00000o0("CameraPlay", "last set time before " + mi.O00000Oo(j));
            int i2 = (int) (O000000o2.f5243O000000o / 1000);
            i = O000000o2.f5243O000000o < j2 ? ((int) (j2 - O000000o2.f5243O000000o)) / 1000 : 0;
            StringBuilder sb = new StringBuilder("last set time after  ");
            long j3 = (long) (i * 1000);
            sb.append(mi.O00000Oo(O000000o2.f5243O000000o + j3));
            civ.O00000o0("CameraPlay", sb.toString());
            this.mIsSetPlayTime = true;
            this.mSelectTime = i2 + i;
            this.mLastSetStart = i2;
            this.mTimeLineControlView.updatePlayTime(O000000o2.f5243O000000o + j3, false);
        } else {
            civ.O00000o0("CameraPlay", "last set time alive");
            this.mHandler.removeMessages(2);
            this.mIsSetPlayTime = true;
            if (this.mCameraSdcardFileManager.O00000oo() == null || this.mCameraSdcardFileManager.O00000oo().size() == 0) {
                initForFirstEnter();
                return;
            } else if (j2 != 0 && (timeItem = this.mCameraSdcardFileManager.O00000oo().get(this.mCameraSdcardFileManager.O00000oo().size() - 1)) != null) {
                if (j2 >= timeItem.O00000o0) {
                    toSdFilesEnd();
                    return;
                }
                i = 0;
            } else {
                return;
            }
        }
        if (!this.mUserPause) {
            hidError();
            showLoading("");
        }
        this.mLastSetPlayTime = System.currentTimeMillis();
        this.mHandler.removeMessages(2);
        if (O000000o2 == null) {
            pauseCamera();
            return;
        }
        this.mStartTime = (int) (O000000o2.f5243O000000o / 1000);
        this.mEndTime = (int) (O000000o2.O00000o0 / 1000);
        this.mDuration = ((int) O000000o2.O00000Oo) / 1000;
        this.mLastUpdateTime = 0;
        this.mTimeItem = O000000o2;
        setPlayWithOffset(i, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a4, code lost:
        if (r11.O00000oO() != false) goto L_0x00a6;
     */
    private void setPlayWithOffset(int i, boolean z) {
        int i2 = this.mDuration;
        if (i == i2) {
            i = i2 - 2;
        }
        if (i < 0) {
            i = 0;
        }
        this.mLastSetTime = System.currentTimeMillis();
        this.mIsSetTime = true;
        this.mLastOffsetTime = i;
        this.mHandler.removeMessages(2);
        hidError();
        if (this.mPauseView.getVisibility() == 0) {
            this.mPauseView.setVisibility(8);
        }
        this.mUserPause = false;
        if (this.isOnFileEnd) {
            this.isOnFileEnd = false;
            z = false;
        }
        if (this.mCameraPlayer != null && (!this.mCameraPlayer.O00000o() || !z)) {
            chv chv = this.mCameraPlayer;
            int i3 = this.mStartTime;
            civ.O00000o("CameraPlay", "set play time " + i3 + "   " + i + "   0");
            if (!chv.O00000oO() || chv.O00000o() || i3 == 0) {
                if (i3 != 0) {
                    civ.O00000o("CameraPlay", "set play time fail start: " + chv.O00000oO() + " pause: " + chv.O00000o());
                }
                chv.O00000Oo(i3);
                chv.O0000oOO = 0;
            }
            if (i3 != 0) {
                chv.O00000oo = true;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sessionid", i3);
                    jSONObject.put("starttime", i3);
                    jSONObject.put("endtime", 0);
                    jSONObject.put("autoswitchtolive", 1);
                    jSONObject.put("offset", i);
                    jSONObject.put("speed", chv.O0000oo0);
                    jSONObject.put("avchannelmerge", 1);
                    String jSONObject2 = jSONObject.toString();
                    chv.O0000oOo = i3;
                    chv.O00000o0.playBack(jSONObject2.getBytes(Charset.forName("UTF-8")));
                    chv.O0000oOO = (long) (i3 + i);
                    civ.O00000o("CameraPlay", "set play time ");
                } catch (JSONException e) {
                    civ.O000000o("CameraPlay", "JSONException", e);
                }
            }
            this.isVideoPlaying = true;
            changePlayBtnBg(true);
        }
        if (this.mCameraPlayer != null && !this.mCameraPlayer.O00000o()) {
            showLoading();
        }
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 3000);
        civ.O00000o0("CameraPlay", "SDCardPlayer PlayTime " + this.mStartTime + " offset " + i + " end " + this.mEndTime);
    }

    public void onPlayError() {
        super.onPlayError();
        this.isVideoPlaying = false;
        changePlayBtnBg(false);
    }
}
