package com.xiaomi.mico.setting.babyschedule.bean;

import _m_j.jcw;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mico.api.model.Music;
import java.util.Objects;

public class ScheduleItem extends BaseScheduleItem implements Parcelable, HorizontalListItemInterface {
    public static final Parcelable.Creator<ScheduleItem> CREATOR = new Parcelable.Creator<ScheduleItem>() {
        /* class com.xiaomi.mico.setting.babyschedule.bean.ScheduleItem.AnonymousClass1 */

        public final ScheduleItem createFromParcel(Parcel parcel) {
            return new ScheduleItem(parcel);
        }

        public final ScheduleItem[] newArray(int i) {
            return new ScheduleItem[i];
        }
    };
    public Music.Station srcStation;

    public int describeContents() {
        return 0;
    }

    public int getItemType() {
        return 2;
    }

    public void handleItemClick(Context context) {
    }

    public ScheduleItem(Parcel parcel) {
        this.cpId = parcel.readString();
        this.cp = parcel.readString();
        this.globalId = parcel.readString();
        this.resourceType = parcel.readString();
        this.target = parcel.readString();
        this.title = parcel.readString();
        this.shortDescription = parcel.readString();
        this.updateTime = parcel.readLong();
        this.images = (Images) parcel.readParcelable(Images.class.getClassLoader());
    }

    public ScheduleItem(Music.Station station) {
        this.srcStation = station;
        this.cpId = station.albumId;
        this.cp = station.cp;
        this.globalId = station.albumGlobalID;
        this.title = station.title;
        this.shortDescription = station.albumAbstract;
        this.images = new Images(station.cover);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cpId);
        parcel.writeString(this.cp);
        parcel.writeString(this.globalId);
        parcel.writeString(this.resourceType);
        parcel.writeString(this.target);
        parcel.writeString(this.title);
        parcel.writeString(this.shortDescription);
        parcel.writeLong(this.updateTime);
        parcel.writeParcelable(this.images, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ScheduleItem scheduleItem = (ScheduleItem) obj;
            return jcw.O000000o(this.cpId, scheduleItem.cpId) && jcw.O000000o(this.cp, scheduleItem.cp);
        }
    }

    public int hashCode() {
        return Objects.hash(this.cpId, this.cp, this.globalId, this.resourceType, this.target, this.title, this.shortDescription);
    }
}
