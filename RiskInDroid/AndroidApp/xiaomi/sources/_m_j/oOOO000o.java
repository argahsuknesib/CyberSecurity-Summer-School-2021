package _m_j;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class oOOO000o<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Pools.O000000o<ArrayList<T>> f2309O000000o = new Pools.SimplePool(10);
    public final o0OO00OO<T, ArrayList<T>> O00000Oo = new o0OO00OO<>();
    private final HashSet<T> O00000o = new HashSet<>();
    private final ArrayList<T> O00000o0 = new ArrayList<>();

    public final void O000000o(T t) {
        if (!this.O00000Oo.containsKey(t)) {
            this.O00000Oo.put(t, null);
        }
    }

    public final List O00000Oo(T t) {
        return this.O00000Oo.get(t);
    }

    public final ArrayList<T> O000000o() {
        this.O00000o0.clear();
        this.O00000o.clear();
        int size = this.O00000Oo.size();
        for (int i = 0; i < size; i++) {
            O000000o(this.O00000Oo.O00000Oo(i), this.O00000o0, this.O00000o);
        }
        return this.O00000o0;
    }

    private void O000000o(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.O00000Oo.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        O000000o(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }
}
