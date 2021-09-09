package _m_j;

import android.text.Editable;
import android.widget.TextView;

public final class bnn extends bnl<TextView> {
    private final Editable O00000Oo;

    public static bnn O000000o(TextView textView, Editable editable) {
        return new bnn(textView, editable);
    }

    private bnn(TextView textView, Editable editable) {
        super(textView);
        this.O00000Oo = editable;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bnn)) {
            return false;
        }
        bnn bnn = (bnn) obj;
        return bnn.f13138O000000o == this.f13138O000000o && this.O00000Oo.equals(bnn.O00000Oo);
    }

    public final String toString() {
        return "TextViewAfterTextChangeEvent{editable=" + ((Object) this.O00000Oo) + ", view=" + ((Object) this.f13138O000000o) + '}';
    }

    public final int hashCode() {
        return ((((TextView) this.f13138O000000o).hashCode() + 629) * 37) + this.O00000Oo.hashCode();
    }
}
