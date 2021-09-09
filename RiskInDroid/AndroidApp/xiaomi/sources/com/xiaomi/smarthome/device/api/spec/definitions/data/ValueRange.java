package com.xiaomi.smarthome.device.api.spec.definitions.data;

import _m_j.gsy;
import _m_j.hhc;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class ValueRange implements Parcelable, ConstraintValue {
    public static final Parcelable.Creator<ValueRange> CREATOR = new Parcelable.Creator<ValueRange>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.ValueRange.AnonymousClass1 */

        public final ValueRange createFromParcel(Parcel parcel) {
            return new ValueRange(parcel);
        }

        public final ValueRange[] newArray(int i) {
            return new ValueRange[i];
        }
    };
    private String format;
    private boolean hasStep;
    private Object maxValue;
    private Object minValue;
    private Object stepValue;

    public int describeContents() {
        return 0;
    }

    public ValueRange(String str, List<Object> list) {
        if (list.size() == 2) {
            init(str, list.get(0), list.get(1), null);
        } else if (list.size() == 3) {
            init(str, list.get(0), list.get(1), list.get(2));
        } else {
            throw new IllegalArgumentException("value list is null");
        }
    }

    @Deprecated
    public ValueRange(DataFormat dataFormat, List<Object> list) {
        this(dataFormat.toString(), list);
    }

    @Deprecated
    public ValueRange(DataFormat dataFormat, Object obj, Object obj2) {
        init(dataFormat.toString(), obj, obj2, null);
    }

    @Deprecated
    public ValueRange(DataFormat dataFormat, Object obj, Object obj2, Object obj3) {
        init(dataFormat.toString(), obj, obj2, obj3);
    }

    protected ValueRange(Parcel parcel) {
        this.format = parcel.readString();
        this.minValue = parcel.readValue(DataValue.class.getClassLoader());
        this.maxValue = parcel.readValue(DataValue.class.getClassLoader());
        this.stepValue = parcel.readValue(DataValue.class.getClassLoader());
        this.hasStep = parcel.readByte() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.format);
        parcel.writeValue(this.minValue);
        parcel.writeValue(this.maxValue);
        parcel.writeValue(this.stepValue);
        parcel.writeByte(this.hasStep ? (byte) 1 : 0);
    }

    private void init(String str, Object obj, Object obj2, Object obj3) {
        this.format = str;
        this.minValue = obj;
        this.maxValue = obj2;
        if (obj3 != null) {
            this.stepValue = obj3;
            this.hasStep = true;
            return;
        }
        this.stepValue = null;
        this.hasStep = false;
    }

    @Deprecated
    public boolean validate(DataValue dataValue) {
        DataFormat from = DataFormat.from(this.format);
        return from.validate(dataValue, from.createValue(this.minValue), from.createValue(this.maxValue), this.hasStep ? from.createValue(this.stepValue) : null);
    }

    public DataValue minValue() {
        return DataFormat.from(this.format).createValue(this.minValue);
    }

    public DataValue maxValue() {
        return DataFormat.from(this.format).createValue(this.maxValue);
    }

    public DataValue stepValue() {
        return DataFormat.from(this.format).createValue(this.stepValue);
    }

    public Object minValueObject() {
        return this.minValue;
    }

    public Object maxValueObject() {
        return this.maxValue;
    }

    public Object stepValueObject() {
        return this.stepValue;
    }

    public List<Object> toList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.minValue);
        arrayList.add(this.maxValue);
        if (this.hasStep) {
            arrayList.add(this.stepValue);
        }
        return arrayList;
    }

    public int size() {
        try {
            return ((int) ((((Number) this.maxValue).doubleValue() - ((Number) this.minValue).doubleValue()) / ((Number) this.stepValue).doubleValue())) + 1;
        } catch (Exception e) {
            gsy.O000000o(6, "ValueRange", Log.getStackTraceString(e));
            return 0;
        }
    }

    public Object getIndexValue(int i) {
        if (i < 0) {
            return this.minValue;
        }
        if (i > size()) {
            return this.maxValue;
        }
        double doubleValue = ((Number) this.minValue).doubleValue();
        double doubleValue2 = ((Number) this.stepValue).doubleValue();
        double d = (double) i;
        Double.isNaN(d);
        double d2 = (d * doubleValue2) + doubleValue;
        if (hhc.O000000o(this.format) || !String.valueOf(this.stepValue).contains(".")) {
            return Long.valueOf(Math.round(d2));
        }
        return Double.valueOf(d2);
    }

    public int getValueIndex(Object obj) {
        if (obj != null && !"".equals(obj)) {
            try {
                double doubleValue = ((Number) this.maxValue).doubleValue();
                double doubleValue2 = ((Number) this.minValue).doubleValue();
                double doubleValue3 = ((Number) this.stepValue).doubleValue();
                double doubleValue4 = obj instanceof Number ? ((Number) obj).doubleValue() : Double.parseDouble(String.valueOf(obj));
                if (doubleValue4 < doubleValue2) {
                    return 0;
                }
                if (doubleValue4 > doubleValue) {
                    return size();
                }
                return (int) Math.round((doubleValue4 - doubleValue2) / doubleValue3);
            } catch (Throwable th) {
                gsy.O000000o(6, "ValueRange", Log.getStackTraceString(th));
            }
        }
        return -1;
    }
}
