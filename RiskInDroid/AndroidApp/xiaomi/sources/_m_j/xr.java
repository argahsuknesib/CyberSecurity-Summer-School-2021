package _m_j;

import com.drew.lang.Rational;
import com.drew.metadata.MetadataException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class xr {
    static final /* synthetic */ boolean O00000oo = (!xr.class.desiredAssertionStatus());

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Map<Integer, Object> f2597O000000o = new HashMap();
    protected final Collection<xw> O00000Oo = new ArrayList();
    protected xx O00000o;
    public final Collection<String> O00000o0 = new ArrayList(4);
    public xr O00000oO;

    public abstract String O000000o();

    /* access modifiers changed from: protected */
    public abstract HashMap<Integer, String> O00000Oo();

    protected xr() {
    }

    public final boolean O00000o0() {
        return this.O00000o0.isEmpty() && this.O00000Oo.isEmpty();
    }

    public final boolean O000000o(int i) {
        return this.f2597O000000o.containsKey(Integer.valueOf(i));
    }

    public final Collection<xw> O00000o() {
        return Collections.unmodifiableCollection(this.O00000Oo);
    }

    public final void O000000o(xx xxVar) {
        this.O00000o = xxVar;
    }

    public final void O000000o(String str) {
        this.O00000o0.add(str);
    }

    public final void O000000o(int i, int i2) {
        O000000o(i, Integer.valueOf(i2));
    }

    public final void O000000o(int i, float f) {
        O000000o(i, Float.valueOf(f));
    }

    public final void O000000o(int i, double d) {
        O000000o(i, Double.valueOf(d));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, java.lang.Object):void
     arg types: [int, _m_j.xv]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, int):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, java.lang.Object):void */
    public final void O000000o(int i, xv xvVar) {
        if (xvVar != null) {
            O000000o(i, (Object) xvVar);
            return;
        }
        throw new NullPointerException("cannot set a null StringValue");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, java.lang.Object):void
     arg types: [int, java.lang.String]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, int):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, java.lang.Object):void */
    public final void O000000o(int i, String str) {
        if (str != null) {
            O000000o(i, (Object) str);
            return;
        }
        throw new NullPointerException("cannot set a null String");
    }

    public final void O000000o(int i, boolean z) {
        O000000o(i, Boolean.valueOf(z));
    }

    public final void O000000o(int i, long j) {
        O000000o(i, Long.valueOf(j));
    }

    public void O000000o(int i, byte[] bArr) {
        O00000Oo(i, bArr);
    }

    public void O000000o(int i, Object obj) {
        if (obj != null) {
            if (!this.f2597O000000o.containsKey(Integer.valueOf(i))) {
                this.O00000Oo.add(new xw(i, this));
            }
            this.f2597O000000o.put(Integer.valueOf(i), obj);
            return;
        }
        throw new NullPointerException("cannot set a null object");
    }

    public void O00000Oo(int i, Object obj) {
        O000000o(i, obj);
    }

    public final int O00000Oo(int i) throws MetadataException {
        Integer O00000o02 = O00000o0(i);
        if (O00000o02 != null) {
            return O00000o02.intValue();
        }
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            throw new MetadataException("Tag '" + O0000o(i) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '" + i + "' cannot be converted to int.  It is of type '" + O0000o0o.getClass() + "'.");
    }

    public final Integer O00000o0(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof Number) {
            return Integer.valueOf(((Number) O0000o0o).intValue());
        }
        if ((O0000o0o instanceof String) || (O0000o0o instanceof xv)) {
            try {
                return Integer.valueOf(Integer.parseInt(O0000o0o.toString()));
            } catch (NumberFormatException unused) {
                long j = 0;
                for (byte b : O0000o0o.toString().getBytes()) {
                    j = (j << 8) + ((long) (b & 255));
                }
                return Integer.valueOf((int) j);
            }
        } else {
            if (O0000o0o instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) O0000o0o;
                if (rationalArr.length == 1) {
                    return Integer.valueOf(rationalArr[0].intValue());
                }
            } else if (O0000o0o instanceof byte[]) {
                byte[] bArr = (byte[]) O0000o0o;
                if (bArr.length == 1) {
                    return Integer.valueOf(bArr[0]);
                }
            } else if (O0000o0o instanceof int[]) {
                int[] iArr = (int[]) O0000o0o;
                if (iArr.length == 1) {
                    return Integer.valueOf(iArr[0]);
                }
            } else if (O0000o0o instanceof short[]) {
                short[] sArr = (short[]) O0000o0o;
                if (sArr.length == 1) {
                    return Integer.valueOf(sArr[0]);
                }
            }
            return null;
        }
    }

    public final String[] O00000o(int i) {
        Object O0000o0o = O0000o0o(i);
        String[] strArr = null;
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof String[]) {
            return (String[]) O0000o0o;
        }
        int i2 = 0;
        if (O0000o0o instanceof String) {
            return new String[]{(String) O0000o0o};
        } else if (O0000o0o instanceof xv) {
            return new String[]{O0000o0o.toString()};
        } else if (O0000o0o instanceof xv[]) {
            xv[] xvVarArr = (xv[]) O0000o0o;
            String[] strArr2 = new String[xvVarArr.length];
            while (i2 < strArr2.length) {
                strArr2[i2] = xvVarArr[i2].toString();
                i2++;
            }
            return strArr2;
        } else if (O0000o0o instanceof int[]) {
            int[] iArr = (int[]) O0000o0o;
            String[] strArr3 = new String[iArr.length];
            while (i2 < strArr3.length) {
                strArr3[i2] = Integer.toString(iArr[i2]);
                i2++;
            }
            return strArr3;
        } else if (O0000o0o instanceof byte[]) {
            byte[] bArr = (byte[]) O0000o0o;
            String[] strArr4 = new String[bArr.length];
            while (i2 < strArr4.length) {
                strArr4[i2] = Byte.toString(bArr[i2]);
                i2++;
            }
            return strArr4;
        } else {
            if (O0000o0o instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) O0000o0o;
                strArr = new String[rationalArr.length];
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    strArr[i3] = rationalArr[i3].O000000o(false);
                }
            }
            return strArr;
        }
    }

    public final xv[] O00000oO(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof xv[]) {
            return (xv[]) O0000o0o;
        }
        if (!(O0000o0o instanceof xv)) {
            return null;
        }
        return new xv[]{(xv) O0000o0o};
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: int[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final int[] O00000oo(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof int[]) {
            return (int[]) O0000o0o;
        }
        int i2 = 0;
        if (O0000o0o instanceof Rational[]) {
            Rational[] rationalArr = (Rational[]) O0000o0o;
            int[] iArr = new int[rationalArr.length];
            while (i2 < iArr.length) {
                iArr[i2] = rationalArr[i2].intValue();
                i2++;
            }
            return iArr;
        } else if (O0000o0o instanceof short[]) {
            short[] sArr = (short[]) O0000o0o;
            int[] iArr2 = new int[sArr.length];
            while (i2 < sArr.length) {
                iArr2[i2] = sArr[i2];
                i2++;
            }
            return iArr2;
        } else if (O0000o0o instanceof byte[]) {
            byte[] bArr = (byte[]) O0000o0o;
            int[] iArr3 = new int[bArr.length];
            while (i2 < bArr.length) {
                iArr3[i2] = bArr[i2];
                i2++;
            }
            return iArr3;
        } else if (O0000o0o instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) O0000o0o;
            int[] iArr4 = new int[charSequence.length()];
            while (i2 < charSequence.length()) {
                iArr4[i2] = charSequence.charAt(i2);
                i2++;
            }
            return iArr4;
        } else if (!(O0000o0o instanceof Integer)) {
            return null;
        } else {
            return new int[]{((Integer) O0000o0o).intValue()};
        }
    }

    public final byte[] O0000O0o(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof xv) {
            return ((xv) O0000o0o).f2600O000000o;
        }
        int i2 = 0;
        if (O0000o0o instanceof Rational[]) {
            Rational[] rationalArr = (Rational[]) O0000o0o;
            byte[] bArr = new byte[rationalArr.length];
            while (i2 < bArr.length) {
                bArr[i2] = rationalArr[i2].byteValue();
                i2++;
            }
            return bArr;
        } else if (O0000o0o instanceof byte[]) {
            return (byte[]) O0000o0o;
        } else {
            if (O0000o0o instanceof int[]) {
                int[] iArr = (int[]) O0000o0o;
                byte[] bArr2 = new byte[iArr.length];
                while (i2 < iArr.length) {
                    bArr2[i2] = (byte) iArr[i2];
                    i2++;
                }
                return bArr2;
            } else if (O0000o0o instanceof short[]) {
                short[] sArr = (short[]) O0000o0o;
                byte[] bArr3 = new byte[sArr.length];
                while (i2 < sArr.length) {
                    bArr3[i2] = (byte) sArr[i2];
                    i2++;
                }
                return bArr3;
            } else if (O0000o0o instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) O0000o0o;
                byte[] bArr4 = new byte[charSequence.length()];
                while (i2 < charSequence.length()) {
                    bArr4[i2] = (byte) charSequence.charAt(i2);
                    i2++;
                }
                return bArr4;
            } else if (!(O0000o0o instanceof Integer)) {
                return null;
            } else {
                return new byte[]{((Integer) O0000o0o).byteValue()};
            }
        }
    }

    public final double O00000oO() throws MetadataException {
        Double O0000OOo = O0000OOo(4);
        if (O0000OOo != null) {
            return O0000OOo.doubleValue();
        }
        Object O0000o0o = O0000o0o(4);
        if (O0000o0o == null) {
            throw new MetadataException("Tag '" + O0000o(4) + "' has not been set -- check using containsTag() first");
        }
        throw new MetadataException("Tag '4" + "' cannot be converted to a double.  It is of type '" + O0000o0o.getClass() + "'.");
    }

    public final Double O0000OOo(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if ((O0000o0o instanceof String) || (O0000o0o instanceof xv)) {
            try {
                return Double.valueOf(Double.parseDouble(O0000o0o.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (O0000o0o instanceof Number) {
            return Double.valueOf(((Number) O0000o0o).doubleValue());
        } else {
            return null;
        }
    }

    public final Float O0000Oo0(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if ((O0000o0o instanceof String) || (O0000o0o instanceof xv)) {
            try {
                return Float.valueOf(Float.parseFloat(O0000o0o.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (O0000o0o instanceof Number) {
            return Float.valueOf(((Number) O0000o0o).floatValue());
        } else {
            return null;
        }
    }

    public final Long O0000Oo(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof Number) {
            return Long.valueOf(((Number) O0000o0o).longValue());
        }
        if ((O0000o0o instanceof String) || (O0000o0o instanceof xv)) {
            try {
                return Long.valueOf(Long.parseLong(O0000o0o.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else {
            if (O0000o0o instanceof Rational[]) {
                Rational[] rationalArr = (Rational[]) O0000o0o;
                if (rationalArr.length == 1) {
                    return Long.valueOf(rationalArr[0].longValue());
                }
            } else if (O0000o0o instanceof byte[]) {
                byte[] bArr = (byte[]) O0000o0o;
                if (bArr.length == 1) {
                    return Long.valueOf((long) bArr[0]);
                }
            } else if (O0000o0o instanceof int[]) {
                int[] iArr = (int[]) O0000o0o;
                if (iArr.length == 1) {
                    return Long.valueOf((long) iArr[0]);
                }
            } else if (O0000o0o instanceof short[]) {
                short[] sArr = (short[]) O0000o0o;
                if (sArr.length == 1) {
                    return Long.valueOf((long) sArr[0]);
                }
            }
            return null;
        }
    }

    public Boolean O0000OoO(int i) {
        Object O0000o0o = O0000o0o(7);
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof Boolean) {
            return (Boolean) O0000o0o;
        }
        if ((O0000o0o instanceof String) || (O0000o0o instanceof xv)) {
            try {
                return Boolean.valueOf(Boolean.getBoolean(O0000o0o.toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (!(O0000o0o instanceof Number)) {
            return null;
        } else {
            return Boolean.valueOf(((Number) O0000o0o).doubleValue() != 0.0d);
        }
    }

    public final Rational O0000Ooo(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof Rational) {
            return (Rational) O0000o0o;
        }
        if (O0000o0o instanceof Integer) {
            return new Rational((long) ((Integer) O0000o0o).intValue(), 1);
        }
        if (O0000o0o instanceof Long) {
            return new Rational(((Long) O0000o0o).longValue(), 1);
        }
        return null;
    }

    public final Rational[] O0000o00(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o != null && (O0000o0o instanceof Rational[])) {
            return (Rational[]) O0000o0o;
        }
        return null;
    }

    public final String O0000o0(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o == null) {
            return null;
        }
        if (O0000o0o instanceof Rational) {
            return ((Rational) O0000o0o).O000000o(true);
        }
        if (O0000o0o.getClass().isArray()) {
            int length = Array.getLength(O0000o0o);
            Class<?> componentType = O0000o0o.getClass().getComponentType();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (Object.class.isAssignableFrom(componentType)) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.get(O0000o0o, i2).toString());
                    i2++;
                }
            } else if (componentType.getName().equals("int")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getInt(O0000o0o, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("short")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append((int) Array.getShort(O0000o0o, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("long")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append(Array.getLong(O0000o0o, i2));
                    i2++;
                }
            } else if (componentType.getName().equals("float")) {
                DecimalFormat decimalFormat = new DecimalFormat("0.###");
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    String format = decimalFormat.format((double) Array.getFloat(O0000o0o, i2));
                    if (format.equals("-0")) {
                        format = "0";
                    }
                    sb.append(format);
                    i2++;
                }
            } else if (componentType.getName().equals("double")) {
                DecimalFormat decimalFormat2 = new DecimalFormat("0.###");
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    String format2 = decimalFormat2.format(Array.getDouble(O0000o0o, i2));
                    if (format2.equals("-0")) {
                        format2 = "0";
                    }
                    sb.append(format2);
                    i2++;
                }
            } else if (componentType.getName().equals("byte")) {
                while (i2 < length) {
                    if (i2 != 0) {
                        sb.append(' ');
                    }
                    sb.append((int) (Array.getByte(O0000o0o, i2) & 255));
                    i2++;
                }
            } else {
                O000000o("Unexpected array component type: " + componentType.getName());
            }
            return sb.toString();
        } else if (O0000o0o instanceof Double) {
            return new DecimalFormat("0.###").format(((Double) O0000o0o).doubleValue());
        } else {
            if (O0000o0o instanceof Float) {
                return new DecimalFormat("0.###").format((double) ((Float) O0000o0o).floatValue());
            }
            return O0000o0o.toString();
        }
    }

    public final xv O0000o0O(int i) {
        Object O0000o0o = O0000o0o(i);
        if (O0000o0o instanceof xv) {
            return (xv) O0000o0o;
        }
        return null;
    }

    public final Object O0000o0o(int i) {
        return this.f2597O000000o.get(Integer.valueOf(i));
    }

    public String O0000o(int i) {
        HashMap<Integer, String> O00000Oo2 = O00000Oo();
        if (O00000Oo2.containsKey(Integer.valueOf(i))) {
            return O00000Oo2.get(Integer.valueOf(i));
        }
        String hexString = Integer.toHexString(i);
        while (hexString.length() < 4) {
            hexString = "0".concat(String.valueOf(hexString));
        }
        return "Unknown tag (0x" + hexString + ")";
    }

    public boolean O0000oO0(int i) {
        return O00000Oo().containsKey(Integer.valueOf(i));
    }

    public final String O0000oO(int i) {
        if (O00000oo || this.O00000o != null) {
            return this.O00000o.O000000o(i);
        }
        throw new AssertionError();
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = O000000o();
        objArr[1] = Integer.valueOf(this.f2597O000000o.size());
        objArr[2] = this.f2597O000000o.size() == 1 ? "tag" : "tags";
        return String.format("%s Directory (%d %s)", objArr);
    }
}
