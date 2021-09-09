package com.xiaomi.smarthome.camera.activity.local;

import _m_j.chw;
import _m_j.cin;
import _m_j.civ;
import _m_j.dvp;
import _m_j.ftn;
import _m_j.goq;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hyy;
import _m_j.hzc;
import _m_j.jdn;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.TrafficStats;
import android.net.wifi.WifiManager;
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
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.mijia.camera.MediaRemuxing;
import com.squareup.picasso.Picasso;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IStreamCmdMessageListener;
import com.xiaomi.smarthome.camera.XmMp4Player;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.CommandTreatment;
import com.xiaomi.smarthome.camera.activity.timelapse.TCPClient;
import com.xiaomi.smarthome.camera.activity.timelapse.TimeLapseTaskManager;
import com.xiaomi.smarthome.camera.activity.timelapse.Timelapse;
import com.xiaomi.smarthome.camera.activity.timelapse.TimelapseTask;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.camera.view.RoundProgressBar;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimelapsePhotographPlayActivity extends CameraPlayerBaseActivity implements View.OnClickListener, IStreamCmdMessageListener {
    private static final String TAG = AlbumActivity.class.getSimpleName();
    private static int fileLength = 0;
    private static long recieveLength = 0;
    private Bitmap bitmapTemp;
    private CheckBox cbTogglePlay;
    private long fileDuration;
    private String fileName = "time_Task_";
    private boolean isDisplay;
    private boolean isDownLoading = false;
    private boolean isSameWifi = false;
    private ImageView ivFullScreen;
    private ImageView iv_download_video;
    private long lastTimeStamp = 0;
    private long lastTotalRxBytes = 0;
    private LinearLayout ll_video_frame;
    private View mBottomViewContainer;
    private TextView mDurationView;
    private ImageView mFullScreenView;
    private File mLocalFile;
    private boolean mPlayAutoPause = false;
    public TextView mPlayingView;
    private SeekBar mProgressBar;
    private View mProgressBarContainer;
    private int mRotation = 0;
    private SeekBar.OnSeekBarChangeListener mSeekBarChange = new SeekBar.OnSeekBarChangeListener() {
        /* class com.xiaomi.smarthome.camera.activity.local.TimelapsePhotographPlayActivity.AnonymousClass3 */

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (TimelapsePhotographPlayActivity.this.mSeekBarTouched) {
                TimelapsePhotographPlayActivity.this.mHandler.removeMessages(2);
                TimelapsePhotographPlayActivity.this.mPlayingView.setText(TimelapsePhotographPlayActivity.this.mTimeFormat.format(Integer.valueOf(i * 1000)));
                Message obtainMessage = TimelapsePhotographPlayActivity.this.mHandler.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i;
                obtainMessage.sendToTarget();
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            TimelapsePhotographPlayActivity.this.mSeekBarTouched = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            TimelapsePhotographPlayActivity.this.mSeekBarTouched = false;
        }
    };
    public boolean mSeekBarTouched = false;
    public SimpleDateFormat mTimeFormat;
    private TimeLapseTaskManager mTimeLapseTaskManager;
    private View mTopViewContainer;
    private XmMp4Player mVideoPlayerRender;
    private FrameLayout mVideoViewFrame;
    private int mVideoViewFrameHeight;
    private final String mp4FileName = "Time_Lapse.mp4";
    public File originalMp4File;
    private String phoneSSID;
    private String picStr;
    private int port;
    private RelativeLayout rl_fragment4_2c_timelapse_play_video_screen_download_video;
    private RelativeLayout rl_start_downloading;
    private String rootVideoPath;
    private RoundProgressBar roundprogressbar;
    private long startRealTimeInsec;
    private long startTimeInsec;
    TimerTask task = new TimerTask() {
        /* class com.xiaomi.smarthome.camera.activity.local.TimelapsePhotographPlayActivity.AnonymousClass1 */

        public void run() {
            TimelapsePhotographPlayActivity.this.showNetSpeed();
        }
    };
    private Timer timer;
    private FrameLayout title_bar;
    private TextView tv_download_speed;
    private TextView tv_video_size;
    private String videoPath;
    private File videofile;
    private XmVideoViewGl xmVideoViewGl;

    public void detectSDCard() {
    }

    public void doResume() {
    }

    public boolean isHistory() {
        return false;
    }

    public void onDisconnectedWithCode(int i) {
    }

    public void refreshUI() {
    }

    public void resumeCamera() {
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        ((AudioManager) getApplicationContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
        setContentView((int) R.layout.camera_activity_timelapse_player);
        Picasso.get().load(ftn.O00000Oo(CoreApi.O000000o().O0000ooO(), hzc.f1008O000000o.get("play_nonepicture_01"))).into((ImageView) findViewById(R.id.rl_download_video_bg));
        Picasso.get().load(ftn.O00000Oo(CoreApi.O000000o().O0000ooO(), hzc.f1008O000000o.get("play_nonepicture_01"))).into((ImageView) findViewById(R.id.rl_start_downloading_bg));
        this.videoPath = getIntent().getStringExtra("file_path");
        this.startRealTimeInsec = getIntent().getLongExtra("file_realtime", 0);
        this.startTimeInsec = getIntent().getLongExtra("file_time", 0);
        this.rootVideoPath = getIntent().getStringExtra("video_path");
        String str = TAG;
        civ.O00000o(str, " 获取来的 videoPath = " + this.videoPath + ",获取的加上时区的时间 startRealTimeInsec=" + this.startRealTimeInsec + ",rootVideoPath =" + this.rootVideoPath + ",没有加上时区的时间=" + this.startTimeInsec);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        initView();
        this.mTimeLapseTaskManager = new TimeLapseTaskManager(this.mCameraDevice, this);
    }

    private void initView() {
        this.title_bar = (FrameLayout) findViewById(R.id.title_bar);
        this.title_bar.bringToFront();
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.rl_start_downloading = (RelativeLayout) findViewById(R.id.rl_start_downloading);
        this.rl_fragment4_2c_timelapse_play_video_screen_download_video = (RelativeLayout) findViewById(R.id.rl_fragment4_2c_timelapse_play_video_screen_download_video);
        this.iv_download_video = (ImageView) findViewById(R.id.iv_download_video);
        this.iv_download_video.setOnClickListener(this);
        this.tv_video_size = (TextView) findViewById(R.id.tv_video_size);
        this.roundprogressbar = (RoundProgressBar) findViewById(R.id.roundprogressbar);
        this.roundprogressbar.setCricleProgressColor(Color.parseColor("#00c598"));
        this.tv_download_speed = (TextView) findViewById(R.id.tv_download_speed);
        this.ll_video_frame = (LinearLayout) findViewById(R.id.ll_video_frame);
        ((TextView) findViewById(R.id.title_bar_title)).setText(cin.O000000o(this.startTimeInsec * 1000));
        String str = TAG;
        civ.O00000o(str, "标题时间戳=" + cin.O000000o(this.startTimeInsec * 1000));
        this.mBottomViewContainer = findViewById(R.id.bottom_tools_container);
        this.mTopViewContainer = findViewById(R.id.top_tools_container);
        this.mProgressBarContainer = findViewById(R.id.progress_bar_container);
        this.mProgressBar = (SeekBar) findViewById(R.id.progress_bar);
        this.mDurationView = (TextView) findViewById(R.id.progress_duration);
        this.mPlayingView = (TextView) findViewById(R.id.progress_playtime);
        this.mProgressBar.setOnSeekBarChangeListener(this.mSeekBarChange);
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        this.mVideoViewFrame.addView(frameLayout, 0, layoutParams);
        this.xmVideoViewGl = XmPluginHostApi.instance().createMp4View(this, frameLayout, true);
        this.xmVideoViewGl.setMiniScale(true);
        this.mVideoPlayerRender = this.xmVideoViewGl.getMp4Player();
        this.mVideoPlayerRender.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$N4CGnMbHwUGGP15cQwsxJDS870 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                TimelapsePhotographPlayActivity.this.lambda$initView$1$TimelapsePhotographPlayActivity(mediaPlayer);
            }
        });
        this.mVideoPlayerRender.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$OGzLrQ9XoxUJv2IkxoR8cvRlzjc */

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return TimelapsePhotographPlayActivity.this.lambda$initView$3$TimelapsePhotographPlayActivity(mediaPlayer, i, i2);
            }
        });
        this.xmVideoViewGl.setVideoViewListener(new XmVideoViewGl.IVideoViewListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$eycdJK1P9pWhEkmXSSU8lrBbhw */

            public final void onVideoViewClick() {
                TimelapsePhotographPlayActivity.this.lambda$initView$4$TimelapsePhotographPlayActivity();
            }
        });
        this.mFullScreenView = (ImageView) findViewById(R.id.full_screen);
        this.mFullScreenView.setOnClickListener(this);
        findViewById(R.id.flip).setOnClickListener(this);
        findViewById(R.id.local_share).setOnClickListener(this);
        findViewById(R.id.local_delete).setOnClickListener(this);
        this.xmVideoViewGl.initial();
        this.mVideoPlayerRender.setRenderCallback(new XmMp4Player.RenderCallback() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$H5Ri0OzAxlNK2z_2ldcseM9To */

            public final void onInitialed() {
                TimelapsePhotographPlayActivity.this.lambda$initView$6$TimelapsePhotographPlayActivity();
            }
        });
        this.cbTogglePlay = (CheckBox) findViewById(R.id.cbTogglePlay);
        this.cbTogglePlay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$2eCP3L93UW0exWssqpu336Zmys */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TimelapsePhotographPlayActivity.this.lambda$initView$7$TimelapsePhotographPlayActivity(compoundButton, z);
            }
        });
        this.ivFullScreen = (ImageView) findViewById(R.id.ivFullScreen);
        this.ivFullScreen.setOnClickListener(this);
    }

    public /* synthetic */ void lambda$initView$1$TimelapsePhotographPlayActivity(MediaPlayer mediaPlayer) {
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$WunNdJQ_mxEQgDw7E6CtGBKzw6I */

            public final void run() {
                TimelapsePhotographPlayActivity.this.lambda$null$0$TimelapsePhotographPlayActivity();
            }
        });
    }

    public /* synthetic */ void lambda$null$0$TimelapsePhotographPlayActivity() {
        this.mHandler.removeMessages(1);
        SeekBar seekBar = this.mProgressBar;
        seekBar.setProgress(seekBar.getMax());
        this.mPlayingView.setText(this.mDurationView.getText());
        this.cbTogglePlay.setChecked(true);
    }

    public /* synthetic */ boolean lambda$initView$3$TimelapsePhotographPlayActivity(MediaPlayer mediaPlayer, int i, int i2) {
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$30B2hLpDV1yzCdXH6koHnK5Qaso */

            public final void run() {
                TimelapsePhotographPlayActivity.this.lambda$null$2$TimelapsePhotographPlayActivity();
            }
        });
        return true;
    }

    public /* synthetic */ void lambda$null$2$TimelapsePhotographPlayActivity() {
        this.mHandler.removeMessages(1);
        this.mProgressBar.setProgress(this.mVideoPlayerRender.getCurrentPosition() / 1000);
        this.mPlayingView.setText(this.mTimeFormat.format(Integer.valueOf(this.mVideoPlayerRender.getCurrentPosition())));
        this.cbTogglePlay.setChecked(true);
    }

    public /* synthetic */ void lambda$initView$4$TimelapsePhotographPlayActivity() {
        if (this.mProgressBarContainer.getVisibility() == 0) {
            AnimationUtils.loadAnimation(this, R.anim.slide_out_top).setFillAfter(true);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
            loadAnimation.setFillAfter(true);
            this.mProgressBarContainer.setClickable(false);
            this.mProgressBarContainer.setVisibility(8);
            this.mProgressBarContainer.startAnimation(loadAnimation);
            return;
        }
        AnimationUtils.loadAnimation(this, R.anim.slide_in_top).setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);
        loadAnimation2.setFillAfter(true);
        this.mProgressBarContainer.setClickable(true);
        this.mProgressBarContainer.setVisibility(0);
        this.mProgressBarContainer.startAnimation(loadAnimation2);
    }

    public /* synthetic */ void lambda$initView$6$TimelapsePhotographPlayActivity() {
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$VpZqXrHf70_xsVRXUIUDnpiU_sY */

            public final void run() {
                TimelapsePhotographPlayActivity.this.lambda$null$5$TimelapsePhotographPlayActivity();
            }
        });
    }

    public /* synthetic */ void lambda$initView$7$TimelapsePhotographPlayActivity(CompoundButton compoundButton, boolean z) {
        if (z) {
            pausePlay();
            this.cbTogglePlay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.home_icon_play02), (Drawable) null);
            return;
        }
        lambda$null$5$TimelapsePhotographPlayActivity();
        this.cbTogglePlay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.home_icon_pause02), (Drawable) null);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.iv_download_video) {
            judgeownloadVideo();
        } else if (id == R.id.local_share) {
            civ.O00000o(TAG, "分享 mLocalFile=" + this.mLocalFile);
            if (this.mLocalFile != null) {
                if (XmPluginHostApi.instance().getApiLevel() >= 29) {
                    CameraJumpUtils.openShareActivity(this, "", "", this.mLocalFile.getAbsolutePath(), 17);
                } else {
                    CameraJumpUtils.openShareActivity(this, "", "", this.mLocalFile.getAbsolutePath());
                }
            }
        } else if (id == R.id.flip) {
            this.mRotation += 90;
            this.mRotation %= 360;
            this.xmVideoViewGl.setRotation(this.mRotation);
        } else if (id == R.id.local_delete) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O000000o((int) R.string.delete_title);
            builder.O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$Tf_Hzt3cWrWgvOGmSQUTKTqY_7A */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    TimelapsePhotographPlayActivity.this.lambda$onClick$8$TimelapsePhotographPlayActivity(dialogInterface, i);
                }
            });
            builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            builder.O00000oo();
        } else if (id == R.id.ivFullScreen) {
            setOrientation(!this.mFullScreen);
        }
    }

    public /* synthetic */ void lambda$onClick$8$TimelapsePhotographPlayActivity(DialogInterface dialogInterface, int i) {
        deleteTimeLapse();
    }

    /* access modifiers changed from: protected */
    public void setOrientation(boolean z) {
        if (z) {
            enterPadFullScreen();
            setRequestedOrientation(0);
            return;
        }
        setRequestedOrientation(1);
    }

    private void judgeownloadVideo() {
        if (!this.isDownLoading) {
            this.isDisplay = true;
            refreshPhoneSSID();
            if (!TextUtils.isEmpty(this.phoneSSID) && this.phoneSSID.contains("5G")) {
                gsy.O00000Oo(TAG, "走了5");
                this.phoneSSID = this.phoneSSID.replaceAll("_5G", "");
                if (this.phoneSSID.contains(this.mCameraDevice.mDeviceStat.ssid) || (!TextUtils.isEmpty(this.mCameraDevice.mDeviceStat.ssid) && this.mCameraDevice.mDeviceStat.ssid.contains(this.phoneSSID))) {
                    this.isSameWifi = true;
                } else {
                    this.isSameWifi = false;
                }
            } else if ((TextUtils.isEmpty(this.phoneSSID) || !this.phoneSSID.contains(this.mCameraDevice.mDeviceStat.ssid)) && (TextUtils.isEmpty(this.mCameraDevice.mDeviceStat.ssid) || !this.mCameraDevice.mDeviceStat.ssid.contains(this.phoneSSID))) {
                this.isSameWifi = false;
            } else {
                this.isSameWifi = true;
            }
            String str = TAG;
            gsy.O00000Oo(str, "摄像头ssid = " + this.mCameraDevice.mDeviceStat.ssid + "   手机ssid = " + this.phoneSSID + "  是否同网=" + this.isSameWifi);
            if (!TextUtils.isEmpty(this.videoPath)) {
                return;
            }
            if (this.isSameWifi) {
                initDownload();
            } else {
                gqg.O000000o((int) R.string.timelapse_connect_camera_failed_not_lan);
            }
        }
    }

    private void refreshPhoneSSID() {
        try {
            this.phoneSSID = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID().replaceAll(jdn.f1779O000000o, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initDownload() {
        if (this.isDownLoading) {
            civ.O00000Oo(TAG, "download is already started!");
            return;
        }
        this.rl_start_downloading.setVisibility(0);
        this.lastTotalRxBytes = getTotalRxBytes();
        this.lastTimeStamp = System.currentTimeMillis();
        if (this.timer == null) {
            this.timer = new Timer();
            TimerTask timerTask = this.task;
            if (timerTask != null) {
                this.timer.schedule(timerTask, 1000, 1000);
            }
        }
        getSDTimeLapsePhotographyFile();
    }

    private long getTotalRxBytes() {
        if (TrafficStats.getUidRxBytes(getApplicationInfo().uid) == -1) {
            return 0;
        }
        return TrafficStats.getTotalRxBytes() / 1024;
    }

    public void showNetSpeed() {
        long totalRxBytes = getTotalRxBytes();
        long currentTimeMillis = System.currentTimeMillis();
        this.lastTimeStamp = currentTimeMillis;
        this.lastTotalRxBytes = totalRxBytes;
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 1000;
        obtainMessage.obj = String.valueOf(((totalRxBytes - this.lastTotalRxBytes) * 1000) / (currentTimeMillis - this.lastTimeStamp)) + " kb/s";
        this.mHandler.sendMessage(obtainMessage);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        civ.O00000o("AlbumActivity", "延时摄影详情页 what=" + message.what);
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
        } else if (i == 1000) {
            civ.O00000o(TAG, "显示下载速度");
            this.tv_download_speed.setText((String) message.obj);
        } else if (i == 21007) {
            String str = TAG;
            civ.O00000o(str, "延时摄影数据删除成功 msg.arg1=" + message.arg1);
            if (message.arg1 == 1) {
                gqg.O000000o(getString(R.string.local_file_delete_success));
                setResult(-1, new Intent());
                finish();
                return;
            }
            gsy.O00000Oo(TAG, "延时摄影删除失败");
            gqg.O000000o(getString(R.string.delete_timelapse_failed));
        } else if (i == 21010) {
            civ.O00000o(TAG, "获取新版延时摄影下载");
            if (message.obj != null) {
                byte[] bArr = (byte[]) message.obj;
                byte b = bArr[0];
                this.port = dvp.O000000o(bArr, 1);
                String str2 = TAG;
                civ.O00000o(str2, "result=" + ((int) b) + ",port=" + this.port);
                if (b == 0 || b == 1 || b == 2) {
                    closeTimeLapsePhotographySever(this.port);
                    UIForCancelDownload();
                    cancleTask();
                    gqg.O000000o(getString(R.string.timelapse_downfaile));
                    return;
                }
                String ip = this.mCameraDevice.getIp();
                civ.O00000o(TAG, "Ip地址=".concat(String.valueOf(ip)));
                this.isDownLoading = true;
                TCPClient.getInstance(this).createClient(ip, this.port, this.mHandler, this.rootVideoPath, this.startRealTimeInsec);
            }
        } else if (i != 26041) {
            if (i == 99999) {
                civ.O00000o(TAG, "socket 服务超时");
                closeTimeLapsePhotographySever(this.port);
                UIForCancelDownload();
                gqg.O000000o(getString(R.string.socket_client_timeout));
            } else if (i != 210011) {
                switch (i) {
                    case 1000000:
                        civ.O00000o(TAG, "socket服务出现问题了，请重试");
                        closeTimeLapsePhotographySever(this.port);
                        UIForCancelDownload();
                        gqg.O000000o(getString(R.string.socket_client));
                        return;
                    case 1000001:
                        fileLength = ((Integer) message.obj).intValue();
                        return;
                    case 1000002:
                        this.isDownLoading = true;
                        long j = (long) message.arg1;
                        recieveLength = j;
                        int i2 = (int) ((j * 100) / ((long) fileLength));
                        gsy.O000000o(3, TAG, "当前的下载的进度=".concat(String.valueOf(i2)));
                        this.rl_start_downloading.setVisibility(0);
                        this.roundprogressbar.setProgress(i2);
                        return;
                    case 1000003:
                        civ.O00000o(TAG, "新版延时摄影下载成功");
                        closeTimeLapsePhotographySever(this.port);
                        this.isDownLoading = false;
                        String str3 = (String) message.obj;
                        civ.O00000o(TAG, "下载成功的文件路径=".concat(String.valueOf(str3)));
                        if (str3 != null) {
                            convert(str3);
                            return;
                        }
                        return;
                    case 1000004:
                        closeTimeLapsePhotographySever(this.port);
                        UIForCancelDownload();
                        String str4 = TAG;
                        civ.O00000o(str4, "新版延时摄影下载失败 msg.arg1=" + message.arg1);
                        if (message.arg1 == 1) {
                            cancleTask();
                            return;
                        } else {
                            gqg.O000000o(getString(R.string.network_not_stable));
                            return;
                        }
                    case 1000005:
                        civ.O00000o(TAG, "取消延时摄影下载");
                        closeTimeLapsePhotographySever(this.port);
                        TCPClient.getInstance(this).setFlag(true);
                        return;
                    default:
                        return;
                }
            } else {
                civ.O00000o(TAG, "关闭下载服务");
                if (message.obj != null) {
                    this.isDownLoading = false;
                    byte b2 = ((byte[]) message.obj)[0];
                    civ.O00000o(TAG, "result=".concat(String.valueOf((int) b2)));
                    if (b2 == 1) {
                        civ.O00000o(TAG, "关闭服务器成功");
                        TCPClient.getInstance(this).closeSocket();
                        return;
                    }
                    civ.O00000o(TAG, "关闭服务器失败");
                }
            }
        } else if (message.arg1 != 26043 && message.arg1 == 26044) {
            this.rl_start_downloading.setVisibility(8);
            this.rl_fragment4_2c_timelapse_play_video_screen_download_video.setVisibility(8);
            cancleTask();
            this.videoPath = this.originalMp4File.getAbsolutePath();
            lambda$null$5$TimelapsePhotographPlayActivity();
            gsy.O000000o(3, TAG, "开始播放了。。。。");
        }
    }

    /* renamed from: startPlay */
    public void lambda$null$5$TimelapsePhotographPlayActivity() {
        String str = TAG;
        civ.O00000o(str, "startPlay did=" + this.mCameraDevice.getDid());
        String str2 = this.videoPath;
        if (str2 == null || !new File(str2).exists()) {
            civ.O00000o(TAG, "没有下载，显示下载的布局");
            TCPClient.getInstance(this).setFlag(true);
            this.rl_fragment4_2c_timelapse_play_video_screen_download_video.setVisibility(0);
            this.ll_video_frame.setVisibility(8);
            findViewById(R.id.local_share).setVisibility(8);
            return;
        }
        this.ll_video_frame.setVisibility(0);
        this.mLocalFile = new File(this.videoPath);
        File file = this.mLocalFile;
        if (file != null) {
            extractVideoInfo(file);
            this.mProgressBar.setMax((int) (this.fileDuration / 1000));
            this.mDurationView.setText(this.mTimeFormat.format(new Date(this.fileDuration)));
        }
        civ.O00000o(TAG, "视频文件存在走了本地播放");
        this.mVideoPlayerRender.openVideoPlayer(this.videoPath);
        findViewById(R.id.local_share).setVisibility(0);
        this.mPlayAutoPause = false;
        this.mHandler.sendEmptyMessage(1);
        saveBitmap(this.bitmapTemp, this.videoPath);
    }

    public void getSDTimeLapsePhotographyFile() {
        this.startRealTimeInsec = getIntent().getLongExtra("file_realtime", 0);
        if (this.startRealTimeInsec != 0) {
            this.fileName += this.startRealTimeInsec;
            civ.O00000o(TAG, "延时摄影下载的文件 fileName=" + this.fileName);
            this.mTimeLapseTaskManager.getSDTimeLapsePhotographyFile(1, this.fileName, this);
        }
    }

    public void closeTimeLapsePhotographySever(int i) {
        this.mTimeLapseTaskManager.closeTimeLapsePhotographySever(i, this);
    }

    public void onServerCmd(int i, byte[] bArr) {
        civ.O00000o(TAG, "延时摄影详情页 CommandTreatment onServerCmd type=".concat(String.valueOf(i)));
        new CommandTreatment(this.mHandler, this.mCameraDevice).processData(bArr);
    }

    public void onConnected() {
        super.onConnected();
        civ.O00000o(TAG, "摄像头连接成功，授权+校准时间+延时摄影查询功能");
        this.mCameraPlayerEx.O0000Oo();
        this.mCameraPlayerEx.O0000Oo0();
        this.mTimeLapseTaskManager.getTimeLapseTask(this);
    }

    private void UIForCancelDownload() {
        this.rl_start_downloading.setVisibility(8);
        this.rl_fragment4_2c_timelapse_play_video_screen_download_video.setVisibility(0);
    }

    private void cancleTask() {
        TimerTask timerTask = this.task;
        if (timerTask != null) {
            timerTask.cancel();
            this.task = null;
        }
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
    }

    private void convert(final String str) {
        findViewById(R.id.local_share).setVisibility(0);
        gsy.O000000o(3, TAG, "convert...filePath=".concat(String.valueOf(str)));
        this.originalMp4File = new File(this.rootVideoPath + "/Time_Lapse.mp4");
        String str2 = TAG;
        gsy.O000000o(3, str2, "originalMp4File=" + this.originalMp4File);
        new File(str);
        new Thread() {
            /* class com.xiaomi.smarthome.camera.activity.local.TimelapsePhotographPlayActivity.AnonymousClass2 */

            public void run() {
                TimelapsePhotographPlayActivity.this.mHandler.obtainMessage(26041, 26043, -1).sendToTarget();
                TimelapsePhotographPlayActivity timelapsePhotographPlayActivity = TimelapsePhotographPlayActivity.this;
                MediaRemuxing.remuxing(timelapsePhotographPlayActivity, str, timelapsePhotographPlayActivity.originalMp4File.getAbsolutePath());
                TimelapsePhotographPlayActivity.this.mHandler.obtainMessage(26041, 26044, -1).sendToTarget();
            }
        }.start();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setWindowNew(configuration);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyy.O000000o(android.app.Activity, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.local.TimelapsePhotographPlayActivity, boolean]
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
    private void setWindowNew(Configuration configuration) {
        if (this.mFullScreen) {
            getWindow().setFlags(1024, 1024);
            this.title_bar.setVisibility(8);
            this.mBottomViewContainer.setVisibility(8);
            this.ivFullScreen.setImageResource(R.drawable.home_icon_mixscreen);
            this.xmVideoViewGl.setVideoFrameSize(-1, -1, true);
        } else {
            getWindow().clearFlags(1024);
            this.title_bar.setVisibility(0);
            this.title_bar.bringToFront();
            this.mBottomViewContainer.setVisibility(0);
            this.ivFullScreen.setImageResource(R.drawable.home_icon_fullscreen);
            this.xmVideoViewGl.setVideoFrameSize(-1, -1, false);
        }
        hyy.O000000o((Activity) this, this.mFullScreen);
    }

    public void onBackPressed() {
        String str = TAG;
        civ.O00000o(str, "onBackPressed isDownLoading=" + this.isDownLoading);
        if (this.mFullScreen) {
            exitFullScreen(null);
        } else if (this.isDownLoading) {
            cancleDownLoad();
        } else {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        XmVideoViewGl xmVideoViewGl2 = this.xmVideoViewGl;
        if (xmVideoViewGl2 != null) {
            xmVideoViewGl2.release();
        }
        civ.O00000o(TAG, "延时摄像详情页 onDestroy");
    }

    private void pausePlay() {
        this.mVideoPlayerRender.pause();
    }

    public void onPause() {
        super.onPause();
        XmMp4Player xmMp4Player = this.mVideoPlayerRender;
        if (xmMp4Player != null && xmMp4Player.isPlaying()) {
            pausePlay();
            this.mPlayAutoPause = true;
        }
    }

    public void onResume() {
        super.onResume();
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$migGViZt8da8xnAdm2TJbQ9bkWQ */

            public final void run() {
                TimelapsePhotographPlayActivity.this.lambda$onResume$9$TimelapsePhotographPlayActivity();
            }
        }, 500);
        if (this.mCameraPlayerEx == null) {
            this.mCameraPlayerEx = new chw(this.mCameraDevice, this);
        }
    }

    public /* synthetic */ void lambda$onResume$9$TimelapsePhotographPlayActivity() {
        if (this.mPlayAutoPause) {
            lambda$null$5$TimelapsePhotographPlayActivity();
        }
    }

    private void extractVideoInfo(File file) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
            String str = TAG;
            civ.O00000o(str, "extractVideoInfo localFile=" + file.getAbsolutePath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            this.bitmapTemp = mediaMetadataRetriever.getFrameAtTime();
            if (!TextUtils.isEmpty(extractMetadata)) {
                this.fileDuration = Long.valueOf(extractMetadata).longValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private void deleteTimeLapse() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        String str = TAG;
        civ.O00000o(str, " 删除Timelapse：" + this.startTimeInsec);
        File deleTimeLapseFolder = deleTimeLapseFolder();
        if (deleTimeLapseFolder != null) {
            String str2 = TAG;
            civ.O00000o(str2, "deletFolderPath =" + deleTimeLapseFolder.getAbsolutePath());
        }
        TimelapseTask timeLapseFromList = Timelapse.getTimeLapseFromList(this.startTimeInsec);
        if (timeLapseFromList != null) {
            timeLapseFromList.deleteLocalData(deleTimeLapseFolder);
        }
        arrayList.add(new TimelapseTask(3, (int) (this.startTimeInsec + ((long) cin.O00000o()))));
        if (arrayList.size() > 0) {
            civ.O00000Oo(TAG, "=====================================0");
            civ.O00000o(TAG, "发送了获取延时摄影列表的命令");
            this.mTimeLapseTaskManager.deleteRecord(arrayList, this);
        }
    }

    private File deleTimeLapseFolder() {
        String str = this.rootVideoPath;
        if (str == null || !str.contains("video")) {
            return null;
        }
        String[] split = this.rootVideoPath.split("/video");
        if (split.length > 0) {
            return new File(split[0]);
        }
        return null;
    }

    private void cancleDownLoad() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.cancel_download);
        builder.O00000Oo((int) R.string.confirm_cancel_download);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$LZjebgs7QNYc8X4OzZ6qa4MW10 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                TimelapsePhotographPlayActivity.this.lambda$cancleDownLoad$10$TimelapsePhotographPlayActivity(dialogInterface, i);
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O00000oo();
    }

    public /* synthetic */ void lambda$cancleDownLoad$10$TimelapsePhotographPlayActivity(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        TCPClient.getInstance(this).setFlag(false);
        finish();
    }

    private boolean findPathPic(String str) {
        if (str != null) {
            try {
                String[] split = str.split("video");
                if (split != null && split.length > 0) {
                    String str2 = split[0];
                    gsy.O00000Oo(TAG, "findPathPic===".concat(String.valueOf(str2)));
                    this.picStr = str2 + "pic/";
                    String str3 = TAG;
                    gsy.O00000Oo(str3, "findPathPic picFile===" + this.picStr);
                    String[] list = new File(this.picStr).list();
                    if (list == null || list.length <= 0) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void saveBitmap(Bitmap bitmap, String str) {
        goq.O000000o(new Runnable(str, bitmap) {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$TimelapsePhotographPlayActivity$r4aOLQcjzk_6PpLhKhxoWDwaw3w */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Bitmap f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                TimelapsePhotographPlayActivity.this.lambda$saveBitmap$11$TimelapsePhotographPlayActivity(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$saveBitmap$11$TimelapsePhotographPlayActivity(String str, Bitmap bitmap) {
        try {
            findPathPic(str);
            if (bitmap != null) {
                String str2 = TAG;
                civ.O00000o(str2, "file ==" + this.picStr);
                File file = new File(this.picStr);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str3 = this.picStr;
                File file2 = new File(str3, System.currentTimeMillis() + ".jpg");
                String str4 = TAG;
                civ.O00000o(str4, "file ==" + file2.getAbsolutePath());
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
            }
            gsy.O00000Oo(TAG, "保存图片成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onSendCmdError() {
        civ.O00000o(TAG, "onSendCmdError");
    }
}
