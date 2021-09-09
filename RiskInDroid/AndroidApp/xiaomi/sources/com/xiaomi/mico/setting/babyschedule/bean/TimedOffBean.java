package com.xiaomi.mico.setting.babyschedule.bean;

import android.content.Context;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TimedOffBean implements Serializable {
    public String displayStr;
    private boolean openTimer = true;
    public int stopByCount = 0;
    public long stopByTime = 0;

    private TimedOffBean(boolean z, String str) {
        this.displayStr = str;
        this.openTimer = z;
    }

    private TimedOffBean(Context context, int i) {
        this.displayStr = String.format(context.getString(R.string.baby_schedule_stop_by_count), Integer.valueOf(i));
        this.stopByCount = i;
    }

    private TimedOffBean(Context context, long j) {
        this.stopByTime = j;
        this.displayStr = String.format(context.getString(R.string.baby_schedule_stop_by_time), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)));
    }

    static TimedOffBean getTimedOffBean(Context context, int i, long j) {
        if (i != 0) {
            return new TimedOffBean(context, i);
        }
        if (j != 0) {
            return new TimedOffBean(context, j);
        }
        return getDefaultTimedOffBean(context);
    }

    static TimedOffBean getDefaultTimedOffBean(Context context) {
        return new TimedOffBean(context, TimeUnit.MINUTES.toMillis(30));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.setting.babyschedule.bean.TimedOffBean.<init>(boolean, java.lang.String):void
     arg types: [int, java.lang.String]
     candidates:
      com.xiaomi.mico.setting.babyschedule.bean.TimedOffBean.<init>(android.content.Context, int):void
      com.xiaomi.mico.setting.babyschedule.bean.TimedOffBean.<init>(android.content.Context, long):void
      com.xiaomi.mico.setting.babyschedule.bean.TimedOffBean.<init>(boolean, java.lang.String):void */
    public static TimedOffBean[] getTimedOffBeans(Context context) {
        return new TimedOffBean[]{new TimedOffBean(false, context.getString(R.string.baby_schedule_do_not_close)), new TimedOffBean(context, 1), new TimedOffBean(context, 2), new TimedOffBean(context, 3), new TimedOffBean(context, 5), new TimedOffBean(context, TimeUnit.MINUTES.toMillis(10)), new TimedOffBean(context, TimeUnit.MINUTES.toMillis(20)), new TimedOffBean(context, TimeUnit.MINUTES.toMillis(30)), new TimedOffBean(context, TimeUnit.MINUTES.toMillis(60))};
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TimedOffBean timedOffBean = (TimedOffBean) obj;
            return this.openTimer == timedOffBean.openTimer && this.stopByCount == timedOffBean.stopByCount && this.stopByTime == timedOffBean.stopByTime && this.displayStr.equals(timedOffBean.displayStr);
        }
    }

    public int hashCode() {
        return Objects.hash(this.displayStr, Boolean.valueOf(this.openTimer), Integer.valueOf(this.stopByCount), Long.valueOf(this.stopByTime));
    }
}
