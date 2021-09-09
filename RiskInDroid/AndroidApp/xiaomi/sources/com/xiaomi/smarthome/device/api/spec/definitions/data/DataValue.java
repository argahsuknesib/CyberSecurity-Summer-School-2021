package com.xiaomi.smarthome.device.api.spec.definitions.data;

import android.os.Parcelable;

@Deprecated
public abstract class DataValue implements Parcelable {
    public abstract Object getObjectValue();

    public boolean lessEquals(DataValue dataValue) {
        throw new RuntimeException("not implemented!");
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2) {
        throw new RuntimeException("not implemented!");
    }

    public boolean validate(DataValue dataValue, DataValue dataValue2, DataValue dataValue3) {
        throw new RuntimeException("not implemented!");
    }
}
