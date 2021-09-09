package _m_j;

import com.tencent.bugly.proguard.b;
import com.tencent.bugly.proguard.k;
import java.util.List;
import java.util.Map;

public final class dhp {

    /* renamed from: O000000o  reason: collision with root package name */
    public StringBuilder f14642O000000o;
    private int O00000Oo = 0;

    public final void O000000o(String str) {
        for (int i = 0; i < this.O00000Oo; i++) {
            this.f14642O000000o.append(9);
        }
        if (str != null) {
            StringBuilder sb = this.f14642O000000o;
            sb.append(str);
            sb.append(": ");
        }
    }

    public dhp(StringBuilder sb, int i) {
        this.f14642O000000o = sb;
        this.O00000Oo = i;
    }

    public final dhp O000000o(boolean z, String str) {
        O000000o(str);
        StringBuilder sb = this.f14642O000000o;
        sb.append(z ? 'T' : 'F');
        sb.append(10);
        return this;
    }

    public final dhp O000000o(int i, String str) {
        O000000o(str);
        StringBuilder sb = this.f14642O000000o;
        sb.append(i);
        sb.append(10);
        return this;
    }

    public final dhp O000000o(String str, String str2) {
        O000000o(str2);
        if (str == null) {
            this.f14642O000000o.append("null\n");
        } else {
            StringBuilder sb = this.f14642O000000o;
            sb.append(str);
            sb.append(10);
        }
        return this;
    }

    public final dhp O000000o(byte[] bArr, String str) {
        O000000o(str);
        if (bArr == null) {
            this.f14642O000000o.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f14642O000000o;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f14642O000000o;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            dhp dhp = new dhp(this.f14642O000000o, this.O00000Oo + 1);
            for (byte b : bArr) {
                dhp.O000000o(null);
                StringBuilder sb3 = dhp.f14642O000000o;
                sb3.append((int) b);
                sb3.append(10);
            }
            O000000o(null);
            StringBuilder sb4 = this.f14642O000000o;
            sb4.append(']');
            sb4.append(10);
            return this;
        }
    }

    public final <K, V> dhp O000000o(Map map, String str) {
        O000000o(str);
        if (map == null) {
            this.f14642O000000o.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f14642O000000o;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f14642O000000o;
            sb2.append(map.size());
            sb2.append(", {\n");
            dhp dhp = new dhp(this.f14642O000000o, this.O00000Oo + 1);
            dhp dhp2 = new dhp(this.f14642O000000o, this.O00000Oo + 2);
            for (Map.Entry entry : map.entrySet()) {
                dhp.O000000o(null);
                StringBuilder sb3 = dhp.f14642O000000o;
                sb3.append('(');
                sb3.append(10);
                dhp2.O000000o(entry.getKey(), (String) null);
                dhp2.O000000o(entry.getValue(), (String) null);
                dhp.O000000o(null);
                StringBuilder sb4 = dhp.f14642O000000o;
                sb4.append(')');
                sb4.append(10);
            }
            O000000o(null);
            StringBuilder sb5 = this.f14642O000000o;
            sb5.append('}');
            sb5.append(10);
            return this;
        }
    }

    private <T> dhp O000000o(Object[] objArr, String str) {
        O000000o(str);
        if (objArr == null) {
            this.f14642O000000o.append("null\n");
            return this;
        } else if (objArr.length == 0) {
            StringBuilder sb = this.f14642O000000o;
            sb.append(objArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f14642O000000o;
            sb2.append(objArr.length);
            sb2.append(", [\n");
            dhp dhp = new dhp(this.f14642O000000o, this.O00000Oo + 1);
            for (Object O000000o2 : objArr) {
                dhp.O000000o(O000000o2, (String) null);
            }
            O000000o(null);
            StringBuilder sb3 = this.f14642O000000o;
            sb3.append(']');
            sb3.append(10);
            return this;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhp.O000000o(java.lang.Object, java.lang.String):_m_j.dhp
     arg types: [boolean[], java.lang.String]
     candidates:
      _m_j.dhp.O000000o(java.lang.Object[], java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(int, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(com.tencent.bugly.proguard.k, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.lang.String, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.util.Map, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(boolean, java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(byte[], java.lang.String):_m_j.dhp
      _m_j.dhp.O000000o(java.lang.Object, java.lang.String):_m_j.dhp */
    private <T> dhp O000000o(Object obj, String str) {
        if (obj == null) {
            this.f14642O000000o.append("null\n");
        } else if (obj instanceof Byte) {
            byte byteValue = ((Byte) obj).byteValue();
            O000000o(str);
            StringBuilder sb = this.f14642O000000o;
            sb.append((int) byteValue);
            sb.append(10);
        } else if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            O000000o(str);
            StringBuilder sb2 = this.f14642O000000o;
            sb2.append(booleanValue ? 'T' : 'F');
            sb2.append(10);
        } else if (obj instanceof Short) {
            short shortValue = ((Short) obj).shortValue();
            O000000o(str);
            StringBuilder sb3 = this.f14642O000000o;
            sb3.append((int) shortValue);
            sb3.append(10);
        } else if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            O000000o(str);
            StringBuilder sb4 = this.f14642O000000o;
            sb4.append(intValue);
            sb4.append(10);
        } else if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            O000000o(str);
            StringBuilder sb5 = this.f14642O000000o;
            sb5.append(longValue);
            sb5.append(10);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            O000000o(str);
            StringBuilder sb6 = this.f14642O000000o;
            sb6.append(floatValue);
            sb6.append(10);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            O000000o(str);
            StringBuilder sb7 = this.f14642O000000o;
            sb7.append(doubleValue);
            sb7.append(10);
        } else if (obj instanceof String) {
            O000000o((String) obj, str);
        } else if (obj instanceof Map) {
            O000000o((Map) obj, str);
        } else if (obj instanceof List) {
            List list = (List) obj;
            if (list == null) {
                O000000o(str);
                this.f14642O000000o.append("null\t");
            } else {
                O000000o(list.toArray(), str);
            }
        } else if (obj instanceof k) {
            O000000o((k) obj, str);
        } else if (obj instanceof byte[]) {
            O000000o((byte[]) obj, str);
        } else if (obj instanceof boolean[]) {
            O000000o((Object) ((boolean[]) obj), str);
        } else {
            int i = 0;
            if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                O000000o(str);
                if (sArr == null) {
                    this.f14642O000000o.append("null\n");
                } else if (sArr.length == 0) {
                    StringBuilder sb8 = this.f14642O000000o;
                    sb8.append(sArr.length);
                    sb8.append(", []\n");
                } else {
                    StringBuilder sb9 = this.f14642O000000o;
                    sb9.append(sArr.length);
                    sb9.append(", [\n");
                    dhp dhp = new dhp(this.f14642O000000o, this.O00000Oo + 1);
                    int length = sArr.length;
                    while (i < length) {
                        short s = sArr[i];
                        dhp.O000000o(null);
                        StringBuilder sb10 = dhp.f14642O000000o;
                        sb10.append((int) s);
                        sb10.append(10);
                        i++;
                    }
                    O000000o(null);
                    StringBuilder sb11 = this.f14642O000000o;
                    sb11.append(']');
                    sb11.append(10);
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                O000000o(str);
                if (iArr == null) {
                    this.f14642O000000o.append("null\n");
                } else if (iArr.length == 0) {
                    StringBuilder sb12 = this.f14642O000000o;
                    sb12.append(iArr.length);
                    sb12.append(", []\n");
                } else {
                    StringBuilder sb13 = this.f14642O000000o;
                    sb13.append(iArr.length);
                    sb13.append(", [\n");
                    dhp dhp2 = new dhp(this.f14642O000000o, this.O00000Oo + 1);
                    int length2 = iArr.length;
                    while (i < length2) {
                        int i2 = iArr[i];
                        dhp2.O000000o(null);
                        StringBuilder sb14 = dhp2.f14642O000000o;
                        sb14.append(i2);
                        sb14.append(10);
                        i++;
                    }
                    O000000o(null);
                    StringBuilder sb15 = this.f14642O000000o;
                    sb15.append(']');
                    sb15.append(10);
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                O000000o(str);
                if (jArr == null) {
                    this.f14642O000000o.append("null\n");
                } else if (jArr.length == 0) {
                    StringBuilder sb16 = this.f14642O000000o;
                    sb16.append(jArr.length);
                    sb16.append(", []\n");
                } else {
                    StringBuilder sb17 = this.f14642O000000o;
                    sb17.append(jArr.length);
                    sb17.append(", [\n");
                    dhp dhp3 = new dhp(this.f14642O000000o, this.O00000Oo + 1);
                    int length3 = jArr.length;
                    while (i < length3) {
                        long j = jArr[i];
                        dhp3.O000000o(null);
                        StringBuilder sb18 = dhp3.f14642O000000o;
                        sb18.append(j);
                        sb18.append(10);
                        i++;
                    }
                    O000000o(null);
                    StringBuilder sb19 = this.f14642O000000o;
                    sb19.append(']');
                    sb19.append(10);
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                O000000o(str);
                if (fArr == null) {
                    this.f14642O000000o.append("null\n");
                } else if (fArr.length == 0) {
                    StringBuilder sb20 = this.f14642O000000o;
                    sb20.append(fArr.length);
                    sb20.append(", []\n");
                } else {
                    StringBuilder sb21 = this.f14642O000000o;
                    sb21.append(fArr.length);
                    sb21.append(", [\n");
                    dhp dhp4 = new dhp(this.f14642O000000o, this.O00000Oo + 1);
                    int length4 = fArr.length;
                    while (i < length4) {
                        float f = fArr[i];
                        dhp4.O000000o(null);
                        StringBuilder sb22 = dhp4.f14642O000000o;
                        sb22.append(f);
                        sb22.append(10);
                        i++;
                    }
                    O000000o(null);
                    StringBuilder sb23 = this.f14642O000000o;
                    sb23.append(']');
                    sb23.append(10);
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                O000000o(str);
                if (dArr == null) {
                    this.f14642O000000o.append("null\n");
                } else if (dArr.length == 0) {
                    StringBuilder sb24 = this.f14642O000000o;
                    sb24.append(dArr.length);
                    sb24.append(", []\n");
                } else {
                    StringBuilder sb25 = this.f14642O000000o;
                    sb25.append(dArr.length);
                    sb25.append(", [\n");
                    dhp dhp5 = new dhp(this.f14642O000000o, this.O00000Oo + 1);
                    int length5 = dArr.length;
                    while (i < length5) {
                        double d = dArr[i];
                        dhp5.O000000o(null);
                        StringBuilder sb26 = dhp5.f14642O000000o;
                        sb26.append(d);
                        sb26.append(10);
                        i++;
                    }
                    O000000o(null);
                    StringBuilder sb27 = this.f14642O000000o;
                    sb27.append(']');
                    sb27.append(10);
                }
            } else if (obj.getClass().isArray()) {
                O000000o((Object[]) obj, str);
            } else {
                throw new b("write object error: unsupport type.");
            }
        }
        return this;
    }

    public final dhp O000000o(k kVar, String str) {
        O000000o(str);
        StringBuilder sb = this.f14642O000000o;
        sb.append('{');
        sb.append(10);
        if (kVar == null) {
            StringBuilder sb2 = this.f14642O000000o;
            sb2.append(9);
            sb2.append("null");
        } else {
            kVar.O000000o(this.f14642O000000o, this.O00000Oo + 1);
        }
        O000000o(null);
        StringBuilder sb3 = this.f14642O000000o;
        sb3.append('}');
        sb3.append(10);
        return this;
    }
}
