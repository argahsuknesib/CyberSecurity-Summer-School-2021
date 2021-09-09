package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() {
        /* class com.google.android.material.timepicker.TimeModel.AnonymousClass1 */

        public final TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        public final TimeModel[] newArray(int i) {
            return new TimeModel[i];
        }
    };
    final int format;
    int hour;
    private final MaxInputValidator hourInputValidator;
    int minute;
    private final MaxInputValidator minuteInputValidator;
    int period;
    int selection;

    private static int getPeriod(int i) {
        return i >= 12 ? 1 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public TimeModel() {
        this(0);
    }

    public TimeModel(int i) {
        this(0, 0, 10, i);
    }

    public TimeModel(int i, int i2, int i3, int i4) {
        this.hour = i;
        this.minute = i2;
        this.selection = i3;
        this.format = i4;
        this.period = getPeriod(i);
        this.minuteInputValidator = new MaxInputValidator(59);
        this.hourInputValidator = new MaxInputValidator(i4 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public void setHourOfDay(int i) {
        this.period = getPeriod(i);
        this.hour = i;
    }

    public void setHour(int i) {
        if (this.format == 1) {
            this.hour = i;
            return;
        }
        int i2 = 12;
        int i3 = i % 12;
        if (this.period != 1) {
            i2 = 0;
        }
        this.hour = i3 + i2;
    }

    public void setMinute(int i) {
        this.minute = i % 60;
    }

    public int getHourForDisplay() {
        if (this.format == 1) {
            return this.hour % 24;
        }
        int i = this.hour;
        if (i % 12 == 0) {
            return 12;
        }
        return this.period == 1 ? i - 12 : i;
    }

    public MaxInputValidator getMinuteInputValidator() {
        return this.minuteInputValidator;
    }

    public MaxInputValidator getHourInputValidator() {
        return this.hourInputValidator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.hour == timeModel.hour && this.minute == timeModel.minute && this.format == timeModel.format && this.selection == timeModel.selection;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeInt(this.selection);
        parcel.writeInt(this.format);
    }

    public void setPeriod(int i) {
        if (i != this.period) {
            this.period = i;
            int i2 = this.hour;
            if (i2 >= 12 || i != 1) {
                int i3 = this.hour;
                if (i3 >= 12 && i == 0) {
                    this.hour = i3 - 12;
                    return;
                }
                return;
            }
            this.hour = i2 + 12;
        }
    }

    public static String formatText(Resources resources, CharSequence charSequence) {
        return formatText(resources, charSequence, "%02d");
    }

    public static String formatText(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }
}
