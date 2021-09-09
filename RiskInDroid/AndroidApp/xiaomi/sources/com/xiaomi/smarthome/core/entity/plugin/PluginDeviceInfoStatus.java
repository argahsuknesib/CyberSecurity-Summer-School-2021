package com.xiaomi.smarthome.core.entity.plugin;

import android.os.Parcel;
import android.os.Parcelable;

public enum PluginDeviceInfoStatus implements Parcelable {
    INIT(0),
    WHITE_LIST(1),
    PREVIEW(2),
    RELEASE(3);
    
    public static final Parcelable.Creator<PluginDeviceInfoStatus> CREATOR = new Parcelable.Creator<PluginDeviceInfoStatus>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfoStatus.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginDeviceInfoStatus[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return PluginDeviceInfoStatus.values()[parcel.readInt()];
        }
    };
    private int mValue;

    public final int describeContents() {
        return 0;
    }

    private PluginDeviceInfoStatus(int i) {
        this.mValue = i;
    }

    public static PluginDeviceInfoStatus valueOf(int i) {
        for (PluginDeviceInfoStatus pluginDeviceInfoStatus : values()) {
            if (i == pluginDeviceInfoStatus.getValue()) {
                return pluginDeviceInfoStatus;
            }
        }
        return INIT;
    }

    public final int getValue() {
        return this.mValue;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
