package com.xiaomi.smarthome.camera.activity.alarm2;

import _m_j.cb;
import _m_j.chr;
import _m_j.ckb;
import _m_j.ckv;
import _m_j.fno;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hyy;
import _m_j.hzf;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.generalplayer.videoview.BasicVideoView;
import com.mijia.generalplayer.videoview.GeneralVideoView;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.alarmcloud.FaceInfoMeta;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter2;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventOperationListAdapter;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.view.calendar.DateUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoUtils;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import com.xiaomi.smarthome.miio.camera.face.widget.ButtonAdaptiveDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;

public class AlarmVideoPlayerActivityNew extends BaseAlarmVideoPlayerActivity implements View.OnClickListener, AlarmEventListAdapter2.OnItemClickLister, AlarmEventOperationListAdapter.OnItemClickLister {
    public String fileId;
    private FrameLayout flTitleBar;
    private GeneralVideoView generalVideoView;
    private boolean isAlarm;
    public AlarmEventListAdapter2 mAlarmEventListAdapter;
    CloudVideoDownloadManager.ICloudVideoDownloadListener mCloudVideoDownloadListener = new CloudVideoDownloadManager.ICloudVideoDownloadListener() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass1 */

        public void onInfo(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
        }

        public void onM3U8ToMp4Finish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        }

        public void onProgress(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
        }

        public void onSpeed(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
        }

        public void onStart(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        }

        public void onStop(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
        }

        public void onFinish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            gsy.O00000Oo("AlarmVideoPlayerActivityNew", "onFinish " + cloudVideoDownloadInfo.m3u8LocalPath);
            if (cloudVideoDownloadInfo.fileId.equals(AlarmVideoPlayerActivityNew.this.fileId)) {
                gqg.O00000Oo((int) R.string.save_success);
            }
        }

        public void onCancelled(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            gqg.O00000Oo((int) R.string.save_fail);
        }

        public void onError(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
            gqg.O00000Oo((int) R.string.save_fail);
        }
    };
    public long mCreateTime;
    private RecyclerView mRecyclerView;
    private SimpleDateFormat mTimeFormat;
    private int needPinCode = 0;
    public boolean needRefresh;
    private int offset;
    private String shareNames = "";
    public double startDuration;
    private ImageView title_bar_more;
    private TextView tvDownloadHint;
    private TextView tvFeedback;
    private ViewGroup videoViewParent;

    static /* synthetic */ void lambda$showDeleteVideoDialog$4(DialogInterface dialogInterface) {
    }

    static /* synthetic */ void lambda$showDeleteVideoDialog$5(DialogInterface dialogInterface, int i) {
    }

    public boolean supportOrientationListen() {
        return true;
    }

    public void touchPosition(AlarmVideo alarmVideo, int i, String str, String str2) {
    }

    public void doCreate(Bundle bundle) {
        chr.O000000o(chr.O000ooo0);
        gwg.O00000o0(this);
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_video_player_general_new);
        Intent intent = getIntent();
        this.shareNames = intent.getStringExtra("Alarm_SN");
        this.fileId = intent.getStringExtra("fileId");
        this.isAlarm = intent.getBooleanExtra("isAlarm", false);
        this.mCreateTime = intent.getLongExtra("createTime", 0);
        this.offset = intent.getIntExtra("offset", 0);
        this.startDuration = intent.getDoubleExtra("startDuration", 0.0d);
        boolean booleanExtra = intent.getBooleanExtra("skipPwd", false);
        if (!getIntent().getBooleanExtra("pincod", false) && !booleanExtra) {
            this.needPinCode++;
            globalPinCodeVerifyFunc();
        }
        gsy.O00000Oo("AlarmVideoPlayerActivityNew", "fileId = " + this.fileId + " createTime = " + this.mCreateTime + " startDuration = " + this.startDuration + " isAlarm = " + this.isAlarm);
        initPlayer();
        initView();
        initRecyclerView();
        getVideoUrl();
        this.generalVideoView.getIvBack2().setVisibility(0);
        this.generalVideoView.getIvBack2().setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        chr.O00000o0();
        int i = this.needPinCode;
        if (i >= 0) {
            this.needPinCode = i - 1;
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$2DYAk1Jad_Aij0iw5C4d7FnUT24 */

                public final void run() {
                    AlarmVideoPlayerActivityNew.this.getEventList();
                }
            }, 250);
        }
        CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).addListener(this.mCloudVideoDownloadListener);
    }

    public void onPause() {
        super.onPause();
        chr.O00000o();
        CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).removeListener(this.mCloudVideoDownloadListener);
    }

    private void initView() {
        long currentDayTS0 = CloudVideoUtils.getCurrentDayTS0();
        TextView textView = (TextView) findViewById(R.id.tv_day);
        long j = this.mCreateTime;
        if (j + 1 <= currentDayTS0 || j + 1 >= currentDayTS0 + AlarmVideoActivityNew.ONE_DAY) {
            textView.setText(DateUtils.getMonthDay(this.mCreateTime + 1));
        } else {
            textView.setText(String.format("%s %s", DateUtils.getMonthDay(this.mCreateTime + 1), getString(R.string.today)));
        }
        this.flTitleBar = (FrameLayout) findViewById(R.id.title_bar);
        ((TextView) findViewById(R.id.title_bar_title)).setText(getString(R.string.housekeeping));
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        this.title_bar_more.setImageResource(R.drawable.mj_webp_titlebar_setting_nor);
        this.title_bar_more.setOnClickListener(this);
        this.title_bar_more.setVisibility(0);
        boolean booleanExtra = getIntent().getBooleanExtra("isFromRn", false);
        if (this.mCameraDevice.isReadOnlyShared() || booleanExtra) {
            this.title_bar_more.setVisibility(8);
        }
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.tvFeedback = (TextView) findViewById(R.id.tv_feedback);
        this.tvFeedback.getPaint().setFlags(8);
        this.tvFeedback.getPaint().setAntiAlias(true);
        this.tvFeedback.setOnClickListener(this);
        this.tvDownloadHint = (TextView) findViewById(R.id.tvDownloadHint);
        this.tvDownloadHint.setOnClickListener(this);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    private void initPlayer() {
        this.videoViewParent = (ViewGroup) findViewById(R.id.videoViewParent);
        if (!hyy.O000000o(getIntent())) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.videoViewParent);
        }
        this.generalVideoView = new GeneralVideoView(this);
        if (!TextUtils.isEmpty(this.shareNames)) {
            cb.O000000o(this.generalVideoView, this.shareNames);
        }
        this.videoViewParent.addView(this.generalVideoView);
        this.generalVideoView.O000000o(this.mCameraDevice.getModel(), this.mCameraDevice.getDid());
        this.generalVideoView.setOnConfigurationChangedListener(new BasicVideoView.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivityNew$gZ1TRtN69PVer75NrdY4Wm2Ekm0 */

            public final void onChangeOrientation(boolean z) {
                AlarmVideoPlayerActivityNew.this.lambda$initPlayer$0$AlarmVideoPlayerActivityNew(z);
            }
        });
        int[] iArr = null;
        if (!this.mCameraDevice.isReadOnlyShared()) {
            iArr = new int[]{ckv.camera_ic_player_snapshot, ckv.camera_ic_player_download, ckv.camera_ic_player_delete};
        }
        this.generalVideoView.O000000o(iArr, new ckv.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivityNew$oLxv_IusrB59Xa1sg_ajMTNSioc */

            public final void onActionClick(int i) {
                AlarmVideoPlayerActivityNew.this.lambda$initPlayer$1$AlarmVideoPlayerActivityNew(i);
            }
        });
        this.generalVideoView.setPlayerListener(new ckb.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass2 */

            public void onPlaySchedule(long j) {
                AlarmVideoPlayerActivityNew.this.mAlarmEventListAdapter.parseProgress(j);
            }
        });
    }

    public /* synthetic */ void lambda$initPlayer$0$AlarmVideoPlayerActivityNew(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.videoViewParent.getLayoutParams();
        int i = -1;
        layoutParams.width = -1;
        if (z) {
            i = -2;
        }
        layoutParams.height = i;
        this.videoViewParent.setLayoutParams(layoutParams);
    }

    public /* synthetic */ void lambda$initPlayer$1$AlarmVideoPlayerActivityNew(int i) {
        if (i == ckv.camera_ic_player_snapshot) {
            if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                gqg.O000000o((int) R.string.no_write_permission);
                return;
            }
            this.generalVideoView.O000000o(new Intent(this, LocalPicActivity.class));
        } else if (i == ckv.camera_ic_player_download) {
            downloadHint();
        } else if (i == ckv.camera_ic_player_delete) {
            showDeleteVideoDialog();
            chr.O000000o("u5v.u1o.4k5.xs8");
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setWindowConfiguration(configuration);
        GeneralVideoView generalVideoView2 = this.generalVideoView;
        if (generalVideoView2 != null) {
            generalVideoView2.O000000o(configuration);
        }
        if (!this.mFullScreen) {
            GeneralVideoView generalVideoView3 = this.generalVideoView;
            if (generalVideoView3 != null) {
                generalVideoView3.getIvBack2().setVisibility(0);
            }
            if (!hyy.O000000o(getIntent())) {
                gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.videoViewParent);
            }
            gwg.O00000o0(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.videoViewParent.getLayoutParams();
            layoutParams.height = -2;
            this.videoViewParent.setLayoutParams(layoutParams);
            return;
        }
        GeneralVideoView generalVideoView4 = this.generalVideoView;
        if (generalVideoView4 != null) {
            generalVideoView4.getIvBack2().setVisibility(8);
        }
        if (!hyy.O000000o(getIntent())) {
            gwg.O000000o(0, this.videoViewParent);
        }
        hideStatusBar();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.videoViewParent.getLayoutParams();
        layoutParams2.height = -1;
        this.videoViewParent.setLayoutParams(layoutParams2);
    }

    private void initRecyclerView() {
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mAlarmEventListAdapter = new AlarmEventListAdapter2(this, this.mCameraDevice);
        this.mRecyclerView.setAdapter(this.mAlarmEventListAdapter);
        this.mAlarmEventListAdapter.setOnItemClickLister(this);
        this.mAlarmEventListAdapter.setShareUser(this.mCameraDevice.isShared() || this.mCameraDevice.isReadOnlyShared());
        this.event_operation_rv = (RecyclerView) findViewById(R.id.event_operation_rv);
        this.event_operation_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mAlarmEventOperationListAdapter = new AlarmEventOperationListAdapter(this, this.mCameraDevice);
        this.mAlarmEventOperationListAdapter.setOnItemClickLister(this);
        this.event_operation_rv.setAdapter(this.mAlarmEventOperationListAdapter);
    }

    private void getVideoUrl() {
        String videoFileUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(this.mCameraDevice.getDid(), this.fileId, this.isAlarm);
        gsy.O00000Oo("AlarmVideoPlayerActivityNew", "videoUrl = ".concat(String.valueOf(videoFileUrl)));
        HashMap hashMap = new HashMap();
        MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
        if (tokenInfo != null) {
            hashMap.put("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0);
            this.generalVideoView.O000000o(videoFileUrl, hashMap, (long) (this.startDuration * 1000.0d));
        }
    }

    public void getEventList() {
        this.mCameraDevice.O00000oo().getEventListByFileId(this.fileId, this.isAlarm, new Callback<ArrayList<AlarmVideo>>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass3 */

            public void onFailure(int i, String str) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
            }

            public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                Collections.sort(arrayList, $$Lambda$AlarmVideoPlayerActivityNew$3$0KUyXZMRrgwenViDtSzm_1QMqV8.INSTANCE);
                if (arrayList != null && arrayList.size() > 0) {
                    AlarmVideoPlayerActivityNew.this.mCreateTime = arrayList.get(0).createTime;
                    AlarmVideoPlayerActivityNew.this.mAlarmEventListAdapter.setData(arrayList);
                    if (AlarmVideoPlayerActivityNew.this.startDuration > 0.0d) {
                        AlarmVideoPlayerActivityNew.this.mAlarmEventListAdapter.parseProgress((long) (AlarmVideoPlayerActivityNew.this.startDuration * 1000.0d));
                    }
                    Iterator<AlarmVideo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        AlarmVideo next = it.next();
                        if (Math.abs(AlarmVideoPlayerActivityNew.this.startDuration - next.startDuration) < 0.1d) {
                            AlarmVideoPlayerActivityNew.this.setFeedbackData(next);
                        }
                    }
                }
            }

            static /* synthetic */ int lambda$onSuccess$0(AlarmVideo alarmVideo, AlarmVideo alarmVideo2) {
                if (alarmVideo.createTime > alarmVideo2.createTime) {
                    return 1;
                }
                return alarmVideo.createTime < alarmVideo2.createTime ? -1 : 0;
            }
        });
    }

    private void downloadHint() {
        chr.O000000o(chr.O000oooO);
        if (CloudVideoNetUtils.getInstance().isWifiConnected(this)) {
            doDownload();
        } else {
            new ButtonAdaptiveDialog.Builder(this).setTitle(getString(R.string.cs_non_wifi_environment)).setConfirmText(getString(R.string.action_continue), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass5 */

                public void onClick(View view) {
                    AlarmVideoPlayerActivityNew.this.doDownload();
                }
            }).setCancle(getString(R.string.cs_cancel), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass4 */

                public void onClick(View view) {
                }
            }).build().show();
        }
    }

    private void showDownloadActivityHint() {
        this.tvDownloadHint.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivityNew$dZSRQtqGKYUkwmOBClmyr3M8RM */

            public final void run() {
                AlarmVideoPlayerActivityNew.this.lambda$showDownloadActivityHint$2$AlarmVideoPlayerActivityNew();
            }
        }, 5000);
    }

    public /* synthetic */ void lambda$showDownloadActivityHint$2$AlarmVideoPlayerActivityNew() {
        TextView textView = this.tvDownloadHint;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void doDownload() {
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
            return;
        }
        long O00000o = this.generalVideoView.getPlayer().O00000o();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Device O000000o2 = fno.O000000o().O000000o(this.mCameraDevice.getDid());
        if (O000000o2 != null) {
            ArrayList arrayList = new ArrayList();
            CloudVideoDownloadInfo cloudVideoDownloadInfo = new CloudVideoDownloadInfo();
            cloudVideoDownloadInfo.uid = O000000o2.userId;
            cloudVideoDownloadInfo.did = this.mCameraDevice.getDid();
            cloudVideoDownloadInfo.title = this.mCameraDevice.getName();
            cloudVideoDownloadInfo.videoUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(this.mCameraDevice.getDid(), this.fileId, this.isAlarm);
            cloudVideoDownloadInfo.fileId = this.fileId;
            cloudVideoDownloadInfo.mp4FilePath = null;
            cloudVideoDownloadInfo.m3u8FilePath = null;
            cloudVideoDownloadInfo.status = 4;
            cloudVideoDownloadInfo.createTime = System.currentTimeMillis();
            long j = this.mCreateTime;
            cloudVideoDownloadInfo.startTime = j;
            cloudVideoDownloadInfo.endTime = j + O00000o;
            cloudVideoDownloadInfo.duration = O00000o / 1000;
            cloudVideoDownloadInfo.createTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.createTime));
            cloudVideoDownloadInfo.startTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.startTime));
            cloudVideoDownloadInfo.endTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.endTime));
            cloudVideoDownloadInfo.size = 0;
            cloudVideoDownloadInfo.progress = 0;
            cloudVideoDownloadInfo.isAlarm = this.isAlarm;
            arrayList.add(cloudVideoDownloadInfo);
            if (arrayList.size() != 1 || !CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).isExistsVideo(this.mCameraDevice.getModel(), (CloudVideoDownloadInfo) arrayList.get(0))) {
                showDownloadActivityHint();
                CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).insertRecords(arrayList);
                CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).pullDownloadFromList(getContext(), O000000o2.userId, this.mCameraDevice.getDid());
                return;
            }
            gqg.O00000Oo((int) R.string.cloud_mp4_download_exists);
        }
    }

    private void showDeleteVideoDialog() {
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_delete_video)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivityNew$CoIURxnkcAgOtd1bMSStKyoA2wc */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmVideoPlayerActivityNew.this.lambda$showDeleteVideoDialog$3$AlarmVideoPlayerActivityNew(dialogInterface, i);
            }
        }).O000000o($$Lambda$AlarmVideoPlayerActivityNew$0H1rLqSNqvw_vtdbxHL2xNFK3vs.INSTANCE).O00000Oo((int) R.string.camera_cancel, $$Lambda$AlarmVideoPlayerActivityNew$hbYTbkHncWzBVPvb0m95Nlbqi2c.INSTANCE).O00000oo();
    }

    public /* synthetic */ void lambda$showDeleteVideoDialog$3$AlarmVideoPlayerActivityNew(DialogInterface dialogInterface, int i) {
        this.mCameraDevice.O00000oo().deleteFiles(new Callback() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass6 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Object obj) {
                AlarmVideoPlayerActivityNew.this.setResult(-1);
                AlarmVideoPlayerActivityNew.this.finish();
            }
        }, this.isAlarm, this.fileId);
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(null);
            return;
        }
        if (this.needRefresh) {
            setResult(-1);
        }
        super.onBackPressed();
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
    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return || view.getId() == R.id.ivBack2) {
            onBackPressed();
        } else if (view.getId() == R.id.title_bar_more) {
            startActivity(new Intent(this, AlarmSettingV2Activity.class));
            chr.O000000o(chr.O00O00Oo);
        } else if (view.getId() == R.id.tvDownloadHint) {
            this.tvDownloadHint.setVisibility(8);
            if (DeviceConstant.isSupportCloudMp4Download(this.mCameraDevice.getModel())) {
                Intent intent = new Intent(this, AlbumActivity.class);
                intent.putExtra("extra_device_did", this.mCameraDevice.getDid());
                intent.putExtra("extra_device_model", this.mCameraDevice.getModel());
                intent.putExtra("is_v4", true);
                intent.putExtra("did", this.mCameraDevice.getDid());
                intent.putExtra("uid", this.mDeviceStat.userId);
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this, CloudVideoDownloadActivity.class);
            intent2.putExtra("did", this.mCameraDevice.getDid());
            intent2.putExtra("title", this.mCameraDevice.getName());
            Device O000000o2 = fno.O000000o().O000000o(this.mCameraDevice.getDid());
            if (O000000o2 != null) {
                intent2.putExtra("uid", O000000o2.userId);
                startActivity(intent2);
            }
        }
    }

    public void onItemClick(final AlarmVideo alarmVideo, int i, String str, String str2) {
        this.mCameraDevice.O00000oo().markEvent(alarmVideo.fileId, alarmVideo.offset, new Callback<Boolean>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass7 */

            public void onSuccess(Boolean bool) {
                if (!AlarmVideoPlayerActivityNew.this.isFinishing() && bool.booleanValue()) {
                    alarmVideo.isRead = true;
                    if (!(AlarmVideoPlayerActivityNew.this.mAlarmEventListAdapter.getDatas() == null || AlarmVideoPlayerActivityNew.this.mAlarmEventListAdapter.getDatas().indexOf(alarmVideo) == -1)) {
                        AlarmVideoPlayerActivityNew.this.mAlarmEventListAdapter.notifyItemChanged(AlarmVideoPlayerActivityNew.this.mAlarmEventListAdapter.getDatas().indexOf(alarmVideo));
                    }
                    AlarmVideoPlayerActivityNew.this.needRefresh = true;
                }
            }

            public void onFailure(int i, String str) {
                if (AlarmVideoPlayerActivityNew.this.isFinishing()) {
                }
            }
        });
        this.generalVideoView.O000000o((long) (alarmVideo.startDuration * 1000.0d));
        setFeedbackData(alarmVideo);
    }

    public void onItemClick(View view, AlarmVideo alarmVideo, int i) {
        if (view.getId() == R.id.iv_add_face || view.getId() == R.id.icon_face || view.getId() == R.id.tv_event_time || view.getId() == R.id.tv_event_des) {
            onBtnClick(alarmVideo, i, !alarmVideo.isKnownFace);
        } else if (view.getId() == R.id.tv_feed_back && alarmVideo != null) {
            showFeedbackDialog(this.fileId, (alarmVideo.eventType.equals("Face") || alarmVideo.eventType.equals("KnownFace")) ? "face" : alarmVideo.eventType);
        }
    }

    public void onBtnClick(AlarmVideo alarmVideo, int i, boolean z) {
        FaceInfoMeta faceInfoMeta = alarmVideo.fileIdMetaResult.faceInfoMetas.get(0);
        chr.O000000o("u5v.u1o.4k5.em4");
        if (z) {
            FaceUtils.processMarkFace(this, faceInfoMeta.faceId, FaceManager.getInstance(this.mCameraDevice), new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass8 */

                public void onSuccess(Object obj, Object obj2) {
                    gqg.O00000Oo((int) R.string.action_success);
                    AlarmVideoPlayerActivityNew.this.getEventList();
                    AlarmVideoPlayerActivityNew.this.needRefresh = true;
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            });
        } else {
            FaceUtils.processReplaceFace(getContext(), faceInfoMeta.faceId, faceInfoMeta.figureId, faceInfoMeta.figureName, FaceManager.getInstance(this.mCameraDevice), new FaceManager.IFaceCallback<Object>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew.AnonymousClass9 */

                public void onSuccess(Object obj, Object obj2) {
                    gqg.O00000Oo((int) R.string.action_success);
                    AlarmVideoPlayerActivityNew.this.getEventList();
                    AlarmVideoPlayerActivityNew.this.needRefresh = true;
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            });
        }
    }

    public void smoothScrollToPosition(AlarmVideo alarmVideo, int i) {
        this.mHandler.post(new Runnable(i, alarmVideo) {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivityNew$ZWJcoZMUpokQ4QLKAuEhz5q1NH8 */
            private final /* synthetic */ int f$1;
            private final /* synthetic */ AlarmVideo f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                AlarmVideoPlayerActivityNew.this.lambda$smoothScrollToPosition$6$AlarmVideoPlayerActivityNew(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$smoothScrollToPosition$6$AlarmVideoPlayerActivityNew(int i, AlarmVideo alarmVideo) {
        this.mRecyclerView.scrollToPosition(i);
        setFeedbackData(alarmVideo);
    }
}
