package com.xiaomi.smarthome.core.entity.statistic;

import android.os.Parcel;
import android.os.Parcelable;

public enum StatType implements Parcelable {
    TIME("time"),
    EVENT("event"),
    SHOP("shop"),
    DEVICE_EDIT("devicelistedit"),
    PLUGIN("Plugin"),
    GENERAL("General"),
    DEVICE_LIST("DeviceList"),
    SCENE("Scene"),
    LABEL("Label"),
    ADD_DEVICE("AddDevice"),
    NOTIFICATION("Notification"),
    DEVICE_SHARE("DeviceShared"),
    UPDATE("Update"),
    EMPTY_DEVICE_ADV("EmptyDevAdv"),
    ACCOUNT("Account"),
    MI_BRAIN("MiBrain"),
    MICRO("Micro"),
    ADS("ads"),
    YOUPIN("youpin"),
    MIUI_SPLASH("MiuiSplash");
    
    public static final Parcelable.Creator<StatType> CREATOR = new Parcelable.Creator<StatType>() {
        /* class com.xiaomi.smarthome.core.entity.statistic.StatType.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StatType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            StatType statType = StatType.values()[parcel.readInt()];
            statType.mValue = parcel.readString();
            return statType;
        }
    };
    public String mValue;

    public final int describeContents() {
        return 0;
    }

    private StatType(String str) {
        this.mValue = str;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
        parcel.writeString(this.mValue);
    }
}
