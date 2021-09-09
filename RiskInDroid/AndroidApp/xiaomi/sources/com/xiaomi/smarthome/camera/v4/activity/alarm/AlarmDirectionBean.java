package com.xiaomi.smarthome.camera.v4.activity.alarm;

import android.os.Parcel;
import android.os.Parcelable;

public class AlarmDirectionBean implements Parcelable {
    public static final Parcelable.Creator<AlarmDirectionBean> CREATOR = new Parcelable.Creator<AlarmDirectionBean>() {
        /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmDirectionBean.AnonymousClass1 */

        public final AlarmDirectionBean createFromParcel(Parcel parcel) {
            return new AlarmDirectionBean(parcel);
        }

        public final AlarmDirectionBean[] newArray(int i) {
            return new AlarmDirectionBean[i];
        }
    };
    public int mDirection = 0;
    public int mEndTime = 0;
    public int mID = 0;
    public int mStartTime = 0;
    public int mTimeType = 0;
    public String op;

    public int describeContents() {
        return 0;
    }

    AlarmDirectionBean() {
    }

    protected AlarmDirectionBean(Parcel parcel) {
        this.mTimeType = parcel.readInt();
        this.mStartTime = parcel.readInt();
        this.mEndTime = parcel.readInt();
        this.mDirection = parcel.readInt();
        this.mID = parcel.readInt();
        this.op = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mTimeType);
        parcel.writeInt(this.mStartTime);
        parcel.writeInt(this.mEndTime);
        parcel.writeInt(this.mDirection);
        parcel.writeInt(this.mID);
        parcel.writeString(this.op);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AlarmDirectionBean)) {
            AlarmDirectionBean alarmDirectionBean = (AlarmDirectionBean) obj;
            if (alarmDirectionBean.mDirection == this.mDirection && this.mStartTime <= alarmDirectionBean.mEndTime && this.mEndTime >= alarmDirectionBean.mStartTime) {
                return true;
            }
        }
        return false;
    }
}
