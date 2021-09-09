package _m_j;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/device_order/CateOrder;", "Lcom/xiaomi/smarthome/homeroom/device_order/Order;", "cateId", "", "orders", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parentId", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getCateId", "()Ljava/lang/String;", "getOrders", "()Ljava/util/ArrayList;", "getParentId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ggj implements ggq {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f17741O000000o;
    public final ArrayList<String> O00000Oo;
    public final String O00000o0;

    public final String toString() {
        return "CateOrder(cateId=" + this.f17741O000000o + ", orders=" + this.O00000Oo + ", parentId=" + this.O00000o0 + ')';
    }

    public ggj(String str, ArrayList<String> arrayList, String str2) {
        ixe.O00000o(str, "cateId");
        ixe.O00000o(arrayList, "orders");
        ixe.O00000o(str2, "parentId");
        this.f17741O000000o = str;
        this.O00000Oo = arrayList;
        this.O00000o0 = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!ixe.O000000o(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            ggj ggj = (ggj) obj;
            return ixe.O000000o(this.f17741O000000o, ggj.f17741O000000o) && ixe.O000000o(this.O00000o0, ggj.O00000o0);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.homeroom.device_order.CateOrder");
    }

    public final int hashCode() {
        return (this.f17741O000000o.hashCode() * 31) + this.O00000o0.hashCode();
    }
}
