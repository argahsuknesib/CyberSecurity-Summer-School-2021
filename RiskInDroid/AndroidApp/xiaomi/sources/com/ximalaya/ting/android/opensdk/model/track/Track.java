package com.ximalaya.ting.android.opensdk.model.track;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.album.Announcer;
import com.ximalaya.ting.android.opensdk.model.album.SubordinatedAlbum;

public class Track extends PlayableModel implements Parcelable {
    public static final Parcelable.Creator<Track> CREATOR = new Parcelable.Creator<Track>() {
        /* class com.ximalaya.ting.android.opensdk.model.track.Track.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Track[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Track track = new Track();
            track.O000000o(parcel);
            return track;
        }
    };
    public boolean O0000OOo;
    @SerializedName(alternate = {"trackIntro"}, value = "track_intro")
    public String O0000Oo;
    @SerializedName(alternate = {"title", "trackTitle"}, value = "track_title")
    public String O0000Oo0;
    @SerializedName(alternate = {"cover_small_path", "coverSmall", "coverUrlSmall"}, value = "cover_url_small")
    public String O0000OoO;
    @SerializedName(alternate = {"cover_middle_path", "coverUrlMiddle"}, value = "cover_url_middle")
    public String O0000Ooo;
    @SerializedName(alternate = {"play_path_64", "playPath64"}, value = "play_url_64")
    public String O0000o;
    public int O0000o0;
    @SerializedName(alternate = {"cover_large_path", "coverUrlLarge"}, value = "cover_url_large")
    public String O0000o00;
    @SerializedName(alternate = {"playCount"}, value = "play_count")
    public int O0000o0O;
    @SerializedName(alternate = {"play_path_32", "playPath32", "playUrl32"}, value = "play_url_32")
    public String O0000o0o;
    @SerializedName(alternate = {"play_path_aac_v164", "playUrl64M4a"}, value = "play_url_64_m4a")
    public String O0000oO;
    @SerializedName(alternate = {"play_path_aac_v224", "playUrl24M4a"}, value = "play_url_24_m4a")
    public String O0000oO0;
    @SerializedName("type")
    public int O0000oOO;
    @SerializedName(alternate = {"downloadSize"}, value = "download_size")
    public long O0000oOo;
    @SerializedName(alternate = {"album"}, value = "subordinated_album")
    public SubordinatedAlbum O0000oo;
    @SerializedName(alternate = {"updatedAt"}, value = "updated_at")
    public long O0000oo0;
    @SerializedName(alternate = {"playSource"}, value = "play_source")
    public int O0000ooO;
    public String O0000ooo;
    public long O000O00o;
    public long O000O0OO;
    public long O000O0Oo;
    @SerializedName(alternate = {"isPaid"}, value = "is_paid")
    public boolean O000O0o;
    @SerializedName(alternate = {"is_bought"}, value = "authorized")
    public boolean O000O0o0;
    @SerializedName(alternate = {"sampleDuration"}, value = "sample_duration")
    public int O000O0oO;
    public long O000O0oo;
    public String O000OO;
    public String O000OO00;
    public String O000OO0o;
    public String O000OOOo;
    public String O000OOo;
    public String O000OOo0;
    public long O000OOoO;
    public boolean O000OOoo;
    public String O000Oo0;
    public String O000Oo00;
    @SerializedName(alternate = {"trackTags"}, value = "track_tags")
    private String O000Oo0O;
    private Announcer O000Oo0o;
    @SerializedName(alternate = {"downloadCount"}, value = "download_count")
    private int O000OoO;
    @SerializedName(alternate = {"favoriteCount"}, value = "favorite_count")
    private int O000OoO0;
    @SerializedName(alternate = {"playSize32"}, value = "play_size_32")
    private int O000OoOO;
    @SerializedName(alternate = {"playSize64"}, value = "play_size_64")
    private int O000OoOo;
    @SerializedName(alternate = {"playSize64m4a"}, value = "play_size_64_m4a")
    private String O000Ooo;
    @SerializedName(alternate = {"playSize24M4a"}, value = "play_size_24_m4a")
    private String O000Ooo0;
    @SerializedName(alternate = {"orderNum"}, value = "order_num")
    private int O000OooO = -1;
    private int O000Oooo = -1;
    private long O000o;
    @SerializedName(alternate = {"createdAt"}, value = "created_at")
    private long O000o0;
    private long O000o00;
    private int O000o000 = 0;
    @SerializedName(alternate = {"download_path", "downloadUrl"}, value = "download_url")
    private String O000o00O;
    private int O000o00o;
    private long O000o0O;
    private int O000o0O0 = -2;
    private int O000o0OO = -1;
    private int O000o0Oo = -2;
    private boolean O000o0o;
    private String O000o0o0;
    private int O000o0oo;
    private int O000oO;
    private double O000oO0;
    private long O000oO00 = 0;
    private double O000oO0O;
    private long O000oO0o;
    private int O000oOO;
    @SerializedName(alternate = {"hasSample"}, value = "has_sample")
    private boolean O000oOO0;
    private int O000oOOO;
    private int O000oOOo;
    private int O000oOo;
    private int O000oOo0;
    @SerializedName(alternate = {"isTrailer"}, value = "is_trailer")
    private boolean O000oOoO;
    @SerializedName(alternate = {"canDownload"}, value = "can_download")
    private boolean O000oOoo;
    private boolean O000oo;
    @SerializedName(alternate = {"playUrlAmr"}, value = "play_url_amr")
    private String O000oo0;
    @SerializedName(alternate = {"playSizeAmr"}, value = "play_size_amr")
    private int O000oo0O;
    @SerializedName(alternate = {"categoryId"}, value = "category_id")
    private int O000oo0o;
    private boolean O000ooO;
    private boolean O000ooO0 = true;
    private long O000ooOO;
    private String O000ooOo;
    @SerializedName(alternate = {"commentCount"}, value = "comment_count")
    private int O00O0Oo;
    @SerializedName(alternate = {"free"}, value = "is_free")
    public boolean O00oOoOo;
    public String O00oOooO;
    public String O00oOooo;

    public int describeContents() {
        return 0;
    }

    public final Announcer O000000o() {
        Announcer announcer = this.O000Oo0o;
        return announcer == null ? new Announcer() : announcer;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O000Oo0O);
        parcel.writeString(this.O0000Oo);
        parcel.writeString(this.O0000OoO);
        parcel.writeString(this.O0000Ooo);
        parcel.writeString(this.O0000o00);
        parcel.writeParcelable(this.O000Oo0o, i);
        parcel.writeInt(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
        parcel.writeInt(this.O000OoO0);
        parcel.writeInt(this.O00O0Oo);
        parcel.writeInt(this.O000OoO);
        parcel.writeString(this.O0000o0o);
        parcel.writeInt(this.O000OoOO);
        parcel.writeString(this.O0000o);
        parcel.writeInt(this.O000OoOo);
        parcel.writeString(this.O0000oO0);
        parcel.writeString(this.O000Ooo0);
        parcel.writeString(this.O0000oO);
        parcel.writeString(this.O000Ooo);
        parcel.writeInt(this.O000OooO);
        parcel.writeString(this.O000o00O);
        parcel.writeLong(this.O0000oOo);
        parcel.writeLong(this.O000o0O);
        parcel.writeParcelable(this.O0000oo, i);
        parcel.writeInt(this.O000o00o);
        parcel.writeLong(this.O0000oo0);
        parcel.writeLong(this.O000o0);
        parcel.writeString(this.O0000ooo);
        parcel.writeString(this.O00oOooO);
        parcel.writeString(this.O00oOooo);
        parcel.writeLong(this.O000O00o);
        parcel.writeString(this.O000OO0o);
        parcel.writeString(this.O000OO);
        parcel.writeString(this.O000OOOo);
        parcel.writeString(this.O000OOo0);
        parcel.writeLong(this.O000O0OO);
        parcel.writeLong(this.O000O0Oo);
        parcel.writeInt(this.O000oo ? 1 : 0);
        parcel.writeInt(this.O000o0o ? 1 : 0);
        parcel.writeString(this.O000OO00);
        parcel.writeInt(this.O0000ooO);
        parcel.writeLong(this.O000o);
        parcel.writeString(this.O000o0o0);
        parcel.writeString(this.O000OOo);
        parcel.writeInt(this.O00oOoOo ? 1 : 0);
        parcel.writeInt(this.O000O0o0 ? 1 : 0);
        parcel.writeInt(this.O000O0o ? 1 : 0);
        parcel.writeDouble(this.O000oO0);
        parcel.writeDouble(this.O000oO0O);
        parcel.writeInt(this.O000oO);
        parcel.writeInt(this.O000O0oO);
        parcel.writeInt(this.O000oOo);
        parcel.writeLong(this.O000O0oo);
        parcel.writeInt(this.O0000OOo ? 1 : 0);
        parcel.writeLong(this.O000OOoO);
        parcel.writeString(this.O000oo0);
        parcel.writeInt(this.O000oo0O);
        parcel.writeInt(this.O000ooO0 ? 1 : 0);
        parcel.writeInt(this.O000ooO ? 1 : 0);
        parcel.writeLong(this.O000ooOO);
        parcel.writeString(this.O000ooOo);
        parcel.writeInt(this.O000OOoo ? 1 : 0);
        parcel.writeString(this.O000Oo00);
        parcel.writeString(this.O000Oo0);
        parcel.writeInt(this.O0000oOO);
    }

    public final void O000000o(Parcel parcel) {
        super.O000000o(parcel);
        this.O0000Oo0 = parcel.readString();
        this.O000Oo0O = parcel.readString();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readString();
        this.O0000Ooo = parcel.readString();
        this.O0000o00 = parcel.readString();
        this.O000Oo0o = (Announcer) parcel.readParcelable(Announcer.class.getClassLoader());
        this.O0000o0 = parcel.readInt();
        this.O0000o0O = parcel.readInt();
        this.O000OoO0 = parcel.readInt();
        this.O00O0Oo = parcel.readInt();
        this.O000OoO = parcel.readInt();
        this.O0000o0o = parcel.readString();
        this.O000OoOO = parcel.readInt();
        this.O0000o = parcel.readString();
        this.O000OoOo = parcel.readInt();
        this.O0000oO0 = parcel.readString();
        this.O000Ooo0 = parcel.readString();
        this.O0000oO = parcel.readString();
        this.O000Ooo = parcel.readString();
        this.O000OooO = parcel.readInt();
        this.O000o00O = parcel.readString();
        this.O0000oOo = parcel.readLong();
        this.O000o0O = parcel.readLong();
        this.O0000oo = (SubordinatedAlbum) parcel.readParcelable(SubordinatedAlbum.class.getClassLoader());
        this.O000o00o = parcel.readInt();
        this.O0000oo0 = parcel.readLong();
        this.O000o0 = parcel.readLong();
        this.O0000ooo = parcel.readString();
        this.O00oOooO = parcel.readString();
        this.O00oOooo = parcel.readString();
        this.O000O00o = parcel.readLong();
        this.O000OO0o = parcel.readString();
        this.O000OO = parcel.readString();
        this.O000OOOo = parcel.readString();
        this.O000OOo0 = parcel.readString();
        this.O000O0OO = parcel.readLong();
        this.O000O0Oo = parcel.readLong();
        boolean z = false;
        this.O000oo = parcel.readInt() == 1;
        this.O000o0o = parcel.readInt() == 1;
        this.O000OO00 = parcel.readString();
        this.O0000ooO = parcel.readInt();
        this.O000o = parcel.readLong();
        this.O000o0o0 = parcel.readString();
        this.O000OOo = parcel.readString();
        this.O00oOoOo = parcel.readInt() == 1;
        this.O000O0o0 = parcel.readInt() == 1;
        this.O000O0o = parcel.readInt() == 1;
        this.O000oO0 = parcel.readDouble();
        this.O000oO0O = parcel.readDouble();
        this.O000oO = parcel.readInt();
        this.O000O0oO = parcel.readInt();
        this.O000oOo = parcel.readInt();
        this.O000O0oo = parcel.readLong();
        this.O0000OOo = parcel.readInt() == 1;
        this.O000OOoO = parcel.readLong();
        this.O000oo0 = parcel.readString();
        this.O000oo0O = parcel.readInt();
        this.O000ooO0 = parcel.readInt() == 1;
        this.O000ooO = parcel.readInt() == 1;
        this.O000ooOO = parcel.readLong();
        this.O000ooOo = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.O000OOoo = z;
        this.O000Oo00 = parcel.readString();
        this.O000Oo0 = parcel.readString();
        this.O0000oOO = parcel.readInt();
    }

    public String toString() {
        return "Track{" + super.toString() + "trackTitle='" + this.O0000Oo0 + '\'' + ", trackTags='" + this.O000Oo0O + '\'' + ", trackIntro='" + this.O0000Oo + '\'' + ", coverUrlSmall='" + this.O0000OoO + '\'' + ", coverUrlMiddle='" + this.O0000Ooo + '\'' + ", coverUrlLarge='" + this.O0000o00 + '\'' + ", announcer=" + this.O000Oo0o + ", duration=" + this.O0000o0 + ", playCount=" + this.O0000o0O + ", favoriteCount=" + this.O000OoO0 + ", commentCount=" + this.O00O0Oo + ", downloadCount=" + this.O000OoO + ", playUrl32='" + this.O0000o0o + '\'' + ", playSize32=" + this.O000OoOO + ", playUrl64='" + this.O0000o + '\'' + ", playSize64=" + this.O000OoOo + ", playUrl24M4a='" + this.O0000oO0 + '\'' + ", playSize24M4a='" + this.O000Ooo0 + '\'' + ", playUrl64M4a='" + this.O0000oO + '\'' + ", playSize64m4a='" + this.O000Ooo + '\'' + ", orderNum=" + this.O000OooO + ", orderPositon=" + this.O000Oooo + ", downloadTime=" + this.O000o00 + ", downloadUrl='" + this.O000o00O + '\'' + ", downloadSize=" + this.O0000oOo + ", source=" + this.O000o00o + ", updatedAt=" + this.O0000oo0 + ", album=" + this.O0000oo + ", createdAt=" + this.O000o0 + ", playSource=" + this.O0000ooO + ", downloadedSaveFilePath='" + this.O0000ooo + '\'' + ", downloadedSize=" + this.O000o0O + ", trackStatus=" + this.O000o0OO + ", downloadStatus=" + this.O000o0Oo + ", sequenceId='" + this.O000o0o0 + '\'' + ", isAutoPaused=" + this.O000o0o + ", insertSequence=" + this.O000o0oo + ", timeline=" + this.O000o + ", downloadCreated=" + this.O000oO00 + ", extra=" + this.O0000OOo + ", startTime='" + this.O00oOooO + '\'' + ", endTime='" + this.O00oOooo + '\'' + ", scheduleId=" + this.O000O00o + ", programId=" + this.O000O0OO + ", radioId=" + this.O000O0Oo + ", price=" + this.O000oO0 + ", discountedPrice=" + this.O000oO0O + ", free=" + this.O00oOoOo + ", authorized=" + this.O000O0o0 + ", isPaid=" + this.O000O0o + ", uid=" + this.O000oO0o + ", priceTypeId=" + this.O000oO + ", blockIndex=" + this.O000oOO + ", blockNum=" + this.O000oOOO + ", protocolVersion=" + this.O000oOOo + ", chargeFileSize=" + this.O000oOo0 + ", sampleDuration=" + this.O000O0oO + ", canDownload=" + this.O000oOoo + ", radioName='" + this.O000OO00 + '\'' + ", radioRate24AacUrl='" + this.O000OO0o + '\'' + ", radioRate24TsUrl='" + this.O000OO + '\'' + ", radioRate64AacUrl='" + this.O000OOOo + '\'' + ", radioRate64TsUrl='" + this.O000OOo0 + '\'' + ", isLike=" + this.O000oo + ", playPathHq='" + this.O000OOo + '\'' + ", priceTypeEnum='" + this.O000oOo + '\'' + ", trackActivityId='" + this.O000O0oo + '\'' + ", liveRoomId='" + this.O000OOoO + '\'' + '}';
    }

    public final boolean O00000Oo() {
        if (!this.O000O0o0 && this.O000O0oO > 0) {
            if (!this.O00oOoOo && this.O000O0o) {
                return true;
            }
        }
        return false;
    }

    public final boolean O00000o0() {
        return this.O0000oOO != 4;
    }
}
