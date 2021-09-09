package _m_j;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import java.util.List;

public final class ijn extends iix {
    @SerializedName("total_page")

    /* renamed from: O000000o  reason: collision with root package name */
    private int f1370O000000o;
    @SerializedName("total_count")
    private int O00000Oo;
    @SerializedName("tag_name")
    private String O00000o;
    @SerializedName("category_id")
    private int O00000o0;
    @SerializedName("current_page")
    private int O00000oO;
    @SerializedName(alternate = {"paid_albums"}, value = "albums")
    private List<Album> O00000oo;

    public final String toString() {
        return "AlbumList [totalPage=" + this.f1370O000000o + ", totalCount=" + this.O00000Oo + ", categoryId=" + this.O00000o0 + ", tagName=" + this.O00000o + ", currentPage=" + this.O00000oO + ", albums=" + this.O00000oo + "]";
    }
}
