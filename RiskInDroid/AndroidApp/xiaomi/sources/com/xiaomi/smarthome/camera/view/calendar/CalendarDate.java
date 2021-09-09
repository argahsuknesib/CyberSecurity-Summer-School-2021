package com.xiaomi.smarthome.camera.view.calendar;

import android.os.Parcel;
import android.os.Parcelable;

public class CalendarDate implements Parcelable {
    public static final Parcelable.Creator<CalendarDate> CREATOR = new Parcelable.Creator<CalendarDate>() {
        /* class com.xiaomi.smarthome.camera.view.calendar.CalendarDate.AnonymousClass1 */

        public final CalendarDate createFromParcel(Parcel parcel) {
            return new CalendarDate(parcel);
        }

        public final CalendarDate[] newArray(int i) {
            return new CalendarDate[i];
        }
    };
    public String day;
    public String month;
    public long time;
    public String way;
    public String year;

    public int describeContents() {
        return 0;
    }

    public CalendarDate(String str, String str2, String str3, String str4, long j) {
        this.year = str;
        this.month = str2;
        this.day = str3;
        this.way = str4;
        this.time = j;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String str) {
        this.year = str;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String str) {
        this.month = str;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String str) {
        this.day = str;
    }

    public String getWay() {
        return this.way;
    }

    public void setWay(String str) {
        this.way = str;
    }

    public String getDateFormat(String str) {
        return DateUtils.getDateFromNum(this.time, str);
    }

    public boolean equalsDate(CalendarDate calendarDate) {
        return this.year.equals(calendarDate.year) && this.month.equals(calendarDate.month) && this.day.equals(calendarDate.day);
    }

    public long[] getDayStartAndEndTimeMillis() {
        long time2 = DateUtils.getTime(getYear() + "-" + (Integer.parseInt(getMonth()) + 1) + "-" + getDay(), "yyyy-M-d");
        return new long[]{time2, (86400000 + time2) - 1};
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.year);
        parcel.writeString(this.month);
        parcel.writeString(this.day);
        parcel.writeString(this.way);
        parcel.writeLong(this.time);
    }

    protected CalendarDate(Parcel parcel) {
        this.year = parcel.readString();
        this.month = parcel.readString();
        this.day = parcel.readString();
        this.way = parcel.readString();
        this.time = parcel.readLong();
    }
}
