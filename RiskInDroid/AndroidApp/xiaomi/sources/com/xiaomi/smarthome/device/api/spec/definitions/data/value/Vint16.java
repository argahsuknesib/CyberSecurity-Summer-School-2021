package com.xiaomi.smarthome.device.api.spec.definitions.data.value;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataValue;
import java.util.Objects;

public class Vint16 extends DataValue implements Parcelable {
    public static final Parcelable.Creator<Vint16> CREATOR = new Parcelable.Creator<Vint16>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vint16.AnonymousClass1 */

        public final Vint16 createFromParcel(Parcel parcel) {
            return new Vint16(parcel);
        }

        public final Vint16[] newArray(int i) {
            return new Vint16[i];
        }
    };
    private int value;

    public int describeContents() {
        return 0;
    }

    public Vint16() {
        this.value = 0;
    }

    public Vint16(int i) {
        this.value = i;
    }

    protected Vint16(Parcel parcel) {
        this.value = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.value);
    }

    public int getValue() {
        return this.value;
    }

    public boolean lessEquals(DataValue dataValue) {
        if (dataValue.getClass() == getClass() && this.value <= ((Vint16) dataValue).value) {
            return true;
        }
        return false;
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2) {
        if (dataValue.getClass() == getClass() && dataValue2.getClass() == getClass()) {
            Vint16 vint16 = (Vint16) dataValue2;
            int i = this.value;
            if (i < ((Vint16) dataValue).value || i > vint16.value) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2, DataValue dataValue3) {
        if (dataValue.getClass() == getClass() && dataValue2.getClass() == getClass() && dataValue3.getClass() == getClass()) {
            int i = ((Vint16) dataValue).value;
            int i2 = ((Vint16) dataValue2).value;
            int i3 = ((Vint16) dataValue3).value;
            int i4 = this.value;
            if (i4 < i || i4 > i2 || i3 <= 0 || (i4 - i) % i3 != 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Object getObjectValue() {
        return Integer.valueOf(this.value);
    }

    public static Vint16 valueOf(Object obj) {
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() > 32767 || num.intValue() < -32768) {
                return null;
            }
            return new Vint16(num.intValue());
        }
        if (obj instanceof String) {
            try {
                return new Vint16(Short.valueOf((String) obj).shortValue());
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
        return obj != null && getClass() == obj.getClass() && this.value == ((Vint16) obj).value;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.value));
    }
}
