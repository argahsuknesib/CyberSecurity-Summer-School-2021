package com.xiaomi.smarthome.camera.activity.alarm2;

import _m_j.cb;
import _m_j.chr;
import _m_j.cih;
import _m_j.civ;
import _m_j.ckb;
import _m_j.cki;
import _m_j.ckv;
import _m_j.clf;
import _m_j.fno;
import _m_j.ftn;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hny;
import _m_j.hor;
import _m_j.hyy;
import _m_j.hzf;
import _m_j.me;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Utils.MediaStoreUtil;
import com.mijia.generalplayer.videoview.BasicVideoView;
import com.mijia.generalplayer.videoview.GeneralVideoView;
import com.mijia.model.alarmcloud.AlarmCloudCallback;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.alarmcloud.FaceInfoMeta;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventOperationListAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter2;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.RecyclerEventTypeAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.bean.EventType;
import com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil;
import com.xiaomi.smarthome.camera.activity.alarm2.util.TopSmoothScroller;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity;
import com.xiaomi.smarthome.camera.view.calendar.CEn7DayRecyclerAdapterNew;
import com.xiaomi.smarthome.camera.view.calendar.CalendarDate;
import com.xiaomi.smarthome.camera.view.calendar.DateUtils;
import com.xiaomi.smarthome.camera.view.calendar.YdCatCalendarView;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayoutEx;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoUserStatus;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoUtils;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import com.xiaomi.smarthome.miio.camera.face.widget.ButtonAdaptiveDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

public class AlarmVideoNormalPlayerActivityNew extends BaseAlarmVideoPlayerActivity implements View.OnClickListener, AlarmEventOperationListAdapter.OnItemClickLister {
    private static final String[] mDevicePropKeys = {"electricity"};
    public View calendar_container;
    public long createTime;
    public int currentPosition = 0;
    YdCatCalendarView custom_calendar;
    public boolean dateNoneDefault;
    private long endTime;
    RecyclerEventTypeAdapter eventTypeAdapter;
    RecyclerView event_type_recycler;
    public String fileId;
    private FrameLayout flTitleBar;
    private GeneralVideoView generalVideoView;
    public int index;
    public boolean isAlarm;
    public boolean isFromRn;
    public boolean isNetRefreshing;
    private boolean isNewRNPlugin;
    public boolean isSharing;
    ImageView iv_more_record;
    ImageView iv_next_day;
    hny liteScenceListenernew = new hny() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass4 */

        public void onRefreshScenceSuccess(int i) {
            int i2;
            if (!AlarmVideoNormalPlayerActivityNew.this.isFinishing() && AlarmVideoNormalPlayerActivityNew.this.isValid()) {
                if (!hor.O000000o().isLiteSceneInited()) {
                    i2 = hor.O000000o().getLiteSceneSize();
                } else {
                    i2 = hor.O000000o().getLiteSceneSizeByDid(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getDid());
                }
                if (i2 > 0) {
                    AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                    alarmVideoNormalPlayerActivityNew.mHasAISceneBuilt = true;
                    if (alarmVideoNormalPlayerActivityNew.eventTypeAdapter != null && AlarmVideoNormalPlayerActivityNew.this.eventTypeAdapter.getItemCount() > 0 && !AlarmVideoNormalPlayerActivityNew.this.eventTypeAdapter.containsAiType()) {
                        EventType eventType = new EventType();
                        eventType.name = AlarmVideoNormalPlayerActivityNew.this.eventTypes[AlarmVideoNormalPlayerActivityNew.this.eventTypes.length - 1];
                        eventType.desc = AlarmVideoNormalPlayerActivityNew.this.eventTypesDesc[AlarmVideoNormalPlayerActivityNew.this.eventTypesDesc.length - 1];
                        AlarmVideoNormalPlayerActivityNew.this.eventTypeAdapter.addEvent(eventType);
                        return;
                    }
                    return;
                }
                AlarmVideoNormalPlayerActivityNew.this.mHasAISceneBuilt = false;
            }
        }

        public void onRefreshScenceFailed(int i) {
            AlarmVideoNormalPlayerActivityNew.this.mHasAISceneBuilt = false;
        }
    };
    LinearLayout ll_calendar_bg;
    LinearLayout ll_empty_content;
    private int loadTimes;
    private View loadingCircle;
    private View loadingContainer;
    private int localAlarmEventTypes;
    public AlarmVideoAdapter2 mAlarmVideoAdapter = null;
    CloudVideoDownloadManager.ICloudVideoDownloadListener mCloudVideoDownloadListener = new CloudVideoDownloadManager.ICloudVideoDownloadListener() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass20 */

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

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String
         arg types: [long, int, java.lang.String]
         candidates:
          _m_j.me.O000000o(java.lang.String, int, java.lang.String):java.lang.String
          _m_j.me.O000000o(java.lang.String, java.lang.String, int):java.lang.String
          _m_j.me.O000000o(long, boolean, java.lang.String):java.lang.String */
        public void onFinish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            gsy.O00000Oo("AlarmVideoNormalPlayerActivity", "onFinish " + cloudVideoDownloadInfo.m3u8LocalPath);
            if (cloudVideoDownloadInfo.fileId.equals(AlarmVideoNormalPlayerActivityNew.this.fileId)) {
                if (!AlarmVideoNormalPlayerActivityNew.this.isAlarm) {
                    gqg.O00000Oo((int) R.string.save_success);
                } else if (!DeviceConstant.isSupportCloudMp4Download(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getModel())) {
                    AlarmVideoNormalPlayerActivityNew.this.m3u8ToMp4(cloudVideoDownloadInfo.m3u8LocalPath);
                } else if (!AlarmVideoNormalPlayerActivityNew.this.isFinishing()) {
                    cki.O00000o0("AlarmVideoNormalPlayerActivity", "download finish for " + AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getModel());
                    AlarmVideoNormalPlayerActivityNew.this.hideLoading();
                    String O000000o2 = me.O000000o(cloudVideoDownloadInfo.startTime, true, cloudVideoDownloadInfo.did);
                    if (new File(O000000o2).exists()) {
                        if (AlarmVideoNormalPlayerActivityNew.this.isSharing) {
                            AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                            alarmVideoNormalPlayerActivityNew.openShareVideoActivity(alarmVideoNormalPlayerActivityNew, "", "", O000000o2, 1);
                            return;
                        }
                        gqg.O00000Oo((int) R.string.save_success);
                    } else if (AlarmVideoNormalPlayerActivityNew.this.isSharing) {
                        gqg.O00000Oo((int) R.string.share_failed);
                    } else {
                        gqg.O00000Oo((int) R.string.save_fail);
                    }
                }
            }
        }

        public void onCancelled(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            AlarmVideoNormalPlayerActivityNew.this.hideLoading();
            if (!AlarmVideoNormalPlayerActivityNew.this.isAlarm) {
                gqg.O00000Oo((int) R.string.save_fail);
            }
        }

        public void onError(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
            AlarmVideoNormalPlayerActivityNew.this.hideLoading();
            if (!AlarmVideoNormalPlayerActivityNew.this.isAlarm) {
                gqg.O00000Oo((int) R.string.save_success);
            }
        }
    };
    public EventType mCurEventType = new EventType();
    public long mEndPoint = 0;
    public long mEndTime = 0;
    public boolean mHasAISceneBuilt;
    LayoutInflater mLayoutInflater;
    private hny mListener = new hny() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass3 */

        public void onRefreshScenceSuccess(int i) {
            int i2;
            if (AlarmVideoNormalPlayerActivityNew.this.isValid()) {
                if (!hor.O000000o().isSceneManagerInited()) {
                    i2 = hor.O000000o().getCachedCustomSceneSize();
                } else {
                    i2 = hor.O000000o().getCustomSceneSizeByDid(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getDid());
                }
                if (i2 > 0) {
                    AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                    alarmVideoNormalPlayerActivityNew.mHasAISceneBuilt = true;
                    if (alarmVideoNormalPlayerActivityNew.eventTypeAdapter != null && AlarmVideoNormalPlayerActivityNew.this.eventTypeAdapter.getItemCount() > 0 && !AlarmVideoNormalPlayerActivityNew.this.eventTypeAdapter.containsAiType()) {
                        EventType eventType = new EventType();
                        eventType.name = AlarmVideoNormalPlayerActivityNew.this.eventTypes[AlarmVideoNormalPlayerActivityNew.this.eventTypes.length - 1];
                        eventType.desc = AlarmVideoNormalPlayerActivityNew.this.eventTypesDesc[AlarmVideoNormalPlayerActivityNew.this.eventTypesDesc.length - 1];
                        AlarmVideoNormalPlayerActivityNew.this.eventTypeAdapter.addEvent(eventType);
                        return;
                    }
                    return;
                }
                AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew2 = AlarmVideoNormalPlayerActivityNew.this;
                alarmVideoNormalPlayerActivityNew2.mHasAISceneBuilt = false;
                alarmVideoNormalPlayerActivityNew2.updateLiteScene();
            }
        }

        public void onRefreshScenceFailed(int i) {
            AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
            alarmVideoNormalPlayerActivityNew.mHasAISceneBuilt = false;
            alarmVideoNormalPlayerActivityNew.updateLiteScene();
        }
    };
    private ImageView mLoadingView;
    private boolean mNeedLicense = false;
    public List<AlarmVideo> mRecordList = new ArrayList();
    private SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
    public long mStartPoint = 0;
    public long mStartTime = 0;
    private SimpleDateFormat mTimeFormat;
    public CloudVideoUserStatus mUserStatus;
    public int mVisibleItemCount;
    private int needPinCode = 0;
    public int offset;
    RecyclerViewRefreshLayoutEx ptrLayout;
    RecyclerView rv_event_list;
    private CalendarDate selectedDate;
    private String shareNames = "";
    private long storedPlayPosition = 0;
    TextView sub_title_bar_title;
    private int targetHeight = -1;
    ImageView title_bar_more;
    ImageView title_bar_redpoint;
    TextView title_bar_title;
    private TextView tvCloudStorageHint;
    public View tvDownloadHint;
    TextView tv_all_record;
    TextView tv_cur_day;
    TextView tv_request_result;
    private ViewGroup videoViewParent;

    public boolean supportOrientationListen() {
        return true;
    }

    public void doCreate(Bundle bundle) {
        chr.O000000o(chr.O000ooo0);
        gwg.O00000o0(this);
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_video_normal_player_general_new);
        this.shareNames = getIntent().getStringExtra("Alarm_SN");
        boolean booleanExtra = getIntent().getBooleanExtra("skipPwd", false);
        if (!getIntent().getBooleanExtra("pincod", false) && !booleanExtra) {
            this.needPinCode++;
            globalPinCodeVerifyFunc();
        }
        initVideo();
        this.generalVideoView.getIvBack2().setVisibility(0);
        this.generalVideoView.getIvBack2().setOnClickListener(this);
        initVideoList();
        getVideoUrl(true);
        this.loadingContainer = findViewById(R.id.loading_area);
        this.loadingCircle = findViewById(R.id.image_circle);
        this.loadingContainer.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass1 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        getUserStatus();
    }

    public void onResume() {
        super.onResume();
        int i = this.needPinCode;
        if (i >= 0) {
            this.needPinCode = i - 1;
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$vcLzLAARJDVKfJnhrt7YG2HrCY */

                public final void run() {
                    AlarmVideoNormalPlayerActivityNew.this.refreshContent();
                }
            }, 350);
        }
    }

    public void onPause() {
        super.onPause();
        chr.O00000o();
    }

    public void finish() {
        setResult(-1);
        super.finish();
    }

    public void onDestroy() {
        try {
            CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).removeListener(this.mCloudVideoDownloadListener);
        } catch (Exception e) {
            cki.O00000oO("AlarmVideoNormalPlayerActivity", e.toString());
        }
        super.onDestroy();
    }

    private void initVideo() {
        this.fileId = getIntent().getStringExtra("fileId");
        this.offset = getIntent().getIntExtra("offset", 0);
        this.createTime = getIntent().getLongExtra("createTime", 0);
        this.isAlarm = getIntent().getBooleanExtra("isAlarm", true);
        this.flTitleBar = (FrameLayout) findViewById(R.id.title_bar);
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
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivityNew$8Vko1edL3xoWPrzkLQjePL5fYI */

            public final void onChangeOrientation(boolean z) {
                AlarmVideoNormalPlayerActivityNew.this.lambda$initVideo$0$AlarmVideoNormalPlayerActivityNew(z);
            }
        });
        this.generalVideoView.setPlayerListener(new ckb.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass2 */

            public void onLoadingChanged(boolean z) {
            }

            public void onPlayerStateChanged(int i) {
            }

            public void onPrepared() {
            }

            public void onPlayerError(String str) {
                AlarmVideoNormalPlayerActivityNew.this.setCloudStorageHintVisible(true);
            }

            public void isPlayingChanged(boolean z) {
                AlarmVideoNormalPlayerActivityNew.this.setCloudStorageHintVisible(!z);
            }
        });
        initPlayerAction();
        this.tvDownloadHint = findViewById(R.id.tvDownloadHint);
        this.tvDownloadHint.setOnClickListener(this);
        this.tvCloudStorageHint = (TextView) findViewById(R.id.tvCloudStorageHint);
        this.tvCloudStorageHint.setText((int) R.string.alarm_cloud_no_buy_tip);
        this.tvCloudStorageHint.setOnClickListener(this);
    }

    public /* synthetic */ void lambda$initVideo$0$AlarmVideoNormalPlayerActivityNew(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.videoViewParent.getLayoutParams();
        int i = -1;
        layoutParams.width = -1;
        if (z) {
            i = -2;
        }
        layoutParams.height = i;
        this.videoViewParent.setLayoutParams(layoutParams);
    }

    public void setCloudStorageHintVisible(boolean z) {
        if (!z) {
            this.tvCloudStorageHint.setVisibility(8);
        } else if (cih.O000000o() && !this.mCameraDevice.isShared() && !hideCloudVideoBuyTips()) {
            if (!DeviceModelManager.getInstance().isMijiaCameraV1(this.mCameraDevice.getModel()) || !this.mCameraDevice.O00000oO().O00000Oo()) {
                this.tvCloudStorageHint.setVisibility(0);
                this.tvCloudStorageHint.bringToFront();
            }
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
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.videoViewParent);
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

    public void initPlayerAction() {
        int[] iArr;
        if (!this.mCameraDevice.isReadOnlyShared()) {
            iArr = !this.isAlarm ? new int[]{ckv.camera_ic_player_snapshot, ckv.camera_ic_player_download, ckv.camera_ic_player_delete} : new int[]{ckv.camera_ic_player_snapshot, ckv.camera_ic_player_share, ckv.camera_ic_player_download, ckv.camera_ic_player_delete};
        } else {
            iArr = null;
        }
        this.generalVideoView.O000000o(iArr, new ckv.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivityNew$Nx1dOPdbHQ8kS4aktmj86A8Udw */

            public final void onActionClick(int i) {
                AlarmVideoNormalPlayerActivityNew.this.lambda$initPlayerAction$1$AlarmVideoNormalPlayerActivityNew(i);
            }
        });
    }

    public /* synthetic */ void lambda$initPlayerAction$1$AlarmVideoNormalPlayerActivityNew(int i) {
        if (i == ckv.camera_ic_player_snapshot) {
            if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                gqg.O000000o((int) R.string.no_write_permission);
                return;
            }
            this.generalVideoView.O000000o(new Intent(this, LocalPicActivity.class));
        } else if (i == ckv.camera_ic_player_share) {
            tryShare();
        } else if (i == ckv.camera_ic_player_download) {
            tryDownload();
        } else if (i == ckv.camera_ic_player_delete) {
            showDeleteVideoDialog();
            chr.O000000o("u5v.u1o.4k5.xs8");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hideCloudVideoBuyTips() {
        return "chuangmi.camera.ipc009".equals(this.mCameraDevice.getModel()) && !clf.O000000o(this.mCameraDevice.O00000o0(), "3.4.2_0200");
    }

    private void initVideoList() {
        findView();
        initEventType();
        initView();
        initData();
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivityNew$aSgc33MBF2BxpKigM2RVaJssn1g */

            public final void run() {
                AlarmVideoNormalPlayerActivityNew.this.lambda$initVideoList$2$AlarmVideoNormalPlayerActivityNew();
            }
        });
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$vcLzLAARJDVKfJnhrt7YG2HrCY */

            public final void run() {
                AlarmVideoNormalPlayerActivityNew.this.refreshContent();
            }
        }, 400);
    }

    private void initEventType() {
        String str = this.mCameraDevice.O00000oO().f14071O000000o;
        for (int i = 0; i < this.eventTypes.length; i++) {
            if (str.equals(this.eventTypes[i])) {
                this.mCurEventType.name = this.eventTypes[i];
                this.mCurEventType.desc = this.eventTypesDesc[i];
                return;
            }
        }
    }

    private void initData() {
        this.index = getIntent().getIntExtra("index", 0);
        this.selectedDate = (CalendarDate) getIntent().getParcelableExtra("dateTime");
        if (this.selectedDate == null) {
            this.selectedDate = DateUtils.getCalendarDate(this.createTime);
        }
        if (this.index != 0) {
            this.dateNoneDefault = true;
        }
        long todayStartTime = getTodayStartTime();
        long currentTimeMillis = System.currentTimeMillis();
        this.tv_cur_day.setText(DateUtils.getMonthDay(System.currentTimeMillis() + 1));
        CalendarDate calendarDate = this.selectedDate;
        if (calendarDate != null) {
            todayStartTime = calendarDate.getDayStartAndEndTimeMillis()[0];
            currentTimeMillis = this.selectedDate.getDayStartAndEndTimeMillis()[1];
            this.tv_cur_day.setText(DateUtils.getMonthDay(1 + todayStartTime));
        }
        this.mStartTime = todayStartTime;
        this.mStartPoint = todayStartTime;
        this.mEndTime = currentTimeMillis;
        this.mEndPoint = currentTimeMillis;
        hor.O000000o().updateCustomScene(this.mDid, this.mListener);
    }

    public void updateLiteScene() {
        hor.O000000o().updateLiteScene(this.liteScenceListenernew);
    }

    private long getTodayStartTime() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return instance.getTimeInMillis();
    }

    private void findView() {
        this.createTime = getIntent().getLongExtra("createTime", 0);
        long currentDayTS0 = CloudVideoUtils.getCurrentDayTS0();
        TextView textView = (TextView) findViewById(R.id.tv_day);
        long j = this.createTime;
        if (j + 1 <= currentDayTS0 || j + 1 >= currentDayTS0 + AlarmVideoActivityNew.ONE_DAY) {
            textView.setText(DateUtils.getMonthDay(this.createTime + 1));
        } else {
            textView.setText(String.format("%s %s", DateUtils.getMonthDay(this.createTime + 1), getString(R.string.today)));
        }
        this.calendar_container = findViewById(R.id.calendar_area);
        View findViewById = findViewById(R.id.see_all_video);
        findViewById.setOnClickListener(this);
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        this.title_bar_more.setImageResource(R.drawable.mj_webp_titlebar_setting_nor);
        this.title_bar_more.setOnClickListener(this);
        this.isFromRn = getIntent().getBooleanExtra("isFromRn", false);
        this.localAlarmEventTypes = getIntent().getIntExtra("localAlarmEventType", 0);
        this.isNewRNPlugin = getIntent().getBooleanExtra("isNewPlugin", false);
        if (this.mCameraDevice.isReadOnlyShared() || this.isFromRn) {
            this.title_bar_more.setVisibility(8);
        }
        if (this.isFromRn) {
            findViewById.setVisibility(8);
        }
        this.custom_calendar = (YdCatCalendarView) findViewById(R.id.custom_calendar);
        this.ll_calendar_bg = (LinearLayout) findViewById(R.id.ll_calendar_bg);
        this.ll_calendar_bg.setOnClickListener(this);
        this.title_bar_title = (TextView) findViewById(R.id.title_bar_title);
        this.sub_title_bar_title = (TextView) findViewById(R.id.sub_title_bar_title);
        this.tv_cur_day = (TextView) findViewById(R.id.tv_cur_day);
        this.tv_cur_day.setOnClickListener(this);
        this.iv_next_day = (ImageView) findViewById(R.id.iv_next_day);
        this.iv_more_record = (ImageView) findViewById(R.id.iv_more_record);
        this.ptrLayout = (RecyclerViewRefreshLayoutEx) findViewById(R.id.ptr);
        this.tv_all_record = (TextView) findViewById(R.id.tv_all_record);
        this.rv_event_list = (RecyclerView) findViewById(R.id.rv_event_list);
        this.event_type_recycler = (RecyclerView) findViewById(R.id.event_type_recycler);
        this.ll_empty_content = (LinearLayout) findViewById(R.id.ll_empty_content);
        this.tv_request_result = (TextView) findViewById(R.id.tv_request_result);
        this.title_bar_redpoint = (ImageView) findViewById(R.id.title_bar_redpoint);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.ll_all_record).setOnClickListener(this);
        this.iv_next_day.setOnClickListener(this);
        this.mLoadingView = (ImageView) findViewById(R.id.ivLoading);
        this.event_operation_rv = (RecyclerView) findViewById(R.id.event_operation_rv);
        this.event_operation_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mAlarmEventOperationListAdapter = new AlarmEventOperationListAdapter(this, this.mCameraDevice);
        this.mAlarmEventOperationListAdapter.setOnItemClickLister(this);
        this.event_operation_rv.setAdapter(this.mAlarmEventOperationListAdapter);
        setFeedbackData((AlarmVideo) getIntent().getParcelableExtra("alarmVideo"));
        getEventListById();
    }

    private void getEventListById() {
        this.mCameraDevice.O00000oo().getEventListByFileId(this.fileId, this.isAlarm, new Callback<ArrayList<AlarmVideo>>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass5 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
            }

            public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                try {
                    Collections.sort(arrayList, $$Lambda$AlarmVideoNormalPlayerActivityNew$5$2lhtuJTsCh93OKL0vVib1XvLUIU.INSTANCE);
                    if (arrayList != null && arrayList.size() > 0) {
                        AlarmVideoNormalPlayerActivityNew.this.setFeedbackData(arrayList.get(0));
                    }
                } catch (Exception e) {
                    cki.O00000oO("AlarmVideoNormalPlayerActivity", e.toString());
                }
            }

            static /* synthetic */ int lambda$onSuccess$0(AlarmVideo alarmVideo, AlarmVideo alarmVideo2) {
                if (alarmVideo.createTime > alarmVideo2.createTime) {
                    return 1;
                }
                return alarmVideo.createTime < alarmVideo2.createTime ? -1 : 0;
            }

            public void onFailure(int i, String str) {
                cki.O00000oO("AlarmVideoNormalPlayerActivity", i + "  -  " + str);
            }
        });
    }

    private void initView() {
        this.mAlarmVideoAdapter = new AlarmVideoAdapter2(this, this.mCameraDevice, false);
        this.mAlarmVideoAdapter.setOnItemClickedListener(new AlarmVideoAdapter2.ItemClickedListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass6 */

            public void onItemClicked(final AlarmVideo alarmVideo, final int i, String str, String str2, View view) {
                AlarmVideoNormalPlayerActivityNew.this.setFeedbackData(alarmVideo);
                AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.O00000oo().markEvent(alarmVideo.fileId, alarmVideo.offset, new Callback<Boolean>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass6.AnonymousClass1 */

                    public void onFailure(int i, String str) {
                    }

                    public void onSuccess(Boolean bool) {
                        if (!AlarmVideoNormalPlayerActivityNew.this.isFinishing() && bool.booleanValue()) {
                            alarmVideo.isRead = true;
                            if (AlarmVideoNormalPlayerActivityNew.this.mRecordList != null && i != -1) {
                                AlarmVideoNormalPlayerActivityNew.this.mAlarmVideoAdapter.notifyItemChanged(i);
                            }
                        }
                    }
                });
                AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                alarmVideoNormalPlayerActivityNew.currentPosition = i;
                alarmVideoNormalPlayerActivityNew.createTime = alarmVideo.createTime;
                AlarmVideoNormalPlayerActivityNew.this.fileId = alarmVideo.fileId;
                AlarmVideoNormalPlayerActivityNew.this.offset = alarmVideo.offset;
                AlarmVideoNormalPlayerActivityNew.this.isAlarm = alarmVideo.isAlarm;
                AlarmVideoNormalPlayerActivityNew.this.initPlayerAction();
                AlarmVideoNormalPlayerActivityNew.this.highLightPlaying();
                AlarmVideoNormalPlayerActivityNew.this.getVideoUrl(true);
            }

            public void onPlaying(AlarmVideo alarmVideo, int i, String str, String str2) {
                cki.O00000o("AlarmVideoNormalPlayerActivity", "onPlaying======");
            }
        });
        ((TextView) findViewById(R.id.title_bar_title)).setText(getString(R.string.housekeeping));
        int width = getWindowManager().getDefaultDisplay().getWidth();
        if (this.targetHeight == -1) {
            this.targetHeight = (width * 720) / 1280;
        }
        initRecycler();
        initPtr();
        this.custom_calendar.setCalendarListener(new YdCatCalendarView.YdCatCalendarListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass7 */

            public void clickOnLeftPage() {
            }

            public void clickOnRightPage() {
            }

            public void clickOnDate(final CalendarDate calendarDate, View view) {
                AlarmVideoNormalPlayerActivityNew.this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass7.AnonymousClass1 */

                    public void run() {
                        AlarmVideoNormalPlayerActivityNew.this.showOrHideCalendar(false, null);
                        long[] dayStartAndEndTimeMillis = calendarDate.getDayStartAndEndTimeMillis();
                        civ.O000000o("AlarmVideoNormalPlayerActivity", calendarDate.getYear() + "-" + calendarDate.getMonth() + "-" + calendarDate.getDay());
                        AlarmVideoNormalPlayerActivityNew.this.mEndTime = dayStartAndEndTimeMillis[1];
                        AlarmVideoNormalPlayerActivityNew.this.mStartPoint = dayStartAndEndTimeMillis[0];
                        AlarmVideoNormalPlayerActivityNew.this.mStartTime = AlarmVideoNormalPlayerActivityNew.this.mStartPoint;
                        AlarmVideoNormalPlayerActivityNew.this.mEndPoint = AlarmVideoNormalPlayerActivityNew.this.mEndTime;
                        AlarmVideoNormalPlayerActivityNew.this.tv_cur_day.setText(DateUtils.getMonthDay(AlarmVideoNormalPlayerActivityNew.this.mStartTime + 1));
                        AlarmVideoNormalPlayerActivityNew.this.refreshContent();
                    }
                }, 300);
            }
        });
    }

    public void highLightPlaying() {
        this.mAlarmVideoAdapter.highLightPlaying(this.currentPosition);
    }

    private void initPtr() {
        this.ptrLayout.setFooterRefreshView(LayoutInflater.from(this).inflate((int) R.layout.camera_list_load_more, (ViewGroup) null));
        this.ptrLayout.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass8 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                AlarmVideoNormalPlayerActivityNew.this.refreshContent();
            }
        });
        this.ptrLayout.setOnPushLoadMoreListener(new RecyclerViewRefreshLayout.OnPushLoadMoreListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass9 */

            public void onPushDistance(int i) {
            }

            public void onPushEnable(boolean z) {
            }

            public void onLoadMore() {
                AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                alarmVideoNormalPlayerActivityNew.getEventList(alarmVideoNormalPlayerActivityNew.mStartTime, AlarmVideoNormalPlayerActivityNew.this.mEndTime, 2);
            }
        });
    }

    private void initRecycler() {
        this.rv_event_list.setLayoutManager(new LinearLayoutManager(activity(), 1, false));
        this.rv_event_list.setAdapter(this.mAlarmVideoAdapter);
        this.rv_event_list.setHasFixedSize(true);
        this.mTimeFormat = new SimpleDateFormat("mm:ss");
        this.mTimeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    public void refreshContent() {
        showLoadingView();
        long[] dayStartAndEndTimeMillis = DateUtils.getCalendarDate(System.currentTimeMillis()).getDayStartAndEndTimeMillis();
        long j = this.mEndPoint;
        if (j > dayStartAndEndTimeMillis[0] && j < dayStartAndEndTimeMillis[1]) {
            this.mEndPoint = System.currentTimeMillis();
        }
        getEventList(this.mStartPoint, this.mEndPoint, 1);
    }

    public void getEventList(long j, long j2, final int i) {
        civ.O000000o("AlarmVideoNormalPlayerActivity", "startTime=" + j + " endTime=" + j2);
        if (!this.isNetRefreshing) {
            this.isNetRefreshing = true;
            if (i == 1) {
                this.ptrLayout.setLoadMore(true);
                this.ptrLayout.setRefreshing(false);
                this.isNetRefreshing = false;
                this.loadTimes = 0;
                this.ptrLayout.setMode(3);
                this.mAlarmVideoAdapter.setToTheEnd(false);
                this.ll_empty_content.setVisibility(8);
            }
            this.mCameraDevice.O00000oo().getEventList(this.mCurEventType.name, j, j2, new AlarmCloudCallback<ArrayList<AlarmVideo>>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass10 */

                public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj, long j, boolean z) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj), j, z);
                }

                public void onSuccess(ArrayList<AlarmVideo> arrayList, long j, boolean z) {
                    AlarmVideoNormalPlayerActivityNew.this.hideLoadingView();
                    AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                    alarmVideoNormalPlayerActivityNew.isNetRefreshing = false;
                    if (alarmVideoNormalPlayerActivityNew.ptrLayout.isRefreshing()) {
                        AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setRefreshing(false);
                    }
                    if (i == 1) {
                        AlarmVideoNormalPlayerActivityNew.this.mRecordList.clear();
                    }
                    AlarmVideoNormalPlayerActivityNew.this.mRecordList.addAll(arrayList);
                    if (i == 1 && arrayList != null && arrayList.size() > 0) {
                        Iterator<AlarmVideo> it = arrayList.iterator();
                        while (it.hasNext()) {
                            AlarmVideo next = it.next();
                            if (next.fileId == null || !next.fileId.equalsIgnoreCase(AlarmVideoNormalPlayerActivityNew.this.fileId)) {
                                next.isPlaying = false;
                            } else {
                                next.isPlaying = true;
                            }
                        }
                    }
                    if (AlarmVideoNormalPlayerActivityNew.this.mRecordList == null || AlarmVideoNormalPlayerActivityNew.this.mRecordList.size() <= 0) {
                        AlarmVideoNormalPlayerActivityNew.this.mAlarmVideoAdapter.update(AlarmVideoNormalPlayerActivityNew.this.mRecordList);
                        AlarmVideoNormalPlayerActivityNew.this.ll_empty_content.setVisibility(0);
                        TextView textView = AlarmVideoNormalPlayerActivityNew.this.tv_request_result;
                        AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew2 = AlarmVideoNormalPlayerActivityNew.this;
                        textView.setText(alarmVideoNormalPlayerActivityNew2.getEmptyStringByType(alarmVideoNormalPlayerActivityNew2.mCurEventType.name));
                        AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setEnabled(true);
                        return;
                    }
                    AlarmVideoNormalPlayerActivityNew.this.ll_empty_content.setVisibility(8);
                    AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setVisibility(0);
                    AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setEnabled(true);
                    if (!z) {
                        AlarmVideoNormalPlayerActivityNew.this.lambda$initVideoList$2$AlarmVideoNormalPlayerActivityNew();
                        AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setMode(1);
                        AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setLoadMore(false);
                        if (AlarmVideoNormalPlayerActivityNew.this.mRecordList.size() < AlarmVideoNormalPlayerActivityNew.this.mVisibleItemCount) {
                            AlarmVideoNormalPlayerActivityNew.this.mAlarmVideoAdapter.setToTheEnd(false);
                        } else {
                            AlarmVideoNormalPlayerActivityNew.this.mAlarmVideoAdapter.setToTheEnd(true);
                        }
                    } else {
                        AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew3 = AlarmVideoNormalPlayerActivityNew.this;
                        alarmVideoNormalPlayerActivityNew3.mEndTime = j;
                        alarmVideoNormalPlayerActivityNew3.mAlarmVideoAdapter.setToTheEnd(false);
                        AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setMode(3);
                        AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setLoadMore(false);
                    }
                    AlarmVideoNormalPlayerActivityNew.this.mAlarmVideoAdapter.update(AlarmVideoNormalPlayerActivityNew.this.mRecordList);
                    if (AlarmVideoNormalPlayerActivityNew.this.dateNoneDefault) {
                        AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew4 = AlarmVideoNormalPlayerActivityNew.this;
                        alarmVideoNormalPlayerActivityNew4.dateNoneDefault = false;
                        alarmVideoNormalPlayerActivityNew4.rv_event_list.scrollToPosition(AlarmVideoNormalPlayerActivityNew.this.index);
                    }
                }

                public void onFailure(int i, String str) {
                    AlarmVideoNormalPlayerActivityNew.this.hideLoadingView();
                    AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                    alarmVideoNormalPlayerActivityNew.isNetRefreshing = false;
                    if (alarmVideoNormalPlayerActivityNew.ptrLayout.isRefreshing()) {
                        AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setRefreshing(false);
                    }
                    AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setLoadMore(false);
                    if (i == 1) {
                        AlarmVideoNormalPlayerActivityNew.this.mRecordList.clear();
                        AlarmVideoNormalPlayerActivityNew.this.mAlarmVideoAdapter.update(AlarmVideoNormalPlayerActivityNew.this.mRecordList);
                        AlarmVideoNormalPlayerActivityNew.this.ll_empty_content.setVisibility(0);
                        TextView textView = AlarmVideoNormalPlayerActivityNew.this.tv_request_result;
                        AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew2 = AlarmVideoNormalPlayerActivityNew.this;
                        textView.setText(alarmVideoNormalPlayerActivityNew2.getEmptyStringByType(alarmVideoNormalPlayerActivityNew2.mCurEventType.name));
                        AlarmVideoNormalPlayerActivityNew.this.ptrLayout.setMode(1);
                    }
                }
            });
        }
    }

    private void smoothScrollToPosition(final int i) {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass11 */

            public void run() {
                TopSmoothScroller topSmoothScroller = new TopSmoothScroller(AlarmVideoNormalPlayerActivityNew.this.getContext());
                topSmoothScroller.setTargetPosition(i);
                if (AlarmVideoNormalPlayerActivityNew.this.rv_event_list.getLayoutManager() != null) {
                    AlarmVideoNormalPlayerActivityNew.this.rv_event_list.getLayoutManager().startSmoothScroll(topSmoothScroller);
                }
            }
        });
    }

    public void getVideoUrl(boolean z) {
        String videoFileUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(this.mCameraDevice.getDid(), this.fileId, this.isAlarm);
        gsy.O00000Oo("AlarmVideoNormalPlayerActivity", "videoUrl = ".concat(String.valueOf(videoFileUrl)));
        if (!TextUtils.isEmpty(videoFileUrl)) {
            HashMap hashMap = new HashMap();
            MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
            if (tokenInfo != null) {
                hashMap.put("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0);
                this.generalVideoView.O000000o(videoFileUrl, hashMap);
                this.generalVideoView.getPlayer().O000000o((long) (this.offset * 3000));
            }
        }
    }

    public void onBtnClick(final AlarmVideo alarmVideo, int i, boolean z) {
        final FaceInfoMeta faceInfoMeta = alarmVideo.fileIdMetaResult.faceInfoMetas.get(0);
        chr.O000000o("u5v.u1o.4k5.em4");
        if (z) {
            FaceUtils.processMarkFace(this, faceInfoMeta.faceId, FaceManager.getInstance(this.mCameraDevice), new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass12 */

                public void onSuccess(Object obj, Object obj2) {
                    gqg.O00000Oo((int) R.string.action_success);
                    try {
                        JSONObject jSONObject = (JSONObject) obj2;
                        String optString = jSONObject.optString("id");
                        String optString2 = jSONObject.optString("name");
                        faceInfoMeta.matched = true;
                        faceInfoMeta.figureId = optString;
                        faceInfoMeta.figureName = optString2;
                        AlarmVideoNormalPlayerActivityNew.this.mAlarmVideoAdapter.notifyDataSetChanged();
                        alarmVideo.fileIdMetaResult.faceInfoMetas.set(0, faceInfoMeta);
                        AlarmVideoNormalPlayerActivityNew.this.mAlarmEventOperationListAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        cki.O00000oO("AlarmVideoNormalPlayerActivity", e.toString());
                    }
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            });
        } else {
            FaceUtils.processReplaceFace(getContext(), faceInfoMeta.faceId, faceInfoMeta.figureId, faceInfoMeta.figureName, FaceManager.getInstance(this.mCameraDevice), new FaceManager.IFaceCallback<Object>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass13 */

                public void onSuccess(Object obj, Object obj2) {
                    gqg.O00000Oo((int) R.string.action_success);
                    try {
                        JSONObject jSONObject = (JSONObject) obj2;
                        String optString = jSONObject.optString("id");
                        String optString2 = jSONObject.optString("name");
                        faceInfoMeta.matched = true;
                        faceInfoMeta.figureId = optString;
                        faceInfoMeta.figureName = optString2;
                        AlarmVideoNormalPlayerActivityNew.this.mAlarmVideoAdapter.notifyDataSetChanged();
                        alarmVideo.fileIdMetaResult.faceInfoMetas.set(0, faceInfoMeta);
                        AlarmVideoNormalPlayerActivityNew.this.mAlarmEventOperationListAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        cki.O00000oO("AlarmVideoNormalPlayerActivity", e.toString());
                    }
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            });
        }
    }

    public void getUserStatus() {
        CloudVideoNetUtils.getInstance().getCloudStatus(this, this.mDid, new ICloudVideoCallback<CloudVideoUserStatus>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass14 */

            public void onCloudVideoSuccess(CloudVideoUserStatus cloudVideoUserStatus, Object obj) {
                if (!AlarmVideoNormalPlayerActivityNew.this.isFinishing()) {
                    civ.O000000o("user status", cloudVideoUserStatus.toString());
                    if (cloudVideoUserStatus == null) {
                        AlarmVideoNormalPlayerActivityNew.this.mUserStatus = new CloudVideoUserStatus();
                        AlarmVideoNormalPlayerActivityNew.this.mUserStatus.setDefault(true);
                    } else {
                        AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                        alarmVideoNormalPlayerActivityNew.mUserStatus = cloudVideoUserStatus;
                        if (alarmVideoNormalPlayerActivityNew.isFromRn) {
                            AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.O00000oO().O00000o0(AlarmVideoNormalPlayerActivityNew.this.mUserStatus.vip);
                        }
                    }
                    AlarmVideoNormalPlayerActivityNew.this.updateSelectParamByUserStatus();
                }
            }

            public void onCloudVideoFailed(int i, String str) {
                if (!AlarmVideoNormalPlayerActivityNew.this.isFinishing()) {
                    AlarmVideoNormalPlayerActivityNew.this.mUserStatus = new CloudVideoUserStatus();
                    AlarmVideoNormalPlayerActivityNew.this.mUserStatus.setDefault(true);
                    AlarmVideoNormalPlayerActivityNew.this.updateSelectParamByUserStatus();
                }
            }
        });
    }

    public void updateSelectParamByUserStatus() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUserStatus.isDefault() || !this.mUserStatus.vip || this.mUserStatus.endTime < currentTimeMillis || this.mUserStatus.startTime > currentTimeMillis) {
            updateEventType(false);
            CEn7DayRecyclerAdapterNew.CLOUD_DAYS = 6;
            long currentTimeMillis2 = System.currentTimeMillis();
            this.custom_calendar.initRecycler(activity());
            this.custom_calendar.addHaveVideoDay(DateUtils.getCalendarDate(currentTimeMillis2 - (CEn7DayRecyclerAdapterNew.CLOUD_DAYS * 86400000)));
            this.custom_calendar.refreshFlag();
            return;
        }
        updateEventType(true);
        int i = this.mUserStatus.rollingSaveInterval;
        if (i <= 8) {
            CEn7DayRecyclerAdapterNew.CLOUD_DAYS = 7;
        } else if (i <= 16) {
            CEn7DayRecyclerAdapterNew.CLOUD_DAYS = 15;
        } else {
            CEn7DayRecyclerAdapterNew.CLOUD_DAYS = 30;
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        this.custom_calendar.initRecycler(activity());
        this.custom_calendar.addHaveVideoDay(DateUtils.getCalendarDate(currentTimeMillis3 - (CEn7DayRecyclerAdapterNew.CLOUD_DAYS * 86400000)));
        this.custom_calendar.refreshFlag();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        if (android.text.TextUtils.equals(r13, "Default") != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        if (android.text.TextUtils.equals(r13, "ObjectMotion") != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        if (android.text.TextUtils.equals(r13, "PeopleMotion") != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007d, code lost:
        if (android.text.TextUtils.equals(r13, "BabyCry") != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        if (android.text.TextUtils.equals(r13, "Face") != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0090, code lost:
        if (android.text.TextUtils.equals(r13, "BabyCry") != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0098, code lost:
        if (android.text.TextUtils.equals(r13, "Face") != false) goto L_0x005f;
     */
    private void updateEventType(boolean z) {
        int i;
        boolean z2 = z;
        this.mAlarmVideoAdapter.setVipStatus(z2);
        boolean z3 = (this.localAlarmEventTypes & 1) != 0;
        boolean z4 = (this.localAlarmEventTypes & 4) != 0;
        boolean z5 = (this.localAlarmEventTypes & 64) != 0;
        boolean z6 = (this.localAlarmEventTypes & 16) != 0;
        boolean z7 = (this.localAlarmEventTypes & 32) != 0;
        final ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z8 = false;
        for (int length = this.eventTypes.length; i2 < length; length = i) {
            String str = this.eventTypes[i2];
            if (this.isFromRn) {
                if (this.isNewRNPlugin) {
                    if (!z3) {
                    }
                    if (!z7) {
                    }
                    if (!z6) {
                    }
                    if (!z5) {
                    }
                    if (!z4) {
                    }
                    i = length;
                } else if (!z2) {
                    if (!z5) {
                    }
                    if (!z4) {
                    }
                    i = length;
                } else {
                    i = length;
                    if (DeviceModelManager.getInstance().showNoFaceAndCryEventType(this.mCameraDevice.getModel())) {
                        if (!TextUtils.equals(str, "BabyCry")) {
                            if (TextUtils.equals(str, "Face")) {
                            }
                        }
                        i2++;
                    }
                }
                i = length;
                i2++;
            } else {
                i = length;
                if (!z2 && !"chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
                    if (!DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) {
                        if (!TextUtils.equals(str, "BabyCry")) {
                            if (TextUtils.equals(str, "Face")) {
                            }
                        }
                        i2++;
                    } else if (TextUtils.equals(str, "Face")) {
                        i2++;
                    }
                }
                if (CoreApi.O000000o().O0000O0o() && ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && !"chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
                    if (!DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) {
                        if (!TextUtils.equals(str, "BabyCry")) {
                            if (TextUtils.equals(str, "Face")) {
                            }
                        }
                        i2++;
                    } else if (TextUtils.equals(str, "Face")) {
                        i2++;
                    }
                }
            }
            if ((!this.mHasAISceneBuilt || !"AI".equals(this.eventTypes[i2]) || this.mCameraDevice.isOwner()) && ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel()) || !"Pet".equals(this.eventTypes[i2]))) {
                EventType eventType = new EventType();
                eventType.name = this.eventTypes[i2];
                eventType.desc = this.eventTypesDesc[i2];
                arrayList.add(eventType);
                if (this.mCurEventType.name.equals(eventType.name)) {
                    z8 = true;
                }
            }
            i2++;
        }
        if (!z8) {
            this.mCurEventType.name = this.eventTypes[0];
            this.mCurEventType.desc = this.eventTypesDesc[0];
            this.mCameraDevice.O00000oO().O00000Oo(this.mCurEventType.name);
        }
        this.tv_all_record.setText(this.mCurEventType.desc);
        this.eventTypeAdapter = new RecyclerEventTypeAdapter(this, arrayList, new RecyclerEventTypeAdapter.OnItemClick() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass15 */

            public void onItemClick(int i) {
                AlarmVideoNormalPlayerActivityNew.this.mCurEventType = (EventType) arrayList.get(i);
                AlarmVideoNormalPlayerActivityNew.this.tv_all_record.setText(AlarmVideoNormalPlayerActivityNew.this.mCurEventType.desc);
                AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.O00000oO().O00000Oo(AlarmVideoNormalPlayerActivityNew.this.mCurEventType.name);
                AlarmVideoNormalPlayerActivityNew.this.onEventTypeBgClick();
                AlarmVideoNormalPlayerActivityNew.this.refreshContent();
                int i2 = 1;
                if (!"Default".equalsIgnoreCase(AlarmVideoNormalPlayerActivityNew.this.mCurEventType.name)) {
                    if ("ObjectMotion".equalsIgnoreCase(AlarmVideoNormalPlayerActivityNew.this.mCurEventType.name)) {
                        i2 = 2;
                    } else if ("PeopleMotion".equalsIgnoreCase(AlarmVideoNormalPlayerActivityNew.this.mCurEventType.name)) {
                        i2 = 3;
                    } else if ("BabyCry".equalsIgnoreCase(AlarmVideoNormalPlayerActivityNew.this.mCurEventType.name)) {
                        i2 = 4;
                    } else if ("Face".equalsIgnoreCase(AlarmVideoNormalPlayerActivityNew.this.mCurEventType.name)) {
                        i2 = 5;
                    } else if ("AI".equalsIgnoreCase(AlarmVideoNormalPlayerActivityNew.this.mCurEventType.name)) {
                        i2 = 6;
                    }
                }
                chr.O000000o("u5v.u1o.4k5.9yf", "type", Integer.valueOf(i2));
            }
        });
        this.event_type_recycler.setLayoutManager(new GridLayoutManager(activity(), 2));
        this.event_type_recycler.setAdapter(this.eventTypeAdapter);
    }

    public void onItemClick(View view, AlarmVideo alarmVideo, int i) {
        if (view.getId() == R.id.iv_add_face || view.getId() == R.id.icon_face || view.getId() == R.id.tv_event_time || view.getId() == R.id.tv_event_des) {
            onBtnClick(alarmVideo, i, !alarmVideo.isKnownFace);
        } else if (view.getId() == R.id.tv_feed_back && alarmVideo != null) {
            showFeedbackDialog(this.fileId, (alarmVideo.eventType.equals("Face") || alarmVideo.eventType.equals("KnownFace")) ? "face" : alarmVideo.eventType);
        }
    }

    public void onEventTypeBgClick() {
        showOrHideEventType(false, null);
    }

    public void showOrHideEventType(boolean z, AnimUtil.AnimEndListener animEndListener) {
        if (z) {
            AnimUtil.animLayoutTop(activity(), true, null, this.ll_calendar_bg, this.event_type_recycler, animEndListener);
            this.iv_more_record.setImageResource(R.drawable.icon_select_up);
            this.tv_all_record.setTextColor(getResources().getColorStateList(R.color.mj_color_green_normal));
            return;
        }
        AnimUtil.animLayoutTop(activity(), false, null, this.ll_calendar_bg, this.event_type_recycler, animEndListener);
        this.iv_more_record.setImageResource(R.drawable.icon_select_down);
        this.tv_all_record.setTextColor(getResources().getColorStateList(R.color.mj_color_black));
    }

    private void showLoadingView() {
        ImageView imageView = this.mLoadingView;
        if (imageView != null) {
            imageView.setVisibility(0);
            Drawable drawable = this.mLoadingView.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).start();
            }
        }
    }

    public void hideLoadingView() {
        ImageView imageView = this.mLoadingView;
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).stop();
            }
            this.mLoadingView.setVisibility(8);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew, int]
     candidates:
      _m_j.gpc.O000000o(android.app.Activity, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.content.Context, float):int */
    /* renamed from: calculateHeight */
    public void lambda$initVideoList$2$AlarmVideoNormalPlayerActivityNew() {
        this.mVisibleItemCount = (int) Math.ceil((double) (((float) this.rv_event_list.getMeasuredHeight()) / (((float) gpc.O000000o((Context) this, 88.0f)) * 1.0f)));
    }

    public void showOrHideCalendar(boolean z, AnimUtil.AnimEndListener animEndListener) {
        if (z) {
            AnimUtil.animLayoutTop(activity(), true, null, this.ll_calendar_bg, this.calendar_container, animEndListener);
            this.iv_next_day.setImageResource(R.drawable.icon_select_up);
            this.tv_cur_day.setTextColor(getResources().getColorStateList(R.color.mj_color_green_normal));
            return;
        }
        AnimUtil.animLayoutTop(activity(), false, null, this.ll_calendar_bg, this.calendar_container, animEndListener);
        this.iv_next_day.setImageResource(R.drawable.icon_select_down);
        this.tv_cur_day.setTextColor(getResources().getColorStateList(R.color.mj_color_black));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public String getEmptyStringByType(String str) {
        char c;
        switch (str.hashCode()) {
            case -1293551627:
                if (str.equals("ObjectMotion")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1085510111:
                if (str.equals("Default")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -740191200:
                if (str.equals("KnownFace")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2088:
                if (str.equals("AI")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2181757:
                if (str.equals("Face")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 722651973:
                if (str.equals("PeopleMotion")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1316906260:
                if (str.equals("BabyCry")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return getString(R.string.empty_video_list_for_default);
            case 1:
                return getString(R.string.empty_video_list_for_moving_obj);
            case 2:
                return getString(R.string.empty_video_list_for_moving_body);
            case 3:
            case 4:
                return getString(R.string.empty_video_list_for_face);
            case 5:
                return getString(R.string.empty_video_list_for_baby_cry);
            case 6:
                return getString(R.string.empty_video_list_for_ai);
            default:
                return getString(R.string.empty_video_list_for_default);
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
    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return || view.getId() == R.id.ivBack2) {
            onBackPressed();
        } else if (view.getId() == R.id.ll_all_record) {
            onAllRecordClicked();
        } else if (view.getId() == R.id.iv_next_day || view.getId() == R.id.tv_cur_day) {
            onSelectDayClick();
        } else if (view.getId() == R.id.ll_calendar_bg) {
            if (this.calendar_container.getVisibility() == 0) {
                onCalendarBgClicked();
            } else if (this.event_type_recycler.getVisibility() == 0) {
                onEventTypeBgClick();
            }
        } else if (view.getId() == R.id.see_all_video) {
            chr.O000000o(chr.oooOoO);
            showOrHideCalendar(false, null);
            if (this.isV4) {
                startActivityForResult(new Intent(this, AlarmDayV2Activity.class), 17);
            } else {
                startActivityForResult(new Intent(this, com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.class), 17);
            }
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
        } else if (view.getId() == R.id.tvCloudStorageHint) {
            CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(this, this.mCameraDevice.getDid());
            chr.O000000o("u5v.u1o.4k5.ax0");
        }
    }

    private void tryShare() {
        chr.O000000o(chr.O00oOOoo);
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
            return;
        }
        this.isSharing = true;
        if (CloudVideoNetUtils.getInstance().isWifiConnected(this)) {
            doDownload();
        } else {
            new ButtonAdaptiveDialog.Builder(this).setTitle(getString(R.string.cs_non_wifi_environment)).setConfirmText(getString(R.string.action_continue), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass17 */

                public void onClick(View view) {
                    AlarmVideoNormalPlayerActivityNew.this.doDownload();
                    if (AlarmVideoNormalPlayerActivityNew.this.mCameraDevice != null && AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.O00000oO().O00000Oo()) {
                        AlarmVideoNormalPlayerActivityNew.this.showDownloadActivityHint();
                    }
                }
            }).setCancle(getString(R.string.cs_cancel), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass16 */

                public void onClick(View view) {
                }
            }).build().show();
        }
    }

    public void onBackPressed() {
        if (this.mFullScreen) {
            exitFullScreen(null);
        } else {
            super.onBackPressed();
        }
    }

    private void tryDownload() {
        chr.O000000o(chr.O000oooO);
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            gqg.O000000o((int) R.string.no_write_permission);
            return;
        }
        this.isSharing = false;
        if (CloudVideoNetUtils.getInstance().isWifiConnected(this)) {
            doDownload();
        } else {
            new ButtonAdaptiveDialog.Builder(this).setTitle(getString(R.string.cs_non_wifi_environment)).setConfirmText(getString(R.string.action_continue), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass19 */

                public void onClick(View view) {
                    AlarmVideoNormalPlayerActivityNew.this.doDownload();
                    if (AlarmVideoNormalPlayerActivityNew.this.mCameraDevice != null && AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.O00000oO().O00000Oo()) {
                        AlarmVideoNormalPlayerActivityNew.this.showDownloadActivityHint();
                    }
                }
            }).setCancle(getString(R.string.cs_cancel), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass18 */

                public void onClick(View view) {
                }
            }).build().show();
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
            cloudVideoDownloadInfo.startTime = this.createTime;
            cloudVideoDownloadInfo.endTime = this.mStartTime + O00000o;
            cloudVideoDownloadInfo.duration = O00000o / 1000;
            cloudVideoDownloadInfo.createTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.createTime));
            cloudVideoDownloadInfo.startTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.startTime));
            cloudVideoDownloadInfo.endTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.endTime));
            cloudVideoDownloadInfo.size = 0;
            cloudVideoDownloadInfo.progress = 0;
            boolean z = this.isAlarm;
            cloudVideoDownloadInfo.isAlarm = z;
            if (!z) {
                showDownloadActivityHint();
                CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).addListener(this.mCloudVideoDownloadListener);
            } else {
                showLoading();
                CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).addListener(this.mCloudVideoDownloadListener);
            }
            arrayList.add(cloudVideoDownloadInfo);
            CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).insertRecords(arrayList);
            CloudVideoDownloadManager.getInstance(this.mCameraDevice.getModel()).pullDownloadFromList(getContext(), O000000o2.userId, this.mCameraDevice.getDid());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.me.O000000o(boolean, java.lang.String):java.lang.String
     arg types: [int, java.lang.String]
     candidates:
      _m_j.me.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.me.O000000o(boolean, java.lang.String):java.lang.String */
    public void m3u8ToMp4(String str) {
        String O000000o2 = me.O000000o(true, this.mCameraDevice.getDid());
        new M3u8ToMp4Task(this.isSharing).execute(str, O000000o2);
    }

    private void showDeleteVideoDialog() {
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_delete_video)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass23 */

            public void onClick(DialogInterface dialogInterface, int i) {
                AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.O00000oo().deleteFiles(new Callback() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass23.AnonymousClass1 */

                    public void onFailure(int i, String str) {
                    }

                    public void onSuccess(Object obj) {
                        AlarmVideoNormalPlayerActivityNew.this.deleteSwitchVideo();
                        AlarmVideoNormalPlayerActivityNew.this.refreshContent();
                    }
                }, AlarmVideoNormalPlayerActivityNew.this.isAlarm, AlarmVideoNormalPlayerActivityNew.this.fileId);
            }
        }).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass22 */

            public void onCancel(DialogInterface dialogInterface) {
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass21 */

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).O00000oo();
    }

    public void deleteSwitchVideo() {
        AlarmVideo alarmVideo;
        if (this.mAlarmVideoAdapter.getItemCount() > 1) {
            if (this.mAlarmVideoAdapter.isTheLastVideo(this.currentPosition)) {
                alarmVideo = this.mAlarmVideoAdapter.getItem(0);
                this.currentPosition = 0;
            } else {
                alarmVideo = this.mAlarmVideoAdapter.getItem(this.currentPosition + 1);
                this.currentPosition++;
            }
            if (alarmVideo != null) {
                this.createTime = alarmVideo.createTime;
                this.fileId = alarmVideo.fileId;
                this.offset = alarmVideo.offset;
                this.isAlarm = alarmVideo.isAlarm;
                getVideoUrl(false);
                setFeedbackData(alarmVideo);
                return;
            }
            return;
        }
        finish();
    }

    private void onSelectDayClick() {
        chr.O000000o("u5v.u1o.4k5.g2i");
        boolean z = false;
        if (this.event_type_recycler.getVisibility() == 0) {
            showOrHideEventType(false, new AnimUtil.AnimEndListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass24 */

                public void animEnd() {
                    AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                    alarmVideoNormalPlayerActivityNew.showOrHideCalendar(alarmVideoNormalPlayerActivityNew.calendar_container.getVisibility() != 0, null);
                }
            });
            return;
        }
        if (this.calendar_container.getVisibility() != 0) {
            z = true;
        }
        showOrHideCalendar(z, null);
    }

    private void onAllRecordClicked() {
        boolean z = false;
        if (this.calendar_container.getVisibility() == 0) {
            showOrHideCalendar(false, new AnimUtil.AnimEndListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass25 */

                public void animEnd() {
                    AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                    alarmVideoNormalPlayerActivityNew.showOrHideEventType(alarmVideoNormalPlayerActivityNew.event_type_recycler.getVisibility() != 0, null);
                }
            });
            return;
        }
        if (this.event_type_recycler.getVisibility() != 0) {
            z = true;
        }
        showOrHideEventType(z, null);
    }

    public void onCalendarBgClicked() {
        showOrHideCalendar(false, null);
    }

    class M3u8ToMp4Task extends AsyncTask<String, Void, String> {
        boolean isSharing;

        M3u8ToMp4Task(boolean z) {
            this.isSharing = z;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0114 A[SYNTHETIC, Splitter:B:52:0x0114] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0150 A[Catch:{ Exception -> 0x019e }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0155 A[Catch:{ Exception -> 0x019e }] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0191 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0195 A[SYNTHETIC, Splitter:B:67:0x0195] */
        public String doInBackground(String... strArr) {
            BufferedOutputStream bufferedOutputStream;
            int videoConverter;
            IOException e;
            try {
                String str = strArr[0];
                String str2 = strArr[1];
                File[] listFiles = new File(str).listFiles();
                if (listFiles == null) {
                    return "";
                }
                List<File> asList = Arrays.asList(listFiles);
                Collections.sort(asList, new Comparator<File>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.M3u8ToMp4Task.AnonymousClass1 */

                    public int compare(File file, File file2) {
                        return file.getName().compareTo(file2.getName());
                    }
                });
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for (File absolutePath : asList) {
                    String absolutePath2 = absolutePath.getAbsolutePath();
                    if (absolutePath2.contains(".ts")) {
                        sb.append("file '" + absolutePath2 + "'\r\n");
                    } else if (absolutePath2.contains("mp4")) {
                        sb2.append("file '" + absolutePath2 + "'\r\n");
                    }
                }
                gsy.O00000Oo("M3u8ToMp4Task", "concat =  " + sb.toString() + " concatMp4 = " + sb2.toString());
                if (TextUtils.isEmpty(sb) && TextUtils.isEmpty(sb2)) {
                    return "";
                }
                File file = new File(str + "/fileList.txt");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        if (!TextUtils.isEmpty(sb)) {
                            bufferedOutputStream.write(sb.toString().getBytes());
                        } else if (!TextUtils.isEmpty(sb2)) {
                            bufferedOutputStream.write(sb2.toString().getBytes());
                        }
                        bufferedOutputStream.flush();
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            String str3 = "ffmpeg -f concat -safe 0 -i " + file.getAbsolutePath() + " -c copy " + str2;
                            gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str3)));
                            videoConverter = XmPluginHostApi.instance().videoConverter(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getModel(), str3);
                            if (videoConverter == 0) {
                            }
                            if (videoConverter != 0) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e6) {
                    bufferedOutputStream = null;
                    e = e6;
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                    }
                    String str32 = "ffmpeg -f concat -safe 0 -i " + file.getAbsolutePath() + " -c copy " + str2;
                    gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str32)));
                    videoConverter = XmPluginHostApi.instance().videoConverter(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getModel(), str32);
                    if (videoConverter == 0) {
                    }
                    if (videoConverter != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
                String str322 = "ffmpeg -f concat -safe 0 -i " + file.getAbsolutePath() + " -c copy " + str2;
                gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str322)));
                videoConverter = XmPluginHostApi.instance().videoConverter(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getModel(), str322);
                if (videoConverter == 0) {
                    deleteM3U8();
                }
                if (videoConverter != 0) {
                    return "";
                }
                if (AlarmVideoNormalPlayerActivityNew.this.mDeviceStat == null || DeviceConstant.shouldInsertIntoNonDidAlbum(AlarmVideoNormalPlayerActivityNew.this.mDeviceStat.model)) {
                    return str2;
                }
                File file2 = new File(str2);
                MediaStoreUtil.O00000Oo(AlarmVideoNormalPlayerActivityNew.this.getContext(), str2, AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getDid(), file2.getName());
                String replaceFirst = str2.replaceFirst("/Xiaomi/local", "").replaceFirst("file://", "");
                file2.delete();
                return replaceFirst;
            } catch (Exception unused) {
                return "";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (!AlarmVideoNormalPlayerActivityNew.this.isFinishing()) {
                gsy.O00000Oo("M3u8ToMp4Task", "onPostExecute result ".concat(String.valueOf(str)));
                AlarmVideoNormalPlayerActivityNew.this.hideLoading();
                if (!TextUtils.isEmpty(str)) {
                    if (this.isSharing) {
                        AlarmVideoNormalPlayerActivityNew alarmVideoNormalPlayerActivityNew = AlarmVideoNormalPlayerActivityNew.this;
                        alarmVideoNormalPlayerActivityNew.openShareVideoActivity(alarmVideoNormalPlayerActivityNew, "", "", str, 1);
                        return;
                    }
                    gqg.O00000Oo((int) R.string.save_success);
                } else if (this.isSharing) {
                    gqg.O00000Oo((int) R.string.share_failed);
                } else {
                    gqg.O00000Oo((int) R.string.save_fail);
                }
            }
        }

        private void deleteM3U8() {
            Device O000000o2 = fno.O000000o().O000000o(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getDid());
            if (O000000o2 != null) {
                List<CloudVideoDownloadInfo> records = CloudVideoDownloadManager.getInstance(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getModel()).getRecords(O000000o2.userId, O000000o2.did);
                CloudVideoDownloadInfo cloudVideoDownloadInfo = null;
                for (int i = 0; i < records.size(); i++) {
                    cloudVideoDownloadInfo = records.get(i);
                    if (cloudVideoDownloadInfo.fileId.equals(AlarmVideoNormalPlayerActivityNew.this.fileId)) {
                        break;
                    }
                }
                if (cloudVideoDownloadInfo != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(cloudVideoDownloadInfo);
                    CloudVideoDownloadManager.getInstance(AlarmVideoNormalPlayerActivityNew.this.mCameraDevice.getModel()).deleteRecords(arrayList);
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 17 && i2 == -1) {
                refreshContent();
            }
        } else if (i2 == -1) {
            chr.O000000o(chr.O00O000o);
        }
    }

    public void showLoading() {
        this.loadingContainer.setVisibility(0);
        this.loadingCircle.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_rotate_360));
    }

    public void hideLoading() {
        this.loadingCircle.clearAnimation();
        this.loadingContainer.setVisibility(8);
    }

    public void showDownloadActivityHint() {
        this.tvDownloadHint.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew.AnonymousClass26 */

            public void run() {
                if (AlarmVideoNormalPlayerActivityNew.this.tvDownloadHint != null) {
                    AlarmVideoNormalPlayerActivityNew.this.tvDownloadHint.setVisibility(8);
                }
            }
        }, 5000);
    }
}
