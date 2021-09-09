package _m_j;

import android.content.Context;
import java.util.Arrays;
import java.util.Collection;

public final class us<T> implements uu<T> {
    public final Collection<? extends uu> O00000Oo;

    public us(uu... uuVarArr) {
        this.O00000Oo = Arrays.asList(uuVarArr);
    }

    public final uw<T> O000000o(Context context, uw<T> uwVar, int i, int i2) {
        for (uu O000000o2 : this.O00000Oo) {
            uwVar = O000000o2.O000000o(context, uwVar, i, i2);
        }
        return uwVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof us) {
            return this.O00000Oo.equals(((us) obj).O00000Oo);
        }
        return false;
    }

    public final int hashCode() {
        return this.O00000Oo.hashCode();
    }
}
