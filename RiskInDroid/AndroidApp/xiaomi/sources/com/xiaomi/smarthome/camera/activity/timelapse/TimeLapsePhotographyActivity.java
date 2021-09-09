package com.xiaomi.smarthome.camera.activity.timelapse;

import _m_j.C0118cif;
import _m_j.chr;
import _m_j.chw;
import _m_j.cin;
import _m_j.civ;
import _m_j.goq;
import _m_j.gqg;
import _m_j.me;
import _m_j.mg;
import _m_j.uo;
import _m_j.up;
import _m_j.uv;
import _m_j.vh;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.mijia.model.sdcard.SDCardInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.IStreamCmdMessageListener;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.activity.CameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.CommandTreatment;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.local.TimelapsePhotographPlayActivity;
import com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootDialog;
import com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootTimeDialog;
import com.xiaomi.smarthome.camera.activity.timelapse.ShootModeDialog;
import com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity;
import com.xiaomi.smarthome.camera.view.MultiStateTextView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TimeLapsePhotographyActivity extends CameraPlayerBaseActivity implements IStreamCmdMessageListener {
    public static final String TAG = "TimeLapsePhotographyActivity";
    public static int TIMELAPSE_PHOTOGRAPHY = 1;
    private Calendar currentCalendar;
    public int currentHour;
    private int currentHourCalendar;
    private int currentMinCalendar;
    public TimelapseTask currentTimelapseTask;
    private int diffHour;
    private int diffMin;
    private String endTimeHour;
    private String endTimeMin;
    public String errorText;
    public FrameLayout fl_timelaps_demo;
    private int intervalToTakePicture;
    public boolean isCancleTimeLapse = false;
    private boolean isClickAlbum = false;
    public boolean isManualShootFinish = false;
    public boolean isMemorycardExists = false;
    public boolean isScheduledShoot = false;
    private boolean isShootTask;
    private boolean isStartPlay = false;
    private boolean isStartShoot = false;
    private boolean isStopAndSave = false;
    private boolean isTomorrow = false;
    public ImageView iv_shoot_start;
    private ImageView iv_timelaps_demo;
    private SDCardInfo mInfo;
    public LinearLayout mLLFuncPopup;
    private TimeLapseTaskManager mTimeLapseTaskManager;
    private MultiStateTextView mTvScheduledShoot;
    public MultiStateTextView mTvShootingMode;
    private TimelapseTask newTimelapseTask;
    private int scheduledHour;
    private int scheduledMine;
    private Calendar scheduledShootCalendar;
    public int shootDurSecond = 18000;
    private ShootModeDialog shootModeDialog;
    private String startTimeDay;
    private String startTimeHour;
    private String startTimeMin;
    private ImageView title_bar_return;
    public TextView tv_mode_hour;
    public TextView tv_timelapse_start;

    public void detectSDCard() {
    }

    public boolean isHistory() {
        return false;
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_timelapse_photography);
        this.scheduledShootCalendar = Calendar.getInstance();
        this.currentCalendar = Calendar.getInstance();
        initView();
        initVideoView();
        initMulti();
        loadData(false);
        this.mTimeLapseTaskManager = new TimeLapseTaskManager(this.mCameraDevice, this);
        this.iv_timelaps_demo = (ImageView) findViewById(R.id.iv_timelaps_demo);
        this.fl_timelaps_demo = (FrameLayout) findViewById(R.id.fl_timelaps_demo);
        this.iv_timelaps_demo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass1 */

            public void onClick(View view) {
            }
        });
        judgeDownloadTimeLapseDemo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void startPlay() {
        if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
            if (this.mPowerOffView.getVisibility() != 0) {
                this.mPowerOffView.setVisibility(0);
            }
        } else if (!mg.O00000o0(this) || this.mAllowMobileNetwork) {
            civ.O00000o(TAG, "startPlay 开始连接摄像头");
            if (this.mPauseView != null && this.mPauseView.getVisibility() == 0) {
                this.mPauseView.setVisibility(8);
            }
            if (this.mCameraPlayerEx == null) {
                this.mCameraPlayerEx = new chw(this, this.mCameraDevice, this, this.mVideoView);
            }
            if (this.mCameraPlayerEx.O00000oO.isConnected()) {
                toggleRemoteAV(true, false);
                this.mCameraPlayerEx.O000000o(true);
                civ.O00000o(TAG, "连接摄像头成功,开始发送查询当前延时摄影状态信息");
                this.mTimeLapseTaskManager.getTimeLapseTask(this);
                return;
            }
            this.mCameraPlayerEx.O000000o(new IMISSListener() {
                /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass2 */

                public void onFailed(int i, String str) {
                }

                public void onProgress(int i) {
                }

                public void onSuccess(String str, Object obj) {
                    TimeLapsePhotographyActivity.this.toggleRemoteAV(true, false);
                }
            });
            civ.O00000o(TAG, "连接摄像头成功,开始发送查询当前延时摄影状态信息");
            this.mTimeLapseTaskManager.getTimeLapseTask(this);
        } else {
            pauseCamera();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void refreshUI() {
        if (this.mCameraDevice.O000000o().O000000o("power", true)) {
            this.mPowerOffView.setVisibility(8);
        } else {
            this.mPowerOffView.setVisibility(0);
        }
    }

    public void doResume() {
        this.mPauseView.setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void resumeCamera() {
        if (this.mPauseView != null) {
            this.mPauseView.setVisibility(8);
        }
        if (mg.O00000o0(this)) {
            this.mAllowMobileNetwork = true;
        }
        if (this.mCameraPlayerEx != null && !this.mCameraPlayerEx.O00000oO.isConnecting()) {
            hidError();
            showLoading("");
            if (this.mCameraDevice != null && this.mCameraDevice.O000000o().O000000o("power", true)) {
                this.mCameraPlayerEx.O000000o(new IMISSListener() {
                    /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass3 */

                    public void onFailed(int i, String str) {
                    }

                    public void onProgress(int i) {
                    }

                    public void onSuccess(String str, Object obj) {
                        TimeLapsePhotographyActivity.this.toggleRemoteAV(true, false);
                    }
                });
            }
        }
        refreshUI();
    }

    private void initView() {
        ((TextView) findViewById(R.id.title_bar_title)).setText(getString(R.string.timelapse_photography));
        findViewById(R.id.tv_album).setOnClickListener(this);
        this.tv_timelapse_start = (TextView) findViewById(R.id.tv_timelapse_start);
        this.mTvShootingMode = (MultiStateTextView) findViewById(R.id.tv_shooting_mode);
        this.mTvScheduledShoot = (MultiStateTextView) findViewById(R.id.tv_scheduled_shoot);
        this.mTvScheduledShoot.setOnClickListener(this);
        this.iv_shoot_start = (ImageView) findViewById(R.id.iv_shoot_start);
        this.iv_shoot_start.setOnClickListener(this);
        this.mLLFuncPopup = (LinearLayout) findViewById(R.id.llFuncPopup);
        this.title_bar_return = (ImageView) findViewById(R.id.title_bar_return);
        this.title_bar_return.setImageResource(R.drawable.camera_tittlebar_white_normal);
        this.title_bar_return.setOnClickListener(this);
        this.mPauseView = findViewById(R.id.pause_view);
        this.tv_mode_hour = (TextView) findViewById(R.id.tv_mode_hour);
        this.currentHourCalendar = this.currentCalendar.get(11);
        this.currentMinCalendar = this.currentCalendar.get(12);
        int i = this.currentHourCalendar;
        if (i < 10) {
            this.startTimeHour = "0" + this.currentHourCalendar;
        } else {
            this.startTimeHour = String.valueOf(i);
        }
        int i2 = this.currentMinCalendar;
        if (i2 < 10) {
            this.startTimeMin = "0" + this.currentMinCalendar;
        } else {
            this.startTimeMin = String.valueOf(i2);
        }
        this.mPauseView = findViewById(R.id.pause_view);
        this.mPauseView.setOnClickListener(this);
        refreshState(false);
        this.iv_shoot_start.setEnabled(true);
        this.iv_shoot_start.setAlpha(1.0f);
    }

    private void initMulti() {
        this.mTvShootingMode.addState(new MultiStateTextView.StateItem(R.string.timelapse_shoot_one_hour, R.drawable.icon_timelapse_shoot_interval, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass4 */

            public void onClick(View view) {
                civ.O00000o(TimeLapsePhotographyActivity.TAG, "点击了拍摄1小时");
                TimeLapsePhotographyActivity.this.showDialogType(0);
            }
        }));
        this.mTvShootingMode.addState(new MultiStateTextView.StateItem(R.string.timelapse_shoot_three_hour, R.drawable.icon_timelapse_shoot_interval, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass5 */

            public void onClick(View view) {
                civ.O00000o(TimeLapsePhotographyActivity.TAG, "点击了拍摄3小时");
                TimeLapsePhotographyActivity.this.showDialogType(1);
            }
        }));
        this.mTvShootingMode.addState(new MultiStateTextView.StateItem(R.string.timelapse_shoot_fives_hour, R.drawable.icon_timelapse_shoot_interval, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass6 */

            public void onClick(View view) {
                civ.O00000o(TimeLapsePhotographyActivity.TAG, "点击了拍摄5小时");
                TimeLapsePhotographyActivity.this.showDialogType(2);
            }
        }));
    }

    public void showDialogType(int i) {
        this.shootModeDialog = new ShootModeDialog.Builder(this, true).setTitle(getString(R.string.timelapse_shooting_mode)).setType(i).setShootOneHourListener(new ShootModeDialog.ShootOneHourListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass9 */

            public void onConfirm(ShootModeDialog shootModeDialog) {
                shootModeDialog.dismiss();
                TimeLapsePhotographyActivity timeLapsePhotographyActivity = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity.shootDurSecond = 3600;
                timeLapsePhotographyActivity.calcuInterval(1);
                TimeLapsePhotographyActivity timeLapsePhotographyActivity2 = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity2.currentHour = 1;
                timeLapsePhotographyActivity2.mTvShootingMode.setCurrentState(0);
                TimeLapsePhotographyActivity.this.tv_mode_hour.setText(TimeLapsePhotographyActivity.this.getText(R.string.timelapse_shoot_one_hour_desc));
                TimeLapsePhotographyActivity.this.setTimeLapseMode(0);
            }
        }).setShootThreeHourListenerr(new ShootModeDialog.ShootThreeHourListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass8 */

            public void onConfirm(ShootModeDialog shootModeDialog) {
                shootModeDialog.dismiss();
                TimeLapsePhotographyActivity timeLapsePhotographyActivity = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity.shootDurSecond = 10800;
                timeLapsePhotographyActivity.calcuInterval(3);
                TimeLapsePhotographyActivity timeLapsePhotographyActivity2 = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity2.currentHour = 3;
                timeLapsePhotographyActivity2.mTvShootingMode.setCurrentState(1);
                TimeLapsePhotographyActivity.this.tv_mode_hour.setText(TimeLapsePhotographyActivity.this.getText(R.string.timelapse_shoot_three_hour_desc));
                TimeLapsePhotographyActivity.this.setTimeLapseMode(1);
            }
        }).setShootFivesHourListener(new ShootModeDialog.ShootFivesHourListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass7 */

            public void onConfirm(ShootModeDialog shootModeDialog) {
                shootModeDialog.dismiss();
                TimeLapsePhotographyActivity timeLapsePhotographyActivity = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity.shootDurSecond = 18000;
                timeLapsePhotographyActivity.calcuInterval(5);
                TimeLapsePhotographyActivity timeLapsePhotographyActivity2 = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity2.currentHour = 5;
                timeLapsePhotographyActivity2.mTvShootingMode.setCurrentState(2);
                TimeLapsePhotographyActivity.this.tv_mode_hour.setText(TimeLapsePhotographyActivity.this.getText(R.string.timelapse_shoot_fives_hour_desc));
                TimeLapsePhotographyActivity.this.setTimeLapseMode(2);
            }
        }).build();
        this.shootModeDialog.show();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void onClick(View view) {
        if (!doOnClick(view)) {
            int id = view.getId();
            if (id == R.id.tv_scheduled_shoot) {
                new ScheduldShootTimeDialog.Builder(this, true, this.startTimeHour, this.startTimeMin, this.startTimeDay).setTitle(getString(R.string.timelapse_scheduled_shoot_time)).setConfirmListener(new ScheduldShootTimeDialog.ConfirmListener() {
                    /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass10 */

                    public void onConfirm(ScheduldShootTimeDialog scheduldShootTimeDialog, String str, String str2, String str3) {
                        String str4 = TimeLapsePhotographyActivity.TAG;
                        civ.O00000o(str4, "hourTime===" + str + ",minTime===" + str2 + ",day===" + str3);
                        TimeLapsePhotographyActivity.this.scheduledTimeLapsePhotography(str, str2, str3);
                        TimeLapsePhotographyActivity.this.fl_timelaps_demo.setVisibility(8);
                    }
                }).build().show();
            } else if (id == R.id.iv_shoot_start) {
                if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                    gqg.O000000o(getString(R.string.power_off));
                    return;
                }
                chr.O000000o(chr.O00Oo0o0);
                if (!this.isMemorycardExists) {
                    gqg.O000000o(this.errorText);
                    return;
                }
                this.fl_timelaps_demo.setVisibility(8);
                this.isStartShoot = !this.isStartShoot;
                this.isCancleTimeLapse = false;
                if (this.isStartShoot) {
                    civ.O00000o(TAG, "开始拍摄");
                    this.iv_shoot_start.setImageResource(R.drawable.icon_timelapse_shoot_finish);
                    refreshState(false);
                    createTimelapseTask();
                    return;
                }
                String str = TAG;
                civ.O00000o(str, "结束拍摄 isScheduledShoot=" + this.isScheduledShoot);
                if (this.isScheduledShoot) {
                    scheduldShootDialog(getString(R.string.scheduled_timelapse_desc));
                } else {
                    scheduldShootDialog(getString(R.string.scheduled_timelapse_stop));
                }
            } else if (id == R.id.tv_album) {
                this.isClickAlbum = true;
                startActivity(new Intent(this, AlbumActivity.class));
            } else if (id == R.id.title_bar_return) {
                onBackPressed();
            }
        }
    }

    public void refreshState(boolean z) {
        if (z) {
            this.mTvShootingMode.setAlpha(1.0f);
            this.mTvShootingMode.setEnabled(true);
            this.mTvScheduledShoot.setAlpha(1.0f);
            this.mTvScheduledShoot.setEnabled(true);
            this.tv_mode_hour.setAlpha(1.0f);
            this.tv_mode_hour.setEnabled(true);
            return;
        }
        this.mTvShootingMode.setAlpha(0.3f);
        this.mTvShootingMode.setEnabled(false);
        this.mTvScheduledShoot.setAlpha(0.3f);
        this.mTvScheduledShoot.setEnabled(false);
        this.tv_mode_hour.setAlpha(0.3f);
        this.tv_mode_hour.setEnabled(false);
    }

    public void onServerCmd(int i, byte[] bArr) {
        String str = TAG;
        civ.O00000o(str, "onServerCmd  type=" + i + ",data=" + bArr.length);
        new CommandTreatment(this.mHandler, this.mCameraDevice).processData(bArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.camera.XmVideoViewGl.setDistort(float, float):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.camera.XmVideoViewGl.setDistort(int, int):void
      com.xiaomi.smarthome.camera.XmVideoViewGl.setDistort(float, float):void */
    private void initVideoView() {
        this.mVideoViewFrame = (FrameLayout) findViewById(R.id.video_frame);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mVideoLayout = new FrameLayout(this);
        this.mVideoViewFrame.addView(this.mVideoLayout, 0, layoutParams);
        this.mVideoView = XmPluginHostApi.instance().createVideoView(this, this.mVideoLayout, true, 2);
        this.mVideoView.setMaxScale(6.0f, 6.0f);
        this.mLoadingView = LayoutInflater.from(this).inflate((int) R.layout.camera_progress, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mVideoLayout.addView(this.mLoadingView, layoutParams2);
        this.mLoadingView.setVisibility(8);
        this.mLoadingProgress = (TextView) this.mLoadingView.findViewById(R.id.loading_progress);
        this.mLoadingTitle = (TextView) this.mLoadingView.findViewById(R.id.loading_title);
        this.mLoadingImageView = (ImageView) this.mLoadingView.findViewById(R.id.loading_anim);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_camera_loading);
        this.mLoadingImageView.setImageDrawable(this.mLoadingAnimation);
        this.mErrorRetryView = LayoutInflater.from(this).inflate((int) R.layout.camera_error_retry, (ViewGroup) null);
        this.mVideoLayout.addView(this.mErrorRetryView, layoutParams2);
        this.mErrorRetryView.setVisibility(8);
        this.mRetryView = this.mErrorRetryView.findViewById(R.id.retry_btn);
        this.mErrorInfoView = (TextView) this.mErrorRetryView.findViewById(R.id.error_info);
        this.mPowerOffView = LayoutInflater.from(this).inflate((int) R.layout.camera_closed, (ViewGroup) null);
        this.mVideoLayout.addView(this.mPowerOffView, layoutParams2);
        this.mPowerOffView.setVisibility(8);
        this.mVideoView.setDistort(0.27083334f, 0.04411765f);
        this.mVideoView.setTouch(false);
        this.mVideoView.setMiniScale(true);
        this.mVideoView.initial();
        showLoading();
    }

    public void onDisConnected() {
        super.onDisConnected();
        civ.O00000o(TAG, "onDisConnected  ");
    }

    public void onDisconnectedWithCode(int i) {
        civ.O00000o(TAG, "onDisconnectedWithCode code=".concat(String.valueOf(i)));
    }

    public void pauseCamera() {
        super.pauseCamera();
    }

    public void onBackPressed() {
        this.isTimeLapsePhotography = true;
        String str = TAG;
        civ.O00000o(str, "onBackPressed isTimeLapsePhotography=" + this.isTimeLapsePhotography);
        super.onBackPressed();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    private void timeLapseFinishAnimation() {
        if (this.mCameraDevice == null || this.mCameraDevice.O000000o() == null || !this.mCameraDevice.O000000o().O000000o("power", true)) {
            gqg.O000000o((int) R.string.power_off);
        } else if (this.mCameraPlayerEx == null || !this.mCameraPlayerEx.O00000oO.isConnected()) {
            gqg.O000000o((int) R.string.snap_failed_paused);
        } else {
            this.mVideoView.snap(new XmVideoViewGl.PhotoSnapCallback() {
                /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass11 */

                public void onSnap(Bitmap bitmap) {
                    goq.O000000o(new Runnable(bitmap) {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.$$Lambda$TimeLapsePhotographyActivity$11$hTwrmIrgCw1ALuIsPD1vXQbs8 */
                        private final /* synthetic */ Bitmap f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            TimeLapsePhotographyActivity.AnonymousClass11.this.lambda$onSnap$0$TimeLapsePhotographyActivity$11(this.f$1);
                        }
                    });
                }

                public /* synthetic */ void lambda$onSnap$0$TimeLapsePhotographyActivity$11(Bitmap bitmap) {
                    TimeLapsePhotographyActivity.this.onSnapShot(bitmap);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void onSnapShot(Bitmap bitmap) {
        final String O00000Oo = me.O00000Oo(this.mCameraDevice.getDid(), this.currentTimelapseTask.getTaskID(), this.currentTimelapseTask.getTaskName());
        civ.O00000o(TAG, "延时摄影拍摄完成截图nSnapShot ===".concat(String.valueOf(O00000Oo)));
        this.fl_timelaps_demo.setVisibility(0);
        if (O00000Oo != null && bitmap != null) {
            Bitmap O000000o2 = C0118cif.O000000o(bitmap, this);
            if (O000000o2 != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(O00000Oo);
                    O000000o2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException unused) {
                    return;
                }
            }
            final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(O000000o2, 200, (O000000o2.getHeight() * 200) / O000000o2.getWidth(), false);
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass12 */

                public void run() {
                    if (new File(O00000Oo).exists()) {
                        ImageView imageView = (ImageView) TimeLapsePhotographyActivity.this.findViewById(R.id.ivShotPic);
                        if (TimeLapsePhotographyActivity.this.mLLFuncPopup.getVisibility() == 0) {
                            TimeLapsePhotographyActivity.this.mLLFuncPopup.setVisibility(8);
                        }
                        TimeLapsePhotographyActivity.this.mLLFuncPopup.setLayoutParams((FrameLayout.LayoutParams) TimeLapsePhotographyActivity.this.mLLFuncPopup.getLayoutParams());
                        TimeLapsePhotographyActivity.this.mLLFuncPopup.startAnimation(AnimationUtils.loadAnimation(TimeLapsePhotographyActivity.this, R.anim.anim_snap_shot_in));
                        TimeLapsePhotographyActivity.this.mLLFuncPopup.setVisibility(0);
                        TimeLapsePhotographyActivity.this.dismissSnapshotPopupRunnable(3000);
                        Bitmap bitmap = createScaledBitmap;
                        if (bitmap != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                        imageView.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass12.AnonymousClass1 */

                            public void onClick(View view) {
                                TimeLapsePhotographyActivity.this.dismissSnapshotPopupRunnable(0);
                                Intent intent = new Intent(TimeLapsePhotographyActivity.this, TimelapsePhotographPlayActivity.class);
                                File videoFile = TimeLapsePhotographyActivity.this.currentTimelapseTask.getVideoFile("mp4");
                                if (videoFile != null) {
                                    intent.putExtra("file_path", videoFile.getAbsolutePath());
                                    String str = TimeLapsePhotographyActivity.TAG;
                                    civ.O00000o(str, "onRecyclerClick localFileData.file_path=" + videoFile.getAbsolutePath());
                                }
                                intent.putExtra("file_realtime", TimeLapsePhotographyActivity.this.currentTimelapseTask.getRealStartTimeInSec());
                                intent.putExtra("video_path", TimeLapsePhotographyActivity.this.currentTimelapseTask.getVideoPath(TimeLapsePhotographyActivity.this.mCameraDevice));
                                intent.putExtra("file_time", TimeLapsePhotographyActivity.this.currentTimelapseTask.getStartTimestampInUTCSeconds());
                                Timelapse.timeLapseList.add(TimeLapsePhotographyActivity.this.currentTimelapseTask);
                                TimeLapsePhotographyActivity.this.startActivityForResult(intent, TimeLapsePhotographyActivity.TIMELAPSE_PHOTOGRAPHY);
                            }
                        });
                    }
                }
            });
        }
    }

    public void dismissSnapshotPopupRunnable(long j) {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass13 */

            public void run() {
                if (TimeLapsePhotographyActivity.this.mLLFuncPopup != null && TimeLapsePhotographyActivity.this.mLLFuncPopup.getVisibility() != 8) {
                    TimeLapsePhotographyActivity.this.mLLFuncPopup.startAnimation(AnimationUtils.loadAnimation(TimeLapsePhotographyActivity.this, R.anim.anim_snap_shot_out));
                    TimeLapsePhotographyActivity.this.mLLFuncPopup.setVisibility(8);
                }
            }
        }, j);
    }

    private void loadData(boolean z) {
        civ.O00000o(TAG, "loadData  获取sd卡信息");
        this.mCameraDevice.O0000Oo0().O000000o(new Callback<SDCardInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass14 */

            public void onSuccess(SDCardInfo sDCardInfo) {
                TimeLapsePhotographyActivity timeLapsePhotographyActivity = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity.isMemorycardExists = true;
                timeLapsePhotographyActivity.parseInfo(sDCardInfo);
            }

            public void onFailure(int i, String str) {
                String str2 = TimeLapsePhotographyActivity.TAG;
                civ.O00000o(str2, "sdcarad status fail " + i + " : " + str);
                TimeLapsePhotographyActivity timeLapsePhotographyActivity = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity.isMemorycardExists = false;
                timeLapsePhotographyActivity.errorText = timeLapsePhotographyActivity.getString(R.string.sdcard_error);
                if (i == -2003) {
                    TimeLapsePhotographyActivity timeLapsePhotographyActivity2 = TimeLapsePhotographyActivity.this;
                    timeLapsePhotographyActivity2.errorText = timeLapsePhotographyActivity2.getString(R.string.no_memory_card_found);
                } else if (i == -2000) {
                    TimeLapsePhotographyActivity timeLapsePhotographyActivity3 = TimeLapsePhotographyActivity.this;
                    timeLapsePhotographyActivity3.errorText = timeLapsePhotographyActivity3.getString(R.string.sdcard_formating);
                } else if (i == -2002) {
                    TimeLapsePhotographyActivity timeLapsePhotographyActivity4 = TimeLapsePhotographyActivity.this;
                    timeLapsePhotographyActivity4.errorText = timeLapsePhotographyActivity4.getString(R.string.sdcard_error_unkonw);
                } else if (i == -2005) {
                    TimeLapsePhotographyActivity timeLapsePhotographyActivity5 = TimeLapsePhotographyActivity.this;
                    timeLapsePhotographyActivity5.errorText = timeLapsePhotographyActivity5.getString(R.string.sdcard_error_out);
                } else if (i == -1) {
                    TimeLapsePhotographyActivity timeLapsePhotographyActivity6 = TimeLapsePhotographyActivity.this;
                    timeLapsePhotographyActivity6.errorText = timeLapsePhotographyActivity6.getString(R.string.sdcard_error);
                }
                TimeLapsePhotographyActivity.this.refreshState(false);
            }
        }, z);
    }

    public void parseInfo(SDCardInfo sDCardInfo) {
        civ.O00000o(TAG, "parseInfo info ===".concat(String.valueOf(sDCardInfo)));
        if (sDCardInfo == null) {
            gqg.O000000o(getString(R.string.sdcard_error));
            return;
        }
        if (!this.isShootTask) {
            refreshState(true);
        }
        this.mInfo = sDCardInfo;
        String O000000o2 = me.O000000o(sDCardInfo.O00000Oo);
        String O000000o3 = me.O000000o(sDCardInfo.O00000o0);
        String O000000o4 = me.O000000o(sDCardInfo.O00000o);
        String str = TAG;
        civ.O00000o(str, "info freeSize =" + sDCardInfo.O00000Oo + ",info videoSize=" + sDCardInfo.O00000o0 + ",info otherSize=" + sDCardInfo.O00000o + ",info.mStatus=" + sDCardInfo.O00000oO);
        String str2 = TAG;
        civ.O00000o(str2, "freeSize =" + O000000o2 + ",videoSize=" + O000000o3 + ",otherSize=" + O000000o4 + ",info.mStatus=" + sDCardInfo.O00000oO);
    }

    private void createTimelapseTask() {
        if (this.mInfo.O00000oO == 1) {
            gqg.O000000o(getString(R.string.no_memory_card_found));
        } else if (this.mInfo.O00000oO == 4) {
            gqg.O000000o(getString(R.string.sdcard_formating));
        } else if (this.mInfo.O00000oO == 5) {
            gqg.O000000o(getString(R.string.sdcard_no));
        } else if (this.mInfo.O00000oO == 3) {
            gqg.O000000o(getString(R.string.sdcard_error_timelapse));
        } else if (this.mInfo.O00000Oo < 3145728) {
            gqg.O000000o(getString(R.string.sd_no_space));
        } else {
            String str = TAG;
            civ.O00000o(str, "mac= " + this.mCameraDevice.getMac());
            int O00000o0 = cin.O00000o0();
            long currentTimeMillis = (System.currentTimeMillis() / 1000) + ((long) (O00000o0 * 60));
            this.newTimelapseTask = new TimelapseTask(this.mCameraDevice, currentTimeMillis, currentTimeMillis, currentTimeMillis + ((long) this.shootDurSecond), this.intervalToTakePicture, O00000o0);
            civ.O00000o("AlbumActivity", "newTimelapseTask mac= " + this.newTimelapseTask.getCameraMac());
            civ.O00000o("AlbumActivity", "newTimelapseTask taskId= " + this.newTimelapseTask.getTaskID());
            civ.O00000o("AlbumActivity", "newTimelapseTask startTimestampInSeconds= " + this.newTimelapseTask.getStartTimestampInSeconds());
            civ.O00000o("AlbumActivity", "newTimelapseTask endTimestampInSeconds= " + this.newTimelapseTask.getEndTimestampInSeconds());
            civ.O00000o("AlbumActivity", "newTimelapseTask intervalToTakePicture= " + this.newTimelapseTask.getIntervalToTakePicture());
            civ.O00000o("AlbumActivity", "newTimelapseTask timezoneInMunite= " + this.newTimelapseTask.getTimezoneInMinutes());
            this.isStopAndSave = false;
            this.mTimeLapseTaskManager.setTimeLapseTask(this.newTimelapseTask, this);
        }
    }

    private void scheduledCreateTimelapseTask() {
        long j;
        long j2;
        String str = TAG;
        civ.O00000o(str, "mac= " + this.mCameraDevice.getMac());
        int O00000o0 = cin.O00000o0();
        String str2 = TAG;
        civ.O00000o(str2, "isTomorrow =" + this.isTomorrow + ",开始时间 scheduledShootCalendar.getTimeInMillis()/1000=" + (this.scheduledShootCalendar.getTimeInMillis() / 1000));
        if (this.isTomorrow) {
            j2 = (this.scheduledShootCalendar.getTimeInMillis() / 1000) + ((long) (O00000o0 * 60));
            j = 86400;
        } else {
            j2 = this.scheduledShootCalendar.getTimeInMillis() / 1000;
            j = (long) (O00000o0 * 60);
        }
        long j3 = j2 + j;
        this.newTimelapseTask = new TimelapseTask(this.mCameraDevice, j3, j3, j3 + ((long) this.shootDurSecond), this.intervalToTakePicture, O00000o0);
        this.isStopAndSave = false;
        this.mTimeLapseTaskManager.setTimeLapseTask(this.newTimelapseTask, this);
    }

    public void closeTimelapseTask() {
        this.isStopAndSave = true;
        this.mTimeLapseTaskManager.closeCurrentTimeLapseTask(this);
    }

    public void calcuInterval(int i) {
        this.intervalToTakePicture = ((i * 60) * 60) / 200;
        String str = TAG;
        civ.O00000o(str, "拍摄间隔 intervalToTakePicture=" + this.intervalToTakePicture);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 100) {
            civ.O000000o(TAG, "延时摄影样片下载成功2222");
            judgeDownloadTimeLapseDemo();
        } else if (i == 30000) {
            civ.O00000o(TAG, "保存图片成功");
        } else if (i == 21004) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            String str = TAG;
            civ.O00000o(str, "设置延时摄影的结果taskId=" + i2 + ",result=" + i3 + ",isManualShootFinish=" + this.isManualShootFinish);
            if (i3 == 1) {
                if (this.isManualShootFinish) {
                    timeLapseFinishAnimation();
                    this.tv_timelapse_start.setText(getString(R.string.timelapse_start));
                    this.isManualShootFinish = false;
                } else {
                    this.currentTimelapseTask = this.newTimelapseTask;
                    refreshState();
                    createStartTimeLapse();
                    if (this.isCancleTimeLapse) {
                        this.isScheduledShoot = false;
                        this.isCancleTimeLapse = false;
                    }
                }
                if (this.isStopAndSave) {
                    civ.O00000o(TAG, "停止延时摄影并保存");
                    refreshState(true);
                    this.fl_timelaps_demo.setVisibility(0);
                    try {
                        this.newTimelapseTask.createLocalFolder(true, true, this.mCameraDevice);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        this.newTimelapseTask.reWriteEndtime(System.currentTimeMillis() / 1000);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    civ.O00000o(TAG, "创建新的延时摄影");
                    try {
                        this.newTimelapseTask.createLocalFolder(true, true, this.mCameraDevice);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (i3 == 3) {
                this.fl_timelaps_demo.setVisibility(0);
                gqg.O000000o(getString(R.string.sdcard_available));
                this.isManualShootFinish = false;
                this.iv_shoot_start.setImageResource(R.drawable.icon_timelapse_shoot_finish);
                refreshState(false);
            } else if (i3 == 2) {
                this.fl_timelaps_demo.setVisibility(0);
                gqg.O000000o(getString(R.string.create_timelapse_photography_failed));
                this.isManualShootFinish = false;
                this.iv_shoot_start.setImageResource(R.drawable.icon_timelapse_shoot_finish);
                refreshState(false);
            }
        } else if (i == 21005) {
            String str2 = TAG;
            civ.O00000o(str2, "获取当前延时摄影的状态=" + message.arg1);
            if (message.arg1 == 1) {
                this.currentTimelapseTask = TimelapseTask.getFromProtocol(this.mCameraDevice, (byte[]) message.obj);
                String str3 = TAG;
                civ.O00000o(str3, "newTimelapseTask=" + this.currentTimelapseTask);
                int taskID = this.currentTimelapseTask.getTaskID();
                civ.O00000o(TAG, "taskid = ".concat(String.valueOf(taskID)));
                String str4 = TAG;
                civ.O00000o(str4, "StartTimestampInSeconds = " + this.currentTimelapseTask.getStartTimestampInSeconds());
                String str5 = TAG;
                civ.O00000o(str5, "EndTimestampInSeconds = " + this.currentTimelapseTask.getEndTimestampInSeconds());
                String str6 = TAG;
                civ.O00000o(str6, "IntervalToTakePicture = " + this.currentTimelapseTask.getIntervalToTakePicture());
                String str7 = TAG;
                civ.O00000o(str7, "TimezoneInMinutes = " + this.currentTimelapseTask.getTimezoneInMinutes());
                String str8 = TAG;
                civ.O00000o(str8, "currentSecond = " + currentSecond());
                if (taskID > 0) {
                    this.isShootTask = true;
                    if (this.currentTimelapseTask.getStartTimestampInSeconds() <= currentSecond()) {
                        civ.O00000o(TAG, "已经开始了任务");
                        setTimelapseIsRecordingUI();
                    } else {
                        civ.O00000o(TAG, "延时任务将要拍摄");
                        setTimelapseIsNotRecording();
                        refreshState(false);
                    }
                    this.fl_timelaps_demo.setVisibility(8);
                    return;
                }
                this.isShootTask = false;
                this.fl_timelaps_demo.setVisibility(0);
            }
        }
    }

    private void refreshState() {
        String str = TAG;
        civ.O00000o(str, "refreshState  将于什么时候停止 拍摄currentHour=" + this.currentHour);
        if (!this.isScheduledShoot) {
            TextView textView = this.tv_timelapse_start;
            Resources resources = getResources();
            int i = this.currentHour;
            textView.setText(getString(R.string.finish_desc, new Object[]{resources.getQuantityString(R.plurals.automation_hour, i, Integer.valueOf(i)), ""}));
        }
    }

    private int hourToInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("0") || str.length() <= 1) {
            return Integer.parseInt(str);
        }
        String substring = str.substring(1);
        civ.O00000o(TAG, "newHour=".concat(String.valueOf(substring)));
        return Integer.parseInt(substring);
    }

    private int minToInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("0") && str.length() > 1) {
            civ.O00000o(TAG, "newMin=".concat(String.valueOf(str.substring(1))));
        }
        return Integer.parseInt(str);
    }

    private void scheduldShootDialog(String str) {
        new ScheduldShootDialog.Builder(this, true).setTitle(str).setConfirmListener(new ScheduldShootDialog.ConfirmListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass15 */

            public void onConfirm(ScheduldShootDialog scheduldShootDialog) {
                String str = TimeLapsePhotographyActivity.TAG;
                civ.O00000o(str, "scheduldShootDialog===" + TimeLapsePhotographyActivity.this.isScheduledShoot);
                if (TimeLapsePhotographyActivity.this.isScheduledShoot) {
                    TimeLapsePhotographyActivity.this.closeTimelapseTask();
                    TimeLapsePhotographyActivity.this.tv_timelapse_start.setText(TimeLapsePhotographyActivity.this.getString(R.string.timelapse_start));
                    TimeLapsePhotographyActivity timeLapsePhotographyActivity = TimeLapsePhotographyActivity.this;
                    timeLapsePhotographyActivity.isManualShootFinish = false;
                    timeLapsePhotographyActivity.isCancleTimeLapse = true;
                    return;
                }
                TimeLapsePhotographyActivity timeLapsePhotographyActivity2 = TimeLapsePhotographyActivity.this;
                timeLapsePhotographyActivity2.isManualShootFinish = true;
                timeLapsePhotographyActivity2.iv_shoot_start.setImageResource(R.drawable.icon_timelapse_shoot_start);
                TimeLapsePhotographyActivity.this.refreshState(true);
                TimeLapsePhotographyActivity.this.closeTimelapseTask();
            }
        }).build().show();
    }

    private void createStartTimeLapse() {
        this.mVideoView.snap(new XmVideoViewGl.PhotoSnapCallback() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.$$Lambda$TimeLapsePhotographyActivity$2LYjoHzUf_UTOPlgFUj0KYRkuGo */

            public final void onSnap(Bitmap bitmap) {
                TimeLapsePhotographyActivity.this.lambda$createStartTimeLapse$1$TimeLapsePhotographyActivity(bitmap);
            }
        });
    }

    public /* synthetic */ void lambda$createStartTimeLapse$1$TimeLapsePhotographyActivity(Bitmap bitmap) {
        runOnUiThread(new Runnable(bitmap) {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.$$Lambda$TimeLapsePhotographyActivity$6iNkIPi9bL3UDB2jTXV46XYerGY */
            private final /* synthetic */ Bitmap f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                TimeLapsePhotographyActivity.this.lambda$null$0$TimeLapsePhotographyActivity(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onSnapShotTimeLapse */
    public void lambda$null$0$TimeLapsePhotographyActivity(Bitmap bitmap) {
        Bitmap O000000o2;
        if (this.currentTimelapseTask != null) {
            String O00000Oo = me.O00000Oo(this.mCameraDevice.getDid(), this.currentTimelapseTask.getTaskID(), this.currentTimelapseTask.getTaskName());
            civ.O00000o(TAG, "延时摄影创建成功截图 onSnapShotTimeLapse ===".concat(String.valueOf(O00000Oo)));
            if (O00000Oo != null && bitmap != null && (O000000o2 = C0118cif.O000000o(bitmap, this)) != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(O00000Oo);
                    O000000o2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public int currentSecond() {
        return (int) ((System.currentTimeMillis() / 1000) + ((long) (this.currentTimelapseTask.getTimezoneInMinutes() * 60)));
    }

    private void setTimelapseIsRecordingUI() {
        this.iv_shoot_start.setImageResource(R.drawable.icon_timelapse_shoot_finish);
        refreshState(false);
        this.isStartShoot = true;
        int endTimestampInSeconds = this.currentTimelapseTask.getEndTimestampInSeconds() - currentSecond();
        int i = endTimestampInSeconds / 3600;
        int i2 = (endTimestampInSeconds - (i * 3600)) / 60;
        String str = TAG;
        civ.O00000o(str, "setTimelapseIsRecordingUI minute==" + i2 + ",hour=" + i + ",diff=" + endTimestampInSeconds);
        this.tv_timelapse_start.setText(getString(R.string.finish_desc, new Object[]{getResources().getQuantityString(R.plurals.automation_hour, i, Integer.valueOf(i)), getResources().getQuantityString(R.plurals.automation_minute, i2, Integer.valueOf(i2))}));
    }

    private void setTimelapseIsNotRecording() {
        this.iv_shoot_start.setImageResource(R.drawable.icon_timelapse_shoot_start);
        int startTimestampInSeconds = this.currentTimelapseTask.getStartTimestampInSeconds() - currentSecond();
        int i = startTimestampInSeconds / 3600;
        int i2 = (startTimestampInSeconds - (i * 3600)) / 60;
        String str = TAG;
        civ.O00000o(str, "setTimelapseIsNotRecording minute==" + i2 + ",hour=" + i + ",diff=" + startTimestampInSeconds);
        this.isScheduledShoot = true;
        this.isStartShoot = true;
        this.tv_timelapse_start.setText(getString(R.string.after_desc, new Object[]{getResources().getQuantityString(R.plurals.automation_hour, i, Integer.valueOf(i)), getResources().getQuantityString(R.plurals.automation_minute, i2, Integer.valueOf(i2))}));
    }

    public void scheduledTimeLapsePhotography(String str, String str2, String str3) {
        this.isScheduledShoot = true;
        this.startTimeHour = str;
        this.startTimeMin = str2;
        this.startTimeDay = str3;
        this.scheduledHour = hourToInt(str);
        this.scheduledMine = minToInt(str2);
        String str4 = TAG;
        civ.O00000o(str4, "intHour=" + this.scheduledHour + ",intMin=" + this.scheduledMine);
        if (getString(R.string.sleep_auto_times_today).equals(str3)) {
            this.isTomorrow = false;
        } else {
            this.isTomorrow = true;
        }
        this.scheduledShootCalendar.set(11, this.scheduledHour);
        this.scheduledShootCalendar.set(12, this.scheduledMine);
        this.currentCalendar.setTimeInMillis(System.currentTimeMillis());
        int i = this.currentCalendar.get(11);
        int i2 = this.currentCalendar.get(12);
        String str5 = TAG;
        civ.O00000o(str5, "当前的小时 currentHour=" + i + ",当前分钟currentMinute=" + i2);
        if (this.isTomorrow) {
            int i3 = (((this.scheduledHour * 60) + this.scheduledMine) + 1440) - ((i * 60) + i2);
            civ.O00000o(TAG, "明天 diff==".concat(String.valueOf(i3)));
            this.diffHour = i3 / 60;
            this.diffMin = i3 - (this.diffHour * 60);
        } else {
            int i4 = ((this.scheduledHour * 60) + this.scheduledMine) - ((i * 60) + i2);
            civ.O00000o(TAG, "今天 diff==".concat(String.valueOf(i4)));
            this.diffHour = i4 / 60;
            this.diffMin = i4 - (this.diffHour * 60);
        }
        if (this.diffHour < 0 || this.diffMin < 0) {
            gqg.O000000o(getString(R.string.timelapse_shoot_tip));
            return;
        }
        TextView textView = this.tv_timelapse_start;
        Resources resources = getResources();
        int i5 = this.diffHour;
        Object[] objArr = {Integer.valueOf(i5)};
        Resources resources2 = getResources();
        int i6 = this.diffMin;
        textView.setText(getString(R.string.after_desc, new Object[]{resources.getQuantityString(R.plurals.automation_hour, i5, objArr), resources2.getQuantityString(R.plurals.automation_minute, i6, Integer.valueOf(i6))}));
        scheduledCreateTimelapseTask();
        this.isManualShootFinish = false;
        this.isStartShoot = true;
        refreshState(false);
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        if (this.isClickAlbum) {
            this.isTimeLapsePhotography = false;
        } else {
            this.isTimeLapsePhotography = true;
        }
        this.isClickAlbum = false;
        this.mLLFuncPopup.setVisibility(8);
        super.onStop();
    }

    public void onConnected() {
        super.onConnected();
        civ.O00000o(TAG, "onConnected  。。。。");
        if (this.mPauseView != null && this.mPauseView.getVisibility() == 0) {
            this.mPauseView.setVisibility(8);
        }
        this.iv_shoot_start.setEnabled(true);
        this.iv_shoot_start.setAlpha(1.0f);
        if (this.mCameraPlayerEx != null) {
            civ.O00000o(TAG, "连接摄像头成功,开始发送查询当前延时摄影状态信息");
            this.mCameraPlayerEx.O000000o(true);
            this.mCameraPlayerEx.O0000Oo();
            this.mCameraPlayerEx.O0000Oo0();
            this.mTimeLapseTaskManager.getTimeLapseTask(this);
        }
    }

    public void onVideoPlayError(int i, String str) {
        super.onVideoPlayError(i, str);
        civ.O00000o(TAG, "摄像机连接失败");
        refreshState(false);
    }

    public void toggleRemoteAV(boolean z, boolean z2) {
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O00000o0(z);
            this.mCameraPlayerEx.O00000o(z2);
        }
    }

    public JSONArray listToArray(int i) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mode", i);
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    public void setTimeLapseMode(int i) {
        civ.O00000o(TAG, "setTimeLapseMode = ".concat(String.valueOf(i)));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("timeLapseMode", listToArray(i).toString());
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("settings", jSONObject2);
            String str = TAG;
            civ.O00000o(str, "jsonObject=" + jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "/device/setsetting", jSONObject, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass16 */

            public void onSuccess(JSONObject jSONObject) {
                String str = TimeLapsePhotographyActivity.TAG;
                civ.O00000o(str, "setTimeLapseMode onSuccess=" + jSONObject.toString());
            }

            public void onFailure(int i, String str) {
                String str2 = TimeLapsePhotographyActivity.TAG;
                civ.O00000o(str2, "setTimeLapseMode onFailure i=" + i + ",s=" + str);
            }
        }, Parser.DEFAULT_PARSER);
    }

    private void getTimeLapseMode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.mCameraDevice.getDid());
            XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "/device/getsetting", jSONObject, new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity.AnonymousClass17 */

                public void onSuccess(JSONObject jSONObject) {
                    String str = TimeLapsePhotographyActivity.TAG;
                    civ.O00000o(str, "getTimeLapseMode onSuccess=" + jSONObject.toString());
                    if (jSONObject != null) {
                        try {
                            String str2 = (String) jSONObject.opt("timeLapseMode");
                            if (!TextUtils.isEmpty(str2)) {
                                civ.O00000o(TimeLapsePhotographyActivity.TAG, "getTimeLapseMode onSuccess json =".concat(String.valueOf(str2)));
                                JSONArray jSONArray = new JSONArray(str2);
                                String str3 = TimeLapsePhotographyActivity.TAG;
                                civ.O00000o(str3, "getTimeLapseMode onSuccess jsonArray=" + jSONArray.length());
                                if (jSONArray.length() > 0) {
                                    int optInt = jSONArray.getJSONObject(0).optInt("mode");
                                    civ.O00000o(TimeLapsePhotographyActivity.TAG, "getTimeLapseMode onSuccess mode=".concat(String.valueOf(optInt)));
                                    TimeLapsePhotographyActivity.this.refresh(optInt);
                                    return;
                                }
                                TimeLapsePhotographyActivity.this.mTvShootingMode.setCurrentState(2);
                                TimeLapsePhotographyActivity.this.tv_mode_hour.setText(TimeLapsePhotographyActivity.this.getText(R.string.timelapse_shoot_fives_hour_desc));
                                TimeLapsePhotographyActivity.this.calcuInterval(5);
                                TimeLapsePhotographyActivity.this.currentHour = 5;
                                TimeLapsePhotographyActivity.this.setTimeLapseMode(2);
                                return;
                            }
                            TimeLapsePhotographyActivity.this.mTvShootingMode.setCurrentState(2);
                            TimeLapsePhotographyActivity.this.tv_mode_hour.setText(TimeLapsePhotographyActivity.this.getText(R.string.timelapse_shoot_fives_hour_desc));
                            TimeLapsePhotographyActivity.this.calcuInterval(5);
                            TimeLapsePhotographyActivity.this.currentHour = 5;
                            TimeLapsePhotographyActivity.this.setTimeLapseMode(2);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            civ.O00000o(TimeLapsePhotographyActivity.TAG, "获取数据异常");
                        }
                    }
                    TimeLapsePhotographyActivity.this.mTvShootingMode.setCurrentState(2);
                    TimeLapsePhotographyActivity.this.tv_mode_hour.setText(TimeLapsePhotographyActivity.this.getText(R.string.timelapse_shoot_fives_hour_desc));
                    TimeLapsePhotographyActivity.this.calcuInterval(5);
                    TimeLapsePhotographyActivity timeLapsePhotographyActivity = TimeLapsePhotographyActivity.this;
                    timeLapsePhotographyActivity.currentHour = 5;
                    timeLapsePhotographyActivity.setTimeLapseMode(2);
                }

                public void onFailure(int i, String str) {
                    String str2 = TimeLapsePhotographyActivity.TAG;
                    civ.O00000o(str2, "getTimeLapseMode onFailure i=" + i + ",s=" + str);
                    TimeLapsePhotographyActivity.this.mTvShootingMode.setCurrentState(2);
                    TimeLapsePhotographyActivity.this.tv_mode_hour.setText(TimeLapsePhotographyActivity.this.getText(R.string.timelapse_shoot_fives_hour_desc));
                    TimeLapsePhotographyActivity.this.calcuInterval(5);
                    TimeLapsePhotographyActivity timeLapsePhotographyActivity = TimeLapsePhotographyActivity.this;
                    timeLapsePhotographyActivity.currentHour = 5;
                    timeLapsePhotographyActivity.setTimeLapseMode(2);
                }
            }, Parser.DEFAULT_PARSER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mCameraPlayerEx != null) {
            this.mCameraPlayerEx.O0000O0o();
            this.mCameraPlayerEx = null;
        }
        this.mCameraPlayerEx = new chw(this, this.mCameraDevice, this, this.mVideoView);
        getTimeLapseMode();
        startPlay();
    }

    public void refresh(int i) {
        civ.O00000o(TAG, "refresh mode=".concat(String.valueOf(i)));
        if (i == 0) {
            this.shootDurSecond = 3600;
            calcuInterval(1);
            this.currentHour = 1;
            this.mTvShootingMode.setCurrentState(0);
            this.tv_mode_hour.setText(getText(R.string.timelapse_shoot_one_hour_desc));
            setTimeLapseMode(0);
        } else if (i == 1) {
            this.shootDurSecond = 10800;
            calcuInterval(3);
            this.currentHour = 3;
            this.mTvShootingMode.setCurrentState(1);
            this.tv_mode_hour.setText(getText(R.string.timelapse_shoot_three_hour_desc));
            setTimeLapseMode(1);
        } else if (i == 2) {
            this.shootDurSecond = 18000;
            calcuInterval(5);
            this.currentHour = 5;
            this.mTvShootingMode.setCurrentState(2);
            this.tv_mode_hour.setText(getText(R.string.timelapse_shoot_fives_hour_desc));
            setTimeLapseMode(2);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == TIMELAPSE_PHOTOGRAPHY) {
            civ.O00000o(TAG, "onActivityResult ......startPlay");
        }
    }

    public void onSendCmdError() {
        civ.O00000o(TAG, "onSendCmdError");
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.$$Lambda$TimeLapsePhotographyActivity$_RK29RPSZvZJO4E1ls2EKk1dgo */

            public final void run() {
                TimeLapsePhotographyActivity.this.lambda$onSendCmdError$2$TimeLapsePhotographyActivity();
            }
        });
    }

    public /* synthetic */ void lambda$onSendCmdError$2$TimeLapsePhotographyActivity() {
        this.isStartShoot = false;
        refreshState(false);
        this.iv_shoot_start.setImageResource(R.drawable.icon_timelapse_shoot_start);
    }

    private void judgeDownloadTimeLapseDemo() {
        File file = new File(getDownloadFilePath());
        String str = TAG;
        civ.O000000o(str, "judgeDownloadTimeLapseDemo file=" + file.getAbsolutePath());
        if (!file.exists()) {
            civ.O00000o(TAG, "不存在开始下载");
            DownLoadTimeLapseDemo.getInstance(this, this.mCameraDevice.getDid(), this.mHandler).downLoadFile();
            return;
        }
        civ.O00000o(TAG, "存在开始显示");
        vh vhVar = new vh();
        vhVar.O00000oO = this.iv_timelaps_demo.getDrawable();
        vh vhVar2 = vhVar;
        vhVar2.O00000o0 = this.iv_timelaps_demo.getDrawable();
        up O000000o2 = uo.O000000o((FragmentActivity) this).O000000o();
        O000000o2.f2542O000000o = file.getAbsolutePath();
        O000000o2.O00000Oo((vh) vhVar2.O000000o(uv.O00000Oo)).O000000o(this.iv_timelaps_demo);
    }

    private String getDownloadFilePath() {
        String O000000o2 = me.O000000o();
        if (TextUtils.isEmpty(O000000o2)) {
            return O000000o2;
        }
        File file = new File(O000000o2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return O000000o2 + File.separator + "timelaps_demo.gif";
    }
}
