package _m_j;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public final class cnu implements cns {

    /* renamed from: O000000o  reason: collision with root package name */
    private final LinkedHashMap<String, Bitmap> f14154O000000o;
    private final int O00000Oo;
    private int O00000o0;

    public cnu(int i) {
        if (i > 0) {
            this.O00000Oo = i;
            this.f14154O000000o = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final Bitmap O000000o(String str) {
        Bitmap bitmap;
        if (str != null) {
            synchronized (this) {
                bitmap = this.f14154O000000o.get(str);
            }
            return bitmap;
        }
        throw new NullPointerException("key == null");
    }

    public final boolean O000000o(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.O00000o0 += O000000o(bitmap);
            Bitmap put = this.f14154O000000o.put(str, bitmap);
            if (put != null) {
                this.O00000o0 -= O000000o(put);
            }
        }
        O000000o(this.O00000Oo);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    private void O000000o(int i) {
        while (true) {
            synchronized (this) {
                if (this.O00000o0 < 0 || (this.f14154O000000o.isEmpty() && this.O00000o0 != 0)) {
                } else if (this.O00000o0 <= i) {
                    break;
                } else if (this.f14154O000000o.isEmpty()) {
                    break;
                } else {
                    Map.Entry next = this.f14154O000000o.entrySet().iterator().next();
                    if (next != null) {
                        this.f14154O000000o.remove((String) next.getKey());
                        this.O00000o0 -= O000000o((Bitmap) next.getValue());
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final Bitmap O00000Oo(String str) {
        Bitmap remove;
        if (str != null) {
            synchronized (this) {
                remove = this.f14154O000000o.remove(str);
                if (remove != null) {
                    this.O00000o0 -= O000000o(remove);
                }
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public final Collection<String> O000000o() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f14154O000000o.keySet());
        }
        return hashSet;
    }

    private static int O000000o(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.O00000Oo));
    }
}
