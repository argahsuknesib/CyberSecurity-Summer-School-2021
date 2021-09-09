package com.xiaomi.smarthome.device.api.spec.instance;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.PropertyDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.Access;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataFormat;

public class SpecProperty extends PropertyDefinition implements Parcelable {
    public static final Parcelable.Creator<SpecProperty> CREATOR = new Parcelable.Creator<SpecProperty>() {
        /* class com.xiaomi.smarthome.device.api.spec.instance.SpecProperty.AnonymousClass1 */

        public final SpecProperty createFromParcel(Parcel parcel) {
            return new SpecProperty(parcel);
        }

        public final SpecProperty[] newArray(int i) {
            return new SpecProperty[i];
        }
    };

    public SpecProperty(int i, String str, String str2, String str3, Access access, String str4, ConstraintValue constraintValue, String str5) {
        super(i, str, str2, str3, access, str4, constraintValue, str5);
    }

    public SpecProperty(int i, String str, String str2, Access access, DataFormat dataFormat, ConstraintValue constraintValue, String str3) {
        super(i, str, str2, access, dataFormat, constraintValue, str3);
    }

    protected SpecProperty(Parcel parcel) {
        super(parcel);
    }

    public SpecProperty(int i, PropertyDefinition propertyDefinition) {
        super(i, propertyDefinition.getType(), propertyDefinition.getDescription(), propertyDefinition.access(), propertyDefinition.getFormat(), propertyDefinition.getConstraintValue(), propertyDefinition.getUnit());
    }
}
