package _m_j;

import com.drew.imaging.png.PngProcessingException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ws {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ws f2583O000000o;
    public static final ws O00000Oo;
    public static final ws O00000o;
    public static final ws O00000o0;
    public static final ws O00000oO;
    public static final ws O00000oo;
    public static final ws O0000O0o;
    public static final ws O0000OOo;
    public static final ws O0000Oo;
    public static final ws O0000Oo0;
    public static final ws O0000OoO;
    public static final ws O0000Ooo;
    public static final ws O0000o;
    public static final ws O0000o0;
    public static final ws O0000o00;
    public static final ws O0000o0O;
    public static final ws O0000o0o;
    public static final ws O0000oO0;
    static final /* synthetic */ boolean O0000oOO = (!ws.class.desiredAssertionStatus());
    private static final Set<String> O0000oOo = new HashSet(Arrays.asList("IDAT", "sPLT", "iTXt", "tEXt", "zTXt"));
    final boolean O0000oO;
    private final byte[] O0000oo0;

    static {
        try {
            f2583O000000o = new ws("IHDR");
            O00000Oo = new ws("PLTE");
            O00000o0 = new ws("IDAT", true);
            O00000o = new ws("IEND");
            O00000oO = new ws("cHRM");
            O00000oo = new ws("gAMA");
            O0000O0o = new ws("iCCP");
            O0000OOo = new ws("sBIT");
            O0000Oo0 = new ws("sRGB");
            O0000Oo = new ws("bKGD");
            O0000OoO = new ws("hIST");
            O0000Ooo = new ws("tRNS");
            O0000o00 = new ws("pHYs");
            O0000o0 = new ws("sPLT", true);
            O0000o0O = new ws("tIME");
            O0000o0o = new ws("iTXt", true);
            O0000o = new ws("tEXt", true);
            O0000oO0 = new ws("zTXt", true);
        } catch (PngProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private ws(String str) throws PngProcessingException {
        this(str, false);
    }

    private ws(String str, boolean z) throws PngProcessingException {
        this.O0000oO = z;
        try {
            byte[] bytes = str.getBytes("ASCII");
            O000000o(bytes);
            this.O0000oo0 = bytes;
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalArgumentException("Unable to convert string code to bytes.");
        }
    }

    public ws(byte[] bArr) throws PngProcessingException {
        O000000o(bArr);
        this.O0000oo0 = bArr;
        this.O0000oO = O0000oOo.contains(O000000o());
    }

    private static void O000000o(byte[] bArr) throws PngProcessingException {
        if (bArr.length == 4) {
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                byte b = bArr[i];
                if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122)) {
                    i++;
                } else {
                    throw new PngProcessingException("PNG chunk type identifier may only contain alphabet characters");
                }
            }
            return;
        }
        throw new PngProcessingException("PNG chunk type identifier must be four bytes in length");
    }

    public final String O000000o() {
        try {
            return new String(this.O0000oo0, "ASCII");
        } catch (UnsupportedEncodingException unused) {
            if (O0000oOO) {
                return "Invalid object instance";
            }
            throw new AssertionError();
        }
    }

    public String toString() {
        return O000000o();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.O0000oo0, ((ws) obj).O0000oo0);
    }

    public int hashCode() {
        return Arrays.hashCode(this.O0000oo0);
    }
}
