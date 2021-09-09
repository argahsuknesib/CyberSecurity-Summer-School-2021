package com.xiaomi.mico.setting.babyschedule.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mico.api.model.AlarmCircle;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.TimeUtil;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleEditInterface;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BabySchedule implements Parcelable, BabyScheduleItem, ScheduleEditInterface {
    public static final Parcelable.Creator<BabySchedule> CREATOR = new Parcelable.Creator<BabySchedule>() {
        /* class com.xiaomi.mico.setting.babyschedule.bean.BabySchedule.AnonymousClass1 */

        public final BabySchedule createFromParcel(Parcel parcel) {
            return new BabySchedule(parcel);
        }

        public final BabySchedule[] newArray(int i) {
            return new BabySchedule[i];
        }
    };
    public String alarmId;
    public long alarmTime;
    public int circle;
    public String extra;
    public ArrayList<ScheduleItem> resourceList;
    public int stopByCount;
    public long stopByTime;

    public int describeContents() {
        return 0;
    }

    public int getItemType() {
        return 2;
    }

    public void handleItemClick(Context context, int i) {
    }

    public BabySchedule() {
        this.alarmId = "";
        this.circle = AlarmCircle.EVERYDAY.getCircle();
        this.resourceList = new ArrayList<>();
    }

    private BabySchedule(Parcel parcel) {
        this.alarmId = "";
        this.circle = AlarmCircle.EVERYDAY.getCircle();
        this.resourceList = new ArrayList<>();
        this.alarmId = parcel.readString();
        this.alarmTime = parcel.readLong();
        this.circle = parcel.readInt();
        this.extra = parcel.readString();
        this.stopByCount = parcel.readInt();
        this.stopByTime = parcel.readLong();
        this.resourceList = parcel.createTypedArrayList(ScheduleItem.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.alarmId);
        parcel.writeLong(this.alarmTime);
        parcel.writeInt(this.circle);
        parcel.writeString(this.extra);
        parcel.writeInt(this.stopByCount);
        parcel.writeLong(this.stopByTime);
        parcel.writeTypedList(this.resourceList);
    }

    public String getEditPageTitle(Context context) {
        return context.getString(R.string.bind_device_room_custom);
    }

    public long getAlarmTime() {
        if (this.alarmTime == 0) {
            this.alarmTime = TimeUnit.MILLISECONDS.toSeconds(ScheduleEditInterface.CC.getDefaultTimeStamp());
        }
        return TimeUnit.SECONDS.toMillis(this.alarmTime);
    }

    public ArrayList<ScheduleItem> getScheduleResource() {
        return this.resourceList;
    }

    public int getCircle() {
        return this.circle;
    }

    public TimedOffBean getTimedOffBean(Context context) {
        return TimedOffBean.getTimedOffBean(context, this.stopByCount, this.stopByTime);
    }

    public String getFormattedAlarmTime() {
        return TimeUtil.timestampToStr(getAlarmTime(), "HH:mm");
    }

    public String getFormattedCircle(Context context) {
        return Remote.Response.Alarm.getRepeatStr(context, this.circle, TimeUnit.SECONDS.toMillis(this.alarmTime), this.extra);
    }
}
