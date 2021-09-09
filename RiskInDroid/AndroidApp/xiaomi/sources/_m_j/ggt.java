package _m_j;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/device_order/UnionOrderSyncFlag;", "", "homeId", "", "choosed", "", "source", "other", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getChoosed", "()Z", "setChoosed", "(Z)V", "getHomeId", "()Ljava/lang/String;", "getOther", "setOther", "(Ljava/lang/String;)V", "getSource", "setSource", "component1", "component2", "component3", "component4", "copy", "equals", "hashCode", "", "toString", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ggt {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f17751O000000o;
    private boolean O00000Oo;
    private String O00000o;
    private String O00000o0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ggt)) {
            return false;
        }
        ggt ggt = (ggt) obj;
        return ixe.O000000o(this.f17751O000000o, ggt.f17751O000000o) && this.O00000Oo == ggt.O00000Oo && ixe.O000000o(this.O00000o0, ggt.O00000o0) && ixe.O000000o(this.O00000o, ggt.O00000o);
    }

    public final int hashCode() {
        int hashCode = this.f17751O000000o.hashCode() * 31;
        boolean z = this.O00000Oo;
        if (z) {
            z = true;
        }
        return ((((hashCode + (z ? 1 : 0)) * 31) + this.O00000o0.hashCode()) * 31) + this.O00000o.hashCode();
    }

    public final String toString() {
        return "UnionOrderSyncFlag(homeId=" + this.f17751O000000o + ", choosed=" + this.O00000Oo + ", source=" + this.O00000o0 + ", other=" + this.O00000o + ')';
    }

    private /* synthetic */ ggt() {
        this("", false, "", "");
    }

    public ggt(String str, boolean z, String str2, String str3) {
        ixe.O00000o(str, "homeId");
        ixe.O00000o(str2, "source");
        ixe.O00000o(str3, "other");
        this.f17751O000000o = str;
        this.O00000Oo = z;
        this.O00000o0 = str2;
        this.O00000o = str3;
    }
}
