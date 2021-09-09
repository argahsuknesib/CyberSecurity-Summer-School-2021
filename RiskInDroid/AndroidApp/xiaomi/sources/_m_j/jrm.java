package _m_j;

import android.app.Activity;
import java.util.Iterator;
import java.util.LinkedList;

public final class jrm {
    private static final jrm O00000o0 = new jrm();

    /* renamed from: O000000o  reason: collision with root package name */
    public LinkedList<Activity> f2100O000000o = null;
    public boolean O00000Oo = false;

    private jrm() {
    }

    public static jrm O000000o() {
        return O00000o0;
    }

    public final void O00000Oo() {
        LinkedList<Activity> linkedList = this.f2100O000000o;
        if (linkedList != null) {
            Iterator<Activity> it = linkedList.iterator();
            while (it.hasNext()) {
                it.next().finish();
            }
            this.f2100O000000o.clear();
        }
    }
}
