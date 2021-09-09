package com.xiaomi.smarthome.device.api.spec.definitions.data.value;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataValue;
import java.util.Objects;

public class Vint64 extends DataValue implements Parcelable {
    public static final Parcelable.Creator<Vint64> CREATOR = new Parcelable.Creator<Vint64>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vint64.AnonymousClass1 */

        public final Vint64 createFromParcel(Parcel parcel) {
            return new Vint64(parcel);
        }

        public final Vint64[] newArray(int i) {
            return new Vint64[i];
        }
    };
    private long value;

    public int describeContents() {
        return 0;
    }

    public Vint64() {
        this.value = 0;
    }

    public Vint64(long j) {
        this.value = j;
    }

    protected Vint64(Parcel parcel) {
        this.value = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.value);
    }

    public long getValue() {
        return this.value;
    }

    public boolean lessEquals(DataValue dataValue) {
        if (dataValue.getClass() == getClass() && this.value <= ((Vint64) dataValue).value) {
            return true;
        }
        return false;
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2) {
        if (dataValue.getClass() == getClass() && dataValue2.getClass() == getClass()) {
            Vint64 vint64 = (Vint64) dataValue2;
            long j = this.value;
            if (j < ((Vint64) dataValue).value || j > vint64.value) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2, DataValue dataValue3) {
        if (dataValue.getClass() == getClass() && dataValue2.getClass() == getClass() && dataValue3.getClass() == getClass()) {
            long j = ((Vint64) dataValue).value;
            long j2 = ((Vint64) dataValue2).value;
            long j3 = ((Vint64) dataValue3).value;
            long j4 = this.value;
            if (j4 < j || j4 > j2 || j3 <= 0 || (j4 - j) % j3 != 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Object getObjectValue() {
        return Long.valueOf(this.value);
    }

    public static Vint64 valueOf(Object obj) {
        if (obj instanceof Integer) {
            return new Vint64((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return new Vint64(((Long) obj).longValue());
        }
        if (obj instanceof String) {
            try {
                return new Vint64(Long.valueOf((String) obj).longValue());
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((Vint64) obj).value;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.value));
    }
}
