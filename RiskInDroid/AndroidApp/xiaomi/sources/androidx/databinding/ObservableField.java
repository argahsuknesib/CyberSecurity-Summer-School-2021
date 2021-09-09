package androidx.databinding;

import _m_j.dj;
import java.io.Serializable;

public class ObservableField<T> extends dj implements Serializable {
    static final long serialVersionUID = 1;
    T mValue;

    public ObservableField(T t) {
        this.mValue = t;
    }

    public ObservableField() {
    }
}
