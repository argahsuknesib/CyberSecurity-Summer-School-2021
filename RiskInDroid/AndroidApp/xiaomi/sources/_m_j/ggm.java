package _m_j;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0007HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/device_order/FreqCameraOrder;", "Lcom/xiaomi/smarthome/homeroom/device_order/Order;", "orders", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isFirst", "", "(Ljava/util/ArrayList;Z)V", "()Z", "getOrders", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ggm implements ggq {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ArrayList<String> f17744O000000o;
    public final boolean O00000Oo;

    public ggm() {
        this(null, false, 3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ggm)) {
            return false;
        }
        ggm ggm = (ggm) obj;
        return ixe.O000000o(this.f17744O000000o, ggm.f17744O000000o) && this.O00000Oo == ggm.O00000Oo;
    }

    public final int hashCode() {
        int hashCode = this.f17744O000000o.hashCode() * 31;
        boolean z = this.O00000Oo;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "FreqCameraOrder(orders=" + this.f17744O000000o + ", isFirst=" + this.O00000Oo + ')';
    }

    private ggm(ArrayList<String> arrayList, boolean z) {
        ixe.O00000o(arrayList, "orders");
        this.f17744O000000o = arrayList;
        this.O00000Oo = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ggm(ArrayList arrayList, boolean z, int i) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? false : z);
    }
}
