package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.C0118cif;
import _m_j.chr;
import _m_j.chx;
import _m_j.cin;
import _m_j.civ;
import _m_j.ciw;
import _m_j.ciy;
import _m_j.cki;
import _m_j.ckq;
import _m_j.clf;
import _m_j.clj;
import _m_j.cln;
import _m_j.ft;
import _m_j.ftn;
import _m_j.goq;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hyy;
import _m_j.me;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.view.FlowLayout;
import com.xiaomi.smarthome.camera.v4.utils.CameraToastUtil;
import com.xiaomi.smarthome.camera.view.TextViewS;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineWithDatePickView;
import com.xiaomi.smarthome.camera.view.widget.CenterDrawableCheckBox;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONObject;

public class SDCardTimeLinePlayerExActivity extends GeneralCameraPlayerBaseActivity {
    private int UPDATE_DURATION = 500;
    private CheckBox cb_area_move;
    private LinearLayout cb_area_move_ll;
    private CheckBox cb_baby_cry;
    private LinearLayout cb_baby_cry_ll;
    private CheckBox cb_people_move;
    private LinearLayout cb_people_move_ll;
    public CenterDrawableCheckBox cdcCameraRecord;
    private CenterDrawableCheckBox cdcToggleAudio;
    private ImageView cdcTogglePlay;
    private int currentVideoHeight = 0;
    private Runnable dismissRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$pzZTZwAa0j5L7A7r1kK2rpgFphM */

        public final void run() {
            SDCardTimeLinePlayerExActivity.this.lambda$new$5$SDCardTimeLinePlayerExActivity();
        }
    };
    private FlowLayout flowLayout;
    private boolean isForeground;
    private boolean isInEnding = false;
    private boolean isOnFileEnd;
    boolean isVideoPlaying = true;
    private ImageView ivCameraShot;
    private ImageView ivFullScreen;
    private LinearLayout land_bottom_ctrl_ll;
    public LinearLayout llFuncPopup;
    private LinearLayout llVideoViewBottomCtrl;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            if (SDCardTimeLinePlayerExActivity.this.mCameraSdcardExFileManager.O00000oO().equals(intent.getAction()) && !SDCardTimeLinePlayerExActivity.this.isFinishing()) {
                gsy.O00000Oo("SDCardTimeLinePlayerExActivity", "mBroadcastReceiver update time items");
                SDCardTimeLinePlayerExActivity.this.mTimeLineControlView.setTimeItems(SDCardTimeLinePlayerExActivity.this.mCameraSdcardExFileManager.O00000oo());
                if (!SDCardTimeLinePlayerExActivity.this.mIsUserPause && SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx != null && !SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx.O0000Ooo()) {
                    SDCardTimeLinePlayerExActivity.this.startPlay();
                }
            }
        }
    };
    public cln mCameraSdcardExFileManager;
    public int mCurrentTime = 0;
    private int mDuration;
    private int mEndTime;
    private FrameLayout mFLTitleBar;
    private boolean mIsSetPlayTime;
    private boolean mIsSetTime = false;
    private int mLastOffsetTime = 0;
    private long mLastSetPlayTime;
    private long mLastSetTime = 0;
    public int mLastTime = 0;
    private long mLastUpdateTime = 0;
    private ft mLocalBroadcastManager;
    private View mPlayerHint1;
    private View mPlayerHint2;
    private View mSeeAllVieo;
    public boolean mSeekBarTouched = false;
    private int mSelectTime;
    private SimpleDateFormat mSimpleDateFormat;
    private int mStartTime;
    public TextView mTVRecordTimer;
    private TimeLineControlView.TimeLineCallback mTimeCallBack = new TimeLineControlView.TimeLineCallback() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass16 */

        public void onUpdateTime(long j) {
            SDCardTimeLinePlayerExActivity.this.mTimeUpdateView.setText(mi.O000000o(j));
            if (SDCardTimeLinePlayerExActivity.this.mNeedSpeed) {
                SDCardTimeLinePlayerExActivity.this.mHandler.removeMessages(4000);
                SDCardTimeLinePlayerExActivity.this.mNeedSpeed = false;
            }
            if (SDCardTimeLinePlayerExActivity.this.mTimeUpdateView.getVisibility() != 0) {
                SDCardTimeLinePlayerExActivity.this.mTimeUpdateView.setVisibility(0);
            }
        }

        public void onSelectTime(long j) {
            if (j != 0) {
                SDCardTimeLinePlayerExActivity.this.mHandler.removeMessages(2);
            }
            SDCardTimeLinePlayerExActivity.this.startPlayVideoWithCheckConnection(j, true);
            SDCardTimeLinePlayerExActivity.this.mTimeUpdateView.setVisibility(8);
        }

        public void onPlayLive() {
            SDCardTimeLinePlayerExActivity.this.toSdFilesEnd();
            SDCardTimeLinePlayerExActivity.this.mTimeUpdateView.setVisibility(8);
        }

        public void onCancel() {
            if (SDCardTimeLinePlayerExActivity.this.mTimeUpdateView.getVisibility() == 0) {
                SDCardTimeLinePlayerExActivity.this.mTimeUpdateView.setVisibility(8);
            }
        }
    };
    private TimeItem mTimeItem;
    public TimeLineWithDatePickView mTimeLineControlView;
    public TextView mTimeUpdateView;
    private FrameLayout root;
    private FrameLayout time_line_land;
    private ImageView title_bar_return;
    private TextViewS tvsMultiSpeed;
    private View zhanwei_land;

    public void detectSDCard() {
    }

    public boolean isHistory() {
        return true;
    }

    public void onDisConnected() {
    }

    public void onDisconnectedWithCode(int i) {
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        civ.O000000o("SDCardTimeLinePlayerExActivity", "onCreate");
        setContentView((int) R.layout.camera_activity_today_sdcard_player);
        this.mFLTitleBar = (FrameLayout) findViewById(R.id.title_bar);
        this.mFLTitleBar.setBackgroundResource(R.drawable.camera_shape_gradient_bg);
        this.title_bar_return = (ImageView) findViewById(R.id.title_bar_return);
        this.title_bar_return.setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mFLTitleBar.bringToFront();
        if (this.mCameraDevice == null) {
            gqg.O000000o((int) R.string.action_fail);
            finish();
            return;
        }
        initView();
        if (this.mCameraDevice.O00000o()) {
            this.mCameraSdcardExFileManager = this.mCameraDevice.O0000Oo0();
        } else {
            this.mCameraSdcardExFileManager = this.mCameraDevice.O0000OOo();
        }
        this.mNetworkMonitor.O000000o(this);
        showLoading(null);
    }

    private void showViews() {
        this.mPlayerHint1.setVisibility(8);
        this.mPlayerHint2.setVisibility(8);
        this.mSeeAllVieo.setVisibility(0);
        this.mTimeLineControlView.setVisibility(0);
        this.llVideoViewBottomCtrl.setVisibility(0);
        this.flowLayout.removeAllViews();
        if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
            this.flowLayout.addView(this.cb_area_move_ll);
            if (clf.f14036O000000o) {
                this.flowLayout.addView(this.cb_baby_cry_ll);
            }
            this.flowLayout.addView(this.cb_people_move_ll);
        }
        if (DeviceConstant.isSupportBabyCryNative(this.mCameraDevice.getModel())) {
            try {
                this.flowLayout.addView(this.cb_area_move_ll);
            } catch (Exception e) {
                cki.O00000oO("SDCardTimeLinePlayerExActivity", e.toString());
            }
            if (clf.f14036O000000o) {
                try {
                    this.flowLayout.addView(this.cb_baby_cry_ll);
                } catch (Exception e2) {
                    cki.O00000oO("SDCardTimeLinePlayerExActivity", e2.toString());
                }
            }
        }
    }

    public void switchPlayBtnStatus() {
        if (this.isVideoPlaying) {
            this.isVideoPlaying = false;
            pauseCamera();
            this.mIsUserPause = true;
        } else {
            this.isVideoPlaying = true;
            if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000Ooo()) {
                this.mIsUserPause = false;
                startPlay();
            } else {
                return;
            }
        }
        changePlayBtnBg(this.isVideoPlaying);
    }

    private void changePlayBtnBg(boolean z) {
        if (this.cdcTogglePlay.getVisibility() != 0) {
            this.cdcTogglePlay.setVisibility(0);
        }
        if (z) {
            if (this.mPauseView != null) {
                this.mPauseView.setVisibility(8);
            }
            this.cdcTogglePlay.setImageResource(R.drawable.camera_icon_pause02_nor);
            return;
        }
        if (this.mPauseView != null) {
            this.mPauseView.setVisibility(0);
        }
        this.cdcTogglePlay.setImageResource(R.drawable.camera_icon_play_nor);
    }

    private void initOtherView() {
        this.mSeeAllVieo = findViewById(R.id.see_all_video);
        this.mPlayerHint1 = findViewById(R.id.play_hint_1);
        this.mPlayerHint2 = findViewById(R.id.play_hint_2);
        this.mSeeAllVieo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass2 */

            public void onClick(View view) {
                if (SDCardTimeLinePlayerExActivity.this.mCameraSdcardExFileManager.O00000oo() == null || SDCardTimeLinePlayerExActivity.this.mCameraSdcardExFileManager.O00000oo().size() <= 0) {
                    SDCardTimeLinePlayerExActivity.this.getContext();
                    gqg.O000000o((int) R.string.action_fail);
                } else if (DeviceConstant.supportNewPlayBack(SDCardTimeLinePlayerExActivity.this.mCameraDevice.getModel())) {
                    SDCardTimeLinePlayerExActivity sDCardTimeLinePlayerExActivity = SDCardTimeLinePlayerExActivity.this;
                    sDCardTimeLinePlayerExActivity.startActivity(new Intent(sDCardTimeLinePlayerExActivity.getContext(), SDCard2Activity.class));
                } else {
                    SDCardTimeLinePlayerExActivity sDCardTimeLinePlayerExActivity2 = SDCardTimeLinePlayerExActivity.this;
                    sDCardTimeLinePlayerExActivity2.startActivity(new Intent(sDCardTimeLinePlayerExActivity2.getContext(), SDCardActivity.class));
                }
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
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O000000o(true);
        }
    }

    private int getScreenWidth() {
        return hyy.O00000Oo(getIntent()).widthPixels;
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
    private void initView() {
        this.flowLayout = (FlowLayout) findViewById(R.id.ll_event_types_flow);
        this.zhanwei_land = findViewById(R.id.zhanwei_land);
        this.mSimpleDateFormat = new SimpleDateFormat("mm:ss");
        this.mSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        this.cdcCameraRecord = (CenterDrawableCheckBox) findViewById(R.id.cdcCameraRecord);
        this.mTVRecordTimer = (TextView) findViewById(R.id.tvRecordTimer);
        this.cdcCameraRecord.setVisibility(0);
        this.root = (FrameLayout) findViewById(R.id.root);
        this.land_bottom_ctrl_ll = (LinearLayout) findViewById(R.id.land_bottom_ctrl_ll);
        this.time_line_land = (FrameLayout) findViewById(R.id.time_line_land);
        this.cb_people_move_ll = (LinearLayout) findViewById(R.id.cb_people_move_ll);
        this.cb_area_move_ll = (LinearLayout) findViewById(R.id.cb_area_move_ll);
        this.cb_baby_cry_ll = (LinearLayout) findViewById(R.id.cb_baby_cry_ll);
        this.cb_people_move = (CheckBox) findViewById(R.id.cb_people_move);
        this.cb_area_move = (CheckBox) findViewById(R.id.cb_area_move);
        this.cb_baby_cry = (CheckBox) findViewById(R.id.cb_baby_cry);
        this.ivCameraShot = (ImageView) findViewById(R.id.ivCameraShot);
        this.ivCameraShot.setOnClickListener(this);
        this.llVideoViewBottomCtrl = (LinearLayout) findViewById(R.id.llVideoViewBottomCtrl);
        this.tvsMultiSpeed = (TextViewS) findViewById(R.id.tvsMultiSpeed);
        this.tvsMultiSpeed.setOnClickListener(this);
        if (this.mCameraDevice.O0000oOO()) {
            this.tvsMultiSpeed.setVisibility(8);
        }
        this.cdcToggleAudio = (CenterDrawableCheckBox) findViewById(R.id.cdcToggleAudio);
        this.cdcToggleAudio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass3 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                civ.O000000o("SDCardTimeLinePlayerExActivity", "cdcToggleAudio isChecked:".concat(String.valueOf(z)));
                if (SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx == null) {
                    return;
                }
                if (z) {
                    SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx.O00000o0(false);
                } else {
                    SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx.O00000o0(true);
                }
            }
        });
        this.cdcTogglePlay = (ImageView) findViewById(R.id.cdcTogglePlay);
        this.cdcTogglePlay.setVisibility(8);
        this.cdcTogglePlay.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass4 */

            public void onClick(View view) {
                SDCardTimeLinePlayerExActivity.this.switchPlayBtnStatus();
            }
        });
        findViewById(R.id.togglePlay).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass5 */

            public void onClick(View view) {
                SDCardTimeLinePlayerExActivity.this.switchPlayBtnStatus();
            }
        });
        changePlayBtnBg(this.isVideoPlaying);
        this.ivFullScreen = (ImageView) findViewById(R.id.ivFullScreen);
        this.ivFullScreen.setOnClickListener(this);
        this.llFuncPopup = (LinearLayout) findViewById(R.id.llFuncPopup);
        this.llFuncPopup.setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llFuncPopup.getLayoutParams();
        layoutParams.bottomMargin = cin.O000000o((Context) activity(), 46.0f);
        this.llFuncPopup.setLayoutParams(layoutParams);
        this.mTimeUpdateView = (TextView) findViewById(R.id.time_container_center);
        this.mTitleView = (TextView) findViewById(R.id.title_bar_title);
        this.mTitleView.setText((int) R.string.item_storage);
        this.mTitleView.setTextColor(getResources().getColor(R.color.camera_white));
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        if (hyy.O000000o()) {
            this.currentVideoHeight = (int) (((float) getScreenWidth()) / 0.9f);
            this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.currentVideoHeight));
        }
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mVideoViewFrame.addView(frameLayout, 0, layoutParams2);
        this.mVideoView = ciy.O000000o(this.mCameraDevice.getModel(), frameLayout);
        this.mVideoView.O00000Oo(6.0f, 6.0f);
        this.mLoadingView = LayoutInflater.from(this).inflate((int) R.layout.camera_progress, (ViewGroup) null);
        this.mVideoViewFrame.addView(this.mLoadingView, layoutParams2);
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
        this.mVideoViewFrame.addView(this.mErrorRetryView, layoutParams2);
        this.mErrorRetryView.setVisibility(8);
        this.mRetryView = this.mErrorRetryView.findViewById(R.id.retry_btn);
        this.mErrorInfoView = (TextView) this.mErrorRetryView.findViewById(R.id.error_info);
        if (this.isV4) {
            this.mPowerOffView = LayoutInflater.from(this).inflate((int) R.layout.camera_closed_v4, (ViewGroup) null);
        } else {
            this.mPowerOffView = LayoutInflater.from(this).inflate((int) R.layout.camera_closed, (ViewGroup) null);
        }
        this.mVideoViewFrame.addView(this.mPowerOffView, layoutParams2);
        this.mPowerOffView.setVisibility(8);
        this.mPauseView = findViewById(R.id.pause_view);
        this.mPauseView.setVisibility(8);
        this.mPauseView.setOnClickListener(this);
        this.mCameraDevice.O00000Oo().O000000o(this.mPropertyChangeListener);
        this.mCameraDevice.O00000Oo().O000000o();
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mCameraDevice.O000000o().O000000o(chx.f13863O000000o, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass6 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Void voidR) {
                if (!SDCardTimeLinePlayerExActivity.this.isFinishing()) {
                    SDCardTimeLinePlayerExActivity.this.refreshUI();
                }
            }
        });
        initTimeSelectView();
        initOtherView();
        this.cb_people_move.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass7 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SDCardTimeLinePlayerExActivity.this.mTimeLineControlView.setPeopleMove(z);
            }
        });
        this.cb_area_move.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass8 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SDCardTimeLinePlayerExActivity.this.mTimeLineControlView.setAreaMove(z);
            }
        });
        this.cb_baby_cry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass9 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SDCardTimeLinePlayerExActivity.this.mTimeLineControlView.setBabyCry(z);
            }
        });
        this.cdcCameraRecord.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass10 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SDCardTimeLinePlayerExActivity.this.mCameraDevice.O000000o().O000000o("power", true)) {
                    return false;
                }
                CameraToastUtil.showPowerOffToast(SDCardTimeLinePlayerExActivity.this.mCameraDevice.getModel(), SDCardTimeLinePlayerExActivity.this, R.string.sleep_recode_error);
                return true;
            }
        });
        final Drawable drawable = getResources().getDrawable(R.drawable.home_icon_camera_recording_small);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        final Drawable drawable2 = getResources().getDrawable(R.drawable.home_icon_camera_record_small);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        this.cdcCameraRecord.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass11 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
             arg types: [int, java.lang.String]
             candidates:
              _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cin.O000000o(android.content.Context, int):java.lang.String
             arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity, int]
             candidates:
              _m_j.cin.O000000o(int, boolean):int
              _m_j.cin.O000000o(android.content.Context, float):int
              _m_j.cin.O000000o(java.lang.String, java.lang.String):int
              _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
              _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
              _m_j.cin.O000000o(android.content.Context, int):java.lang.String */
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O00000Oo("SDCardTimeLinePlayerExActivity", "mCDCCameraRecord:".concat(String.valueOf(z)));
                chr.O000000o(chr.O000oO0O);
                if (z) {
                    SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.setCompoundDrawables(null, null, drawable, null);
                    SDCardTimeLinePlayerExActivity sDCardTimeLinePlayerExActivity = SDCardTimeLinePlayerExActivity.this;
                    sDCardTimeLinePlayerExActivity.mLastTime = 0;
                    sDCardTimeLinePlayerExActivity.mCurrentTime = 0;
                    String O000000o2 = me.O000000o(true, sDCardTimeLinePlayerExActivity.mCameraDevice.getDid());
                    if (SDCardTimeLinePlayerExActivity.this.mCameraDevice != null && SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx != null && !SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx.O0000Ooo()) {
                        SDCardTimeLinePlayerExActivity.this.getContext();
                        gqg.O000000o((int) R.string.record_not_connect);
                        SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.setCompoundDrawables(null, null, drawable2, null);
                        SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.setChecked(false);
                    } else if (!XmPluginHostApi.instance().checkAndRequestPermisson(SDCardTimeLinePlayerExActivity.this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        SDCardTimeLinePlayerExActivity.this.getContext();
                        gqg.O000000o((int) R.string.no_write_permission);
                        SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.setCompoundDrawables(null, null, drawable2, null);
                        SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.setChecked(false);
                    } else if (!TextUtils.isEmpty(O000000o2)) {
                        SDCardTimeLinePlayerExActivity.this.onRecordStateChange(true);
                        if (!(SDCardTimeLinePlayerExActivity.this.mCameraDevice == null || SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx == null)) {
                            if ("mijia.camera.v3".equals(SDCardTimeLinePlayerExActivity.this.mCameraDevice.getModel())) {
                                SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx.O000000o(O000000o2, 1);
                            } else {
                                SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx.O000000o(O000000o2, 2);
                            }
                            SDCardTimeLinePlayerExActivity.this.mCameraPlayerEx.O00000Oo(true);
                        }
                        SDCardTimeLinePlayerExActivity sDCardTimeLinePlayerExActivity2 = SDCardTimeLinePlayerExActivity.this;
                        sDCardTimeLinePlayerExActivity2.upDateTimeTitle(cin.O000000o((Context) sDCardTimeLinePlayerExActivity2, 0));
                        SDCardTimeLinePlayerExActivity.this.mTVRecordTimer.setVisibility(0);
                        gsy.O00000Oo("SDCardTimeLinePlayerExActivity", "startRecord");
                        chr.O0000oOO();
                    } else {
                        gqg.O000000o((int) R.string.snip_video_failed);
                    }
                } else {
                    SDCardTimeLinePlayerExActivity.this.onRecordStateChange(false);
                    chr.O0000oOo();
                    SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.setCompoundDrawables(null, null, drawable2, null);
                    SDCardTimeLinePlayerExActivity.this.doStopRecord();
                }
            }
        });
    }

    public void onRecordStateChange(boolean z) {
        this.mTimeLineControlView.setEnabled(!z);
        this.mSeeAllVieo.setEnabled(!z);
        this.time_line_land.setEnabled(!z);
    }

    public void onPause() {
        doStopRecord();
        try {
            this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver);
            this.mCameraSdcardExFileManager.O00000Oo();
        } catch (Throwable unused) {
        }
        super.onPause();
        this.isForeground = false;
        chr.O00000oo();
    }

    public void doResume() {
        if ((this.mIsUserPause && !this.isVideoPlaying) || !this.isForeground) {
            return;
        }
        if (getEndTimeOfLastVideo() != 0) {
            startPlayVideoWithCheckConnection(this.mTimeLineControlView.getSelectTime(), false);
        } else if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000OOo();
        }
    }

    public void refreshUI() {
        if (this.mCameraPlayerEx == null || this.mCameraPlayerEx.O0000OoO()) {
            this.cdcToggleAudio.setChecked(false);
        } else {
            this.cdcToggleAudio.setChecked(true);
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i != 2) {
            if (i == 4000) {
                this.mNeedSpeed = false;
                this.mTimeUpdateView.setVisibility(8);
            }
        } else if (this.mCameraPlayerEx != null) {
            long O0000oOo = this.mCameraPlayerEx.O0000oOo();
            if (this.mLastUpdateTime == O0000oOo || this.mSeekBarTouched || !this.mCameraPlayerEx.O0000Ooo()) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
                return;
            }
            if (O0000oOo >= 0) {
                setIsConnected();
            }
            if (getEndTimeOfLastVideo() == 0 || getEndTimeOfLastVideo() - (O0000oOo * 1000) >= ((long) this.UPDATE_DURATION)) {
                this.mLastUpdateTime = O0000oOo;
                int i2 = (int) (O0000oOo - (this.mTimeItem.f5243O000000o / 1000));
                if (this.mIsSetTime) {
                    if (Math.abs(this.mLastOffsetTime - i2) <= 3 || System.currentTimeMillis() - this.mLastSetTime > 6000) {
                        this.mIsSetTime = false;
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
                    this.mTimeLineControlView.updatePlayTime(O0000oOo * 1000, false);
                } else if (Math.abs(((long) this.mSelectTime) - O0000oOo) < 10 || System.currentTimeMillis() - this.mLastSetPlayTime > 10000) {
                    this.mIsSetPlayTime = false;
                    this.mTimeLineControlView.updatePlayTime(O0000oOo * 1000, false);
                    civ.O000000o("SDCardTimeLinePlayerExActivity", "update " + Math.abs(((long) this.mSelectTime) - O0000oOo) + "  " + ((System.currentTimeMillis() - this.mLastSetPlayTime) / 1000));
                }
            } else if (!this.isInEnding) {
                toSdFilesEnd();
            }
        }
    }

    public void toSdFilesEnd() {
        List<TimeItem> O00000oo = this.mCameraSdcardExFileManager.O00000oo();
        if (O00000oo != null && O00000oo.size() > 0) {
            this.mTimeLineControlView.updatePlayTime(getEndTimeOfLastVideo(), false);
            pauseCamera();
            this.isOnFileEnd = true;
        }
    }

    private long getEndTimeOfLastVideo() {
        List<TimeItem> O00000oo = this.mCameraSdcardExFileManager.O00000oo();
        if (O00000oo == null || O00000oo.size() == 0) {
            return 0;
        }
        return O00000oo.get(O00000oo.size() - 1).O00000o0;
    }

    public void startPlay() {
        if (!this.mCameraDevice.O00000o() && TextUtils.isEmpty(this.mCameraDevice.O00oOooo())) {
            updatePwd();
        } else if (TextUtils.isEmpty(this.mCameraDevice.getModel()) || TextUtils.isEmpty(this.mCameraDevice.getDid())) {
            hideLoading();
            showError(getString(R.string.camera_play_error2));
        } else {
            if (this.mCameraPlayerEx == null) {
                this.mCameraPlayerEx = ciy.O000000o(this, this.mCameraDevice, this);
                this.mCameraPlayerEx.O00000oO(true);
                this.mCameraPlayerEx.O000000o(this.mIRecodeTimeListener);
                this.mCameraPlayerEx.O000000o(this.mVideoView);
            }
            startPlayVideo();
        }
    }

    public void upDateTimeTitle(String str) {
        this.mTVRecordTimer.setText(str);
    }

    public void resumeCamera() {
        this.mPauseView.setVisibility(8);
        refreshUI();
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, (long) this.UPDATE_DURATION);
        this.isVideoPlaying = true;
        changePlayBtnBg(true);
        startPlay();
    }

    private void startPlayVideo() {
        showLoading(null);
        if (this.mTimeLineControlView.getSelectTime() < getEndTimeOfLastVideo()) {
            startPlayVideoWithCheckConnection(this.mTimeLineControlView.getSelectTime(), false);
        } else if (this.mCameraSdcardExFileManager.O00000oo() != null && this.mCameraSdcardExFileManager.O00000oo().size() != 0) {
            TimeItem timeItem = this.mCameraSdcardExFileManager.O00000oo().get(this.mCameraSdcardExFileManager.O00000oo().size() - 1);
            if (timeItem == null) {
                gsy.O000000o(6, "SDCardTimeLinePlayerExActivity", "last == null");
            } else {
                startPlayVideoWithCheckConnection(timeItem.f5243O000000o, false);
            }
        }
    }

    public void onResume() {
        chr.O00000oO();
        showLoading(null);
        this.mVideoView.O000000o(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$C_CuuIoZqm_5nG5KiuxB7PC4Qg */

            public final void onVideoViewClick() {
                SDCardTimeLinePlayerExActivity.this.lambda$onResume$0$SDCardTimeLinePlayerExActivity();
            }
        });
        this.mTimeLineControlView.setTimeItems(this.mCameraSdcardExFileManager.O00000oo());
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.mCameraSdcardExFileManager.O00000oO());
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver, intentFilter);
        showViews();
        if (ciw.O000000o(getRequestedOrientation())) {
            this.mFullScreen = true;
            this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (this.mVideoView != null) {
                this.mVideoView.O000000o(true);
            }
            this.mTimeLineControlView.setBackgroundColor(getResources().getColor(R.color.mj_color_gray_heavier));
            this.mSeeAllVieo.setVisibility(8);
            this.mTitleView.setVisibility(8);
        }
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O00000o0(true);
            TextViewS textViewS = this.tvsMultiSpeed;
            textViewS.setText(this.mCameraPlayerEx.O0000oOO() + "X");
        } else {
            this.tvsMultiSpeed.setText("1X");
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$NmDb73K6aTJEh5dlzpDYfjKZg0Y */

            public final void run() {
                SDCardTimeLinePlayerExActivity.this.lambda$onResume$1$SDCardTimeLinePlayerExActivity();
            }
        }, 500);
        startPlay();
        this.isForeground = true;
    }

    public /* synthetic */ void lambda$onResume$0$SDCardTimeLinePlayerExActivity() {
        if (this.land_bottom_ctrl_ll.getTranslationY() > 0.0f) {
            LinearLayout linearLayout = this.land_bottom_ctrl_ll;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "translationY", (float) linearLayout.getHeight(), 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.start();
            return;
        }
        LinearLayout linearLayout2 = this.land_bottom_ctrl_ll;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "translationY", 0.0f, (float) linearLayout2.getHeight());
        ofFloat2.setDuration(200L);
        ofFloat2.start();
    }

    public /* synthetic */ void lambda$onResume$1$SDCardTimeLinePlayerExActivity() {
        this.mCameraSdcardExFileManager.O0000O0o();
        this.mCameraSdcardExFileManager.O000000o();
    }

    public void startPlayVideoWithCheckConnection(long j, boolean z) {
        if (this.mCameraPlayerEx != null) {
            if (this.mCameraPlayerEx.O0000Oo()) {
                startMissPlayback(j, z);
                return;
            }
            showLoading(null);
            this.mCameraPlayerEx.O00000Oo(new IXmConnectionClient.XmActionCallback() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass12 */

                public void onSuccess(String str, Object obj) {
                    if (SDCardTimeLinePlayerExActivity.this.isFinishing()) {
                    }
                }

                public void onFailed(int i, String str) {
                    if (!SDCardTimeLinePlayerExActivity.this.isFinishing()) {
                        SDCardTimeLinePlayerExActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$12$YcLMBo1ETXh2XtuBtMGV_kdyJU */

                            public final void run() {
                                SDCardTimeLinePlayerExActivity.AnonymousClass12.this.lambda$onFailed$0$SDCardTimeLinePlayerExActivity$12();
                            }
                        });
                        gsy.O000000o(6, "SDCardTimeLinePlayerExActivity", "SDCardTimeLinePlayerExActivity startStreamPlay onFailed:" + i + " " + str);
                        SDCardTimeLinePlayerExActivity sDCardTimeLinePlayerExActivity = SDCardTimeLinePlayerExActivity.this;
                        sDCardTimeLinePlayerExActivity.showError(sDCardTimeLinePlayerExActivity.getString(R.string.video_play_failed));
                    }
                }

                public /* synthetic */ void lambda$onFailed$0$SDCardTimeLinePlayerExActivity$12() {
                    SDCardTimeLinePlayerExActivity.this.hideLoading();
                }
            });
        }
    }

    public void onClick(View view) {
        doOnClick(view);
        if (view.getId() == R.id.tvsMultiSpeed) {
            if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O0000Ooo()) {
                getContext();
                gqg.O000000o((int) R.string.operation_failed);
            } else if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000O0o()) {
                toggleSpeed();
            } else {
                gqg.O000000o((int) R.string.record_resolution_block);
            }
        } else if (view.getId() == R.id.ivFullScreen) {
            if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O0000Ooo()) {
                getContext();
                gqg.O000000o((int) R.string.operation_failed);
            } else if (this.mFullScreen) {
                setOrientation(false);
            } else {
                setOrientation(true);
            }
        } else if (view.getId() != R.id.ivCameraShot) {
        } else {
            if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O0000Ooo()) {
                getContext();
                gqg.O000000o((int) R.string.operation_failed);
            } else if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                getContext();
                gqg.O000000o((int) R.string.no_write_permission);
            } else {
                snapShot();
            }
        }
    }

    private void startMissPlayback(long j, boolean z) {
        setPlayTime(j, z, new IXmConnectionClient.XmActionCallback() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass13 */

            public void onSuccess(String str, Object obj) {
                cki.O00000o("SDCardTimeLinePlayerExActivity", "onSuccess");
                if (SDCardTimeLinePlayerExActivity.this.isFinishing()) {
                }
            }

            public void onFailed(int i, String str) {
                cki.O00000o("SDCardTimeLinePlayerExActivity", "onFailed:" + str + str);
                if (!SDCardTimeLinePlayerExActivity.this.isFinishing()) {
                    SDCardTimeLinePlayerExActivity.this.runOnUiThread(new Runnable(i, str) {
                        /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$13$9xIx9NYZIgCUNLRFVqdtjV30af4 */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            SDCardTimeLinePlayerExActivity.AnonymousClass13.this.lambda$onFailed$0$SDCardTimeLinePlayerExActivity$13(this.f$1, this.f$2);
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onFailed$0$SDCardTimeLinePlayerExActivity$13(int i, String str) {
                SDCardTimeLinePlayerExActivity.this.hideLoading();
                gsy.O000000o(6, "SDCardTimeLinePlayerExActivity", "SDCardTimeLinePlayerExActivity playbackStream onFailed:" + i + " " + str);
                SDCardTimeLinePlayerExActivity sDCardTimeLinePlayerExActivity = SDCardTimeLinePlayerExActivity.this;
                sDCardTimeLinePlayerExActivity.showError(sDCardTimeLinePlayerExActivity.getString(R.string.video_play_failed));
                SDCardTimeLinePlayerExActivity.this.mHandler.removeMessages(2);
            }
        });
        if (!this.mCameraPlayerEx.O0000OoO()) {
            this.mCameraPlayerEx.O00000o0(this.mCameraPlayerEx.O0000OoO());
        }
    }

    public void onServerCmd(int i, byte[] bArr) {
        String optString;
        char c;
        if (!isFinishing()) {
            gsy.O00000Oo("SDCardTimeLinePlayerExActivity", "server cmd:" + i + " " + new String(bArr));
            if (i == 270) {
                civ.O00000o0("SDCardTimeLinePlayerExActivity", "onServerCmd thread " + Thread.currentThread());
                try {
                    String str = new String(bArr);
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("id", -1);
                    civ.O00000o0("SDCardTimeLinePlayerExActivity", "id ".concat(str));
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
                        civ.O00000o0("SDCardTimeLinePlayerExActivity", " onServerCmd status ".concat(String.valueOf(optString)));
                    }
                } catch (Exception e) {
                    civ.O00000o0("CameraPlay", e.toString());
                }
            }
        }
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$ubNhYaz3L87jfz286xMzudvv1dI */

                public final void run() {
                    SDCardTimeLinePlayerExActivity.this.lambda$onBackPressed$2$SDCardTimeLinePlayerExActivity();
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    public /* synthetic */ void lambda$onBackPressed$2$SDCardTimeLinePlayerExActivity() {
        setOrientation(false);
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
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
        } else if (z) {
            enterPadFullScreen();
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cin.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity, int]
     candidates:
      _m_j.cin.O000000o(int, boolean):int
      _m_j.cin.O000000o(java.lang.String, java.lang.String):int
      _m_j.cin.O000000o(long, android.content.res.Resources):java.lang.String
      _m_j.cin.O000000o(android.content.Context, int):java.lang.String
      _m_j.cin.O000000o(android.content.res.Resources, int):java.lang.String
      _m_j.cin.O000000o(android.content.Context, float):int */
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
     method: _m_j.hyy.O000000o(android.app.Activity, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity, boolean]
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
                    this.mVideoView.O000000o(true);
                }
                this.mTimeLineControlView.setBackgroundColor(getResources().getColor(R.color.land_timeline_bg));
                this.mSeeAllVieo.setVisibility(8);
                this.mTitleView.setVisibility(8);
                this.time_line_land.removeAllViews();
                this.root.removeAllViews();
                this.time_line_land.addView(this.mTimeLineControlView);
                this.time_line_land.setVisibility(0);
                layoutParams2.topMargin = cin.O000000o((Context) this, 30.0f);
                this.mTVRecordTimer.setLayoutParams(layoutParams2);
                this.zhanwei_land.setVisibility(0);
                int O000000o2 = ckq.O000000o(this);
                this.llVideoViewBottomCtrl.setPadding(O000000o2, 0, O000000o2, 0);
                this.mTimeLineControlView.setPadding(O000000o2, 0, O000000o2, 0);
                FrameLayout frameLayout = this.mFLTitleBar;
                frameLayout.setPadding(O000000o2, frameLayout.getPaddingTop(), O000000o2, 0);
                layoutParams.bottomMargin = this.llVideoViewBottomCtrl.getHeight() + cin.O000000o((Context) activity(), 90.0f);
                layoutParams.leftMargin += O000000o2;
                this.llFuncPopup.setLayoutParams(layoutParams);
                this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2_exit);
            } else {
                if (hyy.O000000o()) {
                    this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.currentVideoHeight));
                } else {
                    this.mVideoViewFrame.setLayoutParams(new RelativeLayout.LayoutParams(-1, cin.O000000o((Context) activity(), 350.0f)));
                }
                if (this.mVideoView != null) {
                    this.mVideoView.O000000o(false);
                }
                this.mTimeLineControlView.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
                this.mSeeAllVieo.setVisibility(0);
                this.mTitleView.setVisibility(0);
                this.time_line_land.removeAllViews();
                this.time_line_land.setVisibility(8);
                this.root.removeAllViews();
                this.root.addView(this.mTimeLineControlView);
                layoutParams2.topMargin = cin.O000000o((Context) this, 65.0f);
                this.mTVRecordTimer.setLayoutParams(layoutParams2);
                this.zhanwei_land.setVisibility(8);
                this.llVideoViewBottomCtrl.setPadding(0, 0, 0, 0);
                this.mTimeLineControlView.setPadding(0, 0, 0, 0);
                this.mFLTitleBar.setPadding(0, this.mFLTitleBar.getPaddingTop(), 0, 0);
                layoutParams.bottomMargin = this.llVideoViewBottomCtrl.getHeight() + cin.O000000o((Context) activity(), 6.0f);
                layoutParams.leftMargin = cin.O000000o((Context) activity(), 15.0f);
                this.llFuncPopup.setLayoutParams(layoutParams);
                this.ivFullScreen.setImageResource(R.drawable.camera_icon_fullscreen2);
            }
            hyy.O000000o((Activity) this, this.mFullScreen);
        } catch (Exception e) {
            gsy.O000000o(6, "SDCardTimeLinePlayerExActivity", "onConfigurationChanged:" + e.getLocalizedMessage());
        }
    }

    private void toggleSpeed() {
        if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000Ooo()) {
            getContext();
            gqg.O000000o((int) R.string.sd_card_video_not_playing);
            return;
        }
        int O0000oOO = this.mCameraPlayerEx.O0000oOO();
        civ.O000000o("SDCardTimeLinePlayerExActivity", "speed:".concat(String.valueOf(O0000oOO)));
        int i = 16;
        if (O0000oOO == 1) {
            i = 4;
        } else if (O0000oOO != 4) {
            i = 1;
        }
        this.mCameraPlayerEx.O00000Oo(i);
        if (i == 1) {
            this.cdcToggleAudio.setEnabled(true);
        } else {
            if (this.cdcToggleAudio.isChecked()) {
                this.cdcToggleAudio.performClick();
            }
            this.cdcToggleAudio.setEnabled(false);
        }
        TextViewS textViewS = this.tvsMultiSpeed;
        textViewS.setText(i + "X");
    }

    public void onConnected() {
        if (this.isForeground) {
            super.onConnected();
            if (!this.mIsUserPause) {
                startPlayVideo();
                civ.O000000o("SDCardTimeLinePlayerExActivity", "SDCardPlayer reconnect");
            }
        }
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
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
        } else if (this.mCameraDevice == null || this.mCameraDevice.O000000o() == null || !this.mCameraDevice.O000000o().O000000o("power", true)) {
            CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), activity(), R.string.power_off);
        } else if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000Oo()) {
            activity();
            gqg.O000000o((int) R.string.snap_failed_paused);
        } else {
            this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$6ZomX8wHehFr5HSIlA6QpwJ4UU */

                public final void onSnap(Bitmap bitmap) {
                    SDCardTimeLinePlayerExActivity.this.lambda$snapShot$4$SDCardTimeLinePlayerExActivity(bitmap);
                }
            });
        }
    }

    public /* synthetic */ void lambda$snapShot$4$SDCardTimeLinePlayerExActivity(Bitmap bitmap) {
        goq.O000000o(new Runnable(bitmap) {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$RGQWbzAi_G7_70KW0NPwzObO6s */
            private final /* synthetic */ Bitmap f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SDCardTimeLinePlayerExActivity.this.lambda$null$3$SDCardTimeLinePlayerExActivity(this.f$1);
            }
        });
    }

    public void doStopRecord() {
        this.mLastTime = 0;
        this.mCurrentTime = 0;
        if (this.mCameraPlayerEx != null && this.mCameraPlayerEx.O0000O0o()) {
            if (this.mCameraPlayerEx.O0000OoO()) {
                this.mCameraPlayerEx.O00000Oo(false);
            }
            this.mCameraPlayerEx.O000000o(new XmMp4Record.IRecordListener() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass14 */

                public void onSuccess(String str) {
                    SDCardTimeLinePlayerExActivity.this.mTVRecordTimer.setVisibility(8);
                    SDCardTimeLinePlayerExActivity.this.onVideoRecorded(str);
                    if (SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.isChecked()) {
                        SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.setChecked(false);
                    }
                }

                public void onFailed(int i, String str) {
                    SDCardTimeLinePlayerExActivity.this.mTVRecordTimer.setVisibility(8);
                    if (SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.isChecked()) {
                        SDCardTimeLinePlayerExActivity.this.cdcCameraRecord.setChecked(false);
                    }
                    if (i == -2) {
                        gqg.O000000o((int) R.string.snip_video_failed_time_mini);
                    } else {
                        gqg.O000000o((int) R.string.snip_video_failed);
                    }
                }
            });
        } else if (this.cdcCameraRecord.isChecked()) {
            this.cdcCameraRecord.setChecked(false);
        }
    }

    public void onVideoRecorded(String str) {
        File file = new File(str);
        if (file.exists()) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            final clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null && this.mVideoView != null) {
                this.mVideoView.O000000o(new XmVideoViewGl.PhotoSnapCallback() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass15 */

                    public void onSnap(Bitmap bitmap) {
                        int O000000o2 = gpc.O000000o(100.0f);
                        if (bitmap != null) {
                            final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, O000000o2, (bitmap.getHeight() * O000000o2) / bitmap.getWidth(), false);
                            SDCardTimeLinePlayerExActivity.this.runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass15.AnonymousClass1 */

                                public void run() {
                                    if (createScaledBitmap != null) {
                                        ImageView imageView = (ImageView) SDCardTimeLinePlayerExActivity.this.findViewById(R.id.ivShotPic);
                                        imageView.setImageBitmap(createScaledBitmap);
                                        if (SDCardTimeLinePlayerExActivity.this.llFuncPopup.getVisibility() == 0) {
                                            SDCardTimeLinePlayerExActivity.this.llFuncPopup.setVisibility(4);
                                        }
                                        SDCardTimeLinePlayerExActivity.this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(SDCardTimeLinePlayerExActivity.this, R.anim.anim_snap_shot_in));
                                        SDCardTimeLinePlayerExActivity.this.llFuncPopup.setVisibility(0);
                                        SDCardTimeLinePlayerExActivity.this.dismissSnapshotPopupRunnable(3000);
                                        imageView.setOnClickListener(new View.OnClickListener() {
                                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardTimeLinePlayerExActivity.AnonymousClass15.AnonymousClass1.AnonymousClass1 */

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
                                            public void onClick(View view) {
                                                if (SDCardTimeLinePlayerExActivity.this.canStepOut(R.string.speaking_block, R.string.recording_block)) {
                                                    SDCardTimeLinePlayerExActivity.this.dismissSnapshotPopupRunnable(0);
                                                    Intent intent = new Intent();
                                                    intent.putExtra("file_path", O00000Oo.O00000o);
                                                    intent.putExtra("noScroll", true);
                                                    intent.setClass(SDCardTimeLinePlayerExActivity.this, LocalPicActivity.class);
                                                    SDCardTimeLinePlayerExActivity.this.startActivity(intent);
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
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000OOo();
        }
        hideLoading();
        changePlayBtnBg(false);
        this.isVideoPlaying = false;
    }

    public /* synthetic */ void lambda$new$5$SDCardTimeLinePlayerExActivity() {
        if (this.llFuncPopup.getVisibility() == 0) {
            this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(activity(), R.anim.anim_snap_shot_out));
            this.llFuncPopup.setVisibility(4);
        }
    }

    public void dismissSnapshotPopupRunnable(long j) {
        this.mHandler.removeCallbacks(this.dismissRunnable);
        this.mHandler.postDelayed(this.dismissRunnable, j);
    }

    public void onStop() {
        super.onStop();
        dismissSnapshotPopupRunnable(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    /* access modifiers changed from: package-private */
    /* renamed from: onSnapShot */
    public void lambda$null$3$SDCardTimeLinePlayerExActivity(Bitmap bitmap) {
        String O000000o2 = me.O000000o(false, this.mCameraDevice.getDid());
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
            int O000000o3 = gpc.O000000o(100.0f);
            runOnUiThread(new Runnable(O000000o2, Bitmap.createScaledBitmap(bitmap, O000000o3, (bitmap.getHeight() * O000000o3) / bitmap.getWidth(), false)) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$MWN4ZUmkboKl7NkQu8RsojytcFg */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Bitmap f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SDCardTimeLinePlayerExActivity.this.lambda$onSnapShot$7$SDCardTimeLinePlayerExActivity(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSnapShot$7$SDCardTimeLinePlayerExActivity(String str, Bitmap bitmap) {
        if (new File(str).exists()) {
            ImageView imageView = (ImageView) findViewById(R.id.ivShotPic);
            if (this.llFuncPopup.getVisibility() == 0) {
                this.llFuncPopup.setVisibility(4);
            }
            this.llFuncPopup.startAnimation(AnimationUtils.loadAnimation(activity(), R.anim.anim_snap_shot_in));
            this.llFuncPopup.setVisibility(0);
            dismissSnapshotPopupRunnable(3000);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            ContentValues contentValues = new ContentValues(4);
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("_data", str);
            contentValues.put("mime_type", "image/jpeg");
            try {
                if (!Build.MODEL.equals("HM 1SC")) {
                    activity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                }
                civ.O000000o("SDCardTimeLinePlayerExActivity", "snap success");
            } catch (Throwable unused) {
            }
            clj.O000000o O00000Oo = this.mCameraDevice.O0000O0o().O00000Oo(str);
            if (O00000Oo != null) {
                imageView.setOnClickListener(new View.OnClickListener(O00000Oo) {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.$$Lambda$SDCardTimeLinePlayerExActivity$AXDul9PTEeVhtFCK9wAlEGEhG9M */
                    private final /* synthetic */ clj.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        SDCardTimeLinePlayerExActivity.this.lambda$null$6$SDCardTimeLinePlayerExActivity(this.f$1, view);
                    }
                });
            }
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
    public /* synthetic */ void lambda$null$6$SDCardTimeLinePlayerExActivity(clj.O000000o o000000o, View view) {
        if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O0000O0o()) {
            dismissSnapshotPopupRunnable(0);
            Intent intent = new Intent(activity(), LocalPicActivity.class);
            intent.putExtra("noScroll", true);
            intent.putExtra("file_path", o000000o.O00000o);
            startActivity(intent);
            return;
        }
        gqg.O00000Oo((int) R.string.recording_block);
    }

    public void setPlayTime(long j, boolean z, IXmConnectionClient.XmActionCallback xmActionCallback) {
        int i;
        TimeItem timeItem;
        long j2 = j;
        TimeItem O000000o2 = this.mCameraSdcardExFileManager.O000000o(j2);
        if (O000000o2 != null) {
            civ.O00000o0("SDCardTimeLinePlayerExActivity", "last set time before " + mi.O00000Oo(j));
            int i2 = (int) (O000000o2.f5243O000000o / 1000);
            i = O000000o2.f5243O000000o < j2 ? ((int) (j2 - O000000o2.f5243O000000o)) / 1000 : 0;
            StringBuilder sb = new StringBuilder("last set time after  ");
            long j3 = (long) (i * 1000);
            sb.append(mi.O00000Oo(O000000o2.f5243O000000o + j3));
            civ.O00000o0("SDCardTimeLinePlayerExActivity", sb.toString());
            this.mIsSetPlayTime = true;
            this.mSelectTime = i2 + i;
            this.mTimeLineControlView.updatePlayTime(O000000o2.f5243O000000o + j3, false);
        } else {
            civ.O00000o0("SDCardTimeLinePlayerExActivity", "last set time alive");
            this.mHandler.removeMessages(2);
            this.mIsSetPlayTime = true;
            if (this.mCameraSdcardExFileManager.O00000oo() != null && this.mCameraSdcardExFileManager.O00000oo().size() != 0 && j2 != 0 && (timeItem = this.mCameraSdcardExFileManager.O00000oo().get(this.mCameraSdcardExFileManager.O00000oo().size() - 1)) != null) {
                if (j2 >= timeItem.O00000o0) {
                    toSdFilesEnd();
                    return;
                }
                i = 0;
            } else {
                return;
            }
        }
        if (!this.mIsUserPause) {
            hidError();
            showLoading(null);
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
        setPlayWithOffset(i, z, xmActionCallback);
    }

    private void setPlayWithOffset(int i, boolean z, IXmConnectionClient.XmActionCallback xmActionCallback) {
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
        this.mIsUserPause = false;
        if (this.isOnFileEnd) {
            this.isOnFileEnd = false;
            z = false;
        }
        if (this.mCameraPlayerEx != null && (!this.mCameraPlayerEx.O0000o00() || !z)) {
            changePlayBtnBg(true);
            if (!this.mCameraPlayerEx.O0000Ooo()) {
                this.mCameraPlayerEx.O00000o(true);
            }
            this.mCameraPlayerEx.O000000o(this.mStartTime, i, 0, xmActionCallback);
            this.isVideoPlaying = true;
            changePlayBtnBg(true);
            if (!(this.mErrorRetryView == null || this.mErrorRetryView.getVisibility() == 8)) {
                this.mErrorRetryView.setVisibility(8);
            }
        }
        if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O0000o00()) {
            showLoading(null);
        }
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 3000);
        civ.O00000o0("SDCardTimeLinePlayerExActivity", "SDCardPlayer PlayTime " + this.mStartTime + " offset " + i + " end " + this.mEndTime);
    }

    public void onPlayError() {
        super.onPlayError();
        this.isVideoPlaying = false;
        changePlayBtnBg(false);
    }
}
