package okio;

import _m_j.jaw;
import _m_j.jax;
import _m_j.jbp;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: O000000o  reason: collision with root package name */
    static final char[] f15420O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString O00000Oo = O000000o(new byte[0]);
    private static final long serialVersionUID = 1;
    transient String O00000o;
    transient int O00000o0;
    final byte[] data;

    public /* synthetic */ int compareTo(Object obj) {
        ByteString byteString = (ByteString) obj;
        int O0000OOo = O0000OOo();
        int O0000OOo2 = byteString.O0000OOo();
        int min = Math.min(O0000OOo, O0000OOo2);
        for (int i = 0; i < min; i++) {
            byte O000000o2 = O000000o(i) & 255;
            byte O000000o3 = byteString.O000000o(i) & 255;
            if (O000000o2 != O000000o3) {
                return O000000o2 < O000000o3 ? -1 : 1;
            }
        }
        if (O0000OOo == O0000OOo2) {
            return 0;
        }
        return O0000OOo < O0000OOo2 ? -1 : 1;
    }

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static ByteString O000000o(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString O000000o(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(jbp.f1740O000000o));
            byteString.O00000o = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static ByteString O000000o(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new ByteString(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public String O000000o() {
        String str = this.O00000o;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, jbp.f1740O000000o);
        this.O00000o = str2;
        return str2;
    }

    public String O00000Oo() {
        return jaw.O000000o(this.data);
    }

    public ByteString O00000o0() {
        return O00000o("MD5");
    }

    public ByteString O00000o() {
        return O00000o("SHA-1");
    }

    public ByteString O00000oO() {
        return O00000o("SHA-256");
    }

    private ByteString O00000o(String str) {
        try {
            return O000000o(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static ByteString O00000Oo(String str) {
        if (str != null) {
            byte[] O000000o2 = jaw.O000000o(str);
            if (O000000o2 != null) {
                return new ByteString(O000000o2);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public String O00000oo() {
        byte[] bArr = this.data;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f15420O000000o;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static ByteString O00000o0(String str) {
        if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((O000000o(str.charAt(i2)) << 4) + O000000o(str.charAt(i2 + 1)));
            }
            return O000000o(bArr);
        }
        throw new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(str)));
    }

    private static int O000000o(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
            }
        }
        return (c - c2) + 10;
    }

    public ByteString O0000O0o() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
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
                return new ByteString(bArr2);
            }
        }
    }

    public ByteString O000000o(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.data;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.data, i, bArr2, 0, i3);
                    return new ByteString(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public byte O000000o(int i) {
        return this.data[i];
    }

    public int O0000OOo() {
        return this.data.length;
    }

    public byte[] O0000Oo0() {
        return (byte[]) this.data.clone();
    }

    public byte[] O0000Oo() {
        return this.data;
    }

    public void O000000o(jax jax) {
        byte[] bArr = this.data;
        jax.O00000o0(bArr, 0, bArr.length);
    }

    public boolean O000000o(int i, ByteString byteString, int i2, int i3) {
        return byteString.O000000o(0, this.data, 0, i3);
    }

    public boolean O000000o(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.data;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && jbp.O000000o(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int O0000OOo = byteString.O0000OOo();
            byte[] bArr = this.data;
            return O0000OOo == bArr.length && byteString.O000000o(0, bArr, 0, bArr.length);
        }
    }

    public int hashCode() {
        int i = this.O00000o0;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.O00000o0 = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String O000000o2 = O000000o();
        int length = O000000o2.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = O000000o2.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = O000000o2.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i != -1) {
            String replace = O000000o2.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i < O000000o2.length()) {
                return "[size=" + this.data.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + "]";
        } else if (this.data.length <= 64) {
            return "[hex=" + O00000oo() + "]";
        } else {
            return "[size=" + this.data.length + " hex=" + O000000o(0, 64).O00000oo() + "…]";
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        int readInt = objectInputStream.readInt();
        if (objectInputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (readInt >= 0) {
            byte[] bArr = new byte[readInt];
            int i = 0;
            while (i < readInt) {
                int read = objectInputStream.read(bArr, i, readInt - i);
                if (read != -1) {
                    i += read;
                } else {
                    throw new EOFException();
                }
            }
            ByteString byteString = new ByteString(bArr);
            try {
                Field declaredField = ByteString.class.getDeclaredField("data");
                declaredField.setAccessible(true);
                declaredField.set(this, byteString.data);
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(readInt)));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
