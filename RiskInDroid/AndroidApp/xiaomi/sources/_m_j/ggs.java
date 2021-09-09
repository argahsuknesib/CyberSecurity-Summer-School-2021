package _m_j;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/device_order/RoomOrder;", "Lcom/xiaomi/smarthome/homeroom/device_order/Order;", "roomId", "", "orders", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getOrders", "()Ljava/util/ArrayList;", "getRoomId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ggs implements ggq {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ArrayList<String> f17750O000000o;
    private final String O00000Oo;

    public final String toString() {
        return "RoomOrder(roomId=" + this.O00000Oo + ", orders=" + this.f17750O000000o + ')';
    }

    public ggs(String str, ArrayList<String> arrayList) {
        ixe.O00000o(str, "roomId");
        ixe.O00000o(arrayList, "orders");
        this.O00000Oo = str;
        this.f17750O000000o = arrayList;
    }

    public final String O000000o() {
        return this.O00000Oo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!ixe.O000000o(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            return ixe.O000000o(this.O00000Oo, ((ggs) obj).O00000Oo);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.homeroom.device_order.RoomOrder");
    }

    public final int hashCode() {
        return this.O00000Oo.hashCode();
    }
}
