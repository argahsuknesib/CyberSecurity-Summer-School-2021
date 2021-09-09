package com.xiaomi.mico.setting.babyschedule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.AlarmCircle;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.AlarmEditTitleBar;
import com.xiaomi.mico.common.widget.AlarmSettingItem;
import com.xiaomi.mico.common.widget.AlarmTimePicker;
import com.xiaomi.mico.setting.alarm.AlarmRepeatActivity;
import com.xiaomi.mico.setting.babyschedule.BabySchedulerHorizontalAdapter;
import com.xiaomi.mico.setting.babyschedule.bean.BabySchedule;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleEditInterface;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleItem;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleRecommendation;
import com.xiaomi.mico.setting.babyschedule.bean.TimedOffBean;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BabyScheduleEditActivity extends MicoBaseActivity {
    private BabySchedule babySchedule;
    public BabySchedulerHorizontalAdapter babySchedulerHorizontalAdapter = new BabySchedulerHorizontalAdapter();
    private int cycle;
    private String extra;
    RecyclerView lvContents;
    private int recommendationPosition;
    AlarmSettingItem repeatItem;
    AlarmTimePicker timePicker;
    AlarmSettingItem timedOff;
    private TimedOffBean timedOffBean;
    private long timestamp = ScheduleEditInterface.CC.getDefaultTimeStamp();
    AlarmEditTitleBar titleBar;

    public boolean isDarkMode() {
        return true;
    }

    public static void startForResult(Activity activity, ScheduleRecommendation scheduleRecommendation, int i) {
        Intent intent = new Intent(activity, BabyScheduleEditActivity.class);
        intent.putExtra("INTENT_KEY_RECOMMENDATION_TO_EDIT", scheduleRecommendation);
        intent.putExtra("INTENT_KEY_REQUEST_CODE", i);
        activity.startActivityForResult(intent, i);
    }

    public static void startForResult(Activity activity, BabySchedule babySchedule2, int i) {
        Intent intent = new Intent(activity, BabyScheduleEditActivity.class);
        intent.putExtra("INTENT_KEY_COURSE_TO_EDIT", babySchedule2);
        intent.putExtra("INTENT_KEY_REQUEST_CODE", i);
        activity.startActivityForResult(intent, i);
    }

    public static void startForResult(Activity activity, int i) {
        Intent intent = new Intent(activity, BabyScheduleEditActivity.class);
        intent.putExtra("INTENT_KEY_COURSE_TO_EDIT", new BabySchedule());
        intent.putExtra("INTENT_KEY_REQUEST_CODE", i);
        activity.startActivityForResult(intent, i);
    }

    public static void start(Context context, Music.Station station) {
        Intent intent = new Intent(context, BabyScheduleEditActivity.class);
        BabySchedule babySchedule2 = new BabySchedule();
        babySchedule2.resourceList.add(new ScheduleItem(station));
        intent.putExtra("INTENT_KEY_COURSE_TO_EDIT", babySchedule2);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_baby_schedule_edit);
        this.titleBar = (AlarmEditTitleBar) findViewById(R.id.title_bar);
        this.repeatItem = (AlarmSettingItem) findViewById(R.id.item_repeat);
        this.repeatItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleEditActivity$NLaP59g8LZqbORG0EZ_q1BLvITM */

            public final void onClick(View view) {
                BabyScheduleEditActivity.this.lambda$onCreate$0$BabyScheduleEditActivity(view);
            }
        });
        this.timedOff = (AlarmSettingItem) findViewById(R.id.timedOff);
        this.timedOff.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleEditActivity$oP42_mXG5rZbjFI4sbICPp0e9c */

            public final void onClick(View view) {
                BabyScheduleEditActivity.this.lambda$onCreate$1$BabyScheduleEditActivity(view);
            }
        });
        this.timePicker = (AlarmTimePicker) findViewById(R.id.time_picker);
        this.lvContents = (RecyclerView) findViewById(R.id.lvContents);
        this.titleBar.setOnLeftButtonClickListener(new AlarmEditTitleBar.OnLeftButtonClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$UnHXFvOTmdxZD4_WQSZErojW3YQ */

            public final void onLeftButtonClick() {
                BabyScheduleEditActivity.this.onBackPressed();
            }
        });
        this.titleBar.setOnRightButtonClickListener(new AlarmEditTitleBar.OnRightButtonClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleEditActivity$a5Cth2_sN1eeFrIRE07JqaU7r8o */

            public final void onRightButtonClick() {
                BabyScheduleEditActivity.this.saveSchedule();
            }
        });
        this.timePicker.setOnTimeChangedListener(new AlarmTimePicker.OnTimeChangedListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleEditActivity$JF9Z0AiIPLTREXGDSJM95U694Tc */

            public final void onTimeChanged(AlarmTimePicker alarmTimePicker, int i, int i2) {
                BabyScheduleEditActivity.this.lambda$onCreate$2$BabyScheduleEditActivity(alarmTimePicker, i, i2);
            }
        });
        this.lvContents.setAdapter(this.babySchedulerHorizontalAdapter);
        this.babySchedulerHorizontalAdapter.setOnAddMoreClickListener(new BabySchedulerHorizontalAdapter.OnAddMoreClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleEditActivity$qb4wOWJmbvDcspdH5479ZULk3L4 */

            public final void onAddMoreClick() {
                BabyScheduleEditActivity.this.lambda$onCreate$3$BabyScheduleEditActivity();
            }
        });
        parseIntent();
        setTimedOffItemDesc();
        setRepeatItemDesc(this.cycle, this.timestamp, this.extra);
    }

    public /* synthetic */ void lambda$onCreate$2$BabyScheduleEditActivity(AlarmTimePicker alarmTimePicker, int i, int i2) {
        this.timestamp = calculateTimeStamp();
        if (this.cycle == AlarmCircle.ONCE.getCircle()) {
            setRepeatItemDesc(this.cycle, this.timestamp, this.extra);
        }
    }

    public /* synthetic */ void lambda$onCreate$3$BabyScheduleEditActivity() {
        BabyScheduleAddActivity.startForResult(this, this.babySchedulerHorizontalAdapter.getListItems());
    }

    private void parseIntent() {
        if (getIntent().getIntExtra("INTENT_KEY_REQUEST_CODE", 0) == 300) {
            this.babySchedule = new BabySchedule();
            ScheduleRecommendation scheduleRecommendation = (ScheduleRecommendation) getIntent().getSerializableExtra("INTENT_KEY_RECOMMENDATION_TO_EDIT");
            this.titleBar.setTitle(scheduleRecommendation.getEditPageTitle(this));
            this.titleBar.setBgImageResource(scheduleRecommendation.getEditPageHeaderBg());
            this.cycle = scheduleRecommendation.getCircle();
            this.timedOffBean = scheduleRecommendation.getTimedOffBean(this);
            this.recommendationPosition = scheduleRecommendation.getRecommendType();
            loadRecommendation();
            updateTimePicker(scheduleRecommendation.getHourOfDay(), 0);
            return;
        }
        BabySchedule babySchedule2 = (BabySchedule) getIntent().getParcelableExtra("INTENT_KEY_COURSE_TO_EDIT");
        this.babySchedule = babySchedule2;
        this.titleBar.setBgImageResource(ScheduleRecommendation.RECOMMENDATION_8_AM.getEditPageHeaderBg());
        this.titleBar.setTitle(babySchedule2.getEditPageTitle(this));
        this.cycle = babySchedule2.getCircle();
        this.extra = babySchedule2.extra;
        this.timedOffBean = babySchedule2.getTimedOffBean(this);
        this.timestamp = babySchedule2.getAlarmTime();
        this.babySchedulerHorizontalAdapter.updateData(babySchedule2.resourceList, true);
        setTimePickerCurrentTime(this.timestamp);
    }

    private void loadRecommendation() {
        BabySchedulerApiHelper.loadRecommendation(this.recommendationPosition, new ApiRequest.Listener<ArrayList<ScheduleItem>>() {
            /* class com.xiaomi.mico.setting.babyschedule.BabyScheduleEditActivity.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<ScheduleItem>) ((ArrayList) obj));
            }

            public void onSuccess(ArrayList<ScheduleItem> arrayList) {
                BabyScheduleEditActivity.this.babySchedulerHorizontalAdapter.updateData(arrayList, true);
            }

            public void onFailure(ApiError apiError) {
                BabyScheduleEditActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.failed_of_load_retry);
            }
        });
    }

    private void setRepeatItemDesc(int i, long j, String str) {
        this.repeatItem.setDescription(Remote.Response.Alarm.getRepeatStr(getContext(), i, j, str));
    }

    private void setTimedOffItemDesc() {
        TimedOffBean timedOffBean2 = this.timedOffBean;
        if (timedOffBean2 != null) {
            this.timedOff.setDescription(timedOffBean2.displayStr);
        }
    }

    private void setTimePickerCurrentTime(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        updateTimePicker(instance.get(11), instance.get(12));
    }

    private void updateTimePicker(int i, int i2) {
        this.timePicker.setCurrentHour(Integer.valueOf(i));
        this.timePicker.setCurrentMinute(Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: onClick */
    public void lambda$onCreate$1$BabyScheduleEditActivity(View view) {
        int id = view.getId();
        if (id == R.id.item_repeat) {
            startActivityForResult(AlarmRepeatActivity.buildIntent(getContext(), this.cycle, this.extra, this.timestamp), 100);
        } else if (id == R.id.timedOff) {
            startActivityForResult(TimedOffActivity.buildIntent(this, this.timedOffBean), 200);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 100) {
                this.cycle = intent.getIntExtra("cycle", 0);
                String stringExtra = intent.getStringExtra("extra");
                long longExtra = intent.getLongExtra("timestamp", -1);
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.extra = stringExtra;
                }
                if (this.timestamp > 0) {
                    this.timestamp = longExtra;
                }
                setRepeatItemDesc(this.cycle, longExtra, stringExtra);
            } else if (i == 200) {
                this.timedOffBean = (TimedOffBean) intent.getSerializableExtra("INTENT_KEY_CLOSE_TIME");
                setTimedOffItemDesc();
            } else if (i == 400) {
                this.babySchedulerHorizontalAdapter.updateData(intent.getParcelableArrayListExtra("INTENT_KEY_ADD_SCHEDULE"), true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void saveSchedule() {
        ArrayList listItems = this.babySchedulerHorizontalAdapter.getListItems();
        if (ContainerUtil.isEmpty(listItems)) {
            ToastUtil.showToast((int) R.string.baby_schedule_can_not_save);
            return;
        }
        showProgressDialog(null);
        BabySchedulerApiHelper.postDeviceCourses(this.babySchedule.alarmId, MicoManager.getInstance().getCurrentMicoID(), this.timedOffBean.stopByCount, this.timedOffBean.stopByTime, listItems, Remote.Response.Alarm.getAlarmInJson(this.babySchedule.alarmId, TimeUnit.MILLISECONDS.toSeconds(this.timestamp), this.cycle, this.extra), new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.setting.babyschedule.BabyScheduleEditActivity.AnonymousClass2 */

            public void onSuccess(String str) {
                BabyScheduleEditActivity.this.dismissProgressDialog();
                BabyScheduleEditActivity.this.setEditResult();
            }

            public void onFailure(ApiError apiError) {
                BabyScheduleEditActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.alarm_save_fail);
            }
        });
    }

    public void setEditResult() {
        ToastUtil.showToast((int) R.string.baby_schedule_add_schedule_success_check_it_in_another_page);
        this.babySchedule.alarmTime = TimeUnit.MILLISECONDS.toSeconds(this.timestamp);
        this.babySchedule.resourceList = this.babySchedulerHorizontalAdapter.getListItems();
        BabySchedule babySchedule2 = this.babySchedule;
        babySchedule2.circle = this.cycle;
        babySchedule2.stopByCount = this.timedOffBean.stopByCount;
        this.babySchedule.stopByTime = this.timedOffBean.stopByTime;
        this.babySchedule.extra = this.extra;
        Intent intent = new Intent();
        intent.putExtra("INTENT_KEY_COURSE_TO_EDIT", this.babySchedule);
        setResult(-1, intent);
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleEditActivity$5eAd3oO_gpF87n5_uFYh47LEBpg */

            public final void run() {
                BabyScheduleEditActivity.this.lambda$setEditResult$4$BabyScheduleEditActivity();
            }
        }, 500);
    }

    public /* synthetic */ void lambda$setEditResult$4$BabyScheduleEditActivity() {
        finish();
    }

    public long calculateTimeStamp() {
        int intValue = this.timePicker.getCurrentHour().intValue();
        int intValue2 = this.timePicker.getCurrentMinute().intValue();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.timestamp);
        instance.set(11, intValue);
        instance.set(12, intValue2);
        instance.set(13, 0);
        instance.set(14, 0);
        if (instance.getTimeInMillis() < System.currentTimeMillis()) {
            instance.setTimeInMillis(instance.getTimeInMillis() + 86400000);
        }
        return instance.getTimeInMillis();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
