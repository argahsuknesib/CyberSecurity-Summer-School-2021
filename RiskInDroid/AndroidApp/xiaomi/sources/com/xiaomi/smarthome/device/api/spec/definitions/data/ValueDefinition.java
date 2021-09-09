package com.xiaomi.smarthome.device.api.spec.definitions.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ValueDefinition implements Parcelable {
    public static final Parcelable.Creator<ValueDefinition> CREATOR = new Parcelable.Creator<ValueDefinition>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition.AnonymousClass1 */

        public final ValueDefinition createFromParcel(Parcel parcel) {
            return new ValueDefinition(parcel);
        }

        public final ValueDefinition[] newArray(int i) {
            return new ValueDefinition[i];
        }
    };
    private String description;
    private String format;
    private Object value;

    public int describeContents() {
        return 0;
    }

    public ValueDefinition() {
    }

    public ValueDefinition(DataValue dataValue, String str) {
        Object obj;
        if (dataValue == null) {
            obj = null;
        } else {
            obj = dataValue.getObjectValue();
        }
        this.value = obj;
        this.description = str;
    }

    public ValueDefinition(DataFormat dataFormat, Object obj, String str) {
        String str2;
        if (dataFormat == null) {
            str2 = null;
        } else {
            str2 = dataFormat.toString();
        }
        this.format = str2;
        this.description = str;
        this.value = obj;
        if (this.value == null) {
            throw new IllegalArgumentException("invalid value: " + obj + " type: " + obj.getClass().getSimpleName() + " description: " + str);
        }
    }

    public ValueDefinition(String str, Object obj, String str2) {
        this.format = str;
        this.description = str2;
        this.value = obj;
        if (this.value == null) {
            throw new IllegalArgumentException("invalid value: " + obj + " type: " + obj.getClass().getSimpleName() + " description: " + str2);
        }
    }

    protected ValueDefinition(Parcel parcel) {
        this.value = parcel.readValue(ValueDefinition.class.getClassLoader());
        this.description = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.value);
        parcel.writeString(this.description);
    }

    @Deprecated
    public DataValue value() {
        return DataFormat.from(this.format).createValue(this.value);
    }

    public Object valueObject() {
        return this.value;
    }

    @Deprecated
    public void setValue(DataValue dataValue) {
        this.value = dataValue;
    }

    public String description() {
        return this.description;
    }

    public void description(String str) {
        this.description = str;
    }
}
