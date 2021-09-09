package com.google.android.material.datepicker;

import _m_j.bd;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
        /* class com.google.android.material.datepicker.CalendarConstraints.AnonymousClass1 */

        public final CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()));
        }

        public final CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    };
    public final Month end;
    private final int monthSpan;
    public Month openAt;
    public final Month start;
    public final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    public final int describeContents() {
        return 0;
    }

    private CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 == null || month3.compareTo(month2) <= 0) {
            this.monthSpan = month.monthsUntil(month2) + 1;
            this.yearSpan = (month2.year - month.year) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isWithinBounds(long j) {
        if (this.start.getDay(1) > j) {
            return false;
        }
        Month month = this.end;
        return j <= month.getDay(month.daysInMonth);
    }

    public final DateValidator getDateValidator() {
        return this.validator;
    }

    /* access modifiers changed from: package-private */
    public final Month getStart() {
        return this.start;
    }

    /* access modifiers changed from: package-private */
    public final Month getEnd() {
        return this.end;
    }

    /* access modifiers changed from: package-private */
    public final Month getOpenAt() {
        return this.openAt;
    }

    /* access modifiers changed from: package-private */
    public final void setOpenAt(Month month) {
        this.openAt = month;
    }

    /* access modifiers changed from: package-private */
    public final int getMonthSpan() {
        return this.monthSpan;
    }

    /* access modifiers changed from: package-private */
    public final int getYearSpan() {
        return this.yearSpan;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && bd.O000000o(this.openAt, calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }

    /* access modifiers changed from: package-private */
    public final Month clamp(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        return month.compareTo(this.end) > 0 ? this.end : month;
    }

    public static final class Builder {
        static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        private long end = DEFAULT_END;
        private Long openAt;
        private long start = DEFAULT_START;
        private DateValidator validator = DateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        Builder(CalendarConstraints calendarConstraints) {
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }

        public final Builder setStart(long j) {
            this.start = j;
            return this;
        }

        public final Builder setEnd(long j) {
            this.end = j;
            return this;
        }

        public final Builder setOpenAt(long j) {
            this.openAt = Long.valueOf(j);
            return this;
        }

        public final Builder setValidator(DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        public final CalendarConstraints build() {
            Month month;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.validator);
            Month create = Month.create(this.start);
            Month create2 = Month.create(this.end);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l = this.openAt;
            if (l == null) {
                month = null;
            } else {
                month = Month.create(l.longValue());
            }
            return new CalendarConstraints(create, create2, dateValidator, month);
        }
    }
}
