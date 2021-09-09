package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.chp;
import _m_j.chr;
import _m_j.cin;
import _m_j.clb;
import _m_j.cld;
import _m_j.clf;
import _m_j.clg;
import _m_j.cnx;
import _m_j.fsa;
import _m_j.fsp;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.izb;
import _m_j.me;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.xiaomi.smarthome.camera.v4.view.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.camera.view.widget.LoadMoreView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmV2Activity extends CameraBaseActivity implements View.OnClickListener {
    final int MSG_DOWN_FILE = 11;
    public String currentPlayingFilePath = null;
    private boolean isCreate = true;
    public boolean isMute = true;
    private ImageView ivSave;
    public AlarmAdapterV2 mAdapter;
    public clb mAlarmItem;
    public SimpleDateFormat mAlarmTimeFormat;
    public TextView mAlarmTimeView;
    public boolean mAutoPause = false;
    private String mCurrentPath = "";
    public TextView mDurationView;
    private RelativeLayout mEmptyLayout;
    public boolean mFullScreen;
    public boolean mHasMore = true;
    private LinearLayout mHistoryLayout;
    public boolean mIsMoreLoading = false;
    private View mLoadIng;
    public LoadMoreView mLoadMoreView;
    private AnimationDrawable mLoadingAnimation;
    private LocalAudioPlay mLocalAudioPlay = null;
    public CustomPullDownRefreshListView mMediaListView;
    clg.O00000Oo mOnDownloadListener = new clg.O00000Oo() {
        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass14 */

        public void onDownloading(clg.O000000o o000000o, String str, final int i) {
            if (o000000o.f14062O000000o.O00000Oo == AlarmV2Activity.this.mAlarmItem.O00000Oo) {
                AlarmV2Activity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass14.AnonymousClass1 */

                    public void run() {
                        AlarmV2Activity.this.showProgress(i);
                        AlarmV2Activity.this.currentPlayingFilePath = null;
                    }
                });
            }
        }

        public void onDownloadSuccess(clg.O000000o o000000o, final String str) {
            if (o000000o.f14062O000000o.O00000Oo == AlarmV2Activity.this.mAlarmItem.O00000Oo) {
                AlarmV2Activity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass14.AnonymousClass2 */

                    public void run() {
                        AlarmV2Activity.this.hideProgress();
                        AlarmV2Activity.this.mPauseBtn.setEnabled(true);
                        AlarmV2Activity.this.currentPlayingFilePath = str;
                        AlarmV2Activity.this.startPlay(str);
                    }
                });
            }
        }

        public void onDownloadFailed(clg.O000000o o000000o, String str, int i, String str2) {
            if (o000000o.f14062O000000o.O00000Oo == AlarmV2Activity.this.mAlarmItem.O00000Oo) {
                AlarmV2Activity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass14.AnonymousClass3 */

                    public void run() {
                        izb.O000000o(AlarmV2Activity.this, (int) R.string.sdcard_video_download_failed, 0).show();
                        AlarmV2Activity.this.mPauseBtn.setVisibility(8);
                        AlarmV2Activity.this.mPlayBtn.setVisibility(0);
                        AlarmV2Activity.this.currentPlayingFilePath = null;
                        AlarmV2Activity.this.hideProgress();
                    }
                });
            }
        }
    };
    public ImageView mPauseBtn;
    public ImageView mPlayBg;
    public ImageView mPlayBtn;
    public TextView mPlayingView;
    public SeekBar mProgressBar;
    public XQProgressDialog mPullingDlg;
    public FrameLayout mReplayLayout;
    private ImageView mScreenFull;
    private SeekBar.OnSeekBarChangeListener mSeekBarChange = new SeekBar.OnSeekBarChangeListener() {
        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass15 */

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
    private SharePrefHelper mSharePrefHelper;
    private View mShareView;
    public SimpleDateFormat mTimeFormat;
    public XmMp4Player mVideoPlayerRender;
    private TextView mVideoProgress;
    public View mVideoTool;
    public XmVideoViewGl mVideoView;
    private FrameLayout mVideoViewFrame;
    private FrameLayout title_bar;
    public TextView tvCloudStorageHint;
    public ImageView videoMute;

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 11:
                if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    izb.O000000o(this, (int) R.string.no_write_permission, 1).show();
                    return;
                }
                if (this.mReplayLayout.getVisibility() == 0) {
                    this.mReplayLayout.setVisibility(8);
                }
                if (this.mCameraDevice == null) {
                    return;
                }
                if (!this.mAlarmItem.O0000Ooo) {
                    this.mCameraDevice.O0000o().O000000o(this.mOnDownloadListener);
                    this.mCameraDevice.O0000o().O000000o(this.mAlarmItem);
                    return;
                } else if (this.mCameraDevice != null) {
                    this.mHandler.sendEmptyMessage(16);
                    this.mCameraDevice.O0000o0O().O000000o(this, this.mAlarmItem, new cld.O000000o<String>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass1 */

                        public void onSuccess(String str, Object obj) {
                            if (!AlarmV2Activity.this.isFinishing()) {
                                AlarmV2Activity.this.mHandler.sendEmptyMessage(17);
                                if (!TextUtils.isEmpty(str)) {
                                    AlarmV2Activity.this.mPauseBtn.setEnabled(true);
                                    AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                                    alarmV2Activity.currentPlayingFilePath = str;
                                    alarmV2Activity.startPlay(str);
                                }
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!AlarmV2Activity.this.isFinishing()) {
                                izb.O000000o(AlarmV2Activity.this, (int) R.string.sdcard_video_download_failed, 0).show();
                                AlarmV2Activity.this.mPauseBtn.setVisibility(8);
                                AlarmV2Activity.this.mPlayBtn.setVisibility(0);
                                AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                                alarmV2Activity.currentPlayingFilePath = null;
                                alarmV2Activity.mHandler.sendEmptyMessage(17);
                            }
                        }
                    });
                    return;
                } else {
                    return;
                }
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
                gqg.O000000o((int) R.string.save_success);
                return;
            case GmsLogger.MAX_PII_TAG_LENGTH:
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

    public void doCreate(Bundle bundle) {
        chr.O000000o(chr.O000ooo0);
        super.doCreate(bundle);
        this.mPullingDlg = new XQProgressDialog(this);
        this.mPullingDlg.setCancelable(true);
        this.mPullingDlg.setMessage(getResources().getString(R.string.mj_loading));
        setContentView((int) R.layout.activity_camera_alarm);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        String language = XmPluginHostApi.instance().getSettingLocale() != null ? XmPluginHostApi.instance().getSettingLocale().getLanguage() : null;
        if (XmPluginHostApi.instance().getApiLevel() < 51 || (!"de".equalsIgnoreCase(language) && !"es".equalsIgnoreCase(language) && !"fr".equalsIgnoreCase(language) && !"it".equalsIgnoreCase(language) && !"pl".equalsIgnoreCase(language) && !"ru".equalsIgnoreCase(language))) {
            this.mAlarmTimeFormat = new SimpleDateFormat("yyy-MM-dd");
        } else {
            this.mAlarmTimeFormat = new SimpleDateFormat("dd-MM-yyyy");
        }
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        this.title_bar = (FrameLayout) findViewById(R.id.title_bar);
        this.mAlarmItem = new clb();
        this.mSharePrefHelper = new SharePrefHelper(this, "housekeping", this.mDid);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (TextUtils.isEmpty(this.mSharePrefHelper.getStrValue("click_alarm_list"))) {
            this.mSharePrefHelper.putValue("click_alarm_list", format);
        } else if (this.mSharePrefHelper.getStrValue("click_alarm_list").indexOf(format) < 0) {
            this.mSharePrefHelper.putValue("click_alarm_list", format);
        }
        if (this.mCameraDevice.O0000o0O().O0000Oo0 < 0) {
            if (this.mCameraDevice.O00000oO().O0000o0O > 0) {
                this.mCameraDevice.O0000o0O().O0000Oo0 = this.mCameraDevice.O00000oO().O0000o0O;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("did", this.mCameraDevice.getDid());
                    jSONObject.put("region", Locale.getDefault().getCountry());
                    this.mCameraDevice.O0000o0O().O000000o(this.mCameraDevice.getModel(), jSONObject, new cld.O000000o() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass2 */

                        public void onFailure(int i, String str) {
                        }

                        public void onSuccess(Object obj, Object obj2) {
                            AlarmV2Activity.this.mCameraDevice.O00000oO().O000000o(AlarmV2Activity.this.mCameraDevice.O0000o0O().O0000OOo.O0000OOo);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        initView();
        initVideoView();
        showEmptyView(true);
        this.mPullingDlg.show();
    }

    private void initView() {
        this.mPlayBg = (ImageView) findViewById(R.id.img_alert_new_video_jpg);
        this.mLoadIng = findViewById(R.id.loading_lyt);
        this.mVideoProgress = (TextView) findViewById(R.id.text_new_video_progress);
        this.mHistoryLayout = (LinearLayout) findViewById(R.id.history_alarm_layout);
        this.mAlarmTimeView = (TextView) findViewById(R.id.alarm_list_date);
        getResources().getDisplayMetrics();
        this.mPauseBtn = (ImageView) findViewById(R.id.btn_alert_main_pause);
        this.mPlayBtn = (ImageView) findViewById(R.id.btn_alert_main_play);
        this.mPauseBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass3 */

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
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass4 */

            public void onClick(View view) {
                AlarmV2Activity.this.mPauseBtn.setEnabled(false);
                AlarmV2Activity.this.mHandler.sendEmptyMessage(11);
                AlarmV2Activity.this.mPlayBtn.setVisibility(8);
                AlarmV2Activity.this.mPauseBtn.setVisibility(0);
            }
        });
        this.mScreenFull = (ImageView) findViewById(R.id.btn_alert_main_full_screen);
        this.mScreenFull.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass5 */

            public void onClick(View view) {
                AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                alarmV2Activity.setFullScreen(!alarmV2Activity.mFullScreen);
            }
        });
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
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.main_play_file_v4);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mMediaListView = (CustomPullDownRefreshListView) findViewById(R.id.list_event_listview);
        this.mAdapter = new AlarmAdapterV2(this, this.mDid);
        this.mLoadMoreView = (LoadMoreView) getLayoutInflater().inflate((int) R.layout.load_more_data, (ViewGroup) null);
        this.mMediaListView.addFooterView(this.mLoadMoreView);
        this.mMediaListView.setAdapter((ListAdapter) this.mAdapter);
        this.mMediaListView.setRefreshListener(new CustomPullDownRefreshListView.OnRefreshListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass6 */

            public void startRefresh() {
                AlarmV2Activity.this.loadData(true, false);
            }
        });
        this.mMediaListView.setOnLastItemVisibleListener(new CustomPullDownRefreshListView.OnLastItemVisibleListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass7 */

            public void onLastItemVisible() {
                if (AlarmV2Activity.this.mHasMore && !AlarmV2Activity.this.mIsMoreLoading) {
                    AlarmV2Activity.this.loadMoreData();
                }
            }
        });
        this.videoMute = (ImageView) findViewById(R.id.video_mute);
        this.videoMute.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass8 */

            public void onClick(View view) {
                chr.O000000o(chr.O000ooo);
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
        this.ivSave = (ImageView) findViewById(R.id.ivSave);
        this.ivSave.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass9 */

            public void onClick(View view) {
                AlarmV2Activity.this.saveMediaFile();
            }
        });
        this.mReplayLayout = (FrameLayout) findViewById(R.id.replay_layout);
        findViewById(R.id.replay_btn).setOnClickListener(this);
        this.mMediaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass10 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = i - 1;
                if (i2 >= 0 && i2 < AlarmV2Activity.this.mAdapter.getCount()) {
                    AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                    alarmV2Activity.mAlarmItem = alarmV2Activity.mAdapter.getItem(i2);
                    AlarmV2Activity.this.mAlarmTimeView.setText(AlarmV2Activity.this.mAlarmTimeFormat.format(Long.valueOf(AlarmV2Activity.this.mAlarmItem.O00000Oo)));
                    if (AlarmV2Activity.this.mVideoView != null && AlarmV2Activity.this.mVideoPlayerRender.isPlaying()) {
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
        this.tvCloudStorageHint = (TextView) findViewById(R.id.tvCloudStorageHint);
    }

    public void loadData(boolean z, final boolean z2) {
        this.mCameraDevice.O0000o0O().O000000o((Callback<Void>) new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass11 */

            public void onSuccess(Void voidR) {
                if (!AlarmV2Activity.this.isFinishing()) {
                    AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                    alarmV2Activity.mHasMore = alarmV2Activity.mCameraDevice.O0000o0O().O00000o0;
                    if (AlarmV2Activity.this.mHasMore) {
                        AlarmV2Activity.this.mLoadMoreView.setLoadingData();
                    } else {
                        AlarmV2Activity.this.mLoadMoreView.setLoadingNone();
                    }
                    if (AlarmV2Activity.this.mPullingDlg != null && AlarmV2Activity.this.mPullingDlg.isShowing()) {
                        AlarmV2Activity.this.mPullingDlg.dismiss();
                    }
                    AlarmV2Activity.this.mMediaListView.postRefresh();
                    final List<clb> list = AlarmV2Activity.this.mCameraDevice.O0000o0O().O00000oO;
                    if (!list.isEmpty()) {
                        AlarmV2Activity.this.mAdapter.setData(list, AlarmV2Activity.this.mCameraDevice.getDid());
                        AlarmV2Activity.this.showEmptyView(false);
                        AlarmV2Activity.this.mAlarmItem = list.get(0);
                        AlarmV2Activity.this.mAlarmTimeView.setText(AlarmV2Activity.this.mAlarmTimeFormat.format(Long.valueOf(AlarmV2Activity.this.mAlarmItem.O00000Oo)));
                        if (cnx.O000000o().O00000Oo()) {
                            if (AlarmV2Activity.this.mAlarmItem.O0000Ooo) {
                                cnx.O000000o().O000000o(AlarmV2Activity.this.mAlarmItem.O0000oO, AlarmV2Activity.this.mPlayBg);
                            } else {
                                cnx.O000000o().O000000o(AlarmV2Activity.this.mAlarmItem.O000000o(), AlarmV2Activity.this.mPlayBg);
                            }
                        }
                        if (z2) {
                            AlarmV2Activity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass11.AnonymousClass1 */

                                public void run() {
                                    AlarmV2Activity.this.mAlarmItem = (clb) list.get(0);
                                    if (AlarmV2Activity.this.mVideoPlayerRender.isPlaying()) {
                                        AlarmV2Activity.this.mVideoPlayerRender.pause();
                                        AlarmV2Activity.this.mVideoPlayerRender.seekTo(0);
                                    }
                                    AlarmV2Activity.this.mHandler.removeMessages(12);
                                    AlarmV2Activity.this.mHandler.sendEmptyMessage(11);
                                    AlarmV2Activity.this.mPauseBtn.setVisibility(0);
                                    AlarmV2Activity.this.mPlayBtn.setVisibility(8);
                                }
                            }, 500);
                            return;
                        }
                        return;
                    }
                    AlarmV2Activity.this.showEmptyView(true);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmV2Activity.this.isFinishing()) {
                    if (AlarmV2Activity.this.mPullingDlg != null && AlarmV2Activity.this.mPullingDlg.isShowing()) {
                        AlarmV2Activity.this.mPullingDlg.dismiss();
                    }
                    AlarmV2Activity.this.mMediaListView.postRefresh();
                    AlarmV2Activity.this.showEmptyView(true);
                }
            }
        }, z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cld.O000000o(com.xiaomi.smarthome.device.api.Callback<java.lang.Void>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity$12, int]
     candidates:
      _m_j.cld.O000000o(java.util.List<_m_j.clb>, java.util.List<_m_j.clb>):java.util.List<_m_j.clb>
      _m_j.cld.O000000o(long, com.xiaomi.smarthome.device.api.Callback<_m_j.clb>):void
      _m_j.cld.O000000o(_m_j.ckz, com.xiaomi.smarthome.device.api.Callback<org.json.JSONObject>):void
      _m_j.cld.O000000o(com.xiaomi.smarthome.device.api.Callback<java.lang.Void>, int):void
      _m_j.cld.O000000o(com.xiaomi.smarthome.device.api.Callback<java.lang.Void>, int[][]):void
      _m_j.cld.O000000o(java.lang.String, com.xiaomi.smarthome.device.api.Callback<org.json.JSONObject>):void
      _m_j.cld.O000000o(java.util.List<_m_j.clb>, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cld.O000000o(com.xiaomi.smarthome.device.api.Callback<java.lang.Void>, boolean):void */
    public void loadMoreData() {
        this.mIsMoreLoading = true;
        this.mCameraDevice.O0000o0O().O000000o((Callback<Void>) new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass12 */

            public void onSuccess(Void voidR) {
                if (!AlarmV2Activity.this.isFinishing()) {
                    AlarmV2Activity alarmV2Activity = AlarmV2Activity.this;
                    alarmV2Activity.mIsMoreLoading = false;
                    alarmV2Activity.mHasMore = alarmV2Activity.mCameraDevice.O0000o0O().O00000o0;
                    if (AlarmV2Activity.this.mHasMore) {
                        AlarmV2Activity.this.mLoadMoreView.setLoadingData();
                    } else {
                        AlarmV2Activity.this.mLoadMoreView.setLoadingNone();
                    }
                    AlarmV2Activity.this.mAdapter.setData(AlarmV2Activity.this.mCameraDevice.O0000o0O().O00000oO, AlarmV2Activity.this.mCameraDevice.getDid());
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

    public void showEmptyView(boolean z) {
        if (z) {
            this.mVideoViewFrame.setVisibility(8);
            this.mMediaListView.setVisibility(8);
            this.mHistoryLayout.setVisibility(8);
            this.mEmptyLayout.setVisibility(0);
            return;
        }
        this.mVideoViewFrame.setVisibility(0);
        this.mMediaListView.setVisibility(0);
        this.mHistoryLayout.setVisibility(0);
        this.mEmptyLayout.setVisibility(8);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.title_bar_share) {
            if (TextUtils.isEmpty(this.mCurrentPath)) {
                izb.O000000o(this, (int) R.string.alarm_share_none, 0).show();
            } else if (!new File(this.mCurrentPath).exists()) {
                izb.O000000o(this, (int) R.string.alarm_share_none, 0).show();
            } else {
                shareVideo();
            }
        } else if (id == R.id.title_bar_more) {
            chr.O000000o(chr.O00O00Oo);
            if (clf.O00000oO()) {
                startActivity(new Intent(this, AlarmSettingV2Activity.class));
            } else {
                startActivity(new Intent(this, AlarmSettingActivity.class));
            }
        } else if (id == R.id.history_alarm) {
            resetVideoStats();
            chr.O000000o(chr.oooOoO);
            if (clf.O00000oO()) {
                startActivityForResult(new Intent(this, AlarmDayV2Activity.class), 1001);
            } else {
                startActivity(new Intent(this, AlarmDayActivity.class));
            }
        } else if (id == R.id.replay_btn) {
            this.mPlayBtn.performClick();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    private void shareVideo() {
        chr.O000000o(chr.O00oOOoo);
        if (!TextUtils.isEmpty(this.currentPlayingFilePath)) {
            final String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                new Thread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass13 */

                    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[SYNTHETIC, Splitter:B:38:0x0085] */
                    /* JADX WARNING: Removed duplicated region for block: B:43:0x009f A[SYNTHETIC, Splitter:B:43:0x009f] */
                    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ae A[SYNTHETIC, Splitter:B:49:0x00ae] */
                    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8 A[SYNTHETIC, Splitter:B:54:0x00c8] */
                    /* JADX WARNING: Removed duplicated region for block: B:60:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
                    public void run() {
                        FileOutputStream fileOutputStream;
                        StringBuilder sb;
                        FileInputStream fileInputStream = null;
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(AlarmV2Activity.this.currentPlayingFilePath);
                            try {
                                fileOutputStream = new FileOutputStream(O000000o2);
                            } catch (IOException e) {
                                e = e;
                                fileOutputStream = null;
                                fileInputStream = fileInputStream2;
                                try {
                                    gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                                    if (fileInputStream != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileInputStream != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
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
                                CameraJumpUtils.openShareActivity(AlarmV2Activity.this, "", "", O000000o2, 1);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                    gsy.O000000o(6, "alarm", e2.getLocalizedMessage());
                                }
                            } catch (IOException e3) {
                                e = e3;
                                fileInputStream = fileInputStream2;
                                gsy.O000000o(6, "alarm", e.getLocalizedMessage());
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
                                        return;
                                    } catch (IOException e5) {
                                        e = e5;
                                        sb = new StringBuilder();
                                    }
                                } else {
                                    return;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                        gsy.O000000o(6, "alarm", e6.getLocalizedMessage());
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e7) {
                                        gsy.O000000o(6, "alarm", e7.getLocalizedMessage());
                                    }
                                }
                                throw th;
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException e8) {
                                e = e8;
                                sb = new StringBuilder();
                                sb.append(e.getLocalizedMessage());
                                gsy.O000000o(6, "alarm", sb.toString());
                            }
                        } catch (IOException e9) {
                            e = e9;
                            fileOutputStream = null;
                            gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = null;
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

    public void onResume() {
        super.onResume();
        chr.O00000o0();
        boolean z = this.isCreate;
        if (z) {
            loadData(z, true);
        }
        this.isCreate = false;
        if (this.mAutoPause && this.mReplayLayout.getVisibility() == 8) {
            this.mPauseBtn.setVisibility(0);
            this.mPlayBtn.setVisibility(8);
            startPlay(this.mCurrentPath);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        super.onPause();
        chr.O00000o();
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
        this.mHandler.removeMessages(12);
        AlarmAdapterV2 alarmAdapterV2 = this.mAdapter;
        if (alarmAdapterV2 != null) {
            alarmAdapterV2.destroyDisplayImageOptions();
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

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        if (r0.indexOf(r2.toString()) < 0) goto L_0x0031;
     */
    public void startPlay(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.mSharePrefHelper.getStrValue("click_alarm_list"))) {
                String strValue = this.mSharePrefHelper.getStrValue("click_alarm_list");
                StringBuilder sb = new StringBuilder();
                sb.append(this.mAlarmItem.O00000Oo);
            }
            SharePrefHelper sharePrefHelper = this.mSharePrefHelper;
            sharePrefHelper.putValue("click_alarm_list", this.mSharePrefHelper.getStrValue("click_alarm_list") + "|" + this.mAlarmItem.O00000Oo);
            this.mAdapter.addDownSuccess(this.mAlarmItem);
            this.mPlayBg.setVisibility(8);
            if (!this.mCurrentPath.equals(str)) {
                this.mVideoPlayerRender.changeSource(str);
                if (this.isMute) {
                    this.mVideoPlayerRender.setVolume(0);
                } else {
                    this.mVideoPlayerRender.setVolume(1);
                }
                this.mCurrentPath = str;
            } else {
                this.mVideoPlayerRender.openVideoPlayer(str);
            }
            this.mShareView.setVisibility(0);
            this.mHandler.sendEmptyMessage(12);
        }
    }

    public void setFullScreen(boolean z) {
        chr.O000000o(chr.O000oooo);
        this.mFullScreen = z;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
        }
        if (this.mFullScreen) {
            setRequestedOrientation(6);
        } else {
            setRequestedOrientation(1);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 1) {
                this.mScreenFull.setImageResource(R.drawable.home_icon_fullscreen);
                findViewById(R.id.title_bar).setVisibility(0);
                this.mMediaListView.setVisibility(0);
                this.mHistoryLayout.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.mVideoViewFrame.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = dip2px(this, 203.0f);
                this.mVideoViewFrame.setLayoutParams(layoutParams);
                this.mVideoView.setVideoFrameSize(-1, -1, false);
                return;
            }
            findViewById(R.id.title_bar).setVisibility(8);
            this.mScreenFull.setImageResource(R.drawable.home_icon_mixscreen);
            this.mEmptyLayout.setVisibility(8);
            this.mMediaListView.setVisibility(8);
            this.mHistoryLayout.setVisibility(8);
            ViewGroup.LayoutParams layoutParams2 = this.mVideoViewFrame.getLayoutParams();
            layoutParams2.height = -1;
            layoutParams2.width = -1;
            this.mVideoViewFrame.setLayoutParams(layoutParams2);
            this.mVideoView.setVideoFrameSize(-1, -1, true);
        }
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass16 */

                public void run() {
                    AlarmV2Activity.this.setFullScreen(false);
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    private void initVideoView() {
        this.mVideoTool = findViewById(R.id.layout_video_tools);
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        this.mVideoViewFrame.getLayoutParams().height = (chp.f13827O000000o * 9) / 16;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(activity());
        this.mVideoView = XmPluginHostApi.instance().createMp4View(activity(), frameLayout, !cin.f13904O000000o.contains(Build.MODEL));
        this.mVideoView.setMiniScale(true);
        this.mVideoViewFrame.addView(frameLayout, 0, layoutParams);
        this.mVideoView.initial();
        this.mVideoView.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass17 */

            public void onVideoViewClick() {
                if (AlarmV2Activity.this.mVideoTool.getVisibility() == 8) {
                    AlarmV2Activity.this.mVideoTool.setVisibility(0);
                } else {
                    AlarmV2Activity.this.mVideoTool.setVisibility(8);
                }
            }
        });
        this.mVideoPlayerRender = this.mVideoView.getMp4Player();
        this.mVideoPlayerRender.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass18 */

            public void onCompletion(MediaPlayer mediaPlayer) {
                AlarmV2Activity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass18.AnonymousClass1 */

                    public void run() {
                        AlarmV2Activity.this.setCloudStorageHint();
                        AlarmV2Activity.this.mPauseBtn.setEnabled(true);
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
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass19 */

            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AlarmV2Activity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass19.AnonymousClass1 */

                    public void run() {
                        AlarmV2Activity.this.setCloudStorageHint();
                        AlarmV2Activity.this.showError();
                    }
                });
                return true;
            }
        });
        this.mVideoPlayerRender.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass20 */

            public void onPrepared(MediaPlayer mediaPlayer) {
                AlarmV2Activity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass20.AnonymousClass1 */

                    public void run() {
                        if (AlarmV2Activity.this.tvCloudStorageHint != null) {
                            AlarmV2Activity.this.tvCloudStorageHint.setVisibility(8);
                        }
                        AlarmV2Activity.this.mProgressBar.setMax(AlarmV2Activity.this.mVideoPlayerRender.getDuration() / 1000);
                        AlarmV2Activity.this.mProgressBar.setProgress(0);
                        AlarmV2Activity.this.mProgressBar.setVisibility(0);
                        AlarmV2Activity.this.mPlayingView.setText("00:00");
                        AlarmV2Activity.this.mDurationView.setText(AlarmV2Activity.this.mTimeFormat.format(Integer.valueOf(AlarmV2Activity.this.mVideoPlayerRender.getDuration())));
                        if (AlarmV2Activity.this.mReplayLayout.getVisibility() == 0) {
                            AlarmV2Activity.this.mReplayLayout.setVisibility(8);
                        }
                        AlarmV2Activity.this.mPauseBtn.setVisibility(0);
                        AlarmV2Activity.this.mPlayBtn.setVisibility(8);
                        if (AlarmV2Activity.this.isMute) {
                            AlarmV2Activity.this.mVideoPlayerRender.setVolume(0);
                        } else {
                            AlarmV2Activity.this.mVideoPlayerRender.setVolume(1);
                        }
                    }
                });
            }
        });
    }

    public void hideProgress() {
        if (this.mLoadIng.getVisibility() == 0) {
            this.mLoadIng.setVisibility(8);
        }
        this.mLoadingAnimation.stop();
        this.mVideoProgress.setText("");
    }

    public void showProgress(int i) {
        if (this.mLoadIng.getVisibility() == 8) {
            this.mLoadIng.setVisibility(0);
        }
        if (!this.mLoadingAnimation.isRunning()) {
            this.mLoadingAnimation.start();
        }
        this.mVideoProgress.setText(getString(R.string.loading_hint, new Object[]{Integer.valueOf(i)}));
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
    public void saveMediaFile() {
        chr.O000000o(chr.O000oooO);
        if (!TextUtils.isEmpty(this.currentPlayingFilePath)) {
            final String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                new Thread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass21 */

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

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            loadData(true, false);
        }
        if (i == 1 && i2 == -1) {
            chr.O000000o(chr.O00O000o);
        }
    }

    public void setCloudStorageHint() {
        if (!cin.O00000Oo()) {
            return;
        }
        if (this.mCameraDevice == null || !this.mCameraDevice.isShared()) {
            this.tvCloudStorageHint.setVisibility(0);
            if (this.mCameraDevice.O00000oO().O00000Oo()) {
                this.tvCloudStorageHint.setText((int) R.string.alarm_cloud_buy_tip);
            } else {
                this.tvCloudStorageHint.setText((int) R.string.alarm_cloud_no_buy_tip);
            }
            this.tvCloudStorageHint.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmV2Activity.AnonymousClass22 */

                public void onClick(View view) {
                    try {
                        if (AlarmV2Activity.this.mCameraDevice.O00000oO().O00000Oo()) {
                            fsp.O000000o().O0000Oo.openCloudVideoListActivity(AlarmV2Activity.this, AlarmV2Activity.this.mCameraDevice.getDid(), AlarmV2Activity.this.mCameraDevice.getName());
                        } else {
                            CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(AlarmV2Activity.this, AlarmV2Activity.this.mCameraDevice.getDid());
                        }
                    } catch (Exception unused) {
                    }
                    chr.O000000o("u5v.u1o.4k5.ax0");
                }
            });
        }
    }
}
