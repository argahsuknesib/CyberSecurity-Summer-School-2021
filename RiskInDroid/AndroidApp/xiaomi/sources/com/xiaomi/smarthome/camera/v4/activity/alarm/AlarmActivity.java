package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.chp;
import _m_j.chr;
import _m_j.cki;
import _m_j.clb;
import _m_j.cld;
import _m_j.clg;
import _m_j.cnx;
import _m_j.fsp;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.izb;
import _m_j.me;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
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
import com.Utils.MediaStoreUtil;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmMp4Player;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalAudioPlay;
import com.xiaomi.smarthome.camera.v4.view.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.camera.view.widget.LoadMoreView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class AlarmActivity extends CameraBaseActivity implements View.OnClickListener {
    final int MSG_DOWN_FILE = 11;
    public String currentPlayingFilePath = null;
    public boolean isFromRN;
    public boolean isMute = true;
    private ImageView ivSave;
    public AlarmAdapter mAdapter;
    public clb mAlarmItem;
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
        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass11 */

        public void onDownloading(clg.O000000o o000000o, String str, final int i) {
            if (o000000o.f14062O000000o.O00000Oo == AlarmActivity.this.mAlarmItem.O00000Oo) {
                AlarmActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass11.AnonymousClass1 */

                    public void run() {
                        AlarmActivity.this.showProgress(i);
                        AlarmActivity.this.currentPlayingFilePath = null;
                    }
                });
            }
        }

        public void onDownloadSuccess(clg.O000000o o000000o, final String str) {
            if (o000000o.f14062O000000o.O00000Oo == AlarmActivity.this.mAlarmItem.O00000Oo) {
                AlarmActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass11.AnonymousClass2 */

                    public void run() {
                        AlarmActivity.this.hideProgress();
                        AlarmActivity.this.mPauseBtn.setEnabled(true);
                        AlarmActivity.this.currentPlayingFilePath = str;
                        AlarmActivity.this.startPlay(str);
                    }
                });
            }
        }

        public void onDownloadFailed(clg.O000000o o000000o, String str, int i, String str2) {
            if (o000000o.f14062O000000o.O00000Oo == AlarmActivity.this.mAlarmItem.O00000Oo) {
                AlarmActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass11.AnonymousClass3 */

                    public void run() {
                        izb.O000000o(AlarmActivity.this, (int) R.string.sdcard_video_download_failed, 0).show();
                        AlarmActivity.this.mPauseBtn.setVisibility(8);
                        AlarmActivity.this.mPlayBtn.setVisibility(0);
                        AlarmActivity.this.currentPlayingFilePath = null;
                        AlarmActivity.this.hideProgress();
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
        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass12 */

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (AlarmActivity.this.mSeekBarTouched) {
                AlarmActivity.this.mHandler.removeMessages(13);
                AlarmActivity.this.mPlayingView.setText(AlarmActivity.this.mTimeFormat.format(Integer.valueOf(i * 1000)));
                Message obtainMessage = AlarmActivity.this.mHandler.obtainMessage();
                obtainMessage.what = 13;
                obtainMessage.arg1 = i;
                obtainMessage.sendToTarget();
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            AlarmActivity.this.mSeekBarTouched = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            AlarmActivity.this.mSeekBarTouched = false;
        }
    };
    boolean mSeekBarTouched = false;
    private SharePrefHelper mSharePrefHelper;
    private View mShareView;
    public SimpleDateFormat mTimeFormat;
    public XmMp4Player mVideoPlayerRender;
    private TextView mVideoProgress;
    private View mVideoTool;
    public XmVideoViewGl mVideoView;
    private FrameLayout mVideoViewFrame;
    private FrameLayout title_bar;
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
                if (this.mCameraDevice != null) {
                    this.mCameraDevice.O0000o().O000000o(this.mOnDownloadListener);
                    this.mCameraDevice.O0000o().O000000o(this.mAlarmItem);
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPullingDlg = new XQProgressDialog(this);
        this.mPullingDlg.setCancelable(true);
        this.mPullingDlg.setMessage(getResources().getString(R.string.mj_loading));
        setContentView((int) R.layout.activity_camera_alarm);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        this.title_bar = (FrameLayout) findViewById(R.id.title_bar);
        this.isFromRN = getIntent().getBooleanExtra("is_from_rn", false);
        this.mAlarmItem = new clb();
        this.mSharePrefHelper = new SharePrefHelper(this, "housekeping", this.mDid);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (TextUtils.isEmpty(this.mSharePrefHelper.getStrValue("click_alarm_list"))) {
            this.mSharePrefHelper.putValue("click_alarm_list", format);
        } else if (this.mSharePrefHelper.getStrValue("click_alarm_list").indexOf(format) < 0) {
            this.mSharePrefHelper.putValue("click_alarm_list", format);
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
        getResources().getDisplayMetrics();
        this.mPauseBtn = (ImageView) findViewById(R.id.btn_alert_main_pause);
        this.mPlayBtn = (ImageView) findViewById(R.id.btn_alert_main_play);
        this.mPauseBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass1 */

            public void onClick(View view) {
                if (AlarmActivity.this.mVideoPlayerRender.isPlaying()) {
                    AlarmActivity.this.mVideoPlayerRender.pause();
                }
                AlarmActivity alarmActivity = AlarmActivity.this;
                alarmActivity.mAutoPause = false;
                alarmActivity.mPauseBtn.setVisibility(8);
                AlarmActivity.this.mPlayBtn.setVisibility(0);
            }
        });
        this.mPlayBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass2 */

            public void onClick(View view) {
                AlarmActivity.this.mPauseBtn.setEnabled(false);
                AlarmActivity.this.mHandler.sendEmptyMessage(11);
                AlarmActivity.this.mPlayBtn.setVisibility(8);
                AlarmActivity.this.mPauseBtn.setVisibility(0);
            }
        });
        this.mScreenFull = (ImageView) findViewById(R.id.btn_alert_main_full_screen);
        this.mScreenFull.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass3 */

            public void onClick(View view) {
                AlarmActivity alarmActivity = AlarmActivity.this;
                alarmActivity.setFullScreen(!alarmActivity.mFullScreen);
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
        if (this.isFromRN) {
            imageView.setVisibility(8);
        }
        this.mEmptyLayout = (RelativeLayout) findViewById(R.id.layout_empty);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.main_play_file_v4);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mMediaListView = (CustomPullDownRefreshListView) findViewById(R.id.list_event_listview);
        this.mAdapter = new AlarmAdapter(this, this.mDid);
        this.mLoadMoreView = (LoadMoreView) getLayoutInflater().inflate((int) R.layout.load_more_data, (ViewGroup) null);
        this.mMediaListView.addFooterView(this.mLoadMoreView);
        this.mMediaListView.setAdapter((ListAdapter) this.mAdapter);
        this.mMediaListView.setRefreshListener(new CustomPullDownRefreshListView.OnRefreshListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass4 */

            public void startRefresh() {
                AlarmActivity.this.loadData(true);
            }
        });
        this.mMediaListView.setOnLastItemVisibleListener(new CustomPullDownRefreshListView.OnLastItemVisibleListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass5 */

            public void onLastItemVisible() {
                if (AlarmActivity.this.mHasMore && !AlarmActivity.this.mIsMoreLoading) {
                    AlarmActivity.this.loadMoreData();
                }
            }
        });
        this.videoMute = (ImageView) findViewById(R.id.video_mute);
        this.videoMute.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass6 */

            public void onClick(View view) {
                if (AlarmActivity.this.isMute) {
                    AlarmActivity.this.videoMute.setImageResource(R.drawable.camera_alarm_icon_unmute);
                    AlarmActivity alarmActivity = AlarmActivity.this;
                    alarmActivity.isMute = false;
                    alarmActivity.mVideoPlayerRender.setVolume(1);
                    return;
                }
                AlarmActivity.this.videoMute.setImageResource(R.drawable.camera_alarm_icon_mute);
                AlarmActivity alarmActivity2 = AlarmActivity.this;
                alarmActivity2.isMute = true;
                alarmActivity2.mVideoPlayerRender.setVolume(0);
            }
        });
        this.ivSave = (ImageView) findViewById(R.id.ivSave);
        this.ivSave.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass7 */

            public void onClick(View view) {
                AlarmActivity.this.saveMediaFile();
            }
        });
        this.mReplayLayout = (FrameLayout) findViewById(R.id.replay_layout);
        findViewById(R.id.replay_btn).setOnClickListener(this);
        this.mMediaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass8 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = i - 1;
                if (i2 >= 0 && i2 < AlarmActivity.this.mAdapter.getCount()) {
                    AlarmActivity alarmActivity = AlarmActivity.this;
                    alarmActivity.mAlarmItem = alarmActivity.mAdapter.getItem(i2);
                    if (AlarmActivity.this.mVideoView != null && AlarmActivity.this.mVideoPlayerRender.isPlaying()) {
                        AlarmActivity.this.mVideoPlayerRender.pause();
                        AlarmActivity.this.mVideoPlayerRender.seekTo(0);
                    }
                    AlarmActivity.this.mHandler.removeMessages(12);
                    AlarmActivity.this.mHandler.sendEmptyMessage(11);
                    AlarmActivity.this.mPauseBtn.setVisibility(0);
                    AlarmActivity.this.mPlayBtn.setVisibility(8);
                }
            }
        });
        Date date = new Date(System.currentTimeMillis());
        ((TextView) findViewById(R.id.alarm_list_date)).setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    public void loadData(boolean z) {
        cld O0000o0O = this.mCameraDevice.O0000o0O();
        AnonymousClass9 r1 = new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass9 */

            public void onSuccess(Void voidR) {
                if (!AlarmActivity.this.isFinishing()) {
                    AlarmActivity alarmActivity = AlarmActivity.this;
                    alarmActivity.mHasMore = alarmActivity.mCameraDevice.O0000o0O().O00000o0;
                    if (AlarmActivity.this.mHasMore) {
                        AlarmActivity.this.mLoadMoreView.setLoadingData();
                    } else {
                        AlarmActivity.this.mLoadMoreView.setLoadingNone();
                    }
                    if (AlarmActivity.this.mPullingDlg != null && AlarmActivity.this.mPullingDlg.isShowing()) {
                        AlarmActivity.this.mPullingDlg.dismiss();
                    }
                    AlarmActivity.this.mMediaListView.postRefresh();
                    List<clb> list = AlarmActivity.this.mCameraDevice.O0000o0O().O00000oO;
                    if (!list.isEmpty()) {
                        AlarmActivity.this.mAdapter.setData(list, AlarmActivity.this.mCameraDevice.getDid());
                        AlarmActivity.this.showEmptyView(false);
                        AlarmActivity.this.mAlarmItem = list.get(0);
                        if (cnx.O000000o().O00000Oo()) {
                            cnx.O000000o().O000000o(AlarmActivity.this.mAlarmItem.O000000o(), AlarmActivity.this.mPlayBg);
                            return;
                        }
                        return;
                    }
                    AlarmActivity.this.showEmptyView(true);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmActivity.this.isFinishing()) {
                    if (AlarmActivity.this.mPullingDlg != null && AlarmActivity.this.mPullingDlg.isShowing()) {
                        AlarmActivity.this.mPullingDlg.dismiss();
                    }
                    AlarmActivity.this.mMediaListView.postRefresh();
                    AlarmActivity.this.showEmptyView(true);
                }
            }
        };
        if (z || O0000o0O.O00000oO.isEmpty()) {
            O0000o0O.O00000Oo = System.currentTimeMillis() / 1000;
            O0000o0O.f13988O000000o = cld.O000000o() / 1000;
            O0000o0O.O000000o(r1);
            return;
        }
        r1.onSuccess((Object) null);
    }

    public void loadMoreData() {
        this.mIsMoreLoading = true;
        this.mCameraDevice.O0000o0O().O000000o(new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass10 */

            public void onSuccess(Void voidR) {
                if (!AlarmActivity.this.isFinishing()) {
                    AlarmActivity alarmActivity = AlarmActivity.this;
                    alarmActivity.mIsMoreLoading = false;
                    alarmActivity.mHasMore = alarmActivity.mCameraDevice.O0000o0O().O00000o0;
                    if (AlarmActivity.this.mHasMore) {
                        AlarmActivity.this.mLoadMoreView.setLoadingData();
                    } else {
                        AlarmActivity.this.mLoadMoreView.setLoadingNone();
                    }
                    AlarmActivity.this.mAdapter.setData(AlarmActivity.this.mCameraDevice.O0000o0O().O00000oO, AlarmActivity.this.mCameraDevice.getDid());
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmActivity.this.isFinishing()) {
                    AlarmActivity alarmActivity = AlarmActivity.this;
                    alarmActivity.mIsMoreLoading = false;
                    alarmActivity.mLoadMoreView.setLoadingNone();
                }
            }
        });
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
                fsp.O000000o().O0000Oo.openSharePictureActivity(this, "", "", this.mCurrentPath);
            }
        } else if (id == R.id.title_bar_more) {
            startActivity(new Intent(this, AlarmSettingActivity.class));
        } else if (id == R.id.history_alarm) {
            resetVideoStats();
            Intent intent = new Intent(this, AlarmDayActivity.class);
            intent.putExtra("is_from_rn", this.isFromRN);
            startActivity(intent);
        } else if (id == R.id.replay_btn) {
            this.mPlayBtn.performClick();
        }
    }

    public void onResume() {
        super.onResume();
        chr.O00000o0();
        loadData(false);
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
        AlarmAdapter alarmAdapter = this.mAdapter;
        if (alarmAdapter != null) {
            alarmAdapter.destroyDisplayImageOptions();
        }
        LocalAudioPlay localAudioPlay = this.mLocalAudioPlay;
        if (localAudioPlay != null) {
            localAudioPlay.release();
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003c, code lost:
        if (r1.indexOf(r4.toString()) < 0) goto L_0x003e;
     */
    public void startPlay(String str) {
        if (!TextUtils.isEmpty(str)) {
            cki.O00000o0("AlarmActivity", "startPlay:%s", str);
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
            this.mHandler.sendEmptyMessage(12);
        }
    }

    public void setFullScreen(boolean z) {
        this.mFullScreen = z;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i < i2) {
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        }
        if (this.mFullScreen) {
            getWindow().setFlags(1024, 1024);
            setRequestedOrientation(6);
            findViewById(R.id.title_bar).setVisibility(8);
            this.mScreenFull.setImageResource(R.drawable.home_icon_mixscreen);
            this.mEmptyLayout.setVisibility(8);
            this.mMediaListView.setVisibility(8);
            this.mHistoryLayout.setVisibility(8);
            this.mVideoViewFrame.getLayoutParams().width = i;
            this.mVideoViewFrame.getLayoutParams().height = i2;
            FrameLayout frameLayout = this.mVideoViewFrame;
            frameLayout.setLayoutParams(frameLayout.getLayoutParams());
            return;
        }
        getWindow().clearFlags(1024);
        setRequestedOrientation(1);
        this.mScreenFull.setImageResource(R.drawable.home_icon_fullscreen);
        findViewById(R.id.title_bar).setVisibility(0);
        this.mMediaListView.setVisibility(0);
        this.mHistoryLayout.setVisibility(0);
        this.mVideoViewFrame.getLayoutParams().width = i2;
        this.mVideoViewFrame.getLayoutParams().height = dip2px(this, 203.0f);
        FrameLayout frameLayout2 = this.mVideoViewFrame;
        frameLayout2.setLayoutParams(frameLayout2.getLayoutParams());
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass13 */

                public void run() {
                    AlarmActivity.this.setFullScreen(false);
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
        this.mVideoView = XmPluginHostApi.instance().createMp4View(activity(), this.mVideoViewFrame, true);
        this.mVideoPlayerRender = this.mVideoView.getMp4Player();
        this.mVideoTool.bringToFront();
        this.mVideoView.initial();
        this.mVideoView.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.$$Lambda$AlarmActivity$AaiDKYGMonHteh005ISdN8w5pMo */

            public final void onVideoViewClick() {
                AlarmActivity.this.lambda$initVideoView$0$AlarmActivity();
            }
        });
        this.mVideoPlayerRender.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass14 */

            public void onCompletion(MediaPlayer mediaPlayer) {
                AlarmActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass14.AnonymousClass1 */

                    public void run() {
                        AlarmActivity.this.mPauseBtn.setEnabled(true);
                        AlarmActivity.this.mPlayBtn.setVisibility(0);
                        AlarmActivity.this.mPauseBtn.setVisibility(8);
                        AlarmActivity.this.mHandler.removeMessages(12);
                        AlarmActivity.this.mProgressBar.setProgress(AlarmActivity.this.mProgressBar.getMax());
                        if (AlarmActivity.this.mVideoPlayerRender.getDuration() >= 0) {
                            AlarmActivity.this.mPlayingView.setText(AlarmActivity.this.mTimeFormat.format(Integer.valueOf(AlarmActivity.this.mVideoPlayerRender.getDuration())));
                        }
                        AlarmActivity.this.mReplayLayout.setVisibility(0);
                    }
                });
            }
        });
        this.mVideoPlayerRender.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass15 */

            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AlarmActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass15.AnonymousClass1 */

                    public void run() {
                        AlarmActivity.this.showError();
                    }
                });
                return true;
            }
        });
        this.mVideoPlayerRender.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass16 */

            public void onPrepared(MediaPlayer mediaPlayer) {
                AlarmActivity.this.runMainThread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass16.AnonymousClass1 */

                    public void run() {
                        AlarmActivity.this.mProgressBar.setMax(AlarmActivity.this.mVideoPlayerRender.getDuration() / 1000);
                        AlarmActivity.this.mProgressBar.setProgress(0);
                        AlarmActivity.this.mProgressBar.setVisibility(0);
                        AlarmActivity.this.mPlayingView.setText("00:00");
                        AlarmActivity.this.mDurationView.setText(AlarmActivity.this.mTimeFormat.format(Integer.valueOf(AlarmActivity.this.mVideoPlayerRender.getDuration())));
                        if (AlarmActivity.this.isMute) {
                            AlarmActivity.this.mVideoPlayerRender.setVolume(0);
                        } else {
                            AlarmActivity.this.mVideoPlayerRender.setVolume(1);
                        }
                    }
                });
            }
        });
    }

    public /* synthetic */ void lambda$initVideoView$0$AlarmActivity() {
        if (this.mVideoTool.getVisibility() == 8) {
            this.mVideoTool.setVisibility(0);
        } else {
            this.mVideoTool.setVisibility(8);
        }
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
        if (!TextUtils.isEmpty(this.currentPlayingFilePath)) {
            final String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
            if (!TextUtils.isEmpty(O000000o2)) {
                new Thread(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity.AnonymousClass17 */

                    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d2 A[SYNTHETIC, Splitter:B:46:0x00d2] */
                    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ec A[SYNTHETIC, Splitter:B:51:0x00ec] */
                    /* JADX WARNING: Removed duplicated region for block: B:59:0x010f A[SYNTHETIC, Splitter:B:59:0x010f] */
                    /* JADX WARNING: Removed duplicated region for block: B:64:0x0129 A[SYNTHETIC, Splitter:B:64:0x0129] */
                    public void run() {
                        FileOutputStream fileOutputStream;
                        if (AlarmActivity.this.isFromRN) {
                            try {
                                AlarmActivity.this.mHandler.sendEmptyMessage(16);
                                MediaStoreUtil.O00000Oo(AlarmActivity.this.getContext(), AlarmActivity.this.currentPlayingFilePath, AlarmActivity.this.mDid, new File(AlarmActivity.this.currentPlayingFilePath).getName());
                                AlarmActivity.this.mHandler.sendEmptyMessage(14);
                            } catch (Exception unused) {
                            }
                            AlarmActivity.this.mHandler.sendEmptyMessage(17);
                            return;
                        }
                        FileInputStream fileInputStream = null;
                        try {
                            AlarmActivity.this.mHandler.sendEmptyMessage(16);
                            FileInputStream fileInputStream2 = new FileInputStream(AlarmActivity.this.currentPlayingFilePath);
                            try {
                                fileOutputStream = new FileOutputStream(O000000o2);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = fileInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    AlarmActivity.this.mHandler.sendEmptyMessage(14);
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e) {
                                        gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e2) {
                                        gsy.O000000o(6, "alarm", e2.getLocalizedMessage());
                                    }
                                    AlarmActivity.this.mHandler.sendEmptyMessage(17);
                                } catch (IOException e3) {
                                    e = e3;
                                    fileInputStream = fileInputStream2;
                                    try {
                                        gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                                        if (fileInputStream != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        AlarmActivity.this.mHandler.sendEmptyMessage(17);
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
                                        AlarmActivity.this.mHandler.sendEmptyMessage(17);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    AlarmActivity.this.mHandler.sendEmptyMessage(17);
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e = e6;
                                fileOutputStream = null;
                                fileInputStream = fileInputStream2;
                                gsy.O000000o(6, "alarm", e.getLocalizedMessage());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e7) {
                                        gsy.O000000o(6, "alarm", e7.getLocalizedMessage());
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                        gsy.O000000o(6, "alarm", e8.getLocalizedMessage());
                                    }
                                }
                                AlarmActivity.this.mHandler.sendEmptyMessage(17);
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                AlarmActivity.this.mHandler.sendEmptyMessage(17);
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
                            AlarmActivity.this.mHandler.sendEmptyMessage(17);
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = null;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            AlarmActivity.this.mHandler.sendEmptyMessage(17);
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
}
