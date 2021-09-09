package com.xiaomi.mico.setting.babyschedule.bean;

import android.content.Context;
import com.xiaomi.mico.api.model.AlarmCircle;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleEditInterface;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public enum ScheduleRecommendation implements BabyScheduleItem, ScheduleEditInterface {
    RECOMMENDATION_8_AM(R.string.baby_schedule_recommendation_repeat_time_eight_am, R.string.baby_schedule_recommendation_repeat_time_eight_am_intro, R.drawable.class_default_poetry, R.string.baby_schedule_recommendation_repeat_day, R.drawable.custom_background_8, 1, 8),
    RECOMMENDATION_10_AM(R.string.baby_schedule_recommendation_repeat_time_ten_am, R.string.baby_schedule_recommendation_repeat_time_ten_am_intro, R.drawable.class_default_english, R.string.baby_schedule_recommendation_repeat_day, R.drawable.custom_background_10, 2, 10),
    RECOMMENDATION_3_PM(R.string.baby_schedule_recommendation_repeat_time_three_pm, R.string.baby_schedule_recommendation_repeat_time_three_pm_intro, R.drawable.class_default_music, R.string.baby_schedule_recommendation_repeat_day, R.drawable.custom_background_15, 3, 15),
    RECOMMENDATION_8_PM(R.string.baby_schedule_recommendation_repeat_time_eight_pm, R.string.baby_schedule_recommendation_repeat_time_eight_pm_intro, R.drawable.class_default_story, R.string.baby_schedule_recommendation_repeat_day, R.drawable.custom_background_20, 4, 20);
    
    private final int coverResId;
    private final int editPageHeaderBg;
    private int hourOfDay;
    private final int intro;
    private int recommendType;
    private final int repeatDay;
    private final int repeatTime;

    public final int getItemType() {
        return 3;
    }

    public final void handleItemClick(Context context, int i) {
    }

    private ScheduleRecommendation(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.repeatTime = i;
        this.intro = i2;
        this.coverResId = i3;
        this.repeatDay = i4;
        this.editPageHeaderBg = i5;
        this.recommendType = i6;
        this.hourOfDay = i7;
    }

    public final int getRepeatTime() {
        return this.repeatTime;
    }

    public final int getIntro() {
        return this.intro;
    }

    public final int getCoverResId() {
        return this.coverResId;
    }

    public final int getRepeatDay() {
        return this.repeatDay;
    }

    public final int getEditPageHeaderBg() {
        return this.editPageHeaderBg;
    }

    public final int getRecommendType() {
        return this.recommendType;
    }

    public final int getHourOfDay() {
        return this.hourOfDay;
    }

    public final String getEditPageTitle(Context context) {
        return context.getString(this.repeatTime);
    }

    public final long getAlarmTime() {
        return ScheduleEditInterface.CC.getDefaultTimeStamp();
    }

    public final List<ScheduleItem> getScheduleResource() {
        return new ArrayList();
    }

    public final int getCircle() {
        return AlarmCircle.EVERYDAY.getCircle();
    }

    public final TimedOffBean getTimedOffBean(Context context) {
        return TimedOffBean.getDefaultTimedOffBean(context);
    }

    static class Constants {
        private Constants() {
        }
    }
}
