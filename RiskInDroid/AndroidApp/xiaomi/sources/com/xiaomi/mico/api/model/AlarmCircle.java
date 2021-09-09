package com.xiaomi.mico.api.model;

import android.content.Context;
import com.xiaomi.smarthome.R;

public enum AlarmCircle {
    ONCE(0, R.string.time_setting_repeat_once, 0, 0),
    EVERYDAY(1, R.string.time_setting_repeat_everyday, 1, 1),
    WORKDAY(2, R.string.time_setting_repeat_workday, 2, 2),
    MON2FRI(3, R.string.time_setting_repeat_1_to_5, 3, 4),
    HOLIDAY(4, R.string.time_setting_repeat_holiday, -1, 3),
    WEEKEND(5, R.string.time_setting_repeat_weekend, -1, 5),
    CUSTOM(6, R.string.time_setting_repeat_custom, -1, 6);
    
    private int circle;
    private int place;
    private int placeV2;
    private int resid;

    private AlarmCircle(int i, int i2, int i3, int i4) {
        this.circle = i;
        this.resid = i2;
        this.place = i3;
        this.placeV2 = i4;
    }

    public static int circle2index(int i, int i2) {
        AlarmCircle[] values = values();
        int length = values.length;
        int i3 = 0;
        while (i3 < length) {
            AlarmCircle alarmCircle = values[i3];
            if (alarmCircle.circle != i) {
                i3++;
            } else if (i2 == 2) {
                return alarmCircle.placeV2;
            } else {
                return alarmCircle.place;
            }
        }
        return 0;
    }

    public static int index2circle(int i, int i2) {
        for (AlarmCircle alarmCircle : values()) {
            if (i2 == 2) {
                if (alarmCircle.placeV2 == i) {
                    return alarmCircle.circle;
                }
            } else if (alarmCircle.place == i) {
                return alarmCircle.circle;
            }
        }
        return -1;
    }

    public static int repeatOptionDesc(int i) {
        for (AlarmCircle alarmCircle : values()) {
            if (alarmCircle.circle == i) {
                return alarmCircle.resid;
            }
        }
        return -1;
    }

    public static String getRepeatOptionDesc(Context context, int i) {
        int repeatOptionDesc = repeatOptionDesc(i);
        return repeatOptionDesc != -1 ? context.getResources().getString(repeatOptionDesc) : "";
    }

    public final int getCircle() {
        return this.circle;
    }
}
