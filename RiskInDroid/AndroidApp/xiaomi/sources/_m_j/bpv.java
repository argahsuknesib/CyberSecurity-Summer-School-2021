package _m_j;

import java.util.LinkedList;

public final class bpv {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13189O000000o;
    public LinkedList<Object> O00000Oo;

    public bpv() {
    }

    public bpv(String str) {
        this.f13189O000000o = str;
    }

    public final Object[] O000000o() {
        LinkedList<Object> linkedList = this.O00000Oo;
        if (linkedList != null) {
            return linkedList.toArray();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Object obj) {
        if (this.O00000Oo == null) {
            this.O00000Oo = new LinkedList<>();
        }
        this.O00000Oo.add(obj);
    }
}
