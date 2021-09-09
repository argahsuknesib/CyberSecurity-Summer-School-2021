package gK;

import _m_j.irb;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class f implements Serializable, Comparable<f> {

    /* renamed from: O000000o  reason: collision with root package name */
    static final char[] f12254O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final f O00000Oo = O000000o(new byte[0]);
    transient String O00000o;
    transient int O00000o0;
    public final byte[] c;

    public f(byte[] bArr) {
        this.c = bArr;
    }

    public static f O000000o(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(irb.f1577O000000o));
            fVar.O00000o = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static f O000000o(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private f O00000Oo(String str) {
        try {
            return O000000o(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public final String O000000o() {
        String str = this.O00000o;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, irb.f1577O000000o);
        this.O00000o = str2;
        return str2;
    }

    public final String O00000Oo() {
        byte[] bArr = this.c;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f12254O000000o;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public final byte[] O00000o() {
        return (byte[]) this.c.clone();
    }

    public final f O00000o0() {
        int i = 0;
        while (true) {
            byte[] bArr = this.c;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new f(bArr2);
            }
        }
    }

    public int hashCode() {
        int i = this.O00000o0;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.c);
        this.O00000o0 = hashCode;
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            byte[] bArr = ((f) obj).c;
            int length = bArr.length;
            byte[] bArr2 = this.c;
            if (length == bArr2.length) {
                int length2 = bArr2.length;
                if (bArr.length - length2 >= 0 && bArr2.length - length2 >= 0 && irb.O000000o(bArr, 0, bArr2, 0, length2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        byte[] bArr = this.c;
        if (bArr.length == 0) {
            return "ByteString[size=0]";
        }
        if (bArr.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", Integer.valueOf(bArr.length), O00000Oo());
        }
        return String.format("ByteString[size=%s md5=%s]", Integer.valueOf(bArr.length), O00000Oo("MD5").O00000Oo());
    }

    public /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        int length = this.c.length;
        int length2 = fVar.c.length;
        int min = Math.min(length, length2);
        for (int i = 0; i < min; i++) {
            byte b = this.c[i] & 255;
            byte b2 = fVar.c[i] & 255;
            if (b != b2) {
                return b < b2 ? -1 : 1;
            }
        }
        if (length == length2) {
            return 0;
        }
        return length < length2 ? -1 : 1;
    }
}
