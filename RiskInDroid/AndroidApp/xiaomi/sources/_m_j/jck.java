package _m_j;

import _m_j.jbt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipShort;

public final class jck extends ZipEntry {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f1761O000000o = new byte[0];
    private static final jcn[] O0000Ooo = new jcn[0];
    private int O00000Oo;
    private int O00000o;
    private long O00000o0;
    private int O00000oO;
    private long O00000oo;
    private jcn[] O0000O0o;
    private jcb O0000OOo;
    private byte[] O0000Oo;
    private String O0000Oo0;
    private jbu O0000OoO;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    private jck(String str) {
        super(str);
        this.O00000Oo = -1;
        this.O00000o0 = -1;
        this.O00000o = 0;
        this.O00000oO = 0;
        this.O00000oo = 0;
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        this.O0000Oo = null;
        this.O0000OoO = new jbu();
        if (this.O00000oO == 0 && !str.contains("/")) {
            str = str.replace('\\', '/');
        }
        this.O0000Oo0 = str;
    }

    protected jck() {
        this("");
    }

    public final Object clone() {
        jck jck = (jck) super.clone();
        jck.O00000o = this.O00000o;
        jck.O00000oo = this.O00000oo;
        jck.O000000o(O000000o());
        return jck;
    }

    public final int getMethod() {
        return this.O00000Oo;
    }

    public final void setMethod(int i) {
        if (i >= 0) {
            this.O00000Oo = i;
            return;
        }
        throw new IllegalArgumentException("ZIP compression method can not be negative: ".concat(String.valueOf(i)));
    }

    private void O000000o(jcn[] jcnArr) {
        ArrayList arrayList = new ArrayList();
        for (jcn jcn : jcnArr) {
            if (jcn instanceof jcb) {
                this.O0000OOo = (jcb) jcn;
            } else {
                arrayList.add(jcn);
            }
        }
        this.O0000O0o = (jcn[]) arrayList.toArray(new jcn[arrayList.size()]);
        O00000o();
    }

    private jcn[] O000000o() {
        jcn[] jcnArr = this.O0000O0o;
        if (jcnArr == null) {
            return O00000o0();
        }
        return this.O0000OOo != null ? O00000Oo() : jcnArr;
    }

    private static jcn[] O000000o(jcn[] jcnArr, int i) {
        jcn[] jcnArr2 = new jcn[i];
        System.arraycopy(jcnArr, 0, jcnArr2, 0, Math.min(jcnArr.length, i));
        return jcnArr2;
    }

    private jcn[] O00000Oo() {
        jcn[] jcnArr = this.O0000O0o;
        jcn[] O000000o2 = O000000o(jcnArr, jcnArr.length + 1);
        O000000o2[this.O0000O0o.length] = this.O0000OOo;
        return O000000o2;
    }

    private jcn[] O00000o0() {
        jcb jcb = this.O0000OOo;
        if (jcb == null) {
            return O0000Ooo;
        }
        return new jcn[]{jcb};
    }

    private jcn O000000o(ZipShort zipShort) {
        jcn[] jcnArr = this.O0000O0o;
        if (jcnArr == null) {
            return null;
        }
        for (jcn jcn : jcnArr) {
            if (zipShort.equals(jcn.O00000oO())) {
                return jcn;
            }
        }
        return null;
    }

    public final void setExtra(byte[] bArr) throws RuntimeException {
        jcn jcn;
        try {
            jcn[] O000000o2 = jbt.O000000o(bArr, jbt.O000000o.O00000o0);
            if (this.O0000O0o == null) {
                O000000o(O000000o2);
                return;
            }
            for (jcn jcn2 : O000000o2) {
                if (jcn2 instanceof jcb) {
                    jcn = this.O0000OOo;
                } else {
                    jcn = O000000o(jcn2.O00000oO());
                }
                if (jcn == null) {
                    if (jcn2 instanceof jcb) {
                        this.O0000OOo = (jcb) jcn2;
                    } else if (this.O0000O0o == null) {
                        this.O0000O0o = new jcn[]{jcn2};
                    } else {
                        if (O000000o(jcn2.O00000oO()) != null) {
                            ZipShort O00000oO2 = jcn2.O00000oO();
                            if (this.O0000O0o != null) {
                                ArrayList arrayList = new ArrayList();
                                for (jcn jcn3 : this.O0000O0o) {
                                    if (!O00000oO2.equals(jcn3.O00000oO())) {
                                        arrayList.add(jcn3);
                                    }
                                }
                                if (this.O0000O0o.length != arrayList.size()) {
                                    this.O0000O0o = (jcn[]) arrayList.toArray(new jcn[arrayList.size()]);
                                    O00000o();
                                } else {
                                    throw new NoSuchElementException();
                                }
                            } else {
                                throw new NoSuchElementException();
                            }
                        }
                        jcn[] O000000o3 = O000000o(this.O0000O0o, this.O0000O0o.length + 1);
                        O000000o3[O000000o3.length - 1] = jcn2;
                        this.O0000O0o = O000000o3;
                    }
                    O00000o();
                } else {
                    byte[] O00000o02 = jcn2.O00000o0();
                    jcn.O000000o(O00000o02, 0, O00000o02.length);
                }
            }
            O00000o();
        } catch (ZipException e) {
            throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
        }
    }

    private void O00000o() {
        super.setExtra(jbt.O000000o(O000000o()));
    }

    private byte[] O00000oO() {
        byte[] extra = getExtra();
        if (extra != null) {
            return extra;
        }
        return f1761O000000o;
    }

    public final String getName() {
        String str = this.O0000Oo0;
        return str == null ? super.getName() : str;
    }

    public final boolean isDirectory() {
        return getName().endsWith("/");
    }

    public final long getSize() {
        return this.O00000o0;
    }

    public final void setSize(long j) {
        if (j >= 0) {
            this.O00000o0 = j;
            return;
        }
        throw new IllegalArgumentException("invalid entry size");
    }

    public final int hashCode() {
        return getName().hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            jck jck = (jck) obj;
            String name = getName();
            String name2 = jck.getName();
            if (name == null) {
                if (name2 != null) {
                    return false;
                }
            } else if (!name.equals(name2)) {
                return false;
            }
            String comment = getComment();
            String comment2 = jck.getComment();
            if (comment == null) {
                comment = "";
            }
            if (comment2 == null) {
                comment2 = "";
            }
            return getTime() == jck.getTime() && comment.equals(comment2) && this.O00000o == jck.O00000o && this.O00000oO == jck.O00000oO && this.O00000oo == jck.O00000oo && getMethod() == jck.getMethod() && getSize() == jck.getSize() && getCrc() == jck.getCrc() && getCompressedSize() == jck.getCompressedSize() && Arrays.equals(jbt.O00000Oo(O000000o()), jbt.O00000Oo(jck.O000000o())) && Arrays.equals(O00000oO(), jck.O00000oO()) && this.O0000OoO.equals(jck.O0000OoO);
        }
    }
}
