package com.google.android.material.datepicker;

import _m_j.bf;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Operator ALL_OPERATOR = new Operator() {
        /* class com.google.android.material.datepicker.CompositeDateValidator.AnonymousClass2 */

        public final int getId() {
            return 2;
        }

        public final boolean isValid(List<CalendarConstraints.DateValidator> list, long j) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && !next.isValid(j)) {
                    return false;
                }
            }
            return true;
        }
    };
    public static final Operator ANY_OPERATOR = new Operator() {
        /* class com.google.android.material.datepicker.CompositeDateValidator.AnonymousClass1 */

        public final int getId() {
            return 1;
        }

        public final boolean isValid(List<CalendarConstraints.DateValidator> list, long j) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && next.isValid(j)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator<CompositeDateValidator>() {
        /* class com.google.android.material.datepicker.CompositeDateValidator.AnonymousClass3 */

        public final CompositeDateValidator createFromParcel(Parcel parcel) {
            Operator operator;
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            if (readInt == 2 || readInt != 1) {
                operator = CompositeDateValidator.ALL_OPERATOR;
            } else {
                operator = CompositeDateValidator.ANY_OPERATOR;
            }
            return new CompositeDateValidator((List) bf.O000000o(readArrayList), operator);
        }

        public final CompositeDateValidator[] newArray(int i) {
            return new CompositeDateValidator[i];
        }
    };
    private final Operator operator;
    private final List<CalendarConstraints.DateValidator> validators;

    interface Operator {
        int getId();

        boolean isValid(List<CalendarConstraints.DateValidator> list, long j);
    }

    public final int describeContents() {
        return 0;
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> list, Operator operator2) {
        this.validators = list;
        this.operator = operator2;
    }

    public static CalendarConstraints.DateValidator allOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ALL_OPERATOR);
    }

    public static CalendarConstraints.DateValidator anyOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ANY_OPERATOR);
    }

    public final boolean isValid(long j) {
        return this.operator.isValid(this.validators, j);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.validators.equals(compositeDateValidator.validators) && this.operator.getId() == compositeDateValidator.operator.getId();
    }

    public final int hashCode() {
        return this.validators.hashCode();
    }
}
