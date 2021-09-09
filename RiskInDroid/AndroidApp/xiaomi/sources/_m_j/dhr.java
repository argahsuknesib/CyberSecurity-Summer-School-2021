package _m_j;

import android.support.v4.app.NotificationCompat;
import com.tencent.bugly.proguard.b;
import com.tencent.bugly.proguard.k;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class dhr {

    /* renamed from: O000000o  reason: collision with root package name */
    ByteBuffer f14645O000000o;
    String O00000Oo;

    public dhr(int i) {
        this.O00000Oo = "GBK";
        this.f14645O000000o = ByteBuffer.allocate(i);
    }

    public dhr() {
        this(NotificationCompat.FLAG_HIGH_PRIORITY);
    }

    private void O000000o(int i) {
        if (this.f14645O000000o.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f14645O000000o.capacity() + i) << 1);
            allocate.put(this.f14645O000000o.array(), 0, this.f14645O000000o.position());
            this.f14645O000000o = allocate;
        }
    }

    private void O00000Oo(byte b, int i) {
        if (i < 15) {
            this.f14645O000000o.put((byte) (b | (i << 4)));
        } else if (i < 256) {
            this.f14645O000000o.put((byte) (b | 240));
            this.f14645O000000o.put((byte) i);
        } else {
            throw new b("tag is too large: ".concat(String.valueOf(i)));
        }
    }

    public final void O000000o(boolean z, int i) {
        O000000o(z ? (byte) 1 : 0, i);
    }

    public final void O000000o(byte b, int i) {
        O000000o(3);
        if (b == 0) {
            O00000Oo((byte) 12, i);
            return;
        }
        O00000Oo((byte) 0, i);
        this.f14645O000000o.put(b);
    }

    public final void O000000o(short s, int i) {
        O000000o(4);
        if (s < -128 || s > 127) {
            O00000Oo((byte) 1, i);
            this.f14645O000000o.putShort(s);
            return;
        }
        O000000o((byte) s, i);
    }

    public final void O000000o(int i, int i2) {
        O000000o(6);
        if (i < -32768 || i > 32767) {
            O00000Oo((byte) 2, i2);
            this.f14645O000000o.putInt(i);
            return;
        }
        O000000o((short) i, i2);
    }

    public final void O000000o(long j, int i) {
        O000000o(10);
        if (j < -2147483648L || j > 2147483647L) {
            O00000Oo((byte) 3, i);
            this.f14645O000000o.putLong(j);
            return;
        }
        O000000o((int) j, i);
    }

    public final void O000000o(String str, int i) {
        byte[] bArr;
        try {
            bArr = str.getBytes(this.O00000Oo);
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        O000000o(bArr.length + 10);
        if (bArr.length > 255) {
            O00000Oo((byte) 7, i);
            this.f14645O000000o.putInt(bArr.length);
            this.f14645O000000o.put(bArr);
            return;
        }
        O00000Oo((byte) 6, i);
        this.f14645O000000o.put((byte) bArr.length);
        this.f14645O000000o.put(bArr);
    }

    public final <K, V> void O000000o(Map map, int i) {
        int i2;
        O000000o(8);
        O00000Oo((byte) 8, i);
        if (map == null) {
            i2 = 0;
        } else {
            i2 = map.size();
        }
        O000000o(i2, 0);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                O000000o(entry.getKey(), 0);
                O000000o(entry.getValue(), 1);
            }
        }
    }

    public final void O000000o(byte[] bArr, int i) {
        O000000o(bArr.length + 8);
        O00000Oo((byte) 13, i);
        O00000Oo((byte) 0, 0);
        O000000o(bArr.length, 0);
        this.f14645O000000o.put(bArr);
    }

    public final <T> void O000000o(Collection collection, int i) {
        int i2;
        O000000o(8);
        O00000Oo((byte) 9, i);
        if (collection == null) {
            i2 = 0;
        } else {
            i2 = collection.size();
        }
        O000000o(i2, 0);
        if (collection != null) {
            for (Object O000000o2 : collection) {
                O000000o(O000000o2, 0);
            }
        }
    }

    public final void O000000o(k kVar, int i) {
        O000000o(2);
        O00000Oo((byte) 10, i);
        kVar.O000000o(this);
        O000000o(2);
        O00000Oo((byte) 11, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhr.O000000o(java.util.Collection, int):void
     arg types: [java.util.List, int]
     candidates:
      _m_j.dhr.O000000o(byte, int):void
      _m_j.dhr.O000000o(int, int):void
      _m_j.dhr.O000000o(long, int):void
      _m_j.dhr.O000000o(com.tencent.bugly.proguard.k, int):void
      _m_j.dhr.O000000o(java.lang.Object, int):void
      _m_j.dhr.O000000o(java.lang.String, int):void
      _m_j.dhr.O000000o(java.util.Map, int):void
      _m_j.dhr.O000000o(short, int):void
      _m_j.dhr.O000000o(boolean, int):void
      _m_j.dhr.O000000o(byte[], int):void
      _m_j.dhr.O000000o(java.util.Collection, int):void */
    public final void O000000o(Object obj, int i) {
        if (obj instanceof Byte) {
            O000000o(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            O000000o(((Boolean) obj).booleanValue() ? (byte) 1 : 0, i);
        } else if (obj instanceof Short) {
            O000000o(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            O000000o(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            O000000o(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            O000000o(6);
            O00000Oo((byte) 4, i);
            this.f14645O000000o.putFloat(floatValue);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            O000000o(10);
            O00000Oo((byte) 5, i);
            this.f14645O000000o.putDouble(doubleValue);
        } else if (obj instanceof String) {
            O000000o((String) obj, i);
        } else if (obj instanceof Map) {
            O000000o((Map) obj, i);
        } else if (obj instanceof List) {
            O000000o((Collection) ((List) obj), i);
        } else if (obj instanceof k) {
            O000000o(2);
            O00000Oo((byte) 10, i);
            ((k) obj).O000000o(this);
            O000000o(2);
            O00000Oo((byte) 11, 0);
        } else if (obj instanceof byte[]) {
            O000000o((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            O000000o(8);
            O00000Oo((byte) 9, i);
            O000000o(zArr.length, 0);
            for (boolean z : zArr) {
                O000000o(z ? (byte) 1 : 0, 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            O000000o(8);
            O00000Oo((byte) 9, i);
            O000000o(sArr.length, 0);
            for (short O000000o2 : sArr) {
                O000000o(O000000o2, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            O000000o(8);
            O00000Oo((byte) 9, i);
            O000000o(iArr.length, 0);
            for (int O000000o3 : iArr) {
                O000000o(O000000o3, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            O000000o(8);
            O00000Oo((byte) 9, i);
            O000000o(jArr.length, 0);
            for (long O000000o4 : jArr) {
                O000000o(O000000o4, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            O000000o(8);
            O00000Oo((byte) 9, i);
            O000000o(fArr.length, 0);
            for (float putFloat : fArr) {
                O000000o(6);
                O00000Oo((byte) 4, 0);
                this.f14645O000000o.putFloat(putFloat);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            O000000o(8);
            O00000Oo((byte) 9, i);
            O000000o(dArr.length, 0);
            for (double putDouble : dArr) {
                O000000o(10);
                O00000Oo((byte) 5, 0);
                this.f14645O000000o.putDouble(putDouble);
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            O000000o(8);
            O00000Oo((byte) 9, i);
            O000000o(objArr.length, 0);
            for (Object O000000o5 : objArr) {
                O000000o(O000000o5, 0);
            }
        } else if (obj instanceof Collection) {
            O000000o((Collection) obj, i);
        } else {
            throw new b("write object error: unsupport type. " + obj.getClass());
        }
    }
}
