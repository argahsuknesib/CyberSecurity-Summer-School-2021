package com.xiaomi.smarthome.device.api.spec.definitions;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;

public class EventDefinition extends Spec.SpecItem implements Parcelable {
    public static final Parcelable.Creator<EventDefinition> CREATOR = new Parcelable.Creator<EventDefinition>() {
        /* class com.xiaomi.smarthome.device.api.spec.definitions.EventDefinition.AnonymousClass1 */

        public final EventDefinition createFromParcel(Parcel parcel) {
            return new EventDefinition(parcel);
        }

        public final EventDefinition[] newArray(int i) {
            return new EventDefinition[i];
        }
    };
    private long[] arguments;
    private SpecArguments[] argumentsV3;

    public int describeContents() {
        return 0;
    }

    public EventDefinition getEventDefinition() {
        return this;
    }

    public EventDefinition(int i, String str, String str2, String str3, long[] jArr) {
        super(i, str, str2, str3);
        this.arguments = jArr;
    }

    public EventDefinition(int i, String str, String str2, long[] jArr) {
        this(i, str, (String) null, str2, jArr);
    }

    public EventDefinition(int i, String str, String str2, String str3, SpecArguments[] specArgumentsArr) {
        super(i, str, str2, str3);
        this.argumentsV3 = specArgumentsArr;
    }

    public EventDefinition(int i, String str, String str2, SpecArguments[] specArgumentsArr) {
        this(i, str, (String) null, str2, specArgumentsArr);
    }

    protected EventDefinition(Parcel parcel) {
        super(parcel);
        this.arguments = parcel.createLongArray();
        this.argumentsV3 = (SpecArguments[]) parcel.readParcelableArray(SpecArguments.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLongArray(this.arguments);
        parcel.writeParcelableArray(this.argumentsV3, 0);
    }

    public long[] getArguments() {
        return this.arguments;
    }

    public SpecArguments[] getArgumentsV3() {
        return this.argumentsV3;
    }

    public void setArguments(long[] jArr) {
        this.arguments = jArr;
    }

    public static class SpecArguments implements Parcelable {
        public static final Parcelable.Creator<SpecArguments> CREATOR = new Parcelable.Creator<SpecArguments>() {
            /* class com.xiaomi.smarthome.device.api.spec.definitions.EventDefinition.SpecArguments.AnonymousClass1 */

            public final SpecArguments createFromParcel(Parcel parcel) {
                return new SpecArguments(parcel);
            }

            public final SpecArguments[] newArray(int i) {
                return new SpecArguments[i];
            }
        };
        private String description;
        private String format;

        public int describeContents() {
            return 0;
        }

        public SpecArguments(String str, String str2) {
            this.format = str;
            this.description = str2;
        }

        protected SpecArguments(Parcel parcel) {
            this.format = parcel.readString();
            this.description = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.format);
            parcel.writeString(this.description);
        }

        public String getFormat() {
            return this.format;
        }

        public String getDescription() {
            return this.description;
        }
    }
}
