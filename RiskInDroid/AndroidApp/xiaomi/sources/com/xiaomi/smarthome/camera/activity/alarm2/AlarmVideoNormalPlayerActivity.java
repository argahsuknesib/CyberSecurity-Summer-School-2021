package com.xiaomi.smarthome.camera.activity.alarm2;

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
import _m_j.hny;
import _m_j.hor;
import _m_j.me;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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
import com.mijia.generalplayer.videoview.BasicVideoView;
import com.mijia.generalplayer.videoview.GeneralVideoView;
import com.mijia.model.alarmcloud.AlarmCloudCallback;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.BaseAlarmVideoPlayerActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.RecyclerEventTypeAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.bean.EventType;
import com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil;
import com.xiaomi.smarthome.camera.activity.alarm2.util.TopSmoothScroller;
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
import com.xiaomi.smarthome.miio.camera.face.widget.ButtonAdaptiveDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class AlarmVideoNormalPlayerActivity extends BaseAlarmVideoPlayerActivity implements View.OnClickListener {
    private static final String[] mDevicePropKeys = {"electricity"};
    private View calendar_container;
    private long createTime;
    private int currentPosition = 0;
    YdCatCalendarView custom_calendar;
    private boolean dateNoneDefault;
    private long endTime;
    RecyclerEventTypeAdapter eventTypeAdapter;
    RecyclerView event_type_recycler;
    public boolean firstEnter;
    private FrameLayout flTitleBar;
    private GeneralVideoView generalVideoView;
    private int index;
    public int initialRequestNumber = 0;
    public boolean isAlarm;
    public boolean isNetRefreshing;
    private boolean isNewRNPlugin;
    private boolean isPlayed = false;
    private boolean isSharing;
    ImageView iv_more_record;
    ImageView iv_next_day;
    hny liteScenceListenernew = new hny() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass4 */

        public void onRefreshScenceSuccess(int i) {
            if (!AlarmVideoNormalPlayerActivity.this.isFinishing() && AlarmVideoNormalPlayerActivity.this.isValid()) {
                if ((hor.O000000o().isLiteSceneInited() ? hor.O000000o().getLiteSceneSizeByDid(AlarmVideoNormalPlayerActivity.this.mCameraDevice.getDid()) : 0) > 0) {
                    AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity = AlarmVideoNormalPlayerActivity.this;
                    alarmVideoNormalPlayerActivity.mHasAISceneBuilt = true;
                    if (alarmVideoNormalPlayerActivity.eventTypeAdapter != null && AlarmVideoNormalPlayerActivity.this.eventTypeAdapter.getItemCount() > 0 && !AlarmVideoNormalPlayerActivity.this.eventTypeAdapter.containsAiType()) {
                        EventType eventType = new EventType();
                        eventType.name = AlarmVideoNormalPlayerActivity.this.eventTypes[AlarmVideoNormalPlayerActivity.this.eventTypes.length - 1];
                        eventType.desc = AlarmVideoNormalPlayerActivity.this.eventTypesDesc[AlarmVideoNormalPlayerActivity.this.eventTypesDesc.length - 1];
                        AlarmVideoNormalPlayerActivity.this.eventTypeAdapter.addEvent(eventType);
                        return;
                    }
                    return;
                }
                AlarmVideoNormalPlayerActivity.this.mHasAISceneBuilt = false;
            }
        }

        public void onRefreshScenceFailed(int i) {
            AlarmVideoNormalPlayerActivity.this.mHasAISceneBuilt = false;
        }
    };
    LinearLayout ll_calendar_bg;
    LinearLayout ll_empty_content;
    private int loadTimes;
    private View loadingCircle;
    private View loadingContainer;
    private int localAlarmEventTypes;
    public AlarmVideoAdapter mAlarmVideoAdapter = null;
    CloudVideoDownloadManager.ICloudVideoDownloadListener mCloudVideoDownloadListener = new CloudVideoDownloadManager.ICloudVideoDownloadListener() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass15 */

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
            gsy.O00000Oo("AlarmVideoNormalPlayerActivity", "onFinish " + cloudVideoDownloadInfo.m3u8LocalPath);
            if (cloudVideoDownloadInfo.fileId.equals(AlarmVideoNormalPlayerActivity.this.fileId)) {
                if (!AlarmVideoNormalPlayerActivity.this.isAlarm) {
                    gqg.O00000Oo((int) R.string.save_success);
                } else {
                    AlarmVideoNormalPlayerActivity.this.m3u8ToMp4(cloudVideoDownloadInfo.m3u8LocalPath);
                }
            }
        }

        public void onCancelled(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
            AlarmVideoNormalPlayerActivity.this.hideLoading();
            if (!AlarmVideoNormalPlayerActivity.this.isAlarm) {
                gqg.O00000Oo((int) R.string.save_fail);
            }
        }

        public void onError(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
            AlarmVideoNormalPlayerActivity.this.hideLoading();
            if (!AlarmVideoNormalPlayerActivity.this.isAlarm) {
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
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass3 */

        public void onRefreshScenceSuccess(int i) {
            if (AlarmVideoNormalPlayerActivity.this.isValid()) {
                if ((hor.O000000o().isSceneManagerInited() ? hor.O000000o().getCustomSceneSizeByDid(AlarmVideoNormalPlayerActivity.this.mCameraDevice.getDid()) : 0) > 0) {
                    AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity = AlarmVideoNormalPlayerActivity.this;
                    alarmVideoNormalPlayerActivity.mHasAISceneBuilt = true;
                    if (alarmVideoNormalPlayerActivity.eventTypeAdapter != null && AlarmVideoNormalPlayerActivity.this.eventTypeAdapter.getItemCount() > 0 && !AlarmVideoNormalPlayerActivity.this.eventTypeAdapter.containsAiType()) {
                        EventType eventType = new EventType();
                        eventType.name = AlarmVideoNormalPlayerActivity.this.eventTypes[AlarmVideoNormalPlayerActivity.this.eventTypes.length - 1];
                        eventType.desc = AlarmVideoNormalPlayerActivity.this.eventTypesDesc[AlarmVideoNormalPlayerActivity.this.eventTypesDesc.length - 1];
                        AlarmVideoNormalPlayerActivity.this.eventTypeAdapter.addEvent(eventType);
                        return;
                    }
                    return;
                }
                AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity2 = AlarmVideoNormalPlayerActivity.this;
                alarmVideoNormalPlayerActivity2.mHasAISceneBuilt = false;
                alarmVideoNormalPlayerActivity2.updateLiteScene();
            }
        }

        public void onRefreshScenceFailed(int i) {
            AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity = AlarmVideoNormalPlayerActivity.this;
            alarmVideoNormalPlayerActivity.mHasAISceneBuilt = false;
            alarmVideoNormalPlayerActivity.updateLiteScene();
        }
    };
    private ImageView mLoadingView;
    private boolean mNeedLicense = false;
    protected boolean mNeedPincode = false;
    public List<AlarmVideo> mRecordList = new ArrayList();
    private SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
    public long mStartPoint = 0;
    public long mStartTime = 0;
    private SimpleDateFormat mTimeFormat;
    public CloudVideoUserStatus mUserStatus;
    public int mVisibleItemCount;
    private int offset;
    RecyclerViewRefreshLayoutEx ptrLayout;
    RecyclerView rv_event_list;
    private CalendarDate selectedDate;
    private long storedPlayPosition = 0;
    TextView sub_title_bar_title;
    private int targetHeight = -1;
    ImageView title_bar_more;
    ImageView title_bar_redpoint;
    TextView title_bar_title;
    private TextView tvCloudStorageHint;
    private View tvDownloadHint;
    TextView tv_all_record;
    TextView tv_cur_day;
    TextView tv_request_result;
    private ViewGroup videoViewParent;

    static /* synthetic */ void lambda$showDeleteVideoDialog$7(DialogInterface dialogInterface) {
    }

    static /* synthetic */ void lambda$showDeleteVideoDialog$8(DialogInterface dialogInterface, int i) {
    }

    public boolean supportOrientationListen() {
        return true;
    }

    public void doCreate(Bundle bundle) {
        chr.O000000o(chr.O000ooo0);
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_video_normal_player_general);
        boolean booleanExtra = getIntent().getBooleanExtra("skipPwd", false);
        if (!getIntent().getBooleanExtra("pincod", false) && !booleanExtra) {
            globalPinCodeVerifyFunc();
            if (this.mCameraDevice.O0000oO()) {
                this.mNeedPincode = true;
            }
        }
        this.localAlarmEventTypes = getIntent().getIntExtra("localAlarmEventType", 0);
        this.isNewRNPlugin = getIntent().getBooleanExtra("isNewPlugin", false);
        initVideo();
        initVideoList();
        this.loadingContainer = findViewById(R.id.loading_area);
        this.loadingCircle = findViewById(R.id.image_circle);
        this.loadingContainer.setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass1 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        getUserStatus();
    }

    public void onResume() {
        super.onResume();
        if (!this.mNeedPincode && !this.isPlayed) {
            this.isPlayed = true;
            getVideoUrl(true);
        }
        this.mNeedPincode = false;
        chr.O00000o0();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GeneralVideoView generalVideoView2 = this.generalVideoView;
        if (generalVideoView2 != null) {
            generalVideoView2.O000000o(configuration);
        }
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
        this.firstEnter = true;
        this.offset = getIntent().getIntExtra("offset", 0);
        this.createTime = getIntent().getLongExtra("createTime", 0);
        this.isAlarm = getIntent().getBooleanExtra("isAlarm", true);
        this.flTitleBar = (FrameLayout) findViewById(R.id.title_bar);
        this.videoViewParent = (ViewGroup) findViewById(R.id.videoViewParent);
        this.generalVideoView = new GeneralVideoView(this);
        this.videoViewParent.addView(this.generalVideoView);
        this.generalVideoView.O000000o(this.mCameraDevice.getModel(), this.mCameraDevice.getDid());
        this.generalVideoView.setOnConfigurationChangedListener(new BasicVideoView.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$11ua66FTxhWvcnB2jhyGuafT4 */

            public final void onChangeOrientation(boolean z) {
                AlarmVideoNormalPlayerActivity.this.lambda$initVideo$0$AlarmVideoNormalPlayerActivity(z);
            }
        });
        this.generalVideoView.setPlayerListener(new ckb.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass2 */

            public void onLoadingChanged(boolean z) {
            }

            public void onPlayerStateChanged(int i) {
            }

            public void onPrepared() {
            }

            public void onPlayerError(String str) {
                AlarmVideoNormalPlayerActivity.this.setCloudStorageHintVisible(true);
            }

            public void isPlayingChanged(boolean z) {
                AlarmVideoNormalPlayerActivity.this.setCloudStorageHintVisible(!z);
            }
        });
        initPlayerAction();
        this.tvDownloadHint = findViewById(R.id.tvDownloadHint);
        this.tvDownloadHint.setOnClickListener(this);
        this.tvCloudStorageHint = (TextView) findViewById(R.id.tvCloudStorageHint);
        this.tvCloudStorageHint.setText((int) R.string.alarm_cloud_no_buy_tip);
        this.tvCloudStorageHint.setOnClickListener(this);
    }

    public /* synthetic */ void lambda$initVideo$0$AlarmVideoNormalPlayerActivity(boolean z) {
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

    private void initPlayerAction() {
        int[] iArr;
        if (!this.mCameraDevice.isReadOnlyShared()) {
            iArr = !this.isAlarm ? new int[]{ckv.camera_ic_player_snapshot, ckv.camera_ic_player_download, ckv.camera_ic_player_delete} : new int[]{ckv.camera_ic_player_snapshot, ckv.camera_ic_player_share, ckv.camera_ic_player_download, ckv.camera_ic_player_delete};
        } else {
            iArr = null;
        }
        this.generalVideoView.O000000o(iArr, new ckv.O000000o() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$ybTKaOPac5nT2cRgum_KxSP9ro */

            public final void onActionClick(int i) {
                AlarmVideoNormalPlayerActivity.this.lambda$initPlayerAction$1$AlarmVideoNormalPlayerActivity(i);
            }
        });
    }

    public /* synthetic */ void lambda$initPlayerAction$1$AlarmVideoNormalPlayerActivity(int i) {
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
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$BkndaJMy4EBBtZZl3qvrslZJDVc */

            public final void run() {
                AlarmVideoNormalPlayerActivity.this.lambda$initVideoList$2$AlarmVideoNormalPlayerActivity();
            }
        });
        refreshContent();
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
        this.calendar_container = findViewById(R.id.calendar_area);
        View findViewById = findViewById(R.id.see_all_video);
        findViewById.setOnClickListener(this);
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        this.title_bar_more.setImageResource(R.drawable.mj_webp_titlebar_setting_nor);
        this.title_bar_more.setOnClickListener(this);
        this.isFromRn = getIntent().getBooleanExtra("isFromRn", false);
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
    }

    private void initView() {
        this.mAlarmVideoAdapter = new AlarmVideoAdapter(this);
        this.mAlarmVideoAdapter.setOnItemClickedListener(new AlarmVideoAdapter.ItemClickedListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$nynDz4NMdFP1VXotce3J7fxcio */

            public final void onItemClicked(AlarmVideo alarmVideo, int i) {
                AlarmVideoNormalPlayerActivity.this.lambda$initView$3$AlarmVideoNormalPlayerActivity(alarmVideo, i);
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
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass6 */

            public void clickOnLeftPage() {
            }

            public void clickOnRightPage() {
            }

            public void clickOnDate(CalendarDate calendarDate, View view) {
                AlarmVideoNormalPlayerActivity.this.mHandler.postDelayed(new Runnable(calendarDate) {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$6$2eKyiaqlRDZQlhHgxbw37y4h1T8 */
                    private final /* synthetic */ CalendarDate f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AlarmVideoNormalPlayerActivity.AnonymousClass6.this.lambda$clickOnDate$0$AlarmVideoNormalPlayerActivity$6(this.f$1);
                    }
                }, 300);
            }

            public /* synthetic */ void lambda$clickOnDate$0$AlarmVideoNormalPlayerActivity$6(CalendarDate calendarDate) {
                AlarmVideoNormalPlayerActivity.this.showOrHideCalendar(false, null);
                long[] dayStartAndEndTimeMillis = calendarDate.getDayStartAndEndTimeMillis();
                civ.O000000o("AlarmVideoNormalPlayerActivity", calendarDate.getYear() + "-" + calendarDate.getMonth() + "-" + calendarDate.getDay());
                AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity = AlarmVideoNormalPlayerActivity.this;
                alarmVideoNormalPlayerActivity.mEndTime = dayStartAndEndTimeMillis[1];
                alarmVideoNormalPlayerActivity.mStartPoint = dayStartAndEndTimeMillis[0];
                alarmVideoNormalPlayerActivity.mStartTime = alarmVideoNormalPlayerActivity.mStartPoint;
                AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity2 = AlarmVideoNormalPlayerActivity.this;
                alarmVideoNormalPlayerActivity2.mEndPoint = alarmVideoNormalPlayerActivity2.mEndTime;
                AlarmVideoNormalPlayerActivity.this.tv_cur_day.setText(DateUtils.getMonthDay(AlarmVideoNormalPlayerActivity.this.mStartTime + 1));
                AlarmVideoNormalPlayerActivity.this.refreshContent();
            }
        });
    }

    public /* synthetic */ void lambda$initView$3$AlarmVideoNormalPlayerActivity(final AlarmVideo alarmVideo, final int i) {
        this.mCameraDevice.O00000oo().markEvent(alarmVideo.fileId, alarmVideo.offset, new Callback<Boolean>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass5 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Boolean bool) {
                if (!AlarmVideoNormalPlayerActivity.this.isFinishing() && bool.booleanValue()) {
                    alarmVideo.isRead = true;
                    if (AlarmVideoNormalPlayerActivity.this.mRecordList != null && i != -1) {
                        AlarmVideoNormalPlayerActivity.this.mAlarmVideoAdapter.notifyItemChanged(i);
                    }
                }
            }
        });
        this.currentPosition = i;
        this.createTime = alarmVideo.createTime;
        this.fileId = alarmVideo.fileId;
        this.offset = alarmVideo.offset;
        this.isAlarm = alarmVideo.isAlarm;
        initPlayerAction();
        highLightPlaying();
        getVideoUrl(true);
    }

    private void highLightPlaying() {
        this.mAlarmVideoAdapter.highLightPlaying(this.currentPosition);
    }

    private void initPtr() {
        this.ptrLayout.setFooterRefreshView(LayoutInflater.from(this).inflate((int) R.layout.camera_list_load_more, (ViewGroup) null));
        this.ptrLayout.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass7 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                if (!AlarmVideoNormalPlayerActivity.this.isFinishing()) {
                    AlarmVideoNormalPlayerActivity.this.refreshContent();
                }
            }
        });
        this.ptrLayout.setOnPushLoadMoreListener(new RecyclerViewRefreshLayout.OnPushLoadMoreListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass8 */

            public void onPushDistance(int i) {
            }

            public void onPushEnable(boolean z) {
            }

            public void onLoadMore() {
                if (!AlarmVideoNormalPlayerActivity.this.isFinishing()) {
                    AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity = AlarmVideoNormalPlayerActivity.this;
                    alarmVideoNormalPlayerActivity.getEventList(alarmVideoNormalPlayerActivity.mStartTime, AlarmVideoNormalPlayerActivity.this.mEndTime, 2);
                }
            }
        });
    }

    private void initRecycler() {
        this.rv_event_list.setLayoutManager(new LinearLayoutManager(this, 1, false));
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

    public void getEventList(long j, long j2, int i) {
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
            final int i2 = i;
            final long j3 = j;
            final long j4 = j2;
            this.mCameraDevice.O00000oo().getEventList(this.mCurEventType.name, j, j2, new AlarmCloudCallback<ArrayList<AlarmVideo>>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass9 */

                public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj, long j, boolean z) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj), j, z);
                }

                public void onSuccess(ArrayList<AlarmVideo> arrayList, long j, boolean z) {
                    AlarmVideoNormalPlayerActivity.this.hideLoadingView();
                    AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity = AlarmVideoNormalPlayerActivity.this;
                    alarmVideoNormalPlayerActivity.isNetRefreshing = false;
                    if (alarmVideoNormalPlayerActivity.ptrLayout.isRefreshing()) {
                        AlarmVideoNormalPlayerActivity.this.ptrLayout.setRefreshing(false);
                    }
                    if (i2 == 1) {
                        AlarmVideoNormalPlayerActivity.this.mRecordList.clear();
                    }
                    AlarmVideoNormalPlayerActivity.this.mRecordList.addAll(arrayList);
                    if (i2 == 1 && arrayList != null && arrayList.size() > 0) {
                        Iterator<AlarmVideo> it = arrayList.iterator();
                        while (it.hasNext()) {
                            AlarmVideo next = it.next();
                            if (next.fileId == null || !next.fileId.equalsIgnoreCase(AlarmVideoNormalPlayerActivity.this.fileId)) {
                                next.isPlaying = false;
                            } else {
                                next.isPlaying = true;
                            }
                        }
                    }
                    if (AlarmVideoNormalPlayerActivity.this.mRecordList == null || AlarmVideoNormalPlayerActivity.this.mRecordList.size() <= 0) {
                        AlarmVideoNormalPlayerActivity.this.mAlarmVideoAdapter.update(AlarmVideoNormalPlayerActivity.this.mRecordList);
                        AlarmVideoNormalPlayerActivity.this.ll_empty_content.setVisibility(0);
                        TextView textView = AlarmVideoNormalPlayerActivity.this.tv_request_result;
                        AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity2 = AlarmVideoNormalPlayerActivity.this;
                        textView.setText(alarmVideoNormalPlayerActivity2.getEmptyStringByType(alarmVideoNormalPlayerActivity2.mCurEventType.name));
                        AlarmVideoNormalPlayerActivity.this.ptrLayout.setEnabled(true);
                        return;
                    }
                    AlarmVideoNormalPlayerActivity.this.ll_empty_content.setVisibility(8);
                    AlarmVideoNormalPlayerActivity.this.ptrLayout.setVisibility(0);
                    AlarmVideoNormalPlayerActivity.this.ptrLayout.setEnabled(true);
                    if (!z) {
                        AlarmVideoNormalPlayerActivity.this.lambda$initVideoList$2$AlarmVideoNormalPlayerActivity();
                        AlarmVideoNormalPlayerActivity.this.ptrLayout.setMode(1);
                        AlarmVideoNormalPlayerActivity.this.ptrLayout.setLoadMore(false);
                        if (AlarmVideoNormalPlayerActivity.this.mRecordList.size() < AlarmVideoNormalPlayerActivity.this.mVisibleItemCount) {
                            AlarmVideoNormalPlayerActivity.this.mAlarmVideoAdapter.setToTheEnd(false);
                        } else {
                            AlarmVideoNormalPlayerActivity.this.mAlarmVideoAdapter.setToTheEnd(true);
                        }
                    } else {
                        AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity3 = AlarmVideoNormalPlayerActivity.this;
                        alarmVideoNormalPlayerActivity3.mEndTime = j;
                        alarmVideoNormalPlayerActivity3.mAlarmVideoAdapter.setToTheEnd(false);
                        AlarmVideoNormalPlayerActivity.this.ptrLayout.setMode(3);
                        AlarmVideoNormalPlayerActivity.this.ptrLayout.setLoadMore(false);
                    }
                    AlarmVideoNormalPlayerActivity.this.mAlarmVideoAdapter.update(AlarmVideoNormalPlayerActivity.this.mRecordList);
                    if (AlarmVideoNormalPlayerActivity.this.firstEnter) {
                        int i = 0;
                        while (true) {
                            if (i >= AlarmVideoNormalPlayerActivity.this.mRecordList.size()) {
                                i = -1;
                                break;
                            } else if (TextUtils.equals(AlarmVideoNormalPlayerActivity.this.mRecordList.get(i).fileId, AlarmVideoNormalPlayerActivity.this.fileId)) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            AlarmVideoNormalPlayerActivity.this.smoothScrollToPosition(i);
                            AlarmVideoNormalPlayerActivity.this.firstEnter = false;
                        } else if (z) {
                            AlarmVideoNormalPlayerActivity.this.initialRequestNumber++;
                            if (AlarmVideoNormalPlayerActivity.this.initialRequestNumber > 10) {
                                AlarmVideoNormalPlayerActivity.this.firstEnter = false;
                            } else {
                                AlarmVideoNormalPlayerActivity.this.getEventList(j3, j4, 0);
                            }
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    AlarmVideoNormalPlayerActivity.this.hideLoadingView();
                    AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity = AlarmVideoNormalPlayerActivity.this;
                    alarmVideoNormalPlayerActivity.isNetRefreshing = false;
                    if (alarmVideoNormalPlayerActivity.ptrLayout.isRefreshing()) {
                        AlarmVideoNormalPlayerActivity.this.ptrLayout.setRefreshing(false);
                    }
                    AlarmVideoNormalPlayerActivity.this.ptrLayout.setLoadMore(false);
                    if (i2 == 1) {
                        AlarmVideoNormalPlayerActivity.this.mRecordList.clear();
                        AlarmVideoNormalPlayerActivity.this.mAlarmVideoAdapter.update(AlarmVideoNormalPlayerActivity.this.mRecordList);
                        AlarmVideoNormalPlayerActivity.this.ll_empty_content.setVisibility(0);
                        TextView textView = AlarmVideoNormalPlayerActivity.this.tv_request_result;
                        AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity2 = AlarmVideoNormalPlayerActivity.this;
                        textView.setText(alarmVideoNormalPlayerActivity2.getEmptyStringByType(alarmVideoNormalPlayerActivity2.mCurEventType.name));
                        AlarmVideoNormalPlayerActivity.this.ptrLayout.setMode(1);
                    }
                }
            });
        }
    }

    public void smoothScrollToPosition(int i) {
        this.mHandler.post(new Runnable(i) {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$QNpKj7BnnpYg8BGiSH5WT3YvRJE */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                AlarmVideoNormalPlayerActivity.this.lambda$smoothScrollToPosition$4$AlarmVideoNormalPlayerActivity(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$smoothScrollToPosition$4$AlarmVideoNormalPlayerActivity(int i) {
        TopSmoothScroller topSmoothScroller = new TopSmoothScroller(getContext());
        topSmoothScroller.setTargetPosition(i);
        if (this.rv_event_list.getLayoutManager() != null) {
            this.rv_event_list.getLayoutManager().startSmoothScroll(topSmoothScroller);
        }
    }

    private void getVideoUrl(boolean z) {
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

    public void getUserStatus() {
        CloudVideoNetUtils.getInstance().getCloudStatus(this, this.mDid, new ICloudVideoCallback<CloudVideoUserStatus>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass10 */

            public void onCloudVideoSuccess(CloudVideoUserStatus cloudVideoUserStatus, Object obj) {
                if (!AlarmVideoNormalPlayerActivity.this.isFinishing()) {
                    civ.O000000o("user status", cloudVideoUserStatus.toString());
                    if (cloudVideoUserStatus == null) {
                        AlarmVideoNormalPlayerActivity.this.mUserStatus = new CloudVideoUserStatus();
                        AlarmVideoNormalPlayerActivity.this.mUserStatus.setDefault(true);
                    } else {
                        AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity = AlarmVideoNormalPlayerActivity.this;
                        alarmVideoNormalPlayerActivity.mUserStatus = cloudVideoUserStatus;
                        if (alarmVideoNormalPlayerActivity.isFromRn) {
                            AlarmVideoNormalPlayerActivity.this.mCameraDevice.O00000oO().O00000o0(AlarmVideoNormalPlayerActivity.this.mUserStatus.vip);
                        }
                        AlarmVideoNormalPlayerActivity alarmVideoNormalPlayerActivity2 = AlarmVideoNormalPlayerActivity.this;
                        alarmVideoNormalPlayerActivity2.getEventList(alarmVideoNormalPlayerActivity2.mStartPoint, AlarmVideoNormalPlayerActivity.this.mEndPoint, 1);
                    }
                    AlarmVideoNormalPlayerActivity.this.updateSelectParamByUserStatus();
                }
            }

            public void onCloudVideoFailed(int i, String str) {
                if (!AlarmVideoNormalPlayerActivity.this.isFinishing()) {
                    AlarmVideoNormalPlayerActivity.this.mUserStatus = new CloudVideoUserStatus();
                    AlarmVideoNormalPlayerActivity.this.mUserStatus.setDefault(true);
                    AlarmVideoNormalPlayerActivity.this.updateSelectParamByUserStatus();
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
            this.custom_calendar.mCalendarDayAdapter.chooseDate(DateUtils.getCalendarDate(this.createTime));
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
        this.custom_calendar.mCalendarDayAdapter.chooseDate(DateUtils.getCalendarDate(this.createTime));
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
        ArrayList arrayList = new ArrayList();
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
            if ((this.mHasAISceneBuilt || !"AI".equals(this.eventTypes[i2]) || !this.mCameraDevice.isOwner()) && (("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel()) || !"Pet".equals(this.eventTypes[i2])) && (!"BabyCry".equals(this.eventTypes[i2]) || clf.f14036O000000o))) {
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
        this.eventTypeAdapter = new RecyclerEventTypeAdapter(this, arrayList, new RecyclerEventTypeAdapter.OnItemClick(arrayList) {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$9lOjFsw9xVDZ9bYX5ljyJ0rol3s */
            private final /* synthetic */ ArrayList f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemClick(int i) {
                AlarmVideoNormalPlayerActivity.this.lambda$updateEventType$5$AlarmVideoNormalPlayerActivity(this.f$1, i);
            }
        });
        this.event_type_recycler.setLayoutManager(new GridLayoutManager(activity(), 2));
        this.event_type_recycler.setAdapter(this.eventTypeAdapter);
    }

    public /* synthetic */ void lambda$updateEventType$5$AlarmVideoNormalPlayerActivity(ArrayList arrayList, int i) {
        this.mCurEventType = (EventType) arrayList.get(i);
        this.tv_all_record.setText(this.mCurEventType.desc);
        this.mCameraDevice.O00000oO().O00000Oo(this.mCurEventType.name);
        onEventTypeBgClick();
        refreshContent();
        int i2 = 1;
        for (int i3 = 0; i3 < this.eventTypes.length; i3++) {
            if (this.eventTypes[i3].equalsIgnoreCase(this.mCurEventType.name)) {
                i2 = i3;
            }
        }
        chr.O000000o("u5v.u1o.4k5.9yf", "type", Integer.valueOf(i2));
    }

    private void onEventTypeBgClick() {
        showOrHideEventType(false, null);
    }

    private void showOrHideEventType(boolean z, AnimUtil.AnimEndListener animEndListener) {
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
     arg types: [com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.app.Activity, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.content.Context, float):int */
    /* renamed from: calculateHeight */
    public void lambda$initVideoList$2$AlarmVideoNormalPlayerActivity() {
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
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 80127:
                if (str.equals("Pet")) {
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
                return getString(R.string.empty_video_list_for_pet);
            case 7:
                return getString(R.string.empty_video_list_for_ai);
            default:
                return getString(R.string.empty_video_list_for_default);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
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
            Intent intent = new Intent(this, CloudVideoDownloadActivity.class);
            intent.putExtra("did", this.mCameraDevice.getDid());
            intent.putExtra("title", this.mCameraDevice.getName());
            Device O000000o2 = fno.O000000o().O000000o(this.mCameraDevice.getDid());
            if (O000000o2 != null) {
                intent.putExtra("uid", O000000o2.userId);
                startActivity(intent);
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
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass12 */

                public void onClick(View view) {
                    AlarmVideoNormalPlayerActivity.this.doDownload();
                }
            }).setCancle(getString(R.string.cs_cancel), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass11 */

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
            new ButtonAdaptiveDialog.Builder(this).setTitle(getString(R.string.cs_non_wifi_environment)).setConfirmText(getString(R.string.cs_go_on), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass14 */

                public void onClick(View view) {
                    AlarmVideoNormalPlayerActivity.this.doDownload();
                }
            }).setCancle(getString(R.string.cs_cancel), new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass13 */

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
            long j = this.mStartTime;
            cloudVideoDownloadInfo.startTime = j;
            cloudVideoDownloadInfo.endTime = j + O00000o;
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
        new BaseAlarmVideoPlayerActivity.M3u8ToMp4Task(this.isSharing).execute(str, O000000o2);
    }

    /* access modifiers changed from: package-private */
    public void afterM3u8ToMp4Task(String str, boolean z) {
        if (!isFinishing()) {
            hideLoading();
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    openShareVideoActivity(this, "", "", str, 1);
                } else {
                    gqg.O00000Oo((int) R.string.save_success);
                }
            } else if (z) {
                gqg.O00000Oo((int) R.string.share_failed);
            } else {
                gqg.O00000Oo((int) R.string.save_fail);
            }
        }
    }

    private void showDeleteVideoDialog() {
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.cs_delete_video)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$NQABF2449hdRHbOyrEH9U9GTqg0 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmVideoNormalPlayerActivity.this.lambda$showDeleteVideoDialog$6$AlarmVideoNormalPlayerActivity(dialogInterface, i);
            }
        }).O000000o($$Lambda$AlarmVideoNormalPlayerActivity$mS2eBhadNg6hpr8RFTOp3lSA_RQ.INSTANCE).O00000Oo((int) R.string.sh_common_cancel, $$Lambda$AlarmVideoNormalPlayerActivity$18nKYC9z7r7zsGNyx32GicH6T8c.INSTANCE).O00000oo();
    }

    public /* synthetic */ void lambda$showDeleteVideoDialog$6$AlarmVideoNormalPlayerActivity(DialogInterface dialogInterface, int i) {
        this.mCameraDevice.O00000oo().deleteFiles(new Callback() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity.AnonymousClass16 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Object obj) {
                AlarmVideoNormalPlayerActivity.this.deleteSwitchVideo();
                AlarmVideoNormalPlayerActivity.this.refreshContent();
            }
        }, this.isAlarm, this.fileId);
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
                /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$sdtXdIvk4wkZ_GkcF5ho3w0B59U */

                public final void animEnd() {
                    AlarmVideoNormalPlayerActivity.this.lambda$onSelectDayClick$9$AlarmVideoNormalPlayerActivity();
                }
            });
            return;
        }
        if (this.calendar_container.getVisibility() != 0) {
            z = true;
        }
        showOrHideCalendar(z, null);
    }

    public /* synthetic */ void lambda$onSelectDayClick$9$AlarmVideoNormalPlayerActivity() {
        showOrHideCalendar(this.calendar_container.getVisibility() != 0, null);
    }

    private void onAllRecordClicked() {
        boolean z = false;
        if (this.calendar_container.getVisibility() == 0) {
            showOrHideCalendar(false, new AnimUtil.AnimEndListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$J9VzzicM1Q82THuGMOrxsghHks */

                public final void animEnd() {
                    AlarmVideoNormalPlayerActivity.this.lambda$onAllRecordClicked$10$AlarmVideoNormalPlayerActivity();
                }
            });
            return;
        }
        if (this.event_type_recycler.getVisibility() != 0) {
            z = true;
        }
        showOrHideEventType(z, null);
    }

    public /* synthetic */ void lambda$onAllRecordClicked$10$AlarmVideoNormalPlayerActivity() {
        showOrHideEventType(this.event_type_recycler.getVisibility() != 0, null);
    }

    public void onCalendarBgClicked() {
        showOrHideCalendar(false, null);
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

    private void showDownloadActivityHint() {
        this.tvDownloadHint.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoNormalPlayerActivity$g5DDXV44d_7bTL_Po5uAKEVWU3c */

            public final void run() {
                AlarmVideoNormalPlayerActivity.this.lambda$showDownloadActivityHint$11$AlarmVideoNormalPlayerActivity();
            }
        }, 3000);
    }

    public /* synthetic */ void lambda$showDownloadActivityHint$11$AlarmVideoNormalPlayerActivity() {
        View view = this.tvDownloadHint;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
