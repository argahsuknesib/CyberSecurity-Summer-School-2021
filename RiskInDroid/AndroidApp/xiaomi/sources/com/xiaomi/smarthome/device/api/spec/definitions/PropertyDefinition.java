package com.xiaomi.smarthome.device.api.spec.definitions;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.data.Access;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataFormat;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.Unit;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.operation.controller.PropertyController;

public class PropertyDefinition extends Spec.SpecItem implements Parcelable {
    public static final Parcelable.Creator<PropertyDefinition> CREATOR = new Parcelable.Creator<PropertyDefinition>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.PropertyDefinition.AnonymousClass1 */

        public final PropertyDefinition createFromParcel(Parcel parcel) {
            return new PropertyDefinition(parcel);
        }

        public final PropertyDefinition[] newArray(int i) {
            return new PropertyDefinition[i];
        }
    };
    private Access access;
    private ConstraintValue constraintValue;
    private String format;
    private String unit;
    private DataValue value;

    public int describeContents() {
        return 0;
    }

    public PropertyDefinition getPropertyDefinition() {
        return this;
    }

    public PropertyDefinition(int i, String str, String str2, String str3, Access access2, String str4, ConstraintValue constraintValue2, String str5) {
        super(i, str, str2, str3);
        this.access = access2;
        this.format = str4;
        this.unit = str5;
        this.constraintValue = constraintValue2;
    }

    public PropertyDefinition(int i, String str, String str2, Access access2, DataFormat dataFormat, ConstraintValue constraintValue2, String str3) {
        this(i, str, null, str2, access2, dataFormat.toString(), constraintValue2, str3);
    }

    protected PropertyDefinition(Parcel parcel) {
        super(parcel);
        this.format = parcel.readString();
        this.constraintValue = (ConstraintValue) parcel.readParcelable(ConstraintValue.class.getClassLoader());
        this.access = (Access) parcel.readParcelable(Access.class.getClassLoader());
        this.unit = parcel.readString();
        this.value = (DataValue) parcel.readParcelable(DataValue.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.format);
        parcel.writeParcelable(this.constraintValue, i);
        parcel.writeParcelable(this.access, i);
        parcel.writeString(this.unit);
        parcel.writeParcelable(this.value, i);
    }

    public Access access() {
        return this.access;
    }

    public boolean readable() {
        return this.access.isReadable();
    }

    public void readable(boolean z) {
        this.access.setReadable(z);
    }

    public boolean writable() {
        return this.access.isWritable();
    }

    public void writable(boolean z) {
        this.access.setWritable(z);
    }

    public boolean notifiable() {
        return this.access.isNotifiable();
    }

    public void notifiable(boolean z) {
        this.access.setNotifiable(z);
    }

    public Unit unit() {
        return Unit.from(this.unit);
    }

    public String getUnit() {
        return this.unit;
    }

    @Deprecated
    public void unit(Unit unit2) {
        this.unit = unit2.toString();
    }

    @Deprecated
    public DataFormat getFormat() {
        return DataFormat.from(this.format);
    }

    public String getFormatString() {
        return this.format;
    }

    @Deprecated
    public void setFormat(DataFormat dataFormat) {
        this.format = dataFormat.toString();
    }

    public ConstraintValue getConstraintValue() {
        return this.constraintValue;
    }

    public void setConstraintValue(ConstraintValue constraintValue2) {
        this.constraintValue = constraintValue2;
    }

    @Deprecated
    public boolean validate(DataValue dataValue) {
        if (dataValue == null || !getFormat().getJavaClass().isInstance(dataValue)) {
            return false;
        }
        ConstraintValue constraintValue2 = this.constraintValue;
        if (constraintValue2 == null || constraintValue2.validate(dataValue)) {
            return true;
        }
        return false;
    }

    public Object getValue() {
        DataValue dataValue = this.value;
        if (dataValue == null) {
            return null;
        }
        return dataValue.getObjectValue();
    }

    @Deprecated
    public boolean setValue(Object obj) {
        DataValue createValue = getFormat().createValue(obj);
        if (createValue == null || !validate(createValue)) {
            return false;
        }
        this.value = createValue;
        return true;
    }

    public PropertyController createController() {
        return new PropertyController(getIid(), this);
    }

    public int hashCode() {
        int i;
        String type = getType();
        if (type == null) {
            i = 0;
        } else {
            i = type.hashCode();
        }
        return i + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String type = getType();
        String type2 = ((PropertyDefinition) obj).getType();
        if (type == null) {
            return type2 == null;
        }
        return type.equals(type2);
    }
}
