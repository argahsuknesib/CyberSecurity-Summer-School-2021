package com.ximalaya.ting.android.opensdk.model.album;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class RecommendTrack implements Parcelable {
    public static final Parcelable.Creator<RecommendTrack> CREATOR = new Parcelable.Creator<RecommendTrack>() {
        /* class com.ximalaya.ting.android.opensdk.model.album.RecommendTrack.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecommendTrack[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RecommendTrack(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private long f12173O000000o;
    @SerializedName("human_recommend_track_id")
    private long O00000Oo;
    @SerializedName("human_recommend_track_title")
    private String O00000o;
    @SerializedName("human_recommend_real_title")
    private String O00000o0;

    public int describeContents() {
        return 0;
    }

    public RecommendTrack() {
    }

    public RecommendTrack(Parcel parcel) {
        this.f12173O000000o = parcel.readLong();
        this.O00000Oo = parcel.readLong();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
    }

    public String toString() {
        return "RecommendTrack [uid=" + this.f12173O000000o + ", trackId=" + this.O00000Oo + ", realTitle=" + this.O00000o0 + ", tackTitle=" + this.O00000o + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12173O000000o);
        parcel.writeLong(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
    }
}
