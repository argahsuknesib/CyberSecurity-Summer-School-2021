package com.ximalaya.ting.android.opensdk.model;

import _m_j.ilq;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.live.schedule.Schedule;
import com.ximalaya.ting.android.opensdk.model.track.Track;

public class PlayableModel extends ilq implements Parcelable {
    public static final Parcelable.Creator<PlayableModel> CREATOR = new Parcelable.Creator<PlayableModel>() {
        /* class com.ximalaya.ting.android.opensdk.model.PlayableModel.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlayableModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlayableModel(parcel);
        }
    };
    @SerializedName(alternate = {"trackId"}, value = "id")

    /* renamed from: O000000o  reason: collision with root package name */
    public long f12166O000000o;
    public String O00000Oo;
    public boolean O00000o;
    public int O00000o0 = -1;
    public long O00000oO;
    public long O00000oo;
    public String O0000O0o;

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        long j = this.f12166O000000o;
        return ((int) (j ^ (j >>> 32))) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        boolean z = (obj instanceof Track) && (this instanceof Track);
        boolean z2 = (obj instanceof Radio) && (this instanceof Radio);
        boolean z3 = (obj instanceof Schedule) && (this instanceof Schedule);
        boolean z4 = getClass() == obj.getClass();
        if (!z && !z2 && !z3 && !z4) {
            return false;
        }
        PlayableModel playableModel = (PlayableModel) obj;
        boolean z5 = this.O00000o;
        if (z5 != playableModel.O00000o) {
            return false;
        }
        if (z5) {
            return TextUtils.equals(this.O0000O0o, playableModel.O0000O0o);
        }
        return this.f12166O000000o == playableModel.f12166O000000o;
    }

    public void O000000o(Parcel parcel) {
        this.f12166O000000o = parcel.readLong();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt() != 0;
        this.O00000oO = parcel.readLong();
        this.O00000oo = parcel.readLong();
        this.O0000O0o = parcel.readString();
    }

    public String toString() {
        return "PlayableModel{dataId=" + this.f12166O000000o + ", kind='" + this.O00000Oo + '\'' + ", lastPlayedMills=" + this.O00000o0 + '}';
    }

    public PlayableModel() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12166O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeByte(this.O00000o ? (byte) 1 : 0);
        parcel.writeLong(this.O00000oO);
        parcel.writeLong(this.O00000oo);
        parcel.writeString(this.O0000O0o);
    }

    protected PlayableModel(Parcel parcel) {
        this.f12166O000000o = parcel.readLong();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readByte() != 0;
        this.O00000oO = parcel.readLong();
        this.O00000oo = parcel.readLong();
        this.O0000O0o = parcel.readString();
    }
}
