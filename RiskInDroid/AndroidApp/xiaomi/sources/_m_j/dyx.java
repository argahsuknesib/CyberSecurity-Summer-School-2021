package _m_j;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class dyx extends WeakReference<Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f15088O000000o;
    public final String O00000Oo;

    dyx(Object obj, String str, String str2, ReferenceQueue<Object> referenceQueue) {
        super(dyz.O000000o(obj, "referent"), (ReferenceQueue) dyz.O000000o(referenceQueue, "referenceQueue"));
        this.f15088O000000o = (String) dyz.O000000o(str, "key");
        this.O00000Oo = (String) dyz.O000000o(str2, "name");
    }
}
