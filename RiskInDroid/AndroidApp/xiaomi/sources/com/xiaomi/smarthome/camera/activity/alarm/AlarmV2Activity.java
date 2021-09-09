package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chp;
import _m_j.cin;
import _m_j.civ;
import _m_j.clc;
import _m_j.cle;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.izb;
import _m_j.me;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmMp4Player;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalAudioPlay;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.camera.view.CameraPullDownRefreshListView;
import com.xiaomi.smarthome.camera.view.widget.LoadMoreView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class AlarmV2Activity extends CameraBaseActivity implements View.OnClickListener {
    private final int MSG_DOWN_FILE = 11;
    private final int MSG_SAVE_FAILURE = 15;
    private final int MSG_SAVE_START = 16;
    private final int MSG_SAVE_STOP = 17;
    private final int MSG_SAVE_SUCCESS = 14;
    private final int MSG_UPDATE_PROGRESS = 12;
    private final int MSG_UPDATE_SEEK_PROGRESS = 13;
    public String currentPlayingFilePath = null;
    private boolean isCreate = true;
    public boolean isMute = true;
    public AlarmAdapterV2 mAdapter;
    public clc mAlarmItemV2;
    public SimpleDateFormat mAlarmTimeFormat;
    public TextView mAlarmTimeView;
    public boolean mAutoPause = false;
    public TextView mDurationView;
    private RelativeLayout mEmptyLayout;
    public boolean mHasMore = true;
    private LinearLayout mHistoryLayout;
    public boolean mIsMoreLoading = false;
    private View mLoadIng;
    public LoadMoreView mLoadMoreView;
    private AnimationDrawable mLoadingAnimation;
    private LocalAudioPlay mLocalAudioPlay = null;
    public CameraPullDownRefreshListView mMediaListView;
    private boolean mNeedCheck = false;
    private boolean mNeedPincode = false;
    public long mPathTime = -1;
    public ImageView mPauseBtn;
    private ImageView mPlayBg;
    public ImageView mPlayBtn;
    public TextView mPlayingView;
    public SeekBar mProgressBar;
    public XQProgressDialog mPullingDlg;
    public FrameLayout mReplayLayout;
    private ImageView mScreenFull;
    private SeekBar.OnSeekBarChangeListener mSeekBarChange = new SeekBar.OnSeekBarChangeListener() {
        /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass10 */

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (AlarmV2Activity.this.mSeekBarTouched) {
                AlarmV2Activity.this.mHandler.removeMessages(13);
                AlarmV2Activity.this.mPlayingView.setText(AlarmV2Activity.this.mTimeFormat.format(Integer.valueOf(i * 1000)));
                Message obtainMessage = AlarmV2Activity.this.mHandler.obtainMessage();
                obtainMessage.what = 13;
                obtainMessage.arg1 = i;
                obtainMessage.sendToTarget();
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            AlarmV2Activity.this.mSeekBarTouched = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            AlarmV2Activity.this.mSeekBarTouched = false;
        }
    };
    boolean mSeekBarTouched = false;
    private View mShareView;
    private TextView mSubTitle;
    public SimpleDateFormat mTimeFormat;
    public XmMp4Player mVideoPlayerRender;
    private TextView mVideoProgress;
    public View mVideoTool;
    private XmVideoViewGl mVideoView;
    private FrameLayout mVideoViewFrame;
    private FrameLayout titleBar;
    public ImageView videoMute;

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 11:
                if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    izb.O000000o(activity(), (int) R.string.no_write_permission, 1).show();
                    return;
                }
                if (this.mReplayLayout.getVisibility() != 8) {
                    this.mReplayLayout.setVisibility(8);
                }
                if (this.mCameraDevice != null) {
                    showLoading();
                    this.mCameraDevice.O0000o0o().O000000o(this, this.mAlarmItemV2, new cle.O000000o<String>() {
                        /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass1 */

                        public void onSuccess(String str, Object obj) {
                            if (!AlarmV2Activity.this.isFinishing()) {
                                AlarmV2Activity.this.hideLoading();
                                if (!TextUtils.isEmpty(str)) {
                                    AlarmV2Activity.this.startPlay(str, true);
                                }
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!AlarmV2Activity.this.isFinishing()) {
                                AlarmV2Activity.this.hideLoading();
                                civ.O000000o("AlarmV2Activity", "getAlarmFile errorCode:" + i + " errorMessage:" + str);
                            }
                        }
                    });
                    return;
                }
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                this.mHandler.removeMessages(12);
                if (!this.mSeekBarTouched) {
                    int currentPosition = this.mVideoPlayerRender.getCurrentPosition();
                    if (currentPosition >= 0 && currentPosition <= 60000) {
                        this.mPlayingView.setText(this.mTimeFormat.format(Integer.valueOf(currentPosition)));
                        this.mProgressBar.setProgress(currentPosition / 1000);
                    } else {
                        return;
                    }
                }
                this.mHandler.sendEmptyMessageDelayed(12, 200);
                return;
            case 13:
                this.mVideoPlayerRender.seekTo(this.mProgressBar.getProgress() * 1000);
                return;
            case 14:
                activity();
                gqg.O000000o((int) R.string.save_success);
                return;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                activity();
                gqg.O000000o((int) R.string.retry_download_media_file);
                return;
            case 16:
                XQProgressDialog xQProgressDialog = this.mPullingDlg;
                if (xQProgressDialog != null) {
                    xQProgressDialog.show();
                    return;
                }
                return;
            case 17:
                XQProgressDialog xQProgressDialog2 = this.mPullingDlg;
                if (xQProgressDialog2 != null && xQProgressDialog2.isShowing()) {
                    this.mPullingDlg.dismiss();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPullingDlg = new XQProgressDialog(this);
        this.mPullingDlg.setCancelable(true);
        this.mPullingDlg.setMessage(getResources().getString(R.string.mj_loading));
        setContentView((int) R.layout.camera_activity_alarm_v2);
        this.mNeedCheck = getIntent().getBooleanExtra("check", false);
        civ.O00000o("alarm", "need check " + this.mNeedCheck);
        if (this.mDeviceStat == null) {
            finish();
            return;
        }
        if (this.mNeedCheck) {
            globalPinCodeVerifyFunc();
            civ.O00000o("alarm", "enableVerifyPincode " + this.mDeviceStat.isSetPinCode);
            if (this.mCameraDevice.O0000oO()) {
                this.mNeedPincode = true;
                civ.O000000o("AlarmV2Activity", "need pincode ");
            }
        }
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String str = null;
        if (XmPluginHostApi.instance().getSettingLocale() != null) {
            str = XmPluginHostApi.instance().getSettingLocale().getLanguage();
        }
        if (XmPluginHostApi.instance().getApiLevel() < 51 || (!"de".equalsIgnoreCase(str) && !"es".equalsIgnoreCase(str) && !"fr".equalsIgnoreCase(str) && !"it".equalsIgnoreCase(str) && !"pl".equalsIgnoreCase(str) && !"ru".equalsIgnoreCase(str))) {
            this.mAlarmTimeFormat = new SimpleDateFormat("yyy-MM-dd");
        } else {
            this.mAlarmTimeFormat = new SimpleDateFormat("dd-MM-yyyy");
        }
        this.mAlarmItemV2 = new clc();
        initView();
        initVideoView();
        showEmptyView(true);
        this.mPullingDlg.show();
    }

    private void initView() {
        this.titleBar = (FrameLayout) findViewById(R.id.title_bar);
        this.mAlarmTimeView = (TextView) findViewById(R.id.alarm_time);
        this.mPlayBg = (ImageView) findViewById(R.id.img_alert_new_video_jpg);
        this.mLoadIng = findViewById(R.id.loading_lyt);
        this.mVideoProgress = (TextView) findViewById(R.id.text_new_video_progress);
        this.mHistoryLayout = (LinearLayout) findViewById(R.id.history_alarm_layout);
        this.mPauseBtn = (ImageView) findViewById(R.id.btn_alert_main_pause);
        this.mPlayBtn = (ImageView) findViewById(R.id.btn_alert_main_play);
        this.mPauseBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass2 */

            public void onClick(View view) {
                if (AlarmV2Activity.this.mVideoPlayerRender.isPlaying()) {
                    AlarmV2Activity.this.mVideoPlayerRender.pause();
                }
                AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                alarmV2Activity.mAutoPause = false;
                alarmV2Activity.mPauseBtn.setVisibility(8);
                AlarmV2Activity.this.mPlayBtn.setVisibility(0);
            }
        });
        this.mPlayBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass3 */

            public void onClick(View view) {
                if (AlarmV2Activity.this.mReplayLayout.getVisibility() == 0) {
                    AlarmV2Activity.this.mReplayLayout.setVisibility(8);
                }
                AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                alarmV2Activity.startPlay(alarmV2Activity.currentPlayingFilePath, false);
                AlarmV2Activity.this.mPlayBtn.setVisibility(8);
                if (AlarmV2Activity.this.mReplayLayout.getVisibility() == 0) {
                    AlarmV2Activity.this.mReplayLayout.setVisibility(8);
                }
                AlarmV2Activity.this.mPauseBtn.setVisibility(0);
            }
        });
        this.mScreenFull = (ImageView) findViewById(R.id.btn_alert_main_full_screen);
        this.mScreenFull.setOnClickListener(this);
        findViewById(R.id.ivSave).setOnClickListener(this);
        this.mProgressBar = (SeekBar) findViewById(R.id.progress_bar);
        this.mProgressBar.setOnSeekBarChangeListener(this.mSeekBarChange);
        this.mDurationView = (TextView) findViewById(R.id.progress_duration);
        this.mPlayingView = (TextView) findViewById(R.id.progress_playtime);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_loading);
        ((ImageView) findViewById(R.id.loading_anim)).setImageDrawable(this.mLoadingAnimation);
        findViewById(R.id.history_alarm).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.title_bar_more);
        this.mShareView = findViewById(R.id.title_bar_share);
        this.mShareView.setVisibility(8);
        this.mShareView.setOnClickListener(this);
        imageView.setImageResource(R.drawable.camera_tittlebar_set);
        imageView.setOnClickListener(this);
        this.mEmptyLayout = (RelativeLayout) findViewById(R.id.layout_empty);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.main_play_file);
        this.mSubTitle = (TextView) findViewById(R.id.sub_title_bar_title);
        this.mSubTitle.setVisibility(0);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mMediaListView = (CameraPullDownRefreshListView) findViewById(R.id.list_event_listview);
        this.mAdapter = new AlarmAdapterV2(activity());
        this.mLoadMoreView = (LoadMoreView) getLayoutInflater().inflate((int) R.layout.camera_load_more_data, (ViewGroup) null);
        this.mMediaListView.addFooterView(this.mLoadMoreView);
        this.mLoadMoreView.setLoadingNone();
        this.mMediaListView.setAdapter((ListAdapter) this.mAdapter);
        this.mMediaListView.setRefreshListener(new CameraPullDownRefreshListView.OnRefreshListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass4 */

            public void startRefresh() {
                AlarmV2Activity.this.loadData(true, false);
            }
        });
        this.mMediaListView.setOnLastItemVisibleListener(new CameraPullDownRefreshListView.OnLastItemVisibleListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass5 */

            public void onLastItemVisible() {
                if (AlarmV2Activity.this.mHasMore && !AlarmV2Activity.this.mIsMoreLoading) {
                    AlarmV2Activity.this.loadMoreData();
                }
            }
        });
        this.videoMute = (ImageView) findViewById(R.id.video_mute);
        this.videoMute.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass6 */

            public void onClick(View view) {
                if (AlarmV2Activity.this.isMute) {
                    AlarmV2Activity.this.videoMute.setImageResource(R.drawable.camera_alarm_icon_unmute);
                    AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                    alarmV2Activity.isMute = false;
                    alarmV2Activity.mVideoPlayerRender.setVolume(1);
                    return;
                }
                AlarmV2Activity.this.videoMute.setImageResource(R.drawable.camera_alarm_icon_mute);
                AlarmV2Activity alarmV2Activity2 = AlarmV2Activity.this;
                alarmV2Activity2.isMute = true;
                alarmV2Activity2.mVideoPlayerRender.setVolume(0);
            }
        });
        this.mReplayLayout = (FrameLayout) findViewById(R.id.replay_layout);
        findViewById(R.id.replay_btn).setOnClickListener(this);
        this.mMediaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass7 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = i - 1;
                if (i2 >= 0 && i2 < AlarmV2Activity.this.mAdapter.getCount()) {
                    AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                    alarmV2Activity.mAlarmItemV2 = alarmV2Activity.mAdapter.getItem(i2);
                    AlarmV2Activity.this.mAlarmTimeView.setVisibility(0);
                    AlarmV2Activity.this.mAlarmTimeView.setText(AlarmV2Activity.this.mAlarmTimeFormat.format(Long.valueOf(AlarmV2Activity.this.mAlarmItemV2.O00000o0)));
                    if (AlarmV2Activity.this.mVideoPlayerRender.isPlaying()) {
                        AlarmV2Activity.this.mVideoPlayerRender.pause();
                        AlarmV2Activity.this.mVideoPlayerRender.seekTo(0);
                    }
                    AlarmV2Activity.this.mHandler.removeMessages(12);
                    AlarmV2Activity.this.mHandler.sendEmptyMessage(11);
                    AlarmV2Activity.this.mPauseBtn.setVisibility(0);
                    AlarmV2Activity.this.mPlayBtn.setVisibility(8);
                }
            }
        });
    }

    public void loadData(boolean z, final boolean z2) {
        this.mCameraDevice.O0000o0o().O000000o(new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass8 */

            public void onSuccess(Void voidR) {
                if (!AlarmV2Activity.this.isFinishing()) {
                    if (AlarmV2Activity.this.mPullingDlg != null && AlarmV2Activity.this.mPullingDlg.isShowing()) {
                        AlarmV2Activity.this.mPullingDlg.dismiss();
                    }
                    if (AlarmV2Activity.this.mMediaListView.isRefreshing()) {
                        AlarmV2Activity.this.mMediaListView.postRefresh();
                    }
                    List<clc> list = AlarmV2Activity.this.mCameraDevice.O0000o0o().O00000o0;
                    if (list == null || list.isEmpty()) {
                        AlarmV2Activity.this.showEmptyView(true);
                        return;
                    }
                    AlarmV2Activity.this.mAdapter.setData(list, AlarmV2Activity.this.mCameraDevice.getDid());
                    AlarmV2Activity.this.showEmptyView(false);
                    AlarmV2Activity.this.mAlarmItemV2 = list.get(0);
                    AlarmV2Activity.this.mAlarmTimeView.setVisibility(0);
                    AlarmV2Activity.this.mAlarmTimeView.setText(AlarmV2Activity.this.mAlarmTimeFormat.format(Long.valueOf(AlarmV2Activity.this.mAlarmItemV2.O00000o0)));
                    if (z2) {
                        if (AlarmV2Activity.this.mVideoPlayerRender.isPlaying()) {
                            AlarmV2Activity.this.mVideoPlayerRender.pause();
                            AlarmV2Activity.this.mVideoPlayerRender.seekTo(0);
                        }
                        AlarmV2Activity.this.mHandler.removeMessages(12);
                        AlarmV2Activity.this.mHandler.sendEmptyMessage(11);
                        AlarmV2Activity.this.mPauseBtn.setVisibility(0);
                        AlarmV2Activity.this.mPlayBtn.setVisibility(8);
                        AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                        alarmV2Activity.mPathTime = alarmV2Activity.mAlarmItemV2.O00000o0;
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmV2Activity.this.isFinishing()) {
                    if (AlarmV2Activity.this.mPullingDlg != null && AlarmV2Activity.this.mPullingDlg.isShowing()) {
                        AlarmV2Activity.this.mPullingDlg.dismiss();
                    }
                    if (AlarmV2Activity.this.mMediaListView.isRefreshing()) {
                        AlarmV2Activity.this.mMediaListView.postRefresh();
                    }
                    AlarmV2Activity.this.showEmptyView(true);
                }
            }
        }, z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cle.O000000o(com.xiaomi.smarthome.device.api.Callback<java.lang.Void>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity$9, int]
     candidates:
      _m_j.cle.O000000o(java.util.List<_m_j.clc>, java.util.List<_m_j.clc>):java.util.List<_m_j.clc>
      _m_j.cle.O000000o(boolean, _m_j.cle$O000000o):void
      _m_j.cle.O000000o(com.xiaomi.smarthome.device.api.Callback<java.lang.Void>, boolean):void */
    public void loadMoreData() {
        this.mIsMoreLoading = true;
        List<clc> list = this.mCameraDevice.O0000o0o().O00000o0;
        if (list != null && !list.isEmpty()) {
            this.mCameraDevice.O0000o0o().O000000o((Callback<Void>) new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass9 */

                public void onSuccess(Void voidR) {
                    if (!AlarmV2Activity.this.isFinishing()) {
                        AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                        alarmV2Activity.mIsMoreLoading = false;
                        alarmV2Activity.mHasMore = alarmV2Activity.mCameraDevice.O0000o0o().O00000o;
                        if (AlarmV2Activity.this.mHasMore) {
                            AlarmV2Activity.this.mLoadMoreView.setLoadingData();
                        } else {
                            AlarmV2Activity.this.mLoadMoreView.setLoadingNone();
                        }
                        List<clc> list = AlarmV2Activity.this.mCameraDevice.O0000o0o().O00000o0;
                        if (list != null && !list.isEmpty()) {
                            AlarmV2Activity.this.mAdapter.setData(list, AlarmV2Activity.this.mCameraDevice.getDid());
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmV2Activity.this.isFinishing()) {
                        AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                        alarmV2Activity.mIsMoreLoading = false;
                        alarmV2Activity.mLoadMoreView.setLoadingNone();
                    }
                }
            }, false);
        }
    }

    public void showEmptyView(boolean z) {
        if (z) {
            this.mVideoViewFrame.setVisibility(8);
            this.mMediaListView.setVisibility(8);
            this.mHistoryLayout.setVisibility(8);
            this.mEmptyLayout.setVisibility(0);
            this.mShareView.setVisibility(8);
            return;
        }
        this.mVideoViewFrame.setVisibility(0);
        this.mMediaListView.setVisibility(0);
        this.mHistoryLayout.setVisibility(0);
        this.mEmptyLayout.setVisibility(8);
        this.mShareView.setVisibility(0);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.title_bar_share) {
            if (TextUtils.isEmpty(this.currentPlayingFilePath)) {
                izb.O000000o(activity(), (int) R.string.alarm_share_none, 0).show();
            } else if (!new File(this.currentPlayingFilePath).exists()) {
                izb.O000000o(activity(), (int) R.string.alarm_share_none, 0).show();
            } else {
                saveMediaFileWithoutHint();
            }
        } else if (id == R.id.title_bar_more) {
            if (this.mCameraDevice.isReadOnlyShared()) {
                izb.O000000o(activity(), (int) R.string.auth_fail_read_only, 0).show();
            } else {
                startActivity(new Intent(this, AlarmSettingV2Activity.class));
            }
        } else if (id == R.id.history_alarm) {
            resetVideoStats();
            startActivity(new Intent(this, AlarmDayV2Activity.class));
        } else if (id == R.id.replay_btn) {
            this.mPlayBtn.performClick();
            this.mReplayLayout.setVisibility(8);
        } else if (id == R.id.btn_alert_main_full_screen) {
            if (1 == getRequestedOrientation()) {
                setOrientation(true);
            } else {
                setOrientation(false);
            }
        } else if (id == R.id.ivSave) {
            saveMediaFile();
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.mNeedPincode || !TextUtils.isEmpty(this.mCameraDevice.O0000oOo())) {
            boolean z = this.isCreate;
            if (z) {
                loadData(z, true);
            }
            this.isCreate = false;
            if (this.mAutoPause && this.mReplayLayout.getVisibility() == 8) {
                this.mPauseBtn.setVisibility(0);
                this.mPlayBtn.setVisibility(8);
                startPlay(this.currentPlayingFilePath, false);
            }
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        super.onPause();
        if (this.mVideoPlayerRender.isPlaying()) {
            this.mAutoPause = true;
            this.mVideoPlayerRender.pause();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onDestroy() {
        super.onDestroy();
        XmVideoViewGl xmVideoViewGl = this.mVideoView;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.release();
        }
        LocalAudioPlay localAudioPlay = this.mLocalAudioPlay;
        if (localAudioPlay != null) {
            localAudioPlay.release();
        }
        this.mHandler.removeMessages(12);
        AlarmAdapterV2 alarmAdapterV2 = this.mAdapter;
        if (alarmAdapterV2 != null) {
            alarmAdapterV2.destroyDisplayImageOptions();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setWindow(configuration);
    }

    public void startPlay(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.currentPlayingFilePath = null;
            this.mHandler.sendEmptyMessage(11);
            return;
        }
        this.mAdapter.addDownSuccess(this.mAlarmItemV2);
        this.mSubTitle.setText(this.mAlarmItemV2.O0000OoO);
        this.mPlayBg.setVisibility(8);
        if (str.equals(this.currentPlayingFilePath)) {
            this.mVideoPlayerRender.openVideoPlayer(str);
            if (this.isMute) {
                this.mVideoPlayerRender.setVolume(0);
            } else {
                this.mVideoPlayerRender.setVolume(1);
            }
        } else {
            this.mVideoPlayerRender.changeSource(str);
        }
        this.currentPlayingFilePath = str;
        this.mPauseBtn.setVisibility(0);
        this.mPlayBtn.setVisibility(8);
        this.mShareView.setVisibility(0);
        this.mHandler.sendEmptyMessage(12);
    }

    private void setWindow(Configuration configuration) {
        if (configuration.orientation != 1) {
            activity().getWindow().setFlags(1024, 1024);
            this.titleBar.setVisibility(8);
            this.mScreenFull.setImageResource(R.drawable.camera_alarm_icon_mixscreen);
            this.mEmptyLayout.setVisibility(8);
            this.mMediaListView.setVisibility(8);
            this.mHistoryLayout.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.mVideoViewFrame.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            this.mVideoView.setVideoFrameSize(-1, -1, true);
            return;
        }
        activity().getWindow().clearFlags(1024);
        this.mScreenFull.setImageResource(R.drawable.camera_icon_fullscreen2);
        this.titleBar.setVisibility(0);
        this.mMediaListView.setVisibility(0);
        this.mHistoryLayout.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.mVideoViewFrame.getLayoutParams();
        layoutParams2.height = (chp.f13827O000000o * 9) / 16;
        layoutParams2.width = -1;
        this.mVideoView.setVideoFrameSize(-1, -1, false);
    }

    public void onBackPressed() {
        if (1 != getRequestedOrientation()) {
            setOrientation(false);
        } else {
            super.onBackPressed();
        }
    }

    private void initVideoView() {
        this.mVideoTool = findViewById(R.id.layout_video_tools);
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        this.mVideoViewFrame.getLayoutParams().height = (chp.f13827O000000o * 9) / 16;
        FrameLayout frameLayout = new FrameLayout(activity());
        this.mVideoViewFrame.addView(frameLayout, 0, new FrameLayout.LayoutParams(-1, -1));
        boolean contains = cin.f13904O000000o.contains(Build.MODEL);
        this.mVideoView = XmPluginHostApi.instance().createMp4View(activity(), frameLayout, !contains);
        this.mVideoPlayerRender = this.mVideoView.getMp4Player();
        if (contains) {
            this.mLocalAudioPlay = new LocalAudioPlay(activity());
            this.mVideoPlayerRender.setAudioListener(this.mLocalAudioPlay);
        }
        this.mVideoView.setMiniScale(true);
        this.mVideoView.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass11 */

            public void onVideoViewClick() {
                if (AlarmV2Activity.this.mVideoTool.getVisibility() == 8) {
                    AlarmV2Activity.this.mVideoTool.setVisibility(0);
                } else {
                    AlarmV2Activity.this.mVideoTool.setVisibility(8);
                }
            }
        });
        this.mVideoPlayerRender.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass12 */

            public void onCompletion(MediaPlayer mediaPlayer) {
                AlarmV2Activity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass12.AnonymousClass1 */

                    public void run() {
                        AlarmV2Activity.this.mPlayBtn.setVisibility(0);
                        AlarmV2Activity.this.mPauseBtn.setVisibility(8);
                        AlarmV2Activity.this.mHandler.removeMessages(12);
                        AlarmV2Activity.this.mProgressBar.setProgress(AlarmV2Activity.this.mProgressBar.getMax());
                        if (AlarmV2Activity.this.mVideoPlayerRender.getDuration() >= 0) {
                            AlarmV2Activity.this.mPlayingView.setText(AlarmV2Activity.this.mTimeFormat.format(Integer.valueOf(AlarmV2Activity.this.mVideoPlayerRender.getDuration())));
                        }
                        AlarmV2Activity.this.mReplayLayout.setVisibility(0);
                    }
                });
            }
        });
        this.mVideoPlayerRender.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass13 */

            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AlarmV2Activity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass13.AnonymousClass1 */

                    public void run() {
                        AlarmV2Activity.this.showError();
                    }
                });
                return true;
            }
        });
        this.mVideoPlayerRender.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass14 */

            public void onPrepared(MediaPlayer mediaPlayer) {
                AlarmV2Activity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass14.AnonymousClass1 */

                    public void run() {
                        AlarmV2Activity.this.mProgressBar.setMax(AlarmV2Activity.this.mVideoPlayerRender.getDuration() / 1000);
                        AlarmV2Activity.this.mProgressBar.setProgress(0);
                        AlarmV2Activity.this.mProgressBar.setVisibility(0);
                        AlarmV2Activity.this.mPlayingView.setText("00:00");
                        if (AlarmV2Activity.this.mReplayLayout.getVisibility() != 8) {
                            AlarmV2Activity.this.mReplayLayout.setVisibility(8);
                        }
                        AlarmV2Activity.this.mDurationView.setText(AlarmV2Activity.this.mTimeFormat.format(Integer.valueOf(AlarmV2Activity.this.mVideoPlayerRender.getDuration())));
                        if (AlarmV2Activity.this.isMute) {
                            AlarmV2Activity.this.mVideoPlayerRender.setVolume(0);
                        } else {
                            AlarmV2Activity.this.mVideoPlayerRender.setVolume(1);
                        }
                    }
                });
            }
        });
        this.mVideoView.initial();
    }

    public void hideLoading() {
        if (this.mLoadIng.getVisibility() == 0) {
            this.mLoadIng.setVisibility(8);
        }
        this.mLoadingAnimation.stop();
    }

    private void showLoading() {
        if (this.mLoadIng.getVisibility() == 8) {
            this.mLoadIng.setVisibility(0);
        }
        if (!this.mLoadingAnimation.isRunning()) {
            this.mLoadingAnimation.start();
        }
    }

    private void resetVideoStats() {
        this.mHandler.removeMessages(12);
        this.mPlayBtn.setVisibility(0);
        this.mPauseBtn.setVisibility(8);
    }

    public void showError() {
        this.mProgressBar.setProgress(0);
        this.mPlayingView.setText(this.mTimeFormat.format((Object) 0));
        this.mPauseBtn.setVisibility(8);
        this.mPlayBtn.setVisibility(0);
        this.mReplayLayout.setVisibility(0);
        this.mHandler.removeMessages(12);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    private void saveMediaFile() {
        if (!TextUtils.isEmpty(this.currentPlayingFilePath)) {
            final String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                new Thread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass15 */

                    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a0 A[SYNTHETIC, Splitter:B:38:0x00a0] */
                    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ba A[SYNTHETIC, Splitter:B:43:0x00ba] */
                    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c8 A[SYNTHETIC, Splitter:B:49:0x00c8] */
                    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e2 A[SYNTHETIC, Splitter:B:54:0x00e2] */
                    public void run() {
                        FileOutputStream fileOutputStream;
                        StringBuilder sb;
                        FileInputStream fileInputStream = null;
                        try {
                            AlarmV2Activity.this.mHandler.sendEmptyMessage(16);
                            FileInputStream fileInputStream2 = new FileInputStream(AlarmV2Activity.this.currentPlayingFilePath);
                            try {
                                fileOutputStream = new FileOutputStream(O000000o2);
                            } catch (IOException e) {
                                IOException iOException = e;
                                fileOutputStream = null;
                                fileInputStream = fileInputStream2;
                                e = iOException;
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
                                            e = e3;
                                            sb = new StringBuilder();
                                        }
                                    }
                                    AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
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
                                    AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                fileOutputStream = null;
                                fileInputStream = fileInputStream2;
                                th = th3;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
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
                                AlarmV2Activity.this.mHandler.sendEmptyMessage(14);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e6) {
                                    gsy.O000000o(6, "alarm", e6.getLocalizedMessage());
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    e = e7;
                                    sb = new StringBuilder();
                                }
                            } catch (IOException e8) {
                                FileInputStream fileInputStream3 = fileInputStream2;
                                e = e8;
                                fileInputStream = fileInputStream3;
                                gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
                            } catch (Throwable th4) {
                                FileInputStream fileInputStream4 = fileInputStream2;
                                th = th4;
                                fileInputStream = fileInputStream4;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
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
                            AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = null;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
                            throw th;
                        }
                        AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
                        sb.append(e.getLocalizedMessage());
                        gsy.O000000o(6, "alarm", sb.toString());
                        AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
                    }
                }).start();
                return;
            }
            return;
        }
        this.mHandler.sendEmptyMessage(15);
    }

    /* access modifiers changed from: protected */
    public void setOrientation(boolean z) {
        if (z) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    private void saveMediaFileWithoutHint() {
        if (!TextUtils.isEmpty(this.currentPlayingFilePath)) {
            final String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                new Thread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmV2Activity.AnonymousClass16 */

                    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086 A[SYNTHETIC, Splitter:B:35:0x0086] */
                    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0 A[SYNTHETIC, Splitter:B:40:0x00a0] */
                    /* JADX WARNING: Removed duplicated region for block: B:46:0x00af A[SYNTHETIC, Splitter:B:46:0x00af] */
                    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c9 A[SYNTHETIC, Splitter:B:51:0x00c9] */
                    /* JADX WARNING: Removed duplicated region for block: B:57:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
                    public void run() {
                        FileOutputStream fileOutputStream;
                        FileInputStream fileInputStream;
                        IOException e;
                        StringBuilder sb;
                        try {
                            fileInputStream = new FileInputStream(AlarmV2Activity.this.currentPlayingFilePath);
                            try {
                                fileOutputStream = new FileOutputStream(O000000o2);
                            } catch (IOException e2) {
                                IOException iOException = e2;
                                fileOutputStream = null;
                                e = iOException;
                                try {
                                    gsy.O000000o(6, "AlarmV2Activity", e.getLocalizedMessage());
                                    if (fileInputStream != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                            gsy.O000000o(6, "AlarmV2Activity", e3.getLocalizedMessage());
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            gsy.O000000o(6, "AlarmV2Activity", e4.getLocalizedMessage());
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                fileOutputStream = null;
                                th = th3;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                AlarmV2Activity.this.toShare(O000000o2);
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    gsy.O000000o(6, "AlarmV2Activity", e5.getLocalizedMessage());
                                }
                            } catch (IOException e6) {
                                e = e6;
                                gsy.O000000o(6, "AlarmV2Activity", e.getLocalizedMessage());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e7) {
                                        gsy.O000000o(6, "AlarmV2Activity", e7.getLocalizedMessage());
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException e8) {
                                        e = e8;
                                        sb = new StringBuilder();
                                    }
                                } else {
                                    return;
                                }
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException e9) {
                                e = e9;
                                sb = new StringBuilder();
                                sb.append(e.getLocalizedMessage());
                                gsy.O000000o(6, "AlarmV2Activity", sb.toString());
                            }
                        } catch (IOException e10) {
                            fileOutputStream = null;
                            e = e10;
                            fileInputStream = null;
                            gsy.O000000o(6, "AlarmV2Activity", e.getLocalizedMessage());
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                        } catch (Throwable th4) {
                            fileOutputStream = null;
                            th = th4;
                            fileInputStream = null;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                }).start();
                return;
            }
            return;
        }
        this.mHandler.sendEmptyMessage(15);
    }

    public void toShare(String str) {
        if (!TextUtils.isEmpty(str)) {
            CameraJumpUtils.openShareActivity(activity(), "", "", str, 1);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 9999) {
            return;
        }
        if (!TextUtils.isEmpty(XmPluginHostApi.instance().getDevicePincode(this.mDid))) {
            loadData(true, true);
            this.mCameraDevice.O00000Oo((Callback<Void>) null);
            return;
        }
        civ.O00000o("alarm", "getDevicePincode empty ");
    }
}
