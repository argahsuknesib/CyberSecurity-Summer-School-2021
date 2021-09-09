package _m_j;

import com.lidroid.xutils.cache.KeyExpiryMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class bor<K, V> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final LinkedHashMap<K, V> f13181O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private KeyExpiryMap<K, Long> O0000OOo;

    /* access modifiers changed from: protected */
    public int O000000o(V v) {
        return 1;
    }

    public bor(int i) {
        if (i > 0) {
            this.O00000o0 = i;
            this.f13181O000000o = new LinkedHashMap<>(0, 0.75f, true);
            this.O0000OOo = new KeyExpiryMap<>(0, 0.75f);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V O00000Oo(K k) {
        if (k != null) {
            synchronized (this) {
                if (!this.O0000OOo.containsKey(k)) {
                    O00000o0(k);
                    return null;
                }
                V v = this.f13181O000000o.get(k);
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.lidroid.xutils.cache.KeyExpiryMap.put(java.lang.Object, java.lang.Long):java.lang.Long
     arg types: [K, java.lang.Long]
     candidates:
      com.lidroid.xutils.cache.KeyExpiryMap.put(java.lang.Object, java.lang.Object):java.lang.Object
      ClspMth{java.util.concurrent.ConcurrentHashMap.put(java.lang.Object, java.lang.Object):V}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      com.lidroid.xutils.cache.KeyExpiryMap.put(java.lang.Object, java.lang.Long):java.lang.Long */
    public final V O000000o(K k, V v, long j) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.O00000o++;
            this.O00000Oo += O000000o(k, v);
            put = this.f13181O000000o.put(k, v);
            this.O0000OOo.put((Object) k, Long.valueOf(j));
            if (put != null) {
                this.O00000Oo -= O000000o(k, put);
            }
        }
        O000000o(this.O00000o0);
        return put;
    }

    private void O000000o(int i) {
        while (true) {
            synchronized (this) {
                if (this.O00000Oo <= i) {
                    break;
                } else if (this.f13181O000000o.isEmpty()) {
                    break;
                } else {
                    Map.Entry next = this.f13181O000000o.entrySet().iterator().next();
                    Object key = next.getKey();
                    Object value = next.getValue();
                    this.f13181O000000o.remove(key);
                    this.O0000OOo.remove(key);
                    this.O00000Oo -= O000000o(key, value);
                    this.O00000oO++;
                }
            }
        }
    }

    public final V O00000o0(K k) {
        V remove;
        if (k != null) {
            synchronized (this) {
                remove = this.f13181O000000o.remove(k);
                this.O0000OOo.remove((Object) k);
                if (remove != null) {
                    this.O00000Oo -= O000000o(k, remove);
                }
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public final boolean O00000o(K k) {
        return this.f13181O000000o.containsKey(k);
    }

    private int O000000o(K k, V v) {
        int O000000o2 = O000000o(v);
        if (O000000o2 <= 0) {
            this.O00000Oo = 0;
            for (Map.Entry next : this.f13181O000000o.entrySet()) {
                int i = this.O00000Oo;
                next.getKey();
                this.O00000Oo = i + O000000o(next.getValue());
            }
        }
        return O000000o2;
    }

    public final void O000000o() {
        O000000o(-1);
        this.O0000OOo.clear();
    }

    public final synchronized String toString() {
        int i;
        i = this.O00000oo + this.O0000O0o;
        return String.format("LruMemoryCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000oo), Integer.valueOf(this.O0000O0o), Integer.valueOf(i != 0 ? (this.O00000oo * 100) / i : 0));
    }
}
