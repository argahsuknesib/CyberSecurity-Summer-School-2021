package com.xiaomi.smarthome.camera.activity.alarm2;

import _m_j.cb;
import _m_j.chr;
import _m_j.civ;
import _m_j.cki;
import _m_j.ftn;
import _m_j.gpc;
import _m_j.hny;
import _m_j.hor;
import _m_j.hxi;
import _m_j.oOOO0oOO;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.alarmcloud.AlarmCloudCallback;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter2;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.RecyclerEventTypeAdapter2;
import com.xiaomi.smarthome.camera.activity.alarm2.bean.EventType;
import com.xiaomi.smarthome.camera.activity.sdcard.fragment.DateRecyclerAdapter2;
import com.xiaomi.smarthome.camera.view.calendar.CEn7DayRecyclerAdapterNew;
import com.xiaomi.smarthome.camera.view.calendar.CalendarDate;
import com.xiaomi.smarthome.camera.view.calendar.DateUtils;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayoutEx;
import com.xiaomi.smarthome.device.api.BaseDevice;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoUserStatus;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoUtils;
import com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryActivity;
import com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryGuideActivity;
import com.xiaomi.smarthome.miio.camera.face.model.DailyStoryList;
import com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AlarmVideoActivityNew extends BaseAlarmVideoPlayerActivity implements View.OnClickListener, BaseDevice.StateChangedListener {
    public static long ONE_DAY = 86400000;
    private static final String[] mDevicePropKeys = {"electricity"};
    private final int UPDATE_CHECK = 3051;
    Button btn_daily_story;
    public DailyStoryList dailyStoryList;
    List<CloudVideoDate> dateListDays = new ArrayList();
    public DateRecyclerAdapter2 dateListViewAdapter;
    FrameLayout dialog_new_alarm_events;
    RecyclerEventTypeAdapter2 eventTypeAdapter;
    RecyclerView event_type_recycler;
    public MLAlertDialog event_types_dialog;
    public boolean isFromRn;
    public boolean isNetRefreshing = false;
    private boolean isNewRNPlugin;
    ImageView iv_more_record;
    private boolean licenseDialogShow = false;
    hny liteScenceListenernew = new hny() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass5 */

        public void onRefreshScenceSuccess(int i) {
            if (!AlarmVideoActivityNew.this.isFinishing() && AlarmVideoActivityNew.this.isValid()) {
                if ((hor.O000000o().isSceneManagerInited() ? hor.O000000o().getLiteSceneSizeByDid(AlarmVideoActivityNew.this.mCameraDevice.getDid()) : 0) > 0) {
                    AlarmVideoActivityNew alarmVideoActivityNew = AlarmVideoActivityNew.this;
                    alarmVideoActivityNew.mHasAISceneBuilt = true;
                    if (alarmVideoActivityNew.eventTypeAdapter != null && AlarmVideoActivityNew.this.eventTypeAdapter.getItemCount() > 0 && !AlarmVideoActivityNew.this.eventTypeAdapter.containsAiType()) {
                        EventType eventType = new EventType();
                        eventType.name = AlarmVideoActivityNew.this.eventTypes[AlarmVideoActivityNew.this.eventTypes.length - 1];
                        eventType.desc = AlarmVideoActivityNew.this.eventTypesDesc[AlarmVideoActivityNew.this.eventTypesDesc.length - 1];
                        AlarmVideoActivityNew.this.eventTypeAdapter.addEvent(eventType);
                        return;
                    }
                    return;
                }
                AlarmVideoActivityNew.this.mHasAISceneBuilt = false;
            }
        }

        public void onRefreshScenceFailed(int i) {
            AlarmVideoActivityNew.this.mHasAISceneBuilt = false;
        }
    };
    LinearLayout ll_empty_content;
    LinearLayout ll_title_bar;
    private int localAlarmEventTypes;
    public AlarmVideoAdapter2 mAlarmVideoAdapter = null;
    public EventType mCurEventType = new EventType();
    public long mEndPoint = 0;
    public long mEndTime = 0;
    public boolean mHasAISceneBuilt;
    LayoutInflater mLayoutInflater;
    private hny mListener = new hny() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass4 */

        public void onRefreshScenceSuccess(int i) {
            if (!AlarmVideoActivityNew.this.isFinishing() && AlarmVideoActivityNew.this.isValid()) {
                if ((hor.O000000o().isSceneManagerInited() ? hor.O000000o().getCustomSceneSizeByDid(AlarmVideoActivityNew.this.mCameraDevice.getDid()) : 0) > 0) {
                    AlarmVideoActivityNew alarmVideoActivityNew = AlarmVideoActivityNew.this;
                    alarmVideoActivityNew.mHasAISceneBuilt = true;
                    if (alarmVideoActivityNew.eventTypeAdapter != null && AlarmVideoActivityNew.this.eventTypeAdapter.getItemCount() > 0 && !AlarmVideoActivityNew.this.eventTypeAdapter.containsAiType()) {
                        EventType eventType = new EventType();
                        eventType.name = AlarmVideoActivityNew.this.eventTypes[AlarmVideoActivityNew.this.eventTypes.length - 1];
                        eventType.desc = AlarmVideoActivityNew.this.eventTypesDesc[AlarmVideoActivityNew.this.eventTypesDesc.length - 1];
                        AlarmVideoActivityNew.this.eventTypeAdapter.addEvent(eventType);
                        return;
                    }
                    return;
                }
                AlarmVideoActivityNew alarmVideoActivityNew2 = AlarmVideoActivityNew.this;
                alarmVideoActivityNew2.mHasAISceneBuilt = false;
                alarmVideoActivityNew2.updateLiteScene();
            }
        }

        public void onRefreshScenceFailed(int i) {
            AlarmVideoActivityNew alarmVideoActivityNew = AlarmVideoActivityNew.this;
            alarmVideoActivityNew.mHasAISceneBuilt = false;
            alarmVideoActivityNew.updateLiteScene();
        }
    };
    private ImageView mLoadingView;
    private boolean mNeedLicense = false;
    protected boolean mNeedPincode = false;
    public List<AlarmVideo> mRecordList = new ArrayList();
    private SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
    public CalendarDate mSelectedDate = DateUtils.getCalendarDate(System.currentTimeMillis());
    public volatile long mStartPoint = 0;
    public long mStartTime = 0;
    public CloudVideoUserStatus mUserStatus;
    public int mVisibleItemCount;
    RecyclerViewRefreshLayoutEx ptrLayout;
    RelativeLayout rl_daily_story;
    RecyclerView rv_event_list;
    TextView sub_title_bar_title;
    private int targetHeight = -1;
    RecyclerView time_line_date_list;
    ImageView title_bar_more;
    ImageView title_bar_redpoint;
    TextView title_bar_title;
    TextView tv_all_record;
    TextView tv_cur_day;
    TextView tv_request_result;

    interface AgreeListener {
        void onOk();

        void onPass();
    }

    private void checkIsAgreeLicense(AgreeListener agreeListener) {
    }

    static /* synthetic */ void lambda$updateEventType$2(DialogInterface dialogInterface, int i) {
    }

    public void onStateChanged(BaseDevice baseDevice) {
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        if (getApplicationContext() != null) {
            this.mLayoutInflater = LayoutInflater.from(getApplicationContext());
        }
        if (getIntent() != null) {
            this.isFromRn = getIntent().getBooleanExtra("is_from_rn", false);
            this.localAlarmEventTypes = getIntent().getIntExtra("localAlarmEventType", 0);
            this.isNewRNPlugin = getIntent().getBooleanExtra("isNewPlugin", false);
        }
        boolean booleanExtra = getIntent().getBooleanExtra("skipPwd", false);
        if (!getIntent().getBooleanExtra("pincod", true) && !booleanExtra) {
            globalPinCodeVerifyFunc();
            if (this.mCameraDevice.O0000oO()) {
                this.mNeedPincode = true;
            }
        }
        setContentView((int) R.layout.activity_alarm_video2_new);
        findView();
        initEventType();
        initView();
        initData();
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoActivityNew$FydrvvuH64MT9GMqSXiwVrE_M */

            public final void run() {
                AlarmVideoActivityNew.this.lambda$doCreate$0$AlarmVideoActivityNew();
            }
        });
        refreshContent();
        this.createTime = System.currentTimeMillis();
        if (this.isFromRn) {
            chr.O000000o(this.mDid, XmPluginHostApi.instance().getDeviceByDid(this.mDid).model);
        }
    }

    private void initEventType() {
        this.mCurEventType.name = this.eventTypes[0];
        this.mCurEventType.desc = this.eventTypesDesc[0];
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.content.Context, float):int
     arg types: [com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew, int]
     candidates:
      _m_j.gpc.O000000o(android.app.Activity, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.content.Context, float):int */
    /* renamed from: calculateHeight */
    public void lambda$doCreate$0$AlarmVideoActivityNew() {
        this.mVisibleItemCount = (int) Math.ceil((double) (((float) this.rv_event_list.getMeasuredHeight()) / (((float) gpc.O000000o((Context) this, 88.0f)) * 1.0f)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void findView() {
        long currentDayTS0 = CloudVideoUtils.getCurrentDayTS0();
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        this.title_bar_more.setImageResource(R.drawable.mj_webp_titlebar_setting_nor);
        this.title_bar_more.setVisibility((this.mCameraDevice.isReadOnlyShared() || this.isFromRn) ? 8 : 0);
        this.title_bar_more.setOnClickListener(this);
        this.title_bar_title = (TextView) findViewById(R.id.title_bar_title);
        this.sub_title_bar_title = (TextView) findViewById(R.id.sub_title_bar_title);
        this.tv_cur_day = (TextView) findViewById(R.id.tv_cur_day);
        this.tv_cur_day.setOnClickListener(this);
        this.iv_more_record = (ImageView) findViewById(R.id.iv_more_record);
        this.ptrLayout = (RecyclerViewRefreshLayoutEx) findViewById(R.id.ptr);
        this.tv_all_record = (TextView) findViewById(R.id.tv_all_record);
        this.rv_event_list = (RecyclerView) findViewById(R.id.rv_event_list);
        this.dialog_new_alarm_events = (FrameLayout) this.mLayoutInflater.inflate((int) R.layout.dialog_new_alarm_events, (ViewGroup) null, false);
        this.event_type_recycler = (RecyclerView) this.dialog_new_alarm_events.findViewById(R.id.event_type_recycler);
        this.ll_empty_content = (LinearLayout) findViewById(R.id.ll_empty_content);
        this.tv_request_result = (TextView) findViewById(R.id.tv_request_result);
        this.title_bar_redpoint = (ImageView) findViewById(R.id.title_bar_redpoint);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.ll_all_record).setOnClickListener(this);
        this.mLoadingView = (ImageView) findViewById(R.id.ivLoading);
        this.mLoadingView.setImageDrawable(getResources().getDrawable(R.drawable.camera_loading));
        this.time_line_date_list = (RecyclerView) findViewById(R.id.time_line_date_list);
        this.dateListViewAdapter = new DateRecyclerAdapter2(getContext(), R.drawable.cs_icon_date_selected_bg);
        this.time_line_date_list.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.time_line_date_list.setAdapter(this.dateListViewAdapter);
        this.dateListViewAdapter.setListener(new DateRecyclerAdapter2.IItemClickListener(currentDayTS0) {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoActivityNew$w1ZLW4KNsJP68fZXmvYqEwBgQTA */
            private final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemClick(View view, int i, Object obj) {
                AlarmVideoActivityNew.this.lambda$findView$1$AlarmVideoActivityNew(this.f$1, view, i, (CloudVideoDate) obj);
            }
        });
        updateTopCalendar();
    }

    public /* synthetic */ void lambda$findView$1$AlarmVideoActivityNew(long j, View view, int i, CloudVideoDate cloudVideoDate) {
        DateRecyclerAdapter2 dateRecyclerAdapter2 = this.dateListViewAdapter;
        dateRecyclerAdapter2.selectedItemPosition = i;
        dateRecyclerAdapter2.notifyDataSetChanged();
        CloudVideoDate cloudVideoDate2 = (CloudVideoDate) this.dateListViewAdapter.getItem(i);
        try {
            this.mSelectedDate = DateUtils.getCalendarDate(cloudVideoDate2.timeStamp);
        } catch (Exception e) {
            cki.O00000o("AlarmVideoActivity", e.toString());
        }
        cki.O00000o("AlarmVideoActivity", cloudVideoDate2.dateStr);
        this.mEndTime = cloudVideoDate2.endTime;
        this.mStartPoint = cloudVideoDate2.startTime;
        this.mStartTime = this.mStartPoint;
        this.mEndPoint = this.mEndTime;
        long j2 = this.mStartTime;
        if (j2 + 1 <= j || j2 + 1 >= j + ONE_DAY) {
            this.tv_cur_day.setText(DateUtils.getMonthDay(this.mStartTime + 1));
        } else {
            this.tv_cur_day.setText(String.format("%s %s", DateUtils.getMonthDay(j2 + 1), getString(R.string.today)));
        }
        refreshContent();
    }

    private void updateTopCalendar() {
        this.dateListDays.clear();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long currentDayTS0 = CloudVideoUtils.getCurrentDayTS0();
        Calendar instance = Calendar.getInstance();
        for (long j = CEn7DayRecyclerAdapterNew.CLOUD_DAYS; j >= 0; j--) {
            CloudVideoDate cloudVideoDate = new CloudVideoDate();
            long j2 = currentDayTS0 - (j * 86400000);
            instance.setTime(new Date(j2));
            String format = simpleDateFormat.format(Long.valueOf(j2));
            cloudVideoDate.day = format.split("-")[2];
            cloudVideoDate.month = format.split("-")[1];
            cloudVideoDate.year = format.split("-")[0];
            cloudVideoDate.week = instance.get(7) - 1;
            cloudVideoDate.timeStamp = j2;
            cloudVideoDate.startTime = j2;
            cloudVideoDate.endTime = (j2 + 86400000) - 1;
            cloudVideoDate.isHasVideo = true;
            this.dateListDays.add(cloudVideoDate);
        }
        this.dateListViewAdapter.setData(this.dateListDays);
        this.time_line_date_list.scrollToPosition(this.dateListViewAdapter.getItemCount() - 1);
        DateRecyclerAdapter2 dateRecyclerAdapter2 = this.dateListViewAdapter;
        dateRecyclerAdapter2.selectedItemPosition = dateRecyclerAdapter2.getItemCount() - 1;
    }

    private void initView() {
        this.tv_cur_day.setText(String.format("%s %s", DateUtils.getMonthDay(System.currentTimeMillis() + 1), getString(R.string.today)));
        this.mAlarmVideoAdapter = new AlarmVideoAdapter2(this, this.mCameraDevice, true);
        this.mAlarmVideoAdapter.setOnItemClickedListener(new AlarmVideoAdapter2.ItemClickedListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass1 */

            public void onPlaying(AlarmVideo alarmVideo, int i, String str, String str2) {
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
            public void onItemClicked(final AlarmVideo alarmVideo, int i, String str, String str2, View view) {
                AlarmVideoActivityNew.this.mCameraDevice.O00000oo().markEvent(alarmVideo.fileId, alarmVideo.offset, new Callback<Boolean>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass1.AnonymousClass1 */

                    public void onSuccess(Boolean bool) {
                        if (!AlarmVideoActivityNew.this.isFinishing() && bool.booleanValue()) {
                            alarmVideo.isRead = true;
                            if (AlarmVideoActivityNew.this.mRecordList != null && AlarmVideoActivityNew.this.mRecordList.indexOf(alarmVideo) != -1) {
                                AlarmVideoActivityNew.this.mAlarmVideoAdapter.notifyItemChanged(AlarmVideoActivityNew.this.mRecordList.indexOf(alarmVideo));
                            }
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (AlarmVideoActivityNew.this.isFinishing()) {
                        }
                    }
                });
                if (AlarmVideoActivityNew.this.mUserStatus == null || !AlarmVideoActivityNew.this.mUserStatus.vip || DeviceModelManager.getInstance().isMijiaCameraV1(AlarmVideoActivityNew.this.mDeviceStat.model)) {
                    Intent intent = new Intent(AlarmVideoActivityNew.this.getContext(), AlarmVideoNormalPlayerActivityNew.class);
                    intent.putExtra("fileId", alarmVideo.fileId);
                    intent.putExtra("isAlarm", alarmVideo.isAlarm);
                    intent.putExtra("createTime", alarmVideo.createTime);
                    intent.putExtra("offset", alarmVideo.offset);
                    intent.putExtra("dateTime", AlarmVideoActivityNew.this.mSelectedDate);
                    intent.putExtra("index", i);
                    intent.putExtra("pincod", true);
                    intent.putExtra("isFromRn", AlarmVideoActivityNew.this.isFromRn);
                    intent.putExtra("is_v4", AlarmVideoActivityNew.this.isV4);
                    intent.putExtra("Alarm_SN", cb.O0000oo0(view));
                    intent.putExtra("alarmVideo", alarmVideo);
                    AlarmVideoActivityNew.this.startActivityForResult(intent, 17, oOOO0oOO.O000000o(AlarmVideoActivityNew.this, view, cb.O0000oo0(view)).O000000o());
                    return;
                }
                Intent intent2 = new Intent(AlarmVideoActivityNew.this.getContext(), AlarmVideoPlayerActivityNew.class);
                intent2.putExtra("fileId", alarmVideo.fileId);
                intent2.putExtra("isAlarm", alarmVideo.isAlarm);
                intent2.putExtra("createTime", alarmVideo.createTime);
                intent2.putExtra("offset", alarmVideo.offset);
                intent2.putExtra("startDuration", alarmVideo.startDuration);
                intent2.putExtra("pincod", true);
                intent2.putExtra("isFromRn", AlarmVideoActivityNew.this.isFromRn);
                intent2.putExtra("Alarm_SN", cb.O0000oo0(view));
                AlarmVideoActivityNew.this.startActivityForResult(intent2, 1001, oOOO0oOO.O000000o(AlarmVideoActivityNew.this, view, cb.O0000oo0(view)).O000000o());
            }
        });
        ((TextView) findViewById(R.id.title_bar_title)).setText(getString(R.string.housekeeping_v4));
        int width = getWindowManager().getDefaultDisplay().getWidth();
        if (this.targetHeight == -1) {
            this.targetHeight = (width * 720) / 1280;
        }
        initRecycler();
        initPtr();
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

    public void initRecycler() {
        this.rv_event_list.setLayoutManager(new LinearLayoutManager(activity(), 1, false));
        this.rv_event_list.setAdapter(this.mAlarmVideoAdapter);
        this.rv_event_list.setHasFixedSize(true);
    }

    public void initPtr() {
        this.ptrLayout.setFooterRefreshView(LayoutInflater.from(this).inflate((int) R.layout.camera_list_load_more, (ViewGroup) null));
        this.ptrLayout.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass2 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                if (!AlarmVideoActivityNew.this.isFinishing()) {
                    AlarmVideoActivityNew.this.refreshContent();
                }
            }
        });
        this.ptrLayout.setOnPushLoadMoreListener(new RecyclerViewRefreshLayout.OnPushLoadMoreListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass3 */

            public void onPushDistance(int i) {
            }

            public void onPushEnable(boolean z) {
            }

            public void onLoadMore() {
                if (!AlarmVideoActivityNew.this.isFinishing()) {
                    AlarmVideoActivityNew alarmVideoActivityNew = AlarmVideoActivityNew.this;
                    alarmVideoActivityNew.getEventList(alarmVideoActivityNew.mStartTime, AlarmVideoActivityNew.this.mEndTime, 2);
                }
            }
        });
    }

    private void initData() {
        long todayStartTime = getTodayStartTime();
        long currentTimeMillis = System.currentTimeMillis();
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

    public void onResume() {
        super.onResume();
        if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            initDailyStory();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
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

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        hor.O000000o().unregisterCustomSceneCallback(this.mListener);
        hor.O000000o().unregisterLiteSceneCallback(this.liteScenceListenernew);
        long currentTimeMillis = System.currentTimeMillis() - this.createTime;
        if (this.isFromRn) {
            chr.O000000o("u5v.u1o.4k5.5e7", "time", Integer.valueOf((int) (currentTimeMillis / 1000)));
        }
    }

    public void getEventList(long j, long j2, final int i) {
        civ.O000000o("AlarmVideoActivity", "startTime=" + j + " endTime=" + j2);
        if (this.mUserStatus == null) {
            getUserStatus();
        } else if (!this.isNetRefreshing) {
            this.isNetRefreshing = true;
            if (i == 1) {
                this.ptrLayout.setLoadMore(true);
                this.ptrLayout.setRefreshing(false);
                this.ptrLayout.setMode(3);
                this.mAlarmVideoAdapter.setToTheEnd(false);
                this.ll_empty_content.setVisibility(8);
            }
            this.mCameraDevice.O00000oo().getEventList(this.mCurEventType.name, j, j2, new AlarmCloudCallback<ArrayList<AlarmVideo>>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass6 */

                public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj, long j, boolean z) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj), j, z);
                }

                public void onSuccess(ArrayList<AlarmVideo> arrayList, long j, boolean z) {
                    if (!AlarmVideoActivityNew.this.isFinishing()) {
                        AlarmVideoActivityNew.this.hideLoadingView();
                        AlarmVideoActivityNew alarmVideoActivityNew = AlarmVideoActivityNew.this;
                        alarmVideoActivityNew.isNetRefreshing = false;
                        if (alarmVideoActivityNew.ptrLayout.isRefreshing()) {
                            AlarmVideoActivityNew.this.ptrLayout.setRefreshing(false);
                        }
                        if (arrayList == null || arrayList.size() <= 0 || CloudVideoUtils.getDayTS0(arrayList.get(0).createTime) == CloudVideoUtils.getDayTS0(AlarmVideoActivityNew.this.mStartPoint)) {
                            if (i == 1) {
                                AlarmVideoActivityNew.this.mRecordList.clear();
                            }
                            AlarmVideoActivityNew.this.mRecordList.addAll(arrayList);
                            if (AlarmVideoActivityNew.this.mRecordList == null || AlarmVideoActivityNew.this.mRecordList.size() <= 0) {
                                AlarmVideoActivityNew.this.mAlarmVideoAdapter.update(AlarmVideoActivityNew.this.mRecordList);
                                AlarmVideoActivityNew.this.ll_empty_content.setVisibility(0);
                                TextView textView = AlarmVideoActivityNew.this.tv_request_result;
                                AlarmVideoActivityNew alarmVideoActivityNew2 = AlarmVideoActivityNew.this;
                                textView.setText(alarmVideoActivityNew2.getEmptyStringByType(alarmVideoActivityNew2.mCurEventType.name));
                                AlarmVideoActivityNew.this.ptrLayout.setEnabled(true);
                                return;
                            }
                            AlarmVideoActivityNew.this.ll_empty_content.setVisibility(8);
                            AlarmVideoActivityNew.this.ptrLayout.setVisibility(0);
                            AlarmVideoActivityNew.this.ptrLayout.setEnabled(true);
                            if (!z) {
                                AlarmVideoActivityNew.this.lambda$doCreate$0$AlarmVideoActivityNew();
                                if (AlarmVideoActivityNew.this.mRecordList.size() < AlarmVideoActivityNew.this.mVisibleItemCount) {
                                    AlarmVideoActivityNew.this.mAlarmVideoAdapter.setToTheEnd(false);
                                } else {
                                    AlarmVideoActivityNew.this.mAlarmVideoAdapter.setToTheEnd(true);
                                }
                                AlarmVideoActivityNew.this.ptrLayout.setMode(1);
                                AlarmVideoActivityNew.this.ptrLayout.setLoadMore(false);
                            } else {
                                AlarmVideoActivityNew alarmVideoActivityNew3 = AlarmVideoActivityNew.this;
                                alarmVideoActivityNew3.mEndTime = j;
                                alarmVideoActivityNew3.mAlarmVideoAdapter.setToTheEnd(false);
                                AlarmVideoActivityNew.this.ptrLayout.setMode(3);
                                AlarmVideoActivityNew.this.ptrLayout.setLoadMore(false);
                            }
                            AlarmVideoActivityNew.this.mAlarmVideoAdapter.update(AlarmVideoActivityNew.this.mRecordList);
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmVideoActivityNew.this.isFinishing()) {
                        AlarmVideoActivityNew.this.hideLoadingView();
                        AlarmVideoActivityNew alarmVideoActivityNew = AlarmVideoActivityNew.this;
                        alarmVideoActivityNew.isNetRefreshing = false;
                        if (alarmVideoActivityNew.ptrLayout.isRefreshing()) {
                            AlarmVideoActivityNew.this.ptrLayout.setRefreshing(false);
                        }
                        AlarmVideoActivityNew.this.ptrLayout.setLoadMore(false);
                        if (i == 1) {
                            AlarmVideoActivityNew.this.ll_empty_content.setVisibility(0);
                            AlarmVideoActivityNew.this.mRecordList.clear();
                            AlarmVideoActivityNew.this.mAlarmVideoAdapter.update(AlarmVideoActivityNew.this.mRecordList);
                            TextView textView = AlarmVideoActivityNew.this.tv_request_result;
                            AlarmVideoActivityNew alarmVideoActivityNew2 = AlarmVideoActivityNew.this;
                            textView.setText(alarmVideoActivityNew2.getEmptyStringByType(alarmVideoActivityNew2.mCurEventType.name));
                            AlarmVideoActivityNew.this.ptrLayout.setMode(1);
                        }
                    }
                }
            });
        }
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
            case 2088:
                if (str.equals("AI")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 80127:
                if (str.equals("Pet")) {
                    c = 5;
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
                    c = 4;
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
                return getString(R.string.empty_video_list_for_face_type);
            case 4:
                return getString(R.string.empty_video_list_for_baby_cry);
            case 5:
                return getString(R.string.empty_video_list_for_pet);
            case 6:
                return getString(R.string.empty_video_list_for_ai);
            default:
                return getString(R.string.empty_video_list_for_default);
        }
    }

    public void getUserStatus() {
        CloudVideoNetUtils.getInstance().getCloudStatus(this, this.mDid, new ICloudVideoCallback<CloudVideoUserStatus>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass7 */

            public void onCloudVideoSuccess(CloudVideoUserStatus cloudVideoUserStatus, Object obj) {
                if (!AlarmVideoActivityNew.this.isFinishing()) {
                    civ.O000000o("user status", cloudVideoUserStatus.toString());
                    if (cloudVideoUserStatus == null) {
                        AlarmVideoActivityNew.this.mUserStatus = new CloudVideoUserStatus();
                        AlarmVideoActivityNew.this.mUserStatus.setDefault(true);
                    } else {
                        AlarmVideoActivityNew alarmVideoActivityNew = AlarmVideoActivityNew.this;
                        alarmVideoActivityNew.mUserStatus = cloudVideoUserStatus;
                        if (alarmVideoActivityNew.isFromRn) {
                            AlarmVideoActivityNew.this.mCameraDevice.O00000oO().O00000o0(AlarmVideoActivityNew.this.mUserStatus.vip);
                        }
                        AlarmVideoActivityNew alarmVideoActivityNew2 = AlarmVideoActivityNew.this;
                        alarmVideoActivityNew2.getEventList(alarmVideoActivityNew2.mStartPoint, AlarmVideoActivityNew.this.mEndPoint, 1);
                    }
                    AlarmVideoActivityNew.this.updateSelectParamByUserStatus();
                }
            }

            public void onCloudVideoFailed(int i, String str) {
                if (!AlarmVideoActivityNew.this.isFinishing()) {
                    AlarmVideoActivityNew.this.mUserStatus = new CloudVideoUserStatus();
                    AlarmVideoActivityNew.this.mUserStatus.setDefault(true);
                    AlarmVideoActivityNew.this.updateSelectParamByUserStatus();
                }
            }
        });
    }

    public void updateSelectParamByUserStatus() {
        civ.O000000o("lzc", this.mUserStatus.toString());
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mUserStatus.isDefault() || !this.mUserStatus.vip || this.mUserStatus.endTime < currentTimeMillis || this.mUserStatus.startTime > currentTimeMillis) {
            updateEventType(false);
            CEn7DayRecyclerAdapterNew.CLOUD_DAYS = 7;
            System.currentTimeMillis();
        } else {
            updateEventType(true);
            int i = this.mUserStatus.rollingSaveInterval;
            if (i <= 8) {
                CEn7DayRecyclerAdapterNew.CLOUD_DAYS = 7;
            } else if (i <= 16) {
                CEn7DayRecyclerAdapterNew.CLOUD_DAYS = 15;
            } else {
                CEn7DayRecyclerAdapterNew.CLOUD_DAYS = 30;
            }
        }
        updateTopCalendar();
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
            if (("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel()) || !"Pet".equals(this.eventTypes[i2])) && (this.mHasAISceneBuilt || !"AI".equals(this.eventTypes[i2]) || !this.mCameraDevice.isOwner())) {
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
        }
        this.tv_all_record.setText(this.mCurEventType.desc);
        this.eventTypeAdapter = new RecyclerEventTypeAdapter2(activity(), arrayList, new RecyclerEventTypeAdapter2.OnItemClick() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass8 */

            public void onItemClick(int i) {
                AlarmVideoActivityNew.this.mCurEventType = (EventType) arrayList.get(i);
                AlarmVideoActivityNew.this.eventTypeAdapter.selectedEventType = AlarmVideoActivityNew.this.mCurEventType.name;
                AlarmVideoActivityNew.this.tv_all_record.setText(AlarmVideoActivityNew.this.mCurEventType.desc);
                AlarmVideoActivityNew.this.refreshContent();
                int i2 = 1;
                for (int i3 = 0; i3 < AlarmVideoActivityNew.this.eventTypes.length; i3++) {
                    if (AlarmVideoActivityNew.this.eventTypes[i3].equalsIgnoreCase(AlarmVideoActivityNew.this.mCurEventType.name)) {
                        i2 = i3;
                    }
                }
                chr.O000000o("u5v.u1o.4k5.9yf", "type", Integer.valueOf(i2));
                if (AlarmVideoActivityNew.this.event_types_dialog.isShowing()) {
                    AlarmVideoActivityNew.this.event_types_dialog.dismiss();
                }
                AlarmVideoActivityNew.this.eventTypeAdapter.notifyDataSetChanged();
            }
        });
        this.event_type_recycler.setLayoutManager(new LinearLayoutManager(activity()));
        this.event_type_recycler.setAdapter(this.eventTypeAdapter);
        if (this.event_types_dialog == null) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O000000o(this.dialog_new_alarm_events);
            builder.O00000Oo((int) R.string.sh_common_cancel, $$Lambda$AlarmVideoActivityNew$BFxTPEA_yeNmyk0lJBYf6WKILd8.INSTANCE);
            this.event_types_dialog = builder.O00000o();
        }
    }

    private void initDailyStory() {
        String str;
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo != null) {
            str = O00oOooo.getCountry();
        } else {
            str = Locale.getDefault().getCountry();
        }
        DailyStoryNetUtils.getInstance().getDailyStoryList(this.mDid, 1, this.mCameraDevice.getModel(), str, new DailyStoryNetUtils.ICallback<DailyStoryList>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew.AnonymousClass9 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(DailyStoryList dailyStoryList) {
                AlarmVideoActivityNew.this.dailyStoryList = dailyStoryList;
            }
        });
        this.rl_daily_story = (RelativeLayout) findViewById(R.id.rl_daily_story);
        this.rl_daily_story.setVisibility(0);
        this.btn_daily_story = (Button) findViewById(R.id.btn_daily_story);
        this.btn_daily_story.setOnClickListener(this);
    }

    public void onClick(View view) {
        DailyStoryList dailyStoryList2;
        if (view.getId() == R.id.title_bar_return) {
            finish();
        } else if (view.getId() == R.id.ll_all_record) {
            MLAlertDialog mLAlertDialog = this.event_types_dialog;
            if (mLAlertDialog != null && !mLAlertDialog.isShowing()) {
                this.event_types_dialog.show();
            }
        } else if (view.getId() == R.id.title_bar_more) {
            startActivity(new Intent(this, AlarmSettingV2Activity.class));
            chr.O000000o(chr.O00O00Oo);
        } else if (view.getId() == R.id.btn_daily_story) {
            hxi.O00000o.O0000OoO();
            if (this.mCameraDevice.O00000oO().O0000OoO || (dailyStoryList2 = this.dailyStoryList) == null || (dailyStoryList2.playUnits.size() == 0 && this.dailyStoryList.switchStatus == 0)) {
                Intent intent = new Intent(this, DailyStoryGuideActivity.class);
                DailyStoryList dailyStoryList3 = this.dailyStoryList;
                if (dailyStoryList3 != null) {
                    intent.putExtra("previewVideo", dailyStoryList3.previewVideo);
                }
                startActivity(intent);
                return;
            }
            startActivity(new Intent(this, DailyStoryActivity.class));
        }
    }

    public LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        return super.getLayoutInflater();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if ((i == 17 || i == 1001) && i2 == -1) {
            refreshContent();
        }
    }
}
