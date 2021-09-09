package com.xiaomi.smarthome.device.api.spec.definitions.data.value;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataValue;
import java.util.Objects;

public class Vstring extends DataValue implements Parcelable {
    public static final Parcelable.Creator<Vstring> CREATOR = new Parcelable.Creator<Vstring>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vstring.AnonymousClass1 */

        public final Vstring createFromParcel(Parcel parcel) {
            return new Vstring(parcel);
        }

        public final Vstring[] newArray(int i) {
            return new Vstring[i];
        }
    };
    private String value;

    public int describeContents() {
        return 0;
    }

    public Vstring() {
        this.value = "";
    }

    public Vstring(String str) {
        this.value = str;
    }

    protected Vstring(Parcel parcel) {
        this.value = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.value);
    }

    public String getValue() {
        return this.value;
    }

    public Object getObjectValue() {
        return this.value;
    }

    public static Vstring valueOf(Object obj) {
        if (obj instanceof String) {
            return new Vstring((String) obj);
        }
        return null;
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.value, ((Vstring) obj).value);
    }

    public int hashCode() {
        return Objects.hash(this.value);
    }
}
