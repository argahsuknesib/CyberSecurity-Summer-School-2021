package com.xiaomi.smarthome.camera.activity.alarm2;

import _m_j.chr;
import _m_j.civ;
import _m_j.clf;
import _m_j.fsp;
import _m_j.ftn;
import _m_j.gpc;
import _m_j.hny;
import _m_j.hor;
import _m_j.hxi;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.alarmcloud.AlarmCloudCallback;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.RecyclerEventTypeAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.bean.EventType;
import com.xiaomi.smarthome.camera.activity.alarm2.util.AnimUtil;
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDayV2Activity;
import com.xiaomi.smarthome.camera.view.calendar.CEn7DayRecyclerAdapterNew;
import com.xiaomi.smarthome.camera.view.calendar.CalendarDate;
import com.xiaomi.smarthome.camera.view.calendar.DateUtils;
import com.xiaomi.smarthome.camera.view.calendar.YdCatCalendarView;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayoutEx;
import com.xiaomi.smarthome.device.api.BaseDevice;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoUserStatus;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryActivity;
import com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryGuideActivity;
import com.xiaomi.smarthome.miio.camera.face.model.DailyStoryList;
import com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AlarmVideoActivity extends BaseAlarmVideoPlayerActivity implements View.OnClickListener, BaseDevice.StateChangedListener {
    private static final String[] mDevicePropKeys = {"electricity"};
    private final int UPDATE_CHECK = 3051;
    Button btn_daily_story;
    public View calendar_container;
    YdCatCalendarView custom_calendar;
    public DailyStoryList dailyStoryList;
    RecyclerEventTypeAdapter eventTypeAdapter;
    RecyclerView event_type_recycler;
    public boolean isFromRn;
    public boolean isNetRefreshing = false;
    public boolean isNewRNPlugin;
    ImageView iv_more_record;
    ImageView iv_next_day;
    private boolean licenseDialogShow = false;
    hny liteScenceListenernew = new hny() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass6 */

        public void onRefreshScenceSuccess(int i) {
            if (!AlarmVideoActivity.this.isFinishing() && AlarmVideoActivity.this.isValid()) {
                if ((hor.O000000o().isSceneManagerInited() ? hor.O000000o().getLiteSceneSizeByDid(AlarmVideoActivity.this.mCameraDevice.getDid()) : 0) > 0) {
                    AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                    alarmVideoActivity.mHasAISceneBuilt = true;
                    if (alarmVideoActivity.eventTypeAdapter != null && AlarmVideoActivity.this.eventTypeAdapter.getItemCount() > 0 && !AlarmVideoActivity.this.eventTypeAdapter.containsAiType()) {
                        EventType eventType = new EventType();
                        eventType.name = AlarmVideoActivity.this.eventTypes[AlarmVideoActivity.this.eventTypes.length - 1];
                        eventType.desc = AlarmVideoActivity.this.eventTypesDesc[AlarmVideoActivity.this.eventTypesDesc.length - 1];
                        AlarmVideoActivity.this.eventTypeAdapter.addEvent(eventType);
                        return;
                    }
                    return;
                }
                AlarmVideoActivity.this.mHasAISceneBuilt = false;
            }
        }

        public void onRefreshScenceFailed(int i) {
            AlarmVideoActivity.this.mHasAISceneBuilt = false;
        }
    };
    LinearLayout ll_calendar_bg;
    LinearLayout ll_empty_content;
    LinearLayout ll_title_bar;
    public int localAlarmEventTypes;
    public AlarmVideoAdapter mAlarmVideoAdapter = null;
    public EventType mCurEventType = new EventType();
    public long mEndPoint = 0;
    public long mEndTime = 0;
    public boolean mHasAISceneBuilt;
    LayoutInflater mLayoutInflater;
    private hny mListener = new hny() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass5 */

        public void onRefreshScenceSuccess(int i) {
            if (!AlarmVideoActivity.this.isFinishing() && AlarmVideoActivity.this.isValid()) {
                if ((hor.O000000o().isSceneManagerInited() ? hor.O000000o().getCustomSceneSizeByDid(AlarmVideoActivity.this.mCameraDevice.getDid()) : 0) > 0) {
                    AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                    alarmVideoActivity.mHasAISceneBuilt = true;
                    if (alarmVideoActivity.eventTypeAdapter != null && AlarmVideoActivity.this.eventTypeAdapter.getItemCount() > 0 && !AlarmVideoActivity.this.eventTypeAdapter.containsAiType()) {
                        EventType eventType = new EventType();
                        eventType.name = AlarmVideoActivity.this.eventTypes[AlarmVideoActivity.this.eventTypes.length - 1];
                        eventType.desc = AlarmVideoActivity.this.eventTypesDesc[AlarmVideoActivity.this.eventTypesDesc.length - 1];
                        AlarmVideoActivity.this.eventTypeAdapter.addEvent(eventType);
                        return;
                    }
                    return;
                }
                AlarmVideoActivity alarmVideoActivity2 = AlarmVideoActivity.this;
                alarmVideoActivity2.mHasAISceneBuilt = false;
                alarmVideoActivity2.updateLiteScene();
            }
        }

        public void onRefreshScenceFailed(int i) {
            AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
            alarmVideoActivity.mHasAISceneBuilt = false;
            alarmVideoActivity.updateLiteScene();
        }
    };
    private ImageView mLoadingView;
    private boolean mNeedLicense = false;
    public List<AlarmVideo> mRecordList = new ArrayList();
    private SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
    public CalendarDate mSelectedDate;
    public long mStartPoint = 0;
    public long mStartTime = 0;
    public CloudVideoUserStatus mUserStatus;
    public int mVisibleItemCount;
    RecyclerViewRefreshLayoutEx ptrLayout;
    RelativeLayout rl_daily_story;
    RecyclerView rv_event_list;
    TextView sub_title_bar_title;
    private int targetHeight = -1;
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
        setContentView((int) R.layout.activity_alarm_video2);
        findView();
        initEventType();
        initView();
        initData();
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.$$Lambda$AlarmVideoActivity$oilRLM_VFf4rUJaVVabb0Pfx4I */

            public final void run() {
                AlarmVideoActivity.this.lambda$doCreate$0$AlarmVideoActivity();
            }
        });
        refreshContent();
        if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            initDailyStory();
        }
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
     arg types: [com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.app.Activity, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.content.Context, float):int */
    /* renamed from: calculateHeight */
    public void lambda$doCreate$0$AlarmVideoActivity() {
        this.mVisibleItemCount = (int) Math.ceil((double) (((float) this.rv_event_list.getMeasuredHeight()) / (((float) gpc.O000000o((Context) this, 88.0f)) * 1.0f)));
    }

    private void findView() {
        this.calendar_container = findViewById(R.id.calendar_area);
        View findViewById = findViewById(R.id.see_all_video);
        findViewById.setOnClickListener(this);
        int i = 8;
        if (this.isFromRn) {
            findViewById.setVisibility(8);
        }
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        this.title_bar_more.setImageResource(R.drawable.mj_webp_titlebar_setting_nor);
        ImageView imageView = this.title_bar_more;
        if (!this.mCameraDevice.isReadOnlyShared() && !this.isFromRn) {
            i = 0;
        }
        imageView.setVisibility(i);
        this.title_bar_more.setOnClickListener(this);
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
        this.mLoadingView.setImageDrawable(getResources().getDrawable(R.drawable.camera_loading));
    }

    private void initView() {
        this.tv_cur_day.setText(DateUtils.getMonthDay(System.currentTimeMillis() + 1));
        this.mAlarmVideoAdapter = new AlarmVideoAdapter(this);
        this.mAlarmVideoAdapter.setOnItemClickedListener(new AlarmVideoAdapter.ItemClickedListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass1 */

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
            public void onItemClicked(final AlarmVideo alarmVideo, int i) {
                AlarmVideoActivity.this.mCameraDevice.O00000oo().markEvent(alarmVideo.fileId, alarmVideo.offset, new Callback<Boolean>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass1.AnonymousClass1 */

                    public void onSuccess(Boolean bool) {
                        if (!AlarmVideoActivity.this.isFinishing() && bool.booleanValue()) {
                            alarmVideo.isRead = true;
                            if (AlarmVideoActivity.this.mRecordList != null && AlarmVideoActivity.this.mRecordList.indexOf(alarmVideo) != -1) {
                                AlarmVideoActivity.this.mAlarmVideoAdapter.notifyItemChanged(AlarmVideoActivity.this.mRecordList.indexOf(alarmVideo));
                            }
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (AlarmVideoActivity.this.isFinishing()) {
                        }
                    }
                });
                if (AlarmVideoActivity.this.mUserStatus == null || !AlarmVideoActivity.this.mUserStatus.vip || DeviceModelManager.getInstance().isMijiaCameraV1(AlarmVideoActivity.this.mDeviceStat.model)) {
                    Intent intent = new Intent(AlarmVideoActivity.this.getContext(), AlarmVideoNormalPlayerActivity.class);
                    intent.putExtra("fileId", alarmVideo.fileId);
                    intent.putExtra("isAlarm", alarmVideo.isAlarm);
                    intent.putExtra("createTime", alarmVideo.createTime);
                    intent.putExtra("offset", alarmVideo.offset);
                    intent.putExtra("dateTime", AlarmVideoActivity.this.mSelectedDate);
                    intent.putExtra("index", i);
                    intent.putExtra("pincod", true);
                    intent.putExtra("isFromRn", AlarmVideoActivity.this.isFromRn);
                    intent.putExtra("localAlarmEventType", AlarmVideoActivity.this.localAlarmEventTypes);
                    intent.putExtra("isNewPlugin", AlarmVideoActivity.this.isNewRNPlugin);
                    intent.putExtra("is_v4", AlarmVideoActivity.this.isV4);
                    AlarmVideoActivity.this.startActivityForResult(intent, 17);
                    return;
                }
                Intent intent2 = new Intent(AlarmVideoActivity.this.getContext(), AlarmVideoPlayerActivity.class);
                intent2.putExtra("fileId", alarmVideo.fileId);
                intent2.putExtra("isAlarm", alarmVideo.isAlarm);
                intent2.putExtra("createTime", alarmVideo.createTime);
                intent2.putExtra("offset", alarmVideo.offset);
                intent2.putExtra("startDuration", alarmVideo.startDuration);
                intent2.putExtra("pincod", true);
                intent2.putExtra("isFromRn", AlarmVideoActivity.this.isFromRn);
                AlarmVideoActivity.this.startActivityForResult(intent2, 1001);
            }
        });
        ((TextView) findViewById(R.id.title_bar_title)).setText(getString(R.string.housekeeping_v4));
        int width = getWindowManager().getDefaultDisplay().getWidth();
        if (this.targetHeight == -1) {
            this.targetHeight = (width * 720) / 1280;
        }
        initRecycler();
        initPtr();
        this.custom_calendar.setCalendarListener(new YdCatCalendarView.YdCatCalendarListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass2 */

            public void clickOnLeftPage() {
            }

            public void clickOnRightPage() {
            }

            public void clickOnDate(final CalendarDate calendarDate, View view) {
                AlarmVideoActivity.this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        AlarmVideoActivity.this.showOrHideCalendar(false, null);
                        AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                        CalendarDate calendarDate = calendarDate;
                        alarmVideoActivity.mSelectedDate = calendarDate;
                        long[] dayStartAndEndTimeMillis = calendarDate.getDayStartAndEndTimeMillis();
                        civ.O000000o("AlarmVideoActivity", calendarDate.getYear() + "-" + calendarDate.getMonth() + "-" + calendarDate.getDay());
                        AlarmVideoActivity.this.mEndTime = dayStartAndEndTimeMillis[1];
                        AlarmVideoActivity.this.mStartPoint = dayStartAndEndTimeMillis[0];
                        AlarmVideoActivity.this.mStartTime = AlarmVideoActivity.this.mStartPoint;
                        AlarmVideoActivity.this.mEndPoint = AlarmVideoActivity.this.mEndTime;
                        AlarmVideoActivity.this.tv_cur_day.setText(DateUtils.getMonthDay(AlarmVideoActivity.this.mStartTime + 1));
                        AlarmVideoActivity.this.refreshContent();
                    }
                }, 300);
            }
        });
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
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass3 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                if (!AlarmVideoActivity.this.isFinishing()) {
                    AlarmVideoActivity.this.refreshContent();
                }
            }
        });
        this.ptrLayout.setOnPushLoadMoreListener(new RecyclerViewRefreshLayout.OnPushLoadMoreListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass4 */

            public void onPushDistance(int i) {
            }

            public void onPushEnable(boolean z) {
            }

            public void onLoadMore() {
                if (!AlarmVideoActivity.this.isFinishing()) {
                    AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                    alarmVideoActivity.getEventList(alarmVideoActivity.mStartTime, AlarmVideoActivity.this.mEndTime, 2);
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

    public void onAllRecordClicked() {
        boolean z = false;
        if (this.calendar_container.getVisibility() == 0) {
            showOrHideCalendar(false, new AnimUtil.AnimEndListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass7 */

                public void animEnd() {
                    AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                    alarmVideoActivity.showOrHideEventType(alarmVideoActivity.event_type_recycler.getVisibility() != 0, null);
                }
            });
            return;
        }
        if (this.event_type_recycler.getVisibility() != 0) {
            z = true;
        }
        showOrHideEventType(z, null);
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
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass8 */

                public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj, long j, boolean z) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj), j, z);
                }

                public void onSuccess(ArrayList<AlarmVideo> arrayList, long j, boolean z) {
                    if (!AlarmVideoActivity.this.isFinishing()) {
                        AlarmVideoActivity.this.hideLoadingView();
                        AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                        alarmVideoActivity.isNetRefreshing = false;
                        if (alarmVideoActivity.ptrLayout.isRefreshing()) {
                            AlarmVideoActivity.this.ptrLayout.setRefreshing(false);
                        }
                        if (i == 1) {
                            AlarmVideoActivity.this.mRecordList.clear();
                        }
                        AlarmVideoActivity.this.mRecordList.addAll(arrayList);
                        if (AlarmVideoActivity.this.mRecordList == null || AlarmVideoActivity.this.mRecordList.size() <= 0) {
                            AlarmVideoActivity.this.mAlarmVideoAdapter.update(AlarmVideoActivity.this.mRecordList);
                            AlarmVideoActivity.this.ll_empty_content.setVisibility(0);
                            TextView textView = AlarmVideoActivity.this.tv_request_result;
                            AlarmVideoActivity alarmVideoActivity2 = AlarmVideoActivity.this;
                            textView.setText(alarmVideoActivity2.getEmptyStringByType(alarmVideoActivity2.mCurEventType.name));
                            AlarmVideoActivity.this.ptrLayout.setEnabled(true);
                            return;
                        }
                        AlarmVideoActivity.this.ll_empty_content.setVisibility(8);
                        AlarmVideoActivity.this.ptrLayout.setVisibility(0);
                        AlarmVideoActivity.this.ptrLayout.setEnabled(true);
                        if (!z) {
                            AlarmVideoActivity.this.lambda$doCreate$0$AlarmVideoActivity();
                            if (AlarmVideoActivity.this.mRecordList.size() < AlarmVideoActivity.this.mVisibleItemCount) {
                                AlarmVideoActivity.this.mAlarmVideoAdapter.setToTheEnd(false);
                            } else {
                                AlarmVideoActivity.this.mAlarmVideoAdapter.setToTheEnd(true);
                            }
                            AlarmVideoActivity.this.ptrLayout.setMode(1);
                            AlarmVideoActivity.this.ptrLayout.setLoadMore(false);
                        } else {
                            AlarmVideoActivity alarmVideoActivity3 = AlarmVideoActivity.this;
                            alarmVideoActivity3.mEndTime = j;
                            alarmVideoActivity3.mAlarmVideoAdapter.setToTheEnd(false);
                            AlarmVideoActivity.this.ptrLayout.setMode(3);
                            AlarmVideoActivity.this.ptrLayout.setLoadMore(false);
                        }
                        AlarmVideoActivity.this.mAlarmVideoAdapter.update(AlarmVideoActivity.this.mRecordList);
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmVideoActivity.this.isFinishing()) {
                        AlarmVideoActivity.this.hideLoadingView();
                        AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                        alarmVideoActivity.isNetRefreshing = false;
                        if (alarmVideoActivity.ptrLayout.isRefreshing()) {
                            AlarmVideoActivity.this.ptrLayout.setRefreshing(false);
                        }
                        AlarmVideoActivity.this.ptrLayout.setLoadMore(false);
                        if (i == 1) {
                            AlarmVideoActivity.this.ll_empty_content.setVisibility(0);
                            AlarmVideoActivity.this.mRecordList.clear();
                            AlarmVideoActivity.this.mAlarmVideoAdapter.update(AlarmVideoActivity.this.mRecordList);
                            TextView textView = AlarmVideoActivity.this.tv_request_result;
                            AlarmVideoActivity alarmVideoActivity2 = AlarmVideoActivity.this;
                            textView.setText(alarmVideoActivity2.getEmptyStringByType(alarmVideoActivity2.mCurEventType.name));
                            AlarmVideoActivity.this.ptrLayout.setMode(1);
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
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass9 */

            public void onCloudVideoSuccess(CloudVideoUserStatus cloudVideoUserStatus, Object obj) {
                if (!AlarmVideoActivity.this.isFinishing()) {
                    civ.O000000o("user status", cloudVideoUserStatus.toString());
                    if (cloudVideoUserStatus == null) {
                        AlarmVideoActivity.this.mUserStatus = new CloudVideoUserStatus();
                        AlarmVideoActivity.this.mUserStatus.setDefault(true);
                    } else {
                        AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                        alarmVideoActivity.mUserStatus = cloudVideoUserStatus;
                        if (alarmVideoActivity.isFromRn) {
                            AlarmVideoActivity.this.mCameraDevice.O00000oO().O00000o0(AlarmVideoActivity.this.mUserStatus.vip);
                        }
                        AlarmVideoActivity alarmVideoActivity2 = AlarmVideoActivity.this;
                        alarmVideoActivity2.getEventList(alarmVideoActivity2.mStartPoint, AlarmVideoActivity.this.mEndPoint, 1);
                    }
                    AlarmVideoActivity.this.updateSelectParamByUserStatus();
                }
            }

            public void onCloudVideoFailed(int i, String str) {
                if (!AlarmVideoActivity.this.isFinishing()) {
                    AlarmVideoActivity.this.mUserStatus = new CloudVideoUserStatus();
                    AlarmVideoActivity.this.mUserStatus.setDefault(true);
                    AlarmVideoActivity.this.updateSelectParamByUserStatus();
                }
            }
        });
    }

    public void updateSelectParamByUserStatus() {
        civ.O000000o("lzc", this.mUserStatus.toString());
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
        }
        this.tv_all_record.setText(this.mCurEventType.desc);
        this.eventTypeAdapter = new RecyclerEventTypeAdapter(activity(), arrayList, new RecyclerEventTypeAdapter.OnItemClick() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass10 */

            public void onItemClick(int i) {
                AlarmVideoActivity.this.mCurEventType = (EventType) arrayList.get(i);
                AlarmVideoActivity.this.tv_all_record.setText(AlarmVideoActivity.this.mCurEventType.desc);
                AlarmVideoActivity.this.onEventTypeBgClick();
                AlarmVideoActivity.this.refreshContent();
                int i2 = 1;
                for (int i3 = 0; i3 < AlarmVideoActivity.this.eventTypes.length; i3++) {
                    if (AlarmVideoActivity.this.eventTypes[i3].equalsIgnoreCase(AlarmVideoActivity.this.mCurEventType.name)) {
                        i2 = i3;
                    }
                }
                chr.O000000o("u5v.u1o.4k5.9yf", "type", Integer.valueOf(i2));
            }
        });
        this.event_type_recycler.setLayoutManager(new GridLayoutManager(activity(), 2));
        this.event_type_recycler.setAdapter(this.eventTypeAdapter);
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
            /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass11 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(DailyStoryList dailyStoryList) {
                AlarmVideoActivity.this.dailyStoryList = dailyStoryList;
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
            CloudVideoUserStatus cloudVideoUserStatus = this.mUserStatus;
            if (cloudVideoUserStatus != null && cloudVideoUserStatus.vip) {
                fsp.O000000o().O0000Oo.openCloudVideoListActivityForResult(this, this.mCameraDevice.getDid(), this.mCameraDevice.getName(), 17);
            } else if (this.isV4) {
                startActivityForResult(new Intent(this, AlarmDayV2Activity.class), 17);
            } else {
                startActivityForResult(new Intent(this, com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Activity.class), 17);
            }
        } else if (view.getId() == R.id.title_bar_more) {
            startActivity(new Intent(this, AlarmSettingV2Activity.class));
            chr.O000000o(chr.O00O00Oo);
        } else if (view.getId() == R.id.btn_daily_story) {
            hxi.O00000o.O0000OoO();
            if (this.mCameraDevice.O00000oO().O0000OoO || (dailyStoryList2 = this.dailyStoryList) == null || dailyStoryList2.playUnits.size() == 0) {
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

    private void onSelectDayClick() {
        chr.O000000o("u5v.u1o.4k5.g2i");
        boolean z = false;
        if (this.event_type_recycler.getVisibility() == 0) {
            showOrHideEventType(false, new AnimUtil.AnimEndListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity.AnonymousClass12 */

                public void animEnd() {
                    AlarmVideoActivity alarmVideoActivity = AlarmVideoActivity.this;
                    alarmVideoActivity.showOrHideCalendar(alarmVideoActivity.calendar_container.getVisibility() != 0, null);
                }
            });
            return;
        }
        if (this.calendar_container.getVisibility() != 0) {
            z = true;
        }
        showOrHideCalendar(z, null);
    }

    public void onCalendarBgClicked() {
        showOrHideCalendar(false, null);
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
        if (i != 17) {
            if (i == 1001 && i2 == -1) {
                refreshContent();
            }
        } else if (i2 == -1) {
            refreshContent();
        }
    }
}
