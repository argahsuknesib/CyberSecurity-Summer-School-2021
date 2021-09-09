package _m_j;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/RoomBackGroupStyle;", "", "style", "", "title", "data", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getStyle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ggf {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f17737O000000o;
    public final String O00000Oo;
    public final List<String> O00000o0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ggf)) {
            return false;
        }
        ggf ggf = (ggf) obj;
        return ixe.O000000o(this.f17737O000000o, ggf.f17737O000000o) && ixe.O000000o(this.O00000Oo, ggf.O00000Oo) && ixe.O000000o(this.O00000o0, ggf.O00000o0);
    }

    public final int hashCode() {
        return (((this.f17737O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode();
    }

    public final String toString() {
        return "RoomBackGroupStyle(style=" + this.f17737O000000o + ", title=" + this.O00000Oo + ", data=" + this.O00000o0 + ')';
    }

    public ggf(String str, String str2, List<String> list) {
        ixe.O00000o(str, "style");
        ixe.O00000o(str2, "title");
        ixe.O00000o(list, "data");
        this.f17737O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = list;
    }
}
