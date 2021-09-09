package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new Parcelable.Creator<DateValidatorPointBackward>() {
        /* class com.google.android.material.datepicker.DateValidatorPointBackward.AnonymousClass1 */

        public final DateValidatorPointBackward createFromParcel(Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong());
        }

        public final DateValidatorPointBackward[] newArray(int i) {
            return new DateValidatorPointBackward[i];
        }
    };
    private final long point;

    public int describeContents() {
        return 0;
    }

    private DateValidatorPointBackward(long j) {
        this.point = j;
    }

    public static DateValidatorPointBackward before(long j) {
        return new DateValidatorPointBackward(j);
    }

    public static DateValidatorPointBackward now() {
        return before(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    public boolean isValid(long j) {
        return j <= this.point;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.point);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.point == ((DateValidatorPointBackward) obj).point;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }
}
