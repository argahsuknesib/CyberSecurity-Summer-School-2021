package com.ximalaya.ting.android.opensdk.model.album;

import _m_j.ilq;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class SubordinatedAlbum extends ilq implements Parcelable {
    public static final Parcelable.Creator<SubordinatedAlbum> CREATOR = new Parcelable.Creator<SubordinatedAlbum>() {
        /* class com.ximalaya.ting.android.opensdk.model.album.SubordinatedAlbum.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SubordinatedAlbum[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            SubordinatedAlbum subordinatedAlbum = new SubordinatedAlbum();
            subordinatedAlbum.f12174O000000o = parcel.readLong();
            subordinatedAlbum.O00000Oo = parcel.readString();
            subordinatedAlbum.O00000o0 = parcel.readString();
            subordinatedAlbum.O00000o = parcel.readString();
            subordinatedAlbum.O00000oO = parcel.readString();
            subordinatedAlbum.O00000oo = parcel.readString();
            subordinatedAlbum.O0000O0o = parcel.readString();
            subordinatedAlbum.O0000OOo = parcel.readInt();
            return subordinatedAlbum;
        }
    };
    @SerializedName("id")

    /* renamed from: O000000o  reason: collision with root package name */
    public long f12174O000000o;
    @SerializedName("album_title")
    public String O00000Oo;
    @SerializedName("cover_url_middle")
    String O00000o;
    @SerializedName("cover_url_small")
    String O00000o0;
    @SerializedName("cover_url_large")
    String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    int O0000OOo;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SubordinatedAlbum [albumId=" + this.f12174O000000o + ", albumTitle=" + this.O00000Oo + ", coverUrlSmall=" + this.O00000o0 + ", coverUrlMiddle=" + this.O00000o + ", coverUrlLarge=" + this.O00000oO + ", recSrc=" + this.O00000oo + ", recTrack=" + this.O0000O0o + ",serializeStatus=" + this.O0000OOo + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12174O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
    }
}
