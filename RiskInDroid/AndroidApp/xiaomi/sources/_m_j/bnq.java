package _m_j;

import java.util.LinkedHashMap;
import java.util.Map;

public final class bnq<K, V> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final LinkedHashMap<K, V> f13146O000000o = new LinkedHashMap<>(0, 0.75f, true);
    private int O00000Oo;
    private int O00000o;
    private int O00000o0 = 100;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;

    public final V O000000o(K k) {
        if (k != null) {
            synchronized (this) {
                V v = this.f13146O000000o.get(k);
                if (v != null) {
                    this.O00000oo++;
                    return v;
                }
                this.O0000O0o++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    public final V O000000o(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.O00000o++;
            this.O00000Oo++;
            put = this.f13146O000000o.put(k, v);
            if (put != null) {
                this.O00000Oo--;
            }
        }
        int i = this.O00000o0;
        while (true) {
            synchronized (this) {
                if (this.O00000Oo < 0 || (this.f13146O000000o.isEmpty() && this.O00000Oo != 0)) {
                } else if (this.O00000Oo <= i) {
                    break;
                } else if (this.f13146O000000o.isEmpty()) {
                    break;
                } else {
                    Map.Entry next = this.f13146O000000o.entrySet().iterator().next();
                    Object key = next.getKey();
                    next.getValue();
                    this.f13146O000000o.remove(key);
                    this.O00000Oo--;
                    this.O00000oO++;
                }
            }
        }
        return put;
    }

    public final synchronized String toString() {
        int i;
        i = this.O00000oo + this.O0000O0o;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000oo), Integer.valueOf(this.O0000O0o), Integer.valueOf(i != 0 ? (this.O00000oo * 100) / i : 0));
    }
}
