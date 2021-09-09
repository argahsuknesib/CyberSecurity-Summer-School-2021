package com.xiaomi.smarthome.device.api.spec.definitions.data.value;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataValue;
import java.util.Objects;

public class Vuint32 extends DataValue implements Parcelable {
    public static final Parcelable.Creator<Vuint32> CREATOR = new Parcelable.Creator<Vuint32>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vuint32.AnonymousClass1 */

        public final Vuint32 createFromParcel(Parcel parcel) {
            return new Vuint32(parcel);
        }

        public final Vuint32[] newArray(int i) {
            return new Vuint32[i];
        }
    };
    private long value;

    public int describeContents() {
        return 0;
    }

    public Vuint32() {
        this.value = 0;
    }

    public Vuint32(long j) {
        this.value = j;
    }

    protected Vuint32(Parcel parcel) {
        this.value = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.value);
    }

    public long getValue() {
        return this.value;
    }

    public boolean lessEquals(DataValue dataValue) {
        if (dataValue.getClass() == getClass() && this.value <= ((Vuint32) dataValue).value) {
            return true;
        }
        return false;
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2) {
        if (dataValue.getClass() == getClass() && dataValue2.getClass() == getClass()) {
            Vuint32 vuint32 = (Vuint32) dataValue2;
            long j = this.value;
            if (j < ((Vuint32) dataValue).value || j > vuint32.value) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2, DataValue dataValue3) {
        if (dataValue.getClass() == getClass() && dataValue2.getClass() == getClass() && dataValue3.getClass() == getClass()) {
            long j = ((Vuint32) dataValue).value;
            long j2 = ((Vuint32) dataValue2).value;
            long j3 = ((Vuint32) dataValue3).value;
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

    public static Vuint32 valueOf(Object obj) {
        if (obj instanceof Long) {
            Long l = (Long) obj;
            if (l.longValue() < 0 || l.longValue() > 4294967295L) {
                return null;
            }
            return new Vuint32(l.longValue());
        } else if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() < 0) {
                return null;
            }
            return new Vuint32((long) num.intValue());
        } else {
            if (obj instanceof String) {
                try {
                    Long valueOf = Long.valueOf((String) obj);
                    if (valueOf.longValue() >= 0) {
                        if (valueOf.longValue() <= 4294967295L) {
                            return new Vuint32(valueOf.longValue());
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((Vuint32) obj).value;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.value));
    }
}
