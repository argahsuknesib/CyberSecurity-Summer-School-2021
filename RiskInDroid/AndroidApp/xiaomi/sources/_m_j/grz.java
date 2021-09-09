package _m_j;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.crypto.IllegalBlockSizeException;

public final class grz {
    private static final byte[] O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    gry f18191O000000o;

    static {
        byte[] bArr = new byte[1024];
        O00000Oo = bArr;
        Arrays.fill(bArr, (byte) 0);
    }

    public grz(byte[] bArr) throws SecurityException {
        if (bArr == null || bArr.length == 0) {
            throw new SecurityException("rc4 key is null");
        } else if (bArr.length == 32) {
            this.f18191O000000o = new gry(bArr);
            O000000o(O00000Oo);
        } else {
            throw new IllegalArgumentException("rc4Key length is invalid");
        }
    }

    public grz(String str) throws SecurityException {
        this(grs.O000000o(str));
    }

    private byte[] O000000o(byte[] bArr) throws SecurityException {
        if (bArr != null) {
            try {
                this.f18191O000000o.O000000o(bArr);
                return bArr;
            } catch (IllegalBlockSizeException e) {
                throw new SecurityException(e);
            }
        } else {
            throw new IllegalBlockSizeException("no block data");
        }
    }

    public final String O000000o(boolean z, String str) {
        try {
            byte[] O000000o2 = O000000o(grs.O000000o(str));
            if (z) {
                return jbg.O000000o(new jbe(new jax().O00000o0(O000000o2))).O000000o(StandardCharsets.UTF_8);
            }
            return new String(O000000o2, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new SecurityException(e);
        }
    }

    private byte[] O00000Oo(byte[] bArr) throws SecurityException {
        if (bArr != null) {
            try {
                this.f18191O000000o.O000000o(bArr);
                return bArr;
            } catch (IllegalBlockSizeException e) {
                throw new SecurityException(e);
            }
        } else {
            throw new IllegalBlockSizeException("no block data");
        }
    }

    public final String O000000o(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        return String.valueOf(grs.O000000o(O00000Oo(bArr)));
    }
}
