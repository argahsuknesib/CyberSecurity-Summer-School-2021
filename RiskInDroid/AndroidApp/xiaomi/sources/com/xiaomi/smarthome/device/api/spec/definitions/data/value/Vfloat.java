package com.xiaomi.smarthome.device.api.spec.definitions.data.value;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataValue;

public class Vfloat extends DataValue implements Parcelable {
    public static final Parcelable.Creator<Vfloat> CREATOR = new Parcelable.Creator<Vfloat>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.value.Vfloat.AnonymousClass1 */

        public final Vfloat createFromParcel(Parcel parcel) {
            return new Vfloat(parcel);
        }

        public final Vfloat[] newArray(int i) {
            return new Vfloat[i];
        }
    };
    private float value;

    public int describeContents() {
        return 0;
    }

    public Vfloat() {
        this.value = 0.0f;
    }

    public Vfloat(float f) {
        this.value = f;
    }

    public Vfloat(double d) {
        this.value = (float) d;
    }

    public Vfloat(int i) {
        this.value = (float) i;
    }

    protected Vfloat(Parcel parcel) {
        this.value = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.value);
    }

    public float getValue() {
        return this.value;
    }

    public boolean lessEquals(DataValue dataValue) {
        if (dataValue.getClass() == getClass() && this.value < ((Vfloat) dataValue).value) {
            return true;
        }
        return false;
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2) {
        if (dataValue.getClass() == getClass() && dataValue2.getClass() == getClass()) {
            Vfloat vfloat = (Vfloat) dataValue2;
            float f = this.value;
            if (f < ((Vfloat) dataValue).value || f > vfloat.value) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public boolean validate(DataValue dataValue, DataValue dataValue2, DataValue dataValue3) {
        if (dataValue.getClass() == getClass() && dataValue2.getClass() == getClass() && dataValue3.getClass() == getClass()) {
            float f = ((Vfloat) dataValue).value;
            float f2 = ((Vfloat) dataValue2).value;
            float f3 = ((Vfloat) dataValue3).value;
            float f4 = this.value;
            if (f4 >= f && f4 <= f2 && f3 > 0.0f) {
                double d = (double) f4;
                double d2 = (double) f;
                Double.isNaN(d);
                Double.isNaN(d2);
                double d3 = d - d2;
                double d4 = (double) f3;
                Double.isNaN(d4);
                float max = Math.max(f3 / 100.0f, 1.0E-5f);
                float f5 = f + (((float) ((long) (d3 / d4))) * f3);
                float f6 = f3 + f5;
                if (Math.abs(f5 - this.value) < max || Math.abs(f6 - this.value) < max) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public Object getObjectValue() {
        return Float.valueOf(this.value);
    }

    public static Vfloat valueOf(Object obj) {
        if (obj instanceof Float) {
            return new Vfloat(((Float) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new Vfloat(((Double) obj).doubleValue());
        }
        if (obj instanceof Integer) {
            return new Vfloat(((Integer) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return new Vfloat(Float.valueOf((String) obj).floatValue());
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
