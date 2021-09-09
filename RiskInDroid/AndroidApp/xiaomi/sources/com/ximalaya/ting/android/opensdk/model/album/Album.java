package com.ximalaya.ting.android.opensdk.model.album;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Album implements Parcelable {
    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        /* class com.ximalaya.ting.android.opensdk.model.album.Album.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Album[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Album(parcel);
        }
    };
    @SerializedName(alternate = {"albumId"}, value = "id")

    /* renamed from: O000000o  reason: collision with root package name */
    public long f12170O000000o;
    @SerializedName(alternate = {"title"}, value = "album_title")
    private String O00000Oo;
    @SerializedName("album_intro")
    private String O00000o;
    @SerializedName("album_tags")
    private String O00000o0;
    @SerializedName("cover_url_small")
    private String O00000oO;
    @SerializedName("cover_url_middle")
    private String O00000oo;
    @SerializedName("cover_url_large")
    private String O0000O0o;
    @SerializedName("announcer")
    private Announcer O0000OOo;
    @SerializedName("favorite_count")
    private long O0000Oo;
    @SerializedName("play_count")
    private long O0000Oo0;
    @SerializedName("include_track_count")
    private long O0000OoO;
    @SerializedName("last_uptrack")
    private LastUpTrack O0000Ooo;
    @SerializedName("is_finished")
    private int O0000o;
    @SerializedName("updated_at")
    private long O0000o0;
    @SerializedName("recommend_track")
    private RecommendTrack O0000o00;
    @SerializedName("created_at")
    private long O0000o0O;
    private long O0000o0o;
    @SerializedName("based_relative_album_id")
    private long O0000oO;
    @SerializedName("recommend_src")
    private String O0000oO0;
    @SerializedName("recommend_trace")
    private String O0000oOO;
    @SerializedName("share_count")
    private String O0000oOo;
    @SerializedName("can_download")
    private boolean O0000oo;
    @SerializedName("subscribe_count")
    private long O0000oo0;
    @SerializedName("category_id")
    private int O0000ooO;
    @SerializedName("tracks_natural_ordered")
    private boolean O0000ooo;
    @SerializedName("album_rich_intro")
    private String O000O00o;
    @SerializedName("speaker_intro")
    private String O000O0OO;
    @SerializedName("free_track_count")
    private int O000O0Oo;
    @SerializedName("expected_revenue")
    private String O000O0o;
    @SerializedName("sale_intro")
    private String O000O0o0;
    @SerializedName("buy_notes")
    private String O000O0oO;
    @SerializedName("speaker_title")
    private String O000O0oo;
    @SerializedName("composed_price_type")
    private int O000OO;
    @SerializedName("speaker_content")
    private String O000OO00;
    @SerializedName("has_sample")
    private boolean O000OO0o;
    @SerializedName("price_type_detail")
    private String O000OOOo;
    @SerializedName("detail_banner_url")
    private String O000OOo;
    @SerializedName("price_type_info")
    private List<Object> O000OOo0;
    @SerializedName("album_score")
    private String O000OOoO;
    @SerializedName("free_track_ids")
    private String O00oOoOo;
    @SerializedName("is_paid")
    private boolean O00oOooO;
    @SerializedName("estimated_track_count")
    private int O00oOooo;

    public int describeContents() {
        return 0;
    }

    public Album() {
    }

    public Album(Parcel parcel) {
        this.f12170O000000o = parcel.readLong();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = (Announcer) parcel.readParcelable(Announcer.class.getClassLoader());
        this.O0000Oo0 = parcel.readLong();
        this.O0000Oo = parcel.readLong();
        this.O0000OoO = parcel.readLong();
        this.O0000Ooo = (LastUpTrack) parcel.readParcelable(LastUpTrack.class.getClassLoader());
        this.O0000o00 = (RecommendTrack) parcel.readParcelable(RecommendTrack.class.getClassLoader());
        this.O0000o0 = parcel.readLong();
        this.O0000o0O = parcel.readLong();
        this.O0000o0o = parcel.readLong();
        this.O0000o = parcel.readInt();
        this.O0000oO0 = parcel.readString();
        this.O0000oO = parcel.readLong();
        this.O0000oOO = parcel.readString();
        this.O0000oOo = parcel.readString();
    }

    public String toString() {
        return "Album [id=" + this.f12170O000000o + ", albumTitle=" + this.O00000Oo + ", albumTags=" + this.O00000o0 + ", albumIntro=" + this.O00000o + ", coverUrlSmall=" + this.O00000oO + ", coverUrlMiddle=" + this.O00000oo + ", coverUrlLarge=" + this.O0000O0o + ", announcer=" + this.O0000OOo + ", playCount=" + this.O0000Oo0 + ", favoriteCount=" + this.O0000Oo + ", includeTrackCount=" + this.O0000OoO + ", lastUptrack=" + this.O0000Ooo + ", recommendTrack=" + this.O0000o00 + ", updatedAt=" + this.O0000o0 + ", createdAt=" + this.O0000o0O + ", soundLastListenId=" + this.O0000o0o + ", isFinished=" + this.O0000o + ", recommentSrc=" + this.O0000oO0 + ", basedRelativeAlbumId=" + this.O0000oO + ", recommendTrace=" + this.O0000oOO + ", shareCount=" + this.O0000oOo + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12170O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeParcelable(this.O0000OOo, i);
        parcel.writeLong(this.O0000Oo0);
        parcel.writeLong(this.O0000Oo);
        parcel.writeLong(this.O0000OoO);
        parcel.writeParcelable(this.O0000Ooo, i);
        parcel.writeParcelable(this.O0000o00, i);
        parcel.writeLong(this.O0000o0);
        parcel.writeLong(this.O0000o0o);
        parcel.writeLong(this.O0000o0O);
        parcel.writeInt(this.O0000o);
        parcel.writeString(this.O0000oO0);
        parcel.writeLong(this.O0000oO);
        parcel.writeString(this.O0000oOO);
        parcel.writeString(this.O0000oOo);
    }
}
