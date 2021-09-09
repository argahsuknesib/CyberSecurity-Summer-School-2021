package _m_j;

import io.realm.internal.OsSchemaInfo;
import java.util.HashMap;
import java.util.Map;

public final class irx {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Map<Class<? extends irr>, iry> f1593O000000o = new HashMap();
    public final ish O00000Oo;
    private final OsSchemaInfo O00000o;
    private final Map<String, iry> O00000o0 = new HashMap();

    public irx(ish ish, OsSchemaInfo osSchemaInfo) {
        this.O00000Oo = ish;
        this.O00000o = osSchemaInfo;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ColumnIndices[");
        boolean z = false;
        for (Map.Entry next : this.f1593O000000o.entrySet()) {
            if (z) {
                sb.append(",");
            }
            sb.append(((Class) next.getKey()).getSimpleName());
            sb.append("->");
            sb.append(next.getValue());
            z = true;
        }
        sb.append("]");
        return sb.toString();
    }
}
