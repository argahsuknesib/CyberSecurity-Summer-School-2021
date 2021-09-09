package _m_j;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import java.util.List;

public final class ijo extends iix {
    @SerializedName("total_page")

    /* renamed from: O000000o  reason: collision with root package name */
    private int f1371O000000o;
    @SerializedName("total_count")
    private int O00000Oo;
    @SerializedName("category_id")
    private int O00000o;
    @SerializedName("current_page")
    private int O00000o0;
    @SerializedName("tag_name")
    private String O00000oO;
    private List<Album> O00000oo;

    public final String toString() {
        return "SearchAlbumList [totalPage=" + this.f1371O000000o + ", totalCount=" + this.O00000Oo + ", albums=" + this.O00000oo + "]";
    }
}
