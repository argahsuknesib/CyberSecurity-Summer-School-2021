package _m_j;

import com.tencent.bugly.proguard.f;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class dhn extends dhm {
    private static HashMap<String, byte[]> O00000oo;
    private static HashMap<String, HashMap<String, byte[]>> O0000O0o;
    f O00000oO = new f();

    public dhn() {
        this.O00000oO.f5839a = 2;
    }

    public final <T> void O000000o(String str, Object obj) {
        if (!str.startsWith(".")) {
            super.O000000o(str, obj);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(str)));
    }

    public final void O00000Oo() {
        super.O00000Oo();
        this.O00000oO.f5839a = 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhr.O000000o(java.util.Map, int):void
     arg types: [java.util.HashMap, int]
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
    public final byte[] O000000o() {
        if (this.O00000oO.f5839a != 2) {
            if (this.O00000oO.c == null) {
                this.O00000oO.c = "";
            }
            if (this.O00000oO.d == null) {
                this.O00000oO.d = "";
            }
        } else if (this.O00000oO.c.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.O00000oO.d.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        dhr dhr = new dhr(0);
        dhr.O00000Oo = this.O00000Oo;
        if (this.O00000oO.f5839a == 2) {
            dhr.O000000o((Map) this.f14639O000000o, 0);
        } else {
            dhr.O000000o((Map) this.O00000o, 0);
        }
        this.O00000oO.e = dhs.O000000o(dhr.f14645O000000o);
        dhr dhr2 = new dhr(0);
        dhr2.O00000Oo = this.O00000Oo;
        this.O00000oO.O000000o(dhr2);
        byte[] O000000o2 = dhs.O000000o(dhr2.f14645O000000o);
        int length = O000000o2.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(O000000o2).flip();
        return allocate.array();
    }

    public final void O000000o(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                dhq dhq = new dhq(bArr, (byte) 0);
                dhq.f14643O000000o = this.O00000Oo;
                this.O00000oO.O000000o(dhq);
                if (this.O00000oO.f5839a == 3) {
                    dhq dhq2 = new dhq(this.O00000oO.e);
                    dhq2.f14643O000000o = this.O00000Oo;
                    if (O00000oo == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        O00000oo = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    this.O00000o = dhq2.O000000o(O00000oo);
                    return;
                }
                dhq dhq3 = new dhq(this.O00000oO.e);
                dhq3.f14643O000000o = this.O00000Oo;
                if (O0000O0o == null) {
                    O0000O0o = new HashMap<>();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("", new byte[0]);
                    O0000O0o.put("", hashMap2);
                }
                this.f14639O000000o = dhq3.O000000o(O0000O0o);
                new HashMap();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("decode package must include size head");
        }
    }
}
