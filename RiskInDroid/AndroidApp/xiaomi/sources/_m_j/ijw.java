package _m_j;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.track.Track;

public final class ijw extends ijv<Track> {
    @SerializedName("current_page")
    public int O00000oO;
    @SerializedName("category_id")
    private int O00000oo;
    @SerializedName("tag_name")
    private String O0000O0o;

    public final String toString() {
        return "LastPlayTrackList [categoryId=" + this.O00000oo + ", tagname=" + this.O0000O0o + ", pageid=" + this.O00000oO + "]";
    }
}
