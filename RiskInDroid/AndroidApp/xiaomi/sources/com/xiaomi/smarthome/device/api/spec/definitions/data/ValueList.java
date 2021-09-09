package com.xiaomi.smarthome.device.api.spec.definitions.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ValueList implements Parcelable, ConstraintValue {
    public static final Parcelable.Creator<ValueList> CREATOR = new Parcelable.Creator<ValueList>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList.AnonymousClass1 */

        public final ValueList createFromParcel(Parcel parcel) {
            return new ValueList(parcel);
        }

        public final ValueList[] newArray(int i) {
            return new ValueList[i];
        }
    };
    private List<ValueDefinition> values;

    public int describeContents() {
        return 0;
    }

    public ValueList(List<ValueDefinition> list) {
        this.values = list;
    }

    protected ValueList(Parcel parcel) {
        this.values = parcel.createTypedArrayList(ValueDefinition.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.values);
    }

    public boolean validate(DataValue dataValue) {
        for (ValueDefinition value : this.values) {
            if (value.value().equals(dataValue)) {
                return true;
            }
        }
        return false;
    }

    public List<ValueDefinition> values() {
        return this.values;
    }

    public int size() {
        List<ValueDefinition> list = this.values;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getIndexValue(int i) {
        List<ValueDefinition> list = this.values;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.values.get(i).valueObject();
    }

    public int getValueIndex(Object obj) {
        if (!(this.values == null || obj == null)) {
            for (int i = 0; i < this.values.size(); i++) {
                Object valueObject = this.values.get(i).valueObject();
                if (obj.equals(valueObject) || String.valueOf(obj).equals(String.valueOf(valueObject))) {
                    return i;
                }
            }
        }
        return -1;
    }
}
