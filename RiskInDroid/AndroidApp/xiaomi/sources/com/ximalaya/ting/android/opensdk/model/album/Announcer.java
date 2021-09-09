package com.ximalaya.ting.android.opensdk.model.album;

import _m_j.ilq;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Announcer extends ilq implements Parcelable {
    public static final Parcelable.Creator<Announcer> CREATOR = new Parcelable.Creator<Announcer>() {
        /* class com.ximalaya.ting.android.opensdk.model.album.Announcer.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Announcer[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Announcer announcer = new Announcer();
            announcer.f12171O000000o = parcel.readLong();
            announcer.O00000Oo = parcel.readString();
            announcer.O00000o0 = parcel.readString();
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            announcer.O00000o = zArr[0];
            announcer.O00000oO = parcel.readString();
            announcer.O00000oo = parcel.readLong();
            announcer.O0000O0o = parcel.readString();
            announcer.O0000OOo = parcel.readString();
            announcer.O0000Oo0 = parcel.readString();
            announcer.O0000Oo = parcel.readLong();
            announcer.O0000OoO = parcel.readLong();
            announcer.O0000Ooo = parcel.readLong();
            announcer.O0000o00 = parcel.readLong();
            announcer.O0000o0 = parcel.readInt();
            announcer.O0000o0O = parcel.readInt();
            return announcer;
        }
    };
    @SerializedName("id")

    /* renamed from: O000000o  reason: collision with root package name */
    public long f12171O000000o;
    public String O00000Oo;
    @SerializedName("is_verified")
    boolean O00000o;
    @SerializedName("avatar_url")
    public String O00000o0;
    String O00000oO;
    @SerializedName("vcategory_id")
    long O00000oo;
    String O0000O0o;
    String O0000OOo;
    @SerializedName("follower_count")
    long O0000Oo;
    @SerializedName("announcer_position")
    String O0000Oo0;
    @SerializedName("following_count")
    long O0000OoO;
    @SerializedName("released_album_count")
    long O0000Ooo;
    int O0000o0;
    @SerializedName("released_track_count")
    long O0000o00;
    int O0000o0O;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12171O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeBooleanArray(new boolean[]{this.O00000o});
        parcel.writeString(this.O00000oO);
        parcel.writeLong(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeLong(this.O0000Oo);
        parcel.writeLong(this.O0000OoO);
        parcel.writeLong(this.O0000Ooo);
        parcel.writeLong(this.O0000o00);
        parcel.writeInt(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
    }

    public String toString() {
        return "Announcer [id=" + this.f12171O000000o + ", nickname=" + this.O00000Oo + ", avatarUrl=" + this.O00000o0 + ", isVerified=" + this.O00000o + "]";
    }
}
