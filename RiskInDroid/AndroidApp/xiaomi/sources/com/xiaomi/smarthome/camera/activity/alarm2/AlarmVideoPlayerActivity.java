package com.xiaomi.smarthome.camera.activity.alarm2;

import _m_j.chr;
import _m_j.ckv;
import _m_j.fno;
import _m_j.ftn;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.me;
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
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm2.BaseAlarmVideoPlayerActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.util.TopSmoothScroller;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.view.widget.FeedbackDialog;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import com.xiaomi.smarthome.miio.camera.face.widget.ButtonAdaptiveDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TimeZone;

public class AlarmVideoPlayerActivity extends BaseAlarmVideoPlayerActivity implements View.OnClickListener, AlarmEventListAdapter.OnItemClickLister {
    private FrameLayout flTitleBar;
    private GeneralVideoView generalVideoView;
    private boolean isAlarm;
    public AlarmEventListAdapter mAlarmEventListAdapter;
    CloudVideoDownloadManager.ICloudVideoDownloadListener mCloudVideoDownloadListener = new CloudVideoDownloadManager.ICloudVideoDownloadListener() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity.AnonymousClass1 */

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
            gsy.O00000Oo("AlarmVideoPlayerActivity", "onFinish " + cloudVideoDownloadInfo.m3u8LocalPath);
            if (cloudVideoDownloadInfo.fileId.equals(AlarmVideoPlayerActivity.this.fileId)) {
                if (AlarmVideoPlayerActivity.this.mCameraDevice == null || AlarmVideoPlayerActivity.this.mCameraDevice.O00000oO().O00000Oo()) {
                    gqg.O00000Oo((int) R.string.save_success);
                } else {
                    AlarmVideoPlayerActivity.this.m3u8ToMp4(cloudVideoDownloadInfo.m3u8LocalPath);
                }
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
    private String mFaceName;
    private RecyclerView mRecyclerView;
    private SimpleDateFormat mTimeFormat;
    public boolean needRefresh;
    private int offset;
    public int pos;
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

    public void doCreate(Bundle bundle) {
        chr.O000000o(chr.O000ooo0);
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_video_player_general);
        Intent intent = getIntent();
        this.fileId = intent.getStringExtra("fileId");
        this.isAlarm = intent.getBooleanExtra("isAlarm", false);
        this.mCreateTime = intent.getLongExtra("createTime", 0);
        this.offset = intent.getIntExtra("offset", 0);
        this.startDuration = intent.getDoubleExtra("startDuration", 0.0d);
        this.pos = intent.getIntExtra("position", 0);
        boolean booleanExtra = intent.getBooleanExtra("skipPwd", false);
        this.mFaceName = intent.getStringExtra("faceName");
        if (!getIntent().getBooleanExtra("pincod", false) && !booleanExtra) {
            globalPinCodeVerifyFunc();
        }
        gsy.O00000Oo("AlarmVideoPlayerActivity", "fileId = " + this.fileId + " createTime = " + this.mCreateTime + " startDuration = " + this.startDuration + " isAlarm = " + this.isAlarm);
        initPlayer();
        initView();
        initRecyclerView();
        getVideoUrl();
        getEventList();
    }

    public void onResume() {
        super.onResume();
        chr.O00000o0();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GeneralVideoView generalVideoView2 = this.generalVideoView;
        if (generalVideoView2 != null) {
            generalVideoView2.O000000o(configuration);
        }
        if (this.mIsResumed) {
            if (this.mFullScreen) {
                hideStatusBar();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.videoViewParent.getLayoutParams();
                layoutParams.height = -1;
                this.videoViewParent.setLayoutParams(layoutParams);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.videoViewParent.getLayoutParams();
            layoutParams2.height = -2;
            this.videoViewParent.setLayoutParams(layoutParams2);
        }
    }

    public void onPause() {
        super.onPause();
        chr.O00000o();
    }

    public void checkHasFace(ArrayList<AlarmVideo> arrayList) {
        boolean z;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                z = false;
                break;
            } else if (arrayList.get(i2).fileIdMetaResult != null) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (CoreApi.O000000o().O0000O0o() && ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            z = false;
        }
        TextView textView = this.tvFeedback;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    private void initView() {
        this.flTitleBar = (FrameLayout) findViewById(R.id.title_bar);
        ((TextView) findViewById(R.id.title_bar_title)).setText(getString(R.string.housekeeping));
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        this.title_bar_more.setImageResource(R.drawable.mj_webp_titlebar_setting_nor);
        this.title_bar_more.setOnClickListener(this);
        int i = 0;
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
        TextView textView = this.tvFeedback;
        if (isFeedbackGone()) {
            i = 8;
        }
        textView.setVisibility(i);
        this.tvDownloadHint = (TextView) findViewById(R.id.tvDownloadHint);
        this.tvDownloadHint.setOnClickListener(this);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    private void initPlayer() {
        this.videoViewParent = (ViewGroup) findViewById(R.id.videoViewParent);
        this.generalVideoView = new GeneralVideoView(this);
        this.videoViewParent.addView(this.generalVideoView);
        this.generalVideoView.O000000o(this.mCameraDevice.getModel(), this.mCameraDevice.getDid());
        this.generalVideoView.setOnConfigurationChangedListener(new BasicVideoView.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivity$XOGXGRmwPuatbleCkrqP0PKgXNg */

            public final void onChangeOrientation(boolean z) {
                AlarmVideoPlayerActivity.this.lambda$initPlayer$0$AlarmVideoPlayerActivity(z);
            }
        });
        this.generalVideoView.O000000o(!this.mCameraDevice.isReadOnlyShared() ? new int[]{ckv.camera_ic_player_snapshot, ckv.camera_ic_player_download, ckv.camera_ic_player_delete} : null, new ckv.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivity$PsUqjBuwJgrcY8qaUc2v_EHJRh8 */

            public final void onActionClick(int i) {
                AlarmVideoPlayerActivity.this.lambda$initPlayer$1$AlarmVideoPlayerActivity(i);
            }
        });
    }

    public /* synthetic */ void lambda$initPlayer$0$AlarmVideoPlayerActivity(boolean z) {
        this.flTitleBar.setVisibility(z ? 0 : 8);
        ViewGroup.LayoutParams layoutParams = this.videoViewParent.getLayoutParams();
        int i = -1;
        layoutParams.width = -1;
        if (z) {
            i = -2;
        }
        layoutParams.height = i;
        this.videoViewParent.setLayoutParams(layoutParams);
    }

    public /* synthetic */ void lambda$initPlayer$1$AlarmVideoPlayerActivity(int i) {
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

    private void initRecyclerView() {
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mAlarmEventListAdapter = new AlarmEventListAdapter(this);
        this.mAlarmEventListAdapter.setFaceName(this.mFaceName);
        this.mRecyclerView.setAdapter(this.mAlarmEventListAdapter);
        this.mAlarmEventListAdapter.setOnItemClickLister(this);
        this.mAlarmEventListAdapter.setShareUser(this.mCameraDevice.isShared() || this.mCameraDevice.isReadOnlyShared());
    }

    private void getVideoUrl() {
        String videoFileUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(this.mCameraDevice.getDid(), this.fileId, this.isAlarm);
        gsy.O00000Oo("AlarmVideoPlayerActivity", "videoUrl = ".concat(String.valueOf(videoFileUrl)));
        HashMap hashMap = new HashMap();
        MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
        if (tokenInfo != null) {
            hashMap.put("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0);
            this.generalVideoView.O000000o(videoFileUrl, hashMap);
            if (this.offset > 0) {
                this.generalVideoView.getPlayer().O000000o((long) (this.startDuration * 1000.0d));
            }
        }
    }

    public void getEventList() {
        this.mCameraDevice.O00000oo().getEventListByFileId(this.fileId, this.isAlarm, new Callback<ArrayList<AlarmVideo>>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity.AnonymousClass2 */

            public void onFailure(int i, String str) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
            }

            public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                Collections.sort(arrayList, $$Lambda$AlarmVideoPlayerActivity$2$oVs8FIeRh445rNOVpefg6bc0cuY.INSTANCE);
                AlarmVideoPlayerActivity.this.checkHasFace(arrayList);
                if (arrayList != null && arrayList.size() > 0) {
                    AlarmVideoPlayerActivity.this.mCreateTime = arrayList.get(0).createTime;
                    AlarmVideoPlayerActivity.this.mAlarmEventListAdapter.setData(arrayList);
                    if (AlarmVideoPlayerActivity.this.startDuration > 0.0d) {
                        AlarmVideoPlayerActivity.this.mAlarmEventListAdapter.parseProgress((long) (AlarmVideoPlayerActivity.this.startDuration * 1000.0d));
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    public void m3u8ToMp4(String str) {
        String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
        new BaseAlarmVideoPlayerActivity.M3u8ToMp4Task(false).execute(str, O000000o2);
    }

    /* access modifiers changed from: package-private */
    public void afterM3u8ToMp4Task(String str, boolean z) {
        if (!isFinishing()) {
            if (!TextUtils.isEmpty(str)) {
                gqg.O00000Oo((int) R.string.save_success);
                gqg.O00000Oo((int) R.string.save_success);
                return;
            }
            gqg.O00000Oo((int) R.string.save_fail);
        }
    }

    private void downloadHint() {
        chr.O000000o(chr.O000oooO);
        if (CloudVideoNetUtils.getInstance().isWifiConnected(this)) {
            doDownload();
            if (this.mCameraDevice != null && this.mCameraDevice.O00000oO().O00000Oo()) {
                showDownloadActivityHint();
                return;
            }
            return;
        }
        new ButtonAdaptiveDialog.Builder(this).setTitle(getString(R.string.cs_non_wifi_environment)).setConfirmText(getString(R.string.action_continue), new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity.AnonymousClass4 */

            public void onClick(View view) {
                AlarmVideoPlayerActivity.this.doDownload();
                if (AlarmVideoPlayerActivity.this.mCameraDevice != null && AlarmVideoPlayerActivity.this.mCameraDevice.O00000oO().O00000Oo()) {
                    AlarmVideoPlayerActivity.this.showDownloadActivityHint();
                }
            }
        }).setCancle(getString(R.string.cs_cancel), new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity.AnonymousClass3 */

            public void onClick(View view) {
            }
        }).build().show();
    }

    public void showDownloadActivityHint() {
        this.tvDownloadHint.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivity$12YyjT4L7pSNBQeIT09Ybi9YWBY */

            public final void run() {
                AlarmVideoPlayerActivity.this.lambda$showDownloadActivityHint$2$AlarmVideoPlayerActivity();
            }
        }, 3000);
    }

    public /* synthetic */ void lambda$showDownloadActivityHint$2$AlarmVideoPlayerActivity() {
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
            CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).insertRecords(arrayList);
            CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).addListener(this.mCloudVideoDownloadListener);
            CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).pullDownloadFromList(getContext(), O000000o2.userId, this.mCameraDevice.getDid());
        }
    }

    private void showDeleteVideoDialog() {
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_delete_video)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivity$UdxNgh5ROKYWp4br_5WXgsIJ9Q */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmVideoPlayerActivity.this.lambda$showDeleteVideoDialog$3$AlarmVideoPlayerActivity(dialogInterface, i);
            }
        }).O000000o($$Lambda$AlarmVideoPlayerActivity$lmG98EZZsn9I_t9Ft2PGIVsDbE.INSTANCE).O00000Oo((int) R.string.camera_cancel, $$Lambda$AlarmVideoPlayerActivity$TOwXSrDB_6pkZhmcOJ4WNA4D_E.INSTANCE).O00000oo();
    }

    public /* synthetic */ void lambda$showDeleteVideoDialog$3$AlarmVideoPlayerActivity(DialogInterface dialogInterface, int i) {
        this.mCameraDevice.O00000oo().deleteFiles(new Callback() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity.AnonymousClass5 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Object obj) {
                new Intent().putExtra("position", AlarmVideoPlayerActivity.this.pos);
                AlarmVideoPlayerActivity.this.setResult(-1);
                AlarmVideoPlayerActivity.this.finish();
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

    private void showFeedbackDialog() {
        chr.O000000o("u5v.u1o.4k5.69e");
        FeedbackDialog feedbackDialog = new FeedbackDialog(this);
        feedbackDialog.setTitle((int) R.string.face_match_error);
        feedbackDialog.setOnClickListener(new DialogInterface.OnClickListener(feedbackDialog) {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivity$GGzWa1e0l3KkFmZkqfqTMH4IMA */
            private final /* synthetic */ FeedbackDialog f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmVideoPlayerActivity.this.lambda$showFeedbackDialog$6$AlarmVideoPlayerActivity(this.f$1, dialogInterface, i);
            }
        });
        feedbackDialog.setModel(this.mCameraDevice.getModel());
        feedbackDialog.show();
    }

    public /* synthetic */ void lambda$showFeedbackDialog$6$AlarmVideoPlayerActivity(FeedbackDialog feedbackDialog, DialogInterface dialogInterface, int i) {
        feedbackDialog.dismiss();
        this.mCameraDevice.O00000oo().feedBack(this.fileId, true, new Callback() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity.AnonymousClass6 */

            public void onSuccess(Object obj) {
                gqg.O00000Oo((int) R.string.thanks_feedback);
            }

            public void onFailure(int i, String str) {
                gqg.O00000Oo((int) R.string.action_fail);
            }
        }, "face");
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
        if (view.getId() == R.id.title_bar_return) {
            finish();
        } else if (view.getId() == R.id.title_bar_more) {
            startActivity(new Intent(this, AlarmSettingV2Activity.class));
            chr.O000000o(chr.O00O00Oo);
        } else if (view.getId() == R.id.tv_feedback) {
            showFeedbackDialog();
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

    public void onItemClick(AlarmVideo alarmVideo, int i) {
        this.generalVideoView.O000000o((long) (alarmVideo.startDuration * 1000.0d));
    }

    public void onBtnClick(AlarmVideo alarmVideo, int i, boolean z) {
        String str;
        FaceInfoMeta faceInfoMeta = alarmVideo.fileIdMetaResult.faceInfoMetas.get(0);
        chr.O000000o("u5v.u1o.4k5.em4");
        if (!faceInfoMeta.matched) {
            FaceUtils.processMarkFace(this, faceInfoMeta.faceId, FaceManager.getInstance(this.mCameraDevice), new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity.AnonymousClass7 */

                public void onSuccess(Object obj, Object obj2) {
                    gqg.O00000Oo((int) R.string.action_success);
                    AlarmVideoPlayerActivity.this.getEventList();
                    AlarmVideoPlayerActivity.this.needRefresh = true;
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            });
        } else {
            FaceUtils.processReplaceFace(getContext(), faceInfoMeta.faceId, faceInfoMeta.figureId, (faceInfoMeta.figureName != null || (str = this.mFaceName) == null) ? faceInfoMeta.figureName : str, FaceManager.getInstance(this.mCameraDevice), new FaceManager.IFaceCallback<Object>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity.AnonymousClass8 */

                public void onSuccess(Object obj, Object obj2) {
                    gqg.O00000Oo((int) R.string.action_success);
                    AlarmVideoPlayerActivity.this.getEventList();
                    AlarmVideoPlayerActivity.this.needRefresh = true;
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            });
        }
    }

    public void smoothScrollToPosition(int i) {
        this.mHandler.post(new Runnable(i) {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoPlayerActivity$xGDs8X6zg3v2u4TGUArKNNacMkA */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AlarmVideoPlayerActivity.this.lambda$smoothScrollToPosition$7$AlarmVideoPlayerActivity(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$smoothScrollToPosition$7$AlarmVideoPlayerActivity(int i) {
        TopSmoothScroller topSmoothScroller = new TopSmoothScroller(getContext());
        topSmoothScroller.setTargetPosition(i);
        if (this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().startSmoothScroll(topSmoothScroller);
        }
    }

    private boolean isFeedbackGone() {
        if (this.mCameraDevice == null) {
            return true;
        }
        if ((!CoreApi.O000000o().O0000O0o() || !ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) && !this.mCameraDevice.isShared() && !this.mCameraDevice.isReadOnlyShared()) {
            return false;
        }
        return true;
    }
}
