package _m_j;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.X7875_NewUnix;
import org.apache.commons.compress.archivers.zip.ZipShort;

public final class jbt {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<ZipShort, Class<?>> f1746O000000o = new ConcurrentHashMap();

    static {
        O000000o(jbs.class);
        O000000o(X5455_ExtendedTimestamp.class);
        O000000o(X7875_NewUnix.class);
        O000000o(jbv.class);
        O000000o(jca.class);
        O000000o(jbz.class);
        O000000o(jcj.class);
        O000000o(jcd.class);
        O000000o(jce.class);
        O000000o(jcf.class);
        O000000o(jcg.class);
        O000000o(jch.class);
        O000000o(jci.class);
    }

    private static void O000000o(Class<?> cls) {
        try {
            f1746O000000o.put(((jcn) cls.newInstance()).O00000oO(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (InstantiationException unused2) {
            throw new RuntimeException(cls + " is not a concrete class");
        } catch (IllegalAccessException unused3) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        }
    }

    public static jcn[] O000000o(byte[] bArr, O000000o o000000o) throws ZipException {
        jcn jcn;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i > bArr.length - 4) {
                break;
            }
            ZipShort zipShort = new ZipShort(bArr, i);
            int i2 = new ZipShort(bArr, i + 2).value;
            int i3 = i + 4;
            if (i3 + i2 > bArr.length) {
                int i4 = o000000o.O00000o;
                if (i4 == 0) {
                    StringBuilder sb = new StringBuilder("bad extra field starting at ");
                    sb.append(i);
                    sb.append(".  Block length of ");
                    sb.append(i2);
                    sb.append(" bytes exceeds remaining data of ");
                    sb.append((bArr.length - i) - 4);
                    sb.append(" bytes.");
                    throw new ZipException(sb.toString());
                } else if (i4 != 1) {
                    if (i4 == 2) {
                        jcb jcb = new jcb();
                        jcb.O000000o(bArr, i, bArr.length - i);
                        arrayList.add(jcb);
                    } else {
                        throw new ZipException("unknown UnparseableExtraField key: " + o000000o.O00000o);
                    }
                }
            } else {
                try {
                    Class cls = f1746O000000o.get(zipShort);
                    if (cls != null) {
                        jcn = (jcn) cls.newInstance();
                    } else {
                        jcc jcc = new jcc();
                        jcc.f1757O000000o = zipShort;
                        jcn = jcc;
                    }
                    jcn.O000000o(bArr, i3, i2);
                    arrayList.add(jcn);
                    i += i2 + 4;
                } catch (IllegalAccessException | InstantiationException e) {
                    throw ((ZipException) new ZipException(e.getMessage()).initCause(e));
                }
            }
        }
        return (jcn[]) arrayList.toArray(new jcn[arrayList.size()]);
    }

    public static byte[] O000000o(jcn[] jcnArr) {
        byte[] O00000o0;
        boolean z = jcnArr.length > 0 && (jcnArr[jcnArr.length - 1] instanceof jcb);
        int length = z ? jcnArr.length - 1 : jcnArr.length;
        int i = length * 4;
        for (jcn O00000o : jcnArr) {
            i += O00000o.O00000o().value;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(jcnArr[i3].O00000oO().O000000o(), 0, bArr, i2, 2);
            System.arraycopy(jcnArr[i3].O00000o().O000000o(), 0, bArr, i2 + 2, 2);
            i2 += 4;
            byte[] O00000o02 = jcnArr[i3].O00000o0();
            if (O00000o02 != null) {
                System.arraycopy(O00000o02, 0, bArr, i2, O00000o02.length);
                i2 += O00000o02.length;
            }
        }
        if (z && (O00000o0 = jcnArr[jcnArr.length - 1].O00000o0()) != null) {
            System.arraycopy(O00000o0, 0, bArr, i2, O00000o0.length);
        }
        return bArr;
    }

    public static byte[] O00000Oo(jcn[] jcnArr) {
        byte[] O000000o2;
        boolean z = jcnArr.length > 0 && (jcnArr[jcnArr.length - 1] instanceof jcb);
        int length = z ? jcnArr.length - 1 : jcnArr.length;
        int i = length * 4;
        for (jcn O00000Oo : jcnArr) {
            i += O00000Oo.O00000Oo().value;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(jcnArr[i3].O00000oO().O000000o(), 0, bArr, i2, 2);
            System.arraycopy(jcnArr[i3].O00000Oo().O000000o(), 0, bArr, i2 + 2, 2);
            i2 += 4;
            byte[] O000000o3 = jcnArr[i3].O000000o();
            if (O000000o3 != null) {
                System.arraycopy(O000000o3, 0, bArr, i2, O000000o3.length);
                i2 += O000000o3.length;
            }
        }
        if (z && (O000000o2 = jcnArr[jcnArr.length - 1].O000000o()) != null) {
            System.arraycopy(O000000o2, 0, bArr, i2, O000000o2.length);
        }
        return bArr;
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f1747O000000o = new O000000o(0);
        public static final O000000o O00000Oo = new O000000o(1);
        public static final O000000o O00000o0 = new O000000o(2);
        final int O00000o;

        private O000000o(int i) {
            this.O00000o = i;
        }
    }
}
