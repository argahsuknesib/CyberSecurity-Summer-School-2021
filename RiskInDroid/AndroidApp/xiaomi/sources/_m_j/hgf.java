package _m_j;

import com.xiaomi.smarthome.newui.card.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001R%\u0010\u0004\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/SwitcherStatus;", "", "current", "Lcom/xiaomi/smarthome/newui/card/State;", "allStatus", "", "Lkotlin/Pair;", "", "(Lcom/xiaomi/smarthome/newui/card/State;Ljava/util/List;)V", "getAllStatus", "()Ljava/util/List;", "getCurrent", "()Lcom/xiaomi/smarthome/newui/card/State;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hgf {

    /* renamed from: O000000o  reason: collision with root package name */
    public final State f18897O000000o;
    public final List<Pair<State, String>> O00000Oo;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hgf)) {
            return false;
        }
        hgf hgf = (hgf) obj;
        return this.f18897O000000o == hgf.f18897O000000o && ixe.O000000o(this.O00000Oo, hgf.O00000Oo);
    }

    public final int hashCode() {
        State state = this.f18897O000000o;
        int i = 0;
        int hashCode = (state == null ? 0 : state.hashCode()) * 31;
        List<Pair<State, String>> list = this.O00000Oo;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return "SwitcherStatus(current=" + this.f18897O000000o + ", allStatus=" + this.O00000Oo + ')';
    }

    private /* synthetic */ hgf() {
        this(null, null);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<kotlin.Pair<com.xiaomi.smarthome.newui.card.State, java.lang.String>>, java.util.List<? extends kotlin.Pair<? extends com.xiaomi.smarthome.newui.card.State, java.lang.String>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public hgf(State state, List<? extends Pair<? extends State, String>> r2) {
        this.f18897O000000o = state;
        this.O00000Oo = r2;
    }
}
