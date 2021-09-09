package com.xiaomi.smarthome.device.api.spec.definitions.data;

import android.os.Parcelable;

public interface ConstraintValue extends Parcelable {
    Object getIndexValue(int i);

    int getValueIndex(Object obj);

    int size();

    @Deprecated
    boolean validate(DataValue dataValue);
}
