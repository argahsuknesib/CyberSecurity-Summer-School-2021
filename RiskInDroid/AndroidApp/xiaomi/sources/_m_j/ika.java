package _m_j;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.track.Track;

public final class ika extends ijv<Track> {
    @SerializedName("album_id")
    private int O00000oO;
    @SerializedName("album_title")
    private String O00000oo;
    @SerializedName("category_id")
    private int O0000O0o;
    @SerializedName("album_intro")
    private String O0000OOo;
    @SerializedName("cover_url_middle")
    private String O0000Oo;
    @SerializedName("cover_url_small")
    private String O0000Oo0;
    @SerializedName("cover_url_large")
    private String O0000OoO;
    @SerializedName("current_page")
    private int O0000Ooo;
    @SerializedName("can_download")
    private boolean O0000o00;

    public final String toString() {
        return "TrackList [albumId=" + this.O00000oO + ", albumTitle=" + this.O00000oo + ", categoryId=" + this.O0000O0o + ", albumIntro=" + this.O0000OOo + ", coverUrlSmall=" + this.O0000Oo0 + ", coverUrlMiddle=" + this.O0000Oo + ", coverUrlLarge=" + this.O0000OoO + ", currentPage=" + this.O0000Ooo + "]";
    }
}
