package _m_j;

import java.util.Collections;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/uwb_external/SpeakPlatformConfig;", "", "android", "", "", "linux", "(Ljava/util/List;Ljava/util/List;)V", "getAndroid", "()Ljava/util/List;", "getLinux", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "uwb-external_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hzi {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<String> f1011O000000o;
    private final List<String> O00000Oo;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hzi)) {
            return false;
        }
        hzi hzi = (hzi) obj;
        return ixe.O000000o(this.f1011O000000o, hzi.f1011O000000o) && ixe.O000000o(this.O00000Oo, hzi.O00000Oo);
    }

    public final int hashCode() {
        return (this.f1011O000000o.hashCode() * 31) + this.O00000Oo.hashCode();
    }

    public final String toString() {
        return "SpeakPlatformConfig(android=" + this.f1011O000000o + ", linux=" + this.O00000Oo + ')';
    }

    public hzi(List<String> list, List<String> list2) {
        ixe.O00000o(list, "android");
        ixe.O00000o(list2, "linux");
        this.f1011O000000o = list;
        this.O00000Oo = list2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ hzi() {
        this(r0, r2);
        List emptyList = Collections.emptyList();
        ixe.O00000Oo(emptyList, "emptyList()");
        List emptyList2 = Collections.emptyList();
        ixe.O00000Oo(emptyList2, "emptyList()");
    }
}
