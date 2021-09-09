package _m_j;

import java.util.Hashtable;

public final class jes extends InheritableThreadLocal {
    public final Object childValue(Object obj) {
        Hashtable hashtable = (Hashtable) obj;
        if (hashtable != null) {
            return hashtable.clone();
        }
        return null;
    }
}
