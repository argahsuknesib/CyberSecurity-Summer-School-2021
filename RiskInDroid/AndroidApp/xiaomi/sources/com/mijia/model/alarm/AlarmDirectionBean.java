package com.mijia.model.alarm;

import android.os.Parcel;
import android.os.Parcelable;

public class AlarmDirectionBean implements Parcelable {
    public static final Parcelable.Creator<AlarmDirectionBean> CREATOR = new Parcelable.Creator<AlarmDirectionBean>() {
        /* class com.mijia.model.alarm.AlarmDirectionBean.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AlarmDirectionBean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AlarmDirectionBean(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5240O000000o = 0;
    public int O00000Oo = 0;
    public int O00000o = 0;
    public int O00000o0 = 0;
    public int O00000oO = 0;
    public String O00000oo;

    public int describeContents() {
        return 0;
    }

    public AlarmDirectionBean() {
    }

    protected AlarmDirectionBean(Parcel parcel) {
        this.f5240O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5240O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeString(this.O00000oo);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AlarmDirectionBean)) {
            AlarmDirectionBean alarmDirectionBean = (AlarmDirectionBean) obj;
            if (alarmDirectionBean.O00000o == this.O00000o && this.O00000Oo <= alarmDirectionBean.O00000o0 && this.O00000o0 >= alarmDirectionBean.O00000Oo) {
                return true;
            }
        }
        return false;
    }
}
