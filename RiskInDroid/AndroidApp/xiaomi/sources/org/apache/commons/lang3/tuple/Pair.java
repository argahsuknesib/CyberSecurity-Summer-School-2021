package org.apache.commons.lang3.tuple;

import _m_j.jdg;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;

public abstract class Pair<L, R> implements Serializable, Comparable<Pair<L, R>>, Map.Entry<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;

    public abstract L O000000o();

    public abstract R O00000Oo();

    public /* synthetic */ int compareTo(Object obj) {
        Pair pair = (Pair) obj;
        return new jdg().O000000o(O000000o(), pair.O000000o(), null).O000000o(O00000Oo(), pair.O00000Oo(), null).f1775O000000o;
    }

    public final L getKey() {
        return O000000o();
    }

    public R getValue() {
        return O00000Oo();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return ObjectUtils.O000000o(getKey(), entry.getKey()) && ObjectUtils.O000000o(getValue(), entry.getValue());
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = getKey() == null ? 0 : getKey().hashCode();
        if (getValue() != null) {
            i = getValue().hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "(" + O000000o() + ',' + O00000Oo() + ')';
    }
}
