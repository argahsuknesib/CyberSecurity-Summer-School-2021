package com.xiaomi.smarthome.device.api.spec.definitions.data.value;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataValue;

public final class Vbool extends DataValue implements Parcelable {
    public static final Parcelable.Creator<Vbool> CREATOR = new Parcelable.Creator<Vbool>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vbool.AnonymousClass1 */

        public final Vbool createFromParcel(Parcel parcel) {
            return new Vbool(parcel);
        }

        public final Vbool[] newArray(int i) {
            return new Vbool[i];
        }
    };
    private boolean value;

    public final int describeContents() {
        return 0;
    }

    public Vbool() {
        this.value = false;
    }

    public Vbool(boolean z) {
        this.value = z;
    }

    public Vbool(int i) {
        this.value = i != 1 ? false : true;
    }

    protected Vbool(Parcel parcel) {
        this.value = parcel.readByte() != 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.value ? (byte) 1 : 0);
    }

    public final boolean getValue() {
        return this.value;
    }

    public final Object getObjectValue() {
        return Boolean.valueOf(this.value);
    }

    public static Vbool valueOf(Object obj) {
        if (obj instanceof Boolean) {
            return new Vbool(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("true".equalsIgnoreCase(str)) {
                return new Vbool(true);
            }
            if ("false".equalsIgnoreCase(str)) {
                return new Vbool(false);
            }
            return null;
        } else if (!(obj instanceof Integer)) {
            return null;
        } else {
            Integer num = (Integer) obj;
            if (num.intValue() == 1) {
                return new Vbool(true);
            }
            if (num.intValue() == 0) {
                return new Vbool(false);
            }
            return null;
        }
    }

    public final String toString() {
        return String.valueOf(this.value);
    }
}
