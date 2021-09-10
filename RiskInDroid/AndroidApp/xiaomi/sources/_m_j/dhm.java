package _m_j;

import com.tencent.bugly.proguard.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class dhm extends dhg {
    protected HashMap<String, byte[]> O00000o = null;
    private HashMap<String, Object> O00000oO = new HashMap<>();
    private dhq O00000oo = new dhq();

    public final /* bridge */ /* synthetic */ void O000000o(String str) {
        super.O000000o(str);
    }

    public void O00000Oo() {
        this.O00000o = new HashMap<>();
    }

    public <T> void O000000o(String str, Object obj) {
        if (this.O00000o == null) {
            super.O000000o(str, obj);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (obj == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(obj instanceof Set)) {
            dhr dhr = new dhr();
            dhr.O00000Oo = this.O00000Oo;
            dhr.O000000o(obj, 0);
            this.O00000o.put(str, dhs.O000000o(dhr.f14645O000000o));
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: byte[]} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
     arg types: [T, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object */
    /* JADX WARNING: Multi-variable type inference failed */
    public final <T> T O00000Oo(String str, T t) throws b {
        HashMap<String, byte[]> hashMap = this.O00000o;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.O00000oO.containsKey(str)) {
                return this.O00000oO.get(str);
            }
            try {
                this.O00000oo.O000000o(this.O00000o.get(str));
                this.O00000oo.f14643O000000o = this.O00000Oo;
                T O000000o2 = this.O00000oo.O000000o((Object) t, 0, true);
                if (O000000o2 != null) {
                    this.O00000oO.put(str, O000000o2);
                }
                return O000000o2;
            } catch (Exception e) {
                throw new b(e);
            }
        } else if (!this.f14639O000000o.containsKey(str)) {
            return null;
        } else {
            if (this.O00000oO.containsKey(str)) {
                return this.O00000oO.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator it = ((HashMap) this.f14639O000000o.get(str)).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                entry.getKey();
                bArr = entry.getValue();
            }
            try {
                this.O00000oo.O000000o(bArr);
                this.O00000oo.f14643O000000o = this.O00000Oo;
                T O000000o3 = this.O00000oo.O000000o((Object) t, 0, true);
                this.O00000oO.put(str, O000000o3);
                return O000000o3;
            } catch (Exception e2) {
                throw new b(e2);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhr.O000000o(java.util.Map, int):void
     arg types: [java.util.HashMap<java.lang.String, byte[]>, int]
     candidates:
      _m_j.dhr.O000000o(byte, int):void
      _m_j.dhr.O000000o(int, int):void
      _m_j.dhr.O000000o(long, int):void
      _m_j.dhr.O000000o(com.tencent.bugly.proguard.k, int):void
      _m_j.dhr.O000000o(java.lang.Object, int):void
      _m_j.dhr.O000000o(java.lang.String, int):void
      _m_j.dhr.O000000o(java.util.Collection, int):void
      _m_j.dhr.O000000o(short, int):void
      _m_j.dhr.O000000o(boolean, int):void
      _m_j.dhr.O000000o(byte[], int):void
      _m_j.dhr.O000000o(java.util.Map, int):void */
    public byte[] O000000o() {
        if (this.O00000o == null) {
            return super.O000000o();
        }
        dhr dhr = new dhr(0);
        dhr.O00000Oo = this.O00000Oo;
        dhr.O000000o((Map) this.O00000o, 0);
        return dhs.O000000o(dhr.f14645O000000o);
    }

    public void O000000o(byte[] bArr) {
        try {
            super.O000000o(bArr);
        } catch (Exception unused) {
            this.O00000oo.O000000o(bArr);
            this.O00000oo.f14643O000000o = this.O00000Oo;
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.O00000o = this.O00000oo.O000000o(hashMap);
        }
    }
}
