package com.xiaomi.smarthome.device.api.spec.instance;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.EventDefinition;

public class SpecEvent extends EventDefinition implements Parcelable {
    public static final Parcelable.Creator<SpecEvent> CREATOR = new Parcelable.Creator<SpecEvent>() {
        /* class com.xiaomi.smarthome.device.api.spec.instance.SpecEvent.AnonymousClass1 */

        public final SpecEvent createFromParcel(Parcel parcel) {
            return new SpecEvent(parcel);
        }

        public final SpecEvent[] newArray(int i) {
            return new SpecEvent[i];
        }
    };

    public SpecEvent(int i, String str, String str2, String str3, long[] jArr) {
        super(i, str, str2, str3, jArr);
    }

    public SpecEvent(int i, String str, String str2, long[] jArr) {
        super(i, str, str2, jArr);
    }

    public SpecEvent(int i, String str, String str2, String str3, EventDefinition.SpecArguments[] specArgumentsArr) {
        super(i, str, str2, str3, specArgumentsArr);
    }

    public SpecEvent(int i, String str, String str2, EventDefinition.SpecArguments[] specArgumentsArr) {
        super(i, str, str2, specArgumentsArr);
    }

    protected SpecEvent(Parcel parcel) {
        super(parcel);
    }
}
