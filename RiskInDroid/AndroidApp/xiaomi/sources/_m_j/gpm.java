package _m_j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class gpm<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f18126O000000o = 16;
    private ReentrantReadWriteLock O00000Oo = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock O00000o = this.O00000Oo.readLock();
    private ReentrantReadWriteLock.WriteLock O00000o0 = this.O00000Oo.writeLock();
    private final ArrayList<T> O00000oO;
    private int O00000oo = 0;

    public gpm(int i) {
        i = i <= 4 ? 4 : i;
        this.f18126O000000o = i;
        this.O00000oO = new ArrayList<>(Collections.nCopies(i, null));
    }

    public final boolean O000000o(T t) {
        this.O00000o0.lock();
        try {
            int i = this.O00000oo % this.f18126O000000o;
            this.O00000oO.set(i, t);
            this.O00000oo = (i + 1) % this.f18126O000000o;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.O00000o0.unlock();
            throw th;
        }
        this.O00000o0.unlock();
        return false;
    }

    public final List<T> O000000o() {
        ArrayList arrayList = new ArrayList();
        this.O00000o.lock();
        int i = 0;
        while (i < this.f18126O000000o) {
            try {
                T t = this.O00000oO.get((this.O00000oo + i) % this.f18126O000000o);
                if (t != null) {
                    arrayList.add(t);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.O00000o.unlock();
                throw th;
            }
        }
        this.O00000o.unlock();
        return arrayList;
    }
}
