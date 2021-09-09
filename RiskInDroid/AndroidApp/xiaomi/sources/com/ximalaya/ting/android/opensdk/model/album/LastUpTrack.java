package com.ximalaya.ting.android.opensdk.model.album;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class LastUpTrack implements Parcelable {
    public static Parcelable.Creator<LastUpTrack> CREATOR = new Parcelable.Creator<LastUpTrack>() {
        /* class com.ximalaya.ting.android.opensdk.model.album.LastUpTrack.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LastUpTrack[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LastUpTrack(parcel);
        }
    };
    @SerializedName("track_id")

    /* renamed from: O000000o  reason: collision with root package name */
    private long f12172O000000o;
    @SerializedName("track_title")
    private String O00000Oo;
    @SerializedName("created_at")
    private long O00000o;
    @SerializedName("duration")
    private long O00000o0;
    @SerializedName("updated_at")
    private long O00000oO;

    public int describeContents() {
        return 0;
    }

    public LastUpTrack() {
    }

    public LastUpTrack(Parcel parcel) {
        this.f12172O000000o = parcel.readLong();
        this.O00000o0 = parcel.readLong();
        this.O00000o = parcel.readLong();
        this.O00000oO = parcel.readLong();
        this.O00000Oo = parcel.readString();
    }

    public String toString() {
        return "LastUpTrack [trackId=" + this.f12172O000000o + ", trackTitle=" + this.O00000Oo + ", duration=" + this.O00000o0 + ", createdAt=" + this.O00000o + ", updatedAt=" + this.O00000oO + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.O00000o);
        parcel.writeLong(this.O00000oO);
        parcel.writeLong(this.f12172O000000o);
        parcel.writeLong(this.O00000o0);
        parcel.writeString(this.O00000Oo);
    }
}
