package _m_j;

import io.realm.RealmFieldType;
import java.util.Map;

public abstract class iry {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Map<String, O000000o> f1594O000000o;
    public final Map<String, O000000o> O00000Oo;
    public final boolean O00000o0;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final long f1595O000000o;
        public final RealmFieldType O00000Oo;
        public final String O00000o0;

        public final String toString() {
            return "ColumnDetails[" + this.f1595O000000o + ", " + this.O00000Oo + ", " + this.O00000o0 + "]";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColumnInfo[");
        sb.append("mutable=" + this.O00000o0);
        sb.append(",");
        boolean z = false;
        if (this.f1594O000000o != null) {
            sb.append("JavaFieldNames=[");
            boolean z2 = false;
            for (Map.Entry next : this.f1594O000000o.entrySet()) {
                if (z2) {
                    sb.append(",");
                }
                sb.append((String) next.getKey());
                sb.append("->");
                sb.append(next.getValue());
                z2 = true;
            }
            sb.append("]");
        }
        if (this.O00000Oo != null) {
            sb.append(", InternalFieldNames=[");
            for (Map.Entry next2 : this.O00000Oo.entrySet()) {
                if (z) {
                    sb.append(",");
                }
                sb.append((String) next2.getKey());
                sb.append("->");
                sb.append(next2.getValue());
                z = true;
            }
            sb.append("]");
        }
        sb.append("]");
        return sb.toString();
    }
}
