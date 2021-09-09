package _m_j;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import java.util.List;
import java.util.Map;

public class ijv<T extends PlayableModel> extends iix {
    @SerializedName(alternate = {"paid_tracks"}, value = "tracks")

    /* renamed from: O000000o  reason: collision with root package name */
    public List<T> f1378O000000o;
    public Map<String, String> O00000Oo;
    @SerializedName("total_page")
    public int O00000o;
    @SerializedName("total_count")
    public int O00000o0;

    public String toString() {
        return "CommonTrackList [tracks=" + this.f1378O000000o + ", params=" + this.O00000Oo + ", totalCount=" + this.O00000o0 + ", totalPage=" + this.O00000o + "]";
    }
}
