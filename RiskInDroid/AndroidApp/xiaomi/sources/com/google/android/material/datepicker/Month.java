package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Parcelable, Comparable<Month> {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
        /* class com.google.android.material.datepicker.Month.AnonymousClass1 */

        public final Month createFromParcel(Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        public final Month[] newArray(int i) {
            return new Month[i];
        }
    };
    final int daysInMonth = this.firstOfMonth.getActualMaximum(5);
    final int daysInWeek = this.firstOfMonth.getMaximum(7);
    private final Calendar firstOfMonth;
    private String longName;
    final int month = this.firstOfMonth.get(2);
    final long timeInMillis = this.firstOfMonth.getTimeInMillis();
    final int year = this.firstOfMonth.get(1);

    public final int describeContents() {
        return 0;
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        this.firstOfMonth = UtcDates.getDayCopy(calendar);
    }

    static Month create(long j) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return new Month(utcCalendar);
    }

    static Month create(int i, int i2) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.set(1, i);
        utcCalendar.set(2, i2);
        return new Month(utcCalendar);
    }

    static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    /* access modifiers changed from: package-private */
    public final int daysFromStartOfWeekToFirstOfMonth() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month2 = (Month) obj;
        return this.month == month2.month && this.year == month2.year;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    public final int compareTo(Month month2) {
        return this.firstOfMonth.compareTo(month2.firstOfMonth);
    }

    /* access modifiers changed from: package-private */
    public final int monthsUntil(Month month2) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month2.year - this.year) * 12) + (month2.month - this.month);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* access modifiers changed from: package-private */
    public final long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public final long getDay(int i) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.set(5, i);
        return dayCopy.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public final int getDayOfMonth(long j) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.setTimeInMillis(j);
        return dayCopy.get(5);
    }

    /* access modifiers changed from: package-private */
    public final Month monthsLater(int i) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.add(2, i);
        return new Month(dayCopy);
    }

    /* access modifiers changed from: package-private */
    public final String getLongName(Context context) {
        if (this.longName == null) {
            this.longName = DateStrings.getYearMonth(context, this.firstOfMonth.getTimeInMillis());
        }
        return this.longName;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }
}
